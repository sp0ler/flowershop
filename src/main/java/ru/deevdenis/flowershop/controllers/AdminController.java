package ru.deevdenis.flowershop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.deevdenis.flowershop.DAO.FlowerImagesDAO;
import ru.deevdenis.flowershop.models.Category;
import ru.deevdenis.flowershop.models.Flower;
import ru.deevdenis.flowershop.models.FlowerImages;
import ru.deevdenis.flowershop.servises.CategoryService;
import ru.deevdenis.flowershop.servises.FlowerImagesService;
import ru.deevdenis.flowershop.servises.FlowerService;
import ru.deevdenis.flowershop.servises.UserService;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    private FlowerService flowerService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FlowerImagesService flowerImagesService;

    @Value("${upload.path}")
    private String uploadPath;

    @RequestMapping(value = "/admin")
    public String admin(Model model) {
        List<Flower> allFlowers = flowerService.getAllFlowers();
        model.addAttribute("adminAllFlower", allFlowers);

        List<Category> allCategory = categoryService.getAllCategory();
        model.addAttribute("adminAllCategory", allCategory);

        return "admin";
    }

    @RequestMapping(value = "/admin/addNewFlower")
    public String addNewFlower(Model model) {
        Flower flower = new Flower();
        model.addAttribute("newFlower", flower);
        model.addAttribute("id", flower.getId());
        model.addAttribute("title", "");
        model.addAttribute("description", "");
        model.addAttribute("price", 0.000f);

        List<Category> category = categoryService.getAllCategory();
        Map<String, String> categoryMap = new HashMap<>();
        for (Category category1 : category) {
            categoryMap.put(category1.getCategoryName(), category1.getCategoryName());
        }
        model.addAttribute("allCategory", categoryMap);


        Map<Integer, Boolean> filesMap = new HashMap<>();
        for (int i = 0; i < 10; i ++)
            filesMap.put(i, false);
        model.addAttribute("filesMap", filesMap);

        List<Integer> files = new ArrayList<>();
        for (int i = 0; i < 10; i ++)
            files.add(i);
        model.addAttribute("files", files);

        return "new-flower";
    }

    @RequestMapping(value = "/admin/saveNewFlower", method = RequestMethod.POST)
    public String saveNewFlower(
            @RequestParam("files") List<MultipartFile> multipartFiles,
            @RequestParam("radioName") Integer preview,
            Flower flower
    ) throws IOException {
        Category category = categoryService.getCategoryByCategoryNameEng(flower.getCategoryName());
        if (category != null) flower.setCategory(category);

        //List<FlowerImages> imagesList = flower.getFlowerImagesList();
        for (int i = 0; i < multipartFiles.size() - 1; i++) {
            MultipartFile multipartFile = multipartFiles.get(i);
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();

            if (multipartFile != null && multipartFile.getOriginalFilename().length() != 0) {
                String uuidFile = UUID.randomUUID().toString();
                String fileResultName = uuidFile + "_" + multipartFile.getOriginalFilename();

                multipartFile.transferTo(new File( uploadPath + "/" + fileResultName));

                FlowerImages image = new FlowerImages();
                image.setNameImage(fileResultName);
                image.setFlower(flower);
                if (i == preview) image.setPreview(true);
                flowerImagesService.save(image);
            }
        }
        //flower.setFlowerImagesList(imagesList);
        flowerService.saveFlower(flower);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/updateFlower/{id}")
    public String updateFlower(@PathVariable int id, Model model) {
        Flower flower = flowerService.getFlower(id);
        model.addAttribute("id", flower.getId());
        model.addAttribute("title", flower.getTitle());
        model.addAttribute("description", flower.getDescription());
        model.addAttribute("price", flower.getPrice());

        List<Category> category = categoryService.getAllCategory();
        Map<String, String> categoryMap = new HashMap<>();
        for (Category category1 : category) {
            categoryMap.put(category1.getCategoryName(), category1.getCategoryName());
            //category1.addFlowerToCategory(flower);
        }
        model.addAttribute("allCategory", categoryMap);

        return "new-flower";
    }

    @RequestMapping(value = "/admin/deleteFlower/{id}")
    public String deleteFlower(@PathVariable int id) {
//        flowerImagesService.delete(id);
//        flowerService.delete(id);

        flowerService.deleteById(id);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/addNewCategory", method = RequestMethod.GET)
    public String addNewCategory(Model model) {
        Category category = new Category();
        model.addAttribute("newCategory", category);
        model.addAttribute("id", category.getId());
        model.addAttribute("categoryName", "");
        model.addAttribute("categoryNameEng", "");

        //File file = new File(System.getProperty("user.dir") + "/webapp/resources/images/");
        //model.addAttribute("files", file.listFiles());

        return "new-category";
    }

    @RequestMapping(value = "/admin/saveNewCategory", method = RequestMethod.POST)
    public String saveNewCategory(@RequestParam("file") MultipartFile multipartFile, Category category) throws IOException {
        if (multipartFile != null) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) uploadDir.mkdir();

            String uuidFile = UUID.randomUUID().toString();
            String fileResultName = uuidFile + "_" + multipartFile.getOriginalFilename();

            multipartFile.transferTo(new File( uploadPath + "/" + fileResultName));

            category.setNameImage(fileResultName);
        }
        categoryService.saveCategory(category);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/updateCategory/{id}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    public String updateCategory(@PathVariable int id, Model model) {
        Category category = categoryService.getCategory(id);
        model.addAttribute("newCategory", category);
        model.addAttribute("id", category.getId());
        model.addAttribute("categoryName", category.getCategoryName());
        model.addAttribute("categoryNameEng", category.getCategoryNameEng());
        model.addAttribute("file", category.getNameImage());
        return "new-category";
    }

    @RequestMapping(value = "/admin/deleteCategory/{id}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int id) {
        Category category = categoryService.getCategory(id);
        File file = new File(uploadPath + "/" + category.getNameImage());

        categoryService.deleteCategory(id);
        file.delete();

        return "redirect:/admin";
    }
}

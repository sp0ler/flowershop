package ru.deevdenis.flowershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.deevdenis.flowershop.models.Cart;
import ru.deevdenis.flowershop.models.Category;
import ru.deevdenis.flowershop.models.Flower;
import ru.deevdenis.flowershop.servises.CartService;
import ru.deevdenis.flowershop.servises.CategoryService;
import ru.deevdenis.flowershop.servises.FlowerService;
import ru.deevdenis.flowershop.servises.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    private FlowerService flowerService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CartService cartService;

    @Value("${upload.path}")
    private String uploadPath;

    private String cookie;
    private String username;
    private int numberCart = -1;
    private int numberWishlist = -1;;


    private String getCookies(HttpServletRequest req) {
        if (cookie == null)
            cookie =  Arrays.stream(req.getCookies())
                        .findFirst()
                        .map(Cookie::getValue)
                        .orElse(null);

        return cookie;
    }

    private String getUsername() {
        if (username == null || username.equals("anonymousUser"))
            username = SecurityContextHolder.getContext().getAuthentication().getName();
        return username;
    }

    private Integer getCountItemsInCart(HttpServletRequest req) {
        String username = getUsername();

        if (!username.equals("anonymousUser")) {
            List<Cart> list = cartService.findAllByCookie(getCookies(req));
            List<Cart> list1 = cartService.findAllByEmail(username);

            for (Cart cart : list1)
                if (!list.contains(cart)) list.add(cart);

            cartService.saveAll(list.stream()
                    .peek(cart -> cart.setEmail(username))
                    .collect(Collectors.toList())
            );

            numberCart = list.size();
        } else {
            numberCart = cartService.findAllByCookie(getCookies(req)).size();
        }

        return numberCart;
    }

    private Integer getCountItemsInWishlist(HttpServletRequest req) {
        return 0;
    }


    @GetMapping(value = "/")
    public String index(Model model, HttpServletRequest req) {
        model.addAttribute("numberCart", getCountItemsInCart(req));
        model.addAttribute("numberWishlist", getCountItemsInWishlist(req));
        return "index";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String category(Model model, HttpServletRequest req) {
        List<Category> category = categoryService.getAllCategory();
        model.addAttribute("allCategory", category);

        model.addAttribute("numberCart", getCountItemsInCart(req));
        model.addAttribute("numberWishlist", getCountItemsInWishlist(req));

        return "category";
    }

    @RequestMapping(value = "/category/{categoryNameEng}", method = RequestMethod.GET)
    public String personaCategory(@PathVariable String categoryNameEng, Model model, HttpServletRequest req) {
        Category category = categoryService.getCategoryByCategoryNameEng(categoryNameEng);
        List<Flower> flowers = category.getCategoryNameList();
        model.addAttribute("categoryNameEng", categoryNameEng);
        model.addAttribute("allFlowers", flowers);

        model.addAttribute("numberCart", getCountItemsInCart(req));
        model.addAttribute("numberWishlist", getCountItemsInWishlist(req));

        return "personal-category";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product(Model model, HttpServletRequest req) {
        List<Flower> result = flowerService.getAllFlowers();
        model.addAttribute("allFlowers", result);

        model.addAttribute("numberCart", getCountItemsInCart(req));
        model.addAttribute("numberWishlist", getCountItemsInWishlist(req));

        return "product";
    }

    @RequestMapping(value = "/category/{categoryNameEng}/{id}", method = RequestMethod.GET)
    public String productItem(@PathVariable int id, Model model, HttpServletRequest req){
        Flower flower = flowerService.getFlower(id);
        String categoryNameEng = flower.getCategory().getCategoryNameEng();

        if (categoryNameEng != null) {
            model.addAttribute("flower", flower);
            model.addAttribute("images", flower.getFlowerImagesList());
        }

        model.addAttribute("numberCart", getCountItemsInCart(req));
        model.addAttribute("numberWishlist", getCountItemsInWishlist(req));

        return "product-item";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addToCart(@RequestParam("flowerId") int id, HttpServletRequest req) {
        String currentCookie = getCookies(req);
        String currentUsername = getUsername();
        Flower flower = flowerService.getFlower(id);
        Cart cart = new Cart();

        if (currentUsername.equals("anonymousUser")) {
            cart.setCookie(currentCookie);
            cart.setFlower(flower);

        } else {
            cart.setCookie(currentCookie);
            cart.setEmail(currentUsername);
            cart.setFlower(flower);
        }

        cartService.save(cart);

    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(Model model, HttpServletRequest req) {

        model.addAttribute("numberCart", getCountItemsInCart(req));
        model.addAttribute("numberWishlist", getCountItemsInWishlist(req));

        return "cart";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String productPage(Model model, HttpServletRequest req) {

        model.addAttribute("numberCart", getCountItemsInCart(req));
        model.addAttribute("numberWishlist", getCountItemsInWishlist(req));

        return "product-item";
    }
}

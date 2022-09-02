package ru.deevdenis.flowershop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.deevdenis.flowershop.DAO.UserDAO;
import ru.deevdenis.flowershop.models.User;
import ru.deevdenis.flowershop.servises.CategoryService;
import ru.deevdenis.flowershop.servises.FlowerService;
import ru.deevdenis.flowershop.servises.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private FlowerService flowerService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserDAO userDAO;

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(User user, Model model) {
        System.out.println(user.toString());

        if (!userService.saveUser(user)) {
            model.addAttribute("errorMessage", "Пользователь уже существует");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


}

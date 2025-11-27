package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/chefs")
public class ChefController {

    private final ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    @GetMapping
    public String getDishesPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("chefs", chefService.listChefs());
        model.addAttribute("error", error);
        return "chefsList"; // Thymeleaf template
    }
    @GetMapping("/chef-form")
    public String getAddChefPage(Model model) {
        Chef chef = new Chef();
        model.addAttribute("chef", chef);
        return "chef-form";
    }

    @GetMapping("/chef-form/{id}")
    public String getEditChefForm(@PathVariable Long id, Model model) {
        Chef chef = chefService.findById(id);
        if (chef == null) {
            return "redirect:/chefs?error=ChefNotFound";
        }
        model.addAttribute("chef", chef);
        return "chef-form";
    }

    @PostMapping("/add")
    public String saveChef(@RequestParam Long id,
                           @RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String bio,
                           @RequestParam List<Dish> dishes
    ) {
        chefService.create(id, firstName, lastName, bio,dishes);
        return "redirect:/chefs";
    }

    @PostMapping("/edit/{id}")
    public String editDish(@PathVariable Long id,
                           @RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String bio,
                           @RequestParam List<Dish> dishes) {
        chefService.update(id , firstName, lastName, bio,dishes);
        return "redirect:/dishes";
    }

    @GetMapping("/delete/{id}")
    public String deleteChef(@PathVariable Long id) {
        chefService.delete(id);
        return "redirect:/dishes";
    }

    @PostMapping("/add-to-chef")
    public String addDishToChef(@RequestParam Long Id,
                                @RequestParam String dishId,
                                Model model) {
        return dishId;
    }
}
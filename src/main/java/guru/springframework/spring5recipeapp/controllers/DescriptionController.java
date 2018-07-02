package guru.springframework.spring5recipeapp.controllers;

import guru.springframework.spring5recipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DescriptionController {


    private final RecipeService recipeService;

    public DescriptionController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/description"})
    public String getDescription(Model model) {
        model.addAttribute("recipesForDescription", recipeService.getAllrecipe());
        return "description";
    }
}

package guru.springframework.spring5recipeapp.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import guru.springframework.spring5recipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {


    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(Model model, @PathVariable String id) {

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "/recipe/show";
    }

}
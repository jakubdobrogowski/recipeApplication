package guru.springframework.spring5recipeapp.service;

import guru.springframework.spring5recipeapp.commands.IngredientCommand;
import guru.springframework.spring5recipeapp.converters.IngredientToIngredientCommand;
import guru.springframework.spring5recipeapp.model.Recipe;

import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientToIngredientCommand ingredientToIngredientCommand;
    private RecipeService recipeService;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeService recipeService) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeService = recipeService;
    }

    @Override
    public IngredientCommand findIngredientCommandByRecipeIdAndId(Long recipeId, Long ingredientId) {

        Recipe recipe = recipeService.findById(recipeId);

        return recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Ingredient Not Found"));


    }
}

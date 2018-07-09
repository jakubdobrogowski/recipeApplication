package guru.springframework.spring5recipeapp.service;

import guru.springframework.spring5recipeapp.converters.RecipeCommandToRecipe;
import guru.springframework.spring5recipeapp.converters.RecipeToRecipeCommand;
import guru.springframework.spring5recipeapp.model.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


public class RecipeServiceImplTest {

    RecipeServiceImpl recipeServiceImpl;
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        recipeServiceImpl = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getAllrecipe() {

        Recipe recipe = new Recipe();
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);
        when(recipeServiceImpl.getAllrecipe()).thenReturn(recipes);
        Set<Recipe> allrecipe = recipeServiceImpl.getAllrecipe();
        Assert.assertEquals(allrecipe.size(), 1);
        Mockito.verify(recipeRepository, times(1)).findAll();

    }

    @Test
    public void shouldReturnRecipeWhenIdIsGiven() {

        //given
        Long id = 2L;
        Recipe recipe = new Recipe();
        recipe.setId(2L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        //when
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        //then
        assertNotNull("Null Recipe returned", recipeServiceImpl.findById(id));
        verify(recipeRepository, times(0)).findAll();
        verify(recipeRepository, times(1)).findById(anyLong());
    }


}
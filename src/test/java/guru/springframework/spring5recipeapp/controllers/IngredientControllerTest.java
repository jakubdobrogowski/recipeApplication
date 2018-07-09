package guru.springframework.spring5recipeapp.controllers;

import guru.springframework.spring5recipeapp.commands.RecipeCommand;
import guru.springframework.spring5recipeapp.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IngredientControllerTest {


    IngredientController controller;

    MockMvc mockMvc;

    @Mock
    RecipeService recipeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new IngredientController( recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    public void testGetIngredientsById() throws Exception {

        //given
        RecipeCommand recipeCommand = new RecipeCommand();
      //  recipeCommand.setId(2L);

        //when
        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

        //then
        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/list"))
                .andExpect(model().attributeExists("recipe"));
    }
}
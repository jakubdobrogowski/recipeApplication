package guru.springframework.spring5recipeapp.service;

import guru.springframework.spring5recipeapp.commands.UnitOfMesureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMesureCommand> getListAllUom();
}

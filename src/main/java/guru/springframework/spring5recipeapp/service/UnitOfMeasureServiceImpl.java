package guru.springframework.spring5recipeapp.service;

import guru.springframework.spring5recipeapp.commands.UnitOfMesureCommand;
import guru.springframework.spring5recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.spring5recipeapp.repositories.UnitOfMesureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toSet;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    //muszę dostać liste składników

    UnitOfMesureRepository unitOfMesureRepository;
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMesureRepository unitOfMesureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMesureRepository = unitOfMesureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMesureCommand> getListAllUom() {

        return StreamSupport.stream(unitOfMesureRepository.findAll()
                .spliterator(), false)
                .map(e -> unitOfMeasureToUnitOfMeasureCommand.convert(e))
                .collect(toSet());
    }
}

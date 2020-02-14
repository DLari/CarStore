package ru.reksoft.interns.carstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.reksoft.interns.carstore.dao.DictCarcassRepository;
import ru.reksoft.interns.carstore.dto.ModelsPageDto;
import ru.reksoft.interns.carstore.dto.SelectItemDto;
import ru.reksoft.interns.carstore.mapper.ModelMapperr;
import ru.reksoft.interns.carstore.search.SearchSpecifications;
import ru.reksoft.interns.carstore.dao.ModelRepository;
import ru.reksoft.interns.carstore.dto.ModelDto;
import ru.reksoft.interns.carstore.entity.Model;

import java.util.List;
import java.util.stream.Collectors;


@Transactional
@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private DictCarcassRepository dictCarcassRepository;

    @Autowired
    private ModelMapperr modelMapper;

    @Autowired
    private ModelMapperr modelMapperr;

    public ModelDto getModel(Integer id) {
        return modelMapper.toDto(modelRepository.getById(id));
    }

    public List<ModelDto> findModelAll() {
        return modelRepository.findAll(SearchSpecifications.findAllNotRemovedModel()).stream().map(modelMapper::toDto).collect(Collectors.toList());
    }

    public ModelsPageDto findModelforFilter() {
        List<SelectItemDto> modelsList = findModelAll().stream().map(modelMapperr::toSelectItemDto).collect(Collectors.toList());
        return new ModelsPageDto(){{
            models = modelsList;
        }};
    }

    public ModelDto create(ModelDto newModel) {

       Model model= modelRepository.saveAndFlush(modelMapper.toEntity(newModel));
       ModelDto modelDto=modelMapper.toDto(model);
        return modelDto;
    }

    public ModelDto update(Integer id, ModelDto modelDTO) {

        Model model= modelRepository.getById(id);
        modelMapper.updateModel(modelDTO,model);
        return modelDTO;
    }

    public void delete(Integer id) {

        Model model= modelRepository.getById(id);
        model.setRemoved(true);
        modelRepository.saveAndFlush(model);
    }
}






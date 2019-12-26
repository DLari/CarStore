package ru.reksoft.interns.carstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.mapper.DictCarcassMapper;
import ru.reksoft.interns.carstore.dao.DictCarcassRepository;
import ru.reksoft.interns.carstore.dto.DictCarcassDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DictCarcassService {

    @Autowired
    private DictCarcassRepository dictCarcassRepository;

    @Autowired
    private DictCarcassMapper dictCarcassMapper;

    public DictCarcassDto getDictCarcass(Integer id) {
        return dictCarcassMapper.toDto(dictCarcassRepository.getById(id));
    }

    public List<DictCarcassDto> findDictCarcassAll() {
        return dictCarcassRepository.findAll().stream().map(dictCarcassMapper::toDto).collect(Collectors.toList());
    }
}

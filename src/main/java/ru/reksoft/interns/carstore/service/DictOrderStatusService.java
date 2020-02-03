package ru.reksoft.interns.carstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.mapper.DictOrderStatusMapper;
import ru.reksoft.interns.carstore.dao.DictOrderStatusRepository;
import ru.reksoft.interns.carstore.dto.DictOrderStatusDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DictOrderStatusService {

    @Autowired
    private DictOrderStatusRepository dictOrderStatusRepository;

    @Autowired
    private DictOrderStatusMapper dictOrderStatusMapper;

    public DictOrderStatusDto getDictOrderStatus(Integer id) {
        return dictOrderStatusMapper.toDto(dictOrderStatusRepository.getById(id));
    }


    public List<DictOrderStatusDto> findDictOrderStatusAll() {
        return dictOrderStatusRepository.findAll().stream().map(dictOrderStatusMapper::toDto).collect(Collectors.toList());
    }

}
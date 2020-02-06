package ru.reksoft.interns.carstore.dto;

import ru.reksoft.interns.carstore.entity.AutoInStock;

import java.util.List;

public class CarsPageDTO {
    public List<SelectItemDto> models;
    public List<SelectItemDto> engines;
    public List<SelectItemDto> colors;
    public List<SelectItemDto> carcass;
    public List<AutoInStockDto> cars;
}


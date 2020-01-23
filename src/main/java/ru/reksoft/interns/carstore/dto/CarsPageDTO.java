package ru.reksoft.interns.carstore.dto;

import ru.reksoft.interns.carstore.entity.AutoInStock;

import java.util.List;

public class CarsPageDTO {
    public List<SelectItemDto> Models;
    public List<SelectItemDto> Engines;
    public List<SelectItemDto> Colors;
    public List<SelectItemDto> Carcass;
    public List<AutoInStockDto> Autos;
}


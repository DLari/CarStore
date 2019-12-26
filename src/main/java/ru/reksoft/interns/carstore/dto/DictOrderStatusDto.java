package ru.reksoft.interns.carstore.dto;

/**
 * статус
 */
public class DictOrderStatusDto {

    /**
     * id
     */
    private Integer id;

    /**
     * название статуса
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
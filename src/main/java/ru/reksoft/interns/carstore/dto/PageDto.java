package ru.reksoft.interns.carstore.dto;

import org.springframework.data.domain.Page;
import ru.reksoft.interns.carstore.entity.AutoInStock;

import java.util.List;

/**
 * пагинация
 * @param <D>
 */
public class PageDto <D> {

    /**
     * номер страницы
     */
    private int number;

    /**
     * объем странциы
     */
    private int size;

    /**
     * список авто
     */
    private List<D> content;

    /**
     * общее количество страниц
     */
    private int totalPage;

    /**
     * бщее количество элементов
     */
    private  long totalElements;

    public PageDto(Page page, List<D> list) {
        content=list;
        size=page.getSize();
        number=page.getNumber();
        totalPage=page.getTotalPages();
        totalElements=page.getTotalElements();
}

    public List<AutoInStock> getList(Page<AutoInStock> allAutoPage) {
        return allAutoPage.getContent();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setContent(List<D> content) {
        this.content = content;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public List<D> getContent() {
        return content;
    }

    public long getTotalElements() {
        return totalElements;
    }
}

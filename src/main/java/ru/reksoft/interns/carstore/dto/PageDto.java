package ru.reksoft.interns.carstore.dto;

import org.springframework.data.domain.Page;
import ru.reksoft.interns.carstore.entity.AutoInStock;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PageDto <D> {


    public List<AutoInStock> getList(Page<AutoInStock> allAutoPage) {

        return allAutoPage.getContent();
    }

    private int number;
    private int size;
    private List<D> content;
    private int totalPage;
    private  long totalElements;
    public PageDto(Page page, List<D> list) {
        content=list;
        size=page.getSize();
        number=page.getNumber();
        totalPage=page.getTotalPages();
        totalElements=page.getTotalElements();
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

package com.example.thmd4.dto.response;


import java.util.List;

public class PageResponse<T> {
    Long total = 0L;
    List<T> items;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}

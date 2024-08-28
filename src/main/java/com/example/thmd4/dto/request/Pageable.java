package com.example.thmd4.dto.request;

import java.util.List;

public class Pageable {
    public static final Integer DEFAULT_PAGE = 0;
    public static final Integer DEFAULT_PAGE_SIZE = 10;


    private Integer page;
    private Integer pageSize;
    private Integer offset;
    private Long total;


    public Pageable(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
        this.offset = Math.max((page - 1) * pageSize, 0);

    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}

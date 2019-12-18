package com.ceic.park.model;

import lombok.Data;

@Data
public class PageInfo {

    /**当前页码*/
    private int currentPage;
    /**每页件数*/
    private int pageSize;
    /**总件数*/
    private long total;
}

package com.ceic.park.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

/**
 * RESTful API 通用返回接口
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

    /**消息描述*/
    private final String message;

    /**结果数据，可为空*/
    private final T data;

    /**分页信息*/
    private PageInfo pageInfo;

    public Result(String message) {
        this(message, null);
    }

    public Result(T data) {
        this("Succesful", data);
    }

    public Result(String message, T data) {
        this.message = message;
        this.data = data;
    }

    /**设置分页信息*/
    public void setPageInfo (PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    /**设置分页信息*/
    public void setPageInfo (int page, int size, long total) {
        if (pageInfo == null) {
            pageInfo = new PageInfo();
        }
        pageInfo.setCurrentPage(page);
        pageInfo.setPageSize(size);
        pageInfo.setTotal(total);
    }
}

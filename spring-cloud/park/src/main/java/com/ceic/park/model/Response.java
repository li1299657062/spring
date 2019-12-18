package com.ceic.park.model;

import lombok.Data;

@Data
public class Response {

    private String code;

    private String message;

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Response build(String code, String message) {
        return new Response(code, message);
    }


}

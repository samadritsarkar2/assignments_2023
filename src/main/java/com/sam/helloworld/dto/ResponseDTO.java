package com.sam.helloworld.dto;

public class ResponseDTO<T> {

    private boolean success;
    private boolean error;

    private String errMsg;

    private T data;

}

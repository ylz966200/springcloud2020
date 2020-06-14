package com.ylz.base;

import lombok.Data;

@Data
public class ResultDTO<T> {
    private int code;
    private String message;
    private T info;
}

package com.ylz.base;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Payment {
    private Long id;
    private String serial;
}

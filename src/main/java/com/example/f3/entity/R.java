package com.example.f3.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class R <T> implements Serializable {
    private Integer code;
    private T data;
    private String msg;

    public static <T> R<T> success(T obj){
        R<T> result = new R<>();
        result.code=1;
        result.data=obj;
        return result;
    }
    public static <T> R<T> success(){
        R<T> result = new R<>();
        result.code=1;
//        result.data=null;
        return result;
    }
    public static <T> R<T> error(String msg){
        R<T> result = new R<>();
        result.msg=msg;
        result.code=0;
        return result;
    }




}

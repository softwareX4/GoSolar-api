package org.csu.api.dto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class RestResultDTO<T> implements Serializable{
    private int code;
    private String msg;
    private T data;

    public RestResultDTO() {
    }

    public RestResultDTO(int code) {
        this.code = code;
    }

    public RestResultDTO(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public RestResultDTO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public final String toJSONStr(){
        String result;
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            result = "{\"code\":0,\"msg\":\"parse jsonObject error\",\"data\":[]}";
        }
        return result;
    }
}

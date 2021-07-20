package com.s.returnjson;

public class ReturnObejct {
    private Integer code=200;
    private String message="";
    private Object result;

    public ReturnObejct() {
    }

    public ReturnObejct(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ReturnObejct(Object result) {
        this.result = result;
    }

    public ReturnObejct(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "RetrunObejct{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}

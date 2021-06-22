package com.ksn.domain;

//@Data
public class WebResponse<T> {

    private T result;

    public WebResponse setResult(T result) {
        this.result = result;
        return this;
    }

    public WebResponse(){}

    public WebResponse(T result){
        this.result=result;
    }

    public T getResult() {
        return result;
    }
}

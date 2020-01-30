package com.eh.paraparbd.pojo;

import com.eh.paraparbd.model.DivisionTable;

import java.util.List;

public class DivisionCollection {

    private List<DivisionTable> data;
    private Boolean success;
    private String message;

    public List<DivisionTable> getData() {
        return data;
    }

    public void setData(List<DivisionTable> data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

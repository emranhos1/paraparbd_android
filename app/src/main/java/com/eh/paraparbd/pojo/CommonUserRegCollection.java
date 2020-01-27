package com.eh.paraparbd.pojo;

import com.eh.paraparbd.model.CommonUserRegTable;

public class CommonUserRegCollection {

    private CommonUserRegTable data;
    private Boolean success;
    private String message;

    public CommonUserRegTable getData() {
        return data;
    }

    public void setData(CommonUserRegTable data) {
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

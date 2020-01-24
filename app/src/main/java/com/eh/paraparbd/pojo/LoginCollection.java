package com.eh.paraparbd.pojo;

import com.eh.paraparbd.model.LoginTable;

public class LoginCollection {

    private LoginTable data;
    private Boolean success;
    private String message;

    public LoginTable getData() {
        return data;
    }

    public void setData(LoginTable data) {
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

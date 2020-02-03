package com.eh.paraparbd.pojo;

import com.eh.paraparbd.model.DistrictTable;

import java.util.List;

public class DistrictCollection {

    private List<DistrictTable> data;
    private Boolean success;
    private String message;

    public List<DistrictTable> getData() {
        return data;
    }

    public void setData(List<DistrictTable> data) {
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

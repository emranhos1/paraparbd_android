package com.eh.paraparbd.pojo;

import com.eh.paraparbd.model.CarBrandTable;
import com.eh.paraparbd.model.DistrictTable;

import java.util.List;

public class CarBrandCollection {

    private List<CarBrandTable> data;
    private Boolean success;
    private String message;

    public List<CarBrandTable> getData() {
        return data;
    }

    public void setData(List<CarBrandTable> data) {
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

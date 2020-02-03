package com.eh.paraparbd.pojo;

import com.eh.paraparbd.model.PoliceStationTable;

import java.util.List;

public class PoliceStationCollection {

    private List<PoliceStationTable> data;
    private Boolean success;
    private String message;

    public List<PoliceStationTable> getData() {
        return data;
    }

    public void setData(List<PoliceStationTable> data) {
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

package com.example.firebasecrud;

public class AddData {
    String dataId;
    String data;

    public AddData() {
    }

    public AddData(String dataId, String data) {
        this.dataId = dataId;
        this.data = data;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

package com.example.retrofit.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMobil {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Mobil> listDataKontak;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Mobil> getListDataKontak() {
        return listDataKontak;
    }
    public void setListDataKontak(List<Mobil> listDataKontak) {
        this.listDataKontak = listDataKontak;
    }
}

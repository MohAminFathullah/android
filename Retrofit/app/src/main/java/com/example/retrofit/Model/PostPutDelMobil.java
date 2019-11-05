package com.example.retrofit.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelMobil {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Mobil mKontak;
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
    public Mobil getKontak() {
        return mKontak;
    }
    public void setKontak(Mobil Kontak) {
        mKontak = Kontak;
    }
}

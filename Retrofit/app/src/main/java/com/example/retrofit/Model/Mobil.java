package com.example.retrofit.Model;

import com.google.gson.annotations.SerializedName;

public class Mobil {
    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("nomor")
    private String nomor;
//    @SerializedName("foto")
//    private String foto;

    public Mobil(){}

//    public Kontak(String id, String nama, String nomor, String foto) {
//        this.id = id;
//        this.nama = nama;
//        this.nomor = nomor;
//        this.foto = foto;
//    }

    public Mobil(String id, String nama, String nomor) {
        this.id = id;
        this.nama = nama;
        this.nomor = nomor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

//    public void setFoto(String foto) {
//        this.foto = foto;
//    }
//
//    public String getFoto() {
//        return foto;
//    }
}

package com.example.retrofit.Rest;

import com.example.retrofit.Model.GetMobil;
import com.example.retrofit.Model.PostPutDelMobil;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("kontak_android")
    Call<GetMobil> getKontak();
    @FormUrlEncoded
    @POST("kontak")
    Call<PostPutDelMobil> postKontak(@Field("nama") String nama, @Field("nomor") String nomor);
    @FormUrlEncoded
    @PUT("kontak")
    Call<PostPutDelMobil> putKontak(@Field("id") String id,
                                     @Field("nama") String nama,
                                     @Field("nomor") String nomor);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
    Call<PostPutDelMobil> deleteKontak(@Field("id") String id);
}

package me.tvspark.model.impl;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/* loaded from: classes4.dex */
public interface IHttpGetApi {
    @GET
    Call<ResponseBody> get(@Url String str);
}

package me.tvspark.model.impl;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* loaded from: classes4.dex */
public interface IHttpPostApi {
    @POST
    Call<ResponseBody> post(@Url String str, @Body RequestBody requestBody);
}

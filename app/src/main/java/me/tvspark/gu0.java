package me.tvspark;

import me.tvspark.rl0;
import me.tvspark.widget.dialog.DialogDesc;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class gu0 implements Callback<ResponseBody> {
    public final /* synthetic */ DialogDesc Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements rl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    public gu0(DialogDesc dialogDesc) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogDesc;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<ResponseBody> call, Throwable th) {
        th.printStackTrace();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.pBar.setVisibility(8);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            if (jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
                try {
                    new rl0(response.body().string(), jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).execute(new Void[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                    onFailure(call, e);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            onFailure(call, e2);
        }
    }
}

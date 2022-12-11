package me.tvspark;

import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.bean.IndexRankListParcel;
import me.tvspark.data.sql.WebSourceIndexRecData;
import me.tvspark.pl0;
import me.tvspark.ql0;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class hm0 extends zk0<zm0> implements xm0 {
    public String Wwwwwwwwwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwwwwwwwwww = "";
    public int Wwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwww = 0;
    public List<IndexRankListParcel> Wwwwwwwwwwwwwwwwwww = new ArrayList();
    public List<IndexRankListParcel> Wwwwwwwwwwwwwwwwww = new ArrayList();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ql0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            th.printStackTrace();
            ((zm0) hm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                hm0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, response.body().string());
            } catch (Exception e) {
                e.printStackTrace();
                onFailure(call, e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements pl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            th.printStackTrace();
            hm0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false, "");
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                hm0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false, response.body().string());
            } catch (Exception e) {
                e.printStackTrace();
                onFailure(call, e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            th.printStackTrace();
            hm0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, true, "");
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                hm0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, true, response.body().string());
            } catch (Exception e) {
                e.printStackTrace();
                onFailure(call, e);
            }
        }
    }

    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.xm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceIndexRecData webSourceIndexRecData) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexRecData.getBaseUrlRank(), webSourceIndexRecData.getUserAgentRank()).get(webSourceIndexRecData.getTvRankUrl()).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexRecData.getBaseUrlRank(), webSourceIndexRecData.getUserAgentRank()).get(webSourceIndexRecData.getMovieRankUrl()).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.xm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceIndexRecData webSourceIndexRecData) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexRecData.getBaseUrlRec(), webSourceIndexRecData.getUserAgentRec()).get(webSourceIndexRecData.getIndexUrlRec()).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.xm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str) {
        if (jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
            try {
                new ql0(str, jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z)).execute(new Void[0]);
            } catch (Exception e) {
                e.printStackTrace();
                ((zm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    @Override // me.tvspark.xm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, String str) {
        if (jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
            try {
                new pl0(str, jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), z2, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, z2)).execute(new Void[0]);
            } catch (Exception e) {
                e.printStackTrace();
                ((zm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }
}

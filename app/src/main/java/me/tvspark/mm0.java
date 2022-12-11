package me.tvspark;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.xl0;
import okhttp3.ResponseBody;
import retrofit2.Call;

/* loaded from: classes4.dex */
public class mm0 extends zk0<kn0> implements jn0 {
    public String Wwwwwwwwwwwwwwwwwwwwwww = "";

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements xl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }
    }

    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.jn0
    public Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceIndexData webSourceIndexData) {
        String webSourceBaseUrl = TextUtils.isEmpty(webSourceIndexData.getWebIndexUrl()) ? webSourceIndexData.getWebSourceBaseUrl() : webSourceIndexData.getWebIndexUrl();
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwww)) {
            webSourceBaseUrl = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = "";
        }
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexData.getWebSourceBaseUrl(), webSourceIndexData.getHttpUserAgent()).get(webSourceBaseUrl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.zk0, me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull cl0 cl0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cl0Var;
    }

    @Override // me.tvspark.jn0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, ResponseBody responseBody, String str, int i, WebSourceIndexData webSourceIndexData) {
        if (!z) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexData.getWebSourceBaseUrl(), str);
        }
        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwww)) {
            new xl0(responseBody, str, webSourceIndexData, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, i)).execute(new Void[0]);
            return false;
        }
        return true;
    }
}

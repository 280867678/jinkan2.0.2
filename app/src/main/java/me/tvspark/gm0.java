package me.tvspark;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import me.tvspark.data.sql.WebSourceIndexRecData;
import me.tvspark.sl0;
import okhttp3.ResponseBody;
import retrofit2.Call;

/* loaded from: classes4.dex */
public class gm0 extends zk0<an0> implements ym0 {

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements sl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }
    }

    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.ym0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, WebSourceIndexRecData webSourceIndexRecData) {
        new sl0(str, webSourceIndexRecData, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)).execute(new Void[0]);
    }

    @Override // me.tvspark.ym0
    public Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, WebSourceIndexRecData webSourceIndexRecData) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith("http")) {
                str = webSourceIndexRecData.getBaseUrlRec() + str;
            }
            str2 = str.replace("{page}", String.valueOf(i));
        } else {
            str2 = "http://www.baidu.com";
        }
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexRecData.getBaseUrlRec(), webSourceIndexRecData.getUserAgentRec()).get(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.zk0, me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull cl0 cl0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cl0Var;
    }
}

package me.tvspark;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.ul0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;

/* loaded from: classes4.dex */
public class km0 extends zk0<gn0> implements fn0 {
    public String Wwwwwwwwwwwwwwwwwwwwwww = "";

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ul0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }
    }

    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.fn0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceIndexData webSourceIndexData, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexData.getWebSourceBaseUrl(), str);
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return true;
        }
        new ul0(webSourceIndexData, str, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)).execute(new Void[0]);
        return false;
    }

    @Override // me.tvspark.fn0
    public Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceIndexData webSourceIndexData, String str, int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return null;
        }
        String webSearchUrl = webSourceIndexData.getWebSearchUrl();
        String str2 = "";
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwww)) {
            webSearchUrl = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = str2;
        }
        if (!TextUtils.isEmpty(webSourceIndexData.getReqCharset())) {
            try {
                str = URLEncoder.encode(str, webSourceIndexData.getReqCharset());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(webSourceIndexData.getSearchPostData())) {
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexData.getWebSourceBaseUrl(), webSourceIndexData.getHttpUserAgent()).get(webSearchUrl.replace("{search}", str).replace("{page}", String.valueOf(i)));
        }
        try {
            str2 = webSourceIndexData.getSearchPostData().replace("{search}", str).replace("{page}", String.valueOf(i));
        } catch (Exception unused) {
        }
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexData.getWebSourceBaseUrl(), webSourceIndexData.getHttpUserAgent()).post(webSearchUrl, RequestBody.create(MediaType.parse("text"), str2));
    }
}

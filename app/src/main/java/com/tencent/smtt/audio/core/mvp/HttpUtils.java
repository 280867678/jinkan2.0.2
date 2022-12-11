package com.tencent.smtt.audio.core.mvp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/HttpUtils.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/HttpUtils.class */
public class HttpUtils {
    public static int getHttpResponseCode(URL url) {
        HttpURLConnection httpurlconnection = null;
        int responsecode = -1;
        try {
            URLConnection urlconnection = url.openConnection();
            urlconnection.connect();
            if (!(urlconnection instanceof HttpURLConnection)) {
                return -1;
            }
            httpurlconnection = (HttpURLConnection) urlconnection;
            responsecode = httpurlconnection.getResponseCode();
            switch (responsecode) {
                case 200:
                case 301:
                case 302:
                    break;
                default:
                    httpurlconnection.disconnect();
                    break;
            }
            return responsecode;
        } catch (Exception e) {
            if (httpurlconnection != null) {
                httpurlconnection.disconnect();
            }
            return responsecode;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo info;
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivity != null && (info = connectivity.getActiveNetworkInfo()) != null && info.isConnected() && info.getState() == NetworkInfo.State.CONNECTED) {
            return true;
        }
        return false;
    }
}

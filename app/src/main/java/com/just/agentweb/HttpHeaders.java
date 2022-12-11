package com.just.agentweb;

import android.net.Uri;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import java.util.Map;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class HttpHeaders {
    public final Map<String, Map<String, String>> mHeaders = new ArrayMap();

    public static HttpHeaders create() {
        return new HttpHeaders();
    }

    private String subBaseUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(parse.getAuthority())) {
                return "";
            }
            return parse.getScheme() + "://" + parse.getAuthority();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public void additionalHttpHeader(String str, String str2, String str3) {
        if (str == null) {
            return;
        }
        String subBaseUrl = subBaseUrl(str);
        Map<String, Map<String, String>> headers = getHeaders();
        Map<String, String> map = headers.get(subBaseUrl(subBaseUrl));
        if (map == null) {
            map = new ArrayMap<>();
        }
        map.put(str2, str3);
        headers.put(subBaseUrl, map);
    }

    public void additionalHttpHeaders(String str, Map<String, String> map) {
        if (str == null) {
            return;
        }
        String subBaseUrl = subBaseUrl(str);
        Map<String, Map<String, String>> headers = getHeaders();
        if (map == null) {
            map = new ArrayMap<>();
        }
        headers.put(subBaseUrl, map);
    }

    public Map<String, Map<String, String>> getHeaders() {
        return this.mHeaders;
    }

    public Map<String, String> getHeaders(String str) {
        String subBaseUrl = subBaseUrl(str);
        if (this.mHeaders.get(subBaseUrl) == null) {
            ArrayMap arrayMap = new ArrayMap();
            this.mHeaders.put(subBaseUrl, arrayMap);
            return arrayMap;
        }
        return this.mHeaders.get(subBaseUrl);
    }

    public boolean isEmptyHeaders(String str) {
        Map<String, String> headers = getHeaders(subBaseUrl(str));
        return headers == null || headers.isEmpty();
    }

    public void removeHttpHeader(String str, String str2) {
        if (str == null) {
            return;
        }
        Map<String, String> map = getHeaders().get(subBaseUrl(str));
        if (map == null) {
            return;
        }
        map.remove(str2);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("HttpHeaders{mHeaders=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mHeaders);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

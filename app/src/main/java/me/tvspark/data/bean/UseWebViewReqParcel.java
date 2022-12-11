package me.tvspark.data.bean;

import android.app.Activity;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class UseWebViewReqParcel implements Serializable {
    public Activity context;
    public String searchPostData;
    public String url;
    public String userAgent;

    public UseWebViewReqParcel(Activity activity, String str, String str2) {
        this.searchPostData = "";
        this.context = activity;
        this.url = str;
        this.userAgent = str2;
    }

    public UseWebViewReqParcel(Activity activity, String str, String str2, String str3) {
        this.searchPostData = "";
        this.context = activity;
        this.url = str;
        this.userAgent = str2;
        this.searchPostData = str3;
    }

    public Activity getContext() {
        return this.context;
    }

    public String getSearchPostData() {
        return this.searchPostData;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setContext(Activity activity) {
        this.context = activity;
    }

    public void setSearchPostData(String str) {
        this.searchPostData = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }
}

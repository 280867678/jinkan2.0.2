package me.tvspark.data.bean;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class AppRecParcel implements Serializable {
    public String title = "";
    public String icon = "";
    public String desc = "";
    public String webUrl = "";

    public String getDesc() {
        return this.desc;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }
}

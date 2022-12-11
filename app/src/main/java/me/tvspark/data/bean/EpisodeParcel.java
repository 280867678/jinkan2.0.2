package me.tvspark.data.bean;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class EpisodeParcel implements Serializable {
    public String count = "00";
    public String link = "";

    public String getCount() {
        return this.count;
    }

    public String getLink() {
        return this.link;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public void setLink(String str) {
        this.link = str;
    }
}

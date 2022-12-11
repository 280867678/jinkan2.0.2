package me.tvspark.data.bean;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class LocalInputParcel implements Serializable {
    public int version = 0;
    public String index = "";
    public String season = "";
    public String category = "";
    public String live = "";
    public String download = "";

    public String getCategory() {
        return this.category;
    }

    public String getDownload() {
        return this.download;
    }

    public String getIndex() {
        return this.index;
    }

    public String getLive() {
        return this.live;
    }

    public String getSeason() {
        return this.season;
    }

    public int getVersion() {
        return this.version;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setDownload(String str) {
        this.download = str;
    }

    public void setIndex(String str) {
        this.index = str;
    }

    public void setLive(String str) {
        this.live = str;
    }

    public void setSeason(String str) {
        this.season = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}

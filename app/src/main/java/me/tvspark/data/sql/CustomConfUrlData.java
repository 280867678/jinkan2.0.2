package me.tvspark.data.sql;

import java.io.Serializable;
import me.tvspark.sk0;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class CustomConfUrlData extends LitePalSupport implements Serializable, sk0 {
    public String versionUrl = "";
    public String indexRecUrl = "";
    public String indexUrl = "";
    public String seasonUrl = "";
    public String categoryUrl = "";
    public String liveUrl = "";
    public String downloadUrl = "";

    public String getCategoryUrl() {
        return this.categoryUrl;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getIndexRecUrl() {
        return this.indexRecUrl;
    }

    public String getIndexUrl() {
        return this.indexUrl;
    }

    public String getLiveUrl() {
        return this.liveUrl;
    }

    public String getSeasonUrl() {
        return this.seasonUrl;
    }

    public String getVersionUrl() {
        return this.versionUrl;
    }

    public void setCategoryUrl(String str) {
        this.categoryUrl = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setIndexRecUrl(String str) {
        this.indexRecUrl = str;
    }

    public void setIndexUrl(String str) {
        this.indexUrl = str;
    }

    public void setLiveUrl(String str) {
        this.liveUrl = str;
    }

    public void setSeasonUrl(String str) {
        this.seasonUrl = str;
    }

    public void setVersionUrl(String str) {
        this.versionUrl = str;
    }
}

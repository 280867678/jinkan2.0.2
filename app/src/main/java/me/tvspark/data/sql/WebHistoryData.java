package me.tvspark.data.sql;

import java.io.Serializable;
import me.tvspark.sk0;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class WebHistoryData extends LitePalSupport implements Serializable, sk0 {
    public boolean isVip;
    public String siteName;
    public String siteUrl;
    public long timestamp;

    public WebHistoryData(String str, String str2, boolean z, long j) {
        this.siteName = "";
        this.siteUrl = "";
        this.siteName = str;
        this.siteUrl = str2;
        this.timestamp = j;
        this.isVip = z;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public String getSiteUrl() {
        return this.siteUrl;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isVip() {
        return this.isVip;
    }

    public void setSiteName(String str) {
        this.siteName = str;
    }

    public void setSiteUrl(String str) {
        this.siteUrl = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setVip(boolean z) {
        this.isVip = z;
    }
}

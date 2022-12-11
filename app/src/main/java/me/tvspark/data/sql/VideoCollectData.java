package me.tvspark.data.sql;

import com.efs.sdk.base.Constants;
import java.io.Serializable;
import me.tvspark.sk0;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class VideoCollectData extends LitePalSupport implements Serializable, sk0 {
    public String baseUrl;
    public String coverUrl;
    public boolean customWebSource;
    public String desc;
    public String imgReferer;
    public String siteName;
    public long timestamp;
    public String title;
    public String url;

    public VideoCollectData(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, boolean z) {
        this.title = "";
        this.baseUrl = "";
        this.siteName = "";
        this.coverUrl = "";
        this.desc = "";
        this.url = "";
        this.imgReferer = Constants.CP_NONE;
        this.imgReferer = str2;
        this.title = str4;
        this.siteName = str3;
        this.baseUrl = str;
        this.coverUrl = str5;
        this.desc = str6;
        this.url = str7;
        this.timestamp = j;
        this.customWebSource = z;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getImgReferer() {
        return this.imgReferer;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCustomWebSource() {
        return this.customWebSource;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCustomWebSource(boolean z) {
        this.customWebSource = z;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setImgReferer(String str) {
        this.imgReferer = str;
    }

    public void setSiteName(String str) {
        this.siteName = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}

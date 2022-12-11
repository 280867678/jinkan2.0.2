package me.tvspark.data.sql;

import com.efs.sdk.base.Constants;
import java.io.Serializable;
import me.tvspark.sk0;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class VideoHistoryData extends LitePalSupport implements Serializable, sk0 {
    public String baseUrl;
    public int channel;
    public String coverUrl;
    public boolean customWebSource;
    public String desc;
    public String detailUrl;
    public String episodeUrl;
    public String imgReferer;
    public String lastEpisode;
    public String siteName;
    public long timestamp;
    public String title;

    public VideoHistoryData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, long j, boolean z) {
        this.title = "";
        this.siteName = "";
        this.baseUrl = "";
        this.coverUrl = "";
        this.desc = "";
        this.detailUrl = "";
        this.episodeUrl = "";
        this.channel = 0;
        this.lastEpisode = "";
        this.imgReferer = Constants.CP_NONE;
        this.title = str4;
        this.imgReferer = str2;
        this.siteName = str3;
        this.baseUrl = str;
        this.coverUrl = str5;
        this.desc = str6;
        this.detailUrl = str7;
        this.episodeUrl = str8;
        this.channel = i;
        this.lastEpisode = str9;
        this.timestamp = j;
        this.customWebSource = z;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public int getChannel() {
        return this.channel;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDetailUrl() {
        return this.detailUrl;
    }

    public String getEpisodeUrl() {
        return this.episodeUrl;
    }

    public String getImgReferer() {
        return this.imgReferer;
    }

    public String getLastEpisode() {
        return this.lastEpisode;
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

    public boolean isCustomWebSource() {
        return this.customWebSource;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public void setChannel(int i) {
        this.channel = i;
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

    public void setDetailUrl(String str) {
        this.detailUrl = str;
    }

    public void setEpisodeUrl(String str) {
        this.episodeUrl = str;
    }

    public void setImgReferer(String str) {
        this.imgReferer = str;
    }

    public void setLastEpisode(String str) {
        this.lastEpisode = str;
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
}

package me.tvspark.data.sql;

import java.io.Serializable;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class VideoPlayPosData extends LitePalSupport implements Serializable {
    public String episodeNum;
    public String episodeUrl;
    public long quitTime;
    public String videoSrc;
    public String videoTitle;

    public VideoPlayPosData(String str, String str2, String str3, String str4, long j) {
        this.episodeUrl = "";
        this.videoSrc = "";
        this.videoTitle = "";
        this.episodeNum = "";
        this.quitTime = 0L;
        this.episodeUrl = str;
        this.videoSrc = str2;
        this.videoTitle = str3;
        this.episodeNum = str4;
        this.quitTime = j;
    }

    public String getEpisodeNum() {
        return this.episodeNum;
    }

    public String getEpisodeUrl() {
        return this.episodeUrl;
    }

    public long getQuitTime() {
        return this.quitTime;
    }

    public String getVideoSrc() {
        return this.videoSrc;
    }

    public String getVideoTitle() {
        return this.videoTitle;
    }

    public void setEpisodeNum(String str) {
        this.episodeNum = str;
    }

    public void setEpisodeUrl(String str) {
        this.episodeUrl = str;
    }

    public void setQuitTime(long j) {
        this.quitTime = j;
    }

    public void setVideoSrc(String str) {
        this.videoSrc = str;
    }

    public void setVideoTitle(String str) {
        this.videoTitle = str;
    }
}

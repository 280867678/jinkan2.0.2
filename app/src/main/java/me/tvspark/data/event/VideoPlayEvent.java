package me.tvspark.data.event;

import java.io.Serializable;
import me.tvspark.sk0;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class VideoPlayEvent extends LitePalSupport implements Serializable, sk0 {
    public String detailUrl;
    public String episodeNum;
    public String episodeUrl;
    public int position;

    public VideoPlayEvent(String str, String str2, String str3, int i) {
        this.episodeNum = "";
        this.episodeUrl = "";
        this.detailUrl = "";
        this.position = -1;
        this.detailUrl = str;
        this.episodeNum = str2;
        this.episodeUrl = str3;
        this.position = i;
    }

    public String getDetailUrl() {
        return this.detailUrl;
    }

    public String getEpisodeNum() {
        return this.episodeNum;
    }

    public String getEpisodeUrl() {
        return this.episodeUrl;
    }

    public int getPosition() {
        return this.position;
    }

    public void setDetailUrl(String str) {
        this.detailUrl = str;
    }

    public void setEpisodeNum(String str) {
        this.episodeNum = str;
    }

    public void setEpisodeUrl(String str) {
        this.episodeUrl = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }
}

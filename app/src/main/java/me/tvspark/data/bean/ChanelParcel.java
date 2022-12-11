package me.tvspark.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ChanelParcel implements Serializable {
    public String chanel = "";
    public List<EpisodeParcel> episodeList = new ArrayList();

    public String getChanel() {
        return this.chanel;
    }

    public List<EpisodeParcel> getEpisodeList() {
        return this.episodeList;
    }

    public void setChanel(String str) {
        this.chanel = str;
    }

    public void setEpisodeList(List<EpisodeParcel> list) {
        this.episodeList = list;
    }
}

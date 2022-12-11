package me.tvspark.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class LiveParcel implements Serializable {
    public String chanelName = "";
    public String chanelUrl = "";
    public List<LiveParcel> episodeList = new ArrayList();

    public String getChanelName() {
        return this.chanelName;
    }

    public String getChanelUrl() {
        return this.chanelUrl;
    }

    public List<LiveParcel> getEpisodeList() {
        return this.episodeList;
    }

    public void setChanelName(String str) {
        this.chanelName = str;
    }

    public void setChanelUrl(String str) {
        this.chanelUrl = str;
    }

    public void setEpisodeList(List<LiveParcel> list) {
        this.episodeList = list;
    }
}

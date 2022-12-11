package me.tvspark.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class VideoDetailParcel implements Serializable {
    public String title = "";
    public String coverUrl = "";
    public String desc = "";
    public List<String> tvsList = new ArrayList();
    public List<ChanelParcel> chanelList = new ArrayList();
    public List<GenreParcel> downloadList = new ArrayList();

    public List<ChanelParcel> getChanelList() {
        return this.chanelList;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDesc() {
        return this.desc;
    }

    public List<GenreParcel> getDownloadList() {
        return this.downloadList;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getTvsList() {
        return this.tvsList;
    }

    public void setChanelList(List<ChanelParcel> list) {
        this.chanelList = list;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDownloadList(List<GenreParcel> list) {
        this.downloadList = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTvsList(List<String> list) {
        this.tvsList = list;
    }
}

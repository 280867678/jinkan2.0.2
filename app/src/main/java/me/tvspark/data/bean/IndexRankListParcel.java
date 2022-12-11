package me.tvspark.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class IndexRankListParcel implements Serializable {
    public String titleRank = "";
    public List<VideoParcel> videoList = new ArrayList();

    public String getTitleRank() {
        return this.titleRank;
    }

    public List<VideoParcel> getVideoList() {
        return this.videoList;
    }

    public void setTitleRank(String str) {
        this.titleRank = str;
    }

    public void setVideoList(List<VideoParcel> list) {
        this.videoList = list;
    }
}

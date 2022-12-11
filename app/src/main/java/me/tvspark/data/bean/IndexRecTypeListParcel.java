package me.tvspark.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class IndexRecTypeListParcel implements Serializable {
    public List<VideoParcel> videoList = new ArrayList();

    public List<VideoParcel> getVideoList() {
        return this.videoList;
    }

    public void setVideoList(List<VideoParcel> list) {
        this.videoList = list;
    }
}

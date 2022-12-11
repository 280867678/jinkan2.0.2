package me.tvspark.data.bean;

import com.p038qq.p039e.ads.nativ.NativeExpressADView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.sk0;

/* loaded from: classes4.dex */
public class VideoIndexParcel implements Serializable, sk0 {
    public transient NativeExpressADView nativeExpressADView;
    public String columnTitle = "";
    public int moreIcon = 0;
    public List<VideoParcel> videoList = new ArrayList();
    public boolean isADPos = false;

    public String getColumnTitle() {
        return this.columnTitle;
    }

    public int getMoreIcon() {
        return this.moreIcon;
    }

    public NativeExpressADView getNativeExpressADView() {
        return this.nativeExpressADView;
    }

    public List<VideoParcel> getVideoList() {
        return this.videoList;
    }

    public boolean isADPos() {
        return this.isADPos;
    }

    public void setADPos(boolean z) {
        this.isADPos = z;
    }

    public void setColumnTitle(String str) {
        this.columnTitle = str;
    }

    public void setMoreIcon(int i) {
        this.moreIcon = i;
    }

    public void setNativeExpressADView(NativeExpressADView nativeExpressADView) {
        this.nativeExpressADView = nativeExpressADView;
    }

    public void setVideoList(List<VideoParcel> list) {
        this.videoList = list;
    }
}

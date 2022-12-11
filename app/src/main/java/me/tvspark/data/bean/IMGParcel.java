package me.tvspark.data.bean;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class IMGParcel implements Serializable {
    public String thumbnailUrl = "";
    public String imageUrl = "";
    public boolean isADPos = false;

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public boolean isADPos() {
        return this.isADPos;
    }

    public void setADPos(boolean z) {
        this.isADPos = z;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }
}

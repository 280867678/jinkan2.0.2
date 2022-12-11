package me.tvspark.data.bean;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class GenreParcel implements Serializable {
    public int appVer;
    public boolean isAppLine;
    public String link;
    public String name;

    public GenreParcel() {
        this.name = "";
        this.link = "";
        this.isAppLine = false;
    }

    public GenreParcel(String str, String str2) {
        this.name = "";
        this.link = "";
        this.isAppLine = false;
        this.name = str;
        this.link = str2;
    }

    public GenreParcel(String str, String str2, int i) {
        this.name = "";
        this.link = "";
        this.isAppLine = false;
        this.name = str;
        this.link = str2;
        this.appVer = i;
    }

    public int getAppVer() {
        return this.appVer;
    }

    public String getLink() {
        return this.link;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAppLine() {
        return this.isAppLine;
    }

    public void setAppLine(boolean z) {
        this.isAppLine = z;
    }

    public void setAppVer(int i) {
        this.appVer = i;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}

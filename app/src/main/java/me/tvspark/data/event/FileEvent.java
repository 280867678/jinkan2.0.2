package me.tvspark.data.event;

/* loaded from: classes4.dex */
public class FileEvent extends BaseEvent {
    public String childUrl;
    public String dirName;

    public FileEvent(String str, String str2) {
        this.dirName = str;
        this.childUrl = str2;
    }

    public String getChildUrl() {
        return this.childUrl;
    }

    public String getDirName() {
        return this.dirName;
    }

    public void setChildUrl(String str) {
        this.childUrl = str;
    }

    public void setDirName(String str) {
        this.dirName = str;
    }
}

package me.tvspark.data.sql;

import java.io.Serializable;
import me.tvspark.sk0;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class DownPlayHistoryData extends LitePalSupport implements Serializable, sk0 {
    public String dirName;
    public long timestamp;
    public String title;

    public DownPlayHistoryData(String str, String str2, long j) {
        this.dirName = "";
        this.title = "";
        this.dirName = str;
        this.title = str2;
        this.timestamp = j;
    }

    public String getDirName() {
        return this.dirName;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDirName(String str) {
        this.dirName = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}

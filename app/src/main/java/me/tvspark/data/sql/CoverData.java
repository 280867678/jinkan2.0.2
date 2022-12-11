package me.tvspark.data.sql;

import java.io.Serializable;
import me.tvspark.sk0;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class CoverData extends LitePalSupport implements Serializable, sk0 {
    public String coverUrl;
    public String dirName;

    public CoverData(String str, String str2) {
        this.dirName = "";
        this.coverUrl = "";
        this.dirName = str;
        this.coverUrl = str2;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDirName() {
        return this.dirName;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setDirName(String str) {
        this.dirName = str;
    }
}

package me.tvspark.data.sql;

import java.io.Serializable;
import me.tvspark.sk0;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class SPData extends LitePalSupport implements Serializable, sk0 {
    public String searchHistory = "";
    public String blockWordJson = "";

    public String getBlockWordJson() {
        return this.blockWordJson;
    }

    public String getSearchHistory() {
        return this.searchHistory;
    }

    public void setBlockWordJson(String str) {
        this.blockWordJson = str;
    }

    public void setSearchHistory(String str) {
        this.searchHistory = str;
    }
}

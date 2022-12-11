package me.tvspark.data.sql;

import java.io.Serializable;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class VipApiData extends LitePalSupport implements Serializable {
    public String api = "";
    public String name = "";

    public String getApi() {
        return this.api;
    }

    public String getName() {
        return this.name;
    }

    public void setApi(String str) {
        this.api = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}

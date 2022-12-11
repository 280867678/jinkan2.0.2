package me.tvspark.data.sql;

import java.io.Serializable;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class InputData extends LitePalSupport implements Serializable, Cloneable {
    public WebSourceIndexData index;
    public WebSourceSeasonData season;

    public WebSourceIndexData getIndex() {
        return this.index;
    }

    public WebSourceSeasonData getSeason() {
        return this.season;
    }

    public void setIndex(WebSourceIndexData webSourceIndexData) {
        this.index = webSourceIndexData;
    }

    public void setSeason(WebSourceSeasonData webSourceSeasonData) {
        this.season = webSourceSeasonData;
    }
}

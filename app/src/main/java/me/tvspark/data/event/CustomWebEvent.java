package me.tvspark.data.event;

import java.util.List;
import me.tvspark.data.sql.WebSourceTitaData;

/* loaded from: classes4.dex */
public class CustomWebEvent extends BaseEvent {
    public WebSourceTitaData webSourceTitaData = null;
    public List<WebSourceTitaData> webSourceTitaDataList = null;
    public boolean isToAdd = true;
    public int positionInList = -1;

    public int getPositionInList() {
        return this.positionInList;
    }

    public WebSourceTitaData getWebSourceTitaData() {
        return this.webSourceTitaData;
    }

    public List<WebSourceTitaData> getWebSourceTitaDataList() {
        return this.webSourceTitaDataList;
    }

    public boolean isToAdd() {
        return this.isToAdd;
    }

    public void setPositionInList(int i) {
        this.positionInList = i;
    }

    public void setToAdd(boolean z) {
        this.isToAdd = z;
    }

    public void setWebSourceTitaData(WebSourceTitaData webSourceTitaData) {
        this.webSourceTitaData = webSourceTitaData;
    }

    public void setWebSourceTitaDataList(List<WebSourceTitaData> list) {
        this.webSourceTitaDataList = list;
    }
}

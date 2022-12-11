package me.tvspark.data.bean;

import java.io.Serializable;
import me.tvspark.data.sql.WebSourceIndexData;

/* loaded from: classes4.dex */
public class EngineResultParcel implements Serializable {
    public boolean showWebViewSearch;
    public WebSourceIndexData webSourceData;
    public String title = "";
    public String link = "";
    public String actor = "";
    public String number = "";
    public String cover = "";
    public boolean isParseSuccess = true;

    public String getActor() {
        return this.actor;
    }

    public String getCover() {
        return this.cover;
    }

    public String getLink() {
        return this.link;
    }

    public String getNumber() {
        return this.number;
    }

    public String getTitle() {
        return this.title;
    }

    public WebSourceIndexData getWebSourceData() {
        return this.webSourceData;
    }

    public boolean isParseSuccess() {
        return this.isParseSuccess;
    }

    public boolean isShowWebViewSearch() {
        return this.showWebViewSearch;
    }

    public void setActor(String str) {
        this.actor = str;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setParseSuccess(boolean z) {
        this.isParseSuccess = z;
    }

    public void setShowWebViewSearch(boolean z) {
        this.showWebViewSearch = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWebSourceData(WebSourceIndexData webSourceIndexData) {
        this.webSourceData = webSourceIndexData;
    }
}

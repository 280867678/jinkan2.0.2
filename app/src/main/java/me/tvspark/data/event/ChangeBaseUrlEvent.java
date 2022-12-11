package me.tvspark.data.event;

/* loaded from: classes4.dex */
public class ChangeBaseUrlEvent extends BaseEvent {
    public String webSourceBaseUrl;
    public String webSourceSiteName;

    public ChangeBaseUrlEvent(String str, String str2) {
        this.webSourceBaseUrl = "";
        this.webSourceSiteName = "";
        this.webSourceBaseUrl = str;
        this.webSourceSiteName = str2;
    }

    public String getWebSourceBaseUrl() {
        return this.webSourceBaseUrl;
    }

    public String getWebSourceSiteName() {
        return this.webSourceSiteName;
    }

    public void setWebSourceBaseUrl(String str) {
        this.webSourceBaseUrl = str;
    }

    public void setWebSourceSiteName(String str) {
        this.webSourceSiteName = str;
    }
}

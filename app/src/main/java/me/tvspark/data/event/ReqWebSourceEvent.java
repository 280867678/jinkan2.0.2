package me.tvspark.data.event;

/* loaded from: classes4.dex */
public class ReqWebSourceEvent extends BaseEvent {
    public boolean isSuccess;
    public String urlWebSource;

    public ReqWebSourceEvent(String str, boolean z) {
        this.urlWebSource = str;
        this.isSuccess = z;
    }

    public String getUrlWebSource() {
        return this.urlWebSource;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }

    public void setUrlWebSource(String str) {
        this.urlWebSource = str;
    }
}

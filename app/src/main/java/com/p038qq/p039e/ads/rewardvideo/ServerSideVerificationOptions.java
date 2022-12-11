package com.p038qq.p039e.ads.rewardvideo;

import org.json.JSONObject;

/* renamed from: com.qq.e.ads.rewardvideo.ServerSideVerificationOptions */
/* loaded from: classes3.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";
    public final JSONObject Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new JSONObject();
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: com.qq.e.ads.rewardvideo.ServerSideVerificationOptions$Builder */
    /* loaded from: classes3.dex */
    public static class Builder {
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, null);
        }

        public Builder setCustomData(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            return this;
        }
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, C10541 c10541) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String getCustomData() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public JSONObject getOptions() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String getUserId() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

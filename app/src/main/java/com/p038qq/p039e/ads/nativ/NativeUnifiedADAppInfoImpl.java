package com.p038qq.p039e.ads.nativ;

import org.json.JSONObject;

/* renamed from: com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl */
/* loaded from: classes3.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl$Keys */
    /* loaded from: classes3.dex */
    public interface Keys {
        public static final String APP_NAME = "app_name";
        public static final String AUTHOR_NAME = "author_name";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PERMISSION_URL = "permission_url";
        public static final String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final String VERSION_NAME = "version_name";
    }

    public NativeUnifiedADAppInfoImpl(JSONObject jSONObject) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jSONObject.optString(Keys.APP_NAME);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jSONObject.optString(Keys.AUTHOR_NAME);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jSONObject.optLong(Keys.PACKAGE_SIZE);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jSONObject.optString(Keys.PERMISSION_URL);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jSONObject.optString(Keys.PRIVACY_AGREEMENT);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = jSONObject.optString(Keys.VERSION_NAME);
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

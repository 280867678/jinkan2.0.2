package com.p038qq.p039e.comm.constants;

import java.util.Map;
import me.tvspark.outline;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.constants.LoadAdParams */
/* loaded from: classes3.dex */
public class LoadAdParams {
    public final JSONObject Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new JSONObject();
    public JSONObject Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public LoginType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public Map getDevExtra() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String getDevExtraJsonString() {
        try {
            return (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() <= 0) ? "" : new JSONObject(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String getLoginAppId() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String getLoginOpenid() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public LoginType getLoginType() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public JSONObject getParams() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String getUin() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void setDevExtra(Map<String, String> map) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    public void setLoginOpenid(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    public void setLoginType(LoginType loginType) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = loginType;
    }

    public void setUin(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LoadAdParams{, loginType=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", loginAppId=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", loginOpenid=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", uin=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", passThroughInfo=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", extraInfo=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

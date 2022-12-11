package com.arialyy.aria.core.download.tcp;

/* loaded from: classes3.dex */
public class TcpTaskConfig {
    public String heartbeat;
    public String params;
    public long heartbeatInterval = 1000;
    public String charset = "utf-8";

    public String getCharset() {
        return this.charset;
    }

    public String getHeartbeat() {
        return this.heartbeat;
    }

    public long getHeartbeatInterval() {
        return this.heartbeatInterval;
    }

    public String getParams() {
        return this.params;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setHeartbeat(String str) {
        this.heartbeat = str;
    }

    public void setHeartbeatInterval(long j) {
        this.heartbeatInterval = j;
    }

    public void setParams(String str) {
        this.params = str;
    }
}

package com.arialyy.aria.core.download.tcp;

import android.text.TextUtils;
import com.arialyy.aria.core.common.BaseOption;
import com.arialyy.aria.util.ALog;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class TcpDelegate extends BaseOption {
    public String charset;
    public long heartbeat;
    public String heartbeatInfo;
    public String params;

    public TcpDelegate setCharset(String str) {
        if (!Charset.isSupported(str)) {
            ALog.m4185w(this.TAG, "不支持的编码");
            return this;
        }
        this.charset = str;
        return this;
    }

    public TcpDelegate setHeartbeatInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.m4185w(this.TAG, "心跳包传输的数据不能为空");
            return this;
        }
        this.heartbeatInfo = str;
        return this;
    }

    public TcpDelegate setHeartbeatInterval(long j) {
        if (j <= 0) {
            ALog.m4185w(this.TAG, "心跳间隔不能小于1毫秒");
            return this;
        }
        this.heartbeat = j;
        return this;
    }

    public TcpDelegate setParam(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.m4185w(this.TAG, "tcp传输的数据不能为空");
            return this;
        }
        this.params = str;
        return this;
    }
}

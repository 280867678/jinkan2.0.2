package com.arialyy.aria.core.config;

import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.AriaCrashHandler;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class AppConfig extends BaseConfig implements Serializable {
    public int logLevel;
    public boolean useAriaCrashHandler;
    public boolean netCheck = true;
    public boolean useBroadcast = false;
    public boolean notNetRetry = false;

    public int getLogLevel() {
        return this.logLevel;
    }

    @Override // com.arialyy.aria.core.config.BaseConfig
    public int getType() {
        return 3;
    }

    public boolean getUseAriaCrashHandler() {
        return this.useAriaCrashHandler;
    }

    public boolean isNetCheck() {
        return this.netCheck;
    }

    public boolean isNotNetRetry() {
        return this.notNetRetry;
    }

    public boolean isUseBroadcast() {
        return this.useBroadcast;
    }

    public AppConfig setLogLevel(int i) {
        this.logLevel = i;
        ALog.LOG_LEVEL = i;
        save();
        return this;
    }

    public AppConfig setNetCheck(boolean z) {
        this.netCheck = z;
        save();
        return this;
    }

    public AppConfig setNotNetRetry(boolean z) {
        this.notNetRetry = z;
        save();
        return this;
    }

    public AppConfig setUseAriaCrashHandler(boolean z) {
        this.useAriaCrashHandler = z;
        Thread.setDefaultUncaughtExceptionHandler(z ? new AriaCrashHandler() : null);
        save();
        return this;
    }

    public AppConfig setUseBroadcast(boolean z) {
        this.useBroadcast = z;
        save();
        return this;
    }
}

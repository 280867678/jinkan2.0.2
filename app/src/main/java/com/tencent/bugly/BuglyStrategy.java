package com.tencent.bugly;

import com.tencent.bugly.crashreport.common.info.C1140a;
import java.util.Map;

/* loaded from: classes3.dex */
public class BuglyStrategy {

    /* renamed from: a */
    public String f677a;

    /* renamed from: b */
    public String f678b;

    /* renamed from: c */
    public String f679c;

    /* renamed from: d */
    public long f680d;

    /* renamed from: e */
    public String f681e;

    /* renamed from: f */
    public String f682f;

    /* renamed from: p */
    public C1080a f692p;

    /* renamed from: g */
    public boolean f683g = true;

    /* renamed from: h */
    public boolean f684h = true;

    /* renamed from: i */
    public boolean f685i = true;

    /* renamed from: j */
    public boolean f686j = true;

    /* renamed from: k */
    public Class<?> f687k = null;

    /* renamed from: l */
    public boolean f688l = true;

    /* renamed from: m */
    public boolean f689m = true;

    /* renamed from: n */
    public boolean f690n = true;

    /* renamed from: o */
    public boolean f691o = false;

    /* renamed from: q */
    public int f693q = 31;

    /* renamed from: r */
    public boolean f694r = false;

    /* renamed from: com.tencent.bugly.BuglyStrategy$a */
    /* loaded from: classes3.dex */
    public static class C1080a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public synchronized Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str;
        str = this.f678b;
        if (str == null) {
            str = C1140a.m3394m().f1012I;
        }
        return str;
    }

    public synchronized String getAppPackageName() {
        String str;
        str = this.f679c;
        if (str == null) {
            str = C1140a.m3394m().f1041g;
        }
        return str;
    }

    public synchronized long getAppReportDelay() {
        return this.f680d;
    }

    public synchronized String getAppVersion() {
        String str;
        str = this.f677a;
        if (str == null) {
            str = C1140a.m3394m().f1008E;
        }
        return str;
    }

    public synchronized int getCallBackType() {
        return this.f693q;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f694r;
    }

    /* renamed from: getCrashHandleCallback */
    public synchronized C1080a mo4835getCrashHandleCallback() {
        return this.f692p;
    }

    public synchronized String getDeviceID() {
        return this.f682f;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f681e;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f687k;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f688l;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f684h;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f685i;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f683g;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f686j;
    }

    public boolean isReplaceOldChannel() {
        return this.f689m;
    }

    public synchronized boolean isUploadProcess() {
        return this.f690n;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f691o;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f678b = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f679c = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j) {
        this.f680d = j;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f677a = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.f688l = z;
        return this;
    }

    public synchronized void setCallBackType(int i) {
        this.f693q = i;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.f694r = z;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(C1080a c1080a) {
        this.f692p = c1080a;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f682f = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f684h = z;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z) {
        this.f685i = z;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f683g = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f686j = z;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f681e = str;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.f691o = z;
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.f689m = z;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.f690n = z;
        return this;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f687k = cls;
        return this;
    }
}

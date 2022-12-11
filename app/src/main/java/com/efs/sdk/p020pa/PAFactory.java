package com.efs.sdk.p020pa;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.p020pa.config.ConfigManager;
import com.efs.sdk.p020pa.config.IEfsReporter;
import com.efs.sdk.p020pa.config.PackageLevel;
import com.efs.sdk.p020pa.p021a.C0836c;
import java.util.HashMap;

/* renamed from: com.efs.sdk.pa.PAFactory */
/* loaded from: classes3.dex */
public class PAFactory {
    public static final long DEFAULT_TIME_OUT_TIME = 2000;
    public static final long INVALID_TIME_OUT_TIME = 0;
    public static final long MAX_TIME_OUT_TIME = 4000;
    public static final String TAG = "pafactory";
    public static final ThreadLocal<AbstractC0827PA> sThreadLocal = new ThreadLocal<>();
    public ConfigManager mConfigManager;
    public Context mContext;
    public HashMap<String, String> mExtend;
    public EfsReporter mReporter;
    public IEfsReporter mReporterFactory;
    public String mSerial;
    public String mSver;
    public long mTimeOutTime;
    public PATraceListener mTraceListener;

    /* renamed from: com.efs.sdk.pa.PAFactory$Builder */
    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a */
        public PackageLevel f490a;

        /* renamed from: b */
        public IEfsReporter f491b;

        /* renamed from: c */
        public boolean f492c;

        /* renamed from: d */
        public Context f493d;

        /* renamed from: e */
        public String f494e;

        /* renamed from: f */
        public HashMap<String, String> f495f;

        /* renamed from: g */
        public String f496g;

        /* renamed from: h */
        public long f497h = 2000;

        /* renamed from: i */
        public PATraceListener f498i;

        public Builder(Context context, IEfsReporter iEfsReporter) {
            if (context != null) {
                if (iEfsReporter == null) {
                    throw new RuntimeException("reporter Should Not Empty");
                }
                this.f491b = iEfsReporter;
                this.f493d = context;
                return;
            }
            throw new RuntimeException("context Should Not null");
        }

        public PAFactory build() {
            if (this.f490a != null) {
                return new PAFactory(this.f493d, this.f490a, this.f491b, this.f492c, this.f494e, this.f495f, this.f496g, this.f497h, this.f498i);
            }
            throw new RuntimeException(String.format("%s Should Not Null", ""));
        }

        public Builder extendLogInfo(HashMap<String, String> hashMap) {
            this.f495f = hashMap;
            return this;
        }

        public Builder isNewInstall(boolean z) {
            this.f492c = z;
            return this;
        }

        public Builder packageLevel(PackageLevel packageLevel) {
            this.f490a = packageLevel;
            return this;
        }

        public Builder serial(String str) {
            this.f494e = str;
            return this;
        }

        public Builder sver(String str) {
            this.f496g = str;
            return this;
        }

        public Builder timeoutTime(long j) {
            if (j <= 0) {
                this.f497h = 2000L;
            } else if (j > PAFactory.MAX_TIME_OUT_TIME) {
                this.f497h = 2000L;
                return this;
            } else {
                this.f497h = j;
            }
            return this;
        }

        public Builder traceListener(PATraceListener pATraceListener) {
            this.f498i = pATraceListener;
            return this;
        }
    }

    public PAFactory(Context context, PackageLevel packageLevel, IEfsReporter iEfsReporter, boolean z, String str, HashMap<String, String> hashMap, String str2, long j, PATraceListener pATraceListener) {
        this.mReporterFactory = iEfsReporter;
        this.mSerial = str;
        this.mExtend = hashMap;
        this.mSver = str2;
        this.mContext = context;
        this.mTraceListener = pATraceListener;
        this.mTimeOutTime = j;
        this.mConfigManager = new ConfigManager(context, packageLevel, iEfsReporter, z);
    }

    public ConfigManager getConfigManager() {
        return this.mConfigManager;
    }

    public HashMap<String, String> getExtend() {
        return this.mExtend;
    }

    public synchronized AbstractC0827PA getPaInstance() {
        AbstractC0827PA abstractC0827PA;
        abstractC0827PA = sThreadLocal.get();
        if (abstractC0827PA == null) {
            abstractC0827PA = new C0836c(this.mConfigManager.enableTracer());
            abstractC0827PA.registerPAANRListener(this.mContext, new C0829a(this), this.mTimeOutTime);
            sThreadLocal.set(abstractC0827PA);
        }
        return abstractC0827PA;
    }

    public EfsReporter getReporter() {
        if (this.mReporter == null) {
            IEfsReporter iEfsReporter = this.mReporterFactory;
            this.mReporter = iEfsReporter != null ? iEfsReporter.getReporter() : null;
        }
        return this.mReporter;
    }

    public String getSerial() {
        return this.mSerial;
    }

    public String getSver() {
        return this.mSver;
    }

    public PATraceListener getTraceListener() {
        return this.mTraceListener;
    }
}

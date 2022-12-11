package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.statistics.C1766a;
import com.umeng.commonsdk.statistics.common.C1777d;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.AbstractC1803d;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public class ImLatent implements AbstractC1803d {
    public static ImLatent instanse;
    public Context context;
    public StatTracer statTracer;
    public C1777d storeHelper;
    public final int _DEFAULT_HOURS = 360;
    public final int _DEFAULT_MIN_HOURS = 36;
    public final int _DEFAULT_MIN_LATENT = 1;
    public final int _DEFAULT_MAX_LATENT = 1800;
    public final long _ONE_HOURS_IN_MS = DateUtils.MILLIS_PER_HOUR;
    public final long _360HOURS_IN_MS = 1296000000;
    public final long _36HOURS_IN_MS = 129600000;
    public final int LATENT_MAX = 1800000;
    public final int LATENT_WINDOW = 10;
    public long latentHour = 1296000000;
    public int latentWindow = 10;
    public long mDelay = 0;
    public long mElapsed = 0;
    public boolean mLatentActivite = false;
    public Object mLatentLock = new Object();

    public ImLatent(Context context, StatTracer statTracer) {
        this.context = context;
        this.storeHelper = C1777d.m503a(context);
        this.statTracer = statTracer;
    }

    public static synchronized ImLatent getService(Context context, StatTracer statTracer) {
        ImLatent imLatent;
        synchronized (ImLatent.class) {
            if (instanse == null) {
                ImLatent imLatent2 = new ImLatent(context, statTracer);
                instanse = imLatent2;
                imLatent2.onImprintChanged(ImprintHandler.getImprintService(context).m475c());
            }
            imLatent = instanse;
        }
        return imLatent;
    }

    public long getDelayTime() {
        long j;
        synchronized (this.mLatentLock) {
            j = this.mDelay;
        }
        return j;
    }

    public long getElapsedTime() {
        return this.mElapsed;
    }

    public boolean isLatentActivite() {
        boolean z;
        synchronized (this.mLatentLock) {
            z = this.mLatentActivite;
        }
        return z;
    }

    public void latentDeactivite() {
        synchronized (this.mLatentLock) {
            this.mLatentActivite = false;
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.AbstractC1803d
    public void onImprintChanged(ImprintHandler.C1781a c1781a) {
        int i = 360;
        int intValue = Integer.valueOf(c1781a.m467a("latent_hours", String.valueOf(360))).intValue();
        if (intValue > 36) {
            i = intValue;
        }
        this.latentHour = i * DateUtils.MILLIS_PER_HOUR;
        int intValue2 = Integer.valueOf(c1781a.m467a(C1543ak.f2981aR, "0")).intValue();
        if (intValue2 < 1 || intValue2 > 1800) {
            intValue2 = 0;
        }
        if (intValue2 == 0 && ((intValue2 = C1766a.f4019c) <= 0 || intValue2 > 1800000)) {
            intValue2 = 10;
        }
        this.latentWindow = intValue2;
    }

    public boolean shouldStartLatency() {
        if (!this.storeHelper.m499c() && !this.statTracer.isFirstRequest()) {
            synchronized (this.mLatentLock) {
                if (this.mLatentActivite) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis() - this.statTracer.getLastReqTime();
                if (currentTimeMillis > this.latentHour) {
                    String signature = Envelope.getSignature(this.context);
                    synchronized (this.mLatentLock) {
                        this.mDelay = DataHelper.random(this.latentWindow, signature);
                        this.mElapsed = currentTimeMillis;
                        this.mLatentActivite = true;
                    }
                    return true;
                } else if (currentTimeMillis <= 129600000) {
                    return false;
                } else {
                    synchronized (this.mLatentLock) {
                        this.mDelay = 0L;
                        this.mElapsed = currentTimeMillis;
                        this.mLatentActivite = true;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}

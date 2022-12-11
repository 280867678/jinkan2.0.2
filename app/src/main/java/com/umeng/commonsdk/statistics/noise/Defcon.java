package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.AbstractC1803d;

/* loaded from: classes4.dex */
public class Defcon implements AbstractC1803d {
    public static final int LEVEL_0 = 0;
    public static final int LEVEL_1 = 1;
    public static final int LEVEL_2 = 2;
    public static final int LEVEL_3 = 3;
    public static final long MILLIS_24_HOURS = 86400000;
    public static final long MILLIS_4_HOURS = 14400000;
    public static final long MILLIS_8_HOURS = 28800000;
    public static Defcon instanse;
    public int mLevel = 0;

    public static synchronized Defcon getService(Context context) {
        Defcon defcon;
        synchronized (Defcon.class) {
            if (instanse == null) {
                instanse = new Defcon();
                instanse.setLevel(Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", "0")).intValue());
            }
            defcon = instanse;
        }
        return defcon;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public long getReqInterval() {
        int i = this.mLevel;
        return i != 1 ? i != 2 ? i != 3 ? 0L : 86400000L : MILLIS_8_HOURS : MILLIS_4_HOURS;
    }

    public long getRetryInterval() {
        return this.mLevel == 0 ? 0L : 300000L;
    }

    public boolean isOpen() {
        return this.mLevel != 0;
    }

    @Override // com.umeng.commonsdk.statistics.internal.AbstractC1803d
    public void onImprintChanged(ImprintHandler.C1781a c1781a) {
        setLevel(Integer.valueOf(c1781a.m467a("defcon", String.valueOf(0))).intValue());
    }

    public void setLevel(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.mLevel = i;
    }
}

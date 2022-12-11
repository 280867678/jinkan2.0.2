package me.tvspark;

import android.content.Context;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import white.whale.R;

/* loaded from: classes4.dex */
public class pn0 implements sk0 {
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        Beta.autoInit = true;
        Beta.autoCheckUpgrade = true;
        Beta.upgradeCheckPeriod = 60000L;
        Beta.initDelay = 3000L;
        Beta.largeIconId = R.mipmap.ic_launcher;
        Beta.smallIconId = R.mipmap.ic_launcher;
        Beta.showInterruptedStrategy = true;
        Bugly.setAppChannel(context, str);
        Bugly.init(context, "61177760cc", false);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
        Beta.checkUpgrade(z, z2);
    }
}

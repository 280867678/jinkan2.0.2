package com.p024jg.ids.meizu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.idtracking.C1790h;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.meizu.MeiZuReceiver */
/* loaded from: classes6.dex */
public class MeiZuReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (context != null && intent != null) {
            try {
                int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
                if (intExtra != 1 ? intExtra != 2 || ((stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList")) != null && stringArrayListExtra.contains(context.getPackageName())) : TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
                    String stringExtra = intent.getStringExtra("openIdType");
                    if ("aaid".equals(stringExtra)) {
                        C0983a.m3719a().m3718a(2);
                    } else if ("vaid".equals(stringExtra)) {
                        C0983a.m3719a().m3718a(1);
                    } else if (C1790h.f4114d.equals(stringExtra)) {
                        C0983a.m3719a().m3718a(0);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}

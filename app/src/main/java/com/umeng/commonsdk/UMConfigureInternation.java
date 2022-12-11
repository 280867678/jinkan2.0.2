package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C1724a;
import com.umeng.commonsdk.internal.C1725b;

/* loaded from: classes4.dex */
public class UMConfigureInternation {
    public static boolean isInternal;

    public static void doSelfCheck(Context context) {
        try {
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                return;
            }
            UMWorkDispatch.sendEvent(context, C1724a.f3892C, C1725b.m729a(context).m730a(), null);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void sendInternal(final Context context) {
        synchronized (UMConfigureInternation.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigureInternation.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                    String packageName = context.getPackageName();
                                    if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName) || !UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                                        return;
                                    }
                                    UMWorkDispatch.sendEvent(context, C1724a.f3912n, C1725b.m729a(context).m730a(), null);
                                } catch (Throwable unused) {
                                }
                            }
                        }).start();
                        isInternal = true;
                    }
                } finally {
                }
            }
        }
    }
}

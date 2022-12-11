package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.AbstractC1489a;

/* loaded from: classes4.dex */
public class TbsVideo {
    public static boolean canUseTbsPlayer(Context context) {
        return C1392s.m2404a(context).m2407a();
    }

    public static boolean canUseYunbo(Context context) {
        return C1392s.m2404a(context).m2407a() && QbSdk.canUseVideoFeatrue(context, 1);
    }

    public static void openVideo(Context context, String str) {
        openVideo(context, str, null);
    }

    public static void openVideo(Context context, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("videoUrl", str);
        Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.setFlags(268435456);
        intent.setPackage(context.getPackageName());
        intent.putExtra("extraData", bundle);
        context.startActivity(intent);
    }

    public static boolean openYunboVideo(Context context, String str, Bundle bundle, AbstractC1489a abstractC1489a) {
        if (canUseYunbo(context)) {
            return C1392s.m2404a(context).m2403a(str, bundle, abstractC1489a);
        }
        return false;
    }
}

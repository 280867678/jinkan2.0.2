package com.tencent.bugly.beta.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* renamed from: com.tencent.bugly.beta.utils.f */
/* loaded from: classes3.dex */
public class C1126f {

    /* renamed from: a */
    public static Toast f946a;

    /* renamed from: a */
    public static void m3487a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = f946a;
        if (toast == null) {
            f946a = Toast.makeText(context, str, 0);
        } else {
            toast.setText(str);
        }
        f946a.show();
    }
}

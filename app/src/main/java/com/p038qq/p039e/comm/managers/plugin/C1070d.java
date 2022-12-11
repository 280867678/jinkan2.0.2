package com.p038qq.p039e.comm.managers.plugin;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.C1543ak;

/* renamed from: com.qq.e.comm.managers.plugin.d */
/* loaded from: classes3.dex */
public class C1070d {
    public static final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {"0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "a", "b", C1543ak.f2969aF, "d", "e", "f"};

    /* renamed from: a */
    public static String m3654a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            stringBuffer.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i / 16] + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i % 16]);
        }
        return stringBuffer.toString();
    }
}

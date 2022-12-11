package me.tvspark;

import android.support.p000v4.media.session.MediaSessionCompat;
import com.p046uc.crashsdk.export.LogType;
import com.tencent.smtt.sdk.TbsListener;
import org.mozilla.javascript.Token;

/* renamed from: me.tvspark.x4 */
/* loaded from: classes4.dex */
public final class C2774x4 {
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {1, 2, 3, 6};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {48000, 44100, LogType.UNEXP_KNOWN_REASON};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {24000, 22050, 16000};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {2, 1, 2, 3, 3, 4, 4, 5};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 384, 448, 512, 576, 640};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = {69, 87, 104, 121, Token.USE_STACK, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, 208, TbsListener.ErrorCode.DOWNLOAD_FAILED_FOR_PREINIT_CALLBACK, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int i3 = i2 / 2;
        if (i >= 0) {
            int[] iArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i >= iArr.length || i2 < 0) {
                return -1;
            }
            int[] iArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i3 >= iArr2.length) {
                return -1;
            }
            int i4 = iArr[i];
            if (i4 == 44100) {
                return ((i2 % 2) + iArr2[i3]) * 2;
            }
            int i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
            return i4 == 32000 ? i5 * 6 : i5 * 4;
        }
        return -1;
    }
}

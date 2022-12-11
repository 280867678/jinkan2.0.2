package me.tvspark;

import com.tencent.smtt.sdk.TbsListener;

/* loaded from: classes4.dex */
public class t31 extends s31 {
    @Override // me.tvspark.n31
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        int i2;
        int i3 = bArr[i] & 255;
        if (i3 >= 129 && i3 <= 159) {
            i2 = i3 - 129;
        } else if (i3 < 224 || i3 > 239) {
            return -1;
        } else {
            i2 = (i3 - TbsListener.ErrorCode.EXCEED_INCR_UPDATE) + 31;
        }
        int i4 = i2 * 188;
        int i5 = bArr[i + 1] & 255;
        int i6 = (i5 - 64) + i4;
        return i5 >= 128 ? i6 - 1 : i6;
    }
}

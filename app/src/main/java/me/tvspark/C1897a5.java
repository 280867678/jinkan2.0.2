package me.tvspark;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.a5 */
/* loaded from: classes4.dex */
public final class C1897a5 {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final C1897a5 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C1897a5(new int[]{2}, 8);
    public static final C1897a5 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C1897a5(new int[]{2, 5, 6}, 8);

    public C1897a5(@Nullable int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[0];
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public static C1897a5 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        return (!(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 17 && "Amazon".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) || Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) != 1) ? (registerReceiver == null || registerReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : new C1897a5(registerReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), registerReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8)) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1897a5)) {
            return false;
        }
        C1897a5 c1897a5 = (C1897a5) obj;
        return Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1897a5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c1897a5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String arrays = Arrays.toString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrays, 67));
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}

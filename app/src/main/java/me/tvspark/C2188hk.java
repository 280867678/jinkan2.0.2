package me.tvspark;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.HttpDataSource;

/* renamed from: me.tvspark.hk */
/* loaded from: classes4.dex */
public final class C2188hk extends HttpDataSource.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final AbstractC2410nk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2188hk(String str, @Nullable AbstractC2410nk abstractC2410nk, int i, int i2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2410nk;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            return;
        }
        throw new IllegalArgumentException();
    }
}

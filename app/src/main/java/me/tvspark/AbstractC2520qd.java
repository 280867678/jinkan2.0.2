package me.tvspark;

import androidx.annotation.Nullable;
import me.tvspark.C2254jc;

/* renamed from: me.tvspark.qd */
/* loaded from: classes4.dex */
public abstract class AbstractC2520qd implements C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    @Override // me.tvspark.C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @Nullable
    public /* synthetic */ byte[] Wwwwwwwwwwwwwwwwwwwwww() {
        return C2291kc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // me.tvspark.C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @Nullable
    public /* synthetic */ C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return C2291kc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        return simpleName.length() != 0 ? "SCTE-35 splice command: type=".concat(simpleName) : new String("SCTE-35 splice command: type=");
    }
}

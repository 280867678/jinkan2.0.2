package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: me.tvspark.vd */
/* loaded from: classes4.dex */
public final class C2706vd extends AbstractC2520qd {
    public static final Parcelable.Creator<C2706vd> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final long Wwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.vd$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2706vd> {
        @Override // android.os.Parcelable.Creator
        public C2706vd createFromParcel(Parcel parcel) {
            return new C2706vd(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        public C2706vd[] newArray(int i) {
            return new C2706vd[i];
        }
    }

    public C2706vd(long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwww = j2;
    }

    public /* synthetic */ C2706vd(long j, long j2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwww = j2;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, long j) {
        long Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        if ((128 & Wwwwwwwwwwwwwwwwwwwwww) != 0) {
            return 8589934591L & ((((Wwwwwwwwwwwwwwwwwwwwww & 1) << 32) | c2078el.Wwwwwwwwwwwwwwwwwwwww()) + j);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }
}

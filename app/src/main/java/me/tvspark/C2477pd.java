package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: me.tvspark.pd */
/* loaded from: classes4.dex */
public final class C2477pd extends AbstractC2520qd {
    public static final Parcelable.Creator<C2477pd> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final byte[] Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.pd$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2477pd> {
        @Override // android.os.Parcelable.Creator
        public C2477pd createFromParcel(Parcel parcel) {
            return new C2477pd(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public C2477pd[] newArray(int i) {
            return new C2477pd[i];
        }
    }

    public C2477pd(long j, byte[] bArr, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = bArr;
    }

    public /* synthetic */ C2477pd(Parcel parcel, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readLong();
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readLong();
        byte[] createByteArray = parcel.createByteArray();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(createByteArray);
        this.Wwwwwwwwwwwwwwwwwwwwww = createByteArray;
    }

    public static C2477pd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, long j) {
        long Wwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwww();
        int i2 = i - 4;
        byte[] bArr = new byte[i2];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, i2);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
        return new C2477pd(Wwwwwwwwwwwwwwwwwwwww, bArr, j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeByteArray(this.Wwwwwwwwwwwwwwwwwwwwww);
    }
}

package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.dd */
/* loaded from: classes4.dex */
public final class C2033dd extends AbstractC2255jd {
    public static final Parcelable.Creator<C2033dd> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.dd$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2033dd> {
        @Override // android.os.Parcelable.Creator
        public C2033dd createFromParcel(Parcel parcel) {
            return new C2033dd(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2033dd[] newArray(int i) {
            return new C2033dd[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2033dd(Parcel parcel) {
        super(r0);
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.createByteArray();
    }

    public C2033dd(String str, byte[] bArr) {
        super(str);
        this.Wwwwwwwwwwwwwwwwwwwwwww = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2033dd.class != obj.getClass()) {
            return false;
        }
        C2033dd c2033dd = (C2033dd) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.equals(c2033dd.Wwwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwww, c2033dd.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        return Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwww) + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, 527, 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeByteArray(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }
}

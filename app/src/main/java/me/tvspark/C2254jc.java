package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* renamed from: me.tvspark.jc */
/* loaded from: classes4.dex */
public final class C2254jc implements Parcelable {
    public static final Parcelable.Creator<C2254jc> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.jc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Parcelable {
        @Nullable
        byte[] Wwwwwwwwwwwwwwwwwwwwww();

        @Nullable
        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: me.tvspark.jc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2254jc> {
        @Override // android.os.Parcelable.Creator
        public C2254jc createFromParcel(Parcel parcel) {
            return new C2254jc(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2254jc[] newArray(int i) {
            return new C2254jc[i];
        }
    }

    public C2254jc(Parcel parcel) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[parcel.readInt()];
        int i = 0;
        while (true) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (i < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i] = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) parcel.readParcelable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public C2254jc(List<? extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) list.toArray(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0]);
    }

    public C2254jc(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww... wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
    }

    public C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2254jc c2254jc) {
        if (c2254jc == null) {
            return this;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length == 0 ? this : new C2254jc((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) this.Wwwwwwwwwwwwwwwwwwwwwwww, (Object[]) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C2254jc.class == obj.getClass()) {
            return Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwww, ((C2254jc) obj).Wwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    public String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.Wwwwwwwwwwwwwwwwwwwwwwww));
        return valueOf.length() != 0 ? "entries=".concat(valueOf) : new String("entries=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww.length);
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            parcel.writeParcelable(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0);
        }
    }
}

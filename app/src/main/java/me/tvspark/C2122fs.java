package me.tvspark;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* renamed from: me.tvspark.fs */
/* loaded from: classes4.dex */
public class C2122fs implements Parcelable {
    public static final Parcelable.Creator<C2122fs> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final C2048ds Wwwwwwwwwwwwwwwwwwwwwww;
    public final C2048ds Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.fs$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2122fs> {
        @Override // android.os.Parcelable.Creator
        public C2122fs createFromParcel(Parcel parcel) {
            return new C2122fs(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public C2122fs[] newArray(int i) {
            return new C2122fs[i];
        }
    }

    public C2122fs() {
        this(0, 0, 10, 0);
    }

    public C2122fs(int i, int i2, int i3, int i4) {
        this.Wwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwwwww = i4;
        int i5 = 12;
        this.Wwwwwwwwwwwwwwwwww = i >= 12 ? 1 : 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new C2048ds(59);
        this.Wwwwwwwwwwwwwwwwwwwwwww = new C2048ds(i4 == 1 ? 24 : i5);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwww == 1) {
            return this.Wwwwwwwwwwwwwwwwwwwww % 24;
        }
        int i = this.Wwwwwwwwwwwwwwwwwwwww;
        if (i % 12 == 0) {
            return 12;
        }
        return this.Wwwwwwwwwwwwwwwwww == 1 ? i - 12 : i;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2;
        if (i != this.Wwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwww = i;
            int i3 = this.Wwwwwwwwwwwwwwwwwwwww;
            if (i3 >= 12 || i != 1) {
                int i4 = this.Wwwwwwwwwwwwwwwwwwwww;
                if (i4 < 12 || i != 0) {
                    return;
                }
                i2 = i4 - 12;
            } else {
                i2 = i3 + 12;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = i2;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwww == 1) {
            this.Wwwwwwwwwwwwwwwwwwwww = i;
            return;
        }
        int i2 = 12;
        int i3 = i % 12;
        if (this.Wwwwwwwwwwwwwwwwww != 1) {
            i2 = 0;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = i3 + i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2122fs)) {
            return false;
        }
        C2122fs c2122fs = (C2122fs) obj;
        return this.Wwwwwwwwwwwwwwwwwwwww == c2122fs.Wwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwww == c2122fs.Wwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwww == c2122fs.Wwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwww == c2122fs.Wwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwww), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwww), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwww), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwww)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww);
    }
}

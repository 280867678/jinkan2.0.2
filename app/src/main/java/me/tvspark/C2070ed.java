package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.ed */
/* loaded from: classes4.dex */
public final class C2070ed extends AbstractC2255jd {
    public static final Parcelable.Creator<C2070ed> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final AbstractC2255jd[] Wwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.ed$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2070ed> {
        @Override // android.os.Parcelable.Creator
        public C2070ed createFromParcel(Parcel parcel) {
            return new C2070ed(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2070ed[] newArray(int i) {
            return new C2070ed[i];
        }
    }

    public C2070ed(Parcel parcel) {
        super("CHAP");
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwww = readString;
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwww = parcel.readLong();
        this.Wwwwwwwwwwwwwwwwwww = parcel.readLong();
        int readInt = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwww = new AbstractC2255jd[readInt];
        for (int i = 0; i < readInt; i++) {
            this.Wwwwwwwwwwwwwwwwww[i] = (AbstractC2255jd) parcel.readParcelable(AbstractC2255jd.class.getClassLoader());
        }
    }

    public C2070ed(String str, int i, int i2, long j, long j2, AbstractC2255jd[] abstractC2255jdArr) {
        super("CHAP");
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwww = abstractC2255jdArr;
    }

    @Override // me.tvspark.AbstractC2255jd, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2070ed.class != obj.getClass()) {
            return false;
        }
        C2070ed c2070ed = (C2070ed) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwww == c2070ed.Wwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwww == c2070ed.Wwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwww == c2070ed.Wwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwww == c2070ed.Wwwwwwwwwwwwwwwwwww && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwww, (Object) c2070ed.Wwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwww, c2070ed.Wwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        int i = (((((((527 + this.Wwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwww) * 31) + ((int) this.Wwwwwwwwwwwwwwwwwwww)) * 31) + ((int) this.Wwwwwwwwwwwwwwwwwww)) * 31;
        String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwww);
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwwwww);
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwww.length);
        for (AbstractC2255jd abstractC2255jd : this.Wwwwwwwwwwwwwwwwww) {
            parcel.writeParcelable(abstractC2255jd, 0);
        }
    }
}

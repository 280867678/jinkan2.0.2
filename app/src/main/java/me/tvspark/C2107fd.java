package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.fd */
/* loaded from: classes4.dex */
public final class C2107fd extends AbstractC2255jd {
    public static final Parcelable.Creator<C2107fd> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final AbstractC2255jd[] Wwwwwwwwwwwwwwwwwww;
    public final String[] Wwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.fd$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2107fd> {
        @Override // android.os.Parcelable.Creator
        public C2107fd createFromParcel(Parcel parcel) {
            return new C2107fd(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2107fd[] newArray(int i) {
            return new C2107fd[i];
        }
    }

    public C2107fd(Parcel parcel) {
        super("CTOC");
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwww = readString;
        boolean z = true;
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readByte() != 0;
        this.Wwwwwwwwwwwwwwwwwwwww = parcel.readByte() == 0 ? false : z;
        this.Wwwwwwwwwwwwwwwwwwww = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwww = new AbstractC2255jd[readInt];
        for (int i = 0; i < readInt; i++) {
            this.Wwwwwwwwwwwwwwwwwww[i] = (AbstractC2255jd) parcel.readParcelable(AbstractC2255jd.class.getClassLoader());
        }
    }

    public C2107fd(String str, boolean z, boolean z2, String[] strArr, AbstractC2255jd[] abstractC2255jdArr) {
        super("CTOC");
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwww = z2;
        this.Wwwwwwwwwwwwwwwwwwww = strArr;
        this.Wwwwwwwwwwwwwwwwwww = abstractC2255jdArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2107fd.class != obj.getClass()) {
            return false;
        }
        C2107fd c2107fd = (C2107fd) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwww == c2107fd.Wwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwww == c2107fd.Wwwwwwwwwwwwwwwwwwwww && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwww, (Object) c2107fd.Wwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwww, c2107fd.Wwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwww, c2107fd.Wwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        int i = (((527 + (this.Wwwwwwwwwwwwwwwwwwwwww ? 1 : 0)) * 31) + (this.Wwwwwwwwwwwwwwwwwwwww ? 1 : 0)) * 31;
        String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeByte(this.Wwwwwwwwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.Wwwwwwwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.Wwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwww.length);
        for (AbstractC2255jd abstractC2255jd : this.Wwwwwwwwwwwwwwwwwww) {
            parcel.writeParcelable(abstractC2255jd, 0);
        }
    }
}

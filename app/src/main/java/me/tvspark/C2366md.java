package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.md */
/* loaded from: classes4.dex */
public final class C2366md extends AbstractC2255jd {
    public static final Parcelable.Creator<C2366md> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final byte[] Wwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.md$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2366md> {
        @Override // android.os.Parcelable.Creator
        public C2366md createFromParcel(Parcel parcel) {
            return new C2366md(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2366md[] newArray(int i) {
            return new C2366md[i];
        }
    }

    public C2366md(Parcel parcel) {
        super("PRIV");
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwww = readString;
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.createByteArray();
    }

    public C2366md(String str, byte[] bArr) {
        super("PRIV");
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwww = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2366md.class != obj.getClass()) {
            return false;
        }
        C2366md c2366md = (C2366md) obj;
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwww, (Object) c2366md.Wwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwww, c2366md.Wwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
        return Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwww) + ((527 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // me.tvspark.AbstractC2255jd
    public String toString() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 8)));
        sb.append(str);
        sb.append(": owner=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeByteArray(this.Wwwwwwwwwwwwwwwwwwwwww);
    }
}

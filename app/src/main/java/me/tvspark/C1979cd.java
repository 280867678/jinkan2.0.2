package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.cd */
/* loaded from: classes4.dex */
public final class C1979cd extends AbstractC2255jd {
    public static final Parcelable.Creator<C1979cd> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final byte[] Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.cd$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C1979cd> {
        @Override // android.os.Parcelable.Creator
        public C1979cd createFromParcel(Parcel parcel) {
            return new C1979cd(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C1979cd[] newArray(int i) {
            return new C1979cd[i];
        }
    }

    public C1979cd(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwww = readString;
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwww = parcel.createByteArray();
    }

    public C1979cd(String str, @Nullable String str2, int i, byte[] bArr) {
        super("APIC");
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwww = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1979cd.class != obj.getClass()) {
            return false;
        }
        C1979cd c1979cd = (C1979cd) obj;
        return this.Wwwwwwwwwwwwwwwwwwwww == c1979cd.Wwwwwwwwwwwwwwwwwwwww && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwww, (Object) c1979cd.Wwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwww, (Object) c1979cd.Wwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwww, c1979cd.Wwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        int i = (527 + this.Wwwwwwwwwwwwwwwwwwwww) * 31;
        String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwww) + ((hashCode + i2) * 31);
    }

    @Override // me.tvspark.AbstractC2255jd
    public String toString() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        String str3 = this.Wwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 25))));
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwww);
        parcel.writeByteArray(this.Wwwwwwwwwwwwwwwwwwww);
    }
}

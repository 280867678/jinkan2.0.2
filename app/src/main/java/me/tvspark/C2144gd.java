package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.gd */
/* loaded from: classes4.dex */
public final class C2144gd extends AbstractC2255jd {
    public static final Parcelable.Creator<C2144gd> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final String Wwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.gd$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2144gd> {
        @Override // android.os.Parcelable.Creator
        public C2144gd createFromParcel(Parcel parcel) {
            return new C2144gd(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2144gd[] newArray(int i) {
            return new C2144gd[i];
        }
    }

    public C2144gd(Parcel parcel) {
        super("COMM");
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwww = readString;
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwww = parcel.readString();
    }

    public C2144gd(String str, String str2, String str3) {
        super("COMM");
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwww = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2144gd.class != obj.getClass()) {
            return false;
        }
        C2144gd c2144gd = (C2144gd) obj;
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwww, (Object) c2144gd.Wwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwww, (Object) c2144gd.Wwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwww, (Object) c2144gd.Wwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwww;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Wwwwwwwwwwwwwwwwwwwww;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // me.tvspark.AbstractC2255jd
    public String toString() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        String str3 = this.Wwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 25))));
        sb.append(str);
        sb.append(": language=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwww);
    }
}

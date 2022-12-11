package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.od */
/* loaded from: classes4.dex */
public final class C2440od extends AbstractC2255jd {
    public static final Parcelable.Creator<C2440od> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final String Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.od$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2440od> {
        @Override // android.os.Parcelable.Creator
        public C2440od createFromParcel(Parcel parcel) {
            return new C2440od(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2440od[] newArray(int i) {
            return new C2440od[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2440od(Parcel parcel) {
        super(r0);
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readString();
    }

    public C2440od(String str, @Nullable String str2, String str3) {
        super(str);
        this.Wwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwww = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2440od.class != obj.getClass()) {
            return false;
        }
        C2440od c2440od = (C2440od) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.equals(c2440od.Wwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwww, (Object) c2440od.Wwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwww, (Object) c2440od.Wwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, 527, 31);
        String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i = 0;
        int hashCode = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @Override // me.tvspark.AbstractC2255jd
    public String toString() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 6)));
        sb.append(str);
        sb.append(": url=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwww);
    }
}

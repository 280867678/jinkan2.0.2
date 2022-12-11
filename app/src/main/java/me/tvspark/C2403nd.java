package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.nd */
/* loaded from: classes4.dex */
public final class C2403nd extends AbstractC2255jd {
    public static final Parcelable.Creator<C2403nd> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final String Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.nd$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2403nd> {
        @Override // android.os.Parcelable.Creator
        public C2403nd createFromParcel(Parcel parcel) {
            return new C2403nd(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2403nd[] newArray(int i) {
            return new C2403nd[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2403nd(Parcel parcel) {
        super(r0);
        String readString = parcel.readString();
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readString();
    }

    public C2403nd(String str, @Nullable String str2, String str3) {
        super(str);
        this.Wwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwww = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2403nd.class != obj.getClass()) {
            return false;
        }
        C2403nd c2403nd = (C2403nd) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.equals(c2403nd.Wwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwww, (Object) c2403nd.Wwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwww, (Object) c2403nd.Wwwwwwwwwwwwwwwwwwwwww);
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
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        String str3 = this.Wwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 22))));
        sb.append(str);
        sb.append(": description=");
        sb.append(str2);
        sb.append(": value=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwww);
    }
}

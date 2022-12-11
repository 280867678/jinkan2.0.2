package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.C2254jc;

/* renamed from: me.tvspark.jg */
/* loaded from: classes4.dex */
public final class C2258jg implements C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final Parcelable.Creator<C2258jg> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.jg$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable {
        public static final Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        @Nullable
        public final String Wwwwwwwwwwwwwwwwwww;
        @Nullable
        public final String Wwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final String Wwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final String Wwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.jg$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
            @Override // android.os.Parcelable.Creator
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww createFromParcel(Parcel parcel) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] newArray(int i) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwww = str3;
            this.Wwwwwwwwwwwwwwwwwww = str4;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcel parcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readString();
            this.Wwwwwwwwwwwwwwwwwwwww = parcel.readString();
            this.Wwwwwwwwwwwwwwwwwwww = parcel.readString();
            this.Wwwwwwwwwwwwwwwwwww = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class != obj.getClass()) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww && TextUtils.equals(this.Wwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww) && TextUtils.equals(this.Wwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) && TextUtils.equals(this.Wwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww) && TextUtils.equals(this.Wwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww);
        }

        public int hashCode() {
            int i = ((this.Wwwwwwwwwwwwwwwwwwwwwwww * 31) + this.Wwwwwwwwwwwwwwwwwwwwwww) * 31;
            String str = this.Wwwwwwwwwwwwwwwwwwwwww;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.Wwwwwwwwwwwwwwwwwwwww;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.Wwwwwwwwwwwwwwwwwwww;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.Wwwwwwwwwwwwwwwwwww;
            if (str4 != null) {
                i2 = str4.hashCode();
            }
            return hashCode3 + i2;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwww);
            parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwww);
            parcel.writeString(this.Wwwwwwwwwwwwwwwwwwww);
            parcel.writeString(this.Wwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: me.tvspark.jg$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2258jg> {
        @Override // android.os.Parcelable.Creator
        public C2258jg createFromParcel(Parcel parcel) {
            return new C2258jg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2258jg[] newArray(int i) {
            return new C2258jg[i];
        }
    }

    public C2258jg(Parcel parcel) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) parcel.readParcelable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getClassLoader()));
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(arrayList);
    }

    public C2258jg(@Nullable String str, @Nullable String str2, List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // me.tvspark.C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @Nullable
    public /* synthetic */ byte[] Wwwwwwwwwwwwwwwwwwwwww() {
        return C2291kc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // me.tvspark.C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @Nullable
    public /* synthetic */ C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return C2291kc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2258jg.class != obj.getClass()) {
            return false;
        }
        C2258jg c2258jg = (C2258jg) obj;
        return TextUtils.equals(this.Wwwwwwwwwwwwwwwwwwwwwwww, c2258jg.Wwwwwwwwwwwwwwwwwwwwwwww) && TextUtils.equals(this.Wwwwwwwwwwwwwwwwwwwwwww, c2258jg.Wwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwww.equals(c2258jg.Wwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return this.Wwwwwwwwwwwwwwwwwwwwww.hashCode() + ((hashCode + i) * 31);
    }

    public String toString() {
        String str;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (str2 != null) {
            String str3 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, 5)));
            sb.append(" [");
            sb.append(str2);
            sb.append(", ");
            sb.append(str3);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "";
        }
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? "HlsTrackMetadataEntry".concat(valueOf) : new String("HlsTrackMetadataEntry");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        int size = this.Wwwwwwwwwwwwwwwwwwwwww.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable(this.Wwwwwwwwwwwwwwwwwwwwww.get(i2), 0);
        }
    }
}

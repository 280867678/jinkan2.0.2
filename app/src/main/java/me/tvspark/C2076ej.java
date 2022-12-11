package me.tvspark;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import java.util.Locale;

/* renamed from: me.tvspark.ej */
/* loaded from: classes4.dex */
public class C2076ej implements Parcelable {
    public final int Wwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final C2076ej Wwwwwwwwwwwwwwwwwww = new C2076ej(null, null, 0, false, 0);
    public static final Parcelable.Creator<C2076ej> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.ej$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        @Nullable
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            CaptioningManager captioningManager;
            String locale;
            int i = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i >= 19 && ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled())) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1088;
                Locale locale2 = captioningManager.getLocale();
                if (locale2 != null) {
                    if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21) {
                        locale = locale2.toLanguageTag();
                    } else {
                        locale = locale2.toString();
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = locale;
                }
            }
            return this;
        }
    }

    /* renamed from: me.tvspark.ej$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2076ej> {
        @Override // android.os.Parcelable.Creator
        public C2076ej createFromParcel(Parcel parcel) {
            return new C2076ej(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2076ej[] newArray(int i) {
            return new C2076ej[i];
        }
    }

    public C2076ej(Parcel parcel) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel);
        this.Wwwwwwwwwwwwwwwwwwww = parcel.readInt();
    }

    public C2076ej(@Nullable String str, @Nullable String str2, int i, boolean z, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        this.Wwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        this.Wwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwww = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2076ej c2076ej = (C2076ej) obj;
        return TextUtils.equals(this.Wwwwwwwwwwwwwwwwwwwwwwww, c2076ej.Wwwwwwwwwwwwwwwwwwwwwwww) && TextUtils.equals(this.Wwwwwwwwwwwwwwwwwwwwwww, c2076ej.Wwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwww == c2076ej.Wwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwww == c2076ej.Wwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwww == c2076ej.Wwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((hashCode + i) * 31) + this.Wwwwwwwwwwwwwwwwwwwwww) * 31) + (this.Wwwwwwwwwwwwwwwwwwwww ? 1 : 0)) * 31) + this.Wwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww);
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, this.Wwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwww);
    }
}

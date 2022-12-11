package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;
import me.tvspark.C2678un;

/* renamed from: me.tvspark.yn */
/* loaded from: classes4.dex */
public class C2830yn implements C2678un.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final Parcelable.Creator<C2830yn> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final long Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.yn$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2830yn> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public C2830yn createFromParcel(@NonNull Parcel parcel) {
            return new C2830yn(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public C2830yn[] newArray(int i) {
            return new C2830yn[i];
        }
    }

    public C2830yn(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    public /* synthetic */ C2830yn(long j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.C2678un.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return j >= this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2830yn) && this.Wwwwwwwwwwwwwwwwwwwwwwww == ((C2830yn) obj).Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwww)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }
}

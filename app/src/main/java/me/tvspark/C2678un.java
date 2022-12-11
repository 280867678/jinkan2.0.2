package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;
import org.fourthline.cling.model.Constants;

/* renamed from: me.tvspark.un */
/* loaded from: classes4.dex */
public final class C2678un implements Parcelable {
    public static final Parcelable.Creator<C2678un> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final int Wwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2229io Wwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2229io Wwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2229io Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.un$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Parcelable {
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j);
    }

    /* renamed from: me.tvspark.un$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2229io.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Constants.UPNP_MULTICAST_PORT, 0).Wwwwwwwwwwwwwwwwwww);
        public static final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2229io.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2100, 11).Wwwwwwwwwwwwwwwwwww);

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C2678un c2678un) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2830yn(Long.MIN_VALUE);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2678un.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2678un.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Long.valueOf(c2678un.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2678un.Wwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* renamed from: me.tvspark.un$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2678un> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public C2678un createFromParcel(@NonNull Parcel parcel) {
            return new C2678un((C2229io) parcel.readParcelable(C2229io.class.getClassLoader()), (C2229io) parcel.readParcelable(C2229io.class.getClassLoader()), (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) parcel.readParcelable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getClassLoader()), (C2229io) parcel.readParcelable(C2229io.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public C2678un[] newArray(int i) {
            return new C2678un[i];
        }
    }

    public /* synthetic */ C2678un(C2229io c2229io, C2229io c2229io2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2229io c2229io3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c2229io;
        this.Wwwwwwwwwwwwwwwwwwwwwww = c2229io2;
        this.Wwwwwwwwwwwwwwwwwwwww = c2229io3;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2229io3 != null && c2229io.Wwwwwwwwwwwwwwwwwwwwwwww.compareTo(c2229io3.Wwwwwwwwwwwwwwwwwwwwwwww) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (c2229io3 != null && c2229io3.Wwwwwwwwwwwwwwwwwwwwwwww.compareTo(c2229io2.Wwwwwwwwwwwwwwwwwwwwwwww) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.Wwwwwwwwwwwwwwwwwww = c2229io.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2229io2) + 1;
        this.Wwwwwwwwwwwwwwwwwwww = (c2229io2.Wwwwwwwwwwwwwwwwwwwwww - c2229io.Wwwwwwwwwwwwwwwwwwwwww) + 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2678un)) {
            return false;
        }
        C2678un c2678un = (C2678un) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.equals(c2678un.Wwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwww.equals(c2678un.Wwwwwwwwwwwwwwwwwwwwwww) && ObjectsCompat.equals(this.Wwwwwwwwwwwwwwwwwwwww, c2678un.Wwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwww.equals(c2678un.Wwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.Wwwwwwwwwwwwwwwwwwwwwwww, 0);
        parcel.writeParcelable(this.Wwwwwwwwwwwwwwwwwwwwwww, 0);
        parcel.writeParcelable(this.Wwwwwwwwwwwwwwwwwwwww, 0);
        parcel.writeParcelable(this.Wwwwwwwwwwwwwwwwwwwwww, 0);
    }
}

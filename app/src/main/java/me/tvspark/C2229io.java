package me.tvspark;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* renamed from: me.tvspark.io */
/* loaded from: classes4.dex */
public final class C2229io implements Comparable<C2229io>, Parcelable {
    public static final Parcelable.Creator<C2229io> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    @Nullable
    public String Wwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final Calendar Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.io$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2229io> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public C2229io createFromParcel(@NonNull Parcel parcel) {
            return C2229io.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public C2229io[] newArray(int i) {
            return new C2229io[i];
        }
    }

    public C2229io(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(calendar);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get(2);
        this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.get(1);
        this.Wwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.getMaximum(7);
        this.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.getActualMaximum(5);
        this.Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.getTimeInMillis();
    }

    @NonNull
    public static C2229io Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(1, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(2, i2);
        return new C2229io(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @NonNull
    public static C2229io Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTimeInMillis(j);
        return new C2229io(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @NonNull
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        if (this.Wwwwwwwwwwwwwwwwww == null) {
            long timeInMillis = this.Wwwwwwwwwwwwwwwwwwwwwwww.getTimeInMillis();
            this.Wwwwwwwwwwwwwwwwww = DateUtils.formatDateTime(context, timeInMillis - TimeZone.getDefault().getOffset(timeInMillis), 36);
        }
        return this.Wwwwwwwwwwwwwwwwww;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int firstDayOfWeek = this.Wwwwwwwwwwwwwwwwwwwwwwww.get(7) - this.Wwwwwwwwwwwwwwwwwwwwwwww.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.Wwwwwwwwwwwwwwwwwwwww : firstDayOfWeek;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C2229io c2229io) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww instanceof GregorianCalendar) {
            return (c2229io.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwww) + ((c2229io.Wwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwww) * 12);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // java.lang.Comparable
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public int compareTo(@NonNull C2229io c2229io) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.compareTo(c2229io.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @NonNull
    public C2229io Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.add(2, i);
        return new C2229io(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2229io)) {
            return false;
        }
        C2229io c2229io = (C2229io) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwww == c2229io.Wwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwww == c2229io.Wwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwww), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwww)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }
}

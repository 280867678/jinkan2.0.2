package me.tvspark;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.google.common.collect.Ordering;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.AbstractC1985cj;
import me.tvspark.C2076ej;
import me.tvspark.C2751wi;

/* renamed from: me.tvspark.yi */
/* loaded from: classes4.dex */
public class C2825yi extends AbstractC1911aj {
    public final AtomicReference<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1985cj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[0];
    public static final Ordering<Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Ordering.from(C2673ui.Wwwwwwwwwwwwwwwwwwwwwwww);
    public static final Ordering<Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Ordering.from(C2711vi.Wwwwwwwwwwwwwwwwwwwwwwww);

    /* renamed from: me.tvspark.yi$Wwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparable<Wwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public final int Wwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
            if (r10 < r8.Wwwwwwwwwwww) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x005b, code lost:
            if (r10 < r8.Wwwwwwwwwww) goto L46;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x006f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i, boolean z) {
            boolean z2;
            int i2;
            int i3;
            int i4;
            int i5;
            float f;
            int i6;
            int i7;
            int i8;
            int i9;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z3 = true;
            int i10 = -1;
            if (z && (((i7 = c2245j3.Wwwwwwww) == -1 || i7 <= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww) && ((i8 = c2245j3.Wwwwwww) == -1 || i8 <= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww))) {
                float f2 = c2245j3.Wwwwww;
                if ((f2 == -1.0f || f2 <= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww) && ((i9 = c2245j3.Wwwwwwwwwwwwwwwww) == -1 || i9 <= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww)) {
                    z2 = true;
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = z2;
                    if (z && (((i4 = c2245j3.Wwwwwwww) == -1 || i4 >= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww) && ((i5 = c2245j3.Wwwwwww) == -1 || i5 >= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww))) {
                        f = c2245j3.Wwwwww;
                        if (f != -1.0f) {
                        }
                        i6 = c2245j3.Wwwwwwwwwwwwwwwww;
                        if (i6 != -1) {
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwww = z3;
                        this.Wwwwwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, false);
                        this.Wwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwww;
                        i2 = c2245j3.Wwwwwwww;
                        if (i2 != -1 && (i3 = c2245j3.Wwwwwww) != -1) {
                            i10 = i2 * i3;
                        }
                        this.Wwwwwwwwwwwwwwwwwww = i10;
                    }
                    z3 = false;
                    this.Wwwwwwwwwwwwwwwwwwwwww = z3;
                    this.Wwwwwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, false);
                    this.Wwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwww;
                    i2 = c2245j3.Wwwwwwww;
                    if (i2 != -1) {
                        i10 = i2 * i3;
                    }
                    this.Wwwwwwwwwwwwwwwwwww = i10;
                }
            }
            z2 = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = z2;
            if (z) {
                f = c2245j3.Wwwwww;
                if (f != -1.0f) {
                }
                i6 = c2245j3.Wwwwwwwwwwwwwwwww;
                if (i6 != -1) {
                }
                this.Wwwwwwwwwwwwwwwwwwwwww = z3;
                this.Wwwwwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, false);
                this.Wwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwww;
                i2 = c2245j3.Wwwwwwww;
                if (i2 != -1) {
                }
                this.Wwwwwwwwwwwwwwwwwww = i10;
            }
            z3 = false;
            this.Wwwwwwwwwwwwwwwwwwwwww = z3;
            this.Wwwwwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, false);
            this.Wwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwww;
            i2 = c2245j3.Wwwwwwww;
            if (i2 != -1) {
            }
            this.Wwwwwwwwwwwwwwwwwww = i10;
        }

        @Override // java.lang.Comparable
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public int compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Object reverse;
            Ordering<Integer> ordering;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwww) {
                reverse = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                reverse = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.reverse();
            }
            AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractC2800xu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww);
            Integer valueOf = Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwww);
            Integer valueOf2 = Integer.valueOf(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww);
            if (this.Wwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkk) {
                ordering = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.reverse();
            } else {
                ordering = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueOf, valueOf2, ordering).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.valueOf(this.Wwwwwwwwwwwwwwwwwww), Integer.valueOf(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww), reverse).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwww), Integer.valueOf(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww), reverse).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* renamed from: me.tvspark.yi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparable<Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public final boolean Wwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i, @Nullable String str) {
            boolean z = false;
            this.Wwwwwwwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, false);
            int i2 = c2245j3.Wwwwwwwwwwwwwwwwwwwww & (~wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwww = (i2 & 1) != 0;
            this.Wwwwwwwwwwwwwwwwwwwww = (i2 & 2) != 0;
            this.Wwwwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwww = Integer.bitCount(c2245j3.Wwwwwwwwwwwwwwwwwwww & wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwww = (c2245j3.Wwwwwwwwwwwwwwwwwwww & 1088) != 0;
            this.Wwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, str, C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) == null);
            if (this.Wwwwwwwwwwwwwwwwwwww > 0 || ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww == null && this.Wwwwwwwwwwwwwwwwwww > 0) || this.Wwwwwwwwwwwwwwwwwwwwww || (this.Wwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwww > 0))) {
                z = true;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // java.lang.Comparable
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public int compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractC2800xu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Boolean.valueOf(this.Wwwwwwwwwwwwwwwwwwwww), Boolean.valueOf(wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwww == 0 ? Ordering.natural() : Ordering.natural().reverse()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww);
            if (this.Wwwwwwwwwwwwwwwwwww == 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* renamed from: me.tvspark.yi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable {
        public static final Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public final int Wwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwww;
        public final int[] Wwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.yi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
            @Override // android.os.Parcelable.Creator
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww createFromParcel(Parcel parcel) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] newArray(int i) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcel parcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            int readByte = parcel.readByte();
            this.Wwwwwwwwwwwwwwwwwwwwww = readByte;
            int[] iArr = new int[readByte];
            this.Wwwwwwwwwwwwwwwwwwwwwww = iArr;
            parcel.readIntArray(iArr);
            this.Wwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwww = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class != obj.getClass()) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwww) + (this.Wwwwwwwwwwwwwwwwwwwwwwww * 31)) * 31) + this.Wwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwww;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwww.length);
            parcel.writeIntArray(this.Wwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: me.tvspark.yi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2076ej.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final SparseBooleanArray Wwwwwwww;
        public final SparseArray<Map<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww>> Wwwwwwwww;
        public int Wwwwwwwwww;
        public boolean Wwwwwwwwwww;
        public boolean Wwwwwwwwwwww;
        public boolean Wwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @Deprecated
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwww = new SparseArray<>();
            this.Wwwwwwww = new SparseBooleanArray();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwww = new SparseArray<>();
            this.Wwwwwwww = new SparseBooleanArray();
            Point Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
            int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.x;
            int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.y;
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwww = true;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE;
            this.Wwwwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE;
            this.Wwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE;
            this.Wwwwwwwwwwwwwwwwww = Integer.MAX_VALUE;
            this.Wwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwww = false;
            this.Wwwwwwwwwwww = false;
            this.Wwwwwwwwwww = true;
            this.Wwwwwwwwww = 0;
        }

        @Override // me.tvspark.C2076ej.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public C2076ej.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
            return this;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, 0, 0, 0, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwww, this.Wwwwwwwwwwww, this.Wwwwwwwwwww, this.Wwwwwwwwww, this.Wwwwwwwww, this.Wwwwwwww);
        }
    }

    /* renamed from: me.tvspark.yi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2076ej {
        public static final Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public final SparseBooleanArray Kkkkkkkkkkkkkkkkk;
        public final SparseArray<Map<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww>> Kkkkkkkkkkkkkkkkkk;
        public final int Kkkkkkkkkkkkkkkkkkk;
        public final boolean Kkkkkkkkkkkkkkkkkkkk;
        public final boolean Kkkkkkkkkkkkkkkkkkkkk;
        public final boolean Kkkkkkkkkkkkkkkkkkkkkk;
        public final boolean Kkkkkkkkkkkkkkkkkkkkkkk;
        public final boolean Kkkkkkkkkkkkkkkkkkkkkkkk;
        public final boolean Kkkkkkkkkkkkkkkkkkkkkkkkk;
        public final boolean Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        public final int Www;
        public final int Wwww;
        public final boolean Wwwww;
        public final int Wwwwww;
        public final int Wwwwwww;
        public final boolean Wwwwwwww;
        public final boolean Wwwwwwwww;
        public final boolean Wwwwwwwwww;
        public final int Wwwwwwwwwww;
        public final int Wwwwwwwwwwww;
        public final int Wwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.yi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
            @Override // android.os.Parcelable.Creator
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww createFromParcel(Parcel parcel) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] newArray(int i) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            }
        }

        static {
            new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2, boolean z3, int i9, int i10, boolean z4, @Nullable String str, int i11, int i12, boolean z5, boolean z6, boolean z7, boolean z8, @Nullable String str2, int i13, boolean z9, int i14, boolean z10, boolean z11, boolean z12, int i15, SparseArray<Map<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww>> sparseArray, SparseBooleanArray sparseBooleanArray) {
            super(str, str2, i13, z9, i14);
            this.Wwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwww = i3;
            this.Wwwwwwwwwwwwwww = i4;
            this.Wwwwwwwwwwwwww = i5;
            this.Wwwwwwwwwwwww = i6;
            this.Wwwwwwwwwwww = i7;
            this.Wwwwwwwwwww = i8;
            this.Wwwwwwwwww = z;
            this.Wwwwwwwww = z2;
            this.Wwwwwwww = z3;
            this.Wwwwwww = i9;
            this.Wwwwww = i10;
            this.Wwwww = z4;
            this.Wwww = i11;
            this.Www = i12;
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = z5;
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk = z6;
            this.Kkkkkkkkkkkkkkkkkkkkkkkk = z7;
            this.Kkkkkkkkkkkkkkkkkkkkkkk = z8;
            this.Kkkkkkkkkkkkkkkkkkkkkk = z10;
            this.Kkkkkkkkkkkkkkkkkkkkk = z11;
            this.Kkkkkkkkkkkkkkkkkkkk = z12;
            this.Kkkkkkkkkkkkkkkkkkk = i15;
            this.Kkkkkkkkkkkkkkkkkk = sparseArray;
            this.Kkkkkkkkkkkkkkkkk = sparseBooleanArray;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcel parcel) {
            super(parcel);
            this.Wwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwww = parcel.readInt();
            boolean z = true;
            this.Wwwwwwwwww = parcel.readInt() != 0;
            this.Wwwwwwwww = parcel.readInt() != 0;
            this.Wwwwwwww = parcel.readInt() != 0;
            this.Wwwwwww = parcel.readInt();
            this.Wwwwww = parcel.readInt();
            this.Wwwww = parcel.readInt() != 0;
            this.Wwww = parcel.readInt();
            this.Www = parcel.readInt();
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = parcel.readInt() != 0;
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk = parcel.readInt() != 0;
            this.Kkkkkkkkkkkkkkkkkkkkkkkk = parcel.readInt() != 0;
            this.Kkkkkkkkkkkkkkkkkkkkkkk = parcel.readInt() != 0;
            this.Kkkkkkkkkkkkkkkkkkkkkk = parcel.readInt() != 0;
            this.Kkkkkkkkkkkkkkkkkkkkk = parcel.readInt() != 0;
            this.Kkkkkkkkkkkkkkkkkkkk = parcel.readInt() == 0 ? false : z;
            this.Kkkkkkkkkkkkkkkkkkk = parcel.readInt();
            int readInt = parcel.readInt();
            SparseArray<Map<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww>> sparseArray = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i2 = 0; i2 < readInt3; i2++) {
                    C2368mf c2368mf = (C2368mf) parcel.readParcelable(C2368mf.class.getClassLoader());
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2368mf);
                    hashMap.put(c2368mf, (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) parcel.readParcelable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            this.Kkkkkkkkkkkkkkkkkk = sparseArray;
            this.Kkkkkkkkkkkkkkkkk = parcel.readSparseBooleanArray();
        }

        public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.C2076ej, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:63:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0136 A[LOOP:0: B:69:0x00df->B:86:0x0136, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x00dc A[SYNTHETIC] */
        @Override // me.tvspark.C2076ej
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean equals(@Nullable Object obj) {
            boolean z;
            boolean z2;
            boolean z3;
            if (this == obj) {
                return true;
            }
            if (obj == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class != obj.getClass()) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            if (super.equals(obj) && this.Wwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww && this.Wwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww && this.Wwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww && this.Wwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww && this.Wwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww && this.Wwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww && this.Wwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwww && this.Wwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww && this.Wwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwww && this.Wwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwww && this.Wwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwww && this.Wwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwww && this.Www == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Www && this.Kkkkkkkkkkkkkkkkkkkkkkkkkk == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkkk && this.Kkkkkkkkkkkkkkkkkkkkkkkkk == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkk && this.Kkkkkkkkkkkkkkkkkkkkkkkk == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkk && this.Kkkkkkkkkkkkkkkkkkkkkkk == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkk && this.Kkkkkkkkkkkkkkkkkkkkkk == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkk && this.Kkkkkkkkkkkkkkkkkkkkk == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkk && this.Kkkkkkkkkkkkkkkkkkkk == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkk && this.Kkkkkkkkkkkkkkkkkkk == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkk) {
                SparseBooleanArray sparseBooleanArray = this.Kkkkkkkkkkkkkkkkk;
                SparseBooleanArray sparseBooleanArray2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkk;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    for (int i = 0; i < size; i++) {
                        if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) >= 0) {
                        }
                    }
                    z = true;
                    if (z) {
                        SparseArray<Map<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww>> sparseArray = this.Kkkkkkkkkkkkkkkkkk;
                        SparseArray<Map<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww>> sparseArray2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkk;
                        int size2 = sparseArray.size();
                        if (sparseArray2.size() == size2) {
                            for (int i2 = 0; i2 < size2; i2++) {
                                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                if (indexOfKey >= 0) {
                                    Map<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> valueAt = sparseArray.valueAt(i2);
                                    Map<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> valueAt2 = sparseArray2.valueAt(indexOfKey);
                                    if (valueAt2.size() == valueAt.size()) {
                                        for (Map.Entry<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> entry : valueAt.entrySet()) {
                                            C2368mf key = entry.getKey();
                                            if (valueAt2.containsKey(key)) {
                                                if (!C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry.getValue(), valueAt2.get(key))) {
                                                }
                                            }
                                        }
                                        z3 = true;
                                        if (!z3) {
                                        }
                                    }
                                    z3 = false;
                                    if (!z3) {
                                    }
                                }
                            }
                            z2 = true;
                            if (!z2) {
                                return true;
                            }
                        }
                        z2 = false;
                        if (!z2) {
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }
            return false;
        }

        @Override // me.tvspark.C2076ej
        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.Wwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwww) * 31) + this.Wwwwwwwwwww) * 31) + (this.Wwwwwwwwww ? 1 : 0)) * 31) + (this.Wwwwwwwww ? 1 : 0)) * 31) + (this.Wwwwwwww ? 1 : 0)) * 31) + (this.Wwwww ? 1 : 0)) * 31) + this.Wwwwwww) * 31) + this.Wwwwww) * 31) + this.Wwww) * 31) + this.Www) * 31) + (this.Kkkkkkkkkkkkkkkkkkkkkkkkkk ? 1 : 0)) * 31) + (this.Kkkkkkkkkkkkkkkkkkkkkkkkk ? 1 : 0)) * 31) + (this.Kkkkkkkkkkkkkkkkkkkkkkkk ? 1 : 0)) * 31) + (this.Kkkkkkkkkkkkkkkkkkkkkkk ? 1 : 0)) * 31) + (this.Kkkkkkkkkkkkkkkkkkkkkk ? 1 : 0)) * 31) + (this.Kkkkkkkkkkkkkkkkkkkkk ? 1 : 0)) * 31) + (this.Kkkkkkkkkkkkkkkkkkkk ? 1 : 0)) * 31) + this.Kkkkkkkkkkkkkkkkkkk;
        }

        @Override // me.tvspark.C2076ej, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww);
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, this.Wwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwww ? 1 : 0);
            parcel.writeInt(this.Wwwwwwwww ? 1 : 0);
            parcel.writeInt(this.Wwwwwwww ? 1 : 0);
            parcel.writeInt(this.Wwwwwww);
            parcel.writeInt(this.Wwwwww);
            parcel.writeInt(this.Wwwww ? 1 : 0);
            parcel.writeInt(this.Wwww);
            parcel.writeInt(this.Www);
            parcel.writeInt(this.Kkkkkkkkkkkkkkkkkkkkkkkkkk ? 1 : 0);
            parcel.writeInt(this.Kkkkkkkkkkkkkkkkkkkkkkkkk ? 1 : 0);
            parcel.writeInt(this.Kkkkkkkkkkkkkkkkkkkkkkkk ? 1 : 0);
            parcel.writeInt(this.Kkkkkkkkkkkkkkkkkkkkkkk ? 1 : 0);
            parcel.writeInt(this.Kkkkkkkkkkkkkkkkkkkkkk ? 1 : 0);
            parcel.writeInt(this.Kkkkkkkkkkkkkkkkkkkkk ? 1 : 0);
            parcel.writeInt(this.Kkkkkkkkkkkkkkkkkkkk ? 1 : 0);
            parcel.writeInt(this.Kkkkkkkkkkkkkkkkkkk);
            SparseArray<Map<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww>> sparseArray = this.Kkkkkkkkkkkkkkkkkk;
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = sparseArray.keyAt(i2);
                Map<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> valueAt = sparseArray.valueAt(i2);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry<C2368mf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> entry : valueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
            parcel.writeSparseBooleanArray(this.Kkkkkkkkkkkkkkkkk);
        }
    }

    /* renamed from: me.tvspark.yi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparable<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = (c2245j3.Wwwwwwwwwwwwwwwwwwwww & 1) == 0 ? false : true;
            this.Wwwwwwwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, false);
        }

        @Override // java.lang.Comparable
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public int compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return AbstractC2800xu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* renamed from: me.tvspark.yi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparable<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public final int Wwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final String Wwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i) {
            int i2;
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwwwwwwwwwwww);
            int i3 = 0;
            this.Wwwwwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, false);
            this.Wwwwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, false);
            boolean z = true;
            this.Wwwwwwwwwwwwwwwww = (c2245j3.Wwwwwwwwwwwwwwwwwwwww & 1) != 0;
            this.Wwwwwwwwwwwwwwww = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk;
            this.Wwwwwwwwwwwwwww = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk;
            int i4 = c2245j3.Wwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwww = i4;
            if ((i4 != -1 && i4 > wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Www) || ((i2 = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk) != -1 && i2 > wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwww)) {
                z = false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
            String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i5 = Integer.MAX_VALUE;
            int i6 = 0;
            while (true) {
                if (i6 >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
                    break;
                }
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i6], false);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                    i5 = i6;
                    i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    break;
                }
                i6++;
            }
            this.Wwwwwwwwwwwwwwwwwww = i5;
            this.Wwwwwwwwwwwwwwwwww = i3;
        }

        @Override // java.lang.Comparable
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public int compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Object reverse;
            Ordering<Integer> ordering;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwww) {
                reverse = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                reverse = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.reverse();
            }
            AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractC2800xu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
            Integer valueOf = Integer.valueOf(this.Wwwwwwwwwwwwww);
            Integer valueOf2 = Integer.valueOf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww);
            if (this.Wwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkk) {
                ordering = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.reverse();
            } else {
                ordering = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueOf, valueOf2, ordering).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.valueOf(this.Wwwwwwwwwwwwwwwwwww), Integer.valueOf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww), Ordering.natural().reverse()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.valueOf(this.Wwwwwwwwwwwwwwww), Integer.valueOf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww), reverse).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.valueOf(this.Wwwwwwwwwwwwwww), Integer.valueOf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww), reverse);
            Integer valueOf3 = Integer.valueOf(this.Wwwwwwwwwwwwww);
            Integer valueOf4 = Integer.valueOf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww);
            if (!C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwww, (Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww)) {
                reverse = C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueOf3, valueOf4, reverse).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public C2825yi(Context context) {
        C2751wi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2751wi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer num, Integer num2) {
        return 0;
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        } else if (num2.intValue() != -1) {
            return num.intValue() - num2.intValue();
        } else {
            return 1;
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, @Nullable String str, boolean z) {
        if (TextUtils.isEmpty(str) || !str.equals(c2245j3.Wwwwwwwwwwwwwwwwwwwwww)) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                return (!z || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) ? 0 : 1;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                return 3;
            } else {
                return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, "-")[0].equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.split("-", 2)[0]) ? 2 : 0;
            }
        }
        return 4;
    }

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 4 || (z && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 3);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, @Nullable String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if ((c2245j3.Wwwwwwwwwwwwwwwwwwww & 16384) == 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, false) && (i & i2) != 0) {
            if (str != null && !C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) c2245j3.Wwwwwwwwwwwww, (Object) str)) {
                return false;
            }
            int i11 = c2245j3.Wwwwwwww;
            if (i11 != -1 && (i7 > i11 || i11 > i3)) {
                return false;
            }
            int i12 = c2245j3.Wwwwwww;
            if (i12 != -1 && (i8 > i12 || i12 > i4)) {
                return false;
            }
            float f = c2245j3.Wwwwww;
            if (f != -1.0f && (i9 > f || f > i5)) {
                return false;
            }
            int i13 = c2245j3.Wwwwwwwwwwwwwwwww;
            return i13 == -1 || (i10 <= i13 && i13 <= i6);
        }
        return false;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[][] iArr, C2368mf c2368mf, AbstractC1985cj abstractC1985cj) {
        if (abstractC1985cj == null) {
            return false;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2368mf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1985cj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        for (int i = 0; i < abstractC1985cj.length(); i++) {
            if (C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2][abstractC1985cj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)]) != 32) {
                return false;
            }
        }
        return true;
    }

    public C2825yi(Context context, AbstractC1985cj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2331lf c2331lf, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        Point point;
        int i7;
        int i8;
        ArrayList arrayList = new ArrayList(c2331lf.Wwwwwwwwwwwwwwwwwwwwwwww);
        for (int i9 = 0; i9 < c2331lf.Wwwwwwwwwwwwwwwwwwwwwwww; i9++) {
            arrayList.add(Integer.valueOf(i9));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i10 = 0;
            int i11 = Integer.MAX_VALUE;
            while (true) {
                boolean z2 = true;
                if (i10 >= c2331lf.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    break;
                }
                C2245j3 c2245j3 = c2331lf.Wwwwwwwwwwwwwwwwwwwwwww[i10];
                int i12 = c2245j3.Wwwwwwww;
                if (i12 > 0 && (i4 = c2245j3.Wwwwwww) > 0) {
                    if (z) {
                        boolean z3 = i12 > i4;
                        if (i <= i2) {
                            z2 = false;
                        }
                        if (z3 != z2) {
                            i6 = i;
                            i5 = i2;
                            int i13 = i12 * i6;
                            int i14 = i4 * i5;
                            point = i13 < i14 ? new Point(i5, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i14, i12)) : new Point(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i13, i4), i6);
                            i7 = c2245j3.Wwwwwwww;
                            int i15 = c2245j3.Wwwwwww;
                            i8 = i7 * i15;
                            if (i7 >= ((int) (point.x * 0.98f)) && i15 >= ((int) (point.y * 0.98f)) && i8 < i11) {
                                i11 = i8;
                            }
                        }
                    }
                    i5 = i;
                    i6 = i2;
                    int i132 = i12 * i6;
                    int i142 = i4 * i5;
                    if (i132 < i142) {
                    }
                    i7 = c2245j3.Wwwwwwww;
                    int i152 = c2245j3.Wwwwwww;
                    i8 = i7 * i152;
                    if (i7 >= ((int) (point.x * 0.98f))) {
                        i11 = i8;
                    }
                }
                i10++;
            }
            if (i11 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    C2245j3 c2245j32 = c2331lf.Wwwwwwwwwwwwwwwwwwwwwww[((Integer) arrayList.get(size)).intValue()];
                    int i16 = c2245j32.Wwwwwwww;
                    int i17 = (i16 == -1 || (i3 = c2245j32.Wwwwwww) == -1) ? -1 : i16 * i3;
                    if (i17 == -1 || i17 > i11) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }
}

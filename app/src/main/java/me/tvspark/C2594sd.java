package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: me.tvspark.sd */
/* loaded from: classes4.dex */
public final class C2594sd extends AbstractC2520qd {
    public static final Parcelable.Creator<C2594sd> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final int Wwwwwwwwwwww;
    public final int Wwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwww;
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.sd$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
        }
    }

    /* renamed from: me.tvspark.sd$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2594sd> {
        @Override // android.os.Parcelable.Creator
        public C2594sd createFromParcel(Parcel parcel) {
            return new C2594sd(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public C2594sd[] newArray(int i) {
            return new C2594sd[i];
        }
    }

    public C2594sd(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list, boolean z5, long j4, int i, int i2, int i3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwww = z2;
        this.Wwwwwwwwwwwwwwwwwwwww = z3;
        this.Wwwwwwwwwwwwwwwwwwww = z4;
        this.Wwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwww = j3;
        this.Wwwwwwwwwwwwwwwww = Collections.unmodifiableList(list);
        this.Wwwwwwwwwwwwwwww = z5;
        this.Wwwwwwwwwwwwwww = j4;
        this.Wwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwww = i3;
    }

    public /* synthetic */ C2594sd(Parcel parcel, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readLong();
        boolean z = false;
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readByte() == 1;
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readByte() == 1;
        this.Wwwwwwwwwwwwwwwwwwwww = parcel.readByte() == 1;
        this.Wwwwwwwwwwwwwwwwwwww = parcel.readByte() == 1;
        this.Wwwwwwwwwwwwwwwwwww = parcel.readLong();
        this.Wwwwwwwwwwwwwwwwww = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.Wwwwwwwwwwwwwwwww = Collections.unmodifiableList(arrayList);
        this.Wwwwwwwwwwwwwwww = parcel.readByte() == 1 ? true : z;
        this.Wwwwwwwwwwwwwww = parcel.readLong();
        this.Wwwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwwww = parcel.readInt();
        this.Wwwwwwwwwwww = parcel.readInt();
    }

    public static C2594sd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, long j, C2337ll c2337ll) {
        List list;
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        int i;
        int i2;
        int i3;
        boolean z4;
        boolean z5;
        long j4;
        long Wwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwww();
        boolean z6 = (c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (!z6) {
            int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            boolean z7 = (Wwwwwwwwwwwwwwwwwwwwww & 128) != 0;
            boolean z8 = (Wwwwwwwwwwwwwwwwwwwwww & 64) != 0;
            boolean z9 = (Wwwwwwwwwwwwwwwwwwwwww & 32) != 0;
            boolean z10 = (Wwwwwwwwwwwwwwwwwwwwww & 16) != 0;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (!z8 || z10) ? -9223372036854775807L : C2706vd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, j);
            if (!z8) {
                int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                ArrayList arrayList = new ArrayList(Wwwwwwwwwwwwwwwwwwwwww2);
                for (int i4 = 0; i4 < Wwwwwwwwwwwwwwwwwwwwww2; i4++) {
                    int Wwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = !z10 ? C2706vd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, j) : -9223372036854775807L;
                    arrayList.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, c2337ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3), null));
                }
                emptyList = arrayList;
            }
            if (z9) {
                long Wwwwwwwwwwwwwwwwwwwwww4 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                boolean z11 = (128 & Wwwwwwwwwwwwwwwwwwwwww4) != 0;
                j4 = ((((Wwwwwwwwwwwwwwwwwwwwww4 & 1) << 32) | c2078el.Wwwwwwwwwwwwwwwwwwwww()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
                j4 = -9223372036854775807L;
            }
            i = c2078el.Wwwwwwwwwwwwwwwww();
            z4 = z8;
            i2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            i3 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            list = emptyList;
            long j5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            z3 = z5;
            j3 = j4;
            z2 = z10;
            z = z7;
            j2 = j5;
        } else {
            list = emptyList;
            z = false;
            z2 = false;
            j2 = -9223372036854775807L;
            z3 = false;
            j3 = -9223372036854775807L;
            i = 0;
            i2 = 0;
            i3 = 0;
            z4 = false;
        }
        return new C2594sd(Wwwwwwwwwwwwwwwwwwwww, z6, z, z4, z2, j2, c2337ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2), list, z3, j3, i, i2, i3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeByte(this.Wwwwwwwwwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.Wwwwwwwwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.Wwwwwwwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.Wwwwwwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwwww);
        parcel.writeLong(this.Wwwwwwwwwwwwwwwwww);
        int size = this.Wwwwwwwwwwwwwwwww.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww.get(i2);
            parcel.writeInt(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeLong(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeLong(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        parcel.writeByte(this.Wwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.Wwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwww);
    }
}

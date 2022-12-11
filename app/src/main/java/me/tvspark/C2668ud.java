package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: me.tvspark.ud */
/* loaded from: classes4.dex */
public final class C2668ud extends AbstractC2520qd {
    public static final Parcelable.Creator<C2668ud> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.ud$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z, boolean z2, boolean z3, List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(list);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = z4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i3;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcel parcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parcel.readLong();
            boolean z = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parcel.readByte() == 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parcel.readByte() == 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel.readInt(), parcel.readLong()));
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(arrayList);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parcel.readLong();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = parcel.readByte() == 1 ? true : z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = parcel.readLong();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        }
    }

    /* renamed from: me.tvspark.ud$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        }
    }

    /* renamed from: me.tvspark.ud$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2668ud> {
        @Override // android.os.Parcelable.Creator
        public C2668ud createFromParcel(Parcel parcel) {
            return new C2668ud(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public C2668ud[] newArray(int i) {
            return new C2668ud[i];
        }
    }

    public /* synthetic */ C2668ud(Parcel parcel, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(arrayList);
    }

    public C2668ud(List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(list);
    }

    public static C2668ud Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        int i;
        ArrayList arrayList;
        boolean z;
        boolean z2;
        long j;
        boolean z3;
        long j2;
        int i2;
        int i3;
        int i4;
        boolean z4;
        boolean z5;
        long j3;
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        ArrayList arrayList2 = new ArrayList(Wwwwwwwwwwwwwwwwwwwwww);
        int i5 = 0;
        while (i5 < Wwwwwwwwwwwwwwwwwwwwww) {
            long Wwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwww();
            boolean z6 = (c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 128) != 0;
            ArrayList arrayList3 = new ArrayList();
            if (!z6) {
                int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                boolean z7 = (Wwwwwwwwwwwwwwwwwwwwww2 & 128) != 0;
                boolean z8 = (Wwwwwwwwwwwwwwwwwwwwww2 & 64) != 0;
                boolean z9 = (Wwwwwwwwwwwwwwwwwwwwww2 & 32) != 0;
                long Wwwwwwwwwwwwwwwwwwwww2 = z8 ? c2078el.Wwwwwwwwwwwwwwwwwwwww() : -9223372036854775807L;
                if (!z8) {
                    int Wwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                    ArrayList arrayList4 = new ArrayList(Wwwwwwwwwwwwwwwwwwwwww3);
                    int i6 = 0;
                    while (i6 < Wwwwwwwwwwwwwwwwwwwwww3) {
                        arrayList4.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwww(), c2078el.Wwwwwwwwwwwwwwwwwwwww(), null));
                        i6++;
                        z7 = z7;
                        z8 = z8;
                        Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwww3;
                    }
                    i = Wwwwwwwwwwwwwwwwwwwwww;
                    z2 = z7;
                    z4 = z8;
                    arrayList3 = arrayList4;
                } else {
                    i = Wwwwwwwwwwwwwwwwwwwwww;
                    z2 = z7;
                    z4 = z8;
                }
                if (z9) {
                    long Wwwwwwwwwwwwwwwwwwwwww4 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                    z5 = (Wwwwwwwwwwwwwwwwwwwwww4 & 128) != 0;
                    j3 = ((((Wwwwwwwwwwwwwwwwwwwwww4 & 1) << 32) | c2078el.Wwwwwwwwwwwwwwwwwwwww()) * 1000) / 90;
                } else {
                    z5 = false;
                    j3 = -9223372036854775807L;
                }
                i2 = c2078el.Wwwwwwwwwwwwwwwww();
                arrayList = arrayList3;
                z3 = z5;
                j = Wwwwwwwwwwwwwwwwwwwww2;
                j2 = j3;
                i3 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                i4 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                z = z4;
            } else {
                i = Wwwwwwwwwwwwwwwwwwwwww;
                arrayList = arrayList3;
                z = false;
                z2 = false;
                j = -9223372036854775807L;
                z3 = false;
                j2 = -9223372036854775807L;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            arrayList2.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwww, z6, z2, z, arrayList, j, z3, j2, i2, i3, i4));
            i5++;
            Wwwwwwwwwwwwwwwwwwwwww = i;
        }
        return new C2668ud(arrayList2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.Wwwwwwwwwwwwwwwwwwwwwwww.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i2);
            parcel.writeLong(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeByte(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
            parcel.writeByte(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
            parcel.writeByte(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
            int size2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            parcel.writeInt(size2);
            for (int i3 = 0; i3 < size2; i3++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i3);
                parcel.writeInt(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                parcel.writeLong(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            parcel.writeLong(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeByte(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
            parcel.writeLong(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}

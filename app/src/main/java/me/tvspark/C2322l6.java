package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* renamed from: me.tvspark.l6 */
/* loaded from: classes4.dex */
public final class C2322l6 implements Comparator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww>, Parcelable {
    public static final Parcelable.Creator<C2322l6> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final int Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.l6$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable {
        public static final Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        @Nullable
        public final byte[] Wwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final String Wwwwwwwwwwwwwwwwwwwwww;
        public final UUID Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.l6$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
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

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcel parcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = new UUID(parcel.readLong(), parcel.readLong());
            this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readString();
            String readString = parcel.readString();
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readString);
            this.Wwwwwwwwwwwwwwwwwwwww = readString;
            this.Wwwwwwwwwwwwwwwwwwww = parcel.createByteArray();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UUID uuid, @Nullable String str, String str2, @Nullable byte[] bArr) {
            if (uuid != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = uuid;
                this.Wwwwwwwwwwwwwwwwwwwwww = str;
                if (str2 == null) {
                    throw null;
                }
                this.Wwwwwwwwwwwwwwwwwwwww = str2;
                this.Wwwwwwwwwwwwwwwwwwww = bArr;
                return;
            }
            throw null;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UUID uuid) {
            return C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwwwwwwwwwwwwwwwwwwwwww) || uuid.equals(this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwww, (Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwww, (Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww);
        }

        public int hashCode() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww == 0) {
                int hashCode = this.Wwwwwwwwwwwwwwwwwwwwwww.hashCode() * 31;
                String str = this.Wwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwww) + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, (hashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.Wwwwwwwwwwwwwwwwwwwwwww.getMostSignificantBits());
            parcel.writeLong(this.Wwwwwwwwwwwwwwwwwwwwwww.getLeastSignificantBits());
            parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwww);
            parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwww);
            parcel.writeByteArray(this.Wwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: me.tvspark.l6$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<C2322l6> {
        @Override // android.os.Parcelable.Creator
        public C2322l6 createFromParcel(Parcel parcel) {
            return new C2322l6(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C2322l6[] newArray(int i) {
            return new C2322l6[i];
        }
    }

    public C2322l6(Parcel parcel) {
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) parcel.createTypedArray(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.CREATOR);
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2;
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2.length;
    }

    public C2322l6(@Nullable String str, boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww... wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
        this.Wwwwwwwwwwwwwwwwwwwwww = str;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = z ? (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.clone() : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length;
        Arrays.sort(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr, this);
    }

    @Nullable
    public static C2322l6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2322l6 c2322l6, @Nullable C2322l6 c2322l62) {
        String str;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
        boolean z;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2;
        ArrayList arrayList = new ArrayList();
        if (c2322l6 != null) {
            str = c2322l6.Wwwwwwwwwwwwwwwwwwwwww;
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : c2322l6.Wwwwwwwwwwwwwwwwwwwwwwww) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww != null) {
                    arrayList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        } else {
            str = null;
        }
        if (c2322l62 != null) {
            if (str == null) {
                str = c2322l62.Wwwwwwwwwwwwwwwwwwwwww;
            }
            int size = arrayList.size();
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : c2322l62.Wwwwwwwwwwwwwwwwwwwwwwww) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww != null) {
                    UUID uuid = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww;
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            break;
                        } else if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayList.get(i)).Wwwwwwwwwwwwwwwwwwwwwww.equals(uuid)) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (!z) {
                        arrayList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new C2322l6(str, false, (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) arrayList.toArray(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0]));
    }

    public C2322l6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwww, (Object) str) ? this : new C2322l6(str, false, this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // java.util.Comparator
    public int compare(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        return C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww) ? C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww) ? 0 : 1 : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww.compareTo(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2322l6.class != obj.getClass()) {
            return false;
        }
        C2322l6 c2322l6 = (C2322l6) obj;
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwww, (Object) c2322l6.Wwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwww, c2322l6.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == 0) {
            String str = this.Wwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwww);
        parcel.writeTypedArray(this.Wwwwwwwwwwwwwwwwwwwwwwww, 0);
    }
}

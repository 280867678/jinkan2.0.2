package me.tvspark;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.jp */
/* loaded from: classes4.dex */
public class C2267jp extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<C2267jp> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.jp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.ClassLoaderCreator<C2267jp> {
        @Override // android.os.Parcelable.Creator
        @Nullable
        public Object createFromParcel(@NonNull Parcel parcel) {
            return new C2267jp(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public Object[] newArray(int i) {
            return new C2267jp[i];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        @NonNull
        public C2267jp createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new C2267jp(parcel, classLoader);
        }
    }

    public C2267jp() {
    }

    public C2267jp(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        for (int i = 0; i < readInt; i++) {
            put(iArr[i], readParcelableArray[i]);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = keyAt(i2);
            parcelableArr[i2] = valueAt(i2);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i);
    }
}

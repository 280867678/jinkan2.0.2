package androidx.core.p003os;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* renamed from: androidx.core.os.ParcelableCompat */
/* loaded from: classes3.dex */
public final class ParcelableCompat {

    /* renamed from: androidx.core.os.ParcelableCompat$ParcelableCompatCreatorHoneycombMR2 */
    /* loaded from: classes3.dex */
    public static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
        public final ParcelableCompatCreatorCallbacks<T> mCallbacks;

        public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
            this.mCallbacks = parcelableCompatCreatorCallbacks;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            return this.mCallbacks.createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.mCallbacks.createFromParcel(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i) {
            return this.mCallbacks.newArray(i);
        }
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return new ParcelableCompatCreatorHoneycombMR2(parcelableCompatCreatorCallbacks);
    }
}

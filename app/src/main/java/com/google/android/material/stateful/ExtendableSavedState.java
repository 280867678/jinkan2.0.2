package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    @NonNull
    public final SimpleArrayMap<String, Bundle> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        @Override // android.os.Parcelable.Creator
        @Nullable
        public Object createFromParcel(@NonNull Parcel parcel) {
            return new ExtendableSavedState(parcel, null, null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public Object[] newArray(int i) {
            return new ExtendableSavedState[i];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        @NonNull
        public ExtendableSavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader, null);
        }
    }

    public /* synthetic */ ExtendableSavedState(Parcel parcel, ClassLoader classLoader, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new SimpleArrayMap<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.put(strArr[i], bundleArr[i]);
        }
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new SimpleArrayMap<>();
    }

    @NonNull
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ExtendableSavedState{");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Integer.toHexString(System.identityHashCode(this)));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" states=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("}");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.Wwwwwwwwwwwwwwwwwwwwwwww.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.Wwwwwwwwwwwwwwwwwwwwwwww.keyAt(i2);
            bundleArr[i2] = this.Wwwwwwwwwwwwwwwwwwwwwwww.valueAt(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}

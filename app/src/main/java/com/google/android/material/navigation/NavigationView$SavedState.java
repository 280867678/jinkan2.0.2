package com.google.android.material.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;

/* loaded from: classes3.dex */
public class NavigationView$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<NavigationView$SavedState> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    @Nullable
    public Bundle Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.ClassLoaderCreator<NavigationView$SavedState> {
        @Override // android.os.Parcelable.Creator
        @Nullable
        public Object createFromParcel(@NonNull Parcel parcel) {
            return new NavigationView$SavedState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public Object[] newArray(int i) {
            return new NavigationView$SavedState[i];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        @NonNull
        public NavigationView$SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new NavigationView$SavedState(parcel, classLoader);
        }
    }

    public NavigationView$SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        super(parcel, classLoader);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readBundle(classLoader);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }
}

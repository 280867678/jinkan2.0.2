package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0049R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    public static final int[] Wwwwwwwwwwwwwwwwwwwww = {16842912};
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbsSavedState {
        public static final Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.ClassLoaderCreator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, classLoader);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt() != 1 ? false : true;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AccessibilityDelegateCompat {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(CheckableImageButton.this.Wwwwwwwwwwwwwwwwwwwwwww);
            accessibilityNodeInfoCompat.setChecked(CheckableImageButton.this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0049R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwww = true;
        ViewCompat.setAccessibilityDelegate(this, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww ? ImageButton.mergeDrawableStates(super.onCreateDrawableState(i + Wwwwwwwwwwwwwwwwwwwww.length), Wwwwwwwwwwwwwwwwwwwww) : super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) parcelable;
        super.onRestoreInstanceState(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSuperState());
        setChecked(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(super.onSaveInstanceState());
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void setCheckable(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwww == z) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwwwww) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }
}

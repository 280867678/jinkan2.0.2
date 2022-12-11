package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.C2376mn;
import me.tvspark.C2413nn;
import me.tvspark.C2416nq;
import me.tvspark.C2450on;
import me.tvspark.C2489pp;
import me.tvspark.C2605so;
import me.tvspark.C2606sp;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.View$OnAttachStateChangeListenerC2532qp;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int Kkkkkkkkkkkkkkk = R$style.Widget_Design_BottomSheet_Modal;
    public final ViewDragHelper.Callback Kkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkk;
    @Nullable
    public Map<View, Integer> Kkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public VelocityTracker Kkkkkkkkkkkkkkkkkkkkkk;
    @NonNull
    public final ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Kkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public WeakReference<View> Kkkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public WeakReference<V> Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public int Www;
    public int Wwww;
    public boolean Wwwww;
    public int Wwwwww;
    public boolean Wwwwwww;
    @Nullable
    public ViewDragHelper Wwwwwwww;
    public int Wwwwwwwww;
    public boolean Wwwwwwwwww;
    public boolean Wwwwwwwwwww;
    public boolean Wwwwwwwwwwww;
    public float Wwwwwwwwwwwww;
    public int Wwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    @Nullable
    public ValueAnimator Wwwwwwwwwwwwwwwwwww;
    public BottomSheetBehavior<V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public C2416nq Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    public MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public boolean Wwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            boolean z = false;
            this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readInt() == 1;
            this.Wwwwwwwwwwwwwwwwwwwww = parcel.readInt() == 1;
            this.Wwwwwwwwwwwwwwwwwwww = parcel.readInt() == 1 ? true : z;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = bottomSheetBehavior.Wwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = bottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = bottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = bottomSheetBehavior.Wwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = bottomSheetBehavior.Wwwwwwwwwww;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww ? 1 : 0);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwww ? 1 : 0);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwww ? 1 : 0);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwww;
        public final View Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = view;
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.Wwwwwwww;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
            } else {
                ViewCompat.postOnAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwww, this);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, float f);

        public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, int i);
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends ViewDragHelper.Callback {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i, int i2) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = BottomSheetBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return MathUtils.clamp(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bottomSheetBehavior.Wwwwwwwwwwww ? bottomSheetBehavior.Kkkkkkkkkkkkkkkkkkkkkkkkkk : bottomSheetBehavior.Wwwwwwwwwwwwww);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.Wwwwwwwwwwww ? bottomSheetBehavior.Kkkkkkkkkkkkkkkkkkkkkkkkkk : bottomSheetBehavior.Wwwwwwwwwwwwww;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (i == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (!bottomSheetBehavior.Wwwwwwwwww) {
                    return;
                }
                bottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
            if (java.lang.Math.abs(r8.getTop() - r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww) < java.lang.Math.abs(r8.getTop() - r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
            r9 = r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00b8, code lost:
            if (java.lang.Math.abs(r9 - r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww) < java.lang.Math.abs(r9 - r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww)) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
            if (r9 < java.lang.Math.abs(r9 - r10.Wwwwwwwwwwwwww)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0102, code lost:
            if (java.lang.Math.abs(r9 - r1) < java.lang.Math.abs(r9 - r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww)) goto L33;
         */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onViewReleased(@NonNull View view, float f, float f2) {
            BottomSheetBehavior bottomSheetBehavior;
            BottomSheetBehavior bottomSheetBehavior2;
            int i;
            int i2 = 4;
            if (f2 < 0.0f) {
                bottomSheetBehavior = BottomSheetBehavior.this;
                if (!bottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    int i3 = bottomSheetBehavior3.Wwwwwwwwwwwwwwww;
                    if (top > i3) {
                        i = i3;
                        i2 = 6;
                    } else {
                        i = bottomSheetBehavior3.Wwwwwwwwwwwwwwwwww;
                        i2 = 3;
                    }
                }
                i = bottomSheetBehavior.Wwwwwwwwwwwwwwwww;
                i2 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                if (bottomSheetBehavior4.Wwwwwwwwwwww && bottomSheetBehavior4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, f2)) {
                    if (Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                        if (!(top2 > (bottomSheetBehavior5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + bottomSheetBehavior5.Kkkkkkkkkkkkkkkkkkkkkkkkkk) / 2)) {
                            bottomSheetBehavior = BottomSheetBehavior.this;
                            if (!bottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            }
                            i = bottomSheetBehavior.Wwwwwwwwwwwwwwwww;
                            i2 = 3;
                        }
                    }
                    i = BottomSheetBehavior.this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
                    i2 = 5;
                } else if (f2 != 0.0f && Math.abs(f) <= Math.abs(f2)) {
                    bottomSheetBehavior2 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        int top3 = view.getTop();
                    }
                    i = bottomSheetBehavior2.Wwwwwwwwwwwwww;
                } else {
                    int top4 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior6 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        int i4 = bottomSheetBehavior6.Wwwwwwwwwwwwwwww;
                        if (top4 < i4) {
                        }
                        i = BottomSheetBehavior.this.Wwwwwwwwwwwwwwww;
                        i2 = 6;
                    } else if (Math.abs(top4 - bottomSheetBehavior6.Wwwwwwwwwwwwwwwww) < Math.abs(top4 - BottomSheetBehavior.this.Wwwwwwwwwwwwww)) {
                        bottomSheetBehavior = BottomSheetBehavior.this;
                        i = bottomSheetBehavior.Wwwwwwwwwwwwwwwww;
                        i2 = 3;
                    }
                    bottomSheetBehavior2 = BottomSheetBehavior.this;
                    i = bottomSheetBehavior2.Wwwwwwwwwwwwww;
                }
            }
            BottomSheetBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, i2, i, true);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.Wwwwwwwww;
            if (i2 != 1 && !bottomSheetBehavior.Kkkkkkkkkkkkkkkkkkk) {
                if (i2 == 3 && bottomSheetBehavior.Kkkkkkkkkkkkkkkkkkkkk == i) {
                    WeakReference<View> weakReference = bottomSheetBehavior.Kkkkkkkkkkkkkkkkkkkkkkkk;
                    View view2 = weakReference != null ? weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = BottomSheetBehavior.this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
                return weakReference2 != null && weakReference2.get() == view;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = view;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public BottomSheetBehavior() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwww = 0.5f;
        this.Wwwwwwwwwwwww = -1.0f;
        this.Wwwwwwwwww = true;
        this.Wwwwwwwww = 4;
        this.Kkkkkkkkkkkkkkkkkkkkkkk = new ArrayList<>();
        this.Kkkkkkkkkkkkkkkkk = -1;
        this.Kkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimensionPixelSize;
        int dimensionPixelOffset;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwww = 0.5f;
        this.Wwwwwwwwwwwww = -1.0f;
        this.Wwwwwwwwww = true;
        this.Wwwwwwwww = 4;
        this.Kkkkkkkkkkkkkkkkkkkkkkk = new ArrayList<>();
        this.Kkkkkkkkkkkkkkkkk = -1;
        this.Kkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, hasValue, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, R$styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, hasValue, (ColorStateList) null);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.Wwwwwwwwwwwwwwwwwww = ofFloat;
        ofFloat.setDuration(500L);
        this.Wwwwwwwwwwwwwwwwwww.addUpdateListener(new C2376mn(this));
        this.Wwwwwwwwwwwww = obtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((peekValue == null || (dimensionPixelSize = peekValue.data) != -1) ? obtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : dimensionPixelSize);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        this.Wwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwww != 6) ? this.Wwwwwwwww : 3);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwww = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.Wwwwwwwwww = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f = obtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f > 0.0f && f < 1.0f) {
            this.Wwwwwwwwwwwwwww = f;
            if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk != null) {
                this.Wwwwwwwwwwwwwwww = (int) ((1.0f - f) * this.Kkkkkkkkkkkkkkkkkkkkkkkkkk);
            }
            TypedValue peekValue2 = obtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
            if (peekValue2 == null || peekValue2.type != 16) {
                dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0);
                if (dimensionPixelOffset < 0) {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                dimensionPixelOffset = peekValue2.data;
                if (dimensionPixelOffset < 0) {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.Wwwwwwwwwwwwwwwwww = dimensionPixelOffset;
            obtainStyledAttributes.recycle();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (!(behavior instanceof BottomSheetBehavior)) {
                throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
            }
            return (BottomSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.Wwwwwwwwwwwwwwwwwwwww == z) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = z;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwww == null || (valueAnimator = this.Wwwwwwwwwwwwwwwwwww) == null) {
            return;
        }
        if (valueAnimator.isRunning()) {
            this.Wwwwwwwwwwwwwwwwwww.reverse();
            return;
        }
        float f = z ? 0.0f : 1.0f;
        this.Wwwwwwwwwwwwwwwwwww.setFloatValues(1.0f - f, f);
        this.Wwwwwwwwwwwwwwwwwww.start();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        V v = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent == null || !parent.isLayoutRequested() || !ViewCompat.isAttachedToWindow(v)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) v, i);
        } else {
            v.post(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, i));
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        V v;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        WeakReference<V> weakReference = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v, 524288);
        ViewCompat.removeAccessibilityAction(v, 262144);
        ViewCompat.removeAccessibilityAction(v, 1048576);
        int i = this.Kkkkkkkkkkkkkkkkk;
        if (i != -1) {
            ViewCompat.removeAccessibilityAction(v, i);
        }
        int i2 = 6;
        if (this.Wwwwwwwww != 6) {
            this.Kkkkkkkkkkkkkkkkk = ViewCompat.addAccessibilityAction(v, v.getResources().getString(R$string.bottomsheet_action_expand_halfway), new C2450on(this, 6));
        }
        if (this.Wwwwwwwwwwww && this.Wwwwwwwww != 5) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i3 = this.Wwwwwwwww;
        if (i3 == 3) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                i2 = 4;
            }
            accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE;
        } else if (i3 != 4) {
            if (i3 != 6) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
            return;
        } else {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                i2 = 3;
            }
            accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, accessibilityActionCompat, i2);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        V v;
        if (this.Wwwwwwwww == i) {
            return;
        }
        this.Wwwwwwwww = i;
        WeakReference<V> weakReference = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        } else if (i == 6 || i == 5 || i == 4) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        for (int i2 = 0; i2 < this.Kkkkkkkkkkkkkkkkkkkkkkk.size(); i2++) {
            this.Kkkkkkkkkkkkkkkkkkkkkkk.get(i2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) v, i);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i == this.Wwwwwwwww) {
            return;
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        } else if (i != 4 && i != 3 && i != 6 && (!this.Wwwwwwwwwwww || i != 5)) {
        } else {
            this.Wwwwwwwww = i;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        V v;
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwww != 4 || (v = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.get()) == null) {
                return;
            }
            if (z) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwww);
            } else {
                v.requestLayout();
            }
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww ? Math.min(Math.max(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkkkkk - ((this.Www * 9) / 16)), this.Wwww) : (this.Wwwwwwwwwwwwwwwwwwwwwww || (i = this.Wwwwwwwwwwwwwwwwwwwwwwww) <= 0) ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Math.max(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i + this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean z = true;
        if (i == -1) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            z = false;
        } else {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != i) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.max(0, i);
            }
            z = false;
        }
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        Map<View, Integer> map;
        int intValue;
        WeakReference<V> weakReference = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z) {
            if (this.Kkkkkkkkkkkkkkkkkk != null) {
                return;
            }
            this.Kkkkkkkkkkkkkkkkkk = new HashMap(childCount);
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = coordinatorLayout.getChildAt(i);
            if (childAt != this.Kkkkkkkkkkkkkkkkkkkkkkkkk.get()) {
                if (z) {
                    this.Kkkkkkkkkkkkkkkkkk.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        intValue = 4;
                        ViewCompat.setImportantForAccessibility(childAt, intValue);
                    }
                } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && (map = this.Kkkkkkkkkkkkkkkkkk) != null && map.containsKey(childAt)) {
                    intValue = this.Kkkkkkkkkkkkkkkkkk.get(childAt).intValue();
                    ViewCompat.setImportantForAccessibility(childAt, intValue);
                }
            }
        }
        if (!z) {
            this.Kkkkkkkkkkkkkkkkkk = null;
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk.get().sendAccessibilityEvent(8);
        }
    }

    @Nullable
    @VisibleForTesting
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup.getChildAt(i));
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
        }
        return null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwww = Math.max(this.Kkkkkkkkkkkkkkkkkkkkkkkkkk - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwwwwwwwwwwwwwwww);
        } else {
            this.Wwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        float f;
        float f2;
        V v = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.get();
        if (v == null || this.Kkkkkkkkkkkkkkkkkkkkkkk.isEmpty()) {
            return;
        }
        int i2 = this.Wwwwwwwwwwwwww;
        if (i > i2 || i2 == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            int i3 = this.Wwwwwwwwwwwwww;
            f = i3 - i;
            f2 = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk - i3;
        } else {
            int i4 = this.Wwwwwwwwwwwwww;
            f = i4 - i;
            f2 = i4 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        float f3 = f / f2;
        for (int i5 = 0; i5 < this.Kkkkkkkkkkkkkkkkkkkkkkk.size(); i5++) {
            this.Kkkkkkkkkkkkkkkkkkkkkkk.get(i5).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, f3);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, AttributeSet attributeSet, boolean z, @Nullable ColorStateList colorStateList) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww = C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, R$attr.bottomSheetStyle, Kkkkkkkkkkkkkkk).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.Wwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = materialShapeDrawable;
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2605so(context);
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            if (z && colorStateList != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.Wwwwwwwwwwwwwwwwwwwwwwwww.setTint(typedValue.data);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.Wwwwwwwwwwwwww;
        } else if (i == 6) {
            i2 = this.Wwwwwwwwwwwwwwww;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && i2 <= (i3 = this.Wwwwwwwwwwwwwwwww)) {
                i = 3;
                i2 = i3;
            }
        } else if (i == 3) {
            i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (!this.Wwwwwwwwwwww || i != 5) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Illegal state argument: ", i));
        } else {
            i2 = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, i, i2, false);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Wwwwwwwwwwww != z) {
            this.Wwwwwwwwwwww = z;
            if (!z && this.Wwwwwwwww == 5) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, float f) {
        if (this.Wwwwwwwwwww) {
            return true;
        }
        if (view.getTop() < this.Wwwwwwwwwwwwww) {
            return false;
        }
        return Math.abs(((f * 0.1f) + ((float) view.getTop())) - ((float) this.Wwwwwwwwwwwwww)) / ((float) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) > 0.5f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = null;
        this.Wwwwwwww = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = null;
        this.Wwwwwwww = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!v.isShown() || !this.Wwwwwwwwww) {
            this.Wwwwwww = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        View view = null;
        if (actionMasked == 0) {
            this.Kkkkkkkkkkkkkkkkkkkkk = -1;
            VelocityTracker velocityTracker = this.Kkkkkkkkkkkkkkkkkkkkkk;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Kkkkkkkkkkkkkkkkkkkkkk = null;
            }
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkk == null) {
            this.Kkkkkkkkkkkkkkkkkkkkkk = VelocityTracker.obtain();
        }
        this.Kkkkkkkkkkkkkkkkkkkkkk.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.Kkkkkkkkkkkkkkkkkkkk = (int) motionEvent.getY();
            if (this.Wwwwwwwww != 2) {
                WeakReference<View> weakReference = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x, this.Kkkkkkkkkkkkkkkkkkkk)) {
                    this.Kkkkkkkkkkkkkkkkkkkkk = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.Kkkkkkkkkkkkkkkkkkk = true;
                }
            }
            this.Wwwwwww = this.Kkkkkkkkkkkkkkkkkkkkk == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.Kkkkkkkkkkkkkkkkkkkk);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.Kkkkkkkkkkkkkkkkkkk = false;
            this.Kkkkkkkkkkkkkkkkkkkkk = -1;
            if (this.Wwwwwww) {
                this.Wwwwwww = false;
                return false;
            }
        }
        if (!this.Wwwwwww && (viewDragHelper = this.Wwwwwwww) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        return actionMasked == 2 && view != null && !this.Wwwwwww && this.Wwwwwwwww != 1 && !coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.Wwwwwwww != null && Math.abs(((float) this.Kkkkkkkkkkkkkkkkkkkk) - motionEvent.getY()) > ((float) this.Wwwwwwww.getTouchSlop());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        int i2;
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            if (Build.VERSION.SDK_INT >= 29 && !this.Wwwwwwwwwwwwwwwwwwwwwww && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                ViewCompat.setOnApplyWindowInsetsListener(v, new C2489pp(new C2413nn(this), new C2606sp(ViewCompat.getPaddingStart(v), v.getPaddingTop(), ViewCompat.getPaddingEnd(v), v.getPaddingBottom())));
                if (ViewCompat.isAttachedToWindow(v)) {
                    ViewCompat.requestApplyInsets(v);
                } else {
                    v.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC2532qp());
                }
            }
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk = new WeakReference<>(v);
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww && (materialShapeDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                ViewCompat.setBackground(v, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (materialShapeDrawable2 != null) {
                float f = this.Wwwwwwwwwwwww;
                if (f == -1.0f) {
                    f = ViewCompat.getElevation(v);
                }
                materialShapeDrawable2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
                boolean z = this.Wwwwwwwww == 3;
                this.Wwwwwwwwwwwwwwwwwwwww = z;
                this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z ? 0.0f : 1.0f);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (ViewCompat.getImportantForAccessibility(v) == 0) {
                ViewCompat.setImportantForAccessibility(v, 1);
            }
        }
        if (this.Wwwwwwww == null) {
            this.Wwwwwwww = ViewDragHelper.create(coordinatorLayout, this.Kkkkkkkkkkkkkkkk);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.Www = coordinatorLayout.getWidth();
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.Wwww = height;
        this.Wwwwwwwwwwwwwwwww = Math.max(0, this.Kkkkkkkkkkkkkkkkkkkkkkkkkk - height);
        this.Wwwwwwwwwwwwwwww = (int) ((1.0f - this.Wwwwwwwwwwwwwww) * this.Kkkkkkkkkkkkkkkkkkkkkkkkkk);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i3 = this.Wwwwwwwww;
        if (i3 == 3) {
            i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (i3 == 6) {
            i2 = this.Wwwwwwwwwwwwwwww;
        } else if (!this.Wwwwwwwwwwww || i3 != 5) {
            int i4 = this.Wwwwwwwww;
            if (i4 != 4) {
                if (i4 == 1 || i4 == 2) {
                    ViewCompat.offsetTopAndBottom(v, top - v.getTop());
                }
                this.Kkkkkkkkkkkkkkkkkkkkkkkk = new WeakReference<>(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v));
                return true;
            }
            i2 = this.Wwwwwwwwwwwwww;
        } else {
            i2 = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        }
        ViewCompat.offsetTopAndBottom(v, i2);
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = new WeakReference<>(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f, float f2) {
        WeakReference<View> weakReference = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.Wwwwwwwww != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
        int i4;
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i2;
        if (i2 > 0) {
            if (i5 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                iArr[1] = top - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                i4 = 3;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
            } else if (!this.Wwwwwwwwww) {
                return;
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.Wwwwwwwwwwwwww;
            if (i5 > i6 && !this.Wwwwwwwwwwww) {
                iArr[1] = top - i6;
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                i4 = 4;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
            } else if (!this.Wwwwwwwwww) {
                return;
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v.getTop());
        this.Wwwwww = i2;
        this.Wwwww = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = savedState.Wwwwwwwwwwwwwwwwwwwwwww;
            }
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 == -1 || (i2 & 2) == 2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = savedState.Wwwwwwwwwwwwwwwwwwwwww;
            }
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i3 == -1 || (i3 & 4) == 4) {
                this.Wwwwwwwwwwww = savedState.Wwwwwwwwwwwwwwwwwwwww;
            }
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i4 == -1 || (i4 & 8) == 8) {
                this.Wwwwwwwwwww = savedState.Wwwwwwwwwwwwwwwwwwww;
            }
        }
        int i5 = savedState.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i5 == 1 || i5 == 2) {
            this.Wwwwwwwww = 4;
        } else {
            this.Wwwwwwwww = i5;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i, int i2) {
        this.Wwwwww = 0;
        this.Wwwww = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x007a, code lost:
        if (java.lang.Math.abs(r4 - r3.Wwwwwwwwwwwwwwwww) < java.lang.Math.abs(r4 - r3.Wwwwwwwwwwwwww)) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0089, code lost:
        if (r4 < java.lang.Math.abs(r4 - r3.Wwwwwwwwwwwwww)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
        if (java.lang.Math.abs(r4 - r1) < java.lang.Math.abs(r4 - r3.Wwwwwwwwwwwwww)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b7, code lost:
        if (java.lang.Math.abs(r4 - r3.Wwwwwwwwwwwwwwww) < java.lang.Math.abs(r4 - r3.Wwwwwwwwwwwwww)) goto L44;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i) {
        int i2;
        float yVelocity;
        int i3 = 3;
        if (v.getTop() == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
            return;
        }
        WeakReference<View> weakReference = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        if (weakReference == null || view != weakReference.get() || !this.Wwwww) {
            return;
        }
        if (this.Wwwwww > 0) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                int top = v.getTop();
                int i4 = this.Wwwwwwwwwwwwwwww;
                if (top > i4) {
                    i2 = i4;
                    i3 = 6;
                }
                i2 = this.Wwwwwwwwwwwwwwwwww;
            }
            i2 = this.Wwwwwwwwwwwwwwwww;
        } else {
            if (this.Wwwwwwwwwwww) {
                VelocityTracker velocityTracker = this.Kkkkkkkkkkkkkkkkkkkkkk;
                if (velocityTracker == null) {
                    yVelocity = 0.0f;
                } else {
                    velocityTracker.computeCurrentVelocity(1000, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    yVelocity = this.Kkkkkkkkkkkkkkkkkkkkkk.getYVelocity(this.Kkkkkkkkkkkkkkkkkkkkk);
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v, yVelocity)) {
                    i2 = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
                    i3 = 5;
                }
            }
            if (this.Wwwwww == 0) {
                int top2 = v.getTop();
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    int i5 = this.Wwwwwwwwwwwwwwww;
                    if (top2 < i5) {
                    }
                    i2 = this.Wwwwwwwwwwwwwwww;
                    i3 = 6;
                }
                i2 = this.Wwwwwwwwwwwwww;
                i3 = 4;
            } else {
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    int top3 = v.getTop();
                }
                i2 = this.Wwwwwwwwwwwwww;
                i3 = 4;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) v, i3, i2, false);
        this.Wwwww = false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.Wwwwwwwww == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.Wwwwwwww;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.Kkkkkkkkkkkkkkkkkkkkk = -1;
            VelocityTracker velocityTracker = this.Kkkkkkkkkkkkkkkkkkkkkk;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Kkkkkkkkkkkkkkkkkkkkkk = null;
            }
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkk == null) {
            this.Kkkkkkkkkkkkkkkkkkkkkk = VelocityTracker.obtain();
        }
        this.Kkkkkkkkkkkkkkkkkkkkkk.addMovement(motionEvent);
        if (this.Wwwwwwww != null && actionMasked == 2 && !this.Wwwwwww && Math.abs(this.Kkkkkkkkkkkkkkkkkkkk - motionEvent.getY()) > this.Wwwwwwww.getTouchSlop()) {
            this.Wwwwwwww.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.Wwwwwww;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(V v, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i) {
        ViewCompat.replaceAccessibilityAction(v, accessibilityActionCompat, null, new C2450on(this, i));
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, int i, int i2, boolean z) {
        ViewDragHelper viewDragHelper = this.Wwwwwwww;
        if (viewDragHelper != null && (!z ? viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i2) : viewDragHelper.settleCapturedViewAt(view.getLeft(), i2))) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            if (this.Wwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, i);
            }
            BottomSheetBehavior<V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
            boolean z2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = i;
            if (z2) {
                return;
            }
            ViewCompat.postOnAnimation(view, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = true;
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }
}

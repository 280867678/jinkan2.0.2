package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;
import me.tvspark.C2085es;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class ClockFaceView extends C2085es implements ClockHandView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final ColorStateList Wwwwwwwwwww;
    public float Wwwwwwwwwwww;
    public String[] Wwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwww;
    public final float[] Wwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwww;
    public final AccessibilityDelegateCompat Wwwwwwwwwwwwwwwww;
    public final SparseArray<TextView> Wwwwwwwwwwwwwwwwww;
    public final RectF Wwwwwwwwwwwwwwwwwww;
    public final Rect Wwwwwwwwwwwwwwwwwwww;
    public final ClockHandView Wwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AccessibilityDelegateCompat {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int intValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
            if (intValue > 0) {
                accessibilityNodeInfoCompat.setTraversalAfter(ClockFaceView.this.Wwwwwwwwwwwwwwwwww.get(intValue - 1));
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, intValue, 1, false, view.isSelected()));
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ViewTreeObserver.OnPreDrawListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView clockFaceView = ClockFaceView.this;
            int height = ((ClockFaceView.this.getHeight() / 2) - clockFaceView.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww) - clockFaceView.Wwwwwwwwwwwwww;
            if (height != clockFaceView.Wwwwwwwwwwwwwwwwwwwwwww) {
                clockFaceView.Wwwwwwwwwwwwwwwwwwwwwww = height;
                clockFaceView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ClockHandView clockHandView = clockFaceView.Wwwwwwwwwwwwwwwwwwwww;
                clockHandView.Wwwwwwww = clockFaceView.Wwwwwwwwwwwwwwwwwwwwwww;
                clockHandView.invalidate();
            }
            return true;
        }
    }

    public ClockFaceView(@NonNull Context context) {
        this(context, null);
    }

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwww = new Rect();
        this.Wwwwwwwwwwwwwwwwwww = new RectF();
        this.Wwwwwwwwwwwwwwwwww = new SparseArray<>();
        this.Wwwwwwwwwwwwwww = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, i, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        this.Wwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, R$styleable.ClockFaceView_clockNumberTextColor);
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        this.Wwwwwwwwwwwwwwwwwwwww = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.Wwwwwwwwwwwwww = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        ColorStateList colorStateList = this.Wwwwwwwwwww;
        int colorForState = colorStateList.getColorForState(new int[]{16842913}, colorStateList.getDefaultColor());
        this.Wwwwwwwwwwwwwwww = new int[]{colorForState, colorForState, this.Wwwwwwwwwww.getDefaultColor()};
        this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.add(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, R$styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.Wwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, 0);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        RectF rectF = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww;
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwww.size(); i++) {
            TextView textView = this.Wwwwwwwwwwwwwwwwww.get(i);
            if (textView != null) {
                textView.getDrawingRect(this.Wwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwww.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.Wwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwww.set(this.Wwwwwwwwwwwwwwwwwwww);
                textView.getPaint().setShader(!RectF.intersects(rectF, this.Wwwwwwwwwwwwwwwwwww) ? null : new RadialGradient(rectF.centerX() - this.Wwwwwwwwwwwwwwwwwww.left, rectF.centerY() - this.Wwwwwwwwwwwwwwwwwww.top, 0.5f * rectF.width(), this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, Shader.TileMode.CLAMP));
                textView.invalidate();
            }
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, boolean z) {
        if (Math.abs(this.Wwwwwwwwwwww - f) > 0.001f) {
            this.Wwwwwwwwwwww = f;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String[] strArr, @StringRes int i) {
        this.Wwwwwwwwwwwww = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.Wwwwwwwwwwwwwwwwww.size();
        for (int i2 = 0; i2 < Math.max(this.Wwwwwwwwwwwww.length, size); i2++) {
            TextView textView = this.Wwwwwwwwwwwwwwwwww.get(i2);
            if (i2 >= this.Wwwwwwwwwwwww.length) {
                removeView(textView);
                this.Wwwwwwwwwwwwwwwwww.remove(i2);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    this.Wwwwwwwwwwwwwwwwww.put(i2, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.Wwwwwwwwwwwww[i2]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i2));
                ViewCompat.setAccessibilityDelegate(textView, this.Wwwwwwwwwwwwwwwww);
                textView.setTextColor(this.Wwwwwwwwwww);
                if (i != 0) {
                    textView.setContentDescription(getResources().getString(i, this.Wwwwwwwwwwwww[i2]));
                }
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.Wwwwwwwwwwwww.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}

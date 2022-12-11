package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;
import me.tvspark.AbstractC2121fr;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class SnackbarContentLayout extends LinearLayout implements AbstractC2121fr {
    public int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public Button Wwwwwwwwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwwwwwwwww;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        this.Wwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_android_maxWidth, -1);
        this.Wwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    @Override // me.tvspark.AbstractC2121fr
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setAlpha(1.0f);
        long j = i2;
        long j2 = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.Wwwwwwwwwwwwwwwwwwwwwww.getVisibility() == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.setAlpha(1.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwww.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    @Override // me.tvspark.AbstractC2121fr
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setAlpha(0.0f);
        long j = i2;
        long j2 = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.Wwwwwwwwwwwwwwwwwwwwwww.getVisibility() == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.setAlpha(0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwww.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.getPaddingTop() == i2 && this.Wwwwwwwwwwwwwwwwwwwwwwww.getPaddingBottom() == i3) {
            return z;
        }
        TextView textView = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (ViewCompat.isPaddingRelative(textView)) {
            ViewCompat.setPaddingRelative(textView, ViewCompat.getPaddingStart(textView), i2, ViewCompat.getPaddingEnd(textView), i3);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i2, textView.getPaddingRight(), i3);
        return true;
    }

    public Button getActionView() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public TextView getMessageView() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = (TextView) findViewById(R$id.snackbar_text);
        this.Wwwwwwwwwwwwwwwwwwwwwww = (Button) findViewById(R$id.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, r0, r0 - r1) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, r0, r0) != false) goto L21;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Wwwwwwwwwwwwwwwwwwwwww > 0) {
            int measuredWidth = getMeasuredWidth();
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (measuredWidth > i3) {
                i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                super.onMeasure(i, i2);
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical);
        boolean z = false;
        boolean z2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.getLayout().getLineCount() > 1;
        if (!z2 || this.Wwwwwwwwwwwwwwwwwwwww <= 0 || this.Wwwwwwwwwwwwwwwwwwwwwww.getMeasuredWidth() <= this.Wwwwwwwwwwwwwwwwwwwww) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    public void setMaxInlineActionWidth(int i) {
        this.Wwwwwwwwwwwwwwwwwwwww = i;
    }
}

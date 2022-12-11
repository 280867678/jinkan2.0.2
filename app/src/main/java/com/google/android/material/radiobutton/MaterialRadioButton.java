package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import me.tvspark.C1957bs;
import me.tvspark.C2415np;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class MaterialRadioButton extends AppCompatRadioButton {
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final int Wwwwwwwwwwwwwwwwwwwwww = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;
    public static final int[][] Wwwwwwwwwwwwwwwwwwwww = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, r3, Wwwwwwwwwwwwwwwwwwwwww), attributeSet, r3);
        int i = R$attr.radioButtonStyle;
        Context context2 = getContext();
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, R$styleable.MaterialRadioButton, i, Wwwwwwwwwwwwwwwwwwwwww, new int[0]);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasValue(R$styleable.MaterialRadioButton_buttonTint)) {
            CompoundButtonCompat.setButtonTintList(this, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R$styleable.MaterialRadioButton_buttonTint));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, R$attr.colorControlActivated);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, R$attr.colorOnSurface);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, R$attr.colorSurface);
            int[] iArr = new int[Wwwwwwwwwwwwwwwwwwwww.length];
            iArr[0] = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1.0f);
            iArr[1] = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0.54f);
            iArr[2] = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0.38f);
            iArr[3] = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0.38f);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new ColorStateList(Wwwwwwwwwwwwwwwwwwwww, iArr);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww || CompoundButtonCompat.getButtonTintList(this) != null) {
            return;
        }
        setUseMaterialThemeColors(true);
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = z;
        CompoundButtonCompat.setButtonTintList(this, z ? getMaterialThemeColorsTintList() : null);
    }
}

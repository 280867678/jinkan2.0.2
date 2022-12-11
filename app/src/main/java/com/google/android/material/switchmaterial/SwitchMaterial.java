package com.google.android.material.switchmaterial;

import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class SwitchMaterial extends SwitchCompat {
    public static final int[][] Wwwwwwwwwwwwwwwwwwwww = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwwwwwwww;

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        ColorStateList colorStateList = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (colorStateList != null) {
            return colorStateList;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, R$attr.colorSurface);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, R$attr.colorControlActivated);
        getResources().getDimension(R$dimen.mtrl_switch_thumb_elevation);
        throw null;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == null) {
            int[] iArr = new int[Wwwwwwwwwwwwwwwwwwwww.length];
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, R$attr.colorSurface);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, R$attr.colorControlActivated);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, R$attr.colorOnSurface);
            iArr[0] = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0.54f);
            iArr[1] = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, 0.32f);
            iArr[2] = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0.12f);
            iArr[3] = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, 0.12f);
            this.Wwwwwwwwwwwwwwwwwwwwwww = new ColorStateList(Wwwwwwwwwwwwwwwwwwwww, iArr);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Wwwwwwwwwwwwwwwwwwwwww && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwww || getTrackTintList() != null) {
            return;
        }
        setTrackTintList(getMaterialThemeColorsTrackTintList());
    }

    public void setUseMaterialThemeColors(boolean z) {
        ColorStateList colorStateList;
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            colorStateList = getMaterialThemeColorsTrackTintList();
        } else {
            colorStateList = null;
            setThumbTintList(null);
        }
        setTrackTintList(colorStateList);
    }
}

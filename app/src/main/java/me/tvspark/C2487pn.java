package me.tvspark;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.pn */
/* loaded from: classes4.dex */
public class C2487pn {
    public int Wwwwwwwwwwwwwwww;
    public LayerDrawable Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public PorterDuff.Mode Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final MaterialButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwwwwww = false;

    public C2487pn(MaterialButton materialButton, @NonNull C2416nq c2416nq) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialButton;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.android.material.R$attr.colorSurface) : 0);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        MaterialButton materialButton = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext());
        DrawableCompat.setTintList(materialShapeDrawable, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        PorterDuff.Mode mode = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (mode != null) {
            DrawableCompat.setTintMode(materialShapeDrawable, mode);
        }
        materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.android.material.R$attr.colorSurface) : 0);
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwww = materialShapeDrawable3;
        DrawableCompat.setTint(materialShapeDrawable3, -1);
        RippleDrawable rippleDrawable = new RippleDrawable(C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable}), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww);
        }
    }

    @Nullable
    public final MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
    }

    @Nullable
    public MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }

    @Nullable
    public final MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        LayerDrawable layerDrawable = this.Wwwwwwwwwwwwwwwww;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.Wwwwwwwwwwwwwwwww.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    @Nullable
    public AbstractC2570rq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        LayerDrawable layerDrawable = this.Wwwwwwwwwwwwwwwww;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (AbstractC2570rq) (this.Wwwwwwwwwwwwwwwww.getNumberOfLayers() > 2 ? this.Wwwwwwwwwwwwwwwww.getDrawable(2) : this.Wwwwwwwwwwwwwwwww.getDrawable(1));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Dimension int i, @Dimension int i2) {
        int paddingStart = ViewCompat.getPaddingStart(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int paddingTop = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int paddingBottom = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPaddingBottom();
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        if (!this.Wwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        ViewCompat.setPaddingRelative(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C2416nq c2416nq) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
            MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.invalidateSelf();
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
            MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.invalidateSelf();
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().setShapeAppearanceModel(c2416nq);
        }
    }
}

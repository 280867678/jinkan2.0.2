package me.tvspark;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;

/* renamed from: me.tvspark.qn */
/* loaded from: classes4.dex */
public class C2530qn extends ViewOutlineProvider {
    public final /* synthetic */ Chip Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2530qn(Chip chip) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = chip;
    }

    @Override // android.view.ViewOutlineProvider
    @TargetApi(21)
    public void getOutline(View view, @NonNull Outline outline) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}

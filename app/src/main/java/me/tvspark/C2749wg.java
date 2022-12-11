package me.tvspark;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* renamed from: me.tvspark.wg */
/* loaded from: classes4.dex */
public final class C2749wg {
    public static final C2749wg Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2749wg(-1, -16777216, 0, 0, -1, null);
    @Nullable
    public final Typeface Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2749wg(int i, int i2, int i3, int i4, int i5, @Nullable Typeface typeface) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = typeface;
    }

    @RequiresApi(19)
    public static C2749wg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CaptioningManager.CaptionStyle captionStyle) {
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21) {
            return new C2749wg(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, captionStyle.hasWindowColor() ? captionStyle.windowColor : Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, captionStyle.hasEdgeType() ? captionStyle.edgeType : Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, captionStyle.getTypeface());
        }
        return new C2749wg(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }
}

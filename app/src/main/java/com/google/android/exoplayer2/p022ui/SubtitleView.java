package com.google.android.exoplayer2.p022ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.AbstractC2111fh;
import me.tvspark.C2261jj;
import me.tvspark.C2374ml;
import me.tvspark.C2483pj;
import me.tvspark.C2749wg;
import me.tvspark.C2786xg;

/* renamed from: com.google.android.exoplayer2.ui.SubtitleView */
/* loaded from: classes3.dex */
public final class SubtitleView extends FrameLayout implements AbstractC2111fh {
    public View Wwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public C2749wg Wwwwwwwwwwwwwwwwwwwwwww;
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: com.google.android.exoplayer2.ui.SubtitleView$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<C2786xg> list, C2749wg c2749wg, float f, int i, float f2);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Collections.emptyList();
        this.Wwwwwwwwwwwwwwwwwwwwwww = C2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwww = 0.0533f;
        this.Wwwwwwwwwwwwwwwwwwww = 0.08f;
        this.Wwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwww = true;
        C2261jj c2261jj = new C2261jj(context, attributeSet);
        this.Wwwwwwwwwwwwwwww = c2261jj;
        this.Wwwwwwwwwwwwwww = c2261jj;
        addView(c2261jj);
        this.Wwwwwwwwwwwwwwwww = 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.text.SpannableString] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    private List<C2786xg> getCuesWithStylingPreferencesApplied() {
        C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        ?? valueOf;
        if (!this.Wwwwwwwwwwwwwwwwwww || !this.Wwwwwwwwwwwwwwwwww) {
            ArrayList arrayList = new ArrayList(this.Wwwwwwwwwwwwwwwwwwwwwwww.size());
            for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
                C2786xg c2786xg = this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i);
                CharSequence charSequence = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (!this.Wwwwwwwwwwwwwwwwwww) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww = -3.4028235E38f;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = false;
                    if (charSequence != null) {
                        valueOf = charSequence.toString();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = valueOf;
                    }
                    c2786xg = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                } else if (!this.Wwwwwwwwwwwwwwwwww && charSequence != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww = -3.4028235E38f;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;
                    if (charSequence instanceof Spanned) {
                        valueOf = SpannableString.valueOf(charSequence);
                        for (AbsoluteSizeSpan absoluteSizeSpan : (AbsoluteSizeSpan[]) valueOf.getSpans(0, valueOf.length(), AbsoluteSizeSpan.class)) {
                            valueOf.removeSpan(absoluteSizeSpan);
                        }
                        for (RelativeSizeSpan relativeSizeSpan : (RelativeSizeSpan[]) valueOf.getSpans(0, valueOf.length(), RelativeSizeSpan.class)) {
                            valueOf.removeSpan(relativeSizeSpan);
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = valueOf;
                    }
                    c2786xg = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                arrayList.add(c2786xg);
            }
            return arrayList;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private C2749wg getUserCaptionStyle() {
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 19 || isInEditMode()) {
            return C2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? C2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww : C2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(captioningManager.getUserStyle());
    }

    private <T extends View & Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> void setView(T t) {
        removeView(this.Wwwwwwwwwwwwwww);
        View view = this.Wwwwwwwwwwwwwww;
        if (view instanceof C2483pj) {
            ((C2483pj) view).Wwwwwwwwwwwwwwwwwwwwwww.destroy();
        }
        this.Wwwwwwwwwwwwwww = t;
        this.Wwwwwwwwwwwwwwww = t;
        addView(t);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getCuesWithStylingPreferencesApplied(), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2111fh
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<C2786xg> list) {
        setCues(list);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.Wwwwwwwwwwwwwwwwww = z;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.Wwwwwwwwwwwwwwwwwww = z;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setBottomPaddingFraction(float f) {
        this.Wwwwwwwwwwwwwwwwwwww = f;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setCues(@Nullable List<C2786xg> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = list;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setFractionalTextSize(float f) {
        this.Wwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwww = f;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setStyle(C2749wg c2749wg) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = c2749wg;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setViewType(int i) {
        KeyEvent.Callback c2261jj;
        if (this.Wwwwwwwwwwwwwwwww == i) {
            return;
        }
        if (i == 1) {
            c2261jj = new C2261jj(getContext(), null);
        } else if (i != 2) {
            throw new IllegalArgumentException();
        } else {
            c2261jj = new C2483pj(getContext());
        }
        setView(c2261jj);
        this.Wwwwwwwwwwwwwwwww = i;
    }
}

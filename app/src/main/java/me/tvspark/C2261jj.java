package me.tvspark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.exoplayer2.p022ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.C2786xg;

/* renamed from: me.tvspark.jj */
/* loaded from: classes4.dex */
public final class C2261jj extends View implements SubtitleView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final List<C2372mj> Wwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwww = Collections.emptyList();
    public int Wwwwwwwwwwwwwwwwwwwwww = 0;
    public float Wwwwwwwwwwwwwwwwwwwww = 0.0533f;
    public C2749wg Wwwwwwwwwwwwwwwwwwww = C2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwww = 0.08f;

    public C2261jj(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.exoplayer2.p022ui.SubtitleView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<C2786xg> list, C2749wg c2749wg, float f, int i, float f2) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwww = c2749wg;
        this.Wwwwwwwwwwwwwwwwwwwww = f;
        this.Wwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwww = f2;
        while (this.Wwwwwwwwwwwwwwwwwwwwwwww.size() < list.size()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.add(new C2372mj(getContext()));
        }
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x03d4, code lost:
        if (r3 < r6) goto L155;
     */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x048d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        float f;
        float f2;
        int i8;
        float f3;
        Canvas canvas2;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        C2261jj c2261jj = this;
        Canvas canvas3 = canvas;
        List<C2786xg> list = c2261jj.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i17 = paddingBottom - paddingTop;
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2261jj.Wwwwwwwwwwwwwwwwwwwwww, c2261jj.Wwwwwwwwwwwwwwwwwwwww, height, i17);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 0.0f) {
            return;
        }
        int size = list.size();
        int i18 = 0;
        while (i18 < size) {
            C2786xg c2786xg = list.get(i18);
            if (c2786xg.Wwwwwwwwwwwwwwwwwwww != Integer.MIN_VALUE) {
                C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = -3.4028235E38f;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                if (c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1.0f - c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    i16 = 0;
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (-c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) - 1.0f;
                    i16 = 1;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i16;
                int i19 = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i19 == 0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
                } else if (i19 == 2) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                }
                c2786xg = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2786xg.Wwwwwwwwwwwwwwwwwwwwww, c2786xg.Wwwwwwwwwwwwwwwwwwwww, height, i17);
            C2372mj c2372mj = c2261jj.Wwwwwwwwwwwwwwwwwwwwwwww.get(i18);
            C2749wg c2749wg = c2261jj.Wwwwwwwwwwwwwwwwwwww;
            List<C2786xg> list2 = list;
            float f4 = c2261jj.Wwwwwwwwwwwwwwwwwww;
            if (c2372mj == null) {
                throw null;
            }
            boolean z3 = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null;
            int i20 = height;
            if (!z3) {
                i = i17;
                i2 = -16777216;
            } else if (TextUtils.isEmpty(c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                canvas2 = canvas3;
                i4 = paddingLeft;
                i5 = paddingTop;
                i6 = width;
                i7 = paddingBottom;
                i = i17;
                f = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i3 = size;
                i18++;
                canvas3 = canvas2;
                i17 = i;
                list = list2;
                height = i20;
                size = i3;
                paddingLeft = i4;
                paddingTop = i5;
                width = i6;
                paddingBottom = i7;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
                c2261jj = this;
            } else {
                i2 = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwww ? c2786xg.Wwwwwwwwwwwwwwwwwwwwwww : c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i = i17;
            }
            CharSequence charSequence = c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            i3 = size;
            CharSequence charSequence2 = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if ((charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2))) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwww, c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && c2372mj.Wwwwwwwwwwwwwwwwwwwwwwww == c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && c2372mj.Wwwwwwwwwwwwwwwwwwwwwww == c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && c2372mj.Wwwwwwwwwwwwwwwwwwwwww == c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.valueOf(c2372mj.Wwwwwwwwwwwwwwwwwwwww), Integer.valueOf(c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) && c2372mj.Wwwwwwwwwwwwwwwwwwww == c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.valueOf(c2372mj.Wwwwwwwwwwwwwwwwwww), Integer.valueOf(c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwww)) && c2372mj.Wwwwwwwwwwwwwwwwww == c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwww && c2372mj.Wwwwwwwwwwwwwwwww == c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwww && c2372mj.Wwwwwwwwwwwwwwww == c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && c2372mj.Wwwwwwwwwwwwwww == c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && c2372mj.Wwwwwwwwwwwwww == i2 && c2372mj.Wwwwwwwwwwww == c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && c2372mj.Wwwwwwwwwwwww == c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.getTypeface(), c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) && c2372mj.Wwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && c2372mj.Wwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 && c2372mj.Wwwwwwwww == f4 && c2372mj.Wwwwwwww == paddingLeft && c2372mj.Wwwwwww == paddingTop && c2372mj.Wwwwww == width && c2372mj.Wwwww == paddingBottom) {
                c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas3, z3);
                canvas2 = canvas3;
                i4 = paddingLeft;
                i5 = paddingTop;
                i6 = width;
                i7 = paddingBottom;
                f = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i18++;
                canvas3 = canvas2;
                i17 = i;
                list = list2;
                height = i20;
                size = i3;
                paddingLeft = i4;
                paddingTop = i5;
                width = i6;
                paddingBottom = i7;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
                c2261jj = this;
            } else {
                c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwww = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwwwwwwwwwwww = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwwwwwwwwwww = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwwwwwwwwww = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwwwwwwwww = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwwwwwwww = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwwwwwww = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwwwwww = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwwwww = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwwww = c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwww = c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwww = i2;
                c2372mj.Wwwwwwwwwwww = c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwww = c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTypeface(c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                c2372mj.Wwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2372mj.Wwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                c2372mj.Wwwwwwwww = f4;
                c2372mj.Wwwwwwww = paddingLeft;
                c2372mj.Wwwwwww = paddingTop;
                c2372mj.Wwwwww = width;
                c2372mj.Wwwww = paddingBottom;
                if (z3) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                    CharSequence charSequence3 = c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    SpannableStringBuilder spannableStringBuilder = charSequence3 instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence3 : new SpannableStringBuilder(c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                    int i21 = c2372mj.Wwwwww - c2372mj.Wwwwwwww;
                    int i22 = c2372mj.Wwwww - c2372mj.Wwwwwww;
                    c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTextSize(c2372mj.Wwwwwwwwwww);
                    int i23 = (int) ((c2372mj.Wwwwwwwwwww * 0.125f) + 0.5f);
                    int i24 = i23 * 2;
                    int i25 = i21 - i24;
                    float f5 = c2372mj.Wwwwwwwwwwwwwwwwww;
                    if (f5 != -3.4028235E38f) {
                        i25 = (int) (i25 * f5);
                    }
                    if (i25 <= 0) {
                        i4 = paddingLeft;
                        i5 = paddingTop;
                        i6 = width;
                        i7 = paddingBottom;
                        f = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Canvas canvas4 = canvas3;
                        z2 = z3;
                        canvas2 = canvas4;
                    } else {
                        i4 = paddingLeft;
                        if (c2372mj.Wwwwwwwwww > 0.0f) {
                            i5 = paddingTop;
                            i6 = width;
                            i9 = 0;
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) c2372mj.Wwwwwwwwww), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                        } else {
                            i5 = paddingTop;
                            i6 = width;
                            i9 = 0;
                        }
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                        if (c2372mj.Wwwwwwwwwwww == 1) {
                            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(i9, spannableStringBuilder2.length(), ForegroundColorSpan.class);
                            int i26 = 0;
                            for (int length = foregroundColorSpanArr.length; i26 < length; length = length) {
                                spannableStringBuilder2.removeSpan(foregroundColorSpanArr[i26]);
                                i26++;
                            }
                        }
                        if (Color.alpha(c2372mj.Wwwwwwwwwwwwwww) > 0) {
                            int i27 = c2372mj.Wwwwwwwwwwww;
                            if (i27 == 0 || i27 == 2) {
                                i7 = paddingBottom;
                                spannableStringBuilder.setSpan(new BackgroundColorSpan(c2372mj.Wwwwwwwwwwwwwww), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            } else {
                                i7 = paddingBottom;
                                spannableStringBuilder2.setSpan(new BackgroundColorSpan(c2372mj.Wwwwwwwwwwwwwww), 0, spannableStringBuilder2.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            }
                        } else {
                            i7 = paddingBottom;
                        }
                        Layout.Alignment alignment = c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwww;
                        if (alignment == null) {
                            alignment = Layout.Alignment.ALIGN_CENTER;
                        }
                        f = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, i25, alignment, c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
                        c2372mj.Wwww = staticLayout;
                        int height2 = staticLayout.getHeight();
                        int lineCount = c2372mj.Wwww.getLineCount();
                        int i28 = 0;
                        int i29 = 0;
                        while (i28 < lineCount) {
                            i29 = Math.max((int) Math.ceil(c2372mj.Wwww.getLineWidth(i28)), i29);
                            i28++;
                            lineCount = lineCount;
                            z3 = z3;
                        }
                        z = z3;
                        if (c2372mj.Wwwwwwwwwwwwwwwwww == -3.4028235E38f || i29 >= i25) {
                            i25 = i29;
                        }
                        int i30 = i25 + i24;
                        float f6 = c2372mj.Wwwwwwwwwwwwwwwwwwww;
                        if (f6 != -3.4028235E38f) {
                            int round = Math.round(i21 * f6) + c2372mj.Wwwwwwww;
                            int i31 = c2372mj.Wwwwwwwwwwwwwwwwwww;
                            if (i31 == 1) {
                                round = ((round * 2) - i30) / 2;
                            } else if (i31 == 2) {
                                round -= i30;
                            }
                            i10 = Math.max(round, c2372mj.Wwwwwwww);
                            i11 = Math.min(i30 + i10, c2372mj.Wwwwww);
                        } else {
                            i10 = c2372mj.Wwwwwwww + ((i21 - i30) / 2);
                            i11 = i10 + i30;
                        }
                        int i32 = i11 - i10;
                        if (i32 <= 0) {
                            canvas2 = canvas;
                            z2 = z;
                        } else {
                            float f7 = c2372mj.Wwwwwwwwwwwwwwwwwwwwwww;
                            if (f7 == -3.4028235E38f) {
                                i12 = (c2372mj.Wwwww - height2) - ((int) (i22 * c2372mj.Wwwwwwwww));
                            } else if (c2372mj.Wwwwwwwwwwwwwwwwwwwwww == 0) {
                                i12 = Math.round(i22 * f7) + c2372mj.Wwwwwww;
                                int i33 = c2372mj.Wwwwwwwwwwwwwwwwwwwww;
                                if (i33 == 2) {
                                    i12 -= height2;
                                    i14 = i12 + height2;
                                    i15 = c2372mj.Wwwww;
                                    if (i14 <= i15) {
                                        i12 = i15 - height2;
                                    } else {
                                        i13 = c2372mj.Wwwwwww;
                                    }
                                } else {
                                    if (i33 == 1) {
                                        i12 = ((i12 * 2) - height2) / 2;
                                    }
                                    i14 = i12 + height2;
                                    i15 = c2372mj.Wwwww;
                                    if (i14 <= i15) {
                                    }
                                }
                            } else {
                                int lineBottom = c2372mj.Wwww.getLineBottom(0) - c2372mj.Wwww.getLineTop(0);
                                float f8 = c2372mj.Wwwwwwwwwwwwwwwwwwwwwww;
                                if (f8 >= 0.0f) {
                                    i12 = Math.round(f8 * lineBottom) + c2372mj.Wwwwwww;
                                    i14 = i12 + height2;
                                    i15 = c2372mj.Wwwww;
                                    if (i14 <= i15) {
                                    }
                                } else {
                                    i12 = Math.round((f8 + 1.0f) * lineBottom) + c2372mj.Wwwww;
                                    i12 -= height2;
                                    i14 = i12 + height2;
                                    i15 = c2372mj.Wwwww;
                                    if (i14 <= i15) {
                                    }
                                }
                            }
                            i13 = i12;
                            Layout.Alignment alignment2 = alignment;
                            c2372mj.Wwww = new StaticLayout(spannableStringBuilder, c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, i32, alignment2, c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
                            c2372mj.Www = new StaticLayout(spannableStringBuilder2, c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, i32, alignment2, c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
                            c2372mj.Kkkkkkkkkkkkkkkkkkkkkkkkkk = i10;
                            c2372mj.Kkkkkkkkkkkkkkkkkkkkkkkkk = i13;
                            c2372mj.Kkkkkkkkkkkkkkkkkkkkkkkk = i23;
                        }
                    }
                    c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas2, z2);
                    i18++;
                    canvas3 = canvas2;
                    i17 = i;
                    list = list2;
                    height = i20;
                    size = i3;
                    paddingLeft = i4;
                    paddingTop = i5;
                    width = i6;
                    paddingBottom = i7;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
                    c2261jj = this;
                } else {
                    z = z3;
                    i4 = paddingLeft;
                    i5 = paddingTop;
                    i6 = width;
                    i7 = paddingBottom;
                    f = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2372mj.Wwwwwwwwwwwwwwwwwwwwwwww);
                    Bitmap bitmap = c2372mj.Wwwwwwwwwwwwwwwwwwwwwwww;
                    int i34 = c2372mj.Wwwwww;
                    int i35 = c2372mj.Wwwwwwww;
                    int i36 = c2372mj.Wwwww;
                    int i37 = c2372mj.Wwwwwww;
                    float f9 = i34 - i35;
                    float f10 = (c2372mj.Wwwwwwwwwwwwwwwwwwww * f9) + i35;
                    float f11 = i36 - i37;
                    float f12 = (c2372mj.Wwwwwwwwwwwwwwwwwwwwwww * f11) + i37;
                    int round2 = Math.round(f9 * c2372mj.Wwwwwwwwwwwwwwwwww);
                    float f13 = c2372mj.Wwwwwwwwwwwwwwwww;
                    if (f13 == -3.4028235E38f) {
                        f13 = round2;
                        f11 = bitmap.getHeight() / bitmap.getWidth();
                    }
                    int round3 = Math.round(f11 * f13);
                    int i38 = c2372mj.Wwwwwwwwwwwwwwwwwww;
                    if (i38 == 2) {
                        f2 = round2;
                    } else {
                        if (i38 == 1) {
                            f2 = round2 / 2;
                        }
                        int round4 = Math.round(f10);
                        i8 = c2372mj.Wwwwwwwwwwwwwwwwwwwww;
                        if (i8 != 2) {
                            f3 = round3;
                        } else {
                            if (i8 == 1) {
                                f3 = round3 / 2;
                            }
                            int round5 = Math.round(f12);
                            c2372mj.Kkkkkkkkkkkkkkkkkkkkkkk = new Rect(round4, round5, round2 + round4, round3 + round5);
                        }
                        f12 -= f3;
                        int round52 = Math.round(f12);
                        c2372mj.Kkkkkkkkkkkkkkkkkkkkkkk = new Rect(round4, round52, round2 + round4, round3 + round52);
                    }
                    f10 -= f2;
                    int round42 = Math.round(f10);
                    i8 = c2372mj.Wwwwwwwwwwwwwwwwwwwww;
                    if (i8 != 2) {
                    }
                    f12 -= f3;
                    int round522 = Math.round(f12);
                    c2372mj.Kkkkkkkkkkkkkkkkkkkkkkk = new Rect(round42, round522, round2 + round42, round3 + round522);
                }
                canvas2 = canvas;
                z2 = z;
                c2372mj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas2, z2);
                i18++;
                canvas3 = canvas2;
                i17 = i;
                list = list2;
                height = i20;
                size = i3;
                paddingLeft = i4;
                paddingTop = i5;
                width = i6;
                paddingBottom = i7;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
                c2261jj = this;
            }
        }
    }
}

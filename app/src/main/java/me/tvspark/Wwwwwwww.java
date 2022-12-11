package me.tvspark;

import android.content.Context;
import android.view.TextureView;
import android.view.View;

/* loaded from: classes4.dex */
public class Wwwwwwww extends TextureView {
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    public Wwwwwwww(Context context) {
        super(context);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0092, code lost:
        if (r13 > r8) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0094, code lost:
        r13 = (r8 * r2) / r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a7, code lost:
        if (r13 > r8) goto L38;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        hashCode();
        int rotation = (int) getRotation();
        int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i7 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int measuredHeight = ((View) getParent()).getMeasuredHeight();
        int measuredWidth = ((View) getParent()).getMeasuredWidth();
        if (measuredWidth != 0 && measuredHeight != 0 && i6 != 0 && i7 != 0 && Wwwwww.Kkkkkk == 1) {
            if (rotation == 90 || rotation == 270) {
                measuredWidth = measuredHeight;
                measuredHeight = measuredWidth;
            }
            i7 = (i6 * measuredHeight) / measuredWidth;
        }
        if (rotation == 90 || rotation == 270) {
            i2 = i;
            i = i2;
        }
        int defaultSize = TextureView.getDefaultSize(i6, i);
        int defaultSize2 = TextureView.getDefaultSize(i7, i2);
        if (i6 > 0 && i7 > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            View.MeasureSpec.toString(i);
            View.MeasureSpec.toString(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                i5 = i6 * size2;
                int i8 = size * i7;
                if (i5 >= i8) {
                    if (i5 > i8) {
                        i4 = i8 / i6;
                        defaultSize = size;
                        defaultSize2 = i4;
                    } else {
                        defaultSize = size;
                        defaultSize2 = size2;
                    }
                }
                defaultSize = i5 / i7;
                defaultSize2 = size2;
            } else {
                if (mode == 1073741824) {
                    i4 = (size * i7) / i6;
                    if (mode2 == Integer.MIN_VALUE && i4 > size2) {
                        i5 = size2 * i6;
                        defaultSize = i5 / i7;
                        defaultSize2 = size2;
                    }
                } else if (mode2 == 1073741824) {
                    i3 = (size2 * i6) / i7;
                    if (mode == Integer.MIN_VALUE) {
                    }
                    defaultSize = i3;
                    defaultSize2 = size2;
                } else {
                    if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                        i3 = i6;
                        size2 = i7;
                    } else {
                        i3 = (size2 * i6) / i7;
                    }
                    if (mode == Integer.MIN_VALUE) {
                    }
                    defaultSize = i3;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = i4;
            }
        }
        if (measuredWidth != 0 && measuredHeight != 0 && i6 != 0 && i7 != 0) {
            int i9 = Wwwwww.Kkkkkk;
            if (i9 != 3) {
                if (i9 == 2) {
                    if (rotation == 90 || rotation == 270) {
                        int i10 = measuredWidth;
                        measuredWidth = measuredHeight;
                        measuredHeight = i10;
                    }
                    double d = i7 / i6;
                    double d2 = measuredHeight;
                    double d3 = measuredWidth;
                    double d4 = d2 / d3;
                    if (d > d4) {
                        i7 = (int) ((d3 / defaultSize) * defaultSize2);
                        i6 = measuredWidth;
                    } else if (d < d4) {
                        i6 = (int) ((d2 / defaultSize2) * defaultSize);
                        i7 = measuredHeight;
                    }
                }
            }
            setMeasuredDimension(i6, i7);
        }
        i6 = defaultSize;
        i7 = defaultSize2;
        setMeasuredDimension(i6, i7);
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }
}

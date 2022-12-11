package com.lzf.easyfloat.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import com.lzf.easyfloat.enums.SidePattern;
import com.lzf.easyfloat.interfaces.OnFloatAnimator;
import kotlin.Triple;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes3.dex */
public class DefaultAnimator implements OnFloatAnimator {
    public int bottomDistance;
    public int leftDistance;
    public int minX;
    public int minY;
    public int rightDistance;
    public int topDistance;
    public Rect floatRect = new Rect();
    public Rect parentRect = new Rect();

    @ef0
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SidePattern.values().length];
            $EnumSwitchMapping$0 = iArr;
            SidePattern sidePattern = SidePattern.LEFT;
            iArr[1] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            SidePattern sidePattern2 = SidePattern.RESULT_LEFT;
            iArr2[8] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            SidePattern sidePattern3 = SidePattern.RIGHT;
            iArr3[2] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            SidePattern sidePattern4 = SidePattern.RESULT_RIGHT;
            iArr4[9] = 4;
            int[] iArr5 = $EnumSwitchMapping$0;
            SidePattern sidePattern5 = SidePattern.TOP;
            iArr5[3] = 5;
            int[] iArr6 = $EnumSwitchMapping$0;
            SidePattern sidePattern6 = SidePattern.RESULT_TOP;
            iArr6[10] = 6;
            int[] iArr7 = $EnumSwitchMapping$0;
            SidePattern sidePattern7 = SidePattern.BOTTOM;
            iArr7[4] = 7;
            int[] iArr8 = $EnumSwitchMapping$0;
            SidePattern sidePattern8 = SidePattern.RESULT_BOTTOM;
            iArr8[11] = 8;
            int[] iArr9 = $EnumSwitchMapping$0;
            SidePattern sidePattern9 = SidePattern.DEFAULT;
            iArr9[0] = 9;
            int[] iArr10 = $EnumSwitchMapping$0;
            SidePattern sidePattern10 = SidePattern.AUTO_HORIZONTAL;
            iArr10[5] = 10;
            int[] iArr11 = $EnumSwitchMapping$0;
            SidePattern sidePattern11 = SidePattern.RESULT_HORIZONTAL;
            iArr11[12] = 11;
            int[] iArr12 = $EnumSwitchMapping$0;
            SidePattern sidePattern12 = SidePattern.AUTO_VERTICAL;
            iArr12[6] = 12;
            int[] iArr13 = $EnumSwitchMapping$0;
            SidePattern sidePattern13 = SidePattern.RESULT_VERTICAL;
            iArr13[13] = 13;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x001c, code lost:
        if (r3.topDistance < r3.bottomDistance) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:
        if (r3.leftDistance < r3.rightDistance) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r3.leftDistance < r3.rightDistance) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0044, code lost:
        if (r3.topDistance < r3.bottomDistance) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        r5 = bottomValue(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Triple<String, Float, Float> animTriple(View view, SidePattern sidePattern) {
        float leftValue;
        int ordinal = sidePattern.ordinal();
        String str = Key.TRANSLATION_Y;
        switch (ordinal) {
            case 0:
            case 5:
            case 12:
                break;
            case 1:
            case 8:
                leftValue = leftValue(view);
                str = Key.TRANSLATION_X;
                break;
            case 2:
            case 9:
                leftValue = rightValue(view);
                str = Key.TRANSLATION_X;
                break;
            case 3:
            case 10:
                leftValue = topValue(view);
                break;
            case 4:
            case 11:
                leftValue = rightValue(view);
                break;
            case 6:
            case 13:
                break;
            case 7:
            default:
                if (this.minX > this.minY) {
                    break;
                } else {
                    break;
                }
        }
        return new Triple<>(str, Float.valueOf(leftValue), Float.valueOf(ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) Key.TRANSLATION_X) ? view.getTranslationX() : view.getTranslationY()));
    }

    private final float bottomValue(View view) {
        int i = this.bottomDistance;
        return view.getTranslationY() + view.getHeight() + i;
    }

    private final void initValue(View view, ViewGroup viewGroup) {
        view.getGlobalVisibleRect(this.floatRect);
        viewGroup.getGlobalVisibleRect(this.parentRect);
        Rect rect = this.floatRect;
        int i = rect.left;
        this.leftDistance = i;
        Rect rect2 = this.parentRect;
        int i2 = rect2.right - rect.right;
        this.rightDistance = i2;
        this.topDistance = rect.top - rect2.top;
        this.bottomDistance = rect2.bottom - rect.bottom;
        this.minX = Math.min(i, i2);
        this.minY = Math.min(this.topDistance, this.bottomDistance);
    }

    private final float leftValue(View view) {
        int i = this.leftDistance;
        return view.getTranslationX() + (-(view.getWidth() + i));
    }

    private final float rightValue(View view) {
        int i = this.rightDistance;
        return view.getTranslationX() + view.getWidth() + i;
    }

    private final float topValue(View view) {
        int i = this.topDistance;
        return view.getTranslationY() + (-(view.getHeight() + i));
    }

    @Override // com.lzf.easyfloat.interfaces.OnFloatAnimator
    public Animator enterAnim(View view, ViewGroup viewGroup, SidePattern sidePattern) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, "parentView");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
        initValue(view, viewGroup);
        Triple<String, Float, Float> animTriple = animTriple(view, sidePattern);
        return ObjectAnimator.ofFloat(view, animTriple.component1(), animTriple.component2().floatValue(), animTriple.component3().floatValue()).setDuration(500L);
    }

    @Override // com.lzf.easyfloat.interfaces.OnFloatAnimator
    public Animator exitAnim(View view, ViewGroup viewGroup, SidePattern sidePattern) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, "parentView");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
        initValue(view, viewGroup);
        Triple<String, Float, Float> animTriple = animTriple(view, sidePattern);
        return ObjectAnimator.ofFloat(view, animTriple.component1(), animTriple.component3().floatValue(), animTriple.component2().floatValue()).setDuration(500L);
    }
}

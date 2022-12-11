package me.tvspark;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.motion.widget.Key;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class ou0 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ nu0 Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ long[] Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ ViewTreeObserver Wwwwwwwwwwwwwwwwwwwwwwww;

    public ou0(nu0 nu0Var, ViewTreeObserver viewTreeObserver, long[] jArr) {
        this.Wwwwwwwwwwwwwwwwwwwwww = nu0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = viewTreeObserver;
        this.Wwwwwwwwwwwwwwwwwwwwwww = jArr;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean z;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.removeOnPreDrawListener(this);
        int firstVisiblePosition = this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getDragDropGirdView().getFirstVisiblePosition();
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getDragDropGirdView().getChildCount()) {
                break;
            }
            View childAt = this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getDragDropGirdView().getChildAt(i);
            int i2 = firstVisiblePosition + i;
            if (this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)) {
                long itemId = this.Wwwwwwwwwwwwwwwwwwwwww.getItemId(i2);
                nu0 nu0Var = this.Wwwwwwwwwwwwwwwwwwwwww;
                long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (nu0Var == null) {
                    throw null;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= jArr.length) {
                        z = false;
                        break;
                    } else if (jArr[i3] == itemId) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    arrayList.add(ObjectAnimator.ofFloat(childAt, Key.ALPHA, 0.0f, 1.0f));
                    break;
                }
                Integer num = this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww.get(Long.valueOf(itemId));
                Integer num2 = this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww.get(Long.valueOf(itemId));
                int top = childAt.getTop();
                int left = childAt.getLeft();
                if (num2 != null && num2.intValue() != left) {
                    arrayList.add(ObjectAnimator.ofFloat(childAt, Key.TRANSLATION_X, num2.intValue() - left, 0.0f));
                }
                if (num != null && num.intValue() != top) {
                    arrayList.add(ObjectAnimator.ofFloat(childAt, Key.TRANSLATION_Y, num.intValue() - top, 0.0f));
                }
            }
            i++;
        }
        if (arrayList.size() > 0) {
            animatorSet.setDuration(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww).playTogether(arrayList);
            animatorSet.start();
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww.clear();
        return true;
    }
}

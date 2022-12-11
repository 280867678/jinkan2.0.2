package me.tvspark.widget.autoScrollPager.adapter;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import me.tvspark.zt0;

/* loaded from: classes4.dex */
public abstract class RecyclingPagerAdapter extends PagerAdapter {
    public final zt0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public RecyclingPagerAdapter() {
        zt0 zt0Var = new zt0();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = zt0Var;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 1) {
            SparseArray<View>[] sparseArrayArr = new SparseArray[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
            for (int i = 0; i < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
                sparseArrayArr[i] = new SparseArray<>();
            }
            zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sparseArrayArr[0];
            zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sparseArrayArr;
            return;
        }
        throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 1;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 0;
    }

    public abstract View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, View view, ViewGroup viewGroup);

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            zt0 zt0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            (zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1 ? zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]).put(i, view);
            view.setAccessibilityDelegate(null);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        SparseArray<View> sparseArray;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        View view = null;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            zt0 zt0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                sparseArray = zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 0) {
                SparseArray<View>[] sparseArrayArr = zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < sparseArrayArr.length) {
                    sparseArray = sparseArrayArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                }
            }
            view = zt0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sparseArray, i);
        }
        View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, view, viewGroup);
        viewGroup.addView(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        zt0 zt0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        View[] viewArr = zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int[] iArr = zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z = zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 1;
        SparseArray<View> sparseArray = zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        for (int length = viewArr.length - 1; length >= 0; length--) {
            View view = viewArr[length];
            if (view != null) {
                int i = iArr[length];
                viewArr[length] = null;
                iArr[length] = -1;
                if (i >= 0) {
                    if (z) {
                        sparseArray = zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                    }
                    sparseArray.put(length, view);
                    view.setAccessibilityDelegate(null);
                }
            }
        }
        int length2 = zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
        int i2 = zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        SparseArray<View>[] sparseArrayArr = zt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        for (int i3 = 0; i3 < i2; i3++) {
            SparseArray<View> sparseArray2 = sparseArrayArr[i3];
            int size = sparseArray2.size();
            int i4 = size - length2;
            int i5 = size - 1;
            int i6 = 0;
            while (i6 < i4) {
                sparseArray2.remove(sparseArray2.keyAt(i5));
                i6++;
                i5--;
            }
        }
        super.notifyDataSetChanged();
    }
}

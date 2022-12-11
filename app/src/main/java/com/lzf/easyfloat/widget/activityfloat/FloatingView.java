package com.lzf.easyfloat.widget.activityfloat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.lzf.easyfloat.data.FloatConfig;
import com.umeng.analytics.pro.C1615d;
import java.util.HashMap;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes3.dex */
public final class FloatingView extends AbstractDragFloatingView {
    public HashMap _$_findViewCache;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
    }

    public /* synthetic */ FloatingView(Context context, AttributeSet attributeSet, int i, gi0 gi0Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Override // com.lzf.easyfloat.widget.activityfloat.AbstractDragFloatingView
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.lzf.easyfloat.widget.activityfloat.AbstractDragFloatingView
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.lzf.easyfloat.widget.activityfloat.AbstractDragFloatingView
    public Integer getLayoutId() {
        return getConfig().getLayoutId();
    }

    @Override // com.lzf.easyfloat.widget.activityfloat.AbstractDragFloatingView
    public void renderView(View view) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
    }

    public final void setFloatConfig(FloatConfig floatConfig) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatConfig, "config");
        setConfig(floatConfig);
        Context context = getContext();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) context, C1615d.f3292R);
        initView(context);
        requestLayout();
    }
}

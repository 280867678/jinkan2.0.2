package com.lzf.easyfloat.widget.appfloat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.lzf.easyfloat.data.FloatConfig;
import com.lzf.easyfloat.interfaces.FloatCallbacks;
import com.lzf.easyfloat.interfaces.OnFloatCallbacks;
import com.lzf.easyfloat.interfaces.OnFloatTouchListener;
import com.lzf.easyfloat.utils.InputMethodUtils;
import com.umeng.analytics.pro.C1615d;
import java.util.HashMap;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.of0;
import me.tvspark.xg0;

@ef0
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class ParentFrameLayout extends FrameLayout {
    public HashMap _$_findViewCache;
    public final FloatConfig config;
    public boolean isCreated;
    public OnLayoutListener layoutListener;
    public OnFloatTouchListener touchListener;

    @ef0
    /* loaded from: classes3.dex */
    public interface OnLayoutListener {
        void onLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParentFrameLayout(Context context, FloatConfig floatConfig, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatConfig, "config");
        this.config = floatConfig;
    }

    public /* synthetic */ ParentFrameLayout(Context context, FloatConfig floatConfig, AttributeSet attributeSet, int i, int i2, gi0 gi0Var) {
        this(context, floatConfig, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (this.config.getHasEditText() && keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            InputMethodUtils.closedInputMethod(FloatManager.INSTANCE.getTag(this.config.getFloatTag()));
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public final OnLayoutListener getLayoutListener() {
        return this.layoutListener;
    }

    public final OnFloatTouchListener getTouchListener() {
        return this.touchListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        FloatCallbacks.Builder builder;
        xg0<of0> dismiss$easyfloat_release;
        super.onDetachedFromWindow();
        OnFloatCallbacks callbacks = this.config.getCallbacks();
        if (callbacks != null) {
            callbacks.dismiss();
        }
        FloatCallbacks floatCallbacks = this.config.getFloatCallbacks();
        if (floatCallbacks == null || (builder = floatCallbacks.getBuilder()) == null || (dismiss$easyfloat_release = builder.getDismiss$easyfloat_release()) == null) {
            return;
        }
        dismiss$easyfloat_release.mo4969invoke();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnFloatTouchListener onFloatTouchListener;
        if (motionEvent != null && (onFloatTouchListener = this.touchListener) != null) {
            onFloatTouchListener.onTouch(motionEvent);
        }
        return this.config.isDrag() || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.isCreated) {
            this.isCreated = true;
            OnLayoutListener onLayoutListener = this.layoutListener;
            if (onLayoutListener == null) {
                return;
            }
            onLayoutListener.onLayout();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnFloatTouchListener onFloatTouchListener;
        if (motionEvent != null && (onFloatTouchListener = this.touchListener) != null) {
            onFloatTouchListener.onTouch(motionEvent);
        }
        return this.config.isDrag() || super.onTouchEvent(motionEvent);
    }

    public final void setLayoutListener(OnLayoutListener onLayoutListener) {
        this.layoutListener = onLayoutListener;
    }

    public final void setTouchListener(OnFloatTouchListener onFloatTouchListener) {
        this.touchListener = onFloatTouchListener;
    }
}

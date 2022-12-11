package com.p038qq.p039e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.p038qq.p039e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer */
/* loaded from: classes3.dex */
public class NativeAdContainer extends FrameLayout {
    public ViewStatus Wwwwwwwwwwwwwwwwwwwwwww = ViewStatus.INIT;
    public ViewStatusListener Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C10531 {
        public static final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        static {
            int[] iArr = new int[ViewStatus.values().length];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$ViewStatus */
    /* loaded from: classes3.dex */
    public enum ViewStatus {
        INIT,
        ATTACHED,
        DETACHED
    }

    public NativeAdContainer(Context context) {
        super(context);
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewStatusListener viewStatusListener = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.m3647d("NativeAdContainer onAttachedToWindow");
        this.Wwwwwwwwwwwwwwwwwwwwwww = ViewStatus.ATTACHED;
        ViewStatusListener viewStatusListener = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.m3647d("NativeAdContainer onDetachedFromWindow");
        this.Wwwwwwwwwwwwwwwwwwwwwww = ViewStatus.DETACHED;
        ViewStatusListener viewStatusListener = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        GDTLogger.m3647d("onWindowFocusChanged: hasWindowFocus: " + z);
        ViewStatusListener viewStatusListener = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        GDTLogger.m3647d("onWindowVisibilityChanged: visibility: " + i);
        ViewStatusListener viewStatusListener = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = viewStatusListener;
        if (viewStatusListener != null) {
            int ordinal = this.Wwwwwwwwwwwwwwwwwwwwwww.ordinal();
            if (ordinal == 1) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onAttachToWindow();
            } else if (ordinal != 2) {
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onDetachFromWindow();
            }
        }
    }
}

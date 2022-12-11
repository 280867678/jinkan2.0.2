package com.lzf.easyfloat.interfaces;

import android.view.MotionEvent;
import android.view.View;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.mh0;
import me.tvspark.nh0;
import me.tvspark.of0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes3.dex */
public final class FloatCallbacks {
    public Builder builder;

    @ef0
    /* loaded from: classes3.dex */
    public final class Builder {
        public nh0<? super Boolean, ? super String, ? super View, of0> createdResult;
        public xg0<of0> dismiss;
        public mh0<? super View, ? super MotionEvent, of0> drag;
        public ih0<? super View, of0> dragEnd;
        public ih0<? super View, of0> hide;
        public ih0<? super View, of0> show;
        public mh0<? super View, ? super MotionEvent, of0> touchEvent;

        public Builder() {
        }

        public final void createResult(nh0<? super Boolean, ? super String, ? super View, of0> nh0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nh0Var, "action");
            this.createdResult = nh0Var;
        }

        public final void dismiss(xg0<of0> xg0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var, "action");
            this.dismiss = xg0Var;
        }

        public final void drag(mh0<? super View, ? super MotionEvent, of0> mh0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mh0Var, "action");
            this.drag = mh0Var;
        }

        public final void dragEnd(ih0<? super View, of0> ih0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "action");
            this.dragEnd = ih0Var;
        }

        public final nh0<Boolean, String, View, of0> getCreatedResult$easyfloat_release() {
            return this.createdResult;
        }

        public final xg0<of0> getDismiss$easyfloat_release() {
            return this.dismiss;
        }

        public final mh0<View, MotionEvent, of0> getDrag$easyfloat_release() {
            return this.drag;
        }

        public final ih0<View, of0> getDragEnd$easyfloat_release() {
            return this.dragEnd;
        }

        public final ih0<View, of0> getHide$easyfloat_release() {
            return this.hide;
        }

        public final ih0<View, of0> getShow$easyfloat_release() {
            return this.show;
        }

        public final mh0<View, MotionEvent, of0> getTouchEvent$easyfloat_release() {
            return this.touchEvent;
        }

        public final void hide(ih0<? super View, of0> ih0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "action");
            this.hide = ih0Var;
        }

        public final void setCreatedResult$easyfloat_release(nh0<? super Boolean, ? super String, ? super View, of0> nh0Var) {
            this.createdResult = nh0Var;
        }

        public final void setDismiss$easyfloat_release(xg0<of0> xg0Var) {
            this.dismiss = xg0Var;
        }

        public final void setDrag$easyfloat_release(mh0<? super View, ? super MotionEvent, of0> mh0Var) {
            this.drag = mh0Var;
        }

        public final void setDragEnd$easyfloat_release(ih0<? super View, of0> ih0Var) {
            this.dragEnd = ih0Var;
        }

        public final void setHide$easyfloat_release(ih0<? super View, of0> ih0Var) {
            this.hide = ih0Var;
        }

        public final void setShow$easyfloat_release(ih0<? super View, of0> ih0Var) {
            this.show = ih0Var;
        }

        public final void setTouchEvent$easyfloat_release(mh0<? super View, ? super MotionEvent, of0> mh0Var) {
            this.touchEvent = mh0Var;
        }

        public final void show(ih0<? super View, of0> ih0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "action");
            this.show = ih0Var;
        }

        public final void touchEvent(mh0<? super View, ? super MotionEvent, of0> mh0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mh0Var, "action");
            this.touchEvent = mh0Var;
        }
    }

    public final Builder getBuilder() {
        Builder builder = this.builder;
        if (builder != null) {
            return builder;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("builder");
        throw null;
    }

    public final void registerListener(ih0<? super Builder, of0> ih0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "builder");
        Builder builder = new Builder();
        ih0Var.mo4916invoke(builder);
        this.builder = builder;
    }

    public final void setBuilder(Builder builder) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(builder, "<set-?>");
        this.builder = builder;
    }
}

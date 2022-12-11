package me.tvspark;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* renamed from: me.tvspark.qp */
/* loaded from: classes4.dex */
public final class View$OnAttachStateChangeListenerC2532qp implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NonNull View view) {
        view.removeOnAttachStateChangeListener(this);
        ViewCompat.requestApplyInsets(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}

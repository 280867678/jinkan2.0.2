package me.tvspark;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: me.tvspark.cs */
/* loaded from: classes4.dex */
public class C1994cs extends AccessibilityDelegateCompat {
    public final AccessibilityNodeInfoCompat.AccessibilityActionCompat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1994cs(Context context, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, context.getString(i));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addAction(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}

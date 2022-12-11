package androidx.activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes3.dex */
public interface OnBackPressedDispatcherOwner extends LifecycleOwner {
    @NonNull
    OnBackPressedDispatcher getOnBackPressedDispatcher();
}

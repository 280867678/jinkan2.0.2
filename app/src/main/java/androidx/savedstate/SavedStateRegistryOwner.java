package androidx.savedstate;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes3.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    @NonNull
    SavedStateRegistry getSavedStateRegistry();
}

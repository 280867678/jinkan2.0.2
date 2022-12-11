package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public abstract class ActivityResultContract<I, O> {

    /* loaded from: classes3.dex */
    public static final class SynchronousResult<T> {
        @SuppressLint({"UnknownNullness"})
        public final T mValue;

        public SynchronousResult(@SuppressLint({"UnknownNullness"}) T t) {
            this.mValue = t;
        }

        @SuppressLint({"UnknownNullness"})
        public T getValue() {
            return this.mValue;
        }
    }

    @NonNull
    public abstract Intent createIntent(@NonNull Context context, @SuppressLint({"UnknownNullness"}) I i);

    @Nullable
    public SynchronousResult<O> getSynchronousResult(@NonNull Context context, @SuppressLint({"UnknownNullness"}) I i) {
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    /* renamed from: parseResult */
    public abstract O mo4331parseResult(int i, @Nullable Intent intent);
}

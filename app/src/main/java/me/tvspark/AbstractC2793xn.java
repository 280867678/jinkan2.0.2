package me.tvspark;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.xn */
/* loaded from: classes4.dex */
public interface AbstractC2793xn<S> extends Parcelable {
    @Nullable
    S Wwwwwwwwwwwwwwwwwwwwwww();

    @NonNull
    Collection<Long> Wwwwwwwwwwwwwwwwwwwwwwww();

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j);

    @StyleRes
    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context);

    @NonNull
    View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull C2678un c2678un, @NonNull AbstractC2340lo<S> abstractC2340lo);

    @NonNull
    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context);

    @NonNull
    Collection<Pair<Long, Long>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
}

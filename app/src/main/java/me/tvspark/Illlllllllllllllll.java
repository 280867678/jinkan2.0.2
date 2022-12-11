package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* loaded from: classes4.dex */
public interface Illlllllllllllllll<T> {

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Exception exc);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable T t);
    }

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @NonNull
    Class<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    void cancel();

    @NonNull
    DataSource getDataSource();
}

package me.tvspark;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import me.tvspark.Illlllllllllllllll;

/* loaded from: classes4.dex */
public abstract class Illlllllll<T> implements Illlllllllllllllll<T> {
    public T Wwwwwwwwwwwwwwwwwwwwww;
    public final ContentResolver Wwwwwwwwwwwwwwwwwwwwwww;
    public final Uri Wwwwwwwwwwwwwwwwwwwwwwww;

    public Illlllllll(ContentResolver contentResolver, Uri uri) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = contentResolver;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = uri;
    }

    @Override // me.tvspark.Illlllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        T t = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (t != null) {
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t);
            } catch (IOException unused) {
            }
        }
    }

    public abstract T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // me.tvspark.Illlllllllllllllll
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        try {
            T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super T>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } catch (FileNotFoundException e) {
            Log.isLoggable("LocalUriFetcher", 3);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Exception) e);
        }
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) throws IOException;

    @Override // me.tvspark.Illlllllllllllllll
    public void cancel() {
    }

    @Override // me.tvspark.Illlllllllllllllll
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

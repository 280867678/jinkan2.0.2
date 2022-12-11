package me.tvspark;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;
import me.tvspark.Illlllllllllllllll;

/* loaded from: classes4.dex */
public abstract class Illlllllllllllllllll<T> implements Illlllllllllllllll<T> {
    public T Wwwwwwwwwwwwwwwwwwwwww;
    public final AssetManager Wwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwww;

    public Illlllllllllllllllll(AssetManager assetManager, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = assetManager;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // me.tvspark.Illlllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        T t = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (t == null) {
            return;
        }
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t);
        } catch (IOException unused) {
        }
    }

    public abstract T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AssetManager assetManager, String str) throws IOException;

    @Override // me.tvspark.Illlllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        try {
            T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super T>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } catch (IOException e) {
            Log.isLoggable("AssetPathFetcher", 3);
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

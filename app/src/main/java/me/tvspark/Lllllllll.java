package me.tvspark;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import me.tvspark.Illlllllllllllllll;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public final class Lllllllll implements Llllll<Uri, File> {
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Illlllllllllllllll<File> {
        public static final String[] Wwwwwwwwwwwwwwwwwwwwww = {"_data"};
        public final Uri Wwwwwwwwwwwwwwwwwwwwwww;
        public final Context Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, Uri uri) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = context;
            this.Wwwwwwwwwwwwwwwwwwwwwww = uri;
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public Class<File> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return File.class;
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super File> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Cursor query = this.Wwwwwwwwwwwwwwwwwwwwwwww.getContentResolver().query(this.Wwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwww, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (!TextUtils.isEmpty(str)) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super File>) new File(str));
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to find file path for: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Exception) new FileNotFoundException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()));
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void cancel() {
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Uri, File> {
        public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Uri, File> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Lllllllll(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public Lllllllll(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<File> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        Uri uri2 = uri;
        return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(new C2243j1(uri2), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uri2));
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri) {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
    }
}

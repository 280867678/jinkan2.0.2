package me.tvspark;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.stub.StubApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import me.tvspark.Illlllllllllllllll;
import me.tvspark.Llllll;

@RequiresApi(29)
/* renamed from: me.tvspark.Uu */
/* loaded from: classes4.dex */
public final class C1888Uu<DataT> implements Llllll<Uri, DataT> {
    public final Class<DataT> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Llllll<Uri, DataT> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Llllll<File, DataT> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.Uu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<DataT> implements Illlllllllllllllll<DataT> {
        public static final String[] Wwwwwwwwwwwwww = {"_data"};
        @Nullable
        public volatile Illlllllllllllllll<DataT> Wwwwwwwwwwwwwww;
        public volatile boolean Wwwwwwwwwwwwwwww;
        public final Class<DataT> Wwwwwwwwwwwwwwwww;
        public final Illllllllllllllllllllllll Wwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwww;
        public final Uri Wwwwwwwwwwwwwwwwwwwww;
        public final Llllll<Uri, DataT> Wwwwwwwwwwwwwwwwwwwwww;
        public final Llllll<File, DataT> Wwwwwwwwwwwwwwwwwwwwwww;
        public final Context Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, Llllll<File, DataT> llllll, Llllll<Uri, DataT> llllll2, Uri uri, int i, int i2, Illllllllllllllllllllllll illllllllllllllllllllllll, Class<DataT> cls) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.Wwwwwwwwwwwwwwwwwwwwwww = llllll;
            this.Wwwwwwwwwwwwwwwwwwwwww = llllll2;
            this.Wwwwwwwwwwwwwwwwwwwww = uri;
            this.Wwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwww = illllllllllllllllllllllll;
            this.Wwwwwwwwwwwwwwwww = cls;
        }

        @Nullable
        public final Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<DataT> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws FileNotFoundException {
            if (!Environment.isExternalStorageLegacy()) {
                return this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0 ? MediaStore.setRequireOriginal(this.Wwwwwwwwwwwwwwwwwwwww) : this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww);
            }
            Llllll<File, DataT> llllll = this.Wwwwwwwwwwwwwwwwwwwwwww;
            Uri uri = this.Wwwwwwwwwwwwwwwwwwwww;
            Cursor cursor = null;
            try {
                Cursor query = this.Wwwwwwwwwwwwwwwwwwwwwwww.getContentResolver().query(uri, Wwwwwwwwwwwwww, null, null, null);
                if (query == null || !query.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    query.close();
                    return llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww);
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Illlllllllllllllll<DataT> illlllllllllllllll = this.Wwwwwwwwwwwwwww;
            if (illlllllllllllllll != null) {
                illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public Class<DataT> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super DataT> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            try {
                Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<DataT> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Illlllllllllllllll<DataT> illlllllllllllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
                if (illlllllllllllllll == null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.Wwwwwwwwwwwwwwwwwwwww));
                    return;
                }
                this.Wwwwwwwwwwwwwww = illlllllllllllllll;
                if (this.Wwwwwwwwwwwwwwww) {
                    cancel();
                } else {
                    illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(priority, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            } catch (FileNotFoundException e) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Exception) e);
            }
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void cancel() {
            this.Wwwwwwwwwwwwwwww = true;
            Illlllllllllllllll<DataT> illlllllllllllllll = this.Wwwwwwwwwwwwwww;
            if (illlllllllllllllll != null) {
                illlllllllllllllll.cancel();
            }
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    @RequiresApi(29)
    /* renamed from: me.tvspark.Uu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            super(context, InputStream.class);
        }
    }

    @RequiresApi(29)
    /* renamed from: me.tvspark.Uu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ParcelFileDescriptor> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* renamed from: me.tvspark.Uu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<DataT> implements Lllll<Uri, DataT> {
        public final Class<DataT> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, Class<DataT> cls) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public final Llllll<Uri, DataT> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1884Ll c1884Ll) {
            return new C1888Uu(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1884Ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File.class, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), c1884Ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public C1888Uu(Context context, Llllll<File, DataT> llllll, Llllll<Uri, DataT> llllll2, Class<DataT> cls) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = llllll;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = llllll2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        Uri uri2 = uri;
        return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2243j1(uri2), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uri2, i, i2, illllllllllllllllllllllll, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
    }
}

package me.tvspark;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import me.tvspark.Illlllllllllllllll;

/* loaded from: classes4.dex */
public class Illll implements Illlllllllllllllll<InputStream> {
    public InputStream Wwwwwwwwwwwwwwwwwwwwww;
    public final Ill Wwwwwwwwwwwwwwwwwwwwwww;
    public final Uri Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Illl {
        public static final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {"_data"};
        public final ContentResolver Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ContentResolver contentResolver) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = contentResolver;
        }

        @Override // me.tvspark.Illl
        public Cursor Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Illl {
        public static final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {"_data"};
        public final ContentResolver Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ContentResolver contentResolver) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = contentResolver;
        }

        @Override // me.tvspark.Illl
        public Cursor Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    public Illll(Uri uri, Ill ill) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = uri;
        this.Wwwwwwwwwwwwwwwwwwwwwww = ill;
    }

    public static Illll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, Uri uri, Illl illl) {
        return new Illll(uri, new Ill(Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), illl, Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwww, context.getContentResolver()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0044, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
        if (r6 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0042, code lost:
        if (r6 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0047, code lost:
        r7 = null;
     */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0022: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:83:0x0022 */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws FileNotFoundException {
        Cursor cursor;
        Cursor cursor2;
        InputStream openInputStream;
        int i;
        Ill ill = this.Wwwwwwwwwwwwwwwwwwwwwww;
        Uri uri = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        Cursor cursor3 = null;
        r3 = null;
        r3 = null;
        InputStream inputStream = null;
        if (ill != null) {
            boolean z = false;
            try {
                try {
                    cursor = ill.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
                } catch (Throwable th) {
                    th = th;
                    cursor3 = cursor2;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    throw th;
                }
            } catch (SecurityException unused) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor3 != null) {
                }
                throw th;
            }
            if (cursor != null) {
                try {
                } catch (SecurityException unused2) {
                    if (Log.isLoggable("ThumbStreamOpener", 3)) {
                        String str = "Failed to query for thumbnail for Uri: " + uri;
                    }
                }
                if (cursor.moveToFirst()) {
                    String str2 = cursor.getString(0);
                    cursor.close();
                    if (!TextUtils.isEmpty(str2)) {
                        if (ill.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                            File file = new File(str2);
                            if (ill.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                                if (file.exists()) {
                                    if (ill.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                        throw null;
                                    }
                                    if (0 < file.length()) {
                                        z = true;
                                    }
                                }
                                if (z) {
                                    Uri fromFile = Uri.fromFile(file);
                                    try {
                                        openInputStream = ill.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.openInputStream(fromFile);
                                        if (openInputStream != null) {
                                            Ill ill2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                                            Uri uri2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                            try {
                                                if (ill2 == null) {
                                                    throw null;
                                                }
                                                try {
                                                    inputStream = ill2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.openInputStream(uri2);
                                                    i = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ill2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, inputStream, ill2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (IOException unused3) {
                                                        }
                                                    }
                                                } catch (IOException | NullPointerException unused4) {
                                                    if (Log.isLoggable("ThumbStreamOpener", 3)) {
                                                        String str3 = "Failed to open uri: " + uri2;
                                                    }
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (IOException unused5) {
                                                        }
                                                    }
                                                }
                                                return i != -1 ? new Illllllllllllll(openInputStream, i) : openInputStream;
                                            } catch (Throwable th3) {
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException unused6) {
                                                    }
                                                }
                                                throw th3;
                                            }
                                        }
                                        i = -1;
                                        if (i != -1) {
                                        }
                                    } catch (NullPointerException e) {
                                        throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
                                    }
                                }
                            } else {
                                throw null;
                            }
                        } else {
                            throw null;
                        }
                    }
                    openInputStream = null;
                    if (openInputStream != null) {
                    }
                    i = -1;
                    if (i != -1) {
                    }
                }
            }
        } else {
            throw null;
        }
    }

    @Override // me.tvspark.Illlllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        InputStream inputStream = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // me.tvspark.Illlllllllllllllll
    @NonNull
    public Class<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return InputStream.class;
    }

    @Override // me.tvspark.Illlllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super InputStream> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        try {
            InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super InputStream>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } catch (FileNotFoundException e) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Exception) e);
        }
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

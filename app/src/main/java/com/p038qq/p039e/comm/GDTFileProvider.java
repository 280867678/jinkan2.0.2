package com.p038qq.p039e.comm;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;
import org.apache.commons.p056io.input.Tailer;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.qq.e.comm.GDTFileProvider */
/* loaded from: classes3.dex */
public class GDTFileProvider extends ContentProvider {
    public AbstractC1056a Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final String[] Wwwwwwwwwwwwwwwwwwwwwww = {"_display_name", "_size"};
    public static final File Wwwwwwwwwwwwwwwwwwwwww = new File(File.separator);
    public static HashMap<String, AbstractC1056a> Wwwwwwwwwwwwwwwwwwwww = new HashMap<>();

    /* renamed from: com.qq.e.comm.GDTFileProvider$a */
    /* loaded from: classes3.dex */
    public interface AbstractC1056a {
        /* renamed from: a */
        Uri mo3665a(File file);

        /* renamed from: a */
        File mo3666a(Uri uri);
    }

    /* renamed from: com.qq.e.comm.GDTFileProvider$b */
    /* loaded from: classes3.dex */
    public static class C1057b implements AbstractC1056a {
        public final HashMap<String, File> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public C1057b(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // com.p038qq.p039e.comm.GDTFileProvider.AbstractC1056a
        /* renamed from: a */
        public Uri mo3665a(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to find configured root that contains ", canonicalPath));
                }
                String path2 = entry.getValue().getPath();
                boolean endsWith = path2.endsWith("/");
                int length = path2.length();
                if (!endsWith) {
                    length++;
                }
                String substring = canonicalPath.substring(length);
                return new Uri.Builder().scheme("content").authority(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to resolve canonical path for ", file));
            }
        }

        @Override // com.p038qq.p039e.comm.GDTFileProvider.AbstractC1056a
        /* renamed from: a */
        public File mo3666a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (!canonicalFile.getPath().startsWith(file.getPath())) {
                        throw new SecurityException("Resolved path jumped beyond configured root");
                    }
                    return canonicalFile;
                } catch (IOException unused) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to resolve canonical path for ", file2));
                }
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to find configured root for ", uri));
        }
    }

    public static AbstractC1056a Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) throws IOException, XmlPullParserException {
        C1057b c1057b = new C1057b(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), FileProvider.META_DATA_FILE_PROVIDER_PATHS);
        if (loadXmlMetaData != null) {
            while (true) {
                int next = loadXmlMetaData.next();
                if (next == 1) {
                    loadXmlMetaData.close();
                    return c1057b;
                } else if (next == 2) {
                    String name = loadXmlMetaData.getName();
                    File file = null;
                    String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                    String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                    if (FileProvider.TAG_ROOT_PATH.equals(name)) {
                        file = Wwwwwwwwwwwwwwwwwwwwww;
                    } else if (FileProvider.TAG_FILES_PATH.equals(name)) {
                        file = context.getFilesDir();
                    } else if (FileProvider.TAG_CACHE_PATH.equals(name)) {
                        file = context.getCacheDir();
                    } else if (FileProvider.TAG_EXTERNAL.equals(name)) {
                        file = Environment.getExternalStorageDirectory();
                    } else if (FileProvider.TAG_EXTERNAL_FILES.equals(name)) {
                        File[] externalFilesDirs = context.getExternalFilesDirs(null);
                        if (externalFilesDirs.length > 0) {
                            file = externalFilesDirs[0];
                        }
                    } else if (FileProvider.TAG_EXTERNAL_CACHE.equals(name)) {
                        File[] externalCacheDirs = getExternalCacheDirs(context);
                        if (externalCacheDirs.length > 0) {
                            file = externalCacheDirs[0];
                        }
                    } else if (FileProvider.TAG_EXTERNAL_MEDIA.equals(name)) {
                        File[] externalMediaDirs = context.getExternalMediaDirs();
                        if (externalMediaDirs.length > 0) {
                            file = externalMediaDirs[0];
                        }
                    }
                    if (file != null) {
                        String[] strArr = {attributeValue2};
                        for (int i = 0; i < 1; i++) {
                            String str2 = strArr[i];
                            if (str2 != null) {
                                file = new File(file, str2);
                            }
                        }
                        if (TextUtils.isEmpty(attributeValue)) {
                            throw new IllegalArgumentException("Name must not be empty");
                        }
                        try {
                            c1057b.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(attributeValue, file.getCanonicalFile());
                        } catch (IOException e) {
                            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to resolve canonical path for ", file), e);
                        }
                    } else {
                        continue;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
    }

    public static AbstractC1056a Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        AbstractC1056a abstractC1056a;
        synchronized (Wwwwwwwwwwwwwwwwwwwww) {
            abstractC1056a = Wwwwwwwwwwwwwwwwwwwww.get(str);
            if (abstractC1056a == null) {
                try {
                    abstractC1056a = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, str);
                    Wwwwwwwwwwwwwwwwwwwww.put(str, abstractC1056a);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return abstractC1056a;
    }

    public static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        Uri uri = Uri.EMPTY;
        try {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, str).mo3665a(file);
        } catch (Throwable unused) {
            return uri;
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (!providerInfo.grantUriPermissions) {
                throw new SecurityException("Provider must grant uri permissions");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, providerInfo.authority);
            return;
        }
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.mo3666a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File mo3666a = this.Wwwwwwwwwwwwwwwwwwwwwwww.mo3666a(uri);
        int lastIndexOf = mo3666a.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(mo3666a.getName().substring(lastIndexOf + 1));
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        int i;
        File mo3666a = this.Wwwwwwwwwwwwwwwwwwwwwwww.mo3666a(uri);
        if (Tailer.RAF_MODE.equals(str)) {
            i = 268435456;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i = 738197504;
        } else if ("wa".equals(str)) {
            i = 704643072;
        } else if ("rw".equals(str)) {
            i = 939524096;
        } else if (!"rwt".equals(str)) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid mode: ", str));
        } else {
            i = 1006632960;
        }
        return ParcelFileDescriptor.open(mo3666a, i);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File mo3666a = this.Wwwwwwwwwwwwwwwwwwwwwwww.mo3666a(uri);
        if (strArr == null) {
            strArr = Wwwwwwwwwwwwwwwwwwwwwww;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = mo3666a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(mo3666a.length());
            }
            i2 = i;
        }
        String[] strArr4 = new String[i2];
        System.arraycopy(strArr3, 0, strArr4, 0, i2);
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}

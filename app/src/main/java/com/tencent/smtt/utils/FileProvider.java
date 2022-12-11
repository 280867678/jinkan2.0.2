package com.tencent.smtt.utils;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.stub.StubApp;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;
import org.apache.commons.p056io.input.Tailer;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: a */
    public static final String[] f2361a = {"_display_name", "_size"};

    /* renamed from: b */
    public static final File f2362b = new File("/");

    /* renamed from: c */
    public static HashMap<String, AbstractC1421a> f2363c = new HashMap<>();

    /* renamed from: d */
    public AbstractC1421a f2364d;

    /* renamed from: com.tencent.smtt.utils.FileProvider$a */
    /* loaded from: classes4.dex */
    public interface AbstractC1421a {
        /* renamed from: a */
        Uri mo2201a(File file);

        /* renamed from: a */
        File mo2202a(Uri uri);
    }

    /* renamed from: com.tencent.smtt.utils.FileProvider$b */
    /* loaded from: classes4.dex */
    public static class C1422b implements AbstractC1421a {

        /* renamed from: a */
        public final String f2365a;

        /* renamed from: b */
        public final HashMap<String, File> f2366b = new HashMap<>();

        public C1422b(String str) {
            this.f2365a = str;
        }

        @Override // com.tencent.smtt.utils.FileProvider.AbstractC1421a
        /* renamed from: a */
        public Uri mo2201a(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f2366b.entrySet()) {
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
                return new Uri.Builder().scheme("content").authority(this.f2365a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to resolve canonical path for ", file));
            }
        }

        @Override // com.tencent.smtt.utils.FileProvider.AbstractC1421a
        /* renamed from: a */
        public File mo2202a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f2366b.get(decode);
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

        /* renamed from: a */
        public void m2200a(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f2366b.put(str, file.getCanonicalFile());
                    return;
                } catch (IOException e) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to resolve canonical path for ", file), e);
                }
            }
            throw new IllegalArgumentException("Name must not be empty");
        }
    }

    /* renamed from: a */
    public static int m2207a(String str) {
        if (Tailer.RAF_MODE.equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if (!"rwt".equals(str)) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid mode: ", str));
        }
        return 1006632960;
    }

    /* renamed from: a */
    public static Uri m2211a(Context context, File file) {
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                str = context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), "androidx.core.content.FileProvider"), 0).authority;
            } catch (Exception e) {
                e.printStackTrace();
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                Method declaredMethod = Class.forName("androidx.core.content.FileProvider").getDeclaredMethod("getUriForFile", Context.class, String.class, File.class);
                if (declaredMethod == null) {
                    return null;
                }
                Object invoke = declaredMethod.invoke(null, context, str, file);
                if (!(invoke instanceof Uri)) {
                    return null;
                }
                return (Uri) invoke;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Uri m2210a(Context context, String str) {
        Uri uri = null;
        if (context != null && StubApp.getOrigApplicationContext(context.getApplicationContext()) != null && TbsConfig.APP_QQ.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().packageName)) {
            try {
                return (Uri) C1460i.m2052a(Class.forName("com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper"), "getUriForFile", (Class<?>[]) new Class[]{Context.class, File.class}, context, new File(str));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24 && (uri = m2211a(context, new File(str))) == null && QbSdk.checkContentProviderPrivilage(context)) {
            uri = m2209a(context, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), context.getApplicationInfo().packageName, ".provider"), new File(str));
        }
        if (uri != null) {
            return uri;
        }
        try {
            return Uri.fromFile(new File(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return uri;
        }
    }

    /* renamed from: a */
    public static Uri m2209a(Context context, String str, File file) {
        return m2204b(context, str).mo2201a(file);
    }

    /* renamed from: a */
    public static File m2208a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    /* renamed from: a */
    public static Object[] m2206a(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    /* renamed from: a */
    public static String[] m2205a(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    /* renamed from: b */
    public static AbstractC1421a m2204b(Context context, String str) {
        AbstractC1421a abstractC1421a;
        synchronized (f2363c) {
            abstractC1421a = f2363c.get(str);
            if (abstractC1421a == null) {
                try {
                    abstractC1421a = m2203c(context, str);
                    f2363c.put(str, abstractC1421a);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return abstractC1421a;
    }

    /* renamed from: c */
    public static AbstractC1421a m2203c(Context context, String str) throws IOException, XmlPullParserException {
        C1422b c1422b = new C1422b(str);
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (resolveContentProvider != null) {
            XmlResourceParser loadXmlMetaData = resolveContentProvider.loadXmlMetaData(context.getPackageManager(), androidx.core.content.FileProvider.META_DATA_FILE_PROVIDER_PATHS);
            if (loadXmlMetaData == null) {
                throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            }
            while (true) {
                int next = loadXmlMetaData.next();
                if (next == 1) {
                    return c1422b;
                }
                if (next == 2) {
                    String name = loadXmlMetaData.getName();
                    File file = null;
                    String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                    String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                    if (androidx.core.content.FileProvider.TAG_ROOT_PATH.equals(name)) {
                        file = m2208a(f2362b, attributeValue2);
                    } else if (androidx.core.content.FileProvider.TAG_FILES_PATH.equals(name)) {
                        file = m2208a(context.getFilesDir(), attributeValue2);
                    } else if (androidx.core.content.FileProvider.TAG_CACHE_PATH.equals(name)) {
                        file = m2208a(context.getCacheDir(), attributeValue2);
                    } else if (androidx.core.content.FileProvider.TAG_EXTERNAL.equals(name)) {
                        if (context.getApplicationInfo().packageName.contains(TbsConfig.APP_QQ)) {
                            file = m2208a(new File(Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + context.getApplicationInfo().packageName), attributeValue2);
                        } else {
                            file = m2208a(Environment.getExternalStorageDirectory(), attributeValue2);
                        }
                    }
                    if (file != null) {
                        c1422b.m2200a(attributeValue, file);
                    }
                }
            }
        } else {
            throw new RuntimeException("Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (!providerInfo.grantUriPermissions) {
                throw new SecurityException("Provider must grant uri permissions");
            }
            this.f2364d = m2204b(context, providerInfo.authority);
            return;
        }
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f2364d.mo2202a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File mo2202a = this.f2364d.mo2202a(uri);
        int lastIndexOf = mo2202a.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(mo2202a.getName().substring(lastIndexOf + 1));
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
        return ParcelFileDescriptor.open(this.f2364d.mo2202a(uri), m2207a(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File mo2202a = this.f2364d.mo2202a(uri);
        if (strArr == null) {
            strArr = f2361a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = mo2202a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(mo2202a.length());
            }
            i2 = i;
        }
        String[] m2205a = m2205a(strArr3, i2);
        Object[] m2206a = m2206a(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(m2205a, 1);
        matrixCursor.addRow(m2206a);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}

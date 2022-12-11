package com.just.agentweb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.p003os.EnvironmentCompat;
import androidx.loader.content.CursorLoader;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.stub.StubApp;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import me.tvspark.C2195hr;
import me.tvspark.View$OnClickListenerC2158gr;
import me.tvspark.outline;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes3.dex */
public class AgentWebUtils {
    public static final String TAG = "AgentWebUtils";
    public static Handler mHandler;
    public static Toast mToast;
    public static WeakReference<Snackbar> snackbarWeakReference;

    public AgentWebUtils() {
        throw new UnsupportedOperationException("u can't init me");
    }

    public static boolean checkNetwork(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static int checkNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            return (type == 1 || type == 6 || type == 9) ? 1 : 0;
        }
        int subtype = activeNetworkInfo.getSubtype();
        switch (subtype) {
            case 1:
            case 2:
                return 4;
            case 3:
            case 4:
            case 5:
            case 6:
                return 3;
            default:
                switch (subtype) {
                    case 12:
                        return 3;
                    case 13:
                    case 14:
                    case 15:
                        return 2;
                    default:
                        return 0;
                }
        }
    }

    public static boolean checkWifi(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    public static void clearAgentWebCache(Context context) {
        try {
            clearCacheFolder(new File(getAgentWebFilePath(context)), 0);
        } catch (Throwable th) {
            if (!LogUtils.isDebug()) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static void clearCache(Context context, int i) {
        String.format("Starting cache prune, deleting files older than %d days", Integer.valueOf(i));
        String.format("Cache pruning completed, %d files deleted", Integer.valueOf(clearCacheFolder(context.getCacheDir(), i)));
    }

    public static int clearCacheFolder(File file, int i) {
        int i2;
        File[] listFiles;
        if (file != null) {
            file.getAbsolutePath();
        }
        if (file == null || !file.isDirectory()) {
            return 0;
        }
        try {
            i2 = 0;
            for (File file2 : file.listFiles()) {
                try {
                    if (file2.isDirectory()) {
                        i2 += clearCacheFolder(file2, i);
                    }
                    if (file2.lastModified() < new Date().getTime() - (i * 86400000)) {
                        file2.getName();
                        if (file2.delete()) {
                            i2++;
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    String.format("Failed to clean the cache, result %s", e.getMessage());
                    return i2;
                }
            }
        } catch (Exception e2) {
            e = e2;
            i2 = 0;
        }
        return i2;
    }

    public static final void clearWebView(WebView webView) {
        if (webView != null && Looper.myLooper() == Looper.getMainLooper()) {
            webView.loadUrl("about:blank");
            webView.stopLoading();
            if (webView.getHandler() != null) {
                webView.getHandler().removeCallbacksAndMessages(null);
            }
            webView.removeAllViews();
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            webView.setTag(null);
            webView.clearHistory();
            webView.destroy();
        }
    }

    public static void clearWebViewAllCache(Context context) {
        try {
            clearWebViewAllCache(context, new LollipopFixedWebView(StubApp.getOrigApplicationContext(context.getApplicationContext())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearWebViewAllCache(Context context, WebView webView) {
        try {
            AgentWebConfig.removeAllCookies(null);
            webView.getSettings().setCacheMode(2);
            context.deleteDatabase("webviewCache.db");
            context.deleteDatabase("webview.db");
            webView.clearCache(true);
            webView.clearHistory();
            webView.clearFormData();
            clearCacheFolder(new File(AgentWebConfig.getCachePath(context)), 0);
        } catch (Exception e) {
            if (!AgentWebConfig.DEBUG) {
                return;
            }
            e.printStackTrace();
        }
    }

    public static void closeIO(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static File createFileByName(Context context, String str, boolean z) throws IOException {
        String agentWebFilePath = getAgentWebFilePath(context);
        if (TextUtils.isEmpty(agentWebFilePath)) {
            return null;
        }
        File file = new File(agentWebFilePath, str);
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            return file;
        }
        file.createNewFile();
        return file;
    }

    public static File createImageFile(Context context) {
        try {
            return createFileByName(context, String.format("aw_%s.jpg", new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date())), true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static File createVideoFile(Context context) {
        try {
            return createFileByName(context, String.format("aw_%s.mp4", new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date())), true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void dismiss() {
        WeakReference<Snackbar> weakReference = snackbarWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        snackbarWeakReference.get().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
        snackbarWeakReference = null;
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String getAgentWebFilePath(Context context) {
        if (!TextUtils.isEmpty(AgentWebConfig.AGENTWEB_FILE_PATH)) {
            return AgentWebConfig.AGENTWEB_FILE_PATH;
        }
        File file = new File(getDiskExternalCacheDir(context), AgentWebConfig.FILE_CACHE_PATH);
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable unused) {
            LogUtils.m3701i(TAG, "create dir exception");
        }
        String str = TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("path:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file.getAbsolutePath());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("  path:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file.getPath());
        LogUtils.m3701i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        String absolutePath = file.getAbsolutePath();
        AgentWebConfig.AGENTWEB_FILE_PATH = absolutePath;
        return absolutePath;
    }

    public static AbsAgentWebUIController getAgentWebUIControllerByWebView(WebView webView) {
        return getWebParentLayoutByWebView(webView).mo4828provide();
    }

    public static String getApplicationName(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static long getAvailableStorage() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().toString());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (RuntimeException unused) {
            return 0L;
        }
    }

    public static Intent getCommonFileIntentCompat(Context context, File file) {
        Intent action = new Intent().setAction("android.intent.action.VIEW");
        setIntentDataAndType(context, action, getMIMEType(file), file, false);
        return action;
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        query.close();
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static List<String> getDeniedPermissions(Activity activity, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            if (!hasPermission(activity, strArr[i])) {
                arrayList.add(strArr[i]);
            }
        }
        return arrayList;
    }

    public static String getDiskExternalCacheDir(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if ("mounted".equals(EnvironmentCompat.getStorageState(externalCacheDir))) {
            return externalCacheDir.getAbsolutePath();
        }
        return null;
    }

    @TargetApi(19)
    public static String getFileAbsolutePath(Activity activity, Uri uri) {
        Uri uri2 = null;
        if (activity != null && uri != null) {
            if (!DocumentsContract.isDocumentUri(activity, uri)) {
                String authority = uri.getAuthority();
                if (authority.equalsIgnoreCase(activity.getPackageName() + ".AgentWebFileProvider")) {
                    String path = uri.getPath();
                    int lastIndexOf = path.lastIndexOf("/");
                    return getAgentWebFilePath(activity) + File.separator + path.substring(lastIndexOf + 1, path.length());
                } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                    return isGooglePhotosUri(uri) ? uri.getLastPathSegment() : getDataColumn(activity, uri, null, null);
                } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            } else if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                return getDataColumn(activity, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            } else {
                if (isMediaDocument(uri)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(activity, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        }
        return null;
    }

    public static Intent getInstallApkIntentCompat(Context context, File file) {
        Intent action = new Intent().setAction("android.intent.action.VIEW");
        setIntentDataAndType(context, action, "application/vnd.android.package-archive", file, false);
        return action;
    }

    public static Intent getIntentCaptureCompat(Context context, File file) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri uriFromFile = getUriFromFile(context, file);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("output", uriFromFile);
        return intent;
    }

    public static Intent getIntentVideoCompat(Context context, File file) {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        Uri uriFromFile = getUriFromFile(context, file);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("output", uriFromFile);
        return intent;
    }

    public static String getMIMEType(File file) {
        String name = file.getName();
        String lowerCase = name.substring(name.lastIndexOf(".") + 1, name.length()).toLowerCase();
        return lowerCase.equals("pdf") ? "application/pdf" : (lowerCase.equals("m4a") || lowerCase.equals("mp3") || lowerCase.equals("mid") || lowerCase.equals("xmf") || lowerCase.equals("ogg") || lowerCase.equals("wav")) ? "audio/*" : (lowerCase.equals("3gp") || lowerCase.equals("mp4")) ? "video/*" : (lowerCase.equals("jpg") || lowerCase.equals("gif") || lowerCase.equals("png") || lowerCase.equals("jpeg") || lowerCase.equals("bmp")) ? "image/*" : lowerCase.equals("apk") ? "application/vnd.android.package-archive" : (lowerCase.equals("pptx") || lowerCase.equals("ppt")) ? "application/vnd.ms-powerpoint" : (lowerCase.equals("docx") || lowerCase.equals("doc")) ? "application/vnd.ms-word" : (lowerCase.equals("xlsx") || lowerCase.equals("xls")) ? "application/vnd.ms-excel" : "*/*";
    }

    public static String getRealPathBelowVersion(Context context, Uri uri) {
        String str;
        String str2 = TAG;
        LogUtils.m3701i(str2, "method -> getRealPathBelowVersion " + uri + "   path:" + uri.getPath() + "    getAuthority:" + uri.getAuthority());
        String[] strArr = {"_data"};
        Cursor mo4340loadInBackground = new CursorLoader(context, uri, strArr, null, null, null).mo4340loadInBackground();
        if (mo4340loadInBackground != null) {
            mo4340loadInBackground.moveToFirst();
            str = mo4340loadInBackground.getString(mo4340loadInBackground.getColumnIndex(strArr[0]));
            mo4340loadInBackground.close();
        } else {
            str = null;
        }
        return str == null ? uri.getPath() : str;
    }

    @Deprecated
    public static void getUIControllerAndShowMessage(Activity activity, String str, String str2) {
        AbsAgentWebUIController mo4828provide;
        if (activity == null || activity.isFinishing() || (mo4828provide = ((WebParentLayout) activity.findViewById(C1020R.C1021id.web_parent_layout_id)).mo4828provide()) == null) {
            return;
        }
        mo4828provide.onShowMessage(str, str2);
    }

    public static Uri getUriFromFile(Context context, File file) {
        return Build.VERSION.SDK_INT >= 24 ? getUriFromFileForN(context, file) : Uri.fromFile(file);
    }

    public static Uri getUriFromFileForN(Context context, File file) {
        return FileProvider.getUriForFile(context, context.getPackageName() + ".AgentWebFileProvider", file);
    }

    public static WebParentLayout getWebParentLayoutByWebView(WebView webView) {
        if (webView.getParent() instanceof ViewGroup) {
            ViewParent parent = webView.getParent();
            while (true) {
                for (ViewGroup viewGroup = (ViewGroup) parent; viewGroup != null; viewGroup = null) {
                    String str = TAG;
                    LogUtils.m3701i(str, "ViewGroup:" + viewGroup);
                    if (viewGroup.getId() == C1020R.C1021id.web_parent_layout_id) {
                        WebParentLayout webParentLayout = (WebParentLayout) viewGroup;
                        LogUtils.m3701i(TAG, "found WebParentLayout");
                        return webParentLayout;
                    }
                    parent = viewGroup.getParent();
                    if (parent instanceof ViewGroup) {
                        break;
                    }
                }
                throw new IllegalStateException("please check webcreator's create method was be called ?");
            }
        }
        throw new IllegalStateException("please check webcreator's create method was be called ?");
    }

    public static void grantPermissions(Context context, Intent intent, Uri uri, boolean z) {
        int i = z ? 3 : 1;
        intent.addFlags(i);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, i);
        }
    }

    public static boolean hasPermission(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : list) {
            if (ContextCompat.checkSelfPermission(context, str) == -1) {
                return false;
            }
            String permissionToOp = AppOpsManagerCompat.permissionToOp(str);
            if (!TextUtils.isEmpty(permissionToOp) && AppOpsManagerCompat.noteProxyOp(context, permissionToOp, context.getPackageName()) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasPermission(@NonNull Context context, @NonNull String... strArr) {
        return hasPermission(context, Arrays.asList(strArr));
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isEmptyCollection(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmptyMap(Map map) {
        return map == null || map.isEmpty();
    }

    public static Method isExistMethod(Object obj, String str, Class... clsArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (str.startsWith("[")) {
                new JSONArray(str);
            } else {
                new JSONObject(str);
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isOverriedMethod(Object obj, String str, String str2, Class... clsArr) {
        LogUtils.m3701i(TAG, "  methodName:" + str + "   method:" + str2);
        boolean z = false;
        if (obj == null) {
            return false;
        }
        try {
            z = !obj.getClass().getMethod(str, clsArr).toGenericString().contains(str2);
        } catch (Exception e) {
            if (LogUtils.isDebug()) {
                e.printStackTrace();
            }
        }
        LogUtils.m3701i(TAG, "isOverriedMethod:" + z);
        return z;
    }

    public static boolean isUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
            messageDigest.update(str.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Exception e) {
            if (!LogUtils.isDebug()) {
                return "";
            }
            e.printStackTrace();
            return "";
        }
    }

    public static void runInUiThread(Runnable runnable) {
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
        }
        mHandler.post(runnable);
    }

    public static void setIntentData(Context context, Intent intent, File file, boolean z) {
        if (Build.VERSION.SDK_INT < 24) {
            intent.setData(Uri.fromFile(file));
            return;
        }
        intent.setData(getUriFromFile(context, file));
        intent.addFlags(1);
        if (!z) {
            return;
        }
        intent.addFlags(2);
    }

    public static void setIntentDataAndType(Context context, Intent intent, String str, File file, boolean z) {
        if (Build.VERSION.SDK_INT < 24) {
            intent.setDataAndType(Uri.fromFile(file), str);
            return;
        }
        intent.setDataAndType(getUriFromFile(context, file), str);
        intent.addFlags(1);
        if (!z) {
            return;
        }
        intent.addFlags(2);
    }

    public static void show(View view, CharSequence charSequence, int i, @ColorInt int i2, @ColorInt int i3, CharSequence charSequence2, @ColorInt int i4, View.OnClickListener onClickListener) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i2), 0, spannableString.length(), 33);
        WeakReference<Snackbar> weakReference = new WeakReference<>(Snackbar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, spannableString, i));
        snackbarWeakReference = weakReference;
        Snackbar snackbar = weakReference.get();
        snackbar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setBackgroundColor(i3);
        if (charSequence2 != null && charSequence2.length() > 0 && onClickListener != null) {
            ((SnackbarContentLayout) snackbar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getChildAt(0)).getActionView().setTextColor(i4);
            Button actionView = ((SnackbarContentLayout) snackbar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getChildAt(0)).getActionView();
            if (!TextUtils.isEmpty(charSequence2)) {
                snackbar.Wwwwwwwwwwwwwwww = true;
                actionView.setVisibility(0);
                actionView.setText(charSequence2);
                actionView.setOnClickListener(new View$OnClickListenerC2158gr(snackbar, onClickListener));
            } else {
                actionView.setVisibility(8);
                actionView.setOnClickListener(null);
                snackbar.Wwwwwwwwwwwwwwww = false;
            }
        }
        C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(snackbar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), snackbar.Wwwwwwwwwwwwwwwwwwww);
    }

    public static boolean showFileChooserCompat(Activity activity, WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams, PermissionInterceptor permissionInterceptor, ValueCallback valueCallback2, String str, Handler.Callback callback) {
        try {
            Object invoke = Class.forName("com.just.agentweb.filechooser.FileChooser").getDeclaredMethod("newBuilder", Activity.class, WebView.class).invoke(null, activity, webView);
            Class<?> cls = invoke.getClass();
            if (valueCallback != null) {
                Method declaredMethod = cls.getDeclaredMethod("setUriValueCallbacks", ValueCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(invoke, valueCallback);
            }
            if (fileChooserParams != null) {
                Method declaredMethod2 = cls.getDeclaredMethod("setFileChooserParams", WebChromeClient.FileChooserParams.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(invoke, fileChooserParams);
            }
            if (valueCallback2 != null) {
                Method declaredMethod3 = cls.getDeclaredMethod("setUriValueCallback", ValueCallback.class);
                declaredMethod3.setAccessible(true);
                declaredMethod3.invoke(invoke, valueCallback2);
            }
            if (!TextUtils.isEmpty(str)) {
                Method declaredMethod4 = cls.getDeclaredMethod("setAcceptType", String.class);
                declaredMethod4.setAccessible(true);
                declaredMethod4.invoke(invoke, str);
            }
            if (callback != null) {
                Method declaredMethod5 = cls.getDeclaredMethod("setJsChannelCallback", Handler.Callback.class);
                declaredMethod5.setAccessible(true);
                declaredMethod5.invoke(invoke, callback);
            }
            Method declaredMethod6 = cls.getDeclaredMethod("setPermissionInterceptor", PermissionInterceptor.class);
            declaredMethod6.setAccessible(true);
            declaredMethod6.invoke(invoke, permissionInterceptor);
            Method declaredMethod7 = cls.getDeclaredMethod("build", new Class[0]);
            declaredMethod7.setAccessible(true);
            Object invoke2 = declaredMethod7.invoke(invoke, new Object[0]);
            Method declaredMethod8 = invoke2.getClass().getDeclaredMethod("openFileChooser", new Class[0]);
            declaredMethod8.setAccessible(true);
            declaredMethod8.invoke(invoke2, new Object[0]);
        } catch (Throwable th) {
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
            if (th instanceof ClassNotFoundException) {
                LogUtils.m3703e(TAG, "Please check whether compile'com.just.agentweb:filechooser:x.x.x' dependency was added.");
            }
            if (valueCallback != null) {
                LogUtils.m3701i(TAG, "onReceiveValue empty");
                return false;
            } else if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(null);
            }
        }
        return true;
    }

    public static void toastShowShort(Context context, String str) {
        Toast toast = mToast;
        if (toast == null) {
            mToast = Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), str, 0);
        } else {
            toast.setText(str);
        }
        mToast.show();
    }

    public static String[] uriToPath(Activity activity, Uri[] uriArr) {
        if (activity != null && uriArr != null && uriArr.length != 0) {
            try {
                String[] strArr = new String[uriArr.length];
                int length = uriArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i2 + 1;
                    strArr[i2] = getFileAbsolutePath(activity, uriArr[i]);
                    i++;
                    i2 = i3;
                }
                return strArr;
            } catch (Throwable th) {
                if (LogUtils.isDebug()) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }
}

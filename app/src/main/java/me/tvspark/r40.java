package me.tvspark;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.google.common.hash.Murmur3_32HashFunction;
import com.just.agentweb.RomUtils;
import com.meituan.android.walle.SignatureNotFoundException;
import com.p046uc.crashsdk.export.LogType;
import com.stub.StubApp;
import io.reactivex.disposables.FutureDisposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.X509TrustManager;
import kotlin.Pair;
import kotlin.Result;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import me.tvspark.model.impl.IHttpGetApi;
import me.tvspark.model.impl.IHttpPostApi;
import me.tvspark.tx0;
import me.tvspark.utils.SKUtils;
import me.tvspark.utils.statusbarutils.OSInfo$OSType;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.p054ws.WebSocketProtocol;
import org.antlr.p055v4.runtime.CodePointBuffer;
import org.apache.commons.p056io.input.Tailer;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.simpleframework.xml.transform.ClassTransform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import sun.misc.ServiceConfigurationError;

/* loaded from: classes4.dex */
public class r40 {
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public static String Wwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        return substring.substring(0, substring.lastIndexOf("."));
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwww(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
        } catch (Exception unused) {
        }
        String str2 = "titav2://";
        if (!str.startsWith(str2)) {
            str2 = "whalev2://";
            if (!str.startsWith(str2)) {
                return str;
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.replace(str2, "").substring(10), true);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static IHttpGetApi Wwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String str2;
        try {
            URL url = new URL(str);
            str2 = String.format("%s://%s", url.getProtocol(), url.getHost());
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "");
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (int) (i / Resources.getSystem().getDisplayMetrics().density);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return readLine;
            } catch (IOException unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int indexOf = str.indexOf(46);
        int indexOf2 = indexOf >= 0 ? str.indexOf(46, indexOf + 1) : -1;
        int indexOf3 = str.indexOf(45);
        int length = str.length();
        if (indexOf2 >= 0) {
            length = Math.min(length, indexOf2);
        }
        if (indexOf3 >= 0) {
            length = Math.min(length, indexOf3);
        }
        return str.substring(0, length);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Toast.makeText(context, "请关闭网络代理后重试", 1).show();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static k51[] Wwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        k51[] k51VarArr = new k51[i];
        for (int i2 = 0; i2 < i; i2++) {
            k51VarArr[i2] = new k51();
        }
        return k51VarArr;
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i >= 1073741824) {
            return Integer.MAX_VALUE;
        }
        return (int) ((i / 0.75f) + 1.0f);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : Build.VERSION.SDK_INT >= 23 ? (int) (TypedValue.applyDimension(1, 24.0f, context.getResources().getDisplayMetrics()) + 0.5f) : (int) (TypedValue.applyDimension(1, 25.0f, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int length = str.length();
        char[] cArr = new char[length + 3];
        cArr[0] = 'g';
        cArr[1] = 'e';
        cArr[2] = 't';
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            charAt = (char) (charAt - ' ');
        }
        cArr[3] = charAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 3] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    @NonNull
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf == -1 ? "" : str.substring(lastIndexOf + 1, str.length()).toLowerCase(Locale.getDefault());
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i == 3 || i == 4;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("whalev2://");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10));
        if (str != null && str.length() != 0) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(str.getBytes());
                gZIPOutputStream.close();
                str2 = zu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteArrayOutputStream.toByteArray());
                try {
                    byteArrayOutputStream.close();
                    byteArrayOutputStream2 = gZIPOutputStream;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    byteArrayOutputStream2 = e2;
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                e.printStackTrace();
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                str2 = "";
                byteArrayOutputStream2 = byteArrayOutputStream2;
                str = SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str);
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            str = SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) throws Exception {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                j += listFiles[i].isDirectory() ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(listFiles[i]) : listFiles[i].length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("More produced than requested: ", j3)));
                j3 = 0;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }

    public static Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        try {
            return Class.forName(str.replace('/', '.'));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static OSInfo$OSType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com_github_xubo_statusbarutils_os_sp", 0);
        int i8 = sharedPreferences.getInt("os_type", -1);
        if (i8 != -1) {
            if (i8 != 0) {
                if (i8 == 1) {
                    return OSInfo$OSType.OS_TYPE_EMUI;
                }
                if (i8 == 2) {
                    return OSInfo$OSType.OS_TYPE_MIUI;
                }
                if (i8 == 3) {
                    return OSInfo$OSType.OS_TYPE_FLYME;
                }
                if (i8 == 4) {
                    return OSInfo$OSType.OS_TYPE_COLOR;
                }
                if (i8 == 5) {
                    return OSInfo$OSType.OS_TYPE_FUNTOUCH;
                }
            }
            return OSInfo$OSType.OS_TYPE_OTHER;
        } else if (Build.DISPLAY.toUpperCase().contains("FLYME")) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            i7 = OSInfo$OSType.OS_TYPE_FLYME.value;
            edit.putInt("os_type", i7).commit();
            return OSInfo$OSType.OS_TYPE_FLYME;
        } else if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwww("ro.miui.ui.version.name"))) {
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            i6 = OSInfo$OSType.OS_TYPE_MIUI.value;
            edit2.putInt("os_type", i6).commit();
            return OSInfo$OSType.OS_TYPE_MIUI;
        } else if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwww(RomUtils.VERSION_PROPERTY_HUAWEI))) {
            SharedPreferences.Editor edit3 = sharedPreferences.edit();
            i5 = OSInfo$OSType.OS_TYPE_EMUI.value;
            edit3.putInt("os_type", i5).commit();
            return OSInfo$OSType.OS_TYPE_EMUI;
        } else if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwww("ro.meizu.setupwizard.flyme"))) {
            SharedPreferences.Editor edit4 = sharedPreferences.edit();
            i4 = OSInfo$OSType.OS_TYPE_FLYME.value;
            edit4.putInt("os_type", i4).commit();
            return OSInfo$OSType.OS_TYPE_FLYME;
        } else if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwww("ro.build.version.opporom"))) {
            SharedPreferences.Editor edit5 = sharedPreferences.edit();
            i3 = OSInfo$OSType.OS_TYPE_COLOR.value;
            edit5.putInt("os_type", i3).commit();
            return OSInfo$OSType.OS_TYPE_COLOR;
        } else {
            boolean isEmpty = TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwww("ro.vivo.os.version"));
            SharedPreferences.Editor edit6 = sharedPreferences.edit();
            if (!isEmpty) {
                i2 = OSInfo$OSType.OS_TYPE_FUNTOUCH.value;
                edit6.putInt("os_type", i2).commit();
                return OSInfo$OSType.OS_TYPE_FUNTOUCH;
            }
            i = OSInfo$OSType.OS_TYPE_OTHER.value;
            edit6.putInt("os_type", i).commit();
            return OSInfo$OSType.OS_TYPE_OTHER;
        }
    }

    public static final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int i3 = i2 * Murmur3_32HashFunction.f585C1;
        int i4 = i ^ (((i3 >>> 17) | (i3 << 15)) * Murmur3_32HashFunction.f586C2);
        return (((i4 >>> 19) | (i4 << 13)) * 5) - 430675100;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        long j3 = j * j2;
        if (((j | j2) >>> 31) == 0 || j3 / j == j2) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("More produced than requested: ", j3)));
                j3 = 0;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        int ipAddress = ((WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo().getIpAddress();
        return String.format(Locale.getDefault(), "%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
    }

    public static final <K, V> Map<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (emptyMap != null) {
            return emptyMap;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    public static <T> t70<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i < 0 ? new sc0(-i) : new SpscArrayQueue(i);
    }

    public static tx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        CodePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new CodePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.length(), null);
        CharBuffer allocate = CharBuffer.allocate(str.length());
        allocate.put(str);
        allocate.flip();
        int remaining = allocate.remaining();
        int ordinal = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2 && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() < remaining) {
                    IntBuffer allocate2 = IntBuffer.allocate(CodePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.capacity() + remaining));
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
                    allocate2.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = allocate2;
                }
            } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() < remaining) {
                CharBuffer allocate3 = CharBuffer.allocate(CodePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.capacity() + remaining));
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
                allocate3.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = allocate3;
            }
        } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() < remaining) {
            ByteBuffer allocate4 = ByteBuffer.allocate(CodePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.capacity() + remaining));
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
            allocate4.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = allocate4;
        }
        if (allocate.hasArray()) {
            int ordinal2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
            if (ordinal2 == 0) {
                char[] array = allocate.array();
                int position = allocate.position() + allocate.arrayOffset();
                int limit = allocate.limit() + allocate.arrayOffset();
                byte[] array2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.array();
                int position2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position() + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.arrayOffset();
                while (true) {
                    if (position >= limit) {
                        allocate.position(position - allocate.arrayOffset());
                        ByteBuffer byteBuffer = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        byteBuffer.position(position2 - byteBuffer.arrayOffset());
                        break;
                    }
                    char c = array[position];
                    if (c <= 255) {
                        array2[position2] = (byte) (c & 255);
                        position++;
                        position2++;
                    } else {
                        allocate.position(position - allocate.arrayOffset());
                        ByteBuffer byteBuffer2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        byteBuffer2.position(position2 - byteBuffer2.arrayOffset());
                        if (!Character.isHighSurrogate(c)) {
                            int remaining2 = allocate.remaining();
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
                            CharBuffer allocate5 = CharBuffer.allocate(Math.max(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() + remaining2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.capacity() / 2));
                            while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasRemaining()) {
                                allocate5.put((char) (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get() & 255));
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CodePointBuffer.Type.CHAR;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = allocate5;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(allocate);
                        } else {
                            int remaining3 = allocate.remaining();
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
                            IntBuffer allocate6 = IntBuffer.allocate(Math.max(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() + remaining3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.capacity() / 4));
                            while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasRemaining()) {
                                allocate6.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get() & 255);
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CodePointBuffer.Type.INT;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = allocate6;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(allocate);
                        }
                    }
                }
            } else if (ordinal2 == 1) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(allocate);
            } else if (ordinal2 == 2) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(allocate);
            }
            int ordinal3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
            if (ordinal3 == 0) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
            } else if (ordinal3 == 1) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
            } else if (ordinal3 == 2) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
            }
            CodePointBuffer codePointBuffer = new CodePointBuffer(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null);
            int ordinal4 = codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
            if (ordinal4 == 0) {
                return new tx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), "<unknown>", codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.array(), codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), null);
            }
            if (ordinal4 == 1) {
                return new tx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), "<unknown>", codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.array(), codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), null);
            }
            if (ordinal4 != 2) {
                throw new UnsupportedOperationException("Not reached");
            }
            return new tx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), "<unknown>", codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.array(), codePointBuffer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), null);
        }
        throw new UnsupportedOperationException("TODO");
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (th instanceof ThreadDeath) {
                throw ((ThreadDeath) th);
            }
            if (th instanceof LinkageError) {
                throw ((LinkageError) th);
            }
            return;
        }
        throw ((VirtualMachineError) th);
    }

    public static double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws IOException {
        boolean z;
        HttpsURLConnection httpsURLConnection;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        Map<String, String> map = ir0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str2 = "";
        StringBuilder sb = new StringBuilder(str2);
        URL url = new URL(str);
        sb.append(url.getProtocol());
        sb.append("://");
        sb.append(url.getHost());
        if (url.getPort() != -1 && url.getPort() == url.getDefaultPort()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(":");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(url.getPort());
            str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        }
        sb.append(str2);
        sb.append(url.getPath());
        String query = url.getQuery();
        HashMap hashMap = new HashMap();
        if ((query == null || query.length() == 0) && hashMap.size() <= 0) {
            z = false;
        } else {
            sb.append("?");
            z = true;
        }
        if (query != null && query.length() != 0) {
            sb.append(query);
            sb.append("&");
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
            sb.append("&");
        }
        if (z) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println("before:" + str);
        PrintStream printStream = System.out;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("after:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(sb.toString());
        printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
        URL url2 = new URL(sb.toString());
        HttpURLConnection httpURLConnection = null;
        r1 = null;
        r1 = null;
        BufferedReader bufferedReader = null;
        try {
            if (url2.getProtocol().toUpperCase().equals("HTTPS")) {
                ir0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url2.openConnection();
                httpsURLConnection2.setHostnameVerifier(ir0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                httpsURLConnection = httpsURLConnection2;
            } else {
                httpsURLConnection = (HttpURLConnection) url2.openConnection();
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setConnectTimeout(5000);
            httpsURLConnection.setReadTimeout(10000);
            if (map != null) {
                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                    httpsURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
                }
            }
            httpsURLConnection.getResponseCode();
            StringBuffer stringBuffer = new StringBuffer();
            try {
                if (httpsURLConnection.getResponseCode() < 300) {
                    inputStream = httpsURLConnection.getInputStream();
                    try {
                        inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    stringBuffer.append(readLine + "\n");
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader2;
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    httpsURLConnection.disconnect();
                                    throw th;
                                }
                            }
                            String stringBuffer2 = stringBuffer.toString();
                            bufferedReader2.close();
                            inputStreamReader.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            httpsURLConnection.disconnect();
                            boolean z2 = false;
                            double d = 0.0d;
                            for (String str3 : stringBuffer2.split("\n")) {
                                String trim = str3.trim();
                                if (z2) {
                                    return trim.startsWith("#") ? RoundRectDrawableWithShadow.COS_45 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new URL(new URL(str), trim).toString());
                                }
                                if (trim.startsWith("#")) {
                                    if (trim.startsWith("#EXT-X-STREAM-INF")) {
                                        z2 = true;
                                    } else if (!trim.startsWith("#EXTINF:")) {
                                        continue;
                                    } else {
                                        int indexOf = trim.indexOf(",");
                                        if (indexOf <= 8) {
                                            indexOf = trim.length();
                                        }
                                        try {
                                            d += Double.parseDouble(trim.substring(8, indexOf).trim());
                                        } catch (NumberFormatException e2) {
                                            e2.printStackTrace();
                                            return RoundRectDrawableWithShadow.COS_45;
                                        }
                                    }
                                }
                            }
                            return d;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = null;
                    }
                } else {
                    throw new IOException("HTTP Request is not success, Response code is " + httpsURLConnection.getResponseCode());
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                inputStreamReader = null;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = httpsURLConnection;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (2 > i || 36 < i) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("radix ", i, " was not in valid range ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(new bj0(2, 36));
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        return i;
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    public static final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, j)));
        return j2;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, h21 h21Var) {
        int i2 = i & 255;
        switch (i2) {
            case 0:
                return "top";
            case 1:
                return ClassTransform.INTEGER;
            case 2:
                return ClassTransform.FLOAT;
            case 3:
                return ClassTransform.DOUBLE;
            case 4:
                return ClassTransform.LONG;
            case 5:
                return "null";
            case 6:
                return "uninitialized_this";
            default:
                if (i2 == 7) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, h21Var);
                }
                if (i2 != 8) {
                    throw new IllegalArgumentException("bad type");
                }
                return "uninitialized";
        }
    }

    public static final <T> Iterator<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T[] tArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "array");
        return new ai0(tArr);
    }

    @NonNull
    public static LinkedHashMap<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(context.getExternalCacheDirs()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = ((File) it.next()).getPath().split("/Android")[0];
            linkedHashMap.put(str, new File(str).getName());
        }
        return linkedHashMap;
    }

    public static final <T> List<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection, "$this$plus");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static X509TrustManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            return new fl0();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final mx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Socket socket) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket, "$receiver");
        lx0 lx0Var = new lx0(socket);
        InputStream inputStream = socket.getInputStream();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) inputStream, "getInputStream()");
        return lx0Var.source(new cx0(inputStream, lx0Var));
    }

    public static Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Element element) {
        Elements elements = new Elements();
        while (true) {
            element = element.previousElementSibling();
            if (element == null) {
                break;
            }
            elements.add(element);
        }
        if (elements.size() > 0) {
            return elements;
        }
        return null;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, @ColorInt int i) {
        int i2;
        OSInfo$OSType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity);
        Window window = activity.getWindow();
        View decorView = window.getDecorView();
        if (Build.VERSION.SDK_INT < 23) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == OSInfo$OSType.OS_TYPE_MIUI) {
                Class<?> cls = window.getClass();
                try {
                    Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                    int i3 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                    cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i3), Integer.valueOf(i3));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == OSInfo$OSType.OS_TYPE_FLYME) {
                or0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, true);
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != OSInfo$OSType.OS_TYPE_COLOR || Build.VERSION.SDK_INT < 22) {
                return;
            } else {
                i2 = 16;
            }
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(i);
        }
        i2 = 8192;
        decorView.setSystemUiVisibility(i2);
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(i);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                file2.delete();
            }
        }
        if (file == null || !file.isDirectory()) {
            return;
        }
        for (String str : file.list()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new File(file, str));
        }
    }

    public static final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        if (!(obj instanceof Result.Failure)) {
            return;
        }
        throw ((Result.Failure) obj).exception;
    }

    public static final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "src");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, "dest");
        System.arraycopy(bArr, i, bArr2, i2, i3);
    }

    public static final char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char[] cArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr, "$this$single");
        int length = cArr.length;
        if (length != 0) {
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return cArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return ((i & 65535) << 8) | 7;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int i3 = i ^ (i2 * 4);
        int i4 = (i3 ^ (i3 >>> 16)) * (-2048144789);
        int i5 = (i4 ^ (i4 >>> 13)) * (-1028477387);
        return i5 ^ (i5 >>> 16);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, Object obj) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, obj != null ? obj.hashCode() : 0);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, double d) {
        return (int) ((d * context.getResources().getDisplayMetrics().density) + 0.5d);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @AttrRes int i) {
        return context.getTheme().obtainStyledAttributes(new int[]{i}).getResourceId(0, 0);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls, URL url, BufferedReader bufferedReader, int i, List list, Set set) throws IOException, ServiceConfigurationError {
        String readLine = bufferedReader.readLine();
        if (readLine == null) {
            return -1;
        }
        int indexOf = readLine.indexOf(35);
        if (indexOf >= 0) {
            readLine = readLine.substring(0, indexOf);
        }
        String trim = readLine.trim();
        int length = trim.length();
        if (length != 0) {
            if (trim.indexOf(32) >= 0 || trim.indexOf(9) >= 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, url, i, "Illegal configuration-file syntax");
                throw null;
            }
            int codePointAt = trim.codePointAt(0);
            if (!Character.isJavaIdentifierStart(codePointAt)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, url, i, "Illegal provider-class name: " + trim);
                throw null;
            }
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = trim.codePointAt(charCount);
                if (!Character.isJavaIdentifierPart(codePointAt2) && codePointAt2 != 46) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, url, i, "Illegal provider-class name: " + trim);
                    throw null;
                }
                charCount += Character.charCount(codePointAt2);
            }
            if (!set.contains(trim)) {
                list.add(trim);
                set.add(trim);
            }
        }
        return i + 1;
    }

    public static final <T extends Comparable<?>> int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 != null) {
            return t.compareTo(t2);
        }
        return 1;
    }

    public static final <T> int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends T> iterable, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, h21 h21Var) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
    }

    public static <T> int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T[] tArr, int i) {
        for (T t : tArr) {
            i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, t);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, tArr.length);
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        long j3 = j + j2;
        if (j3 < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, j)));
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    @TargetApi(18)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, Bitmap bitmap, int i) throws RSRuntimeException {
        ScriptIntrinsicBlur scriptIntrinsicBlur;
        Allocation allocation;
        Allocation allocation2;
        RenderScript create;
        RenderScript renderScript = null;
        ScriptIntrinsicBlur scriptIntrinsicBlur2 = null;
        try {
            create = RenderScript.create(context);
            try {
                create.setMessageHandler(new RenderScript.RSMessageHandler());
                allocation = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                try {
                    allocation2 = Allocation.createTyped(create, allocation.getType());
                } catch (Throwable th) {
                    th = th;
                    allocation2 = null;
                    renderScript = create;
                    scriptIntrinsicBlur = allocation2;
                    if (renderScript != null) {
                        renderScript.destroy();
                    }
                    if (allocation != null) {
                        allocation.destroy();
                    }
                    if (allocation2 != null) {
                        allocation2.destroy();
                    }
                    if (scriptIntrinsicBlur != null) {
                        scriptIntrinsicBlur.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                allocation = null;
                allocation2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            scriptIntrinsicBlur = null;
            allocation = null;
            allocation2 = null;
        }
        try {
            scriptIntrinsicBlur2 = ScriptIntrinsicBlur.create(create, android.renderscript.Element.U8_4(create));
            scriptIntrinsicBlur2.setInput(allocation);
            scriptIntrinsicBlur2.setRadius(i);
            scriptIntrinsicBlur2.forEach(allocation2);
            allocation2.copyTo(bitmap);
            create.destroy();
            allocation.destroy();
            allocation2.destroy();
            scriptIntrinsicBlur2.destroy();
            return bitmap;
        } catch (Throwable th4) {
            th = th4;
            ScriptIntrinsicBlur scriptIntrinsicBlur3 = scriptIntrinsicBlur2;
            renderScript = create;
            scriptIntrinsicBlur = scriptIntrinsicBlur3;
            if (renderScript != null) {
            }
            if (allocation != null) {
            }
            if (allocation2 != null) {
            }
            if (scriptIntrinsicBlur != null) {
            }
            throw th;
        }
    }

    public static Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap, int i, boolean z) {
        Bitmap bitmap2;
        int i2;
        int i3;
        int[] iArr;
        int[] iArr2;
        int i4 = i;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i4 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i5 = width * height;
        int[] iArr3 = new int[i5];
        copy.getPixels(iArr3, 0, width, 0, 0, width, height);
        int i6 = width - 1;
        int i7 = height - 1;
        int i8 = i4 + i4 + 1;
        int[] iArr4 = new int[i5];
        int[] iArr5 = new int[i5];
        int[] iArr6 = new int[i5];
        int[] iArr7 = new int[Math.max(width, height)];
        int i9 = (i8 + 1) >> 1;
        int i10 = i9 * i9;
        int i11 = i10 * 256;
        int[] iArr8 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr8[i12] = i12 / i10;
        }
        int[][] iArr9 = (int[][]) Array.newInstance(int.class, i8, 3);
        int i13 = i4 + 1;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            bitmap2 = copy;
            if (i14 >= height) {
                break;
            }
            int i17 = height;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = -i4;
            int i27 = 0;
            while (true) {
                i3 = i7;
                iArr = iArr7;
                if (i26 > i4) {
                    break;
                }
                int i28 = iArr3[Math.min(i6, Math.max(i26, 0)) + i15];
                int[] iArr10 = iArr9[i26 + i4];
                iArr10[0] = (i28 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
                iArr10[1] = (i28 & 65280) >> 8;
                iArr10[2] = i28 & 255;
                int abs = i13 - Math.abs(i26);
                i27 = (iArr10[0] * abs) + i27;
                i18 = (iArr10[1] * abs) + i18;
                i19 = (iArr10[2] * abs) + i19;
                if (i26 > 0) {
                    i23 += iArr10[0];
                    i24 += iArr10[1];
                    i25 += iArr10[2];
                } else {
                    i20 += iArr10[0];
                    i21 += iArr10[1];
                    i22 += iArr10[2];
                }
                i26++;
                i7 = i3;
                iArr7 = iArr;
            }
            int i29 = i4;
            int i30 = i27;
            int i31 = 0;
            while (i31 < width) {
                iArr4[i15] = iArr8[i30];
                iArr5[i15] = iArr8[i18];
                iArr6[i15] = iArr8[i19];
                int i32 = i30 - i20;
                int i33 = i18 - i21;
                int i34 = i19 - i22;
                int[] iArr11 = iArr9[((i29 - i4) + i8) % i8];
                int i35 = i20 - iArr11[0];
                int i36 = i21 - iArr11[1];
                int i37 = i22 - iArr11[2];
                if (i14 == 0) {
                    iArr2 = iArr8;
                    iArr[i31] = Math.min(i31 + i4 + 1, i6);
                } else {
                    iArr2 = iArr8;
                }
                int i38 = iArr3[i16 + iArr[i31]];
                iArr11[0] = (i38 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
                iArr11[1] = (i38 & 65280) >> 8;
                iArr11[2] = i38 & 255;
                int i39 = i23 + iArr11[0];
                int i40 = i24 + iArr11[1];
                int i41 = i25 + iArr11[2];
                i30 = i32 + i39;
                i18 = i33 + i40;
                i19 = i34 + i41;
                i29 = (i29 + 1) % i8;
                int[] iArr12 = iArr9[i29 % i8];
                i20 = i35 + iArr12[0];
                i21 = i36 + iArr12[1];
                i22 = i37 + iArr12[2];
                i23 = i39 - iArr12[0];
                i24 = i40 - iArr12[1];
                i25 = i41 - iArr12[2];
                i15++;
                i31++;
                iArr8 = iArr2;
            }
            i16 += width;
            i14++;
            copy = bitmap2;
            height = i17;
            i7 = i3;
            iArr7 = iArr;
        }
        int i42 = i7;
        int[] iArr13 = iArr7;
        int i43 = height;
        int[] iArr14 = iArr8;
        int i44 = 0;
        while (i44 < width) {
            int i45 = -i4;
            int i46 = i8;
            int[] iArr15 = iArr3;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = i45;
            int i55 = i45 * width;
            int i56 = 0;
            int i57 = 0;
            while (true) {
                i2 = width;
                if (i54 > i4) {
                    break;
                }
                int max = Math.max(0, i55) + i44;
                int[] iArr16 = iArr9[i54 + i4];
                iArr16[0] = iArr4[max];
                iArr16[1] = iArr5[max];
                iArr16[2] = iArr6[max];
                int abs2 = i13 - Math.abs(i54);
                i56 = (iArr4[max] * abs2) + i56;
                i57 = (iArr5[max] * abs2) + i57;
                i47 = (iArr6[max] * abs2) + i47;
                if (i54 > 0) {
                    i51 += iArr16[0];
                    i52 += iArr16[1];
                    i53 += iArr16[2];
                } else {
                    i48 += iArr16[0];
                    i49 += iArr16[1];
                    i50 += iArr16[2];
                }
                int i58 = i42;
                if (i54 < i58) {
                    i55 += i2;
                }
                i54++;
                i42 = i58;
                width = i2;
            }
            int i59 = i42;
            int i60 = i4;
            int i61 = i44;
            int i62 = i57;
            int i63 = i43;
            int i64 = i56;
            int i65 = 0;
            while (i65 < i63) {
                iArr15[i61] = (iArr15[i61] & (-16777216)) | (iArr14[i64] << 16) | (iArr14[i62] << 8) | iArr14[i47];
                int i66 = i64 - i48;
                int i67 = i62 - i49;
                int i68 = i47 - i50;
                int[] iArr17 = iArr9[((i60 - i4) + i46) % i46];
                int i69 = i48 - iArr17[0];
                int i70 = i49 - iArr17[1];
                int i71 = i50 - iArr17[2];
                if (i44 == 0) {
                    iArr13[i65] = Math.min(i65 + i13, i59) * i2;
                }
                int i72 = iArr13[i65] + i44;
                iArr17[0] = iArr4[i72];
                iArr17[1] = iArr5[i72];
                iArr17[2] = iArr6[i72];
                int i73 = i51 + iArr17[0];
                int i74 = i52 + iArr17[1];
                int i75 = i53 + iArr17[2];
                i64 = i66 + i73;
                i62 = i67 + i74;
                i47 = i68 + i75;
                i60 = (i60 + 1) % i46;
                int[] iArr18 = iArr9[i60];
                i48 = i69 + iArr18[0];
                i49 = i70 + iArr18[1];
                i50 = i71 + iArr18[2];
                i51 = i73 - iArr18[0];
                i52 = i74 - iArr18[1];
                i53 = i75 - iArr18[2];
                i61 += i2;
                i65++;
                i4 = i;
            }
            i44++;
            i4 = i;
            i42 = i59;
            i43 = i63;
            i8 = i46;
            iArr3 = iArr15;
            width = i2;
        }
        int i76 = width;
        bitmap2.setPixels(iArr3, 0, i76, 0, 0, i76, i43);
        return bitmap2;
    }

    public static final <T, A extends Appendable> A Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends T> iterable, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ih0<? super T, ? extends CharSequence> ih0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "$this$joinTo");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a, "buffer");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "separator");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence2, "prefix");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence3, "postfix");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a, t, ih0Var);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final <T> Class<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ij0<T> ij0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ij0Var, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((di0) ij0Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return name.equals(ClassTransform.DOUBLE) ? Double.class : cls;
            case 104431:
                return name.equals(ClassTransform.INTEGER) ? Integer.class : cls;
            case 3039496:
                return name.equals(ClassTransform.BYTE) ? Byte.class : cls;
            case 3052374:
                return name.equals(ClassTransform.CHARACTER) ? Character.class : cls;
            case 3327612:
                return name.equals(ClassTransform.LONG) ? Long.class : cls;
            case 3625364:
                return name.equals(ClassTransform.VOID) ? Void.class : cls;
            case 64711720:
                return name.equals(ClassTransform.BOOLEAN) ? Boolean.class : cls;
            case 97526364:
                return name.equals(ClassTransform.FLOAT) ? Float.class : cls;
            case 109413500:
                return name.equals(ClassTransform.SHORT) ? Short.class : cls;
            default:
                return cls;
        }
    }

    public static final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, "exception");
        return new Result.Failure(th);
    }

    public static final <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<? extends T> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, h21 h21Var) {
        if ((i & 255) == 7) {
            return (String) h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >>> 8);
        }
        throw new IllegalArgumentException("expecting object type");
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        File file = new File(context.getCacheDir(), str);
        try {
            InputStream open = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.close();
            open.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d A[Catch: IOException -> 0x0052, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x0052, blocks: (B:30:0x004e, B:45:0x008d), top: B:10:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x0053 -> B:30:0x0090). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        GZIPInputStream gZIPInputStream;
        IOException e;
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
        } catch (Exception unused) {
        }
        if (z) {
            str = SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(zu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.getBytes("utf-8")));
            } catch (IOException e3) {
                e = e3;
                byteArrayInputStream = null;
                e = e;
                gZIPInputStream = byteArrayInputStream;
                e.printStackTrace();
                if (gZIPInputStream != 0) {
                }
                if (byteArrayInputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream = null;
                th = th;
                gZIPInputStream = byteArrayInputStream;
                if (gZIPInputStream != 0) {
                }
                if (byteArrayInputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayOutputStream = null;
            byteArrayInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            byteArrayInputStream = null;
        }
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str2 = byteArrayOutputStream.toString();
                    try {
                        gZIPInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    byteArrayOutputStream.close();
                } catch (IOException e7) {
                    e = e7;
                    e.printStackTrace();
                    if (gZIPInputStream != 0) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return str2;
                }
            } catch (Throwable th4) {
                th = th4;
                if (gZIPInputStream != 0) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e13) {
            e = e13;
            gZIPInputStream = 0;
        } catch (Throwable th5) {
            th = th5;
            gZIPInputStream = 0;
            if (gZIPInputStream != 0) {
            }
            if (byteArrayInputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
        return str2;
    }

    public static <T> String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<T> it, String str) {
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static final /* synthetic */ Void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new UnsupportedOperationException("Not supported for local property reference.");
    }

    public static final <T, C extends Collection<? super T>> C Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends T> iterable, C c) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "$this$toCollection");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c, "destination");
        for (T t : iterable) {
            c.add(t);
        }
        return c;
    }

    public static final <T> List<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        List<T> singletonList = Collections.singletonList(t);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final <T> List<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<? extends T> collection) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static <T> d60<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d60<T> d60Var) {
        return d60Var;
    }

    public static final <T> df0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0<? extends T> xg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var, "initializer");
        return new SynchronizedLazyImpl(xg0Var, null, 2, null);
    }

    public static final kx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(OutputStream outputStream) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outputStream, "$receiver");
        return new ex0(outputStream, new nx0());
    }

    public static final kx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Socket socket) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket, "$receiver");
        lx0 lx0Var = new lx0(socket);
        OutputStream outputStream = socket.getOutputStream();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) outputStream, "getOutputStream()");
        return lx0Var.sink(new ex0(outputStream, lx0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> mg0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0<? super T> mg0Var) {
        mg0<T> mg0Var2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "$this$intercepted");
        ContinuationImpl continuationImpl = !(mg0Var instanceof ContinuationImpl) ? null : mg0Var;
        return (continuationImpl == null || (mg0Var2 = (mg0<T>) continuationImpl.intercepted()) == null) ? mg0Var : mg0Var2;
    }

    public static final vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0 kx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0Var, "$receiver");
        return new gx0(kx0Var);
    }

    public static final ww0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0 mx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "$receiver");
        return new hx0(mx0Var);
    }

    public static Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Element element) {
        Elements elements = new Elements();
        while (true) {
            element = element.nextElementSibling();
            if (element == null) {
                break;
            }
            elements.add(element);
        }
        if (elements.size() > 0) {
            return elements;
        }
        return null;
    }

    public static final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, @ColorInt int i) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(i);
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, String str, String str2, e60 e60Var) throws Exception {
        WebView webView = new WebView(activity);
        webView.getSettings().setJavaScriptEnabled(true);
        WebSettings settings = webView.getSettings();
        if (TextUtils.isEmpty(str)) {
            str = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwww;
        }
        settings.setUserAgentString(str);
        webView.addJavascriptInterface(new vk0(webView, activity, e60Var), "HTMLOUT");
        webView.getSettings().setLoadsImagesAutomatically(false);
        webView.getSettings().setBlockNetworkImage(true);
        webView.getSettings().setMixedContentMode(0);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.setWebViewClient(new xk0(activity, webView));
        webView.loadUrl(str2);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null || !inputMethodManager.isActive(view)) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    public static final <T> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Appendable appendable, T t, ih0<? super T, ? extends CharSequence> ih0Var) {
        CharSequence valueOf;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appendable, "$this$appendElement");
        if (ih0Var != null) {
            t = (T) ih0Var.mo4916invoke(t);
        } else {
            if (!(t != 0 ? t instanceof CharSequence : true)) {
                if (t instanceof Character) {
                    appendable.append(((Character) t).charValue());
                    return;
                }
                valueOf = String.valueOf((Object) t);
                appendable.append(valueOf);
            }
        }
        valueOf = (CharSequence) t;
        appendable.append(valueOf);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls, String str) throws ServiceConfigurationError {
        throw new ServiceConfigurationError(cls.getName() + ": " + str);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls, URL url, int i, String str) throws ServiceConfigurationError {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, url + ":" + i + ": " + str);
        throw null;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        File file = new File(str);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file2.getPath());
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        boolean z = str != null && !"4.7".equals(str) && !Wwwwwwwwwwwwwwwwwwwwwwwwwww("4.7").equals(Wwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        boolean z2 = !"4.7".equals(str2) && !Wwwwwwwwwwwwwwwwwwwwwwwwwww("4.7").equals(Wwwwwwwwwwwwwwwwwwwwwwwwwww(str2));
        if (z) {
            System.err.printf("ANTLR Tool version %s used for code generation does not match the current runtime version %s", str, "4.7");
        }
        if (z2) {
            System.err.printf("ANTLR Runtime version %s used for parser compilation does not match the current runtime version %s", str2, "4.7");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60<? extends T> h60Var, j60<? super T> j60Var) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        j60Var.onSubscribe(blockingObserver);
        h60Var.subscribe(blockingObserver);
        while (!blockingObserver.isDisposed()) {
            Object poll = linkedBlockingQueue.poll();
            if (poll == null) {
                try {
                    poll = linkedBlockingQueue.take();
                } catch (InterruptedException e) {
                    blockingObserver.dispose();
                    j60Var.onError(e);
                    return;
                }
            }
            if (blockingObserver.isDisposed() || h60Var == BlockingObserver.TERMINATED || NotificationLite.acceptFull(poll, j60Var)) {
                return;
            }
            while (!blockingObserver.isDisposed()) {
            }
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<?> j60Var, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        } else if (atomicInteger.getAndIncrement() != 0) {
        } else {
            j60Var.onError(atomicThrowable.terminate());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() != 0 || !atomicInteger.compareAndSet(0, 1)) {
            return;
        }
        s51Var.onNext(t);
        if (atomicInteger.decrementAndGet() == 0) {
            return;
        }
        Throwable terminate = atomicThrowable.terminate();
        if (terminate != null) {
            s51Var.onError(terminate);
        } else {
            s51Var.onComplete();
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<?> s51Var, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        } else if (atomicInteger.getAndIncrement() != 0) {
        } else {
            s51Var.onError(atomicThrowable.terminate());
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<?> s51Var, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                s51Var.onError(terminate);
            } else {
                s51Var.onComplete();
            }
        }
    }

    public static final <T> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T[] tArr, T t, int i, int i2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "$this$fill");
        Arrays.fill(tArr, i, i2, t);
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity) {
        Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(LogType.UNEXP_ANR);
        window.setStatusBarColor(0);
        return true;
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AssertionError assertionError) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(assertionError, "$receiver");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            return message != null ? nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) message, (CharSequence) "getsockname failed", false, 2) : false;
        }
        return false;
    }

    public static final <T> boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<? super T> collection, Iterable<? extends T> iterable) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection, "$this$addAll");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static <T, R> boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60<T> h60Var, j60<? super R> j60Var, f70<? super T, ? extends h60<? extends R>> f70Var) {
        if (h60Var instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) h60Var).call();
                if (obj == 0) {
                    EmptyDisposable.complete(j60Var);
                    return true;
                }
                h60<? extends R> apply = f70Var.apply(obj);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null ObservableSource");
                h60<? extends R> h60Var2 = apply;
                if (h60Var2 instanceof Callable) {
                    Object call = ((Callable) h60Var2).call();
                    if (call == null) {
                        EmptyDisposable.complete(j60Var);
                        return true;
                    }
                    ObservableScalarXMap$ScalarDisposable observableScalarXMap$ScalarDisposable = new ObservableScalarXMap$ScalarDisposable(j60Var, call);
                    j60Var.onSubscribe(observableScalarXMap$ScalarDisposable);
                    observableScalarXMap$ScalarDisposable.run();
                } else {
                    h60Var2.subscribe(j60Var);
                }
                return true;
            } catch (Throwable th) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                EmptyDisposable.error(th, j60Var);
                return true;
            }
        }
        return false;
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "a");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final kx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) throws FileNotFoundException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "$receiver");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fileOutputStream, "$receiver");
        return new ex0(fileOutputStream, new nx0());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) {
        Throwable th;
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        Map<Integer, ByteBuffer> map;
        byte[] bArr;
        ByteBuffer byteBuffer;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, Tailer.RAF_MODE);
                try {
                    fileChannel = randomAccessFile.getChannel();
                } catch (IOException unused) {
                    fileChannel = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            } catch (SignatureNotFoundException unused2) {
                map = null;
                if (map == null) {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset();
                    bArr = Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, byteBuffer.limit() + arrayOffset);
                    if (bArr == null) {
                    }
                }
                bArr = null;
                if (bArr == null) {
                }
            }
        } catch (IOException unused3) {
            fileChannel = null;
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            randomAccessFile = null;
        }
        try {
            map = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fileChannel).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            try {
                try {
                    fileChannel.close();
                } catch (SignatureNotFoundException | IOException unused4) {
                }
            } catch (IOException unused5) {
            }
        } catch (IOException unused6) {
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused7) {
                }
            }
            if (randomAccessFile != null) {
                map = null;
                randomAccessFile.close();
                if (map == null) {
                }
                bArr = null;
                if (bArr == null) {
                }
            }
            map = null;
            if (map == null) {
            }
            bArr = null;
            if (bArr == null) {
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused8) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused9) {
                }
            }
            throw th;
        }
        randomAccessFile.close();
        if (map == null || (byteBuffer = map.get(1903654775)) == null) {
            bArr = null;
        } else {
            byte[] array2 = byteBuffer.array();
            int arrayOffset2 = byteBuffer.arrayOffset();
            bArr = Arrays.copyOfRange(array2, byteBuffer.position() + arrayOffset2, byteBuffer.limit() + arrayOffset2);
        }
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final <T> List<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T[] tArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "$this$asList");
        List<T> asList = Arrays.asList(tArr);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l51 l51Var, o51 o51Var) {
        String str;
        String str2;
        switch (o51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            case 1:
                str = "java/lang/Boolean";
                str2 = "(Z)Ljava/lang/Boolean;";
                break;
            case 2:
                str = "java/lang/Character";
                str2 = "(C)Ljava/lang/Character;";
                break;
            case 3:
                str = "java/lang/Byte";
                str2 = "(B)Ljava/lang/Byte;";
                break;
            case 4:
                str = "java/lang/Short";
                str2 = "(S)Ljava/lang/Short;";
                break;
            case 5:
                str = "java/lang/Integer";
                str2 = "(I)Ljava/lang/Integer;";
                break;
            case 6:
                str = "java/lang/Float";
                str2 = "(F)Ljava/lang/Float;";
                break;
            case 7:
                str = "java/lang/Long";
                str2 = "(J)Ljava/lang/Long;";
                break;
            case 8:
                str = "java/lang/Double";
                str2 = "(D)Ljava/lang/Double;";
                break;
            default:
                return;
        }
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, str, "valueOf", str2);
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, h21 h21Var) {
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            if (charAt == 'F') {
                return 2;
            }
            if (charAt != 'S' && charAt != 'Z' && charAt != 'I') {
                if (charAt == 'J') {
                    return 4;
                }
                switch (charAt) {
                    case 'B':
                    case 'C':
                        break;
                    case 'D':
                        return 3;
                    default:
                        throw new IllegalArgumentException("bad type");
                }
            }
            return 1;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        z51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            if (!z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return null;
            }
            String str = z51.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (str != null) {
                return str;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, null);
            if (z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                Context context2 = z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new a61(z51.Wwwwwwwwwwwwwwwwwwwwwwwwww, 0, null);
                context2.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return z51.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw null;
    }

    public static IHttpGetApi Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        try {
            return (IHttpGetApi) new Retrofit.Builder().baseUrl(TextUtils.isEmpty(str) ? "http://www.baidu.com" : co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)).addConverterFactory(new al0()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(new OkHttpClient.Builder().connectTimeout(15L, TimeUnit.SECONDS).writeTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).retryOnConnectionFailure(true).sslSocketFactory(new el0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).hostnameVerifier(new gl0()).protocols(Collections.singletonList(Protocol.HTTP_1_1)).addInterceptor(new wk0(str2)).addInterceptor(new dl0(1)).connectionPool(new ConnectionPool(5, 1L, TimeUnit.SECONDS)).build()).build().create(IHttpGetApi.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static <T, U> boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, j60<?> j60Var, boolean z3, t70<?> t70Var, p60 p60Var, e80<T, U> e80Var) {
        if (e80Var.Wwwwwwwwwwwwwwwwwwwww) {
            t70Var.clear();
            p60Var.dispose();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (z3) {
                if (!z2) {
                    return false;
                }
                p60Var.dispose();
                Throwable th = e80Var.Wwwwwwwwwwwwwwwwwww;
                if (th != null) {
                    j60Var.onError(th);
                } else {
                    j60Var.onComplete();
                }
                return true;
            }
            Throwable th2 = e80Var.Wwwwwwwwwwwwwwwwwww;
            if (th2 != null) {
                t70Var.clear();
                p60Var.dispose();
                j60Var.onError(th2);
                return true;
            } else if (!z2) {
                return false;
            } else {
                p60Var.dispose();
                j60Var.onComplete();
                return true;
            }
        }
    }

    public static final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, "$this$addSuppressed");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2, "exception");
            if (th == th2) {
                return;
            }
            ug0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, th2);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        th.printStackTrace();
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T, U> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t70<T> t70Var, j60<? super U> j60Var, boolean z, p60 p60Var, e80<T, U> e80Var) {
        int i = 1;
        while (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e80Var.Wwwwwwwwwwwwwwwwwwww, t70Var.isEmpty(), j60Var, z, t70Var, p60Var, e80Var)) {
            while (true) {
                boolean z2 = e80Var.Wwwwwwwwwwwwwwwwwwww;
                try {
                    T mo4868poll = t70Var.mo4868poll();
                    boolean z3 = mo4868poll == null;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, z3, j60Var, z, t70Var, p60Var, e80Var)) {
                        return;
                    }
                    if (z3) {
                        i = e80Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        e80Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, mo4868poll);
                    }
                } catch (Throwable th) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    j60Var.onError(th);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<? extends T> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list.get(0));
        }
        return EmptyList.INSTANCE;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) throws Exception {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file) / 1024.0d;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 1.0d) {
            return "0KB";
        }
        double d = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / 1024.0d;
        if (d >= 1.0d) {
            double d2 = d / 1024.0d;
            if (d2 < 1.0d) {
                BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
                sb = new StringBuilder();
                sb.append(bigDecimal.setScale(2, 4).toPlainString());
                str = "MB";
            } else {
                double d3 = d2 / 1024.0d;
                if (d3 < 1.0d) {
                    BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d2));
                    sb2 = new StringBuilder();
                    sb2.append(bigDecimal2.setScale(2, 4).toPlainString());
                    str2 = "GB";
                } else {
                    BigDecimal bigDecimal3 = new BigDecimal(d3);
                    sb = new StringBuilder();
                    sb.append(bigDecimal3.setScale(2, 4).toPlainString());
                    str = "TB";
                }
            }
            sb.append(str);
            return sb.toString();
        }
        BigDecimal bigDecimal4 = new BigDecimal(Double.toString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        sb2 = new StringBuilder();
        sb2.append(bigDecimal4.setScale(2, 4).toPlainString());
        str2 = "KB";
        sb2.append(str2);
        return sb2.toString();
    }

    public static g50<ByteBuffer, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FileChannel fileChannel) throws IOException, SignatureNotFoundException {
        long size = fileChannel.size();
        if (size >= 22) {
            long j = size - 22;
            long min = Math.min(j, (long) WebSocketProtocol.PAYLOAD_SHORT_MAX);
            int i = 0;
            while (true) {
                long j2 = i;
                if (j2 > min) {
                    throw new IOException("ZIP End of Central Directory (EOCD) record not found");
                }
                long j3 = j - j2;
                ByteBuffer allocate = ByteBuffer.allocate(4);
                fileChannel.position(j3);
                fileChannel.read(allocate);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                if (allocate.getInt(0) == 101010256) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(2);
                    fileChannel.position(j3 + 20);
                    fileChannel.read(allocate2);
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    short s = allocate2.getShort(0);
                    if (s == i) {
                        ByteBuffer allocate3 = ByteBuffer.allocate(4);
                        allocate3.order(ByteOrder.LITTLE_ENDIAN);
                        fileChannel.position((fileChannel.size() - s) - 6);
                        fileChannel.read(allocate3);
                        long j4 = allocate3.getInt(0);
                        if (j4 < 32) {
                            throw new SignatureNotFoundException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("APK too small for APK Signing Block. ZIP Central Directory offset: ", j4));
                        }
                        fileChannel.position(j4 - 24);
                        ByteBuffer allocate4 = ByteBuffer.allocate(24);
                        fileChannel.read(allocate4);
                        allocate4.order(ByteOrder.LITTLE_ENDIAN);
                        if (allocate4.getLong(8) != 2334950737559900225L || allocate4.getLong(16) != 3617552046287187010L) {
                            throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
                        }
                        long j5 = allocate4.getLong(0);
                        if (j5 < allocate4.capacity() || j5 > 2147483639) {
                            throw new SignatureNotFoundException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("APK Signing Block size out of range: ", j5));
                        }
                        int i2 = (int) (8 + j5);
                        long j6 = j4 - i2;
                        if (j6 < 0) {
                            throw new SignatureNotFoundException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("APK Signing Block offset out of range: ", j6));
                        }
                        fileChannel.position(j6);
                        ByteBuffer allocate5 = ByteBuffer.allocate(i2);
                        fileChannel.read(allocate5);
                        allocate5.order(ByteOrder.LITTLE_ENDIAN);
                        long j7 = allocate5.getLong(0);
                        if (j7 == j5) {
                            return new g50<>(allocate5, Long.valueOf(j6));
                        }
                        throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j7 + " vs " + j5);
                    }
                }
                i++;
            }
        } else {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
    }

    public static IHttpPostApi Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        try {
            return (IHttpPostApi) new Retrofit.Builder().baseUrl(TextUtils.isEmpty(str) ? "http://www.baidu.com" : co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)).addConverterFactory(new al0()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(new OkHttpClient.Builder().connectTimeout(15L, TimeUnit.SECONDS).writeTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).retryOnConnectionFailure(true).sslSocketFactory(new el0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).hostnameVerifier(new gl0()).protocols(Collections.singletonList(Protocol.HTTP_1_1)).addInterceptor(new uk0(str2)).addInterceptor(new dl0(1)).connectionPool(new ConnectionPool(5, 1L, TimeUnit.SECONDS)).build()).build().create(IHttpPostApi.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Finally extract failed */
    public static Map<Integer, ByteBuffer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            int capacity = byteBuffer.capacity() - 24;
            if (capacity < 8) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("end < start: ", capacity, " < ", 8));
            }
            int capacity2 = byteBuffer.capacity();
            if (capacity > byteBuffer.capacity()) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("end > capacity: ", capacity, " > ", capacity2));
            }
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i = 0;
            try {
                byteBuffer.position(0);
                byteBuffer.limit(capacity);
                byteBuffer.position(8);
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(0);
                byteBuffer.limit(limit);
                byteBuffer.position(position);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (slice.hasRemaining()) {
                    i++;
                    if (slice.remaining() < 8) {
                        throw new SignatureNotFoundException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Insufficient data to read size of APK Signing Block entry #", i));
                    }
                    long j = slice.getLong();
                    if (j < 4 || j > 2147483647L) {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + j);
                    }
                    int i2 = (int) j;
                    int position2 = slice.position() + i2;
                    if (i2 > slice.remaining()) {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + slice.remaining());
                    }
                    Integer valueOf = Integer.valueOf(slice.getInt());
                    int i3 = i2 - 4;
                    if (i3 < 0) {
                        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size: ", i3));
                    }
                    int limit2 = slice.limit();
                    int position3 = slice.position();
                    int i4 = i3 + position3;
                    if (i4 < position3 || i4 > limit2) {
                        throw new BufferUnderflowException();
                    }
                    slice.limit(i4);
                    try {
                        ByteBuffer slice2 = slice.slice();
                        slice2.order(slice.order());
                        slice.position(i4);
                        slice.limit(limit2);
                        linkedHashMap.put(valueOf, slice2);
                        slice.position(position2);
                    } catch (Throwable th) {
                        slice.limit(limit2);
                        throw th;
                    }
                }
                return linkedHashMap;
            } catch (Throwable th2) {
                byteBuffer.position(0);
                byteBuffer.limit(limit);
                byteBuffer.position(position);
                throw th2;
            }
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    public static final <T> List<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T[] tArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "$this$toList");
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "$this$toMutableList");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "$this$asCollection");
                return new ArrayList(new tf0(tArr, false));
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr[0]);
        }
        return EmptyList.INSTANCE;
    }

    public static p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Future<?> future) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(future, "future is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(future, "future is null");
        return new FutureDisposable(future, true);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Element element, l61 l61Var) {
        Iterator<Element> it = element.mo5259parent().children().iterator();
        int i = 1;
        while (it.hasNext()) {
            Element next = it.next();
            if (element.tagName().equals(next.tagName()) && l61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(next)) {
                if (element.equals(next)) {
                    break;
                }
                i++;
            }
        }
        return i;
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3) - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i3), i3);
        } else if (i3 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else {
            if (i <= i2) {
                return i2;
            }
            int i4 = -i3;
            return i2 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i4) - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i4), i4);
        }
    }

    public static /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ih0 ih0Var, int i2) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = charSequence;
        String str = (i2 & 2) != 0 ? "" : charSequence2;
        String str2 = (i2 & 4) != 0 ? "" : charSequence3;
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence6 = charSequence4;
        if ((i2 & 32) != 0) {
            ih0Var = null;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "$this$joinToString");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence5, "separator");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "prefix");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "postfix");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence6, "truncated");
        StringBuilder sb = new StringBuilder();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, sb, charSequence5, str, str2, i3, charSequence6, ih0Var);
        String sb2 = sb.toString();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8: " + e);
        }
    }

    public static Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, Bitmap bitmap, ze0 ze0Var) {
        int i = ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i / i2;
        int i4 = ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / i2;
        boolean z = false;
        int[] iArr = {i3, i4};
        int i5 = 0;
        while (true) {
            if (i5 >= 2) {
                break;
            } else if (iArr[i5] == 0) {
                z = true;
                break;
            } else {
                i5++;
            }
        }
        if (z) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i6 = ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        canvas.scale(1.0f / i6, 1.0f / i6);
        Paint paint = new Paint();
        paint.setFlags(3);
        paint.setColorFilter(new PorterDuffColorFilter(ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, createBitmap, ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } catch (RSRuntimeException unused) {
            createBitmap = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(createBitmap, ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
        }
        if (ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
            return createBitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
        createBitmap.recycle();
        return createScaledBitmap;
    }

    public static <T> boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, s51<? super T> s51Var, Queue<T> queue, AtomicLong atomicLong, v60 v60Var) {
        boolean z;
        boolean z2;
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                try {
                    z = v60Var.getAsBoolean();
                } catch (Throwable th) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    z = true;
                }
                if (z) {
                    return true;
                }
                Object obj = (T) queue.poll();
                if (obj == null) {
                    s51Var.onComplete();
                    return true;
                }
                s51Var.onNext(obj);
                j2++;
            } else {
                try {
                    z2 = v60Var.getAsBoolean();
                } catch (Throwable th2) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                    z2 = true;
                }
                if (z2) {
                    return true;
                }
                if (queue.isEmpty()) {
                    s51Var.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    long addAndGet = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j = addAndGet;
                    j2 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static kx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file, boolean z, int i) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "$receiver");
        FileOutputStream fileOutputStream = new FileOutputStream(file, z);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fileOutputStream, "$receiver");
        return new ex0(fileOutputStream, new nx0());
    }

    public static <T> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60<? extends T> h60Var, x60<? super T> x60Var, x60<? super Throwable> x60Var2, r60 r60Var) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, new LambdaObserver(x60Var, x60Var2, r60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public static final <T> List<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends T> iterable) {
        List list;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "$this$toList");
        boolean z = iterable instanceof Collection;
        if (z) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return EmptyList.INSTANCE;
            }
            if (size != 1) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "$this$toMutableList");
        if (z) {
            list = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) iterable);
        } else {
            ArrayList arrayList = new ArrayList();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, arrayList);
            list = arrayList;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "$this$toMap");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m, "destination");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m, "$this$putAll");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "pairs");
        for (Pair<? extends K, ? extends V> pair : iterable) {
            m.put(pair.component1(), pair.component2());
        }
        return m;
    }

    public static final <T> List<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zj0<? extends T> zj0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zj0Var, "$this$toMutableList");
        ArrayList arrayList = new ArrayList();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zj0Var, "$this$toCollection");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, "destination");
        for (T t : zj0Var) {
            arrayList.add(t);
        }
        return arrayList;
    }
}

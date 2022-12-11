package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Trace;
import android.provider.Settings;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewParent;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.google.android.exoplayer2.ParserException;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.common.base.Predicates$InPredicate;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists$TransformingRandomAccessList;
import com.google.common.collect.Lists$TransformingSequentialList;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets$UnmodifiableNavigableSet;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import com.google.common.collect.Synchronized$SynchronizedEntry;
import com.google.common.collect.Synchronized$SynchronizedList;
import com.google.common.collect.Synchronized$SynchronizedRandomAccessList;
import com.google.common.collect.Synchronized$SynchronizedSet;
import com.google.common.collect.Synchronized$SynchronizedSortedSet;
import com.google.common.primitives.Ints$IntArrayAsList;
import com.jayway.jsonpath.JsonPathException;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2641tn;
import me.tvspark.AbstractC2653tz;
import me.tvspark.C2218id;
import me.tvspark.C2434o7;
import me.tvspark.x20;
import org.apache.commons.lang3.text.FormattableUtils;
import org.apache.http.message.TokenParser;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
public final class Illllllllllllllllllllllllllll {
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringWriter stringWriter = new StringWriter(length);
        StringBuffer stringBuffer = new StringBuffer(4);
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (z2) {
                stringBuffer.append(charAt);
                if (stringBuffer.length() == 4) {
                    try {
                        stringWriter.write((char) Integer.parseInt(stringBuffer.toString(), 16));
                        stringBuffer.setLength(0);
                        z = false;
                        z2 = false;
                    } catch (NumberFormatException e) {
                        throw new JsonPathException("Unable to parse unicode value: " + ((Object) stringBuffer), e);
                    }
                } else {
                    continue;
                }
            } else if (z) {
                int i2 = 34;
                if (charAt != '\"') {
                    i2 = 39;
                    if (charAt != '\'') {
                        if (charAt == '\\') {
                            stringWriter.write(92);
                        } else if (charAt == 'b') {
                            i2 = 8;
                        } else if (charAt == 'f') {
                            i2 = 12;
                        } else if (charAt == 'n') {
                            i2 = 10;
                        } else if (charAt == 'r') {
                            i2 = 13;
                        } else if (charAt == 't') {
                            i2 = 9;
                        } else if (charAt != 'u') {
                            stringWriter.write(charAt);
                        } else {
                            z = false;
                            z2 = true;
                        }
                        z = false;
                    }
                }
                stringWriter.write(i2);
                z = false;
            } else if (charAt == '\\') {
                z = true;
            } else {
                stringWriter.write(charAt);
            }
        }
        if (z) {
            stringWriter.write(92);
        }
        return stringWriter.toString();
    }

    public static XmlResourceParser Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        Integer num;
        AssetManager assets = context.getAssets();
        try {
            num = (Integer) assets.getClass().getDeclaredMethod("addOverlayPath", String.class).invoke(assets, context.getApplicationInfo().sourceDir);
        } catch (Exception e) {
            e.printStackTrace();
            num = null;
        }
        if (num == null) {
            return null;
        }
        try {
            return context.getAssets().openXmlResourceParser(num.intValue(), "AndroidManifest.xml");
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c)) {
                        charArray[i] = (char) (c ^ TokenParser.f4579SP);
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static C2456ot Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        return new C2456ot(obj.getClass().getSimpleName(), null);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj == null ? 0 : obj.hashCode());
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt >= 'A' && charAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (c >= 'A' && c <= 'Z') {
                        charArray[i] = (char) (c ^ TokenParser.f4579SP);
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (z) {
            return;
        }
        throw new IllegalStateException();
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? Environment.isExternalStorageManager() : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, (List<String>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) x20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i & 4294967295L;
    }

    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, T t2) {
        if (t != null) {
            return t;
        }
        if (t2 == null) {
            throw new NullPointerException("Both parameters are null");
        }
        return t2;
    }

    public static <T> AbstractC2239iy<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<? extends T> it) {
        if (it != null) {
            return it instanceof AbstractC2239iy ? (AbstractC2239iy) it : new C2687uv(it);
        }
        throw null;
    }

    public static <V> AbstractFutureC2691uz<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(V v) {
        return v == null ? AbstractC2653tz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww : new AbstractC2653tz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (z) {
            return;
        }
        throw new IllegalStateException();
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return "android.permission.MANAGE_EXTERNAL_STORAGE".equals(str) || "android.permission.REQUEST_INSTALL_PACKAGES".equals(str) || "android.permission.SYSTEM_ALERT_WINDOW".equals(str) || "android.permission.NOTIFICATION_SERVICE".equals(str) || "android.permission.WRITE_SETTINGS".equals(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        char c;
        if (str == null) {
            return -1;
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwww = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwww(str);
        switch (Wwwwwwwwwwwwwwwwwwwwwwwww.hashCode()) {
            case -2123537834:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("audio/eac3-joc")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1662384011:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("video/mp2p")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -1662384007:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("video/mp2t")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case -1662095187:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("video/webm")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1606874997:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("audio/amr-wb")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1248337486:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("application/mp4")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -1004728940:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("text/vtt")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -387023398:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("audio/x-matroska")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -43467528:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("application/webm")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 13915911:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("video/x-flv")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("audio/ac3")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 187078297:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("audio/ac4")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 187078669:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("audio/amr")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 187090232:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals(DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG_4)) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 187091926:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("audio/ogg")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 187099443:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("audio/wav")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1331848029:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals(DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1503095341:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals(DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_3GP)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("audio/eac3")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1504619009:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("audio/flac")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1504831518:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals(DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 1505118770:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals("audio/webm")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 2039520277:
                if (Wwwwwwwwwwwwwwwwwwwwwwwww.equals(DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MATROSKA)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                return 0;
            case 3:
                return 1;
            case 4:
            case 5:
            case 6:
                return 3;
            case 7:
                return 4;
            case '\b':
                return 5;
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
                return 6;
            case 14:
                return 7;
            case 15:
            case 16:
            case 17:
                return 8;
            case 18:
                return 9;
            case 19:
                return 10;
            case 20:
                return 11;
            case 21:
                return 12;
            case 22:
                return 13;
            default:
                return -1;
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<?> it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
    }

    @EnsuresNonNull({"#1"})
    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@ColorInt int i) {
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(Color.alpha(i) / 255.0d));
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[');
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
            }
            z = false;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(it.next());
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (z) {
            return;
        }
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j >= -2147483648L) {
            return (int) j;
        }
        return Integer.MIN_VALUE;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        if (j2 < 0) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2) < 0 ? j : j - j2;
        } else if (j >= 0) {
            return j % j2;
        } else {
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3, j2) < 0) {
                j2 = 0;
            }
            return j3 - j2;
        }
    }

    public static Intent Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        Intent intent;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
        } else {
            intent = null;
        }
        return (intent == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, intent)) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) : intent;
    }

    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }

    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<T> it) {
        if (it.hasNext()) {
            T next = it.next();
            it.remove();
            return next;
        }
        return null;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (xmlPullParser.getEventType() == 2) && xmlPullParser.getName().equals(str);
    }

    public static int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int i;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i2 = indexOf4 + 2;
        if (i2 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i2) == '/') {
            i = str.indexOf(47, indexOf4 + 3);
            if (i == -1 || i > indexOf2) {
                i = indexOf2;
            }
        } else {
            i = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    public static int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<? extends Number> collection) {
        if (collection instanceof Ints$IntArrayAsList) {
            return ((Ints$IntArrayAsList) collection).toIntArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        if (j2 < 0) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2) < 0 ? 0L : 1L;
        } else if (j >= 0) {
            return j / j2;
        } else {
            int i = 1;
            long j3 = ((j >>> 1) / j2) << 1;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j - (j3 * j2), j2) < 0) {
                i = 0;
            }
            return j3 + i;
        }
    }

    @Nullable
    public static Drawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        Drawable drawable;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawable = AppCompatResources.getDrawable(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawable;
    }

    public static Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("package:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(context.getPackageName());
        return Uri.parse(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Nullable
    public static TypedValue Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @AttrRes int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<? extends T> it, T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static <V> V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 5)));
        sb.append(".");
        sb.append(str);
        sb.append(",.");
        sb.append(str);
        sb.append(" *");
        return sb.toString();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Iterable<? extends Object> iterable) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "", iterable);
    }

    public static /* synthetic */ Collection Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection collection, Object obj) {
        return new Synchronized$SynchronizedCollection(collection, obj);
    }

    public static <T> AbstractC2386mx<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<? extends T> it) {
        return it instanceof C1961bw ? (C1961bw) it : new C1961bw(it);
    }

    public static <T> AbstractC2573rt<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<? extends T> collection) {
        return new Predicates$InPredicate(collection);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
        if (i > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be positive but was: " + i);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, int i) {
        if (z) {
            return;
        }
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Integer.valueOf(i)));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, long j) {
        if (z) {
            return;
        }
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Long.valueOf(j)));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, obj));
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, List<String> list) {
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return true;
        }
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
        return (f3 * f2) + ((1.0f - f3) * f);
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f3 - f, f4 - f2);
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, float f, int i2, int i3) {
        float f2;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f2 = i3;
        } else if (i != 1) {
            if (i == 2) {
                return f;
            }
            return -3.4028235E38f;
        } else {
            f2 = i2;
        }
        return f * f2;
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @Dimension(unit = 0) int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view) {
        float f = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f += ViewCompat.getElevation((View) parent);
        }
        return f;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, double d) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > ((int) (d * highestOneBit))) {
            int i2 = highestOneBit << 1;
            if (i2 <= 0) {
                return 1073741824;
            }
            return i2;
        }
        return highestOneBit;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        if (i < i2 || i >= i3) {
            throw new IndexOutOfBoundsException();
        }
        return i;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        int i = ((j ^ Long.MIN_VALUE) > (j2 ^ Long.MIN_VALUE) ? 1 : ((j ^ Long.MIN_VALUE) == (j2 ^ Long.MIN_VALUE) ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    @ColorInt
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @AttrRes int i, @ColorInt int i2) {
        TypedValue Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, i);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.data : i2;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @AttrRes int i, @NonNull String str) {
        TypedValue Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, i);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        return (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) ? 13 : -1;
    }

    public static <E, K extends Comparable> int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<E> list, AbstractC2271jt<? super E, K> abstractC2271jt, K k, SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, abstractC2271jt, k, Ordering.natural(), sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<String, List<String>> map) {
        List<String> list = map.get("Content-Type");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((list == null || list.isEmpty()) ? null : list.get(0));
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        int i = 0;
        while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 0) {
            int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            i += Wwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwww != 255) {
                return i;
            }
        }
        return -1;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i + i3, i2 - i3);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                break;
            }
            i3 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return i3;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((b2 & 255) << 48) | ((b & 255) << 56) | ((b3 & 255) << 40) | ((b4 & 255) << 32) | ((b5 & 255) << 24) | ((b6 & 255) << 16) | ((b7 & 255) << 8) | (b8 & 255);
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j);
    }

    @NonNull
    public static Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2641tn abstractC2641tn, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(abstractC2641tn, (Property<AbstractC2641tn, V>) AbstractC2641tn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (TypeEvaluator) AbstractC2641tn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Object[]) new AbstractC2641tn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]{new AbstractC2641tn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2, f3)});
        AbstractC2641tn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww revealInfo = abstractC2641tn.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) abstractC2641tn, (int) f, (int) f2, revealInfo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static Intent Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
        return intent;
    }

    @Nullable
    public static ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        ColorStateList colorStateList;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateList;
    }

    @Nullable
    public static ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @NonNull TintTypedArray tintTypedArray, @StyleableRes int i) {
        int resourceId;
        ColorStateList colorStateList;
        return (!tintTypedArray.hasValue(i) || (resourceId = tintTypedArray.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? tintTypedArray.getColorStateList(i) : colorStateList;
    }

    public static PorterDuff.Mode Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i == 5) {
                return PorterDuff.Mode.SRC_IN;
            }
            if (i == 9) {
                return PorterDuff.Mode.SRC_ATOP;
            }
            switch (i) {
                case 14:
                    return PorterDuff.Mode.MULTIPLY;
                case 15:
                    return PorterDuff.Mode.SCREEN;
                case 16:
                    return PorterDuff.Mode.ADD;
                default:
                    return mode;
            }
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    @Nullable
    public static PorterDuffColorFilter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static <T extends CharSequence> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, String str, Object... objArr) {
        if (t != null) {
            if (t.length() == 0) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    @EnsuresNonNull({"#1"})
    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("at index ", i));
    }

    @NonNull
    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable T t, @NonNull String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, String str, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, obj));
    }

    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static <V> V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Future<V> future) throws ExecutionException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(future.isDone(), "Future was expected to be done: %s", future);
        return (V) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Future<Object>) future);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        return Integer.toHexString(c).toUpperCase();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, String str) {
        if (i < 0) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("negative size: ", i2));
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i) {
        int i2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i3 == 0) {
            return "0";
        }
        if (i3 > 0) {
            return Long.toString(j, i);
        }
        char[] cArr = new char[64];
        int i4 = i - 1;
        if ((i & i4) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            i2 = 64;
            do {
                i2--;
                cArr[i2] = Character.forDigit(((int) j) & i4, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 1) == 0 ? (j >>> 1) / (i >>> 1) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i);
            long j2 = i;
            i2 = 63;
            cArr[63] = Character.forDigit((int) (j - (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * j2)), i);
            while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                i2--;
                cArr[i2] = Character.forDigit((int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww % j2), i);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww /= j2;
            }
        }
        return new String(cArr, i2, 64 - i2);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, Iterable<? extends Object> iterable) {
        Iterator<? extends Object> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(str2);
            sb.append(it.next());
            sb.append(str2);
            if (!it.hasNext()) {
                return sb.toString();
            }
            sb.append(str);
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringBuilder sb, int i, int i2) {
        int i3;
        int i4;
        if (i >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i5 = i;
        int i6 = i5;
        while (i5 <= i2) {
            if (i5 == i2) {
                i3 = i5;
            } else if (sb.charAt(i5) == '/') {
                i3 = i5 + 1;
            } else {
                i5++;
            }
            int i7 = i6 + 1;
            if (i5 == i7 && sb.charAt(i6) == '.') {
                sb.delete(i6, i3);
                i2 -= i3 - i6;
            } else {
                if (i5 == i6 + 2 && sb.charAt(i6) == '.' && sb.charAt(i7) == '.') {
                    i4 = sb.lastIndexOf("/", i6 - 2) + 1;
                    int i8 = i4 > i ? i4 : i;
                    sb.delete(i8, i3);
                    i2 -= i3 - i8;
                } else {
                    i4 = i5 + 1;
                }
                i6 = i4;
            }
            i5 = i6;
        }
        return sb.toString();
    }

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence... charSequenceArr) {
        CharSequence charSequence;
        if (charSequenceArr.length == 0) {
            return "";
        }
        if (charSequenceArr.length == 1) {
            charSequence = charSequenceArr[0];
        } else {
            int i = 0;
            int i2 = -1;
            for (int i3 = 0; i3 < charSequenceArr.length; i3++) {
                int length = charSequenceArr[i3].length();
                i += length;
                if (i2 != -2 && length > 0) {
                    i2 = i2 == -1 ? i3 : -2;
                }
            }
            if (i == 0) {
                return "";
            }
            if (i2 <= 0) {
                StringBuilder sb = new StringBuilder(i);
                for (CharSequence charSequence2 : charSequenceArr) {
                    sb.append(charSequence2);
                }
                return sb.toString();
            }
            charSequence = charSequenceArr[i2];
        }
        return charSequence.toString();
    }

    public static <T> ArrayList<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T... tArr) {
        if (tArr == null || tArr.length == 0) {
            return null;
        }
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    public static /* synthetic */ Collection Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection collection) {
        return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : collection instanceof Set ? Collections.unmodifiableSet((Set) collection) : collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
    }

    public static <E> NavigableSet<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof Sets$UnmodifiableNavigableSet)) ? navigableSet : new Sets$UnmodifiableNavigableSet(navigableSet);
    }

    @Nullable
    public static C2075ei Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2075ei c2075ei, @Nullable String[] strArr, Map<String, C2075ei> map) {
        int i = 0;
        if (c2075ei == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                C2075ei c2075ei2 = new C2075ei();
                int length = strArr.length;
                while (i < length) {
                    c2075ei2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map.get(strArr[i]));
                    i++;
                }
                return c2075ei2;
            }
        } else if (strArr != null && strArr.length == 1) {
            c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map.get(strArr[0]));
            return c2075ei;
        } else if (strArr != null && strArr.length > 1) {
            int length2 = strArr.length;
            while (i < length2) {
                c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map.get(strArr[i]));
                i++;
            }
        }
        return c2075ei;
    }

    public static <T> C2577rx<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<T> cls, String str) {
        try {
            return new C2577rx<>(cls.getDeclaredField(str), null);
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    public static C2814y7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, boolean z, boolean z2) throws ParserException {
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, c2078el, false);
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        String[] strArr = new String[(int) Wwwwwwwwwwwwwwwwwwwwwwwwwwww];
        int length = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() + 11 + 4;
        for (int i = 0; i < Wwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
            strArr[i] = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
            length = length + 4 + strArr[i].length();
        }
        if (!z2 || (c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 1) != 0) {
            return new C2814y7(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, strArr, length + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AnimatorSet animatorSet, @NonNull List<Animator> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            j = Math.max(j, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15, "csd-", i), ByteBuffer.wrap(list.get(i)));
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Spannable spannable, Object obj, int i, int i2, int i3) {
        Object[] spans;
        for (Object obj2 : spannable.getSpans(i, i2, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i && spannable.getSpanEnd(obj2) == i2 && spannable.getSpanFlags(obj2) == i3) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i, i2, i3);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
        if (obj != null) {
            if (obj2 != null) {
                return;
            }
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
        throw new NullPointerException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("null key in entry: null=", obj2));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HashMap<String, Integer> hashMap, String str, int i) {
        String str2;
        if (hashMap.containsKey(str)) {
            Integer num = hashMap.get(str);
            if (num == null || num.intValue() >= i) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The AndroidManifest.xml file <uses-permission android:name=\"");
            sb.append(str);
            sb.append("\" android:maxSdkVersion=\"");
            sb.append(num);
            sb.append("\" /> does not meet the requirements, ");
            if (i != Integer.MAX_VALUE) {
                str2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("the minimum requirement for maxSdkVersion is ", i);
            } else {
                str2 = "please delete the android:maxSdkVersion=\"" + num + "\" attribute";
            }
            sb.append(str2);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Please register permissions in the AndroidManifest.xml file <uses-permission android:name=\"", str, "\" />"));
    }

    public static <K, V> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public static <E> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2090ex<E> abstractC2090ex, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(abstractC2090ex.mo4575entrySet().size());
        for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : abstractC2090ex.mo4575entrySet()) {
            objectOutputStream.writeObject(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement());
            objectOutputStream.writeInt(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2876zw<K, V> abstractC2876zw, ObjectInputStream objectInputStream, int i) throws IOException, ClassNotFoundException {
        for (int i2 = 0; i2 < i; i2++) {
            Collection mo4793get = abstractC2876zw.mo4793get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                mo4793get.add(objectInputStream.readObject());
            }
        }
    }

    public static <K, V> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2876zw<K, V> abstractC2876zw, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(abstractC2876zw.mo4790asMap().size());
        for (Map.Entry<K, Collection<V>> entry : abstractC2876zw.mo4790asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            for (V v : entry.getValue()) {
                objectOutputStream.writeObject(v);
            }
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, @NonNull String str) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, int i) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Integer.valueOf(i)));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, int i, int i2) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, long j) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Long.valueOf(j)));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, long j, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Long.valueOf(j), obj));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, obj));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, Object obj, Object obj2) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, obj, obj2));
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
        return Math.getExponent(d) <= 1023;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, C2078el c2078el, boolean z) throws ParserException {
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() < 7) {
            if (!z) {
                throw new ParserException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(29, "too short header: ", c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
            }
            return false;
        } else if (c2078el.Wwwwwwwwwwwwwwwwwwwwww() != i) {
            if (z) {
                return false;
            }
            String valueOf = String.valueOf(Integer.toHexString(i));
            throw new ParserException(valueOf.length() != 0 ? "expected header type ".concat(valueOf) : new String("expected header type "));
        } else if (c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 118 && c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 111 && c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 114 && c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 98 && c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 105 && c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 115) {
            return true;
        } else {
            if (!z) {
                throw new ParserException("expected characters 'vorbis'");
            }
            return false;
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity) {
        int rotation = (Build.VERSION.SDK_INT >= 30 ? activity.getDisplay() : activity.getWindowManager().getDefaultDisplay()).getRotation();
        return rotation == 2 || rotation == 3;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @AttrRes int i, boolean z) {
        TypedValue Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, i);
        return (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.type != 18) ? z : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.data != 0;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty();
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<?> it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    public static Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    public static <T> T[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) tArr, size);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<?>) collection, (Object[]) tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public static Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr[i], i);
        }
        return objArr;
    }

    public static /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return null;
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement();
    }

    public static Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<?> iterable) {
        return (iterable instanceof Collection ? (Collection) iterable : C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable.iterator())).toArray();
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, "index"));
        }
        return i;
    }

    public static /* synthetic */ Set Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Set set, Object obj) {
        if (set instanceof SortedSet) {
            return new Synchronized$SynchronizedSortedSet((SortedSet) set, obj);
        }
        return new Synchronized$SynchronizedSet(set, obj);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i3, "start index") : (i2 < 0 || i2 > i3) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3, "end index") : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, C2078el c2078el, AbstractC2740w7[] abstractC2740w7Arr) {
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        if (!((Wwwwwwwwwwwwwwwwwwwwww & 64) != 0)) {
            return;
        }
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        int i = (Wwwwwwwwwwwwwwwwwwwwww & 31) * 3;
        int i2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        for (AbstractC2740w7 abstractC2740w7 : abstractC2740w7Arr) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, i);
            abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, 1, i, 0, null);
        }
    }

    public static /* synthetic */ Collection Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection collection, Object obj) {
        if (collection instanceof SortedSet) {
            return new Synchronized$SynchronizedSortedSet((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return new Synchronized$SynchronizedSet((Set) collection, obj);
        }
        if (!(collection instanceof List)) {
            return new Synchronized$SynchronizedCollection(collection, obj);
        }
        List list = (List) collection;
        return list instanceof RandomAccess ? new Synchronized$SynchronizedRandomAccessList(list, obj) : new Synchronized$SynchronizedList(list, obj);
    }

    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    @NonNull
    public static ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull OO000 oo000) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, oo000);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream);
                inputStream.reset();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != ImageHeaderParser.ImageType.UNKNOWN) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static /* synthetic */ Map.Entry Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry entry, Object obj) {
        if (entry == null) {
            return null;
        }
        return new Synchronized$SynchronizedEntry(entry, obj);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (xmlPullParser.getEventType() == 3) && xmlPullParser.getName().equals(str);
    }

    public static /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Iterable iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object obj : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        if (iterable == null) {
            throw null;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) collection, (Iterator) iterable.iterator());
    }

    @Nullable
    public static C2399n9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2078el c2078el = new C2078el(bArr);
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 32) {
            return null;
        }
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + 4 || c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 1886614376 || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >> 24) & 255) > 1) {
            return null;
        }
        UUID uuid = new UUID(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwww(), c2078el.Wwwwwwwwwwwwwwwwwwwwwwwww());
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwww() * 16);
        }
        int Wwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwww != c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return null;
        }
        byte[] bArr2 = new byte[Wwwwwwwwwwwwwwwwwww];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr2, 0, Wwwwwwwwwwwwwwwwwww);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwww;
        return new C2399n9(uuid, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr2);
    }

    public static <T> boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<T> collection, Iterator<? extends T> it) {
        if (collection != null) {
            if (it == null) {
                throw null;
            }
            boolean z = false;
            while (it.hasNext()) {
                z |= collection.add(it.next());
            }
            return z;
        }
        throw null;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 18) {
            Trace.beginSection(str);
        }
    }

    public static C2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        int Wwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwww();
        long j = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwww;
        int i = Wwwwwwwwwwwwwwwwwwww / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long Wwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = Wwwwwwwwwwwwwwwwwwwwwwwww;
            jArr2[i2] = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwww();
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
            i2++;
        }
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (j - c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        return new C2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr, jArr2);
    }

    public static <E, K> int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<E> list, AbstractC2271jt<? super E, K> abstractC2271jt, K k, Comparator<? super K> comparator, SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        List lists$TransformingRandomAccessList = list instanceof RandomAccess ? new Lists$TransformingRandomAccessList(list, abstractC2271jt) : new Lists$TransformingSequentialList(list, abstractC2271jt);
        if (comparator != null) {
            if (sortedLists$KeyPresentBehavior == null) {
                throw null;
            }
            if (sortedLists$KeyAbsentBehavior != null) {
                if (!(lists$TransformingRandomAccessList instanceof RandomAccess)) {
                    lists$TransformingRandomAccessList = C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lists$TransformingRandomAccessList);
                }
                int i = 0;
                int size = lists$TransformingRandomAccessList.size() - 1;
                while (i <= size) {
                    int i2 = (i + size) >>> 1;
                    int compare = comparator.compare(k, (Object) lists$TransformingRandomAccessList.get(i2));
                    if (compare < 0) {
                        size = i2 - 1;
                    } else if (compare <= 0) {
                        return sortedLists$KeyPresentBehavior.resultIndex(comparator, k, lists$TransformingRandomAccessList.subList(i, size + 1), i2 - i) + i;
                    } else {
                        i = i2 + 1;
                    }
                }
                return sortedLists$KeyAbsentBehavior.resultIndex(i);
            }
            throw null;
        }
        throw null;
    }

    public static List<byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((((bArr[11] & 255) << 8) | (bArr[10] & 255)) * 1000000000) / 48000));
        arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(80000000L));
        return arrayList;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<?> it, Collection<?> collection) {
        if (collection != null) {
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        throw null;
    }

    public static <T> T[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) (iterable instanceof Collection ? (Collection) iterable : C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable.iterator())).toArray(tArr);
    }

    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UUID uuid, @Nullable byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else if (i2 < 0) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("negative size: ", i2));
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return i;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<?> it) {
        if (it != null) {
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
            return;
        }
        throw null;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, C2078el c2078el, AbstractC2740w7[] abstractC2740w7Arr) {
        while (true) {
            boolean z = true;
            if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 1) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
                int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 4 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 >= 8) {
                    int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                    int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwww == 49 ? c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : 0;
                    int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwww == 47) {
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    }
                    boolean z2 = Wwwwwwwwwwwwwwwwwwwwww == 181 && (Wwwwwwwwwwwwwwwww == 49 || Wwwwwwwwwwwwwwwww == 47) && Wwwwwwwwwwwwwwwwwwwwww2 == 3;
                    if (Wwwwwwwwwwwwwwwww == 49) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1195456820) {
                            z = false;
                        }
                        z2 &= z;
                    }
                    if (z2) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, c2078el, abstractC2740w7Arr);
                    }
                }
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            } else {
                return;
            }
        }
    }

    @NonNull
    public static C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 0) {
            if (i != 1) {
                return new C2379mq();
            }
            return new C2231iq();
        }
        return new C2379mq();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 18) {
            Trace.endSection();
        }
    }

    @ColorInt
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @AttrRes int i) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view.getContext(), i, view.getClass().getCanonicalName());
    }

    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<T> iterable) {
        T next;
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (!list.isEmpty()) {
                return (T) list.get(list.size() - 1);
            }
            throw new NoSuchElementException();
        }
        Iterator<T> it = iterable.iterator();
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull OO000 oo000) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, oo000);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, oo000);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static Intent Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, List<String> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            if (!list.isEmpty()) {
                for (String str : list) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && list.size() == 3 && list.contains("android.permission.MANAGE_EXTERNAL_STORAGE") && list.contains("android.permission.READ_EXTERNAL_STORAGE") && list.contains(UMUtils.SD_PERMISSION)) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
                }
                if (list.size() == 1) {
                    String str2 = list.get(0);
                    if ("android.permission.MANAGE_EXTERNAL_STORAGE".equals(str2)) {
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
                    }
                    Intent intent = null;
                    if ("android.permission.REQUEST_INSTALL_PACKAGES".equals(str2)) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                            intent.setData(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
                        }
                        return (intent == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, intent)) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) : intent;
                    } else if ("android.permission.SYSTEM_ALERT_WINDOW".equals(str2)) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                            intent.setData(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
                        }
                        return (intent == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, intent)) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) : intent;
                    } else if ("android.permission.NOTIFICATION_SERVICE".equals(str2)) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                        }
                        return (intent == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, intent)) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) : intent;
                    } else if ("android.permission.WRITE_SETTINGS".equals(str2)) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                            intent.setData(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
                        }
                        return (intent == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, intent)) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) : intent;
                    }
                }
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<?> comparator, Iterable<?> iterable) {
        Object comparator2;
        if (comparator != null) {
            if (iterable == null) {
                throw null;
            }
            if (iterable instanceof SortedSet) {
                comparator2 = ((SortedSet) iterable).comparator();
                if (comparator2 == null) {
                    comparator2 = Ordering.natural();
                }
            } else if (!(iterable instanceof AbstractC2689ux)) {
                return false;
            } else {
                comparator2 = ((AbstractC2689ux) iterable).comparator();
            }
            return comparator.equals(comparator2);
        }
        throw null;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return true;
        }
        if ("android.permission.MANAGE_EXTERNAL_STORAGE".equals(str)) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        }
        if ("android.permission.REQUEST_INSTALL_PACKAGES".equals(str)) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return true;
            }
            return context.getPackageManager().canRequestPackageInstalls();
        } else if ("android.permission.SYSTEM_ALERT_WINDOW".equals(str)) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return true;
            }
            return Settings.canDrawOverlays(context);
        } else if ("android.permission.NOTIFICATION_SERVICE".equals(str)) {
            if (Build.VERSION.SDK_INT >= 24) {
                return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
            }
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return true;
            }
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                return ((Integer) appOpsManager.getClass().getMethod(NotificationManagerCompat.CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) appOpsManager.getClass().getDeclaredField(NotificationManagerCompat.OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName())).intValue() == 0;
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException e) {
                e.printStackTrace();
                return true;
            }
        } else if ("android.permission.WRITE_SETTINGS".equals(str)) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return true;
            }
            return Settings.System.canWrite(context);
        } else {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                if ("android.permission.BLUETOOTH_SCAN".equals(str)) {
                    return context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
                } else if ("android.permission.BLUETOOTH_CONNECT".equals(str) || "android.permission.BLUETOOTH_ADVERTISE".equals(str)) {
                    return true;
                }
            }
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                if ("android.permission.ACCESS_BACKGROUND_LOCATION".equals(str)) {
                    return context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
                } else if ("android.permission.ACTIVITY_RECOGNITION".equals(str)) {
                    return context.checkSelfPermission("android.permission.BODY_SENSORS") == 0;
                } else if ("android.permission.ACCESS_MEDIA_LOCATION".equals(str)) {
                    return true;
                }
            }
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwww() && "android.permission.ACCEPT_HANDOVER".equals(str)) {
                return true;
            }
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                if ("android.permission.ANSWER_PHONE_CALLS".equals(str)) {
                    return true;
                }
                if ("android.permission.READ_PHONE_NUMBERS".equals(str)) {
                    return context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
                }
            }
            return context.checkSelfPermission(str) == 0;
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, List<String> list) {
        boolean z;
        Iterator<String> it = list.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            String next = it.next();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next)) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    if ("android.permission.BLUETOOTH_SCAN".equals(next)) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, "android.permission.ACCESS_COARSE_LOCATION")) {
                            continue;
                        } else {
                            if (activity.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION")) {
                                continue;
                            }
                            z = true;
                            continue;
                        }
                    } else if ("android.permission.BLUETOOTH_CONNECT".equals(next)) {
                        continue;
                    } else if ("android.permission.BLUETOOTH_ADVERTISE".equals(next)) {
                        continue;
                    }
                }
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || !"android.permission.ACCESS_BACKGROUND_LOCATION".equals(next) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, "android.permission.ACCESS_BACKGROUND_LOCATION") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, "android.permission.ACCESS_FINE_LOCATION")) {
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        if ("android.permission.ACCESS_BACKGROUND_LOCATION".equals(next)) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, "android.permission.ACCESS_FINE_LOCATION")) {
                                continue;
                            } else {
                                if (activity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
                                    continue;
                                }
                                z = true;
                                continue;
                            }
                        } else if ("android.permission.ACTIVITY_RECOGNITION".equals(next)) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, "android.permission.BODY_SENSORS")) {
                                continue;
                            } else {
                                if (activity.shouldShowRequestPermissionRationale("android.permission.BODY_SENSORS")) {
                                    continue;
                                }
                                z = true;
                                continue;
                            }
                        } else if ("android.permission.ACCESS_MEDIA_LOCATION".equals(next)) {
                            continue;
                        }
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww() || !"android.permission.ACCEPT_HANDOVER".equals(next)) {
                        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            if ("android.permission.ANSWER_PHONE_CALLS".equals(next)) {
                                continue;
                            } else if ("android.permission.READ_PHONE_NUMBERS".equals(next)) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, "android.permission.READ_PHONE_STATE")) {
                                    continue;
                                } else {
                                    if (activity.shouldShowRequestPermissionRationale("android.permission.READ_PHONE_STATE")) {
                                        continue;
                                    }
                                    z = true;
                                    continue;
                                }
                            }
                        }
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, next)) {
                            continue;
                        } else {
                            if (activity.shouldShowRequestPermissionRationale(next)) {
                                continue;
                            }
                            z = true;
                            continue;
                        }
                    }
                } else {
                    z = !activity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION");
                    continue;
                }
            }
        } while (!z);
        return true;
    }

    @ColorInt
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@ColorInt int i, @ColorInt int i2, @FloatRange(from = 0.0d, m4213to = 1.0d) float f) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i2, Math.round(Color.alpha(i2) * f)), i);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object... objArr) {
        String str2;
        int indexOf;
        String valueOf = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                try {
                    str2 = String.valueOf(obj);
                } catch (Exception e) {
                    String str3 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str3, (Throwable) e);
                    str2 = "<" + str3 + " threw " + e.getClass().getName() + ">";
                }
                objArr[i2] = str2;
            }
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + valueOf.length());
        int i3 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf(FormattableUtils.SIMPLEST_FORMAT, i3)) != -1) {
            sb.append((CharSequence) valueOf, i3, indexOf);
            sb.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) valueOf, i3, valueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static <T> T[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T[] tArr, int i) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
    }

    @Nullable
    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, UUID uuid) {
        C2399n9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return null;
        }
        if (uuid != null && !uuid.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            String valueOf = String.valueOf(uuid);
            String valueOf2 = String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            valueOf.length();
            valueOf2.length();
            return null;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public static C2475pb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        C2518qb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr;
        if (abstractC2212i7 != null) {
            C2078el c2078el = new C2078el(16);
            if (C2518qb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, c2078el).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1380533830) {
                return null;
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 4);
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 1463899717) {
                return null;
            }
            while (true) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2518qb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, c2078el);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1718449184) {
                    break;
                }
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 16);
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 16);
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            int Wwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwww4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            int i = ((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) - 16;
            if (i > 0) {
                byte[] bArr2 = new byte[i];
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, 0, i);
                bArr = bArr2;
            } else {
                bArr = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return new C2475pb(Wwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwww4, bArr);
        }
        throw null;
    }

    @Nullable
    public static C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, boolean z) throws IOException {
        C2218id.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z ? null : C2218id.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2078el c2078el = new C2078el(10);
        C2254jc c2254jc = null;
        int i = 0;
        while (true) {
            try {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 10);
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                if (c2078el.Wwwwwwwwwwwwwwwwwwww() != 4801587) {
                    break;
                }
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                int Wwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwww();
                int i2 = Wwwwwwwwwwwwwwwwwwwwwww + 10;
                if (c2254jc == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, bArr, 0, 10);
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 10, Wwwwwwwwwwwwwwwwwwwwwww);
                    c2254jc = new C2218id(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i2);
                } else {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        if (c2254jc == null || c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww.length == 0) {
            return null;
        }
        return c2254jc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2090ex<E> abstractC2090ex, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            abstractC2090ex.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, int i2) {
        byte[] bArr;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() < 5) {
            return -9223372036854775807L;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if ((8388608 & Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != 0 || ((2096896 & Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) >> 8) != i2) {
            return -9223372036854775807L;
        }
        if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 32) != 0) && c2078el.Wwwwwwwwwwwwwwwwwwwwww() >= 7 && c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 7) {
            if ((c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 16) == 16) {
                System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new byte[6], 0, 6);
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += 6;
                return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | ((bArr[3] & 255) << 1) | ((bArr[4] & 255) >> 7);
            }
        }
        return -9223372036854775807L;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<?> it, Collection<?> collection) {
        if (collection != null) {
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        throw null;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Set<?> set, Collection<?> collection) {
        if (collection != null) {
            if (collection instanceof AbstractC2090ex) {
                collection = ((AbstractC2090ex) collection).mo4975elementSet();
            }
            return (!(collection instanceof Set) || collection.size() <= set.size()) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(set, collection.iterator()) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(set.iterator(), collection);
        }
        throw null;
    }

    public static Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str, @Nullable String str2) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        int i2;
        int i3;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] != -1) {
            sb.append(str2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1], Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2]);
        } else {
            int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[3] == 0) {
                i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[3];
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2] != 0) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1] != 0) {
                    int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[0] + 1;
                    sb.append((CharSequence) str, 0, i4);
                    sb.append(str2);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1] + i4, i4 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2]);
                } else {
                    if (str2.charAt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1]) == '/') {
                        sb.append((CharSequence) str, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1]);
                        sb.append(str2);
                        i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1];
                        i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1] + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2];
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[0] + 2 >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1] || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1] != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[2]) {
                        int lastIndexOf = str.lastIndexOf(47, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[2] - 1);
                        int i5 = lastIndexOf == -1 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1] : lastIndexOf + 1;
                        sb.append((CharSequence) str, 0, i5);
                        sb.append(str2);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1], i5 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2]);
                    } else {
                        sb.append((CharSequence) str, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1]);
                        sb.append('/');
                        sb.append(str2);
                        i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1];
                        i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1] + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2] + 1;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, i, i2);
                }
                return Uri.parse(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[2];
            }
            sb.append((CharSequence) str, 0, i3);
            sb.append(str2);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sb.toString();
        return Uri.parse(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, float f) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) background;
            MaterialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww == f) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = f;
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        C2605so c2605so = materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2605so != null && c2605so.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
            MaterialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }
}

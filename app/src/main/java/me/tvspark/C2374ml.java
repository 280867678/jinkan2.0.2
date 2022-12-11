package me.tvspark;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.location.GpsStatusWrapper;
import androidx.core.view.DisplayCompat;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.lzf.easyfloat.permission.PermissionUtils;
import com.stub.StubApp;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.statistics.idtracking.C1789g;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.mozilla.javascript.Token;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: me.tvspark.ml */
/* loaded from: classes4.dex */
public final class C2374ml {
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwww;
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final String[] Wwwwwwwwwwwwwwwwwwwwwwwww;
    public static final String[] Wwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public static HashMap<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "R".equals(Build.VERSION.CODENAME) ? 30 : Build.VERSION.SDK_INT;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Build.DEVICE;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Build.MANUFACTURER;
        String str = Build.MODEL;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        String str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, 17))));
        sb.append(str2);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sb.toString();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[0];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
        Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        Wwwwwwwwwwwwwwwwwwwwwwwwww = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", C1543ak.f2994ae, C1789g.f4109a, "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        Wwwwwwwwwwwwwwwwwwwwwwwww = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        Wwwwwwwwwwwwwwwwwwwwwwww = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        Wwwwwwwwwwwwwwwwwwwwwww = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, TbsListener.ErrorCode.RENAME_FAIL, TbsListener.ErrorCode.TPATCH_FAIL, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, TinkerReport.KEY_LOADED_EXCEPTION_DEX, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION, 245, TbsListener.ErrorCode.INCR_UPDATE_ERROR, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, TbsListener.ErrorCode.COPY_TMPDIR_ERROR, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, Token.USE_STACK, 130, Token.LOOP, TbsListener.ErrorCode.STARTDOWNLOAD_9, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 166, 161, 180, 179, NormalCmdFactory.TASK_RESTART, 189, PermissionUtils.requestCode, 192, 201, 206, TbsListener.ErrorCode.RENAME_EXCEPTION, TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, 213, 210, 255, 248, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, 246, TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, TbsListener.ErrorCode.INCR_ERROR_DETAIL, TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS, TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS, 183, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, NormalCmdFactory.TASK_CANCEL_ALL, 190, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2, 165, 162, 143, Token.JSR, 129, Token.EXPR_VOID, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, Token.SCRIPT, 142, Token.EXPR_RESULT, 128, 149, 146, 155, 156, 177, 182, 191, 184, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3, 170, 163, 164, 249, TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE, 247, TbsListener.ErrorCode.TPATCH_VERSION_FAILED, TbsListener.ErrorCode.INSTALL_FROM_UNZIP, TbsListener.ErrorCode.DEXOAT_EXCEPTION, TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS, GpsStatusWrapper.QZSS_SVID_MIN, 198, 207, 200, TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, TbsListener.ErrorCode.STARTDOWNLOAD_10, 160, 167, 178, 181, 188, 187, 150, 145, 152, Token.LETEXPR, Token.TYPEOFNAME, 141, Token.TARGET, Token.LABEL, TbsListener.ErrorCode.UNLZMA_FAIURE, TbsListener.ErrorCode.INCR_UPDATE_FAIL, 208, TbsListener.ErrorCode.COPY_EXCEPTION, 194, 197, 204, 203, TbsListener.ErrorCode.RENAME_SUCCESS, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, TbsListener.ErrorCode.INSTALL_SUCCESS_AND_RELEASE_LOCK, TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, 250, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, TbsListener.ErrorCode.DOWNLOAD_FAILED_FOR_PREINIT_CALLBACK};
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i & 4294967295L;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return str == null ? str : str.toLowerCase(Locale.US);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i == 10 || i == 13;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4;
    }

    public static String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        return TextUtils.isEmpty(str) ? new String[0] : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.trim(), "(\\s*,\\s*)");
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, long j3) {
        long j4 = j - j2;
        return ((j ^ j4) & (j2 ^ j)) < 0 ? j3 : j4;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i == 536870912 || i == 805306368 || i == 4;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        UiModeManager uiModeManager = (UiModeManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String locale;
        String[] strArr;
        Configuration configuration = Resources.getSystem().getConfiguration();
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i >= 24) {
            strArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(configuration.getLocales().toLanguageTags(), ",");
        } else {
            String[] strArr2 = new String[1];
            Locale locale2 = configuration.locale;
            if (i >= 21) {
                locale = locale2.toLanguageTag();
            } else {
                locale = locale2.toString();
            }
            strArr2[0] = locale;
            strArr = strArr2;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr[i2]);
        }
        return strArr;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 13) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }
        return 1;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        ConnectivityManager connectivityManager;
        int i = 0;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return 1;
            }
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                if (type == 1) {
                    return 2;
                }
                if (type != 4 && type != 5) {
                    if (type == 6) {
                        return 5;
                    }
                    return type != 9 ? 8 : 7;
                }
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                    return 3;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 14:
                case 15:
                case 17:
                    return 4;
                case 13:
                    return 5;
                case 16:
                case 19:
                default:
                    return 6;
                case 18:
                    return 2;
                case 20:
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 29) {
                        i = 9;
                    }
                    return i;
            }
        } catch (SecurityException unused) {
            return 0;
        }
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, long j3) {
        int i = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        if (i < 0 || j3 % j2 != 0) {
            if (i < 0 && j2 % j3 == 0) {
                return (j2 / j3) * j;
            }
            return (long) (j * (j2 / j3));
        }
        return j / (j3 / j2);
    }

    public static Looper Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    public static ExecutorService Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: me.tvspark.qk
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, runnable);
            }
        });
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 8) {
            if (i == 16) {
                return 2;
            }
            if (i == 24) {
                return 536870912;
            }
            return i != 32 ? 0 : 805306368;
        }
        return 3;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i != 2) {
            if (i == 3) {
                return i2;
            }
            if (i != 4) {
                if (i != 268435456) {
                    if (i == 536870912) {
                        return i2 * 3;
                    }
                    if (i != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i2 * 4;
        }
        return i2 * 2;
    }

    public static <T extends Comparable<? super T>> int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i;
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (list.get(binarySearch).compareTo(t) == 0);
            i = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = Wwwwwwwwwwwwwwwwwwwwwww[i3 ^ (bArr[i] & 255)];
            i++;
        }
        return i3;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            i = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, float f) {
        return f == 1.0f ? j : Math.round(j / f);
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    public static Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return new Handler(myLooper, null);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            sb.append(objArr[i].getClass().getSimpleName());
            if (i < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return str.getBytes(C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static <T> T[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T[] tArr, T t) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length + 1);
        tArr2[tArr.length] = t;
        return tArr2;
    }

    public static String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        return str.split(str2, 2);
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
            case 6:
                return TinkerReport.KEY_LOADED_EXCEPTION_DEX;
            case 7:
                return 1276;
            case 8:
                int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return (i2 < 23 && i2 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer, int i) {
        int i2 = byteBuffer.getInt(i);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i2 : Integer.reverseBytes(i2);
    }

    public static <T extends Comparable<? super T>> int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i;
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i = ~binarySearch;
        } else {
            int size = list.size();
            do {
                binarySearch++;
                if (binarySearch >= size) {
                    break;
                }
            } while (list.get(binarySearch).compareTo(t) == 0);
            i = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? Math.min(list.size() - 1, i) : i;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2864zk c2864zk, long j, boolean z, boolean z2) {
        int i;
        int i2 = c2864zk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            if (c2864zk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4) < j) {
                i3 = i4 + 1;
            } else {
                i2 = i4 - 1;
            }
        }
        if (!z || (i = i2 + 1) >= c2864zk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || c2864zk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) != j) {
            if (z2 && i2 == -1) {
                return 0;
            }
            return i2;
        }
        return i;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = Wwwwwwwwwwwwwwwwwwwwwwww[((i3 >>> 24) ^ (bArr[i] & 255)) & 255] ^ (i3 << 8);
            i++;
        }
        return i3;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, int i, boolean z, boolean z2) {
        int i2;
        int binarySearch = Arrays.binarySearch(iArr, i);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (iArr[binarySearch] == i);
            i2 = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? Math.max(0, i2) : i2;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = ~binarySearch;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            i = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? Math.min(jArr.length - 1, i) : i;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, float f) {
        return f == 1.0f ? j : Math.round(j * f);
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, long j3) {
        long j4 = j + j2;
        return ((j ^ j4) & (j2 ^ j4)) < 0 ? j3 : j4;
    }

    public static Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper, @Nullable Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, int i) {
        return charSequence.length() <= i ? charSequence : charSequence.subSequence(0, i);
    }

    @EnsuresNonNull({"#1"})
    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable T t) {
        return t;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        String str3 = Build.VERSION.RELEASE;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 38))));
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        sb.append(" (Linux;Android ");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str3, ") ", "ExoPlayerLib/2.12.1");
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        return new String(bArr, C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static /* synthetic */ Thread Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static <T> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<T> list, int i, int i2) {
        if (i < 0 || i2 > list.size() || i > i2) {
            throw new IllegalArgumentException();
        }
        if (i == i2) {
            return;
        }
        list.subList(i, i2).clear();
    }

    public static <T> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<T> list, int i, int i2, int i3) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i4 = (i2 - i) - 1; i4 >= 0; i4--) {
            arrayDeque.addFirst(list.remove(i + i4));
        }
        list.addAll(Math.min(i3, list.size()), arrayDeque);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2863zj abstractC2863zj) {
        if (abstractC2863zj != null) {
            try {
                abstractC2863zj.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long[] jArr, long j, long j2) {
        int i = 0;
        int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
        if (i2 >= 0 && j2 % j == 0) {
            long j3 = j2 / j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
        } else if (i2 >= 0 || j % j2 != 0) {
            double d = j / j2;
            while (i < jArr.length) {
                jArr[i] = (long) (jArr[i] * d);
                i++;
            }
        } else {
            long j4 = j / j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j4;
                i++;
            }
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
            return true;
        }
        return handler.post(runnable);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object[] objArr, @Nullable Object obj) {
        for (Object obj2 : objArr) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T[] tArr) {
        return tArr;
    }

    public static <T> T[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T[] tArr, int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, i);
    }

    public static <T> T[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        return str.split(str2, -1);
    }

    public static Point Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(windowManager);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 29 && defaultDisplay.getDisplayId() == 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context)) {
            if ("Sony".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(DisplayCompat.DISPLAY_SIZE_4K_WIDTH, DisplayCompat.DISPLAY_SIZE_4K_HEIGHT);
            }
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 28 ? "sys.display-size" : "vendor.display-size");
            if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                try {
                    String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.trim(), "x");
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length == 2) {
                        int parseInt = Integer.parseInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3[0]);
                        int parseInt2 = Integer.parseInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                String valueOf = String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                if (valueOf.length() != 0) {
                    "Invalid display size: ".concat(valueOf);
                } else {
                    new String("Invalid display size: ");
                }
            }
        }
        Point point = new Point();
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i >= 23) {
            Display.Mode mode = defaultDisplay.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
            return point;
        } else if (i >= 17) {
            defaultDisplay.getRealSize(point);
            return point;
        } else {
            defaultDisplay.getSize(point);
            return point;
        }
    }

    public static Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Looper myLooper = Looper.myLooper();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(myLooper);
        return new Handler(myLooper, null);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !"und".equals(replace)) {
            str = replace;
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        int i = 0;
        String str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "-")[0];
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            String[] iSOLanguages = Locale.getISOLanguages();
            HashMap<String, String> hashMap = new HashMap<>(iSOLanguages.length + Wwwwwwwwwwwwwwwwwwwwwwwwww.length);
            for (String str3 : iSOLanguages) {
                try {
                    String iSO3Language = new Locale(str3).getISO3Language();
                    if (!TextUtils.isEmpty(iSO3Language)) {
                        hashMap.put(iSO3Language, str3);
                    }
                } catch (MissingResourceException unused) {
                }
            }
            int i2 = 0;
            while (true) {
                String[] strArr = Wwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i2 >= strArr.length) {
                    break;
                }
                hashMap.put(strArr[i2], strArr[i2 + 1]);
                i2 += 2;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwww = hashMap;
        }
        String str4 = Wwwwwwwwwwwwwwwwwwwwwwwwwww.get(str2);
        if (str4 != null) {
            String valueOf = String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.substring(str2.length()));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4);
            str2 = str4;
        }
        if (!"no".equals(str2) && !C1543ak.f2966aC.equals(str2) && !"zh".equals(str2)) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        while (true) {
            String[] strArr2 = Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (i >= strArr2.length) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith(strArr2[i])) {
                String valueOf2 = String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwww[i + 1]);
                String valueOf3 = String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.substring(Wwwwwwwwwwwwwwwwwwwwwwwww[i].length()));
                return valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
            }
            i += 2;
        }
    }

    public static Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Handler.Callback callback) {
        Looper myLooper = Looper.myLooper();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(myLooper);
        return new Handler(myLooper, callback);
    }

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str, int i) {
        String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            if (i == C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() <= 0) {
            return null;
        }
        return sb.toString();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return networkCountryIso == null ? networkCountryIso : networkCountryIso.toUpperCase(Locale.US);
            }
        }
        String country = Locale.getDefault().getCountry();
        return country == null ? country : country.toUpperCase(Locale.US);
    }

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            String valueOf = String.valueOf(str);
            C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueOf.length() != 0 ? "Failed to read system property ".concat(valueOf) : new String("Failed to read system property "), e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, C2078el c2078el2, @Nullable Inflater inflater) {
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() <= 0) {
            return false;
        }
        byte[] bArr = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (bArr.length < c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            bArr = new byte[c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() * 2];
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        int i = 0;
        while (true) {
            try {
                i += inflater.inflate(bArr, i, bArr.length - i);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    } else if (i == bArr.length) {
                        bArr = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                } else {
                    c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
                    c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                    c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                    return true;
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
    }
}

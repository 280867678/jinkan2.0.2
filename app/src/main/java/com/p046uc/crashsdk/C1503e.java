package com.p046uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.Environment;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.p046uc.crashsdk.export.LogType;
import com.p046uc.crashsdk.p047a.C1491a;
import com.p046uc.crashsdk.p047a.C1492b;
import com.p046uc.crashsdk.p047a.C1493c;
import com.p046uc.crashsdk.p047a.C1494d;
import com.p046uc.crashsdk.p047a.C1496f;
import com.p046uc.crashsdk.p047a.C1497g;
import com.p046uc.crashsdk.p047a.C1498h;
import com.p046uc.crashsdk.p047a.RunnableC1495e;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.C1615d;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.apache.commons.lang3.time.DateUtils;
import org.eclipse.jetty.http.HttpHeaderValues;
import org.fourthline.cling.model.Constants;

/* renamed from: com.uc.crashsdk.e */
/* loaded from: classes4.dex */
public class C1503e implements Thread.UncaughtExceptionHandler {

    /* renamed from: b */
    public static long f2780b;

    /* renamed from: i */
    public static String f2786i;

    /* renamed from: e */
    public final List<FileInputStream> f2804e = new ArrayList();

    /* renamed from: a */
    public static final /* synthetic */ boolean f2772a = !C1503e.class.desiredAssertionStatus();

    /* renamed from: c */
    public static final AtomicBoolean f2781c = new AtomicBoolean(false);

    /* renamed from: d */
    public static boolean f2782d = false;

    /* renamed from: f */
    public static long f2783f = 0;

    /* renamed from: g */
    public static long f2784g = -1;

    /* renamed from: h */
    public static boolean f2785h = true;

    /* renamed from: j */
    public static String f2787j = "";

    /* renamed from: k */
    public static String f2788k = null;

    /* renamed from: l */
    public static String f2789l = null;

    /* renamed from: m */
    public static String f2790m = null;

    /* renamed from: n */
    public static final Object f2791n = new Object();

    /* renamed from: o */
    public static final ConditionVariable f2792o = new ConditionVariable();

    /* renamed from: p */
    public static final Object f2793p = new Object();

    /* renamed from: q */
    public static final Object f2794q = new Object();

    /* renamed from: r */
    public static final Object f2795r = new Object();

    /* renamed from: s */
    public static final ArrayList<String> f2796s = new ArrayList<>();

    /* renamed from: t */
    public static int f2797t = 0;

    /* renamed from: u */
    public static String f2798u = null;

    /* renamed from: v */
    public static boolean f2799v = false;

    /* renamed from: w */
    public static String f2800w = null;

    /* renamed from: x */
    public static String f2801x = null;

    /* renamed from: y */
    public static final Object f2802y = new Object();

    /* renamed from: z */
    public static final Object f2803z = new Object();

    /* renamed from: A */
    public static Map<String, Integer> f2746A = null;

    /* renamed from: B */
    public static String f2747B = null;

    /* renamed from: C */
    public static int f2748C = -1;

    /* renamed from: D */
    public static int f2749D = -1;

    /* renamed from: E */
    public static int f2750E = -1;

    /* renamed from: F */
    public static int f2751F = -1;

    /* renamed from: G */
    public static int f2752G = -1;

    /* renamed from: H */
    public static int f2753H = -1;

    /* renamed from: I */
    public static int f2754I = -1;

    /* renamed from: J */
    public static String f2755J = "?";

    /* renamed from: K */
    public static boolean f2756K = false;

    /* renamed from: L */
    public static boolean f2757L = false;

    /* renamed from: M */
    public static int f2758M = 0;

    /* renamed from: N */
    public static int f2759N = 0;

    /* renamed from: O */
    public static boolean f2760O = false;

    /* renamed from: P */
    public static RunnableC1495e f2761P = new RunnableC1495e(405);

    /* renamed from: Q */
    public static C1506c f2762Q = new C1506c((byte) 0);

    /* renamed from: R */
    public static boolean f2763R = false;

    /* renamed from: S */
    public static final RunnableC1495e f2764S = new RunnableC1495e(412);

    /* renamed from: T */
    public static Thread.UncaughtExceptionHandler f2765T = null;

    /* renamed from: U */
    public static Throwable f2766U = null;

    /* renamed from: V */
    public static boolean f2767V = false;

    /* renamed from: W */
    public static boolean f2768W = false;

    /* renamed from: X */
    public static Runnable f2769X = null;

    /* renamed from: Y */
    public static final Object f2770Y = new Object();

    /* renamed from: Z */
    public static int f2771Z = 101;

    /* renamed from: aa */
    public static Runnable f2773aa = new RunnableC1495e(407);

    /* renamed from: ab */
    public static final Object f2774ab = new Object();

    /* renamed from: ac */
    public static volatile boolean f2775ac = false;

    /* renamed from: ad */
    public static Object f2776ad = new Object();

    /* renamed from: ae */
    public static ParcelFileDescriptor f2777ae = null;

    /* renamed from: af */
    public static boolean f2778af = false;

    /* renamed from: ag */
    public static boolean f2779ag = false;

    /* renamed from: com.uc.crashsdk.e$a */
    /* loaded from: classes4.dex */
    public static class C1504a extends OutputStream {

        /* renamed from: a */
        public final long f2805a;

        /* renamed from: b */
        public final OutputStream f2806b;

        /* renamed from: c */
        public int f2807c = 0;

        /* renamed from: d */
        public int f2808d = 0;

        /* renamed from: e */
        public boolean f2809e = false;

        public C1504a(long j, OutputStream outputStream) {
            this.f2805a = j;
            this.f2806b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int m1575a(byte[] bArr, int i, int i2) {
            int i3;
            this.f2808d += i2;
            if (this.f2809e) {
                return 0;
            }
            int m1474y = C1509g.m1474y();
            if (m1474y > 0) {
                int i4 = this.f2807c;
                if (i4 + i2 > m1474y) {
                    i3 = m1474y - i4;
                    this.f2807c += i3;
                    if (this.f2805a == 0) {
                        m1574b(new String(bArr, i, i3));
                    } else {
                        this.f2806b.write(bArr, i, i3);
                    }
                    if (i3 < i2) {
                        this.f2809e = true;
                    }
                    return i3;
                }
            }
            i3 = i2;
            this.f2807c += i3;
            if (this.f2805a == 0) {
            }
            if (i3 < i2) {
            }
            return i3;
        }

        /* renamed from: b */
        private void m1574b(String str) {
            if (C1500b.f2714d) {
                JNIBridge.nativeClientWriteData(this.f2805a, str);
            }
        }

        /* renamed from: a */
        public final void m1577a() {
            try {
                if (this.f2808d - this.f2807c > 0) {
                    m1576a("\n");
                    m1576a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                m1576a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.f2808d), Integer.valueOf(this.f2807c), Integer.valueOf(C1509g.m1474y()), Integer.valueOf(this.f2808d - this.f2807c)));
            } catch (Throwable th) {
                C1497g.m1868a(th);
            }
        }

        /* renamed from: a */
        public final void m1576a(String str) {
            if (C1503e.f2785h && C1503e.m1697O()) {
                C1491a.m1920d("DEBUG", str);
            }
            if (this.f2805a != 0) {
                m1574b(str);
            } else {
                this.f2806b.write(str.getBytes("UTF-8"));
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            if (C1503e.f2785h && C1503e.m1697O()) {
                C1491a.m1920d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i)));
            }
            if (this.f2805a != 0) {
                m1574b(String.format(Locale.US, "%c", Integer.valueOf(i)));
            } else {
                this.f2806b.write(i);
            }
            this.f2807c++;
            this.f2808d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            if (C1503e.f2785h && C1503e.m1697O() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    C1491a.m1920d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            m1575a(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) {
            if (C1503e.f2785h && C1503e.m1697O()) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                if (i2 != 1 || bArr2[0] != 10) {
                    try {
                        C1491a.m1920d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            m1575a(bArr, i, i2);
        }
    }

    /* renamed from: com.uc.crashsdk.e$b */
    /* loaded from: classes4.dex */
    public static class C1505b implements Comparator<File> {
        public C1505b() {
        }

        public /* synthetic */ C1505b(byte b) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }
    }

    /* renamed from: com.uc.crashsdk.e$c */
    /* loaded from: classes4.dex */
    public static class C1506c extends BroadcastReceiver {
        public C1506c() {
        }

        public /* synthetic */ C1506c(byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.intent.action.BATTERY_CHANGED".equals(action)) {
                if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                    boolean unused = C1503e.f2756K = "android.intent.action.BATTERY_LOW".equals(action);
                    C1503e.m1701K();
                    return;
                } else if (!"android.intent.action.ANR".equals(action)) {
                    return;
                } else {
                    try {
                        C1503e.m1629d(context);
                        return;
                    } catch (Throwable th) {
                        C1497g.m1868a(th);
                        return;
                    }
                }
            }
            int unused2 = C1503e.f2748C = intent.getIntExtra("level", -1);
            int unused3 = C1503e.f2749D = intent.getIntExtra("scale", -1);
            int unused4 = C1503e.f2750E = intent.getIntExtra("voltage", -1);
            int unused5 = C1503e.f2751F = intent.getIntExtra("health", -1);
            int unused6 = C1503e.f2752G = intent.getIntExtra("plugged", -1);
            int unused7 = C1503e.f2753H = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            int unused8 = C1503e.f2754I = intent.getIntExtra("temperature", -1);
            String unused9 = C1503e.f2755J = intent.getStringExtra("technology");
            if (C1503e.m1702J() < 2) {
                return;
            }
            C1503e.m1701K();
            int unused10 = C1503e.f2758M = 0;
        }
    }

    /* renamed from: com.uc.crashsdk.e$d */
    /* loaded from: classes4.dex */
    public static class C1507d {

        /* renamed from: a */
        public long f2810a;

        /* renamed from: b */
        public long f2811b;

        /* renamed from: c */
        public int f2812c;

        /* renamed from: d */
        public int f2813d;

        /* renamed from: e */
        public boolean f2814e;

        /* renamed from: f */
        public boolean f2815f;

        /* renamed from: g */
        public boolean f2816g;

        public C1507d() {
            this.f2810a = 0L;
            this.f2811b = 0L;
            this.f2812c = 0;
            this.f2813d = 0;
            this.f2814e = false;
            this.f2815f = false;
            this.f2816g = false;
        }

        public /* synthetic */ C1507d(byte b) {
            this();
        }
    }

    public C1503e() {
        try {
            m1699M();
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
    }

    /* renamed from: A */
    public static void m1711A() {
        if (!C1509g.m1482q()) {
            return;
        }
        C1496f.m1888a(0, new RunnableC1495e(403), 10000L);
    }

    /* renamed from: B */
    public static void m1710B() {
        if (!f2775ac && !C1500b.m1785L()) {
            C1496f.m1888a(1, new RunnableC1495e(408), 1000L);
        }
    }

    /* renamed from: C */
    public static void m1709C() {
        C1496f.m1888a(1, new RunnableC1495e(409), 7000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003b, code lost:
        if ((java.lang.System.currentTimeMillis() % 3) == 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r0 == 1) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
        r3 = false;
     */
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1708D() {
        int m1525L = C1509g.m1525L();
        boolean z = true;
        boolean z2 = false;
        if (m1525L == 0 || m1525L == 3 || m1525L == 4) {
            if (Build.VERSION.SDK_INT <= 25) {
                boolean z3 = m1525L != 0;
                if (m1525L == 3) {
                    z3 = System.currentTimeMillis() % 10 == 0;
                }
                if (m1525L != 4) {
                    z = z3;
                }
            }
        }
        if (!z) {
            C1491a.m1925a("crashsdk", "SIG 3 is disabled by settings");
        }
        boolean m1785L = C1500b.m1785L();
        if (Looper.getMainLooper() == Looper.myLooper() || !z) {
            z2 = z;
        } else {
            C1496f.m1889a(2, new RunnableC1495e(413));
        }
        JNIBridge.nativeCmd(7, m1785L ? 1L : 0L, null, null);
        if (z2) {
            JNIBridge.cmd(8);
        }
    }

    /* renamed from: E */
    public static ParcelFileDescriptor m1707E() {
        if (!C1500b.f2714d) {
            C1491a.m1920d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        synchronized (f2776ad) {
            if (f2777ae != null) {
                return f2777ae;
            }
            int cmd = (int) JNIBridge.cmd(14);
            if (cmd == -1) {
                return null;
            }
            ParcelFileDescriptor adoptFd = ParcelFileDescriptor.adoptFd(cmd);
            f2777ae = adoptFd;
            f2778af = true;
            return adoptFd;
        }
    }

    /* renamed from: F */
    public static boolean m1706F() {
        return f2779ag;
    }

    /* renamed from: G */
    public static void m1705G() {
        String m1515V = C1509g.m1515V();
        File file = new File(m1515V);
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            C1491a.m1923b("Ucebu can not list folder: " + m1515V);
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isFile() && file2.getName().contains("ucebu")) {
                m1655a(false, false);
                return;
            }
        }
    }

    /* renamed from: J */
    public static /* synthetic */ int m1702J() {
        int i = f2758M + 1;
        f2758M = i;
        return i;
    }

    /* renamed from: K */
    public static /* synthetic */ void m1701K() {
        StringBuilder m1687Y;
        if (C1500b.f2714d && (m1687Y = m1687Y()) != null) {
            JNIBridge.set(125, m1687Y.toString());
        }
        f2757L = true;
        m1686Z();
    }

    /* renamed from: M */
    private void m1699M() {
        int m1530G = C1509g.m1530G();
        for (int i = 0; i < m1530G; i++) {
            try {
                this.f2804e.add(new FileInputStream("/dev/null"));
            } catch (Exception e) {
                C1497g.m1868a(e);
                return;
            }
        }
    }

    /* renamed from: N */
    private void m1698N() {
        for (FileInputStream fileInputStream : this.f2804e) {
            C1497g.m1879a(fileInputStream);
        }
        this.f2804e.clear();
    }

    /* renamed from: O */
    public static boolean m1697O() {
        if (C1509g.m1523N()) {
            return true;
        }
        return m1685a();
    }

    /* renamed from: P */
    public static String m1696P() {
        return C1509g.m1494e() + "_";
    }

    /* renamed from: Q */
    public static String m1695Q() {
        return C1500b.m1795B() ? "fg" : "bg";
    }

    /* renamed from: R */
    public static byte[] m1694R() {
        byte[] bArr = null;
        int i = 1024;
        while (bArr == null && i > 0) {
            try {
                bArr = new byte[i];
            } catch (Throwable unused) {
                i /= 2;
                if (i < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    /* renamed from: S */
    public static String m1693S() {
        return (!C1500b.m1791F() || f2782d) ? LogType.JAVA_TYPE : "ucebujava";
    }

    /* renamed from: T */
    public static void m1692T() {
        String str;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String str2 = "-";
        try {
            str = Build.HARDWARE;
        } catch (Throwable th2) {
            C1497g.m1868a(th2);
            str = str2;
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i = 0;
                do {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("Hardware")) {
                            str = readLine.substring(readLine.indexOf(":") + 1).trim();
                        } else if (readLine.startsWith("Processor")) {
                            str2 = readLine.substring(readLine.indexOf(":") + 1).trim();
                        }
                        i++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            C1497g.m1868a(th);
                            C1497g.m1879a(fileReader);
                            C1497g.m1879a(bufferedReader);
                            f2788k = str;
                            f2789l = str2;
                        } catch (Throwable th4) {
                            C1497g.m1879a(fileReader);
                            C1497g.m1879a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i < 2);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
        }
        C1497g.m1879a(fileReader);
        C1497g.m1879a(bufferedReader);
        f2788k = str;
        f2789l = str2;
    }

    /* renamed from: U */
    public static String m1691U() {
        return C1509g.m1516U() + HttpHeaderValues.BYTES;
    }

    /* renamed from: V */
    public static boolean m1690V() {
        return Build.VERSION.SDK_INT < 29;
    }

    /* renamed from: W */
    public static void m1689W() {
        if (f2760O || C1500b.m1791F() || C1500b.m1785L()) {
            return;
        }
        JNIBridge.cmd(18);
    }

    /* renamed from: X */
    public static void m1688X() {
        C1496f.m1888a(3, new RunnableC1495e(414), 1000L);
    }

    /* renamed from: Y */
    public static StringBuilder m1687Y() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(f2748C);
            sb.append("\n");
            sb.append("scale: ");
            sb.append(f2749D);
            sb.append("\n");
            String str2 = " (Unknown)";
            switch (f2751F) {
                case 1:
                    str = str2;
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(f2751F);
            sb.append(str);
            sb.append("\n");
            int i = f2752G;
            String str3 = i != 0 ? i != 1 ? i != 2 ? i != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(f2752G);
            sb.append(str3);
            sb.append("\n");
            int i2 = f2753H;
            if (i2 != 1) {
                str2 = i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)";
            }
            sb.append("status: ");
            sb.append(f2753H);
            sb.append(str2);
            sb.append("\n");
            sb.append("voltage: ");
            sb.append(f2750E);
            sb.append("\n");
            sb.append("temperature: ");
            sb.append(f2754I);
            sb.append("\n");
            sb.append("technology: ");
            sb.append(f2755J);
            sb.append("\n");
            sb.append("battery low: ");
            sb.append(f2756K);
            sb.append("\n");
            return sb;
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return null;
        }
    }

    /* renamed from: Z */
    public static void m1686Z() {
        if (!C1500b.f2713c || !f2757L || !C1490a.f2596c) {
            return;
        }
        f2757L = false;
        if (C1496f.m1884b(f2761P)) {
            return;
        }
        C1496f.m1888a(0, f2761P, 2000L);
    }

    /* renamed from: a */
    public static int m1674a(OutputStream outputStream, String str, int i) {
        int i2 = 0;
        if (str == null) {
            m1675a(outputStream);
            return 0;
        }
        try {
            String m1919a = C1492b.m1919a(str);
            if (m1919a == null) {
                m1919a = "file: '" + str + "' not found or decode failed!";
            }
            int length = m1919a.length();
            if (length <= i + 32) {
                i = length;
            }
            if (i > 0) {
                try {
                    outputStream.write(m1919a.getBytes("UTF-8"), 0, i);
                    outputStream.write("\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    i2 = i;
                    m1660a(th, outputStream);
                    i = i2;
                    m1675a(outputStream);
                    return i;
                }
            }
            if (i < m1919a.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(m1919a.length() - i)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        m1675a(outputStream);
        return i;
    }

    /* renamed from: a */
    public static long m1680a(StatFs statFs, String str, String str2) {
        try {
            Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(statFs, new Object[0]);
            if (invoke != null && (invoke instanceof Long)) {
                return ((Long) invoke).longValue();
            }
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object invoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (invoke2 != null && (invoke2 instanceof Integer)) {
                return ((Integer) invoke2).intValue();
            }
            return 0L;
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return 0L;
        }
    }

    /* renamed from: a */
    public static BufferedReader m1676a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i = 8192;
        while (bufferedReader == null && i > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i);
            } catch (Throwable unused) {
                i /= 2;
                if (i < 512) {
                    break;
                }
            }
        }
        return bufferedReader;
    }

    /* renamed from: a */
    public static String m1684a(int i) {
        try {
            String m1876a = C1497g.m1876a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i))), 128, false);
            return C1497g.m1863b(m1876a) ? m1599l(m1876a) : "unknown";
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return "unknown";
        }
    }

    /* renamed from: a */
    public static String m1677a(File file) {
        String str;
        try {
            str = file.getCanonicalPath();
        } catch (Throwable unused) {
            str = null;
        }
        return C1497g.m1872a(str) ? file.getPath() : str;
    }

    /* renamed from: a */
    public static String m1670a(String str) {
        int lastIndexOf;
        int indexOf;
        int i;
        int indexOf2;
        File file;
        byte[] m1855e;
        if (C1509g.m1475x() && (lastIndexOf = str.lastIndexOf(47)) > 0 && (indexOf = str.indexOf(95, lastIndexOf)) > lastIndexOf && (indexOf2 = str.indexOf(95, (i = indexOf + 1))) > indexOf) {
            String m1859c = C1497g.m1859c("CrashSDK" + str.substring(lastIndexOf + 1, indexOf) + str.substring(i, indexOf2));
            if (m1859c == null || (m1855e = C1497g.m1855e((file = new File(str)))) == null || m1855e.length <= 0) {
                return str;
            }
            byte[] bArr = null;
            try {
                bArr = C1493c.m1903b(m1855e, m1859c.substring(0, 16).getBytes());
            } catch (Throwable th) {
                C1497g.m1868a(th);
            }
            if (bArr == null) {
                return str;
            }
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".ec");
            File file2 = new File(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ".tmp"));
            if (!C1497g.m1873a(file2, bArr)) {
                return str;
            }
            if (!file2.renameTo(new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
                file2.delete();
                return str;
            }
            file.delete();
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
        r3.write(r4.getBytes("UTF-8"));
        r3.write("\n".getBytes("UTF-8"));
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1666a(String str, String str2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(Build.VERSION.SDK_INT >= 26 ? new String[]{"ps", "-ef"} : new String[]{"ps"}).getInputStream()));
            boolean m1863b = C1497g.m1863b(str);
            boolean m1863b2 = C1497g.m1863b(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                boolean z = true;
                if ((!m1863b || !readLine.contains(str)) && ((!m1863b2 || !readLine.contains(str2)) && (readLine.indexOf(47) >= 0 || readLine.indexOf(46) <= 0))) {
                    z = false;
                }
            }
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return "exception exists.";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0358 A[Catch: all -> 0x0368, TryCatch #15 {all -> 0x0368, blocks: (B:98:0x0354, B:100:0x0358, B:101:0x0362), top: B:97:0x0354 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02da A[Catch: all -> 0x0334, TRY_LEAVE, TryCatch #13 {all -> 0x0334, blocks: (B:16:0x003d, B:31:0x0105, B:41:0x0181, B:43:0x0190, B:45:0x0194, B:47:0x01a8, B:49:0x01b3, B:55:0x01f9, B:57:0x020d, B:75:0x02c4, B:77:0x02d6, B:79:0x02da, B:81:0x02ee, B:84:0x0302, B:86:0x0306, B:88:0x031a, B:89:0x031c, B:110:0x0225, B:35:0x011c, B:46:0x0196, B:90:0x0322, B:20:0x0091, B:24:0x00bd, B:26:0x00c3, B:28:0x00cd, B:21:0x009a, B:23:0x00ab, B:80:0x02dc, B:48:0x01aa, B:29:0x00ea, B:82:0x02f0, B:52:0x01cd, B:54:0x01d1, B:115:0x01e3, B:117:0x01e9, B:37:0x0127, B:13:0x002f, B:15:0x0033, B:50:0x01b6, B:83:0x02f9, B:40:0x0160, B:30:0x00f7, B:56:0x01ff, B:51:0x01bf, B:18:0x0046, B:42:0x0187, B:32:0x0108, B:19:0x0050, B:76:0x02cd, B:33:0x0111, B:87:0x0308, B:39:0x013b), top: B:12:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0306 A[Catch: all -> 0x0334, TRY_LEAVE, TryCatch #13 {all -> 0x0334, blocks: (B:16:0x003d, B:31:0x0105, B:41:0x0181, B:43:0x0190, B:45:0x0194, B:47:0x01a8, B:49:0x01b3, B:55:0x01f9, B:57:0x020d, B:75:0x02c4, B:77:0x02d6, B:79:0x02da, B:81:0x02ee, B:84:0x0302, B:86:0x0306, B:88:0x031a, B:89:0x031c, B:110:0x0225, B:35:0x011c, B:46:0x0196, B:90:0x0322, B:20:0x0091, B:24:0x00bd, B:26:0x00c3, B:28:0x00cd, B:21:0x009a, B:23:0x00ab, B:80:0x02dc, B:48:0x01aa, B:29:0x00ea, B:82:0x02f0, B:52:0x01cd, B:54:0x01d1, B:115:0x01e3, B:117:0x01e9, B:37:0x0127, B:13:0x002f, B:15:0x0033, B:50:0x01b6, B:83:0x02f9, B:40:0x0160, B:30:0x00f7, B:56:0x01ff, B:51:0x01bf, B:18:0x0046, B:42:0x0187, B:32:0x0108, B:19:0x0050, B:76:0x02cd, B:33:0x0111, B:87:0x0308, B:39:0x013b), top: B:12:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0351  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1659a(Throwable th, String str, long j, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            if (!C1500b.m1785L()) {
                C1509g.m1510a();
                m1656a(true);
            }
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            fileOutputStream = i == 0 ? new FileOutputStream(str) : null;
            try {
                C1504a c1504a = new C1504a(j, fileOutputStream);
                try {
                    if (C1500b.f2714d) {
                        JNIBridge.set(126, str);
                    }
                    m1643b(c1504a, str, m1693S());
                    if (z) {
                        c1504a.flush();
                    }
                    c1504a.write(("Process Name: '" + m1610h() + "'\n").getBytes("UTF-8"));
                    c1504a.write(("Thread Name: '" + Thread.currentThread().getName() + "'\n").getBytes("UTF-8"));
                    c1504a.write("Back traces starts.\n".getBytes("UTF-8"));
                    Field declaredField = Throwable.class.getDeclaredField("detailMessage");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(th);
                    if (obj != null) {
                        declaredField.set(th, ((String) obj).replaceAll("\n\t", "\n->  "));
                    }
                    String message = th.getMessage();
                    if (message != null && !message.equals(th.getLocalizedMessage())) {
                        c1504a.write(("Message: " + message + "\n").getBytes("UTF-8"));
                    }
                    th.printStackTrace(new PrintStream(c1504a));
                    c1504a.write("Back traces ends.\n".getBytes("UTF-8"));
                    m1675a((OutputStream) c1504a);
                    c1504a.flush();
                    C1490a.m1958a(c1504a, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                    if (z) {
                        c1504a.flush();
                    }
                    c1504a.write("meminfo:\n".getBytes("UTF-8"));
                    m1644b(c1504a, "/proc/meminfo", 10240);
                    String format = String.format(Locale.US, "/proc/%d/status", Integer.valueOf(Process.myPid()));
                    c1504a.write("status:\n".getBytes("UTF-8"));
                    m1644b(c1504a, format, 10240);
                    c1504a.write(("memory info:\n" + m1615g()).getBytes("UTF-8"));
                    m1675a((OutputStream) c1504a);
                    m1613g(c1504a);
                    C1490a.m1956a(c1504a, "UTF-8", (ArrayList<String>) null);
                    if (f2779ag) {
                        f2785h = false;
                        c1504a.write(m1585s("JAVADUMPFILES").getBytes("UTF-8"));
                        f2785h = true;
                    }
                    c1504a.flush();
                    m1645b((OutputStream) c1504a);
                    c1504a.flush();
                    c1504a.write("battery info:\n".getBytes("UTF-8"));
                    if (f2779ag) {
                        f2785h = false;
                        c1504a.write(m1585s("BATTERYINFO").getBytes("UTF-8"));
                        f2785h = true;
                    } else {
                        StringBuilder m1687Y = m1687Y();
                        if (m1687Y != null) {
                            c1504a.write(m1687Y.toString().getBytes("UTF-8"));
                        }
                    }
                    m1675a((OutputStream) c1504a);
                    m1634c(c1504a);
                    c1504a.write("device status:\n".getBytes("UTF-8"));
                    if (f2779ag) {
                        try {
                            f2785h = false;
                            c1504a.write(m1585s("DEVICESTATUS").getBytes("UTF-8"));
                            f2785h = true;
                        } catch (Throwable th2) {
                            th = th2;
                            m1660a(th, c1504a);
                            m1675a((OutputStream) c1504a);
                            m1628d(c1504a);
                            m1623e(c1504a);
                            C1490a.m1945b(c1504a, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", null);
                            if (f2779ag) {
                            }
                            c1504a.flush();
                            C1490a.m1957a(c1504a, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", null);
                            if (f2779ag) {
                            }
                            c1504a.m1577a();
                            m1679a(c1504a);
                            c1504a.flush();
                            if (i != 0) {
                            }
                            C1497g.m1879a(c1504a);
                            C1497g.m1879a(fileOutputStream);
                            if (!f2779ag) {
                            }
                            m1641b(f2779ag ? m1670a(m1597m(str)) : str, LogType.JAVA_TYPE);
                            return str;
                        }
                    } else {
                        try {
                            c1504a.write(String.format(Locale.US, "has root: %s\n", Boolean.valueOf(C1497g.m1856e())).getBytes("UTF-8"));
                            String str2 = "";
                            if (Build.TAGS != null) {
                                str2 = Build.TAGS;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("build tags: ");
                            sb.append(str2);
                            if (C1497g.m1854f()) {
                                sb.append(" (default root)");
                            }
                            sb.append("\n");
                            c1504a.write(sb.toString().getBytes("UTF-8"));
                            String m1852h = C1497g.m1852h();
                            if (C1497g.m1863b(m1852h)) {
                                c1504a.write(String.format(Locale.US, "su binary: %s\n", m1852h).getBytes("UTF-8"));
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("su permission: ");
                                sb2.append(C1497g.m1853g() ? "valid (" : "invalid (");
                                sb2.append(C1497g.m1851i());
                                sb2.append(")\n");
                                c1504a.write(sb2.toString().getBytes("UTF-8"));
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            m1660a(th, c1504a);
                            m1675a((OutputStream) c1504a);
                            m1628d(c1504a);
                            m1623e(c1504a);
                            C1490a.m1945b(c1504a, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", null);
                            if (f2779ag) {
                            }
                            c1504a.flush();
                            C1490a.m1957a(c1504a, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", null);
                            if (f2779ag) {
                            }
                            c1504a.m1577a();
                            m1679a(c1504a);
                            c1504a.flush();
                            if (i != 0) {
                            }
                            C1497g.m1879a(c1504a);
                            C1497g.m1879a(fileOutputStream);
                            if (!f2779ag) {
                            }
                            m1641b(f2779ag ? m1670a(m1597m(str)) : str, LogType.JAVA_TYPE);
                            return str;
                        }
                    }
                    m1675a((OutputStream) c1504a);
                    m1628d(c1504a);
                    m1623e(c1504a);
                    C1490a.m1945b(c1504a, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", null);
                    if (f2779ag) {
                        f2785h = false;
                        c1504a.write(m1585s("JAVACACHEDINFOS").getBytes("UTF-8"));
                        f2785h = true;
                    }
                    c1504a.flush();
                    C1490a.m1957a(c1504a, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", null);
                    if (f2779ag) {
                        f2785h = false;
                        c1504a.write(m1585s("JAVACALLBACKINFOS").getBytes("UTF-8"));
                        f2785h = true;
                    }
                    c1504a.m1577a();
                    m1679a(c1504a);
                    c1504a.flush();
                    if (i != 0) {
                        m1647b(c1504a);
                    }
                    C1497g.m1879a(c1504a);
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    m1660a(th, (OutputStream) null);
                    if (j != 0) {
                        m1647b((C1504a) null);
                    }
                    C1497g.m1879a((Closeable) null);
                    C1497g.m1879a(fileOutputStream);
                    if (!f2779ag) {
                    }
                    m1641b(f2779ag ? m1670a(m1597m(str)) : str, LogType.JAVA_TYPE);
                    return str;
                } catch (Throwable th5) {
                    if (j != 0) {
                        m1647b((C1504a) null);
                    }
                    C1497g.m1879a((Closeable) null);
                    C1497g.m1879a(fileOutputStream);
                    throw th5;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
        }
        C1497g.m1879a(fileOutputStream);
        if (!f2779ag) {
            m1587r(str);
        }
        try {
            m1641b(f2779ag ? m1670a(m1597m(str)) : str, LogType.JAVA_TYPE);
        } catch (Throwable th7) {
            C1497g.m1868a(th7);
        }
        return str;
    }

    /* renamed from: a */
    public static String m1657a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + Constants.UPNP_MULTICAST_PORT), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    /* renamed from: a */
    public static StringBuilder m1654a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z = str == null;
            int i2 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i2++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
                if (!z && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    z = true;
                    i2 = 0;
                }
            }
            i = i2;
        }
        if (i == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static void m1683a(int i, Object[] objArr) {
        int i2;
        switch (i) {
            case 401:
                JNIBridge.nativeCmd(10, C1500b.m1788I() == 5 ? 1L : 0L, null, null);
                C1490a.f2596c = true;
                C1490a.m1947a(false);
                f2757L = true;
                m1686Z();
                m1579y();
                return;
            case 402:
                synchronized (f2770Y) {
                    if (f2769X == null) {
                        return;
                    }
                    f2768W = true;
                    if (C1500b.m1733q()) {
                        return;
                    }
                    if (!C1494d.m1895e()) {
                        C1491a.m1921c("DEBUG", C1494d.m1898b());
                        return;
                    } else if (!m1627d(LogType.UNEXP_TYPE)) {
                        C1491a.m1920d("DEBUG", "unexp sample miss");
                        return;
                    } else {
                        int nativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(C1509g.m1484o(), C1509g.m1483p());
                        if (nativeGenerateUnexpLog != 0) {
                            C1508f.m1564a(11);
                            if ((nativeGenerateUnexpLog & 4352) != 0) {
                                f2771Z = 105;
                                i2 = 30;
                            } else if ((nativeGenerateUnexpLog & LogType.UNEXP_EXIT) != 0) {
                                f2771Z = 104;
                                i2 = 31;
                            } else if ((nativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                                f2771Z = 106;
                                i2 = 32;
                            } else {
                                if ((nativeGenerateUnexpLog & LogType.UNEXP_ANR) != 0) {
                                    f2771Z = 103;
                                    C1508f.m1564a(10);
                                } else if ((nativeGenerateUnexpLog & LogType.UNEXP_LOW_MEMORY) != 0) {
                                    f2771Z = 107;
                                    C1508f.m1564a(29);
                                } else {
                                    f2771Z = 102;
                                }
                                m1656a(true);
                            }
                            C1508f.m1564a(i2);
                            m1656a(true);
                        }
                        synchronized (f2770Y) {
                            f2769X = null;
                        }
                        return;
                    }
                }
            case 403:
                m1652ab();
                return;
            case 404:
            default:
                if (!f2772a) {
                    throw new AssertionError();
                }
                return;
            case 405:
                f2757L = false;
                StringBuilder m1687Y = m1687Y();
                String m1743g = C1500b.m1743g();
                if (m1687Y == null) {
                    return;
                }
                C1497g.m1874a(new File(m1743g), m1687Y.toString());
                return;
            case 406:
                if (!f2772a && objArr == null) {
                    throw new AssertionError();
                }
                m1664a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    C1490a.m1939d();
                    return;
                } catch (Throwable th) {
                    C1497g.m1868a(th);
                    return;
                }
            case 408:
                synchronized (f2774ab) {
                    if (!f2775ac && C1509g.m1522O() && C1500b.m1724z()) {
                        C1500b.m1731s();
                        C1498h.m1815f();
                        C1508f.m1546c();
                        if (C1500b.m1791F()) {
                            m1709C();
                        }
                        if (C1509g.m1522O()) {
                            m1658a(Calendar.getInstance());
                        }
                        f2775ac = true;
                        return;
                    }
                    return;
                }
            case 409:
                m1626d(false);
                return;
            case 410:
                m1655a(false, true);
                return;
            case 411:
                if (!C1500b.f2714d) {
                    return;
                }
                JNIBridge.set(28, m1627d(LogType.NATIVE_TYPE));
                JNIBridge.set(29, m1627d(LogType.ANR_TYPE));
                return;
            case 412:
                if (!f2763R && C1500b.m1795B() && C1509g.m1526K()) {
                    m1648b(C1497g.m1882a());
                    return;
                } else if (!f2763R) {
                    return;
                } else {
                    if (C1500b.m1795B() && C1509g.m1526K()) {
                        return;
                    }
                    try {
                        C1497g.m1882a().unregisterReceiver(f2762Q);
                        f2763R = false;
                        return;
                    } catch (Throwable th2) {
                        C1497g.m1868a(th2);
                        return;
                    }
                }
            case 413:
                JNIBridge.cmd(8);
                return;
            case 414:
                try {
                    if (m1629d(C1497g.m1882a())) {
                        return;
                    }
                    int i3 = f2759N + 1;
                    f2759N = i3;
                    if (i3 < 10) {
                        m1688X();
                        return;
                    } else if (!C1500b.f2714d) {
                        return;
                    } else {
                        JNIBridge.set(130, "(get failed)");
                        return;
                    }
                } catch (Throwable th3) {
                    C1497g.m1868a(th3);
                    return;
                }
            case 415:
                if (!f2772a && objArr == null) {
                    throw new AssertionError();
                }
                long longValue = ((Long) objArr[0]).longValue();
                Calendar calendar = Calendar.getInstance();
                if (calendar.getTimeInMillis() >= longValue) {
                    C1498h.m1814g();
                    C1508f.m1564a(100);
                    m1626d(true);
                    C1508f.m1552a(true);
                    C1498h.m1829b();
                } else {
                    C1498h.m1813h();
                    C1498h.m1812i();
                    C1498h.m1821c();
                }
                m1658a(calendar);
                break;
            case 416:
                break;
        }
        m1689W();
    }

    /* renamed from: a */
    public static void m1682a(Context context) {
        try {
            if (!m1690V()) {
                return;
            }
            context.registerReceiver(new C1506c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, C1496f.m1890a(3));
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
    }

    /* renamed from: a */
    public static void m1679a(C1504a c1504a) {
        try {
            c1504a.m1576a(String.format(Locale.US, "log end: %s\n", m1596n()));
        } catch (Throwable th) {
            m1660a(th, c1504a);
        }
    }

    /* renamed from: a */
    public static void m1678a(C1504a c1504a, String str, long j) {
        String nativeDumpThreads;
        String str2 = null;
        if (C1500b.f2714d) {
            try {
                c1504a.flush();
            } catch (Throwable th) {
                C1497g.m1868a(th);
            }
            nativeDumpThreads = JNIBridge.nativeDumpThreads(str, j);
            if (f2779ag || nativeDumpThreads == null || nativeDumpThreads.length() >= 512 || !nativeDumpThreads.startsWith("/") || nativeDumpThreads.indexOf(10) >= 0) {
                str2 = nativeDumpThreads;
            } else {
                if (!new File(nativeDumpThreads).exists()) {
                    str2 = "Can not found " + nativeDumpThreads;
                }
                String str3 = str2;
                str2 = nativeDumpThreads;
                nativeDumpThreads = str3;
            }
        } else {
            nativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (nativeDumpThreads != null) {
            try {
                c1504a.write(nativeDumpThreads.getBytes("UTF-8"));
                c1504a.write("\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                C1497g.m1868a(th2);
            }
            m1675a((OutputStream) c1504a);
        } else if (str2 != null && !f2779ag) {
            m1644b(c1504a, str2, 1048576);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            c1504a.flush();
        } catch (Throwable th3) {
            C1497g.m1868a(th3);
        }
    }

    /* renamed from: a */
    public static void m1675a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            m1660a(th, outputStream);
        }
    }

    /* renamed from: a */
    public static void m1673a(OutputStream outputStream, String str, String str2) {
        f2785h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        f2785h = true;
    }

    /* renamed from: a */
    public static void m1672a(OutputStream outputStream, String str, String str2, int i, boolean z, boolean z2) {
        int i2 = 0;
        f2785h = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i);
            objArr[3] = Integer.valueOf(z ? 1 : 0);
            if (z2) {
                i2 = 1;
            }
            objArr[4] = Integer.valueOf(i2);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes("UTF-8"));
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        f2785h = true;
        m1675a(outputStream);
    }

    /* renamed from: a */
    public static void m1671a(OutputStream outputStream, String str, Set<String> set) {
        if (C1497g.m1872a(str) || set.contains(str) || str.equals("/storage/emulated")) {
            return;
        }
        set.add(str);
        try {
            StatFs statFs = new StatFs(str);
            long m1680a = m1680a(statFs, "getBlockCountLong", "getBlockCount");
            long m1680a2 = m1680a(statFs, "getBlockSizeLong", "getBlockSize");
            if ((m1680a / 1024) * m1680a2 < 10240) {
                return;
            }
            long m1680a3 = m1680a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
            long m1680a4 = m1680a(statFs, "getFreeBlocksLong", "getFreeBlocks");
            try {
                outputStream.write(String.format(Locale.US, "%s:\n", str).getBytes("UTF-8"));
                double d = m1680a2;
                outputStream.write(String.format(Locale.US, "  total:      %d kB\n", Long.valueOf((long) (((m1680a * 1.0d) * d) / 1024.0d))).getBytes("UTF-8"));
                outputStream.write(String.format(Locale.US, "  available:  %d kB\n", Long.valueOf((long) (((m1680a3 * 1.0d) * d) / 1024.0d))).getBytes("UTF-8"));
                outputStream.write(String.format(Locale.US, "  free:       %d kB\n", Long.valueOf((long) (((m1680a4 * 1.0d) * d) / 1024.0d))).getBytes("UTF-8"));
                outputStream.write(String.format(Locale.US, "  block size: %d B\n\n", Long.valueOf(m1680a2)).getBytes("UTF-8"));
            } catch (Throwable th) {
                m1660a(th, outputStream);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02f1 A[Catch: all -> 0x0425, TryCatch #5 {all -> 0x0430, blocks: (B:11:0x041f, B:12:0x0421, B:13:0x042e, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x002f, B:17:0x0034, B:19:0x003a, B:20:0x004d, B:22:0x005d, B:24:0x0067, B:29:0x03b1, B:30:0x006d, B:32:0x007b, B:34:0x008d, B:35:0x00ae, B:37:0x00be, B:41:0x00cc, B:46:0x00f8, B:51:0x00ea, B:67:0x01c5, B:69:0x01d9, B:71:0x01dd, B:72:0x01df, B:74:0x01e4, B:75:0x01e6, B:76:0x01eb, B:80:0x020e, B:84:0x0224, B:86:0x022a, B:88:0x0233, B:89:0x023f, B:91:0x025e, B:92:0x0271, B:94:0x0283, B:96:0x0291, B:97:0x02a2, B:98:0x02e4, B:103:0x02f1, B:107:0x02fd, B:110:0x0305, B:112:0x0313, B:114:0x0320, B:116:0x0327, B:119:0x0334, B:121:0x0340, B:123:0x035a, B:124:0x035f, B:126:0x036f, B:127:0x037c, B:130:0x03a6, B:132:0x03c5, B:134:0x03cc, B:136:0x03d3, B:138:0x03da, B:140:0x03e1, B:142:0x03e8, B:147:0x03fa, B:149:0x0401, B:151:0x0408, B:153:0x040f, B:154:0x03f3, B:155:0x0376, B:156:0x0399, B:158:0x039e, B:162:0x02a8, B:164:0x02ae, B:167:0x02b6, B:169:0x02ba, B:171:0x02ce, B:173:0x02d2, B:176:0x01f5, B:178:0x0203, B:180:0x0209, B:183:0x01c2), top: B:3:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x041f A[Catch: all -> 0x0430, TRY_ENTER, TryCatch #5 {all -> 0x0430, blocks: (B:11:0x041f, B:12:0x0421, B:13:0x042e, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x002f, B:17:0x0034, B:19:0x003a, B:20:0x004d, B:22:0x005d, B:24:0x0067, B:29:0x03b1, B:30:0x006d, B:32:0x007b, B:34:0x008d, B:35:0x00ae, B:37:0x00be, B:41:0x00cc, B:46:0x00f8, B:51:0x00ea, B:67:0x01c5, B:69:0x01d9, B:71:0x01dd, B:72:0x01df, B:74:0x01e4, B:75:0x01e6, B:76:0x01eb, B:80:0x020e, B:84:0x0224, B:86:0x022a, B:88:0x0233, B:89:0x023f, B:91:0x025e, B:92:0x0271, B:94:0x0283, B:96:0x0291, B:97:0x02a2, B:98:0x02e4, B:103:0x02f1, B:107:0x02fd, B:110:0x0305, B:112:0x0313, B:114:0x0320, B:116:0x0327, B:119:0x0334, B:121:0x0340, B:123:0x035a, B:124:0x035f, B:126:0x036f, B:127:0x037c, B:130:0x03a6, B:132:0x03c5, B:134:0x03cc, B:136:0x03d3, B:138:0x03da, B:140:0x03e1, B:142:0x03e8, B:147:0x03fa, B:149:0x0401, B:151:0x0408, B:153:0x040f, B:154:0x03f3, B:155:0x0376, B:156:0x0399, B:158:0x039e, B:162:0x02a8, B:164:0x02ae, B:167:0x02b6, B:169:0x02ba, B:171:0x02ce, B:173:0x02d2, B:176:0x01f5, B:178:0x0203, B:180:0x0209, B:183:0x01c2), top: B:3:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0340 A[Catch: all -> 0x0425, TryCatch #5 {all -> 0x0430, blocks: (B:11:0x041f, B:12:0x0421, B:13:0x042e, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x002f, B:17:0x0034, B:19:0x003a, B:20:0x004d, B:22:0x005d, B:24:0x0067, B:29:0x03b1, B:30:0x006d, B:32:0x007b, B:34:0x008d, B:35:0x00ae, B:37:0x00be, B:41:0x00cc, B:46:0x00f8, B:51:0x00ea, B:67:0x01c5, B:69:0x01d9, B:71:0x01dd, B:72:0x01df, B:74:0x01e4, B:75:0x01e6, B:76:0x01eb, B:80:0x020e, B:84:0x0224, B:86:0x022a, B:88:0x0233, B:89:0x023f, B:91:0x025e, B:92:0x0271, B:94:0x0283, B:96:0x0291, B:97:0x02a2, B:98:0x02e4, B:103:0x02f1, B:107:0x02fd, B:110:0x0305, B:112:0x0313, B:114:0x0320, B:116:0x0327, B:119:0x0334, B:121:0x0340, B:123:0x035a, B:124:0x035f, B:126:0x036f, B:127:0x037c, B:130:0x03a6, B:132:0x03c5, B:134:0x03cc, B:136:0x03d3, B:138:0x03da, B:140:0x03e1, B:142:0x03e8, B:147:0x03fa, B:149:0x0401, B:151:0x0408, B:153:0x040f, B:154:0x03f3, B:155:0x0376, B:156:0x0399, B:158:0x039e, B:162:0x02a8, B:164:0x02ae, B:167:0x02b6, B:169:0x02ba, B:171:0x02ce, B:173:0x02d2, B:176:0x01f5, B:178:0x0203, B:180:0x0209, B:183:0x01c2), top: B:3:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0399 A[Catch: all -> 0x0425, TryCatch #5 {all -> 0x0430, blocks: (B:11:0x041f, B:12:0x0421, B:13:0x042e, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x002f, B:17:0x0034, B:19:0x003a, B:20:0x004d, B:22:0x005d, B:24:0x0067, B:29:0x03b1, B:30:0x006d, B:32:0x007b, B:34:0x008d, B:35:0x00ae, B:37:0x00be, B:41:0x00cc, B:46:0x00f8, B:51:0x00ea, B:67:0x01c5, B:69:0x01d9, B:71:0x01dd, B:72:0x01df, B:74:0x01e4, B:75:0x01e6, B:76:0x01eb, B:80:0x020e, B:84:0x0224, B:86:0x022a, B:88:0x0233, B:89:0x023f, B:91:0x025e, B:92:0x0271, B:94:0x0283, B:96:0x0291, B:97:0x02a2, B:98:0x02e4, B:103:0x02f1, B:107:0x02fd, B:110:0x0305, B:112:0x0313, B:114:0x0320, B:116:0x0327, B:119:0x0334, B:121:0x0340, B:123:0x035a, B:124:0x035f, B:126:0x036f, B:127:0x037c, B:130:0x03a6, B:132:0x03c5, B:134:0x03cc, B:136:0x03d3, B:138:0x03da, B:140:0x03e1, B:142:0x03e8, B:147:0x03fa, B:149:0x0401, B:151:0x0408, B:153:0x040f, B:154:0x03f3, B:155:0x0376, B:156:0x0399, B:158:0x039e, B:162:0x02a8, B:164:0x02ae, B:167:0x02b6, B:169:0x02ba, B:171:0x02ce, B:173:0x02d2, B:176:0x01f5, B:178:0x0203, B:180:0x0209, B:183:0x01c2), top: B:3:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d9 A[Catch: all -> 0x0425, TryCatch #5 {all -> 0x0430, blocks: (B:11:0x041f, B:12:0x0421, B:13:0x042e, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x002f, B:17:0x0034, B:19:0x003a, B:20:0x004d, B:22:0x005d, B:24:0x0067, B:29:0x03b1, B:30:0x006d, B:32:0x007b, B:34:0x008d, B:35:0x00ae, B:37:0x00be, B:41:0x00cc, B:46:0x00f8, B:51:0x00ea, B:67:0x01c5, B:69:0x01d9, B:71:0x01dd, B:72:0x01df, B:74:0x01e4, B:75:0x01e6, B:76:0x01eb, B:80:0x020e, B:84:0x0224, B:86:0x022a, B:88:0x0233, B:89:0x023f, B:91:0x025e, B:92:0x0271, B:94:0x0283, B:96:0x0291, B:97:0x02a2, B:98:0x02e4, B:103:0x02f1, B:107:0x02fd, B:110:0x0305, B:112:0x0313, B:114:0x0320, B:116:0x0327, B:119:0x0334, B:121:0x0340, B:123:0x035a, B:124:0x035f, B:126:0x036f, B:127:0x037c, B:130:0x03a6, B:132:0x03c5, B:134:0x03cc, B:136:0x03d3, B:138:0x03da, B:140:0x03e1, B:142:0x03e8, B:147:0x03fa, B:149:0x0401, B:151:0x0408, B:153:0x040f, B:154:0x03f3, B:155:0x0376, B:156:0x0399, B:158:0x039e, B:162:0x02a8, B:164:0x02ae, B:167:0x02b6, B:169:0x02ba, B:171:0x02ce, B:173:0x02d2, B:176:0x01f5, B:178:0x0203, B:180:0x0209, B:183:0x01c2), top: B:3:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020e A[Catch: all -> 0x0425, TryCatch #5 {all -> 0x0430, blocks: (B:11:0x041f, B:12:0x0421, B:13:0x042e, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x002f, B:17:0x0034, B:19:0x003a, B:20:0x004d, B:22:0x005d, B:24:0x0067, B:29:0x03b1, B:30:0x006d, B:32:0x007b, B:34:0x008d, B:35:0x00ae, B:37:0x00be, B:41:0x00cc, B:46:0x00f8, B:51:0x00ea, B:67:0x01c5, B:69:0x01d9, B:71:0x01dd, B:72:0x01df, B:74:0x01e4, B:75:0x01e6, B:76:0x01eb, B:80:0x020e, B:84:0x0224, B:86:0x022a, B:88:0x0233, B:89:0x023f, B:91:0x025e, B:92:0x0271, B:94:0x0283, B:96:0x0291, B:97:0x02a2, B:98:0x02e4, B:103:0x02f1, B:107:0x02fd, B:110:0x0305, B:112:0x0313, B:114:0x0320, B:116:0x0327, B:119:0x0334, B:121:0x0340, B:123:0x035a, B:124:0x035f, B:126:0x036f, B:127:0x037c, B:130:0x03a6, B:132:0x03c5, B:134:0x03cc, B:136:0x03d3, B:138:0x03da, B:140:0x03e1, B:142:0x03e8, B:147:0x03fa, B:149:0x0401, B:151:0x0408, B:153:0x040f, B:154:0x03f3, B:155:0x0376, B:156:0x0399, B:158:0x039e, B:162:0x02a8, B:164:0x02ae, B:167:0x02b6, B:169:0x02ba, B:171:0x02ce, B:173:0x02d2, B:176:0x01f5, B:178:0x0203, B:180:0x0209, B:183:0x01c2), top: B:3:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0224 A[Catch: all -> 0x0425, TryCatch #5 {all -> 0x0430, blocks: (B:11:0x041f, B:12:0x0421, B:13:0x042e, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x002f, B:17:0x0034, B:19:0x003a, B:20:0x004d, B:22:0x005d, B:24:0x0067, B:29:0x03b1, B:30:0x006d, B:32:0x007b, B:34:0x008d, B:35:0x00ae, B:37:0x00be, B:41:0x00cc, B:46:0x00f8, B:51:0x00ea, B:67:0x01c5, B:69:0x01d9, B:71:0x01dd, B:72:0x01df, B:74:0x01e4, B:75:0x01e6, B:76:0x01eb, B:80:0x020e, B:84:0x0224, B:86:0x022a, B:88:0x0233, B:89:0x023f, B:91:0x025e, B:92:0x0271, B:94:0x0283, B:96:0x0291, B:97:0x02a2, B:98:0x02e4, B:103:0x02f1, B:107:0x02fd, B:110:0x0305, B:112:0x0313, B:114:0x0320, B:116:0x0327, B:119:0x0334, B:121:0x0340, B:123:0x035a, B:124:0x035f, B:126:0x036f, B:127:0x037c, B:130:0x03a6, B:132:0x03c5, B:134:0x03cc, B:136:0x03d3, B:138:0x03da, B:140:0x03e1, B:142:0x03e8, B:147:0x03fa, B:149:0x0401, B:151:0x0408, B:153:0x040f, B:154:0x03f3, B:155:0x0376, B:156:0x0399, B:158:0x039e, B:162:0x02a8, B:164:0x02ae, B:167:0x02b6, B:169:0x02ba, B:171:0x02ce, B:173:0x02d2, B:176:0x01f5, B:178:0x0203, B:180:0x0209, B:183:0x01c2), top: B:3:0x000a }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1664a(String str, boolean z, boolean z2) {
        String str2;
        String str3;
        int i;
        boolean z3;
        boolean z4;
        int i2;
        String path;
        String m1639b;
        File m1719a;
        int i3;
        String str4;
        String str5;
        int i4;
        File file;
        boolean z5;
        C1491a.m1925a("crashsdk", "crashsdk uploading logs");
        synchronized (f2791n) {
            try {
            } catch (Throwable th) {
                throw th;
            }
            if (C1497g.m1863b(str)) {
                String m1515V = C1509g.m1515V();
                File file2 = new File(m1515V);
                if (!file2.exists()) {
                    str2 = "Folder not exist: " + m1515V;
                    str3 = "crashsdk";
                } else {
                    File[] listFiles = file2.listFiles();
                    if (listFiles == null) {
                        C1491a.m1923b("List folder failed: " + m1515V);
                    } else {
                        int length = listFiles.length;
                        int i5 = 0;
                        int i6 = 0;
                        int i7 = 0;
                        int i8 = 0;
                        int i9 = 0;
                        int i10 = 0;
                        int i11 = 0;
                        int i12 = 0;
                        int i13 = 0;
                        boolean z6 = false;
                        boolean z7 = false;
                        boolean z8 = false;
                        while (true) {
                            if (i5 >= length) {
                                i = i8;
                                z3 = z6;
                                z4 = z7;
                                break;
                            }
                            File file3 = listFiles[i5];
                            File[] fileArr = listFiles;
                            if (!file3.isFile()) {
                                C1497g.m1878a(file3);
                            } else {
                                String name = file3.getName();
                                if (!name.endsWith(".tmp")) {
                                    i2 = length;
                                    z3 = z6;
                                    z4 = z7;
                                    if (file3.length() == 0) {
                                        i6++;
                                        C1497g.m1878a(file3);
                                    } else {
                                        if (z) {
                                            long currentTimeMillis = (System.currentTimeMillis() - file3.lastModified()) / 1000;
                                            if (currentTimeMillis < 0 || (currentTimeMillis >= 2 && (currentTimeMillis >= 5 || !file3.getName().endsWith(".log")))) {
                                                z5 = true;
                                                C1491a.m1926a(String.format(Locale.US, "file: %s, modify interval: %d s, safe upload: %s", file3.getName(), Long.valueOf(currentTimeMillis), Boolean.valueOf(z5)));
                                                if (!z5) {
                                                    i8++;
                                                }
                                            }
                                            z5 = false;
                                            C1491a.m1926a(String.format(Locale.US, "file: %s, modify interval: %d s, safe upload: %s", file3.getName(), Long.valueOf(currentTimeMillis), Boolean.valueOf(z5)));
                                            if (!z5) {
                                            }
                                        }
                                        try {
                                        } catch (Throwable th2) {
                                            th = th2;
                                            i = i8;
                                        }
                                        if (C1509g.m1488k()) {
                                            Matcher matcher = Pattern.compile("([^_]+)_([^_]+)_([^_]+)\\.crashsdk").matcher(file3.getName());
                                            if (matcher.matches()) {
                                                i = i8;
                                                try {
                                                    file = new File(C1509g.m1515V() + String.format(Locale.US, "%s%s_%s_%s.%s", m1603j(matcher.group(2)), m1596n(), m1695Q(), matcher.group(1), matcher.group(3)));
                                                    C1491a.m1925a("crashsdk", "File " + file3.getPath() + " matches, rename to " + file.getPath());
                                                    file3.renameTo(file);
                                                    if (file != file3) {
                                                        i12++;
                                                    }
                                                    file3 = file;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    C1497g.m1868a(th);
                                                    path = file3.getPath();
                                                    boolean[] m1595n = m1595n(path);
                                                    m1639b = m1639b(path, m1595n[0], m1595n[1]);
                                                    if (path != m1639b) {
                                                    }
                                                    m1719a = C1502d.m1719a(file3);
                                                    if (m1719a == null) {
                                                    }
                                                    if (m1719a == null) {
                                                    }
                                                    z7 = z4;
                                                    i5++;
                                                    listFiles = fileArr;
                                                    length = i2;
                                                    z6 = z3;
                                                    i8 = i;
                                                }
                                                path = file3.getPath();
                                                boolean[] m1595n2 = m1595n(path);
                                                m1639b = m1639b(path, m1595n2[0], m1595n2[1]);
                                                if (path != m1639b) {
                                                    if (m1595n2[0]) {
                                                        i11++;
                                                    }
                                                    if (m1595n2[1]) {
                                                        i9++;
                                                    }
                                                    file3 = new File(m1639b);
                                                }
                                                m1719a = C1502d.m1719a(file3);
                                                if (m1719a == null) {
                                                    m1719a = null;
                                                } else if (file3 != m1719a && !file3.getName().equals(m1719a.getName()) && file3.exists()) {
                                                    file3.delete();
                                                }
                                                if (m1719a == null) {
                                                    C1491a.m1923b("onBeforeUploadLog return null, skip upload: " + file3.getAbsolutePath());
                                                } else {
                                                    int m1473z = C1509g.m1473z();
                                                    if (m1473z <= 0 || m1719a.length() < m1473z) {
                                                        C1507d c1507d = new C1507d((byte) 0);
                                                        c1507d.f2811b = 0L;
                                                        c1507d.f2810a = System.currentTimeMillis();
                                                        String m1691U = m1691U();
                                                        if (new File(m1691U).exists()) {
                                                            m1668a(m1691U, new RunnableC1495e(TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, new Object[]{m1691U, c1507d}));
                                                        }
                                                        long m1536A = C1509g.m1536A();
                                                        int m1535B = C1509g.m1535B();
                                                        int m1534C = C1509g.m1534C();
                                                        if (m1536A >= 0) {
                                                            i3 = i9;
                                                            if (c1507d.f2811b + m1719a.length() > m1536A) {
                                                                c1507d.f2814e = true;
                                                                str4 = "Reach max upload bytes: " + m1536A;
                                                                C1491a.m1923b(str4);
                                                                if (!c1507d.f2814e) {
                                                                    z3 = true;
                                                                } else if (c1507d.f2816g) {
                                                                    z7 = true;
                                                                    i9 = i3;
                                                                    i5++;
                                                                    listFiles = fileArr;
                                                                    length = i2;
                                                                    z6 = z3;
                                                                    i8 = i;
                                                                } else if (c1507d.f2815f) {
                                                                    z8 = true;
                                                                } else {
                                                                    String name2 = m1719a.getName();
                                                                    if (name2.startsWith(m1696P())) {
                                                                        String[] split = name2.split("_", 10);
                                                                        if (split.length == 9) {
                                                                            str5 = split[1];
                                                                            boolean z9 = str5 == null && str5.equals(C1509g.m1519R());
                                                                            if (!C1493c.m1912a(m1719a, m1719a.getName(), str)) {
                                                                                C1491a.m1924a("crashsdk", "Uploaded log: " + m1719a.getName(), null);
                                                                                if (z9) {
                                                                                    C1508f.m1564a(13);
                                                                                }
                                                                                c1507d.f2811b += m1719a.length();
                                                                                if (m1646b(m1719a)) {
                                                                                    c1507d.f2812c++;
                                                                                } else {
                                                                                    c1507d.f2813d++;
                                                                                }
                                                                                String m1691U2 = m1691U();
                                                                                m1668a(m1691U2, new RunnableC1495e(TinkerReport.KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK, new Object[]{m1691U2, c1507d}));
                                                                                m1719a.delete();
                                                                                i4 = 3;
                                                                                i13 = 0;
                                                                            } else {
                                                                                i13++;
                                                                                if (z9) {
                                                                                    C1508f.m1564a(14);
                                                                                }
                                                                                i4 = 3;
                                                                            }
                                                                            if (i13 >= i4) {
                                                                                C1491a.m1924a("crashsdk", "Upload failed 3 times continuously, abort upload!", null);
                                                                                i9 = i3;
                                                                                break;
                                                                            }
                                                                            i9 = i3;
                                                                            z7 = z4;
                                                                            i5++;
                                                                            listFiles = fileArr;
                                                                            length = i2;
                                                                            z6 = z3;
                                                                            i8 = i;
                                                                        }
                                                                    }
                                                                    str5 = null;
                                                                    if (str5 == null) {
                                                                    }
                                                                    if (!C1493c.m1912a(m1719a, m1719a.getName(), str)) {
                                                                    }
                                                                    if (i13 >= i4) {
                                                                    }
                                                                    i9 = i3;
                                                                    z7 = z4;
                                                                    i5++;
                                                                    listFiles = fileArr;
                                                                    length = i2;
                                                                    z6 = z3;
                                                                    i8 = i;
                                                                }
                                                                i9 = i3;
                                                                z7 = z4;
                                                                i5++;
                                                                listFiles = fileArr;
                                                                length = i2;
                                                                z6 = z3;
                                                                i8 = i;
                                                            }
                                                        } else {
                                                            i3 = i9;
                                                        }
                                                        if (!C1509g.m1493f()) {
                                                            if (m1646b(m1719a)) {
                                                                if (m1535B >= 0 && c1507d.f2812c >= m1535B) {
                                                                    c1507d.f2816g = true;
                                                                    str4 = "Reach max upload builtin log count: " + m1535B;
                                                                    C1491a.m1923b(str4);
                                                                }
                                                            } else if (m1534C >= 0 && c1507d.f2813d >= m1534C) {
                                                                c1507d.f2815f = true;
                                                                str4 = "Reach max upload custom log count: " + m1534C;
                                                                C1491a.m1923b(str4);
                                                            }
                                                            throw th;
                                                        }
                                                        if (!c1507d.f2814e) {
                                                        }
                                                        i9 = i3;
                                                        z7 = z4;
                                                        i5++;
                                                        listFiles = fileArr;
                                                        length = i2;
                                                        z6 = z3;
                                                        i8 = i;
                                                    } else {
                                                        i10++;
                                                        C1497g.m1878a(m1719a);
                                                    }
                                                }
                                                z7 = z4;
                                                i5++;
                                                listFiles = fileArr;
                                                length = i2;
                                                z6 = z3;
                                                i8 = i;
                                            }
                                        }
                                        i = i8;
                                        file = file3;
                                        if (file != file3) {
                                        }
                                        file3 = file;
                                        path = file3.getPath();
                                        boolean[] m1595n22 = m1595n(path);
                                        m1639b = m1639b(path, m1595n22[0], m1595n22[1]);
                                        if (path != m1639b) {
                                        }
                                        m1719a = C1502d.m1719a(file3);
                                        if (m1719a == null) {
                                        }
                                        if (m1719a == null) {
                                        }
                                        z7 = z4;
                                        i5++;
                                        listFiles = fileArr;
                                        length = i2;
                                        z6 = z3;
                                        i8 = i;
                                    }
                                    i = i8;
                                    z7 = z4;
                                    i5++;
                                    listFiles = fileArr;
                                    length = i2;
                                    z6 = z3;
                                    i8 = i;
                                } else if ((System.currentTimeMillis() - file3.lastModified()) / 1000 > 30) {
                                    i2 = length;
                                    C1491a.m1923b("delete legacy tmp file: " + name);
                                    i7++;
                                    C1497g.m1878a(file3);
                                    i = i8;
                                    z3 = z6;
                                    i5++;
                                    listFiles = fileArr;
                                    length = i2;
                                    z6 = z3;
                                    i8 = i;
                                }
                            }
                            i2 = length;
                            i = i8;
                            z3 = z6;
                            i5++;
                            listFiles = fileArr;
                            length = i2;
                            z6 = z3;
                            i8 = i;
                        }
                        if (i7 > 0) {
                            C1508f.m1563a(200, i7);
                        }
                        if (i6 > 0) {
                            C1508f.m1563a(15, i6);
                        }
                        if (i10 > 0) {
                            C1508f.m1563a(17, i10);
                        }
                        if (z3) {
                            C1508f.m1564a(19);
                        }
                        if (z4) {
                            C1508f.m1564a(20);
                        }
                        if (z8) {
                            C1508f.m1564a(21);
                        }
                        if (z3 || z4 || z8) {
                            C1508f.m1564a(18);
                        }
                        if (i11 > 0) {
                            C1508f.m1563a(24, i11);
                        }
                        if (i9 > 0) {
                            C1508f.m1563a(201, i9);
                        }
                        if (i12 > 0) {
                            C1508f.m1563a(25, i12);
                        }
                        if (i > 0) {
                            C1508f.m1563a(26, i);
                        }
                    }
                    if (z2) {
                        f2792o.open();
                    }
                }
            } else {
                str2 = "upload url is empty!";
                str3 = "crashsdk";
            }
            C1491a.m1925a(str3, str2);
            if (z2) {
            }
        }
    }

    /* renamed from: a */
    public static void m1661a(Throwable th) {
        try {
            C1491a.m1920d("DEBUG", m1654a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m1660a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                C1497g.m1868a(th2);
            }
        }
        C1497g.m1868a(th);
    }

    /* renamed from: a */
    public static void m1658a(Calendar calendar) {
        if (!C1509g.m1520Q()) {
            return;
        }
        long timeInMillis = calendar.getTimeInMillis();
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        long timeInMillis2 = calendar.getTimeInMillis();
        long j = timeInMillis2 - timeInMillis;
        long j2 = DateUtils.MILLIS_PER_HOUR;
        if (j <= DateUtils.MILLIS_PER_HOUR) {
            j2 = 1000 + j;
        }
        C1496f.m1888a(0, new RunnableC1495e(415, new Object[]{Long.valueOf(timeInMillis2)}), j2);
    }

    /* renamed from: a */
    public static void m1656a(boolean z) {
        File[] listFiles;
        try {
            if (!C1500b.m1725y() || (listFiles = new File(C1509g.m1515V()).listFiles()) == null) {
                return;
            }
            int m1487l = C1509g.m1487l();
            int m1486m = C1509g.m1486m();
            if (listFiles.length < Math.min(m1487l, m1486m)) {
                return;
            }
            int i = 0;
            int i2 = 0;
            for (File file : listFiles) {
                if (m1646b(file)) {
                    i++;
                } else {
                    i2++;
                }
            }
            int i3 = (!z || i < m1487l) ? 0 : (i - m1487l) + 1;
            int i4 = (z || i2 < m1486m) ? 0 : (i2 - m1486m) + 1;
            if (i3 == 0 && i4 == 0) {
                return;
            }
            Arrays.sort(listFiles, new C1505b((byte) 0));
            int i5 = i3;
            int i6 = i4;
            for (File file2 : listFiles) {
                boolean m1646b = m1646b(file2);
                if (m1646b && i5 > 0) {
                    C1491a.m1925a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                    file2.delete();
                    i5 += -1;
                } else if (!m1646b && i6 > 0) {
                    C1491a.m1925a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                    file2.delete();
                    i6 += -1;
                }
                if (i5 == 0 && i6 == 0) {
                    break;
                }
            }
            C1508f.m1563a(16, i3 + i4);
            if (i3 > 0) {
                C1508f.m1563a(22, i3);
            }
            if (i4 <= 0) {
                return;
            }
            C1508f.m1563a(23, i4);
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
    }

    /* renamed from: a */
    public static boolean m1685a() {
        if (f2783f == 0) {
            f2783f = 2L;
            if (m1608h(C1500b.m1754b("logs")) == 1) {
                f2783f = 1L;
            }
        }
        return f2783f == 1;
    }

    /* renamed from: a */
    public static boolean m1681a(ParcelFileDescriptor parcelFileDescriptor) {
        String str;
        if (f2778af) {
            str = "Can not call setHostFd and getHostFd in the same process!";
        } else if (C1500b.f2714d) {
            if (f2777ae != null) {
                C1491a.m1921c("crashsdk", "Has already set host fd!");
            }
            f2777ae = parcelFileDescriptor;
            int fd = parcelFileDescriptor.getFd();
            int nativeCmd = (int) JNIBridge.nativeCmd(13, fd, null, null);
            f2779ag = nativeCmd != -1;
            return fd == -1 || nativeCmd != -1;
        } else {
            str = "Crash so is not loaded!";
        }
        C1491a.m1920d("crashsdk", str);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m1669a(String str, long j, StringBuffer stringBuffer, String str2, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str3) {
        FileOutputStream fileOutputStream;
        C1504a c1504a;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                c1504a = null;
                C1497g.m1868a(th);
                if (c1504a == null) {
                }
            }
        } else {
            fileOutputStream = null;
        }
        try {
            c1504a = new C1504a(j, fileOutputStream);
            try {
                synchronized (f2796s) {
                    f2798u = str;
                    if (C1500b.f2714d) {
                        JNIBridge.set(126, f2798u);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                C1497g.m1868a(th);
                if (c1504a == null) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            c1504a = null;
        }
        if (c1504a == null) {
            return false;
        }
        if ((j2 & 1) != 0) {
            try {
                m1643b(c1504a, str, str2);
            } catch (Throwable th4) {
                try {
                    m1660a(th4, c1504a);
                } finally {
                    C1497g.m1879a(c1504a);
                    C1497g.m1879a(fileOutputStream);
                }
            }
        }
        c1504a.write(stringBuffer.toString().getBytes());
        c1504a.write("\n".getBytes("UTF-8"));
        c1504a.flush();
        m1675a((OutputStream) c1504a);
        if ((j2 & 4) != 0) {
            m1645b((OutputStream) c1504a);
            c1504a.flush();
        }
        if (arrayList != null && arrayList.size() > 0) {
            C1490a.m1956a(c1504a, "UTF-8", arrayList);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            C1490a.m1957a(c1504a, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList2);
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            C1490a.m1945b(c1504a, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList3);
        }
        if (str3 != null) {
            c1504a.flush();
            c1504a.write("threads dump:\n".getBytes("UTF-8"));
            f2785h = false;
            f2800w = str3;
            m1678a(c1504a, str3, j);
            f2800w = null;
            f2785h = true;
        }
        if ((j2 & 8) != 0 && i == 0) {
            c1504a.flush();
            c1504a.write("all threads dump:\n".getBytes("UTF-8"));
            f2799v = true;
            m1678a(c1504a, "all", 0L);
            f2799v = false;
        }
        if ((j2 & 16) != 0) {
            m1618f(c1504a);
        }
        if ((j2 & 2) != 0) {
            c1504a.m1577a();
            m1679a(c1504a);
        }
        if (i != 0) {
            m1647b(c1504a);
        }
        try {
            synchronized (f2796s) {
                f2797t++;
                if (f2798u != null) {
                    f2796s.add(f2798u);
                    if (f2796s.size() > 3) {
                        f2796s.remove(0);
                    }
                    if (C1500b.f2714d) {
                        JNIBridge.set(127, f2798u);
                    }
                    f2798u = null;
                }
                if (C1500b.f2714d) {
                    JNIBridge.set(25, f2797t);
                }
            }
        } catch (Throwable th5) {
            C1497g.m1868a(th5);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* renamed from: a */
    public static boolean m1668a(String str, RunnableC1495e runnableC1495e) {
        boolean z;
        FileChannel fileChannel;
        Exception e;
        synchronized (f2793p) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    C1497g.m1868a(e2);
                }
            }
            ?? r5 = 0;
            r5 = null;
            FileLock lock = null;
            z = false;
            try {
                try {
                    try {
                        fileChannel = new RandomAccessFile(file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        r5 = file;
                        C1497g.m1879a((Closeable) r5);
                        throw th;
                    }
                } catch (Exception e3) {
                    try {
                        C1497g.m1868a(e3);
                        fileChannel = null;
                    } catch (Exception e4) {
                        fileChannel = null;
                        e = e4;
                        C1497g.m1868a(e);
                        C1497g.m1879a(fileChannel);
                        return z;
                    }
                }
                if (fileChannel != null) {
                    try {
                        lock = fileChannel.lock();
                    } catch (Exception e5) {
                        try {
                            C1497g.m1868a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            C1497g.m1868a(e);
                            C1497g.m1879a(fileChannel);
                            return z;
                        }
                    }
                }
                try {
                    z = runnableC1495e.m1892a();
                    C1497g.m1879a(fileChannel);
                } finally {
                    if (lock != null) {
                        try {
                            lock.release();
                        } catch (Exception e7) {
                            C1497g.m1868a(e7);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m1667a(String str, C1507d c1507d) {
        String m1876a = C1497g.m1876a(new File(str), 64, false);
        if (m1876a == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(m1876a);
            if (matcher.find()) {
                long parseLong = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - parseLong < 86400000) {
                    c1507d.f2811b = Long.parseLong(matcher.group(2));
                    c1507d.f2812c = Integer.parseInt(matcher.group(3));
                    c1507d.f2813d = Integer.parseInt(matcher.group(4));
                    c1507d.f2810a = parseLong;
                }
            }
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m1665a(String str, String str2, boolean z) {
        if (m1593o(str2)) {
            C1498h.m1835a(str, str2, true, z);
            C1491a.m1923b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1663a(StringBuffer stringBuffer, String str, long j, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j2;
        boolean z;
        boolean m1669a;
        long j3;
        if (f2781c.get()) {
            C1491a.m1923b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z2 = f2779ag || C1500b.m1785L();
        if (!z2 && !C1494d.m1895e()) {
            C1491a.m1921c("DEBUG", C1494d.m1898b());
            return false;
        } else if (!m1627d(str)) {
            C1491a.m1920d("DEBUG", "custom log sample miss: " + str);
            return false;
        } else if (m1653aa()) {
            C1491a.m1923b("Processing native crash, skip generate custom log: " + str);
            return false;
        } else if (stringBuffer == null || str == null) {
            return false;
        } else {
            String str3 = C1509g.m1515V() + m1601k(str);
            boolean z3 = (j & 32) != 0;
            if (z2) {
                if (C1500b.f2714d) {
                    int i = z3 ? 1 : 0;
                    int i2 = z3 ? 1 : 0;
                    j3 = JNIBridge.nativeClientCreateConnection(str3, "custom", str, i);
                } else {
                    j3 = 0;
                }
                if (j3 == 0) {
                    C1491a.m1920d("DEBUG", "skip custom log: " + str);
                    return false;
                }
                j2 = j3;
            } else if (m1665a(m1610h(), str, z3)) {
                return false;
            } else {
                C1509g.m1510a();
                m1656a(false);
                j2 = 0;
            }
            synchronized (f2794q) {
                long j4 = j2;
                boolean z4 = z3 ? 1 : 0;
                Object[] objArr = z3 ? 1 : 0;
                z = z4;
                m1669a = m1669a(str3, j4, stringBuffer, str, j, arrayList, arrayList2, arrayList3, str2);
            }
            if (m1669a && !z2) {
                m1640b(m1610h(), str, z);
            }
            if (j2 != 0) {
                JNIBridge.nativeClientCloseConnection(j2);
            }
            if (!m1669a) {
                return false;
            }
            if (!z2) {
                m1587r(str3);
            }
            if (!z2) {
                str3 = m1670a(m1597m(str3));
            }
            m1641b(str3, str);
            if (!z || z2) {
                return true;
            }
            try {
                m1655a(true, false);
                return true;
            } catch (Throwable th) {
                C1497g.m1868a(th);
                return true;
            }
        }
    }

    /* renamed from: a */
    public static boolean m1655a(boolean z, boolean z2) {
        if (!f2782d) {
            if (C1500b.f2714d) {
                JNIBridge.set(1, true);
            }
            f2782d = true;
        }
        try {
            String m1602k = m1602k();
            if (C1497g.m1872a(m1602k)) {
                C1491a.m1925a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            if (C1496f.m1889a(z ? 1 : 0, new RunnableC1495e(406, new Object[]{m1602k, Boolean.valueOf(z2), Boolean.valueOf(z)})) && z) {
                f2792o.close();
                if (!f2792o.block(3000L)) {
                    C1491a.m1925a("crashsdk", "timeout to wait for uploading");
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return false;
        }
    }

    /* renamed from: aa */
    public static boolean m1653aa() {
        return C1500b.f2714d && JNIBridge.nativeIsCrashing();
    }

    /* renamed from: ab */
    public static void m1652ab() {
        String m1514W = C1509g.m1514W();
        File file = new File(m1514W);
        if (!file.isDirectory()) {
            return;
        }
        try {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 150) {
                return;
            }
            Arrays.sort(listFiles, new C1505b((byte) 0));
            int length = listFiles.length - 150;
            int i = length < 0 ? 0 : length;
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            int i3 = 0;
            while (i2 < listFiles.length) {
                File file2 = listFiles[i2];
                boolean z = i2 < i;
                if (!z && currentTimeMillis - file2.lastModified() >= 432000000) {
                    z = true;
                }
                if (!z) {
                    break;
                }
                file2.delete();
                i3++;
                if (0 >= 3) {
                    break;
                }
                i2++;
            }
            C1491a.m1926a("Removed " + i3 + " logs in " + m1514W);
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
    }

    /* renamed from: b */
    public static int m1644b(OutputStream outputStream, String str, int i) {
        int i2;
        DataInputStream dataInputStream;
        int i3;
        DataInputStream dataInputStream2 = null;
        int i4 = 0;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] m1694R = m1694R();
                if (m1694R == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    return 0;
                }
                dataInputStream = new DataInputStream(new FileInputStream(file));
                i3 = 0;
                i2 = 0;
                loop0: while (true) {
                    boolean z = false;
                    while (true) {
                        try {
                            int read = dataInputStream.read(m1694R);
                            if (read == -1) {
                                break loop0;
                            }
                            i3 += read;
                            int i5 = i - i2;
                            if (read <= i5 + 32) {
                                i5 = read;
                            }
                            if (i5 > 0 && !z) {
                                outputStream.write(m1694R, 0, i5);
                                i2 += i5;
                            }
                            if (!z) {
                                if (i5 < read || i2 >= i) {
                                    z = true;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            i4 = i2;
                            dataInputStream2 = dataInputStream;
                            try {
                                m1660a(th, outputStream);
                                C1497g.m1879a(dataInputStream2);
                                i2 = i4;
                                m1675a(outputStream);
                                return i2;
                            } finally {
                                C1497g.m1879a(dataInputStream2);
                            }
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream = null;
                i3 = 0;
                i2 = 0;
            }
            if (i2 > 0) {
                outputStream.write("\n".getBytes("UTF-8"));
            }
            if (i2 < i3) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i3 - i2)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        m1675a(outputStream);
        return i2;
    }

    /* renamed from: b */
    public static long m1651b() {
        if (f2784g == -1) {
            f2784g = m1608h(C1500b.m1754b("local"));
        }
        return f2784g;
    }

    /* renamed from: b */
    public static String m1639b(String str, boolean z, boolean z2) {
        if (z) {
            try {
                str = m1597m(str);
            } catch (Throwable th) {
                C1497g.m1868a(th);
            }
        }
        if (z2) {
            try {
                return m1670a(str);
            } catch (Throwable th2) {
                C1497g.m1868a(th2);
                return str;
            }
        }
        return str;
    }

    /* renamed from: b */
    public static void m1650b(int i) {
        C1496f.m1888a(0, new RunnableC1495e(410), i * 1000);
    }

    /* renamed from: b */
    public static void m1648b(Context context) {
        if (!C1509g.m1526K()) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.intent.action.BATTERY_LOW");
            intentFilter.addAction("android.intent.action.BATTERY_OKAY");
            context.registerReceiver(f2762Q, intentFilter, null, C1496f.m1890a(1));
            f2763R = true;
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
    }

    /* renamed from: b */
    public static void m1647b(C1504a c1504a) {
        f2785h = false;
        try {
            c1504a.write((m1585s("LOG_END") + "\n").getBytes("UTF-8"));
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        f2785h = true;
    }

    /* renamed from: b */
    public static void m1645b(OutputStream outputStream) {
        BufferedReader bufferedReader = null;
        try {
            outputStream.write("logcat:\n".getBytes("UTF-8"));
        } finally {
            try {
                C1497g.m1879a(bufferedReader);
                m1675a(outputStream);
            } finally {
            }
        }
        if (C1509g.m1485n() <= 0) {
            outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
            m1675a(outputStream);
            return;
        }
        int m1485n = C1509g.m1485n();
        bufferedReader = m1676a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", C1615d.f3327ar, "-b", "main", "-v", "threadtime", "-t", String.valueOf(m1485n)}).getInputStream()));
        if (bufferedReader == null) {
            outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
            m1675a(outputStream);
            return;
        }
        f2785h = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            i++;
            if (i2 < m1485n && !readLine.contains(" I auditd ") && !readLine.contains(" I liblog ")) {
                outputStream.write(readLine.getBytes("UTF-8"));
                outputStream.write("\n".getBytes("UTF-8"));
                i2++;
            }
        }
        outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i), Integer.valueOf(i2)).getBytes("UTF-8"));
        f2785h = true;
        C1497g.m1879a(bufferedReader);
        m1675a(outputStream);
    }

    /* renamed from: b */
    public static void m1643b(OutputStream outputStream, String str, String str2) {
        String str3;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            m1660a(th, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), m1596n()).getBytes("UTF-8"));
            Locale locale = Locale.US;
            Object[] objArr = new Object[3];
            objArr[0] = m1625e();
            if (C1497g.m1872a(f2789l)) {
                m1692T();
            }
            objArr[1] = f2789l;
            objArr[2] = m1620f();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (Throwable th2) {
            m1660a(th2, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            Locale locale2 = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = m1657a(new Date(f2780b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = C1497g.m1858d();
            objArr2[3] = C1500b.m1795B() ? "fg" : "bg";
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes("UTF-8"));
        } catch (Throwable th3) {
            m1660a(th3, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", C1509g.m1519R(), C1509g.m1518S(), C1509g.m1517T(), Integer.valueOf(C1490a.m1941c())).getBytes("UTF-8"));
            String str4 = "0";
            String str5 = "";
            if (C1500b.f2714d) {
                String nativeGet = JNIBridge.nativeGet(1, 0L, null);
                str3 = JNIBridge.nativeGet(2, 0L, null);
                str4 = nativeGet;
            } else {
                str3 = str5;
            }
            outputStream.write(String.format(Locale.US, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.3.1.1", str4, "210916105822", str3, "release").getBytes("UTF-8"));
            if (str != null) {
                str5 = str;
            }
            outputStream.write(("Report Name: " + str5.substring(str5.lastIndexOf(47) + 1) + "\n").getBytes("UTF-8"));
        } catch (Throwable th4) {
            m1660a(th4, outputStream);
        }
        try {
            outputStream.write(String.format("UUID: %s\n", f2779ag ? m1585s("UUID") : f2747B).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + "\n").getBytes("UTF-8"));
        } catch (Throwable th5) {
            m1660a(th5, outputStream);
        }
        try {
            String m1792E = C1500b.m1792E();
            if (C1497g.m1872a(m1792E)) {
                m1792E = "(none)";
            }
            outputStream.write(("Activity: " + m1792E + "\n").getBytes("UTF-8"));
        } catch (Throwable th6) {
            m1660a(th6, outputStream);
        }
        m1675a(outputStream);
        try {
            C1490a.m1959a(outputStream, "UTF-8");
            if (f2779ag) {
                f2785h = false;
                outputStream.write(m1585s("HEADER").getBytes("UTF-8"));
                f2785h = true;
            }
        } catch (Throwable th7) {
            m1660a(th7, outputStream);
        }
        m1675a(outputStream);
    }

    /* renamed from: b */
    public static void m1642b(String str) {
        synchronized (f2802y) {
            f2801x = str;
            C1492b.m1918a(C1500b.m1741i(), str + "\n");
        }
    }

    /* renamed from: b */
    public static void m1641b(String str, String str2) {
        try {
            C1502d.m1717a(str, m1610h(), str2);
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
    }

    /* renamed from: b */
    public static void m1640b(String str, String str2, boolean z) {
        C1498h.m1835a(str, str2, false, z);
    }

    /* renamed from: b */
    public static void m1638b(boolean z) {
        try {
            boolean z2 = C1509g.m1481r() && C1500b.m1791F() && !f2782d;
            if (!z2) {
                z2 = C1509g.m1480s();
            }
            if (!z2) {
                return;
            }
            if (!z) {
                m1655a(true, false);
                return;
            }
            String m1602k = m1602k();
            if (C1497g.m1872a(m1602k)) {
                return;
            }
            m1604j();
            m1664a(m1602k, false, false);
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
    }

    /* renamed from: b */
    public static boolean m1649b(int i, Object[] objArr) {
        if (i == 451) {
            if (!f2772a && objArr == null) {
                throw new AssertionError();
            }
            return m1667a((String) objArr[0], (C1507d) objArr[1]);
        } else if (i != 452) {
            if (!f2772a) {
                throw new AssertionError();
            }
            return false;
        } else if (!f2772a && objArr == null) {
            throw new AssertionError();
        } else {
            C1507d c1507d = (C1507d) objArr[1];
            return C1497g.m1873a(new File((String) objArr[0]), String.format(Locale.US, "%d %d %d %d", Long.valueOf(c1507d.f2810a), Long.valueOf(c1507d.f2811b), Integer.valueOf(c1507d.f2812c), Integer.valueOf(c1507d.f2813d)).getBytes());
        }
    }

    /* renamed from: b */
    public static boolean m1646b(File file) {
        int indexOf;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(95);
        if (lastIndexOf > 0 && (indexOf = name.indexOf(46, lastIndexOf)) > 0) {
            String substring = name.substring(lastIndexOf + 1, indexOf);
            return LogType.JAVA_TYPE.equals(substring) || "ucebujava".equals(substring) || LogType.NATIVE_TYPE.equals(substring) || "ucebujni".equals(substring) || LogType.UNEXP_TYPE.equals(substring) || LogType.ANR_TYPE.equals(substring);
        }
        return false;
    }

    /* renamed from: c */
    public static void m1637c() {
        f2786i = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:22:0x004d, B:24:0x0065, B:26:0x006b, B:28:0x006e, B:30:0x0076), top: B:21:0x004d }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1634c(OutputStream outputStream) {
        HashSet hashSet;
        Throwable th;
        File file;
        File[] listFiles;
        try {
            outputStream.write("disk info:\n".getBytes("UTF-8"));
        } catch (Throwable th2) {
            m1660a(th2, outputStream);
        }
        if (f2779ag) {
            f2785h = false;
            try {
                outputStream.write(m1585s("FSSTAT").getBytes("UTF-8"));
            } catch (Throwable th3) {
                m1660a(th3, outputStream);
            }
            f2785h = true;
        } else {
            try {
                hashSet = new HashSet();
                try {
                    m1671a(outputStream, m1677a(new File(C1497g.m1865b())), hashSet);
                } catch (Throwable th4) {
                    th = th4;
                    m1660a(th, outputStream);
                    m1671a(outputStream, m1677a(Environment.getExternalStorageDirectory()), hashSet);
                    file = new File("/storage");
                    if (file.exists()) {
                        while (r2 < r3) {
                        }
                    }
                    m1675a(outputStream);
                }
            } catch (Throwable th5) {
                hashSet = null;
                th = th5;
            }
            try {
                m1671a(outputStream, m1677a(Environment.getExternalStorageDirectory()), hashSet);
                file = new File("/storage");
                if (file.exists() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            m1671a(outputStream, m1677a(file2), hashSet);
                        }
                    }
                }
            } catch (Throwable th6) {
                m1660a(th6, outputStream);
            }
        }
        m1675a(outputStream);
    }

    /* renamed from: c */
    public static void m1633c(String str) {
        synchronized (f2803z) {
            String m1738l = C1500b.m1738l();
            C1492b.m1918a(m1738l, str + "\n");
        }
    }

    /* renamed from: c */
    public static void m1632c(boolean z) {
        boolean z2 = true;
        if (!f2763R ? !z || !C1509g.m1526K() : z && C1509g.m1526K()) {
            z2 = false;
        }
        if (z2) {
            if (C1496f.m1884b(f2764S)) {
                C1496f.m1886a(f2764S);
            }
            C1496f.m1888a(0, f2764S, 3000L);
        }
    }

    /* renamed from: d */
    public static String m1631d() {
        String str = f2786i;
        if (str != null) {
            return str;
        }
        String m1603j = m1603j(null);
        f2786i = m1603j;
        return m1603j;
    }

    /* renamed from: d */
    public static void m1628d(OutputStream outputStream) {
        if (C1500b.f2714d) {
            String m1735o = C1500b.m1735o();
            f2785h = false;
            if (1 == JNIBridge.cmd(17, m1735o)) {
                File file = new File(m1735o);
                try {
                    byte[] m1855e = C1497g.m1855e(file);
                    if (m1855e != null) {
                        outputStream.write(m1855e);
                    }
                } catch (Throwable th) {
                    m1660a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th2) {
                    m1660a(th2, outputStream);
                }
                f2785h = true;
                m1675a(outputStream);
            }
            f2785h = true;
            return;
        }
        File[] fileArr = null;
        int i = 900;
        try {
            i = C1509g.m1529H();
            fileArr = new File("/proc/self/fd").listFiles();
            if (fileArr != null) {
                outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArr.length), Integer.valueOf(i)).getBytes("UTF-8"));
            } else {
                outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            m1660a(th3, outputStream);
        }
        if (fileArr != null) {
            try {
                if (fileArr.length >= i) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    for (File file2 : fileArr) {
                        sb.append(file2.getName());
                        sb.append(" -> ");
                        sb.append(file2.getCanonicalPath());
                        sb.append("\n");
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
            } catch (Throwable th4) {
                m1660a(th4, outputStream);
            }
        }
        m1675a(outputStream);
    }

    /* renamed from: d */
    public static void m1626d(boolean z) {
        C1508f.m1540d(false);
        if (z) {
            C1508f.m1556a(C1500b.m1752c(), false);
        } else {
            C1508f.m1565a();
        }
        C1498h.m1812i();
    }

    /* renamed from: d */
    public static boolean m1629d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        boolean z = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == myPid) {
                f2760O = true;
                if (m1697O()) {
                    C1491a.m1920d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (C1500b.f2714d) {
                    JNIBridge.set(130, next.longMsg);
                }
                z = true;
            }
        }
        if (!z && C1500b.f2714d) {
            m1689W();
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m1627d(String str) {
        if (f2779ag) {
            return true;
        }
        try {
            return m1591p(str);
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return true;
        }
    }

    /* renamed from: e */
    public static int m1621e(boolean z) {
        return C1508f.m1552a(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009b A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #5 {all -> 0x00bf, blocks: (B:43:0x0086, B:45:0x009b), top: B:42:0x0086 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cc A[Catch: all -> 0x012f, TryCatch #4 {all -> 0x012f, blocks: (B:50:0x00c6, B:52:0x00cc, B:54:0x00d4, B:55:0x00fa, B:57:0x0100, B:59:0x0108), top: B:49:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0100 A[Catch: all -> 0x012f, TryCatch #4 {all -> 0x012f, blocks: (B:50:0x00c6, B:52:0x00cc, B:54:0x00d4, B:55:0x00fa, B:57:0x0100, B:59:0x0108), top: B:49:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1625e() {
        String str;
        String str2;
        Method declaredMethod;
        String str3;
        String str4;
        boolean z;
        if (!C1497g.m1872a(f2787j)) {
            return f2787j;
        }
        String str5 = null;
        try {
            Field declaredField = Build.class.getDeclaredField("SUPPORTED_ABIS");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj != null && (obj instanceof String[])) {
                String[] strArr = (String[]) obj;
                StringBuilder sb = new StringBuilder();
                int length = strArr.length;
                int i = 0;
                boolean z2 = true;
                while (i < length) {
                    String str6 = strArr[i];
                    if (!z2) {
                        sb.append(",");
                    }
                    sb.append(str6);
                    i++;
                    z2 = false;
                }
                f2787j = sb.toString();
            }
        } catch (Throwable unused) {
        }
        if (C1497g.m1872a(f2787j)) {
            try {
                str3 = Build.CPU_ABI;
            } catch (Throwable unused2) {
                str3 = null;
            }
            try {
                str4 = Build.CPU_ABI2;
            } catch (Throwable unused3) {
                str4 = null;
                z = !C1497g.m1872a(str3);
                if (z) {
                }
                if (!C1497g.m1872a(str4)) {
                }
                declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                if (declaredMethod != null) {
                }
            }
            z = !C1497g.m1872a(str3);
            if (z) {
                f2787j = str3;
            }
            if (!C1497g.m1872a(str4)) {
                if (z) {
                    f2787j = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), f2787j, ",");
                    f2787j = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), f2787j, str4);
                } else {
                    f2787j = str4;
                }
            }
        }
        try {
            declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
        } catch (Throwable th) {
            th = th;
            str = null;
        }
        if (declaredMethod != null) {
            str2 = null;
            if (!C1497g.m1872a(str5)) {
                f2787j += ",";
                f2787j += str5;
            }
            if (!C1497g.m1872a(str2)) {
                f2787j += ",";
                f2787j += str2;
            }
            return f2787j;
        }
        declaredMethod.setAccessible(true);
        str = (String) declaredMethod.invoke(null, "ro.product.cpu.abi", null);
        try {
            str2 = (String) declaredMethod.invoke(null, "ro.product.cpu.abi2", null);
        } catch (Throwable th2) {
            th = th2;
            C1497g.m1868a(th);
            str2 = null;
            str5 = str;
            if (!C1497g.m1872a(str5)) {
            }
            if (!C1497g.m1872a(str2)) {
            }
            return f2787j;
        }
        str5 = str;
        try {
            if (!C1497g.m1872a(str5) && !f2787j.contains(str5)) {
                f2787j += ",";
                f2787j += str5;
            }
            if (!C1497g.m1872a(str2) && !f2787j.contains(str2)) {
                f2787j += ",";
                f2787j += str2;
            }
        } catch (Throwable th3) {
            C1497g.m1868a(th3);
        }
        return f2787j;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1623e(OutputStream outputStream) {
        int i;
        int i2;
        File[] fileArr = null;
        try {
            i = C1509g.m1528I();
            try {
                fileArr = new File("/proc/self/task").listFiles();
            } catch (Throwable th) {
                th = th;
                C1497g.m1868a(th);
                i2 = 0;
                if (fileArr != null) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            i = 300;
        }
        if (fileArr == null) {
            return;
        }
        i2 = fileArr.length;
        if (i2 < i) {
            return;
        }
        if (fileArr != null) {
            return;
        }
        try {
            outputStream.write("threads info:\n".getBytes("UTF-8"));
            outputStream.write(String.format(Locale.US, "threads count: %d, dump limit: %d.\n", Integer.valueOf(i2), Integer.valueOf(i)).getBytes("UTF-8"));
            outputStream.write(" tid     name\n".getBytes("UTF-8"));
            for (File file : fileArr) {
                outputStream.write(String.format(Locale.US, "%5s %s\n", file.getName(), m1599l(C1497g.m1876a(new File(file.getPath(), "comm"), 128, false))).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            m1660a(th3, outputStream);
        }
        m1675a(outputStream);
    }

    /* renamed from: e */
    public static boolean m1622e(String str) {
        try {
            if (!C1497g.m1863b(str) || !str.startsWith("lib") || !str.endsWith(".so")) {
                return false;
            }
            System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return false;
        }
    }

    /* renamed from: f */
    public static int m1616f(boolean z) {
        int m1551b = z ? C1508f.m1559a(C1500b.m1752c()) ? 1 : 0 : C1508f.m1551b();
        int m1547b = C1508f.m1547b(z);
        return m1547b > m1551b ? m1547b : m1551b;
    }

    /* renamed from: f */
    public static String m1620f() {
        if (C1497g.m1872a(f2788k)) {
            m1692T();
        }
        return f2788k;
    }

    /* renamed from: f */
    public static StringBuilder m1617f(String str) {
        return m1654a(Thread.currentThread().getStackTrace(), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006f A[SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1618f(OutputStream outputStream) {
        BufferedReader bufferedReader;
        int indexOf;
        boolean z;
        if (!C1500b.f2714d) {
            return;
        }
        try {
            outputStream.write("solib build id:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            m1660a(th, outputStream);
        }
        FileReader fileReader = null;
        try {
            ArrayList arrayList = new ArrayList();
            FileReader fileReader2 = new FileReader(new File("/proc/self/maps"));
            try {
                bufferedReader = new BufferedReader(fileReader2, 512);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.endsWith(".so") && (indexOf = readLine.indexOf(47)) != -1) {
                            String substring = readLine.substring(indexOf);
                            if (!substring.contains("/data/") && !substring.contains(C1490a.f2594a)) {
                                z = false;
                                if (z && !arrayList.contains(substring)) {
                                    arrayList.add(substring);
                                    if (!f2779ag) {
                                        outputStream.write((String.format("$^%s`%s^$", "SOBUILDID", substring) + "\n").getBytes("UTF-8"));
                                    } else {
                                        outputStream.write(String.format(Locale.US, "%s: %s\n", substring, JNIBridge.nativeGet(3, 0L, substring)).getBytes("UTF-8"));
                                    }
                                }
                            }
                            z = true;
                            if (z) {
                                arrayList.add(substring);
                                if (!f2779ag) {
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader = fileReader2;
                        try {
                            m1660a(th, outputStream);
                            C1497g.m1879a(fileReader);
                            C1497g.m1879a(bufferedReader);
                            m1675a(outputStream);
                        } catch (Throwable th3) {
                            C1497g.m1879a(fileReader);
                            C1497g.m1879a(bufferedReader);
                            throw th3;
                        }
                    }
                }
                C1497g.m1879a(fileReader2);
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
        C1497g.m1879a(bufferedReader);
        m1675a(outputStream);
    }

    /* renamed from: g */
    public static String m1615g() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            ActivityManager activityManager = (ActivityManager) C1497g.m1882a().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                sb.append("availMem:   ");
                sb.append(memoryInfo.availMem / 1024);
                sb.append(" kB\n");
                sb.append("threshold:  ");
                sb.append(memoryInfo.threshold / 1024);
                sb.append(" kB\n");
                sb.append("lowMemory:  ");
                sb.append(memoryInfo.lowMemory);
                sb.append("\n");
            }
            return sb.toString();
        } catch (Throwable th) {
            C1497g.m1868a(th);
            return "";
        }
    }

    /* renamed from: g */
    public static void m1613g(OutputStream outputStream) {
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            m1660a(th, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", f2779ag ? m1585s("LASTVER") : C1490a.m1930m()).getBytes("UTF-8"));
        } catch (Throwable th2) {
            m1660a(th2, outputStream);
        }
        try {
            synchronized (f2796s) {
                if (f2798u != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", f2798u).getBytes("UTF-8"));
                }
                if (f2797t > 0 || f2796s.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(f2797t)).getBytes("UTF-8"));
                    Iterator<String> it = f2796s.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "dumping all threads: %s\n", Boolean.valueOf(f2799v)).getBytes("UTF-8"));
            if (f2800w != null) {
                outputStream.write(String.format(Locale.US, "dumping threads: %s\n", f2800w).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            m1660a(th3, outputStream);
        }
        m1675a(outputStream);
    }

    /* renamed from: h */
    public static long m1608h(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        return 0L;
    }

    /* renamed from: h */
    public static String m1610h() {
        String str = f2790m;
        if (str != null) {
            return str;
        }
        String m1684a = m1684a(Process.myPid());
        f2790m = m1684a;
        return m1684a;
    }

    /* renamed from: i */
    public static String m1605i(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    /* renamed from: i */
    public static boolean m1607i() {
        return f2782d;
    }

    /* renamed from: j */
    public static String m1603j(String str) {
        if (str == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String.valueOf(System.currentTimeMillis()));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(new Random().nextInt(65536));
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", m1696P(), C1509g.m1519R(), C1509g.m1517T(), m1605i(Build.MODEL), m1605i(Build.VERSION.RELEASE), str);
    }

    /* renamed from: j */
    public static void m1604j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
    }

    /* renamed from: k */
    public static String m1602k() {
        String str = f2801x;
        if (C1497g.m1872a(str)) {
            synchronized (f2802y) {
                str = C1497g.m1871a(C1500b.m1741i(), C1509g.m1521P() ? "https://errlogos.umeng.com/upload" : "https://errlog.umeng.com/upload", true);
                f2801x = str;
            }
        }
        return str;
    }

    /* renamed from: k */
    public static String m1601k(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", m1631d(), m1596n(), m1695Q(), str);
    }

    /* renamed from: l */
    public static String m1599l(String str) {
        if (C1497g.m1863b(str)) {
            int indexOf = str.indexOf(0);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            return str.trim();
        }
        return "";
    }

    /* renamed from: l */
    public static void m1600l() {
        synchronized (f2802y) {
            f2801x = null;
        }
    }

    /* renamed from: m */
    public static String m1597m(String str) {
        String m1917a = C1492b.m1917a(str, C1509g.m1476w(), C1509g.m1477v());
        if (!str.equals(m1917a)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return m1917a;
    }

    /* renamed from: m */
    public static void m1598m() {
        if (f2779ag) {
            return;
        }
        C1496f.m1888a(1, new RunnableC1495e(411), 1000L);
    }

    /* renamed from: n */
    public static String m1596n() {
        return m1657a(new Date());
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
        if (r7.endsWith(r3) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        if (r7.indexOf(".log", r7.lastIndexOf(95)) != r7.lastIndexOf(".log")) goto L29;
     */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean[] m1595n(String str) {
        boolean m1477v = C1509g.m1477v();
        boolean m1475x = C1509g.m1475x();
        if (m1477v || m1475x) {
            if (!str.endsWith(".tmp") && !str.contains(".ec")) {
                int lastIndexOf = str.lastIndexOf(File.separatorChar);
                if (lastIndexOf < 0) {
                    lastIndexOf = 0;
                }
                int i = 0;
                do {
                    lastIndexOf = str.indexOf(95, lastIndexOf);
                    if (lastIndexOf >= 0) {
                        i++;
                        lastIndexOf++;
                        continue;
                    }
                } while (lastIndexOf >= 0);
                if (i == 8) {
                    String m1476w = C1509g.m1476w();
                    if (!str.endsWith(".log")) {
                        if (!C1497g.m1872a(m1476w)) {
                        }
                    } else if (!C1497g.m1872a(m1476w)) {
                    }
                    m1477v = false;
                }
            }
            m1477v = false;
            m1475x = false;
        }
        return new boolean[]{m1477v, m1475x};
    }

    /* renamed from: o */
    public static void m1594o() {
        f2780b = System.currentTimeMillis();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:3|4|(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|54|(0)|25|26|27|29|30|31|32) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|26|27|29|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00dd, code lost:
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e2, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e5, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1879a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d9, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00da, code lost:
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ea, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1879a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ed, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e1, code lost:
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ae A[Catch: all -> 0x00ee, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x0033, B:7:0x0041, B:9:0x0047, B:11:0x0051, B:13:0x0056, B:49:0x0068, B:18:0x0078, B:22:0x0083, B:24:0x00ae, B:31:0x00d5, B:32:0x00e8, B:43:0x00ea, B:44:0x00ed, B:39:0x00e5, B:52:0x0072), top: B:3:0x0005, inners: #5 }] */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m1593o(String str) {
        boolean z;
        boolean z2;
        int parseInt;
        synchronized (f2795r) {
            File file = new File(C1509g.m1516U() + "customlog");
            String m1876a = C1497g.m1876a(file, 1024, false);
            long currentTimeMillis = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            try {
                if (m1876a != null) {
                    stringBuffer.append(m1876a);
                    Matcher matcher = Pattern.compile("([^\\n\\r\\t\\s]+) (\\d+) (\\d+)").matcher(stringBuffer);
                    for (int i = 0; matcher.find(i); i = matcher.end()) {
                        if (str.equals(matcher.group(1))) {
                            long parseLong = Long.parseLong(matcher.group(2));
                            if (currentTimeMillis - parseLong < 86400000) {
                                try {
                                    parseInt = Integer.parseInt(matcher.group(3));
                                } catch (Exception e) {
                                    C1497g.m1868a(e);
                                }
                                int m1533D = C1509g.m1533D();
                                z2 = m1533D < 0 && parseInt >= m1533D;
                                stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", str, Long.valueOf(parseLong), Integer.valueOf(parseInt + 1)));
                                z = true;
                                if (!z) {
                                    stringBuffer.append(String.format(Locale.US, "%s %d 1\n", str, Long.valueOf(currentTimeMillis)));
                                }
                                FileWriter fileWriter = null;
                                FileWriter fileWriter2 = new FileWriter(file);
                                String stringBuffer2 = stringBuffer.toString();
                                fileWriter2.write(stringBuffer2, 0, stringBuffer2.length());
                                C1497g.m1879a(fileWriter2);
                            } else {
                                parseLong = currentTimeMillis;
                            }
                            parseInt = 0;
                            int m1533D2 = C1509g.m1533D();
                            if (m1533D2 < 0) {
                            }
                            stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", str, Long.valueOf(parseLong), Integer.valueOf(parseInt + 1)));
                            z = true;
                            if (!z) {
                            }
                            FileWriter fileWriter3 = null;
                            FileWriter fileWriter22 = new FileWriter(file);
                            String stringBuffer22 = stringBuffer.toString();
                            fileWriter22.write(stringBuffer22, 0, stringBuffer22.length());
                            C1497g.m1879a(fileWriter22);
                        }
                    }
                }
                FileWriter fileWriter222 = new FileWriter(file);
                String stringBuffer222 = stringBuffer.toString();
                fileWriter222.write(stringBuffer222, 0, stringBuffer222.length());
                C1497g.m1879a(fileWriter222);
            } catch (Throwable th) {
                th = th;
            }
            z = false;
            z2 = false;
            if (!z) {
            }
            FileWriter fileWriter32 = null;
        }
        return z2;
    }

    /* renamed from: p */
    public static void m1592p() {
        String str;
        Throwable th;
        if (!C1497g.m1872a(f2747B)) {
            return;
        }
        String str2 = null;
        try {
            File file = new File(C1509g.m1516U() + "unique");
            if (file.exists()) {
                str = C1497g.m1876a(file, 48, false);
                try {
                    if (str != null) {
                        try {
                            if (str.length() == 36) {
                                str2 = str.replaceAll("[^0-9a-zA-Z-]", "-");
                            }
                        } catch (Exception e) {
                            C1497g.m1868a(e);
                        }
                    }
                    str2 = str;
                } catch (Throwable th2) {
                    th = th2;
                    C1497g.m1868a(th);
                    str2 = str;
                    f2747B = str2;
                }
            }
            if (C1497g.m1872a(str2)) {
                C1500b.m1790G();
                str2 = UUID.randomUUID().toString();
                if (!C1497g.m1872a(str2)) {
                    C1497g.m1873a(file, str2.getBytes());
                }
            }
        } catch (Throwable th3) {
            str = str2;
            th = th3;
        }
        f2747B = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ae A[Catch: all -> 0x0106, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:12:0x00ae, B:17:0x00d3, B:23:0x00ee, B:24:0x00de, B:37:0x00fa, B:40:0x0104, B:44:0x0033, B:46:0x003b, B:47:0x0044, B:49:0x004c, B:51:0x0054, B:53:0x005c, B:58:0x006a, B:60:0x0074, B:62:0x0081, B:64:0x008b, B:65:0x0096, B:67:0x00a0), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a0 A[Catch: all -> 0x0106, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:12:0x00ae, B:17:0x00d3, B:23:0x00ee, B:24:0x00de, B:37:0x00fa, B:40:0x0104, B:44:0x0033, B:46:0x003b, B:47:0x0044, B:49:0x004c, B:51:0x0054, B:53:0x005c, B:58:0x006a, B:60:0x0074, B:62:0x0081, B:64:0x008b, B:65:0x0096, B:67:0x00a0), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ab  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m1591p(String str) {
        boolean z;
        boolean z2;
        int i;
        Integer num;
        synchronized (f2803z) {
            z = false;
            if (f2746A == null) {
                f2746A = m1589q(C1497g.m1871a(C1500b.m1738l(), "all:1", false));
            }
            if (f2746A.containsKey("all")) {
                num = f2746A.get("all");
            } else if (f2746A.containsKey(str)) {
                num = f2746A.get(str);
            } else {
                if (!LogType.JAVA_TYPE.equals(str) && !LogType.NATIVE_TYPE.equals(str) && !LogType.ANR_TYPE.equals(str) && !LogType.UNEXP_TYPE.equals(str)) {
                    z2 = false;
                    if (!z2 && f2746A.containsKey("crash")) {
                        num = f2746A.get("crash");
                    } else if (z2 && f2746A.containsKey("nocrash")) {
                        num = f2746A.get("nocrash");
                    } else if (!f2746A.containsKey("other")) {
                        num = f2746A.get("other");
                    } else {
                        i = 1;
                        if (i != 0) {
                            long j = i;
                            if (j < 0) {
                                long j2 = 30;
                                if (j == -2) {
                                    j2 = 7;
                                } else if (j == -3) {
                                    j2 = 15;
                                } else if (j == -4) {
                                    j2 = 60;
                                }
                                long m1946b = C1490a.m1946b();
                                long currentTimeMillis = m1946b == 0 ? -1L : (System.currentTimeMillis() - m1946b) / 86400000;
                                j = currentTimeMillis <= j2 ? 1L : currentTimeMillis - j2;
                            }
                            if (j != 1) {
                                if (j > 0) {
                                    if (System.currentTimeMillis() % j == 0) {
                                    }
                                }
                            }
                            z = true;
                        }
                    }
                }
                z2 = true;
                if (!z2) {
                }
                if (z2) {
                }
                if (!f2746A.containsKey("other")) {
                }
            }
            i = num.intValue();
            if (i != 0) {
            }
        }
        return z;
    }

    /* renamed from: q */
    public static String m1590q() {
        return f2747B;
    }

    /* renamed from: q */
    public static Map<String, Integer> m1589q(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\\|", 30)) {
            String[] split = str2.split(":", 3);
            if (split.length == 2) {
                String trim = split[0].trim();
                if (!C1497g.m1872a(trim)) {
                    int i = 1;
                    try {
                        i = Integer.parseInt(split[1].trim(), 10);
                    } catch (Throwable th) {
                        C1497g.m1868a(th);
                    }
                    hashMap.put(trim, Integer.valueOf(i));
                }
            }
        }
        return hashMap;
    }

    /* renamed from: r */
    public static void m1588r() {
        f2760O = false;
        if (!C1500b.m1795B()) {
            C1496f.m1888a(3, new RunnableC1495e(416), 11000L);
        }
        if (m1690V()) {
            return;
        }
        f2759N = 0;
        m1688X();
    }

    /* renamed from: r */
    public static void m1587r(String str) {
        if (!C1509g.m1482q()) {
            return;
        }
        try {
            m1652ab();
        } catch (Throwable th) {
            C1497g.m1868a(th);
        }
        if (str == null || "".equals(str)) {
            return;
        }
        try {
            File file = new File(C1509g.m1514W());
            if (!file.exists()) {
                file.mkdirs();
            }
            C1491a.m1925a("crashsdk", "copy log to: " + file);
            C1497g.m1875a(new File(str), file);
        } catch (Throwable th2) {
            C1497g.m1868a(th2);
        }
    }

    /* renamed from: s */
    public static String m1585s(String str) {
        return String.format("$^%s^$", str);
    }

    /* renamed from: s */
    public static void m1586s() {
        f2765T = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new C1503e());
    }

    /* renamed from: t */
    public static void m1584t() {
        Thread.setDefaultUncaughtExceptionHandler(f2765T);
    }

    /* renamed from: u */
    public static boolean m1583u() {
        return f2781c.get() || m1653aa();
    }

    /* renamed from: v */
    public static Throwable m1582v() {
        return f2766U;
    }

    /* renamed from: w */
    public static int m1581w() {
        if (C1500b.m1788I() == 5) {
            return f2771Z;
        }
        return 100;
    }

    /* renamed from: x */
    public static void m1580x() {
        long m1484o = C1509g.m1484o();
        if (m1484o < 0) {
            return;
        }
        boolean z = C1500b.m1788I() == 5;
        C1496f.m1889a(0, new RunnableC1495e(401));
        if (!z) {
            return;
        }
        RunnableC1495e runnableC1495e = new RunnableC1495e(402);
        f2769X = runnableC1495e;
        C1496f.m1888a(0, runnableC1495e, m1484o);
    }

    /* renamed from: y */
    public static void m1579y() {
        if (!C1500b.f2713c || !C1490a.f2596c || C1496f.m1884b(f2773aa)) {
            return;
        }
        C1496f.m1888a(0, f2773aa, 1000L);
    }

    /* renamed from: z */
    public static boolean m1578z() {
        synchronized (f2770Y) {
            if (f2769X == null || f2768W) {
                return false;
            }
            C1496f.m1886a(f2769X);
            f2769X = null;
            return true;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(1:367)|(3:399|400|(15:403|404|405|(1:372)|373|374|375|376|(1:378)|379|(1:383)|384|(1:387)|389|(2:391|392)(1:393)))|369|(1:372)|373|374|375|376|(0)|379|(2:381|383)|384|(1:387)|389|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:145|(3:177|178|(15:181|182|183|(1:150)|151|152|153|154|(1:156)|157|(1:161)|162|(1:165)|167|(2:169|170)(1:171)))|147|(1:150)|151|152|153|154|(0)|157|(2:159|161)|162|(1:165)|167|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:193|(3:225|226|(15:229|230|231|(1:198)|199|200|201|202|(1:204)|205|(1:209)|210|(1:213)|215|(2:217|218)(1:219)))|195|(1:198)|199|200|201|202|(0)|205|(2:207|209)|210|(1:213)|215|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:71|(3:103|104|(15:107|108|109|(1:76)|77|78|79|80|(1:82)|83|(1:87)|88|(1:91)|93|(2:95|96)(1:97)))|73|(1:76)|77|78|79|80|(0)|83|(2:85|87)|88|(1:91)|93|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:313|(1:317)|(3:349|350|(15:353|354|355|(1:322)|323|324|326|327|(1:329)|330|(1:334)|335|(1:338)|340|(2:342|343)(1:344)))|319|(1:322)|323|324|326|327|(0)|330|(2:332|334)|335|(1:338)|340|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:11|(5:14|15|16|(1:18)|12)|66|19|(3:52|53|(15:56|57|58|(1:24)|25|26|27|28|(1:30)|31|(1:35)|36|(1:39)|41|(2:43|44)(1:46)))|21|(1:24)|25|26|27|28|(0)|31|(2:33|35)|36|(1:39)|41|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:471|472|(1:476)|(3:507|508|(17:511|512|513|514|(1:481)|482|483|484|485|(1:487)|488|(1:492)|493|(1:496)|498|(1:500)|501))|478|(1:481)|482|483|484|485|(0)|488|(2:490|492)|493|(1:496)|498|(0)|501) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:414|415|416|(1:418)|420|(1:424)|(3:456|457|(16:460|461|462|463|(1:429)|430|431|432|433|(1:435)|436|(1:440)|441|(1:444)|446|(2:448|449)(1:450)))|426|(1:429)|430|431|432|433|(0)|436|(2:438|440)|441|(1:444)|446|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(34:117|(1:119)|120|(1:122)|123|124|125|126|127|128|(1:524)|132|133|134|135|(7:137|138|139|(1:141)(1:303)|142|143|(15:145|(3:177|178|(15:181|182|183|(1:150)|151|152|153|154|(1:156)|157|(1:161)|162|(1:165)|167|(2:169|170)(1:171)))|147|(1:150)|151|152|153|154|(0)|157|(2:159|161)|162|(1:165)|167|(0)(0))(2:191|(15:193|(3:225|226|(15:229|230|231|(1:198)|199|200|201|202|(1:204)|205|(1:209)|210|(1:213)|215|(2:217|218)(1:219)))|195|(1:198)|199|200|201|202|(0)|205|(2:207|209)|210|(1:213)|215|(0)(0))(1:239)))(5:(1:307)|308|(1:310)(1:413)|311|(16:313|(1:317)|(3:349|350|(15:353|354|355|(1:322)|323|324|326|327|(1:329)|330|(1:334)|335|(1:338)|340|(2:342|343)(1:344)))|319|(1:322)|323|324|326|327|(0)|330|(2:332|334)|335|(1:338)|340|(0)(0))(1:(15:(1:367)|(3:399|400|(15:403|404|405|(1:372)|373|374|375|376|(1:378)|379|(1:383)|384|(1:387)|389|(2:391|392)(1:393)))|369|(1:372)|373|374|375|376|(0)|379|(2:381|383)|384|(1:387)|389|(0)(0))))|240|(5:245|(1:247)|248|249|250)|251|(1:255)|(3:287|288|(16:291|292|293|294|(1:260)|261|262|263|264|(1:266)|267|(1:271)|272|(1:275)|277|(2:279|280)(1:281)))|257|(1:260)|261|262|263|264|(0)|267|(2:269|271)|272|(1:275)|277|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00fc, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00fd, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0286, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0287, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x024c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x024d, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0303, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0304, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x02c9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02ca, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x051f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0520, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x04e5, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x04e6, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x03a3, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x03a4, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x0369, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x036a, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0420, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x0421, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x03e6, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x03e7, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:451:0x05d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:452:0x05d3, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x0598, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x0599, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b3, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b4, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x0655, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:0x0656, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x061b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:506:0x061c, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0079, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007a, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0136, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0137, code lost:
        com.p046uc.crashsdk.p047a.C1497g.m1868a(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01f7 A[Catch: all -> 0x020e, TRY_ENTER, TRY_LEAVE, TryCatch #13 {all -> 0x0536, blocks: (B:145:0x0225, B:191:0x029a, B:193:0x02a0, B:307:0x031d, B:308:0x0322, B:310:0x0326, B:137:0x01f7, B:305:0x020a, B:143:0x0212), top: B:135:0x01f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0243 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x026d A[Catch: all -> 0x0286, TryCatch #26 {all -> 0x0286, blocks: (B:154:0x0251, B:157:0x025c, B:159:0x026d, B:161:0x0271, B:162:0x0276, B:165:0x027e), top: B:153:0x0251 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x027c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02ea A[Catch: all -> 0x0303, TryCatch #22 {all -> 0x0303, blocks: (B:202:0x02ce, B:205:0x02d9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f3, B:213:0x02fb), top: B:201:0x02ce }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02f9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0464 A[Catch: all -> 0x0534, TryCatch #11 {all -> 0x0534, blocks: (B:240:0x0434, B:243:0x0446, B:245:0x044c, B:247:0x0464, B:248:0x0467, B:250:0x0495, B:313:0x0334, B:249:0x048c), top: B:135:0x01f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x04dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0506 A[Catch: all -> 0x051f, TryCatch #46 {all -> 0x051f, blocks: (B:264:0x04ea, B:267:0x04f5, B:269:0x0506, B:271:0x050a, B:272:0x050f, B:275:0x0517), top: B:263:0x04ea }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0515 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:281:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0360 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x038a A[Catch: all -> 0x03a3, TryCatch #47 {all -> 0x03a3, blocks: (B:327:0x036e, B:330:0x0379, B:332:0x038a, B:334:0x038e, B:335:0x0393, B:338:0x039b), top: B:326:0x036e }] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0399 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009a A[Catch: all -> 0x00b3, TryCatch #10 {all -> 0x00b3, blocks: (B:28:0x007e, B:31:0x0089, B:33:0x009a, B:35:0x009e, B:36:0x00a3, B:39:0x00ab), top: B:27:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:342:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:344:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x03dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0407 A[Catch: all -> 0x0420, TryCatch #48 {all -> 0x0420, blocks: (B:376:0x03eb, B:379:0x03f6, B:381:0x0407, B:383:0x040b, B:384:0x0410, B:387:0x0418), top: B:375:0x03eb }] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0416 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:393:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:428:0x058f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:435:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x05b9 A[Catch: all -> 0x05d2, TryCatch #38 {all -> 0x05d2, blocks: (B:433:0x059d, B:436:0x05a8, B:438:0x05b9, B:440:0x05bd, B:441:0x05c2, B:444:0x05ca), top: B:432:0x059d }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x05c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:448:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:450:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0612 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:487:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x063c A[Catch: all -> 0x0655, TryCatch #42 {all -> 0x0655, blocks: (B:485:0x0620, B:488:0x062b, B:490:0x063c, B:492:0x0640, B:493:0x0645, B:496:0x064d), top: B:484:0x0620 }] */
    /* JADX WARN: Removed duplicated region for block: B:495:0x064b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x011d A[Catch: all -> 0x0136, TryCatch #14 {all -> 0x0136, blocks: (B:80:0x0101, B:83:0x010c, B:85:0x011d, B:87:0x0121, B:88:0x0126, B:91:0x012e), top: B:79:0x0101 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x012c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1662a(Thread thread, Throwable th, boolean z) {
        boolean z2;
        long j;
        boolean z3;
        boolean m1490i;
        Throwable th2;
        boolean z4;
        boolean m1490i2;
        boolean z5;
        String str;
        long nativeClientCreateConnection;
        boolean z6;
        boolean m1490i3;
        boolean z7;
        boolean m1490i4;
        Throwable th3;
        boolean z8;
        boolean m1490i5;
        File file;
        boolean z9;
        boolean m1490i6;
        boolean z10;
        boolean m1490i7;
        boolean z11;
        boolean m1490i8;
        boolean z12;
        boolean m1490i9;
        boolean z13 = (f2779ag && C1500b.f2714d) || C1500b.m1785L();
        try {
            j = 4;
            if (!f2781c.getAndSet(true) || Process.myPid() <= 0) {
                f2766U = th;
                if (z13 || C1494d.m1895e()) {
                    C1491a.m1920d("DEBUG", "encryptLog: " + C1509g.m1475x() + ", zipCrashLog: " + C1509g.m1475x());
                    if (C1509g.f2826a != null) {
                        C1491a.m1920d("DEBUG", "the set zip log to false stack is:");
                        C1509g.f2826a.printStackTrace();
                    }
                    if (C1509g.f2827b != null) {
                        C1491a.m1920d("DEBUG", "the set encrypt to true stack is:");
                        C1509g.f2827b.printStackTrace();
                    }
                    C1491a.m1920d("DEBUG", "begin to generate java report");
                    m1698N();
                    try {
                        z5 = C1509g.m1479t();
                        try {
                            String m1492g = C1509g.m1492g();
                            if (m1492g == null || m1492g.equals("")) {
                                m1492g = m1601k(m1693S());
                            }
                            str = C1509g.m1515V() + m1492g;
                            z2 = false;
                        } catch (Throwable th4) {
                            th = th4;
                            C1491a.m1920d("DEBUG", "get java log name failed: " + th);
                            m1661a(th);
                            C1491a.m1920d("DEBUG", "original exception is: " + th);
                            m1661a(th);
                            str = null;
                            z2 = true;
                            try {
                                if (z13) {
                                }
                                boolean z14 = th instanceof OutOfMemoryError;
                                m1659a(th, str, nativeClientCreateConnection, z14);
                                C1491a.m1920d("DEBUG", "generate java report finished");
                                if (!C1500b.m1785L()) {
                                    String name = new File(str).getName();
                                    String m1514W = C1509g.m1514W();
                                    file = new File(m1514W);
                                    if (!file.exists()) {
                                    }
                                    String format = String.format(Locale.US, "%s%s.hprof", m1514W, name);
                                    C1491a.m1920d("DEBUG", "begin dump hprof: " + format);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    Debug.dumpHprofData(format);
                                    C1491a.m1920d("DEBUG", "end dump hprof, use " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                                }
                                if (nativeClientCreateConnection != 0) {
                                    JNIBridge.nativeClientCloseConnection(nativeClientCreateConnection);
                                }
                                if (z) {
                                }
                                z8 = false;
                                if (!z8) {
                                }
                                C1508f.m1543c(false);
                                m1490i5 = C1509g.m1490i();
                                if (!C1494d.m1895e()) {
                                }
                                C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i5);
                                if (m1490i5) {
                                }
                                if (C1500b.m1795B()) {
                                }
                                f2767V = true;
                                if (Process.myPid() > 0) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    C1491a.m1920d("DEBUG", "exception occurs while java log: " + th);
                                    m1661a(th);
                                    if (!z2) {
                                        C1491a.m1920d("DEBUG", "original exception is: " + th);
                                        m1661a(th);
                                    }
                                    if (j != 0 && C1500b.f2714d) {
                                        JNIBridge.nativeClientCloseConnection(j);
                                    }
                                    if (z) {
                                        try {
                                        } catch (Throwable th6) {
                                            th2 = th6;
                                            z4 = false;
                                        }
                                        if (C1509g.m1481r() && !z13) {
                                            try {
                                                m1655a(true, false);
                                                z4 = true;
                                            } catch (Throwable th7) {
                                                th2 = th7;
                                                z4 = true;
                                                C1497g.m1868a(th2);
                                                if (!z4) {
                                                }
                                                C1508f.m1543c(false);
                                                m1490i2 = C1509g.m1490i();
                                                if (!C1494d.m1895e()) {
                                                }
                                                C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i2);
                                                if (m1490i2) {
                                                }
                                                if (C1500b.m1795B()) {
                                                }
                                                f2767V = true;
                                                if (Process.myPid() <= 0) {
                                                }
                                            }
                                            if (!z4 && !z13) {
                                                m1638b(false);
                                            }
                                            C1508f.m1543c(false);
                                            m1490i2 = C1509g.m1490i();
                                            if (!C1494d.m1895e()) {
                                                m1490i2 = true;
                                            }
                                            C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i2);
                                            if (m1490i2 && f2765T != null) {
                                                f2765T.uncaughtException(thread, th);
                                            }
                                            if (C1500b.m1795B() && !z13) {
                                                C1500b.m1755b(C1497g.m1882a());
                                            }
                                            f2767V = true;
                                            if (Process.myPid() <= 0) {
                                                return;
                                            }
                                            Process.killProcess(Process.myPid());
                                            return;
                                        }
                                    }
                                    z4 = false;
                                    if (!z4) {
                                        m1638b(false);
                                    }
                                    C1508f.m1543c(false);
                                    m1490i2 = C1509g.m1490i();
                                    if (!C1494d.m1895e()) {
                                    }
                                    C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i2);
                                    if (m1490i2) {
                                        f2765T.uncaughtException(thread, th);
                                    }
                                    if (C1500b.m1795B()) {
                                        C1500b.m1755b(C1497g.m1882a());
                                    }
                                    f2767V = true;
                                    if (Process.myPid() <= 0) {
                                    }
                                } catch (Throwable th8) {
                                    if (j != 0 && C1500b.f2714d) {
                                        JNIBridge.nativeClientCloseConnection(j);
                                    }
                                    if (z) {
                                        try {
                                        } catch (Throwable th9) {
                                            th = th9;
                                            z3 = false;
                                        }
                                        if (C1509g.m1481r() && !z13) {
                                            try {
                                                m1655a(true, false);
                                                z3 = true;
                                            } catch (Throwable th10) {
                                                th = th10;
                                                z3 = true;
                                                C1497g.m1868a(th);
                                                if (!z3) {
                                                }
                                                C1508f.m1543c(false);
                                                m1490i = C1509g.m1490i();
                                                if (!C1494d.m1895e()) {
                                                }
                                                C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i);
                                                if (m1490i) {
                                                }
                                                if (C1500b.m1795B()) {
                                                }
                                                f2767V = true;
                                                if (Process.myPid() > 0) {
                                                }
                                                throw th8;
                                            }
                                            if (!z3 && !z13) {
                                                m1638b(false);
                                            }
                                            C1508f.m1543c(false);
                                            m1490i = C1509g.m1490i();
                                            if (!C1494d.m1895e()) {
                                                m1490i = true;
                                            }
                                            C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i);
                                            if (m1490i && f2765T != null) {
                                                f2765T.uncaughtException(thread, th);
                                            }
                                            if (C1500b.m1795B() && !z13) {
                                                C1500b.m1755b(C1497g.m1882a());
                                            }
                                            f2767V = true;
                                            if (Process.myPid() > 0) {
                                                Process.killProcess(Process.myPid());
                                            }
                                            throw th8;
                                        }
                                    }
                                    z3 = false;
                                    if (!z3) {
                                        m1638b(false);
                                    }
                                    C1508f.m1543c(false);
                                    m1490i = C1509g.m1490i();
                                    if (!C1494d.m1895e()) {
                                    }
                                    C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i);
                                    if (m1490i) {
                                        f2765T.uncaughtException(thread, th);
                                    }
                                    if (C1500b.m1795B()) {
                                        C1500b.m1755b(C1497g.m1882a());
                                    }
                                    f2767V = true;
                                    if (Process.myPid() > 0) {
                                    }
                                    throw th8;
                                }
                            }
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        z5 = false;
                    }
                    try {
                        if (z13) {
                            C1509g.m1510a();
                            try {
                                if (C1500b.m1795B()) {
                                    C1508f.m1564a(3);
                                } else {
                                    C1508f.m1564a(4);
                                }
                            } catch (Throwable th12) {
                                C1497g.m1868a(th12);
                            }
                            new File(C1500b.m1757b()).createNewFile();
                            if (z5) {
                                C1491a.m1920d("DEBUG", "omit java crash");
                                if (z) {
                                    try {
                                    } catch (Throwable th13) {
                                        th = th13;
                                        z10 = false;
                                    }
                                    if (C1509g.m1481r() && !z13) {
                                        try {
                                            m1655a(true, false);
                                            z10 = true;
                                        } catch (Throwable th14) {
                                            th = th14;
                                            z10 = true;
                                            C1497g.m1868a(th);
                                            if (!z10) {
                                            }
                                            C1508f.m1543c(false);
                                            m1490i7 = C1509g.m1490i();
                                            if (!C1494d.m1895e()) {
                                            }
                                            C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i7);
                                            if (m1490i7) {
                                            }
                                            if (C1500b.m1795B()) {
                                            }
                                            f2767V = true;
                                            if (Process.myPid() <= 0) {
                                            }
                                        }
                                        if (!z10 && !z13) {
                                            m1638b(false);
                                        }
                                        C1508f.m1543c(false);
                                        m1490i7 = C1509g.m1490i();
                                        if (!C1494d.m1895e()) {
                                            m1490i7 = true;
                                        }
                                        C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i7);
                                        if (m1490i7 && f2765T != null) {
                                            f2765T.uncaughtException(thread, th);
                                        }
                                        if (C1500b.m1795B() && !z13) {
                                            C1500b.m1755b(C1497g.m1882a());
                                        }
                                        f2767V = true;
                                        if (Process.myPid() <= 0) {
                                            return;
                                        }
                                        Process.killProcess(Process.myPid());
                                        return;
                                    }
                                }
                                z10 = false;
                                if (!z10) {
                                    m1638b(false);
                                }
                                C1508f.m1543c(false);
                                m1490i7 = C1509g.m1490i();
                                if (!C1494d.m1895e()) {
                                }
                                C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i7);
                                if (m1490i7) {
                                    f2765T.uncaughtException(thread, th);
                                }
                                if (C1500b.m1795B()) {
                                    C1500b.m1755b(C1497g.m1882a());
                                }
                                f2767V = true;
                                if (Process.myPid() <= 0) {
                                }
                            } else if (!m1627d(LogType.JAVA_TYPE)) {
                                C1491a.m1920d("DEBUG", "java log sample miss");
                                if (z) {
                                    try {
                                    } catch (Throwable th15) {
                                        th = th15;
                                        z9 = false;
                                    }
                                    if (C1509g.m1481r() && !z13) {
                                        try {
                                            m1655a(true, false);
                                            z9 = true;
                                        } catch (Throwable th16) {
                                            th = th16;
                                            z9 = true;
                                            C1497g.m1868a(th);
                                            if (!z9) {
                                            }
                                            C1508f.m1543c(false);
                                            m1490i6 = C1509g.m1490i();
                                            if (!C1494d.m1895e()) {
                                            }
                                            C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i6);
                                            if (m1490i6) {
                                            }
                                            if (C1500b.m1795B()) {
                                            }
                                            f2767V = true;
                                            if (Process.myPid() <= 0) {
                                            }
                                        }
                                        if (!z9 && !z13) {
                                            m1638b(false);
                                        }
                                        C1508f.m1543c(false);
                                        m1490i6 = C1509g.m1490i();
                                        if (!C1494d.m1895e()) {
                                            m1490i6 = true;
                                        }
                                        C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i6);
                                        if (m1490i6 && f2765T != null) {
                                            f2765T.uncaughtException(thread, th);
                                        }
                                        if (C1500b.m1795B() && !z13) {
                                            C1500b.m1755b(C1497g.m1882a());
                                        }
                                        f2767V = true;
                                        if (Process.myPid() <= 0) {
                                            return;
                                        }
                                        Process.killProcess(Process.myPid());
                                        return;
                                    }
                                }
                                z9 = false;
                                if (!z9) {
                                    m1638b(false);
                                }
                                C1508f.m1543c(false);
                                m1490i6 = C1509g.m1490i();
                                if (!C1494d.m1895e()) {
                                }
                                C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i6);
                                if (m1490i6) {
                                    f2765T.uncaughtException(thread, th);
                                }
                                if (C1500b.m1795B()) {
                                    C1500b.m1755b(C1497g.m1882a());
                                }
                                f2767V = true;
                                if (Process.myPid() <= 0) {
                                }
                            } else {
                                nativeClientCreateConnection = 0;
                            }
                        } else {
                            if (z5) {
                                str = "omit";
                                C1491a.m1920d("DEBUG", "omit java crash");
                            }
                            nativeClientCreateConnection = C1500b.f2714d ? JNIBridge.nativeClientCreateConnection(str, LogType.JAVA_TYPE, null, 0) : 0L;
                            int i = (nativeClientCreateConnection > 0L ? 1 : (nativeClientCreateConnection == 0L ? 0 : -1));
                            if (i == 0) {
                                C1491a.m1920d("DEBUG", "skip java crash:");
                                m1661a(th);
                                if (i != 0 && C1500b.f2714d) {
                                    JNIBridge.nativeClientCloseConnection(nativeClientCreateConnection);
                                }
                                if (z) {
                                    try {
                                    } catch (Throwable th17) {
                                        th = th17;
                                        z7 = false;
                                    }
                                    if (C1509g.m1481r() && !z13) {
                                        try {
                                            m1655a(true, false);
                                            z7 = true;
                                        } catch (Throwable th18) {
                                            th = th18;
                                            z7 = true;
                                            C1497g.m1868a(th);
                                            if (!z7) {
                                            }
                                            C1508f.m1543c(false);
                                            m1490i4 = C1509g.m1490i();
                                            if (!C1494d.m1895e()) {
                                            }
                                            C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i4);
                                            if (m1490i4) {
                                            }
                                            if (C1500b.m1795B()) {
                                            }
                                            f2767V = true;
                                            if (Process.myPid() <= 0) {
                                            }
                                        }
                                        if (!z7 && !z13) {
                                            m1638b(false);
                                        }
                                        C1508f.m1543c(false);
                                        m1490i4 = C1509g.m1490i();
                                        if (!C1494d.m1895e()) {
                                            m1490i4 = true;
                                        }
                                        C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i4);
                                        if (m1490i4 && f2765T != null) {
                                            f2765T.uncaughtException(thread, th);
                                        }
                                        if (C1500b.m1795B() && !z13) {
                                            C1500b.m1755b(C1497g.m1882a());
                                        }
                                        f2767V = true;
                                        if (Process.myPid() <= 0) {
                                            return;
                                        }
                                        Process.killProcess(Process.myPid());
                                        return;
                                    }
                                }
                                z7 = false;
                                if (!z7) {
                                    m1638b(false);
                                }
                                C1508f.m1543c(false);
                                m1490i4 = C1509g.m1490i();
                                if (!C1494d.m1895e()) {
                                }
                                C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i4);
                                if (m1490i4) {
                                    f2765T.uncaughtException(thread, th);
                                }
                                if (C1500b.m1795B()) {
                                    C1500b.m1755b(C1497g.m1882a());
                                }
                                f2767V = true;
                                if (Process.myPid() <= 0) {
                                }
                            } else if (z5) {
                                if (i != 0 && C1500b.f2714d) {
                                    JNIBridge.nativeClientCloseConnection(nativeClientCreateConnection);
                                }
                                if (z) {
                                    try {
                                    } catch (Throwable th19) {
                                        th = th19;
                                        z6 = false;
                                    }
                                    if (C1509g.m1481r() && !z13) {
                                        try {
                                            m1655a(true, false);
                                            z6 = true;
                                        } catch (Throwable th20) {
                                            th = th20;
                                            z6 = true;
                                            C1497g.m1868a(th);
                                            if (!z6) {
                                            }
                                            C1508f.m1543c(false);
                                            m1490i3 = C1509g.m1490i();
                                            if (!C1494d.m1895e()) {
                                            }
                                            C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i3);
                                            if (m1490i3) {
                                            }
                                            if (C1500b.m1795B()) {
                                            }
                                            f2767V = true;
                                            if (Process.myPid() <= 0) {
                                            }
                                        }
                                        if (!z6 && !z13) {
                                            m1638b(false);
                                        }
                                        C1508f.m1543c(false);
                                        m1490i3 = C1509g.m1490i();
                                        if (!C1494d.m1895e()) {
                                            m1490i3 = true;
                                        }
                                        C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i3);
                                        if (m1490i3 && f2765T != null) {
                                            f2765T.uncaughtException(thread, th);
                                        }
                                        if (C1500b.m1795B() && !z13) {
                                            C1500b.m1755b(C1497g.m1882a());
                                        }
                                        f2767V = true;
                                        if (Process.myPid() <= 0) {
                                            return;
                                        }
                                        Process.killProcess(Process.myPid());
                                        return;
                                    }
                                }
                                z6 = false;
                                if (!z6) {
                                    m1638b(false);
                                }
                                C1508f.m1543c(false);
                                m1490i3 = C1509g.m1490i();
                                if (!C1494d.m1895e()) {
                                }
                                C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i3);
                                if (m1490i3) {
                                    f2765T.uncaughtException(thread, th);
                                }
                                if (C1500b.m1795B()) {
                                    C1500b.m1755b(C1497g.m1882a());
                                }
                                f2767V = true;
                                if (Process.myPid() <= 0) {
                                }
                            }
                        }
                        boolean z142 = th instanceof OutOfMemoryError;
                        m1659a(th, str, nativeClientCreateConnection, z142);
                        C1491a.m1920d("DEBUG", "generate java report finished");
                        if (!C1500b.m1785L() && z142 && C1509g.m1489j()) {
                            String name2 = new File(str).getName();
                            String m1514W2 = C1509g.m1514W();
                            file = new File(m1514W2);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            String format2 = String.format(Locale.US, "%s%s.hprof", m1514W2, name2);
                            C1491a.m1920d("DEBUG", "begin dump hprof: " + format2);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            Debug.dumpHprofData(format2);
                            C1491a.m1920d("DEBUG", "end dump hprof, use " + (System.currentTimeMillis() - currentTimeMillis2) + " ms");
                        }
                        if (nativeClientCreateConnection != 0 && C1500b.f2714d) {
                            JNIBridge.nativeClientCloseConnection(nativeClientCreateConnection);
                        }
                        if (z) {
                            try {
                            } catch (Throwable th21) {
                                th3 = th21;
                                z8 = false;
                            }
                            if (C1509g.m1481r() && !z13) {
                                try {
                                    m1655a(true, false);
                                    z8 = true;
                                } catch (Throwable th22) {
                                    th3 = th22;
                                    z8 = true;
                                    C1497g.m1868a(th3);
                                    if (!z8) {
                                    }
                                    C1508f.m1543c(false);
                                    m1490i5 = C1509g.m1490i();
                                    if (!C1494d.m1895e()) {
                                    }
                                    C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i5);
                                    if (m1490i5) {
                                    }
                                    if (C1500b.m1795B()) {
                                    }
                                    f2767V = true;
                                    if (Process.myPid() > 0) {
                                    }
                                }
                                if (!z8 && !z13) {
                                    m1638b(false);
                                }
                                C1508f.m1543c(false);
                                m1490i5 = C1509g.m1490i();
                                if (!C1494d.m1895e()) {
                                    m1490i5 = true;
                                }
                                C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i5);
                                if (m1490i5 && f2765T != null) {
                                    f2765T.uncaughtException(thread, th);
                                }
                                if (C1500b.m1795B() && !z13) {
                                    C1500b.m1755b(C1497g.m1882a());
                                }
                                f2767V = true;
                                if (Process.myPid() > 0) {
                                    return;
                                }
                                Process.killProcess(Process.myPid());
                                return;
                            }
                        }
                        z8 = false;
                        if (!z8) {
                            m1638b(false);
                        }
                        C1508f.m1543c(false);
                        m1490i5 = C1509g.m1490i();
                        if (!C1494d.m1895e()) {
                        }
                        C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i5);
                        if (m1490i5) {
                            f2765T.uncaughtException(thread, th);
                        }
                        if (C1500b.m1795B()) {
                            C1500b.m1755b(C1497g.m1882a());
                        }
                        f2767V = true;
                        if (Process.myPid() > 0) {
                        }
                    }
                } else {
                    C1491a.m1921c("DEBUG", C1494d.m1898b());
                    if (z) {
                        try {
                        } catch (Throwable th23) {
                            th = th23;
                            z11 = false;
                        }
                        if (C1509g.m1481r() && !z13) {
                            try {
                                m1655a(true, false);
                                z11 = true;
                            } catch (Throwable th24) {
                                th = th24;
                                z11 = true;
                                C1497g.m1868a(th);
                                if (!z11) {
                                }
                                C1508f.m1543c(false);
                                m1490i8 = C1509g.m1490i();
                                if (!C1494d.m1895e()) {
                                }
                                C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i8);
                                if (m1490i8) {
                                }
                                if (C1500b.m1795B()) {
                                }
                                f2767V = true;
                                if (Process.myPid() <= 0) {
                                }
                            }
                            if (!z11 && !z13) {
                                m1638b(false);
                            }
                            C1508f.m1543c(false);
                            m1490i8 = C1509g.m1490i();
                            if (!C1494d.m1895e()) {
                                m1490i8 = true;
                            }
                            C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i8);
                            if (m1490i8 && f2765T != null) {
                                f2765T.uncaughtException(thread, th);
                            }
                            if (C1500b.m1795B() && !z13) {
                                C1500b.m1755b(C1497g.m1882a());
                            }
                            f2767V = true;
                            if (Process.myPid() <= 0) {
                                return;
                            }
                            Process.killProcess(Process.myPid());
                            return;
                        }
                    }
                    z11 = false;
                    if (!z11) {
                        m1638b(false);
                    }
                    C1508f.m1543c(false);
                    m1490i8 = C1509g.m1490i();
                    if (!C1494d.m1895e()) {
                    }
                    C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i8);
                    if (m1490i8) {
                        f2765T.uncaughtException(thread, th);
                    }
                    if (C1500b.m1795B()) {
                        C1500b.m1755b(C1497g.m1882a());
                    }
                    f2767V = true;
                    if (Process.myPid() <= 0) {
                    }
                }
            } else {
                C1491a.m1920d("DEBUG", "another thread is generating java report!");
                C1491a.m1920d("DEBUG", "current thread exception is:");
                m1661a(th);
                int i2 = 0;
                while (!f2767V) {
                    Thread.sleep(1000L);
                    i2++;
                    if (i2 >= 4) {
                        break;
                    }
                }
                Process.killProcess(Process.myPid());
                if (z) {
                    try {
                    } catch (Throwable th25) {
                        th = th25;
                        z12 = false;
                    }
                    if (C1509g.m1481r() && !z13) {
                        try {
                            m1655a(true, false);
                            z12 = true;
                        } catch (Throwable th26) {
                            th = th26;
                            z12 = true;
                            C1497g.m1868a(th);
                            if (!z12) {
                            }
                            C1508f.m1543c(false);
                            m1490i9 = C1509g.m1490i();
                            if (!C1494d.m1895e()) {
                            }
                            C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i9);
                            if (m1490i9) {
                            }
                            if (C1500b.m1795B()) {
                            }
                            f2767V = true;
                            if (Process.myPid() <= 0) {
                            }
                        }
                        if (!z12 && !z13) {
                            m1638b(false);
                        }
                        C1508f.m1543c(false);
                        m1490i9 = C1509g.m1490i();
                        if (!C1494d.m1895e()) {
                            m1490i9 = true;
                        }
                        C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i9);
                        if (m1490i9 && f2765T != null) {
                            f2765T.uncaughtException(thread, th);
                        }
                        if (C1500b.m1795B() && !z13) {
                            C1500b.m1755b(C1497g.m1882a());
                        }
                        f2767V = true;
                        if (Process.myPid() <= 0) {
                            return;
                        }
                        Process.killProcess(Process.myPid());
                        return;
                    }
                }
                z12 = false;
                if (!z12) {
                    m1638b(false);
                }
                C1508f.m1543c(false);
                m1490i9 = C1509g.m1490i();
                if (!C1494d.m1895e()) {
                }
                C1491a.m1925a("crashsdk", "Call java default handler: " + m1490i9);
                if (m1490i9) {
                    f2765T.uncaughtException(thread, th);
                }
                if (C1500b.m1795B()) {
                    C1500b.m1755b(C1497g.m1882a());
                }
                f2767V = true;
                if (Process.myPid() <= 0) {
                }
            }
        } catch (Throwable th27) {
            th = th27;
            z2 = false;
            j = 0;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m1662a(thread, th, false);
    }
}

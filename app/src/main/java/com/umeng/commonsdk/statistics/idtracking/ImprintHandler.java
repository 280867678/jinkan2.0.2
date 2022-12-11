package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.analytics.pro.C1563aw;
import com.umeng.analytics.pro.C1572bc;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.AbstractC1803d;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.statistics.proto.C1831d;
import com.umeng.commonsdk.statistics.proto.C1838e;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public class ImprintHandler implements FileLockCallback {

    /* renamed from: a */
    public static final String f4067a = "ImprintHandler";

    /* renamed from: c */
    public static final String f4069c = ".imprint";

    /* renamed from: k */
    public static Context f4074k = null;

    /* renamed from: l */
    public static FileLockUtil f4075l = null;

    /* renamed from: m */
    public static final int f4076m = 0;

    /* renamed from: n */
    public static final int f4077n = 1;

    /* renamed from: e */
    public AbstractC1803d f4080e;

    /* renamed from: h */
    public C1781a f4081h = new C1781a();

    /* renamed from: i */
    public C1831d f4082i = null;

    /* renamed from: b */
    public static Object f4068b = new Object();

    /* renamed from: d */
    public static final byte[] f4070d = "pbl0".getBytes();

    /* renamed from: f */
    public static Map<String, ArrayList<UMImprintChangeCallback>> f4071f = new HashMap();

    /* renamed from: g */
    public static Object f4072g = new Object();

    /* renamed from: j */
    public static ImprintHandler f4073j = null;

    /* renamed from: o */
    public static Map<String, UMImprintPreProcessCallback> f4078o = new HashMap();

    /* renamed from: p */
    public static Object f4079p = new Object();

    /* renamed from: com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a */
    /* loaded from: classes4.dex */
    public static class C1781a {

        /* renamed from: a */
        public Map<String, String> f4083a = new HashMap();

        public C1781a() {
        }

        public C1781a(C1831d c1831d) {
            m469a(c1831d);
        }

        /* renamed from: b */
        private synchronized void m466b(C1831d c1831d) {
            C1838e c1838e;
            if (c1831d != null) {
                if (c1831d.m283e()) {
                    Map<String, C1838e> m286c = c1831d.m286c();
                    for (String str : m286c.keySet()) {
                        if (!TextUtils.isEmpty(str) && (c1838e = m286c.get(str)) != null) {
                            String m255b = c1838e.m255b();
                            if (!TextUtils.isEmpty(m255b)) {
                                this.f4083a.put(str, m255b);
                                boolean z = AnalyticsConstants.UM_DEBUG;
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public synchronized String m467a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.f4083a.size() > 0) {
                String str3 = this.f4083a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }

        /* renamed from: a */
        public void m469a(C1831d c1831d) {
            if (c1831d == null) {
                return;
            }
            m466b(c1831d);
        }

        /* renamed from: a */
        public synchronized void m468a(String str) {
            if (this.f4083a != null && this.f4083a.size() > 0 && !TextUtils.isEmpty(str) && this.f4083a.containsKey(str)) {
                this.f4083a.remove(str);
            }
        }
    }

    public ImprintHandler(Context context) {
        f4074k = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: a */
    private C1831d m484a(C1831d c1831d, C1831d c1831d2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (c1831d2 == null) {
            return c1831d;
        }
        Map<String, C1838e> m286c = c1831d.m286c();
        for (Map.Entry<String, C1838e> entry : c1831d2.m286c().entrySet()) {
            int i = 0;
            if (entry.getValue().m250d()) {
                String key = entry.getKey();
                String str = entry.getValue().f4229a;
                synchronized (f4079p) {
                    if (!TextUtils.isEmpty(key) && f4078o.containsKey(key) && (uMImprintPreProcessCallback = f4078o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i = 1;
                    }
                }
                if (i == 0) {
                    m286c.put(entry.getKey(), entry.getValue());
                    synchronized (f4072g) {
                        if (!TextUtils.isEmpty(key) && f4071f.containsKey(key) && f4071f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (f4072g) {
                    if (!TextUtils.isEmpty(key2) && f4071f.containsKey(key2) && (arrayList = f4071f.get(key2)) != null) {
                        while (i < arrayList.size()) {
                            arrayList.get(i).onImprintValueChanged(key2, null);
                            i++;
                        }
                    }
                }
                m286c.remove(key2);
                this.f4081h.m468a(key2);
            }
        }
        c1831d.m296a(c1831d2.m282f());
        c1831d.m293a(m485a(c1831d));
        return c1831d;
    }

    /* renamed from: a */
    private void m482a(File file) {
        if (this.f4082i == null) {
            return;
        }
        try {
            synchronized (f4068b) {
                byte[] m1216a = new C1572bc().m1216a(this.f4082i);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(m1216a);
                    fileOutputStream.flush();
                } finally {
                    HelperUtils.safeClose(fileOutputStream);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m480a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (f4072g) {
            int i = 0;
            if (f4071f.containsKey(str)) {
                ArrayList<UMImprintChangeCallback> arrayList = f4071f.get(str);
                int size = arrayList.size();
                ULog.m538i("--->>> addCallback: before add: callbacks size is: " + size);
                while (i < size) {
                    if (uMImprintChangeCallback == arrayList.get(i)) {
                        ULog.m538i("--->>> addCallback: callback has exist, just exit");
                        return;
                    }
                    i++;
                }
                arrayList.add(uMImprintChangeCallback);
                ULog.m538i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
            } else {
                ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                int size2 = arrayList2.size();
                ULog.m538i("--->>> addCallback: before add: callbacks size is: " + size2);
                while (i < size2) {
                    if (uMImprintChangeCallback == arrayList2.get(i)) {
                        ULog.m538i("--->>> addCallback: callback has exist, just exit");
                        return;
                    }
                    i++;
                }
                arrayList2.add(uMImprintChangeCallback);
                ULog.m538i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                f4071f.put(str, arrayList2);
            }
        }
    }

    /* renamed from: a */
    private boolean m479a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    /* renamed from: b */
    public static void m476b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        synchronized (f4072g) {
            try {
                if (f4071f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f4071f.get(str);
                    if (arrayList.size() > 0) {
                        int size = arrayList.size();
                        ULog.m538i("--->>> removeCallback: before remove: callbacks size is: " + size);
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                break;
                            } else if (uMImprintChangeCallback == arrayList.get(i)) {
                                ULog.m538i("--->>> removeCallback: remove index " + i);
                                arrayList.remove(i);
                                break;
                            } else {
                                i++;
                            }
                        }
                        ULog.m538i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                        if (arrayList.size() == 0) {
                            ULog.m538i("--->>> removeCallback: remove key from map: key = " + str);
                            f4071f.remove(str);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private boolean m474c(C1831d c1831d) {
        if (!c1831d.m279i().equals(m485a(c1831d))) {
            return false;
        }
        for (C1838e c1838e : c1831d.m286c().values()) {
            byte[] reverseHexString = DataHelper.reverseHexString(c1838e.m246h());
            byte[] m483a = m483a(c1838e);
            for (int i = 0; i < 4; i++) {
                if (reverseHexString[i] != m483a[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: d */
    private C1831d m472d(C1831d c1831d) {
        Map<String, C1838e> m286c = c1831d.m286c();
        if (m286c.containsKey(C1543ak.f3035f)) {
            m286c.remove(C1543ak.f3035f);
            this.f4081h.m468a(C1543ak.f3035f);
            c1831d.m296a(c1831d.m282f());
            c1831d.m293a(m485a(c1831d));
        }
        return c1831d;
    }

    /* renamed from: e */
    private C1831d m470e(C1831d c1831d) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, C1838e> m286c = c1831d.m286c();
        ArrayList arrayList3 = new ArrayList(m286c.size() / 2);
        Iterator<Map.Entry<String, C1838e>> it = m286c.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, C1838e> next = it.next();
            if (!next.getValue().m250d()) {
                arrayList3.add(next.getKey());
            } else {
                String key = next.getKey();
                String str = next.getValue().f4229a;
                synchronized (f4079p) {
                    z = !TextUtils.isEmpty(key) && f4078o.containsKey(key) && (uMImprintPreProcessCallback = f4078o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z) {
                    arrayList3.add(key);
                }
                synchronized (f4072g) {
                    if (!TextUtils.isEmpty(key) && f4071f.containsKey(key) && (arrayList2 = f4071f.get(key)) != null) {
                        for (int i = 0; i < arrayList2.size(); i++) {
                            arrayList2.get(i).onImprintValueChanged(key, str);
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            synchronized (f4072g) {
                if (!TextUtils.isEmpty(str2) && f4071f.containsKey(str2) && (arrayList = f4071f.get(str2)) != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        arrayList.get(i2).onImprintValueChanged(str2, null);
                    }
                }
            }
            m286c.remove(str2);
        }
        return c1831d;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m471e() {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(f4074k.getFilesDir(), f4069c);
        synchronized (f4068b) {
            if (!file.exists()) {
                return;
            }
            byte[] bArr = null;
            try {
                fileInputStream = f4074k.openFileInput(f4069c);
                try {
                    try {
                        bArr = HelperUtils.readStreamToByteArray(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        HelperUtils.safeClose(fileInputStream);
                        if (bArr != null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
            HelperUtils.safeClose(fileInputStream);
            if (bArr != null) {
                try {
                    C1831d c1831d = new C1831d();
                    new C1563aw().m1234a(c1831d, bArr);
                    this.f4082i = c1831d;
                    this.f4081h.m469a(c1831d);
                    this.f4082i = m472d(this.f4082i);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            if (f4073j == null) {
                f4073j = new ImprintHandler(context);
                FileLockUtil fileLockUtil = new FileLockUtil();
                f4075l = fileLockUtil;
                if (fileLockUtil != null) {
                    f4075l.doFileOperateion(new File(f4074k.getFilesDir(), f4069c), f4073j, 0);
                }
            }
            imprintHandler = f4073j;
        }
        return imprintHandler;
    }

    /* renamed from: a */
    public String m485a(C1831d c1831d) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(c1831d.m286c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((C1838e) entry.getValue()).m250d()) {
                sb.append(((C1838e) entry.getValue()).m255b());
            }
            sb.append(((C1838e) entry.getValue()).m249e());
            sb.append(((C1838e) entry.getValue()).m246h());
        }
        sb.append(c1831d.f4211b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    /* renamed from: a */
    public void m486a(AbstractC1803d abstractC1803d) {
        this.f4080e = abstractC1803d;
    }

    /* renamed from: a */
    public void m481a(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (f4079p) {
                try {
                    if (f4078o.containsKey(str)) {
                        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                        f4071f.remove(str);
                    } else {
                        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public byte[] m487a() {
        try {
            synchronized (this) {
                if (this.f4082i == null) {
                    return null;
                }
                if (this.f4082i.m289b() <= 0) {
                    return null;
                }
                return new C1572bc().m1216a(this.f4082i);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f4074k, th);
            return null;
        }
    }

    /* renamed from: a */
    public byte[] m483a(C1838e c1838e) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(c1838e.m249e());
        byte[] array = allocate.array();
        byte[] bArr = f4070d;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (array[i] ^ bArr[i]);
        }
        return bArr2;
    }

    /* renamed from: b */
    public synchronized C1831d m478b() {
        return this.f4082i;
    }

    /* renamed from: b */
    public void m477b(C1831d c1831d) {
        boolean z;
        if (c1831d == null) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return;
            }
            UMRTLog.m768d(UMRTLog.RTLOG_TAG, "Imprint is null");
        } else if (!m474c(c1831d)) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return;
            }
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
        } else {
            boolean z2 = AnalyticsConstants.UM_DEBUG;
            HashMap hashMap = new HashMap();
            synchronized (this) {
                C1831d c1831d2 = this.f4082i;
                C1831d m472d = m472d(c1831d);
                String str = null;
                String m279i = c1831d2 == null ? null : c1831d2.m279i();
                C1831d m470e = c1831d2 == null ? m470e(m472d) : m484a(c1831d2, m472d, hashMap);
                this.f4082i = m470e;
                if (m470e != null) {
                    str = m470e.m279i();
                }
                z = !m479a(m279i, str);
            }
            C1831d c1831d3 = this.f4082i;
            if (c1831d3 != null) {
                boolean z3 = AnalyticsConstants.UM_DEBUG;
                if (z) {
                    this.f4081h.m469a(c1831d3);
                    AbstractC1803d abstractC1803d = this.f4080e;
                    if (abstractC1803d != null) {
                        abstractC1803d.onImprintChanged(this.f4081h);
                    }
                }
            }
            if (hashMap.size() <= 0) {
                return;
            }
            synchronized (f4072g) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    if (!TextUtils.isEmpty(str2) && f4071f.containsKey(str2)) {
                        ULog.m538i("--->>> target imprint key is: " + str2 + "; value is: " + str3);
                        ArrayList<UMImprintChangeCallback> arrayList = f4071f.get(str2);
                        if (arrayList != null) {
                            for (int i = 0; i < arrayList.size(); i++) {
                                arrayList.get(i).onImprintValueChanged(str2, str3);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public C1781a m475c() {
        return this.f4081h;
    }

    /* renamed from: d */
    public void m473d() {
        if (this.f4082i == null || f4075l == null) {
            return;
        }
        File file = new File(f4074k.getFilesDir(), f4069c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    UMCrashManager.reportCrash(f4074k, e);
                }
            } catch (IOException unused) {
                file.createNewFile();
            }
        }
        f4075l.doFileOperateion(file, f4073j, 1);
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i) {
        if (i == 0) {
            f4073j.m471e();
        } else if (i == 1) {
            f4073j.m482a(file);
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        m480a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (f4079p) {
            try {
                if (!f4078o.containsKey(str)) {
                    f4078o.put(str, uMImprintPreProcessCallback);
                    str2 = UMRTLog.RTLOG_TAG;
                    str3 = "--->>> registPreProcessCallback: key : " + str + " regist success.";
                } else {
                    str2 = UMRTLog.RTLOG_TAG;
                    str3 = "--->>> key : " + str + " PreProcesser has registed!";
                }
                UMRTLog.m766i(str2, str3);
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        m476b(str, uMImprintChangeCallback);
    }
}

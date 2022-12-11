package com.tencent.bugly.beta.global;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.AbstractC1087c;
import com.tencent.bugly.beta.download.C1085a;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1234p;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.beta.global.f */
/* loaded from: classes3.dex */
public class C1094f {

    /* renamed from: a */
    public static C1094f f794a = new C1094f();

    /* renamed from: b */
    public List<Runnable> f795b = new ArrayList();

    /* renamed from: c */
    public final Map<String, DownloadTask> f796c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d */
    public Handler f797d = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public void m3607a() {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        for (String str : ResBean.f726b) {
            String m3628a = ResBean.f725a.m3628a(str);
            if (str.startsWith("IMG_") && !TextUtils.isEmpty(m3628a)) {
                arrayList.add(m3628a);
            }
        }
        File[] listFiles = C1093e.f737b.f788u.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            Iterator it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                if (file.getAbsolutePath().equals((String) it.next())) {
                    z = false;
                }
            }
            if (z) {
                C1234p.f1572a.m2873b(file.getAbsolutePath());
                if (!file.delete()) {
                    C1199X.m3081b("cannot deleteCache file:%s", file.getAbsolutePath());
                }
            }
        }
    }

    /* renamed from: a */
    public void m3606a(AbstractC1087c abstractC1087c, Map<String, String> map) {
        ResBean resBean;
        String[] strArr;
        DownloadTask downloadTask;
        if (abstractC1087c == null) {
            return;
        }
        if (map != null && !map.isEmpty()) {
            for (DownloadTask downloadTask2 : this.f796c.values()) {
                downloadTask2.delete(true);
            }
            this.f796c.clear();
            C1085a c1085a = new C1085a(1, this, this.f796c);
            for (String str : ResBean.f726b) {
                if (!map.containsKey(str)) {
                    this.f796c.clear();
                    resBean = new ResBean();
                } else {
                    String str2 = map.get(str);
                    if (!str.startsWith("IMG_") || TextUtils.isEmpty(str2)) {
                        ResBean.f725a.m3627a(str, str2);
                    } else {
                        ResBean.f725a.m3627a(str, "");
                        Iterator<DownloadTask> it = this.f796c.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                downloadTask = null;
                                break;
                            }
                            downloadTask = it.next();
                            if (downloadTask.getDownloadUrl().equals(str2)) {
                                break;
                            }
                        }
                        if (downloadTask == null) {
                            downloadTask = abstractC1087c.mo2863a(str2, C1093e.f737b.f788u.getAbsolutePath(), null, null);
                        }
                        if (downloadTask != null) {
                            downloadTask.addListener(c1085a);
                            downloadTask.setNeededNotify(false);
                            this.f796c.put(str, downloadTask);
                        }
                    }
                }
            }
            C1089a.m3614a("rb.bch", ResBean.f725a);
            if (this.f796c.isEmpty()) {
                return;
            }
            for (DownloadTask downloadTask3 : this.f796c.values()) {
                downloadTask3.download();
            }
            return;
        }
        this.f796c.clear();
        resBean = new ResBean();
        ResBean.f725a = resBean;
        C1089a.m3614a("rb.bch", resBean);
    }

    /* renamed from: a */
    public synchronized void m3605a(Runnable runnable) {
        if (this.f796c.size() == 0) {
            runnable.run();
        } else {
            this.f795b.add(runnable);
        }
    }

    /* renamed from: a */
    public synchronized void m3604a(Runnable runnable, int i) {
        if (this.f796c.size() == 0) {
            runnable.run();
        } else {
            RunnableC1092d runnableC1092d = new RunnableC1092d(6, false, runnable);
            this.f797d.postDelayed(runnableC1092d, i);
            m3605a(runnableC1092d);
        }
    }

    /* renamed from: b */
    public void m3603b() {
        synchronized (this) {
            for (Runnable runnable : this.f795b) {
                runnable.run();
            }
            for (DownloadTask downloadTask : this.f796c.values()) {
                downloadTask.delete(false);
            }
            this.f795b.clear();
            this.f796c.clear();
        }
    }
}

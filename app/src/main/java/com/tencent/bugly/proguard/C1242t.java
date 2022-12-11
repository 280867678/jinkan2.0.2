package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.t */
/* loaded from: classes3.dex */
public class C1242t {
    /* renamed from: a */
    public static synchronized void m2865a(Context context) {
        String str;
        File[] listFiles;
        String m3032a;
        C1177B c1177b;
        synchronized (C1242t.class) {
            C1093e c1093e = C1093e.f737b;
            String absolutePath = context.getDir(TinkerManager.PATCH_DIR, 0).getAbsolutePath();
            String absolutePath2 = context.getDir("tmpPatch", 32768).getAbsolutePath();
            c1093e.f746I = new File(absolutePath, TinkerManager.PATCH_NAME);
            if (TextUtils.isEmpty(C1089a.m3613a("PatchFile", ""))) {
                C1089a.m3610b("PatchFile", c1093e.f746I.getAbsolutePath());
            }
            c1093e.f747J = new File(absolutePath2, "tmpPatch.apk");
            if (c1093e.f746I != null && TextUtils.isEmpty(C1089a.m3613a("PatchFile", ""))) {
                C1089a.m3610b("PatchFile", c1093e.f746I.getAbsolutePath());
            }
            File dir = context.getDir("tmpPatch", 0);
            c1093e.f748K = dir;
            if (dir != null && TextUtils.isEmpty(C1089a.m3613a("PatchTmpDir", ""))) {
                C1089a.m3610b("PatchTmpDir", c1093e.f746I.getAbsolutePath());
            }
            BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) C1089a.m3615a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            if (betaGrayStrategy == null || (c1177b = betaGrayStrategy.f858a) == null || c1177b.f1343u != 3) {
                if (TinkerManager.getInstance().getPatchDirectory(c1093e.f789v) != null && !TinkerManager.getInstance().getPatchDirectory(c1093e.f789v).exists()) {
                    C1089a.m3609b("IS_PATCH_ROLL_BACK", false);
                }
                if (C1089a.m3612a("IS_PATCH_ROLL_BACK", false)) {
                    TinkerManager.getInstance().onPatchRollback(false);
                }
            } else {
                Map<String, String> map = c1177b.f1339q;
                if (map != null) {
                    c1093e.f752O = map.get("H2");
                }
                c1093e.f753P = C1089a.m3612a("PatchResult", false);
                c1093e.f754Q = Integer.valueOf(C1089a.m3613a("PATCH_MAX_TIMES", "0")).intValue();
                if (!c1093e.f753P) {
                    C1199X.m3078c("[patch] inject failure", new Object[0]);
                    if (!C1089a.m3612a("UPLOAD_PATCH_RESULT", false)) {
                        C1089a.m3609b("UPLOAD_PATCH_RESULT", true);
                        C1234p c1234p = C1234p.f1572a;
                        long currentTimeMillis = System.currentTimeMillis();
                        C1177B c1177b2 = betaGrayStrategy.f858a;
                        if (c1234p.m2877a(new C1250z("active", currentTimeMillis, (byte) 1, 0L, null, c1177b2.f1340r, c1177b2.f1343u, null))) {
                            C1199X.m3078c("save patch failed event success!", new Object[0]);
                        } else {
                            C1199X.m3081b("save patch failed event failed!", new Object[0]);
                        }
                    }
                } else {
                    C1199X.m3078c("[patch] inject success", new Object[0]);
                    if (!C1089a.m3612a("UPLOAD_PATCH_RESULT", false)) {
                        C1089a.m3609b("UPLOAD_PATCH_RESULT", true);
                        C1234p c1234p2 = C1234p.f1572a;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C1177B c1177b3 = betaGrayStrategy.f858a;
                        if (c1234p2.m2877a(new C1250z("active", currentTimeMillis2, (byte) 0, 0L, null, c1177b3.f1340r, c1177b3.f1343u, null))) {
                            C1199X.m3078c("save patch success event success!", new Object[0]);
                        } else {
                            C1199X.m3081b("save patch success event failed!", new Object[0]);
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(TinkerManager.getNewTinkerId())) {
                C1199X.m3076e("[patch] tinker new id is null ,so patch version is invalid", new Object[0]);
                c1093e.f752O = "";
            }
            C1208ca.m3005c("G15", c1093e.f752O);
            File file = C1093e.f737b.f747J;
            if (file != null && file.exists() && file.delete()) {
                C1199X.m3078c("[patch] delete tmpPatch.apk success", new Object[0]);
            }
            File file2 = C1093e.f737b.f746I;
            if (file2 != null && file2.exists() && (m3032a = C1208ca.m3032a(file2, "SHA")) != null) {
                C1093e.f737b.f751N = m3032a;
            }
            if (TinkerManager.isTinkerManagerInstalled()) {
                if (TextUtils.isEmpty(c1093e.f749L)) {
                    c1093e.f749L = TinkerManager.getTinkerId();
                }
                C1199X.m3078c("TINKER_ID:" + c1093e.f749L, new Object[0]);
                c1093e.f750M = TinkerManager.getNewTinkerId();
                C1199X.m3078c("NEW_TINKER_ID:" + c1093e.f750M, new Object[0]);
                TinkerManager.getInstance().setTinkerListener(new C1240s(c1093e));
            }
            if (TextUtils.isEmpty(C1089a.m3613a("BaseArchName", "")) && (str = c1093e.f789v.getApplicationInfo().nativeLibraryDir) != null && (listFiles = new File(str).listFiles()) != null && listFiles.length > 0) {
                boolean z = false;
                for (File file3 : listFiles) {
                    if (file3.getName().endsWith(".so")) {
                        String replace = file3.getName().replace(".so", "");
                        if (replace.startsWith("lib")) {
                            replace = replace.substring(replace.indexOf("lib") + 3);
                        }
                        C1199X.m3078c("libName:" + replace, new Object[0]);
                        String absolutePath3 = file3.getAbsolutePath();
                        C1199X.m3078c("soFilePath:" + absolutePath3, new Object[0]);
                        Iterator<String> it = c1093e.f767ca.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (replace.equals(it.next())) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            String m3611b = C1089a.m3611b(absolutePath3);
                            C1199X.m3078c("archName:" + m3611b, new Object[0]);
                            if (m3611b != null && m3611b.equals("armeabi-v5te")) {
                                m3611b = "armeabi";
                            }
                            C1089a.m3610b(replace, m3611b);
                            if (TextUtils.isEmpty(C1089a.m3613a("BaseArchName", ""))) {
                                C1089a.m3610b("BaseArchName", m3611b);
                            }
                            z = false;
                        }
                    }
                }
            }
        }
    }
}

package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import androidx.multidex.MultiDexExtractor;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.io.FileFilter;
import me.tvspark.outline;

/* renamed from: com.tencent.smtt.utils.m */
/* loaded from: classes4.dex */
public class C1465m {
    /* renamed from: a */
    public static boolean m2023a(Context context) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return m2021b(context);
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m2022a(File file) {
        try {
            return !C1443e.m2085b(file);
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("isOatFileBroken exception: ", th);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m2021b(Context context) {
        File m2020c;
        File[] listFiles;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (Build.VERSION.SDK_INT <= 25 && (m2020c = m2020c(context)) != null) {
            for (File file : m2020c.listFiles(new FileFilter() { // from class: com.tencent.smtt.utils.m.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    String name = file2.getName();
                    return !TextUtils.isEmpty(name) && name.endsWith(MultiDexExtractor.DEX_SUFFIX);
                }
            })) {
                if (file.isFile() && file.exists()) {
                    if (m2022a(file)) {
                        TbsLog.m2148w("TbsCheckUtils", "" + file + " is invalid --> check failed!");
                        file.delete();
                        return false;
                    }
                    TbsLog.m2155i("TbsCheckUtils", "" + file + " #4 check success!");
                }
            }
            TbsLog.m2155i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
            return true;
        }
        return true;
    }

    /* renamed from: c */
    public static File m2020c(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share");
        if (!file.isDirectory() || !file.exists()) {
            return null;
        }
        return file;
    }
}

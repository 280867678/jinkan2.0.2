package com.lzf.easyfloat.permission.rom;

import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.C1543ak;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.nk0;

@ef0
/* loaded from: classes3.dex */
public final class RomUtils {
    public static final RomUtils INSTANCE = new RomUtils();
    public static final String TAG = "RomUtils--->";

    public static final double getEmuiVersion() {
        try {
            String systemProperty = getSystemProperty(com.just.agentweb.RomUtils.VERSION_PROPERTY_HUAWEI);
            if (systemProperty == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) systemProperty, "_", 0, false, 6) + 1;
            if (systemProperty == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = systemProperty.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.String).substring(startIndex)");
            return Double.parseDouble(substring);
        } catch (Exception e) {
            e.printStackTrace();
            return 4.0d;
        }
    }

    public static final String getSystemProperty(String str) {
        BufferedReader bufferedReader;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "propName");
        BufferedReader bufferedReader2 = null;
        try {
            Process exec = Runtime.getRuntime().exec("getprop " + str);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) exec, C1543ak.f3013ax);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) readLine, "input.readLine()");
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (IOException unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean checkIs360Rom() {
        String str = Build.MANUFACTURER;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, "Build.MANUFACTURER");
        if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, (CharSequence) "QiKU", false, 2)) {
            String str2 = Build.MANUFACTURER;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str2, "Build.MANUFACTURER");
            if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str2, (CharSequence) "360", false, 2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean checkIsHuaweiRom() {
        String str = Build.MANUFACTURER;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, "Build.MANUFACTURER");
        return nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, (CharSequence) "HUAWEI", false, 2);
    }

    public final boolean checkIsMeizuRom() {
        String systemProperty = getSystemProperty("ro.build.display.id");
        if (TextUtils.isEmpty(systemProperty)) {
            return false;
        }
        if (systemProperty == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) systemProperty, (CharSequence) "flyme", false, 2)) {
            String lowerCase = systemProperty.toLowerCase();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) lowerCase, (CharSequence) "flyme", false, 2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean checkIsMiuiRom() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"));
    }

    public final boolean checkIsOppoRom() {
        String str = Build.MANUFACTURER;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, "Build.MANUFACTURER");
        if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, (CharSequence) "OPPO", false, 2)) {
            String str2 = Build.MANUFACTURER;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str2, "Build.MANUFACTURER");
            if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str2, (CharSequence) "oppo", false, 2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean checkIsVivoRom() {
        String str = Build.MANUFACTURER;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, "Build.MANUFACTURER");
        if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, (CharSequence) "VIVO", false, 2)) {
            String str2 = Build.MANUFACTURER;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str2, "Build.MANUFACTURER");
            if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str2, (CharSequence) "vivo", false, 2)) {
                return false;
            }
        }
        return true;
    }

    public final int getMiuiVersion() {
        String systemProperty = getSystemProperty("ro.miui.ui.version.name");
        if (systemProperty != null) {
            try {
                String substring = systemProperty.substring(1);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.String).substring(startIndex)");
                return Integer.parseInt(substring);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }
}

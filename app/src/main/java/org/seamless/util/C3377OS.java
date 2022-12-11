package org.seamless.util;

import com.umeng.commonsdk.statistics.idtracking.C1789g;

/* renamed from: org.seamless.util.OS */
/* loaded from: classes5.dex */
public class C3377OS {
    public static boolean checkForHp() {
        return checkForPresence("os.name", "hp");
    }

    public static boolean checkForLinux() {
        return checkForPresence("os.name", "linux");
    }

    public static boolean checkForMac() {
        return checkForPresence("os.name", C1789g.f4109a);
    }

    public static boolean checkForPresence(String str, String str2) {
        try {
            String property = System.getProperty(str);
            if (property == null) {
                return false;
            }
            return property.trim().toLowerCase().startsWith(str2);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean checkForSolaris() {
        return checkForPresence("os.name", "sun");
    }

    public static boolean checkForWindows() {
        return checkForPresence("os.name", "win");
    }
}

package org.fourthline.cling.model;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import me.tvspark.outline;
import org.simpleframework.xml.stream.DocumentReader;

/* loaded from: classes5.dex */
public class ModelUtil {
    public static final boolean ANDROID_EMULATOR;
    public static final boolean ANDROID_RUNTIME;

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|2|3|(8:5|6|7|8|(2:10|(1:12))|14|15|16)|19|6|7|8|(0)|14|15|16) */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0042 A[Catch: Exception -> 0x004d, TRY_LEAVE, TryCatch #1 {Exception -> 0x004d, blocks: (B:8:0x0022, B:10:0x0042), top: B:7:0x0022 }] */
    static {
        boolean z;
        String str;
        boolean z2 = true;
        boolean z3 = false;
        if (Thread.currentThread().getContextClassLoader().loadClass("android.os.Build").getField("ID").get(null) != null) {
            z = true;
            ANDROID_RUNTIME = z;
            str = (String) Thread.currentThread().getContextClassLoader().loadClass("android.os.Build").getField("PRODUCT").get(null);
            if (!"google_sdk".equals(str)) {
                if (!"sdk".equals(str)) {
                    z2 = false;
                }
            }
            z3 = z2;
            ANDROID_EMULATOR = z3;
        }
        z = false;
        ANDROID_RUNTIME = z;
        str = (String) Thread.currentThread().getContextClassLoader().loadClass("android.os.Build").getField("PRODUCT").get(null);
        if (!"google_sdk".equals(str)) {
        }
        z3 = z2;
        ANDROID_EMULATOR = z3;
    }

    public static String commaToNewline(String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split(",")) {
            sb.append(str2);
            sb.append(",");
            sb.append("\n");
        }
        if (sb.length() > 2) {
            sb.deleteCharAt(sb.length() - 2);
        }
        return sb.toString();
    }

    public static String[] fromCommaSeparatedList(String str) {
        return fromCommaSeparatedList(str, true);
    }

    public static String[] fromCommaSeparatedList(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (z) {
            str = str.replaceAll("\\\\,", "XXX1122334455XXX");
        }
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].replaceAll("XXX1122334455XXX", ",");
            split[i] = split[i].replaceAll("\\\\\\\\", "\\\\");
        }
        return split;
    }

    public static long fromTimeString(String str) {
        if (str.lastIndexOf(".") != -1) {
            str = str.substring(0, str.lastIndexOf("."));
        }
        String[] split = str.split(":");
        if (split.length == 3) {
            long parseLong = Long.parseLong(split[1]) * 60;
            return Long.parseLong(split[2]) + parseLong + (Long.parseLong(split[0]) * 3600);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse time string: ", str));
    }

    public static byte[] getFirstNetworkInterfaceHardwareAddress() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.isLoopback() && networkInterface.isUp() && networkInterface.getHardwareAddress() != null) {
                    return networkInterface.getHardwareAddress();
                }
            }
            throw new RuntimeException("Could not discover first network interface hardware address");
        } catch (Exception unused) {
            throw new RuntimeException("Could not discover first network interface hardware address");
        }
    }

    public static InetAddress getInetAddressByName(String str) {
        try {
            return InetAddress.getByName(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getLocalHostName(boolean z) {
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            return (!z && hostName.indexOf(".") != -1) ? hostName.substring(0, hostName.indexOf(".")) : hostName;
        } catch (Exception unused) {
            return "UNKNOWN HOST";
        }
    }

    public static boolean isStringConvertibleType(Set<Class> set, Class cls) {
        if (cls.isEnum()) {
            return true;
        }
        for (Class cls2 : set) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidUDAName(String str) {
        return ANDROID_RUNTIME ? (str == null || str.length() == 0) ? false : true : str != null && str.length() != 0 && !str.toLowerCase(Locale.ROOT).startsWith(DocumentReader.RESERVED) && str.matches(Constants.REGEX_UDA_NAME);
    }

    public static String toCommaSeparatedList(Object[] objArr) {
        return toCommaSeparatedList(objArr, true, false);
    }

    public static String toCommaSeparatedList(Object[] objArr, boolean z, boolean z2) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            String replaceAll = obj.toString().replaceAll("\\\\", "\\\\\\\\");
            if (z) {
                replaceAll = replaceAll.replaceAll(",", "\\\\,");
            }
            if (z2) {
                replaceAll = replaceAll.replaceAll("\"", "\\\"");
            }
            sb.append(replaceAll);
            sb.append(",");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String toTimeString(long j) {
        long j2 = j / 3600;
        long j3 = j % 3600;
        long j4 = j3 / 60;
        long j5 = j3 % 60;
        StringBuilder sb = new StringBuilder();
        String str = "0";
        sb.append(j2 < 10 ? str : "");
        sb.append(j2);
        sb.append(":");
        sb.append(j4 < 10 ? str : "");
        sb.append(j4);
        sb.append(":");
        if (j5 >= 10) {
            str = "";
        }
        sb.append(str);
        sb.append(j5);
        return sb.toString();
    }
}

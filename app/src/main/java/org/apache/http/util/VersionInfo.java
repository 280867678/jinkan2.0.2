package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes4.dex */
public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";
    public final String infoClassloader;
    public final String infoModule;
    public final String infoPackage;
    public final String infoRelease;
    public final String infoTimestamp;

    public VersionInfo(String str, String str2, String str3, String str4, String str5) {
        Args.notNull(str, "Package identifier");
        this.infoPackage = str;
        this.infoModule = str2 == null ? UNAVAILABLE : str2;
        this.infoRelease = str3 == null ? UNAVAILABLE : str3;
        this.infoTimestamp = str4 == null ? UNAVAILABLE : str4;
        this.infoClassloader = str5 == null ? UNAVAILABLE : str5;
    }

    public static VersionInfo fromMap(String str, Map<?, ?> map, ClassLoader classLoader) {
        String str2;
        String str3;
        String str4;
        Args.notNull(str, "Package identifier");
        String str5 = null;
        if (map != null) {
            String str6 = (String) map.get(PROPERTY_MODULE);
            if (str6 != null && str6.length() < 1) {
                str6 = null;
            }
            String str7 = (String) map.get(PROPERTY_RELEASE);
            if (str7 != null && (str7.length() < 1 || str7.equals("${pom.version}"))) {
                str7 = null;
            }
            String str8 = (String) map.get(PROPERTY_TIMESTAMP);
            str4 = (str8 == null || (str8.length() >= 1 && !str8.equals("${mvn.timestamp}"))) ? str8 : null;
            str2 = str6;
            str3 = str7;
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        if (classLoader != null) {
            str5 = classLoader.toString();
        }
        return new VersionInfo(str, str2, str3, str4, str5);
    }

    public static String getUserAgent(String str, String str2, Class<?> cls) {
        VersionInfo loadVersionInfo = loadVersionInfo(str2, cls.getClassLoader());
        return String.format("%s/%s (Java/%s)", str, loadVersionInfo != null ? loadVersionInfo.getRelease() : UNAVAILABLE, System.getProperty("java.version"));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static VersionInfo loadVersionInfo(String str, ClassLoader classLoader) {
        Properties properties;
        InputStream resourceAsStream;
        Args.notNull(str, "Package identifier");
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            resourceAsStream = classLoader.getResourceAsStream(str.replace('.', '/') + "/" + VERSION_PROPERTY_FILE);
        } catch (IOException unused) {
        }
        if (resourceAsStream != null) {
            properties = new Properties();
            properties.load(resourceAsStream);
            try {
                resourceAsStream.close();
            } catch (IOException unused2) {
            }
            if (properties != null) {
                return null;
            }
            return fromMap(str, properties, classLoader);
        }
        properties = null;
        if (properties != null) {
        }
    }

    public static VersionInfo[] loadVersionInfo(String[] strArr, ClassLoader classLoader) {
        Args.notNull(strArr, "Package identifier array");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            VersionInfo loadVersionInfo = loadVersionInfo(str, classLoader);
            if (loadVersionInfo != null) {
                arrayList.add(loadVersionInfo);
            }
        }
        return (VersionInfo[]) arrayList.toArray(new VersionInfo[arrayList.size()]);
    }

    public final String getClassloader() {
        return this.infoClassloader;
    }

    public final String getModule() {
        return this.infoModule;
    }

    public final String getPackage() {
        return this.infoPackage;
    }

    public final String getRelease() {
        return this.infoRelease;
    }

    public final String getTimestamp() {
        return this.infoTimestamp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.infoClassloader.length() + this.infoTimestamp.length() + this.infoRelease.length() + this.infoModule.length() + this.infoPackage.length() + 20);
        sb.append("VersionInfo(");
        sb.append(this.infoPackage);
        sb.append(':');
        sb.append(this.infoModule);
        if (!UNAVAILABLE.equals(this.infoRelease)) {
            sb.append(':');
            sb.append(this.infoRelease);
        }
        if (!UNAVAILABLE.equals(this.infoTimestamp)) {
            sb.append(':');
            sb.append(this.infoTimestamp);
        }
        sb.append(')');
        if (!UNAVAILABLE.equals(this.infoClassloader)) {
            sb.append('@');
            sb.append(this.infoClassloader);
        }
        return sb.toString();
    }
}

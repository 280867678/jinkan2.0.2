package org.apache.commons.lang3;

import com.arialyy.aria.core.common.FtpOption;
import java.io.File;
import java.io.PrintStream;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public class SystemUtils {
    public static final boolean IS_JAVA_1_1;
    public static final boolean IS_JAVA_1_2;
    public static final boolean IS_JAVA_1_3;
    public static final boolean IS_JAVA_1_4;
    public static final boolean IS_JAVA_1_5;
    public static final boolean IS_JAVA_1_6;
    public static final boolean IS_JAVA_1_7;
    public static final boolean IS_JAVA_1_8;
    public static final boolean IS_OS_400;
    public static final boolean IS_OS_AIX;
    public static final boolean IS_OS_FREE_BSD;
    public static final boolean IS_OS_HP_UX;
    public static final boolean IS_OS_IRIX;
    public static final boolean IS_OS_LINUX;
    public static final boolean IS_OS_MAC;
    public static final boolean IS_OS_MAC_OSX;
    public static final boolean IS_OS_NET_BSD;
    public static final boolean IS_OS_OPEN_BSD;
    public static final boolean IS_OS_OS2;
    public static final boolean IS_OS_SOLARIS;
    public static final boolean IS_OS_SUN_OS;
    public static final boolean IS_OS_UNIX;
    public static final boolean IS_OS_WINDOWS;
    public static final boolean IS_OS_WINDOWS_2000;
    public static final boolean IS_OS_WINDOWS_2003;
    public static final boolean IS_OS_WINDOWS_2008;
    public static final boolean IS_OS_WINDOWS_7;
    public static final boolean IS_OS_WINDOWS_8;
    public static final boolean IS_OS_WINDOWS_95;
    public static final boolean IS_OS_WINDOWS_98;
    public static final boolean IS_OS_WINDOWS_ME;
    public static final boolean IS_OS_WINDOWS_NT;
    public static final boolean IS_OS_WINDOWS_VISTA;
    public static final boolean IS_OS_WINDOWS_XP;
    public static final String JAVA_SPECIFICATION_VERSION;
    public static final JavaVersion JAVA_SPECIFICATION_VERSION_AS_ENUM;
    public static final String OS_NAME_WINDOWS_PREFIX = "Windows";
    public static final String USER_COUNTRY;
    public static final String USER_DIR;
    public static final String USER_DIR_KEY = "user.dir";
    public static final String USER_HOME;
    public static final String USER_HOME_KEY = "user.home";
    public static final String USER_LANGUAGE;
    public static final String USER_NAME;
    public static final String USER_TIMEZONE;
    public static final String AWT_TOOLKIT = getSystemProperty("awt.toolkit");
    public static final String FILE_ENCODING = getSystemProperty("file.encoding");
    public static final String FILE_SEPARATOR = getSystemProperty("file.separator");
    public static final String JAVA_AWT_FONTS = getSystemProperty("java.awt.fonts");
    public static final String JAVA_AWT_GRAPHICSENV = getSystemProperty("java.awt.graphicsenv");
    public static final String JAVA_AWT_HEADLESS = getSystemProperty("java.awt.headless");
    public static final String JAVA_AWT_PRINTERJOB = getSystemProperty("java.awt.printerjob");
    public static final String JAVA_CLASS_PATH = getSystemProperty("java.class.path");
    public static final String JAVA_CLASS_VERSION = getSystemProperty("java.class.version");
    public static final String JAVA_COMPILER = getSystemProperty("java.compiler");
    public static final String JAVA_ENDORSED_DIRS = getSystemProperty("java.endorsed.dirs");
    public static final String JAVA_EXT_DIRS = getSystemProperty("java.ext.dirs");
    public static final String JAVA_HOME_KEY = "java.home";
    public static final String JAVA_HOME = getSystemProperty(JAVA_HOME_KEY);
    public static final String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";
    public static final String JAVA_IO_TMPDIR = getSystemProperty(JAVA_IO_TMPDIR_KEY);
    public static final String JAVA_LIBRARY_PATH = getSystemProperty("java.library.path");
    public static final String JAVA_RUNTIME_NAME = getSystemProperty("java.runtime.name");
    public static final String JAVA_RUNTIME_VERSION = getSystemProperty("java.runtime.version");
    public static final String JAVA_SPECIFICATION_NAME = getSystemProperty("java.specification.name");
    public static final String JAVA_SPECIFICATION_VENDOR = getSystemProperty("java.specification.vendor");
    public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY = getSystemProperty("java.util.prefs.PreferencesFactory");
    public static final String JAVA_VENDOR = getSystemProperty("java.vendor");
    public static final String JAVA_VENDOR_URL = getSystemProperty(LoggerFactory.JAVA_VENDOR_PROPERTY);
    public static final String JAVA_VERSION = getSystemProperty("java.version");
    public static final String JAVA_VM_INFO = getSystemProperty("java.vm.info");
    public static final String JAVA_VM_NAME = getSystemProperty("java.vm.name");
    public static final String JAVA_VM_SPECIFICATION_NAME = getSystemProperty("java.vm.specification.name");
    public static final String JAVA_VM_SPECIFICATION_VENDOR = getSystemProperty("java.vm.specification.vendor");
    public static final String JAVA_VM_SPECIFICATION_VERSION = getSystemProperty("java.vm.specification.version");
    public static final String JAVA_VM_VENDOR = getSystemProperty("java.vm.vendor");
    public static final String JAVA_VM_VERSION = getSystemProperty("java.vm.version");
    public static final String LINE_SEPARATOR = getSystemProperty("line.separator");
    public static final String OS_ARCH = getSystemProperty("os.arch");
    public static final String OS_NAME = getSystemProperty("os.name");
    public static final String OS_VERSION = getSystemProperty("os.version");
    public static final String PATH_SEPARATOR = getSystemProperty("path.separator");

    static {
        String systemProperty = getSystemProperty("java.specification.version");
        JAVA_SPECIFICATION_VERSION = systemProperty;
        JAVA_SPECIFICATION_VERSION_AS_ENUM = JavaVersion.get(systemProperty);
        String str = "user.country";
        if (getSystemProperty(str) == null) {
            str = "user.region";
        }
        USER_COUNTRY = getSystemProperty(str);
        USER_DIR = getSystemProperty(USER_DIR_KEY);
        USER_HOME = getSystemProperty(USER_HOME_KEY);
        USER_LANGUAGE = getSystemProperty("user.language");
        USER_NAME = getSystemProperty("user.name");
        USER_TIMEZONE = getSystemProperty("user.timezone");
        IS_JAVA_1_1 = getJavaVersionMatches("1.1");
        IS_JAVA_1_2 = getJavaVersionMatches("1.2");
        IS_JAVA_1_3 = getJavaVersionMatches("1.3");
        IS_JAVA_1_4 = getJavaVersionMatches("1.4");
        IS_JAVA_1_5 = getJavaVersionMatches("1.5");
        IS_JAVA_1_6 = getJavaVersionMatches("1.6");
        IS_JAVA_1_7 = getJavaVersionMatches("1.7");
        IS_JAVA_1_8 = getJavaVersionMatches("1.8");
        IS_OS_AIX = getOSMatchesName("AIX");
        IS_OS_HP_UX = getOSMatchesName("HP-UX");
        IS_OS_400 = getOSMatchesName(FtpOption.FTPServerIdentifier.SYST_OS400);
        IS_OS_IRIX = getOSMatchesName("Irix");
        boolean z = false;
        IS_OS_LINUX = getOSMatchesName("Linux") || getOSMatchesName("LINUX");
        IS_OS_MAC = getOSMatchesName("Mac");
        IS_OS_MAC_OSX = getOSMatchesName("Mac OS X");
        IS_OS_FREE_BSD = getOSMatchesName("FreeBSD");
        IS_OS_OPEN_BSD = getOSMatchesName("OpenBSD");
        IS_OS_NET_BSD = getOSMatchesName("NetBSD");
        IS_OS_OS2 = getOSMatchesName(FtpOption.FTPServerIdentifier.SYST_OS2);
        IS_OS_SOLARIS = getOSMatchesName("Solaris");
        boolean oSMatchesName = getOSMatchesName("SunOS");
        IS_OS_SUN_OS = oSMatchesName;
        if (IS_OS_AIX || IS_OS_HP_UX || IS_OS_IRIX || IS_OS_LINUX || IS_OS_MAC_OSX || IS_OS_SOLARIS || oSMatchesName || IS_OS_FREE_BSD || IS_OS_OPEN_BSD || IS_OS_NET_BSD) {
            z = true;
        }
        IS_OS_UNIX = z;
        IS_OS_WINDOWS = getOSMatchesName(OS_NAME_WINDOWS_PREFIX);
        IS_OS_WINDOWS_2000 = getOSMatches(OS_NAME_WINDOWS_PREFIX, "5.0");
        IS_OS_WINDOWS_2003 = getOSMatches(OS_NAME_WINDOWS_PREFIX, "5.2");
        IS_OS_WINDOWS_2008 = getOSMatches("Windows Server 2008", "6.1");
        IS_OS_WINDOWS_95 = getOSMatches("Windows 9", "4.0");
        IS_OS_WINDOWS_98 = getOSMatches("Windows 9", "4.1");
        IS_OS_WINDOWS_ME = getOSMatches(OS_NAME_WINDOWS_PREFIX, "4.9");
        IS_OS_WINDOWS_NT = getOSMatchesName("Windows NT");
        IS_OS_WINDOWS_XP = getOSMatches(OS_NAME_WINDOWS_PREFIX, "5.1");
        IS_OS_WINDOWS_VISTA = getOSMatches(OS_NAME_WINDOWS_PREFIX, "6.0");
        IS_OS_WINDOWS_7 = getOSMatches(OS_NAME_WINDOWS_PREFIX, "6.1");
        IS_OS_WINDOWS_8 = getOSMatches(OS_NAME_WINDOWS_PREFIX, "6.2");
    }

    public static File getJavaHome() {
        return new File(System.getProperty(JAVA_HOME_KEY));
    }

    public static File getJavaIoTmpDir() {
        return new File(System.getProperty(JAVA_IO_TMPDIR_KEY));
    }

    public static boolean getJavaVersionMatches(String str) {
        return isJavaVersionMatch(JAVA_SPECIFICATION_VERSION, str);
    }

    public static boolean getOSMatches(String str, String str2) {
        return isOSMatch(OS_NAME, OS_VERSION, str, str2);
    }

    public static boolean getOSMatchesName(String str) {
        return isOSNameMatch(OS_NAME, str);
    }

    public static String getSystemProperty(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            PrintStream printStream = System.err;
            printStream.println("Caught a SecurityException reading the system property '" + str + "'; the SystemUtils property value will default to null.");
            return null;
        }
    }

    public static File getUserDir() {
        return new File(System.getProperty(USER_DIR_KEY));
    }

    public static File getUserHome() {
        return new File(System.getProperty(USER_HOME_KEY));
    }

    public static boolean isJavaAwtHeadless() {
        String str = JAVA_AWT_HEADLESS;
        if (str != null) {
            return str.equals(Boolean.TRUE.toString());
        }
        return false;
    }

    public static boolean isJavaVersionAtLeast(JavaVersion javaVersion) {
        return JAVA_SPECIFICATION_VERSION_AS_ENUM.atLeast(javaVersion);
    }

    public static boolean isJavaVersionMatch(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    public static boolean isOSMatch(String str, String str2, String str3, String str4) {
        return str != null && str2 != null && str.startsWith(str3) && str2.startsWith(str4);
    }

    public static boolean isOSNameMatch(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }
}

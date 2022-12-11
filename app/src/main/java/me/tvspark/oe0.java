package me.tvspark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;
import javax.xml.stream.FactoryConfigurationError;
import org.apache.commons.lang3.SystemUtils;

/* loaded from: classes4.dex */
public class oe0 {
    public static /* synthetic */ Class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public abstract ClassLoader Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    static {
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = System.getProperty("xml.stream.debug") != null;
        } catch (Exception unused) {
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("STREAM: ");
            stringBuffer.append(str);
            printStream.println(stringBuffer.toString());
        }
    }

    public static /* synthetic */ Class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, ClassLoader classLoader) throws FactoryConfigurationError {
        try {
            return (classLoader == null ? Class.forName(str) : classLoader.loadClass(str)).newInstance();
        } catch (ClassNotFoundException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Provider ");
            stringBuffer.append(str);
            stringBuffer.append(" not found");
            throw new FactoryConfigurationError(stringBuffer.toString(), e);
        } catch (Exception e2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Provider ");
            stringBuffer2.append(str);
            stringBuffer2.append(" could not be instantiated: ");
            stringBuffer2.append(e2);
            throw new FactoryConfigurationError(stringBuffer2.toString(), e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0041, code lost:
        if (r1 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x004f, code lost:
        r0 = r1.getClassLoader();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0049, code lost:
        r1 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("javax.xml.stream.FactoryFinder");
        me.tvspark.oe0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0047, code lost:
        if (r1 != null) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) throws FactoryConfigurationError {
        Class cls;
        ClassLoader classLoader;
        Class cls2;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                cls2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("javax.xml.stream.FactoryFinder");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls2;
            } else {
                cls2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            stringBuffer.append(cls2.getName());
            stringBuffer.append("$ClassLoaderFinderConcrete");
            classLoader = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Class.forName(stringBuffer.toString()).newInstance()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } catch (ClassNotFoundException unused) {
            cls = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } catch (Exception e) {
            throw new FactoryConfigurationError(e.toString(), e);
        } catch (LinkageError unused2) {
            cls = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        try {
            String property = System.getProperty(str);
            if (property != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("found system property");
                stringBuffer2.append(property);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringBuffer2.toString());
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(property, classLoader);
            }
        } catch (SecurityException unused3) {
        }
        try {
            String property2 = System.getProperty(SystemUtils.JAVA_HOME_KEY);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(property2);
            stringBuffer3.append(File.separator);
            stringBuffer3.append("lib");
            stringBuffer3.append(File.separator);
            stringBuffer3.append("jaxp.properties");
            File file = new File(stringBuffer3.toString());
            if (file.exists()) {
                Properties properties = new Properties();
                properties.load(new FileInputStream(file));
                String property3 = properties.getProperty(str);
                if (property3 != null && property3.length() > 0) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("found java.home property ");
                    stringBuffer4.append(property3);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringBuffer4.toString());
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(property3, classLoader);
                }
            }
        } catch (Exception e2) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                e2.printStackTrace();
            }
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("META-INF/services/");
        stringBuffer5.append(str);
        String stringBuffer6 = stringBuffer5.toString();
        try {
            InputStream systemResourceAsStream = classLoader == null ? ClassLoader.getSystemResourceAsStream(stringBuffer6) : classLoader.getResourceAsStream(stringBuffer6);
            if (systemResourceAsStream != null) {
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append("found ");
                stringBuffer7.append(stringBuffer6);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringBuffer7.toString());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(systemResourceAsStream, "UTF-8"));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                if (readLine != null && !"".equals(readLine)) {
                    StringBuffer stringBuffer8 = new StringBuffer();
                    stringBuffer8.append("loaded from services: ");
                    stringBuffer8.append(readLine);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringBuffer8.toString());
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readLine, classLoader);
                }
            }
        } catch (Exception e3) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                e3.printStackTrace();
            }
        }
        if (str2 != null) {
            StringBuffer stringBuffer9 = new StringBuffer();
            stringBuffer9.append("loaded from fallback value: ");
            stringBuffer9.append(str2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringBuffer9.toString());
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, classLoader);
        }
        StringBuffer stringBuffer10 = new StringBuffer();
        stringBuffer10.append("Provider for ");
        stringBuffer10.append(str);
        stringBuffer10.append(" cannot be found");
        throw new FactoryConfigurationError(stringBuffer10.toString(), (Exception) null);
    }
}

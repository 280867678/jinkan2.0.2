package org.eclipse.jetty.util.log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.Loader;

/* loaded from: classes5.dex */
public class Log {
    public static final String EXCEPTION = "EXCEPTION ";
    public static final String IGNORED = "IGNORED ";
    public static Logger LOG;
    public static boolean __ignored;
    public static boolean __initialized;
    public static String __logClass;
    public static final ConcurrentMap<String, Logger> __loggers = new ConcurrentHashMap();
    public static Properties __props = new Properties();

    static {
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.eclipse.jetty.util.log.Log.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0050  */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v11 */
            /* JADX WARN: Type inference failed for: r2v12 */
            /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
            @Override // java.security.PrivilegedAction
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Object run() {
                InputStream inputStream;
                Enumeration<?> propertyNames;
                ?? r2 = 1;
                URL resource = Loader.getResource(Log.class, "jetty-logging.properties", true);
                InputStream inputStream2 = null;
                try {
                    if (resource != null) {
                        try {
                            inputStream = resource.openStream();
                            try {
                                Log.__props.load(inputStream);
                                r2 = inputStream;
                            } catch (IOException e) {
                                e = e;
                                System.err.println("Unable to load " + resource);
                                e.printStackTrace(System.err);
                                r2 = inputStream;
                                C3009IO.close((InputStream) r2);
                                propertyNames = System.getProperties().propertyNames();
                                while (propertyNames.hasMoreElements()) {
                                }
                                Log.__logClass = Log.__props.getProperty("org.eclipse.jetty.util.log.class", "org.eclipse.jetty.util.log.Slf4jLog");
                                Log.__ignored = Boolean.parseBoolean(Log.__props.getProperty("org.eclipse.jetty.util.log.IGNORED", "false"));
                                return null;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            inputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            C3009IO.close(inputStream2);
                            throw th;
                        }
                        C3009IO.close((InputStream) r2);
                    }
                    propertyNames = System.getProperties().propertyNames();
                    while (propertyNames.hasMoreElements()) {
                        String str = (String) propertyNames.nextElement();
                        String property = System.getProperty(str);
                        if (property != null) {
                            Log.__props.setProperty(str, property);
                        }
                    }
                    Log.__logClass = Log.__props.getProperty("org.eclipse.jetty.util.log.class", "org.eclipse.jetty.util.log.Slf4jLog");
                    Log.__ignored = Boolean.parseBoolean(Log.__props.getProperty("org.eclipse.jetty.util.log.IGNORED", "false"));
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = r2;
                }
            }
        });
    }

    @Deprecated
    public static void debug(String str) {
        if (!initialized()) {
            return;
        }
        LOG.debug(str, new Object[0]);
    }

    @Deprecated
    public static void debug(String str, Object obj) {
        if (!initialized()) {
            return;
        }
        LOG.debug(str, obj);
    }

    @Deprecated
    public static void debug(String str, Object obj, Object obj2) {
        if (!initialized()) {
            return;
        }
        LOG.debug(str, obj, obj2);
    }

    @Deprecated
    public static void debug(Throwable th) {
        if (!isDebugEnabled()) {
            return;
        }
        LOG.debug(EXCEPTION, th);
    }

    @Deprecated
    public static Logger getLog() {
        initialized();
        return LOG;
    }

    public static Logger getLogger(Class<?> cls) {
        return getLogger(cls.getName());
    }

    public static Logger getLogger(String str) {
        if (!initialized()) {
            return null;
        }
        if (str == null) {
            return LOG;
        }
        Logger logger = __loggers.get(str);
        return logger == null ? LOG.getLogger(str) : logger;
    }

    public static Map<String, Logger> getLoggers() {
        return Collections.unmodifiableMap(__loggers);
    }

    public static ConcurrentMap<String, Logger> getMutableLoggers() {
        return __loggers;
    }

    public static Logger getRootLogger() {
        initialized();
        return LOG;
    }

    @Deprecated
    public static void ignore(Throwable th) {
        if (!initialized()) {
            return;
        }
        LOG.ignore(th);
    }

    @Deprecated
    public static void info(String str) {
        if (!initialized()) {
            return;
        }
        LOG.info(str, new Object[0]);
    }

    @Deprecated
    public static void info(String str, Object obj) {
        if (!initialized()) {
            return;
        }
        LOG.info(str, obj);
    }

    @Deprecated
    public static void info(String str, Object obj, Object obj2) {
        if (!initialized()) {
            return;
        }
        LOG.info(str, obj, obj2);
    }

    public static void initStandardLogging(Throwable th) {
        if (th != null && __ignored) {
            th.printStackTrace();
        }
        if (LOG == null) {
            StdErrLog stdErrLog = new StdErrLog();
            LOG = stdErrLog;
            stdErrLog.debug("Logging to {} via {}", stdErrLog, StdErrLog.class.getName());
        }
    }

    public static boolean initialized() {
        boolean z = true;
        if (LOG != null) {
            return true;
        }
        synchronized (Log.class) {
            if (__initialized) {
                if (LOG == null) {
                    z = false;
                }
                return z;
            }
            __initialized = true;
            try {
                Class loadClass = Loader.loadClass(Log.class, __logClass);
                if (LOG == null || !LOG.getClass().equals(loadClass)) {
                    Logger logger = (Logger) loadClass.newInstance();
                    LOG = logger;
                    logger.debug("Logging to {} via {}", logger, loadClass.getName());
                }
            } catch (Throwable th) {
                initStandardLogging(th);
            }
            return LOG != null;
        }
    }

    @Deprecated
    public static boolean isDebugEnabled() {
        if (!initialized()) {
            return false;
        }
        return LOG.isDebugEnabled();
    }

    public static boolean isIgnored() {
        return __ignored;
    }

    public static void setLog(Logger logger) {
        LOG = logger;
    }

    public static void setLogToParent(String str) {
        ClassLoader classLoader = Log.class.getClassLoader();
        if (classLoader == null || classLoader.getParent() == null) {
            setLog(getLogger(str));
            return;
        }
        try {
            setLog(new LoggerLog(classLoader.getParent().loadClass("org.eclipse.jetty.util.log.Log").getMethod("getLogger", String.class).invoke(null, str)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void warn(String str) {
        if (!initialized()) {
            return;
        }
        LOG.warn(str, new Object[0]);
    }

    @Deprecated
    public static void warn(String str, Object obj) {
        if (!initialized()) {
            return;
        }
        LOG.warn(str, obj);
    }

    @Deprecated
    public static void warn(String str, Object obj, Object obj2) {
        if (!initialized()) {
            return;
        }
        LOG.warn(str, obj, obj2);
    }

    @Deprecated
    public static void warn(String str, Throwable th) {
        if (!initialized()) {
            return;
        }
        LOG.warn(str, th);
    }

    @Deprecated
    public static void warn(Throwable th) {
        if (!initialized()) {
            return;
        }
        LOG.warn(EXCEPTION, th);
    }
}

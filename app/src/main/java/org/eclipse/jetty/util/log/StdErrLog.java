package org.eclipse.jetty.util.log;

import java.io.PrintStream;
import java.security.AccessControlException;
import java.util.Properties;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.DateCache;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes5.dex */
public class StdErrLog extends AbstractLogger {
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_WARN = 3;
    public static final boolean __source;
    public static DateCache _dateCache;
    public final String _abbrevname;
    public int _configuredLevel;
    public boolean _hideStacks;
    public int _level;
    public final String _name;
    public boolean _printLongNames;
    public boolean _source;
    public PrintStream _stderr;
    public static final String EOL = System.getProperty("line.separator");
    public static final Properties __props = new Properties();
    public static final boolean __long = Boolean.parseBoolean(Log.__props.getProperty("org.eclipse.jetty.util.log.stderr.LONG", "false"));

    static {
        Properties properties = Log.__props;
        __source = Boolean.parseBoolean(properties.getProperty("org.eclipse.jetty.util.log.SOURCE", properties.getProperty("org.eclipse.jetty.util.log.stderr.SOURCE", "false")));
        __props.putAll(Log.__props);
        String[] strArr = {"DEBUG", "org.eclipse.jetty.util.log.DEBUG", "org.eclipse.jetty.util.log.stderr.DEBUG"};
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            if (System.getProperty(str) != null) {
                System.err.printf("System Property [%s] has been deprecated! (Use org.eclipse.jetty.LEVEL=DEBUG instead)%n", str);
            }
        }
        try {
            _dateCache = new DateCache("yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public StdErrLog() {
        this(null);
    }

    public StdErrLog(String str) {
        this(str, __props);
    }

    public StdErrLog(String str, Properties properties) {
        Properties properties2;
        this._level = 2;
        this._stderr = null;
        this._source = __source;
        this._printLongNames = __long;
        this._hideStacks = false;
        if (properties != null && properties != (properties2 = __props)) {
            properties2.putAll(properties);
        }
        str = str == null ? "" : str;
        this._name = str;
        this._abbrevname = condensePackageString(str);
        int loggingLevel = getLoggingLevel(properties, this._name);
        this._level = loggingLevel;
        this._configuredLevel = loggingLevel;
        try {
            this._source = Boolean.parseBoolean(properties.getProperty(this._name + ".SOURCE", Boolean.toString(this._source)));
        } catch (AccessControlException unused) {
            this._source = __source;
        }
    }

    public static String condensePackageString(String str) {
        String[] split = str.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            sb.append(split[i].charAt(0));
        }
        if (sb.length() > 0) {
            sb.append('.');
        }
        sb.append(split[split.length - 1]);
        return sb.toString();
    }

    private void escape(StringBuilder sb, String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isISOControl(charAt)) {
                charAt = charAt == '\n' ? '|' : charAt == '\r' ? '<' : '?';
            }
            sb.append(charAt);
        }
    }

    private void format(StringBuilder sb, String str, String str2, Throwable th) {
        format(sb, str, str2, new Object[0]);
        if (isHideStacks()) {
            format(sb, String.valueOf(th), new Object[0]);
        } else {
            format(sb, th);
        }
    }

    private void format(StringBuilder sb, String str, String str2, Object... objArr) {
        tag(sb, _dateCache.now(), _dateCache.lastMs(), str);
        format(sb, str2, objArr);
    }

    private void format(StringBuilder sb, String str, Object... objArr) {
        if (str == null) {
            str = "";
            for (int i = 0; i < objArr.length; i++) {
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "{} ");
            }
        }
        int i2 = 0;
        for (Object obj : objArr) {
            int indexOf = str.indexOf(MessageFormatter.DELIM_STR, i2);
            if (indexOf < 0) {
                escape(sb, str.substring(i2));
                sb.append(StringUtils.SPACE);
                sb.append(obj);
                i2 = str.length();
            } else {
                escape(sb, str.substring(i2, indexOf));
                sb.append(String.valueOf(obj));
                i2 = indexOf + 2;
            }
        }
        escape(sb, str.substring(i2));
    }

    private void format(StringBuilder sb, Throwable th) {
        if (th == null) {
            sb.append("null");
            return;
        }
        sb.append(EOL);
        format(sb, th.toString(), new Object[0]);
        StackTraceElement[] stackTrace = th.getStackTrace();
        for (int i = 0; stackTrace != null && i < stackTrace.length; i++) {
            sb.append(EOL);
            sb.append("\tat ");
            format(sb, stackTrace[i].toString(), new Object[0]);
        }
        Throwable cause = th.getCause();
        if (cause == null || cause == th) {
            return;
        }
        sb.append(EOL);
        sb.append("Caused by: ");
        format(sb, cause);
    }

    public static int getLevelId(String str, String str2) {
        if (str2 == null) {
            return -1;
        }
        String trim = str2.trim();
        if ("ALL".equalsIgnoreCase(trim)) {
            return 0;
        }
        if ("DEBUG".equalsIgnoreCase(trim)) {
            return 1;
        }
        if ("INFO".equalsIgnoreCase(trim)) {
            return 2;
        }
        if ("WARN".equalsIgnoreCase(trim)) {
            return 3;
        }
        PrintStream printStream = System.err;
        printStream.println("Unknown StdErrLog level [" + str + "]=[" + trim + "], expecting only [ALL, DEBUG, INFO, WARN] as values.");
        return -1;
    }

    public static int getLoggingLevel(Properties properties, String str) {
        while (str != null && str.length() > 0) {
            String property = properties.getProperty(str + ".LEVEL");
            int levelId = getLevelId(str + ".LEVEL", property);
            if (levelId != -1) {
                return levelId;
            }
            int lastIndexOf = str.lastIndexOf(46);
            str = lastIndexOf >= 0 ? str.substring(0, lastIndexOf) : null;
        }
        return getLevelId("log.LEVEL", properties.getProperty("log.LEVEL", "INFO"));
    }

    public static void setProperties(Properties properties) {
        __props.clear();
        __props.putAll(properties);
    }

    private void tag(StringBuilder sb, String str, int i, String str2) {
        StackTraceElement[] stackTrace;
        sb.setLength(0);
        sb.append(str);
        if (i > 99) {
            sb.append('.');
        } else {
            sb.append(i > 9 ? ".0" : ".00");
        }
        sb.append(i);
        sb.append(str2);
        sb.append(this._printLongNames ? this._name : this._abbrevname);
        sb.append(':');
        if (this._source) {
            for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
                String className = stackTraceElement.getClassName();
                if (!className.equals(StdErrLog.class.getName()) && !className.equals(Log.class.getName())) {
                    if (this._printLongNames || !className.startsWith("org.eclipse.jetty.")) {
                        sb.append(className);
                    } else {
                        sb.append(condensePackageString(className));
                    }
                    sb.append('#');
                    sb.append(stackTraceElement.getMethodName());
                    if (stackTraceElement.getFileName() != null) {
                        sb.append('(');
                        sb.append(stackTraceElement.getFileName());
                        sb.append(':');
                        sb.append(stackTraceElement.getLineNumber());
                        sb.append(')');
                    }
                    sb.append(':');
                    return;
                }
            }
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(String str, Throwable th) {
        if (this._level <= 1) {
            StringBuilder sb = new StringBuilder(64);
            format(sb, ":DBUG:", str, th);
            PrintStream printStream = this._stderr;
            if (printStream == null) {
                printStream = System.err;
            }
            printStream.println(sb);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(String str, Object... objArr) {
        if (this._level <= 1) {
            StringBuilder sb = new StringBuilder(64);
            format(sb, ":DBUG:", str, objArr);
            PrintStream printStream = this._stderr;
            if (printStream == null) {
                printStream = System.err;
            }
            printStream.println(sb);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(Throwable th) {
        debug("", th);
    }

    public int getLevel() {
        return this._level;
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public String getName() {
        return this._name;
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void ignore(Throwable th) {
        if (this._level <= 0) {
            StringBuilder sb = new StringBuilder(64);
            format(sb, ":IGNORED:", "", th);
            PrintStream printStream = this._stderr;
            if (printStream == null) {
                printStream = System.err;
            }
            printStream.println(sb);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(String str, Throwable th) {
        if (this._level <= 2) {
            StringBuilder sb = new StringBuilder(64);
            format(sb, ":INFO:", str, th);
            PrintStream printStream = this._stderr;
            if (printStream == null) {
                printStream = System.err;
            }
            printStream.println(sb);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(String str, Object... objArr) {
        if (this._level <= 2) {
            StringBuilder sb = new StringBuilder(64);
            format(sb, ":INFO:", str, objArr);
            PrintStream printStream = this._stderr;
            if (printStream == null) {
                printStream = System.err;
            }
            printStream.println(sb);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(Throwable th) {
        info("", th);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public boolean isDebugEnabled() {
        return this._level <= 1;
    }

    public boolean isHideStacks() {
        return this._hideStacks;
    }

    public boolean isPrintLongNames() {
        return this._printLongNames;
    }

    public boolean isSource() {
        return this._source;
    }

    @Override // org.eclipse.jetty.util.log.AbstractLogger
    public Logger newLogger(String str) {
        StdErrLog stdErrLog = new StdErrLog(str);
        stdErrLog.setPrintLongNames(this._printLongNames);
        stdErrLog.setSource(this._source);
        stdErrLog._stderr = this._stderr;
        int i = this._level;
        if (i != this._configuredLevel) {
            stdErrLog._level = i;
        }
        return stdErrLog;
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void setDebugEnabled(boolean z) {
        if (z) {
            this._level = 1;
            for (Logger logger : Log.getLoggers().values()) {
                if (logger.getName().startsWith(getName()) && (logger instanceof StdErrLog)) {
                    ((StdErrLog) logger).setLevel(1);
                }
            }
            return;
        }
        this._level = this._configuredLevel;
        for (Logger logger2 : Log.getLoggers().values()) {
            if (logger2.getName().startsWith(getName()) && (logger2 instanceof StdErrLog)) {
                StdErrLog stdErrLog = (StdErrLog) logger2;
                stdErrLog.setLevel(stdErrLog._configuredLevel);
            }
        }
    }

    public void setHideStacks(boolean z) {
        this._hideStacks = z;
    }

    public void setLevel(int i) {
        this._level = i;
    }

    public void setPrintLongNames(boolean z) {
        this._printLongNames = z;
    }

    public void setSource(boolean z) {
        this._source = z;
    }

    public void setStdErrStream(PrintStream printStream) {
        if (printStream == System.err) {
            printStream = null;
        }
        this._stderr = printStream;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("StdErrLog:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._name);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":LEVEL=");
        int i = this._level;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? "?" : "WARN" : "INFO" : "DEBUG" : "ALL");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(String str, Throwable th) {
        if (this._level <= 3) {
            StringBuilder sb = new StringBuilder(64);
            format(sb, ":WARN:", str, th);
            PrintStream printStream = this._stderr;
            if (printStream == null) {
                printStream = System.err;
            }
            printStream.println(sb);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(String str, Object... objArr) {
        if (this._level <= 3) {
            StringBuilder sb = new StringBuilder(64);
            format(sb, ":WARN:", str, objArr);
            PrintStream printStream = this._stderr;
            if (printStream == null) {
                printStream = System.err;
            }
            printStream.println(sb);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(Throwable th) {
        warn("", th);
    }
}

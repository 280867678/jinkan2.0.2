package org.eclipse.jetty.util.log;

import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes5.dex */
public class JavaUtilLog extends AbstractLogger {
    public java.util.logging.Logger _logger;
    public Level configuredLevel;

    public JavaUtilLog() {
        this("org.eclipse.jetty.util.log");
    }

    public JavaUtilLog(String str) {
        this._logger = java.util.logging.Logger.getLogger(str);
        if (Boolean.parseBoolean(Log.__props.getProperty("org.eclipse.jetty.util.log.DEBUG", "false"))) {
            this._logger.setLevel(Level.FINE);
        }
        this.configuredLevel = this._logger.getLevel();
    }

    private String format(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : objArr) {
            int indexOf = valueOf.indexOf(MessageFormatter.DELIM_STR, i);
            if (indexOf < 0) {
                sb.append(valueOf.substring(i));
                sb.append(StringUtils.SPACE);
                sb.append(obj);
                i = valueOf.length();
            } else {
                sb.append(valueOf.substring(i, indexOf));
                sb.append(String.valueOf(obj));
                i = indexOf + 2;
            }
        }
        sb.append(valueOf.substring(i));
        return sb.toString();
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(String str, Throwable th) {
        this._logger.log(Level.FINE, str, th);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(String str, Object... objArr) {
        this._logger.log(Level.FINE, format(str, objArr));
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void debug(Throwable th) {
        debug("", th);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public String getName() {
        return this._logger.getName();
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void ignore(Throwable th) {
        if (Log.isIgnored()) {
            warn(Log.IGNORED, th);
        }
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(String str, Throwable th) {
        this._logger.log(Level.INFO, str, th);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(String str, Object... objArr) {
        this._logger.log(Level.INFO, format(str, objArr));
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void info(Throwable th) {
        info("", th);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public boolean isDebugEnabled() {
        return this._logger.isLoggable(Level.FINE);
    }

    @Override // org.eclipse.jetty.util.log.AbstractLogger
    public Logger newLogger(String str) {
        return new JavaUtilLog(str);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void setDebugEnabled(boolean z) {
        java.util.logging.Logger logger;
        Level level;
        if (z) {
            this.configuredLevel = this._logger.getLevel();
            logger = this._logger;
            level = Level.FINE;
        } else {
            logger = this._logger;
            level = this.configuredLevel;
        }
        logger.setLevel(level);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(String str, Throwable th) {
        this._logger.log(Level.WARNING, str, th);
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(String str, Object... objArr) {
        this._logger.log(Level.WARNING, format(str, objArr));
    }

    @Override // org.eclipse.jetty.util.log.Logger
    public void warn(Throwable th) {
        warn("", th);
    }
}

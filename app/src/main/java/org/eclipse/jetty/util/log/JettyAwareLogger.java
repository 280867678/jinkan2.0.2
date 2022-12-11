package org.eclipse.jetty.util.log;

import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

/* loaded from: classes5.dex */
public class JettyAwareLogger implements org.slf4j.Logger {
    public static final int DEBUG = 10;
    public static final int ERROR = 40;
    public static final String FQCN = Slf4jLog.class.getName();
    public static final int INFO = 20;
    public static final int TRACE = 0;
    public static final int WARN = 30;
    public final LocationAwareLogger _logger;

    public JettyAwareLogger(LocationAwareLogger locationAwareLogger) {
        this._logger = locationAwareLogger;
    }

    private void log(Marker marker, int i, String str, Object[] objArr, Throwable th) {
        String str2;
        String message;
        Object[] objArr2;
        Marker marker2;
        int i2;
        LocationAwareLogger locationAwareLogger = this._logger;
        if (objArr == null) {
            str2 = FQCN;
            objArr2 = null;
            marker2 = marker;
            i2 = i;
            message = str;
        } else {
            if ((locationAwareLogger.isTraceEnabled() ? 0 : this._logger.isDebugEnabled() ? 10 : this._logger.isInfoEnabled() ? 20 : this._logger.isWarnEnabled() ? 30 : 40) > i) {
                return;
            }
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            locationAwareLogger = this._logger;
            str2 = FQCN;
            message = arrayFormat.getMessage();
            objArr2 = null;
            marker2 = marker;
            i2 = i;
        }
        locationAwareLogger.log(marker2, str2, i2, message, objArr2, th);
    }

    @Override // org.slf4j.Logger
    public void debug(String str) {
        log(null, 10, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj) {
        log(null, 10, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj, Object obj2) {
        log(null, 10, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Throwable th) {
        log(null, 10, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object[] objArr) {
        log(null, 10, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String str) {
        log(marker, 10, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String str, Object obj) {
        log(marker, 10, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String str, Object obj, Object obj2) {
        log(marker, 10, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String str, Throwable th) {
        log(marker, 10, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void debug(Marker marker, String str, Object[] objArr) {
        log(marker, 10, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void error(String str) {
        log(null, 40, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object obj) {
        log(null, 40, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object obj, Object obj2) {
        log(null, 40, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Throwable th) {
        log(null, 40, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object[] objArr) {
        log(null, 40, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String str) {
        log(marker, 40, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String str, Object obj) {
        log(marker, 40, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String str, Object obj, Object obj2) {
        log(marker, 40, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String str, Throwable th) {
        log(marker, 40, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void error(Marker marker, String str, Object[] objArr) {
        log(marker, 40, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public String getName() {
        return this._logger.getName();
    }

    @Override // org.slf4j.Logger
    public void info(String str) {
        log(null, 20, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void info(String str, Object obj) {
        log(null, 20, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void info(String str, Object obj, Object obj2) {
        log(null, 20, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void info(String str, Throwable th) {
        log(null, 20, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void info(String str, Object[] objArr) {
        log(null, 20, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String str) {
        log(marker, 20, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String str, Object obj) {
        log(marker, 20, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String str, Object obj, Object obj2) {
        log(marker, 20, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String str, Throwable th) {
        log(marker, 20, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void info(Marker marker, String str, Object[] objArr) {
        log(marker, 20, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public boolean isDebugEnabled() {
        return this._logger.isDebugEnabled();
    }

    @Override // org.slf4j.Logger
    public boolean isDebugEnabled(Marker marker) {
        return this._logger.isDebugEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public boolean isErrorEnabled() {
        return this._logger.isErrorEnabled();
    }

    @Override // org.slf4j.Logger
    public boolean isErrorEnabled(Marker marker) {
        return this._logger.isErrorEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public boolean isInfoEnabled() {
        return this._logger.isInfoEnabled();
    }

    @Override // org.slf4j.Logger
    public boolean isInfoEnabled(Marker marker) {
        return this._logger.isInfoEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public boolean isTraceEnabled() {
        return this._logger.isTraceEnabled();
    }

    @Override // org.slf4j.Logger
    public boolean isTraceEnabled(Marker marker) {
        return this._logger.isTraceEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public boolean isWarnEnabled() {
        return this._logger.isWarnEnabled();
    }

    @Override // org.slf4j.Logger
    public boolean isWarnEnabled(Marker marker) {
        return this._logger.isWarnEnabled(marker);
    }

    public String toString() {
        return this._logger.toString();
    }

    @Override // org.slf4j.Logger
    public void trace(String str) {
        log(null, 0, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Object obj) {
        log(null, 0, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Object obj, Object obj2) {
        log(null, 0, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Throwable th) {
        log(null, 0, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Object[] objArr) {
        log(null, 0, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String str) {
        log(marker, 0, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String str, Object obj) {
        log(marker, 0, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String str, Object obj, Object obj2) {
        log(marker, 0, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String str, Throwable th) {
        log(marker, 0, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void trace(Marker marker, String str, Object[] objArr) {
        log(marker, 0, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String str) {
        log(null, 30, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object obj) {
        log(null, 30, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object obj, Object obj2) {
        log(null, 30, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Throwable th) {
        log(null, 30, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object[] objArr) {
        log(null, 30, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String str) {
        log(marker, 30, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String str, Object obj) {
        log(marker, 30, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String str, Object obj, Object obj2) {
        log(marker, 30, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String str, Throwable th) {
        log(marker, 30, str, null, th);
    }

    @Override // org.slf4j.Logger
    public void warn(Marker marker, String str, Object[] objArr) {
        log(marker, 30, str, objArr, null);
    }
}

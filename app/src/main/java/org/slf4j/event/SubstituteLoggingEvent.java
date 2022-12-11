package org.slf4j.event;

import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* loaded from: classes5.dex */
public class SubstituteLoggingEvent implements LoggingEvent {
    public Object[] argArray;
    public Level level;
    public SubstituteLogger logger;
    public String loggerName;
    public Marker marker;
    public String message;
    public String threadName;
    public Throwable throwable;
    public long timeStamp;

    @Override // org.slf4j.event.LoggingEvent
    public Object[] getArgumentArray() {
        return this.argArray;
    }

    @Override // org.slf4j.event.LoggingEvent
    public Level getLevel() {
        return this.level;
    }

    public SubstituteLogger getLogger() {
        return this.logger;
    }

    @Override // org.slf4j.event.LoggingEvent
    public String getLoggerName() {
        return this.loggerName;
    }

    @Override // org.slf4j.event.LoggingEvent
    public Marker getMarker() {
        return this.marker;
    }

    @Override // org.slf4j.event.LoggingEvent
    public String getMessage() {
        return this.message;
    }

    @Override // org.slf4j.event.LoggingEvent
    public String getThreadName() {
        return this.threadName;
    }

    @Override // org.slf4j.event.LoggingEvent
    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override // org.slf4j.event.LoggingEvent
    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setArgumentArray(Object[] objArr) {
        this.argArray = objArr;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setLogger(SubstituteLogger substituteLogger) {
        this.logger = substituteLogger;
    }

    public void setLoggerName(String str) {
        this.loggerName = str;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setThreadName(String str) {
        this.threadName = str;
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }
}

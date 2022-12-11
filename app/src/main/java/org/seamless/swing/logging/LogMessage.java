package org.seamless.swing.logging;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/* loaded from: classes5.dex */
public class LogMessage {
    public Long createdOn;
    public Level level;
    public String message;
    public String source;
    public String thread;

    public LogMessage(String str) {
        this(Level.INFO, str);
    }

    public LogMessage(String str, String str2) {
        this(Level.INFO, str, str2);
    }

    public LogMessage(Level level, String str) {
        this(level, null, str);
    }

    public LogMessage(Level level, String str, String str2) {
        this.createdOn = Long.valueOf(new Date().getTime());
        this.thread = Thread.currentThread().getName();
        this.level = level;
        this.source = str;
        this.message = str2;
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getMessage() {
        return this.message;
    }

    public String getSource() {
        return this.source;
    }

    public String getThread() {
        return this.thread;
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
        return getLevel() + " - " + simpleDateFormat.format(new Date(getCreatedOn().longValue())) + " - " + getThread() + " : " + getSource() + " : " + getMessage();
    }
}

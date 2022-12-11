package org.seamless.swing.logging;

import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* loaded from: classes5.dex */
public abstract class LoggingHandler extends Handler {
    public int sourcePathElements;

    public LoggingHandler() {
        this.sourcePathElements = 3;
    }

    public LoggingHandler(int i) {
        this.sourcePathElements = 3;
        this.sourcePathElements = i;
    }

    @Override // java.util.logging.Handler
    public void close() throws SecurityException {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    public String getSource(LogRecord logRecord) {
        StringBuilder sb = new StringBuilder(180);
        String[] split = logRecord.getSourceClassName().split("\\.");
        int length = split.length;
        int i = this.sourcePathElements;
        if (length > i) {
            split = (String[]) Arrays.copyOfRange(split, split.length - i, split.length);
        }
        for (String str : split) {
            sb.append(str);
            sb.append(".");
        }
        sb.append(logRecord.getSourceMethodName());
        return sb.toString();
    }

    public abstract void log(LogMessage logMessage);

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        log(new LogMessage(logRecord.getLevel(), getSource(logRecord), logRecord.getMessage()));
    }
}

package org.fourthline.cling.android;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* loaded from: classes5.dex */
public class FixedAndroidLogHandler extends Handler {
    public static final Formatter THE_FORMATTER = new Formatter() { // from class: org.fourthline.cling.android.FixedAndroidLogHandler.1
        @Override // java.util.logging.Formatter
        public String format(LogRecord logRecord) {
            Throwable thrown = logRecord.getThrown();
            if (thrown != null) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                stringWriter.write(logRecord.getMessage());
                stringWriter.write("\n");
                thrown.printStackTrace(printWriter);
                printWriter.flush();
                return stringWriter.toString();
            }
            return logRecord.getMessage();
        }
    };

    public FixedAndroidLogHandler() {
        setFormatter(THE_FORMATTER);
    }

    public static int getAndroidLevel(Level level) {
        int intValue = level.intValue();
        if (intValue >= 1000) {
            return 6;
        }
        if (intValue >= 900) {
            return 5;
        }
        return intValue >= 800 ? 4 : 3;
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        int length;
        try {
            getAndroidLevel(logRecord.getLevel());
            String loggerName = logRecord.getLoggerName();
            if (loggerName != null && (length = loggerName.length()) > 23) {
                int lastIndexOf = loggerName.lastIndexOf(".");
                if ((length - lastIndexOf) - 1 <= 23) {
                    loggerName.substring(lastIndexOf + 1);
                } else {
                    loggerName.substring(loggerName.length() - 23);
                }
            }
            getFormatter().format(logRecord);
        } catch (RuntimeException unused) {
        }
    }
}

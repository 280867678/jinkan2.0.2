package com.arialyy.aria.util;

import android.annotation.SuppressLint;
import com.arialyy.aria.core.AriaConfig;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes3.dex */
public class ErrorHelp {
    @SuppressLint({"SimpleDateFormat"})
    public static String getData(String str) {
        return new SimpleDateFormat(str).format(new Date(System.currentTimeMillis()));
    }

    public static String getLogPath() {
        String format = String.format("%slog/AriaCrash_%s.log", CommonUtil.getAppPath(AriaConfig.getInstance().getAPP()), getData("yyyy-MM-dd_HH_mm_ss"));
        FileUtil.createFile(format);
        return format;
    }

    public static void saveError(String str, String str2, String str3) {
        writeLogToFile(str, String.format("\nmsg【%s】\nException：%s", str2, str3));
    }

    public static int writeLogToFile(String str, String str2) {
        PrintWriter printWriter;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getData("yyyy-MM-dd HH:mm:ss"));
        stringBuffer.append("    ");
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        stringBuffer.append("\n\n");
        PrintWriter printWriter2 = null;
        try {
            try {
                File file = new File(getLogPath());
                if (!file.exists()) {
                    FileUtil.createFile(file);
                }
                printWriter = new PrintWriter(new FileWriter(file.getPath(), true));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            printWriter.append((CharSequence) stringBuffer);
            printWriter.flush();
            printWriter.close();
            return 0;
        } catch (Exception e2) {
            e = e2;
            printWriter2 = printWriter;
            e.printStackTrace();
            if (printWriter2 == null) {
                return 0;
            }
            printWriter2.close();
            return 0;
        } catch (Throwable th2) {
            th = th2;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }
}

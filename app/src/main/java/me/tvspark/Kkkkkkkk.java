package me.tvspark;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class Kkkkkkkk {
    public static final Charset Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Charset.forName("US-ASCII");

    static {
        Charset.forName("UTF-8");
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file2);
                }
                if (!file2.delete()) {
                    throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("failed to delete file: ", file2));
                }
            }
            return;
        }
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("not a readable directory: ", file));
    }
}

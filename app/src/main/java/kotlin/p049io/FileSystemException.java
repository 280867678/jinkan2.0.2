package kotlin.p049io;

import java.io.File;
import java.io.IOException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;

@ef0
/* renamed from: kotlin.io.FileSystemException */
/* loaded from: classes4.dex */
public class FileSystemException extends IOException {
    public final File file;
    public final File other;
    public final String reason;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FileSystemException(File file, File file2, String str) {
        super(r0);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "file");
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "sb.toString()");
        this.file = file;
        this.other = file2;
        this.reason = str;
    }

    public /* synthetic */ FileSystemException(File file, File file2, String str, int i, gi0 gi0Var) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    public final File getFile() {
        return this.file;
    }

    public final File getOther() {
        return this.other;
    }

    public final String getReason() {
        return this.reason;
    }
}

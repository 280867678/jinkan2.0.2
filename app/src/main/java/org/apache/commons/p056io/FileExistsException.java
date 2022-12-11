package org.apache.commons.p056io;

import java.io.File;
import java.io.IOException;
import me.tvspark.outline;

/* renamed from: org.apache.commons.io.FileExistsException */
/* loaded from: classes4.dex */
public class FileExistsException extends IOException {
    public static final long serialVersionUID = 1;

    public FileExistsException() {
    }

    public FileExistsException(File file) {
        super(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("File ", file, " exists"));
    }

    public FileExistsException(String str) {
        super(str);
    }
}

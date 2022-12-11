package kotlin.p049io;

import java.io.File;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;

@ef0
/* renamed from: kotlin.io.FileAlreadyExistsException */
/* loaded from: classes4.dex */
public final class FileAlreadyExistsException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileAlreadyExistsException(File file, File file2, String str) {
        super(file, file2, str);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "file");
    }

    public /* synthetic */ FileAlreadyExistsException(File file, File file2, String str, int i, gi0 gi0Var) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }
}

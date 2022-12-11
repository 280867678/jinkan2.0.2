package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.uw0;

@ef0
/* loaded from: classes4.dex */
public final class FileOperator {
    public final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j, uw0 uw0Var, long j2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
        if (j2 >= 0) {
            while (j2 > 0) {
                long transferTo = this.fileChannel.transferTo(j, j2, uw0Var);
                j += transferTo;
                j2 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void write(long j, uw0 uw0Var, long j2) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
        if (j2 < 0 || j2 > uw0Var.Wwwwwwwwwwwwwwwwwwwwwww) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long transferFrom = this.fileChannel.transferFrom(uw0Var, j3, j4);
            j3 += transferFrom;
            j4 -= transferFrom;
        }
    }
}

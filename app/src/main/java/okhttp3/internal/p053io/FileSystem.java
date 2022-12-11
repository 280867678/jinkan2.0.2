package okhttp3.internal.p053io;

import androidx.core.net.MailTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import me.tvspark.cx0;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.kx0;
import me.tvspark.mx0;
import me.tvspark.nx0;
import me.tvspark.outline;
import me.tvspark.r40;

@ef0
/* renamed from: okhttp3.internal.io.FileSystem */
/* loaded from: classes4.dex */
public interface FileSystem {
    public static final Companion Companion = new Companion(null);
    public static final FileSystem SYSTEM = new FileSystem() { // from class: okhttp3.internal.io.FileSystem$Companion$SYSTEM$1
        @Override // okhttp3.internal.p053io.FileSystem
        public kx0 appendingSink(File file) throws FileNotFoundException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "file");
            try {
                return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file);
            }
        }

        @Override // okhttp3.internal.p053io.FileSystem
        public void delete(File file) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "file");
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("failed to delete ", file));
        }

        @Override // okhttp3.internal.p053io.FileSystem
        public void deleteContents(File file) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "directory");
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) file2, "file");
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("failed to delete ", file2));
                    }
                }
                return;
            }
            throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("not a readable directory: ", file));
        }

        @Override // okhttp3.internal.p053io.FileSystem
        public boolean exists(File file) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "file");
            return file.exists();
        }

        @Override // okhttp3.internal.p053io.FileSystem
        public void rename(File file, File file2) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "from");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file2, MailTo.f53TO);
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // okhttp3.internal.p053io.FileSystem
        public kx0 sink(File file) throws FileNotFoundException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "file");
            try {
                return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, false, 1);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, false, 1);
            }
        }

        @Override // okhttp3.internal.p053io.FileSystem
        public long size(File file) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "file");
            return file.length();
        }

        @Override // okhttp3.internal.p053io.FileSystem
        public mx0 source(File file) throws FileNotFoundException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "file");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "$receiver");
            FileInputStream fileInputStream = new FileInputStream(file);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fileInputStream, "$receiver");
            return new cx0(fileInputStream, new nx0());
        }
    };

    @ef0
    /* renamed from: okhttp3.internal.io.FileSystem$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = null;

        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }
    }

    kx0 appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    kx0 sink(File file) throws FileNotFoundException;

    long size(File file);

    mx0 source(File file) throws FileNotFoundException;
}

package org.apache.commons.p056io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import me.tvspark.outline;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.p056io.Charsets;
import org.apache.commons.p056io.FileUtils;
import org.apache.commons.p056io.IOUtils;

/* renamed from: org.apache.commons.io.output.LockableFileWriter */
/* loaded from: classes4.dex */
public class LockableFileWriter extends Writer {
    public static final String LCK = ".lck";
    public final File lockFile;
    public final Writer out;

    public LockableFileWriter(File file) throws IOException {
        this(file, false, (String) null);
    }

    public LockableFileWriter(File file, String str) throws IOException {
        this(file, str, false, (String) null);
    }

    public LockableFileWriter(File file, String str, boolean z, String str2) throws IOException {
        this(file, Charsets.toCharset(str), z, str2);
    }

    public LockableFileWriter(File file, Charset charset) throws IOException {
        this(file, charset, false, (String) null);
    }

    public LockableFileWriter(File file, Charset charset, boolean z, String str) throws IOException {
        File absoluteFile = file.getAbsoluteFile();
        if (absoluteFile.getParentFile() != null) {
            FileUtils.forceMkdir(absoluteFile.getParentFile());
        }
        if (!absoluteFile.isDirectory()) {
            File file2 = new File(str == null ? System.getProperty(SystemUtils.JAVA_IO_TMPDIR_KEY) : str);
            FileUtils.forceMkdir(file2);
            testLockDir(file2);
            this.lockFile = new File(file2, absoluteFile.getName() + LCK);
            createLock();
            this.out = initWriter(absoluteFile, charset, z);
            return;
        }
        throw new IOException("File specified is a directory");
    }

    public LockableFileWriter(File file, boolean z) throws IOException {
        this(file, z, (String) null);
    }

    @Deprecated
    public LockableFileWriter(File file, boolean z, String str) throws IOException {
        this(file, Charset.defaultCharset(), z, str);
    }

    public LockableFileWriter(String str) throws IOException {
        this(str, false, (String) null);
    }

    public LockableFileWriter(String str, boolean z) throws IOException {
        this(str, z, (String) null);
    }

    public LockableFileWriter(String str, boolean z, String str2) throws IOException {
        this(new File(str), z, str2);
    }

    private void createLock() throws IOException {
        synchronized (LockableFileWriter.class) {
            if (!this.lockFile.createNewFile()) {
                throw new IOException("Can't write file, lock " + this.lockFile.getAbsolutePath() + " exists");
            }
            this.lockFile.deleteOnExit();
        }
    }

    private Writer initWriter(File file, Charset charset, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        boolean exists = file.exists();
        try {
            fileOutputStream = new FileOutputStream(file.getAbsolutePath(), z);
            try {
                return new OutputStreamWriter(fileOutputStream, Charsets.toCharset(charset));
            } catch (IOException e) {
                e = e;
                IOUtils.closeQuietly((Writer) null);
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                FileUtils.deleteQuietly(this.lockFile);
                if (!exists) {
                    FileUtils.deleteQuietly(file);
                }
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                IOUtils.closeQuietly((Writer) null);
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                FileUtils.deleteQuietly(this.lockFile);
                if (!exists) {
                    FileUtils.deleteQuietly(file);
                }
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (RuntimeException e4) {
            e = e4;
            fileOutputStream = null;
        }
    }

    private void testLockDir(File file) throws IOException {
        if (!file.exists()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not find lockDir: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file.getAbsolutePath());
            throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (file.canWrite()) {
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not write to lockDir: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(file.getAbsolutePath());
            throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.out.close();
        } finally {
            this.lockFile.delete();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        this.out.write(i);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        this.out.write(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        this.out.write(str, i, i2);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        this.out.write(cArr);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        this.out.write(cArr, i, i2);
    }
}

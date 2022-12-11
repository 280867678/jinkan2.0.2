package org.apache.commons.p056io;

import java.io.File;
import java.io.IOException;
import me.tvspark.outline;

/* renamed from: org.apache.commons.io.FileDeleteStrategy */
/* loaded from: classes4.dex */
public class FileDeleteStrategy {
    public final String name;
    public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy("Normal");
    public static final FileDeleteStrategy FORCE = new ForceFileDeleteStrategy();

    /* renamed from: org.apache.commons.io.FileDeleteStrategy$ForceFileDeleteStrategy */
    /* loaded from: classes4.dex */
    public static class ForceFileDeleteStrategy extends FileDeleteStrategy {
        public ForceFileDeleteStrategy() {
            super("Force");
        }

        @Override // org.apache.commons.p056io.FileDeleteStrategy
        public boolean doDelete(File file) throws IOException {
            FileUtils.forceDelete(file);
            return true;
        }
    }

    public FileDeleteStrategy(String str) {
        this.name = str;
    }

    public void delete(File file) throws IOException {
        if (!file.exists() || doDelete(file)) {
            return;
        }
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Deletion failed: ", file));
    }

    public boolean deleteQuietly(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        try {
            return doDelete(file);
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean doDelete(File file) throws IOException {
        return file.delete();
    }

    public String toString() {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FileDeleteStrategy["), this.name, "]");
    }
}

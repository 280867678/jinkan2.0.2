package org.apache.commons.p056io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.p056io.filefilter.FileFilterUtils;
import org.apache.commons.p056io.filefilter.IOFileFilter;
import org.apache.commons.p056io.filefilter.TrueFileFilter;

/* renamed from: org.apache.commons.io.DirectoryWalker */
/* loaded from: classes4.dex */
public abstract class DirectoryWalker<T> {
    public final int depthLimit;
    public final FileFilter filter;

    /* renamed from: org.apache.commons.io.DirectoryWalker$CancelException */
    /* loaded from: classes4.dex */
    public static class CancelException extends IOException {
        public static final long serialVersionUID = 1347339620135041008L;
        public final int depth;
        public final File file;

        public CancelException(File file, int i) {
            this("Operation Cancelled", file, i);
        }

        public CancelException(String str, File file, int i) {
            super(str);
            this.file = file;
            this.depth = i;
        }

        public int getDepth() {
            return this.depth;
        }

        public File getFile() {
            return this.file;
        }
    }

    public DirectoryWalker() {
        this(null, -1);
    }

    public DirectoryWalker(FileFilter fileFilter, int i) {
        this.filter = fileFilter;
        this.depthLimit = i;
    }

    public DirectoryWalker(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2, int i) {
        IOFileFilter m49or;
        if (iOFileFilter == null && iOFileFilter2 == null) {
            m49or = null;
        } else {
            m49or = FileFilterUtils.m49or(FileFilterUtils.makeDirectoryOnly(iOFileFilter == null ? TrueFileFilter.TRUE : iOFileFilter), FileFilterUtils.makeFileOnly(iOFileFilter2 == null ? TrueFileFilter.TRUE : iOFileFilter2));
        }
        this.filter = m49or;
        this.depthLimit = i;
    }

    private void walk(File file, int i, Collection<T> collection) throws IOException {
        checkIfCancelled(file, i, collection);
        if (handleDirectory(file, i, collection)) {
            handleDirectoryStart(file, i, collection);
            int i2 = i + 1;
            int i3 = this.depthLimit;
            if (i3 < 0 || i2 <= i3) {
                checkIfCancelled(file, i, collection);
                FileFilter fileFilter = this.filter;
                File[] filterDirectoryContents = filterDirectoryContents(file, i, fileFilter == null ? file.listFiles() : file.listFiles(fileFilter));
                if (filterDirectoryContents == null) {
                    handleRestricted(file, i2, collection);
                } else {
                    for (File file2 : filterDirectoryContents) {
                        if (file2.isDirectory()) {
                            walk(file2, i2, collection);
                        } else {
                            checkIfCancelled(file2, i2, collection);
                            handleFile(file2, i2, collection);
                            checkIfCancelled(file2, i2, collection);
                        }
                    }
                }
            }
            handleDirectoryEnd(file, i, collection);
        }
        checkIfCancelled(file, i, collection);
    }

    public final void checkIfCancelled(File file, int i, Collection<T> collection) throws IOException {
        if (!handleIsCancelled(file, i, collection)) {
            return;
        }
        throw new CancelException(file, i);
    }

    public File[] filterDirectoryContents(File file, int i, File[] fileArr) throws IOException {
        return fileArr;
    }

    public void handleCancelled(File file, Collection<T> collection, CancelException cancelException) throws IOException {
        throw cancelException;
    }

    public boolean handleDirectory(File file, int i, Collection<T> collection) throws IOException {
        return true;
    }

    public void handleDirectoryEnd(File file, int i, Collection<T> collection) throws IOException {
    }

    public void handleDirectoryStart(File file, int i, Collection<T> collection) throws IOException {
    }

    public void handleEnd(Collection<T> collection) throws IOException {
    }

    public void handleFile(File file, int i, Collection<T> collection) throws IOException {
    }

    public boolean handleIsCancelled(File file, int i, Collection<T> collection) throws IOException {
        return false;
    }

    public void handleRestricted(File file, int i, Collection<T> collection) throws IOException {
    }

    public void handleStart(File file, Collection<T> collection) throws IOException {
    }

    public final void walk(File file, Collection<T> collection) throws IOException {
        if (file != null) {
            try {
                handleStart(file, collection);
                walk(file, 0, collection);
                handleEnd(collection);
                return;
            } catch (CancelException e) {
                handleCancelled(file, collection, e);
                return;
            }
        }
        throw new NullPointerException("Start Directory is null");
    }
}

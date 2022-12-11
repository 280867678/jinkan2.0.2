package org.apache.commons.p056io.monitor;

import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.monitor.FileEntry */
/* loaded from: classes4.dex */
public class FileEntry implements Serializable {
    public static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
    public static final long serialVersionUID = -2505664948818681153L;
    public FileEntry[] children;
    public boolean directory;
    public boolean exists;
    public final File file;
    public long lastModified;
    public long length;
    public String name;
    public final FileEntry parent;

    public FileEntry(File file) {
        this(null, file);
    }

    public FileEntry(FileEntry fileEntry, File file) {
        if (file != null) {
            this.file = file;
            this.parent = fileEntry;
            this.name = file.getName();
            return;
        }
        throw new IllegalArgumentException("File is missing");
    }

    public FileEntry[] getChildren() {
        FileEntry[] fileEntryArr = this.children;
        return fileEntryArr != null ? fileEntryArr : EMPTY_ENTRIES;
    }

    public File getFile() {
        return this.file;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public long getLength() {
        return this.length;
    }

    public int getLevel() {
        FileEntry fileEntry = this.parent;
        if (fileEntry == null) {
            return 0;
        }
        return fileEntry.getLevel() + 1;
    }

    public String getName() {
        return this.name;
    }

    public FileEntry getParent() {
        return this.parent;
    }

    public boolean isDirectory() {
        return this.directory;
    }

    public boolean isExists() {
        return this.exists;
    }

    public FileEntry newChildInstance(File file) {
        return new FileEntry(this, file);
    }

    public boolean refresh(File file) {
        boolean z = this.exists;
        long j = this.lastModified;
        boolean z2 = this.directory;
        long j2 = this.length;
        this.name = file.getName();
        boolean exists = file.exists();
        this.exists = exists;
        this.directory = exists && file.isDirectory();
        long j3 = 0;
        this.lastModified = this.exists ? file.lastModified() : 0L;
        if (this.exists && !this.directory) {
            j3 = file.length();
        }
        this.length = j3;
        return (this.exists == z && this.lastModified == j && this.directory == z2 && j3 == j2) ? false : true;
    }

    public void setChildren(FileEntry[] fileEntryArr) {
        this.children = fileEntryArr;
    }

    public void setDirectory(boolean z) {
        this.directory = z;
    }

    public void setExists(boolean z) {
        this.exists = z;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setName(String str) {
        this.name = str;
    }
}

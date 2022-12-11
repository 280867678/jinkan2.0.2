package org.apache.commons.p056io.filefilter;

import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.filefilter.DirectoryFileFilter */
/* loaded from: classes4.dex */
public class DirectoryFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter DIRECTORY;
    public static final IOFileFilter INSTANCE;
    public static final long serialVersionUID = -5148237843784525732L;

    static {
        DirectoryFileFilter directoryFileFilter = new DirectoryFileFilter();
        DIRECTORY = directoryFileFilter;
        INSTANCE = directoryFileFilter;
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter, org.apache.commons.p056io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}

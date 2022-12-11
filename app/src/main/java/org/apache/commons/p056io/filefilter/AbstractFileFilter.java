package org.apache.commons.p056io.filefilter;

import java.io.File;

/* renamed from: org.apache.commons.io.filefilter.AbstractFileFilter */
/* loaded from: classes4.dex */
public abstract class AbstractFileFilter implements IOFileFilter {
    @Override // org.apache.commons.p056io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return accept(file.getParentFile(), file.getName());
    }

    @Override // org.apache.commons.p056io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return accept(new File(file, str));
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}

package org.apache.commons.p056io.filefilter;

import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.filefilter.EmptyFileFilter */
/* loaded from: classes4.dex */
public class EmptyFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter EMPTY;
    public static final IOFileFilter NOT_EMPTY;
    public static final long serialVersionUID = 3631422087512832211L;

    static {
        EmptyFileFilter emptyFileFilter = new EmptyFileFilter();
        EMPTY = emptyFileFilter;
        NOT_EMPTY = new NotFileFilter(emptyFileFilter);
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter, org.apache.commons.p056io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        if (!file.isDirectory()) {
            return file.length() == 0;
        }
        File[] listFiles = file.listFiles();
        return listFiles == null || listFiles.length == 0;
    }
}

package org.apache.commons.p056io.filefilter;

import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.filefilter.NotFileFilter */
/* loaded from: classes4.dex */
public class NotFileFilter extends AbstractFileFilter implements Serializable {
    public static final long serialVersionUID = 6131563330944994230L;
    public final IOFileFilter filter;

    public NotFileFilter(IOFileFilter iOFileFilter) {
        if (iOFileFilter != null) {
            this.filter = iOFileFilter;
            return;
        }
        throw new IllegalArgumentException("The filter must not be null");
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter, org.apache.commons.p056io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return !this.filter.accept(file);
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter, org.apache.commons.p056io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return !this.filter.accept(file, str);
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter
    public String toString() {
        return super.toString() + "(" + this.filter.toString() + ")";
    }
}

package org.apache.commons.p056io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import me.tvspark.outline;
import org.apache.commons.p056io.FileUtils;

/* renamed from: org.apache.commons.io.filefilter.AgeFileFilter */
/* loaded from: classes4.dex */
public class AgeFileFilter extends AbstractFileFilter implements Serializable {
    public static final long serialVersionUID = -2132740084016138541L;
    public final boolean acceptOlder;
    public final long cutoff;

    public AgeFileFilter(long j) {
        this(j, true);
    }

    public AgeFileFilter(long j, boolean z) {
        this.acceptOlder = z;
        this.cutoff = j;
    }

    public AgeFileFilter(File file) {
        this(file, true);
    }

    public AgeFileFilter(File file, boolean z) {
        this(file.lastModified(), z);
    }

    public AgeFileFilter(Date date) {
        this(date, true);
    }

    public AgeFileFilter(Date date, boolean z) {
        this(date.getTime(), z);
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter, org.apache.commons.p056io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean isFileNewer = FileUtils.isFileNewer(file, this.cutoff);
        return this.acceptOlder ? !isFileNewer : isFileNewer;
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter
    public String toString() {
        String str = this.acceptOlder ? "<=" : ">";
        StringBuilder sb = new StringBuilder();
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, super.toString(), "(", str);
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, this.cutoff, ")");
    }
}

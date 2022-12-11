package org.apache.commons.p056io.filefilter;

import java.io.File;
import java.io.Serializable;
import me.tvspark.outline;

/* renamed from: org.apache.commons.io.filefilter.SizeFileFilter */
/* loaded from: classes4.dex */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    public static final long serialVersionUID = 7388077430788600069L;
    public final boolean acceptLarger;
    public final long size;

    public SizeFileFilter(long j) {
        this(j, true);
    }

    public SizeFileFilter(long j, boolean z) {
        if (j >= 0) {
            this.size = j;
            this.acceptLarger = z;
            return;
        }
        throw new IllegalArgumentException("The size must be non-negative");
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter, org.apache.commons.p056io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean z = file.length() < this.size;
        return this.acceptLarger ? !z : z;
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter
    public String toString() {
        String str = this.acceptLarger ? ">=" : "<";
        StringBuilder sb = new StringBuilder();
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, super.toString(), "(", str);
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, this.size, ")");
    }
}

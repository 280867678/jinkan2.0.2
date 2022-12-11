package org.apache.commons.p056io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.p056io.FileUtils;

/* renamed from: org.apache.commons.io.comparator.SizeFileComparator */
/* loaded from: classes4.dex */
public class SizeFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> SIZE_COMPARATOR;
    public static final Comparator<File> SIZE_REVERSE;
    public static final Comparator<File> SIZE_SUMDIR_COMPARATOR;
    public static final Comparator<File> SIZE_SUMDIR_REVERSE;
    public static final long serialVersionUID = -1201561106411416190L;
    public final boolean sumDirectoryContents;

    static {
        SizeFileComparator sizeFileComparator = new SizeFileComparator();
        SIZE_COMPARATOR = sizeFileComparator;
        SIZE_REVERSE = new ReverseComparator(sizeFileComparator);
        SizeFileComparator sizeFileComparator2 = new SizeFileComparator(true);
        SIZE_SUMDIR_COMPARATOR = sizeFileComparator2;
        SIZE_SUMDIR_REVERSE = new ReverseComparator(sizeFileComparator2);
    }

    public SizeFileComparator() {
        this.sumDirectoryContents = false;
    }

    public SizeFileComparator(boolean z) {
        this.sumDirectoryContents = z;
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        int i = (((file.isDirectory() ? (!this.sumDirectoryContents || !file.exists()) ? 0L : FileUtils.sizeOfDirectory(file) : file.length()) - (file2.isDirectory() ? (!this.sumDirectoryContents || !file2.exists()) ? 0L : FileUtils.sizeOfDirectory(file2) : file2.length())) > 0L ? 1 : (((file.isDirectory() ? (!this.sumDirectoryContents || !file.exists()) ? 0L : FileUtils.sizeOfDirectory(file) : file.length()) - (file2.isDirectory() ? (!this.sumDirectoryContents || !file2.exists()) ? 0L : FileUtils.sizeOfDirectory(file2) : file2.length())) == 0L ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    @Override // org.apache.commons.p056io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort(list);
    }

    @Override // org.apache.commons.p056io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    @Override // org.apache.commons.p056io.comparator.AbstractFileComparator
    public String toString() {
        return super.toString() + "[sumDirectoryContents=" + this.sumDirectoryContents + "]";
    }
}

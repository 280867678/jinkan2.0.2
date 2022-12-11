package org.apache.commons.p056io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

/* renamed from: org.apache.commons.io.comparator.DefaultFileComparator */
/* loaded from: classes4.dex */
public class DefaultFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> DEFAULT_COMPARATOR;
    public static final Comparator<File> DEFAULT_REVERSE;
    public static final long serialVersionUID = 3260141861365313518L;

    static {
        DefaultFileComparator defaultFileComparator = new DefaultFileComparator();
        DEFAULT_COMPARATOR = defaultFileComparator;
        DEFAULT_REVERSE = new ReverseComparator(defaultFileComparator);
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return file.compareTo(file2);
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
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}

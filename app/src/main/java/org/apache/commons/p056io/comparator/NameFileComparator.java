package org.apache.commons.p056io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.p056io.IOCase;

/* renamed from: org.apache.commons.io.comparator.NameFileComparator */
/* loaded from: classes4.dex */
public class NameFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> NAME_COMPARATOR;
    public static final Comparator<File> NAME_INSENSITIVE_COMPARATOR;
    public static final Comparator<File> NAME_INSENSITIVE_REVERSE;
    public static final Comparator<File> NAME_REVERSE;
    public static final Comparator<File> NAME_SYSTEM_COMPARATOR;
    public static final Comparator<File> NAME_SYSTEM_REVERSE;
    public static final long serialVersionUID = 8397947749814525798L;
    public final IOCase caseSensitivity;

    static {
        NameFileComparator nameFileComparator = new NameFileComparator();
        NAME_COMPARATOR = nameFileComparator;
        NAME_REVERSE = new ReverseComparator(nameFileComparator);
        NameFileComparator nameFileComparator2 = new NameFileComparator(IOCase.INSENSITIVE);
        NAME_INSENSITIVE_COMPARATOR = nameFileComparator2;
        NAME_INSENSITIVE_REVERSE = new ReverseComparator(nameFileComparator2);
        NameFileComparator nameFileComparator3 = new NameFileComparator(IOCase.SYSTEM);
        NAME_SYSTEM_COMPARATOR = nameFileComparator3;
        NAME_SYSTEM_REVERSE = new ReverseComparator(nameFileComparator3);
    }

    public NameFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    public NameFileComparator(IOCase iOCase) {
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return this.caseSensitivity.checkCompareTo(file.getName(), file2.getName());
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
        return super.toString() + "[caseSensitivity=" + this.caseSensitivity + "]";
    }
}

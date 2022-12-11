package org.apache.commons.p056io.comparator;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: org.apache.commons.io.comparator.AbstractFileComparator */
/* loaded from: classes4.dex */
public abstract class AbstractFileComparator implements Comparator<File> {
    public List<File> sort(List<File> list) {
        if (list != null) {
            Collections.sort(list, this);
        }
        return list;
    }

    public File[] sort(File... fileArr) {
        if (fileArr != null) {
            Arrays.sort(fileArr, this);
        }
        return fileArr;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}

package org.apache.commons.p056io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

/* renamed from: org.apache.commons.io.comparator.ReverseComparator */
/* loaded from: classes4.dex */
public class ReverseComparator extends AbstractFileComparator implements Serializable {
    public static final long serialVersionUID = -4808255005272229056L;
    public final Comparator<File> delegate;

    public ReverseComparator(Comparator<File> comparator) {
        if (comparator != null) {
            this.delegate = comparator;
            return;
        }
        throw new IllegalArgumentException("Delegate comparator is missing");
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return this.delegate.compare(file2, file);
    }

    @Override // org.apache.commons.p056io.comparator.AbstractFileComparator
    public String toString() {
        return super.toString() + "[" + this.delegate.toString() + "]";
    }
}

package org.apache.commons.p056io.filefilter;

import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.filefilter.FileFileFilter */
/* loaded from: classes4.dex */
public class FileFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter FILE = new FileFileFilter();
    public static final long serialVersionUID = 5345244090827540862L;

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter, org.apache.commons.p056io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return file.isFile();
    }
}

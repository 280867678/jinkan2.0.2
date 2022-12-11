package org.apache.commons.p056io.filefilter;

import java.util.List;

/* renamed from: org.apache.commons.io.filefilter.ConditionalFileFilter */
/* loaded from: classes4.dex */
public interface ConditionalFileFilter {
    void addFileFilter(IOFileFilter iOFileFilter);

    List<IOFileFilter> getFileFilters();

    boolean removeFileFilter(IOFileFilter iOFileFilter);

    void setFileFilters(List<IOFileFilter> list);
}

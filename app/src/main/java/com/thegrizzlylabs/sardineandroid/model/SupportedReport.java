package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class SupportedReport {
    public Report report;

    public Report getReport() {
        return this.report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}

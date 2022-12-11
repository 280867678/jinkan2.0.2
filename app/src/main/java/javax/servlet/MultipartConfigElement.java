package javax.servlet;

import me.tvspark.wd0;

/* loaded from: classes4.dex */
public class MultipartConfigElement {
    public int fileSizeThreshold;
    public String location;
    public long maxFileSize;
    public long maxRequestSize;

    public MultipartConfigElement(String str) {
        this.location = str == null ? "" : str;
        this.maxFileSize = -1L;
        this.maxRequestSize = -1L;
        this.fileSizeThreshold = 0;
    }

    public MultipartConfigElement(String str, long j, long j2, int i) {
        this.location = str == null ? "" : str;
        this.maxFileSize = j;
        this.maxRequestSize = j2;
        this.fileSizeThreshold = i;
    }

    public MultipartConfigElement(wd0 wd0Var) {
        this.location = wd0Var.location();
        this.fileSizeThreshold = wd0Var.fileSizeThreshold();
        this.maxFileSize = wd0Var.maxFileSize();
        this.maxRequestSize = wd0Var.maxRequestSize();
    }

    public int getFileSizeThreshold() {
        return this.fileSizeThreshold;
    }

    public String getLocation() {
        return this.location;
    }

    public long getMaxFileSize() {
        return this.maxFileSize;
    }

    public long getMaxRequestSize() {
        return this.maxRequestSize;
    }
}

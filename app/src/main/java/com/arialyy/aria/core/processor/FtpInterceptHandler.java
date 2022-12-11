package com.arialyy.aria.core.processor;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class FtpInterceptHandler {
    public boolean coverServerFile;
    public String newFileName;

    /* loaded from: classes3.dex */
    public static final class Builder {
        public String newFileName;
        public boolean coverServerFile = false;
        public boolean stopUpload = false;

        public FtpInterceptHandler build() {
            FtpInterceptHandler ftpInterceptHandler = new FtpInterceptHandler();
            if (this.coverServerFile) {
                ftpInterceptHandler.coverServerFile = true;
            } else if (!TextUtils.isEmpty(this.newFileName)) {
                ftpInterceptHandler.newFileName = this.newFileName;
            }
            return ftpInterceptHandler;
        }

        public Builder coverServerFile() {
            this.coverServerFile = true;
            return this;
        }

        public Builder resetFileName(String str) {
            this.newFileName = str;
            return this;
        }

        public Builder stopUpload() {
            this.stopUpload = true;
            return this;
        }
    }

    public FtpInterceptHandler() {
    }

    public String getNewFileName() {
        return this.newFileName;
    }

    public boolean isCoverServerFile() {
        return this.coverServerFile;
    }
}

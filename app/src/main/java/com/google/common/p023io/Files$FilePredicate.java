package com.google.common.p023io;

import java.io.File;
import me.tvspark.AbstractC2573rt;
import me.tvspark.C2690uy;

/* renamed from: com.google.common.io.Files$FilePredicate */
/* loaded from: classes3.dex */
public enum Files$FilePredicate implements AbstractC2573rt<File> {
    IS_DIRECTORY { // from class: com.google.common.io.Files$FilePredicate.1
        @Override // me.tvspark.AbstractC2573rt
        public boolean apply(File file) {
            return file.isDirectory();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Files.isDirectory()";
        }
    },
    IS_FILE { // from class: com.google.common.io.Files$FilePredicate.2
        @Override // me.tvspark.AbstractC2573rt
        public boolean apply(File file) {
            return file.isFile();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Files.isFile()";
        }
    };

    /* synthetic */ Files$FilePredicate(C2690uy c2690uy) {
        this();
    }
}

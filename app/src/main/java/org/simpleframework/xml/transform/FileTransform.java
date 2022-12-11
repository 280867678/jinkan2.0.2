package org.simpleframework.xml.transform;

import java.io.File;

/* loaded from: classes5.dex */
public class FileTransform implements Transform<File> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read */
    public File mo5334read(String str) {
        return new File(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(File file) {
        return file.getPath();
    }
}

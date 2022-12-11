package org.simpleframework.xml.transform;

import java.net.URL;

/* loaded from: classes5.dex */
public class URLTransform implements Transform<URL> {
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read  reason: collision with other method in class */
    public URL mo5334read(String str) throws Exception {
        return new URL(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(URL url) throws Exception {
        return url.toString();
    }
}

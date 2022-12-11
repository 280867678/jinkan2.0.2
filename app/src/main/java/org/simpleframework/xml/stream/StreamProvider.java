package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import me.tvspark.oe0;
import me.tvspark.qe0;
import me.tvspark.re0;

/* loaded from: classes5.dex */
public class StreamProvider implements Provider {
    public final re0 factory = (re0) oe0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("javax.xml.stream.XMLInputFactory", "com.bea.xml.stream.MXParserFactory");

    private EventReader provide(qe0 qe0Var) throws Exception {
        return new StreamReader(qe0Var);
    }

    @Override // org.simpleframework.xml.stream.Provider
    public EventReader provide(InputStream inputStream) throws Exception {
        return provide(this.factory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream));
    }

    @Override // org.simpleframework.xml.stream.Provider
    public EventReader provide(Reader reader) throws Exception {
        return provide(this.factory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(reader));
    }
}

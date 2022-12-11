package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes5.dex */
public class PullProvider implements Provider {
    public final XmlPullParserFactory factory;

    public PullProvider() throws Exception {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        this.factory = newInstance;
        newInstance.setNamespaceAware(true);
    }

    @Override // org.simpleframework.xml.stream.Provider
    public EventReader provide(InputStream inputStream) throws Exception {
        XmlPullParser newPullParser = this.factory.newPullParser();
        if (inputStream != null) {
            newPullParser.setInput(inputStream, null);
        }
        return new PullReader(newPullParser);
    }

    @Override // org.simpleframework.xml.stream.Provider
    public EventReader provide(Reader reader) throws Exception {
        XmlPullParser newPullParser = this.factory.newPullParser();
        if (reader != null) {
            newPullParser.setInput(reader);
        }
        return new PullReader(newPullParser);
    }
}

package me.tvspark;

import java.util.ArrayList;
import java.util.Collections;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.protocol.HttpDateGenerator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes4.dex */
public final class p50 {
    public static final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {"yyyy-MM-dd'T'HH:mm:ss'Z'", HttpDateGenerator.PATTERN_RFC1123, "yyyy-MM-dd'T'HH:mm:ss.sss'Z'", "yyyy-MM-dd'T'HH:mm:ssZ", "EEE MMM dd HH:mm:ss zzz yyyy", "EEEEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMMM d HH:mm:ss yyyy"};
    public static final DocumentBuilderFactory Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DocumentBuilderFactory.newInstance();

    static {
        ArrayList arrayList = new ArrayList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length);
        for (int i = 0; i < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length; i++) {
            arrayList.add(new ThreadLocal());
        }
        Collections.unmodifiableList(arrayList);
    }

    public static Element Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(QName qName) {
        try {
            Document newDocument = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.newDocumentBuilder().newDocument();
            String namespaceURI = qName.getNamespaceURI();
            return newDocument.createElementNS(namespaceURI, qName.getPrefix() + ":" + qName.getLocalPart());
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}

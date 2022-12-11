package org.fourthline.cling.support.lastchange;

import java.io.InputStream;
import java.io.StringReader;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import me.tvspark.outline;
import org.fourthline.cling.model.XMLUtil;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.shared.AbstractMap;
import org.seamless.util.Exceptions;
import org.seamless.util.p061io.C3387IO;
import org.seamless.xml.DOMParser;
import org.seamless.xml.SAXParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public abstract class LastChangeParser extends SAXParser {
    public static final Logger log = Logger.getLogger(LastChangeParser.class.getName());

    /* loaded from: classes5.dex */
    public enum CONSTANTS {
        Event,
        InstanceID,
        val;

        public boolean equals(String str) {
            return name().equals(str);
        }
    }

    /* loaded from: classes5.dex */
    public class InstanceIDHandler extends SAXParser.Handler<InstanceID> {
        public InstanceIDHandler(InstanceID instanceID, SAXParser.Handler handler) {
            super(instanceID, handler);
        }

        @Override // org.seamless.xml.SAXParser.Handler
        public boolean isLastElement(String str, String str2, String str3) {
            return CONSTANTS.InstanceID.equals(str2);
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            super.startElement(str, str2, str3, attributes);
            int length = attributes.getLength();
            Map.Entry<String, String>[] entryArr = new Map.Entry[length];
            for (int i = 0; i < length; i++) {
                entryArr[i] = new AbstractMap.SimpleEntry(attributes.getLocalName(i), attributes.getValue(i));
            }
            try {
                EventedValue createValue = LastChangeParser.this.createValue(str2, entryArr);
                if (createValue == null) {
                    return;
                }
                getInstance().getValues().add(createValue);
            } catch (Exception e) {
                Logger logger = LastChangeParser.log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error reading event XML, ignoring value: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Exceptions.unwrap(e));
                logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class RootHandler extends SAXParser.Handler<Event> {
        public RootHandler(Event event) {
            super(event);
        }

        public RootHandler(Event event, SAXParser sAXParser) {
            super(event, sAXParser);
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            super.startElement(str, str2, str3, attributes);
            if (CONSTANTS.InstanceID.equals(str2)) {
                CONSTANTS constants = CONSTANTS.val;
                String value = attributes.getValue("val");
                if (value == null) {
                    return;
                }
                InstanceID instanceID = new InstanceID(new UnsignedIntegerFourBytes(value));
                getInstance().getInstanceIDs().add(instanceID);
                new InstanceIDHandler(instanceID, this);
            }
        }
    }

    public Document buildDOM(Event event) throws Exception {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        Document newDocument = newInstance.newDocumentBuilder().newDocument();
        generateRoot(event, newDocument);
        return newDocument;
    }

    public EventedValue createValue(String str, Map.Entry<String, String>[] entryArr) throws Exception {
        for (Class<? extends EventedValue> cls : getEventedVariables()) {
            if (cls.getSimpleName().equals(str)) {
                return cls.getConstructor(Map.Entry[].class).newInstance(entryArr);
            }
        }
        return null;
    }

    public String generate(Event event) throws Exception {
        return XMLUtil.documentToFragmentString(buildDOM(event));
    }

    public void generateEventedValue(EventedValue eventedValue, Document document, Element element) {
        String name = eventedValue.getName();
        Map.Entry<String, String>[] attributes = eventedValue.getAttributes();
        if (attributes == null || attributes.length <= 0) {
            return;
        }
        Element appendNewElement = XMLUtil.appendNewElement(document, element, name);
        for (Map.Entry<String, String> entry : attributes) {
            appendNewElement.setAttribute(entry.getKey(), DOMParser.escape(entry.getValue()));
        }
    }

    public void generateInstanceIDs(Event event, Document document, Element element) {
        for (InstanceID instanceID : event.getInstanceIDs()) {
            if (instanceID.getId() != null) {
                CONSTANTS constants = CONSTANTS.InstanceID;
                Element appendNewElement = XMLUtil.appendNewElement(document, element, "InstanceID");
                CONSTANTS constants2 = CONSTANTS.val;
                appendNewElement.setAttribute("val", instanceID.getId().toString());
                for (EventedValue eventedValue : instanceID.getValues()) {
                    generateEventedValue(eventedValue, document, appendNewElement);
                }
            }
        }
    }

    public void generateRoot(Event event, Document document) {
        String namespace = getNamespace();
        CONSTANTS constants = CONSTANTS.Event;
        Element createElementNS = document.createElementNS(namespace, "Event");
        document.appendChild(createElementNS);
        generateInstanceIDs(event, document, createElementNS);
    }

    public Set<Class<? extends EventedValue>> getEventedVariables() {
        return Collections.EMPTY_SET;
    }

    public abstract String getNamespace();

    public Event parse(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("Null or empty XML");
        }
        Event event = new Event();
        new RootHandler(event, this);
        if (log.isLoggable(Level.FINE)) {
            log.fine("Parsing 'LastChange' event XML content");
            log.fine("===================================== 'LastChange' BEGIN ============================================");
            log.fine(str);
            log.fine("====================================== 'LastChange' END  ============================================");
        }
        parse(new InputSource(new StringReader(str)));
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Parsed event with instances IDs: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(event.getInstanceIDs().size());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (log.isLoggable(Level.FINEST)) {
            for (InstanceID instanceID : event.getInstanceIDs()) {
                Logger logger2 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("InstanceID '");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(instanceID.getId());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("' has values: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(instanceID.getValues().size());
                logger2.finest(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                for (EventedValue eventedValue : instanceID.getValues()) {
                    Logger logger3 = log;
                    logger3.finest(eventedValue.getName() + " => " + eventedValue.getValue());
                }
            }
        }
        return event;
    }

    public Event parseResource(String str) throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(str);
            Event parse = parse(C3387IO.readLines(inputStream));
            inputStream.close();
            return parse;
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}

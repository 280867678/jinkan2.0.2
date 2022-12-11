package org.simpleframework.xml.stream;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class PullReader implements EventReader {
    public XmlPullParser parser;
    public EventNode peek;

    /* loaded from: classes5.dex */
    public static class End extends EventToken {
        public End() {
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public boolean isEnd() {
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public static class Entry extends EventAttribute {
        public final String name;
        public final String prefix;
        public final String reference;
        public final XmlPullParser source;
        public final String value;

        public Entry(XmlPullParser xmlPullParser, int i) {
            this.reference = xmlPullParser.getAttributeNamespace(i);
            this.prefix = xmlPullParser.getAttributePrefix(i);
            this.value = xmlPullParser.getAttributeValue(i);
            this.name = xmlPullParser.getAttributeName(i);
            this.source = xmlPullParser;
        }

        @Override // org.simpleframework.xml.stream.Attribute
        public String getName() {
            return this.name;
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public String getPrefix() {
            return this.prefix;
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public String getReference() {
            return this.reference;
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public Object getSource() {
            return this.source;
        }

        @Override // org.simpleframework.xml.stream.Attribute
        public String getValue() {
            return this.value;
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public boolean isReserved() {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public static class Start extends EventElement {
        public final int line;
        public final String name;
        public final String prefix;
        public final String reference;
        public final XmlPullParser source;

        public Start(XmlPullParser xmlPullParser) {
            this.reference = xmlPullParser.getNamespace();
            this.line = xmlPullParser.getLineNumber();
            this.prefix = xmlPullParser.getPrefix();
            this.name = xmlPullParser.getName();
            this.source = xmlPullParser;
        }

        @Override // org.simpleframework.xml.stream.EventElement, org.simpleframework.xml.stream.EventNode
        public int getLine() {
            return this.line;
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getName() {
            return this.name;
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getPrefix() {
            return this.prefix;
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getReference() {
            return this.reference;
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public Object getSource() {
            return this.source;
        }
    }

    /* loaded from: classes5.dex */
    public static class Text extends EventToken {
        public final XmlPullParser source;
        public final String text;

        public Text(XmlPullParser xmlPullParser) {
            this.text = xmlPullParser.getText();
            this.source = xmlPullParser;
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public Object getSource() {
            return this.source;
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public String getValue() {
            return this.text;
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public boolean isText() {
            return true;
        }
    }

    public PullReader(XmlPullParser xmlPullParser) {
        this.parser = xmlPullParser;
    }

    private Entry attribute(int i) throws Exception {
        return new Entry(this.parser, i);
    }

    private Start build(Start start) throws Exception {
        int attributeCount = this.parser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            Entry attribute = attribute(i);
            if (!attribute.isReserved()) {
                start.add(attribute);
            }
        }
        return start;
    }

    private End end() throws Exception {
        return new End();
    }

    private EventNode read() throws Exception {
        int next = this.parser.next();
        if (next != 1) {
            return next == 2 ? start() : next == 4 ? text() : next == 3 ? end() : read();
        }
        return null;
    }

    private Start start() throws Exception {
        Start start = new Start(this.parser);
        return start.isEmpty() ? build(start) : start;
    }

    private Text text() throws Exception {
        return new Text(this.parser);
    }

    @Override // org.simpleframework.xml.stream.EventReader
    public EventNode next() throws Exception {
        EventNode eventNode = this.peek;
        if (eventNode == null) {
            return read();
        }
        this.peek = null;
        return eventNode;
    }

    @Override // org.simpleframework.xml.stream.EventReader
    public EventNode peek() throws Exception {
        if (this.peek == null) {
            this.peek = next();
        }
        return this.peek;
    }
}

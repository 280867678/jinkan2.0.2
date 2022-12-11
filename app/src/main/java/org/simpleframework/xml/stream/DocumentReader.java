package org.simpleframework.xml.stream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/* loaded from: classes5.dex */
public class DocumentReader implements EventReader {
    public static final String RESERVED = "xml";
    public EventNode peek;
    public NodeExtractor queue;
    public NodeStack stack;

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
        public final org.w3c.dom.Node node;

        public Entry(org.w3c.dom.Node node) {
            this.node = node;
        }

        @Override // org.simpleframework.xml.stream.Attribute
        public String getName() {
            return this.node.getLocalName();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public String getPrefix() {
            return this.node.getPrefix();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public String getReference() {
            return this.node.getNamespaceURI();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public Object getSource() {
            return this.node;
        }

        @Override // org.simpleframework.xml.stream.Attribute
        public String getValue() {
            return this.node.getNodeValue();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public boolean isReserved() {
            String prefix = getPrefix();
            return prefix != null ? prefix.startsWith(DocumentReader.RESERVED) : getName().startsWith(DocumentReader.RESERVED);
        }
    }

    /* loaded from: classes5.dex */
    public static class Start extends EventElement {
        public final Element element;

        public Start(org.w3c.dom.Node node) {
            this.element = (Element) node;
        }

        public NamedNodeMap getAttributes() {
            return this.element.getAttributes();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getName() {
            return this.element.getLocalName();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getPrefix() {
            return this.element.getPrefix();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getReference() {
            return this.element.getNamespaceURI();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public Object getSource() {
            return this.element;
        }
    }

    /* loaded from: classes5.dex */
    public static class Text extends EventToken {
        public final org.w3c.dom.Node node;

        public Text(org.w3c.dom.Node node) {
            this.node = node;
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public Object getSource() {
            return this.node;
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public String getValue() {
            return this.node.getNodeValue();
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public boolean isText() {
            return true;
        }
    }

    public DocumentReader(Document document) {
        this.queue = new NodeExtractor(document);
        NodeStack nodeStack = new NodeStack();
        this.stack = nodeStack;
        nodeStack.push(document);
    }

    private Entry attribute(org.w3c.dom.Node node) {
        return new Entry(node);
    }

    private Start build(Start start) {
        NamedNodeMap attributes = start.getAttributes();
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            Entry attribute = attribute(attributes.item(i));
            if (!attribute.isReserved()) {
                start.add(attribute);
            }
        }
        return start;
    }

    private EventNode convert(org.w3c.dom.Node node) throws Exception {
        if (node.getNodeType() == 1) {
            this.stack.push(node);
            return start(node);
        }
        return text(node);
    }

    private End end() {
        return new End();
    }

    private EventNode read() throws Exception {
        org.w3c.dom.Node peek = this.queue.peek();
        return peek == null ? end() : read(peek);
    }

    private EventNode read(org.w3c.dom.Node node) throws Exception {
        org.w3c.dom.Node parentNode = node.getParentNode();
        org.w3c.dom.Node pVar = this.stack.top();
        if (parentNode == pVar) {
            this.queue.poll();
            return convert(node);
        }
        if (pVar != null) {
            this.stack.pop();
        }
        return end();
    }

    private Start start(org.w3c.dom.Node node) {
        Start start = new Start(node);
        return start.isEmpty() ? build(start) : start;
    }

    private Text text(org.w3c.dom.Node node) {
        return new Text(node);
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

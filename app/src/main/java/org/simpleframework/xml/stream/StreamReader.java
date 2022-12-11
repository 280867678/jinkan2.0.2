package org.simpleframework.xml.stream;

import java.util.Iterator;
import me.tvspark.pe0;
import me.tvspark.qe0;
import me.tvspark.se0;
import me.tvspark.te0;
import me.tvspark.ue0;
import me.tvspark.ve0;

/* loaded from: classes5.dex */
public class StreamReader implements EventReader {
    public EventNode peek;
    public qe0 reader;

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
        public final se0 entry;

        public Entry(se0 se0Var) {
            this.entry = se0Var;
        }

        @Override // org.simpleframework.xml.stream.Attribute
        public String getName() {
            return this.entry.getName().getLocalPart();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public String getPrefix() {
            return this.entry.getName().getPrefix();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public String getReference() {
            return this.entry.getName().getNamespaceURI();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public Object getSource() {
            return this.entry;
        }

        @Override // org.simpleframework.xml.stream.Attribute
        public String getValue() {
            return this.entry.getValue();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public boolean isReserved() {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public static class Start extends EventElement {
        public final ue0 element;
        public final pe0 location;

        public Start(ve0 ve0Var) {
            this.element = ve0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.location = ve0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public Iterator<se0> getAttributes() {
            return this.element.getAttributes();
        }

        @Override // org.simpleframework.xml.stream.EventElement, org.simpleframework.xml.stream.EventNode
        public int getLine() {
            return this.location.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getName() {
            return this.element.getName().getLocalPart();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getPrefix() {
            return this.element.getName().getPrefix();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getReference() {
            return this.element.getName().getNamespaceURI();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public Object getSource() {
            return this.element;
        }
    }

    /* loaded from: classes5.dex */
    public static class Text extends EventToken {
        public final te0 text;

        public Text(ve0 ve0Var) {
            this.text = ve0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public Object getSource() {
            return this.text;
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public String getValue() {
            return this.text.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public boolean isText() {
            return true;
        }
    }

    public StreamReader(qe0 qe0Var) {
        this.reader = qe0Var;
    }

    private Entry attribute(se0 se0Var) {
        return new Entry(se0Var);
    }

    private Start build(Start start) {
        Iterator<se0> attributes = start.getAttributes();
        while (attributes.hasNext()) {
            Entry attribute = attribute(attributes.next());
            if (!attribute.isReserved()) {
                start.add(attribute);
            }
        }
        return start;
    }

    private End end() {
        return new End();
    }

    private EventNode read() throws Exception {
        ve0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.reader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? start(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? text(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? end() : read();
        }
        return null;
    }

    private Start start(ve0 ve0Var) {
        Start start = new Start(ve0Var);
        return start.isEmpty() ? build(start) : start;
    }

    private Text text(ve0 ve0Var) {
        return new Text(ve0Var);
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

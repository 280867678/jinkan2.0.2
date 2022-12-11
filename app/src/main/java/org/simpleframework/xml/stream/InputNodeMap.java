package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes5.dex */
public class InputNodeMap extends LinkedHashMap<String, InputNode> implements NodeMap<InputNode> {
    public final InputNode source;

    public InputNodeMap(InputNode inputNode) {
        this.source = inputNode;
    }

    public InputNodeMap(InputNode inputNode, EventNode eventNode) {
        this.source = inputNode;
        build(eventNode);
    }

    private void build(EventNode eventNode) {
        for (Attribute attribute : eventNode) {
            InputAttribute inputAttribute = new InputAttribute(this.source, attribute);
            if (!attribute.isReserved()) {
                put((InputNodeMap) inputAttribute.getName(), (String) inputAttribute);
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.stream.NodeMap
    /* renamed from: get */
    public InputNode mo5312get(String str) {
        return (InputNode) super.get((Object) str);
    }

    @Override // org.simpleframework.xml.stream.NodeMap
    public String getName() {
        return this.source.getName();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.stream.NodeMap
    /* renamed from: getNode */
    public InputNode mo5313getNode() {
        return this.source;
    }

    @Override // org.simpleframework.xml.stream.NodeMap, java.lang.Iterable
    public Iterator<String> iterator() {
        return keySet().iterator();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.stream.NodeMap
    /* renamed from: put */
    public InputNode mo5314put(String str, String str2) {
        InputAttribute inputAttribute = new InputAttribute(this.source, str, str2);
        if (str != null) {
            put((InputNodeMap) str, (String) inputAttribute);
        }
        return inputAttribute;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.stream.NodeMap
    /* renamed from: remove */
    public InputNode mo5315remove(String str) {
        return (InputNode) super.remove((Object) str);
    }
}

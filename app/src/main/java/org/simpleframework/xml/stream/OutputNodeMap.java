package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes5.dex */
public class OutputNodeMap extends LinkedHashMap<String, OutputNode> implements NodeMap<OutputNode> {
    public final OutputNode source;

    public OutputNodeMap(OutputNode outputNode) {
        this.source = outputNode;
    }

    @Override // org.simpleframework.xml.stream.NodeMap
    /* renamed from: get  reason: collision with other method in class */
    public OutputNode mo5312get(String str) {
        return (OutputNode) super.get((Object) str);
    }

    @Override // org.simpleframework.xml.stream.NodeMap
    public String getName() {
        return this.source.getName();
    }

    @Override // org.simpleframework.xml.stream.NodeMap
    /* renamed from: getNode  reason: collision with other method in class */
    public OutputNode mo5313getNode() {
        return this.source;
    }

    @Override // org.simpleframework.xml.stream.NodeMap, java.lang.Iterable
    public Iterator<String> iterator() {
        return keySet().iterator();
    }

    @Override // org.simpleframework.xml.stream.NodeMap
    /* renamed from: put  reason: collision with other method in class */
    public OutputNode mo5314put(String str, String str2) {
        OutputAttribute outputAttribute = new OutputAttribute(this.source, str, str2);
        if (this.source != null) {
            put((OutputNodeMap) str, (String) outputAttribute);
        }
        return outputAttribute;
    }

    @Override // org.simpleframework.xml.stream.NodeMap
    /* renamed from: remove  reason: collision with other method in class */
    public OutputNode mo5315remove(String str) {
        return (OutputNode) super.remove((Object) str);
    }
}

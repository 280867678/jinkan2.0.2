package org.simpleframework.xml.strategy;

import java.util.HashMap;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

/* loaded from: classes5.dex */
public class ReadGraph extends HashMap {
    public final String label;
    public final String length;
    public final Loader loader;
    public final String mark;
    public final String refer;

    public ReadGraph(Contract contract, Loader loader) {
        this.refer = contract.getReference();
        this.mark = contract.getIdentity();
        this.length = contract.getLength();
        this.label = contract.getLabel();
        this.loader = loader;
    }

    private Value readArray(Type type, Class cls, NodeMap nodeMap) throws Exception {
        Node mo5315remove = nodeMap.mo5315remove(this.length);
        return new ArrayValue(cls, mo5315remove != null ? Integer.parseInt(mo5315remove.getValue()) : 0);
    }

    private Value readInstance(Type type, Class cls, NodeMap nodeMap) throws Exception {
        Node mo5315remove = nodeMap.mo5315remove(this.mark);
        if (mo5315remove == null) {
            return readReference(type, cls, nodeMap);
        }
        String value = mo5315remove.getValue();
        if (containsKey(value)) {
            throw new CycleException("Element '%s' already exists", value);
        }
        return readValue(type, cls, nodeMap, value);
    }

    private Value readReference(Type type, Class cls, NodeMap nodeMap) throws Exception {
        Node mo5315remove = nodeMap.mo5315remove(this.refer);
        if (mo5315remove == null) {
            return readValue(type, cls, nodeMap);
        }
        String value = mo5315remove.getValue();
        Object obj = get(value);
        if (!containsKey(value)) {
            throw new CycleException("Invalid reference '%s' found", value);
        }
        return new Reference(obj, cls);
    }

    private Value readValue(Type type, Class cls, NodeMap nodeMap) throws Exception {
        return type.getType().isArray() ? readArray(type, cls, nodeMap) : new ObjectValue(cls);
    }

    private Value readValue(Type type, Class cls, NodeMap nodeMap, String str) throws Exception {
        Value readValue = readValue(type, cls, nodeMap);
        return str != null ? new Allocate(readValue, this, str) : readValue;
    }

    public Value read(Type type, NodeMap nodeMap) throws Exception {
        Node mo5315remove = nodeMap.mo5315remove(this.label);
        Class<?> type2 = type.getType();
        if (type2.isArray()) {
            type2 = type2.getComponentType();
        }
        if (mo5315remove != null) {
            type2 = this.loader.load(mo5315remove.getValue());
        }
        return readInstance(type, type2, nodeMap);
    }
}

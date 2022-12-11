package org.simpleframework.xml.strategy;

import java.lang.reflect.Array;
import java.util.Map;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

/* loaded from: classes5.dex */
public class TreeStrategy implements Strategy {
    public final String label;
    public final String length;
    public final Loader loader;

    public TreeStrategy() {
        this("class", Name.LENGTH);
    }

    public TreeStrategy(String str, String str2) {
        this.loader = new Loader();
        this.length = str2;
        this.label = str;
    }

    private Value readArray(Class cls, NodeMap nodeMap) throws Exception {
        Node mo5315remove = nodeMap.mo5315remove(this.length);
        return new ArrayValue(cls, mo5315remove != null ? Integer.parseInt(mo5315remove.getValue()) : 0);
    }

    private Class readValue(Type type, NodeMap nodeMap) throws Exception {
        Node mo5315remove = nodeMap.mo5315remove(this.label);
        Class<?> type2 = type.getType();
        if (type2.isArray()) {
            type2 = type2.getComponentType();
        }
        if (mo5315remove != null) {
            return this.loader.load(mo5315remove.getValue());
        }
        return type2;
    }

    private Class writeArray(Class cls, Object obj, NodeMap nodeMap) {
        int length = Array.getLength(obj);
        String str = this.length;
        if (str != null) {
            nodeMap.mo5314put(str, String.valueOf(length));
        }
        return cls.getComponentType();
    }

    @Override // org.simpleframework.xml.strategy.Strategy
    public Value read(Type type, NodeMap nodeMap, Map map) throws Exception {
        Class readValue = readValue(type, nodeMap);
        Class type2 = type.getType();
        if (type2.isArray()) {
            return readArray(readValue, nodeMap);
        }
        if (type2 == readValue) {
            return null;
        }
        return new ObjectValue(readValue);
    }

    @Override // org.simpleframework.xml.strategy.Strategy
    public boolean write(Type type, Object obj, NodeMap nodeMap, Map map) {
        Class<?> cls = obj.getClass();
        Class<?> type2 = type.getType();
        Class<?> writeArray = cls.isArray() ? writeArray(type2, obj, nodeMap) : cls;
        if (cls != type2) {
            nodeMap.mo5314put(this.label, writeArray.getName());
            return false;
        }
        return false;
    }
}

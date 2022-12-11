package org.simpleframework.xml.convert;

import java.util.Map;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes5.dex */
public class AnnotationStrategy implements Strategy {
    public final ConverterScanner scanner;
    public final Strategy strategy;

    public AnnotationStrategy() {
        this(new TreeStrategy());
    }

    public AnnotationStrategy(Strategy strategy) {
        this.scanner = new ConverterScanner();
        this.strategy = strategy;
    }

    private boolean isReference(Value value) {
        return value != null && value.isReference();
    }

    private Value read(Type type, NodeMap<InputNode> nodeMap, Value value) throws Exception {
        Converter converter = this.scanner.getConverter(type, value);
        InputNode mo5313getNode = nodeMap.mo5313getNode();
        if (converter != null) {
            Object mo4863read = converter.mo4863read(mo5313getNode);
            Class type2 = type.getType();
            if (value != null) {
                value.setValue(mo4863read);
            }
            return new Reference(value, mo4863read, type2);
        }
        return value;
    }

    private boolean write(Type type, Object obj, NodeMap<OutputNode> nodeMap) throws Exception {
        Converter converter = this.scanner.getConverter(type, obj);
        OutputNode mo5313getNode = nodeMap.mo5313getNode();
        if (converter != null) {
            converter.write(mo5313getNode, obj);
            return true;
        }
        return false;
    }

    @Override // org.simpleframework.xml.strategy.Strategy
    public Value read(Type type, NodeMap<InputNode> nodeMap, Map map) throws Exception {
        Value read = this.strategy.read(type, nodeMap, map);
        return isReference(read) ? read : read(type, nodeMap, read);
    }

    @Override // org.simpleframework.xml.strategy.Strategy
    public boolean write(Type type, Object obj, NodeMap<OutputNode> nodeMap, Map map) throws Exception {
        boolean write = this.strategy.write(type, obj, nodeMap, map);
        return !write ? write(type, obj, nodeMap) : write;
    }
}

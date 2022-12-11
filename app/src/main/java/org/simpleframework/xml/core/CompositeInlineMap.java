package org.simpleframework.xml.core;

import java.util.Map;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

/* loaded from: classes5.dex */
public class CompositeInlineMap implements Repeater {
    public final Entry entry;
    public final MapFactory factory;
    public final Converter key;
    public final Style style;
    public final Converter value;

    public CompositeInlineMap(Context context, Entry entry, Type type) throws Exception {
        this.factory = new MapFactory(context, type);
        this.value = entry.getValue(context);
        this.key = entry.getKey(context);
        this.style = context.getStyle();
        this.entry = entry;
    }

    private Object read(InputNode inputNode, Map map) throws Exception {
        InputNode mo5311getParent = inputNode.mo5311getParent();
        String name = inputNode.getName();
        while (inputNode != null) {
            Object read = this.key.read(inputNode);
            Object read2 = this.value.read(inputNode);
            if (map != null) {
                map.put(read, read2);
            }
            inputNode = mo5311getParent.getNext(name);
        }
        return map;
    }

    private void write(OutputNode outputNode, Map map, Mode mode) throws Exception {
        String element = this.style.getElement(this.entry.getEntry());
        for (Object obj : map.keySet()) {
            OutputNode child = outputNode.getChild(element);
            Object obj2 = map.get(obj);
            child.setMode(mode);
            this.key.write(child, obj);
            this.value.write(child, obj2);
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws Exception {
        Map map = (Map) this.factory.getInstance();
        if (map != null) {
            return read(inputNode, map);
        }
        return null;
    }

    @Override // org.simpleframework.xml.core.Repeater, org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws Exception {
        Map map = (Map) obj;
        return map != null ? read(inputNode, map) : read(inputNode);
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) throws Exception {
        InputNode mo5311getParent = inputNode.mo5311getParent();
        String name = inputNode.getName();
        while (inputNode != null) {
            if (!this.key.validate(inputNode) || !this.value.validate(inputNode)) {
                return false;
            }
            inputNode = mo5311getParent.getNext(name);
        }
        return true;
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws Exception {
        OutputNode mo5311getParent = outputNode.mo5311getParent();
        Mode mode = outputNode.getMode();
        Map map = (Map) obj;
        if (!outputNode.isCommitted()) {
            outputNode.remove();
        }
        write(mo5311getParent, map, mode);
    }
}

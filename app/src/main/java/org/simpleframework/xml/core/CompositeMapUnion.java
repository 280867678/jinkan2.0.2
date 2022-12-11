package org.simpleframework.xml.core;

import java.util.Collections;
import java.util.Map;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

/* loaded from: classes5.dex */
public class CompositeMapUnion implements Repeater {
    public final Context context;
    public final LabelMap elements;
    public final Group group;
    public final Expression path;
    public final Style style;
    public final Type type;

    public CompositeMapUnion(Context context, Group group, Expression expression, Type type) throws Exception {
        this.elements = group.getElements();
        this.style = context.getStyle();
        this.context = context;
        this.group = group;
        this.type = type;
        this.path = expression;
    }

    private void write(OutputNode outputNode, Object obj, Object obj2, Label label) throws Exception {
        Converter converter = label.getConverter(this.context);
        Map singletonMap = Collections.singletonMap(obj, obj2);
        if (!label.isInline()) {
            String element = this.style.getElement(label.getName());
            if (!outputNode.isCommitted()) {
                outputNode.setName(element);
            }
        }
        converter.write(outputNode, singletonMap);
    }

    private void write(OutputNode outputNode, Map map) throws Exception {
        for (Object obj : map.keySet()) {
            Object obj2 = map.get(obj);
            if (obj2 != null) {
                Class<?> cls = obj2.getClass();
                Label label = this.group.getLabel(cls);
                if (label == null) {
                    throw new UnionException("Value of %s not declared in %s with annotation %s", cls, this.type, this.group);
                }
                write(outputNode, obj, obj2, label);
            }
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws Exception {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).read(inputNode);
    }

    @Override // org.simpleframework.xml.core.Repeater, org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws Exception {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).read(inputNode, obj);
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) throws Exception {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).validate(inputNode);
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws Exception {
        Map map = (Map) obj;
        if (!this.group.isInline() || !map.isEmpty()) {
            write(outputNode, map);
        } else if (outputNode.isCommitted()) {
        } else {
            outputNode.remove();
        }
    }
}

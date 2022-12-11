package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes5.dex */
public class CompositeUnion implements Converter {
    public final Context context;
    public final LabelMap elements;
    public final Group group;
    public final Expression path;
    public final Type type;

    public CompositeUnion(Context context, Group group, Expression expression, Type type) throws Exception {
        this.elements = group.getElements();
        this.context = context;
        this.group = group;
        this.type = type;
        this.path = expression;
    }

    private void write(OutputNode outputNode, Object obj, Label label) throws Exception {
        label.getConverter(this.context).write(outputNode, obj);
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws Exception {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).read(inputNode);
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws Exception {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).read(inputNode, obj);
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) throws Exception {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).validate(inputNode);
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        Label label = this.group.getLabel(cls);
        if (label != null) {
            write(outputNode, obj, label);
            return;
        }
        throw new UnionException("Value of %s not declared in %s with annotation %s", cls, this.type, this.group);
    }
}

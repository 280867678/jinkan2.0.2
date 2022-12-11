package org.simpleframework.xml.core;

import java.util.Collection;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes5.dex */
public class PrimitiveInlineList implements Repeater {
    public final Type entry;
    public final CollectionFactory factory;
    public final String parent;
    public final Primitive root;

    public PrimitiveInlineList(Context context, Type type, Type type2, String str) {
        this.factory = new CollectionFactory(context, type);
        this.root = new Primitive(context, type2);
        this.parent = str;
        this.entry = type2;
    }

    private boolean isOverridden(OutputNode outputNode, Object obj) throws Exception {
        return this.factory.setOverride(this.entry, obj, outputNode);
    }

    private Object read(InputNode inputNode, Collection collection) throws Exception {
        InputNode mo5311getParent = inputNode.mo5311getParent();
        String name = inputNode.getName();
        while (inputNode != null) {
            Object read = this.root.read(inputNode);
            if (read != null) {
                collection.add(read);
            }
            inputNode = mo5311getParent.getNext(name);
        }
        return collection;
    }

    private void write(OutputNode outputNode, Object obj, Mode mode) throws Exception {
        for (Object obj2 : (Collection) obj) {
            if (obj2 != null) {
                OutputNode child = outputNode.getChild(this.parent);
                if (!isOverridden(child, obj2)) {
                    child.setMode(mode);
                    this.root.write(child, obj2);
                }
            }
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws Exception {
        Collection collection = (Collection) this.factory.getInstance();
        if (collection != null) {
            return read(inputNode, collection);
        }
        return null;
    }

    @Override // org.simpleframework.xml.core.Repeater, org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws Exception {
        Collection collection = (Collection) obj;
        return collection != null ? read(inputNode, collection) : read(inputNode);
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) throws Exception {
        InputNode mo5311getParent = inputNode.mo5311getParent();
        String name = inputNode.getName();
        while (inputNode != null) {
            if (!this.root.validate(inputNode)) {
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
        if (!outputNode.isCommitted()) {
            outputNode.remove();
        }
        write(mo5311getParent, obj, mode);
    }
}

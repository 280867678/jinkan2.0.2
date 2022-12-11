package org.simpleframework.xml.core;

import java.util.Collection;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes5.dex */
public class CompositeInlineList implements Repeater {
    public final Type entry;
    public final CollectionFactory factory;
    public final String name;
    public final Traverser root;
    public final Type type;

    public CompositeInlineList(Context context, Type type, Type type2, String str) {
        this.factory = new CollectionFactory(context, type);
        this.root = new Traverser(context);
        this.entry = type2;
        this.type = type;
        this.name = str;
    }

    private Object read(InputNode inputNode, Class cls) throws Exception {
        Object read = this.root.read(inputNode, cls);
        Class<?> cls2 = read.getClass();
        if (this.entry.getType().isAssignableFrom(cls2)) {
            return read;
        }
        throw new PersistenceException("Entry %s does not match %s for %s", cls2, this.entry, this.type);
    }

    private Object read(InputNode inputNode, Collection collection) throws Exception {
        InputNode mo5311getParent = inputNode.mo5311getParent();
        String name = inputNode.getName();
        while (inputNode != null) {
            Object read = read(inputNode, this.entry.getType());
            if (read != null) {
                collection.add(read);
            }
            inputNode = mo5311getParent.getNext(name);
        }
        return collection;
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
        Class type = this.entry.getType();
        String name = inputNode.getName();
        while (inputNode != null) {
            if (!this.root.validate(inputNode, type)) {
                return false;
            }
            inputNode = mo5311getParent.getNext(name);
        }
        return true;
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws Exception {
        Collection collection = (Collection) obj;
        OutputNode mo5311getParent = outputNode.mo5311getParent();
        if (!outputNode.isCommitted()) {
            outputNode.remove();
        }
        write(mo5311getParent, collection);
    }

    public void write(OutputNode outputNode, Collection collection) throws Exception {
        for (Object obj : collection) {
            if (obj != null) {
                Class type = this.entry.getType();
                Class<?> cls = obj.getClass();
                if (!type.isAssignableFrom(cls)) {
                    throw new PersistenceException("Entry %s does not match %s for %s", cls, type, this.type);
                }
                this.root.write(outputNode, obj, type, this.name);
            }
        }
    }
}

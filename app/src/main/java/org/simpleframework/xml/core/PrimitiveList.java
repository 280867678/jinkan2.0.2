package org.simpleframework.xml.core;

import java.util.Collection;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes5.dex */
public class PrimitiveList implements Converter {
    public final Type entry;
    public final CollectionFactory factory;
    public final String parent;
    public final Primitive root;

    public PrimitiveList(Context context, Type type, Type type2, String str) {
        this.factory = new CollectionFactory(context, type);
        this.root = new Primitive(context, type2);
        this.parent = str;
        this.entry = type2;
    }

    private boolean isOverridden(OutputNode outputNode, Object obj) throws Exception {
        return this.factory.setOverride(this.entry, obj, outputNode);
    }

    private Object populate(InputNode inputNode, Object obj) throws Exception {
        Collection collection = (Collection) obj;
        while (true) {
            InputNode next = inputNode.getNext();
            if (next == null) {
                return collection;
            }
            collection.add(this.root.read(next));
        }
    }

    private boolean validate(InputNode inputNode, Class cls) throws Exception {
        while (true) {
            InputNode next = inputNode.getNext();
            if (next == null) {
                return true;
            }
            this.root.validate(next);
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws Exception {
        Instance collectionFactory = this.factory.getInstance(inputNode);
        Object instance = collectionFactory.getInstance();
        return !collectionFactory.isReference() ? populate(inputNode, instance) : instance;
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws Exception {
        Instance collectionFactory = this.factory.getInstance(inputNode);
        if (collectionFactory.isReference()) {
            return collectionFactory.getInstance();
        }
        collectionFactory.setInstance(obj);
        return obj != null ? populate(inputNode, obj) : obj;
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) throws Exception {
        Instance collectionFactory = this.factory.getInstance(inputNode);
        if (!collectionFactory.isReference()) {
            collectionFactory.setInstance(null);
            return validate(inputNode, collectionFactory.getType());
        }
        return true;
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws Exception {
        for (Object obj2 : (Collection) obj) {
            if (obj2 != null) {
                OutputNode child = outputNode.getChild(this.parent);
                if (!isOverridden(child, obj2)) {
                    this.root.write(child, obj2);
                }
            }
        }
    }
}

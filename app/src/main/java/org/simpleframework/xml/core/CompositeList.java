package org.simpleframework.xml.core;

import java.util.Collection;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes5.dex */
public class CompositeList implements Converter {
    public final Type entry;
    public final CollectionFactory factory;
    public final String name;
    public final Traverser root;
    public final Type type;

    public CompositeList(Context context, Type type, Type type2, String str) {
        this.factory = new CollectionFactory(context, type);
        this.root = new Traverser(context);
        this.entry = type2;
        this.type = type;
        this.name = str;
    }

    private Object populate(InputNode inputNode, Object obj) throws Exception {
        Collection collection = (Collection) obj;
        while (true) {
            InputNode next = inputNode.getNext();
            Class type = this.entry.getType();
            if (next == null) {
                return collection;
            }
            collection.add(this.root.read(next, type));
        }
    }

    private boolean validate(InputNode inputNode, Class cls) throws Exception {
        while (true) {
            InputNode next = inputNode.getNext();
            Class type = this.entry.getType();
            if (next == null) {
                return true;
            }
            this.root.validate(next, type);
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
                Class type = this.entry.getType();
                Class<?> cls = obj2.getClass();
                if (!type.isAssignableFrom(cls)) {
                    throw new PersistenceException("Entry %s does not match %s for %s", cls, this.entry, this.type);
                }
                this.root.write(outputNode, obj2, type, this.name);
            }
        }
    }
}

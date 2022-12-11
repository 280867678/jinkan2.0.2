package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

/* loaded from: classes5.dex */
public class PrimitiveArray implements Converter {
    public final Type entry;
    public final ArrayFactory factory;
    public final String parent;
    public final Primitive root;
    public final Type type;

    public PrimitiveArray(Context context, Type type, Type type2, String str) {
        this.factory = new ArrayFactory(context, type);
        this.root = new Primitive(context, type2);
        this.parent = str;
        this.entry = type2;
        this.type = type;
    }

    private boolean isOverridden(OutputNode outputNode, Object obj) throws Exception {
        return this.factory.setOverride(this.entry, obj, outputNode);
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

    private void write(OutputNode outputNode, Object obj, int i) throws Exception {
        Object obj2 = Array.get(obj, i);
        if (obj2 == null || isOverridden(outputNode, obj2)) {
            return;
        }
        this.root.write(outputNode, obj2);
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws Exception {
        Instance arrayFactory = this.factory.getInstance(inputNode);
        Object instance = arrayFactory.getInstance();
        return !arrayFactory.isReference() ? read(inputNode, instance) : instance;
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws Exception {
        int length = Array.getLength(obj);
        int i = 0;
        while (true) {
            Position position = inputNode.getPosition();
            InputNode next = inputNode.getNext();
            if (next == null) {
                return obj;
            }
            if (i >= length) {
                throw new ElementException("Array length missing or incorrect for %s at %s", this.type, position);
            }
            Array.set(obj, i, this.root.read(next));
            i++;
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) throws Exception {
        Instance arrayFactory = this.factory.getInstance(inputNode);
        if (!arrayFactory.isReference()) {
            arrayFactory.setInstance(null);
            return validate(inputNode, arrayFactory.getType());
        }
        return true;
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws Exception {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            OutputNode child = outputNode.getChild(this.parent);
            if (child == null) {
                return;
            }
            write(child, obj, i);
        }
    }
}

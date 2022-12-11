package org.simpleframework.xml.core;

import java.util.Collection;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes5.dex */
public class TextList implements Repeater {
    public final CollectionFactory factory;
    public final Primitive primitive;
    public final Type type = new ClassType(String.class);

    public TextList(Context context, Type type, Label label) {
        this.factory = new CollectionFactory(context, type);
        this.primitive = new Primitive(context, this.type);
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws Exception {
        Instance collectionFactory = this.factory.getInstance(inputNode);
        return collectionFactory.isReference() ? collectionFactory.getInstance() : read(inputNode, collectionFactory.getInstance());
    }

    @Override // org.simpleframework.xml.core.Repeater, org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws Exception {
        Collection collection = (Collection) obj;
        Object read = this.primitive.read(inputNode);
        if (read != null) {
            collection.add(read);
        }
        return obj;
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) throws Exception {
        return true;
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws Exception {
        OutputNode mo5311getParent = outputNode.mo5311getParent();
        for (Object obj2 : (Collection) obj) {
            this.primitive.write(mo5311getParent, obj2);
        }
    }
}

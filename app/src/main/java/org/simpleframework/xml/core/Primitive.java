package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes5.dex */
public class Primitive implements Converter {
    public final Context context;
    public final String empty;
    public final Class expect;
    public final PrimitiveFactory factory;
    public final Type type;

    public Primitive(Context context, Type type) {
        this(context, type, null);
    }

    public Primitive(Context context, Type type, String str) {
        this.factory = new PrimitiveFactory(context, type);
        this.expect = type.getType();
        this.context = context;
        this.empty = str;
        this.type = type;
    }

    private Object readElement(InputNode inputNode) throws Exception {
        Instance primitiveFactory = this.factory.getInstance(inputNode);
        return !primitiveFactory.isReference() ? readElement(inputNode, primitiveFactory) : primitiveFactory.getInstance();
    }

    private Object readElement(InputNode inputNode, Instance instance) throws Exception {
        Object read = read(inputNode, this.expect);
        if (instance != null) {
            instance.setInstance(read);
        }
        return read;
    }

    private Object readTemplate(String str, Class cls) throws Exception {
        String property = this.context.getProperty(str);
        if (property != null) {
            return this.factory.getInstance(property, cls);
        }
        return null;
    }

    private boolean validateElement(InputNode inputNode) throws Exception {
        Instance primitiveFactory = this.factory.getInstance(inputNode);
        if (!primitiveFactory.isReference()) {
            primitiveFactory.setInstance(null);
            return true;
        }
        return true;
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws Exception {
        return inputNode.isElement() ? readElement(inputNode) : read(inputNode, this.expect);
    }

    public Object read(InputNode inputNode, Class cls) throws Exception {
        String value = inputNode.getValue();
        if (value == null) {
            return null;
        }
        String str = this.empty;
        return (str == null || !value.equals(str)) ? readTemplate(value, cls) : this.empty;
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws Exception {
        if (obj == null) {
            return read(inputNode);
        }
        throw new PersistenceException("Can not read existing %s for %s", this.expect, this.type);
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) throws Exception {
        if (inputNode.isElement()) {
            validateElement(inputNode);
            return true;
        }
        inputNode.getValue();
        return true;
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws Exception {
        String text = this.factory.getText(obj);
        if (text != null) {
            outputNode.setValue(text);
        }
    }
}

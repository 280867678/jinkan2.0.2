package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

/* loaded from: classes5.dex */
public class PrimitiveFactory extends Factory {
    public PrimitiveFactory(Context context, Type type) {
        super(context, type);
    }

    public PrimitiveFactory(Context context, Type type, Class cls) {
        super(context, type, cls);
    }

    public Object getInstance(String str, Class cls) throws Exception {
        return this.support.read(str, cls);
    }

    public Instance getInstance(InputNode inputNode) throws Exception {
        Value override = getOverride(inputNode);
        return override == null ? this.context.getInstance(getType()) : new ObjectInstance(this.context, override);
    }

    public String getText(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        cls.isEnum();
        return this.support.write(obj, cls);
    }
}

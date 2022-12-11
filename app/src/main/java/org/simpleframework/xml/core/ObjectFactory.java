package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

/* loaded from: classes5.dex */
public class ObjectFactory extends PrimitiveFactory {
    public ObjectFactory(Context context, Type type, Class cls) {
        super(context, type, cls);
    }

    @Override // org.simpleframework.xml.core.PrimitiveFactory
    public Instance getInstance(InputNode inputNode) throws Exception {
        Value override = getOverride(inputNode);
        Class type = getType();
        if (override == null) {
            if (!Factory.isInstantiable(type)) {
                throw new InstantiationException("Cannot instantiate %s for %s", type, this.type);
            }
            return this.context.getInstance(type);
        }
        return new ObjectInstance(this.context, override);
    }
}

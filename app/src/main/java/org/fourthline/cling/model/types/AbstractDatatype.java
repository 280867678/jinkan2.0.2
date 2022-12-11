package org.fourthline.cling.model.types;

import java.lang.reflect.ParameterizedType;
import me.tvspark.outline;
import org.fourthline.cling.model.types.Datatype;

/* loaded from: classes5.dex */
public abstract class AbstractDatatype<V> implements Datatype<V> {
    public Datatype.Builtin builtin;

    @Override // org.fourthline.cling.model.types.Datatype
    public Datatype.Builtin getBuiltin() {
        return this.builtin;
    }

    @Override // org.fourthline.cling.model.types.Datatype
    public String getDisplayString() {
        return this instanceof CustomDatatype ? ((CustomDatatype) this).getName() : getBuiltin() != null ? getBuiltin().getDescriptorName() : getValueType().getSimpleName();
    }

    @Override // org.fourthline.cling.model.types.Datatype
    public String getString(V v) throws InvalidValueException {
        if (v == null) {
            return "";
        }
        if (!isValid(v)) {
            throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Value is not valid: ", v));
        }
        return v.toString();
    }

    public Class<V> getValueType() {
        return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override // org.fourthline.cling.model.types.Datatype
    public boolean isHandlingJavaType(Class cls) {
        return getValueType().isAssignableFrom(cls);
    }

    @Override // org.fourthline.cling.model.types.Datatype
    public boolean isValid(V v) {
        return v == null || getValueType().isAssignableFrom(v.getClass());
    }

    public void setBuiltin(Datatype.Builtin builtin) {
        this.builtin = builtin;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.fourthline.cling.model.types.Datatype
    /* renamed from: valueOf */
    public V mo5215valueOf(String str) throws InvalidValueException {
        return null;
    }
}

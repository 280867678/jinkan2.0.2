package org.simpleframework.xml.core;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.List;

/* loaded from: classes5.dex */
public class SignatureCreator implements Creator {
    public final List<Parameter> list;
    public final Signature signature;
    public final Class type;

    public SignatureCreator(Signature signature) {
        this.type = signature.getType();
        this.list = signature.getAll();
        this.signature = signature;
    }

    private double getAdjustment(double d) {
        return d > RoundRectDrawableWithShadow.COS_45 ? (d / this.list.size()) + (this.list.size() / 1000.0d) : d / this.list.size();
    }

    private double getPercentage(Criteria criteria) throws Exception {
        double d = RoundRectDrawableWithShadow.COS_45;
        for (Parameter parameter : this.list) {
            if (criteria.get(parameter.getKey()) != null) {
                d += 1.0d;
            } else if (parameter.isRequired() || parameter.isPrimitive()) {
                return -1.0d;
            }
        }
        return getAdjustment(d);
    }

    private Object getVariable(Criteria criteria, int i) throws Exception {
        Variable remove = criteria.remove(this.list.get(i).getKey());
        if (remove != null) {
            return remove.getValue();
        }
        return null;
    }

    @Override // org.simpleframework.xml.core.Creator
    public Object getInstance() throws Exception {
        return this.signature.create();
    }

    @Override // org.simpleframework.xml.core.Creator
    public Object getInstance(Criteria criteria) throws Exception {
        Object[] array = this.list.toArray();
        for (int i = 0; i < this.list.size(); i++) {
            array[i] = getVariable(criteria, i);
        }
        return this.signature.create(array);
    }

    @Override // org.simpleframework.xml.core.Creator
    public double getScore(Criteria criteria) throws Exception {
        Signature copy = this.signature.copy();
        for (Object obj : criteria) {
            Parameter parameter = copy.get(obj);
            Variable variable = criteria.get(obj);
            Contact contact = variable.getContact();
            if (parameter != null && !Support.isAssignable(variable.getValue().getClass(), parameter.getType())) {
                return -1.0d;
            }
            if (contact.isReadOnly() && parameter == null) {
                return -1.0d;
            }
        }
        return getPercentage(criteria);
    }

    @Override // org.simpleframework.xml.core.Creator
    public Signature getSignature() {
        return this.signature;
    }

    @Override // org.simpleframework.xml.core.Creator
    public Class getType() {
        return this.type;
    }

    public String toString() {
        return this.signature.toString();
    }
}

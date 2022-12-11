package org.simpleframework.xml.core;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ClassInstantiator implements Instantiator {
    public final List<Creator> creators;
    public final Detail detail;
    public final Creator primary;
    public final ParameterMap registry;

    public ClassInstantiator(List<Creator> list, Creator creator, ParameterMap parameterMap, Detail detail) {
        this.creators = list;
        this.registry = parameterMap;
        this.primary = creator;
        this.detail = detail;
    }

    private Creator getCreator(Criteria criteria) throws Exception {
        Creator creator = this.primary;
        double d = RoundRectDrawableWithShadow.COS_45;
        for (Creator creator2 : this.creators) {
            double score = creator2.getScore(criteria);
            if (score > d) {
                creator = creator2;
                d = score;
            }
        }
        return creator;
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public List<Creator> getCreators() {
        return new ArrayList(this.creators);
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public Object getInstance() throws Exception {
        return this.primary.getInstance();
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public Object getInstance(Criteria criteria) throws Exception {
        Creator creator = getCreator(criteria);
        if (creator != null) {
            return creator.getInstance(criteria);
        }
        throw new PersistenceException("Constructor not matched for %s", this.detail);
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public Parameter getParameter(String str) {
        return this.registry.get(str);
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public List<Parameter> getParameters() {
        return this.registry.getAll();
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public boolean isDefault() {
        return this.creators.size() <= 1 && this.primary != null;
    }

    public String toString() {
        return String.format("creator for %s", this.detail);
    }
}

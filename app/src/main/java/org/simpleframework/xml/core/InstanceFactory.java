package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: classes5.dex */
public class InstanceFactory {
    public final Cache<Constructor> cache = new ConcurrentCache();

    /* loaded from: classes5.dex */
    public class ClassInstance implements Instance {
        public Class type;
        public Object value;

        public ClassInstance(Class cls) {
            this.type = cls;
        }

        @Override // org.simpleframework.xml.core.Instance
        public Object getInstance() throws Exception {
            if (this.value == null) {
                this.value = InstanceFactory.this.getObject(this.type);
            }
            return this.value;
        }

        @Override // org.simpleframework.xml.core.Instance
        public Class getType() {
            return this.type;
        }

        @Override // org.simpleframework.xml.core.Instance
        public boolean isReference() {
            return false;
        }

        @Override // org.simpleframework.xml.core.Instance
        public Object setInstance(Object obj) throws Exception {
            this.value = obj;
            return obj;
        }
    }

    /* loaded from: classes5.dex */
    public class ValueInstance implements Instance {
        public final Class type;
        public final Value value;

        public ValueInstance(Value value) {
            this.type = value.getType();
            this.value = value;
        }

        @Override // org.simpleframework.xml.core.Instance
        public Object getInstance() throws Exception {
            if (this.value.isReference()) {
                return this.value.getValue();
            }
            Object object = InstanceFactory.this.getObject(this.type);
            Value value = this.value;
            if (value != null) {
                value.setValue(object);
            }
            return object;
        }

        @Override // org.simpleframework.xml.core.Instance
        public Class getType() {
            return this.type;
        }

        @Override // org.simpleframework.xml.core.Instance
        public boolean isReference() {
            return this.value.isReference();
        }

        @Override // org.simpleframework.xml.core.Instance
        public Object setInstance(Object obj) {
            Value value = this.value;
            if (value != null) {
                value.setValue(obj);
            }
            return obj;
        }
    }

    public Instance getInstance(Class cls) {
        return new ClassInstance(cls);
    }

    public Instance getInstance(Value value) {
        return new ValueInstance(value);
    }

    public Object getObject(Class cls) throws Exception {
        Constructor fetch = this.cache.fetch(cls);
        if (fetch == null) {
            fetch = cls.getDeclaredConstructor(new Class[0]);
            if (!fetch.isAccessible()) {
                fetch.setAccessible(true);
            }
            this.cache.cache(cls, fetch);
        }
        return fetch.newInstance(new Object[0]);
    }
}

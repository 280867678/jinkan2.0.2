package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes5.dex */
public abstract class NamedLoggerBase implements Logger, Serializable {
    public static final long serialVersionUID = 7535258609338176893L;
    public String name;

    @Override // org.slf4j.Logger
    public String getName() {
        return this.name;
    }

    public Object readResolve() throws ObjectStreamException {
        return LoggerFactory.getLogger(getName());
    }
}

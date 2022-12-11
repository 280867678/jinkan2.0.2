package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

/* loaded from: classes5.dex */
public class ClassSchema implements Schema {
    public final Caller caller;
    public final Decorator decorator;
    public final Instantiator factory;
    public final boolean primitive;
    public final Version revision;
    public final Section section;
    public final Label text;
    public final Class type;
    public final Label version;

    public ClassSchema(Scanner scanner, Context context) throws Exception {
        this.caller = scanner.getCaller(context);
        this.factory = scanner.getInstantiator();
        this.revision = scanner.getRevision();
        this.decorator = scanner.getDecorator();
        this.primitive = scanner.isPrimitive();
        this.version = scanner.getVersion();
        this.section = scanner.getSection();
        this.text = scanner.getText();
        this.type = scanner.getType();
    }

    @Override // org.simpleframework.xml.core.Schema
    public Caller getCaller() {
        return this.caller;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Decorator getDecorator() {
        return this.decorator;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Instantiator getInstantiator() {
        return this.factory;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Version getRevision() {
        return this.revision;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Section getSection() {
        return this.section;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Label getText() {
        return this.text;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Label getVersion() {
        return this.version;
    }

    @Override // org.simpleframework.xml.core.Schema
    public boolean isPrimitive() {
        return this.primitive;
    }

    public String toString() {
        return String.format("schema for %s", this.type);
    }
}

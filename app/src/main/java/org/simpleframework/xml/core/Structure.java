package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

/* loaded from: classes5.dex */
public class Structure {
    public final Instantiator factory;
    public final Model model;
    public final boolean primitive;
    public final Label text;
    public final Label version;

    public Structure(Instantiator instantiator, Model model, Label label, Label label2, boolean z) {
        this.primitive = z;
        this.factory = instantiator;
        this.version = label;
        this.model = model;
        this.text = label2;
    }

    public Instantiator getInstantiator() {
        return this.factory;
    }

    public Version getRevision() {
        Label label = this.version;
        if (label != null) {
            return (Version) label.getContact().getAnnotation(Version.class);
        }
        return null;
    }

    public Section getSection() {
        return new ModelSection(this.model);
    }

    public Label getText() {
        return this.text;
    }

    public Label getVersion() {
        return this.version;
    }

    public boolean isPrimitive() {
        return this.primitive;
    }
}

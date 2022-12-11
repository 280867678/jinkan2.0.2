package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

/* loaded from: classes5.dex */
public class Introspector {
    public final Contact contact;
    public final Format format;
    public final Label label;
    public final Annotation marker;

    public Introspector(Contact contact, Label label, Format format) {
        this.marker = contact.getAnnotation();
        this.contact = contact;
        this.format = format;
        this.label = label;
    }

    private String getDefault() throws Exception {
        String override = this.label.getOverride();
        return !isEmpty(override) ? override : this.contact.getName();
    }

    private String getName(Class cls) throws Exception {
        String root = getRoot(cls);
        return root != null ? root : Reflector.getName(cls.getSimpleName());
    }

    private String getRoot(Class cls) {
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String root = getRoot(cls, cls2);
            if (root != null) {
                return root;
            }
        }
        return null;
    }

    private String getRoot(Class<?> cls, Class<?> cls2) {
        String simpleName = cls2.getSimpleName();
        Root root = (Root) cls2.getAnnotation(Root.class);
        if (root != null) {
            String name = root.name();
            return !isEmpty(name) ? name : Reflector.getName(simpleName);
        }
        return null;
    }

    public Contact getContact() {
        return this.contact;
    }

    public Type getDependent() throws Exception {
        return this.label.getDependent();
    }

    public String getEntry() throws Exception {
        Class<?> type = getDependent().getType();
        if (type.isArray()) {
            type = type.getComponentType();
        }
        return getName(type);
    }

    public Expression getExpression() throws Exception {
        String path = getPath();
        return path != null ? new PathParser(path, this.contact, this.format) : new EmptyExpression(this.format);
    }

    public String getName() throws Exception {
        return !this.label.isInline() ? getDefault() : this.label.getEntry();
    }

    public String getPath() throws Exception {
        Path path = (Path) this.contact.getAnnotation(Path.class);
        if (path == null) {
            return null;
        }
        return path.value();
    }

    public boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public String toString() {
        return String.format("%s on %s", this.marker, this.contact);
    }
}

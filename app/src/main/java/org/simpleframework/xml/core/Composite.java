package org.simpleframework.xml.core;

import java.util.Iterator;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NamespaceMap;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

/* loaded from: classes5.dex */
public class Composite implements Converter {
    public final Context context;
    public final Criteria criteria;
    public final ObjectFactory factory;
    public final Primitive primitive;
    public final Revision revision;
    public final Type type;

    /* loaded from: classes5.dex */
    public static class Builder {
        public final Composite composite;
        public final Criteria criteria;
        public final Schema schema;
        public final Instance value;

        public Builder(Composite composite, Criteria criteria, Schema schema, Instance instance) {
            this.composite = composite;
            this.criteria = criteria;
            this.schema = schema;
            this.value = instance;
        }

        public Object read(InputNode inputNode) throws Exception {
            Object instance = this.value.getInstance();
            Section section = this.schema.getSection();
            this.value.setInstance(instance);
            this.composite.readVersion(inputNode, instance, this.schema);
            this.composite.readText(inputNode, instance, section);
            this.composite.readAttributes(inputNode, instance, section);
            this.composite.readElements(inputNode, instance, section);
            this.criteria.commit(instance);
            return instance;
        }
    }

    /* loaded from: classes5.dex */
    public class Injector extends Builder {
        public Injector(Composite composite, Criteria criteria, Schema schema, Instance instance) {
            super(composite, criteria, schema, instance);
        }

        private Object readInject(InputNode inputNode) throws Exception {
            Object instantiator = this.schema.getInstantiator().getInstance(this.criteria);
            this.value.setInstance(instantiator);
            this.criteria.commit(instantiator);
            return instantiator;
        }

        @Override // org.simpleframework.xml.core.Composite.Builder
        public Object read(InputNode inputNode) throws Exception {
            Section section = this.schema.getSection();
            this.composite.readVersion(inputNode, (Object) null, this.schema);
            this.composite.readText(inputNode, null, section);
            this.composite.readAttributes(inputNode, null, section);
            this.composite.readElements(inputNode, null, section);
            return readInject(inputNode);
        }
    }

    public Composite(Context context, Type type) {
        this(context, type, null);
    }

    public Composite(Context context, Type type, Class cls) {
        this.factory = new ObjectFactory(context, type, cls);
        this.primitive = new Primitive(context, type);
        this.criteria = new Collector();
        this.revision = new Revision();
        this.context = context;
        this.type = type;
    }

    private boolean isOverridden(OutputNode outputNode, Object obj, Type type) throws Exception {
        return this.factory.setOverride(type, obj, outputNode);
    }

    private Object read(InputNode inputNode, Instance instance, Class cls) throws Exception {
        Schema schema = this.context.getSchema(cls);
        Caller caller = schema.getCaller();
        Object read = read(schema, instance).read(inputNode);
        caller.validate(read);
        caller.commit(read);
        instance.setInstance(read);
        return readResolve(inputNode, read, caller);
    }

    private Builder read(Schema schema, Instance instance) throws Exception {
        return schema.getInstantiator().isDefault() ? new Builder(this, this.criteria, schema, instance) : new Injector(this, this.criteria, schema, instance);
    }

    private void read(InputNode inputNode, Object obj, Schema schema) throws Exception {
        Section section = schema.getSection();
        readVersion(inputNode, obj, schema);
        readSection(inputNode, obj, section);
    }

    private void readAttribute(InputNode inputNode, Object obj, Section section, LabelMap labelMap) throws Exception {
        String attribute = section.getAttribute(inputNode.getName());
        Label label = labelMap.getLabel(attribute);
        if (label != null) {
            readInstance(inputNode, obj, label);
            return;
        }
        Position position = inputNode.getPosition();
        Class type = this.context.getType(this.type, obj);
        if (labelMap.isStrict(this.context) && this.revision.isEqual()) {
            throw new AttributeException("Attribute '%s' does not have a match in %s at %s", attribute, type, position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readAttributes(InputNode inputNode, Object obj, Section section) throws Exception {
        NodeMap<InputNode> attributes = inputNode.getAttributes();
        LabelMap attributes2 = section.getAttributes();
        Iterator<String> it = attributes.iterator();
        while (it.hasNext()) {
            InputNode attribute = inputNode.getAttribute(it.next());
            if (attribute != null) {
                readAttribute(attribute, obj, section, attributes2);
            }
        }
        validate(inputNode, attributes2, obj);
    }

    private void readElement(InputNode inputNode, Object obj, Section section, LabelMap labelMap) throws Exception {
        String path = section.getPath(inputNode.getName());
        Label label = labelMap.getLabel(path);
        if (label == null) {
            label = this.criteria.resolve(path);
        }
        if (label != null) {
            readUnion(inputNode, obj, labelMap, label);
            return;
        }
        Position position = inputNode.getPosition();
        Class type = this.context.getType(this.type, obj);
        if (labelMap.isStrict(this.context) && this.revision.isEqual()) {
            throw new ElementException("Element '%s' does not have a match in %s at %s", path, type, position);
        }
        inputNode.skip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readElements(InputNode inputNode, Object obj, Section section) throws Exception {
        LabelMap elements = section.getElements();
        while (true) {
            InputNode next = inputNode.getNext();
            if (next == null) {
                validate(inputNode, elements, obj);
                return;
            }
            Section section2 = section.getSection(next.getName());
            if (section2 != null) {
                readSection(next, obj, section2);
            } else {
                readElement(next, obj, section, elements);
            }
        }
    }

    private Object readInstance(InputNode inputNode, Object obj, Label label) throws Exception {
        Object readVariable = readVariable(inputNode, obj, label);
        if (readVariable == null) {
            Position position = inputNode.getPosition();
            Class type = this.context.getType(this.type, obj);
            if (label.isRequired() && this.revision.isEqual()) {
                throw new ValueRequiredException("Empty value for %s in %s at %s", label, type, position);
            }
        } else if (readVariable != label.mo5301getEmpty(this.context)) {
            this.criteria.set(label, readVariable);
        }
        return readVariable;
    }

    private Object readPrimitive(InputNode inputNode, Instance instance) throws Exception {
        Class type = instance.getType();
        Object read = this.primitive.read(inputNode, type);
        if (type != null) {
            instance.setInstance(read);
        }
        return read;
    }

    private Object readResolve(InputNode inputNode, Object obj, Caller caller) throws Exception {
        if (obj != null) {
            Position position = inputNode.getPosition();
            Object resolve = caller.resolve(obj);
            Class type = this.type.getType();
            Class<?> cls = resolve.getClass();
            if (!type.isAssignableFrom(cls)) {
                throw new ElementException("Type %s does not match %s at %s", cls, type, position);
            }
            return resolve;
        }
        return obj;
    }

    private void readSection(InputNode inputNode, Object obj, Section section) throws Exception {
        readText(inputNode, obj, section);
        readAttributes(inputNode, obj, section);
        readElements(inputNode, obj, section);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readText(InputNode inputNode, Object obj, Section section) throws Exception {
        Label text = section.getText();
        if (text != null) {
            readInstance(inputNode, obj, text);
        }
    }

    private void readUnion(InputNode inputNode, Object obj, LabelMap labelMap, Label label) throws Exception {
        Object readInstance = readInstance(inputNode, obj, label);
        for (String str : label.getPaths()) {
            labelMap.getLabel(str);
        }
        if (label.isInline()) {
            this.criteria.set(label, readInstance);
        }
    }

    private Object readVariable(InputNode inputNode, Object obj, Label label) throws Exception {
        Object obj2;
        Converter converter = label.getConverter(this.context);
        if (label.isCollection()) {
            Variable variable = this.criteria.get(label);
            Contact contact = label.getContact();
            if (variable != null) {
                return converter.read(inputNode, variable.getValue());
            }
            if (obj != null && (obj2 = contact.get(obj)) != null) {
                return converter.read(inputNode, obj2);
            }
        }
        return converter.read(inputNode);
    }

    private void readVersion(InputNode inputNode, Object obj, Label label) throws Exception {
        Object readInstance = readInstance(inputNode, obj, label);
        Class type = this.type.getType();
        if (readInstance != null) {
            Double valueOf = Double.valueOf(this.context.getVersion(type).revision());
            if (readInstance.equals(this.revision)) {
                return;
            }
            this.revision.compare(valueOf, readInstance);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readVersion(InputNode inputNode, Object obj, Schema schema) throws Exception {
        Label version = schema.getVersion();
        Class type = this.type.getType();
        if (version != null) {
            InputNode mo5315remove = inputNode.getAttributes().mo5315remove(version.getName());
            if (mo5315remove != null) {
                readVersion(mo5315remove, obj, version);
                return;
            }
            Version version2 = this.context.getVersion(type);
            Double valueOf = Double.valueOf(this.revision.getDefault());
            Double valueOf2 = Double.valueOf(version2.revision());
            this.criteria.set(version, valueOf);
            this.revision.compare(valueOf2, valueOf);
        }
    }

    private void validate(InputNode inputNode, Label label) throws Exception {
        Converter converter = label.getConverter(this.context);
        Position position = inputNode.getPosition();
        Class type = this.type.getType();
        if (converter.validate(inputNode)) {
            this.criteria.set(label, null);
            return;
        }
        throw new PersistenceException("Invalid value for %s in %s at %s", label, type, position);
    }

    private void validate(InputNode inputNode, LabelMap labelMap) throws Exception {
        Position position = inputNode.getPosition();
        Iterator<Label> it = labelMap.iterator();
        while (it.hasNext()) {
            Label next = it.next();
            Class type = this.type.getType();
            if (next.isRequired() && this.revision.isEqual()) {
                throw new ValueRequiredException("Unable to satisfy %s for %s at %s", next, type, position);
            }
        }
    }

    private void validate(InputNode inputNode, LabelMap labelMap, Object obj) throws Exception {
        Class type = this.context.getType(this.type, obj);
        Position position = inputNode.getPosition();
        Iterator<Label> it = labelMap.iterator();
        while (it.hasNext()) {
            Label next = it.next();
            if (next.isRequired() && this.revision.isEqual()) {
                throw new ValueRequiredException("Unable to satisfy %s for %s at %s", next, type, position);
            }
            Object mo5301getEmpty = next.mo5301getEmpty(this.context);
            if (mo5301getEmpty != null) {
                this.criteria.set(next, mo5301getEmpty);
            }
        }
    }

    private boolean validate(InputNode inputNode, Class cls) throws Exception {
        Schema schema = this.context.getSchema(cls);
        Section section = schema.getSection();
        validateText(inputNode, schema);
        validateSection(inputNode, section);
        return inputNode.isElement();
    }

    private void validateAttribute(InputNode inputNode, Section section, LabelMap labelMap) throws Exception {
        Position position = inputNode.getPosition();
        String attribute = section.getAttribute(inputNode.getName());
        Label label = labelMap.getLabel(attribute);
        if (label != null) {
            validate(inputNode, label);
            return;
        }
        Class type = this.type.getType();
        if (labelMap.isStrict(this.context) && this.revision.isEqual()) {
            throw new AttributeException("Attribute '%s' does not exist for %s at %s", attribute, type, position);
        }
    }

    private void validateAttributes(InputNode inputNode, Section section) throws Exception {
        NodeMap<InputNode> attributes = inputNode.getAttributes();
        LabelMap attributes2 = section.getAttributes();
        Iterator<String> it = attributes.iterator();
        while (it.hasNext()) {
            InputNode attribute = inputNode.getAttribute(it.next());
            if (attribute != null) {
                validateAttribute(attribute, section, attributes2);
            }
        }
        validate(inputNode, attributes2);
    }

    private void validateElement(InputNode inputNode, Section section, LabelMap labelMap) throws Exception {
        String path = section.getPath(inputNode.getName());
        Label label = labelMap.getLabel(path);
        if (label == null) {
            label = this.criteria.resolve(path);
        }
        if (label != null) {
            validateUnion(inputNode, labelMap, label);
            return;
        }
        Position position = inputNode.getPosition();
        Class type = this.type.getType();
        if (labelMap.isStrict(this.context) && this.revision.isEqual()) {
            throw new ElementException("Element '%s' does not exist for %s at %s", path, type, position);
        }
        inputNode.skip();
    }

    private void validateElements(InputNode inputNode, Section section) throws Exception {
        LabelMap elements = section.getElements();
        while (true) {
            InputNode next = inputNode.getNext();
            if (next == null) {
                validate(inputNode, elements);
                return;
            }
            Section section2 = section.getSection(next.getName());
            if (section2 != null) {
                validateSection(next, section2);
            } else {
                validateElement(next, section, elements);
            }
        }
    }

    private void validateSection(InputNode inputNode, Section section) throws Exception {
        validateAttributes(inputNode, section);
        validateElements(inputNode, section);
    }

    private void validateText(InputNode inputNode, Schema schema) throws Exception {
        Label text = schema.getText();
        if (text != null) {
            validate(inputNode, text);
        }
    }

    private void validateUnion(InputNode inputNode, LabelMap labelMap, Label label) throws Exception {
        for (String str : label.getPaths()) {
            labelMap.getLabel(str);
        }
        if (label.isInline()) {
            this.criteria.set(label, null);
        }
        validate(inputNode, label);
    }

    private void write(OutputNode outputNode, Object obj, Schema schema) throws Exception {
        Section section = schema.getSection();
        writeVersion(outputNode, obj, schema);
        writeSection(outputNode, obj, section);
    }

    private void writeAttribute(OutputNode outputNode, Object obj, Label label) throws Exception {
        if (obj != null) {
            label.getDecorator().decorate(outputNode.setAttribute(label.getName(), this.factory.getText(obj)));
        }
    }

    private void writeAttributes(OutputNode outputNode, Object obj, Section section) throws Exception {
        Iterator<Label> it = section.getAttributes().iterator();
        while (it.hasNext()) {
            Label next = it.next();
            Object obj2 = next.getContact().get(obj);
            Class type = this.context.getType(this.type, obj);
            if (obj2 == null) {
                obj2 = next.mo5301getEmpty(this.context);
            }
            if (obj2 == null && next.isRequired()) {
                throw new AttributeException("Value for %s is null in %s", next, type);
            }
            writeAttribute(outputNode, obj2, next);
        }
    }

    private void writeElement(OutputNode outputNode, Object obj, Converter converter) throws Exception {
        converter.write(outputNode, obj);
    }

    private void writeElement(OutputNode outputNode, Object obj, Label label) throws Exception {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Label label2 = label.getLabel(cls);
            String name = label2.getName();
            Type type = label.getType(cls);
            OutputNode child = outputNode.getChild(name);
            if (!label2.isInline()) {
                writeNamespaces(child, type, label2);
            }
            if (!label2.isInline() && isOverridden(child, obj, type)) {
                return;
            }
            Converter converter = label2.getConverter(this.context);
            child.setData(label2.isData());
            writeElement(child, obj, converter);
        }
    }

    private void writeElements(OutputNode outputNode, Object obj, Section section) throws Exception {
        for (String str : section) {
            Section section2 = section.getSection(str);
            if (section2 != null) {
                writeSection(outputNode.getChild(str), obj, section2);
            } else {
                Label element = section.getElement(section.getPath(str));
                Class type = this.context.getType(this.type, obj);
                if (this.criteria.get(element) != null) {
                    continue;
                } else if (element == null) {
                    throw new ElementException("Element '%s' not defined in %s", str, type);
                } else {
                    writeUnion(outputNode, obj, section, element);
                }
            }
        }
    }

    private void writeNamespaces(OutputNode outputNode, Type type, Label label) throws Exception {
        label.getDecorator().decorate(outputNode, this.context.getDecorator(type.getType()));
    }

    private Object writeReplace(Object obj) throws Exception {
        if (obj != null) {
            return this.context.getCaller(obj.getClass()).replace(obj);
        }
        return obj;
    }

    private void writeSection(OutputNode outputNode, Object obj, Section section) throws Exception {
        NamespaceMap namespaces = outputNode.getNamespaces();
        String prefix = section.getPrefix();
        if (prefix != null) {
            String reference = namespaces.getReference(prefix);
            if (reference == null) {
                throw new ElementException("Namespace prefix '%s' in %s is not in scope", prefix, this.type);
            }
            outputNode.setReference(reference);
        }
        writeAttributes(outputNode, obj, section);
        writeElements(outputNode, obj, section);
        writeText(outputNode, obj, section);
    }

    private void writeText(OutputNode outputNode, Object obj, Label label) throws Exception {
        if (obj == null || label.isTextList()) {
            return;
        }
        String text = this.factory.getText(obj);
        outputNode.setData(label.isData());
        outputNode.setValue(text);
    }

    private void writeText(OutputNode outputNode, Object obj, Section section) throws Exception {
        Label text = section.getText();
        if (text != null) {
            Object obj2 = text.getContact().get(obj);
            Class type = this.context.getType(this.type, obj);
            if (obj2 == null) {
                obj2 = text.mo5301getEmpty(this.context);
            }
            if (obj2 == null && text.isRequired()) {
                throw new TextException("Value for %s is null in %s", text, type);
            }
            writeText(outputNode, obj2, text);
        }
    }

    private void writeUnion(OutputNode outputNode, Object obj, Section section, Label label) throws Exception {
        Object obj2 = label.getContact().get(obj);
        Class type = this.context.getType(this.type, obj);
        if (obj2 != null || !label.isRequired()) {
            Object writeReplace = writeReplace(obj2);
            if (writeReplace != null) {
                writeElement(outputNode, writeReplace, label);
            }
            this.criteria.set(label, writeReplace);
            return;
        }
        throw new ElementException("Value for %s is null in %s", label, type);
    }

    private void writeVersion(OutputNode outputNode, Object obj, Schema schema) throws Exception {
        Version revision = schema.getRevision();
        Label version = schema.getVersion();
        if (revision != null) {
            Double valueOf = Double.valueOf(this.revision.getDefault());
            Double valueOf2 = Double.valueOf(revision.revision());
            if (this.revision.compare(valueOf2, valueOf) && !version.isRequired()) {
                return;
            }
            writeAttribute(outputNode, valueOf2, version);
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws Exception {
        Instance objectFactory = this.factory.getInstance(inputNode);
        Class type = objectFactory.getType();
        return objectFactory.isReference() ? objectFactory.getInstance() : this.context.isPrimitive(type) ? readPrimitive(inputNode, objectFactory) : read(inputNode, objectFactory, type);
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws Exception {
        Schema schema = this.context.getSchema(obj.getClass());
        Caller caller = schema.getCaller();
        read(inputNode, obj, schema);
        this.criteria.commit(obj);
        caller.validate(obj);
        caller.commit(obj);
        return readResolve(inputNode, obj, caller);
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) throws Exception {
        Instance objectFactory = this.factory.getInstance(inputNode);
        if (!objectFactory.isReference()) {
            objectFactory.setInstance(null);
            return validate(inputNode, objectFactory.getType());
        }
        return true;
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws Exception {
        Schema schema = this.context.getSchema(obj.getClass());
        Caller caller = schema.getCaller();
        try {
            if (schema.isPrimitive()) {
                this.primitive.write(outputNode, obj);
            } else {
                caller.persist(obj);
                write(outputNode, obj, schema);
            }
        } finally {
            caller.complete(obj);
        }
    }
}

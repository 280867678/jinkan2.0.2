package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Version;

/* loaded from: classes5.dex */
public class StructureBuilder {
    public ModelAssembler assembler;
    public LabelMap attributes;
    public ExpressionBuilder builder;
    public LabelMap elements;
    public Instantiator factory;
    public boolean primitive;
    public InstantiatorBuilder resolver;
    public Model root;
    public Scanner scanner;
    public Support support;
    public Label text;
    public LabelMap texts;
    public Label version;

    public StructureBuilder(Scanner scanner, Detail detail, Support support) throws Exception {
        ExpressionBuilder expressionBuilder = new ExpressionBuilder(detail, support);
        this.builder = expressionBuilder;
        this.assembler = new ModelAssembler(expressionBuilder, detail, support);
        this.resolver = new InstantiatorBuilder(scanner, detail);
        this.root = new TreeModel(scanner, detail);
        this.attributes = new LabelMap(scanner);
        this.elements = new LabelMap(scanner);
        this.texts = new LabelMap(scanner);
        this.scanner = scanner;
        this.support = support;
    }

    private Model create(Expression expression) throws Exception {
        Model model = this.root;
        while (model != null) {
            String prefix = expression.getPrefix();
            String first = expression.getFirst();
            int index = expression.getIndex();
            if (first != null) {
                model = model.register(first, prefix, index);
            }
            if (!expression.isPath()) {
                break;
            }
            expression = expression.getPath(1);
        }
        return model;
    }

    private boolean isAttribute(String str) throws Exception {
        Expression build = this.builder.build(str);
        Model lookup = lookup(build);
        if (lookup != null) {
            return !build.isPath() ? lookup.isAttribute(str) : lookup.isAttribute(build.getLast());
        }
        return false;
    }

    private boolean isElement(String str) throws Exception {
        Expression build = this.builder.build(str);
        Model lookup = lookup(build);
        if (lookup != null) {
            String last = build.getLast();
            int index = build.getIndex();
            if (lookup.isElement(last)) {
                return true;
            }
            return lookup.isModel(last) && !lookup.lookup(last, index).isEmpty();
        }
        return false;
    }

    private boolean isEmpty() {
        if (this.text != null) {
            return false;
        }
        return this.root.isEmpty();
    }

    private Model lookup(Expression expression) throws Exception {
        return expression.isPath() ? this.root.lookup(expression.getPath(0, 1)) : this.root;
    }

    private void process(Contact contact, Annotation annotation, LabelMap labelMap) throws Exception {
        Label label = this.support.getLabel(contact, annotation);
        String path = label.getPath();
        String name = label.getName();
        if (labelMap.get(path) == null) {
            process(contact, label, labelMap);
            return;
        }
        throw new PersistenceException("Duplicate annotation of name '%s' on %s", name, contact);
    }

    private void process(Contact contact, Label label, LabelMap labelMap) throws Exception {
        Expression expression = label.getExpression();
        String path = label.getPath();
        Model model = this.root;
        if (!expression.isEmpty()) {
            model = register(expression);
        }
        this.resolver.register(label);
        model.register(label);
        labelMap.put(path, label);
    }

    private Model register(Expression expression) throws Exception {
        Model lookup = this.root.lookup(expression);
        return lookup != null ? lookup : create(expression);
    }

    private void text(Contact contact, Annotation annotation) throws Exception {
        Label label = this.support.getLabel(contact, annotation);
        Expression expression = label.getExpression();
        String path = label.getPath();
        Model model = this.root;
        if (!expression.isEmpty()) {
            model = register(expression);
        }
        if (this.texts.get(path) == null) {
            this.resolver.register(label);
            model.register(label);
            this.texts.put(path, label);
            return;
        }
        throw new TextException("Multiple text annotations in %s", annotation);
    }

    private void union(Contact contact, Annotation annotation, LabelMap labelMap) throws Exception {
        for (Label label : this.support.getLabels(contact, annotation)) {
            String path = label.getPath();
            String name = label.getName();
            if (labelMap.get(path) != null) {
                throw new PersistenceException("Duplicate annotation of name '%s' on %s", name, label);
            }
            process(contact, label, labelMap);
        }
    }

    private void validateAttributes(Class cls, Order order) throws Exception {
        String[] attributes;
        if (order != null) {
            for (String str : order.attributes()) {
                if (!isAttribute(str)) {
                    throw new AttributeException("Ordered attribute '%s' missing in %s", str, cls);
                }
            }
        }
    }

    private void validateElements(Class cls, Order order) throws Exception {
        String[] elements;
        if (order != null) {
            for (String str : order.elements()) {
                if (!isElement(str)) {
                    throw new ElementException("Ordered element '%s' missing for %s", str, cls);
                }
            }
        }
    }

    private void validateModel(Class cls) throws Exception {
        if (!this.root.isEmpty()) {
            this.root.validate(cls);
        }
    }

    private void validateText(Class cls) throws Exception {
        Label text = this.root.getText();
        if (text == null) {
            if (!this.scanner.isEmpty()) {
                return;
            }
            this.primitive = isEmpty();
        } else if (text.isTextList()) {
        } else {
            if (!this.elements.isEmpty()) {
                throw new TextException("Elements used with %s in %s", text, cls);
            }
            if (this.root.isComposite()) {
                throw new TextException("Paths used with %s in %s", text, cls);
            }
        }
    }

    private void validateTextList(Class cls) throws Exception {
        Label text = this.root.getText();
        if (text == null || !text.isTextList()) {
            return;
        }
        Object key = text.getKey();
        Iterator<Label> it = this.elements.iterator();
        while (it.hasNext()) {
            Label next = it.next();
            if (!next.getKey().equals(key)) {
                throw new TextException("Elements used with %s in %s", text, cls);
            }
            Class type = next.getDependent().getType();
            if (type == String.class) {
                throw new TextException("Illegal entry of %s with text annotations on %s in %s", type, text, cls);
            }
        }
        if (this.root.isComposite()) {
            throw new TextException("Paths used with %s in %s", text, cls);
        }
    }

    private void validateUnions(Class cls) throws Exception {
        Iterator<Label> it = this.elements.iterator();
        while (it.hasNext()) {
            Label next = it.next();
            String[] paths = next.getPaths();
            Contact contact = next.getContact();
            for (String str : paths) {
                Annotation annotation = contact.getAnnotation();
                Label label = this.elements.get(str);
                if (next.isInline() != label.isInline()) {
                    throw new UnionException("Inline must be consistent in %s for %s", annotation, contact);
                }
                if (next.isRequired() != label.isRequired()) {
                    throw new UnionException("Required must be consistent in %s for %s", annotation, contact);
                }
            }
        }
    }

    private void version(Contact contact, Annotation annotation) throws Exception {
        Label label = this.support.getLabel(contact, annotation);
        if (this.version == null) {
            this.version = label;
            return;
        }
        throw new AttributeException("Multiple version annotations in %s", annotation);
    }

    public void assemble(Class cls) throws Exception {
        Order order = this.scanner.getOrder();
        if (order != null) {
            this.assembler.assemble(this.root, order);
        }
    }

    public Structure build(Class cls) throws Exception {
        return new Structure(this.factory, this.root, this.version, this.text, this.primitive);
    }

    public void commit(Class cls) throws Exception {
        if (this.factory == null) {
            this.factory = this.resolver.build();
        }
    }

    public void process(Contact contact, Annotation annotation) throws Exception {
        if (annotation instanceof Attribute) {
            process(contact, annotation, this.attributes);
        }
        if (annotation instanceof ElementUnion) {
            union(contact, annotation, this.elements);
        }
        if (annotation instanceof ElementListUnion) {
            union(contact, annotation, this.elements);
        }
        if (annotation instanceof ElementMapUnion) {
            union(contact, annotation, this.elements);
        }
        if (annotation instanceof ElementList) {
            process(contact, annotation, this.elements);
        }
        if (annotation instanceof ElementArray) {
            process(contact, annotation, this.elements);
        }
        if (annotation instanceof ElementMap) {
            process(contact, annotation, this.elements);
        }
        if (annotation instanceof Element) {
            process(contact, annotation, this.elements);
        }
        if (annotation instanceof Version) {
            version(contact, annotation);
        }
        if (annotation instanceof Text) {
            text(contact, annotation);
        }
    }

    public void validate(Class cls) throws Exception {
        Order order = this.scanner.getOrder();
        validateUnions(cls);
        validateElements(cls, order);
        validateAttributes(cls, order);
        validateModel(cls);
        validateText(cls);
        validateTextList(cls);
    }
}

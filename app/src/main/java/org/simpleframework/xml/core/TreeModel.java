package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class TreeModel implements Model {
    public LabelMap attributes;
    public Detail detail;
    public LabelMap elements;
    public Expression expression;
    public int index;
    public Label list;
    public ModelMap models;
    public String name;
    public OrderList order;
    public Policy policy;
    public String prefix;
    public Label text;

    /* loaded from: classes5.dex */
    public static class OrderList extends ArrayList<String> {
    }

    public TreeModel(Policy policy, Detail detail) {
        this(policy, detail, null, null, 1);
    }

    public TreeModel(Policy policy, Detail detail, String str, String str2, int i) {
        this.attributes = new LabelMap(policy);
        this.elements = new LabelMap(policy);
        this.models = new ModelMap(detail);
        this.order = new OrderList();
        this.detail = detail;
        this.policy = policy;
        this.prefix = str2;
        this.index = i;
        this.name = str;
    }

    private Model create(String str, String str2, int i) throws Exception {
        TreeModel treeModel = new TreeModel(this.policy, this.detail, str, str2, i);
        if (str != null) {
            this.models.register(str, treeModel);
            this.order.add(str);
        }
        return treeModel;
    }

    private void validateAttributes(Class cls) throws Exception {
        for (String str : this.attributes.keySet()) {
            if (this.attributes.get(str) == null) {
                throw new AttributeException("Ordered attribute '%s' does not exist in %s", str, cls);
            }
            Expression expression = this.expression;
            if (expression != null) {
                expression.getAttribute(str);
            }
        }
    }

    private void validateElements(Class cls) throws Exception {
        for (String str : this.elements.keySet()) {
            ModelList modelList = this.models.get(str);
            Label label = this.elements.get(str);
            if (modelList == null && label == null) {
                throw new ElementException("Ordered element '%s' does not exist in %s", str, cls);
            }
            if (modelList != null && label != null && !modelList.isEmpty()) {
                throw new ElementException("Element '%s' is also a path name in %s", str, cls);
            }
            Expression expression = this.expression;
            if (expression != null) {
                expression.getElement(str);
            }
        }
    }

    private void validateExpression(Label label) throws Exception {
        Expression expression = label.getExpression();
        Expression expression2 = this.expression;
        if (expression2 == null) {
            this.expression = expression;
            return;
        }
        String path = expression2.getPath();
        String path2 = expression.getPath();
        if (!path.equals(path2)) {
            throw new PathException("Path '%s' does not match '%s' in %s", path, path2, this.detail);
        }
    }

    private void validateExpressions(Class cls) throws Exception {
        Iterator<Label> it = this.elements.iterator();
        while (it.hasNext()) {
            Label next = it.next();
            if (next != null) {
                validateExpression(next);
            }
        }
        Iterator<Label> it2 = this.attributes.iterator();
        while (it2.hasNext()) {
            Label next2 = it2.next();
            if (next2 != null) {
                validateExpression(next2);
            }
        }
        Label label = this.text;
        if (label != null) {
            validateExpression(label);
        }
    }

    private void validateModels(Class cls) throws Exception {
        Iterator<ModelList> it = this.models.iterator();
        while (it.hasNext()) {
            Iterator<Model> it2 = it.next().iterator();
            int i = 1;
            while (it2.hasNext()) {
                Model next = it2.next();
                if (next != null) {
                    String name = next.getName();
                    int index = next.getIndex();
                    int i2 = i + 1;
                    if (index != i) {
                        throw new ElementException("Path section '%s[%s]' is out of sequence in %s", name, Integer.valueOf(index), cls);
                    }
                    next.validate(cls);
                    i = i2;
                }
            }
        }
    }

    private void validateText(Class cls) throws Exception {
        if (this.text != null) {
            if (!this.elements.isEmpty()) {
                throw new TextException("Text annotation %s used with elements in %s", this.text, cls);
            }
            if (isComposite()) {
                throw new TextException("Text annotation %s can not be used with paths in %s", this.text, cls);
            }
        }
    }

    @Override // org.simpleframework.xml.core.Model
    public LabelMap getAttributes() throws Exception {
        return this.attributes.getLabels();
    }

    @Override // org.simpleframework.xml.core.Model
    public LabelMap getElements() throws Exception {
        return this.elements.getLabels();
    }

    @Override // org.simpleframework.xml.core.Model
    public Expression getExpression() {
        return this.expression;
    }

    @Override // org.simpleframework.xml.core.Model
    public int getIndex() {
        return this.index;
    }

    @Override // org.simpleframework.xml.core.Model
    public ModelMap getModels() throws Exception {
        return this.models.getModels();
    }

    @Override // org.simpleframework.xml.core.Model
    public String getName() {
        return this.name;
    }

    @Override // org.simpleframework.xml.core.Model
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.simpleframework.xml.core.Model
    public Label getText() {
        Label label = this.list;
        return label != null ? label : this.text;
    }

    @Override // org.simpleframework.xml.core.Model
    public boolean isAttribute(String str) {
        return this.attributes.containsKey(str);
    }

    @Override // org.simpleframework.xml.core.Model
    public boolean isComposite() {
        Iterator<ModelList> it = this.models.iterator();
        while (it.hasNext()) {
            Iterator<Model> it2 = it.next().iterator();
            while (it2.hasNext()) {
                Model next = it2.next();
                if (next != null && !next.isEmpty()) {
                    return true;
                }
            }
        }
        return !this.models.isEmpty();
    }

    @Override // org.simpleframework.xml.core.Model
    public boolean isElement(String str) {
        return this.elements.containsKey(str);
    }

    @Override // org.simpleframework.xml.core.Model
    public boolean isEmpty() {
        if (this.text == null && this.elements.isEmpty() && this.attributes.isEmpty()) {
            return !isComposite();
        }
        return false;
    }

    @Override // org.simpleframework.xml.core.Model
    public boolean isModel(String str) {
        return this.models.containsKey(str);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.order.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList.iterator();
    }

    @Override // org.simpleframework.xml.core.Model
    public Model lookup(String str, int i) {
        return this.models.lookup(str, i);
    }

    @Override // org.simpleframework.xml.core.Model
    public Model lookup(Expression expression) {
        Model lookup = lookup(expression.getFirst(), expression.getIndex());
        if (expression.isPath()) {
            Expression path = expression.getPath(1, 0);
            if (lookup != null) {
                return lookup.lookup(path);
            }
        }
        return lookup;
    }

    @Override // org.simpleframework.xml.core.Model
    public Model register(String str, String str2, int i) throws Exception {
        Model lookup = this.models.lookup(str, i);
        return lookup == null ? create(str, str2, i) : lookup;
    }

    @Override // org.simpleframework.xml.core.Model
    public void register(Label label) throws Exception {
        if (label.isAttribute()) {
            registerAttribute(label);
        } else if (label.isText()) {
            registerText(label);
        } else {
            registerElement(label);
        }
    }

    @Override // org.simpleframework.xml.core.Model
    public void registerAttribute(String str) throws Exception {
        this.attributes.put(str, null);
    }

    @Override // org.simpleframework.xml.core.Model
    public void registerAttribute(Label label) throws Exception {
        String name = label.getName();
        if (this.attributes.get(name) == null) {
            this.attributes.put(name, label);
            return;
        }
        throw new AttributeException("Duplicate annotation of name '%s' on %s", name, label);
    }

    @Override // org.simpleframework.xml.core.Model
    public void registerElement(String str) throws Exception {
        if (!this.order.contains(str)) {
            this.order.add(str);
        }
        this.elements.put(str, null);
    }

    @Override // org.simpleframework.xml.core.Model
    public void registerElement(Label label) throws Exception {
        String name = label.getName();
        if (this.elements.get(name) == null) {
            if (!this.order.contains(name)) {
                this.order.add(name);
            }
            if (label.isTextList()) {
                this.list = label;
            }
            this.elements.put(name, label);
            return;
        }
        throw new ElementException("Duplicate annotation of name '%s' on %s", name, label);
    }

    @Override // org.simpleframework.xml.core.Model
    public void registerText(Label label) throws Exception {
        if (this.text == null) {
            this.text = label;
            return;
        }
        throw new TextException("Duplicate text annotation on %s", label);
    }

    public String toString() {
        return String.format("model '%s[%s]'", this.name, Integer.valueOf(this.index));
    }

    @Override // org.simpleframework.xml.core.Model
    public void validate(Class cls) throws Exception {
        validateExpressions(cls);
        validateAttributes(cls);
        validateElements(cls);
        validateModels(cls);
        validateText(cls);
    }
}

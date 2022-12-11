package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class ObjectLiteral extends AstNode implements DestructuringForm {
    public static final List<ObjectProperty> NO_ELEMS = Collections.unmodifiableList(new ArrayList());
    public List<ObjectProperty> elements;
    public boolean isDestructuring;

    public ObjectLiteral() {
        this.type = 67;
    }

    public ObjectLiteral(int i) {
        super(i);
        this.type = 67;
    }

    public ObjectLiteral(int i, int i2) {
        super(i, i2);
        this.type = 67;
    }

    public void addElement(ObjectProperty objectProperty) {
        assertNotNull(objectProperty);
        if (this.elements == null) {
            this.elements = new ArrayList();
        }
        this.elements.add(objectProperty);
        objectProperty.setParent(this);
    }

    public List<ObjectProperty> getElements() {
        List<ObjectProperty> list = this.elements;
        return list != null ? list : NO_ELEMS;
    }

    @Override // org.mozilla.javascript.ast.DestructuringForm
    public boolean isDestructuring() {
        return this.isDestructuring;
    }

    public void setElements(List<ObjectProperty> list) {
        if (list == null) {
            this.elements = null;
            return;
        }
        List<ObjectProperty> list2 = this.elements;
        if (list2 != null) {
            list2.clear();
        }
        for (ObjectProperty objectProperty : list) {
            addElement(objectProperty);
        }
    }

    @Override // org.mozilla.javascript.ast.DestructuringForm
    public void setIsDestructuring(boolean z) {
        this.isDestructuring = z;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("{");
        List<ObjectProperty> list = this.elements;
        if (list != null) {
            printList(list, sb);
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            for (ObjectProperty objectProperty : getElements()) {
                objectProperty.visit(nodeVisitor);
            }
        }
    }
}

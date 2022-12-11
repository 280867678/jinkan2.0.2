package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class XmlPropRef extends XmlRef {
    public Name propName;

    public XmlPropRef() {
        this.type = 80;
    }

    public XmlPropRef(int i) {
        super(i);
        this.type = 80;
    }

    public XmlPropRef(int i, int i2) {
        super(i, i2);
        this.type = 80;
    }

    public Name getPropName() {
        return this.propName;
    }

    public void setPropName(Name name) {
        assertNotNull(name);
        this.propName = name;
        name.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        if (isAttributeAccess()) {
            sb.append("@");
        }
        Name name = this.namespace;
        if (name != null) {
            sb.append(name.toSource(0));
            sb.append("::");
        }
        sb.append(this.propName.toSource(0));
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            Name name = this.namespace;
            if (name != null) {
                name.visit(nodeVisitor);
            }
            this.propName.visit(nodeVisitor);
        }
    }
}

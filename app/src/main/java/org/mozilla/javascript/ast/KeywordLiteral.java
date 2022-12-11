package org.mozilla.javascript.ast;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class KeywordLiteral extends AstNode {
    public KeywordLiteral() {
    }

    public KeywordLiteral(int i) {
        super(i);
    }

    public KeywordLiteral(int i, int i2) {
        super(i, i2);
    }

    public KeywordLiteral(int i, int i2, int i3) {
        super(i, i2);
        mo5274setType(i3);
    }

    public boolean isBooleanLiteral() {
        int i = this.type;
        return i == 45 || i == 44;
    }

    @Override // org.mozilla.javascript.Node
    /* renamed from: setType  reason: collision with other method in class */
    public KeywordLiteral mo5274setType(int i) {
        if (i == 43 || i == 42 || i == 45 || i == 44 || i == 161) {
            this.type = i;
            return this;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid node type: ", i));
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        int type = getType();
        if (type != 161) {
            switch (type) {
                case 42:
                    str = "null";
                    break;
                case 43:
                    str = "this";
                    break;
                case 44:
                    str = "false";
                    break;
                case 45:
                    str = "true";
                    break;
                default:
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid keyword literal type: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getType());
                    throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        } else {
            str = "debugger;\n";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}

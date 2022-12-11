package org.mozilla.javascript.ast;

import me.tvspark.outline;
import org.mozilla.javascript.Token;

/* loaded from: classes5.dex */
public class Label extends Jump {
    public String name;

    public Label() {
        this.type = Token.LABEL;
    }

    public Label(int i) {
        this(i, -1);
    }

    public Label(int i, int i2) {
        this.type = Token.LABEL;
        this.position = i;
        this.length = i2;
    }

    public Label(int i, int i2, String str) {
        this(i, i2);
        setName(str);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        String trim = str == null ? null : str.trim();
        if (trim == null || "".equals(trim)) {
            throw new IllegalArgumentException("invalid label name");
        }
        this.name = trim;
    }

    @Override // org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, this.name, ":\n");
    }

    @Override // org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}

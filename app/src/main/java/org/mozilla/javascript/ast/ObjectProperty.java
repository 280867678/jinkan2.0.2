package org.mozilla.javascript.ast;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class ObjectProperty extends InfixExpression {
    public ObjectProperty() {
        this.type = 104;
    }

    public ObjectProperty(int i) {
        super(i);
        this.type = 104;
    }

    public ObjectProperty(int i, int i2) {
        super(i, i2);
        this.type = 104;
    }

    public boolean isGetterMethod() {
        return this.type == 152;
    }

    public boolean isMethod() {
        return isGetterMethod() || isSetterMethod() || isNormalMethod();
    }

    public boolean isNormalMethod() {
        return this.type == 164;
    }

    public boolean isSetterMethod() {
        return this.type == 153;
    }

    public void setIsGetterMethod() {
        this.type = 152;
    }

    public void setIsNormalMethod() {
        this.type = 164;
    }

    public void setIsSetterMethod() {
        this.type = 153;
    }

    public void setNodeType(int i) {
        if (i == 104 || i == 152 || i == 153 || i == 164) {
            mo5274setType(i);
            return;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("invalid node type: ", i));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    @Override // org.mozilla.javascript.ast.InfixExpression, org.mozilla.javascript.ast.AstNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toSource(int i) {
        String str;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\n");
        int i2 = i + 1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(makeIndent(i2));
        if (!isGetterMethod()) {
            if (isSetterMethod()) {
                str = "set ";
            }
            AstNode astNode = this.left;
            if (getType() == 104) {
                i = 0;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(astNode.toSource(i));
            if (this.type == 104) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(": ");
            }
            AstNode astNode2 = this.right;
            if (getType() == 104) {
                i2 = 0;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(astNode2.toSource(i2));
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        str = "get ";
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        AstNode astNode3 = this.left;
        if (getType() == 104) {
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(astNode3.toSource(i));
        if (this.type == 104) {
        }
        AstNode astNode22 = this.right;
        if (getType() == 104) {
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(astNode22.toSource(i2));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

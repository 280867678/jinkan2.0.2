package org.mozilla.javascript.ast;

import me.tvspark.outline;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;

/* loaded from: classes5.dex */
public class Symbol {
    public Scope containingTable;
    public int declType;
    public int index = -1;
    public String name;
    public Node node;

    public Symbol() {
    }

    public Symbol(int i, String str) {
        setName(str);
        setDeclType(i);
    }

    public Scope getContainingTable() {
        return this.containingTable;
    }

    public int getDeclType() {
        return this.declType;
    }

    public String getDeclTypeName() {
        return Token.typeToName(this.declType);
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public Node getNode() {
        return this.node;
    }

    public void setContainingTable(Scope scope) {
        this.containingTable = scope;
    }

    public void setDeclType(int i) {
        if (i == 110 || i == 88 || i == 123 || i == 154 || i == 155) {
            this.declType = i;
            return;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid declType: ", i));
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Symbol (");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDeclTypeName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") name=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.name);
        if (this.node != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" line=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.node.getLineno());
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

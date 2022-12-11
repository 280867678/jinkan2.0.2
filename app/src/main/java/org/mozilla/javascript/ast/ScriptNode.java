package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.tvspark.outline;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;

/* loaded from: classes5.dex */
public class ScriptNode extends Scope {
    public Object compilerData;
    public String encodedSource;
    public List<FunctionNode> functions;
    public boolean inStrictMode;
    public boolean[] isConsts;
    public List<RegExpLiteral> regexps;
    public String sourceName;
    public String[] variableNames;
    public int encodedSourceStart = -1;
    public int encodedSourceEnd = -1;
    public int endLineno = -1;
    public List<FunctionNode> EMPTY_LIST = Collections.emptyList();
    public List<Symbol> symbols = new ArrayList(4);
    public int paramCount = 0;
    public int tempNumber = 0;

    public ScriptNode() {
        this.top = this;
        this.type = Token.SCRIPT;
    }

    public ScriptNode(int i) {
        super(i);
        this.top = this;
        this.type = Token.SCRIPT;
    }

    public int addFunction(FunctionNode functionNode) {
        if (functionNode == null) {
            AstNode.codeBug();
        }
        if (this.functions == null) {
            this.functions = new ArrayList();
        }
        this.functions.add(functionNode);
        return this.functions.size() - 1;
    }

    public void addRegExp(RegExpLiteral regExpLiteral) {
        if (regExpLiteral == null) {
            AstNode.codeBug();
        }
        if (this.regexps == null) {
            this.regexps = new ArrayList();
        }
        this.regexps.add(regExpLiteral);
        regExpLiteral.putIntProp(4, this.regexps.size() - 1);
    }

    public void addSymbol(Symbol symbol) {
        if (this.variableNames != null) {
            AstNode.codeBug();
        }
        if (symbol.getDeclType() == 88) {
            this.paramCount++;
        }
        this.symbols.add(symbol);
    }

    public void flattenSymbolTable(boolean z) {
        if (!z) {
            ArrayList arrayList = new ArrayList();
            if (this.symbolTable != null) {
                for (int i = 0; i < this.symbols.size(); i++) {
                    Symbol symbol = this.symbols.get(i);
                    if (symbol.getContainingTable() == this) {
                        arrayList.add(symbol);
                    }
                }
            }
            this.symbols = arrayList;
        }
        this.variableNames = new String[this.symbols.size()];
        this.isConsts = new boolean[this.symbols.size()];
        for (int i2 = 0; i2 < this.symbols.size(); i2++) {
            Symbol symbol2 = this.symbols.get(i2);
            this.variableNames[i2] = symbol2.getName();
            this.isConsts[i2] = symbol2.getDeclType() == 155;
            symbol2.setIndex(i2);
        }
    }

    public int getBaseLineno() {
        return this.lineno;
    }

    public Object getCompilerData() {
        return this.compilerData;
    }

    public String getEncodedSource() {
        return this.encodedSource;
    }

    public int getEncodedSourceEnd() {
        return this.encodedSourceEnd;
    }

    public int getEncodedSourceStart() {
        return this.encodedSourceStart;
    }

    public int getEndLineno() {
        return this.endLineno;
    }

    public int getFunctionCount() {
        List<FunctionNode> list = this.functions;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public FunctionNode getFunctionNode(int i) {
        return this.functions.get(i);
    }

    public List<FunctionNode> getFunctions() {
        List<FunctionNode> list = this.functions;
        return list == null ? this.EMPTY_LIST : list;
    }

    public int getIndexForNameNode(Node node) {
        if (this.variableNames == null) {
            AstNode.codeBug();
        }
        Scope scope = node.getScope();
        Symbol symbol = scope == null ? null : scope.getSymbol(((Name) node).getIdentifier());
        if (symbol == null) {
            return -1;
        }
        return symbol.getIndex();
    }

    public String getNextTempName() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("$");
        int i = this.tempNumber;
        this.tempNumber = i + 1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public boolean[] getParamAndVarConst() {
        if (this.variableNames == null) {
            AstNode.codeBug();
        }
        return this.isConsts;
    }

    public int getParamAndVarCount() {
        if (this.variableNames == null) {
            AstNode.codeBug();
        }
        return this.symbols.size();
    }

    public String[] getParamAndVarNames() {
        if (this.variableNames == null) {
            AstNode.codeBug();
        }
        return this.variableNames;
    }

    public int getParamCount() {
        return this.paramCount;
    }

    public String getParamOrVarName(int i) {
        if (this.variableNames == null) {
            AstNode.codeBug();
        }
        return this.variableNames[i];
    }

    public int getRegexpCount() {
        List<RegExpLiteral> list = this.regexps;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public String getRegexpFlags(int i) {
        return this.regexps.get(i).getFlags();
    }

    public String getRegexpString(int i) {
        return this.regexps.get(i).getValue();
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public List<Symbol> getSymbols() {
        return this.symbols;
    }

    public boolean isInStrictMode() {
        return this.inStrictMode;
    }

    public void setBaseLineno(int i) {
        if (i < 0 || this.lineno >= 0) {
            AstNode.codeBug();
        }
        this.lineno = i;
    }

    public void setCompilerData(Object obj) {
        assertNotNull(obj);
        if (this.compilerData == null) {
            this.compilerData = obj;
            return;
        }
        throw new IllegalStateException();
    }

    public void setEncodedSource(String str) {
        this.encodedSource = str;
    }

    public void setEncodedSourceBounds(int i, int i2) {
        this.encodedSourceStart = i;
        this.encodedSourceEnd = i2;
    }

    public void setEncodedSourceEnd(int i) {
        this.encodedSourceEnd = i;
    }

    public void setEncodedSourceStart(int i) {
        this.encodedSourceStart = i;
    }

    public void setEndLineno(int i) {
        if (i < 0 || this.endLineno >= 0) {
            AstNode.codeBug();
        }
        this.endLineno = i;
    }

    public void setInStrictMode(boolean z) {
        this.inStrictMode = z;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }

    public void setSymbols(List<Symbol> list) {
        this.symbols = list;
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            Iterator<Node> it = iterator();
            while (it.hasNext()) {
                ((AstNode) it.next()).visit(nodeVisitor);
            }
        }
    }
}

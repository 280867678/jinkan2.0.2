package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.tvspark.outline;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.ArrayComprehension;
import org.mozilla.javascript.ast.ArrayComprehensionLoop;
import org.mozilla.javascript.ast.ArrayLiteral;
import org.mozilla.javascript.ast.Assignment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.Block;
import org.mozilla.javascript.ast.BreakStatement;
import org.mozilla.javascript.ast.CatchClause;
import org.mozilla.javascript.ast.Comment;
import org.mozilla.javascript.ast.ConditionalExpression;
import org.mozilla.javascript.ast.ContinueStatement;
import org.mozilla.javascript.ast.DestructuringForm;
import org.mozilla.javascript.ast.DoLoop;
import org.mozilla.javascript.ast.ElementGet;
import org.mozilla.javascript.ast.EmptyExpression;
import org.mozilla.javascript.ast.EmptyStatement;
import org.mozilla.javascript.ast.ErrorNode;
import org.mozilla.javascript.ast.ExpressionStatement;
import org.mozilla.javascript.ast.ForInLoop;
import org.mozilla.javascript.ast.ForLoop;
import org.mozilla.javascript.ast.FunctionCall;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.GeneratorExpression;
import org.mozilla.javascript.ast.GeneratorExpressionLoop;
import org.mozilla.javascript.ast.IdeErrorReporter;
import org.mozilla.javascript.ast.IfStatement;
import org.mozilla.javascript.ast.InfixExpression;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.KeywordLiteral;
import org.mozilla.javascript.ast.Label;
import org.mozilla.javascript.ast.LabeledStatement;
import org.mozilla.javascript.ast.LetNode;
import org.mozilla.javascript.ast.Loop;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.NewExpression;
import org.mozilla.javascript.ast.NumberLiteral;
import org.mozilla.javascript.ast.ObjectLiteral;
import org.mozilla.javascript.ast.ObjectProperty;
import org.mozilla.javascript.ast.ParenthesizedExpression;
import org.mozilla.javascript.ast.PropertyGet;
import org.mozilla.javascript.ast.RegExpLiteral;
import org.mozilla.javascript.ast.ReturnStatement;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.ast.StringLiteral;
import org.mozilla.javascript.ast.SwitchCase;
import org.mozilla.javascript.ast.SwitchStatement;
import org.mozilla.javascript.ast.ThrowStatement;
import org.mozilla.javascript.ast.TryStatement;
import org.mozilla.javascript.ast.UnaryExpression;
import org.mozilla.javascript.ast.VariableDeclaration;
import org.mozilla.javascript.ast.VariableInitializer;
import org.mozilla.javascript.ast.WhileLoop;
import org.mozilla.javascript.ast.WithStatement;
import org.mozilla.javascript.ast.XmlDotQuery;
import org.mozilla.javascript.ast.XmlElemRef;
import org.mozilla.javascript.ast.XmlExpression;
import org.mozilla.javascript.ast.XmlLiteral;
import org.mozilla.javascript.ast.XmlMemberGet;
import org.mozilla.javascript.ast.XmlPropRef;
import org.mozilla.javascript.ast.XmlRef;
import org.mozilla.javascript.ast.XmlString;
import org.mozilla.javascript.ast.Yield;
import org.simpleframework.xml.stream.DocumentReader;

/* loaded from: classes5.dex */
public class Parser {
    public static final int ARGC_LIMIT = 65536;
    public static final int CLEAR_TI_MASK = 65535;
    public static final int GET_ENTRY = 2;
    public static final int METHOD_ENTRY = 8;
    public static final int PROP_ENTRY = 1;
    public static final int SET_ENTRY = 4;
    public static final int TI_AFTER_EOL = 65536;
    public static final int TI_CHECK_LABEL = 131072;
    public boolean calledByCompileFunction;
    public CompilerEnvirons compilerEnv;
    public int currentFlaggedToken;
    public Comment currentJsDocComment;
    public LabeledStatement currentLabel;
    public Scope currentScope;
    public ScriptNode currentScriptOrFn;
    public int currentToken;
    public boolean defaultUseStrictDirective;
    public int endFlags;
    public IdeErrorReporter errorCollector;
    public ErrorReporter errorReporter;
    public boolean inDestructuringAssignment;
    public boolean inForInit;
    public boolean inUseStrictDirective;
    public Map<String, LabeledStatement> labelSet;
    public List<Jump> loopAndSwitchSet;
    public List<Loop> loopSet;
    public int nestingOfFunction;
    public boolean parseFinished;
    public int prevNameTokenLineno;
    public int prevNameTokenStart;
    public String prevNameTokenString;
    public List<Comment> scannedComments;
    public char[] sourceChars;
    public String sourceURI;
    public int syntaxErrorCount;

    /* renamed from: ts */
    public TokenStream f4679ts;

    /* loaded from: classes5.dex */
    public static class ConditionData {
        public AstNode condition;

        /* renamed from: lp */
        public int f4680lp;

        /* renamed from: rp */
        public int f4681rp;

        public ConditionData() {
            this.f4680lp = -1;
            this.f4681rp = -1;
        }
    }

    /* loaded from: classes5.dex */
    public static class ParserException extends RuntimeException {
        public static final long serialVersionUID = 5882582646773765630L;

        public ParserException() {
        }
    }

    /* loaded from: classes5.dex */
    public class PerFunctionVariables {
        public Scope savedCurrentScope;
        public ScriptNode savedCurrentScriptOrFn;
        public int savedEndFlags;
        public boolean savedInForInit;
        public Map<String, LabeledStatement> savedLabelSet;
        public List<Jump> savedLoopAndSwitchSet;
        public List<Loop> savedLoopSet;

        public PerFunctionVariables(FunctionNode functionNode) {
            this.savedCurrentScriptOrFn = Parser.this.currentScriptOrFn;
            Parser.this.currentScriptOrFn = functionNode;
            this.savedCurrentScope = Parser.this.currentScope;
            Parser.this.currentScope = functionNode;
            this.savedLabelSet = Parser.this.labelSet;
            Parser.this.labelSet = null;
            this.savedLoopSet = Parser.this.loopSet;
            Parser.this.loopSet = null;
            this.savedLoopAndSwitchSet = Parser.this.loopAndSwitchSet;
            Parser.this.loopAndSwitchSet = null;
            this.savedEndFlags = Parser.this.endFlags;
            Parser.this.endFlags = 0;
            this.savedInForInit = Parser.this.inForInit;
            Parser.this.inForInit = false;
        }

        public void restore() {
            Parser parser = Parser.this;
            parser.currentScriptOrFn = this.savedCurrentScriptOrFn;
            parser.currentScope = this.savedCurrentScope;
            parser.labelSet = this.savedLabelSet;
            Parser.this.loopSet = this.savedLoopSet;
            Parser.this.loopAndSwitchSet = this.savedLoopAndSwitchSet;
            Parser.this.endFlags = this.savedEndFlags;
            Parser.this.inForInit = this.savedInForInit;
        }
    }

    public Parser() {
        this(new CompilerEnvirons());
    }

    public Parser(CompilerEnvirons compilerEnvirons) {
        this(compilerEnvirons, compilerEnvirons.getErrorReporter());
    }

    public Parser(CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter) {
        this.currentFlaggedToken = 0;
        this.prevNameTokenString = "";
        this.compilerEnv = compilerEnvirons;
        this.errorReporter = errorReporter;
        if (errorReporter instanceof IdeErrorReporter) {
            this.errorCollector = (IdeErrorReporter) errorReporter;
        }
    }

    private void addError(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        this.syntaxErrorCount++;
        String lookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(lookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.error(lookupMessage, this.sourceURI, i3, str3, i4);
        }
    }

    private AstNode addExpr() throws IOException {
        AstNode mulExpr = mulExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.f4679ts.tokenBeg;
            if (peekToken == 21 || peekToken == 22) {
                consumeToken();
                mulExpr = new InfixExpression(peekToken, mulExpr, mulExpr(), i);
            } else {
                return mulExpr;
            }
        }
    }

    private void addStrictWarning(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i, i2, i3, str3, i4);
        }
    }

    private void addWarning(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        String lookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i, i2, i3, str3, i4);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(lookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.warning(lookupMessage, this.sourceURI, i3, str3, i4);
        }
    }

    private AstNode andExpr() throws IOException {
        AstNode bitOrExpr = bitOrExpr();
        if (matchToken(106, true)) {
            return new InfixExpression(106, bitOrExpr, andExpr(), this.f4679ts.tokenBeg);
        }
        return bitOrExpr;
    }

    private List<AstNode> argumentList() throws IOException {
        if (matchToken(89, true)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.inForInit;
        this.inForInit = false;
        do {
            try {
                if (peekToken() == 89) {
                    break;
                }
                if (peekToken() == 73) {
                    reportError("msg.yield.parenthesized");
                }
                AstNode assignExpr = assignExpr();
                if (peekToken() == 120) {
                    try {
                        arrayList.add(generatorExpression(assignExpr, 0, true));
                    } catch (IOException unused) {
                    }
                } else {
                    arrayList.add(assignExpr);
                }
            } catch (Throwable th) {
                this.inForInit = z;
                throw th;
            }
        } while (matchToken(90, true));
        this.inForInit = z;
        mustMatchToken(89, "msg.no.paren.arg", true);
        return arrayList;
    }

    private AstNode arrayComprehension(AstNode astNode, int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 120) {
            arrayList.add(arrayComprehensionLoop());
        }
        int i2 = -1;
        ConditionData conditionData = null;
        if (peekToken() == 113) {
            consumeToken();
            i2 = this.f4679ts.tokenBeg - i;
            conditionData = condition();
        }
        mustMatchToken(85, "msg.no.bracket.arg", true);
        ArrayComprehension arrayComprehension = new ArrayComprehension(i, this.f4679ts.tokenEnd - i);
        arrayComprehension.setResult(astNode);
        arrayComprehension.setLoops(arrayList);
        if (conditionData != null) {
            arrayComprehension.setIfPosition(i2);
            arrayComprehension.setFilter(conditionData.condition);
            arrayComprehension.setFilterLp(conditionData.f4680lp - i);
            arrayComprehension.setFilterRp(conditionData.f4681rp - i);
        }
        return arrayComprehension;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:12:0x003b, B:14:0x0043, B:15:0x004a, B:21:0x0059, B:22:0x006e, B:24:0x0074, B:25:0x007f, B:30:0x00ad, B:32:0x00b4, B:34:0x00c2, B:35:0x00c9, B:38:0x00e1, B:45:0x008b, B:46:0x0091, B:49:0x00a1, B:50:0x00a6, B:51:0x005f, B:52:0x0067, B:54:0x0037), top: B:5:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:12:0x003b, B:14:0x0043, B:15:0x004a, B:21:0x0059, B:22:0x006e, B:24:0x0074, B:25:0x007f, B:30:0x00ad, B:32:0x00b4, B:34:0x00c2, B:35:0x00c9, B:38:0x00e1, B:45:0x008b, B:46:0x0091, B:49:0x00a1, B:50:0x00a6, B:51:0x005f, B:52:0x0067, B:54:0x0037), top: B:5:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:12:0x003b, B:14:0x0043, B:15:0x004a, B:21:0x0059, B:22:0x006e, B:24:0x0074, B:25:0x007f, B:30:0x00ad, B:32:0x00b4, B:34:0x00c2, B:35:0x00c9, B:38:0x00e1, B:45:0x008b, B:46:0x0091, B:49:0x00a1, B:50:0x00a6, B:51:0x005f, B:52:0x0067, B:54:0x0037), top: B:5:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0091 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:12:0x003b, B:14:0x0043, B:15:0x004a, B:21:0x0059, B:22:0x006e, B:24:0x0074, B:25:0x007f, B:30:0x00ad, B:32:0x00b4, B:34:0x00c2, B:35:0x00c9, B:38:0x00e1, B:45:0x008b, B:46:0x0091, B:49:0x00a1, B:50:0x00a6, B:51:0x005f, B:52:0x0067, B:54:0x0037), top: B:5:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0067 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:12:0x003b, B:14:0x0043, B:15:0x004a, B:21:0x0059, B:22:0x006e, B:24:0x0074, B:25:0x007f, B:30:0x00ad, B:32:0x00b4, B:34:0x00c2, B:35:0x00c9, B:38:0x00e1, B:45:0x008b, B:46:0x0091, B:49:0x00a1, B:50:0x00a6, B:51:0x005f, B:52:0x0067, B:54:0x0037), top: B:5:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ArrayComprehensionLoop arrayComprehensionLoop() throws IOException {
        int i;
        AstNode astNode;
        int peekToken;
        int nextToken;
        int i2;
        boolean z;
        if (nextToken() != 120) {
            codeBug();
        }
        int i3 = this.f4679ts.tokenBeg;
        ArrayComprehensionLoop arrayComprehensionLoop = new ArrayComprehensionLoop(i3);
        pushScope(arrayComprehensionLoop);
        boolean z2 = true;
        try {
            if (matchToken(39, true)) {
                if (this.f4679ts.getString().equals("each")) {
                    i = this.f4679ts.tokenBeg - i3;
                    int i4 = !mustMatchToken(88, "msg.no.paren.for", true) ? this.f4679ts.tokenBeg - i3 : -1;
                    astNode = null;
                    peekToken = peekToken();
                    if (peekToken != 39) {
                        consumeToken();
                        astNode = createNameNode();
                    } else if (peekToken == 84 || peekToken == 86) {
                        astNode = destructuringPrimaryExpr();
                        markDestructuring(astNode);
                    } else {
                        reportError("msg.bad.var");
                    }
                    if (astNode.getType() == 39) {
                        defineSymbol(154, this.f4679ts.getString(), true);
                    }
                    nextToken = nextToken();
                    if (nextToken == 39) {
                        if (nextToken == 52) {
                            i2 = this.f4679ts.tokenBeg - i3;
                            z = false;
                            AstNode expr = expr();
                            int i5 = !mustMatchToken(89, "msg.no.paren.for.ctrl", true) ? this.f4679ts.tokenBeg - i3 : -1;
                            arrayComprehensionLoop.setLength(this.f4679ts.tokenEnd - i3);
                            arrayComprehensionLoop.setIterator(astNode);
                            arrayComprehensionLoop.setIteratedObject(expr);
                            arrayComprehensionLoop.setInPosition(i2);
                            arrayComprehensionLoop.setEachPosition(i);
                            if (i != -1) {
                                z2 = false;
                            }
                            arrayComprehensionLoop.setIsForEach(z2);
                            arrayComprehensionLoop.setParens(i4, i5);
                            arrayComprehensionLoop.setIsForOf(z);
                            return arrayComprehensionLoop;
                        }
                    } else if ("of".equals(this.f4679ts.getString())) {
                        if (i != -1) {
                            reportError("msg.invalid.for.each");
                        }
                        i2 = this.f4679ts.tokenBeg - i3;
                        z = true;
                        AstNode expr2 = expr();
                        if (!mustMatchToken(89, "msg.no.paren.for.ctrl", true)) {
                        }
                        arrayComprehensionLoop.setLength(this.f4679ts.tokenEnd - i3);
                        arrayComprehensionLoop.setIterator(astNode);
                        arrayComprehensionLoop.setIteratedObject(expr2);
                        arrayComprehensionLoop.setInPosition(i2);
                        arrayComprehensionLoop.setEachPosition(i);
                        if (i != -1) {
                        }
                        arrayComprehensionLoop.setIsForEach(z2);
                        arrayComprehensionLoop.setParens(i4, i5);
                        arrayComprehensionLoop.setIsForOf(z);
                        return arrayComprehensionLoop;
                    }
                    reportError("msg.in.after.for.name");
                    i2 = -1;
                    z = false;
                    AstNode expr22 = expr();
                    if (!mustMatchToken(89, "msg.no.paren.for.ctrl", true)) {
                    }
                    arrayComprehensionLoop.setLength(this.f4679ts.tokenEnd - i3);
                    arrayComprehensionLoop.setIterator(astNode);
                    arrayComprehensionLoop.setIteratedObject(expr22);
                    arrayComprehensionLoop.setInPosition(i2);
                    arrayComprehensionLoop.setEachPosition(i);
                    if (i != -1) {
                    }
                    arrayComprehensionLoop.setIsForEach(z2);
                    arrayComprehensionLoop.setParens(i4, i5);
                    arrayComprehensionLoop.setIsForOf(z);
                    return arrayComprehensionLoop;
                }
                reportError("msg.no.paren.for");
            }
            i = -1;
            if (!mustMatchToken(88, "msg.no.paren.for", true)) {
            }
            astNode = null;
            peekToken = peekToken();
            if (peekToken != 39) {
            }
            if (astNode.getType() == 39) {
            }
            nextToken = nextToken();
            if (nextToken == 39) {
            }
            reportError("msg.in.after.for.name");
            i2 = -1;
            z = false;
            AstNode expr222 = expr();
            if (!mustMatchToken(89, "msg.no.paren.for.ctrl", true)) {
            }
            arrayComprehensionLoop.setLength(this.f4679ts.tokenEnd - i3);
            arrayComprehensionLoop.setIterator(astNode);
            arrayComprehensionLoop.setIteratedObject(expr222);
            arrayComprehensionLoop.setInPosition(i2);
            arrayComprehensionLoop.setEachPosition(i);
            if (i != -1) {
            }
            arrayComprehensionLoop.setIsForEach(z2);
            arrayComprehensionLoop.setParens(i4, i5);
            arrayComprehensionLoop.setIsForOf(z);
            return arrayComprehensionLoop;
        } finally {
            popScope();
        }
    }

    private AstNode arrayLiteral() throws IOException {
        int peekToken;
        if (this.currentToken != 84) {
            codeBug();
        }
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.tokenBeg;
        int i2 = tokenStream.tokenEnd;
        ArrayList arrayList = new ArrayList();
        ArrayLiteral arrayLiteral = new ArrayLiteral(i);
        int i3 = 1;
        int i4 = 0;
        while (true) {
            int i5 = -1;
            while (true) {
                peekToken = peekToken();
                if (peekToken != 90) {
                    break;
                }
                consumeToken();
                i5 = this.f4679ts.tokenEnd;
                if (i3 == 0) {
                    i3 = 1;
                } else {
                    arrayList.add(new EmptyExpression(this.f4679ts.tokenBeg, 1));
                    i4++;
                }
            }
            if (peekToken == 85) {
                consumeToken();
                i2 = this.f4679ts.tokenEnd;
                arrayLiteral.setDestructuringLength(arrayList.size() + i3);
                arrayLiteral.setSkipCount(i4);
                if (i5 != -1) {
                    warnTrailingComma(i, arrayList, i5);
                }
            } else if (peekToken == 120 && i3 == 0 && arrayList.size() == 1) {
                return arrayComprehension((AstNode) arrayList.get(0), i);
            } else {
                if (peekToken == 0) {
                    reportError("msg.no.bracket.arg");
                    break;
                }
                if (i3 == 0) {
                    reportError("msg.no.bracket.arg");
                }
                arrayList.add(assignExpr());
                i3 = 0;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayLiteral.addElement((AstNode) it.next());
        }
        arrayLiteral.setLength(i2 - i);
        return arrayLiteral;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
        if ((r10 instanceof org.mozilla.javascript.ast.EmptyExpression) == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AstNode arrowFunction(AstNode astNode) throws IOException {
        int i = this.f4679ts.lineno;
        int position = astNode != null ? astNode.getPosition() : -1;
        FunctionNode functionNode = new FunctionNode(position);
        functionNode.setFunctionType(4);
        functionNode.setJsDocNode(getAndResetJsDoc());
        HashMap hashMap = new HashMap();
        Set<String> hashSet = new HashSet<>();
        PerFunctionVariables perFunctionVariables = new PerFunctionVariables(functionNode);
        try {
            if (astNode instanceof ParenthesizedExpression) {
                functionNode.setParens(0, astNode.getLength());
                astNode = ((ParenthesizedExpression) astNode).getExpression();
            }
            arrowFunctionParams(functionNode, astNode, hashMap, hashSet);
            if (!hashMap.isEmpty()) {
                Node node = new Node(90);
                for (Map.Entry entry : hashMap.entrySet()) {
                    node.addChildToBack(createDestructuringAssignment(123, (Node) entry.getValue(), createName((String) entry.getKey())));
                }
                functionNode.putProp(23, node);
            }
            functionNode.setBody(parseFunctionBody(4, functionNode));
            functionNode.setEncodedSourceBounds(position, this.f4679ts.tokenEnd);
            functionNode.setLength(this.f4679ts.tokenEnd - position);
            perFunctionVariables.restore();
            if (functionNode.isGenerator()) {
                reportError("msg.arrowfunction.generator");
                return makeErrorNode();
            }
            functionNode.setSourceName(this.sourceURI);
            functionNode.setBaseLineno(i);
            functionNode.setEndLineno(this.f4679ts.lineno);
            return functionNode;
        } catch (Throwable th) {
            perFunctionVariables.restore();
            throw th;
        }
    }

    private void arrowFunctionParams(FunctionNode functionNode, AstNode astNode, Map<String, Node> map, Set<String> set) {
        if ((astNode instanceof ArrayLiteral) || (astNode instanceof ObjectLiteral)) {
            markDestructuring(astNode);
            functionNode.addParam(astNode);
            String nextTempName = this.currentScriptOrFn.getNextTempName();
            defineSymbol(88, nextTempName, false);
            map.put(nextTempName, astNode);
        } else if ((astNode instanceof InfixExpression) && astNode.getType() == 90) {
            InfixExpression infixExpression = (InfixExpression) astNode;
            arrowFunctionParams(functionNode, infixExpression.getLeft(), map, set);
            arrowFunctionParams(functionNode, infixExpression.getRight(), map, set);
        } else if (!(astNode instanceof Name)) {
            reportError("msg.no.parm", astNode.getPosition(), astNode.getLength());
            functionNode.addParam(makeErrorNode());
        } else {
            functionNode.addParam(astNode);
            String identifier = ((Name) astNode).getIdentifier();
            defineSymbol(88, identifier);
            if (!this.inUseStrictDirective) {
                return;
            }
            if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                reportError("msg.bad.id.strict", identifier);
            }
            if (set.contains(identifier)) {
                addError("msg.dup.param.strict", identifier);
            }
            set.add(identifier);
        }
    }

    private AstNode assignExpr() throws IOException {
        int peekToken = peekToken();
        boolean z = true;
        if (peekToken == 73) {
            return returnOrYield(peekToken, true);
        }
        AstNode condExpr = condExpr();
        int peekTokenOrEOL = peekTokenOrEOL();
        if (peekTokenOrEOL == 1) {
            peekTokenOrEOL = peekToken();
        } else {
            z = false;
        }
        if (91 > peekTokenOrEOL || peekTokenOrEOL > 102) {
            if (peekTokenOrEOL == 83) {
                if (this.currentJsDocComment == null) {
                    return condExpr;
                }
                condExpr.setJsDocNode(getAndResetJsDoc());
                return condExpr;
            } else if (z || peekTokenOrEOL != 165) {
                return condExpr;
            } else {
                consumeToken();
                return arrowFunction(condExpr);
            }
        }
        if (this.inDestructuringAssignment) {
            reportError("msg.destruct.default.vals");
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        markDestructuring(condExpr);
        Assignment assignment = new Assignment(peekTokenOrEOL, condExpr, assignExpr(), this.f4679ts.tokenBeg);
        if (andResetJsDoc != null) {
            assignment.setJsDocNode(andResetJsDoc);
        }
        return assignment;
    }

    private AstNode attributeAccess() throws IOException {
        int nextToken = nextToken();
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.tokenBeg;
        if (nextToken == 23) {
            saveNameTokenData(i, "*", tokenStream.lineno);
            return propertyName(i, "*", 0);
        } else if (nextToken == 39) {
            return propertyName(i, tokenStream.getString(), 0);
        } else {
            if (nextToken == 84) {
                return xmlElemRef(i, null, -1);
            }
            reportError("msg.no.name.after.xmlAttr");
            return makeErrorNode();
        }
    }

    private void autoInsertSemicolon(AstNode astNode) throws IOException {
        int max;
        int peekFlaggedToken = peekFlaggedToken();
        int position = astNode.getPosition();
        int i = 65535 & peekFlaggedToken;
        if (i != -1 && i != 0) {
            if (i == 83) {
                consumeToken();
                astNode.setLength(this.f4679ts.tokenEnd - position);
                return;
            } else if (i != 87) {
                if ((peekFlaggedToken & 65536) == 0) {
                    reportError("msg.no.semi.stmt");
                    return;
                }
                max = nodeEnd(astNode);
                warnMissingSemi(position, max);
            }
        }
        max = Math.max(position + 1, nodeEnd(astNode));
        warnMissingSemi(position, max);
    }

    private AstNode bitAndExpr() throws IOException {
        AstNode eqExpr = eqExpr();
        while (matchToken(11, true)) {
            eqExpr = new InfixExpression(11, eqExpr, eqExpr(), this.f4679ts.tokenBeg);
        }
        return eqExpr;
    }

    private AstNode bitOrExpr() throws IOException {
        AstNode bitXorExpr = bitXorExpr();
        while (matchToken(9, true)) {
            bitXorExpr = new InfixExpression(9, bitXorExpr, bitXorExpr(), this.f4679ts.tokenBeg);
        }
        return bitXorExpr;
    }

    private AstNode bitXorExpr() throws IOException {
        AstNode bitAndExpr = bitAndExpr();
        while (matchToken(10, true)) {
            bitAndExpr = new InfixExpression(10, bitAndExpr, bitAndExpr(), this.f4679ts.tokenBeg);
        }
        return bitAndExpr;
    }

    private AstNode block() throws IOException {
        if (this.currentToken != 86) {
            codeBug();
        }
        consumeToken();
        int i = this.f4679ts.tokenBeg;
        Scope scope = new Scope(i);
        scope.setLineno(this.f4679ts.lineno);
        pushScope(scope);
        try {
            statements(scope);
            mustMatchToken(87, "msg.no.brace.block", true);
            scope.setLength(this.f4679ts.tokenEnd - i);
            return scope;
        } finally {
            popScope();
        }
    }

    private BreakStatement breakStatement() throws IOException {
        int i;
        Name name;
        List<Jump> list;
        if (this.currentToken != 121) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.f4679ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        int i4 = tokenStream.tokenEnd;
        Jump jump = null;
        if (peekTokenOrEOL() == 39) {
            name = createNameNode();
            i = getNodeEnd(name);
        } else {
            i = i4;
            name = null;
        }
        LabeledStatement matchJumpLabelName = matchJumpLabelName();
        if (matchJumpLabelName != null) {
            jump = matchJumpLabelName.getFirstLabel();
        }
        if (jump == null && name == null) {
            List<Jump> list2 = this.loopAndSwitchSet;
            if (list2 == null || list2.size() == 0) {
                reportError("msg.bad.break", i3, i - i3);
            } else {
                jump = this.loopAndSwitchSet.get(list.size() - 1);
            }
        }
        BreakStatement breakStatement = new BreakStatement(i3, i - i3);
        breakStatement.setBreakLabel(name);
        if (jump != null) {
            breakStatement.setBreakTarget(jump);
        }
        breakStatement.setLineno(i2);
        return breakStatement;
    }

    private void checkBadIncDec(UnaryExpression unaryExpression) {
        int type = removeParens(unaryExpression.getOperand()).getType();
        if (type == 39 || type == 33 || type == 36 || type == 68 || type == 38) {
            return;
        }
        reportError(unaryExpression.getType() == 107 ? "msg.bad.incr" : "msg.bad.decr");
    }

    private void checkCallRequiresActivation(AstNode astNode) {
        if ((astNode.getType() != 39 || !"eval".equals(((Name) astNode).getIdentifier())) && (astNode.getType() != 33 || !"eval".equals(((PropertyGet) astNode).getProperty().getIdentifier()))) {
            return;
        }
        setRequiresActivation();
    }

    private RuntimeException codeBug() throws RuntimeException {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ts.cursor=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4679ts.cursor);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ts.tokenBeg=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4679ts.tokenBeg);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", currentToken=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.currentToken);
        throw Kit.codeBug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    private AstNode condExpr() throws IOException {
        AstNode orExpr = orExpr();
        if (matchToken(103, true)) {
            TokenStream tokenStream = this.f4679ts;
            int i = tokenStream.lineno;
            int i2 = tokenStream.tokenBeg;
            int i3 = -1;
            boolean z = this.inForInit;
            this.inForInit = false;
            try {
                AstNode assignExpr = assignExpr();
                this.inForInit = z;
                if (mustMatchToken(104, "msg.no.colon.cond", true)) {
                    i3 = this.f4679ts.tokenBeg;
                }
                AstNode assignExpr2 = assignExpr();
                int position = orExpr.getPosition();
                ConditionalExpression conditionalExpression = new ConditionalExpression(position, getNodeEnd(assignExpr2) - position);
                conditionalExpression.setLineno(i);
                conditionalExpression.setTestExpression(orExpr);
                conditionalExpression.setTrueExpression(assignExpr);
                conditionalExpression.setFalseExpression(assignExpr2);
                conditionalExpression.setQuestionMarkPosition(i2 - position);
                conditionalExpression.setColonPosition(i3 - position);
                return conditionalExpression;
            } catch (Throwable th) {
                this.inForInit = z;
                throw th;
            }
        }
        return orExpr;
    }

    private ConditionData condition() throws IOException {
        ConditionData conditionData = new ConditionData();
        if (mustMatchToken(88, "msg.no.paren.cond", true)) {
            conditionData.f4680lp = this.f4679ts.tokenBeg;
        }
        conditionData.condition = expr();
        if (mustMatchToken(89, "msg.no.paren.after.cond", true)) {
            conditionData.f4681rp = this.f4679ts.tokenBeg;
        }
        AstNode astNode = conditionData.condition;
        if (astNode instanceof Assignment) {
            addStrictWarning("msg.equal.as.assign", "", astNode.getPosition(), conditionData.condition.getLength());
        }
        return conditionData;
    }

    private void consumeToken() {
        this.currentFlaggedToken = 0;
    }

    private ContinueStatement continueStatement() throws IOException {
        int i;
        Name name;
        AstNode astNode;
        List<Loop> list;
        if (this.currentToken != 122) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.f4679ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        int i4 = tokenStream.tokenEnd;
        Loop loop = null;
        if (peekTokenOrEOL() == 39) {
            name = createNameNode();
            i = getNodeEnd(name);
        } else {
            i = i4;
            name = null;
        }
        LabeledStatement matchJumpLabelName = matchJumpLabelName();
        if (matchJumpLabelName == null && name == null) {
            List<Loop> list2 = this.loopSet;
            if (list2 == null || list2.size() == 0) {
                reportError("msg.continue.outside");
            } else {
                astNode = this.loopSet.get(list.size() - 1);
                loop = (Loop) astNode;
            }
        } else {
            if (matchJumpLabelName == null || !(matchJumpLabelName.getStatement() instanceof Loop)) {
                reportError("msg.continue.nonloop", i3, i - i3);
            }
            if (matchJumpLabelName != null) {
                astNode = matchJumpLabelName.getStatement();
                loop = (Loop) astNode;
            }
        }
        ContinueStatement continueStatement = new ContinueStatement(i3, i - i3);
        if (loop != null) {
            continueStatement.setTarget(loop);
        }
        continueStatement.setLabel(name);
        continueStatement.setLineno(i2);
        return continueStatement;
    }

    private Name createNameNode() {
        return createNameNode(false, 39);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Name createNameNode(boolean z, int i) {
        TokenStream tokenStream = this.f4679ts;
        int i2 = tokenStream.tokenBeg;
        String string = tokenStream.getString();
        int i3 = this.f4679ts.lineno;
        String str = "";
        if (!str.equals(this.prevNameTokenString)) {
            i2 = this.prevNameTokenStart;
            string = this.prevNameTokenString;
            i3 = this.prevNameTokenLineno;
            this.prevNameTokenStart = 0;
            this.prevNameTokenString = str;
            this.prevNameTokenLineno = 0;
        }
        if (string == null) {
            if (!this.compilerEnv.isIdeMode()) {
                codeBug();
            }
            Name name = new Name(i2, str);
            name.setLineno(i3);
            if (z) {
                checkActivationName(str, i);
            }
            return name;
        }
        str = string;
        Name name2 = new Name(i2, str);
        name2.setLineno(i3);
        if (z) {
        }
        return name2;
    }

    private StringLiteral createStringLiteral() {
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.tokenBeg;
        StringLiteral stringLiteral = new StringLiteral(i, tokenStream.tokenEnd - i);
        stringLiteral.setLineno(this.f4679ts.lineno);
        stringLiteral.setValue(this.f4679ts.getString());
        stringLiteral.setQuoteCharacter(this.f4679ts.getQuoteChar());
        return stringLiteral;
    }

    private AstNode defaultXmlNamespace() throws IOException {
        if (this.currentToken != 117) {
            codeBug();
        }
        consumeToken();
        mustHaveXML();
        setRequiresActivation();
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        if (!matchToken(39, true) || !DocumentReader.RESERVED.equals(this.f4679ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(39, true) || !"namespace".equals(this.f4679ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(91, true)) {
            reportError("msg.bad.namespace");
        }
        AstNode expr = expr();
        UnaryExpression unaryExpression = new UnaryExpression(i2, getNodeEnd(expr) - i2);
        unaryExpression.setOperator(75);
        unaryExpression.setOperand(expr);
        unaryExpression.setLineno(i);
        return new ExpressionStatement((AstNode) unaryExpression, true);
    }

    private AstNode destructuringPrimaryExpr() throws IOException, ParserException {
        try {
            this.inDestructuringAssignment = true;
            return primaryExpr();
        } finally {
            this.inDestructuringAssignment = false;
        }
    }

    private DoLoop doLoop() throws IOException {
        if (this.currentToken != 119) {
            codeBug();
        }
        consumeToken();
        int i = this.f4679ts.tokenBeg;
        DoLoop doLoop = new DoLoop(i);
        doLoop.setLineno(this.f4679ts.lineno);
        enterLoop(doLoop);
        try {
            AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(doLoop);
            mustMatchToken(118, "msg.no.while.do", true);
            doLoop.setWhilePosition(this.f4679ts.tokenBeg - i);
            ConditionData condition = condition();
            doLoop.setCondition(condition.condition);
            doLoop.setParens(condition.f4680lp - i, condition.f4681rp - i);
            int nodeEnd = getNodeEnd(nextStatementAfterInlineComments);
            doLoop.setBody(nextStatementAfterInlineComments);
            exitLoop();
            if (matchToken(83, true)) {
                nodeEnd = this.f4679ts.tokenEnd;
            }
            doLoop.setLength(nodeEnd - i);
            return doLoop;
        } catch (Throwable th) {
            exitLoop();
            throw th;
        }
    }

    private void enterLoop(Loop loop) {
        if (this.loopSet == null) {
            this.loopSet = new ArrayList();
        }
        this.loopSet.add(loop);
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(loop);
        pushScope(loop);
        LabeledStatement labeledStatement = this.currentLabel;
        if (labeledStatement != null) {
            labeledStatement.setStatement(loop);
            this.currentLabel.getFirstLabel().setLoop(loop);
            loop.setRelative(-this.currentLabel.getPosition());
        }
    }

    private void enterSwitch(SwitchStatement switchStatement) {
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(switchStatement);
    }

    private AstNode eqExpr() throws IOException {
        AstNode relExpr = relExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.f4679ts.tokenBeg;
            if (peekToken == 12 || peekToken == 13 || peekToken == 46 || peekToken == 47) {
                consumeToken();
                if (this.compilerEnv.getLanguageVersion() == 120) {
                    if (peekToken == 12) {
                        peekToken = 46;
                    } else if (peekToken == 13) {
                        peekToken = 47;
                    }
                }
                relExpr = new InfixExpression(peekToken, relExpr, relExpr(), i);
            } else {
                return relExpr;
            }
        }
    }

    private void exitLoop() {
        List<Loop> list = this.loopSet;
        Loop remove = list.remove(list.size() - 1);
        List<Jump> list2 = this.loopAndSwitchSet;
        list2.remove(list2.size() - 1);
        if (remove.getParent() != null) {
            remove.setRelative(remove.getParent().getPosition());
        }
        popScope();
    }

    private void exitSwitch() {
        List<Jump> list = this.loopAndSwitchSet;
        list.remove(list.size() - 1);
    }

    private AstNode expr() throws IOException {
        AstNode assignExpr = assignExpr();
        int position = assignExpr.getPosition();
        while (matchToken(90, true)) {
            int i = this.f4679ts.tokenBeg;
            if (this.compilerEnv.isStrictMode() && !assignExpr.hasSideEffects()) {
                addStrictWarning("msg.no.side.effects", "", position, nodeEnd(assignExpr) - position);
            }
            if (peekToken() == 73) {
                reportError("msg.yield.parenthesized");
            }
            assignExpr = new InfixExpression(90, assignExpr, assignExpr(), i);
        }
        return assignExpr;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004b A[Catch: all -> 0x016d, TryCatch #1 {all -> 0x016d, blocks: (B:6:0x0020, B:9:0x0029, B:11:0x0037, B:12:0x0043, B:14:0x004b, B:15:0x0052, B:17:0x0064, B:19:0x00e3, B:21:0x00eb, B:25:0x00f7, B:26:0x013d, B:28:0x0157, B:36:0x0106, B:38:0x010f, B:40:0x011c, B:43:0x0125, B:44:0x012a, B:46:0x0072, B:48:0x007c, B:50:0x0082, B:52:0x0090, B:53:0x009c, B:55:0x00a9, B:56:0x00be, B:58:0x00ce, B:60:0x00dc, B:61:0x00ba, B:63:0x003e, B:27:0x0148), top: B:5:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[Catch: all -> 0x016d, TryCatch #1 {all -> 0x016d, blocks: (B:6:0x0020, B:9:0x0029, B:11:0x0037, B:12:0x0043, B:14:0x004b, B:15:0x0052, B:17:0x0064, B:19:0x00e3, B:21:0x00eb, B:25:0x00f7, B:26:0x013d, B:28:0x0157, B:36:0x0106, B:38:0x010f, B:40:0x011c, B:43:0x0125, B:44:0x012a, B:46:0x0072, B:48:0x007c, B:50:0x0082, B:52:0x0090, B:53:0x009c, B:55:0x00a9, B:56:0x00be, B:58:0x00ce, B:60:0x00dc, B:61:0x00ba, B:63:0x003e, B:27:0x0148), top: B:5:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00eb A[Catch: all -> 0x016d, TryCatch #1 {all -> 0x016d, blocks: (B:6:0x0020, B:9:0x0029, B:11:0x0037, B:12:0x0043, B:14:0x004b, B:15:0x0052, B:17:0x0064, B:19:0x00e3, B:21:0x00eb, B:25:0x00f7, B:26:0x013d, B:28:0x0157, B:36:0x0106, B:38:0x010f, B:40:0x011c, B:43:0x0125, B:44:0x012a, B:46:0x0072, B:48:0x007c, B:50:0x0082, B:52:0x0090, B:53:0x009c, B:55:0x00a9, B:56:0x00be, B:58:0x00ce, B:60:0x00dc, B:61:0x00ba, B:63:0x003e, B:27:0x0148), top: B:5:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x015e A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010f A[Catch: all -> 0x016d, TryCatch #1 {all -> 0x016d, blocks: (B:6:0x0020, B:9:0x0029, B:11:0x0037, B:12:0x0043, B:14:0x004b, B:15:0x0052, B:17:0x0064, B:19:0x00e3, B:21:0x00eb, B:25:0x00f7, B:26:0x013d, B:28:0x0157, B:36:0x0106, B:38:0x010f, B:40:0x011c, B:43:0x0125, B:44:0x012a, B:46:0x0072, B:48:0x007c, B:50:0x0082, B:52:0x0090, B:53:0x009c, B:55:0x00a9, B:56:0x00be, B:58:0x00ce, B:60:0x00dc, B:61:0x00ba, B:63:0x003e, B:27:0x0148), top: B:5:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0123 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0072 A[Catch: all -> 0x016d, TryCatch #1 {all -> 0x016d, blocks: (B:6:0x0020, B:9:0x0029, B:11:0x0037, B:12:0x0043, B:14:0x004b, B:15:0x0052, B:17:0x0064, B:19:0x00e3, B:21:0x00eb, B:25:0x00f7, B:26:0x013d, B:28:0x0157, B:36:0x0106, B:38:0x010f, B:40:0x011c, B:43:0x0125, B:44:0x012a, B:46:0x0072, B:48:0x007c, B:50:0x0082, B:52:0x0090, B:53:0x009c, B:55:0x00a9, B:56:0x00be, B:58:0x00ce, B:60:0x00dc, B:61:0x00ba, B:63:0x003e, B:27:0x0148), top: B:5:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Loop forLoop() throws IOException {
        int i;
        boolean z;
        AstNode forLoopInit;
        AstNode expr;
        AstNode astNode;
        int i2;
        boolean z2;
        ForLoop forLoop;
        if (this.currentToken != 120) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.f4679ts;
        int i3 = tokenStream.tokenBeg;
        int i4 = tokenStream.lineno;
        AstNode astNode2 = null;
        Scope scope = new Scope();
        pushScope(scope);
        try {
            boolean z3 = false;
            if (matchToken(39, true)) {
                if ("each".equals(this.f4679ts.getString())) {
                    i = this.f4679ts.tokenBeg - i3;
                    z = true;
                    int i5 = !mustMatchToken(88, "msg.no.paren.for", true) ? this.f4679ts.tokenBeg - i3 : -1;
                    forLoopInit = forLoopInit(peekToken());
                    if (!matchToken(52, true)) {
                        i2 = this.f4679ts.tokenBeg - i3;
                        astNode = expr();
                        z3 = true;
                    } else if (this.compilerEnv.getLanguageVersion() >= 200 && matchToken(39, true) && "of".equals(this.f4679ts.getString())) {
                        i2 = this.f4679ts.tokenBeg - i3;
                        astNode = expr();
                        z2 = true;
                        int i6 = mustMatchToken(89, "msg.no.paren.for.ctrl", true) ? this.f4679ts.tokenBeg - i3 : -1;
                        if (!z3 && !z2) {
                            ForLoop forLoop2 = new ForLoop(i3);
                            forLoop2.setInitializer(forLoopInit);
                            forLoop2.setCondition(astNode);
                            forLoop2.setIncrement(astNode2);
                            forLoop = forLoop2;
                            this.currentScope.replaceWith(forLoop);
                            popScope();
                            enterLoop(forLoop);
                            AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(forLoop);
                            forLoop.setLength(getNodeEnd(nextStatementAfterInlineComments) - i3);
                            forLoop.setBody(nextStatementAfterInlineComments);
                            exitLoop();
                            forLoop.setParens(i5, i6);
                            forLoop.setLineno(i4);
                            return forLoop;
                        }
                        ForInLoop forInLoop = new ForInLoop(i3);
                        if ((forLoopInit instanceof VariableDeclaration) && ((VariableDeclaration) forLoopInit).getVariables().size() > 1) {
                            reportError("msg.mult.index");
                        }
                        if (z2 && z) {
                            reportError("msg.invalid.for.each");
                        }
                        forInLoop.setIterator(forLoopInit);
                        forInLoop.setIteratedObject(astNode);
                        forInLoop.setInPosition(i2);
                        forInLoop.setIsForEach(z);
                        forInLoop.setEachPosition(i);
                        forInLoop.setIsForOf(z2);
                        forLoop = forInLoop;
                        this.currentScope.replaceWith(forLoop);
                        popScope();
                        enterLoop(forLoop);
                        AstNode nextStatementAfterInlineComments2 = getNextStatementAfterInlineComments(forLoop);
                        forLoop.setLength(getNodeEnd(nextStatementAfterInlineComments2) - i3);
                        forLoop.setBody(nextStatementAfterInlineComments2);
                        exitLoop();
                        forLoop.setParens(i5, i6);
                        forLoop.setLineno(i4);
                        return forLoop;
                    } else {
                        mustMatchToken(83, "msg.no.semi.for", true);
                        if (peekToken() == 83) {
                            expr = new EmptyExpression(this.f4679ts.tokenBeg, 1);
                            expr.setLineno(this.f4679ts.lineno);
                        } else {
                            expr = expr();
                        }
                        AstNode astNode3 = expr;
                        mustMatchToken(83, "msg.no.semi.for.cond", true);
                        int i7 = this.f4679ts.tokenEnd;
                        if (peekToken() == 89) {
                            AstNode emptyExpression = new EmptyExpression(i7, 1);
                            emptyExpression.setLineno(this.f4679ts.lineno);
                            astNode2 = emptyExpression;
                        } else {
                            astNode2 = expr();
                        }
                        astNode = astNode3;
                        i2 = -1;
                    }
                    z2 = false;
                    if (mustMatchToken(89, "msg.no.paren.for.ctrl", true)) {
                    }
                    if (!z3) {
                        ForLoop forLoop22 = new ForLoop(i3);
                        forLoop22.setInitializer(forLoopInit);
                        forLoop22.setCondition(astNode);
                        forLoop22.setIncrement(astNode2);
                        forLoop = forLoop22;
                        this.currentScope.replaceWith(forLoop);
                        popScope();
                        enterLoop(forLoop);
                        AstNode nextStatementAfterInlineComments22 = getNextStatementAfterInlineComments(forLoop);
                        forLoop.setLength(getNodeEnd(nextStatementAfterInlineComments22) - i3);
                        forLoop.setBody(nextStatementAfterInlineComments22);
                        exitLoop();
                        forLoop.setParens(i5, i6);
                        forLoop.setLineno(i4);
                        return forLoop;
                    }
                    ForInLoop forInLoop2 = new ForInLoop(i3);
                    if (forLoopInit instanceof VariableDeclaration) {
                        reportError("msg.mult.index");
                    }
                    if (z2) {
                        reportError("msg.invalid.for.each");
                    }
                    forInLoop2.setIterator(forLoopInit);
                    forInLoop2.setIteratedObject(astNode);
                    forInLoop2.setInPosition(i2);
                    forInLoop2.setIsForEach(z);
                    forInLoop2.setEachPosition(i);
                    forInLoop2.setIsForOf(z2);
                    forLoop = forInLoop2;
                    this.currentScope.replaceWith(forLoop);
                    popScope();
                    enterLoop(forLoop);
                    AstNode nextStatementAfterInlineComments222 = getNextStatementAfterInlineComments(forLoop);
                    forLoop.setLength(getNodeEnd(nextStatementAfterInlineComments222) - i3);
                    forLoop.setBody(nextStatementAfterInlineComments222);
                    exitLoop();
                    forLoop.setParens(i5, i6);
                    forLoop.setLineno(i4);
                    return forLoop;
                }
                reportError("msg.no.paren.for");
            }
            i = -1;
            z = false;
            if (!mustMatchToken(88, "msg.no.paren.for", true)) {
            }
            forLoopInit = forLoopInit(peekToken());
            if (!matchToken(52, true)) {
            }
            z2 = false;
            if (mustMatchToken(89, "msg.no.paren.for.ctrl", true)) {
            }
            if (!z3) {
            }
            ForInLoop forInLoop22 = new ForInLoop(i3);
            if (forLoopInit instanceof VariableDeclaration) {
            }
            if (z2) {
            }
            forInLoop22.setIterator(forLoopInit);
            forInLoop22.setIteratedObject(astNode);
            forInLoop22.setInPosition(i2);
            forInLoop22.setIsForEach(z);
            forInLoop22.setEachPosition(i);
            forInLoop22.setIsForOf(z2);
            forLoop = forInLoop22;
            this.currentScope.replaceWith(forLoop);
            popScope();
            enterLoop(forLoop);
            AstNode nextStatementAfterInlineComments2222 = getNextStatementAfterInlineComments(forLoop);
            forLoop.setLength(getNodeEnd(nextStatementAfterInlineComments2222) - i3);
            forLoop.setBody(nextStatementAfterInlineComments2222);
            exitLoop();
            forLoop.setParens(i5, i6);
            forLoop.setLineno(i4);
            return forLoop;
        } finally {
            if (this.currentScope == scope) {
                popScope();
            }
        }
    }

    private AstNode forLoopInit(int i) throws IOException {
        AstNode variables;
        try {
            this.inForInit = true;
            if (i == 83) {
                variables = new EmptyExpression(this.f4679ts.tokenBeg, 1);
                variables.setLineno(this.f4679ts.lineno);
            } else {
                if (i != 123 && i != 154) {
                    variables = expr();
                    markDestructuring(variables);
                }
                consumeToken();
                variables = variables(i, this.f4679ts.tokenBeg, false);
            }
            return variables;
        } finally {
            this.inForInit = false;
        }
    }

    private FunctionNode function(int i) throws IOException {
        Name name;
        TokenStream tokenStream = this.f4679ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        AstNode astNode = null;
        if (matchToken(39, true)) {
            name = createNameNode(true, 39);
            if (this.inUseStrictDirective) {
                String identifier = name.getIdentifier();
                if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                    reportError("msg.bad.id.strict", identifier);
                }
            }
            if (!matchToken(88, true)) {
                if (this.compilerEnv.isAllowMemberExprAsFunctionName()) {
                    astNode = memberExprTail(false, name);
                    name = null;
                }
                mustMatchToken(88, "msg.no.paren.parms", true);
            }
        } else if (matchToken(88, true)) {
            name = null;
        } else {
            AstNode memberExpr = this.compilerEnv.isAllowMemberExprAsFunctionName() ? memberExpr(false) : null;
            mustMatchToken(88, "msg.no.paren.parms", true);
            astNode = memberExpr;
            name = null;
        }
        int i4 = this.currentToken == 88 ? this.f4679ts.tokenBeg : -1;
        if ((astNode != null ? 2 : i) != 2 && name != null && name.length() > 0) {
            defineSymbol(110, name.getIdentifier());
        }
        FunctionNode functionNode = new FunctionNode(i3, name);
        functionNode.setFunctionType(i);
        if (i4 != -1) {
            functionNode.setLp(i4 - i3);
        }
        functionNode.setJsDocNode(getAndResetJsDoc());
        PerFunctionVariables perFunctionVariables = new PerFunctionVariables(functionNode);
        try {
            parseFunctionParams(functionNode);
            functionNode.setBody(parseFunctionBody(i, functionNode));
            functionNode.setEncodedSourceBounds(i3, this.f4679ts.tokenEnd);
            functionNode.setLength(this.f4679ts.tokenEnd - i3);
            if (this.compilerEnv.isStrictMode() && !functionNode.getBody().hasConsistentReturnUsage()) {
                addStrictWarning((name == null || name.length() <= 0) ? "msg.anon.no.return.value" : "msg.no.return.value", name == null ? "" : name.getIdentifier());
            }
            if (astNode != null) {
                Kit.codeBug();
                functionNode.setMemberExprNode(astNode);
            }
            functionNode.setSourceName(this.sourceURI);
            functionNode.setBaseLineno(i2);
            functionNode.setEndLineno(this.f4679ts.lineno);
            if (this.compilerEnv.isIdeMode()) {
                functionNode.setParentScope(this.currentScope);
            }
            return functionNode;
        } finally {
            perFunctionVariables.restore();
        }
    }

    private AstNode generatorExpression(AstNode astNode, int i) throws IOException {
        return generatorExpression(astNode, i, false);
    }

    private AstNode generatorExpression(AstNode astNode, int i, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 120) {
            arrayList.add(generatorExpressionLoop());
        }
        int i2 = -1;
        ConditionData conditionData = null;
        if (peekToken() == 113) {
            consumeToken();
            i2 = this.f4679ts.tokenBeg - i;
            conditionData = condition();
        }
        if (!z) {
            mustMatchToken(89, "msg.no.paren.let", true);
        }
        GeneratorExpression generatorExpression = new GeneratorExpression(i, this.f4679ts.tokenEnd - i);
        generatorExpression.setResult(astNode);
        generatorExpression.setLoops(arrayList);
        if (conditionData != null) {
            generatorExpression.setIfPosition(i2);
            generatorExpression.setFilter(conditionData.condition);
            generatorExpression.setFilterLp(conditionData.f4680lp - i);
            generatorExpression.setFilterRp(conditionData.f4681rp - i);
        }
        return generatorExpression;
    }

    private GeneratorExpressionLoop generatorExpressionLoop() throws IOException {
        if (nextToken() != 120) {
            codeBug();
        }
        int i = this.f4679ts.tokenBeg;
        GeneratorExpressionLoop generatorExpressionLoop = new GeneratorExpressionLoop(i);
        pushScope(generatorExpressionLoop);
        try {
            int i2 = -1;
            int i3 = mustMatchToken(88, "msg.no.paren.for", true) ? this.f4679ts.tokenBeg - i : -1;
            AstNode astNode = null;
            int peekToken = peekToken();
            if (peekToken == 39) {
                consumeToken();
                astNode = createNameNode();
            } else if (peekToken == 84 || peekToken == 86) {
                astNode = destructuringPrimaryExpr();
                markDestructuring(astNode);
            } else {
                reportError("msg.bad.var");
            }
            if (astNode.getType() == 39) {
                defineSymbol(154, this.f4679ts.getString(), true);
            }
            int i4 = mustMatchToken(52, "msg.in.after.for.name", true) ? this.f4679ts.tokenBeg - i : -1;
            AstNode expr = expr();
            if (mustMatchToken(89, "msg.no.paren.for.ctrl", true)) {
                i2 = this.f4679ts.tokenBeg - i;
            }
            generatorExpressionLoop.setLength(this.f4679ts.tokenEnd - i);
            generatorExpressionLoop.setIterator(astNode);
            generatorExpressionLoop.setIteratedObject(expr);
            generatorExpressionLoop.setInPosition(i4);
            generatorExpressionLoop.setParens(i3, i2);
            return generatorExpressionLoop;
        } finally {
            popScope();
        }
    }

    private Comment getAndResetJsDoc() {
        Comment comment = this.currentJsDocComment;
        this.currentJsDocComment = null;
        return comment;
    }

    private String getDirective(AstNode astNode) {
        if (astNode instanceof ExpressionStatement) {
            AstNode expression = ((ExpressionStatement) astNode).getExpression();
            if (!(expression instanceof StringLiteral)) {
                return null;
            }
            return ((StringLiteral) expression).getValue();
        }
        return null;
    }

    private AstNode getNextStatementAfterInlineComments(AstNode astNode) throws IOException {
        AstNode statement = statement();
        if (162 == statement.getType()) {
            AstNode statement2 = statement();
            if (astNode != null) {
                astNode.setInlineComment(statement);
            } else {
                statement2.setInlineComment(statement);
            }
            return statement2;
        }
        return statement;
    }

    private int getNodeEnd(AstNode astNode) {
        return astNode.getLength() + astNode.getPosition();
    }

    private int getNumberOfEols(String str) {
        int i = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) == '\n') {
                i++;
            }
        }
        return i;
    }

    private IfStatement ifStatement() throws IOException {
        if (this.currentToken != 113) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.tokenBeg;
        int i2 = tokenStream.lineno;
        int i3 = -1;
        IfStatement ifStatement = new IfStatement(i);
        ConditionData condition = condition();
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(ifStatement);
        AstNode astNode = null;
        if (matchToken(114, true)) {
            if (peekToken() == 162) {
                List<Comment> list = this.scannedComments;
                ifStatement.setElseKeyWordInlineComment(list.get(list.size() - 1));
                consumeToken();
            }
            i3 = this.f4679ts.tokenBeg - i;
            astNode = statement();
        }
        ifStatement.setLength(getNodeEnd(astNode != null ? astNode : nextStatementAfterInlineComments) - i);
        ifStatement.setCondition(condition.condition);
        ifStatement.setParens(condition.f4680lp - i, condition.f4681rp - i);
        ifStatement.setThenPart(nextStatementAfterInlineComments);
        ifStatement.setElsePart(astNode);
        ifStatement.setElsePosition(i3);
        ifStatement.setLineno(i2);
        return ifStatement;
    }

    private AstNode let(boolean z, int i) throws IOException {
        LetNode letNode = new LetNode(i);
        letNode.setLineno(this.f4679ts.lineno);
        boolean z2 = true;
        if (mustMatchToken(88, "msg.no.paren.after.let", true)) {
            letNode.setLp(this.f4679ts.tokenBeg - i);
        }
        pushScope(letNode);
        try {
            letNode.setVariables(variables(154, this.f4679ts.tokenBeg, z));
            if (mustMatchToken(89, "msg.no.paren.let", true)) {
                letNode.setRp(this.f4679ts.tokenBeg - i);
            }
            if (!z || peekToken() != 86) {
                AstNode expr = expr();
                letNode.setLength(getNodeEnd(expr) - i);
                letNode.setBody(expr);
                if (z) {
                    if (insideFunction()) {
                        z2 = false;
                    }
                    ExpressionStatement expressionStatement = new ExpressionStatement(letNode, z2);
                    expressionStatement.setLineno(letNode.getLineno());
                    return expressionStatement;
                }
            } else {
                consumeToken();
                int i2 = this.f4679ts.tokenBeg;
                AstNode statements = statements();
                mustMatchToken(87, "msg.no.curly.let", true);
                statements.setLength(this.f4679ts.tokenEnd - i2);
                letNode.setLength(this.f4679ts.tokenEnd - i);
                letNode.setBody(statements);
                letNode.mo5274setType(154);
            }
            return letNode;
        } finally {
            popScope();
        }
    }

    private AstNode letStatement() throws IOException {
        if (this.currentToken != 154) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        AstNode let = peekToken() == 88 ? let(true, i2) : variables(154, i2, true);
        let.setLineno(i);
        return let;
    }

    private int lineBeginningFor(int i) {
        char[] cArr = this.sourceChars;
        if (cArr == null) {
            return -1;
        }
        if (i <= 0) {
            return 0;
        }
        if (i >= cArr.length) {
            i = cArr.length - 1;
        }
        do {
            i--;
            if (i < 0) {
                return 0;
            }
        } while (!ScriptRuntime.isJSLineTerminator(cArr[i]));
        return i + 1;
    }

    private ErrorNode makeErrorNode() {
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.tokenBeg;
        ErrorNode errorNode = new ErrorNode(i, tokenStream.tokenEnd - i);
        errorNode.setLineno(this.f4679ts.lineno);
        return errorNode;
    }

    private LabeledStatement matchJumpLabelName() throws IOException {
        LabeledStatement labeledStatement = null;
        if (peekTokenOrEOL() == 39) {
            consumeToken();
            Map<String, LabeledStatement> map = this.labelSet;
            if (map != null) {
                labeledStatement = map.get(this.f4679ts.getString());
            }
            if (labeledStatement == null) {
                reportError("msg.undef.label");
            }
        }
        return labeledStatement;
    }

    private boolean matchToken(int i, boolean z) throws IOException {
        int peekToken;
        while (true) {
            peekToken = peekToken();
            if (peekToken != 162 || !z) {
                break;
            }
            consumeToken();
        }
        if (peekToken != i) {
            return false;
        }
        consumeToken();
        return true;
    }

    private AstNode memberExpr(boolean z) throws IOException {
        AstNode astNode;
        int peekToken = peekToken();
        int i = this.f4679ts.lineno;
        if (peekToken != 30) {
            astNode = primaryExpr();
        } else {
            consumeToken();
            int i2 = this.f4679ts.tokenBeg;
            NewExpression newExpression = new NewExpression(i2);
            AstNode memberExpr = memberExpr(false);
            int nodeEnd = getNodeEnd(memberExpr);
            newExpression.setTarget(memberExpr);
            if (matchToken(88, true)) {
                int i3 = this.f4679ts.tokenBeg;
                List<AstNode> argumentList = argumentList();
                if (argumentList != null && argumentList.size() > 65536) {
                    reportError("msg.too.many.constructor.args");
                }
                TokenStream tokenStream = this.f4679ts;
                int i4 = tokenStream.tokenBeg;
                int i5 = tokenStream.tokenEnd;
                if (argumentList != null) {
                    newExpression.setArguments(argumentList);
                }
                newExpression.setParens(i3 - i2, i4 - i2);
                nodeEnd = i5;
            }
            if (matchToken(86, true)) {
                ObjectLiteral objectLiteral = objectLiteral();
                nodeEnd = getNodeEnd(objectLiteral);
                newExpression.setInitializer(objectLiteral);
            }
            newExpression.setLength(nodeEnd - i2);
            astNode = newExpression;
        }
        astNode.setLineno(i);
        return memberExprTail(z, astNode);
    }

    private AstNode memberExprTail(boolean z, AstNode astNode) throws IOException {
        int i;
        AstNode astNode2;
        if (astNode == null) {
            codeBug();
        }
        int position = astNode.getPosition();
        while (true) {
            int peekToken = peekToken();
            int i2 = -1;
            if (peekToken == 84) {
                consumeToken();
                TokenStream tokenStream = this.f4679ts;
                int i3 = tokenStream.tokenBeg;
                i = tokenStream.lineno;
                AstNode expr = expr();
                int nodeEnd = getNodeEnd(expr);
                if (mustMatchToken(85, "msg.no.bracket.index", true)) {
                    TokenStream tokenStream2 = this.f4679ts;
                    i2 = tokenStream2.tokenBeg;
                    nodeEnd = tokenStream2.tokenEnd;
                }
                ElementGet elementGet = new ElementGet(position, nodeEnd - position);
                elementGet.setTarget(astNode);
                elementGet.setElement(expr);
                elementGet.setParens(i3, i2);
                astNode2 = elementGet;
            } else if (peekToken != 88) {
                if (peekToken == 109 || peekToken == 144) {
                    int i4 = this.f4679ts.lineno;
                    astNode = propertyAccess(peekToken, astNode);
                    astNode.setLineno(i4);
                } else if (peekToken == 147) {
                    consumeToken();
                    TokenStream tokenStream3 = this.f4679ts;
                    int i5 = tokenStream3.tokenBeg;
                    i = tokenStream3.lineno;
                    mustHaveXML();
                    setRequiresActivation();
                    AstNode expr2 = expr();
                    int nodeEnd2 = getNodeEnd(expr2);
                    if (mustMatchToken(89, "msg.no.paren", true)) {
                        TokenStream tokenStream4 = this.f4679ts;
                        i2 = tokenStream4.tokenBeg;
                        nodeEnd2 = tokenStream4.tokenEnd;
                    }
                    XmlDotQuery xmlDotQuery = new XmlDotQuery(position, nodeEnd2 - position);
                    xmlDotQuery.setLeft(astNode);
                    xmlDotQuery.setRight(expr2);
                    xmlDotQuery.setOperatorPosition(i5);
                    xmlDotQuery.setRp(i2 - position);
                    astNode2 = xmlDotQuery;
                } else if (peekToken != 162) {
                    break;
                } else {
                    int i6 = this.currentFlaggedToken;
                    peekUntilNonComment(peekToken);
                    int i7 = this.currentFlaggedToken;
                    if ((i7 & 65536) != 0) {
                        i6 = i7;
                    }
                    this.currentFlaggedToken = i6;
                }
            } else if (!z) {
                break;
            } else {
                int i8 = this.f4679ts.lineno;
                consumeToken();
                checkCallRequiresActivation(astNode);
                FunctionCall functionCall = new FunctionCall(position);
                functionCall.setTarget(astNode);
                functionCall.setLineno(i8);
                functionCall.setLp(this.f4679ts.tokenBeg - position);
                List<AstNode> argumentList = argumentList();
                if (argumentList != null && argumentList.size() > 65536) {
                    reportError("msg.too.many.function.args");
                }
                functionCall.setArguments(argumentList);
                functionCall.setRp(this.f4679ts.tokenBeg - position);
                functionCall.setLength(this.f4679ts.tokenEnd - position);
                astNode = functionCall;
            }
            astNode2.setLineno(i);
            astNode = astNode2;
        }
        return astNode;
    }

    private ObjectProperty methodDefinition(int i, AstNode astNode, int i2) throws IOException {
        FunctionNode function = function(2);
        Name functionName = function.getFunctionName();
        if (functionName != null && functionName.length() != 0) {
            reportError("msg.bad.prop");
        }
        ObjectProperty objectProperty = new ObjectProperty(i);
        if (i2 == 2) {
            objectProperty.setIsGetterMethod();
            function.setFunctionIsGetterMethod();
        } else if (i2 == 4) {
            objectProperty.setIsSetterMethod();
            function.setFunctionIsSetterMethod();
        } else if (i2 == 8) {
            objectProperty.setIsNormalMethod();
            function.setFunctionIsNormalMethod();
        }
        int nodeEnd = getNodeEnd(function);
        objectProperty.setLeft(astNode);
        objectProperty.setRight(function);
        objectProperty.setLength(nodeEnd - i);
        return objectProperty;
    }

    private AstNode mulExpr() throws IOException {
        AstNode unaryExpr = unaryExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.f4679ts.tokenBeg;
            switch (peekToken) {
                case 23:
                case 24:
                case 25:
                    consumeToken();
                    unaryExpr = new InfixExpression(peekToken, unaryExpr, unaryExpr(), i);
                default:
                    return unaryExpr;
            }
        }
    }

    private void mustHaveXML() {
        if (!this.compilerEnv.isXmlAvailable()) {
            reportError("msg.XML.not.available");
        }
    }

    private boolean mustMatchToken(int i, String str, int i2, int i3, boolean z) throws IOException {
        if (matchToken(i, z)) {
            return true;
        }
        reportError(str, i2, i3);
        return false;
    }

    private boolean mustMatchToken(int i, String str, boolean z) throws IOException {
        TokenStream tokenStream = this.f4679ts;
        int i2 = tokenStream.tokenBeg;
        return mustMatchToken(i, str, i2, tokenStream.tokenEnd - i2, z);
    }

    private AstNode name(int i, int i2) throws IOException {
        String string = this.f4679ts.getString();
        TokenStream tokenStream = this.f4679ts;
        int i3 = tokenStream.tokenBeg;
        int i4 = tokenStream.lineno;
        if ((i & 131072) == 0 || peekToken() != 104) {
            saveNameTokenData(i3, string, i4);
            return this.compilerEnv.isXmlAvailable() ? propertyName(-1, string, 0) : createNameNode(true, 39);
        }
        Label label = new Label(i3, this.f4679ts.tokenEnd - i3);
        label.setName(string);
        label.setLineno(this.f4679ts.lineno);
        return label;
    }

    private AstNode nameOrLabel() throws IOException {
        AstNode astNode;
        if (this.currentToken == 39) {
            int i = this.f4679ts.tokenBeg;
            this.currentFlaggedToken |= 131072;
            AstNode expr = expr();
            if (expr.getType() != 131) {
                ExpressionStatement expressionStatement = new ExpressionStatement(expr, !insideFunction());
                expressionStatement.lineno = expr.lineno;
                return expressionStatement;
            }
            LabeledStatement labeledStatement = new LabeledStatement(i);
            recordLabel((Label) expr, labeledStatement);
            labeledStatement.setLineno(this.f4679ts.lineno);
            while (true) {
                if (peekToken() != 39) {
                    astNode = null;
                    break;
                }
                this.currentFlaggedToken |= 131072;
                AstNode expr2 = expr();
                if (expr2.getType() != 131) {
                    astNode = new ExpressionStatement(expr2, !insideFunction());
                    autoInsertSemicolon(astNode);
                    break;
                }
                recordLabel((Label) expr2, labeledStatement);
            }
            try {
                this.currentLabel = labeledStatement;
                if (astNode == null) {
                    astNode = statementHelper();
                    if (peekToken() == 162 && astNode.getLineno() == this.scannedComments.get(this.scannedComments.size() - 1).getLineno()) {
                        astNode.setInlineComment(this.scannedComments.get(this.scannedComments.size() - 1));
                        consumeToken();
                    }
                }
                labeledStatement.setLength(astNode.getParent() == null ? getNodeEnd(astNode) - i : getNodeEnd(astNode));
                labeledStatement.setStatement(astNode);
                return labeledStatement;
            } finally {
                this.currentLabel = null;
                for (Label next : labeledStatement.getLabels()) {
                    this.labelSet.remove(next.getName());
                }
            }
        }
        throw codeBug();
    }

    private int nextFlaggedToken() throws IOException {
        peekToken();
        int i = this.currentFlaggedToken;
        consumeToken();
        return i;
    }

    private int nextToken() throws IOException {
        int peekToken = peekToken();
        consumeToken();
        return peekToken;
    }

    private int nodeEnd(AstNode astNode) {
        return astNode.getLength() + astNode.getPosition();
    }

    public static final boolean nowAllSet(int i, int i2, int i3) {
        return (i & i3) != i3 && (i2 & i3) == i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d5, code lost:
        if (r5 != 8) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0111 A[LOOP:0: B:5:0x0024->B:41:0x0111, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0118 A[EDGE_INSN: B:42:0x0118->B:43:0x0118 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ObjectLiteral objectLiteral() throws IOException {
        HashSet hashSet;
        HashSet hashSet2;
        boolean z;
        String string;
        int i;
        TokenStream tokenStream = this.f4679ts;
        int i2 = tokenStream.tokenBeg;
        int i3 = tokenStream.lineno;
        ArrayList arrayList = new ArrayList();
        if (this.inUseStrictDirective) {
            hashSet = new HashSet();
            hashSet2 = new HashSet();
        } else {
            hashSet = null;
            hashSet2 = null;
        }
        Comment andResetJsDoc = getAndResetJsDoc();
        int i4 = -1;
        int i5 = -1;
        while (true) {
            int peekToken = peekToken();
            Comment andResetJsDoc2 = getAndResetJsDoc();
            if (peekToken == 162) {
                consumeToken();
                peekToken = peekUntilNonComment(peekToken);
            }
            if (peekToken == 87) {
                if (i5 != i4) {
                    warnTrailingComma(i2, arrayList, i5);
                }
                z = true;
            } else {
                AstNode objliteralProperty = objliteralProperty();
                if (objliteralProperty != null) {
                    string = this.f4679ts.getString();
                    int i6 = this.f4679ts.tokenBeg;
                    consumeToken();
                    int peekToken2 = peekToken();
                    if (peekToken2 == 90 || peekToken2 == 104 || peekToken2 == 87) {
                        objliteralProperty.setJsDocNode(andResetJsDoc2);
                        arrayList.add(plainProperty(objliteralProperty, peekToken));
                        i = 1;
                    } else {
                        if (peekToken2 == 88) {
                            i = 8;
                        } else {
                            if (objliteralProperty.getType() == 39) {
                                if ("get".equals(string)) {
                                    i = 2;
                                } else if ("set".equals(string)) {
                                    i = 4;
                                }
                            }
                            i = 1;
                        }
                        if (i == 2 || i == 4) {
                            objliteralProperty = objliteralProperty();
                            if (objliteralProperty == null) {
                                reportError("msg.bad.prop");
                            }
                            consumeToken();
                        }
                        if (objliteralProperty != null) {
                            string = this.f4679ts.getString();
                            ObjectProperty methodDefinition = methodDefinition(i6, objliteralProperty, i);
                            objliteralProperty.setJsDocNode(andResetJsDoc2);
                            arrayList.add(methodDefinition);
                        }
                    }
                    if (this.inUseStrictDirective && string != null) {
                        if (i != 1) {
                            if (i == 2) {
                                if (hashSet.contains(string)) {
                                    addError("msg.dup.obj.lit.prop.strict", string);
                                }
                                hashSet.add(string);
                            } else if (i == 4) {
                                if (hashSet2.contains(string)) {
                                    addError("msg.dup.obj.lit.prop.strict", string);
                                }
                                hashSet2.add(string);
                            }
                        }
                        if (!hashSet.contains(string) || hashSet2.contains(string)) {
                            addError("msg.dup.obj.lit.prop.strict", string);
                        }
                        hashSet.add(string);
                        hashSet2.add(string);
                    }
                    getAndResetJsDoc();
                    z = true;
                    if (matchToken(90, true)) {
                        break;
                    }
                    i5 = this.f4679ts.tokenEnd;
                    i4 = -1;
                } else {
                    reportError("msg.bad.prop");
                    i = 1;
                }
                string = null;
                if (this.inUseStrictDirective) {
                    if (i != 1) {
                    }
                    if (!hashSet.contains(string)) {
                    }
                    addError("msg.dup.obj.lit.prop.strict", string);
                    hashSet.add(string);
                    hashSet2.add(string);
                }
                getAndResetJsDoc();
                z = true;
                if (matchToken(90, true)) {
                }
            }
        }
        mustMatchToken(87, "msg.no.brace.prop", z);
        ObjectLiteral objectLiteral = new ObjectLiteral(i2, this.f4679ts.tokenEnd - i2);
        if (andResetJsDoc != null) {
            objectLiteral.setJsDocNode(andResetJsDoc);
        }
        objectLiteral.setElements(arrayList);
        objectLiteral.setLineno(i3);
        return objectLiteral;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private AstNode objliteralProperty() throws IOException {
        switch (peekToken()) {
            case 39:
                break;
            case 40:
                TokenStream tokenStream = this.f4679ts;
                return new NumberLiteral(tokenStream.tokenBeg, tokenStream.getString(), this.f4679ts.getNumber());
            case 41:
                return createStringLiteral();
            default:
                if (!this.compilerEnv.isReservedKeywordAsIdentifier() || !TokenStream.isKeyword(this.f4679ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective)) {
                    return null;
                }
                break;
        }
        return createNameNode();
    }

    private AstNode orExpr() throws IOException {
        AstNode andExpr = andExpr();
        if (matchToken(105, true)) {
            return new InfixExpression(105, andExpr, orExpr(), this.f4679ts.tokenBeg);
        }
        return andExpr;
    }

    private AstNode parenExpr() throws IOException {
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            Comment andResetJsDoc = getAndResetJsDoc();
            int i = this.f4679ts.lineno;
            int i2 = this.f4679ts.tokenBeg;
            AstNode emptyExpression = peekToken() == 89 ? new EmptyExpression(i2) : expr();
            if (peekToken() == 120) {
                return generatorExpression(emptyExpression, i2);
            }
            mustMatchToken(89, "msg.no.paren", true);
            if (emptyExpression.getType() == 129 && peekToken() != 165) {
                reportError("msg.syntax");
                return makeErrorNode();
            }
            ParenthesizedExpression parenthesizedExpression = new ParenthesizedExpression(i2, this.f4679ts.tokenEnd - i2, emptyExpression);
            parenthesizedExpression.setLineno(i);
            if (andResetJsDoc == null) {
                andResetJsDoc = getAndResetJsDoc();
            }
            if (andResetJsDoc != null) {
                parenthesizedExpression.setJsDocNode(andResetJsDoc);
            }
            return parenthesizedExpression;
        } finally {
            this.inForInit = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AstRoot parse() throws IOException {
        int i;
        List<Comment> list;
        AstNode statement;
        AstRoot astRoot = new AstRoot(0);
        this.currentScriptOrFn = astRoot;
        this.currentScope = astRoot;
        int i2 = this.f4679ts.lineno;
        boolean z = this.inUseStrictDirective;
        boolean z2 = this.defaultUseStrictDirective;
        this.inUseStrictDirective = z2;
        if (z2) {
            astRoot.setInStrictMode(true);
        }
        boolean z3 = true;
        int i3 = 0;
        while (true) {
            try {
                try {
                    int peekToken = peekToken();
                    if (peekToken <= 0) {
                        break;
                    }
                    if (peekToken == 110) {
                        consumeToken();
                        try {
                            statement = function(this.calledByCompileFunction ? 2 : 1);
                        } catch (ParserException unused) {
                        }
                    } else if (peekToken == 162) {
                        statement = this.scannedComments.get(this.scannedComments.size() - 1);
                        consumeToken();
                    } else {
                        statement = statement();
                        if (z3) {
                            String directive = getDirective(statement);
                            if (directive == null) {
                                z3 = false;
                            } else if (directive.equals("use strict")) {
                                this.inUseStrictDirective = true;
                                astRoot.setInStrictMode(true);
                            }
                        }
                    }
                    i3 = getNodeEnd(statement);
                    astRoot.addChildToBack(statement);
                    statement.setParent(astRoot);
                } catch (StackOverflowError unused2) {
                    String lookupMessage = lookupMessage("msg.too.deep.parser.recursion");
                    if (!this.compilerEnv.isIdeMode()) {
                        throw Context.reportRuntimeError(lookupMessage, this.sourceURI, this.f4679ts.lineno, null, 0);
                    }
                }
                i = this.syntaxErrorCount;
                if (i != 0) {
                    String lookupMessage2 = lookupMessage("msg.got.syntax.errors", String.valueOf(i));
                    if (!this.compilerEnv.isIdeMode()) {
                        throw this.errorReporter.runtimeError(lookupMessage2, this.sourceURI, i2, null, 0);
                    }
                }
                list = this.scannedComments;
                if (list != null) {
                    i3 = Math.max(i3, getNodeEnd(this.scannedComments.get(list.size() - 1)));
                    for (Comment comment : this.scannedComments) {
                        astRoot.addComment(comment);
                    }
                }
                astRoot.setLength(i3 - 0);
                astRoot.setSourceName(this.sourceURI);
                astRoot.setBaseLineno(i2);
                astRoot.setEndLineno(this.f4679ts.lineno);
                return astRoot;
            } finally {
                this.inUseStrictDirective = z;
            }
        }
        i = this.syntaxErrorCount;
        if (i != 0) {
        }
        list = this.scannedComments;
        if (list != null) {
        }
        astRoot.setLength(i3 - 0);
        astRoot.setSourceName(this.sourceURI);
        astRoot.setBaseLineno(i2);
        astRoot.setEndLineno(this.f4679ts.lineno);
        return astRoot;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(9:7|(1:9)(1:61)|10|11|(3:13|(1:15)|16)(2:25|(2:26|(3:30|(2:32|(2:34|(1:49)(2:36|(2:38|39)(2:41|(2:43|(2:45|46)(1:47))(1:48))))(2:50|51))(2:52|53)|40)(3:56|55|54)))|17|(1:21)|22|23)(1:6))|62|(0)(0)|10|11|(0)(0)|17|(2:19|21)|22|23|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00bd, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00be, code lost:
        r10.nestingOfFunction--;
        r10.inUseStrictDirective = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c5, code lost:
        throw r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040 A[Catch: all -> 0x00bd, ParserException -> 0x00c6, TRY_ENTER, TryCatch #2 {ParserException -> 0x00c6, all -> 0x00bd, blocks: (B:13:0x0040, B:15:0x005f, B:16:0x0066, B:26:0x006b, B:34:0x007e, B:36:0x0084, B:41:0x008c, B:43:0x0094, B:45:0x009b, B:40:0x00b9, B:50:0x009f, B:52:0x00b2), top: B:11:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AstNode parseFunctionBody(int i, FunctionNode functionNode) throws IOException {
        boolean z;
        int i2;
        Comment function;
        if (!matchToken(86, true)) {
            if (this.compilerEnv.getLanguageVersion() >= 180 || i == 4) {
                z = true;
                boolean z2 = i != 4;
                this.nestingOfFunction++;
                int i3 = this.f4679ts.tokenBeg;
                Block block = new Block(i3);
                boolean z3 = this.inUseStrictDirective;
                block.setLineno(this.f4679ts.lineno);
                if (z) {
                    boolean z4 = true;
                    while (true) {
                        int peekToken = peekToken();
                        if (peekToken == -1 || peekToken == 0 || peekToken == 87) {
                            break;
                        }
                        if (peekToken == 110) {
                            consumeToken();
                            function = function(1);
                        } else if (peekToken != 162) {
                            function = statement();
                            if (z4) {
                                String directive = getDirective(function);
                                if (directive == null) {
                                    z4 = false;
                                } else if (directive.equals("use strict")) {
                                    this.inUseStrictDirective = true;
                                    functionNode.setInStrictMode(true);
                                    if (!z3) {
                                        setRequiresActivation();
                                    }
                                }
                            }
                        } else {
                            consumeToken();
                            function = this.scannedComments.get(this.scannedComments.size() - 1);
                        }
                        block.addStatement(function);
                    }
                } else {
                    AstNode assignExpr = assignExpr();
                    ReturnStatement returnStatement = new ReturnStatement(assignExpr.getPosition(), assignExpr.getLength(), assignExpr);
                    returnStatement.putProp(25, Boolean.TRUE);
                    block.putProp(25, Boolean.TRUE);
                    if (z2) {
                        returnStatement.putProp(27, Boolean.TRUE);
                    }
                    block.addStatement(returnStatement);
                }
                this.nestingOfFunction--;
                this.inUseStrictDirective = z3;
                i2 = this.f4679ts.tokenEnd;
                getAndResetJsDoc();
                if (!z && mustMatchToken(87, "msg.no.brace.after.body", true)) {
                    i2 = this.f4679ts.tokenEnd;
                }
                block.setLength(i2 - i3);
                return block;
            }
            reportError("msg.no.brace.body");
        }
        z = false;
        if (i != 4) {
        }
        this.nestingOfFunction++;
        int i32 = this.f4679ts.tokenBeg;
        Block block2 = new Block(i32);
        boolean z32 = this.inUseStrictDirective;
        block2.setLineno(this.f4679ts.lineno);
        if (z) {
        }
        this.nestingOfFunction--;
        this.inUseStrictDirective = z32;
        i2 = this.f4679ts.tokenEnd;
        getAndResetJsDoc();
        if (!z) {
            i2 = this.f4679ts.tokenEnd;
        }
        block2.setLength(i2 - i32);
        return block2;
    }

    private void parseFunctionParams(FunctionNode functionNode) throws IOException {
        if (matchToken(89, true)) {
            functionNode.setRp(this.f4679ts.tokenBeg - functionNode.getPosition());
            return;
        }
        HashMap hashMap = null;
        HashSet hashSet = new HashSet();
        do {
            int peekToken = peekToken();
            if (peekToken == 84 || peekToken == 86) {
                AstNode destructuringPrimaryExpr = destructuringPrimaryExpr();
                markDestructuring(destructuringPrimaryExpr);
                functionNode.addParam(destructuringPrimaryExpr);
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                String nextTempName = this.currentScriptOrFn.getNextTempName();
                defineSymbol(88, nextTempName, false);
                hashMap.put(nextTempName, destructuringPrimaryExpr);
            } else if (mustMatchToken(39, "msg.no.parm", true)) {
                AstNode createNameNode = createNameNode();
                Comment andResetJsDoc = getAndResetJsDoc();
                if (andResetJsDoc != null) {
                    createNameNode.setJsDocNode(andResetJsDoc);
                }
                functionNode.addParam(createNameNode);
                String string = this.f4679ts.getString();
                defineSymbol(88, string);
                if (this.inUseStrictDirective) {
                    if ("eval".equals(string) || "arguments".equals(string)) {
                        reportError("msg.bad.id.strict", string);
                    }
                    if (hashSet.contains(string)) {
                        addError("msg.dup.param.strict", string);
                    }
                    hashSet.add(string);
                }
            } else {
                functionNode.addParam(makeErrorNode());
            }
        } while (matchToken(90, true));
        if (hashMap != null) {
            Node node = new Node(90);
            for (Map.Entry entry : hashMap.entrySet()) {
                node.addChildToBack(createDestructuringAssignment(123, (Node) entry.getValue(), createName((String) entry.getKey())));
            }
            functionNode.putProp(23, node);
        }
        if (!mustMatchToken(89, "msg.no.paren.after.parms", true)) {
            return;
        }
        functionNode.setRp(this.f4679ts.tokenBeg - functionNode.getPosition());
    }

    private int peekFlaggedToken() throws IOException {
        peekToken();
        return this.currentFlaggedToken;
    }

    private int peekToken() throws IOException {
        if (this.currentFlaggedToken != 0) {
            return this.currentToken;
        }
        int lineno = this.f4679ts.getLineno();
        int token = this.f4679ts.getToken();
        int i = 0;
        boolean z = false;
        while (true) {
            if (token != 1 && token != 162) {
                break;
            } else if (token == 1) {
                lineno++;
                token = this.f4679ts.getToken();
                z = true;
            } else if (this.compilerEnv.isRecordingComments()) {
                String andResetCurrentComment = this.f4679ts.getAndResetCurrentComment();
                recordComment(lineno, andResetCurrentComment);
                getNumberOfEols(andResetCurrentComment);
                break;
            } else {
                token = this.f4679ts.getToken();
            }
        }
        this.currentToken = token;
        if (z) {
            i = 65536;
        }
        this.currentFlaggedToken = token | i;
        return this.currentToken;
    }

    private int peekTokenOrEOL() throws IOException {
        int peekToken = peekToken();
        if ((this.currentFlaggedToken & 65536) != 0) {
            return 1;
        }
        return peekToken;
    }

    private int peekUntilNonComment(int i) throws IOException {
        while (i == 162) {
            consumeToken();
            i = peekToken();
        }
        return i;
    }

    private ObjectProperty plainProperty(AstNode astNode, int i) throws IOException {
        int peekToken = peekToken();
        if ((peekToken != 90 && peekToken != 87) || i != 39 || this.compilerEnv.getLanguageVersion() < 180) {
            mustMatchToken(104, "msg.no.colon.prop", true);
            ObjectProperty objectProperty = new ObjectProperty();
            objectProperty.setOperatorPosition(this.f4679ts.tokenBeg);
            objectProperty.setLeftAndRight(astNode, assignExpr());
            return objectProperty;
        }
        if (!this.inDestructuringAssignment) {
            reportError("msg.bad.object.init");
        }
        Name name = new Name(astNode.getPosition(), astNode.getString());
        ObjectProperty objectProperty2 = new ObjectProperty();
        objectProperty2.putProp(26, Boolean.TRUE);
        objectProperty2.setLeftAndRight(astNode, name);
        return objectProperty2;
    }

    private AstNode primaryExpr() throws IOException {
        String str;
        int peekFlaggedToken = peekFlaggedToken();
        int i = 65535 & peekFlaggedToken;
        if (i != -1) {
            if (i != 0) {
                if (i != 24) {
                    if (i == 84) {
                        consumeToken();
                        return arrayLiteral();
                    } else if (i == 86) {
                        consumeToken();
                        return objectLiteral();
                    } else if (i == 88) {
                        consumeToken();
                        return parenExpr();
                    } else if (i != 101) {
                        if (i == 110) {
                            consumeToken();
                            return function(2);
                        } else if (i == 128) {
                            consumeToken();
                            reportError("msg.reserved.id", this.f4679ts.getString());
                        } else if (i == 148) {
                            consumeToken();
                            mustHaveXML();
                            return attributeAccess();
                        } else {
                            consumeToken();
                            if (i == 154) {
                                return let(false, this.f4679ts.tokenBeg);
                            }
                            switch (i) {
                                case 39:
                                    return name(peekFlaggedToken, i);
                                case 40:
                                    String string = this.f4679ts.getString();
                                    if (this.inUseStrictDirective && this.f4679ts.isNumberOldOctal()) {
                                        reportError("msg.no.old.octal.strict");
                                    }
                                    if (this.f4679ts.isNumberBinary()) {
                                        string = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("0b", string);
                                    }
                                    if (this.f4679ts.isNumberOldOctal()) {
                                        string = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("0", string);
                                    }
                                    if (this.f4679ts.isNumberOctal()) {
                                        string = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("0o", string);
                                    }
                                    if (this.f4679ts.isNumberHex()) {
                                        string = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("0x", string);
                                    }
                                    TokenStream tokenStream = this.f4679ts;
                                    return new NumberLiteral(tokenStream.tokenBeg, string, tokenStream.getNumber());
                                case 41:
                                    return createStringLiteral();
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                    TokenStream tokenStream2 = this.f4679ts;
                                    int i2 = tokenStream2.tokenBeg;
                                    return new KeywordLiteral(i2, tokenStream2.tokenEnd - i2, i);
                                default:
                                    str = "msg.syntax";
                                    break;
                            }
                        }
                    }
                }
                consumeToken();
                this.f4679ts.readRegExp(i);
                TokenStream tokenStream3 = this.f4679ts;
                int i3 = tokenStream3.tokenBeg;
                RegExpLiteral regExpLiteral = new RegExpLiteral(i3, tokenStream3.tokenEnd - i3);
                regExpLiteral.setValue(this.f4679ts.getString());
                regExpLiteral.setFlags(this.f4679ts.readAndClearRegExpFlags());
                return regExpLiteral;
            }
            consumeToken();
            str = "msg.unexpected.eof";
            reportError(str);
        } else {
            consumeToken();
        }
        consumeToken();
        return makeErrorNode();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AstNode propertyAccess(int i, AstNode astNode) throws IOException {
        int i2;
        int i3;
        String str;
        AstNode propertyName;
        boolean z;
        InfixExpression xmlMemberGet;
        String string;
        if (astNode == null) {
            codeBug();
        }
        int i4 = 0;
        TokenStream tokenStream = this.f4679ts;
        int i5 = tokenStream.lineno;
        int i6 = tokenStream.tokenBeg;
        consumeToken();
        if (i == 144) {
            mustHaveXML();
            i4 = 4;
        }
        if (!this.compilerEnv.isXmlAvailable()) {
            if (nextToken() != 39 && (!this.compilerEnv.isReservedKeywordAsIdentifier() || !TokenStream.isKeyword(this.f4679ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective))) {
                reportError("msg.no.name.after.dot");
            }
            PropertyGet propertyGet = new PropertyGet(astNode, createNameNode(true, 33), i6);
            propertyGet.setLineno(i5);
            return propertyGet;
        }
        int nextToken = nextToken();
        if (nextToken != 23) {
            if (nextToken == 39) {
                string = this.f4679ts.getString();
            } else if (nextToken != 50) {
                if (nextToken == 128) {
                    string = this.f4679ts.getString();
                } else if (nextToken == 148) {
                    propertyName = attributeAccess();
                    z = propertyName instanceof XmlRef;
                    xmlMemberGet = z ? new XmlMemberGet() : new PropertyGet();
                    if (z && i == 109) {
                        xmlMemberGet.mo5274setType(109);
                    }
                    int position = astNode.getPosition();
                    xmlMemberGet.setPosition(position);
                    xmlMemberGet.setLength(getNodeEnd(propertyName) - position);
                    xmlMemberGet.setOperatorPosition(i6 - position);
                    xmlMemberGet.setLineno(astNode.getLineno());
                    xmlMemberGet.setLeft(astNode);
                    xmlMemberGet.setRight(propertyName);
                    return xmlMemberGet;
                } else if (!this.compilerEnv.isReservedKeywordAsIdentifier() || (string = Token.keywordToName(nextToken)) == null) {
                    reportError("msg.no.name.after.dot");
                    return makeErrorNode();
                }
                TokenStream tokenStream2 = this.f4679ts;
                saveNameTokenData(tokenStream2.tokenBeg, string, tokenStream2.lineno);
            } else {
                TokenStream tokenStream3 = this.f4679ts;
                i2 = tokenStream3.tokenBeg;
                i3 = tokenStream3.lineno;
                str = "throw";
            }
            propertyName = propertyName(-1, string, i4);
            z = propertyName instanceof XmlRef;
            if (z) {
            }
            if (z) {
                xmlMemberGet.mo5274setType(109);
            }
            int position2 = astNode.getPosition();
            xmlMemberGet.setPosition(position2);
            xmlMemberGet.setLength(getNodeEnd(propertyName) - position2);
            xmlMemberGet.setOperatorPosition(i6 - position2);
            xmlMemberGet.setLineno(astNode.getLineno());
            xmlMemberGet.setLeft(astNode);
            xmlMemberGet.setRight(propertyName);
            return xmlMemberGet;
        }
        TokenStream tokenStream4 = this.f4679ts;
        i2 = tokenStream4.tokenBeg;
        i3 = tokenStream4.lineno;
        str = "*";
        saveNameTokenData(i2, str, i3);
        propertyName = propertyName(-1, str, i4);
        z = propertyName instanceof XmlRef;
        if (z) {
        }
        if (z) {
        }
        int position22 = astNode.getPosition();
        xmlMemberGet.setPosition(position22);
        xmlMemberGet.setLength(getNodeEnd(propertyName) - position22);
        xmlMemberGet.setOperatorPosition(i6 - position22);
        xmlMemberGet.setLineno(astNode.getLineno());
        xmlMemberGet.setLeft(astNode);
        xmlMemberGet.setRight(propertyName);
        return xmlMemberGet;
    }

    private AstNode propertyName(int i, String str, int i2) throws IOException {
        int i3;
        Name name;
        int i4 = i != -1 ? i : this.f4679ts.tokenBeg;
        int i5 = this.f4679ts.lineno;
        Name createNameNode = createNameNode(true, this.currentToken);
        if (matchToken(145, true)) {
            i3 = this.f4679ts.tokenBeg;
            int nextToken = nextToken();
            if (nextToken == 23) {
                TokenStream tokenStream = this.f4679ts;
                saveNameTokenData(tokenStream.tokenBeg, "*", tokenStream.lineno);
                name = createNameNode(false, -1);
            } else if (nextToken != 39) {
                if (nextToken == 84) {
                    return xmlElemRef(i, createNameNode, i3);
                }
                reportError("msg.no.name.after.coloncolon");
                return makeErrorNode();
            } else {
                name = createNameNode();
            }
        } else {
            i3 = -1;
            name = createNameNode;
            createNameNode = null;
        }
        if (createNameNode == null && i2 == 0 && i == -1) {
            return name;
        }
        XmlPropRef xmlPropRef = new XmlPropRef(i4, getNodeEnd(name) - i4);
        xmlPropRef.setAtPos(i);
        xmlPropRef.setNamespace(createNameNode);
        xmlPropRef.setColonPos(i3);
        xmlPropRef.setPropName(name);
        xmlPropRef.setLineno(i5);
        return xmlPropRef;
    }

    private String readFully(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            char[] cArr = new char[1024];
            StringBuilder sb = new StringBuilder(1024);
            while (true) {
                int read = bufferedReader.read(cArr, 0, 1024);
                if (read == -1) {
                    String sb2 = sb.toString();
                    bufferedReader.close();
                    return sb2;
                }
                sb.append(cArr, 0, read);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedReader.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void recordComment(int i, String str) {
        if (this.scannedComments == null) {
            this.scannedComments = new ArrayList();
        }
        TokenStream tokenStream = this.f4679ts;
        Comment comment = new Comment(tokenStream.tokenBeg, tokenStream.getTokenLength(), this.f4679ts.commentType, str);
        if (this.f4679ts.commentType == Token.CommentType.JSDOC && this.compilerEnv.isRecordingLocalJsDocComments()) {
            TokenStream tokenStream2 = this.f4679ts;
            Comment comment2 = new Comment(tokenStream2.tokenBeg, tokenStream2.getTokenLength(), this.f4679ts.commentType, str);
            this.currentJsDocComment = comment2;
            comment2.setLineno(i);
        }
        comment.setLineno(i);
        this.scannedComments.add(comment);
    }

    private void recordLabel(Label label, LabeledStatement labeledStatement) throws IOException {
        if (peekToken() != 104) {
            codeBug();
        }
        consumeToken();
        String name = label.getName();
        Map<String, LabeledStatement> map = this.labelSet;
        if (map == null) {
            this.labelSet = new HashMap();
        } else {
            LabeledStatement labeledStatement2 = map.get(name);
            if (labeledStatement2 != null) {
                if (this.compilerEnv.isIdeMode()) {
                    Label labelByName = labeledStatement2.getLabelByName(name);
                    reportError("msg.dup.label", labelByName.getAbsolutePosition(), labelByName.getLength());
                }
                reportError("msg.dup.label", label.getPosition(), label.getLength());
            }
        }
        labeledStatement.addLabel(label);
        this.labelSet.put(name, labeledStatement);
    }

    private AstNode relExpr() throws IOException {
        AstNode shiftExpr = shiftExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.f4679ts.tokenBeg;
            if (peekToken != 52) {
                if (peekToken != 53) {
                    switch (peekToken) {
                    }
                } else {
                    continue;
                }
                consumeToken();
                shiftExpr = new InfixExpression(peekToken, shiftExpr, shiftExpr(), i);
            } else if (!this.inForInit) {
                consumeToken();
                shiftExpr = new InfixExpression(peekToken, shiftExpr, shiftExpr(), i);
            }
        }
        return shiftExpr;
    }

    private AstNode returnOrYield(int i, boolean z) throws IOException {
        AstNode yield;
        int i2 = 4;
        if (!insideFunction()) {
            reportError(i == 4 ? "msg.bad.return" : "msg.bad.yield");
        }
        consumeToken();
        TokenStream tokenStream = this.f4679ts;
        int i3 = tokenStream.lineno;
        int i4 = tokenStream.tokenBeg;
        int i5 = tokenStream.tokenEnd;
        AstNode astNode = null;
        int peekTokenOrEOL = peekTokenOrEOL();
        if (peekTokenOrEOL != -1 && peekTokenOrEOL != 0 && peekTokenOrEOL != 1 && peekTokenOrEOL != 73 && peekTokenOrEOL != 83 && peekTokenOrEOL != 85 && peekTokenOrEOL != 87 && peekTokenOrEOL != 89) {
            astNode = expr();
            i5 = getNodeEnd(astNode);
        }
        int i6 = this.endFlags;
        if (i == 4) {
            if (astNode == null) {
                i2 = 2;
            }
            this.endFlags = i6 | i2;
            int i7 = i5 - i4;
            yield = new ReturnStatement(i4, i7, astNode);
            if (nowAllSet(i6, this.endFlags, 6)) {
                addStrictWarning("msg.return.inconsistent", "", i4, i7);
            }
        } else {
            if (!insideFunction()) {
                reportError("msg.bad.yield");
            }
            this.endFlags |= 8;
            yield = new Yield(i4, i5 - i4, astNode);
            setRequiresActivation();
            setIsGenerator();
            if (!z) {
                yield = new ExpressionStatement(yield);
            }
        }
        if (insideFunction() && nowAllSet(i6, this.endFlags, 12)) {
            Name functionName = ((FunctionNode) this.currentScriptOrFn).getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                addError("msg.anon.generator.returns", "");
            } else {
                addError("msg.generator.returns", functionName.getIdentifier());
            }
        }
        yield.setLineno(i3);
        return yield;
    }

    private void saveNameTokenData(int i, String str, int i2) {
        this.prevNameTokenStart = i;
        this.prevNameTokenString = str;
        this.prevNameTokenLineno = i2;
    }

    private AstNode shiftExpr() throws IOException {
        AstNode addExpr = addExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.f4679ts.tokenBeg;
            switch (peekToken) {
                case 18:
                case 19:
                case 20:
                    consumeToken();
                    addExpr = new InfixExpression(peekToken, addExpr, addExpr(), i);
                default:
                    return addExpr;
            }
        }
    }

    private AstNode statement() throws IOException {
        int peekTokenOrEOL;
        int i = this.f4679ts.tokenBeg;
        try {
            AstNode statementHelper = statementHelper();
            if (statementHelper != null) {
                if (this.compilerEnv.isStrictMode() && !statementHelper.hasSideEffects()) {
                    int position = statementHelper.getPosition();
                    int max = Math.max(position, lineBeginningFor(position));
                    addStrictWarning(statementHelper instanceof EmptyStatement ? "msg.extra.trailing.semi" : "msg.no.side.effects", "", max, nodeEnd(statementHelper) - max);
                }
                if (peekToken() == 162 && statementHelper.getLineno() == this.scannedComments.get(this.scannedComments.size() - 1).getLineno()) {
                    statementHelper.setInlineComment(this.scannedComments.get(this.scannedComments.size() - 1));
                    consumeToken();
                }
                return statementHelper;
            }
        } catch (ParserException unused) {
        }
        do {
            peekTokenOrEOL = peekTokenOrEOL();
            consumeToken();
            if (peekTokenOrEOL == -1 || peekTokenOrEOL == 0 || peekTokenOrEOL == 1) {
                break;
            }
        } while (peekTokenOrEOL != 83);
        return new EmptyStatement(i, this.f4679ts.tokenBeg - i);
    }

    private AstNode statementHelper() throws IOException {
        AstNode returnOrYield;
        int i;
        AstNode keywordLiteral;
        int i2;
        LabeledStatement labeledStatement = this.currentLabel;
        if (labeledStatement != null && labeledStatement.getStatement() != null) {
            this.currentLabel = null;
        }
        int peekToken = peekToken();
        TokenStream tokenStream = this.f4679ts;
        int i3 = tokenStream.tokenBeg;
        if (peekToken == -1) {
            consumeToken();
            return makeErrorNode();
        }
        if (peekToken != 4) {
            if (peekToken == 39) {
                returnOrYield = nameOrLabel();
                if (!(returnOrYield instanceof ExpressionStatement)) {
                    return returnOrYield;
                }
            } else if (peekToken == 50) {
                returnOrYield = throwStatement();
            } else if (peekToken != 73) {
                if (peekToken == 86) {
                    return block();
                }
                if (peekToken == 110) {
                    consumeToken();
                    return function(3);
                } else if (peekToken == 113) {
                    return ifStatement();
                } else {
                    if (peekToken == 115) {
                        return switchStatement();
                    }
                    if (peekToken == 82) {
                        return tryStatement();
                    }
                    if (peekToken == 83) {
                        consumeToken();
                        int i4 = this.f4679ts.tokenBeg;
                        EmptyStatement emptyStatement = new EmptyStatement(i4, this.f4679ts.tokenEnd - i4);
                        emptyStatement.setLineno(this.f4679ts.lineno);
                        return emptyStatement;
                    } else if (peekToken != 154) {
                        if (peekToken != 155) {
                            if (peekToken == 161) {
                                consumeToken();
                                TokenStream tokenStream2 = this.f4679ts;
                                int i5 = tokenStream2.tokenBeg;
                                keywordLiteral = new KeywordLiteral(i5, tokenStream2.tokenEnd - i5, peekToken);
                                i2 = this.f4679ts.lineno;
                            } else if (peekToken == 162) {
                                List<Comment> list = this.scannedComments;
                                return list.get(list.size() - 1);
                            } else {
                                switch (peekToken) {
                                    case 117:
                                        returnOrYield = defaultXmlNamespace();
                                        break;
                                    case 118:
                                        return whileLoop();
                                    case 119:
                                        return doLoop();
                                    case 120:
                                        return forLoop();
                                    case 121:
                                        returnOrYield = breakStatement();
                                        break;
                                    case 122:
                                        returnOrYield = continueStatement();
                                        break;
                                    case 123:
                                        break;
                                    case 124:
                                        if (this.inUseStrictDirective) {
                                            reportError("msg.no.with.strict");
                                        }
                                        return withStatement();
                                    default:
                                        i2 = tokenStream.lineno;
                                        keywordLiteral = new ExpressionStatement(expr(), true ^ insideFunction());
                                        break;
                                }
                            }
                            AstNode astNode = keywordLiteral;
                            i = i2;
                            returnOrYield = astNode;
                            returnOrYield.setLineno(i);
                        }
                        consumeToken();
                        TokenStream tokenStream3 = this.f4679ts;
                        i = tokenStream3.lineno;
                        returnOrYield = variables(this.currentToken, tokenStream3.tokenBeg, true);
                        returnOrYield.setLineno(i);
                    } else {
                        returnOrYield = letStatement();
                        if (!(returnOrYield instanceof VariableDeclaration) || peekToken() != 83) {
                            return returnOrYield;
                        }
                    }
                }
            }
            autoInsertSemicolon(returnOrYield);
            return returnOrYield;
        }
        returnOrYield = returnOrYield(peekToken, false);
        autoInsertSemicolon(returnOrYield);
        return returnOrYield;
    }

    private AstNode statements() throws IOException {
        return statements(null);
    }

    private AstNode statements(AstNode astNode) throws IOException {
        if (this.currentToken != 86 && !this.compilerEnv.isIdeMode()) {
            codeBug();
        }
        int i = this.f4679ts.tokenBeg;
        if (astNode == null) {
            astNode = new Block(i);
        }
        astNode.setLineno(this.f4679ts.lineno);
        while (true) {
            int peekToken = peekToken();
            if (peekToken <= 0 || peekToken == 87) {
                break;
            }
            astNode.addChild(statement());
        }
        astNode.setLength(this.f4679ts.tokenBeg - i);
        return astNode;
    }

    private SwitchStatement switchStatement() throws IOException {
        if (this.currentToken != 115) {
            codeBug();
        }
        consumeToken();
        int i = this.f4679ts.tokenBeg;
        SwitchStatement switchStatement = new SwitchStatement(i);
        if (mustMatchToken(88, "msg.no.paren.switch", true)) {
            switchStatement.setLp(this.f4679ts.tokenBeg - i);
        }
        switchStatement.setLineno(this.f4679ts.lineno);
        switchStatement.setExpression(expr());
        enterSwitch(switchStatement);
        try {
            if (mustMatchToken(89, "msg.no.paren.after.switch", true)) {
                switchStatement.setRp(this.f4679ts.tokenBeg - i);
            }
            mustMatchToken(86, "msg.no.brace.switch", true);
            boolean z = false;
            while (true) {
                int nextToken = nextToken();
                int i2 = this.f4679ts.tokenBeg;
                int i3 = this.f4679ts.lineno;
                AstNode astNode = null;
                if (nextToken == 87) {
                    switchStatement.setLength(this.f4679ts.tokenEnd - i);
                    break;
                } else if (nextToken != 162) {
                    if (nextToken == 116) {
                        astNode = expr();
                        mustMatchToken(104, "msg.no.colon.case", true);
                    } else if (nextToken != 117) {
                        reportError("msg.bad.switch");
                        break;
                    } else {
                        if (z) {
                            reportError("msg.double.switch.default");
                        }
                        mustMatchToken(104, "msg.no.colon.case", true);
                        z = true;
                    }
                    SwitchCase switchCase = new SwitchCase(i2);
                    switchCase.setExpression(astNode);
                    switchCase.setLength(this.f4679ts.tokenEnd - i);
                    switchCase.setLineno(i3);
                    while (true) {
                        int peekToken = peekToken();
                        if (peekToken == 87 || peekToken == 116 || peekToken == 117 || peekToken == 0) {
                            break;
                        } else if (peekToken == 162) {
                            Comment comment = this.scannedComments.get(this.scannedComments.size() - 1);
                            if (switchCase.getInlineComment() == null && comment.getLineno() == switchCase.getLineno()) {
                                switchCase.setInlineComment(comment);
                            } else {
                                switchCase.addStatement(comment);
                            }
                            consumeToken();
                        } else {
                            switchCase.addStatement(statement());
                        }
                    }
                    switchStatement.addCase(switchCase);
                } else {
                    switchStatement.addChild(this.scannedComments.get(this.scannedComments.size() - 1));
                }
            }
            return switchStatement;
        } finally {
            exitSwitch();
        }
    }

    private ThrowStatement throwStatement() throws IOException {
        if (this.currentToken != 50) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.tokenBeg;
        int i2 = tokenStream.lineno;
        if (peekTokenOrEOL() == 1) {
            reportError("msg.bad.throw.eol");
        }
        ThrowStatement throwStatement = new ThrowStatement(i, expr());
        throwStatement.setLineno(i2);
        return throwStatement;
    }

    private TryStatement tryStatement() throws IOException {
        Comment comment;
        int i;
        boolean z;
        ArrayList arrayList;
        int i2;
        AstNode astNode;
        int i3;
        AstNode astNode2;
        boolean z2;
        if (this.currentToken != 82) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        TokenStream tokenStream = this.f4679ts;
        int i4 = tokenStream.tokenBeg;
        int i5 = tokenStream.lineno;
        TryStatement tryStatement = new TryStatement(i4);
        int peekToken = peekToken();
        if (peekToken == 162) {
            List<Comment> list = this.scannedComments;
            tryStatement.setInlineComment(list.get(list.size() - 1));
            consumeToken();
            peekToken = peekToken();
        }
        if (peekToken != 86) {
            reportError("msg.no.brace.try");
        }
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(tryStatement);
        int nodeEnd = getNodeEnd(nextStatementAfterInlineComments);
        boolean z3 = false;
        int peekToken2 = peekToken();
        int i6 = 125;
        if (peekToken2 == 125) {
            arrayList = null;
            for (boolean z4 = true; matchToken(i6, z4); z4 = true) {
                int i7 = this.f4679ts.lineno;
                if (z3) {
                    reportError("msg.catch.unreachable");
                }
                int i8 = this.f4679ts.tokenBeg;
                int i9 = mustMatchToken(88, "msg.no.paren.catch", z4) ? this.f4679ts.tokenBeg : -1;
                mustMatchToken(39, "msg.bad.catchcond", z4);
                Name createNameNode = createNameNode();
                Comment andResetJsDoc2 = getAndResetJsDoc();
                if (andResetJsDoc2 != null) {
                    createNameNode.setJsDocNode(andResetJsDoc2);
                }
                String identifier = createNameNode.getIdentifier();
                if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                    reportError("msg.bad.id.strict", identifier);
                }
                if (matchToken(113, z4)) {
                    i3 = this.f4679ts.tokenBeg;
                    astNode2 = expr();
                    z2 = z3;
                } else {
                    i3 = -1;
                    astNode2 = null;
                    z2 = true;
                }
                int i10 = mustMatchToken(89, "msg.bad.catchcond", z4) ? this.f4679ts.tokenBeg : -1;
                Comment comment2 = andResetJsDoc;
                mustMatchToken(86, "msg.no.brace.catchblock", z4);
                Block block = (Block) statements();
                int nodeEnd2 = getNodeEnd(block);
                CatchClause catchClause = new CatchClause(i8);
                catchClause.setVarName(createNameNode);
                catchClause.setCatchCondition(astNode2);
                catchClause.setBody(block);
                if (i3 != -1) {
                    catchClause.setIfPosition(i3 - i8);
                }
                catchClause.setParens(i9, i10);
                catchClause.setLineno(i7);
                nodeEnd = mustMatchToken(87, "msg.no.brace.after.body", true) ? this.f4679ts.tokenEnd : nodeEnd2;
                catchClause.setLength(nodeEnd - i8);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(catchClause);
                i6 = 125;
                z3 = z2;
                andResetJsDoc = comment2;
            }
            comment = andResetJsDoc;
            i = 126;
            z = true;
        } else {
            comment = andResetJsDoc;
            i = 126;
            if (peekToken2 != 126) {
                z = true;
                mustMatchToken(126, "msg.try.no.catchfinally", true);
            } else {
                z = true;
            }
            arrayList = null;
        }
        if (matchToken(i, z)) {
            i2 = this.f4679ts.tokenBeg;
            AstNode statement = statement();
            astNode = statement;
            nodeEnd = getNodeEnd(statement);
        } else {
            i2 = -1;
            astNode = null;
        }
        tryStatement.setLength(nodeEnd - i4);
        tryStatement.setTryBlock(nextStatementAfterInlineComments);
        tryStatement.setCatchClauses(arrayList);
        tryStatement.setFinallyBlock(astNode);
        if (i2 != -1) {
            tryStatement.setFinallyPosition(i2 - i4);
        }
        tryStatement.setLineno(i5);
        if (comment != null) {
            tryStatement.setJsDocNode(comment);
        }
        return tryStatement;
    }

    private AstNode unaryExpr() throws IOException {
        int peekToken = peekToken();
        if (peekToken == 162) {
            consumeToken();
            peekToken = peekUntilNonComment(peekToken);
        }
        int i = this.f4679ts.lineno;
        if (peekToken == -1) {
            consumeToken();
            return makeErrorNode();
        }
        if (peekToken != 14) {
            if (peekToken != 127) {
                if (peekToken == 21) {
                    consumeToken();
                    UnaryExpression unaryExpression = new UnaryExpression(28, this.f4679ts.tokenBeg, unaryExpr());
                    unaryExpression.setLineno(i);
                    return unaryExpression;
                } else if (peekToken == 22) {
                    consumeToken();
                    UnaryExpression unaryExpression2 = new UnaryExpression(29, this.f4679ts.tokenBeg, unaryExpr());
                    unaryExpression2.setLineno(i);
                    return unaryExpression2;
                } else if (peekToken != 26 && peekToken != 27) {
                    if (peekToken == 31) {
                        consumeToken();
                        UnaryExpression unaryExpression3 = new UnaryExpression(peekToken, this.f4679ts.tokenBeg, unaryExpr());
                        unaryExpression3.setLineno(i);
                        return unaryExpression3;
                    } else if (peekToken != 32) {
                        if (peekToken == 107 || peekToken == 108) {
                            consumeToken();
                            UnaryExpression unaryExpression4 = new UnaryExpression(peekToken, this.f4679ts.tokenBeg, memberExpr(true));
                            unaryExpression4.setLineno(i);
                            checkBadIncDec(unaryExpression4);
                            return unaryExpression4;
                        }
                    }
                }
            }
            consumeToken();
            UnaryExpression unaryExpression5 = new UnaryExpression(peekToken, this.f4679ts.tokenBeg, unaryExpr());
            unaryExpression5.setLineno(i);
            return unaryExpression5;
        } else if (this.compilerEnv.isXmlAvailable()) {
            consumeToken();
            return memberExprTail(true, xmlInitializer());
        }
        AstNode memberExpr = memberExpr(true);
        int peekTokenOrEOL = peekTokenOrEOL();
        if (peekTokenOrEOL != 107 && peekTokenOrEOL != 108) {
            return memberExpr;
        }
        consumeToken();
        UnaryExpression unaryExpression6 = new UnaryExpression(peekTokenOrEOL, this.f4679ts.tokenBeg, memberExpr, true);
        unaryExpression6.setLineno(i);
        checkBadIncDec(unaryExpression6);
        return unaryExpression6;
    }

    private VariableDeclaration variables(int i, int i2, boolean z) throws IOException {
        AstNode destructuringPrimaryExpr;
        int i3;
        Name name;
        VariableDeclaration variableDeclaration = new VariableDeclaration(i2);
        variableDeclaration.mo5274setType(i);
        variableDeclaration.setLineno(this.f4679ts.lineno);
        Comment andResetJsDoc = getAndResetJsDoc();
        if (andResetJsDoc != null) {
            variableDeclaration.setJsDocNode(andResetJsDoc);
        }
        do {
            int peekToken = peekToken();
            TokenStream tokenStream = this.f4679ts;
            int i4 = tokenStream.tokenBeg;
            int i5 = tokenStream.tokenEnd;
            AstNode astNode = null;
            if (peekToken == 84 || peekToken == 86) {
                destructuringPrimaryExpr = destructuringPrimaryExpr();
                int nodeEnd = getNodeEnd(destructuringPrimaryExpr);
                if (!(destructuringPrimaryExpr instanceof DestructuringForm)) {
                    reportError("msg.bad.assign.left", i4, nodeEnd - i4);
                }
                markDestructuring(destructuringPrimaryExpr);
                i3 = nodeEnd;
                name = null;
            } else {
                mustMatchToken(39, "msg.bad.var", true);
                Name createNameNode = createNameNode();
                createNameNode.setLineno(this.f4679ts.getLineno());
                if (this.inUseStrictDirective) {
                    String string = this.f4679ts.getString();
                    if ("eval".equals(string) || "arguments".equals(this.f4679ts.getString())) {
                        reportError("msg.bad.id.strict", string);
                    }
                }
                defineSymbol(i, this.f4679ts.getString(), this.inForInit);
                i3 = i5;
                name = createNameNode;
                destructuringPrimaryExpr = null;
            }
            int i6 = this.f4679ts.lineno;
            Comment andResetJsDoc2 = getAndResetJsDoc();
            if (matchToken(91, true)) {
                astNode = assignExpr();
                i3 = getNodeEnd(astNode);
            }
            VariableInitializer variableInitializer = new VariableInitializer(i4, i3 - i4);
            if (destructuringPrimaryExpr != null) {
                if (astNode == null && !this.inForInit) {
                    reportError("msg.destruct.assign.no.init");
                }
                variableInitializer.setTarget(destructuringPrimaryExpr);
            } else {
                variableInitializer.setTarget(name);
            }
            variableInitializer.setInitializer(astNode);
            variableInitializer.mo5274setType(i);
            variableInitializer.setJsDocNode(andResetJsDoc2);
            variableInitializer.setLineno(i6);
            variableDeclaration.addVariable(variableInitializer);
        } while (matchToken(90, true));
        variableDeclaration.setLength(i3 - i2);
        variableDeclaration.setIsStatement(z);
        return variableDeclaration;
    }

    private void warnMissingSemi(int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            int[] iArr = new int[2];
            String line = this.f4679ts.getLine(i2, iArr);
            if (this.compilerEnv.isIdeMode()) {
                i = Math.max(i, i2 - iArr[1]);
            }
            int i3 = i;
            if (line != null) {
                addStrictWarning("msg.missing.semi", "", i3, i2 - i3, iArr[0], line, iArr[1]);
            } else {
                addStrictWarning("msg.missing.semi", "", i3, i2 - i3);
            }
        }
    }

    private void warnTrailingComma(int i, List<?> list, int i2) {
        if (this.compilerEnv.getWarnTrailingComma()) {
            if (!list.isEmpty()) {
                i = ((AstNode) list.get(0)).getPosition();
            }
            int max = Math.max(i, lineBeginningFor(i2));
            addWarning("msg.extra.trailing.comma", max, i2 - max);
        }
    }

    private WhileLoop whileLoop() throws IOException {
        if (this.currentToken != 118) {
            codeBug();
        }
        consumeToken();
        int i = this.f4679ts.tokenBeg;
        WhileLoop whileLoop = new WhileLoop(i);
        whileLoop.setLineno(this.f4679ts.lineno);
        enterLoop(whileLoop);
        try {
            ConditionData condition = condition();
            whileLoop.setCondition(condition.condition);
            whileLoop.setParens(condition.f4680lp - i, condition.f4681rp - i);
            AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(whileLoop);
            whileLoop.setLength(getNodeEnd(nextStatementAfterInlineComments) - i);
            whileLoop.setBody(nextStatementAfterInlineComments);
            return whileLoop;
        } finally {
            exitLoop();
        }
    }

    private WithStatement withStatement() throws IOException {
        if (this.currentToken != 124) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        int i3 = -1;
        int i4 = mustMatchToken(88, "msg.no.paren.with", true) ? this.f4679ts.tokenBeg : -1;
        AstNode expr = expr();
        if (mustMatchToken(89, "msg.no.paren.after.with", true)) {
            i3 = this.f4679ts.tokenBeg;
        }
        WithStatement withStatement = new WithStatement(i2);
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(withStatement);
        withStatement.setLength(getNodeEnd(nextStatementAfterInlineComments) - i2);
        withStatement.setJsDocNode(andResetJsDoc);
        withStatement.setExpression(expr);
        withStatement.setStatement(nextStatementAfterInlineComments);
        withStatement.setParens(i4, i3);
        withStatement.setLineno(i);
        return withStatement;
    }

    private XmlElemRef xmlElemRef(int i, Name name, int i2) throws IOException {
        int i3 = this.f4679ts.tokenBeg;
        int i4 = -1;
        int i5 = i != -1 ? i : i3;
        AstNode expr = expr();
        int nodeEnd = getNodeEnd(expr);
        if (mustMatchToken(85, "msg.no.bracket.index", true)) {
            TokenStream tokenStream = this.f4679ts;
            int i6 = tokenStream.tokenBeg;
            nodeEnd = tokenStream.tokenEnd;
            i4 = i6;
        }
        XmlElemRef xmlElemRef = new XmlElemRef(i5, nodeEnd - i5);
        xmlElemRef.setNamespace(name);
        xmlElemRef.setColonPos(i2);
        xmlElemRef.setAtPos(i);
        xmlElemRef.setExpression(expr);
        xmlElemRef.setBrackets(i3, i4);
        return xmlElemRef;
    }

    private AstNode xmlInitializer() throws IOException {
        if (this.currentToken != 14) {
            codeBug();
        }
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.tokenBeg;
        int firstXMLToken = tokenStream.getFirstXMLToken();
        if (firstXMLToken == 146 || firstXMLToken == 149) {
            XmlLiteral xmlLiteral = new XmlLiteral(i);
            xmlLiteral.setLineno(this.f4679ts.lineno);
            while (firstXMLToken == 146) {
                TokenStream tokenStream2 = this.f4679ts;
                xmlLiteral.addFragment(new XmlString(tokenStream2.tokenBeg, tokenStream2.getString()));
                mustMatchToken(86, "msg.syntax", true);
                int i2 = this.f4679ts.tokenBeg;
                AstNode emptyExpression = peekToken() == 87 ? new EmptyExpression(i2, this.f4679ts.tokenEnd - i2) : expr();
                mustMatchToken(87, "msg.syntax", true);
                XmlExpression xmlExpression = new XmlExpression(i2, emptyExpression);
                xmlExpression.setIsXmlAttribute(this.f4679ts.isXMLAttribute());
                xmlExpression.setLength(this.f4679ts.tokenEnd - i2);
                xmlLiteral.addFragment(xmlExpression);
                firstXMLToken = this.f4679ts.getNextXMLToken();
            }
            if (firstXMLToken == 149) {
                TokenStream tokenStream3 = this.f4679ts;
                xmlLiteral.addFragment(new XmlString(tokenStream3.tokenBeg, tokenStream3.getString()));
                return xmlLiteral;
            }
        }
        reportError("msg.syntax");
        return makeErrorNode();
    }

    public void addError(String str) {
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.tokenBeg;
        addError(str, i, tokenStream.tokenEnd - i);
    }

    public void addError(String str, int i) {
        String ch = Character.toString((char) i);
        TokenStream tokenStream = this.f4679ts;
        int i2 = tokenStream.tokenBeg;
        addError(str, ch, i2, tokenStream.tokenEnd - i2);
    }

    public void addError(String str, int i, int i2) {
        addError(str, null, i, i2);
    }

    public void addError(String str, String str2) {
        TokenStream tokenStream = this.f4679ts;
        int i = tokenStream.tokenBeg;
        addError(str, str2, i, tokenStream.tokenEnd - i);
    }

    public void addError(String str, String str2, int i, int i2) {
        String str3;
        int i3;
        int i4;
        this.syntaxErrorCount++;
        String lookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(lookupMessage, this.sourceURI, i, i2);
            return;
        }
        TokenStream tokenStream = this.f4679ts;
        if (tokenStream != null) {
            int lineno = tokenStream.getLineno();
            str3 = this.f4679ts.getLine();
            i4 = this.f4679ts.getOffset();
            i3 = lineno;
        } else {
            str3 = "";
            i3 = 1;
            i4 = 1;
        }
        this.errorReporter.error(lookupMessage, this.sourceURI, i3, str3, i4);
    }

    public void addStrictWarning(String str, String str2) {
        int i;
        TokenStream tokenStream = this.f4679ts;
        int i2 = -1;
        if (tokenStream != null) {
            i2 = tokenStream.tokenBeg;
            i = tokenStream.tokenEnd - i2;
        } else {
            i = -1;
        }
        addStrictWarning(str, str2, i2, i);
    }

    public void addStrictWarning(String str, String str2, int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i, i2);
        }
    }

    public void addWarning(String str, int i, int i2) {
        addWarning(str, null, i, i2);
    }

    public void addWarning(String str, String str2) {
        int i;
        TokenStream tokenStream = this.f4679ts;
        int i2 = -1;
        if (tokenStream != null) {
            i2 = tokenStream.tokenBeg;
            i = tokenStream.tokenEnd - i2;
        } else {
            i = -1;
        }
        addWarning(str, str2, i2, i);
    }

    public void addWarning(String str, String str2, int i, int i2) {
        String lookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i, i2);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(lookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.warning(lookupMessage, this.sourceURI, this.f4679ts.getLineno(), this.f4679ts.getLine(), this.f4679ts.getOffset());
        }
    }

    public void checkActivationName(String str, int i) {
        if (!insideFunction()) {
            return;
        }
        boolean z = false;
        if (("arguments".equals(str) && ((FunctionNode) this.currentScriptOrFn).getFunctionType() != 4) || ((this.compilerEnv.getActivationNames() != null && this.compilerEnv.getActivationNames().contains(str)) || (org.simpleframework.xml.strategy.Name.LENGTH.equals(str) && i == 33 && this.compilerEnv.getLanguageVersion() == 120))) {
            z = true;
        }
        if (!z) {
            return;
        }
        setRequiresActivation();
    }

    public void checkMutableReference(Node node) {
        if ((node.getIntProp(16, 0) & 4) != 0) {
            reportError("msg.bad.assign.left");
        }
    }

    public Node createDestructuringAssignment(int i, Node node, Node node2) {
        String nextTempName = this.currentScriptOrFn.getNextTempName();
        Node destructuringAssignmentHelper = destructuringAssignmentHelper(i, node, node2, nextTempName);
        destructuringAssignmentHelper.getLastChild().addChildToBack(createName(nextTempName));
        return destructuringAssignmentHelper;
    }

    public Node createName(int i, String str, Node node) {
        Node createName = createName(str);
        createName.mo5274setType(i);
        if (node != null) {
            createName.addChildToBack(node);
        }
        return createName;
    }

    public Node createName(String str) {
        checkActivationName(str, 39);
        return Node.newString(39, str);
    }

    public Node createNumber(double d) {
        return Node.newNumber(d);
    }

    public Scope createScopeNode(int i, int i2) {
        Scope scope = new Scope();
        scope.mo5274setType(i);
        scope.setLineno(i2);
        return scope;
    }

    public void defineSymbol(int i, String str) {
        defineSymbol(i, str, false);
    }

    public void defineSymbol(int i, String str, boolean z) {
        if (str == null) {
            if (this.compilerEnv.isIdeMode()) {
                return;
            }
            codeBug();
        }
        Scope definingScope = this.currentScope.getDefiningScope(str);
        org.mozilla.javascript.ast.Symbol symbol = definingScope != null ? definingScope.getSymbol(str) : null;
        int declType = symbol != null ? symbol.getDeclType() : -1;
        String str2 = "msg.var.redecl";
        if (symbol != null && (declType == 155 || i == 155 || (definingScope == this.currentScope && declType == 154))) {
            if (declType == 155) {
                str2 = "msg.const.redecl";
            } else if (declType == 154) {
                str2 = "msg.let.redecl";
            } else if (declType != 123) {
                str2 = declType == 110 ? "msg.fn.redecl" : "msg.parm.redecl";
            }
            addError(str2, str);
        } else if (i == 88) {
            if (symbol != null) {
                addWarning("msg.dup.parms", str);
            }
            this.currentScriptOrFn.putSymbol(new org.mozilla.javascript.ast.Symbol(i, str));
        } else {
            if (i != 110 && i != 123) {
                if (i == 154) {
                    if (z || (this.currentScope.getType() != 113 && !(this.currentScope instanceof Loop))) {
                        this.currentScope.putSymbol(new org.mozilla.javascript.ast.Symbol(i, str));
                        return;
                    } else {
                        addError("msg.let.decl.not.in.block");
                        return;
                    }
                } else if (i != 155) {
                    throw codeBug();
                }
            }
            if (symbol == null) {
                this.currentScriptOrFn.putSymbol(new org.mozilla.javascript.ast.Symbol(i, str));
            } else if (declType == 123) {
                addStrictWarning(str2, str);
            } else if (declType != 88) {
            } else {
                addStrictWarning("msg.var.hides.arg", str);
            }
        }
    }

    public boolean destructuringArray(ArrayLiteral arrayLiteral, int i, String str, Node node, List<String> list) {
        int i2 = i == 155 ? 156 : 8;
        boolean z = true;
        int i3 = 0;
        for (AstNode astNode : arrayLiteral.getElements()) {
            if (astNode.getType() == 129) {
                i3++;
            } else {
                Node node2 = new Node(36, createName(str), createNumber(i3));
                if (astNode.getType() == 39) {
                    String string = astNode.getString();
                    node.addChildToBack(new Node(i2, createName(49, string, null), node2));
                    if (i != -1) {
                        defineSymbol(i, string, true);
                        list.add(string);
                    }
                } else {
                    node.addChildToBack(destructuringAssignmentHelper(i, astNode, node2, this.currentScriptOrFn.getNextTempName()));
                }
                i3++;
                z = false;
            }
        }
        return z;
    }

    public Node destructuringAssignmentHelper(int i, Node node, Node node2, String str) {
        Scope createScopeNode = createScopeNode(Token.LETEXPR, node.getLineno());
        createScopeNode.addChildToFront(new Node(154, createName(39, str, node2)));
        try {
            pushScope(createScopeNode);
            boolean z = true;
            defineSymbol(154, str, true);
            popScope();
            Node node3 = new Node(90);
            createScopeNode.addChildToBack(node3);
            List<String> arrayList = new ArrayList<>();
            int type = node.getType();
            if (type == 33 || type == 36) {
                if (i == 123 || i == 154 || i == 155) {
                    reportError("msg.bad.assign.left");
                }
                node3.addChildToBack(simpleAssignment(node, createName(str)));
            } else if (type == 66) {
                z = destructuringArray((ArrayLiteral) node, i, str, node3, arrayList);
            } else if (type != 67) {
                reportError("msg.bad.assign.left");
            } else {
                z = destructuringObject((ObjectLiteral) node, i, str, node3, arrayList);
            }
            if (z) {
                node3.addChildToBack(createNumber(RoundRectDrawableWithShadow.COS_45));
            }
            createScopeNode.putProp(22, arrayList);
            return createScopeNode;
        } catch (Throwable th) {
            popScope();
            throw th;
        }
    }

    public boolean destructuringObject(ObjectLiteral objectLiteral, int i, String str, Node node, List<String> list) {
        Node node2;
        int i2 = i == 155 ? 156 : 8;
        boolean z = true;
        for (ObjectProperty objectProperty : objectLiteral.getElements()) {
            TokenStream tokenStream = this.f4679ts;
            int i3 = tokenStream != null ? tokenStream.lineno : 0;
            AstNode left = objectProperty.getLeft();
            if (left instanceof Name) {
                node2 = new Node(33, createName(str), Node.newString(((Name) left).getIdentifier()));
            } else if (left instanceof StringLiteral) {
                node2 = new Node(33, createName(str), Node.newString(((StringLiteral) left).getValue()));
            } else if (!(left instanceof NumberLiteral)) {
                throw codeBug();
            } else {
                node2 = new Node(36, createName(str), createNumber((int) ((NumberLiteral) left).getNumber()));
            }
            node2.setLineno(i3);
            AstNode right = objectProperty.getRight();
            if (right.getType() == 39) {
                String identifier = ((Name) right).getIdentifier();
                node.addChildToBack(new Node(i2, createName(49, identifier, null), node2));
                if (i != -1) {
                    defineSymbol(i, identifier, true);
                    list.add(identifier);
                }
            } else {
                node.addChildToBack(destructuringAssignmentHelper(i, right, node2, this.currentScriptOrFn.getNextTempName()));
            }
            z = false;
        }
        return z;
    }

    public boolean eof() {
        return this.f4679ts.eof();
    }

    public boolean inUseStrictDirective() {
        return this.inUseStrictDirective;
    }

    public boolean insideFunction() {
        return this.nestingOfFunction != 0;
    }

    public String lookupMessage(String str) {
        return lookupMessage(str, null);
    }

    public String lookupMessage(String str, String str2) {
        return str2 == null ? ScriptRuntime.getMessage0(str) : ScriptRuntime.getMessage1(str, str2);
    }

    public void markDestructuring(AstNode astNode) {
        if (astNode instanceof DestructuringForm) {
            ((DestructuringForm) astNode).setIsDestructuring(true);
        } else if (!(astNode instanceof ParenthesizedExpression)) {
        } else {
            markDestructuring(((ParenthesizedExpression) astNode).getExpression());
        }
    }

    public AstRoot parse(Reader reader, String str, int i) throws IOException {
        if (!this.parseFinished) {
            if (this.compilerEnv.isIdeMode()) {
                return parse(readFully(reader), str, i);
            }
            try {
                this.sourceURI = str;
                this.f4679ts = new TokenStream(this, reader, null, i);
                return parse();
            } finally {
                this.parseFinished = true;
            }
        }
        throw new IllegalStateException("parser reused");
    }

    public AstRoot parse(String str, String str2, int i) {
        if (!this.parseFinished) {
            this.sourceURI = str2;
            if (this.compilerEnv.isIdeMode()) {
                this.sourceChars = str.toCharArray();
            }
            this.f4679ts = new TokenStream(this, null, str, i);
            try {
                try {
                    return parse();
                } catch (IOException unused) {
                    throw new IllegalStateException();
                }
            } finally {
                this.parseFinished = true;
            }
        }
        throw new IllegalStateException("parser reused");
    }

    public void popScope() {
        this.currentScope = this.currentScope.getParentScope();
    }

    public void pushScope(Scope scope) {
        Scope parentScope = scope.getParentScope();
        if (parentScope == null) {
            this.currentScope.addChildScope(scope);
        } else if (parentScope != this.currentScope) {
            codeBug();
        }
        this.currentScope = scope;
    }

    public AstNode removeParens(AstNode astNode) {
        while (astNode instanceof ParenthesizedExpression) {
            astNode = ((ParenthesizedExpression) astNode).getExpression();
        }
        return astNode;
    }

    public void reportError(String str) {
        reportError(str, null);
    }

    public void reportError(String str, int i, int i2) {
        reportError(str, null, i, i2);
    }

    public void reportError(String str, String str2) {
        TokenStream tokenStream = this.f4679ts;
        if (tokenStream == null) {
            reportError(str, str2, 1, 1);
            return;
        }
        int i = tokenStream.tokenBeg;
        reportError(str, str2, i, tokenStream.tokenEnd - i);
    }

    public void reportError(String str, String str2, int i, int i2) {
        addError(str, str2, i, i2);
        if (this.compilerEnv.recoverFromErrors()) {
            return;
        }
        throw new ParserException();
    }

    public void setDefaultUseStrictDirective(boolean z) {
        this.defaultUseStrictDirective = z;
    }

    public void setIsGenerator() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setIsGenerator();
        }
    }

    public void setRequiresActivation() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setRequiresActivation();
        }
    }

    public Node simpleAssignment(Node node, Node node2) {
        Node firstChild;
        Node lastChild;
        int i;
        int type = node.getType();
        if (type != 33 && type != 36) {
            if (type != 39) {
                if (type != 68) {
                    throw codeBug();
                }
                Node firstChild2 = node.getFirstChild();
                checkMutableReference(firstChild2);
                return new Node(69, firstChild2, node2);
            }
            String identifier = ((Name) node).getIdentifier();
            if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                reportError("msg.bad.id.strict", identifier);
            }
            node.mo5274setType(49);
            return new Node(8, node, node2);
        }
        if (node instanceof PropertyGet) {
            PropertyGet propertyGet = (PropertyGet) node;
            firstChild = propertyGet.getTarget();
            lastChild = propertyGet.getProperty();
        } else if (node instanceof ElementGet) {
            ElementGet elementGet = (ElementGet) node;
            firstChild = elementGet.getTarget();
            lastChild = elementGet.getElement();
        } else {
            firstChild = node.getFirstChild();
            lastChild = node.getLastChild();
        }
        if (type == 33) {
            i = 35;
            lastChild.mo5274setType(41);
        } else {
            i = 37;
        }
        return new Node(i, firstChild, lastChild, node2);
    }
}

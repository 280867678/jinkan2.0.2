package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;

/* loaded from: classes5.dex */
public class NodeTransformer {
    public boolean hasFinally;
    public ObjArray loopEnds;
    public ObjArray loops;

    public static Node addBeforeCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
            node.addChildToFront(node4);
        } else {
            if (node3 != node2.getNext()) {
                Kit.codeBug();
            }
            node.addChildAfter(node4, node2);
        }
        return node4;
    }

    public static Node replaceCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
        } else if (node2.next == node3) {
            node.replaceChildAfter(node2, node4);
            return node4;
        }
        node.replaceChild(node3, node4);
        return node4;
    }

    private void transformCompilationUnit(ScriptNode scriptNode, boolean z) {
        this.loops = new ObjArray();
        this.loopEnds = new ObjArray();
        this.hasFinally = false;
        boolean z2 = scriptNode.getType() != 110 || ((FunctionNode) scriptNode).requiresActivation();
        scriptNode.flattenSymbolTable(!z2);
        transformCompilationUnit_r(scriptNode, scriptNode, scriptNode, z2, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0169  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v7, types: [org.mozilla.javascript.ast.Scope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void transformCompilationUnit_r(ScriptNode scriptNode, Node node, Scope scope, boolean z, boolean z2) {
        Node node2;
        Node next;
        Node node3;
        Scope scope2;
        Node node4;
        ScriptNode scriptNode2;
        NodeTransformer nodeTransformer;
        int i;
        Jump jump;
        Node firstChild;
        Scope definingScope;
        int i2;
        Node node5;
        Node firstChild2;
        ?? r10 = 0;
        Node node6 = null;
        while (true) {
            if (node6 == null) {
                next = node.getFirstChild();
                node2 = r10;
            } else {
                node2 = node6;
                next = node6.getNext();
            }
            if (next == null) {
                return;
            }
            int type = next.getType();
            if (z && ((type == 130 || type == 133 || type == 158) && (next instanceof Scope))) {
                ?? r13 = (Scope) next;
                if (r13.getSymbolTable() != null) {
                    Node node7 = new Node(type == 158 ? Token.LETEXPR : 154);
                    Node node8 = new Node(154);
                    node7.addChildToBack(node8);
                    for (String str : r13.getSymbolTable().keySet()) {
                        node8.addChildToBack(Node.newString(39, str));
                    }
                    r13.setSymbolTable(r10);
                    Node replaceCurrent = replaceCurrent(node, node2, next, node7);
                    int type2 = replaceCurrent.getType();
                    node7.addChildToBack(next);
                    next = replaceCurrent;
                    type = type2;
                }
            }
            if (type != 3) {
                boolean z3 = false;
                if (type != 4) {
                    if (type != 7) {
                        if (type != 8) {
                            if (type == 38) {
                                visitCall(next, scriptNode);
                            } else if (type != 39) {
                                if (type != 73) {
                                    if (type != 82) {
                                        if (type != 115) {
                                            if (type != 138) {
                                                if (type != 159) {
                                                    switch (type) {
                                                        case 30:
                                                            visitNew(next, scriptNode);
                                                            break;
                                                        case 31:
                                                            break;
                                                        case 32:
                                                            break;
                                                        default:
                                                            switch (type) {
                                                                case 121:
                                                                case 122:
                                                                    Jump jump2 = (Jump) next;
                                                                    Jump jumpStatement = jump2.getJumpStatement();
                                                                    if (jumpStatement == null) {
                                                                        Kit.codeBug();
                                                                    }
                                                                    int size = this.loops.size();
                                                                    while (size != 0) {
                                                                        size--;
                                                                        Node node9 = (Node) this.loops.get(size);
                                                                        if (node9 == jumpStatement) {
                                                                            jump2.target = type == 121 ? jumpStatement.target : jumpStatement.getContinue();
                                                                            jump2.mo5274setType(5);
                                                                            break;
                                                                        } else {
                                                                            int type3 = node9.getType();
                                                                            if (type3 == 124) {
                                                                                node2 = addBeforeCurrent(node, node2, next, new Node(3));
                                                                            } else if (type3 == 82) {
                                                                                Jump jump3 = new Jump(Token.JSR);
                                                                                jump3.target = ((Jump) node9).getFinally();
                                                                                node2 = addBeforeCurrent(node, node2, next, jump3);
                                                                            }
                                                                        }
                                                                    }
                                                                    throw Kit.codeBug();
                                                                case 123:
                                                                    Node node10 = new Node(130);
                                                                    firstChild2 = next.getFirstChild();
                                                                    while (firstChild2 != null) {
                                                                        Node next2 = firstChild2.getNext();
                                                                        if (firstChild2.getType() == 39) {
                                                                            if (!firstChild2.hasChildren()) {
                                                                                firstChild2 = next2;
                                                                            } else {
                                                                                Node firstChild3 = firstChild2.getFirstChild();
                                                                                firstChild2.removeChild(firstChild3);
                                                                                firstChild2.mo5274setType(49);
                                                                                firstChild2 = new Node(type == 155 ? 156 : 8, firstChild2, firstChild3);
                                                                            }
                                                                        } else if (firstChild2.getType() != 159) {
                                                                            throw Kit.codeBug();
                                                                        }
                                                                        node10.addChildToBack(new Node((int) Token.EXPR_VOID, firstChild2, next.getLineno()));
                                                                        firstChild2 = next2;
                                                                    }
                                                                    next = replaceCurrent(node, node2, next, node10);
                                                                    break;
                                                                case 124:
                                                                    this.loops.push(next);
                                                                    node5 = next.getNext();
                                                                    if (node5.getType() != 3) {
                                                                        Kit.codeBug();
                                                                    }
                                                                    this.loopEnds.push(node5);
                                                                    break;
                                                                default:
                                                                    switch (type) {
                                                                        case Token.LABEL /* 131 */:
                                                                        case Token.LOOP /* 133 */:
                                                                            break;
                                                                        case Token.TARGET /* 132 */:
                                                                            break;
                                                                        default:
                                                                            switch (type) {
                                                                            }
                                                                    }
                                                            }
                                                    }
                                                }
                                                if (next.getFirstChild().getType() == 154) {
                                                    next = visitLet(scriptNode.getType() != 110 || ((FunctionNode) scriptNode).requiresActivation(), node, node2, next);
                                                }
                                                Node node102 = new Node(130);
                                                firstChild2 = next.getFirstChild();
                                                while (firstChild2 != null) {
                                                }
                                                next = replaceCurrent(node, node2, next, node102);
                                            } else {
                                                Scope definingScope2 = scope.getDefiningScope(next.getString());
                                                if (definingScope2 != null) {
                                                    next.setScope(definingScope2);
                                                }
                                            }
                                        }
                                        this.loops.push(next);
                                        this.loopEnds.push(((Jump) next).target);
                                    } else {
                                        node5 = ((Jump) next).getFinally();
                                        if (node5 != null) {
                                            this.hasFinally = true;
                                            this.loops.push(next);
                                            this.loopEnds.push(node5);
                                        }
                                    }
                                    node6 = node3;
                                    r10 = 0;
                                } else {
                                    ((FunctionNode) scriptNode).addResumptionPoint(next);
                                }
                            }
                        } else if (z2) {
                            next.mo5274setType(74);
                        }
                        if (!z) {
                            if (type == 39) {
                                firstChild = next;
                            } else {
                                firstChild = next.getFirstChild();
                                if (firstChild.getType() != 49) {
                                    if (type != 31) {
                                        throw Kit.codeBug();
                                    }
                                }
                            }
                            if (firstChild.getScope() == null && (definingScope = scope.getDefiningScope(firstChild.getString())) != null) {
                                firstChild.setScope(definingScope);
                                if (type == 39) {
                                    next.mo5274setType(55);
                                } else {
                                    if (type == 8 || type == 74) {
                                        i2 = 56;
                                    } else if (type == 156) {
                                        i2 = 157;
                                    } else if (type != 31) {
                                        throw Kit.codeBug();
                                    } else {
                                        next = replaceCurrent(node, node2, next, new Node(44));
                                    }
                                    next.mo5274setType(i2);
                                    firstChild.mo5274setType(41);
                                }
                            }
                        }
                    }
                    Node firstChild4 = next.getFirstChild();
                    if (type == 7) {
                        while (firstChild4.getType() == 26) {
                            firstChild4 = firstChild4.getFirstChild();
                        }
                        if (firstChild4.getType() == 12 || firstChild4.getType() == 13) {
                            Node firstChild5 = firstChild4.getFirstChild();
                            Node lastChild = firstChild4.getLastChild();
                            if (firstChild5.getType() == 39 && firstChild5.getString().equals("undefined")) {
                                firstChild4 = lastChild;
                            } else if (lastChild.getType() == 39 && lastChild.getString().equals("undefined")) {
                                firstChild4 = firstChild5;
                            }
                        }
                    }
                    if (firstChild4.getType() == 33) {
                        firstChild4.mo5274setType(34);
                    }
                } else {
                    if (scriptNode.getType() == 110 && ((FunctionNode) scriptNode).isGenerator()) {
                        z3 = true;
                    }
                    if (z3) {
                        i = 1;
                        next.putIntProp(20, 1);
                    } else {
                        i = 1;
                    }
                    if (this.hasFinally) {
                        int size2 = this.loops.size() - i;
                        Node node11 = null;
                        while (size2 >= 0) {
                            Node node12 = (Node) this.loops.get(size2);
                            int type4 = node12.getType();
                            if (type4 == 82 || type4 == 124) {
                                if (type4 == 82) {
                                    Jump jump4 = new Jump(Token.JSR);
                                    jump4.target = ((Jump) node12).getFinally();
                                    jump = jump4;
                                } else {
                                    jump = new Node(3);
                                }
                                node11 = node11 == null ? new Node(130, next.getLineno()) : node11;
                                node11.addChildToBack(jump);
                            }
                            size2--;
                            node11 = node11;
                        }
                        if (node11 != null) {
                            Node firstChild6 = next.getFirstChild();
                            node3 = replaceCurrent(node, node2, next, node11);
                            if (firstChild6 == null || z3) {
                                node11.addChildToBack(next);
                                node6 = node3;
                                r10 = 0;
                            } else {
                                Node node13 = new Node((int) Token.EXPR_RESULT, firstChild6);
                                node11.addChildToFront(node13);
                                node11.addChildToBack(new Node(65));
                                nodeTransformer = this;
                                scriptNode2 = scriptNode;
                                node4 = node13;
                                scope2 = scope;
                                nodeTransformer.transformCompilationUnit_r(scriptNode2, node4, scope2, z, z2);
                                node6 = node3;
                                r10 = 0;
                            }
                        }
                    }
                }
                node3 = next;
                scope2 = !(node3 instanceof Scope) ? (Scope) node3 : scope;
                nodeTransformer = this;
                scriptNode2 = scriptNode;
                node4 = node3;
                nodeTransformer.transformCompilationUnit_r(scriptNode2, node4, scope2, z, z2);
                node6 = node3;
                r10 = 0;
            }
            if (!this.loopEnds.isEmpty() && this.loopEnds.peek() == next) {
                this.loopEnds.pop();
                this.loops.pop();
            }
            node3 = next;
            if (!(node3 instanceof Scope)) {
            }
            nodeTransformer = this;
            scriptNode2 = scriptNode;
            node4 = node3;
            nodeTransformer.transformCompilationUnit_r(scriptNode2, node4, scope2, z, z2);
            node6 = node3;
            r10 = 0;
        }
    }

    public final void transform(ScriptNode scriptNode, CompilerEnvirons compilerEnvirons) {
        transform(scriptNode, false, compilerEnvirons);
    }

    public final void transform(ScriptNode scriptNode, boolean z, CompilerEnvirons compilerEnvirons) {
        if (compilerEnvirons.getLanguageVersion() >= 200 && scriptNode.isInStrictMode()) {
            z = true;
        }
        transformCompilationUnit(scriptNode, z);
        for (int i = 0; i != scriptNode.getFunctionCount(); i++) {
            transform(scriptNode.getFunctionNode(i), z, compilerEnvirons);
        }
    }

    public void visitCall(Node node, ScriptNode scriptNode) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b2, code lost:
        if ((r4 instanceof org.mozilla.javascript.ast.Scope) != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01ca, code lost:
        r4 = (org.mozilla.javascript.ast.Scope) r4;
        r1 = r4.getParentScope();
        r2 = (org.mozilla.javascript.ast.Scope) r21;
        r4.setParentScope(r2);
        r2.setParentScope(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c8, code lost:
        if ((r4 instanceof org.mozilla.javascript.ast.Scope) != false) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Node visitLet(boolean z, Node node, Node node2, Node node3) {
        Node replaceCurrent;
        Node node4;
        Node node5;
        Node node6;
        Node node7;
        Node firstChild = node3.getFirstChild();
        Node next = firstChild.getNext();
        node3.removeChild(firstChild);
        node3.removeChild(next);
        int type = node3.getType();
        int i = Token.LETEXPR;
        boolean z2 = type == 159;
        int i2 = 154;
        int i3 = 90;
        if (z) {
            replaceCurrent = replaceCurrent(node, node2, node3, new Node(z2 ? 160 : 130));
            ArrayList arrayList = new ArrayList();
            Node node8 = new Node(67);
            Node firstChild2 = firstChild.getFirstChild();
            while (firstChild2 != null) {
                if (firstChild2.getType() == i) {
                    List list = (List) firstChild2.getProp(22);
                    Node firstChild3 = firstChild2.getFirstChild();
                    if (firstChild3.getType() != i2) {
                        throw Kit.codeBug();
                    }
                    node6 = z2 ? new Node(i3, firstChild3.getNext(), next) : new Node(130, new Node((int) Token.EXPR_VOID, firstChild3.getNext()), next);
                    if (list != null) {
                        arrayList.addAll(list);
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            node8.addChildToBack(new Node(127, Node.newNumber(RoundRectDrawableWithShadow.COS_45)));
                        }
                    }
                    node7 = firstChild3.getFirstChild();
                } else {
                    node6 = next;
                    node7 = firstChild2;
                }
                if (node7.getType() != 39) {
                    throw Kit.codeBug();
                }
                arrayList.add(ScriptRuntime.getIndexObject(node7.getString()));
                Node firstChild4 = node7.getFirstChild();
                if (firstChild4 == null) {
                    firstChild4 = new Node(127, Node.newNumber(RoundRectDrawableWithShadow.COS_45));
                }
                node8.addChildToBack(firstChild4);
                firstChild2 = firstChild2.getNext();
                next = node6;
                i = Token.LETEXPR;
                i2 = 154;
                i3 = 90;
            }
            node8.putProp(12, arrayList.toArray());
            replaceCurrent.addChildToBack(new Node(2, node8));
            replaceCurrent.addChildToBack(new Node(124, next));
            replaceCurrent.addChildToBack(new Node(3));
        } else {
            replaceCurrent = replaceCurrent(node, node2, node3, new Node(z2 ? 90 : 130));
            Node node9 = new Node(90);
            Node firstChild5 = firstChild.getFirstChild();
            while (firstChild5 != null) {
                if (firstChild5.getType() == 159) {
                    Node firstChild6 = firstChild5.getFirstChild();
                    if (firstChild6.getType() != 154) {
                        throw Kit.codeBug();
                    }
                    node4 = z2 ? new Node(90, firstChild6.getNext(), next) : new Node(130, new Node((int) Token.EXPR_VOID, firstChild6.getNext()), next);
                    Scope.joinScopes((Scope) firstChild5, (Scope) node3);
                    node5 = firstChild6.getFirstChild();
                } else {
                    node4 = next;
                    node5 = firstChild5;
                }
                if (node5.getType() != 39) {
                    throw Kit.codeBug();
                }
                Node newString = Node.newString(node5.getString());
                newString.setScope((Scope) node3);
                Node firstChild7 = node5.getFirstChild();
                if (firstChild7 == null) {
                    firstChild7 = new Node(127, Node.newNumber(RoundRectDrawableWithShadow.COS_45));
                }
                node9.addChildToBack(new Node(56, newString, firstChild7));
                firstChild5 = firstChild5.getNext();
                next = node4;
            }
            if (z2) {
                replaceCurrent.addChildToBack(node9);
                node3.mo5274setType(90);
                replaceCurrent.addChildToBack(node3);
                node3.addChildToBack(next);
            } else {
                replaceCurrent.addChildToBack(new Node((int) Token.EXPR_VOID, node9));
                node3.mo5274setType(130);
                replaceCurrent.addChildToBack(node3);
                node3.addChildrenToBack(next);
            }
        }
        return replaceCurrent;
    }

    public void visitNew(Node node, ScriptNode scriptNode) {
    }
}

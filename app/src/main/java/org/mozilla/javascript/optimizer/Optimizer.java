package org.mozilla.javascript.optimizer;

import org.mozilla.javascript.Node;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ast.ScriptNode;

/* loaded from: classes5.dex */
public class Optimizer {
    public static final int AnyType = 3;
    public static final int NoType = 0;
    public static final int NumberType = 1;
    public boolean inDirectCallFunction;
    public boolean parameterUsedInNumberContext;
    public OptFunctionNode theFunction;

    public static void buildStatementList_r(Node node, ObjArray objArray) {
        int type = node.getType();
        if (type != 130 && type != 142 && type != 133 && type != 110) {
            objArray.add(node);
            return;
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            buildStatementList_r(firstChild, objArray);
        }
    }

    private boolean convertParameter(Node node) {
        if (!this.inDirectCallFunction || node.getType() != 55) {
            return false;
        }
        if (!this.theFunction.isParameter(this.theFunction.getVarIndex(node))) {
            return false;
        }
        node.removeProp(8);
        return true;
    }

    private void markDCPNumberContext(Node node) {
        if (!this.inDirectCallFunction || node.getType() != 55) {
            return;
        }
        if (!this.theFunction.isParameter(this.theFunction.getVarIndex(node))) {
            return;
        }
        this.parameterUsedInNumberContext = true;
    }

    private void optimizeFunction(OptFunctionNode optFunctionNode) {
        if (optFunctionNode.fnode.requiresActivation()) {
            return;
        }
        this.inDirectCallFunction = optFunctionNode.isTargetOfDirectCall();
        this.theFunction = optFunctionNode;
        ObjArray objArray = new ObjArray();
        buildStatementList_r(optFunctionNode.fnode, objArray);
        int size = objArray.size();
        Node[] nodeArr = new Node[size];
        objArray.toArray(nodeArr);
        Block.runFlowAnalyzes(optFunctionNode, nodeArr);
        if (optFunctionNode.fnode.requiresActivation()) {
            return;
        }
        this.parameterUsedInNumberContext = false;
        for (int i = 0; i < size; i++) {
            rewriteForNumberVariables(nodeArr[i], 1);
        }
        optFunctionNode.setParameterNumberContext(this.parameterUsedInNumberContext);
    }

    private void rewriteAsObjectChildren(Node node, Node node2) {
        while (node2 != null) {
            Node next = node2.getNext();
            if (rewriteForNumberVariables(node2, 0) == 1 && !convertParameter(node2)) {
                node.removeChild(node2);
                Node node3 = new Node(150, node2);
                if (next == null) {
                    node.addChildToBack(node3);
                } else {
                    node.addChildBefore(node3, next);
                }
            }
            node2 = next;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ba, code lost:
        if (r6 != 1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00bc, code lost:
        r9.putIntProp(8, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c6, code lost:
        if (r5 == 1) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d4, code lost:
        if (r6 == 1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00fb, code lost:
        if (r6 != 1) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00fd, code lost:
        r9.putIntProp(8, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0107, code lost:
        if (r5 == 1) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0115, code lost:
        if (r6 == 1) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int rewriteForNumberVariables(Node node, int i) {
        Node next;
        int type = node.getType();
        if (type == 40) {
            node.putIntProp(8, 0);
            return 1;
        } else if (type == 134) {
            if (rewriteForNumberVariables(node.getFirstChild(), 1) == 1) {
                node.putIntProp(8, 0);
            }
            return 0;
        } else {
            if (type != 141) {
                if (type != 157) {
                    if (type == 55) {
                        int varIndex = this.theFunction.getVarIndex(node);
                        if (this.inDirectCallFunction && this.theFunction.isParameter(varIndex) && i == 1) {
                            node.putIntProp(8, 0);
                            return 1;
                        } else if (!this.theFunction.isNumberVar(varIndex)) {
                            return 0;
                        } else {
                            node.putIntProp(8, 0);
                            return 1;
                        }
                    } else if (type != 56) {
                        if (type == 107 || type == 108) {
                            next = node.getFirstChild();
                            int rewriteForNumberVariables = rewriteForNumberVariables(next, 1);
                            if (next.getType() != 55) {
                                if (next.getType() != 36 && next.getType() != 33) {
                                    return 0;
                                }
                                return rewriteForNumberVariables;
                            }
                            if (rewriteForNumberVariables != 1 || convertParameter(next)) {
                                return 0;
                            }
                            node.putIntProp(8, 0);
                            markDCPNumberContext(next);
                            return 1;
                        }
                        switch (type) {
                            case 9:
                            case 10:
                            case 11:
                                break;
                            default:
                                switch (type) {
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        Node firstChild = node.getFirstChild();
                                        Node next2 = firstChild.getNext();
                                        int rewriteForNumberVariables2 = rewriteForNumberVariables(firstChild, 1);
                                        int rewriteForNumberVariables3 = rewriteForNumberVariables(next2, 1);
                                        markDCPNumberContext(firstChild);
                                        markDCPNumberContext(next2);
                                        if (!convertParameter(firstChild)) {
                                            if (!convertParameter(next2)) {
                                                if (rewriteForNumberVariables2 == 1) {
                                                    if (rewriteForNumberVariables3 == 1) {
                                                        node.putIntProp(8, 0);
                                                    }
                                                    node.putIntProp(8, 1);
                                                }
                                            }
                                            return 0;
                                        } else if (convertParameter(next2)) {
                                            return 0;
                                        }
                                        break;
                                    case 18:
                                    case 19:
                                        break;
                                    default:
                                        switch (type) {
                                            case 21:
                                                Node firstChild2 = node.getFirstChild();
                                                Node next3 = firstChild2.getNext();
                                                int rewriteForNumberVariables4 = rewriteForNumberVariables(firstChild2, 1);
                                                int rewriteForNumberVariables5 = rewriteForNumberVariables(next3, 1);
                                                if (!convertParameter(firstChild2)) {
                                                    if (!convertParameter(next3)) {
                                                        if (rewriteForNumberVariables4 == 1) {
                                                            if (rewriteForNumberVariables5 == 1) {
                                                                node.putIntProp(8, 0);
                                                                return 1;
                                                            }
                                                            node.putIntProp(8, 1);
                                                        }
                                                    }
                                                    return 0;
                                                } else if (convertParameter(next3)) {
                                                    return 0;
                                                }
                                                break;
                                            case 22:
                                            case 23:
                                            case 24:
                                            case 25:
                                                break;
                                            default:
                                                switch (type) {
                                                    case 36:
                                                        Node firstChild3 = node.getFirstChild();
                                                        Node next4 = firstChild3.getNext();
                                                        if (rewriteForNumberVariables(firstChild3, 1) == 1 && !convertParameter(firstChild3)) {
                                                            node.removeChild(firstChild3);
                                                            node.addChildToFront(new Node(150, firstChild3));
                                                        }
                                                        if (rewriteForNumberVariables(next4, 1) == 1 && !convertParameter(next4)) {
                                                            node.putIntProp(8, 2);
                                                        }
                                                        return 0;
                                                    case 37:
                                                        break;
                                                    case 38:
                                                        Node firstChild4 = node.getFirstChild();
                                                        rewriteAsObjectChildren(firstChild4, firstChild4.getFirstChild());
                                                        Node next5 = firstChild4.getNext();
                                                        if (((OptFunctionNode) node.getProp(9)) != null) {
                                                            while (next5 != null) {
                                                                if (rewriteForNumberVariables(next5, 1) == 1) {
                                                                    markDCPNumberContext(next5);
                                                                }
                                                                next5 = next5.getNext();
                                                            }
                                                        } else {
                                                            rewriteAsObjectChildren(node, next5);
                                                        }
                                                        return 0;
                                                    default:
                                                        rewriteAsObjectChildren(node, node.getFirstChild());
                                                        return 0;
                                                }
                                        }
                                }
                        }
                        Node firstChild5 = node.getFirstChild();
                        Node next6 = firstChild5.getNext();
                        int rewriteForNumberVariables6 = rewriteForNumberVariables(firstChild5, 1);
                        int rewriteForNumberVariables7 = rewriteForNumberVariables(next6, 1);
                        markDCPNumberContext(firstChild5);
                        markDCPNumberContext(next6);
                        if (rewriteForNumberVariables6 == 1) {
                            if (rewriteForNumberVariables7 == 1) {
                                node.putIntProp(8, 0);
                                return 1;
                            }
                            if (!convertParameter(next6)) {
                                node.removeChild(next6);
                                node.addChildToBack(new Node(151, next6));
                                node.putIntProp(8, 0);
                            }
                            return 1;
                        } else if (rewriteForNumberVariables7 == 1) {
                            if (!convertParameter(firstChild5)) {
                                node.removeChild(firstChild5);
                                node.addChildToFront(new Node(151, firstChild5));
                                node.putIntProp(8, 0);
                            }
                            return 1;
                        } else {
                            if (!convertParameter(firstChild5)) {
                                node.removeChild(firstChild5);
                                node.addChildToFront(new Node(151, firstChild5));
                            }
                            if (!convertParameter(next6)) {
                                node.removeChild(next6);
                                node.addChildToBack(new Node(151, next6));
                            }
                            node.putIntProp(8, 0);
                            return 1;
                        }
                    }
                }
                next = node.getFirstChild().getNext();
                int rewriteForNumberVariables8 = rewriteForNumberVariables(next, 1);
                int varIndex2 = this.theFunction.getVarIndex(node);
                if (this.inDirectCallFunction && this.theFunction.isParameter(varIndex2)) {
                    if (rewriteForNumberVariables8 != 1) {
                        return rewriteForNumberVariables8;
                    }
                    if (!convertParameter(next)) {
                        node.putIntProp(8, 0);
                        return 1;
                    }
                    markDCPNumberContext(next);
                    return 0;
                } else if (!this.theFunction.isNumberVar(varIndex2)) {
                    if (rewriteForNumberVariables8 == 1 && !convertParameter(next)) {
                        node.removeChild(next);
                        node.addChildToBack(new Node(150, next));
                    }
                    return 0;
                } else {
                    if (rewriteForNumberVariables8 != 1) {
                        node.removeChild(next);
                        node.addChildToBack(new Node(151, next));
                    }
                    node.putIntProp(8, 0);
                    markDCPNumberContext(next);
                    return 1;
                }
            }
            Node firstChild6 = node.getFirstChild();
            Node next7 = firstChild6.getNext();
            Node next8 = next7.getNext();
            if (rewriteForNumberVariables(firstChild6, 1) == 1 && !convertParameter(firstChild6)) {
                node.removeChild(firstChild6);
                node.addChildToFront(new Node(150, firstChild6));
            }
            if (rewriteForNumberVariables(next7, 1) == 1 && !convertParameter(next7)) {
                node.putIntProp(8, 1);
            }
            if (rewriteForNumberVariables(next8, 1) == 1 && !convertParameter(next8)) {
                node.removeChild(next8);
                node.addChildToBack(new Node(150, next8));
            }
            return 0;
        }
    }

    public void optimize(ScriptNode scriptNode) {
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            optimizeFunction(OptFunctionNode.get(scriptNode, i));
        }
    }
}

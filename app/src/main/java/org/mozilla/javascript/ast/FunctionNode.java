package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.mozilla.javascript.Node;

/* loaded from: classes5.dex */
public class FunctionNode extends ScriptNode {
    public static final int ARROW_FUNCTION = 4;
    public static final int FUNCTION_EXPRESSION = 2;
    public static final int FUNCTION_EXPRESSION_STATEMENT = 3;
    public static final int FUNCTION_STATEMENT = 1;
    public static final List<AstNode> NO_PARAMS = Collections.unmodifiableList(new ArrayList());
    public AstNode body;
    public Name functionName;
    public int functionType;
    public List<Node> generatorResumePoints;
    public boolean isExpressionClosure;
    public boolean isGenerator;
    public Map<Node, int[]> liveLocals;
    public AstNode memberExprNode;
    public boolean needsActivation;
    public List<AstNode> params;
    public Form functionForm = Form.FUNCTION;

    /* renamed from: lp */
    public int f4708lp = -1;

    /* renamed from: rp */
    public int f4709rp = -1;

    /* loaded from: classes5.dex */
    public enum Form {
        FUNCTION,
        GETTER,
        SETTER,
        METHOD
    }

    public FunctionNode() {
        this.type = 110;
    }

    public FunctionNode(int i) {
        super(i);
        this.type = 110;
    }

    public FunctionNode(int i, Name name) {
        super(i);
        this.type = 110;
        setFunctionName(name);
    }

    @Override // org.mozilla.javascript.ast.ScriptNode
    public int addFunction(FunctionNode functionNode) {
        int addFunction = super.addFunction(functionNode);
        if (getFunctionCount() > 0) {
            this.needsActivation = true;
        }
        return addFunction;
    }

    public void addLiveLocals(Node node, int[] iArr) {
        if (this.liveLocals == null) {
            this.liveLocals = new HashMap();
        }
        this.liveLocals.put(node, iArr);
    }

    public void addParam(AstNode astNode) {
        assertNotNull(astNode);
        if (this.params == null) {
            this.params = new ArrayList();
        }
        this.params.add(astNode);
        astNode.setParent(this);
    }

    public void addResumptionPoint(Node node) {
        if (this.generatorResumePoints == null) {
            this.generatorResumePoints = new ArrayList();
        }
        this.generatorResumePoints.add(node);
    }

    public AstNode getBody() {
        return this.body;
    }

    public Name getFunctionName() {
        return this.functionName;
    }

    public int getFunctionType() {
        return this.functionType;
    }

    public Map<Node, int[]> getLiveLocals() {
        return this.liveLocals;
    }

    public int getLp() {
        return this.f4708lp;
    }

    public AstNode getMemberExprNode() {
        return this.memberExprNode;
    }

    public String getName() {
        Name name = this.functionName;
        return name != null ? name.getIdentifier() : "";
    }

    public List<AstNode> getParams() {
        List<AstNode> list = this.params;
        return list != null ? list : NO_PARAMS;
    }

    public List<Node> getResumptionPoints() {
        return this.generatorResumePoints;
    }

    public int getRp() {
        return this.f4709rp;
    }

    public boolean isExpressionClosure() {
        return this.isExpressionClosure;
    }

    public boolean isGenerator() {
        return this.isGenerator;
    }

    public boolean isGetterMethod() {
        return this.functionForm == Form.GETTER;
    }

    public boolean isMethod() {
        Form form = this.functionForm;
        return form == Form.GETTER || form == Form.SETTER || form == Form.METHOD;
    }

    public boolean isNormalMethod() {
        return this.functionForm == Form.METHOD;
    }

    public boolean isParam(AstNode astNode) {
        List<AstNode> list = this.params;
        if (list == null) {
            return false;
        }
        return list.contains(astNode);
    }

    public boolean isSetterMethod() {
        return this.functionForm == Form.SETTER;
    }

    public boolean requiresActivation() {
        return this.needsActivation;
    }

    public void setBody(AstNode astNode) {
        assertNotNull(astNode);
        this.body = astNode;
        if (Boolean.TRUE.equals(astNode.getProp(25))) {
            setIsExpressionClosure(true);
        }
        int length = astNode.getLength() + astNode.getPosition();
        astNode.setParent(this);
        setLength(length - this.position);
        setEncodedSourceBounds(this.position, length);
    }

    public void setFunctionIsGetterMethod() {
        this.functionForm = Form.GETTER;
    }

    public void setFunctionIsNormalMethod() {
        this.functionForm = Form.METHOD;
    }

    public void setFunctionIsSetterMethod() {
        this.functionForm = Form.SETTER;
    }

    public void setFunctionName(Name name) {
        this.functionName = name;
        if (name != null) {
            name.setParent(this);
        }
    }

    public void setFunctionType(int i) {
        this.functionType = i;
    }

    public void setIsExpressionClosure(boolean z) {
        this.isExpressionClosure = z;
    }

    public void setIsGenerator() {
        this.isGenerator = true;
    }

    public void setLp(int i) {
        this.f4708lp = i;
    }

    public void setMemberExprNode(AstNode astNode) {
        this.memberExprNode = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setParams(List<AstNode> list) {
        if (list == null) {
            this.params = null;
            return;
        }
        List<AstNode> list2 = this.params;
        if (list2 != null) {
            list2.clear();
        }
        for (AstNode astNode : list) {
            addParam(astNode);
        }
    }

    public void setParens(int i, int i2) {
        this.f4708lp = i;
        this.f4709rp = i2;
    }

    public void setRequiresActivation() {
        this.needsActivation = true;
    }

    public void setRp(int i) {
        this.f4709rp = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toSource(int i) {
        String str;
        String trim;
        StringBuilder sb = new StringBuilder();
        boolean z = this.functionType == 4;
        if (!isMethod()) {
            sb.append(makeIndent(i));
            if (!z) {
                sb.append("function");
            }
        }
        if (this.functionName != null) {
            sb.append(StringUtils.SPACE);
            sb.append(this.functionName.toSource(0));
        }
        List<AstNode> list = this.params;
        if (list == null) {
            str = "() ";
        } else if (z && this.f4708lp == -1) {
            printList(list, sb);
            sb.append(StringUtils.SPACE);
            if (z) {
                sb.append("=> ");
            }
            if (!this.isExpressionClosure) {
                AstNode body = getBody();
                if (body.getLastChild() instanceof ReturnStatement) {
                    sb.append(((ReturnStatement) body.getLastChild()).getReturnValue().toSource(0));
                    if (this.functionType == 1) {
                        trim = ";";
                    }
                    if (this.functionType != 1 || isMethod()) {
                        sb.append("\n");
                    }
                    return sb.toString();
                }
                sb.append(StringUtils.SPACE);
                trim = body.toSource(0);
            } else {
                trim = getBody().toSource(i).trim();
            }
            sb.append(trim);
            if (this.functionType != 1) {
            }
            sb.append("\n");
            return sb.toString();
        } else {
            sb.append("(");
            printList(this.params, sb);
            str = ") ";
        }
        sb.append(str);
        if (z) {
        }
        if (!this.isExpressionClosure) {
        }
        sb.append(trim);
        if (this.functionType != 1) {
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.ScriptNode, org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        AstNode astNode;
        if (nodeVisitor.visit(this)) {
            Name name = this.functionName;
            if (name != null) {
                name.visit(nodeVisitor);
            }
            for (AstNode astNode2 : getParams()) {
                astNode2.visit(nodeVisitor);
            }
            getBody().visit(nodeVisitor);
            if (this.isExpressionClosure || (astNode = this.memberExprNode) == null) {
                return;
            }
            astNode.visit(nodeVisitor);
        }
    }
}

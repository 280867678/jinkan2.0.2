package org.mozilla.javascript.ast;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.AstNode;

/* loaded from: classes5.dex */
public class AstRoot extends ScriptNode {
    public SortedSet<Comment> comments;

    public AstRoot() {
        this.type = Token.SCRIPT;
    }

    public AstRoot(int i) {
        super(i);
        this.type = Token.SCRIPT;
    }

    public void addComment(Comment comment) {
        assertNotNull(comment);
        if (this.comments == null) {
            this.comments = new TreeSet(new AstNode.PositionComparator());
        }
        this.comments.add(comment);
        comment.setParent(this);
    }

    public void checkParentLinks() {
        visit(new NodeVisitor() { // from class: org.mozilla.javascript.ast.AstRoot.1
            @Override // org.mozilla.javascript.ast.NodeVisitor
            public boolean visit(AstNode astNode) {
                if (astNode.getType() != 137 && astNode.getParent() == null) {
                    throw new IllegalStateException("No parent for node: " + astNode + "\n" + astNode.toSource(0));
                }
                return true;
            }
        });
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String debugPrint() {
        AstNode.DebugPrintVisitor debugPrintVisitor = new AstNode.DebugPrintVisitor(new StringBuilder(1000));
        visitAll(debugPrintVisitor);
        return debugPrintVisitor.toString();
    }

    public SortedSet<Comment> getComments() {
        return this.comments;
    }

    public void setComments(SortedSet<Comment> sortedSet) {
        if (sortedSet == null) {
            this.comments = null;
            return;
        }
        SortedSet<Comment> sortedSet2 = this.comments;
        if (sortedSet2 != null) {
            sortedSet2.clear();
        }
        for (Comment comment : sortedSet) {
            addComment(comment);
        }
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        Iterator<Node> it = iterator();
        while (it.hasNext()) {
            Node next = it.next();
            sb.append(((AstNode) next).toSource(i));
            if (next.getType() == 162) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void visitAll(NodeVisitor nodeVisitor) {
        visit(nodeVisitor);
        visitComments(nodeVisitor);
    }

    public void visitComments(NodeVisitor nodeVisitor) {
        SortedSet<Comment> sortedSet = this.comments;
        if (sortedSet != null) {
            for (Comment comment : sortedSet) {
                nodeVisitor.visit(comment);
            }
        }
    }
}

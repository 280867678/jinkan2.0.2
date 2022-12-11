package org.mozilla.javascript.tools.debugger;

import java.util.Arrays;
import java.util.Comparator;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import me.tvspark.outline;
import org.apache.http.message.TokenParser;
import org.mozilla.javascript.tools.debugger.treetable.TreeTableModel;

/* loaded from: classes5.dex */
public class VariableModel implements TreeTableModel {
    public Dim debugger;
    public VariableNode root;
    public static final String[] cNames = {" Name", " Value"};
    public static final Class<?>[] cTypes = {TreeTableModel.class, String.class};
    public static final VariableNode[] CHILDLESS = new VariableNode[0];

    /* loaded from: classes5.dex */
    public static class VariableNode {
        public VariableNode[] children;

        /* renamed from: id */
        public Object f4740id;
        public Object object;

        public VariableNode(Object obj, Object obj2) {
            this.object = obj;
            this.f4740id = obj2;
        }

        public String toString() {
            Object obj = this.f4740id;
            if (obj instanceof String) {
                return (String) obj;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(((Integer) this.f4740id).intValue());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public VariableModel() {
    }

    public VariableModel(Dim dim, Object obj) {
        this.debugger = dim;
        this.root = new VariableNode(obj, "this");
    }

    private VariableNode[] children(VariableNode variableNode) {
        VariableNode[] variableNodeArr;
        if (variableNode.children != null) {
            return variableNode.children;
        }
        Object value = getValue(variableNode);
        Object[] objectIds = this.debugger.getObjectIds(value);
        if (objectIds == null || objectIds.length == 0) {
            variableNodeArr = CHILDLESS;
        } else {
            Arrays.sort(objectIds, new Comparator<Object>() { // from class: org.mozilla.javascript.tools.debugger.VariableModel.1
                @Override // java.util.Comparator
                public int compare(Object obj, Object obj2) {
                    if (obj instanceof String) {
                        if (!(obj2 instanceof Integer)) {
                            return ((String) obj).compareToIgnoreCase((String) obj2);
                        }
                        return -1;
                    } else if (!(obj2 instanceof String)) {
                        return ((Integer) obj).intValue() - ((Integer) obj2).intValue();
                    } else {
                        return 1;
                    }
                }
            });
            variableNodeArr = new VariableNode[objectIds.length];
            for (int i = 0; i != objectIds.length; i++) {
                variableNodeArr[i] = new VariableNode(value, objectIds[i]);
            }
        }
        variableNode.children = variableNodeArr;
        return variableNodeArr;
    }

    public void addTreeModelListener(TreeModelListener treeModelListener) {
    }

    public Object getChild(Object obj, int i) {
        if (this.debugger == null) {
            return null;
        }
        return children((VariableNode) obj)[i];
    }

    public int getChildCount(Object obj) {
        if (this.debugger == null) {
            return 0;
        }
        return children((VariableNode) obj).length;
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public Class<?> getColumnClass(int i) {
        return cTypes[i];
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public int getColumnCount() {
        return cNames.length;
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public String getColumnName(int i) {
        return cNames[i];
    }

    public int getIndexOfChild(Object obj, Object obj2) {
        if (this.debugger == null) {
            return -1;
        }
        VariableNode variableNode = (VariableNode) obj2;
        VariableNode[] children = children((VariableNode) obj);
        for (int i = 0; i != children.length; i++) {
            if (children[i] == variableNode) {
                return i;
            }
        }
        return -1;
    }

    public Object getRoot() {
        if (this.debugger == null) {
            return null;
        }
        return this.root;
    }

    public Object getValue(VariableNode variableNode) {
        try {
            return this.debugger.getObjectProperty(variableNode.object, variableNode.f4740id);
        } catch (Exception unused) {
            return "undefined";
        }
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public Object getValueAt(Object obj, int i) {
        String message;
        Dim dim = this.debugger;
        if (dim == null) {
            return null;
        }
        VariableNode variableNode = (VariableNode) obj;
        if (i == 0) {
            return variableNode.toString();
        }
        if (i != 1) {
            return null;
        }
        try {
            message = dim.objectToString(getValue(variableNode));
        } catch (RuntimeException e) {
            message = e.getMessage();
        }
        StringBuilder sb = new StringBuilder();
        int length = message.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = message.charAt(i2);
            if (Character.isISOControl(charAt)) {
                charAt = TokenParser.f4579SP;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public boolean isCellEditable(Object obj, int i) {
        return i == 0;
    }

    public boolean isLeaf(Object obj) {
        return this.debugger == null || children((VariableNode) obj).length == 0;
    }

    public void removeTreeModelListener(TreeModelListener treeModelListener) {
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public void setValueAt(Object obj, Object obj2, int i) {
    }

    public void valueForPathChanged(TreePath treePath, Object obj) {
    }
}

package org.mozilla.javascript.tools.debugger;

import javax.swing.JTable;

/* loaded from: classes5.dex */
public class Evaluator extends JTable {
    public static final long serialVersionUID = 8133672432982594256L;
    public MyTableModel tableModel = getModel();

    public Evaluator(SwingGui swingGui) {
        super(new MyTableModel(swingGui));
    }
}

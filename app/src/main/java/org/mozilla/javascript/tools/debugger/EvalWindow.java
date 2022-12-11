package org.mozilla.javascript.tools.debugger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

/* loaded from: classes5.dex */
public class EvalWindow extends JInternalFrame implements ActionListener {
    public static final long serialVersionUID = -2860585845212160176L;
    public EvalTextArea evalTextArea;

    public EvalWindow(String str, SwingGui swingGui) {
        super(str, true, false, true, true);
        EvalTextArea evalTextArea = new EvalTextArea(swingGui);
        this.evalTextArea = evalTextArea;
        evalTextArea.setRows(24);
        this.evalTextArea.setColumns(80);
        setContentPane(new JScrollPane(this.evalTextArea));
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("Cut")) {
            this.evalTextArea.cut();
        } else if (actionCommand.equals("Copy")) {
            this.evalTextArea.copy();
        } else if (!actionCommand.equals("Paste")) {
        } else {
            this.evalTextArea.paste();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.evalTextArea.setEnabled(z);
    }
}

package org.mozilla.javascript.tools.debugger;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/* loaded from: classes5.dex */
public class FilePopupMenu extends JPopupMenu {
    public static final long serialVersionUID = 3589525009546013565L;

    /* renamed from: x */
    public int f4736x;

    /* renamed from: y */
    public int f4737y;

    public FilePopupMenu(FileTextArea fileTextArea) {
        JMenuItem jMenuItem = new JMenuItem("Set Breakpoint");
        add(jMenuItem);
        jMenuItem.addActionListener(fileTextArea);
        JMenuItem jMenuItem2 = new JMenuItem("Clear Breakpoint");
        add(jMenuItem2);
        jMenuItem2.addActionListener(fileTextArea);
        JMenuItem jMenuItem3 = new JMenuItem("Run");
        add(jMenuItem3);
        jMenuItem3.addActionListener(fileTextArea);
    }

    public void show(JComponent jComponent, int i, int i2) {
        this.f4736x = i;
        this.f4737y = i2;
        super.show(jComponent, i, i2);
    }
}

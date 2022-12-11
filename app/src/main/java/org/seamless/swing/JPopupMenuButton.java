package org.seamless.swing;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPopupMenu;

/* loaded from: classes5.dex */
public class JPopupMenuButton extends JButton {
    public JPopupMenu popup;

    public JPopupMenuButton(String str, Icon icon, JPopupMenu jPopupMenu) {
        super(str, icon);
        this.popup = jPopupMenu;
        enableEvents(8L);
        enableEvents(16L);
        setModel(new DefaultButtonModel() { // from class: org.seamless.swing.JPopupMenuButton.1
            public void setPressed(boolean z) {
            }
        });
    }

    public JPopupMenuButton(String str, JPopupMenu jPopupMenu) {
        super(str);
        this.popup = jPopupMenu;
        enableEvents(8L);
        enableEvents(16L);
    }

    public JPopupMenuButton(JPopupMenu jPopupMenu) {
        this.popup = jPopupMenu;
        enableEvents(8L);
        enableEvents(16L);
    }

    public void processKeyEvent(KeyEvent keyEvent) {
        int id = keyEvent.getID();
        if (id == 401 || id == 400) {
            if (keyEvent.getKeyCode() == 10) {
                this.popup.show(this, 0, 10);
            }
            super.processKeyEvent(keyEvent);
        }
    }

    public void processMouseEvent(MouseEvent mouseEvent) {
        JPopupMenu jPopupMenu;
        super.processMouseEvent(mouseEvent);
        int id = mouseEvent.getID();
        if (id == 501) {
            JPopupMenu jPopupMenu2 = this.popup;
            if (jPopupMenu2 == null) {
                return;
            }
            jPopupMenu2.show(this, 0, 0);
        } else if (id != 502 || (jPopupMenu = this.popup) == null) {
        } else {
            jPopupMenu.setVisible(false);
        }
    }
}

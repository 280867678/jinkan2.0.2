package org.seamless.swing;

import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/* loaded from: classes5.dex */
public class ActionButton extends JButton {
    public ActionButton(String str) {
        setActionCommand(str);
    }

    public ActionButton(String str, String str2) {
        super(str);
        setActionCommand(str2);
    }

    public ActionButton(String str, Icon icon, String str2) {
        super(str, icon);
        setActionCommand(str2);
    }

    public ActionButton(Action action, String str) {
        super(action);
        setActionCommand(str);
    }

    public ActionButton(Icon icon, String str) {
        super(icon);
        setActionCommand(str);
    }

    public Event createDefaultEvent() {
        return null;
    }

    public Event createDefaultGlobalEvent() {
        return null;
    }

    public ActionButton enableDefaultEvents(final Controller controller) {
        controller.registerAction(this, new DefaultAction() { // from class: org.seamless.swing.ActionButton.1
            public void actionPerformed(ActionEvent actionEvent) {
                Event createDefaultEvent = ActionButton.this.createDefaultEvent();
                if (createDefaultEvent != null) {
                    controller.fireEvent(createDefaultEvent);
                }
                Event createDefaultGlobalEvent = ActionButton.this.createDefaultGlobalEvent();
                if (createDefaultGlobalEvent != null) {
                    controller.fireEventGlobal(createDefaultGlobalEvent);
                }
            }
        });
        return this;
    }
}

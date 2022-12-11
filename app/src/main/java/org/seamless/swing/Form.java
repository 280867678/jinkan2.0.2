package org.seamless.swing;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JSeparator;

/* loaded from: classes5.dex */
public class Form {
    public GridBagConstraints labelConstraints;
    public GridBagConstraints lastConstraints;
    public GridBagConstraints middleConstraints;
    public GridBagConstraints separatorConstraints;

    public Form(int i) {
        this.lastConstraints = null;
        this.middleConstraints = null;
        this.labelConstraints = null;
        this.separatorConstraints = null;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        this.lastConstraints = gridBagConstraints;
        gridBagConstraints.fill = 2;
        this.lastConstraints.anchor = 18;
        this.lastConstraints.weightx = 1.0d;
        this.lastConstraints.gridwidth = 0;
        this.lastConstraints.insets = new Insets(i, i, i, i);
        GridBagConstraints gridBagConstraints2 = (GridBagConstraints) this.lastConstraints.clone();
        this.middleConstraints = gridBagConstraints2;
        gridBagConstraints2.gridwidth = -1;
        GridBagConstraints gridBagConstraints3 = (GridBagConstraints) this.lastConstraints.clone();
        this.labelConstraints = gridBagConstraints3;
        gridBagConstraints3.weightx = RoundRectDrawableWithShadow.COS_45;
        this.labelConstraints.gridwidth = 1;
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
        this.separatorConstraints = gridBagConstraints4;
        gridBagConstraints4.fill = 2;
        this.separatorConstraints.gridwidth = 0;
    }

    public JLabel addLabel(String str, Container container) {
        JLabel jLabel = new JLabel(str);
        addLabel((Component) jLabel, container);
        return jLabel;
    }

    public void addLabel(Component component, Container container) {
        container.getLayout().setConstraints(component, this.labelConstraints);
        container.add(component);
    }

    public void addLabelAndLastField(String str, Container container, Container container2) {
        addLabel(str, container2);
        addLastField(container, container2);
    }

    public void addLabelAndLastField(String str, String str2, Container container) {
        addLabel(str, container);
        addLastField(new JLabel(str2), container);
    }

    public void addLastField(Component component, Container container) {
        container.getLayout().setConstraints(component, this.lastConstraints);
        container.add(component);
    }

    public void addMiddleField(Component component, Container container) {
        container.getLayout().setConstraints(component, this.middleConstraints);
        container.add(component);
    }

    public void addSeparator(Container container) {
        JSeparator jSeparator = new JSeparator();
        container.getLayout().setConstraints(jSeparator, this.separatorConstraints);
        container.add(jSeparator);
    }
}

package org.fourthline.cling.support.messagebox.model;

import org.fourthline.cling.support.messagebox.parser.MessageElement;

/* loaded from: classes5.dex */
public class NumberName implements ElementAppender {
    public String name;
    public String number;

    public NumberName(String str, String str2) {
        this.number = str;
        this.name = str2;
    }

    @Override // org.fourthline.cling.support.messagebox.model.ElementAppender
    public void appendMessageElements(MessageElement messageElement) {
        messageElement.createChild("Number").setContent(getNumber());
        messageElement.createChild("Name").setContent(getName());
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }
}

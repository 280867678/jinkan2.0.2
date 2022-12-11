package org.mozilla.javascript;

import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public class IdFunctionObjectES6 extends IdFunctionObject {
    public static final int Id_length = 1;
    public static final int Id_name = 3;
    public boolean myLength = true;
    public boolean myName = true;

    public IdFunctionObjectES6(IdFunctionCall idFunctionCall, Object obj, int i, String str, int i2, Scriptable scriptable) {
        super(idFunctionCall, obj, i, str, i2, scriptable);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        return str.equals(Name.LENGTH) ? IdScriptableObject.instanceIdInfo(3, 1) : str.equals("name") ? IdScriptableObject.instanceIdInfo(3, 3) : super.findInstanceIdInfo(str);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        return (i != 1 || this.myLength) ? (i != 3 || this.myName) ? super.getInstanceIdValue(i) : Scriptable.NOT_FOUND : Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        if (i == 1 && obj == Scriptable.NOT_FOUND) {
            this.myLength = false;
        } else if (i == 3 && obj == Scriptable.NOT_FOUND) {
            this.myName = false;
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }
}

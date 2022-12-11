package org.litepal.tablemanager.typechange;

import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes5.dex */
public class TextOrm extends OrmChange {
    @Override // org.litepal.tablemanager.typechange.OrmChange
    public String object2Relation(String str) {
        if (str != null) {
            if (!str.equals(ClassTransform.CHARACTER) && !str.equals("java.lang.Character") && !str.equals("java.lang.String")) {
                return null;
            }
            return "text";
        }
        return null;
    }
}

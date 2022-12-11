package org.litepal.tablemanager.typechange;

import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes5.dex */
public class BooleanOrm extends OrmChange {
    @Override // org.litepal.tablemanager.typechange.OrmChange
    public String object2Relation(String str) {
        if (str != null) {
            if (!str.equals(ClassTransform.BOOLEAN) && !str.equals("java.lang.Boolean")) {
                return null;
            }
            return "integer";
        }
        return null;
    }
}

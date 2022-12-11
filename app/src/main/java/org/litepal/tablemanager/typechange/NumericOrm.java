package org.litepal.tablemanager.typechange;

import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes5.dex */
public class NumericOrm extends OrmChange {
    @Override // org.litepal.tablemanager.typechange.OrmChange
    public String object2Relation(String str) {
        if (str != null) {
            if (!str.equals(ClassTransform.INTEGER) && !str.equals("java.lang.Integer") && !str.equals(ClassTransform.LONG) && !str.equals("java.lang.Long") && !str.equals(ClassTransform.SHORT) && !str.equals("java.lang.Short")) {
                return null;
            }
            return "integer";
        }
        return null;
    }
}

package org.litepal.tablemanager.typechange;

import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes5.dex */
public class DecimalOrm extends OrmChange {
    @Override // org.litepal.tablemanager.typechange.OrmChange
    public String object2Relation(String str) {
        if (str != null) {
            if (!str.equals(ClassTransform.FLOAT) && !str.equals("java.lang.Float") && !str.equals(ClassTransform.DOUBLE) && !str.equals("java.lang.Double")) {
                return null;
            }
            return "real";
        }
        return null;
    }
}

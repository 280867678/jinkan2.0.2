package org.simpleframework.xml.transform;

import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class BigDecimalTransform implements Transform<BigDecimal> {
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read  reason: avoid collision after fix types in other method */
    public BigDecimal mo5334read(String str) {
        return new BigDecimal(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(BigDecimal bigDecimal) {
        return bigDecimal.toString();
    }
}

package org.simpleframework.xml.transform;

import java.math.BigInteger;

/* loaded from: classes5.dex */
public class BigIntegerTransform implements Transform<BigInteger> {
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read  reason: avoid collision after fix types in other method */
    public BigInteger mo5334read(String str) {
        return new BigInteger(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(BigInteger bigInteger) {
        return bigInteger.toString();
    }
}

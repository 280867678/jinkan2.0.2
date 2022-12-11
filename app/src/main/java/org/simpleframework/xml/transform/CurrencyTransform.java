package org.simpleframework.xml.transform;

import java.util.Currency;

/* loaded from: classes5.dex */
public class CurrencyTransform implements Transform<Currency> {
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read  reason: collision with other method in class */
    public Currency mo5334read(String str) {
        return Currency.getInstance(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Currency currency) {
        return currency.toString();
    }
}

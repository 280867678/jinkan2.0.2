package org.simpleframework.xml.transform;

import java.util.Date;

/* loaded from: classes5.dex */
public class DateTransform<T extends Date> implements Transform<T> {
    public final DateFactory<T> factory;

    public DateTransform(Class<T> cls) throws Exception {
        this.factory = new DateFactory<>(cls);
    }

    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read  reason: collision with other method in class */
    public synchronized T mo5334read(String str) throws Exception {
        return this.factory.getInstance(Long.valueOf(DateType.getDate(str).getTime()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.simpleframework.xml.transform.Transform
    public /* bridge */ /* synthetic */ String write(Object obj) throws Exception {
        return write((DateTransform<T>) ((Date) obj));
    }

    public synchronized String write(T t) throws Exception {
        return DateType.getText(t);
    }
}

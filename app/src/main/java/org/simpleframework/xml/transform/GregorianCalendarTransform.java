package org.simpleframework.xml.transform;

import java.util.Date;
import java.util.GregorianCalendar;

/* loaded from: classes5.dex */
public class GregorianCalendarTransform implements Transform<GregorianCalendar> {
    public final DateTransform transform;

    public GregorianCalendarTransform() throws Exception {
        this(Date.class);
    }

    public GregorianCalendarTransform(Class cls) throws Exception {
        this.transform = new DateTransform(cls);
    }

    private GregorianCalendar read(Date date) throws Exception {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (date != null) {
            gregorianCalendar.setTime(date);
        }
        return gregorianCalendar;
    }

    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read  reason: collision with other method in class */
    public GregorianCalendar mo5334read(String str) throws Exception {
        return read(this.transform.mo5334read(str));
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(GregorianCalendar gregorianCalendar) throws Exception {
        return this.transform.write((DateTransform) gregorianCalendar.getTime());
    }
}

package org.simpleframework.xml.transform;

import java.util.TimeZone;

/* loaded from: classes5.dex */
public class TimeZoneTransform implements Transform<TimeZone> {
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read  reason: collision with other method in class */
    public TimeZone mo5334read(String str) {
        return TimeZone.getTimeZone(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(TimeZone timeZone) {
        return timeZone.getID();
    }
}

package org.fourthline.cling.model.meta;

import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;
import org.fourthline.cling.model.Validatable;
import org.fourthline.cling.model.ValidationError;
import org.fourthline.cling.model.types.UDN;

/* loaded from: classes5.dex */
public class DeviceIdentity implements Validatable {
    public final Integer maxAgeSeconds;
    public final UDN udn;

    public DeviceIdentity(UDN udn) {
        this.udn = udn;
        this.maxAgeSeconds = 1800;
    }

    public DeviceIdentity(UDN udn, Integer num) {
        this.udn = udn;
        this.maxAgeSeconds = num;
    }

    public DeviceIdentity(UDN udn, DeviceIdentity deviceIdentity) {
        this.udn = udn;
        this.maxAgeSeconds = deviceIdentity.getMaxAgeSeconds();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.udn.equals(((DeviceIdentity) obj).udn);
    }

    public Integer getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public UDN getUdn() {
        return this.udn;
    }

    public int hashCode() {
        return this.udn.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") UDN: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getUdn());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.fourthline.cling.model.Validatable
    public List<ValidationError> validate() {
        ArrayList arrayList = new ArrayList();
        if (getUdn() == null) {
            arrayList.add(new ValidationError(getClass(), "major", "Device has no UDN"));
        }
        return arrayList;
    }
}

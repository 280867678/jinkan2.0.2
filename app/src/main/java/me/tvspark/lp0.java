package me.tvspark;

import java.util.ArrayList;
import java.util.List;
import org.fourthline.cling.model.types.DeviceType;
import org.fourthline.cling.model.types.UDADeviceType;

/* loaded from: classes4.dex */
public class lp0 {
    public static lp0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final DeviceType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new UDADeviceType("MediaRenderer");
    public ro0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<ro0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public lp0() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
    }

    public static lp0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new lp0();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

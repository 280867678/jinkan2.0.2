package me.tvspark;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.seimicrawler.xpath.exception.NoSuchFunctionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public class z71 {
    public static Map<String, i61> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
    public static Map<String, k61> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
    public static Map<String, j61> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
    public static Logger Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LoggerFactory.getLogger(z71.class);

    static {
        Class[] clsArr = {o61.class, p61.class, q61.class, r61.class, s61.class, t61.class, u61.class, v61.class, w61.class, x61.class, y61.class, z61.class, a71.class, b71.class};
        int i = 0;
        for (int i2 = 14; i < i2; i2 = 14) {
            try {
                i61 i61Var = (i61) clsArr[i].newInstance();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(i61Var.name(), i61Var);
            } catch (Exception e) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.info(ExceptionUtils.getRootCauseMessage(e), (Throwable) e);
            }
            i++;
        }
        Class[] clsArr2 = {c71.class, d71.class, e71.class, f71.class, h71.class, i71.class, j71.class, k71.class, l71.class, m71.class, n71.class, p71.class, r71.class, g71.class, o71.class, q71.class};
        for (int i3 = 0; i3 < 16; i3++) {
            try {
                j61 j61Var = (j61) clsArr2[i3].newInstance();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(j61Var.name(), j61Var);
            } catch (Exception e2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.info(ExceptionUtils.getRootCauseMessage(e2), (Throwable) e2);
            }
        }
        Class[] clsArr3 = {s71.class, t71.class, u71.class, v71.class, w71.class, x71.class};
        for (int i4 = 0; i4 < 6; i4++) {
            try {
                k61 k61Var = (k61) clsArr3[i4].newInstance();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(k61Var.name(), k61Var);
            } catch (Exception e3) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.info(ExceptionUtils.getRootCauseMessage(e3), (Throwable) e3);
            }
        }
    }

    public static k61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        k61 k61Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
        if (k61Var != null) {
            return k61Var;
        }
        throw new NoSuchFunctionException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("not support nodeTest: ", str));
    }
}

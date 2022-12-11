package sun.reflect;

import java.util.HashMap;
import sun.misc.C3423VM;

/* loaded from: classes5.dex */
public class Reflection {
    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Reflection.class, new String[]{"fieldFilterMap", "methodFilterMap"});
        hashMap.put(System.class, new String[]{"security"});
        new HashMap();
    }

    @CallerSensitive
    @Deprecated
    public static Class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C3423VM.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return getCallerClass0(i + 1);
    }

    @CallerSensitive
    public static native Class getCallerClass0(int i);
}

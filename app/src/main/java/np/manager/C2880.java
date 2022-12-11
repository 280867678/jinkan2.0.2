package np.manager;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.ArrayMap;
import android.util.Log;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: np.manager.̅ */
/* loaded from: classes2.dex */
public final class C2880 {

    /* renamed from: ̅ */
    public static boolean f4534 = false;

    /* renamed from: ̍ */
    private static final short[] f4535 = {1853, 1841, 1822, 1834, 1853, 1800, 1817, 1834, 1798, 1800, 1851, 1843, 1852, 1846, 1898, 1816, 1851, 1800, 1809, 1837, 1802, 1901, 1843, 1841, 1853, 1848, 1890, 1890, 1574, 1613, 1606, 1547, 1587, 1553, 1593, 1551, 1565, 1554, 1563, 1610, 1563, 1580, 1610, 1592, 1563, 1576, 1585, 1549, 1578, 1613, 1555, 1553, 1565, 1560, 1602, 1602};

    /* renamed from: ̎ */
    public static boolean f4536 = true;

    /* renamed from: ̍ */
    public static String m172(Object obj) {
        String name = ((Method) obj).getName();
        while (true) {
            int i = 1708705 ^ 14757;
            while (true) {
                switch (i) {
                    case -1060848036:
                        return name;
                    case 1714948:
                        i = -1060848036;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x002b -> 0x001c
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̎ */
    public static java.lang.StringBuilder m171(java.lang.Object r84, java.lang.Object r85) {
        /*
            r34 = r85
            r33 = r84
            r0 = r33
            r1 = r34
            java.lang.StringBuilder r0 = (java.lang.StringBuilder) r0
            java.lang.StringBuilder r0 = r0.append(r1)
        Le:
            r7 = 1709077(0x1a1415, float:2.394927E-39)
            goto L12
        L12:
            r9 = 37493(0x9275, float:5.2539E-41)
            r7 = r7 ^ r9
        L17:
            switch(r7) {
                case -1834964072: goto L2a;
                case 1738336: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto Le
        L1b:
            goto L26
        L26:
            r7 = -1834964072(0xffffffff92a0ab98, float:-1.0139721E-27)
            goto L17
        L2a:
            return r0
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m171(java.lang.Object, java.lang.Object):java.lang.StringBuilder");
    }

    /* renamed from: ̐ */
    public static void m170(Object obj) {
        ((FileInputStream) obj).close();
        while (true) {
            int i = 1736853 ^ 14667;
            while (true) {
                switch (i) {
                    case 1751518:
                        i = 401229226;
                    case 401229226:
                        return;
                }
            }
        }
    }

    /* renamed from: ̒ */
    public static Method m169(Object obj, Object obj2, Object obj3) {
        Method declaredMethod = ((Class) obj).getDeclaredMethod((String) obj2, (Class[]) obj3);
        while (true) {
            int i = 1736884 ^ 52863;
            while (true) {
                switch (i) {
                    case 1724107:
                        i = 107826461;
                    case 107826461:
                        return declaredMethod;
                }
            }
        }
    }

    /* renamed from: ̓ */
    public static Object m168(Object obj, Object obj2, Object obj3) {
        Object newProxyInstance = Proxy.newProxyInstance((ClassLoader) obj, (Class[]) obj2, (InvocationHandler) obj3);
        while (true) {
            int i = 1736915 ^ 53927;
            while (true) {
                switch (i) {
                    case -185574588:
                        return newProxyInstance;
                    case 1725044:
                        i = -185574588;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0023 -> 0x0018
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̔ */
    public static android.content.pm.ApplicationInfo m167(java.lang.Object r84) {
        /*
            r33 = r84
            r0 = r33
            android.content.Context r0 = (android.content.Context) r0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
        La:
            r6 = 1736946(0x1a80f2, float:2.43398E-39)
            goto Le
        Le:
            r8 = 32721(0x7fd1, float:4.5852E-41)
            r6 = r6 ^ r8
        L13:
            switch(r6) {
                case 1769251: goto L17;
                case 963244506: goto L22;
                default: goto L16;
            }
        L16:
            goto La
        L17:
            goto L24
        L22:
            return r0
            goto L18
        L24:
            r6 = 963244506(0x3969f1da, float:2.2310708E-4)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m167(java.lang.Object):android.content.pm.ApplicationInfo");
    }

    /*  JADX ERROR: Failed to set jump: 0x0023 -> 0x0018
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̕ */
    public static java.lang.Class m166(java.lang.Object r84) {
        /*
            r33 = r84
            r0 = r33
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Class r0 = m115(r0)
        La:
            r6 = 1736977(0x1a8111, float:2.434023E-39)
            goto Le
        Le:
            r8 = 68985(0x10d79, float:9.6669E-41)
            r6 = r6 ^ r8
        L13:
            switch(r6) {
                case 1805416: goto L17;
                case 669882869: goto L22;
                default: goto L16;
            }
        L16:
            goto La
        L17:
            goto L24
        L22:
            return r0
            goto L18
        L24:
            r6 = 669882869(0x27ed99f5, float:6.5947635E-15)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m166(java.lang.Object):java.lang.Class");
    }

    /* renamed from: ̖ */
    public static Object m165(Object obj, Object obj2) {
        Object obj3 = ((Field) obj).get(obj2);
        while (true) {
            int i = 1737008 ^ 99635;
            while (true) {
                switch (i) {
                    case 1770499:
                        i = 376315454;
                    case 376315454:
                        return obj3;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0029 -> 0x001e
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̗ */
    public static java.lang.reflect.Field m164(java.lang.Object r84, java.lang.Object r85) {
        /*
            r34 = r85
            r33 = r84
            r0 = r33
            r1 = r34
            java.lang.Class r0 = (java.lang.Class) r0
            java.lang.String r1 = (java.lang.String) r1
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)
        L10:
            r7 = 1708457(0x1a11a9, float:2.394058E-39)
            goto L14
        L14:
            r9 = 84519(0x14a27, float:1.18436E-40)
            r7 = r7 ^ r9
        L19:
            switch(r7) {
                case -155771795: goto L28;
                case 1792910: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L10
        L1d:
            goto L2a
        L28:
            return r0
            goto L1e
        L2a:
            r7 = -155771795(0xfffffffff6b71c6d, float:-1.8569665E33)
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m164(java.lang.Object, java.lang.Object):java.lang.reflect.Field");
    }

    /* renamed from: ̘ */
    public static Object m163(Object obj) {
        Object next = ((Iterator) obj).next();
        while (true) {
            int i = 53062561 ^ 35300;
            while (true) {
                switch (i) {
                    case -1796589631:
                        return next;
                    case 53027397:
                        i = -1796589631;
                }
            }
        }
    }

    /* renamed from: ̙ */
    public static void m162(Object obj, boolean z) {
        ((Method) obj).setAccessible(z);
        while (true) {
            int i = 52971328 ^ 42116;
            while (true) {
                switch (i) {
                    case 53011396:
                        i = 2128239431;
                    case 2128239431:
                        return;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0027 -> 0x001c
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̚ */
    public static int m161(java.lang.Object r84, int r85) {
        /*
            r34 = r85
            r33 = r84
            r0 = r33
            r1 = r34
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.codePointAt(r1)
        Le:
            r7 = 52971700(0x32848b4, float:4.945422E-37)
            goto L12
        L12:
            r9 = 79775(0x1379f, float:1.11789E-40)
            r7 = r7 ^ r9
        L17:
            switch(r7) {
                case 53051179: goto L1b;
                case 1354204712: goto L26;
                default: goto L1a;
            }
        L1a:
            goto Le
        L1b:
            goto L28
        L26:
            return r0
            goto L1c
        L28:
            r7 = 1354204712(0x50b78628, float:2.46321807E10)
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m161(java.lang.Object, int):int");
    }

    /* renamed from: ̜ */
    public static void m160(Object obj, Object obj2) {
        ((DataInputStream) obj).readFully((byte[]) obj2);
        while (true) {
            int i = 52999476 ^ 51839;
            while (true) {
                switch (i) {
                    case -704626988:
                        return;
                    case 52985675:
                        i = -704626988;
                }
            }
        }
    }

    /* renamed from: ̝ */
    public static int m159(Object obj, Object obj2) {
        int e = Log.e((String) obj, (String) obj2);
        while (true) {
            int i = 52999507 ^ 51794;
            while (true) {
                switch (i) {
                    case -998035074:
                        return e;
                    case 52985601:
                        i = -998035074;
                }
            }
        }
    }

    /* renamed from: ̞ */
    public static Class m158(Object obj) {
        Class<?> cls = obj.getClass();
        while (true) {
            int i = 52999538 ^ 64882;
            while (true) {
                switch (i) {
                    case -1291322145:
                        return cls;
                    case 52971520:
                        i = -1291322145;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0023 -> 0x0018
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̟ */
    public static java.lang.String m157(java.lang.Object r84) {
        /*
            r33 = r84
            r0 = r33
            java.io.File r0 = (java.io.File) r0
            java.lang.String r0 = r0.getAbsolutePath()
        La:
            r6 = 52999569(0x328b591, float:4.957919E-37)
            goto Le
        Le:
            r8 = 16735(0x415f, float:2.3451E-41)
            r6 = r6 ^ r8
        L13:
            switch(r6) {
                case -142588790: goto L22;
                case 53015758: goto L17;
                default: goto L16;
            }
        L16:
            goto La
        L17:
            goto L24
        L22:
            return r0
            goto L18
        L24:
            r6 = -142588790(0xfffffffff780448a, float:-5.203157E33)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m157(java.lang.Object):java.lang.String");
    }

    /*  JADX ERROR: Failed to set jump: 0x0021 -> 0x0016
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̠ */
    public static java.lang.String m156(java.lang.Object r84) {
        /*
            r33 = r84
            r0 = r33
            java.lang.String r0 = r0.toString()
        L8:
            r6 = 52999600(0x328b5b0, float:4.957933E-37)
            goto Lc
        Lc:
            r8 = 48986(0xbf5a, float:6.8644E-41)
            r6 = r6 ^ r8
        L11:
            switch(r6) {
                case -435965172: goto L20;
                case 52955882: goto L15;
                default: goto L14;
            }
        L14:
            goto L8
        L15:
            goto L22
        L20:
            return r0
            goto L16
        L22:
            r6 = -435965172(0xffffffffe603b30c, float:-1.5548321E23)
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m156(java.lang.Object):java.lang.String");
    }

    /* renamed from: ̡ */
    public static Boolean m155(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        while (true) {
            int i = 52999631 ^ 41094;
            while (true) {
                switch (i) {
                    case -729370031:
                        return valueOf;
                    case 52958537:
                        i = -729370031;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0027 -> 0x0018
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̢ */
    public static int m154(java.lang.Object r84) {
        /*
            r33 = r84
            r0 = r33
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.length()
        La:
            r6 = 52971080(0x3284648, float:4.945144E-37)
            goto Le
        Le:
            r8 = 80438(0x13a36, float:1.12718E-40)
            r6 = r6 ^ r8
        L13:
            switch(r6) {
                case -1261571038: goto L26;
                case 53050494: goto L17;
                default: goto L16;
            }
        L16:
            goto La
        L17:
            goto L22
        L22:
            r6 = -1261571038(0xffffffffb4cdf422, float:-3.8361856E-7)
            goto L13
        L26:
            return r0
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m154(java.lang.Object):int");
    }

    /* renamed from: ̩ */
    public static Object m153(Object obj, Object obj2, Object obj3) {
        Object invoke = ((Method) obj).invoke(obj2, (Object[]) obj3);
        while (true) {
            int i = 53074093 ^ 86055;
            while (true) {
                switch (i) {
                    case -252741314:
                        return invoke;
                    case 52988042:
                        i = -252741314;
                }
            }
        }
    }

    /* renamed from: ̪ */
    public static boolean m152(Object obj, Object obj2) {
        boolean add = ((ArrayList) obj).add(obj2);
        while (true) {
            int i = 52982860 ^ 57466;
            while (true) {
                switch (i) {
                    case -622949683:
                        return add;
                    case 52991030:
                        i = -622949683;
                }
            }
        }
    }

    /* renamed from: ̫ */
    public static int m151(Object obj) {
        int intValue = ((Integer) obj).intValue();
        while (true) {
            int i = 52983232 ^ 60659;
            while (true) {
                switch (i) {
                    case -1397034920:
                        return intValue;
                    case 52992307:
                        i = -1397034920;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0021 -> 0x0016
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̬ */
    public static int m150(java.lang.Object r84) {
        /*
            r33 = r84
            r0 = r33
            int r0 = r0.hashCode()
        L8:
            r6 = 53011008(0x328e240, float:4.9630485E-37)
            goto Lc
        Lc:
            r8 = 49113(0xbfd9, float:6.8822E-41)
            r6 = r6 ^ r8
        L11:
            switch(r6) {
                case 52977049: goto L15;
                case 839180358: goto L20;
                default: goto L14;
            }
        L14:
            goto L8
        L15:
            goto L22
        L20:
            return r0
            goto L16
        L22:
            r6 = 839180358(0x3204e046, float:7.734405E-9)
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m150(java.lang.Object):int");
    }

    /* renamed from: ̯ */
    public static void m149(Object obj) {
        ((Application) obj).onCreate();
        while (true) {
            int i = 53011039 ^ 71708;
            while (true) {
                switch (i) {
                    case 53082691:
                        i = 545685052;
                    case 545685052:
                        return;
                }
            }
        }
    }

    /* renamed from: ̲ */
    public static boolean m148() {
        while (true) {
            int i = 53011070 ^ 24497;
            while (true) {
                switch (i) {
                    case 53001679:
                        i = 252326672;
                    case 252326672:
                        return true;
                }
            }
        }
    }

    /* renamed from: ̳ */
    public static int m147(Object obj, Object obj2) {
        int i = Log.i((String) obj, (String) obj2);
        while (true) {
            int i2 = 53011101 ^ 89247;
            while (true) {
                switch (i2) {
                    case 53067266:
                        i2 = 1401039958;
                    case 1401039958:
                        return i;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0027 -> 0x001c
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̴ */
    public static byte[] m146(java.lang.Object r84, int r85) {
        /*
            r34 = r85
            r33 = r84
            r0 = r33
            r1 = r34
            java.lang.String r0 = (java.lang.String) r0
            byte[] r0 = android.util.Base64.decode(r0, r1)
        Le:
            r7 = 53011132(0x328e2bc, float:4.963104E-37)
            goto L12
        L12:
            r9 = 98734(0x181ae, float:1.38356E-40)
            r7 = r7 ^ r9
        L17:
            switch(r7) {
                case 53043986: goto L1b;
                case 1107818212: goto L26;
                default: goto L1a;
            }
        L1a:
            goto Le
        L1b:
            goto L28
        L26:
            return r0
            goto L1c
        L28:
            r7 = 1107818212(0x4207f6e4, float:33.991104)
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m146(java.lang.Object, int):byte[]");
    }

    /* renamed from: ̵ */
    public static StringBuilder m145(Object obj, Object obj2) {
        StringBuilder append = ((StringBuilder) obj).append((String) obj2);
        while (true) {
            int i = 53011163 ^ 34366;
            while (true) {
                switch (i) {
                    case 52978917:
                        i = 814349301;
                    case 814349301:
                        return append;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0023 -> 0x0018
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̶ */
    public static java.util.Iterator m144(java.lang.Object r84) {
        /*
            r33 = r84
            r0 = r33
            java.util.Set r0 = (java.util.Set) r0
            java.util.Iterator r0 = r0.iterator()
        La:
            r6 = 52982612(0x3287354, float:4.9503153E-37)
            goto Le
        Le:
            r8 = 29716(0x7414, float:4.1641E-41)
            r6 = r6 ^ r8
        L13:
            switch(r6) {
                case 52954944: goto L17;
                case 282086684: goto L22;
                default: goto L16;
            }
        L16:
            goto La
        L17:
            goto L24
        L22:
            return r0
            goto L18
        L24:
            r6 = 282086684(0x10d04d1c, float:8.216034E-29)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m144(java.lang.Object):java.util.Iterator");
    }

    /*  JADX ERROR: Failed to set jump: 0x0027 -> 0x0018
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̹ */
    public static java.lang.Object m142(java.lang.Object r84) {
        /*
            r33 = r84
            r0 = r33
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            java.lang.Object r0 = r0.get()
        La:
            r6 = 53872064(0x33605c0, float:5.3491594E-37)
            goto Le
        Le:
            r8 = 94781(0x1723d, float:1.32816E-40)
            r6 = r6 ^ r8
        L13:
            switch(r6) {
                case -561714770: goto L26;
                case 53966845: goto L17;
                default: goto L16;
            }
        L16:
            goto La
        L17:
            goto L22
        L22:
            r6 = -561714770(0xffffffffde84e9ae, float:-4.7886887E18)
            goto L13
        L26:
            return r0
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m142(java.lang.Object):java.lang.Object");
    }

    /* renamed from: ̻ */
    public static boolean m141(Object obj, Object obj2) {
        boolean remove = ((ArrayList) obj).remove(obj2);
        while (true) {
            int i = 53872095 ^ 42293;
            while (true) {
                switch (i) {
                    case -855111903:
                        return remove;
                    case 53911786:
                        i = -855111903;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0029 -> 0x001a
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̼ */
    public static boolean m140(java.lang.Object r84, java.lang.Object r85) {
        /*
            r34 = r85
            r33 = r84
            r0 = r33
            r1 = r34
            boolean r0 = r0.equals(r1)
        Lc:
            r7 = 53872126(0x33605fe, float:5.349187E-37)
            goto L10
        L10:
            r9 = 30777(0x7839, float:4.3128E-41)
            r7 = r7 ^ r9
        L15:
            switch(r7) {
                case -1148464980: goto L28;
                case 53902791: goto L19;
                default: goto L18;
            }
        L18:
            goto Lc
        L19:
            goto L24
        L24:
            r7 = -1148464980(0xffffffffbb8bd0ac, float:-0.004266819)
            goto L15
        L28:
            return r0
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m140(java.lang.Object, java.lang.Object):boolean");
    }

    /* renamed from: ̽ */
    public static int m139(Object obj) {
        int read = ((DataInputStream) obj).read();
        while (true) {
            int i = 53872157 ^ 68186;
            while (true) {
                switch (i) {
                    case 370407:
                        return read;
                    case 53939271:
                        i = 370407;
                }
            }
        }
    }

    /* renamed from: ̾ */
    public static boolean m138(Object obj, Object obj2) {
        boolean contains = ((String) obj).contains((CharSequence) obj2);
        while (true) {
            int i = 53872188 ^ 97551;
            while (true) {
                switch (i) {
                    case -293155279:
                        return contains;
                    case 53967667:
                        i = -293155279;
                }
            }
        }
    }

    /* renamed from: ̿ */
    public static int m137(Object obj) {
        int readInt = ((DataInputStream) obj).readInt();
        while (true) {
            int i = 53872219 ^ 81210;
            while (true) {
                switch (i) {
                    case -586447739:
                        return readInt;
                    case 53951329:
                        i = -586447739;
                }
            }
        }
    }

    /* renamed from: ͂ */
    public static String m136(Object obj) {
        String stackTraceString = Log.getStackTraceString((Throwable) obj);
        while (true) {
            int i = 53843668 ^ 76190;
            while (true) {
                switch (i) {
                    case -1118806686:
                        return stackTraceString;
                    case 53788490:
                        i = -1118806686;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0027 -> 0x001c
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ̓ */
    public static java.lang.StringBuilder m135(java.lang.Object r84, char r85) {
        /*
            r34 = r85
            r33 = r84
            r0 = r33
            r1 = r34
            java.lang.StringBuilder r0 = (java.lang.StringBuilder) r0
            java.lang.StringBuilder r0 = r0.append(r1)
        Le:
            r7 = 53936110(0x336ffee, float:5.3778786E-37)
            goto L12
        L12:
            r9 = 12998(0x32c6, float:1.8214E-41)
            r7 = r7 ^ r9
        L17:
            switch(r7) {
                case 53923112: goto L1b;
                case 1796862984: goto L26;
                default: goto L1a;
            }
        L1a:
            goto Le
        L1b:
            goto L28
        L26:
            return r0
            goto L1c
        L28:
            r7 = 1796862984(0x6b19f408, float:1.8611806E26)
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m135(java.lang.Object, char):java.lang.StringBuilder");
    }

    /* renamed from: ͅ */
    public static Set m134(Object obj) {
        Set keySet = ((Map) obj).keySet();
        while (true) {
            int i = 53844877 ^ 44036;
            while (true) {
                switch (i) {
                    case 53819273:
                        i = 1426760808;
                    case 1426760808:
                        return keySet;
                }
            }
        }
    }

    /* renamed from: ͆ */
    public static Collection m133(Object obj) {
        Collection values = ((ArrayMap) obj).values();
        while (true) {
            int i = 53845249 ^ 52862;
            while (true) {
                switch (i) {
                    case 53826431:
                        i = 652571678;
                    case 652571678:
                        return values;
                }
            }
        }
    }

    /* renamed from: ͇ */
    public static Iterator m132(Object obj) {
        Iterator it = ((Collection) obj).iterator();
        while (true) {
            int i = 53873025 ^ 25125;
            while (true) {
                switch (i) {
                    case -1406165135:
                        return it;
                    case 53898148:
                        i = -1406165135;
                }
            }
        }
    }

    /* renamed from: ͈ */
    public static Thread m131() {
        Thread currentThread = Thread.currentThread();
        while (true) {
            int i = 53873056 ^ 55512;
            while (true) {
                switch (i) {
                    case -1699489011:
                        return currentThread;
                    case 53924216:
                        i = -1699489011;
                }
            }
        }
    }

    /* renamed from: ͉ */
    public static Object m130(Object obj, Object obj2) {
        Object obj3 = ((Map) obj).get(obj2);
        while (true) {
            int i = 53873087 ^ 74156;
            while (true) {
                switch (i) {
                    case -1992872966:
                        return obj3;
                    case 53946387:
                        i = -1992872966;
                }
            }
        }
    }

    /* renamed from: ͊ */
    public static String m129(Object obj, Object obj2, Object obj3) {
        String replace = ((String) obj).replace((CharSequence) obj2, (CharSequence) obj3);
        while (true) {
            int i = 53873118 ^ 35302;
            while (true) {
                switch (i) {
                    case -844134504:
                        return replace;
                    case 53903416:
                        i = -844134504;
                }
            }
        }
    }

    /* renamed from: ͋ */
    public static PackageManager m128(Object obj) {
        PackageManager packageManager = ((Context) obj).getPackageManager();
        while (true) {
            int i = 53873149 ^ 15709;
            while (true) {
                switch (i) {
                    case -1137563230:
                        return packageManager;
                    case 53884064:
                        i = -1137563230;
                }
            }
        }
    }

    /* renamed from: ͌ */
    public static void m127(Object obj, boolean z) {
        ((Field) obj).setAccessible(z);
        while (true) {
            int i = 53873180 ^ 15332;
            while (true) {
                switch (i) {
                    case -1430970268:
                        return;
                    case 53883384:
                        i = -1430970268;
                }
            }
        }
    }

    /* renamed from: ͍ */
    public static Signature[] m126(Object obj) {
        Signature[] apkContentsSigners = ((SigningInfo) obj).getApkContentsSigners();
        while (true) {
            int i = 53844629 ^ 5462;
            while (true) {
                switch (i) {
                    case -1963211797:
                        return apkContentsSigners;
                    case 53841859:
                        i = -1963211797;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0075 -> 0x004c
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ͎ */
    public static java.lang.String m125(short[] r87, int r88, int r89, int r90) {
        /*
            r39 = r90
            r38 = r89
            r37 = r88
            r36 = r87
            r3 = r36
            r4 = r37
            r5 = r38
            r6 = r39
            char[] r1 = new char[r5]
            r0 = 0
        L13:
            r12 = 53937071(0x33703af, float:5.3783095E-37)
            goto L17
        L17:
            r14 = 69100(0x10dec, float:9.683E-41)
            r12 = r12 ^ r14
        L1c:
            switch(r12) {
                case -1934634591: goto L82;
                case -1087930910: goto L76;
                case 53874243: goto L20;
                default: goto L1f;
            }
        L1f:
            goto L13
        L20:
            goto L66
        L21:
            int r2 = r4 + r0
            short r2 = r3[r2]
            r2 = r2 ^ r6
            char r2 = (char) r2
            r1[r0] = r2
            int r0 = r0 + 1
        L2b:
            r12 = 53845838(0x3359f4e, float:5.337399E-37)
            goto L2f
        L2f:
            r14 = 66432(0x10380, float:9.3091E-41)
            r12 = r12 ^ r14
        L34:
            switch(r12) {
                case 53779662: goto L38;
                case 582314413: goto L87;
                default: goto L37;
            }
        L37:
            goto L2b
        L38:
            goto L5a
        L39:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L3e:
            r12 = 53846210(0x335a0c2, float:5.337566E-37)
            goto L42
        L42:
            r14 = 32967(0x80c7, float:4.6197E-41)
            r12 = r12 ^ r14
        L47:
            switch(r12) {
                case -191849242: goto L74;
                case 53813253: goto L4b;
                default: goto L4a;
            }
        L4a:
            goto L3e
        L4b:
            goto L83
        L5a:
            r12 = 582314413(0x22b569ad, float:4.9172037E-18)
            goto L34
        L5e:
            r12 = -1087930910(0xffffffffbf277de2, float:-0.65426457)
            goto L1c
        L62:
            r12 = -1934697395(0xffffffff8caedc4d, float:-2.6941534E-31)
            goto L17
        L66:
            if (r0 >= r5) goto L62
            goto L5e
        L74:
            return r0
            goto L4c
        L76:
            goto L21
        L82:
            goto L39
        L83:
            r12 = -191849242(0xfffffffff4909ce6, float:-9.1659305E31)
            goto L47
        L87:
            goto L13
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m125(short[], int, int, int):java.lang.String");
    }

    /*  JADX ERROR: Failed to set jump: 0x0021 -> 0x0016
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ͏ */
    public static java.lang.Integer m124(int r84) {
        /*
            r33 = r84
            r0 = r33
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L8:
            r6 = 53873986(0x3360d42, float:5.350021E-37)
            goto Lc
        Lc:
            r8 = 91176(0x16428, float:1.27765E-40)
            r6 = r6 ^ r8
        L11:
            switch(r6) {
                case 53963114: goto L15;
                case 2044410685: goto L20;
                default: goto L14;
            }
        L14:
            goto L8
        L15:
            goto L22
        L20:
            return r0
            goto L16
        L22:
            r6 = 2044410685(0x79db3b3d, float:1.4228931E35)
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m124(int):java.lang.Integer");
    }

    /* renamed from: ͐ */
    public static ClassLoader m123(Object obj) {
        ClassLoader classLoader = ((Class) obj).getClassLoader();
        while (true) {
            int i = 53874017 ^ 82726;
            while (true) {
                switch (i) {
                    case 53956167:
                        i = 1750869680;
                    case 1750869680:
                        return classLoader;
                }
            }
        }
    }

    /* renamed from: ͑ */
    public static boolean m122(Object obj) {
        boolean exists = ((File) obj).exists();
        while (true) {
            int i = 53874048 ^ 75239;
            while (true) {
                switch (i) {
                    case 53946471:
                        i = 1457605104;
                    case 1457605104:
                        return exists;
                }
            }
        }
    }

    /* renamed from: ͒ */
    public static Method m121(Object obj, Object obj2, Object obj3) {
        Method method = ((Class) obj).getMethod((String) obj2, (Class[]) obj3);
        while (true) {
            int i = 53874079 ^ 54146;
            while (true) {
                switch (i) {
                    case -1688624195:
                        return method;
                    case 53927453:
                        i = -1688624195;
                }
            }
        }
    }

    /* renamed from: ͓ */
    public static boolean m120(Object obj) {
        boolean hasNext = ((Iterator) obj).hasNext();
        while (true) {
            int i = 53874110 ^ 32261;
            while (true) {
                switch (i) {
                    case -1982068539:
                        return hasNext;
                    case 53900219:
                        i = -1982068539;
                }
            }
        }
    }

    /* renamed from: ͔ */
    public static void m119(Object obj, Object obj2, Object obj3) {
        ((Field) obj).set(obj2, obj3);
        while (true) {
            int i = 53874141 ^ 5767;
            while (true) {
                switch (i) {
                    case 53877594:
                        i = 2019519430;
                    case 2019519430:
                        return;
                }
            }
        }
    }

    /*  JADX ERROR: Failed to set jump: 0x0023 -> 0x0018
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.addJump(ProcessInstructionsVisitor.java:144)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.initJumps(ProcessInstructionsVisitor.java:73)
        	at jadx.core.dex.visitors.ProcessInstructionsVisitor.visit(ProcessInstructionsVisitor.java:40)
        */
    /* renamed from: ͕ */
    public static java.lang.String m118(java.lang.Object r84) {
        /*
            r33 = r84
            r0 = r33
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r0 = r0.getPackageName()
        La:
            r6 = 53845590(0x3359e56, float:5.337288E-37)
            goto Le
        Le:
            r8 = 65353(0xff49, float:9.1579E-41)
            r6 = r6 ^ r8
        L13:
            switch(r6) {
                case 53829919: goto L17;
                case 1487324983: goto L22;
                default: goto L16;
            }
        L16:
            goto La
        L17:
            goto L24
        L22:
            return r0
            goto L18
        L24:
            r6 = 1487324983(0x58a6c737, float:1.46699641E15)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m118(java.lang.Object):java.lang.String");
    }

    /* renamed from: ͗ */
    public static int m116(Object obj) {
        int hashCode = obj.hashCode();
        while (true) {
            int i = 53938032 ^ 35211;
            while (true) {
                switch (i) {
                    case 53972731:
                        i = 1533273916;
                    case 1533273916:
                        return hashCode;
                }
            }
        }
    }

    /* renamed from: ͚ */
    public static boolean m113() {
        while (true) {
            int i = 53875009 ^ 93479;
            while (true) {
                switch (i) {
                    case 53967974:
                        i = 2038357784;
                    case 2038357784:
                        return false;
                }
            }
        }
    }

    /* renamed from: ͗ */
    public static Class<?> m115(String str) throws ClassNotFoundException {
        Class<?> cls = Class.forName(str);
        while (true) {
            int i = 53846799 ^ 39678;
            while (true) {
                switch (i) {
                    case 53819889:
                        i = 1163078315;
                    case 1163078315:
                        return cls;
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: ̷ */
    public static java.lang.String m143(java.lang.Object r93) {
        /*
            r42 = r93
            r9 = r42
            r0 = r9
            r4 = r0
            java.lang.Class r4 = (java.lang.Class) r4
            java.lang.String r4 = r4.getName()
            r2 = r4
            r4 = r2
            byte[] r4 = r4.getBytes()
            r5 = 0
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r5)
            java.lang.String r4 = r4.trim()
            int r4 = r4.hashCode()
            short[] r58 = np.manager.C2880.f4535
            r61 = 1755000(0x1ac778, float:2.459279E-39)
            java.lang.String r57 = "ۦۖۗ"
            int r57 = m116(r57)
            r61 = r61 ^ r57
            r59 = 1748420(0x1aadc4, float:2.450058E-39)
            java.lang.String r57 = "ۡۙۜ"
            int r57 = m116(r57)
            r59 = r59 ^ r57
            r60 = 1758967(0x1ad6f7, float:2.464838E-39)
            java.lang.String r57 = "۬ۘۗ"
            int r57 = m116(r57)
            r60 = r60 ^ r57
            java.lang.String r58 = m114(r58, r59, r60, r61)
            r5 = r58
            int r5 = r5.hashCode()
        L4c:
            r15 = 53935149(0x336fc2d, float:5.3774477E-37)
            goto L50
        L50:
            r17 = 79046(0x134c6, float:1.10767E-40)
            r15 = r15 ^ r17
        L55:
            switch(r15) {
                case -1228610870: goto Lec;
                case 53987563: goto L59;
                case 1658617613: goto Ld4;
                default: goto L58;
            }
        L58:
            goto L4c
        L59:
            goto Lbe
        L5a:
            java.lang.String r4 = new java.lang.String
            r8 = r4
            r4 = r8
            r5 = r8
            short[] r51 = np.manager.C2880.f4535
            r54 = 1757888(0x1ad2c0, float:2.463326E-39)
            java.lang.String r50 = "۫ۥۙ"
            int r50 = m116(r50)
            r54 = r54 ^ r50
            r52 = 1752185(0x1abc79, float:2.455334E-39)
            java.lang.String r50 = "ۥۖۖ"
            int r50 = m116(r50)
            r52 = r52 ^ r50
            r53 = 1738322(0x1a8652, float:2.435908E-39)
            java.lang.String r50 = "ۖۨ۠"
            int r50 = m116(r50)
            r53 = r53 ^ r50
            java.lang.String r51 = m114(r51, r52, r53, r54)
            r6 = r51
            r7 = 0
            byte[] r6 = android.util.Base64.decode(r6, r7)
            r5.<init>(r6)
            r0 = r4
        L91:
            r15 = 53843916(0x33597cc, float:5.3365374E-37)
            goto L95
        L95:
            r17 = 19689(0x4ce9, float:2.759E-41)
            r15 = r15 ^ r17
        L9a:
            switch(r15) {
                case -2023757246: goto Ld5;
                case 53861157: goto L9e;
                default: goto L9d;
            }
        L9d:
            goto L91
        L9e:
            goto Ld9
        L9f:
            r4 = r2
            r0 = r4
        La1:
            r15 = 53844288(0x3359940, float:5.336704E-37)
            goto La5
        La5:
            r17 = 36995(0x9083, float:5.1841E-41)
            r15 = r15 ^ r17
        Laa:
            switch(r15) {
                case 53807555: goto Lae;
                case 1497090076: goto Ld7;
                default: goto Lad;
            }
        Lad:
            goto La1
        Lae:
            goto Lc5
        Laf:
        Lb0:
            r15 = -1228610870(0xffffffffb6c4e2ca, float:-5.867657E-6)
            goto L55
        Lbe:
            if (r4 == r5) goto Lc1
            goto Lb0
        Lc1:
            r15 = 1658670027(0x62dd4bcb, float:2.041096E21)
            goto L50
        Lc5:
            r15 = 1497090076(0x593bc81c, float:3.3034902E15)
            goto Laa
        Ld4:
            goto L9f
        Ld5:
            return r0
            goto L9f
        Ld7:
            goto L91
            goto Laf
        Ld9:
            r15 = -2023757246(0xffffffff875fea42, float:-1.6845498E-34)
            goto L9a
        Lec:
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m143(java.lang.Object):java.lang.String");
    }

    /* renamed from: ͖ */
    public static String m117(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            charArray[i] = (char) (charArray[i] ^ 27016);
            if (i + 1 < charArray.length) {
                i++;
                charArray[i] = (char) (charArray[i] ^ i);
            }
            i++;
        }
        return new String(charArray);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: ͗ */
    public static java.lang.String m114(short[] r87, int r88, int r89, int r90) {
        /*
            r39 = r90
            r38 = r89
            r37 = r88
            r36 = r87
            r3 = r36
            r4 = r37
            r5 = r38
            r6 = r39
            char[] r1 = new char[r5]
            r0 = 0
        L13:
            r12 = 53847171(0x335a483, float:5.337997E-37)
            goto L17
        L17:
            r14 = 22227(0x56d3, float:3.1147E-41)
            r12 = r12 ^ r14
        L1c:
            switch(r12) {
                case -1815502693: goto L6a;
                case -1707140652: goto L7e;
                case 53867088: goto L20;
                default: goto L1f;
            }
        L1f:
            goto L13
        L20:
            goto L4d
        L21:
            int r2 = r4 + r0
            short r2 = r3[r2]
            r2 = r2 ^ r6
            char r2 = (char) r2
            r1[r0] = r2
            int r0 = r0 + 1
        L2b:
            r12 = 53874947(0x3361103, float:5.350452E-37)
            goto L2f
        L2f:
            r14 = 49642(0xc1ea, float:6.9563E-41)
            r12 = r12 ^ r14
        L34:
            switch(r12) {
                case -1669765929: goto L7c;
                case 53924073: goto L38;
                default: goto L37;
            }
        L37:
            goto L2b
        L38:
            goto L62
        L39:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L3e:
            r12 = 53874978(0x3361122, float:5.350466E-37)
            goto L42
        L42:
            r14 = 72965(0x11d05, float:1.02246E-40)
            r12 = r12 ^ r14
        L47:
            switch(r12) {
                case -1963084101: goto L7a;
                case 53939239: goto L4b;
                default: goto L4a;
            }
        L4a:
            goto L3e
        L4b:
            goto L54
        L4c:
        L4d:
            if (r0 >= r5) goto L50
            goto L66
        L50:
            r12 = -1707127033(0xffffffff9a3f4f07, float:-3.9561712E-23)
            goto L17
        L54:
            r12 = -1963084101(0xffffffff8afdb6bb, float:-2.443175E-32)
            goto L47
        L62:
            r12 = -1669765929(0xffffffff9c7964d7, float:-8.251752E-22)
            goto L34
        L66:
            r12 = -1815502693(0xffffffff93c9a09b, float:-5.0897903E-27)
            goto L1c
        L6a:
            goto L21
        L7a:
            return r0
            goto L4c
        L7c:
            goto L13
            goto L39
        L7e:
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.C2880.m114(short[], int, int, int):java.lang.String");
    }
}

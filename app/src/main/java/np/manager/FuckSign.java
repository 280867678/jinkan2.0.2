package np.manager;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.util.ArrayMap;
import androidx.constraintlayout.solver.widgets.Optimizer;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.commonsdk.stateless.C1754b;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.StringFogIgnore;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@Copyright("Copyright © 2019-2020 2863678687@qq.com All Rights Reserved")
/* loaded from: classes2.dex */
public class FuckSign extends Application implements InvocationHandler {

    /* renamed from: ̅ */
    private static final short[] f4525 = {3779, -6907, -6902, -6912, -6890, -6901, -6899, -6912, -6838, -6907, -6892, -6892, -6838, -6875, -6905, -6896, -6899, -6894, -6899, -6896, -6883, -6864, -6900, -6890, -6911, -6907, -6912, -6889, -6873, -6895, -6890, -6890, -6911, -6902, -6896, -6875, -6905, -6896, -6899, -6894, -6899, -6896, -6883, -6864, -6900, -6890, -6911, -6907, -6912, 9548, -16621, -16618, -16611, -16615, -16630, -16612, -16620, -16559, -16628, -16624, -16585, -16624, -16624, -16620, -16615, -16618, -16621, -16614, -16545, -16622, -16593, -16610, -16612, -16620, -16610, -16616, -16614, -16628, -16545, -16613, -16624, -16614, -16628, -16545, -16623, -16624, -16629, -16545, -16614, -16633, -16618, -16628, -16629, -16559, -16595, -16614, -16613, -16618, -16627, -16614, -16612, -16629, -16545, -16610, -16625, -16620, -16545, -16628, -16630, -16612, -16612, -16614, -16628, -16628, -16559, -16622, -16578, -16625, -16625, -16581, -16618, -16627, -16610, -16621, -16621, -16622, -16578, -16625, -16625, -16621, -16618, -16612, -16610, -16629, -16618, -16624, -16623, -16586, -16623, -16615, -16624, -16622, -16595, -16614, -16628, -16581, -16618, -16627, 4196, -26577, -26590, -26582, -26587, -26572, 8024, 27321, 27316, 27324, 27315, 27298, 4824, 14404, 14408, 14410, 14345, 14422, 14414, 14409, 14400, 14430, 14418, 14345, 14433, 14418, 14404, 14412, 14452, 14414, 14400, 14409, 14413, 14406, 14417, 14406, 14345, 14411, 14406, 14409, 14400, 14345, 14452, 14430, 14420, 14419, 14402, 14410, 14400, 14402, 14419, 14438, 14409, 14409, 14408, 14419, 14406, 14419, 14414, 14408, 14409, 14420, 14402, 14431, 14414, 14419, 14413, 14406, 14417, 14406, 14345, 14411, 14406, 14409, 14400, 14345, 14452, 14430, 14420, 14419, 14402, 14410, 14422, 14430, 14410, 14406, 14345, 14430, 14430, 14430, 14402, 14431, 14414, 14419, 14410, 14437, 14408, 14418, 14409, 14403, 14438, 14423, 14423, 14411, 14414, 14404, 14406, 14419, 14414, 14408, 14409, 14414, 14409, 14401, 14408, 14410, 14438, 14423, 14423, 14411, 14414, 14404, 14406, 14419, 14414, 14408, 14409, 14410, 14446, 14409, 14414, 14419, 14414, 14406, 14411, 14438, 14423, 14423, 14411, 14414, 14404, 14406, 14419, 14414, 14408, 14409, 14410, 14438, 14411, 14411, 14438, 14423, 14423, 14411, 14414, 14404, 14406, 14419, 14414, 14408, 14409, 14420, 14410, 14438, 14423, 14423, 14411, 14414, 14404, 14406, 14419, 14414, 14408, 14409, 14446, 14409, 14401, 14408, 14406, 14423, 14423, 14446, 14409, 14401, 14408, 14410, 14406, 14412, 14402, 14438, 14423, 14423, 14411, 14414, 14404, 14406, 14419, 14414, 14408, 14409, 14410, 14446, 14409, 14414, 14419, 14414, 14406, 14411, 14438, 14423, 14423, 14411, 14414, 14404, 14406, 14419, 14414, 14408, 14409, 14410, 14455, 14421, 14408, 14417, 14414, 14403, 14402, 14421, 14442, 14406, 14423, 14453, 14402, 14403, 14414, 14421, 14402, 14404, 14419, 14343, 14406, 14423, 14423, 14343, 14420, 14418, 14404, 14404, 14402, 14420, 14420, 14345, 14410, 14443, 14408, 14404, 14406, 14411, 14455, 14421, 14408, 14417, 14414, 14403, 14402, 14421, 14410, 14436, 14408, 14409, 14419, 14402, 14431, 14419, 6261, -31643, -32333, -31643, -32333, -31643, -32333, -31643, -32333, -31643, -32333, 5311, -4013, -3972, -4015, -4021, -4016, -4006, -3969, -4018, -4018, -4014, -4009, -4003, -4001, -4022, -4009, -4015, -4016, -4009, -4016, -4008, -4015, -4013, -3977, -4016, -4009, -4022, -4009, -4001, -4014, -3969, -4018, -4018, -4014, -4009, -4003, -4001, -4022, -4009, -4015, -4016, -4013, -3969, -4018, -4018, -4014, -4009, -4003, -4001, -4022, -4009, -4015, -4016, 4720, 23723, 23702, 23688, 23731, 23700, 23700, 23696, 23771, 23709, 23706, 23698, 23703, 23710, 23711, 23765, 23697, 23706, 23693, 23706, 23765, 23703, 23706, 23701, 23708, 23765, 23720, 23682, 23688, 23695, 23710, 23702, 23704, 23700, 23702, 23765, 23690, 23698, 23701, 23708, 23682, 23694, 23765, 23704, 23701, 23709, 23698, 23683, 23710, 23683, 23698, 23695, 23719, 23701, 23793, 23688, 23723, 23706, 23704, 23696, 23706, 23708, 23710, 23734, 23706, 23701, 23706, 23708, 23710, 23689, 23706, 23701, 23711, 23689, 23700, 23698, 23711, 23765, 23704, 23700, 23701, 23695, 23710, 23701, 23695, 23765, 23691, 23702, 23765, 23730, 23723, 23706, 23704, 23696, 23706, 23708, 23710, 23734, 23706, 23701, 23706, 23708, 23710, 23689, 23702, 23723, 23734, 23723, 23702, 23688, 23731, 23700, 23700, 23696, 23771, 23688, 23694, 23704, 23704, 23710, 23688, 23688, 23765, 9691, -11675, -11673, -11658, -11694, -11677, -11679, -11671, -11677, -11675, -11673, -11701, -11668, -11676, -11667, 2949, 1113, 1110, 1116, 1098, 1111, 1105, 1116, 1046, 1113, 1096, 1096, 1046, 1145, 1096, 1096, 1108, 1105, 1115, 1113, 1100, 1105, 1111, 1110};

    /* renamed from: ̍ */
    private String f4526 = "";

    /* renamed from: ̎ */
    private byte[][] f4527;

    /* renamed from: ̐ */
    private Application f4528;

    /* renamed from: ̒ */
    private Object f4529;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x014d, code lost:
        r9 = "ۘۗۡ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0132, code lost:
        r9 = "ۨۘۗ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
        r9 = "۬ۢ۠";
     */
    /* renamed from: ̎ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object m183() {
        String str;
        Object obj = null;
        short[] sArr = null;
        char c = 0;
        short s = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        short s2 = 0;
        int i4 = 0;
        String str2 = "ۡۧۗ";
        while (true) {
            int m59 = C2881.m59(str2);
            while (true) {
                switch (m59) {
                    case 1739714:
                        if (!C2880.f4534) {
                            str2 = "ۤۢۨ";
                            break;
                        } else {
                            break;
                        }
                    case 1740014:
                        if (C2881.f4537) {
                            break;
                        } else {
                            str = "ۡۛۖ";
                            m59 = C2880.m150(str);
                        }
                    case 1740183:
                        if (!C2881.m111()) {
                            break;
                        } else {
                            str = "ۧۙۨ";
                            m59 = C2880.m150(str);
                        }
                    case 1740676:
                        C2880.m148();
                        C2881.m111();
                        break;
                    case 1742758:
                        i4 = 37663;
                        break;
                    case 1743026:
                        if (C2881.m111()) {
                            str2 = "ۦۜۗ";
                            break;
                        } else {
                            break;
                        }
                    case 1743583:
                        C2880.m148();
                        if (C2880.m148()) {
                            break;
                        }
                        str = "ۙۗۢ";
                        m59 = C2880.m150(str);
                    case 1748323:
                        C2881.m111();
                        if (!C2881.m111()) {
                            str2 = "ۜۘۛ";
                            break;
                        } else {
                            break;
                        }
                    case 1748356:
                        int i5 = i + i2;
                        int i6 = i5 + i5;
                        if (C2881.f4537) {
                            break;
                        } else {
                            m59 = C2880.m150("۫ۥۢ");
                            i3 = i6;
                        }
                    case 1748364:
                        short s3 = sArr[c];
                        if (C2881.f4537) {
                            break;
                        } else {
                            m59 = C2881.m59("ۤ۬ۜ");
                            s = s3;
                        }
                    case 1748476:
                        if (!C2880.m148()) {
                            break;
                        } else {
                            m59 = C2881.m59("ۡۗۢ");
                            c = 0;
                        }
                    case 1748516:
                        obj = C2881.m112();
                        str = "ۦۦۘ";
                        m59 = C2880.m150(str);
                    case 1748849:
                        short[] sArr2 = f4525;
                        if (!C2881.m111()) {
                            break;
                        } else {
                            m59 = C2881.m59("۬ۗۥ");
                            sArr = sArr2;
                        }
                    case 1751594:
                        C2880.m148();
                        if (!C2880.m148()) {
                            str2 = "ۘۦۥ";
                            break;
                        }
                        str = "ۙۗۢ";
                        m59 = C2880.m150(str);
                    case 1753313:
                        if (C2881.f4537) {
                            break;
                        } else {
                            str = "ۘۡۗ";
                            m59 = C2880.m150(str);
                        }
                    case 1753624:
                        return obj;
                    case 1754198:
                        if (C2880.f4534) {
                            break;
                        }
                        str = "ۙۗۢ";
                        m59 = C2880.m150(str);
                    case 1755111:
                        C2880.m148();
                        return null;
                    case 1755560:
                        int i7 = s + s2;
                        if ((i7 * i7) - i3 <= 0) {
                            str2 = "۫۬ۥ";
                            break;
                        } else {
                            str2 = "ۛۜۧ";
                            break;
                        }
                    case 1758408:
                        if (!C2880.m148()) {
                            break;
                        } else {
                            m59 = C2880.m150("ۨۦۦ");
                            s2 = 18595;
                        }
                    case 1758628:
                        i4 = 58724;
                        break;
                    case 1758938:
                        if (!C2880.f4534) {
                            str2 = "ۛۥۜ";
                            break;
                        }
                        str = "ۙۗۢ";
                        m59 = C2880.m150(str);
                    case 1759274:
                        try {
                            Field m164 = C2880.m164(C2880.m166(C2881.m90(f4525, 1, 26, i4)), C2881.m90(f4525, 27, 22, i4));
                            C2880.m127(m164, true);
                            obj = C2880.m165(m164, null);
                            str = "ۦۦۘ";
                            m59 = C2880.m150(str);
                        } catch (Throwable unused) {
                            str2 = "ۡۜ۟";
                            break;
                        }
                    default:
                        int i8 = s * s;
                        if (!C2881.m111()) {
                            break;
                        } else {
                            i2 = 345774025;
                            m59 = C2880.m150("ۡۗۚ");
                            i = i8;
                        }
                }
            }
            str2 = "ۡۖۘ";
        }
    }

    /* renamed from: ̐ */
    private final void m182(Context context) {
        String str;
        Map map;
        String str2;
        File file;
        String str3;
        String str4;
        Object m142;
        boolean z = false;
        String str5 = null;
        Map map2 = null;
        Iterator it = null;
        boolean z2 = false;
        String str6 = null;
        boolean z3 = false;
        Object obj = null;
        boolean z4 = false;
        int i = 0;
        int m150 = C2880.m150("ۨۥۙ");
        File file2 = null;
        Object th = null;
        while (true) {
            switch (m150) {
                case 1739776:
                    m180(C2880.m136(th));
                    throw new RuntimeException(C2881.m106(th));
                case 1740356:
                    try {
                        m174(obj, C2880.m125(f4525, 141, 7, i), str5);
                    } catch (Throwable th2) {
                        th = th2;
                        file = file2;
                        str = str5;
                        map = map2;
                        str4 = "ۘۙۡ";
                        m150 = C2881.m59(str4);
                        map2 = map;
                        str5 = str;
                        file2 = file;
                    }
                case 1746436:
                    file = file2;
                    str = str5;
                    map = map2;
                    if (!z) {
                        str4 = "۬ۗ۫";
                        m150 = C2881.m59(str4);
                        map2 = map;
                        str5 = str;
                        file2 = file;
                    } else {
                        str3 = "ۡۘۙ";
                        m150 = C2880.m150(str3);
                        map2 = map;
                        str5 = str;
                        file2 = file;
                    }
                case 1746539:
                    str = str5;
                    map = map2;
                    if (z2) {
                        m150 = C2880.m150("ۧۘۡ");
                        map2 = map;
                        str5 = str;
                    }
                    str2 = "ۦۛۥ";
                    m150 = C2881.m59(str2);
                    map2 = map;
                    str5 = str;
                case 1747715:
                    file = file2;
                    str = str5;
                    map = map2;
                    i = 49023;
                    str3 = "ۦۗۨ";
                    m150 = C2880.m150(str3);
                    map2 = map;
                    str5 = str;
                    file2 = file;
                case 1748386:
                    str = str5;
                    map = map2;
                    str5 = C2880.m157(file2);
                    Object m183 = m183();
                    file = file2;
                    try {
                        Field m74 = C2881.m74(C2881.m83(m183), C2880.m125(f4525, 69, 9, i));
                        C2880.m127(m74, true);
                        Map map3 = (Map) C2881.m105(m74, m183);
                        it = C2880.m144(C2880.m134(map3));
                        map2 = map3;
                        m150 = C2880.m150("ۧۧۦ");
                    } catch (Throwable th3) {
                        th = th3;
                        str4 = "ۘۙۡ";
                        m150 = C2881.m59(str4);
                        map2 = map;
                        str5 = str;
                        file2 = file;
                    }
                    file2 = file;
                case 1749012:
                    String str7 = str5;
                    Map map4 = map2;
                    m181(C2880.m125(f4525, 94, 21, i));
                    file = file2;
                    map2 = map4;
                    str5 = str7;
                    m150 = C2880.m150("ۧۧۦ");
                    file2 = file;
                case 1752539:
                    ApplicationInfo applicationInfo = (ApplicationInfo) m178(obj, C2881.m90(f4525, 125, 16, i));
                    applicationInfo.publicSourceDir = str5;
                    applicationInfo.sourceDir = str5;
                    str = str5;
                    map = map2;
                    str2 = "ۡ۬۟";
                    m150 = C2881.m59(str2);
                    map2 = map;
                    str5 = str;
                case 1753175:
                    str = str5;
                    map = map2;
                    file2 = new File(C2881.m100(context).nativeLibraryDir, C2881.m90(f4525, 50, 10, i));
                    z = C2880.m122(file2);
                    str2 = "۟ۗۜ";
                    m150 = C2881.m59(str2);
                    map2 = map;
                    str5 = str;
                case 1753221:
                    file = file2;
                    str = str5;
                    map = map2;
                    i = 44538;
                    str3 = "ۦۗۨ";
                    m150 = C2880.m150(str3);
                    map2 = map;
                    str5 = str;
                    file2 = file;
                case 1753296:
                    return;
                case 1754160:
                    str = str5;
                    map = map2;
                    String str8 = (String) C2880.m163(it);
                    z3 = C2880.m140(str8, C2880.m118(context));
                    m150 = C2881.m59("ۧۚ۬");
                    str6 = str8;
                    map2 = map;
                    str5 = str;
                case 1754233:
                    str = str5;
                    map = map2;
                    if (z3) {
                        str2 = "ۨۛۥ";
                        m150 = C2881.m59(str2);
                        map2 = map;
                        str5 = str;
                    }
                    str2 = "ۡ۬۟";
                    m150 = C2881.m59(str2);
                    map2 = map;
                    str5 = str;
                case 1755218:
                    try {
                        m142 = C2880.m142((WeakReference) C2880.m130(map2, str6));
                        map = map2;
                    } catch (Throwable th4) {
                        th = th4;
                        str = str5;
                        map = map2;
                    }
                    try {
                        m174(m142, C2880.m125(f4525, 115, 7, i), str5);
                        str = str5;
                        z4 = C2880.m140(m173(DATA.f4532), C2881.m90(f4525, 122, 3, i));
                        obj = m142;
                        map2 = map;
                        m150 = C2880.m150("۫ۢ۟");
                        str5 = str;
                    } catch (Throwable th5) {
                        th = th5;
                        str = str5;
                        file = file2;
                        str4 = "ۘۙۡ";
                        m150 = C2881.m59(str4);
                        map2 = map;
                        str5 = str;
                        file2 = file;
                    }
                case 1755516:
                    file = file2;
                    str = str5;
                    map = map2;
                    short s = f4525[49];
                    int i2 = s + 13309;
                    int i3 = (s * s) + 177129481;
                    if ((i2 * i2) - (i3 + i3) > 0) {
                        str4 = "ۦۙۘ";
                        m150 = C2881.m59(str4);
                        map2 = map;
                        str5 = str;
                        file2 = file;
                    } else {
                        str3 = "۠ۡۤ";
                        m150 = C2880.m150(str3);
                        map2 = map;
                        str5 = str;
                        file2 = file;
                    }
                case 1758312:
                    m150 = z4 ? C2881.m59("ۘ۬ۘ") : C2880.m150("ۥۢۘ");
                case 1758944:
                    str = str5;
                    map = map2;
                    m180(C2881.m106(C2881.m109(C2880.m171(C2881.m109(new StringBuilder(), C2880.m125(f4525, 60, 9, i)), file2), C2880.m125(f4525, 78, 16, i))));
                    str2 = "ۦۛۥ";
                    m150 = C2881.m59(str2);
                    map2 = map;
                    str5 = str;
                default:
                    str = str5;
                    map = map2;
                    try {
                        z2 = C2880.m120(it);
                        str2 = "۟ۚۦ";
                        m150 = C2881.m59(str2);
                        map2 = map;
                        str5 = str;
                    } catch (Throwable th6) {
                        th = th6;
                        file = file2;
                        str4 = "ۘۙۡ";
                        m150 = C2881.m59(str4);
                        map2 = map;
                        str5 = str;
                        file2 = file;
                    }
            }
        }
    }

    @TargetApi(19)
    /* renamed from: ̔ */
    private Application m179() {
        Object obj;
        char c;
        Application application;
        String str;
        String str2;
        Class cls;
        Application application2;
        String str3;
        int m150;
        String str4;
        String str5;
        String str6;
        int m59;
        FuckSign fuckSign = this;
        int m592 = C2881.m59("۫ۨۧ");
        Application application3 = null;
        Iterator it = null;
        ArrayList arrayList = null;
        Object th = null;
        int i = 0;
        Application application4 = null;
        Object obj2 = null;
        Application application5 = null;
        Object obj3 = null;
        Application application6 = null;
        Object obj4 = null;
        Class cls2 = null;
        Object obj5 = null;
        char c2 = 0;
        boolean z = false;
        while (true) {
            switch (m592) {
                case 1738043:
                    obj = th;
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    if (application4.length != 0) {
                        str3 = "۠۟ۘ";
                        m150 = C2880.m150(str3);
                        cls2 = cls;
                        application5 = application2;
                        c2 = c;
                        m592 = m150;
                        th = obj;
                    }
                    str3 = "ۡۚۜ";
                    m150 = C2880.m150(str3);
                    cls2 = cls;
                    application5 = application2;
                    c2 = c;
                    m592 = m150;
                    th = obj;
                case 1738260:
                    obj = th;
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    if (application4 != null) {
                        str3 = "ۖ۟ۤ";
                        m150 = C2880.m150(str3);
                        cls2 = cls;
                        application5 = application2;
                        c2 = c;
                        m592 = m150;
                        th = obj;
                    }
                    str3 = "ۡۚۜ";
                    m150 = C2880.m150(str3);
                    cls2 = cls;
                    application5 = application2;
                    c2 = c;
                    m592 = m150;
                    th = obj;
                case 1738313:
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    obj5 = C2881.m104(it);
                    str5 = "ۜۘۘ";
                    m59 = C2881.m59(str5);
                    cls2 = cls;
                    application5 = application2;
                    m592 = m59;
                    c2 = c;
                case 1738751:
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    if (z) {
                        str6 = "ۖۨۛ";
                        m59 = C2880.m150(str6);
                        cls2 = cls;
                        application5 = application2;
                        m592 = m59;
                        c2 = c;
                    } else {
                        str5 = "ۧۦ۠";
                        m59 = C2881.m59(str5);
                        cls2 = cls;
                        application5 = application2;
                        m592 = m59;
                        c2 = c;
                    }
                case 1740214:
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    obj = th;
                    Method m169 = C2880.m169(C2881.m83(obj2), C2881.m90(f4525, 333, 15, i), new Class[]{Boolean.TYPE, Instrumentation.class});
                    C2881.m79(m169, true);
                    Application application7 = (Application) C2880.m153(m169, obj2, new Object[]{C2880.m155(false), null});
                    fuckSign.m174(obj3, C2880.m125(f4525, 348, 19, i), application7);
                    C2881.m70(arrayList, application7);
                    application6 = application7;
                    it = C2880.m132(C2880.m133((ArrayMap) fuckSign.m178(obj3, C2881.m90(f4525, 367, 12, i))));
                    str4 = "ۢۤۤ";
                    m150 = C2881.m59(str4);
                    cls2 = cls;
                    application5 = application2;
                    c2 = c;
                    m592 = m150;
                    th = obj;
                case 1741133:
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    obj4 = fuckSign.m178(obj5, C2880.m125(f4525, 400, 14, i));
                    str5 = "ۢۜۚ";
                    m59 = C2881.m59(str5);
                    cls2 = cls;
                    application5 = application2;
                    m592 = m59;
                    c2 = c;
                case 1741673:
                    obj = th;
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    obj3 = m183();
                    Object m178 = fuckSign.m178(obj3, C2880.m125(f4525, TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION, 17, i));
                    obj2 = fuckSign.m178(m178, C2881.m90(f4525, 259, 4, i));
                    fuckSign.m174(obj2, C2880.m125(f4525, Optimizer.OPTIMIZATION_STANDARD, 12, i), application3);
                    Object m1782 = fuckSign.m178(obj3, C2881.m90(f4525, C1754b.f4002g, 19, i));
                    arrayList = (ArrayList) fuckSign.m178(obj3, C2881.m90(f4525, 294, 16, i));
                    C2881.m81(arrayList, m1782);
                    ((ApplicationInfo) fuckSign.m178(obj2, C2881.m90(f4525, 310, 16, i))).className = fuckSign.m173(DATA.f4531);
                    ((ApplicationInfo) fuckSign.m178(m178, C2880.m125(f4525, TbsListener.ErrorCode.TEST_THROWABLE_IS_NULL, 7, i))).className = fuckSign.m173(DATA.f4531);
                    str4 = "ۘۧۥ";
                    m150 = C2881.m59(str4);
                    cls2 = cls;
                    application5 = application2;
                    c2 = c;
                    m592 = m150;
                    th = obj;
                case 1742631:
                    cls = cls2;
                    try {
                        application2 = application5;
                        c = c2;
                        fuckSign.m174(obj4, C2881.m90(f4525, 414, 8, i), application6);
                        obj = th;
                        str4 = "ۢۤۤ";
                        m150 = C2881.m59(str4);
                        cls2 = cls;
                        application5 = application2;
                        c2 = c;
                        m592 = m150;
                        th = obj;
                    } catch (Throwable th2) {
                        th = th2;
                        c = c2;
                        application2 = application5;
                        str6 = "۟ۜۨ";
                        m59 = C2880.m150(str6);
                        cls2 = cls;
                        application5 = application2;
                        m592 = m59;
                        c2 = c;
                    }
                case 1743113:
                    obj = th;
                    c = c2;
                    application = application5;
                    i = 54192;
                    str2 = "۫ۘۚ";
                    m592 = C2880.m150(str2);
                    fuckSign = this;
                    application5 = application;
                    c2 = c;
                    th = obj;
                case 1743580:
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    if (obj5 != null) {
                        str5 = "ۙۦۚ";
                        m59 = C2881.m59(str5);
                        cls2 = cls;
                        application5 = application2;
                        m592 = m59;
                        c2 = c;
                    } else {
                        obj = th;
                        str4 = "ۢۤۤ";
                        m150 = C2881.m59(str4);
                        cls2 = cls;
                        application5 = application2;
                        c2 = c;
                        m592 = m150;
                        th = obj;
                    }
                case 1743644:
                    obj = th;
                    c = c2;
                    application = application5;
                    cls2 = C2880.m158(this);
                    str = "ۡ۠ۧ";
                    m592 = C2881.m59(str);
                    fuckSign = this;
                    application5 = application;
                    c2 = c;
                    th = obj;
                case 1746603:
                    fuckSign.m180(C2880.m136(th));
                    throw new RuntimeException(C2881.m106(th));
                case 1747641:
                    obj = th;
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    if (C2880.m138(C2881.m106(application4[c]), C2881.m90(f4525, TbsListener.ErrorCode.RENAME_SUCCESS, 8, i))) {
                        str4 = "ۚۘۧ";
                        m150 = C2881.m59(str4);
                        cls2 = cls;
                        application5 = application2;
                        c2 = c;
                        m592 = m150;
                        th = obj;
                    }
                    str3 = "ۡۚۜ";
                    m150 = C2880.m150(str3);
                    cls2 = cls;
                    application5 = application2;
                    c2 = c;
                    m592 = m150;
                    th = obj;
                case 1747657:
                    obj = th;
                    c = c2;
                    try {
                        C2880.m153(C2881.m103(C2880.m166(C2881.m90(f4525, 180, 16, i)), C2881.m90(f4525, 210, 4, i), new Class[]{Integer.TYPE}), null, new Object[]{C2880.m124(-1)});
                    } catch (Exception unused) {
                    }
                    application5 = application3;
                    m592 = C2881.m59("ۦۦۨ");
                    fuckSign = this;
                    c2 = c;
                    th = obj;
                case 1748451:
                    obj = th;
                    c = c2;
                    Class cls3 = cls2;
                    try {
                        C2881.m107(C2880.m121(C2881.m63(C2881.m90(f4525, TbsListener.ErrorCode.COPY_TMPDIR_ERROR, 16, i)), C2880.m125(f4525, TbsListener.ErrorCode.TPATCH_FAIL, 4, i), new Class[]{Integer.TYPE}), null, new Object[]{C2880.m124(-1)});
                    } catch (Exception unused2) {
                    }
                    cls2 = cls3;
                    application5 = application3;
                    m592 = C2881.m59("ۦۦۨ");
                    fuckSign = this;
                    c2 = c;
                    th = obj;
                case 1748648:
                    obj = th;
                    c = c2;
                    Class cls4 = cls2;
                    application = application5;
                    try {
                        cls2 = cls4;
                        try {
                            application4 = (Object[]) C2881.m107(C2881.m103(C2881.m83(cls4), C2880.m125(f4525, 196, 14, i), new Class[0]), cls2, new Object[0]);
                        } catch (Exception unused3) {
                            application4 = application3;
                            m592 = C2880.m150("ۖۦۤ");
                            application5 = application;
                            c2 = c;
                            th = obj;
                        }
                    } catch (Exception unused4) {
                        cls2 = cls4;
                    }
                    m592 = C2880.m150("ۖۦۤ");
                    application5 = application;
                    c2 = c;
                    th = obj;
                case 1749472:
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    if (obj4 != null) {
                        str6 = "ۛۘۤ";
                        m59 = C2880.m150(str6);
                        cls2 = cls;
                        application5 = application2;
                        m592 = m59;
                        c2 = c;
                    } else {
                        obj = th;
                        str4 = "ۢۤۤ";
                        m150 = C2881.m59(str4);
                        cls2 = cls;
                        application5 = application2;
                        c2 = c;
                        m592 = m150;
                        th = obj;
                    }
                case 1749730:
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    z = C2881.m85(it);
                    str5 = "ۗۗ۟";
                    m59 = C2881.m59(str5);
                    cls2 = cls;
                    application5 = application2;
                    m592 = m59;
                    c2 = c;
                case 1753640:
                    return application5;
                case 1757997:
                    obj = th;
                    c = c2;
                    application = application5;
                    application3 = null;
                    if (C2880.m140(C2880.m143(C2881.m83(this)), C2880.m125(f4525, 161, 19, i))) {
                        str = "۠۟ۨ";
                        m592 = C2881.m59(str);
                        fuckSign = this;
                        application5 = application;
                        c2 = c;
                        th = obj;
                    } else {
                        c2 = 0;
                        fuckSign = this;
                        m592 = C2880.m150("ۜۚۚ");
                        application5 = application;
                        th = obj;
                    }
                case 1758506:
                    obj = th;
                    c = c2;
                    application = application5;
                    short s = f4525[160];
                    if ((s * 30934) - ((s * s) + 239228089) > 0) {
                        str2 = "ۛۨۖ";
                        m592 = C2880.m150(str2);
                        fuckSign = this;
                        application5 = application;
                        c2 = c;
                        th = obj;
                    } else {
                        str = "۬۠ۚ";
                        m592 = C2881.m59(str);
                        fuckSign = this;
                        application5 = application;
                        c2 = c;
                        th = obj;
                    }
                case 1759206:
                    obj = th;
                    c = c2;
                    application = application5;
                    i = 14375;
                    str2 = "۫ۘۚ";
                    m592 = C2880.m150(str2);
                    fuckSign = this;
                    application5 = application;
                    c2 = c;
                    th = obj;
                default:
                    c = c2;
                    cls = cls2;
                    application2 = application5;
                    try {
                        fuckSign.m181(C2881.m90(f4525, 379, 21, i));
                        obj = th;
                        application5 = application6;
                        cls2 = cls;
                        m592 = C2881.m59("ۦۦۨ");
                        fuckSign = this;
                        c2 = c;
                        th = obj;
                    } catch (Throwable th3) {
                        th = th3;
                        str6 = "۟ۜۨ";
                        m59 = C2880.m150(str6);
                        cls2 = cls;
                        application5 = application2;
                        m592 = m59;
                        c2 = c;
                    }
            }
        }
    }

    /* renamed from: ̘ */
    private void m175(Context context) {
        String str;
        String str2;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        DataInputStream dataInputStream = null;
        int i2 = 0;
        int i3 = 0;
        int m150 = C2880.m150("ۙۗۢ");
        Object th = null;
        int i4 = 0;
        while (true) {
            switch (m150) {
                case 1737795:
                    return;
                case 1739222:
                    C2881.m107(C2881.m103(C2881.m63(C2880.m125(f4525, 502, 16, i)), C2880.m125(f4525, 534, 4, i), new Class[]{Integer.TYPE}), null, new Object[]{C2880.m124(-1)});
                    throw new UnsatisfiedLinkError();
                    break;
                case 1739719:
                    DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream(C2880.m146(C2881.m102(m173(DATA.f4530), C2881.m90(f4525, 538, 2, i), C2880.m125(f4525, 540, 1, i)), 0)));
                    this.f4527 = new byte[C2881.m77(dataInputStream2) & 255];
                    i3 = i4;
                    dataInputStream = dataInputStream2;
                    str = "ۥ۬ۢ";
                    m150 = C2881.m59(str);
                case 1740363:
                    if (z2) {
                        str2 = "ۗۦۥ";
                        m150 = C2880.m150(str2);
                    } else {
                        str2 = "ۘۗۦ";
                        m150 = C2880.m150(str2);
                    }
                case 1740676:
                    short s = f4525[486];
                    int i5 = s + 9455;
                    int i6 = (s * s) + 89397025;
                    str = (i6 + i6) - (i5 * i5) < 0 ? "ۡۢ۬" : "ۥۢۡ";
                    m150 = C2881.m59(str);
                case 1740928:
                    m180(C2880.m125(f4525, 487, 15, i));
                    m180(C2881.m88(th));
                    str2 = "ۖۗۤ";
                    m150 = C2880.m150(str2);
                case 1743117:
                    try {
                        this.f4527[i3] = new byte[C2881.m98(dataInputStream)];
                        C2881.m110(dataInputStream, this.f4527[i3]);
                        str = "ۢۦۥ";
                    } catch (Throwable th2) {
                        th = th2;
                        str = "ۙ۟ۦ";
                    }
                    m150 = C2881.m59(str);
                case 1744024:
                    z = C2881.m75(this.f4526, m173(DATA.f4533));
                    str2 = "ۤۨۛ";
                    m150 = C2880.m150(str2);
                case 1748715:
                    i = 3665;
                    str = "۫۠ۖ";
                    m150 = C2881.m59(str);
                case 1749793:
                    i3++;
                    str = "ۥ۬ۢ";
                    m150 = C2881.m59(str);
                case 1751767:
                    if (z) {
                        str = "۫ۗۧ";
                        m150 = C2881.m59(str);
                    } else {
                        str2 = "ۗۦۥ";
                        m150 = C2880.m150(str2);
                    }
                case 1752548:
                    i = 23803;
                    str = "۫۠ۖ";
                    m150 = C2881.m59(str);
                case 1752859:
                    i2 = this.f4527.length;
                    str = "ۥ۠۟";
                    m150 = C2881.m59(str);
                case 1752864:
                    Object m183 = m183();
                    Field m74 = C2881.m74(C2880.m158(m183), C2880.m125(f4525, 541, 15, i));
                    C2880.m127(m74, true);
                    this.f4529 = C2881.m105(m74, m183);
                    Class m166 = C2880.m166(C2880.m125(f4525, 556, 34, i));
                    Object m168 = C2880.m168(C2880.m123(m166), new Class[]{m166}, this);
                    C2881.m108(m74, m183, m168);
                    PackageManager m128 = C2880.m128(context);
                    Field m164 = C2880.m164(C2880.m158(m128), C2881.m90(f4525, 590, 3, i));
                    C2880.m127(m164, true);
                    C2880.m119(m164, m128, m168);
                    m181(C2881.m90(f4525, 593, 16, i));
                    str2 = "ۖۗۤ";
                    m150 = C2880.m150(str2);
                case 1757979:
                    z2 = C2881.m75(this.f4526, C2881.m90(f4525, 518, 16, i));
                    str = "ۘ۬۟";
                    m150 = C2881.m59(str);
                case 1758241:
                    i4 = 0;
                    str = "ۜۦۢ";
                    m150 = C2881.m59(str);
                default:
                    if (i3 < i2) {
                        str = "ۛۨۚ";
                        m150 = C2881.m59(str);
                    } else {
                        str2 = "ۥ۬ۧ";
                        m150 = C2880.m150(str2);
                    }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
        r1 = "ۦۥۘ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x000c, code lost:
        if (np.manager.C2881.f4537 == false) goto L11;
     */
    @Override // android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void attachBaseContext(Context context) {
        String str;
        String str2 = null;
        String str3 = "ۙ۫ۙ";
        while (true) {
            int m150 = C2880.m150(str3);
            while (true) {
                switch (m150) {
                    case 1740152:
                        C2880.m148();
                        C2880.m148();
                        str = "۫ۛۡ";
                        m150 = C2881.m59(str);
                    case 1740673:
                        if (!C2881.f4537) {
                            str = "ۧۧ۫";
                            m150 = C2881.m59(str);
                        }
                        str = "ۚ۟ۙ";
                        m150 = C2881.m59(str);
                    case 1741287:
                        if (C2880.m148()) {
                            str3 = "ۙۗ۟";
                            break;
                        }
                        str = "۫ۛۡ";
                        m150 = C2881.m59(str);
                    case 1741662:
                        if (C2881.m111()) {
                            str3 = "ۤۦ۟";
                            break;
                        } else {
                            break;
                        }
                    case 1741876:
                        if (!C2881.f4537) {
                            break;
                        } else {
                            break;
                        }
                    case 1742929:
                        C2881.m111();
                        if (!C2881.f4537) {
                            break;
                        }
                        str = "۫ۛۡ";
                        m150 = C2881.m59(str);
                    case 1743255:
                        this.f4526 = str2;
                        m175(context);
                        if (!C2881.f4537) {
                            str3 = "۬ۦۨ";
                            break;
                        }
                        str = "ۚ۟ۙ";
                        m150 = C2881.m59(str);
                    case 1746558:
                        if (C2881.f4537) {
                            break;
                        } else {
                            str = "ۤۙۦ";
                            m150 = C2881.m59(str);
                        }
                    case 1751313:
                        if (C2881.f4537) {
                            break;
                        } else {
                            str = "ۚۘۜ";
                            m150 = C2881.m59(str);
                        }
                    case 1751709:
                        String m118 = C2880.m118(context);
                        if (!C2881.m111()) {
                            str = "۫ۛۡ";
                            m150 = C2881.m59(str);
                        } else {
                            m150 = C2881.m59("ۛ۬ۨ");
                            str2 = m118;
                        }
                    case 1754635:
                        if (!C2881.m111()) {
                            break;
                        } else {
                            str = "ۧۨۧ";
                            m150 = C2881.m59(str);
                        }
                    case 1754662:
                        if (!C2881.f4537) {
                            str = "۟ۛۚ";
                            m150 = C2881.m59(str);
                        }
                        str = "ۚ۟ۙ";
                        m150 = C2881.m59(str);
                    case 1755593:
                        this.f4528 = m179();
                        return;
                    case 1758097:
                        C2880.m148();
                        C2880.m148();
                        return;
                    case 1759406:
                        m182(context);
                        super.attachBaseContext(context);
                        if (!C2881.f4537) {
                            str = "ۨۧۨ";
                            m150 = C2881.m59(str);
                        }
                        str = "ۘۥۥ";
                        m150 = C2881.m59(str);
                }
            }
            str3 = "ۛۢۘ";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0116, code lost:
        r12 = "ۦۧۜ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0020, code lost:
        if (np.manager.C2880.f4534 == false) goto L62;
     */
    /* renamed from: ̒ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m181(Object obj) {
        String str;
        short[] sArr = null;
        char c = 0;
        short s = 0;
        short s2 = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        short[] sArr2 = null;
        int i6 = 0;
        int i7 = 0;
        String str2 = "ۦۖۤ";
        while (true) {
            int m150 = C2880.m150(str2);
            while (true) {
                switch (m150) {
                    case 1738324:
                        if (C2880.f4534) {
                            break;
                        } else {
                            m150 = C2880.m150("ۛۛ۠");
                            i7 = 5;
                        }
                    case 1739008:
                        C2880.m148();
                        break;
                    case 1739377:
                        if (!C2880.m148()) {
                            str = "ۡۤۦ";
                            m150 = C2881.m59(str);
                        } else {
                            m150 = C2881.m59("ۜۙۦ");
                            c = 148;
                        }
                    case 1739966:
                        i5 = 39020;
                        str = "۬ۘۜ";
                        m150 = C2881.m59(str);
                    case 1740344:
                        C2881.m111();
                        return;
                    case 1742720:
                        C2880.m147(C2880.m125(sArr2, i6, i7, i5), C2880.m156(obj));
                        return;
                    case 1743625:
                        short s3 = sArr[c];
                        if (C2881.f4537) {
                            str = "ۘ۫۫";
                            m150 = C2881.m59(str);
                        } else {
                            s2 = 9655;
                            m150 = C2880.m150("ۥۤۜ");
                            s = s3;
                        }
                    case 1743645:
                        C2880.m148();
                        if (!C2880.m148()) {
                            break;
                        }
                        str = "ۘ۫۫";
                        m150 = C2881.m59(str);
                    case 1744199:
                        int i8 = i3 + i4;
                        if (i2 - (i8 + i8) <= 0) {
                            str2 = "ۘ۟ۥ";
                            break;
                        } else {
                            str2 = "۬ۗۦ";
                            break;
                        }
                    case 1748771:
                        C2881.m111();
                        if (C2881.m111()) {
                            str2 = "ۜۚۛ";
                            break;
                        } else {
                            break;
                        }
                    case 1749669:
                        if (C2881.f4537) {
                            str = "ۡۤۦ";
                            m150 = C2881.m59(str);
                        } else {
                            m150 = C2881.m59("ۜ۬ۗ");
                            i4 = 93219025;
                        }
                    case 1751672:
                        short[] sArr3 = f4525;
                        if (!C2880.m148()) {
                            str = "ۘ۫۫";
                            m150 = C2881.m59(str);
                        } else {
                            m150 = C2881.m59("ۗ۫ۥ");
                            sArr = sArr3;
                        }
                    case 1752605:
                        int i9 = s + s2;
                        if (C2880.f4534) {
                            break;
                        } else {
                            m150 = C2881.m59("ۦۧ۫");
                            i = i9;
                        }
                    case 1753140:
                        if (C2880.m148()) {
                            str = "ۦۗۨ";
                            m150 = C2881.m59(str);
                        }
                        str = "ۡۤۦ";
                        m150 = C2881.m59(str);
                    case 1753659:
                        C2880.m148();
                        C2881.m111();
                        str = "ۘ۫۫";
                        m150 = C2881.m59(str);
                    case 1753674:
                        int i10 = i * i;
                        int i11 = s * s;
                        if (C2880.f4534) {
                            break;
                        } else {
                            i3 = i11;
                            m150 = C2880.m150("ۢۢۥ");
                            i2 = i10;
                        }
                    case 1758939:
                        i5 = 1181;
                        str = "۬ۘۜ";
                        m150 = C2881.m59(str);
                    case 1758960:
                        short[] sArr4 = f4525;
                        if (!C2880.m148()) {
                            str = "ۡۤۦ";
                            m150 = C2881.m59(str);
                        } else {
                            i6 = 149;
                            m150 = C2880.m150("ۖۨۦ");
                            sArr2 = sArr4;
                        }
                    default:
                        if (C2881.f4537) {
                            break;
                        } else {
                            str = "ۤۥۙ";
                            m150 = C2881.m59(str);
                        }
                }
            }
            str2 = "ۗ۟ۨ";
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        int i;
        int i2;
        int i3;
        String str;
        int m59;
        Object obj2;
        String str2;
        String str3;
        int i4;
        short[] sArr;
        int i5;
        int m592;
        String str4;
        String str5;
        int m593;
        int m150;
        String str6;
        FuckSign fuckSign = this;
        Method method2 = method;
        int i6 = 0;
        int i7 = 0;
        PackageInfo packageInfo = null;
        int i8 = 0;
        String str7 = null;
        int i9 = 0;
        Object obj3 = null;
        Integer num = null;
        Object obj4 = null;
        Signature signature = null;
        int m594 = C2881.m59("ۨۤۢ");
        Signature[] signatureArr = null;
        PackageInfo packageInfo2 = null;
        int i10 = 0;
        int i11 = 0;
        short s = 0;
        int i12 = 0;
        short[] sArr2 = null;
        byte[][] bArr = null;
        while (true) {
            switch (m594) {
                case 1737754:
                    if (!C2881.m111()) {
                        str6 = "ۢ۬ۜ";
                        m594 = C2881.m59(str6);
                    } else {
                        i = i11;
                        i3 = i9;
                        i4 = i12;
                        i5 = i8;
                        sArr = sArr2;
                        str5 = "۠ۨۘ";
                        m150 = C2881.m59(str5);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    }
                case 1737945:
                    i = i11;
                    i3 = i9;
                    i4 = i12;
                    i5 = i8;
                    sArr = sArr2;
                    short[] sArr3 = f4525;
                    if (!C2880.m148()) {
                        str5 = "ۜ۫ۡ";
                        m150 = C2881.m59(str5);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    } else {
                        m594 = C2881.m59("ۥۗۖ");
                        fuckSign = this;
                        sArr2 = sArr3;
                        i12 = i4;
                        i11 = i;
                        i6 = 0;
                        i8 = 610;
                        i9 = 14;
                        method2 = method;
                    }
                case 1739086:
                    i = i11;
                    i3 = i9;
                    i4 = i12;
                    i5 = i8;
                    sArr = sArr2;
                    if (C2881.m111()) {
                        str4 = "ۦۖۢ";
                        m150 = C2880.m150(str4);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    }
                    str5 = "۠ۨۘ";
                    m150 = C2881.m59(str5);
                    method2 = method;
                    i12 = i4;
                    sArr2 = sArr;
                    i8 = i5;
                    i9 = i3;
                    i11 = i;
                    m594 = m150;
                    fuckSign = this;
                case 1739393:
                    i = i11;
                    i2 = i8;
                    i3 = i9;
                    if (Build.VERSION.SDK_INT >= 28) {
                        str = "ۛۧ۬";
                        m592 = C2881.m59(str);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    } else {
                        i4 = i12;
                        sArr = sArr2;
                        i5 = i2;
                        str5 = "ۨۘۙ";
                        m150 = C2881.m59(str5);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    }
                case 1740369:
                    i = i11;
                    i3 = i9;
                    i4 = i12;
                    i5 = i8;
                    sArr = sArr2;
                    int i13 = (s * s) + 274664329;
                    if (C2880.f4534) {
                        str4 = "۟ۥۙ";
                        m150 = C2880.m150(str4);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    } else {
                        m593 = C2880.m150("ۨۢۗ");
                        i10 = i13;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        fuckSign = this;
                        m594 = m593;
                        method2 = method;
                    }
                case 1740649:
                    i2 = i8;
                    i3 = i9;
                    Signature[] signatureArr2 = packageInfo2.signatures;
                    i = i11;
                    byte[] bArr2 = fuckSign.f4527[i7];
                    if (!C2880.m148()) {
                        i4 = i12;
                        sArr = sArr2;
                        i5 = i2;
                        str4 = "۟ۥۙ";
                        m150 = C2880.m150(str4);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    } else {
                        signatureArr2[i7] = new Signature(bArr2);
                        i7++;
                        str3 = "۬ۛۗ";
                        m592 = C2880.m150(str3);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    }
                case 1740667:
                    i = i11;
                    i2 = i8;
                    i3 = i9;
                    PackageInfo packageInfo3 = (PackageInfo) C2881.m107(method2, fuckSign.f4529, objArr);
                    byte[][] bArr3 = fuckSign.f4527;
                    if (!C2881.m111()) {
                        i4 = i12;
                        sArr = sArr2;
                        i5 = i2;
                        str4 = "۟ۥۙ";
                        m150 = C2880.m150(str4);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    } else {
                        bArr = bArr3;
                        i8 = i2;
                        i9 = i3;
                        m594 = C2880.m150("ۡۤۡ");
                        packageInfo2 = packageInfo3;
                        obj3 = obj3;
                        i11 = i;
                    }
                case 1740948:
                    i = i11;
                    i3 = i9;
                    i5 = i8;
                    sArr = sArr2;
                    i12 = 53762;
                    m150 = C2880.m150("ۖۜ۟");
                    method2 = method;
                    sArr2 = sArr;
                    i8 = i5;
                    i9 = i3;
                    i11 = i;
                    m594 = m150;
                    fuckSign = this;
                case 1741113:
                    i = i11;
                    i2 = i8;
                    i3 = i9;
                    PackageInfo packageInfo4 = (PackageInfo) C2880.m153(method2, fuckSign.f4529, objArr);
                    SigningInfo signingInfo = packageInfo4.signingInfo;
                    obj2 = packageInfo4;
                    if (signingInfo != null) {
                        i8 = i2;
                        i9 = i3;
                        m594 = C2880.m150("۠ۘۗ");
                        packageInfo = packageInfo4;
                        obj3 = obj3;
                        i11 = i;
                    }
                    obj4 = obj2;
                    str3 = "۟۫ۧ";
                    m592 = C2880.m150(str3);
                    i8 = i2;
                    i9 = i3;
                    m594 = m592;
                    obj3 = obj3;
                    i11 = i;
                case 1741690:
                    if (!C2880.f4534) {
                        i = i11;
                        i3 = i9;
                        i4 = i12;
                        i5 = i8;
                        sArr = sArr2;
                        str4 = "۟ۥۙ";
                        m150 = C2880.m150(str4);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    }
                    i = i11;
                    i3 = i9;
                    i4 = i12;
                    i5 = i8;
                    sArr = sArr2;
                    str5 = "ۜ۫ۡ";
                    m150 = C2881.m59(str5);
                    method2 = method;
                    i12 = i4;
                    sArr2 = sArr;
                    i8 = i5;
                    i9 = i3;
                    i11 = i;
                    m594 = m150;
                    fuckSign = this;
                case 1742845:
                    i = i11;
                    i2 = i8;
                    i3 = i9;
                    str3 = (C2881.m60(num) & 64) != 0 ? "ۙۗۙ" : "ۗ۬ۖ";
                    m592 = C2880.m150(str3);
                    i8 = i2;
                    i9 = i3;
                    m594 = m592;
                    obj3 = obj3;
                    i11 = i;
                case 1743104:
                    i = i11;
                    i2 = i8;
                    i3 = i9;
                    if (134217728 == C2880.m151(num)) {
                        str3 = "ۙۥۥ";
                        m592 = C2880.m150(str3);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    } else {
                        i4 = i12;
                        sArr = sArr2;
                        i5 = i2;
                        str5 = "ۨۘۙ";
                        m150 = C2881.m59(str5);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    }
                case 1744178:
                    C2881.m111();
                    if (!C2880.f4534) {
                        i = i11;
                        i2 = i8;
                        i3 = i9;
                        str = "۬۫ۡ";
                        m592 = C2881.m59(str);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    } else {
                        str6 = "ۢ۬ۜ";
                        m594 = C2881.m59(str6);
                    }
                case 1746867:
                    if (!C2881.f4537) {
                        str6 = "ۢ۬ۜ";
                        m594 = C2881.m59(str6);
                    } else {
                        i = i11;
                        i3 = i9;
                        i4 = i12;
                        i5 = i8;
                        sArr = sArr2;
                        str5 = "ۜ۫ۡ";
                        m150 = C2881.m59(str5);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    }
                case 1747067:
                    return obj4;
                case 1747423:
                    i2 = i8;
                    i3 = i9;
                    Signature[] m126 = C2880.m126(packageInfo.signingInfo);
                    if (m126 != null) {
                        i9 = i3;
                        m594 = C2880.m150("ۧۨ۫");
                        signatureArr = m126;
                        i8 = i2;
                    } else {
                        i = i11;
                        obj2 = packageInfo;
                        obj4 = obj2;
                        str3 = "۟۫ۧ";
                        m592 = C2880.m150(str3);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    }
                case 1747920:
                    if (!C2881.f4537) {
                        i = i11;
                        i2 = i8;
                        i3 = i9;
                        str = "۬۫ۡ";
                        m592 = C2881.m59(str);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    } else {
                        i2 = i8;
                        i3 = i9;
                        str2 = "ۨۨ۠";
                        m59 = C2881.m59(str2);
                        i9 = i3;
                        m594 = m59;
                        i8 = i2;
                    }
                case 1748826:
                    i = i11;
                    i2 = i8;
                    i3 = i9;
                    obj2 = C2880.m153(method2, fuckSign.f4529, objArr);
                    obj4 = obj2;
                    str3 = "۟۫ۧ";
                    m592 = C2880.m150(str3);
                    i8 = i2;
                    i9 = i3;
                    m594 = m592;
                    obj3 = obj3;
                    i11 = i;
                case 1749970:
                    C2880.m148();
                    if (C2881.m111()) {
                        str6 = "ۥۦۖ";
                        m594 = C2881.m59(str6);
                    } else {
                        i = i11;
                        i2 = i8;
                        i3 = i9;
                        str = "۬۫ۡ";
                        m592 = C2881.m59(str);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    }
                case 1752196:
                    i = i11;
                    int i14 = i9;
                    i4 = i12;
                    i5 = i8;
                    sArr = sArr2;
                    i3 = i14;
                    if (C2880.m140(C2881.m90(sArr, i5, i14, i4), C2880.m172(method))) {
                        str4 = "ۧۥۦ";
                        m150 = C2880.m150(str4);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    }
                    str5 = "ۨۘۙ";
                    m150 = C2881.m59(str5);
                    method2 = method;
                    i12 = i4;
                    sArr2 = sArr;
                    i8 = i5;
                    i9 = i3;
                    i11 = i;
                    m594 = m150;
                    fuckSign = this;
                case 1752661:
                    C2880.m148();
                    C2881.m111();
                    return null;
                case 1752703:
                    i2 = i8;
                    i3 = i9;
                    if (i11 < signatureArr.length) {
                        str2 = "۬ۡۧ";
                        m59 = C2881.m59(str2);
                        i9 = i3;
                        m594 = m59;
                        i8 = i2;
                    } else {
                        i = i11;
                        obj2 = packageInfo;
                        obj4 = obj2;
                        str3 = "۟۫ۧ";
                        m592 = C2880.m150(str3);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    }
                case 1753138:
                    i = i11;
                    i3 = i9;
                    i4 = i12;
                    i5 = i8;
                    sArr = sArr2;
                    if (!C2881.f4537) {
                        str5 = "۫ۙۥ";
                        m150 = C2881.m59(str5);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    }
                    str5 = "ۜ۫ۡ";
                    m150 = C2881.m59(str5);
                    method2 = method;
                    i12 = i4;
                    sArr2 = sArr;
                    i8 = i5;
                    i9 = i3;
                    i11 = i;
                    m594 = m150;
                    fuckSign = this;
                case 1754276:
                    i = i11;
                    i2 = i8;
                    i3 = i9;
                    Integer num2 = (Integer) obj3;
                    if (!C2880.m140(str7, fuckSign.f4526)) {
                        str = "ۡۦ۟";
                        m592 = C2881.m59(str);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    } else {
                        m59 = C2881.m59("ۛ۟ۡ");
                        num = num2;
                        i9 = i3;
                        i11 = i;
                        m594 = m59;
                        i8 = i2;
                    }
                case 1754568:
                    i = i11;
                    i2 = i8;
                    i3 = i9;
                    String str8 = (String) objArr[i6];
                    Object obj5 = objArr[1];
                    if (C2881.m111()) {
                        obj3 = obj5;
                        i8 = i2;
                        i9 = i3;
                        m594 = C2880.m150("ۧۜۙ");
                        str7 = str8;
                        i11 = i;
                    }
                    str = "۬۫ۡ";
                    m592 = C2881.m59(str);
                    i8 = i2;
                    i9 = i3;
                    m594 = m592;
                    obj3 = obj3;
                    i11 = i;
                case 1754666:
                    i2 = i8;
                    i3 = i9;
                    if (signatureArr.length > 0) {
                        i11 = i6;
                        str2 = "ۥۧۡ";
                        m59 = C2881.m59(str2);
                        i9 = i3;
                        m594 = m59;
                        i8 = i2;
                    } else {
                        i = i11;
                        obj2 = packageInfo;
                        obj4 = obj2;
                        str3 = "۟۫ۧ";
                        m592 = C2880.m150(str3);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    }
                case 1755113:
                    i = i11;
                    i2 = i8;
                    i3 = i9;
                    obj2 = C2881.m107(method2, fuckSign.f4529, objArr);
                    obj4 = obj2;
                    str3 = "۟۫ۧ";
                    m592 = C2880.m150(str3);
                    i8 = i2;
                    i9 = i3;
                    m594 = m592;
                    obj3 = obj3;
                    i11 = i;
                case 1755421:
                    i = i11;
                    i3 = i9;
                    i4 = i12;
                    i5 = i8;
                    sArr = sArr2;
                    str5 = i10 - (33146 * s) < 0 ? "۫ۙۨ" : "ۙ۠ۛ";
                    m150 = C2881.m59(str5);
                    method2 = method;
                    i12 = i4;
                    sArr2 = sArr;
                    i8 = i5;
                    i9 = i3;
                    i11 = i;
                    m594 = m150;
                    fuckSign = this;
                case 1755494:
                    i = i11;
                    i3 = i9;
                    i4 = i12;
                    i5 = i8;
                    sArr = sArr2;
                    if (!C2881.f4537) {
                        str4 = "ۗۢۙ";
                        m150 = C2880.m150(str4);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    }
                    str5 = "ۜ۫ۡ";
                    m150 = C2881.m59(str5);
                    method2 = method;
                    i12 = i4;
                    sArr2 = sArr;
                    i8 = i5;
                    i9 = i3;
                    i11 = i;
                    m594 = m150;
                    fuckSign = this;
                case 1755615:
                    signatureArr[i11] = signature;
                    i11++;
                    i2 = i8;
                    i3 = i9;
                    str2 = "ۥۧۡ";
                    m59 = C2881.m59(str2);
                    i9 = i3;
                    m594 = m59;
                    i8 = i2;
                case 1755616:
                    C2880.m148();
                    if (!C2881.m111()) {
                        str6 = "ۢ۬ۜ";
                        m594 = C2881.m59(str6);
                    } else {
                        m594 = C2880.m150("ۚۙۙ");
                    }
                case 1758039:
                    i = i11;
                    i3 = i9;
                    i4 = i12;
                    i5 = i8;
                    sArr = sArr2;
                    short s2 = f4525[609];
                    if (C2880.f4534) {
                        str4 = "ۖۖۚ";
                        m150 = C2880.m150(str4);
                        method2 = method;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        m594 = m150;
                        fuckSign = this;
                    } else {
                        m593 = C2881.m59("ۘ۬ۥ");
                        s = s2;
                        i12 = i4;
                        sArr2 = sArr;
                        i8 = i5;
                        i9 = i3;
                        i11 = i;
                        fuckSign = this;
                        m594 = m593;
                        method2 = method;
                    }
                case 1758042:
                    i = i11;
                    i3 = i9;
                    i5 = i8;
                    sArr = sArr2;
                    i12 = 40960;
                    m150 = C2880.m150("ۖۜ۟");
                    method2 = method;
                    sArr2 = sArr;
                    i8 = i5;
                    i9 = i3;
                    i11 = i;
                    m594 = m150;
                    fuckSign = this;
                case 1759048:
                    i = i11;
                    i2 = i8;
                    i3 = i9;
                    if (i7 < packageInfo2.signatures.length) {
                        str = "ۙۖۦ";
                        m592 = C2881.m59(str);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    } else {
                        obj4 = packageInfo2;
                        str3 = "۟۫ۧ";
                        m592 = C2880.m150(str3);
                        i8 = i2;
                        i9 = i3;
                        m594 = m592;
                        obj3 = obj3;
                        i11 = i;
                    }
                case 1759250:
                    i2 = i8;
                    i3 = i9;
                    Signature signature2 = new Signature(fuckSign.f4527[i11]);
                    if (C2881.f4537) {
                        str2 = "ۨۨ۠";
                        m59 = C2881.m59(str2);
                        i9 = i3;
                        m594 = m59;
                        i8 = i2;
                    } else {
                        signature = signature2;
                        i8 = i2;
                        m594 = C2880.m150("ۨۨ۟");
                        i9 = i3;
                    }
                case 1759554:
                    C2881.m111();
                    str6 = "ۥۦۖ";
                    m594 = C2881.m59(str6);
                default:
                    i = i11;
                    i2 = i8;
                    i3 = i9;
                    packageInfo2.signatures = new Signature[bArr.length];
                    i7 = i6;
                    str3 = "۬ۛۗ";
                    m592 = C2880.m150(str3);
                    i8 = i2;
                    i9 = i3;
                    m594 = m592;
                    obj3 = obj3;
                    i11 = i;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00fb, code lost:
        r10 = "ۜ۬ۤ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0020, code lost:
        if (np.manager.C2881.f4537 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c9, code lost:
        r10 = "ۙۡۗ";
     */
    /* renamed from: ̓ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m180(Object obj) {
        String str;
        short[] sArr = null;
        int i = 0;
        int i2 = 0;
        short[] sArr2 = null;
        char c = 0;
        short s = 0;
        int i3 = 0;
        int i4 = 0;
        short s2 = 0;
        int i5 = 0;
        String str2 = "ۛ۫۠";
        while (true) {
            int m150 = C2880.m150(str2);
            while (true) {
                switch (m150) {
                    case 1739159:
                        if (!C2880.f4534) {
                            str2 = "۠ۢۤ";
                            break;
                        } else {
                            break;
                        }
                    case 1740055:
                        int i6 = 870489 + i3;
                        if (!C2881.m111()) {
                            break;
                        } else {
                            m150 = C2880.m150("۟ۜۥ");
                            i4 = i6;
                        }
                    case 1740124:
                        if (!C2880.m148()) {
                            break;
                        }
                        str = "ۢۧۤ";
                        m150 = C2881.m59(str);
                    case 1740638:
                        i5 = 27386;
                        str = "ۤۦۖ";
                        m150 = C2881.m59(str);
                    case 1740975:
                        C2880.m148();
                        break;
                    case 1743216:
                        if (C2880.m148()) {
                            str = "ۗۤۤ";
                            m150 = C2881.m59(str);
                        }
                        str = "ۢۧۤ";
                        m150 = C2881.m59(str);
                    case 1743619:
                        C2881.m94(C2880.m125(sArr, i, i2, i5), C2881.m106(obj));
                        return;
                    case 1744212:
                        if (!C2880.f4534) {
                            break;
                        }
                        str = "ۢۧۤ";
                        m150 = C2881.m59(str);
                    case 1746600:
                        if (C2881.f4537) {
                            break;
                        } else {
                            m150 = C2881.m59("ۧۚۘ");
                            s2 = 1866;
                        }
                    case 1747091:
                        short s3 = sArr2[c];
                        int i7 = s3 * s3;
                        if (!C2881.m111()) {
                            break;
                        } else {
                            i3 = i7;
                            m150 = C2881.m59("ۘۢۡ");
                            s = s3;
                        }
                    case 1747746:
                        if (!C2880.m148()) {
                            break;
                        } else {
                            str = "ۢۢۛ";
                            m150 = C2881.m59(str);
                        }
                    case 1747794:
                        if (C2881.f4537) {
                            break;
                        } else {
                            m150 = C2881.m59("ۜۙ۠");
                            i2 = 5;
                        }
                    case 1749659:
                        short[] sArr3 = f4525;
                        if (C2881.f4537) {
                            break;
                        } else {
                            m150 = C2880.m150("۟ۧۦ");
                            sArr2 = sArr3;
                        }
                    case 1749823:
                        C2880.m148();
                        C2880.m148();
                        break;
                    case 1751700:
                        short[] sArr4 = f4525;
                        if (C2880.f4534) {
                            str = "ۘۤۨ";
                            m150 = C2881.m59(str);
                        } else {
                            i = 155;
                            m150 = C2881.m59("۠ۤۖ");
                            sArr = sArr4;
                        }
                    case 1751898:
                        C2880.m148();
                        return;
                    case 1753439:
                        i5 = 42870;
                        str = "ۤۦۖ";
                        m150 = C2881.m59(str);
                    case 1754213:
                        str = (s * s2) - i4 <= 0 ? "ۙۖۛ" : "ۦ۠ۙ";
                        m150 = C2881.m59(str);
                    default:
                        if (C2880.f4534) {
                            break;
                        } else {
                            m150 = C2881.m59("۟۬۠");
                            c = 154;
                        }
                }
            }
            str2 = "ۤ۬ۢ";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0069, code lost:
        if (np.manager.C2880.f4534 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00a0, code lost:
        if (np.manager.C2880.f4534 == false) goto L67;
     */
    /* renamed from: ̖ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String m177(Object obj) {
        Throwable th;
        String str;
        String str2;
        int m59;
        int i;
        String str3;
        int m592;
        int m150;
        String str4;
        String str5;
        String str6;
        int i2;
        int m97;
        int m1502;
        String str7;
        String str8;
        int i3 = 0;
        String str9 = null;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        FileInputStream fileInputStream = null;
        StringBuilder sb = null;
        FileInputStream fileInputStream2 = null;
        short[] sArr = null;
        FileInputStream fileInputStream3 = null;
        char c = 0;
        int m1503 = C2880.m150("ۧۙۜ");
        String str10 = null;
        FileInputStream fileInputStream4 = null;
        FileInputStream fileInputStream5 = null;
        String str11 = null;
        Throwable th2 = null;
        String str12 = null;
        short[] sArr2 = null;
        StringBuilder sb2 = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        short s = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        FileInputStream fileInputStream6 = null;
        String str13 = null;
        int i19 = 0;
        int i20 = 0;
        while (true) {
            switch (m1503) {
                case 1737919:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    if (i10 > C2880.m154(str9) - 1) {
                        str5 = "۟ۤۢ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th3 = th;
                        m1503 = m1502;
                        th2 = th3;
                    } else {
                        i7 = i10;
                        str4 = "ۤۙۛ";
                        m1502 = C2881.m59(str4);
                        i19 = i;
                        str12 = str3;
                        Throwable th32 = th;
                        m1503 = m1502;
                        th2 = th32;
                    }
                case 1738185:
                    break;
                case 1738258:
                    th = th2;
                    if (i8 > i9) {
                        str2 = "ۛۤۚ";
                        m1502 = C2881.m59(str2);
                        Throwable th322 = th;
                        m1503 = m1502;
                        th2 = th322;
                    } else {
                        i20 = i8;
                        fileInputStream2 = fileInputStream5;
                        str2 = "ۧۧۛ";
                        m1502 = C2881.m59(str2);
                        Throwable th3222 = th;
                        m1503 = m1502;
                        th2 = th3222;
                    }
                case 1738856:
                    C2880.m148();
                    C2881.m111();
                    return null;
                case 1739032:
                    C2880.m148();
                    if (C2880.f4534) {
                        str = "ۗۚ۫";
                        m1503 = C2881.m59(str);
                    } else {
                        th = th2;
                        i = i19;
                        str3 = str12;
                        str4 = "۠ۚۧ";
                        m1502 = C2881.m59(str4);
                        i19 = i;
                        str12 = str3;
                        Throwable th32222 = th;
                        m1503 = m1502;
                        th2 = th32222;
                    }
                case 1739054:
                    th = th2;
                    i3++;
                    i = i19;
                    i10 = i7 + 1;
                    i6 = i20;
                    fileInputStream = fileInputStream2;
                    str12 = C2881.m106(sb);
                    m1502 = C2881.m59("ۚۖ۫");
                    i19 = i;
                    Throwable th322222 = th;
                    m1503 = m1502;
                    th2 = th322222;
                case 1740944:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    int i21 = i17 + i18;
                    if ((i21 + i21) - i16 < 0) {
                        str5 = "ۡۦ۫";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th3222222 = th;
                        m1503 = m1502;
                        th2 = th3222222;
                    } else {
                        str4 = "ۢ۫ۤ";
                        m1502 = C2881.m59(str4);
                        i19 = i;
                        str12 = str3;
                        Throwable th32222222 = th;
                        m1503 = m1502;
                        th2 = th32222222;
                    }
                case 1741068:
                    if (!C2881.f4537) {
                        str8 = "ۗ۠ۡ";
                        m1503 = C2880.m150(str8);
                    } else {
                        th = th2;
                        i = i19;
                        str3 = str12;
                        str5 = "ۢۖۖ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th322222222 = th;
                        m1503 = m1502;
                        th2 = th322222222;
                    }
                case 1741288:
                    th = th2;
                    try {
                        FileInputStream fileInputStream7 = new FileInputStream(str12);
                        m59 = C2881.m59("۫ۘۨ");
                        fileInputStream3 = fileInputStream7;
                        th2 = th;
                        m1503 = m59;
                    } catch (FileNotFoundException unused) {
                        str2 = "ۧ۬ۤ";
                        break;
                    } catch (Throwable th4) {
                        th2 = th4;
                        str = "ۥۗۙ";
                        break;
                    }
                case 1741615:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    if (i3 < C2881.m89(str13)) {
                        str5 = "ۡۘۡ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th3222222222 = th;
                        m1503 = m1502;
                        th2 = th3222222222;
                    } else {
                        str6 = str3;
                        str11 = str6;
                        str5 = "ۢۛۢ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th32222222222 = th;
                        m1503 = m1502;
                        th2 = th32222222222;
                    }
                case 1741760:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    if (!C2881.m111()) {
                        str4 = "ۤۧۙ";
                        m1502 = C2881.m59(str4);
                        i19 = i;
                        str12 = str3;
                        Throwable th322222222222 = th;
                        m1503 = m1502;
                        th2 = th322222222222;
                    } else {
                        m592 = C2880.m150("ۤ۠۫");
                        th2 = th;
                        str12 = str3;
                        c = 422;
                        m1503 = m592;
                        i19 = i;
                    }
                case 1742880:
                    try {
                        C2880.m170(fileInputStream);
                    } catch (IOException unused2) {
                    }
                    th = th2;
                    fileInputStream5 = fileInputStream;
                    str7 = "ۖۦۢ";
                    m1502 = C2880.m150(str7);
                    Throwable th3222222222222 = th;
                    m1503 = m1502;
                    th2 = th3222222222222;
                case 1742993:
                    i20 = i8 % i9;
                    th = th2;
                    fileInputStream2 = fileInputStream5;
                    str2 = "ۧۧۛ";
                    m1502 = C2881.m59(str2);
                    Throwable th32222222222222 = th;
                    m1503 = m1502;
                    th2 = th32222222222222;
                case 1743072:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    if (C2880.f4534) {
                        str5 = "ۡۢۥ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th322222222222222 = th;
                        m1503 = m1502;
                        th2 = th322222222222222;
                    } else {
                        fileInputStream6 = null;
                        th2 = th;
                        i19 = i;
                        str12 = str3;
                        i14 = 0;
                        m1503 = C2881.m59("ۡۘۜ");
                        i9 = 65535;
                    }
                case 1743097:
                    th = th2;
                    i20 = i19 % i9;
                    fileInputStream2 = fileInputStream4;
                    str2 = "ۧۧۛ";
                    m1502 = C2881.m59(str2);
                    Throwable th3222222222222222 = th;
                    m1503 = m1502;
                    th2 = th3222222222222222;
                case 1746845:
                    th = th2;
                    short[] sArr3 = f4525;
                    if (C2880.f4534) {
                        i = i19;
                        str3 = str12;
                        str4 = "۠ۚۧ";
                        m1502 = C2881.m59(str4);
                        i19 = i;
                        str12 = str3;
                        Throwable th32222222222222222 = th;
                        m1503 = m1502;
                        th2 = th32222222222222222;
                    } else {
                        i11 = 429;
                        i12 = 2;
                        m59 = C2880.m150("ۧۖۢ");
                        sArr2 = sArr3;
                        th2 = th;
                        m1503 = m59;
                    }
                case 1747427:
                    throw th2;
                    break;
                case 1747501:
                    C2881.m111();
                    C2880.m148();
                    str = "ۗۚ۫";
                    m1503 = C2881.m59(str);
                case 1748389:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    String str14 = (String) obj;
                    if (!C2880.m148()) {
                        str5 = "ۢۖۖ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th322222222222222222 = th;
                        m1503 = m1502;
                        th2 = th322222222222222222;
                    } else {
                        m150 = C2880.m150("۫ۜۖ");
                        str13 = str14;
                        str10 = "";
                        th2 = th;
                        i19 = i;
                        m1503 = m150;
                        str12 = str3;
                    }
                case 1748394:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    String m125 = C2880.m125(f4525, 427, 2, i13);
                    if (C2881.f4537) {
                        str4 = "۠ۚۧ";
                        m1502 = C2881.m59(str4);
                        i19 = i;
                        str12 = str3;
                        Throwable th3222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th3222222222222222222;
                    } else {
                        m592 = C2880.m150("ۖۛۤ");
                        str9 = m125;
                        th2 = th;
                        str12 = str3;
                        m1503 = m592;
                        i19 = i;
                    }
                case 1748708:
                    C2880.m148();
                    if (C2880.m148()) {
                        str = "ۗۚ۫";
                        m1503 = C2881.m59(str);
                    } else {
                        str8 = "ۗ۠ۡ";
                        m1503 = C2880.m150(str8);
                    }
                case 1748838:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    i13 = 55099;
                    str4 = "ۛۦ۫";
                    m1502 = C2881.m59(str4);
                    i19 = i;
                    str12 = str3;
                    Throwable th32222222222222222222 = th;
                    m1503 = m1502;
                    th2 = th32222222222222222222;
                case 1749282:
                    C2881.m111();
                    if (C2880.m148()) {
                        str8 = "ۗ۠ۡ";
                        m1503 = C2880.m150(str8);
                    } else {
                        str = "ۗۙۤ";
                        m1503 = C2881.m59(str);
                    }
                case 1749378:
                    th = th2;
                    i8 = (i4 + i9) - i5;
                    if (fileInputStream != null) {
                        str7 = "ۙ۫ۚ";
                        m1502 = C2880.m150(str7);
                        Throwable th322222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th322222222222222222222;
                    }
                    fileInputStream5 = fileInputStream;
                    str7 = "ۖۦۢ";
                    m1502 = C2880.m150(str7);
                    Throwable th3222222222222222222222 = th;
                    m1503 = m1502;
                    th2 = th3222222222222222222222;
                case 1749447:
                    th = th2;
                    if (i19 > i9) {
                        str2 = "ۛۧۥ";
                        m1502 = C2881.m59(str2);
                        Throwable th32222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th32222222222222222222222;
                    } else {
                        i20 = i19;
                        fileInputStream2 = fileInputStream4;
                        str2 = "ۧۧۛ";
                        m1502 = C2881.m59(str2);
                        Throwable th322222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th322222222222222222222222;
                    }
                case 1749449:
                    return str11;
                case 1749947:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    i13 = 33459;
                    str4 = "ۛۦ۫";
                    m1502 = C2881.m59(str4);
                    i19 = i;
                    str12 = str3;
                    Throwable th3222222222222222222222222 = th;
                    m1503 = m1502;
                    th2 = th3222222222222222222222222;
                case 1751302:
                    th = th2;
                    try {
                        m97 = C2881.m97(str13, i3);
                        i = i19;
                        str3 = str12;
                    } catch (Throwable unused3) {
                        str3 = str12;
                    }
                    try {
                        i5 = C2880.m161(C2881.m90(f4525, 431, 2, i13), i7);
                        m1502 = C2880.m150("ۢۙۙ");
                        i4 = m97;
                        i19 = i;
                    } catch (Throwable unused4) {
                        i2 = i6;
                        i19 = i2;
                        fileInputStream4 = fileInputStream;
                        m1502 = C2881.m59("ۢۛ۠");
                        str12 = str3;
                        Throwable th32222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th32222222222222222222222222;
                    }
                    str12 = str3;
                    Throwable th322222222222222222222222222 = th;
                    m1503 = m1502;
                    th2 = th322222222222222222222222222;
                case 1751535:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    short s2 = sArr[c];
                    int i22 = s2 + 12429;
                    if (!C2881.m111()) {
                        str5 = "ۤۥۤ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th3222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th3222222222222222222222222222;
                    } else {
                        m150 = C2880.m150("ۤۡۡ");
                        s = s2;
                        i15 = i22;
                        th2 = th;
                        i19 = i;
                        m1503 = m150;
                        str12 = str3;
                    }
                case 1751556:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    int i23 = i15 * i15;
                    int i24 = s * s;
                    if (C2881.f4537) {
                        str5 = "ۢۖۖ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th32222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th32222222222222222222222222222;
                    } else {
                        i17 = i24;
                        th2 = th;
                        i19 = i;
                        i18 = 154480041;
                        m1503 = C2881.m59("ۙ۠ۗ");
                        i16 = i23;
                        str12 = str3;
                    }
                case 1751654:
                    th = th2;
                    StringBuilder m65 = C2881.m65(sb2, (char) i20);
                    if (C2880.f4534) {
                        i = i19;
                        str3 = str12;
                        str5 = "ۙۤۗ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th322222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th322222222222222222222222222222;
                    } else {
                        m59 = C2881.m59("ۗۡۘ");
                        sb = m65;
                        th2 = th;
                        m1503 = m59;
                    }
                case 1751683:
                    C2881.m111();
                    if (!C2881.m111()) {
                        th = th2;
                        i = i19;
                        str3 = str12;
                        str4 = "ۤۧۙ";
                        m1502 = C2881.m59(str4);
                        i19 = i;
                        str12 = str3;
                        Throwable th3222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th3222222222222222222222222222222;
                    }
                    th = th2;
                    i = i19;
                    str3 = str12;
                    str5 = "ۙۤۗ";
                    m1502 = C2880.m150(str5);
                    i19 = i;
                    str12 = str3;
                    Throwable th32222222222222222222222222222222 = th;
                    m1503 = m1502;
                    th2 = th32222222222222222222222222222222;
                case 1751734:
                    if (C2880.m148()) {
                        th = th2;
                        i = i19;
                        str3 = str12;
                        str5 = "ۡۢۥ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th322222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th322222222222222222222222222222222;
                    } else {
                        str = "ۖۤۗ";
                        m1503 = C2881.m59(str);
                    }
                case 1752199:
                    if (fileInputStream != null) {
                        str8 = "ۥۛ۬";
                        m1503 = C2880.m150(str8);
                    } else {
                        str = "۠ۘۛ";
                        m1503 = C2881.m59(str);
                    }
                case 1752342:
                    try {
                        try {
                            C2881.m61(fileInputStream);
                        } catch (IOException unused5) {
                        }
                        str = "۠ۘۛ";
                        m1503 = C2881.m59(str);
                    } catch (Throwable unused6) {
                        th = th2;
                        str3 = str12;
                        i2 = i8;
                        i19 = i2;
                        fileInputStream4 = fileInputStream;
                        m1502 = C2881.m59("ۢۛ۠");
                        str12 = str3;
                        Throwable th3222222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th3222222222222222222222222222222222;
                    }
                case 1753193:
                    try {
                        C2880.m170(fileInputStream3);
                    } catch (IOException unused7) {
                    } catch (Throwable unused8) {
                        th = th2;
                        str3 = str12;
                        i19 = i8;
                        fileInputStream4 = fileInputStream3;
                        m1502 = C2881.m59("ۢۛ۠");
                        str12 = str3;
                        Throwable th32222222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th32222222222222222222222222222222222;
                    }
                    th = th2;
                    fileInputStream5 = fileInputStream3;
                    str7 = "ۖۦۢ";
                    m1502 = C2880.m150(str7);
                    Throwable th322222222222222222222222222222222222 = th;
                    m1503 = m1502;
                    th2 = th322222222222222222222222222222222222;
                case 1754099:
                    th = th2;
                    i7 = i10 % C2881.m89(C2881.m90(sArr2, i11, i12, i13));
                    i = i19;
                    str3 = str12;
                    str4 = "ۤۙۛ";
                    m1502 = C2881.m59(str4);
                    i19 = i;
                    str12 = str3;
                    Throwable th3222222222222222222222222222222222222 = th;
                    m1503 = m1502;
                    th2 = th3222222222222222222222222222222222222;
                case 1754186:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    short[] sArr4 = f4525;
                    if (C2881.f4537) {
                        str5 = "ۙۤۗ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th32222222222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th32222222222222222222222222222222222222;
                    } else {
                        m592 = C2881.m59("ۚۛۡ");
                        sArr = sArr4;
                        th2 = th;
                        str12 = str3;
                        m1503 = m592;
                        i19 = i;
                    }
                case 1754619:
                    th = th2;
                    StringBuilder m109 = C2881.m109(new StringBuilder(), str12);
                    if (!C2880.m148()) {
                        i = i19;
                        str3 = str12;
                        str5 = "ۤۥۤ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th322222222222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th322222222222222222222222222222222222222;
                    } else {
                        m59 = C2880.m150("ۤۤۦ");
                        sb2 = m109;
                        th2 = th;
                        m1503 = m59;
                    }
                case 1754783:
                    if (fileInputStream != null) {
                        str = "ۛ۠ۥ";
                        m1503 = C2881.m59(str);
                    } else {
                        th = th2;
                        fileInputStream5 = fileInputStream;
                        str7 = "ۖۦۢ";
                        m1502 = C2880.m150(str7);
                        Throwable th3222222222222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th3222222222222222222222222222222222222222;
                    }
                case 1758011:
                    if (fileInputStream3 != null) {
                        str = "ۦۘۛ";
                        m1503 = C2881.m59(str);
                    } else {
                        th = th2;
                        fileInputStream5 = fileInputStream3;
                        str7 = "ۖۦۢ";
                        m1502 = C2880.m150(str7);
                        Throwable th32222222222222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th32222222222222222222222222222222222222222;
                    }
                case 1758117:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    if (C2881.m89(C2880.m125(f4525, 423, 2, i13)) == 0) {
                        str11 = str13;
                        str5 = "ۢۛۢ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th322222222222222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th322222222222222222222222222222222222222222;
                    } else {
                        str5 = "۬ۦۦ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th3222222222222222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th3222222222222222222222222222222222222222222;
                    }
                case 1759404:
                    th = th2;
                    i = i19;
                    str3 = str12;
                    if (!C2880.m140(str13, C2881.m90(f4525, 425, 2, i13))) {
                        fileInputStream = fileInputStream6;
                        i10 = i14;
                        i3 = i10;
                        i6 = i3;
                        str12 = str10;
                        m1502 = C2881.m59("ۚۖ۫");
                        i19 = i;
                        Throwable th32222222222222222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th32222222222222222222222222222222222222222222;
                    } else {
                        str6 = str10;
                        str11 = str6;
                        str5 = "ۢۛۢ";
                        m1502 = C2880.m150(str5);
                        i19 = i;
                        str12 = str3;
                        Throwable th322222222222222222222222222222222222222222222 = th;
                        m1503 = m1502;
                        th2 = th322222222222222222222222222222222222222222222;
                    }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0018, code lost:
        if (np.manager.C2881.m111() == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
        r0 = "ۤ۫ۖ";
     */
    /* renamed from: ̙ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m174(Object obj, String str, Object obj2) {
        String str2;
        String str3 = "۟ۢۡ";
        while (true) {
            int m150 = C2880.m150(str3);
            while (true) {
                switch (m150) {
                    case 1738227:
                        break;
                    case 1740213:
                        if (C2880.m148()) {
                            str3 = "ۥۧ۟";
                            break;
                        }
                        str2 = "ۙ۬ۘ";
                        m150 = C2881.m59(str2);
                    case 1740685:
                        C2881.m111();
                        if (C2880.f4534) {
                            break;
                        }
                        str2 = "ۙ۬ۘ";
                        m150 = C2881.m59(str2);
                    case 1741317:
                        C2880.m148();
                        return;
                    case 1742649:
                        if (!C2880.f4534) {
                            str3 = "۠ۦ۠";
                            break;
                        } else {
                            break;
                        }
                    case 1742914:
                        if (!C2880.f4534) {
                            str3 = "ۛۙۗ";
                            break;
                        } else {
                            break;
                        }
                    case 1743610:
                        try {
                            Field m164 = C2880.m164(C2880.m158(obj), str);
                            C2880.m127(m164, true);
                            C2881.m108(m164, obj, obj2);
                        } catch (Throwable unused) {
                        }
                        str2 = "ۢ۠۬";
                        m150 = C2881.m59(str2);
                    case 1743630:
                        if (!C2880.f4534) {
                            str3 = "ۤۘ۟";
                            break;
                        }
                        str2 = "۫ۥۖ";
                        m150 = C2881.m59(str2);
                    case 1746782:
                        if (!C2880.f4534) {
                            str3 = "ۛۡۨ";
                            break;
                        } else {
                            break;
                        }
                    case 1747866:
                        if (C2880.f4534) {
                            break;
                        } else {
                            str2 = "۬ۚۨ";
                            m150 = C2881.m59(str2);
                        }
                    case 1749614:
                        return;
                    case 1751275:
                        if (C2880.f4534) {
                            break;
                        } else {
                            str2 = "۬ۨۦ";
                            m150 = C2881.m59(str2);
                        }
                    case 1751855:
                        C2881.m111();
                        C2880.m148();
                        str2 = "ۙ۬ۘ";
                        m150 = C2881.m59(str2);
                    case 1752701:
                        if (!C2880.f4534) {
                            str3 = "ۜۙ۫";
                            break;
                        }
                        str2 = "۫ۥۖ";
                        m150 = C2881.m59(str2);
                    case 1758396:
                        if (C2881.f4537) {
                            break;
                        }
                        str2 = "ۙ۬ۘ";
                        m150 = C2881.m59(str2);
                    case 1759466:
                        if (!C2881.f4537) {
                            str3 = "ۜۙۗ";
                            break;
                        }
                        str2 = "۫ۥۖ";
                        m150 = C2881.m59(str2);
                    default:
                        if (!C2880.f4534) {
                            str3 = "ۘۧۤ";
                            break;
                        }
                        str2 = "ۙۗ۫";
                        m150 = C2881.m59(str2);
                }
            }
            str3 = "ۖۥۢ";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0095, code lost:
        r11 = "ۗۢۛ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x011d, code lost:
        r11 = "ۥۨۜ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b7, code lost:
        r11 = "۫۫ۚ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0143, code lost:
        r11 = "ۗۛ۬";
     */
    @Override // android.app.Application
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate() {
        String str;
        int i = 0;
        int i2 = 0;
        String str2 = null;
        short[] sArr = null;
        int i3 = 0;
        short[] sArr2 = null;
        char c = 0;
        short s = 0;
        short s2 = 0;
        int i4 = 0;
        int i5 = 0;
        String str3 = "ۖۖۢ";
        while (true) {
            int m150 = C2880.m150(str3);
            while (true) {
                switch (m150) {
                    case 1737762:
                        short[] sArr3 = f4525;
                        if (!C2881.m111()) {
                            break;
                        } else {
                            m150 = C2881.m59("ۛ۠ۨ");
                            sArr2 = sArr3;
                        }
                    case 1738137:
                        C2880.m148();
                        C2880.m148();
                        break;
                    case 1738140:
                        short[] sArr4 = f4525;
                        if (C2881.f4537) {
                            break;
                        } else {
                            m150 = C2881.m59("ۨۡۛ");
                            sArr = sArr4;
                        }
                    case 1738868:
                        if (m173(DATA.f4531) == null) {
                            break;
                        } else {
                            str3 = "ۡ۬ۤ";
                            break;
                        }
                    case 1738888:
                        C2880.m148();
                        if (!C2881.m111()) {
                            str3 = "ۚۢ۠";
                            break;
                        } else {
                            break;
                        }
                    case 1739088:
                        C2881.m111();
                        C2881.m111();
                        return;
                    case 1739368:
                        if (C2881.f4537) {
                            break;
                        } else {
                            m150 = C2880.m150("ۘۖ۫");
                            i = 301716900;
                        }
                    case 1739693:
                        str = (i5 + i) - i4 >= 0 ? "۬ۛۧ" : "ۚۦۨ";
                        m150 = C2881.m59(str);
                    case 1740833:
                        int i6 = s * s2;
                        int i7 = s * s;
                        if (C2880.f4534) {
                            break;
                        } else {
                            i5 = i7;
                            m150 = C2880.m150("ۗ۫ۜ");
                            i4 = i6;
                        }
                    case 1741976:
                        if (!C2881.m111()) {
                            break;
                        } else {
                            break;
                        }
                    case 1742108:
                        i2 = 4299;
                        str = "ۗۛۘ";
                        m150 = C2881.m59(str);
                    case 1742154:
                        if (C2880.f4534) {
                            break;
                        } else {
                            m150 = C2880.m150("ۤۤۙ");
                            c = 624;
                        }
                    case 1742883:
                        if (!C2881.m111()) {
                            break;
                        } else {
                            str = "ۚۨۘ";
                            m150 = C2881.m59(str);
                        }
                    case 1742896:
                        return;
                    case 1749017:
                        String m173 = m173(DATA.f4531);
                        if (!C2880.m148()) {
                            break;
                        } else {
                            m150 = C2880.m150("ۖۢۨ");
                            str2 = m173;
                        }
                    case 1751641:
                        short s3 = sArr2[c];
                        if (!C2880.m148()) {
                            break;
                        } else {
                            s2 = 34740;
                            m150 = C2881.m59("ۙۜۤ");
                            s = s3;
                        }
                    case 1751783:
                        C2881.m73(this.f4528);
                        str = "ۛۡۖ";
                        m150 = C2881.m59(str);
                    case 1751861:
                        if (C2880.m140(str2, C2880.m125(sArr, i3, 23, i2))) {
                            break;
                        } else {
                            str3 = "ۡ۟ۖ";
                            break;
                        }
                    case 1752729:
                        C2880.m148();
                        if (C2880.f4534) {
                            break;
                        } else {
                            break;
                        }
                    case 1755394:
                        if (C2881.f4537) {
                            break;
                        } else {
                            m150 = C2881.m59("ۤ۫ۜ");
                            i3 = 625;
                        }
                    case 1758586:
                        super.onCreate();
                        str = "ۛۡۖ";
                        m150 = C2881.m59(str);
                    case 1759064:
                        i2 = 1080;
                        str = "ۗۛۘ";
                        m150 = C2881.m59(str);
                    default:
                        m176(this.f4528);
                        if (C2880.m148()) {
                            str3 = "ۤۨ۫";
                            break;
                        } else {
                            break;
                        }
                }
            }
            str3 = "ۖۢۥ";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00b4, code lost:
        r1 = "ۖۘۛ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a6, code lost:
        r1 = "۬۟ۘ";
     */
    /* renamed from: ̕ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object m178(Object obj, String str) {
        String str2;
        Object obj2 = null;
        String str3 = "۫ۙۦ";
        while (true) {
            int m150 = C2880.m150(str3);
            while (true) {
                switch (m150) {
                    case 1737817:
                        if (!C2880.m148()) {
                            break;
                        } else {
                            str2 = "ۧۥۜ";
                            m150 = C2881.m59(str2);
                        }
                    case 1739384:
                        if (!C2881.f4537) {
                            str2 = "ۧۢۙ";
                            m150 = C2881.m59(str2);
                        }
                        str2 = "۟ۢۦ";
                        m150 = C2881.m59(str2);
                    case 1739709:
                        if (C2880.m148()) {
                            str3 = "ۛۙۚ";
                            break;
                        }
                        str2 = "۟ۢۦ";
                        m150 = C2881.m59(str2);
                    case 1741176:
                        return obj2;
                    case 1742652:
                        try {
                            Field m164 = C2880.m164(C2880.m158(obj), str);
                            C2881.m64(m164, true);
                            obj2 = C2880.m165(m164, obj);
                            break;
                        } catch (Throwable unused) {
                            str2 = "۠۟ۡ";
                            break;
                        }
                    case 1746787:
                        C2881.m111();
                        if (!C2880.m148()) {
                            break;
                        }
                        str2 = "۫ۨۡ";
                        m150 = C2881.m59(str2);
                    case 1747650:
                        obj2 = null;
                        break;
                    case 1747874:
                        if (C2881.m111()) {
                            str3 = "۫ۧ۟";
                            break;
                        } else {
                            break;
                        }
                    case 1748862:
                        if (C2880.m148()) {
                            str3 = "ۘۗۜ";
                            break;
                        }
                        str2 = "۫ۨۡ";
                        m150 = C2881.m59(str2);
                    case 1749379:
                        if (!C2881.f4537) {
                            str2 = "ۧۢ۠";
                            m150 = C2881.m59(str2);
                        }
                        str2 = "۫ۨۡ";
                        m150 = C2881.m59(str2);
                    case 1751218:
                        if (C2880.m148()) {
                            str3 = "ۗ۫۬";
                            break;
                        }
                        str2 = "۫ۨۡ";
                        m150 = C2881.m59(str2);
                    case 1754469:
                        if (!C2880.f4534) {
                            str2 = "ۤۖۤ";
                            m150 = C2881.m59(str2);
                        }
                        str2 = "۟ۢۦ";
                        m150 = C2881.m59(str2);
                    case 1754558:
                        if (C2881.m111()) {
                            break;
                        }
                        str2 = "۫ۨۡ";
                        m150 = C2881.m59(str2);
                    case 1758040:
                        if (C2881.m111()) {
                            str3 = "۠ۦۨ";
                            break;
                        } else {
                            break;
                        }
                    case 1758467:
                        if (!C2880.f4534) {
                            str3 = "ۢۙۚ";
                            break;
                        } else {
                            break;
                        }
                    case 1758500:
                        C2881.m111();
                        break;
                    case 1759173:
                        C2881.m111();
                        C2881.m111();
                        return null;
                    default:
                        if (!C2880.f4534) {
                            str2 = "ۡۧۤ";
                            m150 = C2881.m59(str2);
                        }
                        str2 = "۫ۨۡ";
                        m150 = C2881.m59(str2);
                }
            }
            str3 = "ۙۧۦ";
        }
    }

    /* renamed from: ̗ */
    private void m176(Application application) {
        Object obj;
        String str;
        String str2;
        Object obj2;
        String str3;
        int m150;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        short s = 0;
        int i = 0;
        short[] sArr = null;
        int i2 = 0;
        int i3 = 0;
        short[] sArr2 = null;
        int m1502 = C2880.m150("ۧۦۙ");
        short[] sArr3 = null;
        short[] sArr4 = null;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        char c = 0;
        int i8 = 0;
        int i9 = 0;
        short s2 = 0;
        while (true) {
            switch (m1502) {
                case 1740802:
                    obj = obj5;
                    short[] sArr5 = f4525;
                    if (C2881.f4537) {
                        str2 = "ۛۗۤ";
                        m150 = C2880.m150(str2);
                        obj2 = obj;
                        m1502 = m150;
                        obj5 = obj2;
                    } else {
                        sArr4 = sArr5;
                        obj5 = obj;
                        i7 = 455;
                        m1502 = C2881.m59("ۡۜۡ");
                        i6 = 19;
                    }
                case 1740831:
                    C2880.m148();
                    str = "ۢۢۗ";
                    m1502 = C2880.m150(str);
                case 1742600:
                    if (C2881.f4537) {
                        str = "ۢۢۗ";
                        m1502 = C2880.m150(str);
                    } else {
                        obj = obj5;
                        str3 = "ۛۡۜ";
                        m150 = C2881.m59(str3);
                        obj2 = obj;
                        m1502 = m150;
                        obj5 = obj2;
                    }
                case 1742902:
                    if (!C2880.m148()) {
                        obj = obj5;
                        str3 = "ۤۘۛ";
                        m150 = C2881.m59(str3);
                        obj2 = obj;
                        m1502 = m150;
                        obj5 = obj2;
                    }
                    obj = obj5;
                    str2 = "ۙۜۢ";
                    m150 = C2880.m150(str2);
                    obj2 = obj;
                    m1502 = m150;
                    obj5 = obj2;
                case 1746969:
                    obj = obj5;
                    obj5 = m178(obj4, C2881.m90(sArr2, i4, i5, i));
                    if (C2881.f4537) {
                        str2 = "ۛۗۤ";
                        m150 = C2880.m150(str2);
                        obj2 = obj;
                        m1502 = m150;
                        obj5 = obj2;
                    } else {
                        str = "ۙۛۤ";
                        m1502 = C2880.m150(str);
                    }
                case 1747815:
                    obj = obj5;
                    if (C2881.f4537) {
                        str2 = "ۙۜۢ";
                        m150 = C2880.m150(str2);
                        obj2 = obj;
                        m1502 = m150;
                        obj5 = obj2;
                    } else {
                        obj5 = obj;
                        m1502 = C2881.m59("ۥۜۡ");
                        c = 433;
                    }
                case 1748485:
                    obj = obj5;
                    Object m183 = m183();
                    short[] sArr6 = f4525;
                    if (!C2881.f4537) {
                        sArr = sArr6;
                        i2 = 434;
                        i3 = 17;
                        obj2 = obj;
                        m1502 = C2880.m150("۬ۘۚ");
                        obj3 = m183;
                        obj5 = obj2;
                    }
                    str2 = "ۛۗۤ";
                    m150 = C2880.m150(str2);
                    obj2 = obj;
                    m1502 = m150;
                    obj5 = obj2;
                case 1748498:
                    obj = obj5;
                    str2 = (s2 * s) - i9 > 0 ? "ۙۗۥ" : "۬ۘۥ";
                    m150 = C2880.m150(str2);
                    obj2 = obj;
                    m1502 = m150;
                    obj5 = obj2;
                case 1748518:
                    obj = obj5;
                    m174(obj3, C2881.m90(sArr4, i7, i6, i), application);
                    if (!C2881.f4537) {
                        str2 = "۬ۜۥ";
                        m150 = C2880.m150(str2);
                        obj2 = obj;
                        m1502 = m150;
                        obj5 = obj2;
                    }
                    str2 = "ۛۗۤ";
                    m150 = C2880.m150(str2);
                    obj2 = obj;
                    m1502 = m150;
                    obj5 = obj2;
                case 1749655:
                    C2881.m111();
                    C2880.m148();
                    return;
                case 1751271:
                    if (!C2880.m148()) {
                        str = "ۢۢۗ";
                        m1502 = C2880.m150(str);
                    } else {
                        obj = obj5;
                        str2 = "ۙۜۢ";
                        m150 = C2880.m150(str2);
                        obj2 = obj;
                        m1502 = m150;
                        obj5 = obj2;
                    }
                case 1752362:
                    obj = obj5;
                    short s3 = sArr3[c];
                    int i10 = s3 * s3;
                    if (C2881.f4537) {
                        str2 = "ۙۜۢ";
                        m150 = C2880.m150(str2);
                        obj2 = obj;
                        m1502 = m150;
                        obj5 = obj2;
                    } else {
                        s2 = s3;
                        obj5 = obj;
                        m1502 = C2881.m59("ۨۙۡ");
                        i8 = i10;
                    }
                case 1754584:
                    obj = obj5;
                    short[] sArr7 = f4525;
                    if (!C2880.m148()) {
                        str3 = "ۤۘۛ";
                        m150 = C2881.m59(str3);
                        obj2 = obj;
                        m1502 = m150;
                        obj5 = obj2;
                    } else {
                        sArr2 = sArr7;
                        obj5 = obj;
                        i5 = 4;
                        m1502 = C2880.m150("۟ۨۢ");
                        i4 = TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR;
                    }
                case 1754586:
                    obj = obj5;
                    short[] sArr8 = f4525;
                    if (!C2881.m111()) {
                        str3 = "ۛۡۜ";
                        m150 = C2881.m59(str3);
                        obj2 = obj;
                        m1502 = m150;
                        obj5 = obj2;
                    } else {
                        sArr3 = sArr8;
                        obj5 = obj;
                        m1502 = C2881.m59("۠ۤ۫");
                    }
                case 1755152:
                    obj = obj5;
                    int i11 = i8 + 269452225;
                    if (C2880.f4534) {
                        str2 = "ۛۗۤ";
                        m150 = C2880.m150(str2);
                        obj2 = obj;
                        m1502 = m150;
                        obj5 = obj2;
                    } else {
                        i9 = i11;
                        obj5 = obj;
                        m1502 = C2880.m150("ۡۛ۬");
                        s = 32830;
                    }
                case 1758958:
                    obj = obj5;
                    Object m178 = m178(obj3, C2881.m90(sArr, i2, i3, i));
                    if (!C2881.f4537) {
                        obj2 = obj;
                        m1502 = C2881.m59("ۧۦۗ");
                        obj4 = m178;
                        obj5 = obj2;
                    }
                    str3 = "ۛۡۜ";
                    m150 = C2881.m59(str3);
                    obj2 = obj;
                    m1502 = m150;
                    obj5 = obj2;
                case 1758969:
                    obj = obj5;
                    i = 61502;
                    str3 = "ۡۛ۟";
                    m150 = C2881.m59(str3);
                    obj2 = obj;
                    m1502 = m150;
                    obj5 = obj2;
                case 1759093:
                    m174(obj5, C2880.m125(f4525, 474, 12, i), application);
                    return;
                default:
                    obj = obj5;
                    i = 30131;
                    str3 = "ۡۛ۟";
                    m150 = C2881.m59(str3);
                    obj2 = obj;
                    m1502 = m150;
                    obj5 = obj2;
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
    /* renamed from: ̚ */
    private java.lang.String m173(java.lang.Object r53) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: np.manager.FuckSign.m173(java.lang.Object):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @StringFogIgnore
    /* loaded from: classes2.dex */
    public final class DATA {

        /* renamed from: ̅ */
        public static String f4530 = "0B7B036676526D325E470E1F6A696E06340A706B614F6A640B4E7C19732E11707461757E63144160736E267605606A626A7E720B64690752066376726222777605717E74663E04387F7B657862667A6E6F7B7F07647574671654763E6A701112091479466B71716B711B78660F5D186C6D616A295B782C48635A660A07267F796269407308425E26492F71435C7400696D06006061161100024962677B42713373797B1F0F760F4E641460641161766462331F0A6B776A444D7F215E6708490C6A637458087D65727D73615E0A3F040578484F7F6A206C56075003127A53753D74640E036A744F2508067C57646C6E6C084E601C68037E63785A04406E1375776D66740200007A656B6D6A0D7A431C531870060C6D14015703617E647115140974587A63757F00454C12413A634D786E075E6E1172664F73062E315D4C4D7E5B421E6C7E076B7260760875007A580A77744D713D1F16001A6D7917500E78770E7C1376737C571F727A1F7A4B427F2F32266B17576C7E7E00624110632A51547761147C6205616664401D75007C6667626E480D6B6F0668286D056D597740470F614865487631294B5E561E40167E7C1A2813047352616C267E6E35524F79662C2239636A5458004F3F43481E5A0D4E610C48247A75211B6242680C2E717C196266594D011F177B7C00637F584B044D14751F5072693D0E1B0618436F6B513A5D621D4F336E7D01542D520F37785F0F5635371B5D431141581E04187E2E1872657660772A6C5414655E4341223003504D4A1D6B74246A4C381F17167C5F72315D61207D65616601320560766A63407D03415829640376727F6214786420696261720E33767C180F7F6E4C3A6F1738781B40654E6A31574E747861426E70011B087D17694357615B010352305E517467086F6216631174482D0A27436E59587746334F5A3B1A174B560B500F72663663626F482A0B10445B47727B5F2918192F4613147C69753C6E7968665561130F71366843691C5D1F205D7D007A2663531665737F7317055D164017762C67194C78496E7C1F1738052F4E4E126331537028724149100B700A505E6852761A";

        /* renamed from: ̍ */
        public static String f4531 = "29452F09444D55271773334545615734";

        /* renamed from: ̎ */
        public static String f4532 = "2B462E";

        /* renamed from: ̐ */
        public static String f4533 = "3D422B535217572D584C22";

        private DATA() {
        }
    }
}

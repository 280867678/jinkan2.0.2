package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import me.tvspark.outline;
import org.litepal.parser.LitePalParser;
import org.mozilla.javascript.tools.idswitch.Main;
import org.simpleframework.xml.transform.ClassTransform;

/* renamed from: com.tencent.bugly.proguard.a */
/* loaded from: classes3.dex */
public class C1202a {
    /* renamed from: a */
    public static String m3071a(String str) {
        if (str.equals("java.lang.Integer") || str.equals(ClassTransform.INTEGER)) {
            return "int32";
        }
        if (str.equals("java.lang.Boolean") || str.equals(ClassTransform.BOOLEAN)) {
            return "bool";
        }
        if (str.equals("java.lang.Byte") || str.equals(ClassTransform.BYTE)) {
            return ClassTransform.CHARACTER;
        }
        boolean equals = str.equals("java.lang.Double");
        String str2 = ClassTransform.DOUBLE;
        if (!equals && !str.equals(str2)) {
            boolean equals2 = str.equals("java.lang.Float");
            str2 = ClassTransform.FLOAT;
            if (!equals2 && !str.equals(str2)) {
                if (str.equals("java.lang.Long") || str.equals(ClassTransform.LONG)) {
                    return "int64";
                }
                if (str.equals("java.lang.Short") || str.equals(ClassTransform.SHORT)) {
                    return ClassTransform.SHORT;
                }
                if (str.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                }
                return str.equals("java.lang.String") ? Main.STRING_TAG_STR : str.equals("java.util.List") ? LitePalParser.NODE_LIST : str.equals("java.util.Map") ? "map" : str;
            }
        }
        return str2;
    }

    /* renamed from: a */
    public static String m3070a(ArrayList<String> arrayList) {
        StringBuilder sb;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, m3071a(arrayList.get(i)));
        }
        Collections.reverse(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = arrayList.get(i2);
            if (str.equals(LitePalParser.NODE_LIST)) {
                int i3 = i2 - 1;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(arrayList.get(i3));
                arrayList.set(i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                sb = new StringBuilder();
            } else if (str.equals("map")) {
                int i4 = i2 - 1;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(arrayList.get(i4));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(",");
                arrayList.set(i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                sb = new StringBuilder();
            } else if (str.equals("Array")) {
                int i5 = i2 - 1;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(arrayList.get(i5));
                arrayList.set(i5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                sb = new StringBuilder();
            }
            sb.append(arrayList.get(0));
            sb.append(">");
            arrayList.set(0, sb.toString());
        }
        Collections.reverse(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }
}

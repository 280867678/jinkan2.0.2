package cn.qqtheme.framework.entity;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class JavaBean implements Serializable {
    public static final long serialVersionUID = -6111323241670458039L;

    public String toString() {
        Field[] fieldArr;
        Field[] declaredFields;
        ArrayList arrayList = new ArrayList();
        Class<?> cls = getClass();
        arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (cls == Object.class) {
                break;
            }
            cls = cls.getSuperclass();
            for (Field field : cls.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                    arrayList.add(field);
                }
            }
        }
        for (Field field2 : (Field[]) arrayList.toArray(new Field[arrayList.size()])) {
            String name = field2.getName();
            try {
                Object obj = field2.get(this);
                sb.append(name);
                sb.append("=");
                sb.append(obj);
                sb.append("\n");
            } catch (IllegalAccessException e) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                e.printStackTrace(printWriter);
                String stringWriter2 = stringWriter.toString();
                if (stringWriter2.length() > 131071) {
                    stringWriter2.substring(0, 131047);
                }
                printWriter.close();
            }
        }
        return sb.toString();
    }
}

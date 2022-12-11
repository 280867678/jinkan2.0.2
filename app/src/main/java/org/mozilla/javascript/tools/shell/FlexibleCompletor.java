package org.mozilla.javascript.tools.shell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import me.tvspark.outline;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* loaded from: classes5.dex */
public class FlexibleCompletor implements InvocationHandler {
    public Method completeMethod;
    public Scriptable global;

    public FlexibleCompletor(Class<?> cls, Scriptable scriptable) throws NoSuchMethodException {
        this.global = scriptable;
        this.completeMethod = cls.getMethod("complete", String.class, Integer.TYPE, List.class);
    }

    public int complete(String str, int i, List<String> list) {
        int i2 = i - 1;
        while (i2 >= 0) {
            char charAt = str.charAt(i2);
            if (!Character.isJavaIdentifierPart(charAt) && charAt != '.') {
                break;
            }
            i2--;
        }
        String[] split = str.substring(i2 + 1, i).split("\\.", -1);
        Scriptable scriptable = this.global;
        for (int i3 = 0; i3 < split.length - 1; i3++) {
            Object obj = scriptable.get(split[i3], this.global);
            if (!(obj instanceof Scriptable)) {
                return str.length();
            }
            scriptable = (Scriptable) obj;
        }
        Object[] allIds = scriptable instanceof ScriptableObject ? ((ScriptableObject) scriptable).getAllIds() : scriptable.getIds();
        String str2 = split[split.length - 1];
        for (int i4 = 0; i4 < allIds.length; i4++) {
            if (allIds[i4] instanceof String) {
                String str3 = (String) allIds[i4];
                if (str3.startsWith(str2)) {
                    if (scriptable.get(str3, scriptable) instanceof Function) {
                        str3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, "(");
                    }
                    list.add(str3);
                }
            }
        }
        return str.length() - str2.length();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.equals(this.completeMethod)) {
            return Integer.valueOf(complete((String) objArr[0], ((Integer) objArr[1]).intValue(), (List) objArr[2]));
        }
        throw new NoSuchMethodError(method.toString());
    }
}

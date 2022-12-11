package org.litepal.util;

import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Locale;
import org.litepal.LitePalApplication;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.parser.LitePalAttr;
import org.litepal.util.Const;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes5.dex */
public class BaseUtility {
    public static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            if (str != null) {
                return "";
            }
            return null;
        }
        return str.substring(0, 1).toUpperCase(Locale.US) + str.substring(1);
    }

    public static String changeCase(String str) {
        if (str != null) {
            String cases = LitePalAttr.getInstance().getCases();
            return Const.Config.CASES_KEEP.equals(cases) ? str : Const.Config.CASES_UPPER.equals(cases) ? str.toUpperCase(Locale.US) : str.toLowerCase(Locale.US);
        }
        return null;
    }

    public static void checkConditionsCorrect(String... strArr) {
        int length;
        if (strArr == null || (length = strArr.length) <= 0 || length == count(strArr[0], "?") + 1) {
            return;
        }
        throw new LitePalSupportException(LitePalSupportException.UPDATE_CONDITIONS_EXCEPTION);
    }

    public static boolean containsIgnoreCases(Collection<String> collection, String str) {
        if (collection == null) {
            return false;
        }
        if (str == null) {
            return collection.contains(null);
        }
        for (String str2 : collection) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public static int count(String str, String str2) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            while (true) {
                int indexOf = str.indexOf(str2);
                if (indexOf == -1) {
                    break;
                }
                i++;
                str = str.substring(str2.length() + indexOf);
            }
        }
        return i;
    }

    public static boolean isClassAndMethodExist(String str, String str2) {
        try {
            for (Method method : Class.forName(str).getMethods()) {
                if (str2.equals(method.getName())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isFieldTypeSupported(String str) {
        return ClassTransform.BOOLEAN.equals(str) || "java.lang.Boolean".equals(str) || ClassTransform.FLOAT.equals(str) || "java.lang.Float".equals(str) || ClassTransform.DOUBLE.equals(str) || "java.lang.Double".equals(str) || ClassTransform.INTEGER.equals(str) || "java.lang.Integer".equals(str) || ClassTransform.LONG.equals(str) || "java.lang.Long".equals(str) || ClassTransform.SHORT.equals(str) || "java.lang.Short".equals(str) || ClassTransform.CHARACTER.equals(str) || "java.lang.Character".equals(str) || "[B".equals(str) || "[Ljava.lang.Byte;".equals(str) || "java.lang.String".equals(str) || "java.util.Date".equals(str);
    }

    public static boolean isGenericTypeSupported(String str) {
        return "java.lang.String".equals(str) || "java.lang.Integer".equals(str) || "java.lang.Float".equals(str) || "java.lang.Double".equals(str) || "java.lang.Long".equals(str) || "java.lang.Short".equals(str) || "java.lang.Boolean".equals(str) || "java.lang.Character".equals(str);
    }

    public static boolean isLitePalXMLExists() {
        try {
            String[] list = LitePalApplication.getContext().getAssets().list("");
            if (list != null && list.length > 0) {
                for (String str : list) {
                    if (Const.Config.CONFIGURATION_FILE_NAME.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
        } catch (IOException unused) {
        }
        return false;
    }
}

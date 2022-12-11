package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.umeng.commonsdk.debug.UMLog;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class Debug {
    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String str) {
        Field[] fields;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getFileName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getLineNumber());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("  ");
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        PrintStream printStream = System.out;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(" >>>>>>>>>>>>>>>>>>. dump ", sb, "  ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(layoutParams.getClass().getName());
        printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        for (Field field : layoutParams.getClass().getFields()) {
            try {
                Object obj = field.get(layoutParams);
                String name = field.getName();
                if (name.contains("To") && !obj.toString().equals("-1")) {
                    System.out.println(sb + "       " + name + StringUtils.SPACE + obj);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + sb);
    }

    public static void dumpLayoutParams(ViewGroup viewGroup, String str) {
        Field[] fields;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getFileName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getLineNumber());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("  ");
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        int childCount = viewGroup.getChildCount();
        System.out.println(str + " children " + childCount);
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            PrintStream printStream = System.out;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, UMLog.INDENT);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName(childAt));
            printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            for (Field field : layoutParams.getClass().getFields()) {
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To") && !obj.toString().equals("-1")) {
                        System.out.println(sb + "       " + field.getName() + StringUtils.SPACE + obj);
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public static void dumpPoc(Object obj) {
        Field[] fields;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getFileName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getLineNumber());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        Class<?> cls = obj.getClass();
        PrintStream printStream = System.out;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "------------- ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" --------------------");
        printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        for (Field field : cls.getFields()) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint") && ((!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) && ((!(obj2 instanceof Integer) || !obj2.toString().equals("0")) && ((!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) && (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")))))) {
                    System.out.println(sb + "    " + field.getName() + StringUtils.SPACE + obj2);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        PrintStream printStream2 = System.out;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "------------- ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" --------------------");
        printStream2.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
    }

    public static String getActionType(MotionEvent motionEvent) {
        Field[] fields;
        int action = motionEvent.getAction();
        for (Field field : MotionEvent.class.getFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static String getCallFrom(int i) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i + 2];
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getFileName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getLineNumber());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getFileName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getLineNumber());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getMethodName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("()");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getFileName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getLineNumber());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getFileName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.getLineNumber());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public static String getName(Context context, int i) {
        if (i != -1) {
            try {
                return context.getResources().getResourceEntryName(i);
            } catch (Exception unused) {
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("?", i);
            }
        }
        return "UNKNOWN";
    }

    public static String getName(Context context, int[] iArr) {
        String str;
        try {
            String str2 = iArr.length + "[";
            int i = 0;
            while (i < iArr.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(i == 0 ? "" : StringUtils.SPACE);
                String sb2 = sb.toString();
                try {
                    str = context.getResources().getResourceEntryName(iArr[i]);
                } catch (Resources.NotFoundException unused) {
                    str = "? " + iArr[i] + StringUtils.SPACE;
                }
                str2 = sb2 + str;
                i++;
            }
            return str2 + "]";
        } catch (Exception e) {
            e.toString();
            return "UNKNOWN";
        }
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout motionLayout, int i) {
        return i == -1 ? "UNDEFINED" : motionLayout.getContext().getResources().getResourceEntryName(i);
    }

    public static void logStack(String str, String str2, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length - 1);
        String str3 = StringUtils.SPACE;
        for (int i2 = 1; i2 <= min; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTrace[i2].getFileName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTrace[i2].getLineNumber());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTrace[i2].getMethodName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            str3 = str3 + StringUtils.SPACE;
        }
    }

    public static void printStack(String str, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length - 1);
        String str2 = StringUtils.SPACE;
        for (int i2 = 1; i2 <= min; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTrace[i2].getFileName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTrace[i2].getLineNumber());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            str2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, StringUtils.SPACE);
            PrintStream printStream = System.out;
            printStream.println(str + str2 + sb + str2);
        }
    }
}

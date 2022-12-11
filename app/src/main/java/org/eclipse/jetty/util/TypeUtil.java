package org.eclipse.jetty.util;

import androidx.core.view.DisplayCompat;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import me.tvspark.outline;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.mozilla.javascript.tools.idswitch.Main;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes5.dex */
public class TypeUtil {
    public static final HashMap<Class<?>, String> class2Name;
    public static final HashMap<Class<?>, Method> class2Value;
    public static final HashMap<String, Class<?>> name2Class;
    public static final Logger LOG = Log.getLogger(TypeUtil.class);

    /* renamed from: CR */
    public static int f4595CR = 13;

    /* renamed from: LF */
    public static int f4596LF = 10;

    static {
        HashMap<String, Class<?>> hashMap = new HashMap<>();
        name2Class = hashMap;
        hashMap.put(ClassTransform.BOOLEAN, Boolean.TYPE);
        name2Class.put(ClassTransform.BYTE, Byte.TYPE);
        name2Class.put(ClassTransform.CHARACTER, Character.TYPE);
        name2Class.put(ClassTransform.DOUBLE, Double.TYPE);
        name2Class.put(ClassTransform.FLOAT, Float.TYPE);
        name2Class.put(ClassTransform.INTEGER, Integer.TYPE);
        name2Class.put(ClassTransform.LONG, Long.TYPE);
        name2Class.put(ClassTransform.SHORT, Short.TYPE);
        name2Class.put(ClassTransform.VOID, Void.TYPE);
        name2Class.put("java.lang.Boolean.TYPE", Boolean.TYPE);
        name2Class.put("java.lang.Byte.TYPE", Byte.TYPE);
        name2Class.put("java.lang.Character.TYPE", Character.TYPE);
        name2Class.put("java.lang.Double.TYPE", Double.TYPE);
        name2Class.put("java.lang.Float.TYPE", Float.TYPE);
        name2Class.put("java.lang.Integer.TYPE", Integer.TYPE);
        name2Class.put("java.lang.Long.TYPE", Long.TYPE);
        name2Class.put("java.lang.Short.TYPE", Short.TYPE);
        name2Class.put("java.lang.Void.TYPE", Void.TYPE);
        name2Class.put("java.lang.Boolean", Boolean.class);
        name2Class.put("java.lang.Byte", Byte.class);
        name2Class.put("java.lang.Character", Character.class);
        name2Class.put("java.lang.Double", Double.class);
        name2Class.put("java.lang.Float", Float.class);
        name2Class.put("java.lang.Integer", Integer.class);
        name2Class.put("java.lang.Long", Long.class);
        name2Class.put("java.lang.Short", Short.class);
        name2Class.put("Boolean", Boolean.class);
        name2Class.put("Byte", Byte.class);
        name2Class.put("Character", Character.class);
        name2Class.put("Double", Double.class);
        name2Class.put("Float", Float.class);
        name2Class.put("Integer", Integer.class);
        name2Class.put("Long", Long.class);
        name2Class.put("Short", Short.class);
        name2Class.put(null, Void.TYPE);
        name2Class.put(Main.STRING_TAG_STR, String.class);
        name2Class.put("String", String.class);
        name2Class.put("java.lang.String", String.class);
        HashMap<Class<?>, String> hashMap2 = new HashMap<>();
        class2Name = hashMap2;
        hashMap2.put(Boolean.TYPE, ClassTransform.BOOLEAN);
        class2Name.put(Byte.TYPE, ClassTransform.BYTE);
        class2Name.put(Character.TYPE, ClassTransform.CHARACTER);
        class2Name.put(Double.TYPE, ClassTransform.DOUBLE);
        class2Name.put(Float.TYPE, ClassTransform.FLOAT);
        class2Name.put(Integer.TYPE, ClassTransform.INTEGER);
        class2Name.put(Long.TYPE, ClassTransform.LONG);
        class2Name.put(Short.TYPE, ClassTransform.SHORT);
        class2Name.put(Void.TYPE, ClassTransform.VOID);
        class2Name.put(Boolean.class, "java.lang.Boolean");
        class2Name.put(Byte.class, "java.lang.Byte");
        class2Name.put(Character.class, "java.lang.Character");
        class2Name.put(Double.class, "java.lang.Double");
        class2Name.put(Float.class, "java.lang.Float");
        class2Name.put(Integer.class, "java.lang.Integer");
        class2Name.put(Long.class, "java.lang.Long");
        class2Name.put(Short.class, "java.lang.Short");
        class2Name.put(null, ClassTransform.VOID);
        class2Name.put(String.class, "java.lang.String");
        HashMap<Class<?>, Method> hashMap3 = new HashMap<>();
        class2Value = hashMap3;
        try {
            Class[] clsArr = {String.class};
            hashMap3.put(Boolean.TYPE, Boolean.class.getMethod("valueOf", clsArr));
            class2Value.put(Byte.TYPE, Byte.class.getMethod("valueOf", clsArr));
            class2Value.put(Double.TYPE, Double.class.getMethod("valueOf", clsArr));
            class2Value.put(Float.TYPE, Float.class.getMethod("valueOf", clsArr));
            class2Value.put(Integer.TYPE, Integer.class.getMethod("valueOf", clsArr));
            class2Value.put(Long.TYPE, Long.class.getMethod("valueOf", clsArr));
            class2Value.put(Short.TYPE, Short.class.getMethod("valueOf", clsArr));
            class2Value.put(Boolean.class, Boolean.class.getMethod("valueOf", clsArr));
            class2Value.put(Byte.class, Byte.class.getMethod("valueOf", clsArr));
            class2Value.put(Double.class, Double.class.getMethod("valueOf", clsArr));
            class2Value.put(Float.class, Float.class.getMethod("valueOf", clsArr));
            class2Value.put(Integer.class, Integer.class.getMethod("valueOf", clsArr));
            class2Value.put(Long.class, Long.class.getMethod("valueOf", clsArr));
            class2Value.put(Short.class, Short.class.getMethod("valueOf", clsArr));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static <T> List<T> asList(T[] tArr) {
        return tArr == null ? Collections.emptyList() : Arrays.asList(tArr);
    }

    public static Object call(Class<?> cls, String str, Object obj, Object[] objArr) throws InvocationTargetException, NoSuchMethodException {
        Method[] methods = cls.getMethods();
        for (int i = 0; methods != null && i < methods.length; i++) {
            if (methods[i].getName().equals(str) && methods[i].getParameterTypes().length == objArr.length) {
                if (Modifier.isStatic(methods[i].getModifiers()) == (obj == null) && (obj != null || methods[i].getDeclaringClass() == cls)) {
                    try {
                        return methods[i].invoke(obj, objArr);
                    } catch (IllegalAccessException | IllegalArgumentException e) {
                        LOG.ignore(e);
                    }
                }
            }
        }
        throw new NoSuchMethodException(str);
    }

    public static byte convertHexDigit(byte b) {
        byte b2 = (byte) ((((b >> 6) * 25) + (b & 31)) - 16);
        if (b2 < 0 || b2 > 15) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("!hex ", (int) b));
        }
        return b2;
    }

    public static int convertHexDigit(int i) {
        int i2 = (((i >> 6) * 25) + (i & 31)) - 16;
        if (i2 < 0 || i2 > 15) {
            throw new NumberFormatException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("!hex ", i));
        }
        return i2;
    }

    public static void dump(Class<?> cls) {
        PrintStream printStream = System.err;
        printStream.println("Dump: " + cls);
        dump(cls.getClassLoader());
    }

    public static void dump(ClassLoader classLoader) {
        System.err.println("Dump Loaders:");
        while (classLoader != null) {
            PrintStream printStream = System.err;
            printStream.println("  loader " + classLoader);
            classLoader = classLoader.getParent();
        }
    }

    public static byte[] fromHexString(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            }
            return bArr;
        }
        throw new IllegalArgumentException(str);
    }

    public static Class<?> fromName(String str) {
        return name2Class.get(str);
    }

    public static URL jarFor(String str) {
        try {
            String url = Loader.getResource(null, str.replace('.', '/') + ".class", false).toString();
            if (url.startsWith("jar:file:")) {
                return new URL(url.substring(4, url.indexOf("!/")));
            }
        } catch (Exception e) {
            LOG.ignore(e);
        }
        return null;
    }

    public static byte[] parseBytes(String str, int i) {
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < str.length(); i2 += 2) {
            bArr[i2 / 2] = (byte) parseInt(str, i2, 2, i);
        }
        return bArr;
    }

    public static int parseInt(String str, int i, int i2, int i3) throws NumberFormatException {
        if (i2 < 0) {
            i2 = str.length() - i;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int convertHexDigit = convertHexDigit(str.charAt(i + i5));
            if (convertHexDigit < 0 || convertHexDigit >= i3) {
                throw new NumberFormatException(str.substring(i, i2 + i));
            }
            i4 = (i4 * i3) + convertHexDigit;
        }
        return i4;
    }

    public static int parseInt(byte[] bArr, int i, int i2, int i3) throws NumberFormatException {
        char c;
        int i4;
        if (i2 < 0) {
            i2 = bArr.length - i;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = ((char) (bArr[i + i6] & 255)) - '0';
            if ((i7 < 0 || i7 >= i3 || i7 >= 10) && ((i4 = c + '\n') - 65 < 10 || i7 >= i3)) {
                i7 = i4 - 97;
            }
            if (i7 < 0 || i7 >= i3) {
                throw new NumberFormatException(new String(bArr, i, i2));
            }
            i5 = (i5 * i3) + i7;
        }
        return i5;
    }

    public static byte[] readLine(InputStream inputStream) throws IOException {
        int read;
        byte[] bArr = new byte[256];
        int i = 0;
        int i2 = 0;
        while (true) {
            read = inputStream.read();
            if (read < 0) {
                break;
            }
            i++;
            if (i != 1 || read != f4596LF) {
                if (read == f4595CR || read == f4596LF) {
                    break;
                }
                if (i2 >= bArr.length) {
                    byte[] bArr2 = new byte[bArr.length + 256];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    bArr = bArr2;
                }
                bArr[i2] = (byte) read;
                i2++;
            }
        }
        if (read == -1 && i2 == 0) {
            return null;
        }
        if (read == f4595CR && inputStream.available() >= 1 && inputStream.markSupported()) {
            inputStream.mark(1);
            if (inputStream.read() != f4596LF) {
                inputStream.reset();
            }
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, 0, bArr3, 0, i2);
        return bArr3;
    }

    public static void toHex(byte b, Appendable appendable) {
        int i = ((b & 240) >> 4) & 15;
        int i2 = 55;
        try {
            appendable.append((char) ((i > 9 ? 55 : 48) + i));
            int i3 = b & 15;
            if (i3 <= 9) {
                i2 = 48;
            }
            appendable.append((char) (i2 + i3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void toHex(int i, Appendable appendable) throws IOException {
        int i2 = (((-268435456) & i) >> 28) & 15;
        int i3 = 55;
        appendable.append((char) ((i2 > 9 ? 55 : 48) + i2));
        int i4 = ((251658240 & i) >> 24) & 15;
        appendable.append((char) ((i4 > 9 ? 55 : 48) + i4));
        int i5 = ((15728640 & i) >> 20) & 15;
        appendable.append((char) ((i5 > 9 ? 55 : 48) + i5));
        int i6 = ((983040 & i) >> 16) & 15;
        appendable.append((char) ((i6 > 9 ? 55 : 48) + i6));
        int i7 = ((61440 & i) >> 12) & 15;
        appendable.append((char) ((i7 > 9 ? 55 : 48) + i7));
        int i8 = ((i & DisplayCompat.DISPLAY_SIZE_4K_WIDTH) >> 8) & 15;
        appendable.append((char) ((i8 > 9 ? 55 : 48) + i8));
        int i9 = ((i & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >> 4) & 15;
        appendable.append((char) ((i9 > 9 ? 55 : 48) + i9));
        int i10 = i & 15;
        if (i10 <= 9) {
            i3 = 48;
        }
        appendable.append((char) (i3 + i10));
        Integer.toString(0, 36);
    }

    public static void toHex(long j, Appendable appendable) throws IOException {
        toHex((int) (j >> 32), appendable);
        toHex((int) j, appendable);
    }

    public static String toHexString(byte b) {
        return toHexString(new byte[]{b}, 0, 1);
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = i; i3 < i + i2; i3++) {
            int i4 = bArr[i3] & 255;
            int i5 = ((i4 / 16) % 16) + 48;
            if (i5 > 57) {
                i5 = ((i5 - 48) - 10) + 65;
            }
            sb.append((char) i5);
            int i6 = (i4 % 16) + 48;
            if (i6 > 57) {
                i6 = ((i6 - 48) - 10) + 97;
            }
            sb.append((char) i6);
        }
        return sb.toString();
    }

    public static String toName(Class<?> cls) {
        return class2Name.get(cls);
    }

    public static String toString(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 : bArr) {
            int i3 = i2 & 255;
            int i4 = ((i3 / i) % i) + 48;
            if (i4 > 57) {
                i4 = ((i4 - 48) - 10) + 97;
            }
            sb.append((char) i4);
            int i5 = (i3 % i) + 48;
            if (i5 > 57) {
                i5 = ((i5 - 48) - 10) + 97;
            }
            sb.append((char) i5);
        }
        return sb.toString();
    }

    public static Object valueOf(Class<?> cls, String str) {
        try {
            if (cls.equals(String.class)) {
                return str;
            }
            Method method = class2Value.get(cls);
            if (method != null) {
                return method.invoke(null, str);
            }
            if (!cls.equals(Character.TYPE) && !cls.equals(Character.class)) {
                return cls.getConstructor(String.class).newInstance(str);
            }
            return new Character(str.charAt(0));
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            if (e.getTargetException() instanceof Error) {
                throw ((Error) e.getTargetException());
            }
            return null;
        }
    }

    public static Object valueOf(String str, String str2) {
        return valueOf(fromName(str), str2);
    }
}

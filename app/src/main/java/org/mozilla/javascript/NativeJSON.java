package org.mozilla.javascript;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import me.tvspark.outline;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.TokenParser;
import org.mozilla.javascript.json.JsonParser;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes5.dex */
public final class NativeJSON extends IdScriptableObject {
    public static final int Id_parse = 2;
    public static final int Id_stringify = 3;
    public static final int Id_toSource = 1;
    public static final Object JSON_TAG = "JSON";
    public static final int LAST_METHOD_ID = 3;
    public static final int MAX_ID = 3;
    public static final int MAX_STRINGIFY_GAP_LENGTH = 10;
    public static final long serialVersionUID = -4567599697595654984L;

    /* loaded from: classes5.dex */
    public static class StringifyState {

        /* renamed from: cx */
        public Context f4672cx;
        public String gap;
        public String indent;
        public List<Object> propertyList;
        public Callable replacer;
        public Scriptable scope;
        public Object space;
        public Stack<Scriptable> stack = new Stack<>();

        public StringifyState(Context context, Scriptable scriptable, String str, String str2, Callable callable, List<Object> list, Object obj) {
            this.f4672cx = context;
            this.scope = scriptable;
            this.indent = str;
            this.gap = str2;
            this.replacer = callable;
            this.propertyList = list;
            this.space = obj;
        }
    }

    public static void init(Scriptable scriptable, boolean z) {
        NativeJSON nativeJSON = new NativeJSON();
        nativeJSON.activatePrototypeMap(3);
        nativeJSON.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeJSON.setParentScope(scriptable);
        if (z) {
            nativeJSON.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "JSON", nativeJSON, 2);
    }

    /* renamed from: ja */
    public static String m28ja(NativeArray nativeArray, StringifyState stringifyState) {
        String sb;
        if (stringifyState.stack.search(nativeArray) == -1) {
            stringifyState.stack.push(nativeArray);
            String str = stringifyState.indent;
            stringifyState.indent += stringifyState.gap;
            LinkedList linkedList = new LinkedList();
            long length = nativeArray.getLength();
            long j = 0;
            while (j < length) {
                Object str2 = str(j > 2147483647L ? Long.toString(j) : Integer.valueOf((int) j), nativeArray, stringifyState);
                if (str2 == Undefined.instance) {
                    str2 = "null";
                }
                linkedList.add(str2);
                j++;
            }
            if (linkedList.isEmpty()) {
                sb = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else if (stringifyState.gap.length() == 0) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[');
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(join(linkedList, ","));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
                sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(",\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(stringifyState.indent);
                String join = join(linkedList, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(stringifyState.indent);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(join);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append('\n');
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(str);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(']');
                sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
            }
            stringifyState.stack.pop();
            stringifyState.indent = str;
            return sb;
        }
        throw ScriptRuntime.typeError0("msg.cyclic.value");
    }

    /* renamed from: jo */
    public static String m27jo(Scriptable scriptable, StringifyState stringifyState) {
        String sb;
        if (stringifyState.stack.search(scriptable) == -1) {
            stringifyState.stack.push(scriptable);
            String str = stringifyState.indent;
            stringifyState.indent += stringifyState.gap;
            List<Object> list = stringifyState.propertyList;
            Object[] array = list != null ? list.toArray() : scriptable.getIds();
            LinkedList linkedList = new LinkedList();
            for (Object obj : array) {
                Object str2 = str(obj, scriptable, stringifyState);
                if (str2 != Undefined.instance) {
                    String str3 = quote(obj.toString()) + ":";
                    if (stringifyState.gap.length() > 0) {
                        str3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, StringUtils.SPACE);
                    }
                    linkedList.add(str3 + str2);
                }
            }
            if (linkedList.isEmpty()) {
                sb = MessageFormatter.DELIM_STR;
            } else if (stringifyState.gap.length() == 0) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('{');
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(join(linkedList, ","));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
                sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(",\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(stringifyState.indent);
                String join = join(linkedList, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("{\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(stringifyState.indent);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(join);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append('\n');
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(str);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append('}');
                sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
            }
            stringifyState.stack.pop();
            stringifyState.indent = str;
            return sb;
        }
        throw ScriptRuntime.typeError0("msg.cyclic.value");
    }

    public static String join(Collection<Object> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        Iterator<Object> it = collection.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(it.next().toString());
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    public static Object parse(Context context, Scriptable scriptable, String str) {
        try {
            return new JsonParser(context, scriptable).parseValue(str);
        } catch (JsonParser.ParseException e) {
            throw ScriptRuntime.constructError("SyntaxError", e.getMessage());
        }
    }

    public static Object parse(Context context, Scriptable scriptable, String str, Callable callable) {
        Object parse = parse(context, scriptable, str);
        Scriptable newObject = context.newObject(scriptable);
        newObject.put("", newObject, parse);
        return walk(context, scriptable, callable, newObject, "");
    }

    public static String quote(String str) {
        String str2;
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                str2 = "\\f";
            } else if (charAt == '\r') {
                str2 = "\\r";
            } else if (charAt == '\"') {
                str2 = "\\\"";
            } else if (charAt != '\\') {
                switch (charAt) {
                    case '\b':
                        str2 = "\\b";
                        break;
                    case '\t':
                        str2 = "\\t";
                        break;
                    case '\n':
                        str2 = "\\n";
                        break;
                    default:
                        if (charAt < ' ') {
                            sb.append("\\u");
                            str2 = String.format("%04x", Integer.valueOf(charAt));
                            break;
                        } else {
                            sb.append(charAt);
                            continue;
                        }
                }
            } else {
                str2 = "\\\\";
            }
            sb.append(str2);
        }
        sb.append('\"');
        return sb.toString();
    }

    public static String repeat(char c, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    public static Object str(Object obj, Scriptable scriptable, StringifyState stringifyState) {
        Object property = obj instanceof String ? ScriptableObject.getProperty(scriptable, (String) obj) : ScriptableObject.getProperty(scriptable, ((Number) obj).intValue());
        if (property instanceof Scriptable) {
            Scriptable scriptable2 = (Scriptable) property;
            if (ScriptableObject.hasProperty(scriptable2, "toJSON") && (ScriptableObject.getProperty(scriptable2, "toJSON") instanceof Callable)) {
                property = ScriptableObject.callMethod(stringifyState.f4672cx, scriptable2, "toJSON", new Object[]{obj});
            }
        }
        Callable callable = stringifyState.replacer;
        if (callable != null) {
            property = callable.call(stringifyState.f4672cx, stringifyState.scope, scriptable, new Object[]{obj, property});
        }
        if (property instanceof NativeNumber) {
            property = Double.valueOf(ScriptRuntime.toNumber(property));
        } else if (property instanceof NativeString) {
            property = ScriptRuntime.toString(property);
        } else if (property instanceof NativeBoolean) {
            property = ((NativeBoolean) property).getDefaultValue(ScriptRuntime.BooleanClass);
        }
        if (property == null) {
            return "null";
        }
        if (property.equals(Boolean.TRUE)) {
            return "true";
        }
        if (property.equals(Boolean.FALSE)) {
            return "false";
        }
        if (property instanceof CharSequence) {
            return quote(property.toString());
        }
        if (!(property instanceof Number)) {
            return (!(property instanceof Scriptable) || (property instanceof Callable)) ? Undefined.instance : property instanceof NativeArray ? m28ja((NativeArray) property, stringifyState) : m27jo((Scriptable) property, stringifyState);
        }
        double doubleValue = ((Number) property).doubleValue();
        return (doubleValue != doubleValue || doubleValue == Double.POSITIVE_INFINITY || doubleValue == Double.NEGATIVE_INFINITY) ? "null" : ScriptRuntime.toString(property);
    }

    public static Object stringify(Context context, Scriptable scriptable, Object obj, Object obj2, Object obj3) {
        Callable callable;
        LinkedList linkedList;
        Object obj4;
        String str;
        String str2;
        if (obj2 instanceof Callable) {
            callable = (Callable) obj2;
            linkedList = null;
        } else if (obj2 instanceof NativeArray) {
            LinkedList linkedList2 = new LinkedList();
            NativeArray nativeArray = (NativeArray) obj2;
            for (Integer num : nativeArray.getIndexIds()) {
                Object obj5 = nativeArray.get(num.intValue(), nativeArray);
                if (!(obj5 instanceof String) && !(obj5 instanceof Number)) {
                    if ((obj5 instanceof NativeString) || (obj5 instanceof NativeNumber)) {
                        obj5 = ScriptRuntime.toString(obj5);
                    }
                }
                linkedList2.add(obj5);
            }
            linkedList = linkedList2;
            callable = null;
        } else {
            callable = null;
            linkedList = null;
        }
        Object valueOf = obj3 instanceof NativeNumber ? Double.valueOf(ScriptRuntime.toNumber(obj3)) : obj3 instanceof NativeString ? ScriptRuntime.toString(obj3) : obj3;
        if (valueOf instanceof Number) {
            int min = Math.min(10, (int) ScriptRuntime.toInteger(valueOf));
            str2 = min > 0 ? repeat(TokenParser.f4579SP, min) : "";
            valueOf = Integer.valueOf(min);
        } else if (!(valueOf instanceof String)) {
            obj4 = valueOf;
            str = "";
            StringifyState stringifyState = new StringifyState(context, scriptable, "", str, callable, linkedList, obj4);
            NativeObject nativeObject = new NativeObject();
            nativeObject.setParentScope(scriptable);
            nativeObject.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
            nativeObject.defineProperty("", obj, 0);
            return str("", nativeObject, stringifyState);
        } else {
            str2 = (String) valueOf;
            if (str2.length() > 10) {
                str2 = str2.substring(0, 10);
            }
        }
        obj4 = valueOf;
        str = str2;
        StringifyState stringifyState2 = new StringifyState(context, scriptable, "", str, callable, linkedList, obj4);
        NativeObject nativeObject2 = new NativeObject();
        nativeObject2.setParentScope(scriptable);
        nativeObject2.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeObject2.defineProperty("", obj, 0);
        return str("", nativeObject2, stringifyState2);
    }

    public static Object walk(Context context, Scriptable scriptable, Callable callable, Scriptable scriptable2, Object obj) {
        Object[] ids;
        Object obj2 = obj instanceof Number ? scriptable2.get(((Number) obj).intValue(), scriptable2) : scriptable2.get((String) obj, scriptable2);
        if (obj2 instanceof Scriptable) {
            Scriptable scriptable3 = (Scriptable) obj2;
            if (scriptable3 instanceof NativeArray) {
                long length = ((NativeArray) scriptable3).getLength();
                for (long j = 0; j < length; j++) {
                    if (j > 2147483647L) {
                        String l = Long.toString(j);
                        Object walk = walk(context, scriptable, callable, scriptable3, l);
                        if (walk == Undefined.instance) {
                            scriptable3.delete(l);
                        } else {
                            scriptable3.put(l, scriptable3, walk);
                        }
                    } else {
                        int i = (int) j;
                        Object walk2 = walk(context, scriptable, callable, scriptable3, Integer.valueOf(i));
                        if (walk2 == Undefined.instance) {
                            scriptable3.delete(i);
                        } else {
                            scriptable3.put(i, scriptable3, walk2);
                        }
                    }
                }
            } else {
                for (Object obj3 : scriptable3.getIds()) {
                    Object walk3 = walk(context, scriptable, callable, scriptable3, obj3);
                    if (walk3 == Undefined.instance) {
                        if (obj3 instanceof Number) {
                            scriptable3.delete(((Number) obj3).intValue());
                        } else {
                            scriptable3.delete((String) obj3);
                        }
                    } else if (obj3 instanceof Number) {
                        scriptable3.put(((Number) obj3).intValue(), scriptable3, walk3);
                    } else {
                        scriptable3.put((String) obj3, scriptable3, walk3);
                    }
                }
            }
        }
        return callable.call(context, scriptable, scriptable2, new Object[]{obj, obj2});
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        Object obj2;
        Object obj3;
        if (!idFunctionObject.hasTag(JSON_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            return "JSON";
        }
        Callable callable = null;
        if (methodId == 2) {
            String scriptRuntime = ScriptRuntime.toString(objArr, 0);
            if (objArr.length > 1) {
                callable = objArr[1];
            }
            return callable instanceof Callable ? parse(context, scriptable, scriptRuntime, callable) : parse(context, scriptable, scriptRuntime);
        } else if (methodId != 3) {
            throw new IllegalStateException(String.valueOf(methodId));
        } else {
            int length = objArr.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        obj3 = null;
                        obj2 = null;
                        return stringify(context, scriptable, callable, obj3, obj2);
                    }
                    callable = objArr[2];
                }
                Object obj4 = callable;
                callable = objArr[1];
                obj = obj4;
            } else {
                obj = null;
            }
            obj2 = obj;
            obj3 = callable;
            callable = objArr[0];
            return stringify(context, scriptable, callable, obj3, obj2);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 5) {
            str2 = "parse";
            i = 2;
        } else if (length == 8) {
            str2 = "toSource";
            i = 1;
        } else if (length != 9) {
            str2 = null;
            i = 0;
        } else {
            str2 = "stringify";
            i = 3;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JSON";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        int i2 = 3;
        if (i <= 3) {
            if (i == 1) {
                i2 = 0;
                str = "toSource";
            } else if (i == 2) {
                str = "parse";
                i2 = 2;
            } else if (i != 3) {
                throw new IllegalStateException(String.valueOf(i));
            } else {
                str = "stringify";
            }
            initPrototypeMethod(JSON_TAG, i, str, i2);
            return;
        }
        throw new IllegalStateException(String.valueOf(i));
    }
}

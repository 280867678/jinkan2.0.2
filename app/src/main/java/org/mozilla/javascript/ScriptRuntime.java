package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.p046uc.crashsdk.export.LogType;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import me.tvspark.outline;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.mozilla.javascript.NativeIterator;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.tools.idswitch.Main;
import org.mozilla.javascript.typedarrays.NativeArrayBuffer;
import org.mozilla.javascript.typedarrays.NativeDataView;
import org.mozilla.javascript.typedarrays.NativeFloat32Array;
import org.mozilla.javascript.typedarrays.NativeFloat64Array;
import org.mozilla.javascript.typedarrays.NativeInt16Array;
import org.mozilla.javascript.typedarrays.NativeInt32Array;
import org.mozilla.javascript.typedarrays.NativeInt8Array;
import org.mozilla.javascript.typedarrays.NativeUint16Array;
import org.mozilla.javascript.typedarrays.NativeUint32Array;
import org.mozilla.javascript.typedarrays.NativeUint8Array;
import org.mozilla.javascript.typedarrays.NativeUint8ClampedArray;
import org.mozilla.javascript.v8dtoa.DoubleConversion;
import org.mozilla.javascript.v8dtoa.FastDtoa;
import org.mozilla.javascript.xml.XMLLib;
import org.mozilla.javascript.xml.XMLObject;
import org.simpleframework.xml.strategy.Name;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes5.dex */
public class ScriptRuntime {
    public static final String DEFAULT_NS_TAG = "__default_namespace__";
    public static final int ENUMERATE_ARRAY = 2;
    public static final int ENUMERATE_ARRAY_NO_ITERATOR = 5;
    public static final int ENUMERATE_KEYS = 0;
    public static final int ENUMERATE_KEYS_NO_ITERATOR = 3;
    public static final int ENUMERATE_VALUES = 1;
    public static final int ENUMERATE_VALUES_IN_ORDER = 6;
    public static final int ENUMERATE_VALUES_NO_ITERATOR = 4;
    public static final Class<?> BooleanClass = Kit.classOrNull("java.lang.Boolean");
    public static final Class<?> ByteClass = Kit.classOrNull("java.lang.Byte");
    public static final Class<?> CharacterClass = Kit.classOrNull("java.lang.Character");
    public static final Class<?> ClassClass = Kit.classOrNull("java.lang.Class");
    public static final Class<?> DoubleClass = Kit.classOrNull("java.lang.Double");
    public static final Class<?> FloatClass = Kit.classOrNull("java.lang.Float");
    public static final Class<?> IntegerClass = Kit.classOrNull("java.lang.Integer");
    public static final Class<?> LongClass = Kit.classOrNull("java.lang.Long");
    public static final Class<?> NumberClass = Kit.classOrNull("java.lang.Number");
    public static final Class<?> ObjectClass = Kit.classOrNull("java.lang.Object");
    public static final Class<?> ShortClass = Kit.classOrNull("java.lang.Short");
    public static final Class<?> StringClass = Kit.classOrNull("java.lang.String");
    public static final Class<?> DateClass = Kit.classOrNull("java.util.Date");
    public static final Class<?> ContextClass = Kit.classOrNull("org.mozilla.javascript.Context");
    public static final Class<?> ContextFactoryClass = Kit.classOrNull("org.mozilla.javascript.ContextFactory");
    public static final Class<?> FunctionClass = Kit.classOrNull("org.mozilla.javascript.Function");
    public static final Class<?> ScriptableObjectClass = Kit.classOrNull("org.mozilla.javascript.ScriptableObject");
    public static final Class<Scriptable> ScriptableClass = Scriptable.class;
    public static Locale ROOT_LOCALE = new Locale("");
    public static final Object LIBRARY_SCOPE_KEY = "LIBRARY_SCOPE";
    public static final double NaN = Double.longBitsToDouble(9221120237041090560L);
    public static final double negativeZero = Double.longBitsToDouble(Long.MIN_VALUE);
    public static final Double NaNobj = new Double(NaN);
    public static MessageProvider messageProvider = new DefaultMessageProvider();
    public static final Object[] emptyArgs = new Object[0];
    public static final String[] emptyStrings = new String[0];

    /* loaded from: classes5.dex */
    public static class DefaultMessageProvider implements MessageProvider {
        public DefaultMessageProvider() {
        }

        @Override // org.mozilla.javascript.ScriptRuntime.MessageProvider
        public String getMessage(String str, Object[] objArr) {
            Context currentContext = Context.getCurrentContext();
            try {
                return new MessageFormat(ResourceBundle.getBundle("org.mozilla.javascript.resources.Messages", currentContext != null ? currentContext.getLocale() : Locale.getDefault()).getString(str)).format(objArr);
            } catch (MissingResourceException unused) {
                throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no message resource found for message property ", str));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class IdEnumeration implements Serializable {
        public static final long serialVersionUID = 1;
        public Object currentId;
        public boolean enumNumbers;
        public int enumType;
        public Object[] ids;
        public int index;
        public Scriptable iterator;
        public Scriptable obj;
        public ObjToIntMap used;

        public IdEnumeration() {
        }
    }

    /* loaded from: classes5.dex */
    public interface MessageProvider {
        String getMessage(String str, Object[] objArr);
    }

    /* loaded from: classes5.dex */
    public static class NoSuchMethodShim implements Callable {
        public String methodName;
        public Callable noSuchMethodMethod;

        public NoSuchMethodShim(Callable callable, String str) {
            this.noSuchMethodMethod = callable;
            this.methodName = str;
        }

        @Override // org.mozilla.javascript.Callable
        public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            return this.noSuchMethodMethod.call(context, scriptable, scriptable2, new Object[]{this.methodName, ScriptRuntime.newArrayLiteral(objArr, null, context, scriptable)});
        }
    }

    public static CharSequence add(CharSequence charSequence, Object obj) {
        return new ConsString(charSequence, toCharSequence(obj));
    }

    public static CharSequence add(Object obj, CharSequence charSequence) {
        return new ConsString(toCharSequence(obj), charSequence);
    }

    public static Object add(Object obj, Object obj2, Context context) {
        double number;
        double number2;
        Object addValues;
        Object addValues2;
        if (!(obj instanceof Number) || !(obj2 instanceof Number)) {
            if ((obj instanceof XMLObject) && (addValues2 = ((XMLObject) obj).addValues(context, true, obj2)) != Scriptable.NOT_FOUND) {
                return addValues2;
            }
            if ((obj2 instanceof XMLObject) && (addValues = ((XMLObject) obj2).addValues(context, false, obj)) != Scriptable.NOT_FOUND) {
                return addValues;
            }
            if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
                throw typeError0("msg.not.a.number");
            }
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(null);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(null);
            }
            if ((obj instanceof CharSequence) || (obj2 instanceof CharSequence)) {
                return new ConsString(toCharSequence(obj), toCharSequence(obj2));
            }
            if (!(obj instanceof Number) || !(obj2 instanceof Number)) {
                number = toNumber(obj);
                number2 = toNumber(obj2);
                return wrapNumber(number2 + number);
            }
        }
        number = ((Number) obj).doubleValue();
        number2 = ((Number) obj2).doubleValue();
        return wrapNumber(number2 + number);
    }

    public static void addInstructionCount(Context context, int i) {
        int i2 = context.instructionCount + i;
        context.instructionCount = i2;
        if (i2 > context.instructionThreshold) {
            context.observeInstructionCount(i2);
            context.instructionCount = 0;
        }
    }

    public static Object applyOrCall(boolean z, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable scriptable3;
        Object[] objArr2;
        Object obj;
        int length = objArr.length;
        Callable callable = getCallable(scriptable2);
        if (length != 0) {
            if (context.hasFeature(15)) {
                obj = objArr[0];
            } else if (objArr[0] == Undefined.instance) {
                scriptable3 = Undefined.SCRIPTABLE_UNDEFINED;
            } else {
                obj = objArr[0];
            }
            scriptable3 = toObjectOrNull(context, obj, scriptable);
        } else {
            scriptable3 = null;
        }
        if (scriptable3 == null && context.hasFeature(15)) {
            scriptable3 = getTopCallScope(context);
        }
        if (z) {
            if (length > 1) {
                objArr2 = getApplyArguments(context, objArr[1]);
            }
            objArr2 = emptyArgs;
        } else {
            if (length > 1) {
                int i = length - 1;
                objArr2 = new Object[i];
                System.arraycopy(objArr, 1, objArr2, 0, i);
            }
            objArr2 = emptyArgs;
        }
        return callable.call(context, scriptable, scriptable3, objArr2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
        r5 = r0;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
        if (org.mozilla.javascript.ScriptableObject.hasProperty(r5, r6) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003a, code lost:
        r5 = r0.getParentScope();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:
        if (r5 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
        r3 = r0;
        r0 = r5;
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0039, code lost:
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Scriptable bind(Context context, Scriptable scriptable, String str) {
        Scriptable parentScope = scriptable.getParentScope();
        XMLObject xMLObject = null;
        if (parentScope != null) {
            XMLObject xMLObject2 = null;
            while (true) {
                if (scriptable instanceof NativeWith) {
                    Scriptable prototype = scriptable.getPrototype();
                    if (prototype instanceof XMLObject) {
                        XMLObject xMLObject3 = (XMLObject) prototype;
                        if (xMLObject3.has(context, str)) {
                            return xMLObject3;
                        }
                        if (xMLObject2 == null) {
                            xMLObject2 = xMLObject3;
                        }
                    } else if (ScriptableObject.hasProperty(prototype, str)) {
                        return prototype;
                    }
                    Scriptable parentScope2 = parentScope.getParentScope();
                    if (parentScope2 == null) {
                        break;
                    }
                    Scriptable scriptable2 = parentScope;
                    parentScope = parentScope2;
                    scriptable = scriptable2;
                }
            }
        }
        if (context.useDynamicScope) {
            scriptable = checkDynamicScope(context.topCallScope, scriptable);
        }
        return ScriptableObject.hasProperty(scriptable, str) ? scriptable : xMLObject;
    }

    @Deprecated
    public static Object call(Context context, Object obj, Object obj2, Object[] objArr, Scriptable scriptable) {
        if (obj instanceof Function) {
            Function function = (Function) obj;
            Scriptable objectOrNull = toObjectOrNull(context, obj2, scriptable);
            if (objectOrNull == null) {
                throw undefCallError(objectOrNull, "function");
            }
            return function.call(context, scriptable, objectOrNull, objArr);
        }
        throw notFunctionError(toString(obj));
    }

    public static Object callIterator(Object obj, Context context, Scriptable scriptable) {
        return getElemFunctionAndThis(obj, SymbolKey.ITERATOR, context, scriptable).call(context, scriptable, lastStoredScriptable(context), emptyArgs);
    }

    public static Ref callRef(Callable callable, Scriptable scriptable, Object[] objArr, Context context) {
        if (callable instanceof RefCallable) {
            RefCallable refCallable = (RefCallable) callable;
            Ref refCall = refCallable.refCall(context, scriptable, objArr);
            if (refCall != null) {
                return refCall;
            }
            throw new IllegalStateException(refCallable.getClass().getName() + ".refCall() returned null");
        }
        throw constructError("ReferenceError", getMessage1("msg.no.ref.from.function", toString(callable)));
    }

    public static Object callSpecial(Context context, Callable callable, Scriptable scriptable, Object[] objArr, Scriptable scriptable2, Scriptable scriptable3, int i, String str, int i2) {
        if (i == 1) {
            if (scriptable.getParentScope() == null && NativeGlobal.isEvalFunction(callable)) {
                return evalSpecial(context, scriptable2, scriptable3, objArr, str, i2);
            }
        } else if (i != 2) {
            throw Kit.codeBug();
        } else {
            if (NativeWith.isWithFunction(callable)) {
                throw Context.reportRuntimeError1("msg.only.from.new", "With");
            }
        }
        return callable.call(context, scriptable2, scriptable, objArr);
    }

    public static void checkDeprecated(Context context, String str) {
        int languageVersion = context.getLanguageVersion();
        if (languageVersion >= 140 || languageVersion == 0) {
            String message1 = getMessage1("msg.deprec.ctor", str);
            if (languageVersion != 0) {
                throw Context.reportRuntimeError(message1);
            }
            Context.reportWarning(message1);
        }
    }

    public static Scriptable checkDynamicScope(Scriptable scriptable, Scriptable scriptable2) {
        if (scriptable == scriptable2) {
            return scriptable;
        }
        Scriptable scriptable3 = scriptable;
        do {
            scriptable3 = scriptable3.getPrototype();
            if (scriptable3 == scriptable2) {
                return scriptable;
            }
        } while (scriptable3 != null);
        return scriptable2;
    }

    public static RegExpProxy checkRegExpProxy(Context context) {
        RegExpProxy regExpProxy = getRegExpProxy(context);
        if (regExpProxy != null) {
            return regExpProxy;
        }
        throw Context.reportRuntimeError0("msg.no.regexp");
    }

    public static boolean cmp_LE(Object obj, Object obj2) {
        double number;
        double number2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            number = ((Number) obj).doubleValue();
            number2 = ((Number) obj2).doubleValue();
        } else if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
            throw typeError0("msg.compare.symbol");
        } else {
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(NumberClass);
            }
            if ((obj instanceof CharSequence) && (obj2 instanceof CharSequence)) {
                return obj.toString().compareTo(obj2.toString()) <= 0;
            }
            number = toNumber(obj);
            number2 = toNumber(obj2);
        }
        return number <= number2;
    }

    public static boolean cmp_LT(Object obj, Object obj2) {
        double number;
        double number2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            number = ((Number) obj).doubleValue();
            number2 = ((Number) obj2).doubleValue();
        } else if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
            throw typeError0("msg.compare.symbol");
        } else {
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(NumberClass);
            }
            if ((obj instanceof CharSequence) && (obj2 instanceof CharSequence)) {
                return obj.toString().compareTo(obj2.toString()) < 0;
            }
            number = toNumber(obj);
            number2 = toNumber(obj2);
        }
        return number < number2;
    }

    public static EcmaError constructError(String str, String str2) {
        int[] iArr = new int[1];
        return constructError(str, str2, Context.getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static EcmaError constructError(String str, String str2, int i) {
        int[] iArr = new int[1];
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        if (iArr[0] != 0) {
            iArr[0] = iArr[0] + i;
        }
        return constructError(str, str2, sourcePositionFromStack, iArr[0], null, 0);
    }

    public static EcmaError constructError(String str, String str2, String str3, int i, String str4, int i2) {
        return new EcmaError(str, str2, str3, i, str4, i2);
    }

    public static Scriptable createArrowFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr, boolean z) {
        return new NativeCall(nativeFunction, scriptable, objArr, true, z);
    }

    @Deprecated
    public static Scriptable createFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr) {
        return createFunctionActivation(nativeFunction, scriptable, objArr, false);
    }

    public static Scriptable createFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr, boolean z) {
        return new NativeCall(nativeFunction, scriptable, objArr, false, z);
    }

    public static XMLLib currentXMLLib(Context context) {
        Scriptable scriptable = context.topCallScope;
        if (scriptable != null) {
            XMLLib xMLLib = context.cachedXMLLib;
            if (xMLLib == null) {
                xMLLib = XMLLib.extractFromScope(scriptable);
                if (xMLLib == null) {
                    throw new IllegalStateException();
                }
                context.cachedXMLLib = xMLLib;
            }
            return xMLLib;
        }
        throw new IllegalStateException();
    }

    public static String defaultObjectToSource(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        boolean has;
        boolean z;
        Object obj;
        ObjToIntMap objToIntMap = context.iterating;
        if (objToIntMap == null) {
            context.iterating = new ObjToIntMap(31);
            z = true;
            has = false;
        } else {
            has = objToIntMap.has(scriptable2);
            z = false;
        }
        StringBuilder sb = new StringBuilder(128);
        if (z) {
            sb.append("(");
        }
        sb.append('{');
        if (!has) {
            try {
                context.iterating.intern(scriptable2);
                Object[] ids = scriptable2.getIds();
                for (int i = 0; i < ids.length; i++) {
                    Object obj2 = ids[i];
                    if (obj2 instanceof Integer) {
                        int intValue = ((Integer) obj2).intValue();
                        obj = scriptable2.get(intValue, scriptable2);
                        if (obj != Scriptable.NOT_FOUND) {
                            if (i > 0) {
                                sb.append(", ");
                            }
                            sb.append(intValue);
                            sb.append(':');
                            sb.append(uneval(context, scriptable, obj));
                        }
                    } else {
                        String str = (String) obj2;
                        obj = scriptable2.get(str, scriptable2);
                        if (obj != Scriptable.NOT_FOUND) {
                            if (i > 0) {
                                sb.append(", ");
                            }
                            if (isValidIdentifierName(str, context, context.isStrictMode())) {
                                sb.append(str);
                            } else {
                                sb.append(ExtendedMessageFormat.QUOTE);
                                sb.append(escapeString(str, ExtendedMessageFormat.QUOTE));
                                sb.append(ExtendedMessageFormat.QUOTE);
                            }
                            sb.append(':');
                            sb.append(uneval(context, scriptable, obj));
                        }
                    }
                }
            } finally {
                if (z) {
                    context.iterating = null;
                }
            }
        }
        sb.append('}');
        if (z) {
            sb.append(')');
        }
        return sb.toString();
    }

    public static String defaultObjectToString(Scriptable scriptable) {
        if (scriptable == null) {
            return "[object Null]";
        }
        if (Undefined.isUndefined(scriptable)) {
            return "[object Undefined]";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[object ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(scriptable.getClassName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Deprecated
    public static Object delete(Object obj, Object obj2, Context context) {
        return delete(obj, obj2, context, false);
    }

    public static Object delete(Object obj, Object obj2, Context context, Scriptable scriptable, boolean z) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            if (!z) {
                throw undefDeleteError(obj, obj2);
            }
            return Boolean.TRUE;
        }
        return wrapBoolean(deleteObjectElem(objectOrNull, obj2, context));
    }

    @Deprecated
    public static Object delete(Object obj, Object obj2, Context context, boolean z) {
        return delete(obj, obj2, context, getTopCallScope(context), z);
    }

    public static boolean deleteObjectElem(Scriptable scriptable, Object obj, Context context) {
        if (isSymbol(obj)) {
            SymbolScriptable ensureSymbolScriptable = ScriptableObject.ensureSymbolScriptable(scriptable);
            Symbol symbol = (Symbol) obj;
            ensureSymbolScriptable.delete(symbol);
            return !ensureSymbolScriptable.has(symbol, scriptable);
        }
        String stringIdOrIndex = toStringIdOrIndex(context, obj);
        if (stringIdOrIndex != null) {
            scriptable.delete(stringIdOrIndex);
            return !scriptable.has(stringIdOrIndex, scriptable);
        }
        int lastIndexResult = lastIndexResult(context);
        scriptable.delete(lastIndexResult);
        return !scriptable.has(lastIndexResult, scriptable);
    }

    public static Object doScriptableIncrDecr(Scriptable scriptable, String str, Scriptable scriptable2, Object obj, int i) {
        double number;
        boolean z = (i & 2) != 0;
        if (obj instanceof Number) {
            number = ((Number) obj).doubleValue();
        } else {
            number = toNumber(obj);
            if (z) {
                obj = wrapNumber(number);
            }
        }
        Number wrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        scriptable.put(str, scriptable2, wrapNumber);
        return z ? obj : wrapNumber;
    }

    @Deprecated
    public static Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return doTopCall(callable, context, scriptable, scriptable2, objArr, context.isTopLevelStrict);
    }

    public static Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, boolean z) {
        if (scriptable != null) {
            if (context.topCallScope != null) {
                throw new IllegalStateException();
            }
            context.topCallScope = ScriptableObject.getTopLevelScope(scriptable);
            context.useDynamicScope = context.hasFeature(7);
            boolean z2 = context.isTopLevelStrict;
            context.isTopLevelStrict = z;
            try {
                Object doTopCall = context.getFactory().doTopCall(callable, context, scriptable, scriptable2, objArr);
                context.topCallScope = null;
                context.cachedXMLLib = null;
                context.isTopLevelStrict = z2;
                if (context.currentActivationCall != null) {
                    throw new IllegalStateException();
                }
                return doTopCall;
            } catch (Throwable th) {
                context.topCallScope = null;
                context.cachedXMLLib = null;
                context.isTopLevelStrict = z2;
                if (context.currentActivationCall == null) {
                    throw th;
                }
                throw new IllegalStateException();
            }
        }
        throw new IllegalArgumentException();
    }

    @Deprecated
    public static Object elemIncrDecr(Object obj, Object obj2, Context context, int i) {
        return elemIncrDecr(obj, obj2, context, getTopCallScope(context), i);
    }

    public static Object elemIncrDecr(Object obj, Object obj2, Context context, Scriptable scriptable, int i) {
        double number;
        Object objectElem = getObjectElem(obj, obj2, context, scriptable);
        boolean z = (i & 2) != 0;
        if (objectElem instanceof Number) {
            number = ((Number) objectElem).doubleValue();
        } else {
            number = toNumber(objectElem);
            if (z) {
                objectElem = wrapNumber(number);
            }
        }
        Number wrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        setObjectElem(obj, obj2, wrapNumber, context, scriptable);
        return z ? objectElem : wrapNumber;
    }

    public static void enterActivationFunction(Context context, Scriptable scriptable) {
        if (context.topCallScope != null) {
            NativeCall nativeCall = (NativeCall) scriptable;
            nativeCall.parentActivationCall = context.currentActivationCall;
            context.currentActivationCall = nativeCall;
            nativeCall.defineAttributesForArguments();
            return;
        }
        throw new IllegalStateException();
    }

    public static Scriptable enterDotQuery(Object obj, Scriptable scriptable) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).enterDotQuery(scriptable);
        }
        throw notXmlError(obj);
    }

    public static Scriptable enterWith(Object obj, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return objectOrNull instanceof XMLObject ? ((XMLObject) objectOrNull).enterWith(scriptable) : new NativeWith(scriptable, objectOrNull);
        }
        throw typeError1("msg.undef.with", toString(obj));
    }

    public static void enumChangeObject(IdEnumeration idEnumeration) {
        Object[] objArr;
        Object[] objArr2 = null;
        while (true) {
            Scriptable scriptable = idEnumeration.obj;
            if (scriptable == null) {
                break;
            }
            objArr2 = scriptable.getIds();
            if (objArr2.length != 0) {
                break;
            }
            idEnumeration.obj = idEnumeration.obj.getPrototype();
        }
        if (idEnumeration.obj != null && (objArr = idEnumeration.ids) != null) {
            int length = objArr.length;
            if (idEnumeration.used == null) {
                idEnumeration.used = new ObjToIntMap(length);
            }
            for (int i = 0; i != length; i++) {
                idEnumeration.used.intern(objArr[i]);
            }
        }
        idEnumeration.ids = objArr2;
        idEnumeration.index = 0;
    }

    public static Object enumId(Object obj, Context context) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        if (idEnumeration.iterator != null) {
            return idEnumeration.currentId;
        }
        int i = idEnumeration.enumType;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                throw Kit.codeBug();
                            }
                        }
                    }
                }
                return context.newArray(ScriptableObject.getTopLevelScope(idEnumeration.obj), new Object[]{idEnumeration.currentId, enumValue(obj, context)});
            }
            return enumValue(obj, context);
        }
        return idEnumeration.currentId;
    }

    @Deprecated
    public static Object enumInit(Object obj, Context context, int i) {
        return enumInit(obj, context, getTopCallScope(context), i);
    }

    public static Object enumInit(Object obj, Context context, Scriptable scriptable, int i) {
        IdEnumeration idEnumeration = new IdEnumeration();
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        idEnumeration.obj = objectOrNull;
        if (i == 6) {
            idEnumeration.enumType = i;
            idEnumeration.iterator = null;
            return enumInitInOrder(context, idEnumeration);
        } else if (objectOrNull == null) {
            return idEnumeration;
        } else {
            idEnumeration.enumType = i;
            idEnumeration.iterator = null;
            if (i != 3 && i != 4 && i != 5) {
                idEnumeration.iterator = toIterator(context, objectOrNull.getParentScope(), idEnumeration.obj, i == 0);
            }
            if (idEnumeration.iterator == null) {
                enumChangeObject(idEnumeration);
            }
            return idEnumeration;
        }
    }

    @Deprecated
    public static Object enumInit(Object obj, Context context, boolean z) {
        return enumInit(obj, context, z ? 1 : 0);
    }

    public static Object enumInitInOrder(Context context, IdEnumeration idEnumeration) {
        Scriptable scriptable = idEnumeration.obj;
        if (scriptable instanceof ScriptableObject) {
            ScriptableObject scriptableObject = (ScriptableObject) scriptable;
            if (!ScriptableObject.hasProperty(scriptableObject, SymbolKey.ITERATOR)) {
                throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
            }
            Object property = ScriptableObject.getProperty(scriptableObject, SymbolKey.ITERATOR);
            if (!(property instanceof Callable)) {
                throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
            }
            Object call = ((Callable) property).call(context, idEnumeration.obj.getParentScope(), idEnumeration.obj, new Object[0]);
            if (!(call instanceof Scriptable)) {
                throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
            }
            idEnumeration.iterator = (Scriptable) call;
            return idEnumeration;
        }
        throw typeError1("msg.not.iterable", toString(scriptable));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.String] */
    public static Boolean enumNext(Object obj) {
        Object obj2;
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        Scriptable scriptable = idEnumeration.iterator;
        if (scriptable != null) {
            if (idEnumeration.enumType == 6) {
                return enumNextInOrder(idEnumeration);
            }
            Object property = ScriptableObject.getProperty(scriptable, ES6Iterator.NEXT_METHOD);
            if (!(property instanceof Callable)) {
                return Boolean.FALSE;
            }
            try {
                idEnumeration.currentId = ((Callable) property).call(Context.getContext(), idEnumeration.iterator.getParentScope(), idEnumeration.iterator, emptyArgs);
                return Boolean.TRUE;
            } catch (JavaScriptException e) {
                if (!(e.getValue() instanceof NativeIterator.StopIteration)) {
                    throw e;
                }
                return Boolean.FALSE;
            }
        }
        while (true) {
            Scriptable scriptable2 = idEnumeration.obj;
            if (scriptable2 == null) {
                return Boolean.FALSE;
            }
            int i = idEnumeration.index;
            Object[] objArr = idEnumeration.ids;
            if (i == objArr.length) {
                idEnumeration.obj = scriptable2.getPrototype();
                enumChangeObject(idEnumeration);
            } else {
                idEnumeration.index = i + 1;
                Object obj3 = objArr[i];
                ObjToIntMap objToIntMap = idEnumeration.used;
                if (objToIntMap == null || !objToIntMap.has(obj3)) {
                    if (obj3 instanceof Symbol) {
                        continue;
                    } else if (obj3 instanceof String) {
                        obj2 = (String) obj3;
                        Scriptable scriptable3 = idEnumeration.obj;
                        if (scriptable3.has((String) obj2, scriptable3)) {
                            break;
                        }
                    } else {
                        int intValue = ((Number) obj3).intValue();
                        Scriptable scriptable4 = idEnumeration.obj;
                        if (scriptable4.has(intValue, scriptable4)) {
                            obj2 = idEnumeration.enumNumbers ? Integer.valueOf(intValue) : String.valueOf(intValue);
                        }
                    }
                }
            }
        }
        idEnumeration.currentId = obj2;
        return Boolean.TRUE;
    }

    public static Boolean enumNextInOrder(IdEnumeration idEnumeration) {
        Object property = ScriptableObject.getProperty(idEnumeration.iterator, ES6Iterator.NEXT_METHOD);
        if (property instanceof Callable) {
            Context context = Context.getContext();
            Scriptable parentScope = idEnumeration.iterator.getParentScope();
            Scriptable object = toObject(context, parentScope, ((Callable) property).call(context, parentScope, idEnumeration.iterator, emptyArgs));
            Object property2 = ScriptableObject.getProperty(object, ES6Iterator.DONE_PROPERTY);
            if (property2 != Scriptable.NOT_FOUND && toBoolean(property2)) {
                return Boolean.FALSE;
            }
            idEnumeration.currentId = ScriptableObject.getProperty(object, "value");
            return Boolean.TRUE;
        }
        throw notFunctionError(idEnumeration.iterator, ES6Iterator.NEXT_METHOD);
    }

    public static Object enumValue(Object obj, Context context) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        if (isSymbol(idEnumeration.currentId)) {
            return ScriptableObject.ensureSymbolScriptable(idEnumeration.obj).get((Symbol) idEnumeration.currentId, idEnumeration.obj);
        }
        String stringIdOrIndex = toStringIdOrIndex(context, idEnumeration.currentId);
        if (stringIdOrIndex != null) {
            Scriptable scriptable = idEnumeration.obj;
            return scriptable.get(stringIdOrIndex, scriptable);
        }
        int lastIndexResult = lastIndexResult(context);
        Scriptable scriptable2 = idEnumeration.obj;
        return scriptable2.get(lastIndexResult, scriptable2);
    }

    /* renamed from: eq */
    public static boolean m26eq(Object obj, Object obj2) {
        Object equivalentValues;
        Object equivalentValues2;
        Object equivalentValues3;
        Object equivalentValues4;
        Object equivalentValues5;
        if (obj == null || obj == Undefined.instance) {
            if (obj2 == null || obj2 == Undefined.instance) {
                return true;
            }
            if ((obj2 instanceof ScriptableObject) && (equivalentValues = ((ScriptableObject) obj2).equivalentValues(obj)) != Scriptable.NOT_FOUND) {
                return ((Boolean) equivalentValues).booleanValue();
            }
            return false;
        } else if (obj instanceof Number) {
            return eqNumber(((Number) obj).doubleValue(), obj2);
        } else {
            if (obj == obj2) {
                return true;
            }
            if (obj instanceof CharSequence) {
                return eqString((CharSequence) obj, obj2);
            }
            double d = 1.0d;
            if (obj instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                if (obj2 instanceof Boolean) {
                    return booleanValue == ((Boolean) obj2).booleanValue();
                } else if ((obj2 instanceof ScriptableObject) && (equivalentValues5 = ((ScriptableObject) obj2).equivalentValues(obj)) != Scriptable.NOT_FOUND) {
                    return ((Boolean) equivalentValues5).booleanValue();
                } else {
                    if (!booleanValue) {
                        d = 0.0d;
                    }
                    return eqNumber(d, obj2);
                }
            } else if (!(obj instanceof Scriptable)) {
                warnAboutNonJSObject(obj);
                return obj == obj2;
            } else if (!(obj2 instanceof Scriptable)) {
                if (!(obj2 instanceof Boolean)) {
                    if (obj2 instanceof Number) {
                        return eqNumber(((Number) obj2).doubleValue(), obj);
                    }
                    if (!(obj2 instanceof CharSequence)) {
                        return false;
                    }
                    return eqString((CharSequence) obj2, obj);
                } else if ((obj instanceof ScriptableObject) && (equivalentValues2 = ((ScriptableObject) obj).equivalentValues(obj2)) != Scriptable.NOT_FOUND) {
                    return ((Boolean) equivalentValues2).booleanValue();
                } else {
                    if (!((Boolean) obj2).booleanValue()) {
                        d = 0.0d;
                    }
                    return eqNumber(d, obj);
                }
            } else if ((obj instanceof ScriptableObject) && (equivalentValues4 = ((ScriptableObject) obj).equivalentValues(obj2)) != Scriptable.NOT_FOUND) {
                return ((Boolean) equivalentValues4).booleanValue();
            } else {
                if ((obj2 instanceof ScriptableObject) && (equivalentValues3 = ((ScriptableObject) obj2).equivalentValues(obj)) != Scriptable.NOT_FOUND) {
                    return ((Boolean) equivalentValues3).booleanValue();
                }
                if (!(obj instanceof Wrapper) || !(obj2 instanceof Wrapper)) {
                    return false;
                }
                Object unwrap = ((Wrapper) obj).unwrap();
                Object unwrap2 = ((Wrapper) obj2).unwrap();
                if (unwrap == unwrap2) {
                    return true;
                }
                return isPrimitive(unwrap) && isPrimitive(unwrap2) && m26eq(unwrap, unwrap2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean eqNumber(double d, Object obj) {
        while (true) {
            if (obj != null && obj != Undefined.instance) {
                if (!(obj instanceof Number)) {
                    if (!(obj instanceof CharSequence)) {
                        if (!(obj instanceof Boolean)) {
                            if (!isSymbol(obj)) {
                                if (!(obj instanceof Scriptable)) {
                                    warnAboutNonJSObject(obj);
                                    break;
                                }
                                if (obj instanceof ScriptableObject) {
                                    Object equivalentValues = ((ScriptableObject) obj).equivalentValues(wrapNumber(d));
                                    if (equivalentValues != Scriptable.NOT_FOUND) {
                                        return ((Boolean) equivalentValues).booleanValue();
                                    }
                                }
                                obj = toPrimitive(obj);
                            } else {
                                return false;
                            }
                        } else {
                            return d == (((Boolean) obj).booleanValue() ? 1.0d : RoundRectDrawableWithShadow.COS_45);
                        }
                    } else {
                        return d == toNumber(obj);
                    }
                } else {
                    return d == ((Number) obj).doubleValue();
                }
            } else {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008f, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean eqString(CharSequence charSequence, Object obj) {
        Object equivalentValues;
        while (true) {
            if (obj != null && obj != Undefined.instance) {
                if (!(obj instanceof CharSequence)) {
                    if (!(obj instanceof Number)) {
                        if (!(obj instanceof Boolean)) {
                            if (!isSymbol(obj)) {
                                if (!(obj instanceof Scriptable)) {
                                    warnAboutNonJSObject(obj);
                                    break;
                                } else if ((obj instanceof ScriptableObject) && (equivalentValues = ((ScriptableObject) obj).equivalentValues(charSequence.toString())) != Scriptable.NOT_FOUND) {
                                    return ((Boolean) equivalentValues).booleanValue();
                                } else {
                                    obj = toPrimitive(obj);
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return toNumber(charSequence.toString()) == (((Boolean) obj).booleanValue() ? 1.0d : RoundRectDrawableWithShadow.COS_45);
                        }
                    } else {
                        return toNumber(charSequence.toString()) == ((Number) obj).doubleValue();
                    }
                } else {
                    CharSequence charSequence2 = (CharSequence) obj;
                    return charSequence.length() == charSequence2.length() && charSequence.toString().equals(charSequence2.toString());
                }
            } else {
                break;
            }
        }
    }

    public static RuntimeException errorWithClassName(String str, Object obj) {
        return Context.reportRuntimeError1(str, obj.getClass().getName());
    }

    public static String escapeAttributeValue(Object obj, Context context) {
        return currentXMLLib(context).escapeAttributeValue(obj);
    }

    public static String escapeString(String str) {
        return escapeString(str, '\"');
    }

    public static String escapeString(String str, char c) {
        int i;
        char c2;
        if (c != '\"' && c != '\'' && c != '`') {
            Kit.codeBug();
        }
        StringBuilder sb = null;
        int length = str.length();
        for (int i2 = 0; i2 != length; i2++) {
            char charAt = str.charAt(i2);
            int i3 = 32;
            if (' ' > charAt || charAt > '~' || charAt == c || charAt == '\\') {
                if (sb == null) {
                    sb = new StringBuilder(length + 3);
                    sb.append(str);
                    sb.setLength(i2);
                }
                if (charAt != ' ') {
                    if (charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                i3 = 98;
                                break;
                            case '\t':
                                i3 = 116;
                                break;
                            case '\n':
                                i3 = 110;
                                break;
                            case 11:
                                i3 = 118;
                                break;
                            case '\f':
                                i3 = 102;
                                break;
                            case '\r':
                                i3 = 114;
                                break;
                            default:
                                i3 = -1;
                                break;
                        }
                    } else {
                        i3 = 92;
                    }
                }
                if (i3 >= 0) {
                    sb.append('\\');
                    c2 = (char) i3;
                    sb.append(c2);
                } else {
                    if (charAt == c) {
                        sb.append('\\');
                        sb.append(c);
                    } else {
                        if (charAt < 256) {
                            sb.append("\\x");
                            i = 2;
                        } else {
                            sb.append("\\u");
                            i = 4;
                        }
                        for (int i4 = (i - 1) * 4; i4 >= 0; i4 -= 4) {
                            int i5 = (charAt >> i4) & 15;
                            sb.append((char) (i5 < 10 ? i5 + 48 : i5 + 87));
                        }
                    }
                }
            } else if (sb != null) {
                c2 = charAt;
                sb.append(c2);
            }
        }
        return sb == null ? str : sb.toString();
    }

    public static String escapeTextValue(Object obj, Context context) {
        return currentXMLLib(context).escapeTextValue(obj);
    }

    public static Object evalSpecial(Context context, Scriptable scriptable, Object obj, Object[] objArr, String str, int i) {
        if (objArr.length < 1) {
            return Undefined.instance;
        }
        Object obj2 = objArr[0];
        if (!(obj2 instanceof CharSequence)) {
            if (context.hasFeature(11) || context.hasFeature(9)) {
                throw Context.reportRuntimeError0("msg.eval.nonstring.strict");
            }
            Context.reportWarning(getMessage0("msg.eval.nonstring"));
            return obj2;
        }
        if (str == null) {
            int[] iArr = new int[1];
            String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
            if (sourcePositionFromStack != null) {
                i = iArr[0];
                str = sourcePositionFromStack;
            } else {
                str = "";
            }
        }
        String makeUrlForGeneratedScript = makeUrlForGeneratedScript(true, str, i);
        ErrorReporter forEval = DefaultErrorReporter.forEval(context.getErrorReporter());
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter == null) {
            throw new JavaScriptException("Interpreter not present", str, i);
        }
        Script compileString = context.compileString(obj2.toString(), createInterpreter, forEval, makeUrlForGeneratedScript, 1, null);
        createInterpreter.setEvalScriptFlag(compileString);
        return ((Callable) compileString).call(context, scriptable, (Scriptable) obj, emptyArgs);
    }

    public static void exitActivationFunction(Context context) {
        NativeCall nativeCall = context.currentActivationCall;
        context.currentActivationCall = nativeCall.parentActivationCall;
        nativeCall.parentActivationCall = null;
    }

    public static NativeCall findFunctionActivation(Context context, Function function) {
        for (NativeCall nativeCall = context.currentActivationCall; nativeCall != null; nativeCall = nativeCall.parentActivationCall) {
            if (nativeCall.function == function) {
                return nativeCall;
            }
        }
        return null;
    }

    public static Object[] getApplyArguments(Context context, Object obj) {
        if (obj == null || obj == Undefined.instance) {
            return emptyArgs;
        }
        if (obj instanceof Scriptable) {
            Scriptable scriptable = (Scriptable) obj;
            if (isArrayLike(scriptable)) {
                return context.getElements(scriptable);
            }
        }
        if (!(obj instanceof ScriptableObject)) {
            throw typeError0("msg.arg.isnt.array");
        }
        return emptyArgs;
    }

    public static Object[] getArrayElements(Scriptable scriptable) {
        long lengthProperty = NativeArray.getLengthProperty(Context.getContext(), scriptable, false);
        if (lengthProperty <= 2147483647L) {
            int i = (int) lengthProperty;
            if (i == 0) {
                return emptyArgs;
            }
            Object[] objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                Object property = ScriptableObject.getProperty(scriptable, i2);
                if (property == Scriptable.NOT_FOUND) {
                    property = Undefined.instance;
                }
                objArr[i2] = property;
            }
            return objArr;
        }
        throw new IllegalArgumentException();
    }

    public static Callable getCallable(Scriptable scriptable) {
        if (scriptable instanceof Callable) {
            return (Callable) scriptable;
        }
        Object defaultValue = scriptable.getDefaultValue(FunctionClass);
        if (!(defaultValue instanceof Callable)) {
            throw notFunctionError(defaultValue, scriptable);
        }
        return (Callable) defaultValue;
    }

    @Deprecated
    public static Callable getElemFunctionAndThis(Object obj, Object obj2, Context context) {
        return getElemFunctionAndThis(obj, obj2, context, getTopCallScope(context));
    }

    public static Callable getElemFunctionAndThis(Object obj, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull;
        Object property;
        if (isSymbol(obj2)) {
            objectOrNull = toObjectOrNull(context, obj, scriptable);
            if (objectOrNull == null) {
                throw undefCallError(obj, String.valueOf(obj2));
            }
            property = ScriptableObject.getProperty(objectOrNull, (Symbol) obj2);
        } else {
            String stringIdOrIndex = toStringIdOrIndex(context, obj2);
            if (stringIdOrIndex != null) {
                return getPropFunctionAndThis(obj, stringIdOrIndex, context, scriptable);
            }
            int lastIndexResult = lastIndexResult(context);
            objectOrNull = toObjectOrNull(context, obj, scriptable);
            if (objectOrNull == null) {
                throw undefCallError(obj, String.valueOf(obj2));
            }
            property = ScriptableObject.getProperty(objectOrNull, lastIndexResult);
        }
        if (property instanceof Callable) {
            storeScriptable(context, objectOrNull);
            return (Callable) property;
        }
        throw notFunctionError(property, obj2);
    }

    public static Function getExistingCtor(Context context, Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property instanceof Function) {
            return (Function) property;
        }
        if (property != Scriptable.NOT_FOUND) {
            throw Context.reportRuntimeError1("msg.not.ctor", str);
        }
        throw Context.reportRuntimeError1("msg.ctor.not.found", str);
    }

    public static ScriptableObject getGlobal(Context context) {
        Class<?> classOrNull = Kit.classOrNull("org.mozilla.javascript.tools.shell.Global");
        if (classOrNull != null) {
            try {
                return (ScriptableObject) classOrNull.getConstructor(ContextClass).newInstance(context);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
        return new ImporterTopLevel(context);
    }

    public static Object getIndexObject(double d) {
        int i = (int) d;
        return ((double) i) == d ? Integer.valueOf(i) : toString(d);
    }

    public static Object getIndexObject(String str) {
        long indexFromString = indexFromString(str);
        return indexFromString >= 0 ? Integer.valueOf((int) indexFromString) : str;
    }

    public static ScriptableObject getLibraryScopeOrNull(Scriptable scriptable) {
        return (ScriptableObject) ScriptableObject.getTopScopeValue(scriptable, LIBRARY_SCOPE_KEY);
    }

    public static String getMessage(String str, Object[] objArr) {
        return messageProvider.getMessage(str, objArr);
    }

    public static String getMessage0(String str) {
        return getMessage(str, null);
    }

    public static String getMessage1(String str, Object obj) {
        return getMessage(str, new Object[]{obj});
    }

    public static String getMessage2(String str, Object obj, Object obj2) {
        return getMessage(str, new Object[]{obj, obj2});
    }

    public static String getMessage3(String str, Object obj, Object obj2, Object obj3) {
        return getMessage(str, new Object[]{obj, obj2, obj3});
    }

    public static String getMessage4(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return getMessage(str, new Object[]{obj, obj2, obj3, obj4});
    }

    public static Callable getNameFunctionAndThis(String str, Context context, Scriptable scriptable) {
        Scriptable parentScope = scriptable.getParentScope();
        if (parentScope == null) {
            Object obj = topScopeName(context, scriptable, str);
            if (obj instanceof Callable) {
                storeScriptable(context, scriptable);
                return (Callable) obj;
            } else if (obj != Scriptable.NOT_FOUND) {
                throw notFunctionError(obj, str);
            } else {
                throw notFoundError(scriptable, str);
            }
        }
        return (Callable) nameOrFunction(context, scriptable, parentScope, str, true);
    }

    @Deprecated
    public static Object getObjectElem(Object obj, Object obj2, Context context) {
        return getObjectElem(obj, obj2, context, getTopCallScope(context));
    }

    public static Object getObjectElem(Object obj, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return getObjectElem(objectOrNull, obj2, context);
        }
        throw undefReadError(obj, obj2);
    }

    public static Object getObjectElem(Scriptable scriptable, Object obj, Context context) {
        Object property;
        if (scriptable instanceof XMLObject) {
            property = ((XMLObject) scriptable).get(context, obj);
        } else if (isSymbol(obj)) {
            property = ScriptableObject.getProperty(scriptable, (Symbol) obj);
        } else {
            String stringIdOrIndex = toStringIdOrIndex(context, obj);
            property = stringIdOrIndex == null ? ScriptableObject.getProperty(scriptable, lastIndexResult(context)) : ScriptableObject.getProperty(scriptable, stringIdOrIndex);
        }
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    @Deprecated
    public static Object getObjectIndex(Object obj, double d, Context context) {
        return getObjectIndex(obj, d, context, getTopCallScope(context));
    }

    public static Object getObjectIndex(Object obj, double d, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            int i = (int) d;
            return ((double) i) == d ? getObjectIndex(objectOrNull, i, context) : getObjectProp(objectOrNull, toString(d), context);
        }
        throw undefReadError(obj, toString(d));
    }

    public static Object getObjectIndex(Scriptable scriptable, int i, Context context) {
        Object property = ScriptableObject.getProperty(scriptable, i);
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    @Deprecated
    public static Object getObjectProp(Object obj, String str, Context context) {
        return getObjectProp(obj, str, context, getTopCallScope(context));
    }

    public static Object getObjectProp(Object obj, String str, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return getObjectProp(objectOrNull, str, context);
        }
        throw undefReadError(obj, str);
    }

    public static Object getObjectProp(Scriptable scriptable, String str, Context context) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            if (context.hasFeature(11)) {
                Context.reportWarning(getMessage1("msg.ref.undefined.prop", str));
            }
            return Undefined.instance;
        }
        return property;
    }

    @Deprecated
    public static Object getObjectPropNoWarn(Object obj, String str, Context context) {
        return getObjectPropNoWarn(obj, str, context, getTopCallScope(context));
    }

    public static Object getObjectPropNoWarn(Object obj, String str, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            Object property = ScriptableObject.getProperty(objectOrNull, str);
            return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
        }
        throw undefReadError(obj, str);
    }

    @Deprecated
    public static Callable getPropFunctionAndThis(Object obj, String str, Context context) {
        return getPropFunctionAndThis(obj, str, context, getTopCallScope(context));
    }

    public static Callable getPropFunctionAndThis(Object obj, String str, Context context, Scriptable scriptable) {
        return getPropFunctionAndThisHelper(obj, str, context, toObjectOrNull(context, obj, scriptable));
    }

    public static Callable getPropFunctionAndThisHelper(Object obj, String str, Context context, Scriptable scriptable) {
        if (scriptable != null) {
            Object property = ScriptableObject.getProperty(scriptable, str);
            if (!(property instanceof Callable)) {
                Object property2 = ScriptableObject.getProperty(scriptable, "__noSuchMethod__");
                if (property2 instanceof Callable) {
                    property = new NoSuchMethodShim((Callable) property2, str);
                }
            }
            if (!(property instanceof Callable)) {
                throw notFunctionError(scriptable, property, str);
            }
            storeScriptable(context, scriptable);
            return (Callable) property;
        }
        throw undefCallError(obj, str);
    }

    public static RegExpProxy getRegExpProxy(Context context) {
        return context.getRegExpProxy();
    }

    public static Scriptable getTopCallScope(Context context) {
        Scriptable scriptable = context.topCallScope;
        if (scriptable != null) {
            return scriptable;
        }
        throw new IllegalStateException();
    }

    public static Object getTopLevelProp(Scriptable scriptable, String str) {
        return ScriptableObject.getProperty(ScriptableObject.getTopLevelScope(scriptable), str);
    }

    public static String[] getTopPackageNames() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new String[]{LogType.JAVA_TYPE, "javax", "org", "com", "edu", "net", "android"} : new String[]{LogType.JAVA_TYPE, "javax", "org", "com", "edu", "net"};
    }

    public static Callable getValueFunctionAndThis(Object obj, Context context) {
        if (obj instanceof Callable) {
            Callable callable = (Callable) obj;
            Scriptable scriptable = null;
            if (callable instanceof Scriptable) {
                scriptable = ((Scriptable) callable).getParentScope();
            }
            if (scriptable == null && (scriptable = context.topCallScope) == null) {
                throw new IllegalStateException();
            }
            if (scriptable.getParentScope() != null && !(scriptable instanceof NativeWith) && (scriptable instanceof NativeCall)) {
                scriptable = ScriptableObject.getTopLevelScope(scriptable);
            }
            storeScriptable(context, scriptable);
            return callable;
        }
        throw notFunctionError(obj);
    }

    public static boolean hasObjectElem(Scriptable scriptable, Object obj, Context context) {
        if (isSymbol(obj)) {
            return ScriptableObject.hasProperty(scriptable, (Symbol) obj);
        }
        String stringIdOrIndex = toStringIdOrIndex(context, obj);
        return stringIdOrIndex == null ? ScriptableObject.hasProperty(scriptable, lastIndexResult(context)) : ScriptableObject.hasProperty(scriptable, stringIdOrIndex);
    }

    public static boolean hasTopCall(Context context) {
        return context.topCallScope != null;
    }

    /* renamed from: in */
    public static boolean m25in(Object obj, Object obj2, Context context) {
        if (obj2 instanceof Scriptable) {
            return hasObjectElem((Scriptable) obj2, obj, context);
        }
        throw typeError0("msg.in.not.object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005a, code lost:
        if (r4 <= (r5 ? 8 : 7)) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long indexFromString(String str) {
        boolean z;
        int i;
        int length = str.length();
        if (length > 0) {
            int i2 = 0;
            char charAt = str.charAt(0);
            if (charAt != '-' || length <= 1) {
                z = false;
                i = 0;
            } else {
                charAt = str.charAt(1);
                if (charAt == '0') {
                    return -1L;
                }
                z = true;
                i = 1;
            }
            int i3 = charAt - '0';
            if (i3 >= 0 && i3 <= 9) {
                if (length <= (z ? 11 : 10)) {
                    int i4 = -i3;
                    int i5 = i + 1;
                    if (i4 != 0) {
                        while (i5 != length) {
                            i3 = str.charAt(i5) - '0';
                            if (i3 < 0 || i3 > 9) {
                                break;
                            }
                            i5++;
                            int i6 = i4;
                            i4 = (i4 * 10) - i3;
                            i2 = i6;
                        }
                    }
                    if (i5 == length) {
                        if (i2 <= -214748364) {
                            if (i2 == -214748364) {
                            }
                        }
                        if (!z) {
                            i4 = -i4;
                        }
                        return 4294967295L & i4;
                    }
                }
            }
        }
        return -1L;
    }

    public static void initFunction(Context context, Scriptable scriptable, NativeFunction nativeFunction, int i, boolean z) {
        String functionName;
        if (i == 1) {
            functionName = nativeFunction.getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                return;
            }
            if (!z) {
                ScriptableObject.defineProperty(scriptable, functionName, nativeFunction, 4);
                return;
            }
        } else if (i != 3) {
            throw Kit.codeBug();
        } else {
            functionName = nativeFunction.getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                return;
            }
            while (scriptable instanceof NativeWith) {
                scriptable = scriptable.getParentScope();
            }
        }
        scriptable.put(functionName, scriptable, nativeFunction);
    }

    public static ScriptableObject initSafeStandardObjects(Context context, ScriptableObject scriptableObject, boolean z) {
        if (scriptableObject == null) {
            scriptableObject = new NativeObject();
        }
        scriptableObject.associateValue(LIBRARY_SCOPE_KEY, scriptableObject);
        new ClassCache().associate(scriptableObject);
        BaseFunction.init(scriptableObject, z);
        NativeObject.init(scriptableObject, z);
        Scriptable objectPrototype = ScriptableObject.getObjectPrototype(scriptableObject);
        ScriptableObject.getClassPrototype(scriptableObject, "Function").setPrototype(objectPrototype);
        if (scriptableObject.getPrototype() == null) {
            scriptableObject.setPrototype(objectPrototype);
        }
        NativeError.init(scriptableObject, z);
        NativeGlobal.init(context, scriptableObject, z);
        NativeArray.init(scriptableObject, z);
        if (context.getOptimizationLevel() > 0) {
            NativeArray.setMaximumInitialCapacity(200000);
        }
        NativeString.init(scriptableObject, z);
        NativeBoolean.init(scriptableObject, z);
        NativeNumber.init(scriptableObject, z);
        NativeDate.init(scriptableObject, z);
        NativeMath.init(scriptableObject, z);
        NativeJSON.init(scriptableObject, z);
        NativeWith.init(scriptableObject, z);
        NativeCall.init(scriptableObject, z);
        NativeScript.init(scriptableObject, z);
        NativeIterator.init(scriptableObject, z);
        NativeArrayIterator.init(scriptableObject, z);
        NativeStringIterator.init(scriptableObject, z);
        boolean z2 = context.hasFeature(6) && context.getE4xImplementationFactory() != null;
        ScriptableObject scriptableObject2 = scriptableObject;
        new LazilyLoadedCtor(scriptableObject2, "RegExp", "org.mozilla.javascript.regexp.NativeRegExp", z, true);
        new LazilyLoadedCtor(scriptableObject2, "Continuation", "org.mozilla.javascript.NativeContinuation", z, true);
        if (z2) {
            String implementationClassName = context.getE4xImplementationFactory().getImplementationClassName();
            ScriptableObject scriptableObject3 = scriptableObject;
            new LazilyLoadedCtor(scriptableObject3, "XML", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject3, "XMLList", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject3, "Namespace", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject3, "QName", implementationClassName, z, true);
        }
        if ((context.getLanguageVersion() >= 180 && context.hasFeature(14)) || context.getLanguageVersion() >= 200) {
            ScriptableObject scriptableObject4 = scriptableObject;
            new LazilyLoadedCtor(scriptableObject4, NativeArrayBuffer.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeArrayBuffer", z, true);
            new LazilyLoadedCtor(scriptableObject4, NativeInt8Array.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeInt8Array", z, true);
            new LazilyLoadedCtor(scriptableObject4, NativeUint8Array.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeUint8Array", z, true);
            new LazilyLoadedCtor(scriptableObject4, NativeUint8ClampedArray.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeUint8ClampedArray", z, true);
            new LazilyLoadedCtor(scriptableObject4, NativeInt16Array.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeInt16Array", z, true);
            new LazilyLoadedCtor(scriptableObject4, NativeUint16Array.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeUint16Array", z, true);
            new LazilyLoadedCtor(scriptableObject4, NativeInt32Array.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeInt32Array", z, true);
            new LazilyLoadedCtor(scriptableObject4, NativeUint32Array.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeUint32Array", z, true);
            new LazilyLoadedCtor(scriptableObject4, NativeFloat32Array.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeFloat32Array", z, true);
            new LazilyLoadedCtor(scriptableObject4, NativeFloat64Array.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeFloat64Array", z, true);
            new LazilyLoadedCtor(scriptableObject4, NativeDataView.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeDataView", z, true);
        }
        if (context.getLanguageVersion() >= 200) {
            NativeSymbol.init(context, scriptableObject, z);
            NativeCollectionIterator.init(scriptableObject, NativeSet.ITERATOR_TAG, z);
            NativeCollectionIterator.init(scriptableObject, NativeMap.ITERATOR_TAG, z);
            NativeMap.init(context, scriptableObject, z);
            NativeSet.init(context, scriptableObject, z);
            NativeWeakMap.init(scriptableObject, z);
            NativeWeakSet.init(scriptableObject, z);
        }
        if (scriptableObject instanceof TopLevel) {
            scriptableObject.cacheBuiltins();
        }
        return scriptableObject;
    }

    public static void initScript(NativeFunction nativeFunction, Scriptable scriptable, Context context, Scriptable scriptable2, boolean z) {
        if (context.topCallScope != null) {
            int paramAndVarCount = nativeFunction.getParamAndVarCount();
            if (paramAndVarCount == 0) {
                return;
            }
            Scriptable scriptable3 = scriptable2;
            while (scriptable3 instanceof NativeWith) {
                scriptable3 = scriptable3.getParentScope();
            }
            while (true) {
                int i = paramAndVarCount - 1;
                if (paramAndVarCount == 0) {
                    return;
                }
                String paramOrVarName = nativeFunction.getParamOrVarName(i);
                boolean paramOrVarConst = nativeFunction.getParamOrVarConst(i);
                if (ScriptableObject.hasProperty(scriptable2, paramOrVarName)) {
                    ScriptableObject.redefineProperty(scriptable2, paramOrVarName, paramOrVarConst);
                } else if (paramOrVarConst) {
                    ScriptableObject.defineConstProperty(scriptable3, paramOrVarName);
                } else {
                    Object obj = Undefined.instance;
                    if (!z) {
                        ScriptableObject.defineProperty(scriptable3, paramOrVarName, obj, 4);
                    } else {
                        scriptable3.put(paramOrVarName, scriptable3, obj);
                    }
                }
                paramAndVarCount = i;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public static ScriptableObject initStandardObjects(Context context, ScriptableObject scriptableObject, boolean z) {
        ScriptableObject initSafeStandardObjects = initSafeStandardObjects(context, scriptableObject, z);
        new LazilyLoadedCtor(initSafeStandardObjects, "Packages", "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        new LazilyLoadedCtor(initSafeStandardObjects, "getClass", "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        new LazilyLoadedCtor(initSafeStandardObjects, "JavaAdapter", "org.mozilla.javascript.JavaAdapter", z, true);
        new LazilyLoadedCtor(initSafeStandardObjects, "JavaImporter", "org.mozilla.javascript.ImporterTopLevel", z, true);
        for (String str : getTopPackageNames()) {
            new LazilyLoadedCtor(initSafeStandardObjects, str, "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        }
        return initSafeStandardObjects;
    }

    public static boolean instanceOf(Object obj, Object obj2, Context context) {
        if (obj2 instanceof Scriptable) {
            if (obj instanceof Scriptable) {
                return ((Scriptable) obj2).hasInstance((Scriptable) obj);
            }
            return false;
        }
        throw typeError0("msg.instanceof.not.object");
    }

    public static boolean isArrayLike(Scriptable scriptable) {
        return scriptable != null && ((scriptable instanceof NativeArray) || (scriptable instanceof Arguments) || ScriptableObject.hasProperty(scriptable, Name.LENGTH));
    }

    public static boolean isArrayObject(Object obj) {
        return (obj instanceof NativeArray) || (obj instanceof Arguments);
    }

    public static boolean isGeneratedScript(String str) {
        return str.indexOf("(eval)") >= 0 || str.indexOf("(Function)") >= 0;
    }

    public static boolean isJSLineTerminator(int i) {
        if ((57296 & i) != 0) {
            return false;
        }
        return i == 10 || i == 13 || i == 8232 || i == 8233;
    }

    public static boolean isJSWhitespaceOrLineTerminator(int i) {
        return isStrWhiteSpaceChar(i) || isJSLineTerminator(i);
    }

    public static boolean isNaN(Object obj) {
        if (obj == NaNobj) {
            return true;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            return d.doubleValue() == NaN || Double.isNaN(d.doubleValue());
        } else if (!(obj instanceof Float)) {
            return false;
        } else {
            Float f = (Float) obj;
            return ((double) f.floatValue()) == NaN || Float.isNaN(f.floatValue());
        }
    }

    public static boolean isObject(Object obj) {
        if (obj != null && !Undefined.instance.equals(obj)) {
            if (obj instanceof ScriptableObject) {
                String typeOf = ((ScriptableObject) obj).getTypeOf();
                return "object".equals(typeOf) || "function".equals(typeOf);
            } else if (!(obj instanceof Scriptable)) {
                return false;
            } else {
                return !(obj instanceof Callable);
            }
        }
        return false;
    }

    public static boolean isPrimitive(Object obj) {
        return obj == null || obj == Undefined.instance || (obj instanceof Number) || (obj instanceof String) || (obj instanceof Boolean);
    }

    public static boolean isRhinoRuntimeType(Class<?> cls) {
        return cls.isPrimitive() ? cls != Character.TYPE : cls == StringClass || cls == BooleanClass || NumberClass.isAssignableFrom(cls) || ScriptableClass.isAssignableFrom(cls);
    }

    public static boolean isSpecialProperty(String str) {
        return str.equals("__proto__") || str.equals("__parent__");
    }

    public static boolean isStrWhiteSpaceChar(int i) {
        if (i == 32 || i == 160 || i == 65279 || i == 8232 || i == 8233) {
            return true;
        }
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return true;
            default:
                return Character.getType(i) == 12;
        }
    }

    public static boolean isSymbol(Object obj) {
        return ((obj instanceof NativeSymbol) && ((NativeSymbol) obj).isSymbol()) || (obj instanceof SymbolKey);
    }

    public static boolean isValidIdentifierName(String str, Context context, boolean z) {
        int length = str.length();
        if (length != 0 && Character.isJavaIdentifierStart(str.charAt(0))) {
            for (int i = 1; i != length; i++) {
                if (!Character.isJavaIdentifierPart(str.charAt(i))) {
                    return false;
                }
            }
            return !TokenStream.isKeyword(str, context.getLanguageVersion(), z);
        }
        return false;
    }

    public static boolean isVisible(Context context, Object obj) {
        ClassShutter classShutter = context.getClassShutter();
        return classShutter == null || classShutter.visibleToScripts(obj.getClass().getName());
    }

    public static boolean jsDelegatesTo(Scriptable scriptable, Scriptable scriptable2) {
        do {
            scriptable = scriptable.getPrototype();
            if (scriptable == null) {
                return false;
            }
        } while (!scriptable.equals(scriptable2));
        return true;
    }

    public static int lastIndexResult(Context context) {
        return context.scratchIndex;
    }

    public static Scriptable lastStoredScriptable(Context context) {
        Scriptable scriptable = context.scratchScriptable;
        context.scratchScriptable = null;
        return scriptable;
    }

    public static long lastUint32Result(Context context) {
        long j = context.scratchUint32;
        if ((j >>> 32) == 0) {
            return j;
        }
        throw new IllegalStateException();
    }

    public static Scriptable leaveDotQuery(Scriptable scriptable) {
        return ((NativeWith) scriptable).getParentScope();
    }

    public static Scriptable leaveWith(Scriptable scriptable) {
        return ((NativeWith) scriptable).getParentScope();
    }

    public static String makeUrlForGeneratedScript(boolean z, String str, int i) {
        StringBuilder sb;
        String str2;
        if (z) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append('#');
            sb.append(i);
            str2 = "(eval)";
        } else {
            sb = new StringBuilder();
            sb.append(str);
            sb.append('#');
            sb.append(i);
            str2 = "(Function)";
        }
        sb.append(str2);
        return sb.toString();
    }

    public static Ref memberRef(Object obj, Object obj2, Object obj3, Context context, int i) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).memberRef(context, obj2, obj3, i);
        }
        throw notXmlError(obj);
    }

    public static Ref memberRef(Object obj, Object obj2, Context context, int i) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).memberRef(context, obj2, i);
        }
        throw notXmlError(obj);
    }

    public static Object name(Context context, Scriptable scriptable, String str) {
        Scriptable parentScope = scriptable.getParentScope();
        if (parentScope == null) {
            Object obj = topScopeName(context, scriptable, str);
            if (obj == Scriptable.NOT_FOUND) {
                throw notFoundError(scriptable, str);
            }
            return obj;
        }
        return nameOrFunction(context, scriptable, parentScope, str, false);
    }

    @Deprecated
    public static Object nameIncrDecr(Scriptable scriptable, String str, int i) {
        return nameIncrDecr(scriptable, str, Context.getContext(), i);
    }

    public static Object nameIncrDecr(Scriptable scriptable, String str, Context context, int i) {
        do {
            if (context.useDynamicScope && scriptable.getParentScope() == null) {
                scriptable = checkDynamicScope(context.topCallScope, scriptable);
            }
            Scriptable scriptable2 = scriptable;
            do {
                if ((scriptable2 instanceof NativeWith) && (scriptable2.getPrototype() instanceof XMLObject)) {
                    break;
                }
                Object obj = scriptable2.get(str, scriptable);
                if (obj != Scriptable.NOT_FOUND) {
                    return doScriptableIncrDecr(scriptable2, str, scriptable, obj, i);
                }
                scriptable2 = scriptable2.getPrototype();
            } while (scriptable2 != null);
            scriptable = scriptable.getParentScope();
        } while (scriptable != null);
        throw notFoundError(scriptable, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0046, code lost:
        r6 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0075 A[LOOP:0: B:2:0x0002->B:12:0x0075, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object nameOrFunction(Context context, Scriptable scriptable, Scriptable scriptable2, String str, boolean z) {
        Object property;
        Object obj;
        Scriptable parentScope;
        Scriptable scriptable3 = null;
        Scriptable scriptable4 = scriptable;
        while (true) {
            if (scriptable4 instanceof NativeWith) {
                scriptable4 = scriptable4.getPrototype();
                if (!(scriptable4 instanceof XMLObject)) {
                    property = ScriptableObject.getProperty(scriptable4, str);
                    if (property != Scriptable.NOT_FOUND) {
                        break;
                    }
                } else {
                    scriptable4 = (XMLObject) scriptable4;
                    if (scriptable4.has(str, scriptable4)) {
                        obj = scriptable4.get(str, scriptable4);
                        break;
                    } else if (scriptable3 == null) {
                        scriptable3 = scriptable4;
                    }
                }
                parentScope = scriptable2.getParentScope();
                if (parentScope != null) {
                    obj = topScopeName(context, scriptable2, str);
                    if (obj == Scriptable.NOT_FOUND) {
                        if (scriptable3 == null || z) {
                            throw notFoundError(scriptable2, str);
                        }
                        obj = scriptable3.get(str, scriptable3);
                    }
                    scriptable4 = scriptable2;
                } else {
                    scriptable4 = scriptable2;
                    scriptable2 = parentScope;
                }
            } else {
                if (!(scriptable4 instanceof NativeCall)) {
                    property = ScriptableObject.getProperty(scriptable4, str);
                    if (property != Scriptable.NOT_FOUND) {
                        break;
                    }
                } else {
                    Object obj2 = scriptable4.get(str, scriptable4);
                    if (obj2 != Scriptable.NOT_FOUND) {
                        if (z) {
                            scriptable = ScriptableObject.getTopLevelScope(scriptable2);
                        }
                        scriptable4 = scriptable;
                        obj = obj2;
                    }
                }
                parentScope = scriptable2.getParentScope();
                if (parentScope != null) {
                }
            }
        }
        if (z) {
            if (!(obj instanceof Callable)) {
                throw notFunctionError(obj, str);
            }
            storeScriptable(context, scriptable4);
        }
        return obj;
    }

    public static Ref nameRef(Object obj, Object obj2, Context context, Scriptable scriptable, int i) {
        return currentXMLLib(context).nameRef(context, obj, obj2, scriptable, i);
    }

    public static Ref nameRef(Object obj, Context context, Scriptable scriptable, int i) {
        return currentXMLLib(context).nameRef(context, obj, scriptable, i);
    }

    public static Scriptable newArrayLiteral(Object[] objArr, int[] iArr, Context context, Scriptable scriptable) {
        int length = objArr.length;
        int i = 0;
        int length2 = iArr != null ? iArr.length : 0;
        int i2 = length + length2;
        if (i2 <= 1 || length2 * 2 >= i2) {
            Scriptable newArray = context.newArray(scriptable, i2);
            int i3 = 0;
            int i4 = 0;
            while (i != i2) {
                if (i3 == length2 || iArr[i3] != i) {
                    newArray.put(i, newArray, objArr[i4]);
                    i4++;
                } else {
                    i3++;
                }
                i++;
            }
            return newArray;
        }
        if (length2 != 0) {
            Object[] objArr2 = new Object[i2];
            int i5 = 0;
            int i6 = 0;
            while (i != i2) {
                if (i5 == length2 || iArr[i5] != i) {
                    objArr2[i] = objArr[i6];
                    i6++;
                } else {
                    objArr2[i] = Scriptable.NOT_FOUND;
                    i5++;
                }
                i++;
            }
            objArr = objArr2;
        }
        return context.newArray(scriptable, objArr);
    }

    public static Scriptable newBuiltinObject(Context context, Scriptable scriptable, TopLevel.Builtins builtins, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function builtinCtor = TopLevel.getBuiltinCtor(context, topLevelScope, builtins);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return builtinCtor.construct(context, topLevelScope, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Scriptable newCatchScope(Throwable th, Scriptable scriptable, String str, Context context, Scriptable scriptable2) {
        TopLevel.NativeErrors nativeErrors;
        String th2;
        String str2;
        Throwable th3;
        RhinoException rhinoException;
        String sourceName;
        Scriptable newNativeError;
        Object obj;
        EcmaError ecmaError;
        boolean z = false;
        if (th instanceof JavaScriptException) {
            obj = ((JavaScriptException) th).getValue();
        } else {
            if (scriptable != null) {
                obj = ((NativeObject) scriptable).getAssociatedValue(th);
                if (obj == null) {
                    Kit.codeBug();
                }
            } else {
                if (th instanceof EcmaError) {
                    EcmaError ecmaError2 = (EcmaError) th;
                    nativeErrors = TopLevel.NativeErrors.valueOf(ecmaError2.getName());
                    th2 = ecmaError2.getErrorMessage();
                    ecmaError = ecmaError2;
                } else if (th instanceof WrappedException) {
                    WrappedException wrappedException = (WrappedException) th;
                    Throwable wrappedException2 = wrappedException.getWrappedException();
                    str2 = wrappedException2.getClass().getName() + ": " + wrappedException2.getMessage();
                    th3 = wrappedException2;
                    nativeErrors = TopLevel.NativeErrors.JavaException;
                    rhinoException = wrappedException;
                    sourceName = rhinoException.sourceName();
                    if (sourceName == null) {
                        sourceName = "";
                    }
                    int lineNumber = rhinoException.lineNumber();
                    newNativeError = newNativeError(context, scriptable2, nativeErrors, lineNumber <= 0 ? new Object[]{str2, sourceName, Integer.valueOf(lineNumber)} : new Object[]{str2, sourceName});
                    if (newNativeError instanceof NativeError) {
                        ((NativeError) newNativeError).setStackProvider(rhinoException);
                    }
                    if (th3 != null && isVisible(context, th3)) {
                        ScriptableObject.defineProperty(newNativeError, "javaException", context.getWrapFactory().wrap(context, scriptable2, th3, null), 7);
                    }
                    if (isVisible(context, rhinoException)) {
                        ScriptableObject.defineProperty(newNativeError, "rhinoException", context.getWrapFactory().wrap(context, scriptable2, rhinoException, null), 7);
                    }
                    obj = newNativeError;
                } else if (th instanceof EvaluatorException) {
                    RhinoException rhinoException2 = (EvaluatorException) th;
                    nativeErrors = TopLevel.NativeErrors.InternalError;
                    th2 = rhinoException2.getMessage();
                    ecmaError = rhinoException2;
                } else if (!context.hasFeature(13)) {
                    throw Kit.codeBug();
                } else {
                    RhinoException wrappedException3 = new WrappedException(th);
                    nativeErrors = TopLevel.NativeErrors.JavaException;
                    th2 = th.toString();
                    ecmaError = wrappedException3;
                }
                str2 = th2;
                th3 = null;
                rhinoException = ecmaError;
                sourceName = rhinoException.sourceName();
                if (sourceName == null) {
                }
                int lineNumber2 = rhinoException.lineNumber();
                newNativeError = newNativeError(context, scriptable2, nativeErrors, lineNumber2 <= 0 ? new Object[]{str2, sourceName, Integer.valueOf(lineNumber2)} : new Object[]{str2, sourceName});
                if (newNativeError instanceof NativeError) {
                }
                if (th3 != null) {
                    ScriptableObject.defineProperty(newNativeError, "javaException", context.getWrapFactory().wrap(context, scriptable2, th3, null), 7);
                }
                if (isVisible(context, rhinoException)) {
                }
                obj = newNativeError;
            }
            z = true;
        }
        NativeObject nativeObject = new NativeObject();
        nativeObject.defineProperty(str, obj, 4);
        if (isVisible(context, th)) {
            nativeObject.defineProperty("__exception__", Context.javaToJS(th, scriptable2), 6);
        }
        if (z) {
            nativeObject.associateValue(th, obj);
        }
        return nativeObject;
    }

    public static Scriptable newNativeError(Context context, Scriptable scriptable, TopLevel.NativeErrors nativeErrors, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function nativeErrorCtor = TopLevel.getNativeErrorCtor(context, topLevelScope, nativeErrors);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return nativeErrorCtor.construct(context, topLevelScope, objArr);
    }

    public static Scriptable newObject(Object obj, Context context, Scriptable scriptable, Object[] objArr) {
        if (obj instanceof Function) {
            return ((Function) obj).construct(context, scriptable, objArr);
        }
        throw notFunctionError(obj);
    }

    public static Scriptable newObject(Context context, Scriptable scriptable, String str, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function existingCtor = getExistingCtor(context, topLevelScope, str);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return existingCtor.construct(context, topLevelScope, objArr);
    }

    @Deprecated
    public static Scriptable newObjectLiteral(Object[] objArr, Object[] objArr2, Context context, Scriptable scriptable) {
        return newObjectLiteral(objArr, objArr2, null, context, scriptable);
    }

    public static Scriptable newObjectLiteral(Object[] objArr, Object[] objArr2, int[] iArr, Context context, Scriptable scriptable) {
        Scriptable newObject = context.newObject(scriptable);
        int length = objArr.length;
        for (int i = 0; i != length; i++) {
            Object obj = objArr[i];
            int i2 = iArr == null ? 0 : iArr[i];
            Object obj2 = objArr2[i];
            if (!(obj instanceof String)) {
                newObject.put(((Integer) obj).intValue(), newObject, obj2);
            } else if (i2 == 0) {
                String str = (String) obj;
                if (isSpecialProperty(str)) {
                    specialRef(newObject, str, context, scriptable).set(context, scriptable, obj2);
                } else {
                    newObject.put(str, newObject, obj2);
                }
            } else {
                ScriptableObject scriptableObject = (ScriptableObject) newObject;
                Callable callable = (Callable) obj2;
                boolean z = true;
                if (i2 != 1) {
                    z = false;
                }
                scriptableObject.setGetterOrSetter((String) obj, 0, callable, z);
            }
        }
        return newObject;
    }

    public static Object newSpecial(Context context, Object obj, Object[] objArr, Scriptable scriptable, int i) {
        if (i == 1) {
            if (NativeGlobal.isEvalFunction(obj)) {
                throw typeError1("msg.not.ctor", "eval");
            }
        } else if (i != 2) {
            throw Kit.codeBug();
        } else {
            if (NativeWith.isWithFunction(obj)) {
                return NativeWith.newWithSpecial(context, scriptable, objArr);
            }
        }
        return newObject(obj, context, scriptable, objArr);
    }

    public static RuntimeException notFoundError(Scriptable scriptable, String str) {
        throw constructError("ReferenceError", getMessage1("msg.is.not.defined", str));
    }

    public static RuntimeException notFunctionError(Object obj) {
        return notFunctionError(obj, obj);
    }

    public static RuntimeException notFunctionError(Object obj, Object obj2) {
        String obj3 = obj2 == null ? "null" : obj2.toString();
        return obj == Scriptable.NOT_FOUND ? typeError1("msg.function.not.found", obj3) : typeError2("msg.isnt.function", obj3, typeof(obj));
    }

    public static RuntimeException notFunctionError(Object obj, Object obj2, String str) {
        int indexOf;
        String scriptRuntime = toString(obj);
        if ((obj instanceof NativeFunction) && (indexOf = scriptRuntime.indexOf(123, scriptRuntime.indexOf(41))) > -1) {
            scriptRuntime = scriptRuntime.substring(0, indexOf + 1) + "...}";
        }
        return obj2 == Scriptable.NOT_FOUND ? typeError2("msg.function.not.found.in", str, scriptRuntime) : typeError3("msg.isnt.function.in", str, scriptRuntime, typeof(obj2));
    }

    public static RuntimeException notXmlError(Object obj) {
        throw typeError1("msg.isnt.xml.object", toString(obj));
    }

    public static String numberToString(double d, int i) {
        if (i < 2 || i > 36) {
            throw Context.reportRuntimeError1("msg.bad.radix", Integer.toString(i));
        }
        if (d != d) {
            return "NaN";
        }
        if (d == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        if (d == RoundRectDrawableWithShadow.COS_45) {
            return "0";
        }
        if (i != 10) {
            return DToA.JS_dtobasestr(i, d);
        }
        String numberToString = FastDtoa.numberToString(d);
        if (numberToString != null) {
            return numberToString;
        }
        StringBuilder sb = new StringBuilder();
        DToA.JS_dtostr(sb, 0, 0, d);
        return sb.toString();
    }

    public static Object[] padArguments(Object[] objArr, int i) {
        if (i < objArr.length) {
            return objArr;
        }
        Object[] objArr2 = new Object[i];
        int i2 = 0;
        while (i2 < objArr.length) {
            objArr2[i2] = objArr[i2];
            i2++;
        }
        while (i2 < i) {
            objArr2[i2] = Undefined.instance;
            i2++;
        }
        return objArr2;
    }

    @Deprecated
    public static Object propIncrDecr(Object obj, String str, Context context, int i) {
        return propIncrDecr(obj, str, context, getTopCallScope(context), i);
    }

    public static Object propIncrDecr(Object obj, String str, Context context, Scriptable scriptable, int i) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            Scriptable scriptable2 = objectOrNull;
            do {
                Object obj2 = scriptable2.get(str, objectOrNull);
                if (obj2 != Scriptable.NOT_FOUND) {
                    return doScriptableIncrDecr(scriptable2, str, objectOrNull, obj2, i);
                }
                scriptable2 = scriptable2.getPrototype();
            } while (scriptable2 != null);
            objectOrNull.put(str, objectOrNull, NaNobj);
            return NaNobj;
        }
        throw undefReadError(obj, str);
    }

    public static EcmaError rangeError(String str) {
        return constructError("RangeError", str);
    }

    public static Object refDel(Ref ref, Context context) {
        return wrapBoolean(ref.delete(context));
    }

    public static Object refGet(Ref ref, Context context) {
        return ref.get(context);
    }

    @Deprecated
    public static Object refIncrDecr(Ref ref, Context context, int i) {
        return refIncrDecr(ref, context, getTopCallScope(context), i);
    }

    public static Object refIncrDecr(Ref ref, Context context, Scriptable scriptable, int i) {
        double number;
        Object obj = ref.get(context);
        boolean z = (i & 2) != 0;
        if (obj instanceof Number) {
            number = ((Number) obj).doubleValue();
        } else {
            number = toNumber(obj);
            if (z) {
                obj = wrapNumber(number);
            }
        }
        Number wrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        ref.set(context, scriptable, wrapNumber);
        return z ? obj : wrapNumber;
    }

    @Deprecated
    public static Object refSet(Ref ref, Object obj, Context context) {
        return refSet(ref, obj, context, getTopCallScope(context));
    }

    public static Object refSet(Ref ref, Object obj, Context context, Scriptable scriptable) {
        return ref.set(context, scriptable, obj);
    }

    public static boolean same(Object obj, Object obj2) {
        if (!typeof(obj).equals(typeof(obj2))) {
            return false;
        }
        if (!(obj instanceof Number)) {
            return m26eq(obj, obj2);
        }
        if (isNaN(obj) && isNaN(obj2)) {
            return true;
        }
        return obj.equals(obj2);
    }

    public static boolean sameZero(Object obj, Object obj2) {
        if (!typeof(obj).equals(typeof(obj2))) {
            return false;
        }
        if (!(obj instanceof Number)) {
            return m26eq(obj, obj2);
        }
        if (isNaN(obj) && isNaN(obj2)) {
            return true;
        }
        double doubleValue = ((Number) obj).doubleValue();
        if (obj2 instanceof Number) {
            double doubleValue2 = ((Number) obj2).doubleValue();
            if ((doubleValue == negativeZero && doubleValue2 == RoundRectDrawableWithShadow.COS_45) || (doubleValue == RoundRectDrawableWithShadow.COS_45 && doubleValue2 == negativeZero)) {
                return true;
            }
        }
        return eqNumber(doubleValue, obj2);
    }

    public static Object searchDefaultNamespace(Context context) {
        Scriptable scriptable = context.currentActivationCall;
        if (scriptable == null) {
            scriptable = getTopCallScope(context);
        }
        while (true) {
            Scriptable parentScope = scriptable.getParentScope();
            if (parentScope == null) {
                Object property = ScriptableObject.getProperty(scriptable, DEFAULT_NS_TAG);
                if (property != Scriptable.NOT_FOUND) {
                    return property;
                }
                return null;
            }
            Object obj = scriptable.get(DEFAULT_NS_TAG, scriptable);
            if (obj != Scriptable.NOT_FOUND) {
                return obj;
            }
            scriptable = parentScope;
        }
    }

    public static void setBuiltinProtoAndParent(ScriptableObject scriptableObject, Scriptable scriptable, TopLevel.Builtins builtins) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        scriptableObject.setParentScope(topLevelScope);
        scriptableObject.setPrototype(TopLevel.getBuiltinPrototype(topLevelScope, builtins));
    }

    public static Object setConst(Scriptable scriptable, Object obj, Context context, String str) {
        if (scriptable instanceof XMLObject) {
            scriptable.put(str, scriptable, obj);
        } else {
            ScriptableObject.putConstProperty(scriptable, str, obj);
        }
        return obj;
    }

    public static Object setDefaultNamespace(Object obj, Context context) {
        Scriptable scriptable = context.currentActivationCall;
        if (scriptable == null) {
            scriptable = getTopCallScope(context);
        }
        Object defaultXmlNamespace = currentXMLLib(context).toDefaultXmlNamespace(context, obj);
        if (!scriptable.has(DEFAULT_NS_TAG, scriptable)) {
            ScriptableObject.defineProperty(scriptable, DEFAULT_NS_TAG, defaultXmlNamespace, 6);
        } else {
            scriptable.put(DEFAULT_NS_TAG, scriptable, defaultXmlNamespace);
        }
        return Undefined.instance;
    }

    public static void setEnumNumbers(Object obj, boolean z) {
        ((IdEnumeration) obj).enumNumbers = z;
    }

    public static void setFunctionProtoAndParent(BaseFunction baseFunction, Scriptable scriptable) {
        baseFunction.setParentScope(scriptable);
        baseFunction.setPrototype(ScriptableObject.getFunctionPrototype(scriptable));
    }

    public static Object setName(Scriptable scriptable, Object obj, Context context, Scriptable scriptable2, String str) {
        if (scriptable != null) {
            ScriptableObject.putProperty(scriptable, str, obj);
        } else {
            if (context.hasFeature(11) || context.hasFeature(8)) {
                Context.reportWarning(getMessage1("msg.assn.create.strict", str));
            }
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable2);
            if (context.useDynamicScope) {
                topLevelScope = checkDynamicScope(context.topCallScope, topLevelScope);
            }
            topLevelScope.put(str, topLevelScope, obj);
        }
        return obj;
    }

    @Deprecated
    public static Object setObjectElem(Object obj, Object obj2, Object obj3, Context context) {
        return setObjectElem(obj, obj2, obj3, context, getTopCallScope(context));
    }

    public static Object setObjectElem(Object obj, Object obj2, Object obj3, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return setObjectElem(objectOrNull, obj2, obj3, context);
        }
        throw undefWriteError(obj, obj2, obj3);
    }

    public static Object setObjectElem(Scriptable scriptable, Object obj, Object obj2, Context context) {
        if (scriptable instanceof XMLObject) {
            ((XMLObject) scriptable).put(context, obj, obj2);
        } else if (isSymbol(obj)) {
            ScriptableObject.putProperty(scriptable, (Symbol) obj, obj2);
        } else {
            String stringIdOrIndex = toStringIdOrIndex(context, obj);
            if (stringIdOrIndex == null) {
                ScriptableObject.putProperty(scriptable, lastIndexResult(context), obj2);
            } else {
                ScriptableObject.putProperty(scriptable, stringIdOrIndex, obj2);
            }
        }
        return obj2;
    }

    @Deprecated
    public static Object setObjectIndex(Object obj, double d, Object obj2, Context context) {
        return setObjectIndex(obj, d, obj2, context, getTopCallScope(context));
    }

    public static Object setObjectIndex(Object obj, double d, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            int i = (int) d;
            return ((double) i) == d ? setObjectIndex(objectOrNull, i, obj2, context) : setObjectProp(objectOrNull, toString(d), obj2, context);
        }
        throw undefWriteError(obj, String.valueOf(d), obj2);
    }

    public static Object setObjectIndex(Scriptable scriptable, int i, Object obj, Context context) {
        ScriptableObject.putProperty(scriptable, i, obj);
        return obj;
    }

    @Deprecated
    public static Object setObjectProp(Object obj, String str, Object obj2, Context context) {
        return setObjectProp(obj, str, obj2, context, getTopCallScope(context));
    }

    public static Object setObjectProp(Object obj, String str, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return setObjectProp(objectOrNull, str, obj2, context);
        }
        throw undefWriteError(obj, str, obj2);
    }

    public static Object setObjectProp(Scriptable scriptable, String str, Object obj, Context context) {
        ScriptableObject.putProperty(scriptable, str, obj);
        return obj;
    }

    public static void setObjectProtoAndParent(ScriptableObject scriptableObject, Scriptable scriptable) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        scriptableObject.setParentScope(topLevelScope);
        scriptableObject.setPrototype(ScriptableObject.getClassPrototype(topLevelScope, scriptableObject.getClassName()));
    }

    public static void setRegExpProxy(Context context, RegExpProxy regExpProxy) {
        if (regExpProxy != null) {
            context.regExpProxy = regExpProxy;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean shallowEq(Object obj, Object obj2) {
        if (obj == obj2) {
            if (!(obj instanceof Number)) {
                return true;
            }
            double doubleValue = ((Number) obj).doubleValue();
            return doubleValue == doubleValue;
        } else if (obj == null || obj == Undefined.instance || obj == Undefined.SCRIPTABLE_UNDEFINED) {
            return (obj == Undefined.instance && obj2 == Undefined.SCRIPTABLE_UNDEFINED) || (obj == Undefined.SCRIPTABLE_UNDEFINED && obj2 == Undefined.instance);
        } else if (obj instanceof Number) {
            return (obj2 instanceof Number) && ((Number) obj).doubleValue() == ((Number) obj2).doubleValue();
        } else if (obj instanceof CharSequence) {
            if (!(obj2 instanceof CharSequence)) {
                return false;
            }
            return obj.toString().equals(obj2.toString());
        } else if (obj instanceof Boolean) {
            if (!(obj2 instanceof Boolean)) {
                return false;
            }
            return obj.equals(obj2);
        } else if (obj instanceof Scriptable) {
            return (obj instanceof Wrapper) && (obj2 instanceof Wrapper) && ((Wrapper) obj).unwrap() == ((Wrapper) obj2).unwrap();
        } else {
            warnAboutNonJSObject(obj);
            return obj == obj2;
        }
    }

    @Deprecated
    public static Ref specialRef(Object obj, String str, Context context) {
        return specialRef(obj, str, context, getTopCallScope(context));
    }

    public static Ref specialRef(Object obj, String str, Context context, Scriptable scriptable) {
        return SpecialRef.createSpecial(context, scriptable, obj, str);
    }

    public static void storeIndexResult(Context context, int i) {
        context.scratchIndex = i;
    }

    public static void storeScriptable(Context context, Scriptable scriptable) {
        if (context.scratchScriptable == null) {
            context.scratchScriptable = scriptable;
            return;
        }
        throw new IllegalStateException();
    }

    public static void storeUint32Result(Context context, long j) {
        if ((j >>> 32) == 0) {
            context.scratchUint32 = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static Object strictSetName(Scriptable scriptable, Object obj, Context context, Scriptable scriptable2, String str) {
        if (scriptable != null) {
            ScriptableObject.putProperty(scriptable, str, obj);
            return obj;
        }
        throw constructError("ReferenceError", "Assignment to undefined \"" + str + "\" in strict mode");
    }

    public static double stringPrefixToNumber(String str, int i, int i2) {
        return stringToNumber(str, i, str.length() - 1, i2, true);
    }

    public static double stringToNumber(String str, int i, int i2, int i3) {
        return stringToNumber(str, i, i2, i3, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
        if (r27 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
        return org.mozilla.javascript.ScriptRuntime.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a0, code lost:
        if (r10 != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a7, code lost:
        r14 = r14 + 1.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00a5, code lost:
        if ((r10 & r12) != false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static double stringToNumber(String str, int i, int i2, int i3, boolean z) {
        char c;
        char c2;
        char c3;
        int i4;
        int i5;
        int i6 = i;
        char c4 = i3 < 10 ? (char) ((i3 + 48) - 1) : '9';
        char c5 = 'A';
        char c6 = 'a';
        if (i3 > 10) {
            c = (char) ((i3 + 97) - 10);
            c2 = (char) ((i3 + 65) - 10);
        } else {
            c = 'a';
            c2 = 'A';
        }
        int i7 = i6;
        double d = RoundRectDrawableWithShadow.COS_45;
        while (true) {
            c3 = '0';
            if (i7 > i2) {
                break;
            }
            char charAt = str.charAt(i7);
            if ('0' > charAt || charAt > c4) {
                if (c6 <= charAt && charAt < c) {
                    i4 = charAt - 'a';
                } else if (c5 > charAt || charAt >= c2) {
                    break;
                } else {
                    i4 = charAt - 'A';
                }
                i5 = i4 + 10;
            } else {
                i5 = charAt - '0';
            }
            d = (d * i3) + i5;
            i7++;
            c5 = 'A';
            c6 = 'a';
        }
        if (i6 == i7) {
            return NaN;
        }
        if (d > 9.007199254740991E15d) {
            if (i3 == 10) {
                try {
                    return Double.parseDouble(str.substring(i6, i7));
                } catch (NumberFormatException unused) {
                    return NaN;
                }
            } else if (i3 == 2 || i3 == 4 || i3 == 8 || i3 == 16 || i3 == 32) {
                int i8 = 53;
                int i9 = 1;
                char c7 = 0;
                boolean z2 = false;
                boolean z3 = false;
                int i10 = 0;
                double d2 = RoundRectDrawableWithShadow.COS_45;
                while (true) {
                    if (i9 == 1) {
                        if (i6 == i7) {
                            break;
                        }
                        int i11 = i6 + 1;
                        char charAt2 = str.charAt(i6);
                        i10 = (c3 > charAt2 || charAt2 > '9') ? ('a' > charAt2 || charAt2 > 'z') ? charAt2 - '7' : charAt2 - 'W' : charAt2 - '0';
                        i6 = i11;
                        i9 = i3;
                    }
                    i9 >>= 1;
                    boolean z4 = (i10 & i9) != 0;
                    if (c7 != 0) {
                        if (c7 == 1) {
                            d *= 2.0d;
                            if (z4) {
                                d += 1.0d;
                            }
                            i8--;
                            if (i8 == 0) {
                                z3 = z4;
                                c7 = 2;
                            }
                        } else if (c7 != 2) {
                            if (c7 != 3) {
                                if (c7 != 4) {
                                }
                            } else if (z4) {
                                c7 = 4;
                            }
                            d2 *= 2.0d;
                        } else {
                            z2 = z4;
                            d2 = 2.0d;
                            c7 = 3;
                        }
                    } else if (z4) {
                        i8--;
                        d = 1.0d;
                        c7 = 1;
                    }
                    c3 = '0';
                }
                if (c7 == 0) {
                    return RoundRectDrawableWithShadow.COS_45;
                }
                if (c7 != 3) {
                    if (c7 == 4) {
                    }
                }
                return d * d2;
            }
        }
        return d;
    }

    public static long testUint32String(String str) {
        int length = str.length();
        if (1 <= length && length <= 10) {
            int charAt = str.charAt(0) - '0';
            if (charAt == 0) {
                return length == 1 ? 0L : -1L;
            } else if (1 <= charAt && charAt <= 9) {
                long j = charAt;
                for (int i = 1; i != length; i++) {
                    int charAt2 = str.charAt(i) - '0';
                    if (charAt2 < 0 || charAt2 > 9) {
                        return -1L;
                    }
                    j = (j * 10) + charAt2;
                }
                if ((j >>> 32) == 0) {
                    return j;
                }
            }
        }
        return -1L;
    }

    public static JavaScriptException throwCustomError(Context context, Scriptable scriptable, String str, String str2) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        return new JavaScriptException(context.newObject(scriptable, str, new Object[]{str2, sourcePositionFromStack, Integer.valueOf(iArr[0])}), sourcePositionFromStack, iArr[0]);
    }

    public static JavaScriptException throwError(Context context, Scriptable scriptable, String str) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        return new JavaScriptException(newBuiltinObject(context, scriptable, TopLevel.Builtins.Error, new Object[]{str, sourcePositionFromStack, Integer.valueOf(iArr[0])}), sourcePositionFromStack, iArr[0]);
    }

    public static boolean toBoolean(Object obj) {
        while (!(obj instanceof Boolean)) {
            if (obj == null || obj == Undefined.instance) {
                return false;
            }
            if (obj instanceof CharSequence) {
                return ((CharSequence) obj).length() != 0;
            } else if (obj instanceof Number) {
                double doubleValue = ((Number) obj).doubleValue();
                return doubleValue == doubleValue && doubleValue != RoundRectDrawableWithShadow.COS_45;
            } else if (!(obj instanceof Scriptable)) {
                warnAboutNonJSObject(obj);
                return true;
            } else if ((obj instanceof ScriptableObject) && ((ScriptableObject) obj).avoidObjectDetection()) {
                return false;
            } else {
                if (Context.getContext().isVersionECMA1()) {
                    return true;
                }
                obj = ((Scriptable) obj).getDefaultValue(BooleanClass);
                if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                    throw errorWithClassName("msg.primitive.expected", obj);
                }
            }
        }
        return ((Boolean) obj).booleanValue();
    }

    public static CharSequence toCharSequence(Object obj) {
        return obj instanceof NativeString ? ((NativeString) obj).toCharSequence() : obj instanceof CharSequence ? (CharSequence) obj : toString(obj);
    }

    public static int toInt32(double d) {
        return DoubleConversion.doubleToInt32(d);
    }

    public static int toInt32(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : toInt32(toNumber(obj));
    }

    public static int toInt32(Object[] objArr, int i) {
        if (i < objArr.length) {
            return toInt32(objArr[i]);
        }
        return 0;
    }

    public static double toInteger(double d) {
        if (d != d) {
            return RoundRectDrawableWithShadow.COS_45;
        }
        int i = (d > RoundRectDrawableWithShadow.COS_45 ? 1 : (d == RoundRectDrawableWithShadow.COS_45 ? 0 : -1));
        return (i == 0 || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY) ? d : i > 0 ? Math.floor(d) : Math.ceil(d);
    }

    public static double toInteger(Object obj) {
        return toInteger(toNumber(obj));
    }

    public static double toInteger(Object[] objArr, int i) {
        return i < objArr.length ? toInteger(objArr[i]) : RoundRectDrawableWithShadow.COS_45;
    }

    public static Scriptable toIterator(Context context, Scriptable scriptable, Scriptable scriptable2, boolean z) {
        if (ScriptableObject.hasProperty(scriptable2, NativeIterator.ITERATOR_PROPERTY_NAME)) {
            Object property = ScriptableObject.getProperty(scriptable2, NativeIterator.ITERATOR_PROPERTY_NAME);
            if (!(property instanceof Callable)) {
                throw typeError0("msg.invalid.iterator");
            }
            Callable callable = (Callable) property;
            Object[] objArr = new Object[1];
            objArr[0] = z ? Boolean.TRUE : Boolean.FALSE;
            Object call = callable.call(context, scriptable, scriptable2, objArr);
            if (!(call instanceof Scriptable)) {
                throw typeError0("msg.iterator.primitive");
            }
            return (Scriptable) call;
        }
        return null;
    }

    public static long toLength(Object[] objArr, int i) {
        double integer = toInteger(objArr, i);
        if (integer <= RoundRectDrawableWithShadow.COS_45) {
            return 0L;
        }
        return (long) Math.min(integer, 9.007199254740991E15d);
    }

    public static double toNumber(Object obj) {
        while (!(obj instanceof Number)) {
            if (obj == null) {
                return RoundRectDrawableWithShadow.COS_45;
            }
            if (obj == Undefined.instance) {
                return NaN;
            }
            if (obj instanceof String) {
                return toNumber((String) obj);
            }
            if (obj instanceof CharSequence) {
                return toNumber(obj.toString());
            }
            if (obj instanceof Boolean) {
                if (!((Boolean) obj).booleanValue()) {
                    return RoundRectDrawableWithShadow.COS_45;
                }
                return 1.0d;
            } else if (obj instanceof Symbol) {
                throw typeError0("msg.not.a.number");
            } else {
                if (!(obj instanceof Scriptable)) {
                    warnAboutNonJSObject(obj);
                    return NaN;
                }
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
                if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                    throw errorWithClassName("msg.primitive.expected", obj);
                }
            }
        }
        return ((Number) obj).doubleValue();
    }

    public static double toNumber(String str) {
        char charAt;
        int i;
        char charAt2;
        int length = str.length();
        int i2 = 0;
        while (i2 != length) {
            char charAt3 = str.charAt(i2);
            if (!isStrWhiteSpaceChar(charAt3)) {
                int i3 = length - 1;
                while (true) {
                    charAt = str.charAt(i3);
                    if (!isStrWhiteSpaceChar(charAt)) {
                        break;
                    }
                    i3--;
                }
                Context currentContext = Context.getCurrentContext();
                boolean z = currentContext == null || currentContext.getLanguageVersion() < 200;
                int i4 = 16;
                if (charAt3 == '0') {
                    int i5 = i2 + 2;
                    if (i5 <= i3) {
                        char charAt4 = str.charAt(i2 + 1);
                        if (charAt4 != 'x' && charAt4 != 'X') {
                            i4 = (z || !(charAt4 == 'o' || charAt4 == 'O')) ? (z || !(charAt4 == 'b' || charAt4 == 'B')) ? -1 : 2 : 8;
                        }
                        if (i4 != -1) {
                            return z ? stringPrefixToNumber(str, i5, i4) : stringToNumber(str, i5, i3, i4);
                        }
                    }
                } else if (z && ((charAt3 == '+' || charAt3 == '-') && (i = i2 + 3) <= i3 && str.charAt(i2 + 1) == '0' && ((charAt2 = str.charAt(i2 + 2)) == 'x' || charAt2 == 'X'))) {
                    double stringPrefixToNumber = stringPrefixToNumber(str, i, 16);
                    return charAt3 == '-' ? -stringPrefixToNumber : stringPrefixToNumber;
                }
                if (charAt == 'y') {
                    if (charAt3 == '+' || charAt3 == '-') {
                        i2++;
                    }
                    return (i2 + 7 != i3 || !str.regionMatches(i2, "Infinity", 0, 8)) ? NaN : charAt3 == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                }
                String substring = str.substring(i2, i3 + 1);
                for (int length2 = substring.length() - 1; length2 >= 0; length2--) {
                    char charAt5 = substring.charAt(length2);
                    if (('0' > charAt5 || charAt5 > '9') && charAt5 != '.' && charAt5 != 'e' && charAt5 != 'E' && charAt5 != '+' && charAt5 != '-') {
                        return NaN;
                    }
                }
                try {
                    return Double.parseDouble(substring);
                } catch (NumberFormatException unused) {
                    return NaN;
                }
            }
            i2++;
        }
        return RoundRectDrawableWithShadow.COS_45;
    }

    public static double toNumber(Object[] objArr, int i) {
        return i < objArr.length ? toNumber(objArr[i]) : NaN;
    }

    public static Scriptable toObject(Context context, Scriptable scriptable, Object obj) {
        ScriptableObject nativeBoolean;
        TopLevel.Builtins builtins;
        if (obj != null) {
            if (Undefined.isUndefined(obj)) {
                throw typeError0("msg.undef.to.object");
            }
            if (isSymbol(obj)) {
                nativeBoolean = new NativeSymbol((NativeSymbol) obj);
                builtins = TopLevel.Builtins.Symbol;
            } else if (obj instanceof Scriptable) {
                return (Scriptable) obj;
            } else {
                if (obj instanceof CharSequence) {
                    nativeBoolean = new NativeString((CharSequence) obj);
                    builtins = TopLevel.Builtins.String;
                } else if (obj instanceof Number) {
                    nativeBoolean = new NativeNumber(((Number) obj).doubleValue());
                    builtins = TopLevel.Builtins.Number;
                } else if (!(obj instanceof Boolean)) {
                    Object wrap = context.getWrapFactory().wrap(context, scriptable, obj, null);
                    if (!(wrap instanceof Scriptable)) {
                        throw errorWithClassName("msg.invalid.type", obj);
                    }
                    return (Scriptable) wrap;
                } else {
                    nativeBoolean = new NativeBoolean(((Boolean) obj).booleanValue());
                    builtins = TopLevel.Builtins.Boolean;
                }
            }
            setBuiltinProtoAndParent(nativeBoolean, scriptable, builtins);
            return nativeBoolean;
        }
        throw typeError0("msg.null.to.object");
    }

    @Deprecated
    public static Scriptable toObject(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        return toObject(context, scriptable, obj);
    }

    public static Scriptable toObject(Scriptable scriptable, Object obj) {
        return obj instanceof Scriptable ? (Scriptable) obj : toObject(Context.getContext(), scriptable, obj);
    }

    @Deprecated
    public static Scriptable toObject(Scriptable scriptable, Object obj, Class<?> cls) {
        return obj instanceof Scriptable ? (Scriptable) obj : toObject(Context.getContext(), scriptable, obj);
    }

    @Deprecated
    public static Scriptable toObjectOrNull(Context context, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj != null && obj != Undefined.instance) {
            return toObject(context, getTopCallScope(context), obj);
        }
        return null;
    }

    public static Scriptable toObjectOrNull(Context context, Object obj, Scriptable scriptable) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj != null && obj != Undefined.instance) {
            return toObject(context, scriptable, obj);
        }
        return null;
    }

    public static Object toPrimitive(Object obj) {
        return toPrimitive(obj, null);
    }

    public static Object toPrimitive(Object obj, Class<?> cls) {
        if (!(obj instanceof Scriptable)) {
            return obj;
        }
        Object defaultValue = ((Scriptable) obj).getDefaultValue(cls);
        if ((defaultValue instanceof Scriptable) && !isSymbol(defaultValue)) {
            throw typeError0("msg.bad.default.value");
        }
        return defaultValue;
    }

    public static String toString(double d) {
        return numberToString(d, 10);
    }

    public static String toString(Object obj) {
        while (obj != null) {
            if (obj == Undefined.instance || obj == Undefined.SCRIPTABLE_UNDEFINED) {
                return "undefined";
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof Number) {
                return numberToString(((Number) obj).doubleValue(), 10);
            }
            if (obj instanceof Symbol) {
                throw typeError0("msg.not.a.string");
            }
            if (!(obj instanceof Scriptable)) {
                return obj.toString();
            }
            obj = ((Scriptable) obj).getDefaultValue(StringClass);
            if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                throw errorWithClassName("msg.primitive.expected", obj);
            }
        }
        return "null";
    }

    public static String toString(Object[] objArr, int i) {
        return i < objArr.length ? toString(objArr[i]) : "undefined";
    }

    public static String toStringIdOrIndex(Context context, Object obj) {
        if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            int i = (int) doubleValue;
            if (i != doubleValue) {
                return toString(obj);
            }
            storeIndexResult(context, i);
            return null;
        }
        String scriptRuntime = obj instanceof String ? (String) obj : toString(obj);
        long indexFromString = indexFromString(scriptRuntime);
        if (indexFromString < 0) {
            return scriptRuntime;
        }
        storeIndexResult(context, (int) indexFromString);
        return null;
    }

    public static char toUint16(Object obj) {
        return (char) DoubleConversion.doubleToInt32(toNumber(obj));
    }

    public static long toUint32(double d) {
        return DoubleConversion.doubleToInt32(d) & 4294967295L;
    }

    public static long toUint32(Object obj) {
        return toUint32(toNumber(obj));
    }

    public static Object topScopeName(Context context, Scriptable scriptable, String str) {
        if (context.useDynamicScope) {
            scriptable = checkDynamicScope(context.topCallScope, scriptable);
        }
        return ScriptableObject.getProperty(scriptable, str);
    }

    public static EcmaError typeError(String str) {
        return constructError("TypeError", str);
    }

    public static EcmaError typeError0(String str) {
        return typeError(getMessage0(str));
    }

    public static EcmaError typeError1(String str, Object obj) {
        return typeError(getMessage1(str, obj));
    }

    public static EcmaError typeError2(String str, Object obj, Object obj2) {
        return typeError(getMessage2(str, obj, obj2));
    }

    public static EcmaError typeError3(String str, String str2, String str3, String str4) {
        return typeError(getMessage3(str, str2, str3, str4));
    }

    @Deprecated
    public static BaseFunction typeErrorThrower() {
        return typeErrorThrower(Context.getCurrentContext());
    }

    public static BaseFunction typeErrorThrower(Context context) {
        if (context.typeErrorThrower == null) {
            BaseFunction baseFunction = new BaseFunction() { // from class: org.mozilla.javascript.ScriptRuntime.1
                public static final long serialVersionUID = -5891740962154902286L;

                @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
                public Object call(Context context2, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
                    throw ScriptRuntime.typeError0("msg.op.not.allowed");
                }

                @Override // org.mozilla.javascript.BaseFunction
                public int getLength() {
                    return 0;
                }
            };
            setFunctionProtoAndParent(baseFunction, context.topCallScope);
            baseFunction.preventExtensions();
            context.typeErrorThrower = baseFunction;
        }
        return context.typeErrorThrower;
    }

    public static String typeof(Object obj) {
        if (obj == null) {
            return "object";
        }
        if (obj == Undefined.instance) {
            return "undefined";
        }
        if (obj instanceof ScriptableObject) {
            return ((ScriptableObject) obj).getTypeOf();
        }
        if (obj instanceof Scriptable) {
            return obj instanceof Callable ? "function" : "object";
        } else if (obj instanceof CharSequence) {
            return Main.STRING_TAG_STR;
        } else {
            if (obj instanceof Number) {
                return "number";
            }
            if (!(obj instanceof Boolean)) {
                throw errorWithClassName("msg.invalid.type", obj);
            }
            return ClassTransform.BOOLEAN;
        }
    }

    public static String typeofName(Scriptable scriptable, String str) {
        Context context = Context.getContext();
        Scriptable bind = bind(context, scriptable, str);
        return bind == null ? "undefined" : typeof(getObjectProp(bind, str, context));
    }

    public static RuntimeException undefCallError(Object obj, Object obj2) {
        return typeError2("msg.undef.method.call", toString(obj), toString(obj2));
    }

    public static RuntimeException undefDeleteError(Object obj, Object obj2) {
        throw typeError2("msg.undef.prop.delete", toString(obj), toString(obj2));
    }

    public static RuntimeException undefReadError(Object obj, Object obj2) {
        return typeError2("msg.undef.prop.read", toString(obj), toString(obj2));
    }

    public static RuntimeException undefWriteError(Object obj, Object obj2, Object obj3) {
        return typeError3("msg.undef.prop.write", toString(obj), toString(obj2), toString(obj3));
    }

    public static String uneval(Context context, Scriptable scriptable, Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj == Undefined.instance) {
            return "undefined";
        }
        if (obj instanceof CharSequence) {
            String escapeString = escapeString(obj.toString());
            StringBuilder sb = new StringBuilder(escapeString.length() + 2);
            sb.append('\"');
            sb.append(escapeString);
            sb.append('\"');
            return sb.toString();
        } else if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            return (doubleValue != RoundRectDrawableWithShadow.COS_45 || 1.0d / doubleValue >= RoundRectDrawableWithShadow.COS_45) ? toString(doubleValue) : "-0";
        } else if (obj instanceof Boolean) {
            return toString(obj);
        } else {
            if (!(obj instanceof Scriptable)) {
                warnAboutNonJSObject(obj);
                return obj.toString();
            }
            Scriptable scriptable2 = (Scriptable) obj;
            if (ScriptableObject.hasProperty(scriptable2, "toSource")) {
                Object property = ScriptableObject.getProperty(scriptable2, "toSource");
                if (property instanceof Function) {
                    return toString(((Function) property).call(context, scriptable, scriptable2, emptyArgs));
                }
            }
            return toString(obj);
        }
    }

    public static Object updateDotQuery(boolean z, Scriptable scriptable) {
        return ((NativeWith) scriptable).updateDotQuery(z);
    }

    public static void warnAboutNonJSObject(Object obj) {
        if (!"true".equals(getMessage0("params.omit.non.js.object.warning"))) {
            String message2 = getMessage2("msg.non.js.object.warning", obj, obj.getClass().getName());
            Context.reportWarning(message2);
            System.err.println(message2);
        }
    }

    public static Boolean wrapBoolean(boolean z) {
        return z ? Boolean.TRUE : Boolean.FALSE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Scriptable wrapException(Throwable th, Scriptable scriptable, Context context) {
        String str;
        Throwable th2;
        String th3;
        RhinoException rhinoException;
        String str2;
        Throwable wrappedException;
        String sourceName;
        Scriptable newObject;
        EcmaError ecmaError;
        if (!(th instanceof EcmaError)) {
            if (th instanceof WrappedException) {
                WrappedException wrappedException2 = (WrappedException) th;
                th2 = wrappedException2.getWrappedException();
                th3 = wrappedException.getClass().getName() + ": " + wrappedException.getMessage();
                str = "JavaException";
                rhinoException = wrappedException2;
            } else if (th instanceof EvaluatorException) {
                RhinoException rhinoException2 = (EvaluatorException) th;
                th3 = rhinoException2.getMessage();
                str2 = "InternalError";
                ecmaError = rhinoException2;
            } else if (!context.hasFeature(13)) {
                throw Kit.codeBug();
            } else {
                RhinoException wrappedException3 = new WrappedException(th);
                str = "JavaException";
                th2 = null;
                th3 = th.toString();
                rhinoException = wrappedException3;
            }
            sourceName = rhinoException.sourceName();
            if (sourceName == null) {
                sourceName = "";
            }
            int lineNumber = rhinoException.lineNumber();
            newObject = context.newObject(scriptable, str, lineNumber <= 0 ? new Object[]{th3, sourceName, Integer.valueOf(lineNumber)} : new Object[]{th3, sourceName});
            ScriptableObject.putProperty(newObject, "name", str);
            if (newObject instanceof NativeError) {
                ((NativeError) newObject).setStackProvider(rhinoException);
            }
            if (th2 != null && isVisible(context, th2)) {
                ScriptableObject.defineProperty(newObject, "javaException", context.getWrapFactory().wrap(context, scriptable, th2, null), 7);
            }
            if (isVisible(context, rhinoException)) {
                ScriptableObject.defineProperty(newObject, "rhinoException", context.getWrapFactory().wrap(context, scriptable, rhinoException, null), 7);
            }
            return newObject;
        }
        EcmaError ecmaError2 = (EcmaError) th;
        str2 = ecmaError2.getName();
        th3 = ecmaError2.getErrorMessage();
        ecmaError = ecmaError2;
        str = str2;
        th2 = null;
        rhinoException = ecmaError;
        sourceName = rhinoException.sourceName();
        if (sourceName == null) {
        }
        int lineNumber2 = rhinoException.lineNumber();
        newObject = context.newObject(scriptable, str, lineNumber2 <= 0 ? new Object[]{th3, sourceName, Integer.valueOf(lineNumber2)} : new Object[]{th3, sourceName});
        ScriptableObject.putProperty(newObject, "name", str);
        if (newObject instanceof NativeError) {
        }
        if (th2 != null) {
            ScriptableObject.defineProperty(newObject, "javaException", context.getWrapFactory().wrap(context, scriptable, th2, null), 7);
        }
        if (isVisible(context, rhinoException)) {
        }
        return newObject;
    }

    public static Integer wrapInt(int i) {
        return Integer.valueOf(i);
    }

    public static Number wrapNumber(double d) {
        return d != d ? NaNobj : new Double(d);
    }

    public static Scriptable wrapRegExp(Context context, Scriptable scriptable, Object obj) {
        return context.getRegExpProxy().wrapRegExp(context, scriptable, obj);
    }
}

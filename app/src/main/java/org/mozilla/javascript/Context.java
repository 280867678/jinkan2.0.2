package org.mozilla.javascript;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.debug.DebuggableScript;
import org.mozilla.javascript.debug.Debugger;
import org.mozilla.javascript.xml.XMLLib;

/* loaded from: classes5.dex */
public class Context {
    public static final int FEATURE_DYNAMIC_SCOPE = 7;
    public static final int FEATURE_E4X = 6;
    public static final int FEATURE_ENHANCED_JAVA_ACCESS = 13;
    public static final int FEATURE_ENUMERATE_IDS_FIRST = 16;
    public static final int FEATURE_INTEGER_WITHOUT_DECIMAL_PLACE = 18;
    public static final int FEATURE_LITTLE_ENDIAN = 19;
    public static final int FEATURE_LOCATION_INFORMATION_IN_ERROR = 10;
    public static final int FEATURE_MEMBER_EXPR_AS_FUNCTION_NAME = 2;
    public static final int FEATURE_NON_ECMA_GET_YEAR = 1;
    public static final int FEATURE_OLD_UNDEF_NULL_THIS = 15;
    public static final int FEATURE_PARENT_PROTO_PROPERTIES = 5;
    @Deprecated
    public static final int FEATURE_PARENT_PROTO_PROPRTIES = 5;
    public static final int FEATURE_RESERVED_KEYWORD_AS_IDENTIFIER = 3;
    public static final int FEATURE_STRICT_EVAL = 9;
    public static final int FEATURE_STRICT_MODE = 11;
    public static final int FEATURE_STRICT_VARS = 8;
    public static final int FEATURE_THREAD_SAFE_OBJECTS = 17;
    public static final int FEATURE_TO_STRING_AS_SOURCE = 4;
    public static final int FEATURE_V8_EXTENSIONS = 14;
    public static final int FEATURE_WARNING_AS_ERROR = 12;
    public static final int VERSION_1_0 = 100;
    public static final int VERSION_1_1 = 110;
    public static final int VERSION_1_2 = 120;
    public static final int VERSION_1_3 = 130;
    public static final int VERSION_1_4 = 140;
    public static final int VERSION_1_5 = 150;
    public static final int VERSION_1_6 = 160;
    public static final int VERSION_1_7 = 170;
    public static final int VERSION_1_8 = 180;
    public static final int VERSION_DEFAULT = 0;
    public static final int VERSION_ES6 = 200;
    public static final int VERSION_UNKNOWN = -1;
    public static final String errorReporterProperty = "error reporter";
    public static String implementationVersion = null;
    public static final String languageVersionProperty = "language version";
    public Set<String> activationNames;
    public ClassLoader applicationClassLoader;
    public XMLLib cachedXMLLib;
    public ClassShutter classShutter;
    public NativeCall currentActivationCall;
    public Debugger debugger;
    public Object debuggerData;
    public int enterCount;
    public ErrorReporter errorReporter;
    public final ContextFactory factory;
    public boolean generateObserverCount;
    public boolean generatingDebug;
    public boolean generatingDebugChanged;
    public boolean generatingSource;
    public boolean hasClassShutter;
    public int instructionCount;
    public int instructionThreshold;
    public Object interpreterSecurityDomain;
    public boolean isContinuationsTopCall;
    public boolean isTopLevelStrict;
    public ObjToIntMap iterating;
    public Object lastInterpreterFrame;
    public Locale locale;
    public int maximumInterpreterStackDepth;
    public int optimizationLevel;
    public ObjArray previousInterpreterInvocations;
    public Object propertyListeners;
    public RegExpProxy regExpProxy;
    public int scratchIndex;
    public Scriptable scratchScriptable;
    public long scratchUint32;
    public Object sealKey;
    public boolean sealed;
    public SecurityController securityController;
    public Map<Object, Object> threadLocalMap;
    public Scriptable topCallScope;
    public BaseFunction typeErrorThrower;
    public boolean useDynamicScope;
    public int version;
    public WrapFactory wrapFactory;
    public static final Object[] emptyArgs = ScriptRuntime.emptyArgs;
    public static Class<?> codegenClass = Kit.classOrNull("org.mozilla.javascript.optimizer.Codegen");
    public static Class<?> interpreterClass = Kit.classOrNull("org.mozilla.javascript.Interpreter");

    /* loaded from: classes5.dex */
    public interface ClassShutterSetter {
        ClassShutter getClassShutter();

        void setClassShutter(ClassShutter classShutter);
    }

    @Deprecated
    public Context() {
        this(ContextFactory.getGlobal());
    }

    public Context(ContextFactory contextFactory) {
        this.generatingSource = true;
        int i = 0;
        this.generateObserverCount = false;
        if (contextFactory != null) {
            this.factory = contextFactory;
            this.version = 0;
            this.optimizationLevel = codegenClass == null ? -1 : i;
            this.maximumInterpreterStackDepth = Integer.MAX_VALUE;
            return;
        }
        throw new IllegalArgumentException("factory == null");
    }

    @Deprecated
    public static void addContextListener(ContextListener contextListener) {
        if (!"org.mozilla.javascript.tools.debugger.Main".equals(contextListener.getClass().getName())) {
            ContextFactory.getGlobal().addListener(contextListener);
            return;
        }
        try {
            contextListener.getClass().getMethod("attachTo", Kit.classOrNull("org.mozilla.javascript.ContextFactory")).invoke(contextListener, ContextFactory.getGlobal());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public static <T> T call(ContextAction<T> contextAction) {
        return (T) call(ContextFactory.getGlobal(), contextAction);
    }

    public static Object call(ContextFactory contextFactory, final Callable callable, final Scriptable scriptable, final Scriptable scriptable2, final Object[] objArr) {
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        return call(contextFactory, new ContextAction() { // from class: me.tvspark.l21
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                Object call;
                call = Callable.this.call(context, scriptable, scriptable2, objArr);
                return call;
            }
        });
    }

    public static <T> T call(ContextFactory contextFactory, ContextAction<T> contextAction) {
        try {
            return contextAction.run(enter(null, contextFactory));
        } finally {
            exit();
        }
    }

    public static void checkLanguageVersion(int i) {
        if (isValidLanguageVersion(i)) {
            return;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bad language version: ", i));
    }

    public static void checkOptimizationLevel(int i) {
        if (isValidOptimizationLevel(i)) {
            return;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Optimization level outside [-1..9]: ", i));
    }

    private Object compileImpl(Scriptable scriptable, Reader reader, String str, String str2, int i, Object obj, boolean z, Evaluator evaluator, ErrorReporter errorReporter) throws IOException {
        Reader reader2;
        String str3;
        Evaluator createCompiler;
        Object compile;
        String str4 = str2 == null ? "unnamed script" : str2;
        if (obj == null || getSecurityController() != null) {
            boolean z2 = true;
            if (!((reader == null) ^ (str == null))) {
                Kit.codeBug();
            }
            if (scriptable != null) {
                z2 = false;
            }
            if (!(z2 ^ z)) {
                Kit.codeBug();
            }
            CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
            compilerEnvirons.initFromContext(this);
            ErrorReporter errorReporter2 = errorReporter == null ? compilerEnvirons.getErrorReporter() : errorReporter;
            if (this.debugger == null || reader == null) {
                reader2 = reader;
                str3 = str;
            } else {
                str3 = Kit.readReader(reader);
                reader2 = null;
            }
            ScriptNode parse = parse(reader2, str3, str4, i, compilerEnvirons, errorReporter2, z);
            if (evaluator == null) {
                try {
                    createCompiler = createCompiler();
                } catch (ClassFileWriter.ClassFileFormatException unused) {
                    Evaluator createInterpreter = createInterpreter();
                    ScriptNode parse2 = parse(reader2, str3, str4, i, compilerEnvirons, errorReporter2, z);
                    compile = createInterpreter.compile(compilerEnvirons, parse2, parse2.getEncodedSource(), z);
                    createCompiler = createInterpreter;
                }
            } else {
                createCompiler = evaluator;
            }
            compile = createCompiler.compile(compilerEnvirons, parse, parse.getEncodedSource(), z);
            if (this.debugger != null) {
                if (str3 == null) {
                    Kit.codeBug();
                }
                if (!(compile instanceof DebuggableScript)) {
                    throw new RuntimeException("NOT SUPPORTED");
                }
                notifyDebugger_r(this, (DebuggableScript) compile, str3);
            }
            return z ? createCompiler.createFunctionObject(this, scriptable, compile, obj) : createCompiler.createScriptObject(compile, obj);
        }
        throw new IllegalArgumentException("securityDomain should be null if setSecurityController() was never called");
    }

    private Evaluator createCompiler() {
        Class<?> cls;
        Evaluator evaluator = (this.optimizationLevel < 0 || (cls = codegenClass) == null) ? null : (Evaluator) Kit.newInstanceOrNull(cls);
        return evaluator == null ? createInterpreter() : evaluator;
    }

    public static Evaluator createInterpreter() {
        return (Evaluator) Kit.newInstanceOrNull(interpreterClass);
    }

    public static Context enter() {
        return enter(null);
    }

    @Deprecated
    public static Context enter(Context context) {
        return enter(context, ContextFactory.getGlobal());
    }

    public static final Context enter(Context context, ContextFactory contextFactory) {
        Object threadContextHelper = VMBridge.instance.getThreadContextHelper();
        Context context2 = VMBridge.instance.getContext(threadContextHelper);
        if (context2 == null) {
            if (context == null) {
                context = contextFactory.makeContext();
                if (context.enterCount != 0) {
                    throw new IllegalStateException("factory.makeContext() returned Context instance already associated with some thread");
                }
                contextFactory.onContextCreated(context);
                if (contextFactory.isSealed() && !context.isSealed()) {
                    context.seal(null);
                }
            } else if (context.enterCount != 0) {
                throw new IllegalStateException("can not use Context instance already associated with some thread");
            }
            VMBridge.instance.setContext(threadContextHelper, context);
            context2 = context;
        }
        context2.enterCount++;
        return context2;
    }

    public static void exit() {
        Object threadContextHelper = VMBridge.instance.getThreadContextHelper();
        Context context = VMBridge.instance.getContext(threadContextHelper);
        if (context != null) {
            if (context.enterCount < 1) {
                Kit.codeBug();
            }
            int i = context.enterCount - 1;
            context.enterCount = i;
            if (i != 0) {
                return;
            }
            VMBridge.instance.setContext(threadContextHelper, null);
            context.factory.onContextReleased(context);
            return;
        }
        throw new IllegalStateException("Calling Context.exit without previous Context.enter");
    }

    private void firePropertyChangeImpl(Object obj, String str, Object obj2, Object obj3) {
        int i = 0;
        while (true) {
            Object listener = Kit.getListener(obj, i);
            if (listener == null) {
                return;
            }
            if (listener instanceof PropertyChangeListener) {
                ((PropertyChangeListener) listener).propertyChange(new PropertyChangeEvent(this, str, obj2, obj3));
            }
            i++;
        }
    }

    public static Context getContext() {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            return currentContext;
        }
        throw new RuntimeException("No Context associated with current Thread");
    }

    public static Context getCurrentContext() {
        return VMBridge.instance.getContext(VMBridge.instance.getThreadContextHelper());
    }

    public static DebuggableScript getDebuggableView(Script script) {
        if (script instanceof NativeFunction) {
            return ((NativeFunction) script).getDebuggableView();
        }
        return null;
    }

    public static String getSourcePositionFromStack(int[] iArr) {
        StackTraceElement[] stackTrace;
        int lineNumber;
        Evaluator createInterpreter;
        Context currentContext = getCurrentContext();
        if (currentContext == null) {
            return null;
        }
        if (currentContext.lastInterpreterFrame != null && (createInterpreter = createInterpreter()) != null) {
            return createInterpreter.getSourcePositionFromStack(currentContext, iArr);
        }
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            String fileName = stackTraceElement.getFileName();
            if (fileName != null && !fileName.endsWith(".java") && (lineNumber = stackTraceElement.getLineNumber()) >= 0) {
                iArr[0] = lineNumber;
                return fileName;
            }
        }
        return null;
    }

    public static Object getUndefinedValue() {
        return Undefined.instance;
    }

    public static boolean isValidLanguageVersion(int i) {
        switch (i) {
            case 0:
            case 100:
            case 110:
            case 120:
            case 130:
            case 140:
            case 150:
            case 160:
            case 170:
            case 180:
            case 200:
                return true;
            default:
                return false;
        }
    }

    public static boolean isValidOptimizationLevel(int i) {
        return -1 <= i && i <= 9;
    }

    public static Object javaToJS(Object obj, Scriptable scriptable) {
        if ((obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Scriptable)) {
            return obj;
        }
        if (obj instanceof Character) {
            return String.valueOf(((Character) obj).charValue());
        }
        Context context = getContext();
        return context.getWrapFactory().wrap(context, scriptable, obj, null);
    }

    public static Object jsToJava(Object obj, Class<?> cls) throws EvaluatorException {
        return NativeJavaObject.coerceTypeImpl(cls, obj);
    }

    public static void notifyDebugger_r(Context context, DebuggableScript debuggableScript, String str) {
        context.debugger.handleCompilationDone(context, debuggableScript, str);
        for (int i = 0; i != debuggableScript.getFunctionCount(); i++) {
            notifyDebugger_r(context, debuggableScript.getFunction(i), str);
        }
    }

    public static void onSealedMutation() {
        throw new IllegalStateException();
    }

    private ScriptNode parse(Reader reader, String str, String str2, int i, CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter, boolean z) throws IOException {
        Parser parser = new Parser(compilerEnvirons, errorReporter);
        if (z) {
            parser.calledByCompileFunction = true;
        }
        if (isStrictMode()) {
            parser.setDefaultUseStrictDirective(true);
        }
        AstRoot parse = str != null ? parser.parse(str, str2, i) : parser.parse(reader, str2, i);
        if (!z || (parse.getFirstChild() != null && parse.getFirstChild().getType() == 110)) {
            return new IRFactory(compilerEnvirons, errorReporter).transformTree(parse);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("compileFunction only accepts source with single JS function: ", str));
    }

    @Deprecated
    public static void removeContextListener(ContextListener contextListener) {
        ContextFactory.getGlobal().addListener(contextListener);
    }

    public static void reportError(String str) {
        int[] iArr = {0};
        reportError(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static void reportError(String str, String str2, int i, String str3, int i2) {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            currentContext.getErrorReporter().error(str, str2, i, str3, i2);
            return;
        }
        throw new EvaluatorException(str, str2, i, str3, i2);
    }

    public static EvaluatorException reportRuntimeError(String str) {
        int[] iArr = {0};
        return reportRuntimeError(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static EvaluatorException reportRuntimeError(String str, String str2, int i, String str3, int i2) {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            return currentContext.getErrorReporter().runtimeError(str, str2, i, str3, i2);
        }
        throw new EvaluatorException(str, str2, i, str3, i2);
    }

    public static EvaluatorException reportRuntimeError0(String str) {
        return reportRuntimeError(ScriptRuntime.getMessage0(str));
    }

    public static EvaluatorException reportRuntimeError1(String str, Object obj) {
        return reportRuntimeError(ScriptRuntime.getMessage1(str, obj));
    }

    public static EvaluatorException reportRuntimeError2(String str, Object obj, Object obj2) {
        return reportRuntimeError(ScriptRuntime.getMessage2(str, obj, obj2));
    }

    public static EvaluatorException reportRuntimeError3(String str, Object obj, Object obj2, Object obj3) {
        return reportRuntimeError(ScriptRuntime.getMessage3(str, obj, obj2, obj3));
    }

    public static EvaluatorException reportRuntimeError4(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return reportRuntimeError(ScriptRuntime.getMessage4(str, obj, obj2, obj3, obj4));
    }

    public static void reportWarning(String str) {
        int[] iArr = {0};
        reportWarning(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static void reportWarning(String str, String str2, int i, String str3, int i2) {
        Context context = getContext();
        if (context.hasFeature(12)) {
            reportError(str, str2, i, str3, i2);
        } else {
            context.getErrorReporter().warning(str, str2, i, str3, i2);
        }
    }

    public static void reportWarning(String str, Throwable th) {
        int[] iArr = {0};
        String sourcePositionFromStack = getSourcePositionFromStack(iArr);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println(str);
        th.printStackTrace(printWriter);
        printWriter.flush();
        reportWarning(stringWriter.toString(), sourcePositionFromStack, iArr[0], null, 0);
    }

    @Deprecated
    public static void setCachingEnabled(boolean z) {
    }

    public static RuntimeException throwAsScriptRuntimeEx(Throwable th) {
        Context context;
        while (th instanceof InvocationTargetException) {
            th = ((InvocationTargetException) th).getTargetException();
        }
        if (!(th instanceof Error) || ((context = getContext()) != null && context.hasFeature(13))) {
            if (!(th instanceof RhinoException)) {
                throw new WrappedException(th);
            }
            throw ((RhinoException) th);
        }
        throw ((Error) th);
    }

    public static boolean toBoolean(Object obj) {
        return ScriptRuntime.toBoolean(obj);
    }

    public static double toNumber(Object obj) {
        return ScriptRuntime.toNumber(obj);
    }

    public static Scriptable toObject(Object obj, Scriptable scriptable) {
        return ScriptRuntime.toObject(scriptable, obj);
    }

    @Deprecated
    public static Scriptable toObject(Object obj, Scriptable scriptable, Class<?> cls) {
        return ScriptRuntime.toObject(scriptable, obj);
    }

    public static String toString(Object obj) {
        return ScriptRuntime.toString(obj);
    }

    @Deprecated
    public static Object toType(Object obj, Class<?> cls) throws IllegalArgumentException {
        try {
            return jsToJava(obj, cls);
        } catch (EvaluatorException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public void addActivationName(String str) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.activationNames == null) {
            this.activationNames = new HashSet();
        }
        this.activationNames.add(str);
    }

    public final void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.addListener(this.propertyListeners, propertyChangeListener);
    }

    public Object callFunctionWithContinuations(Callable callable, Scriptable scriptable, Object[] objArr) throws ContinuationPending {
        if (callable instanceof InterpretedFunction) {
            if (ScriptRuntime.hasTopCall(this)) {
                throw new IllegalStateException("Cannot have any pending top calls when executing a script with continuations");
            }
            this.isContinuationsTopCall = true;
            return ScriptRuntime.doTopCall(callable, this, scriptable, scriptable, objArr, this.isTopLevelStrict);
        }
        throw new IllegalArgumentException("Function argument was not created by interpreted mode ");
    }

    public ContinuationPending captureContinuation() {
        return new ContinuationPending(Interpreter.captureContinuation(this));
    }

    public final Function compileFunction(Scriptable scriptable, String str, String str2, int i, Object obj) {
        return compileFunction(scriptable, str, null, null, str2, i, obj);
    }

    public final Function compileFunction(Scriptable scriptable, String str, Evaluator evaluator, ErrorReporter errorReporter, String str2, int i, Object obj) {
        try {
            return (Function) compileImpl(scriptable, null, str, str2, i, obj, true, evaluator, errorReporter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final Script compileReader(Reader reader, String str, int i, Object obj) throws IOException {
        return (Script) compileImpl(null, reader, null, str, i < 0 ? 0 : i, obj, false, null, null);
    }

    @Deprecated
    public final Script compileReader(Scriptable scriptable, Reader reader, String str, int i, Object obj) throws IOException {
        return compileReader(reader, str, i, obj);
    }

    public final Script compileString(String str, String str2, int i, Object obj) {
        return compileString(str, null, null, str2, i < 0 ? 0 : i, obj);
    }

    public final Script compileString(String str, Evaluator evaluator, ErrorReporter errorReporter, String str2, int i, Object obj) {
        try {
            return (Script) compileImpl(null, null, str, str2, i, obj, false, evaluator, errorReporter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GeneratedClassLoader createClassLoader(ClassLoader classLoader) {
        return getFactory().createClassLoader(classLoader);
    }

    public final String decompileFunction(Function function, int i) {
        if (function instanceof BaseFunction) {
            return ((BaseFunction) function).decompile(i, 0);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("function ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(function.getClassName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("() {\n\t[native code]\n}\n");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public final String decompileFunctionBody(Function function, int i) {
        return function instanceof BaseFunction ? ((BaseFunction) function).decompile(i, 1) : "[native code]\n";
    }

    public final String decompileScript(Script script, int i) {
        return ((NativeFunction) script).decompile(i, 0);
    }

    public final Object evaluateReader(Scriptable scriptable, Reader reader, String str, int i, Object obj) throws IOException {
        Script compileReader = compileReader(scriptable, reader, str, i, obj);
        if (compileReader != null) {
            return compileReader.exec(this, scriptable);
        }
        return null;
    }

    public final Object evaluateString(Scriptable scriptable, String str, String str2, int i, Object obj) {
        Script compileString = compileString(str, str2, i, obj);
        if (compileString != null) {
            return compileString.exec(this, scriptable);
        }
        return null;
    }

    public Object executeScriptWithContinuations(Script script, Scriptable scriptable) throws ContinuationPending {
        if (script instanceof InterpretedFunction) {
            InterpretedFunction interpretedFunction = (InterpretedFunction) script;
            if (interpretedFunction.isScript()) {
                return callFunctionWithContinuations(interpretedFunction, scriptable, ScriptRuntime.emptyArgs);
            }
        }
        throw new IllegalArgumentException("Script argument was not a script or was not created by interpreted mode ");
    }

    public final void firePropertyChange(String str, Object obj, Object obj2) {
        Object obj3 = this.propertyListeners;
        if (obj3 != null) {
            firePropertyChangeImpl(obj3, str, obj, obj2);
        }
    }

    public final ClassLoader getApplicationClassLoader() {
        if (this.applicationClassLoader == null) {
            ContextFactory factory = getFactory();
            ClassLoader applicationClassLoader = factory.getApplicationClassLoader();
            if (applicationClassLoader == null) {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null && Kit.testIfCanLoadRhinoClasses(contextClassLoader)) {
                    return contextClassLoader;
                }
                Class<?> cls = factory.getClass();
                if (cls == ScriptRuntime.ContextFactoryClass) {
                    cls = Context.class;
                }
                applicationClassLoader = cls.getClassLoader();
            }
            this.applicationClassLoader = applicationClassLoader;
        }
        return this.applicationClassLoader;
    }

    public final synchronized ClassShutter getClassShutter() {
        return this.classShutter;
    }

    public final synchronized ClassShutterSetter getClassShutterSetter() {
        if (this.hasClassShutter) {
            return null;
        }
        this.hasClassShutter = true;
        return new ClassShutterSetter() { // from class: org.mozilla.javascript.Context.1
            @Override // org.mozilla.javascript.Context.ClassShutterSetter
            public ClassShutter getClassShutter() {
                return Context.this.classShutter;
            }

            @Override // org.mozilla.javascript.Context.ClassShutterSetter
            public void setClassShutter(ClassShutter classShutter) {
                Context.this.classShutter = classShutter;
            }
        };
    }

    public final Debugger getDebugger() {
        return this.debugger;
    }

    public final Object getDebuggerContextData() {
        return this.debuggerData;
    }

    public XMLLib.Factory getE4xImplementationFactory() {
        return getFactory().getE4xImplementationFactory();
    }

    public final Object[] getElements(Scriptable scriptable) {
        return ScriptRuntime.getArrayElements(scriptable);
    }

    public final ErrorReporter getErrorReporter() {
        ErrorReporter errorReporter = this.errorReporter;
        return errorReporter == null ? DefaultErrorReporter.instance : errorReporter;
    }

    public final ContextFactory getFactory() {
        return this.factory;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:35|(2:37|31)|27|28|30|31) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getImplementationVersion() {
        InputStream inputStream;
        Attributes mainAttributes;
        if (implementationVersion == null) {
            InputStream inputStream2 = null;
            try {
                Enumeration<URL> resources = Context.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
                while (resources.hasMoreElements()) {
                    try {
                        inputStream = resources.nextElement().openStream();
                        try {
                        } catch (IOException unused) {
                            if (inputStream == null) {
                            }
                            inputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException unused3) {
                        inputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if ("Mozilla Rhino".equals(new Manifest(inputStream).getMainAttributes().getValue("Implementation-Title"))) {
                        String str = "Rhino " + mainAttributes.getValue("Implementation-Version") + StringUtils.SPACE + mainAttributes.getValue("Built-Date").replaceAll("-", StringUtils.SPACE);
                        implementationVersion = str;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        return str;
                    }
                    if (inputStream == null) {
                    }
                    inputStream.close();
                }
            } catch (IOException unused5) {
                return null;
            }
        }
        return implementationVersion;
    }

    public final int getInstructionObserverThreshold() {
        return this.instructionThreshold;
    }

    public final int getLanguageVersion() {
        return this.version;
    }

    public final Locale getLocale() {
        if (this.locale == null) {
            this.locale = Locale.getDefault();
        }
        return this.locale;
    }

    public final int getMaximumInterpreterStackDepth() {
        return this.maximumInterpreterStackDepth;
    }

    public final int getOptimizationLevel() {
        return this.optimizationLevel;
    }

    public RegExpProxy getRegExpProxy() {
        Class<?> classOrNull;
        if (this.regExpProxy == null && (classOrNull = Kit.classOrNull("org.mozilla.javascript.regexp.RegExpImpl")) != null) {
            this.regExpProxy = (RegExpProxy) Kit.newInstanceOrNull(classOrNull);
        }
        return this.regExpProxy;
    }

    public SecurityController getSecurityController() {
        SecurityController global = SecurityController.global();
        return global != null ? global : this.securityController;
    }

    public final Object getThreadLocal(Object obj) {
        Map<Object, Object> map = this.threadLocalMap;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    public final WrapFactory getWrapFactory() {
        if (this.wrapFactory == null) {
            this.wrapFactory = new WrapFactory();
        }
        return this.wrapFactory;
    }

    public boolean hasFeature(int i) {
        return getFactory().hasFeature(this, i);
    }

    public final Scriptable initSafeStandardObjects(ScriptableObject scriptableObject) {
        return initSafeStandardObjects(scriptableObject, false);
    }

    public final ScriptableObject initSafeStandardObjects() {
        return initSafeStandardObjects(null, false);
    }

    public ScriptableObject initSafeStandardObjects(ScriptableObject scriptableObject, boolean z) {
        return ScriptRuntime.initSafeStandardObjects(this, scriptableObject, z);
    }

    public final Scriptable initStandardObjects(ScriptableObject scriptableObject) {
        return initStandardObjects(scriptableObject, false);
    }

    public final ScriptableObject initStandardObjects() {
        return initStandardObjects(null, false);
    }

    public ScriptableObject initStandardObjects(ScriptableObject scriptableObject, boolean z) {
        return ScriptRuntime.initStandardObjects(this, scriptableObject, z);
    }

    public final boolean isActivationNeeded(String str) {
        Set<String> set = this.activationNames;
        return set != null && set.contains(str);
    }

    public final boolean isGeneratingDebug() {
        return this.generatingDebug;
    }

    public final boolean isGeneratingDebugChanged() {
        return this.generatingDebugChanged;
    }

    public final boolean isGeneratingSource() {
        return this.generatingSource;
    }

    public final boolean isSealed() {
        return this.sealed;
    }

    public final boolean isStrictMode() {
        NativeCall nativeCall;
        return this.isTopLevelStrict || ((nativeCall = this.currentActivationCall) != null && nativeCall.isStrict);
    }

    public final boolean isVersionECMA1() {
        int i = this.version;
        return i == 0 || i >= 130;
    }

    public Scriptable newArray(Scriptable scriptable, int i) {
        NativeArray nativeArray = new NativeArray(i);
        ScriptRuntime.setBuiltinProtoAndParent(nativeArray, scriptable, TopLevel.Builtins.Array);
        return nativeArray;
    }

    public Scriptable newArray(Scriptable scriptable, Object[] objArr) {
        if (objArr.getClass().getComponentType() == ScriptRuntime.ObjectClass) {
            NativeArray nativeArray = new NativeArray(objArr);
            ScriptRuntime.setBuiltinProtoAndParent(nativeArray, scriptable, TopLevel.Builtins.Array);
            return nativeArray;
        }
        throw new IllegalArgumentException();
    }

    public Scriptable newObject(Scriptable scriptable) {
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
        return nativeObject;
    }

    public Scriptable newObject(Scriptable scriptable, String str) {
        return newObject(scriptable, str, ScriptRuntime.emptyArgs);
    }

    public Scriptable newObject(Scriptable scriptable, String str, Object[] objArr) {
        return ScriptRuntime.newObject(this, scriptable, str, objArr);
    }

    public void observeInstructionCount(int i) {
        getFactory().observeInstructionCount(this, i);
    }

    public final synchronized void putThreadLocal(Object obj, Object obj2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.threadLocalMap == null) {
            this.threadLocalMap = new HashMap();
        }
        this.threadLocalMap.put(obj, obj2);
    }

    public void removeActivationName(String str) {
        if (this.sealed) {
            onSealedMutation();
        }
        Set<String> set = this.activationNames;
        if (set != null) {
            set.remove(str);
        }
    }

    public final void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.removeListener(this.propertyListeners, propertyChangeListener);
    }

    public final void removeThreadLocal(Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        Map<Object, Object> map = this.threadLocalMap;
        if (map == null) {
            return;
        }
        map.remove(obj);
    }

    public Object resumeContinuation(Object obj, Scriptable scriptable, Object obj2) throws ContinuationPending {
        return Interpreter.restartContinuation((NativeContinuation) obj, this, scriptable, new Object[]{obj2});
    }

    public final void seal(Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.sealed = true;
        this.sealKey = obj;
    }

    public final void setApplicationClassLoader(ClassLoader classLoader) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (classLoader == null) {
            this.applicationClassLoader = null;
        } else if (!Kit.testIfCanLoadRhinoClasses(classLoader)) {
            throw new IllegalArgumentException("Loader can not resolve Rhino classes");
        } else {
            this.applicationClassLoader = classLoader;
        }
    }

    public final synchronized void setClassShutter(ClassShutter classShutter) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (classShutter == null) {
            throw new IllegalArgumentException();
        }
        if (this.hasClassShutter) {
            throw new SecurityException("Cannot overwrite existing ClassShutter object");
        }
        this.classShutter = classShutter;
        this.hasClassShutter = true;
    }

    public final void setDebugger(Debugger debugger, Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.debugger = debugger;
        this.debuggerData = obj;
    }

    public final ErrorReporter setErrorReporter(ErrorReporter errorReporter) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (errorReporter != null) {
            ErrorReporter errorReporter2 = getErrorReporter();
            if (errorReporter == errorReporter2) {
                return errorReporter2;
            }
            Object obj = this.propertyListeners;
            if (obj != null) {
                firePropertyChangeImpl(obj, errorReporterProperty, errorReporter2, errorReporter);
            }
            this.errorReporter = errorReporter;
            return errorReporter2;
        }
        throw new IllegalArgumentException();
    }

    public void setGenerateObserverCount(boolean z) {
        this.generateObserverCount = z;
    }

    public final void setGeneratingDebug(boolean z) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingDebugChanged = true;
        if (z && getOptimizationLevel() > 0) {
            setOptimizationLevel(0);
        }
        this.generatingDebug = z;
    }

    public final void setGeneratingSource(boolean z) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingSource = z;
    }

    public final void setInstructionObserverThreshold(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (i >= 0) {
            this.instructionThreshold = i;
            setGenerateObserverCount(i > 0);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setLanguageVersion(int i) {
        int i2;
        if (this.sealed) {
            onSealedMutation();
        }
        checkLanguageVersion(i);
        Object obj = this.propertyListeners;
        if (obj != null && i != (i2 = this.version)) {
            firePropertyChangeImpl(obj, languageVersionProperty, Integer.valueOf(i2), Integer.valueOf(i));
        }
        this.version = i;
    }

    public final Locale setLocale(Locale locale) {
        if (this.sealed) {
            onSealedMutation();
        }
        Locale locale2 = this.locale;
        this.locale = locale;
        return locale2;
    }

    public final void setMaximumInterpreterStackDepth(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.optimizationLevel == -1) {
            if (i < 1) {
                throw new IllegalArgumentException("Cannot set maximumInterpreterStackDepth to less than 1");
            }
            this.maximumInterpreterStackDepth = i;
            return;
        }
        throw new IllegalStateException("Cannot set maximumInterpreterStackDepth when optimizationLevel != -1");
    }

    public final void setOptimizationLevel(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        int i2 = -1;
        if (i == -2) {
            i = -1;
        }
        checkOptimizationLevel(i);
        if (codegenClass != null) {
            i2 = i;
        }
        this.optimizationLevel = i2;
    }

    public final void setSecurityController(SecurityController securityController) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (securityController != null) {
            if (this.securityController != null) {
                throw new SecurityException("Can not overwrite existing SecurityController object");
            }
            if (SecurityController.hasGlobal()) {
                throw new SecurityException("Can not overwrite existing global SecurityController object");
            }
            this.securityController = securityController;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final void setWrapFactory(WrapFactory wrapFactory) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (wrapFactory != null) {
            this.wrapFactory = wrapFactory;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final boolean stringIsCompilableUnit(String str) {
        boolean z;
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        compilerEnvirons.initFromContext(this);
        compilerEnvirons.setGeneratingSource(false);
        Parser parser = new Parser(compilerEnvirons, DefaultErrorReporter.instance);
        try {
            parser.parse(str, (String) null, 1);
            z = false;
        } catch (EvaluatorException unused) {
            z = true;
        }
        return !z || !parser.eof();
    }

    public final void unseal(Object obj) {
        if (obj != null) {
            if (this.sealKey != obj) {
                throw new IllegalArgumentException();
            }
            if (!this.sealed) {
                throw new IllegalStateException();
            }
            this.sealed = false;
            this.sealKey = null;
            return;
        }
        throw new IllegalArgumentException();
    }
}

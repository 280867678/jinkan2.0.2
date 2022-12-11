package org.mozilla.javascript.tools.debugger;

import com.just.agentweb.DefaultWebClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.SystemUtils;
import org.eclipse.jetty.util.URIUtil;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeCall;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.SecurityUtilities;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.debug.DebugFrame;
import org.mozilla.javascript.debug.DebuggableObject;
import org.mozilla.javascript.debug.DebuggableScript;
import org.mozilla.javascript.debug.Debugger;

/* loaded from: classes5.dex */
public class Dim {
    public static final int BREAK = 4;
    public static final int EXIT = 5;

    /* renamed from: GO */
    public static final int f4734GO = 3;
    public static final int IPROXY_COMPILE_SCRIPT = 2;
    public static final int IPROXY_DEBUG = 0;
    public static final int IPROXY_EVAL_SCRIPT = 3;
    public static final int IPROXY_LISTEN = 1;
    public static final int IPROXY_OBJECT_IDS = 7;
    public static final int IPROXY_OBJECT_PROPERTY = 6;
    public static final int IPROXY_OBJECT_TO_STRING = 5;
    public static final int IPROXY_STRING_IS_COMPILABLE = 4;
    public static final int STEP_INTO = 1;
    public static final int STEP_OUT = 2;
    public static final int STEP_OVER = 0;
    public boolean breakFlag;
    public boolean breakOnEnter;
    public boolean breakOnExceptions;
    public boolean breakOnReturn;
    public GuiCallback callback;
    public ContextFactory contextFactory;
    public StackFrame evalFrame;
    public String evalRequest;
    public String evalResult;
    public boolean insideInterruptLoop;
    public volatile ContextData interruptedContextData;
    public DimIProxy listener;
    public ScopeProvider scopeProvider;
    public SourceProvider sourceProvider;
    public int frameIndex = -1;
    public Object monitor = new Object();
    public Object eventThreadMonitor = new Object();
    public volatile int returnValue = -1;
    public final Map<String, SourceInfo> urlToSourceInfo = Collections.synchronizedMap(new HashMap());
    public final Map<String, FunctionSource> functionNames = Collections.synchronizedMap(new HashMap());
    public final Map<DebuggableScript, FunctionSource> functionToSource = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes5.dex */
    public static class ContextData {
        public boolean breakNextLine;
        public boolean eventThreadFlag;
        public Throwable lastProcessedException;
        public ObjArray frameStack = new ObjArray();
        public int stopAtFrameDepth = -1;

        public static ContextData get(Context context) {
            return (ContextData) context.getDebuggerContextData();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void popFrame() {
            this.frameStack.pop();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pushFrame(StackFrame stackFrame) {
            this.frameStack.push(stackFrame);
        }

        public int frameCount() {
            return this.frameStack.size();
        }

        public StackFrame getFrame(int i) {
            return (StackFrame) this.frameStack.get((this.frameStack.size() - i) - 1);
        }
    }

    /* loaded from: classes5.dex */
    public static class DimIProxy implements ContextAction, ContextFactory.Listener, Debugger {
        public boolean booleanResult;
        public Dim dim;

        /* renamed from: id */
        public Object f4735id;
        public Object object;
        public Object[] objectArrayResult;
        public Object objectResult;
        public String stringResult;
        public String text;
        public int type;
        public String url;

        public DimIProxy(Dim dim, int i) {
            this.dim = dim;
            this.type = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void withContext() {
            this.dim.contextFactory.call(this);
        }

        @Override // org.mozilla.javascript.ContextFactory.Listener
        public void contextCreated(Context context) {
            if (this.type != 1) {
                Kit.codeBug();
            }
            context.setDebugger(new DimIProxy(this.dim, 0), new ContextData());
            context.setGeneratingDebug(true);
            context.setOptimizationLevel(-1);
        }

        @Override // org.mozilla.javascript.ContextFactory.Listener
        public void contextReleased(Context context) {
            if (this.type != 1) {
                Kit.codeBug();
            }
        }

        @Override // org.mozilla.javascript.debug.Debugger
        public DebugFrame getFrame(Context context, DebuggableScript debuggableScript) {
            if (this.type != 0) {
                Kit.codeBug();
            }
            FunctionSource functionSource = this.dim.getFunctionSource(debuggableScript);
            if (functionSource == null) {
                return null;
            }
            return new StackFrame(context, this.dim, functionSource);
        }

        @Override // org.mozilla.javascript.debug.Debugger
        public void handleCompilationDone(Context context, DebuggableScript debuggableScript, String str) {
            if (this.type != 0) {
                Kit.codeBug();
            }
            if (!debuggableScript.isTopLevel()) {
                return;
            }
            this.dim.registerTopScript(debuggableScript, str);
        }

        @Override // org.mozilla.javascript.ContextAction
        public Object run(Context context) {
            switch (this.type) {
                case 2:
                    context.compileString(this.text, this.url, 1, null);
                    break;
                case 3:
                    Scriptable scope = this.dim.scopeProvider != null ? this.dim.scopeProvider.getScope() : null;
                    if (scope == null) {
                        scope = new ImporterTopLevel(context);
                    }
                    context.evaluateString(scope, this.text, this.url, 1, null);
                    break;
                case 4:
                    this.booleanResult = context.stringIsCompilableUnit(this.text);
                    break;
                case 5:
                    Object obj = this.object;
                    this.stringResult = obj == Undefined.instance ? "undefined" : obj == null ? "null" : obj instanceof NativeCall ? "[object Call]" : Context.toString(obj);
                    break;
                case 6:
                    this.objectResult = this.dim.getObjectPropertyImpl(context, this.object, this.f4735id);
                    break;
                case 7:
                    this.objectArrayResult = this.dim.getObjectIdsImpl(context, this.object);
                    break;
                default:
                    throw Kit.codeBug();
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class FunctionSource {
        public int firstLine;
        public String name;
        public SourceInfo sourceInfo;

        public FunctionSource(SourceInfo sourceInfo, int i, String str) {
            if (str != null) {
                this.sourceInfo = sourceInfo;
                this.firstLine = i;
                this.name = str;
                return;
            }
            throw new IllegalArgumentException();
        }

        public int firstLine() {
            return this.firstLine;
        }

        public String name() {
            return this.name;
        }

        public SourceInfo sourceInfo() {
            return this.sourceInfo;
        }
    }

    /* loaded from: classes5.dex */
    public static class SourceInfo {
        public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
        public boolean[] breakableLines;
        public boolean[] breakpoints;
        public FunctionSource[] functionSources;
        public String source;
        public String url;

        public SourceInfo(String str, DebuggableScript[] debuggableScriptArr, String str2) {
            this.source = str;
            this.url = str2;
            int length = debuggableScriptArr.length;
            int[][] iArr = new int[length];
            for (int i = 0; i != length; i++) {
                iArr[i] = debuggableScriptArr[i].getLineNumbers();
            }
            int[] iArr2 = new int[length];
            int i2 = 0;
            int i3 = 0;
            int i4 = -1;
            while (true) {
                if (i2 == length) {
                    break;
                }
                int[] iArr3 = iArr[i2];
                if (iArr3 == null || iArr3.length == 0) {
                    iArr2[i2] = -1;
                } else {
                    int i5 = iArr3[0];
                    int i6 = i5;
                    for (int i7 = 1; i7 != iArr3.length; i7++) {
                        int i8 = iArr3[i7];
                        if (i8 < i5) {
                            i5 = i8;
                        } else if (i8 > i6) {
                            i6 = i8;
                        }
                    }
                    iArr2[i2] = i5;
                    if (i3 > i4) {
                        i3 = i5;
                    } else {
                        i3 = i5 < i3 ? i5 : i3;
                        if (i6 <= i4) {
                        }
                    }
                    i4 = i6;
                }
                i2++;
            }
            if (i3 > i4) {
                boolean[] zArr = EMPTY_BOOLEAN_ARRAY;
                this.breakableLines = zArr;
                this.breakpoints = zArr;
            } else if (i3 < 0) {
                throw new IllegalStateException(String.valueOf(i3));
            } else {
                int i9 = i4 + 1;
                this.breakableLines = new boolean[i9];
                this.breakpoints = new boolean[i9];
                for (int i10 = 0; i10 != length; i10++) {
                    int[] iArr4 = iArr[i10];
                    if (iArr4 != null && iArr4.length != 0) {
                        for (int i11 = 0; i11 != iArr4.length; i11++) {
                            this.breakableLines[iArr4[i11]] = true;
                        }
                    }
                }
            }
            this.functionSources = new FunctionSource[length];
            for (int i12 = 0; i12 != length; i12++) {
                String functionName = debuggableScriptArr[i12].getFunctionName();
                if (functionName == null) {
                    functionName = "";
                }
                this.functionSources[i12] = new FunctionSource(this, iArr2[i12], functionName);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void copyBreakpointsFrom(SourceInfo sourceInfo) {
            int length = sourceInfo.breakpoints.length;
            boolean[] zArr = this.breakpoints;
            if (length > zArr.length) {
                length = zArr.length;
            }
            for (int i = 0; i != length; i++) {
                if (sourceInfo.breakpoints[i]) {
                    this.breakpoints[i] = true;
                }
            }
        }

        public boolean breakableLine(int i) {
            boolean[] zArr = this.breakableLines;
            return i < zArr.length && zArr[i];
        }

        public boolean breakpoint(int i) {
            if (breakableLine(i)) {
                boolean[] zArr = this.breakpoints;
                return i < zArr.length && zArr[i];
            }
            throw new IllegalArgumentException(String.valueOf(i));
        }

        public boolean breakpoint(int i, boolean z) {
            boolean z2;
            if (breakableLine(i)) {
                synchronized (this.breakpoints) {
                    if (this.breakpoints[i] != z) {
                        this.breakpoints[i] = z;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                return z2;
            }
            throw new IllegalArgumentException(String.valueOf(i));
        }

        public FunctionSource functionSource(int i) {
            return this.functionSources[i];
        }

        public int functionSourcesTop() {
            return this.functionSources.length;
        }

        public void removeAllBreakpoints() {
            synchronized (this.breakpoints) {
                for (int i = 0; i != this.breakpoints.length; i++) {
                    this.breakpoints[i] = false;
                }
            }
        }

        public String source() {
            return this.source;
        }

        public String url() {
            return this.url;
        }
    }

    /* loaded from: classes5.dex */
    public static class StackFrame implements DebugFrame {
        public boolean[] breakpoints;
        public ContextData contextData;
        public Dim dim;
        public FunctionSource fsource;
        public int lineNumber;
        public Scriptable scope;
        public Scriptable thisObj;

        public StackFrame(Context context, Dim dim, FunctionSource functionSource) {
            this.dim = dim;
            this.contextData = ContextData.get(context);
            this.fsource = functionSource;
            this.breakpoints = functionSource.sourceInfo().breakpoints;
            this.lineNumber = functionSource.firstLine();
        }

        public ContextData contextData() {
            return this.contextData;
        }

        public String getFunctionName() {
            return this.fsource.name();
        }

        public int getLineNumber() {
            return this.lineNumber;
        }

        public String getUrl() {
            return this.fsource.sourceInfo().url();
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onDebuggerStatement(Context context) {
            this.dim.handleBreakpointHit(this, context);
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onEnter(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            this.contextData.pushFrame(this);
            this.scope = scriptable;
            this.thisObj = scriptable2;
            if (this.dim.breakOnEnter) {
                this.dim.handleBreakpointHit(this, context);
            }
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onExceptionThrown(Context context, Throwable th) {
            this.dim.handleExceptionThrown(context, th, this);
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onExit(Context context, boolean z, Object obj) {
            if (this.dim.breakOnReturn && !z) {
                this.dim.handleBreakpointHit(this, context);
            }
            this.contextData.popFrame();
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onLineChange(Context context, int i) {
            this.lineNumber = i;
            if (!this.breakpoints[i] && !this.dim.breakFlag) {
                boolean z = this.contextData.breakNextLine;
                if (z && this.contextData.stopAtFrameDepth >= 0) {
                    z = this.contextData.frameCount() <= this.contextData.stopAtFrameDepth;
                }
                if (!z) {
                    return;
                }
                this.contextData.stopAtFrameDepth = -1;
                this.contextData.breakNextLine = false;
            }
            this.dim.handleBreakpointHit(this, context);
        }

        public Object scope() {
            return this.scope;
        }

        public SourceInfo sourceInfo() {
            return this.fsource.sourceInfo();
        }

        public Object thisObj() {
            return this.thisObj;
        }
    }

    public static void collectFunctions_r(DebuggableScript debuggableScript, ObjArray objArray) {
        objArray.add(debuggableScript);
        for (int i = 0; i != debuggableScript.getFunctionCount(); i++) {
            collectFunctions_r(debuggableScript.getFunction(i), objArray);
        }
    }

    public static String do_eval(Context context, StackFrame stackFrame, String str) {
        String str2 = "";
        Debugger debugger = context.getDebugger();
        Object debuggerContextData = context.getDebuggerContextData();
        int optimizationLevel = context.getOptimizationLevel();
        context.setDebugger(null, null);
        context.setOptimizationLevel(-1);
        context.setGeneratingDebug(false);
        try {
            try {
                Object call = ((Callable) context.compileString(str, str2, 0, null)).call(context, stackFrame.scope, stackFrame.thisObj, ScriptRuntime.emptyArgs);
                if (call != Undefined.instance) {
                    str2 = ScriptRuntime.toString(call);
                }
            } catch (Exception e) {
                str2 = e.getMessage();
            }
            return str2 == null ? "null" : str2;
        } finally {
            context.setGeneratingDebug(true);
            context.setOptimizationLevel(optimizationLevel);
            context.setDebugger(debugger, debuggerContextData);
        }
    }

    private FunctionSource functionSource(DebuggableScript debuggableScript) {
        return this.functionToSource.get(debuggableScript);
    }

    public static DebuggableScript[] getAllFunctions(DebuggableScript debuggableScript) {
        ObjArray objArray = new ObjArray();
        collectFunctions_r(debuggableScript, objArray);
        DebuggableScript[] debuggableScriptArr = new DebuggableScript[objArray.size()];
        objArray.toArray(debuggableScriptArr);
        return debuggableScriptArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FunctionSource getFunctionSource(DebuggableScript debuggableScript) {
        String loadSource;
        FunctionSource functionSource = functionSource(debuggableScript);
        if (functionSource == null) {
            String normalizedUrl = getNormalizedUrl(debuggableScript);
            if (sourceInfo(normalizedUrl) != null || debuggableScript.isGeneratedScript() || (loadSource = loadSource(normalizedUrl)) == null) {
                return functionSource;
            }
            DebuggableScript debuggableScript2 = debuggableScript;
            while (true) {
                DebuggableScript parent = debuggableScript2.getParent();
                if (parent == null) {
                    registerTopScript(debuggableScript2, loadSource);
                    return functionSource(debuggableScript);
                }
                debuggableScript2 = parent;
            }
        } else {
            return functionSource;
        }
    }

    private String getNormalizedUrl(DebuggableScript debuggableScript) {
        String sourceName = debuggableScript.getSourceName();
        if (sourceName == null) {
            return "<stdin>";
        }
        int length = sourceName.length();
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            int indexOf = sourceName.indexOf(35, i);
            if (indexOf < 0) {
                break;
            }
            int i2 = indexOf + 1;
            int i3 = i2;
            while (i3 != length) {
                char charAt = sourceName.charAt(i3);
                if ('0' > charAt || charAt > '9') {
                    break;
                }
                i3++;
            }
            String str = "(eval)";
            if (i3 == i2 || !str.regionMatches(0, sourceName, i3, 6)) {
                str = null;
            } else {
                i = i3 + 6;
            }
            if (str == null) {
                break;
            }
            if (sb == null) {
                sb = new StringBuilder();
                sb.append(sourceName.substring(0, indexOf));
            }
            sb.append(str);
        }
        if (sb == null) {
            return sourceName;
        }
        if (i != length) {
            sb.append(sourceName.substring(i));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] getObjectIdsImpl(Context context, Object obj) {
        if (!(obj instanceof Scriptable) || obj == Undefined.instance) {
            return Context.emptyArgs;
        }
        Scriptable scriptable = (Scriptable) obj;
        Object[] allIds = scriptable instanceof DebuggableObject ? ((DebuggableObject) scriptable).getAllIds() : scriptable.getIds();
        Scriptable prototype = scriptable.getPrototype();
        Scriptable parentScope = scriptable.getParentScope();
        char c = 1;
        int i = prototype != null ? 1 : 0;
        if (parentScope != null) {
            i++;
        }
        if (i == 0) {
            return allIds;
        }
        Object[] objArr = new Object[allIds.length + i];
        System.arraycopy(allIds, 0, objArr, i, allIds.length);
        if (prototype != null) {
            objArr[0] = "__proto__";
        } else {
            c = 0;
        }
        if (parentScope != null) {
            objArr[c] = "__parent__";
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getObjectPropertyImpl(Context context, Object obj, Object obj2) {
        Scriptable scriptable = (Scriptable) obj;
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (str.equals("this")) {
                return scriptable;
            }
            if (str.equals("__proto__")) {
                return scriptable.getPrototype();
            }
            if (str.equals("__parent__")) {
                return scriptable.getParentScope();
            }
            Object property = ScriptableObject.getProperty(scriptable, str);
            if (property != Scriptable.NOT_FOUND) {
                return property;
            }
        } else {
            Object property2 = ScriptableObject.getProperty(scriptable, ((Integer) obj2).intValue());
            if (property2 != Scriptable.NOT_FOUND) {
                return property2;
            }
        }
        return Undefined.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBreakpointHit(StackFrame stackFrame, Context context) {
        this.breakFlag = false;
        interrupted(context, stackFrame, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExceptionThrown(Context context, Throwable th, StackFrame stackFrame) {
        if (this.breakOnExceptions) {
            ContextData contextData = stackFrame.contextData();
            if (contextData.lastProcessedException == th) {
                return;
            }
            interrupted(context, stackFrame, th);
            contextData.lastProcessedException = th;
        }
    }

    private void interrupted(Context context, StackFrame stackFrame, Throwable th) {
        boolean z;
        int i;
        ContextData contextData = stackFrame.contextData();
        boolean isGuiEventThread = this.callback.isGuiEventThread();
        contextData.eventThreadFlag = isGuiEventThread;
        synchronized (this.eventThreadMonitor) {
            if (!isGuiEventThread) {
                while (this.interruptedContextData != null) {
                    try {
                        this.eventThreadMonitor.wait();
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
            } else if (this.interruptedContextData != null) {
                z = true;
            }
            this.interruptedContextData = contextData;
            z = false;
        }
        if (z) {
            return;
        }
        if (this.interruptedContextData == null) {
            Kit.codeBug();
        }
        try {
            this.frameIndex = contextData.frameCount() - 1;
            String thread = Thread.currentThread().toString();
            String th2 = th == null ? null : th.toString();
            if (!isGuiEventThread) {
                synchronized (this.monitor) {
                    if (this.insideInterruptLoop) {
                        Kit.codeBug();
                    }
                    this.insideInterruptLoop = true;
                    this.evalRequest = null;
                    this.returnValue = -1;
                    this.callback.enterInterrupt(stackFrame, thread, th2);
                    while (true) {
                        try {
                            this.monitor.wait();
                            if (this.evalRequest != null) {
                                this.evalResult = null;
                                this.evalResult = do_eval(context, this.evalFrame, this.evalRequest);
                                this.evalRequest = null;
                                this.evalFrame = null;
                                this.monitor.notify();
                            } else if (this.returnValue != -1) {
                                break;
                            }
                        } catch (InterruptedException unused2) {
                            Thread.currentThread().interrupt();
                            i = -1;
                        }
                    }
                    i = this.returnValue;
                    this.insideInterruptLoop = false;
                }
            } else {
                this.returnValue = -1;
                this.callback.enterInterrupt(stackFrame, thread, th2);
                while (this.returnValue == -1) {
                    try {
                        this.callback.dispatchNextGuiEvent();
                    } catch (InterruptedException unused3) {
                    }
                }
                i = this.returnValue;
            }
            if (i == 0) {
                contextData.breakNextLine = true;
                contextData.stopAtFrameDepth = contextData.frameCount();
            } else if (i == 1) {
                contextData.breakNextLine = true;
                contextData.stopAtFrameDepth = -1;
            } else if (i == 2 && contextData.frameCount() > 1) {
                contextData.breakNextLine = true;
                contextData.stopAtFrameDepth = contextData.frameCount() - 1;
            }
            synchronized (this.eventThreadMonitor) {
                this.interruptedContextData = null;
                this.eventThreadMonitor.notifyAll();
            }
        } catch (Throwable th3) {
            synchronized (this.eventThreadMonitor) {
                this.interruptedContextData = null;
                this.eventThreadMonitor.notifyAll();
                throw th3;
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0068 -> B:8:0x0091). Please submit an issue!!! */
    private String loadSource(String str) {
        InputStream fileInputStream;
        String systemProperty;
        StringBuilder sb;
        int indexOf = str.indexOf(35);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        String str2 = null;
        try {
        } catch (IOException e) {
            PrintStream printStream = System.err;
            printStream.println("Failed to load source from " + str + ": " + e);
        }
        if (str.indexOf(58) < 0) {
            if (str.startsWith("~/") && (systemProperty = SecurityUtilities.getSystemProperty(SystemUtils.USER_HOME_KEY)) != null) {
                File file = new File(new File(systemProperty), str.substring(2));
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    str2 = Kit.readReader(new InputStreamReader(fileInputStream));
                    fileInputStream.close();
                    return str2;
                }
            }
            File file2 = new File(str);
            if (file2.exists()) {
                fileInputStream = new FileInputStream(file2);
                str2 = Kit.readReader(new InputStreamReader(fileInputStream));
                fileInputStream.close();
                return str2;
            }
            if (str.startsWith("//")) {
                sb = new StringBuilder();
                sb.append(URIUtil.HTTP_COLON);
                sb.append(str);
            } else if (str.startsWith("/")) {
                sb = new StringBuilder();
                sb.append("http://127.0.0.1");
                sb.append(str);
            } else {
                sb = new StringBuilder();
                sb.append(DefaultWebClient.HTTP_SCHEME);
                sb.append(str);
            }
            str = sb.toString();
        }
        fileInputStream = new URL(str).openStream();
        str2 = Kit.readReader(new InputStreamReader(fileInputStream));
        fileInputStream.close();
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerTopScript(DebuggableScript debuggableScript, String str) {
        int i;
        String source;
        if (debuggableScript.isTopLevel()) {
            String normalizedUrl = getNormalizedUrl(debuggableScript);
            DebuggableScript[] allFunctions = getAllFunctions(debuggableScript);
            SourceProvider sourceProvider = this.sourceProvider;
            if (sourceProvider != null && (source = sourceProvider.getSource(debuggableScript)) != null) {
                str = source;
            }
            SourceInfo sourceInfo = new SourceInfo(str, allFunctions, normalizedUrl);
            synchronized (this.urlToSourceInfo) {
                SourceInfo sourceInfo2 = this.urlToSourceInfo.get(normalizedUrl);
                if (sourceInfo2 != null) {
                    sourceInfo.copyBreakpointsFrom(sourceInfo2);
                }
                this.urlToSourceInfo.put(normalizedUrl, sourceInfo);
                for (int i2 = 0; i2 != sourceInfo.functionSourcesTop(); i2++) {
                    FunctionSource functionSource = sourceInfo.functionSource(i2);
                    String name = functionSource.name();
                    if (name.length() != 0) {
                        this.functionNames.put(name, functionSource);
                    }
                }
            }
            synchronized (this.functionToSource) {
                for (i = 0; i != allFunctions.length; i++) {
                    this.functionToSource.put(allFunctions[i], sourceInfo.functionSource(i));
                }
            }
            this.callback.updateSourceText(sourceInfo);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void attachTo(ContextFactory contextFactory) {
        detach();
        this.contextFactory = contextFactory;
        DimIProxy dimIProxy = new DimIProxy(1);
        this.listener = dimIProxy;
        contextFactory.addListener(dimIProxy);
    }

    public void clearAllBreakpoints() {
        for (SourceInfo sourceInfo : this.urlToSourceInfo.values()) {
            sourceInfo.removeAllBreakpoints();
        }
    }

    public void compileScript(String str, String str2) {
        DimIProxy dimIProxy = new DimIProxy(2);
        dimIProxy.url = str;
        dimIProxy.text = str2;
        dimIProxy.withContext();
    }

    public void contextSwitch(int i) {
        this.frameIndex = i;
    }

    public ContextData currentContextData() {
        return this.interruptedContextData;
    }

    public void detach() {
        DimIProxy dimIProxy = this.listener;
        if (dimIProxy != null) {
            this.contextFactory.removeListener(dimIProxy);
            this.contextFactory = null;
            this.listener = null;
        }
    }

    public void dispose() {
        detach();
    }

    public String eval(String str) {
        ContextData currentContextData;
        String str2 = "undefined";
        if (str == null || (currentContextData = currentContextData()) == null || this.frameIndex >= currentContextData.frameCount()) {
            return str2;
        }
        StackFrame frame = currentContextData.getFrame(this.frameIndex);
        if (currentContextData.eventThreadFlag) {
            return do_eval(Context.getCurrentContext(), frame, str);
        }
        synchronized (this.monitor) {
            if (this.insideInterruptLoop) {
                this.evalRequest = str;
                this.evalFrame = frame;
                this.monitor.notify();
                do {
                    try {
                        this.monitor.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                } while (this.evalRequest != null);
                str2 = this.evalResult;
            }
        }
        return str2;
    }

    public void evalScript(String str, String str2) {
        DimIProxy dimIProxy = new DimIProxy(3);
        dimIProxy.url = str;
        dimIProxy.text = str2;
        dimIProxy.withContext();
    }

    public String[] functionNames() {
        String[] strArr;
        synchronized (this.urlToSourceInfo) {
            strArr = (String[]) this.functionNames.keySet().toArray(new String[this.functionNames.size()]);
        }
        return strArr;
    }

    public FunctionSource functionSourceByName(String str) {
        return this.functionNames.get(str);
    }

    public Object[] getObjectIds(Object obj) {
        DimIProxy dimIProxy = new DimIProxy(7);
        dimIProxy.object = obj;
        dimIProxy.withContext();
        return dimIProxy.objectArrayResult;
    }

    public Object getObjectProperty(Object obj, Object obj2) {
        DimIProxy dimIProxy = new DimIProxy(6);
        dimIProxy.object = obj;
        dimIProxy.f4735id = obj2;
        dimIProxy.withContext();
        return dimIProxy.objectResult;
    }

    /* renamed from: go */
    public void m24go() {
        synchronized (this.monitor) {
            this.returnValue = 3;
            this.monitor.notifyAll();
        }
    }

    public String objectToString(Object obj) {
        DimIProxy dimIProxy = new DimIProxy(5);
        dimIProxy.object = obj;
        dimIProxy.withContext();
        return dimIProxy.stringResult;
    }

    public void setBreak() {
        this.breakFlag = true;
    }

    public void setBreakOnEnter(boolean z) {
        this.breakOnEnter = z;
    }

    public void setBreakOnExceptions(boolean z) {
        this.breakOnExceptions = z;
    }

    public void setBreakOnReturn(boolean z) {
        this.breakOnReturn = z;
    }

    public void setGuiCallback(GuiCallback guiCallback) {
        this.callback = guiCallback;
    }

    public void setReturnValue(int i) {
        synchronized (this.monitor) {
            this.returnValue = i;
            this.monitor.notify();
        }
    }

    public void setScopeProvider(ScopeProvider scopeProvider) {
        this.scopeProvider = scopeProvider;
    }

    public void setSourceProvider(SourceProvider sourceProvider) {
        this.sourceProvider = sourceProvider;
    }

    public SourceInfo sourceInfo(String str) {
        return this.urlToSourceInfo.get(str);
    }

    public boolean stringIsCompilableUnit(String str) {
        DimIProxy dimIProxy = new DimIProxy(4);
        dimIProxy.text = str;
        dimIProxy.withContext();
        return dimIProxy.booleanResult;
    }
}

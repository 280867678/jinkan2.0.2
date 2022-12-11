package org.mozilla.javascript.tools.shell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;
import org.apache.commons.lang3.SystemUtils;
import org.litepal.crud.LitePalSupport;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.GeneratedClassLoader;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.SecurityController;
import org.mozilla.javascript.commonjs.module.ModuleScope;
import org.mozilla.javascript.commonjs.module.Require;
import org.mozilla.javascript.tools.SourceReader;
import org.mozilla.javascript.tools.ToolErrorReporter;

/* loaded from: classes5.dex */
public class Main {
    public static final int EXITCODE_FILE_NOT_FOUND = 4;
    public static final int EXITCODE_RUNTIME_ERROR = 3;
    public static ToolErrorReporter errorReporter;
    public static String mainModule;
    public static List<String> modulePath;
    public static Require require;
    public static SecurityProxy securityImpl;
    public static ShellContextFactory shellContextFactory = new ShellContextFactory();
    public static Global global = new Global();
    public static int exitCode = 0;
    public static boolean processStdin = true;
    public static List<String> fileList = new ArrayList();
    public static boolean sandboxed = false;
    public static boolean useRequire = false;
    public static final ScriptCache scriptCache = new ScriptCache(32);

    /* loaded from: classes5.dex */
    public static class IProxy implements ContextAction<Object>, QuitAction {
        public static final int EVAL_INLINE_SCRIPT = 2;
        public static final int PROCESS_FILES = 1;
        public static final int SYSTEM_EXIT = 3;
        public String[] args;
        public String scriptText;
        public int type;

        public IProxy(int i) {
            this.type = i;
        }

        @Override // org.mozilla.javascript.tools.shell.QuitAction
        public void quit(Context context, int i) {
            if (this.type == 3) {
                System.exit(i);
                return;
            }
            throw Kit.codeBug();
        }

        @Override // org.mozilla.javascript.ContextAction
        public Object run(Context context) {
            if (Main.useRequire) {
                Main.require = Main.global.installRequire(context, Main.modulePath, Main.sandboxed);
            }
            int i = this.type;
            if (i == 1) {
                Main.processFiles(context, this.args);
                return null;
            } else if (i != 2) {
                throw Kit.codeBug();
            } else {
                Main.evalInlineScript(context, this.scriptText);
                return null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ScriptCache extends LinkedHashMap<String, ScriptReference> {
        public int capacity;
        public ReferenceQueue<Script> queue = new ReferenceQueue<>();

        public ScriptCache(int i) {
            super(i + 1, 2.0f, true);
            this.capacity = i;
        }

        public ScriptReference get(String str, byte[] bArr) {
            while (true) {
                ScriptReference scriptReference = (ScriptReference) this.queue.poll();
                if (scriptReference == null) {
                    break;
                }
                remove(scriptReference.path);
            }
            ScriptReference scriptReference2 = get(str);
            if (scriptReference2 == null || Arrays.equals(bArr, scriptReference2.digest)) {
                return scriptReference2;
            }
            remove(scriptReference2.path);
            return null;
        }

        public void put(String str, byte[] bArr, Script script) {
            put(str, new ScriptReference(str, bArr, script, this.queue));
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, ScriptReference> entry) {
            return size() > this.capacity;
        }
    }

    /* loaded from: classes5.dex */
    public static class ScriptReference extends SoftReference<Script> {
        public byte[] digest;
        public String path;

        public ScriptReference(String str, byte[] bArr, Script script, ReferenceQueue<Script> referenceQueue) {
            super(script, referenceQueue);
            this.path = str;
            this.digest = bArr;
        }
    }

    static {
        global.initQuitAction(new IProxy(3));
    }

    public static void evalInlineScript(Context context, String str) {
        try {
            Script compileString = context.compileString(str, "<command>", 1, null);
            if (compileString == null) {
                return;
            }
            compileString.exec(context, getShellScope());
        } catch (VirtualMachineError e) {
            e.printStackTrace();
            Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e.toString()));
            exitCode = 3;
        } catch (RhinoException e2) {
            ToolErrorReporter.reportException(context.getErrorReporter(), e2);
            exitCode = 3;
        }
    }

    public static int exec(String[] strArr) {
        ToolErrorReporter toolErrorReporter = new ToolErrorReporter(false, global.getErr());
        errorReporter = toolErrorReporter;
        shellContextFactory.setErrorReporter(toolErrorReporter);
        String[] processOptions = processOptions(strArr);
        int i = exitCode;
        if (i > 0) {
            return i;
        }
        if (processStdin) {
            fileList.add(null);
        }
        Global global2 = global;
        if (!global2.initialized) {
            global2.init(shellContextFactory);
        }
        IProxy iProxy = new IProxy(1);
        iProxy.args = processOptions;
        shellContextFactory.call(iProxy);
        return exitCode;
    }

    public static byte[] getDigest(Object obj) {
        byte[] bytes;
        if (obj != null) {
            if (obj instanceof String) {
                try {
                    bytes = ((String) obj).getBytes("UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    bytes = ((String) obj).getBytes();
                }
            } else {
                bytes = (byte[]) obj;
            }
            try {
                return MessageDigest.getInstance(LitePalSupport.MD5).digest(bytes);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static PrintStream getErr() {
        return getGlobal().getErr();
    }

    public static Global getGlobal() {
        return global;
    }

    public static InputStream getIn() {
        return getGlobal().getIn();
    }

    public static PrintStream getOut() {
        return getGlobal().getOut();
    }

    public static Scriptable getScope(String str) {
        File file;
        URI uri;
        if (useRequire) {
            if (str == null) {
                uri = new File(System.getProperty(SystemUtils.USER_DIR_KEY)).toURI();
            } else {
                if (SourceReader.toUrl(str) != null) {
                    try {
                        uri = new URI(str);
                    } catch (URISyntaxException unused) {
                        file = new File(str);
                    }
                } else {
                    file = new File(str);
                }
                uri = file.toURI();
            }
            return new ModuleScope(global, uri, null);
        }
        return global;
    }

    public static Scriptable getShellScope() {
        return getScope(null);
    }

    public static void initJavaPolicySecuritySupport() {
        try {
            SecurityProxy securityProxy = (SecurityProxy) Class.forName("org.mozilla.javascript.tools.shell.JavaPolicySecurity").newInstance();
            securityImpl = securityProxy;
            SecurityController.initGlobal(securityProxy);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | LinkageError e) {
            throw new IllegalStateException("Can not load security support: " + e, e);
        }
    }

    public static Script loadCompiledScript(Context context, String str, byte[] bArr, Object obj) throws FileNotFoundException {
        if (bArr != null) {
            int lastIndexOf = str.lastIndexOf(47);
            int i = lastIndexOf < 0 ? 0 : lastIndexOf + 1;
            int lastIndexOf2 = str.lastIndexOf(46);
            if (lastIndexOf2 < i) {
                lastIndexOf2 = str.length();
            }
            String substring = str.substring(i, lastIndexOf2);
            try {
                GeneratedClassLoader createLoader = SecurityController.createLoader(context.getApplicationClassLoader(), obj);
                Class<?> defineClass = createLoader.defineClass(substring, bArr);
                createLoader.linkClass(defineClass);
                if (!Script.class.isAssignableFrom(defineClass)) {
                    throw Context.reportRuntimeError("msg.must.implement.Script");
                }
                return (Script) defineClass.newInstance();
            } catch (IllegalAccessException e) {
                Context.reportError(e.toString());
                throw new RuntimeException(e);
            } catch (InstantiationException e2) {
                Context.reportError(e2.toString());
                throw new RuntimeException(e2);
            }
        }
        throw new FileNotFoundException(str);
    }

    public static void main(String[] strArr) {
        try {
            if (Boolean.getBoolean("rhino.use_java_policy_security")) {
                initJavaPolicySecuritySupport();
            }
        } catch (SecurityException e) {
            e.printStackTrace(System.err);
        }
        int exec = exec(strArr);
        if (exec != 0) {
            System.exit(exec);
        }
    }

    public static void processFile(Context context, Scriptable scriptable, String str) throws IOException {
        SecurityProxy securityProxy = securityImpl;
        if (securityProxy == null) {
            processFileSecure(context, scriptable, str, null);
        } else {
            securityProxy.callProcessFileSecure(context, scriptable, str);
        }
    }

    public static void processFileNoThrow(Context context, Scriptable scriptable, String str) {
        try {
            processFile(context, scriptable, str);
        } catch (IOException e) {
            Context.reportError(ToolErrorReporter.getMessage("msg.couldnt.read.source", str, e.getMessage()));
            exitCode = 4;
        } catch (VirtualMachineError e2) {
            e2.printStackTrace();
            Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e2.toString()));
            exitCode = 3;
        } catch (RhinoException e3) {
            ToolErrorReporter.reportException(context.getErrorReporter(), e3);
            exitCode = 3;
        }
    }

    public static void processFileSecure(Context context, Scriptable scriptable, String str, Object obj) throws IOException {
        Script compileString;
        boolean endsWith = str.endsWith(".class");
        Object readFileOrUrl = readFileOrUrl(str, !endsWith);
        byte[] digest = getDigest(readFileOrUrl);
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "_");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(context.getOptimizationLevel());
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        ScriptReference scriptReference = scriptCache.get(sb, digest);
        Script script = scriptReference != null ? scriptReference.get() : null;
        if (script == null) {
            if (endsWith) {
                compileString = loadCompiledScript(context, str, (byte[]) readFileOrUrl, obj);
            } else {
                String str2 = (String) readFileOrUrl;
                if (str2.length() > 0 && str2.charAt(0) == '#') {
                    for (int i = 1; i != str2.length(); i++) {
                        char charAt = str2.charAt(i);
                        if (charAt == '\n' || charAt == '\r') {
                            str2 = str2.substring(i);
                            break;
                        }
                    }
                }
                compileString = context.compileString(str2, str, 1, obj);
            }
            script = compileString;
            scriptCache.put(sb, digest, script);
        }
        if (script != null) {
            script.exec(context, scriptable);
        }
    }

    public static void processFiles(Context context, String[] strArr) {
        Object[] objArr = new Object[strArr.length];
        System.arraycopy(strArr, 0, objArr, 0, strArr.length);
        global.defineProperty("arguments", context.newArray(global, objArr), 2);
        for (String str : fileList) {
            try {
                processSource(context, str);
            } catch (IOException e) {
                Context.reportError(ToolErrorReporter.getMessage("msg.couldnt.read.source", str, e.getMessage()));
                exitCode = 4;
            } catch (VirtualMachineError e2) {
                e2.printStackTrace();
                Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e2.toString()));
                exitCode = 3;
            } catch (RhinoException e3) {
                ToolErrorReporter.reportException(context.getErrorReporter(), e3);
                exitCode = 3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x0171, code lost:
        if (r3.equals("-help") == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] processOptions(String[] strArr) {
        int i = 0;
        while (i != strArr.length) {
            String str = strArr[i];
            if (!str.startsWith("-")) {
                processStdin = false;
                fileList.add(str);
                mainModule = str;
                String[] strArr2 = new String[(strArr.length - i) - 1];
                System.arraycopy(strArr, i + 1, strArr2, 0, (strArr.length - i) - 1);
                return strArr2;
            }
            if (str.equals("-version")) {
                i++;
                if (i != strArr.length) {
                    try {
                        int parseInt = Integer.parseInt(strArr[i]);
                        if (!Context.isValidLanguageVersion(parseInt)) {
                            str = strArr[i];
                        } else {
                            shellContextFactory.setLanguageVersion(parseInt);
                        }
                    } catch (NumberFormatException unused) {
                        str = strArr[i];
                    }
                }
                global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                exitCode = 1;
                return null;
            } else if (str.equals("-opt") || str.equals("-O")) {
                i++;
                if (i != strArr.length) {
                    try {
                        int parseInt2 = Integer.parseInt(strArr[i]);
                        if (parseInt2 == -2) {
                            parseInt2 = -1;
                        } else if (!Context.isValidOptimizationLevel(parseInt2)) {
                            str = strArr[i];
                        }
                        shellContextFactory.setOptimizationLevel(parseInt2);
                    } catch (NumberFormatException unused2) {
                        str = strArr[i];
                    }
                }
                global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                exitCode = 1;
                return null;
            } else if (str.equals("-encoding")) {
                i++;
                if (i == strArr.length) {
                    global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                    global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                    exitCode = 1;
                    return null;
                }
                shellContextFactory.setCharacterEncoding(strArr[i]);
            } else {
                if (str.equals("-strict")) {
                    shellContextFactory.setStrictMode(true);
                    shellContextFactory.setAllowReservedKeywords(false);
                } else if (str.equals("-fatal-warnings")) {
                    shellContextFactory.setWarningAsError(true);
                } else if (str.equals("-e")) {
                    processStdin = false;
                    i++;
                    if (i == strArr.length) {
                        global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                        global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                        exitCode = 1;
                        return null;
                    }
                    Global global2 = global;
                    if (!global2.initialized) {
                        global2.init(shellContextFactory);
                    }
                    IProxy iProxy = new IProxy(2);
                    iProxy.scriptText = strArr[i];
                    shellContextFactory.call(iProxy);
                } else {
                    if (!str.equals("-require")) {
                        if (!str.equals("-sandbox")) {
                            if (str.equals("-modules")) {
                                i++;
                                if (i != strArr.length) {
                                    if (modulePath == null) {
                                        modulePath = new ArrayList();
                                    }
                                    modulePath.add(strArr[i]);
                                }
                            } else if (!str.equals("-w")) {
                                if (str.equals("-f")) {
                                    processStdin = false;
                                    i++;
                                    if (i != strArr.length) {
                                        if (strArr[i].equals("-")) {
                                            fileList.add(null);
                                        } else {
                                            fileList.add(strArr[i]);
                                            mainModule = strArr[i];
                                        }
                                    }
                                } else if (str.equals("-sealedlib")) {
                                    global.setSealedStdLib(true);
                                } else if (!str.equals("-debug")) {
                                    if (!str.equals("-?")) {
                                    }
                                    global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                                    exitCode = 1;
                                    return null;
                                } else {
                                    shellContextFactory.setGeneratingDebug(true);
                                }
                            }
                            global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                            global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                            exitCode = 1;
                            return null;
                        }
                        sandboxed = true;
                    }
                    useRequire = true;
                }
                errorReporter.setIsReportingWarnings(true);
            }
            i++;
        }
        return new String[0];
    }

    public static void processSource(Context context, String str) throws IOException {
        if (str != null && !str.equals("-")) {
            if (!useRequire || !str.equals(mainModule)) {
                processFile(context, getScope(str), str);
                return;
            } else {
                require.requireMain(context, str);
                return;
            }
        }
        Scriptable shellScope = getShellScope();
        String characterEncoding = shellContextFactory.getCharacterEncoding();
        ShellConsole console = global.getConsole(characterEncoding != null ? Charset.forName(characterEncoding) : Charset.defaultCharset());
        if (str == null) {
            console.println(context.getImplementationVersion());
        }
        boolean z = false;
        int i = 1;
        while (!z) {
            String[] prompts = global.getPrompts(context);
            String str2 = str == null ? prompts[0] : null;
            console.flush();
            String str3 = "";
            while (true) {
                try {
                    String readLine = console.readLine(str2);
                    if (readLine == null) {
                        z = true;
                        break;
                    }
                    str3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, readLine, "\n");
                    i++;
                    if (context.stringIsCompilableUnit(str3)) {
                        break;
                    }
                    str2 = prompts[1];
                } catch (IOException e) {
                    console.println(e.toString());
                }
            }
            try {
                try {
                    Script compileString = context.compileString(str3, "<stdin>", i, null);
                    if (compileString != null) {
                        Object exec = compileString.exec(context, shellScope);
                        if (exec != Context.getUndefinedValue() && (!(exec instanceof Function) || !str3.trim().startsWith("function"))) {
                            try {
                                console.println(Context.toString(exec));
                            } catch (RhinoException e2) {
                                ToolErrorReporter.reportException(context.getErrorReporter(), e2);
                            }
                        }
                        NativeArray nativeArray = global.history;
                        nativeArray.put((int) nativeArray.getLength(), nativeArray, str3);
                    }
                } catch (RhinoException e3) {
                    ToolErrorReporter.reportException(context.getErrorReporter(), e3);
                    exitCode = 3;
                }
            } catch (VirtualMachineError e4) {
                e4.printStackTrace();
                Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e4.toString()));
                exitCode = 3;
            }
        }
        console.println();
        console.flush();
    }

    public static Object readFileOrUrl(String str, boolean z) throws IOException {
        return SourceReader.readFileOrUrl(str, z, shellContextFactory.getCharacterEncoding());
    }

    public static void setErr(PrintStream printStream) {
        getGlobal().setErr(printStream);
    }

    public static void setIn(InputStream inputStream) {
        getGlobal().setIn(inputStream);
    }

    public static void setOut(PrintStream printStream) {
        getGlobal().setOut(printStream);
    }
}

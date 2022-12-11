package org.mozilla.javascript.tools.shell;

import androidx.core.app.NotificationCompat;
import com.just.agentweb.JsCallJava;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.B64Code;
import org.litepal.parser.LitePalParser;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Synchronizer;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.Wrapper;
import org.mozilla.javascript.commonjs.module.Require;
import org.mozilla.javascript.commonjs.module.RequireBuilder;
import org.mozilla.javascript.commonjs.module.provider.SoftCachingModuleScriptProvider;
import org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider;
import org.mozilla.javascript.serialize.ScriptableInputStream;
import org.mozilla.javascript.serialize.ScriptableOutputStream;
import org.mozilla.javascript.tools.ToolErrorReporter;
import org.mozilla.javascript.tools.shell.Global;

/* loaded from: classes5.dex */
public class Global extends ImporterTopLevel {
    public static final long serialVersionUID = 4029130780977538005L;
    public boolean attemptedJLineLoad;
    public ShellConsole console;
    public HashMap<String, String> doctestCanonicalizations;
    public PrintStream errStream;
    public NativeArray history;
    public InputStream inStream;
    public boolean initialized;
    public PrintStream outStream;
    public QuitAction quitAction;
    public boolean sealedStdLib = false;
    public String[] prompts = {"js> ", "  > "};

    public Global() {
    }

    public Global(Context context) {
        init(context);
    }

    public static void defineClass(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> cls = getClass(objArr);
        if (Scriptable.class.isAssignableFrom(cls)) {
            ScriptableObject.defineClass(scriptable, cls);
            return;
        }
        throw reportRuntimeError("msg.must.implement.Scriptable");
    }

    public static Object deserialize(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException, ClassNotFoundException {
        if (objArr.length >= 1) {
            FileInputStream fileInputStream = new FileInputStream(Context.toString(objArr[0]));
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
            ScriptableInputStream scriptableInputStream = new ScriptableInputStream(fileInputStream, topLevelScope);
            Object readObject = scriptableInputStream.readObject();
            scriptableInputStream.close();
            return Context.toObject(readObject, topLevelScope);
        }
        throw Context.reportRuntimeError("Expected a filename to read the serialization from");
    }

    public static Object doPrint(Object[] objArr, Function function, boolean z) {
        PrintStream out = getInstance(function).getOut();
        for (int i = 0; i < objArr.length; i++) {
            if (i > 0) {
                out.print(StringUtils.SPACE);
            }
            out.print(Context.toString(objArr[i]));
        }
        if (z) {
            out.println();
        }
        return Context.getUndefinedValue();
    }

    public static Object doctest(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length == 0) {
            return Boolean.FALSE;
        }
        String context2 = Context.toString(objArr[0]);
        Global global = getInstance(function);
        return new Integer(global.runDoctest(context, global, context2, null, 0));
    }

    private boolean doctestOutputMatches(String str, String str2) {
        String trim = str.trim();
        String replace = str2.trim().replace("\r\n", "\n");
        if (trim.equals(replace)) {
            return true;
        }
        for (Map.Entry<String, String> entry : this.doctestCanonicalizations.entrySet()) {
            trim = trim.replace(entry.getKey(), entry.getValue());
        }
        if (trim.equals(replace)) {
            return true;
        }
        Pattern compile = Pattern.compile("@[0-9a-fA-F]+");
        Matcher matcher = compile.matcher(trim);
        Matcher matcher2 = compile.matcher(replace);
        while (matcher.find() && matcher2.find() && matcher2.start() == matcher.start()) {
            int start = matcher.start();
            if (!trim.substring(0, start).equals(replace.substring(0, start))) {
                return false;
            }
            String group = matcher.group();
            String group2 = matcher2.group();
            String str3 = this.doctestCanonicalizations.get(group);
            if (str3 == null) {
                this.doctestCanonicalizations.put(group, group2);
                trim = trim.replace(group, group2);
            } else if (!group2.equals(str3)) {
                return false;
            }
            if (trim.equals(replace)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: gc */
    public static void m15gc(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        System.gc();
    }

    public static String getCharCodingFromType(String str) {
        int indexOf = str.indexOf(59);
        if (indexOf >= 0) {
            int length = str.length();
            do {
                indexOf++;
                if (indexOf == length) {
                    break;
                }
            } while (str.charAt(indexOf) <= ' ');
            if (!"charset".regionMatches(true, 0, str, indexOf, 7)) {
                return null;
            }
            int i = indexOf + 7;
            while (i != length && str.charAt(i) <= ' ') {
                i++;
            }
            if (i == length || str.charAt(i) != '=') {
                return null;
            }
            do {
                i++;
                if (i == length) {
                    break;
                }
            } while (str.charAt(i) <= ' ');
            if (i == length) {
                return null;
            }
            while (str.charAt(length - 1) <= ' ') {
                length--;
            }
            return str.substring(i, length);
        }
        return null;
    }

    public static Class<?> getClass(Object[] objArr) {
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof Wrapper) {
                Object unwrap = ((Wrapper) obj).unwrap();
                if (unwrap instanceof Class) {
                    return (Class) unwrap;
                }
            }
            String context = Context.toString(objArr[0]);
            try {
                return Class.forName(context);
            } catch (ClassNotFoundException unused) {
                throw reportRuntimeError("msg.class.not.found", context);
            }
        }
        throw reportRuntimeError("msg.expected.string.arg");
    }

    public static Global getInstance(Function function) {
        Scriptable parentScope = function.getParentScope();
        if (parentScope instanceof Global) {
            return (Global) parentScope;
        }
        throw reportRuntimeError("msg.bad.shell.function.scope", String.valueOf(parentScope));
    }

    public static void help(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        getInstance(function).getOut().println(ToolErrorReporter.getMessage("msg.help"));
    }

    public static void load(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        for (Object obj : objArr) {
            String context2 = Context.toString(obj);
            try {
                Main.processFile(context, scriptable, context2);
            } catch (IOException e) {
                throw Context.reportRuntimeError(ToolErrorReporter.getMessage("msg.couldnt.read.source", context2, e.getMessage()));
            } catch (VirtualMachineError e2) {
                e2.printStackTrace();
                throw Context.reportRuntimeError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e2.toString()));
            }
        }
    }

    public static void loadClass(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IllegalAccessException, InstantiationException {
        Class<?> cls = getClass(objArr);
        if (Script.class.isAssignableFrom(cls)) {
            ((Script) cls.newInstance()).exec(context, scriptable);
            return;
        }
        throw reportRuntimeError("msg.must.implement.Script");
    }

    private boolean loadJLine(Charset charset) {
        if (!this.attemptedJLineLoad) {
            this.attemptedJLineLoad = true;
            this.console = ShellConsole.getConsole(this, charset);
        }
        return this.console != null;
    }

    public static void pipe(boolean z, InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = !z ? inputStream.read(bArr, 0, 4096) : inputStream.read(bArr, 0, 4096);
                if (read >= 0) {
                    if (z) {
                        outputStream.write(bArr, 0, read);
                        outputStream.flush();
                    } else {
                        try {
                            outputStream.write(bArr, 0, read);
                            outputStream.flush();
                        } catch (IOException unused) {
                        }
                    }
                }
                try {
                    break;
                } catch (IOException unused2) {
                    return;
                }
            }
        } finally {
            try {
                if (z) {
                    inputStream.close();
                } else {
                    outputStream.close();
                }
            } catch (IOException unused3) {
            }
        }
    }

    public static Object print(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        return doPrint(objArr, function, true);
    }

    public static void quit(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Global global = getInstance(function);
        if (global.quitAction != null) {
            int i = 0;
            if (objArr.length != 0) {
                i = ScriptRuntime.toInt32(objArr[0]);
            }
            global.quitAction.quit(context, i);
        }
    }

    public static Object readFile(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        if (objArr.length != 0) {
            String scriptRuntime = ScriptRuntime.toString(objArr[0]);
            String str = null;
            if (objArr.length >= 2) {
                str = ScriptRuntime.toString(objArr[1]);
            }
            return readUrl(scriptRuntime, str, true);
        }
        throw reportRuntimeError("msg.shell.readFile.bad.args");
    }

    public static String readReader(Reader reader) throws IOException {
        return readReader(reader, 4096);
    }

    public static String readReader(Reader reader, int i) throws IOException {
        char[] cArr = new char[i];
        int i2 = 0;
        while (true) {
            int read = reader.read(cArr, i2, cArr.length - i2);
            if (read < 0) {
                return new String(cArr, 0, i2);
            }
            i2 += read;
            if (i2 == cArr.length) {
                char[] cArr2 = new char[cArr.length * 2];
                System.arraycopy(cArr, 0, cArr2, 0, i2);
                cArr = cArr2;
            }
        }
    }

    public static Object readUrl(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        if (objArr.length != 0) {
            String scriptRuntime = ScriptRuntime.toString(objArr[0]);
            String str = null;
            if (objArr.length >= 2) {
                str = ScriptRuntime.toString(objArr[1]);
            }
            return readUrl(scriptRuntime, str, false);
        }
        throw reportRuntimeError("msg.shell.readUrl.bad.args");
    }

    public static String readUrl(String str, String str2, boolean z) throws IOException {
        int i;
        InputStream inputStream;
        String contentType;
        InputStream inputStream2 = null;
        try {
            if (!z) {
                URLConnection openConnection = new URL(str).openConnection();
                inputStream = openConnection.getInputStream();
                i = openConnection.getContentLength();
                if (i <= 0) {
                    i = 1024;
                }
                if (str2 == null && (contentType = openConnection.getContentType()) != null) {
                    str2 = getCharCodingFromType(contentType);
                }
            } else {
                File file = new File(str);
                if (!file.exists()) {
                    throw new FileNotFoundException("File not found: " + str);
                } else if (!file.canRead()) {
                    throw new IOException("Cannot read file: " + str);
                } else {
                    long length = file.length();
                    int i2 = (int) length;
                    if (i2 != length) {
                        throw new IOException("Too big file size: " + length);
                    } else if (i2 == 0) {
                        return "";
                    } else {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        i = i2;
                        inputStream = fileInputStream;
                    }
                }
            }
            return readReader(str2 == null ? new InputStreamReader(inputStream2) : new InputStreamReader(inputStream2, str2), i);
        } finally {
            if (inputStream2 != null) {
                inputStream2.close();
            }
        }
    }

    public static Object readline(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        Global global = getInstance(function);
        int length = objArr.length;
        ShellConsole shellConsole = global.console;
        return length > 0 ? shellConsole.readLine(Context.toString(objArr[0])) : shellConsole.readLine();
    }

    public static RuntimeException reportRuntimeError(String str) {
        return Context.reportRuntimeError(ToolErrorReporter.getMessage(str));
    }

    public static RuntimeException reportRuntimeError(String str, String str2) {
        return Context.reportRuntimeError(ToolErrorReporter.getMessage(str, str2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00df  */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object runCommand(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        Object[] objArr2;
        Object obj;
        Object obj2;
        PrintStream printStream;
        String[] strArr;
        File file;
        InputStream inputStream;
        Scriptable scriptable2;
        PrintStream printStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String[] strArr2;
        PrintStream printStream3;
        ByteArrayOutputStream byteArrayOutputStream3;
        ByteArrayOutputStream byteArrayOutputStream4;
        Object property;
        PrintStream printStream4;
        ByteArrayOutputStream byteArrayOutputStream5;
        Object property2;
        Object property3;
        String str;
        int length = objArr.length;
        if (length == 0 || (length == 1 && (objArr[0] instanceof Scriptable))) {
            throw reportRuntimeError("msg.runCommand.bad.args");
        }
        int i = length - 1;
        if (objArr[i] instanceof Scriptable) {
            Scriptable scriptable3 = (Scriptable) objArr[i];
            length--;
            Object property4 = ScriptableObject.getProperty(scriptable3, "env");
            if (property4 == Scriptable.NOT_FOUND) {
                strArr2 = null;
            } else if (property4 == null) {
                strArr2 = new String[0];
            } else if (!(property4 instanceof Scriptable)) {
                throw reportRuntimeError("msg.runCommand.bad.env");
            } else {
                Scriptable scriptable4 = (Scriptable) property4;
                Object[] propertyIds = ScriptableObject.getPropertyIds(scriptable4);
                String[] strArr3 = new String[propertyIds.length];
                for (int i2 = 0; i2 != propertyIds.length; i2++) {
                    Object obj3 = propertyIds[i2];
                    if (obj3 instanceof String) {
                        str = (String) obj3;
                        property3 = ScriptableObject.getProperty(scriptable4, str);
                    } else {
                        int intValue = ((Number) obj3).intValue();
                        String num = Integer.toString(intValue);
                        property3 = ScriptableObject.getProperty(scriptable4, intValue);
                        str = num;
                    }
                    if (property3 == Scriptable.NOT_FOUND) {
                        property3 = Undefined.instance;
                    }
                    strArr3[i2] = str + B64Code.__pad + ScriptRuntime.toString(property3);
                }
                strArr2 = strArr3;
            }
            Object property5 = ScriptableObject.getProperty(scriptable3, "dir");
            File file2 = property5 != Scriptable.NOT_FOUND ? new File(ScriptRuntime.toString(property5)) : null;
            Object property6 = ScriptableObject.getProperty(scriptable3, "input");
            InputStream inputStream2 = property6 != Scriptable.NOT_FOUND ? toInputStream(property6) : null;
            Object property7 = ScriptableObject.getProperty(scriptable3, "output");
            if (property7 != Scriptable.NOT_FOUND) {
                ?? outputStream = toOutputStream(property7);
                printStream3 = outputStream;
                if (outputStream == 0) {
                    ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                    byteArrayOutputStream3 = byteArrayOutputStream6;
                    byteArrayOutputStream4 = byteArrayOutputStream6;
                    property = ScriptableObject.getProperty(scriptable3, NotificationCompat.CATEGORY_ERROR);
                    if (property == Scriptable.NOT_FOUND) {
                        ?? outputStream2 = toOutputStream(property);
                        printStream4 = outputStream2;
                        if (outputStream2 == 0) {
                            ByteArrayOutputStream byteArrayOutputStream7 = new ByteArrayOutputStream();
                            byteArrayOutputStream = byteArrayOutputStream7;
                            byteArrayOutputStream5 = byteArrayOutputStream7;
                            property2 = ScriptableObject.getProperty(scriptable3, JsCallJava.KEY_ARGS);
                            if (property2 != Scriptable.NOT_FOUND) {
                                objArr2 = context.getElements(Context.toObject(property2, ScriptableObject.getTopLevelScope(scriptable)));
                                printStream = byteArrayOutputStream4;
                                byteArrayOutputStream2 = byteArrayOutputStream3;
                            } else {
                                printStream = byteArrayOutputStream4;
                                byteArrayOutputStream2 = byteArrayOutputStream3;
                                objArr2 = null;
                            }
                            inputStream = inputStream2;
                            scriptable2 = scriptable3;
                            obj = property7;
                            file = file2;
                            strArr = strArr2;
                            obj2 = property;
                            printStream2 = byteArrayOutputStream5;
                        }
                    } else {
                        printStream4 = null;
                    }
                    byteArrayOutputStream = null;
                    byteArrayOutputStream5 = printStream4;
                    property2 = ScriptableObject.getProperty(scriptable3, JsCallJava.KEY_ARGS);
                    if (property2 != Scriptable.NOT_FOUND) {
                    }
                    inputStream = inputStream2;
                    scriptable2 = scriptable3;
                    obj = property7;
                    file = file2;
                    strArr = strArr2;
                    obj2 = property;
                    printStream2 = byteArrayOutputStream5;
                }
            } else {
                printStream3 = null;
            }
            byteArrayOutputStream3 = null;
            byteArrayOutputStream4 = printStream3;
            property = ScriptableObject.getProperty(scriptable3, NotificationCompat.CATEGORY_ERROR);
            if (property == Scriptable.NOT_FOUND) {
            }
            byteArrayOutputStream = null;
            byteArrayOutputStream5 = printStream4;
            property2 = ScriptableObject.getProperty(scriptable3, JsCallJava.KEY_ARGS);
            if (property2 != Scriptable.NOT_FOUND) {
            }
            inputStream = inputStream2;
            scriptable2 = scriptable3;
            obj = property7;
            file = file2;
            strArr = strArr2;
            obj2 = property;
            printStream2 = byteArrayOutputStream5;
        } else {
            objArr2 = null;
            obj = null;
            obj2 = null;
            printStream = null;
            strArr = null;
            file = null;
            inputStream = null;
            scriptable2 = null;
            printStream2 = null;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
        }
        Global global = getInstance(function);
        if (printStream == null) {
            printStream = global != null ? global.getOut() : System.out;
        }
        PrintStream printStream5 = printStream;
        if (printStream2 == null) {
            printStream2 = global != null ? global.getErr() : System.err;
        }
        String[] strArr4 = new String[objArr2 == null ? length : objArr2.length + length];
        for (int i3 = 0; i3 != length; i3++) {
            strArr4[i3] = ScriptRuntime.toString(objArr[i3]);
        }
        if (objArr2 != null) {
            for (int i4 = 0; i4 != objArr2.length; i4++) {
                strArr4[length + i4] = ScriptRuntime.toString(objArr2[i4]);
            }
        }
        Scriptable scriptable5 = scriptable2;
        int runProcess = runProcess(strArr4, strArr, file, inputStream, printStream5, printStream2);
        if (byteArrayOutputStream2 != null) {
            ScriptableObject.putProperty(scriptable5, "output", ScriptRuntime.toString(obj) + byteArrayOutputStream2.toString());
        }
        if (byteArrayOutputStream != null) {
            ScriptableObject.putProperty(scriptable5, NotificationCompat.CATEGORY_ERROR, ScriptRuntime.toString(obj2) + byteArrayOutputStream.toString());
        }
        return new Integer(runProcess);
    }

    public static int runProcess(String[] strArr, String[] strArr2, File file, InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) throws IOException {
        PipeThread pipeThread;
        PipeThread pipeThread2;
        PipeThread pipeThread3 = null;
        Process exec = strArr2 == null ? Runtime.getRuntime().exec(strArr, (String[]) null, file) : Runtime.getRuntime().exec(strArr, strArr2, file);
        try {
            if (inputStream != null) {
                pipeThread = new PipeThread(false, inputStream, exec.getOutputStream());
                pipeThread.start();
            } else {
                exec.getOutputStream().close();
                pipeThread = null;
            }
            if (outputStream != null) {
                pipeThread2 = new PipeThread(true, exec.getInputStream(), outputStream);
                pipeThread2.start();
            } else {
                exec.getInputStream().close();
                pipeThread2 = null;
            }
            if (outputStream2 != null) {
                pipeThread3 = new PipeThread(true, exec.getErrorStream(), outputStream2);
                pipeThread3.start();
            } else {
                exec.getErrorStream().close();
            }
            while (true) {
                try {
                    exec.waitFor();
                    if (pipeThread2 != null) {
                        pipeThread2.join();
                    }
                    if (pipeThread != null) {
                        pipeThread.join();
                    }
                    if (pipeThread3 == null) {
                        break;
                    }
                    pipeThread3.join();
                    break;
                } catch (InterruptedException unused) {
                }
            }
            return exec.exitValue();
        } finally {
            exec.destroy();
        }
    }

    public static void seal(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            if (!(obj instanceof ScriptableObject) || obj == Undefined.instance) {
                if ((obj instanceof Scriptable) && obj != Undefined.instance) {
                    throw reportRuntimeError("msg.shell.seal.not.scriptable");
                }
                throw reportRuntimeError("msg.shell.seal.not.object");
            }
        }
        for (int i2 = 0; i2 != objArr.length; i2++) {
            ((ScriptableObject) objArr[i2]).sealObject();
        }
    }

    public static void serialize(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        if (objArr.length >= 2) {
            Object obj = objArr[0];
            ScriptableOutputStream scriptableOutputStream = new ScriptableOutputStream(new FileOutputStream(Context.toString(objArr[1])), ScriptableObject.getTopLevelScope(scriptable));
            scriptableOutputStream.writeObject(obj);
            scriptableOutputStream.close();
            return;
        }
        throw Context.reportRuntimeError("Expected an object to serialize and a filename to write the serialization to");
    }

    public static Object spawn(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Runner runner;
        Scriptable parentScope = function.getParentScope();
        if (objArr.length != 0 && (objArr[0] instanceof Function)) {
            Object[] objArr2 = null;
            if (objArr.length > 1 && (objArr[1] instanceof Scriptable)) {
                objArr2 = context.getElements((Scriptable) objArr[1]);
            }
            if (objArr2 == null) {
                objArr2 = ScriptRuntime.emptyArgs;
            }
            runner = new Runner(parentScope, (Function) objArr[0], objArr2);
        } else if (objArr.length == 0 || !(objArr[0] instanceof Script)) {
            throw reportRuntimeError("msg.spawn.args");
        } else {
            runner = new Runner(parentScope, (Script) objArr[0]);
        }
        runner.factory = context.getFactory();
        Thread thread = new Thread(runner);
        thread.start();
        return thread;
    }

    public static Object sync(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length < 1 || objArr.length > 2 || !(objArr[0] instanceof Function)) {
            throw reportRuntimeError("msg.sync.args");
        }
        Object obj = null;
        if (objArr.length == 2 && objArr[1] != Undefined.instance) {
            obj = objArr[1];
        }
        return new Synchronizer((Function) objArr[0], obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InputStream toInputStream(Object obj) throws IOException {
        String str;
        ByteArrayInputStream byteArrayInputStream = null;
        if (obj instanceof Wrapper) {
            Object unwrap = ((Wrapper) obj).unwrap();
            if (unwrap instanceof InputStream) {
                byteArrayInputStream = (InputStream) unwrap;
                str = null;
            } else if (unwrap instanceof byte[]) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream((byte[]) unwrap);
                str = null;
                byteArrayInputStream = byteArrayInputStream2;
            } else if (unwrap instanceof Reader) {
                str = readReader((Reader) unwrap);
            } else if (unwrap instanceof char[]) {
                str = new String((char[]) unwrap);
            }
            if (byteArrayInputStream == null) {
                return byteArrayInputStream;
            }
            if (str == null) {
                str = ScriptRuntime.toString(obj);
            }
            return new ByteArrayInputStream(str.getBytes());
        }
        str = null;
        if (byteArrayInputStream == null) {
        }
    }

    public static OutputStream toOutputStream(Object obj) {
        if (obj instanceof Wrapper) {
            Object unwrap = ((Wrapper) obj).unwrap();
            if (unwrap instanceof OutputStream) {
                return (OutputStream) unwrap;
            }
        }
        return null;
    }

    public static Object toint32(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Object obj = objArr.length != 0 ? objArr[0] : Undefined.instance;
        return obj instanceof Integer ? obj : ScriptRuntime.wrapInt(ScriptRuntime.toInt32(obj));
    }

    public static double version(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length > 0) {
            context.setLanguageVersion((int) Context.toNumber(objArr[0]));
        }
        return context.getLanguageVersion();
    }

    public static Object write(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        return doPrint(objArr, function, false);
    }

    public /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        init(context);
        return null;
    }

    public ShellConsole getConsole(Charset charset) {
        if (!loadJLine(charset)) {
            this.console = ShellConsole.getConsole(getIn(), getErr(), charset);
        }
        return this.console;
    }

    public PrintStream getErr() {
        PrintStream printStream = this.errStream;
        return printStream == null ? System.err : printStream;
    }

    public InputStream getIn() {
        if (this.inStream == null && !this.attemptedJLineLoad && loadJLine(Charset.defaultCharset())) {
            this.inStream = this.console.getIn();
        }
        InputStream inputStream = this.inStream;
        return inputStream == null ? System.in : inputStream;
    }

    public PrintStream getOut() {
        PrintStream printStream = this.outStream;
        return printStream == null ? System.out : printStream;
    }

    public String[] getPrompts(Context context) {
        if (ScriptableObject.hasProperty(this, "prompts")) {
            Object property = ScriptableObject.getProperty(this, "prompts");
            if (property instanceof Scriptable) {
                Scriptable scriptable = (Scriptable) property;
                if (ScriptableObject.hasProperty(scriptable, 0) && ScriptableObject.hasProperty(scriptable, 1)) {
                    Object property2 = ScriptableObject.getProperty(scriptable, 0);
                    if (property2 instanceof Function) {
                        property2 = ((Function) property2).call(context, this, scriptable, new Object[0]);
                    }
                    this.prompts[0] = Context.toString(property2);
                    Object property3 = ScriptableObject.getProperty(scriptable, 1);
                    if (property3 instanceof Function) {
                        property3 = ((Function) property3).call(context, this, scriptable, new Object[0]);
                    }
                    this.prompts[1] = Context.toString(property3);
                }
            }
        }
        return this.prompts;
    }

    public void init(Context context) {
        initStandardObjects(context, this.sealedStdLib);
        defineFunctionProperties(new String[]{"defineClass", "deserialize", "doctest", "gc", "help", "load", "loadClass", "print", "quit", "readline", "readFile", "readUrl", "runCommand", "seal", "serialize", "spawn", "sync", "toint32", LitePalParser.NODE_VERSION, "write"}, Global.class, 2);
        Environment.defineClass(this);
        defineProperty("environment", new Environment(this), 2);
        NativeArray nativeArray = (NativeArray) context.newArray(this, 0);
        this.history = nativeArray;
        defineProperty("history", nativeArray, 2);
        this.initialized = true;
    }

    public void init(ContextFactory contextFactory) {
        contextFactory.call(new ContextAction() { // from class: me.tvspark.u21
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return Global.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
            }
        });
    }

    public void initQuitAction(QuitAction quitAction) {
        if (quitAction != null) {
            if (this.quitAction != null) {
                throw new IllegalArgumentException("The method is once-call.");
            }
            this.quitAction = quitAction;
            return;
        }
        throw new IllegalArgumentException("quitAction is null");
    }

    public Require installRequire(Context context, List<String> list, boolean z) {
        RequireBuilder requireBuilder = new RequireBuilder();
        requireBuilder.setSandboxed(z);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str : list) {
                try {
                    URI uri = new URI(str);
                    if (!uri.isAbsolute()) {
                        uri = new File(str).toURI().resolve("");
                    }
                    if (!uri.toString().endsWith("/")) {
                        uri = new URI(uri + "/");
                    }
                    arrayList.add(uri);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        requireBuilder.setModuleScriptProvider(new SoftCachingModuleScriptProvider(new UrlModuleSourceProvider(arrayList, null)));
        Require createRequire = requireBuilder.createRequire(context, this);
        createRequire.install(this);
        return createRequire;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:52:0x013d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:82)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    public int runDoctest(org.mozilla.javascript.Context r25, org.mozilla.javascript.Scriptable r26, java.lang.String r27, java.lang.String r28, int r29) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.shell.Global.runDoctest(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.String, java.lang.String, int):int");
    }

    public void setErr(PrintStream printStream) {
        this.errStream = printStream;
    }

    public void setIn(InputStream inputStream) {
        this.inStream = inputStream;
    }

    public void setOut(PrintStream printStream) {
        this.outStream = printStream;
    }

    public void setSealedStdLib(boolean z) {
        this.sealedStdLib = z;
    }
}

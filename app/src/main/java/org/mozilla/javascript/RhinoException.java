package org.mozilla.javascript;

import java.io.CharArrayWriter;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public abstract class RhinoException extends RuntimeException {
    public static final Pattern JAVA_STACK_PATTERN = Pattern.compile("_c_(.*)_\\d+");
    public static final long serialVersionUID = 1883500631321581169L;
    public static StackStyle stackStyle;
    public int columnNumber;
    public int[] interpreterLineData;
    public Object interpreterStackInfo;
    public int lineNumber;
    public String lineSource;
    public String sourceName;

    /* renamed from: org.mozilla.javascript.RhinoException$1 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C33201 {
        public static final /* synthetic */ int[] $SwitchMap$org$mozilla$javascript$StackStyle;

        static {
            int[] iArr = new int[StackStyle.values().length];
            $SwitchMap$org$mozilla$javascript$StackStyle = iArr;
            try {
                StackStyle stackStyle = StackStyle.MOZILLA;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$org$mozilla$javascript$StackStyle;
                StackStyle stackStyle2 = StackStyle.V8;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$org$mozilla$javascript$StackStyle;
                StackStyle stackStyle3 = StackStyle.RHINO;
                iArr3[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        StackStyle stackStyle2;
        stackStyle = StackStyle.RHINO;
        String property = System.getProperty("rhino.stack.style");
        if (property != null) {
            if ("Rhino".equalsIgnoreCase(property)) {
                stackStyle2 = StackStyle.RHINO;
            } else if ("Mozilla".equalsIgnoreCase(property)) {
                stackStyle2 = StackStyle.MOZILLA;
            } else if (!"V8".equalsIgnoreCase(property)) {
                return;
            } else {
                stackStyle2 = StackStyle.V8;
            }
            stackStyle = stackStyle2;
        }
    }

    public RhinoException() {
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter != null) {
            createInterpreter.captureStackInfo(this);
        }
    }

    public RhinoException(String str) {
        super(str);
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter != null) {
            createInterpreter.captureStackInfo(this);
        }
    }

    public static String formatStackTrace(ScriptStackElement[] scriptStackElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        if (stackStyle == StackStyle.V8 && !"null".equals(str)) {
            sb.append(str);
            sb.append(systemProperty);
        }
        for (ScriptStackElement scriptStackElement : scriptStackElementArr) {
            int ordinal = stackStyle.ordinal();
            if (ordinal == 0) {
                scriptStackElement.renderJavaStyle(sb);
            } else if (ordinal == 1) {
                scriptStackElement.renderMozillaStyle(sb);
            } else if (ordinal == 2) {
                scriptStackElement.renderV8Style(sb);
            }
            sb.append(systemProperty);
        }
        return sb.toString();
    }

    private String generateStackTrace() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        super.printStackTrace(new PrintWriter(charArrayWriter));
        String charArrayWriter2 = charArrayWriter.toString();
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter != null) {
            return createInterpreter.getPatchedStack(this, charArrayWriter2);
        }
        return null;
    }

    public static StackStyle getStackStyle() {
        return stackStyle;
    }

    public static void setStackStyle(StackStyle stackStyle2) {
        stackStyle = stackStyle2;
    }

    public static void useMozillaStackStyle(boolean z) {
        stackStyle = z ? StackStyle.MOZILLA : StackStyle.RHINO;
    }

    public static boolean usesMozillaStackStyle() {
        return stackStyle == StackStyle.MOZILLA;
    }

    public final int columnNumber() {
        return this.columnNumber;
    }

    public String details() {
        return super.getMessage();
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String details = details();
        if (this.sourceName == null || this.lineNumber <= 0) {
            return details;
        }
        StringBuilder sb = new StringBuilder(details);
        sb.append(" (");
        String str = this.sourceName;
        if (str != null) {
            sb.append(str);
        }
        if (this.lineNumber > 0) {
            sb.append('#');
            sb.append(this.lineNumber);
        }
        sb.append(')');
        return sb.toString();
    }

    public ScriptStackElement[] getScriptStack() {
        return getScriptStack(-1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ScriptStackElement[] getScriptStack(int i, String str) {
        ScriptStackElement[][] scriptStackElementArr;
        ScriptStackElement[] scriptStackElementArr2;
        ArrayList arrayList = new ArrayList();
        if (this.interpreterStackInfo != null) {
            Evaluator createInterpreter = Context.createInterpreter();
            if (createInterpreter instanceof Interpreter) {
                scriptStackElementArr = ((Interpreter) createInterpreter).getScriptStackElements(this);
                StackTraceElement[] stackTrace = getStackTrace();
                boolean z = str != null;
                int i2 = 0;
                int i3 = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String fileName = stackTraceElement.getFileName();
                    if (stackTraceElement.getMethodName().startsWith("_c_") && stackTraceElement.getLineNumber() > -1 && fileName != null && !fileName.endsWith(".java")) {
                        String methodName = stackTraceElement.getMethodName();
                        Matcher matcher = JAVA_STACK_PATTERN.matcher(methodName);
                        String group = ("_c_script_0".equals(methodName) || !matcher.find()) ? null : matcher.group(1);
                        if (!z && str.equals(group)) {
                            z = true;
                        } else if (z && (i < 0 || i3 < i)) {
                            arrayList.add(new ScriptStackElement(fileName, group, stackTraceElement.getLineNumber()));
                            i3++;
                        }
                    } else if ("org.mozilla.javascript.Interpreter".equals(stackTraceElement.getClassName()) && "interpretLoop".equals(stackTraceElement.getMethodName()) && scriptStackElementArr != null && scriptStackElementArr.length > i2) {
                        int i4 = i2 + 1;
                        for (ScriptStackElement scriptStackElement : scriptStackElementArr[i2]) {
                            if (!z && str.equals(scriptStackElement.functionName)) {
                                z = true;
                            } else if (z && (i < 0 || i3 < i)) {
                                arrayList.add(scriptStackElement);
                                i3++;
                            }
                        }
                        i2 = i4;
                    }
                }
                return (ScriptStackElement[]) arrayList.toArray(new ScriptStackElement[arrayList.size()]);
            }
        }
        scriptStackElementArr = null;
        StackTraceElement[] stackTrace2 = getStackTrace();
        if (str != null) {
        }
        int i22 = 0;
        int i32 = 0;
        while (r11 < r10) {
        }
        return (ScriptStackElement[]) arrayList.toArray(new ScriptStackElement[arrayList.size()]);
    }

    public String getScriptStackTrace() {
        return getScriptStackTrace(-1, null);
    }

    public String getScriptStackTrace(int i, String str) {
        return formatStackTrace(getScriptStack(i, str), details());
    }

    @Deprecated
    public String getScriptStackTrace(FilenameFilter filenameFilter) {
        return getScriptStackTrace();
    }

    public final void initColumnNumber(int i) {
        if (i > 0) {
            if (this.columnNumber > 0) {
                throw new IllegalStateException();
            }
            this.columnNumber = i;
            return;
        }
        throw new IllegalArgumentException(String.valueOf(i));
    }

    public final void initLineNumber(int i) {
        if (i > 0) {
            if (this.lineNumber > 0) {
                throw new IllegalStateException();
            }
            this.lineNumber = i;
            return;
        }
        throw new IllegalArgumentException(String.valueOf(i));
    }

    public final void initLineSource(String str) {
        if (str != null) {
            if (this.lineSource != null) {
                throw new IllegalStateException();
            }
            this.lineSource = str;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final void initSourceName(String str) {
        if (str != null) {
            if (this.sourceName != null) {
                throw new IllegalStateException();
            }
            this.sourceName = str;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final int lineNumber() {
        return this.lineNumber;
    }

    public final String lineSource() {
        return this.lineSource;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(printStream);
        } else {
            printStream.print(generateStackTrace());
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(printWriter);
        } else {
            printWriter.print(generateStackTrace());
        }
    }

    public final void recordErrorOrigin(String str, int i, String str2, int i2) {
        if (i == -1) {
            i = 0;
        }
        if (str != null) {
            initSourceName(str);
        }
        if (i != 0) {
            initLineNumber(i);
        }
        if (str2 != null) {
            initLineSource(str2);
        }
        if (i2 != 0) {
            initColumnNumber(i2);
        }
    }

    public final String sourceName() {
        return this.sourceName;
    }
}

package org.mozilla.javascript;

/* loaded from: classes5.dex */
public class DefaultErrorReporter implements ErrorReporter {
    public static final DefaultErrorReporter instance = new DefaultErrorReporter();
    public ErrorReporter chainedReporter;
    public boolean forEval;

    public static ErrorReporter forEval(ErrorReporter errorReporter) {
        DefaultErrorReporter defaultErrorReporter = new DefaultErrorReporter();
        defaultErrorReporter.forEval = true;
        defaultErrorReporter.chainedReporter = errorReporter;
        return defaultErrorReporter;
    }

    @Override // org.mozilla.javascript.ErrorReporter
    public void error(String str, String str2, int i, String str3, int i2) {
        String str4;
        if (!this.forEval) {
            ErrorReporter errorReporter = this.chainedReporter;
            if (errorReporter == null) {
                throw runtimeError(str, str2, i, str3, i2);
            }
            errorReporter.error(str, str2, i, str3, i2);
            return;
        }
        if (str.startsWith("TypeError: ")) {
            str = str.substring(11);
            str4 = "TypeError";
        } else {
            str4 = "SyntaxError";
        }
        throw ScriptRuntime.constructError(str4, str, str2, i, str3, i2);
    }

    @Override // org.mozilla.javascript.ErrorReporter
    public EvaluatorException runtimeError(String str, String str2, int i, String str3, int i2) {
        ErrorReporter errorReporter = this.chainedReporter;
        return errorReporter != null ? errorReporter.runtimeError(str, str2, i, str3, i2) : new EvaluatorException(str, str2, i, str3, i2);
    }

    @Override // org.mozilla.javascript.ErrorReporter
    public void warning(String str, String str2, int i, String str3, int i2) {
        ErrorReporter errorReporter = this.chainedReporter;
        if (errorReporter != null) {
            errorReporter.warning(str, str2, i, str3, i2);
        }
    }
}

package org.mozilla.javascript;

/* loaded from: classes5.dex */
public class EcmaError extends RhinoException {
    public static final long serialVersionUID = -6261226256957286699L;
    public String errorMessage;
    public String errorName;

    public EcmaError(String str, String str2, String str3, int i, String str4, int i2) {
        recordErrorOrigin(str3, i, str4, i2);
        this.errorName = str;
        this.errorMessage = str2;
    }

    @Deprecated
    public EcmaError(Scriptable scriptable, String str, int i, int i2, String str2) {
        this("InternalError", ScriptRuntime.toString(scriptable), str, i, str2, i2);
    }

    @Override // org.mozilla.javascript.RhinoException
    public String details() {
        return this.errorName + ": " + this.errorMessage;
    }

    @Deprecated
    public int getColumnNumber() {
        return columnNumber();
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Deprecated
    public Scriptable getErrorObject() {
        return null;
    }

    @Deprecated
    public int getLineNumber() {
        return lineNumber();
    }

    @Deprecated
    public String getLineSource() {
        return lineSource();
    }

    public String getName() {
        return this.errorName;
    }

    @Deprecated
    public String getSourceName() {
        return sourceName();
    }
}

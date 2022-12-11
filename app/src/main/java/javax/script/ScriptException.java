package javax.script;

import me.tvspark.outline;

/* loaded from: classes4.dex */
public class ScriptException extends Exception {
    public int columnNumber;
    public String fileName;
    public int lineNumber;

    public ScriptException(Exception exc) {
        super(exc);
        this.fileName = null;
        this.lineNumber = -1;
        this.columnNumber = -1;
    }

    public ScriptException(String str) {
        super(str);
        this.fileName = null;
        this.lineNumber = -1;
        this.columnNumber = -1;
    }

    public ScriptException(String str, String str2, int i) {
        super(str);
        this.fileName = str2;
        this.lineNumber = i;
        this.columnNumber = -1;
    }

    public ScriptException(String str, String str2, int i, int i2) {
        super(str);
        this.fileName = str2;
        this.lineNumber = i;
        this.columnNumber = i2;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this.fileName != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(message, " in ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.fileName);
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            if (this.lineNumber != -1) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, " at line number ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.lineNumber);
                sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            }
            if (this.columnNumber == -1) {
                return sb;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, " at column number ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.columnNumber);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
        }
        return message;
    }
}

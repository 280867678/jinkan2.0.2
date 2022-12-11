package net.minidev.json.parser;

/* loaded from: classes4.dex */
public class ParseException extends Exception {
    public static final int ERROR_UNEXPECTED_CHAR = 0;
    public static final int ERROR_UNEXPECTED_DUPLICATE_KEY = 5;
    public static final int ERROR_UNEXPECTED_EOF = 3;
    public static final int ERROR_UNEXPECTED_EXCEPTION = 2;
    public static final int ERROR_UNEXPECTED_LEADING_0 = 6;
    public static final int ERROR_UNEXPECTED_TOKEN = 1;
    public static final int ERROR_UNEXPECTED_UNICODE = 4;
    public static final long serialVersionUID = 8879024178584091857L;
    public int errorType;
    public int position;
    public Object unexpectedObject;

    public ParseException(int i, int i2, Object obj) {
        super(toMessage(i, i2, obj));
        this.position = i;
        this.errorType = i2;
        this.unexpectedObject = obj;
    }

    public ParseException(int i, Throwable th) {
        super(toMessage(i, 2, th), th);
        this.position = i;
        this.errorType = 2;
        this.unexpectedObject = th;
    }

    public static String toMessage(int i, int i2, Object obj) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (i2 != 0) {
            if (i2 == 1) {
                str2 = "Unexpected token ";
            } else if (i2 == 2) {
                sb.append("Unexpected exception ");
                sb.append(obj);
                str = " occur at position ";
            } else if (i2 == 3) {
                sb.append("Unexpected End Of File position ");
                sb.append(i);
                sb.append(": ");
                sb.append(obj);
                return sb.toString();
            } else if (i2 == 4) {
                str2 = "Unexpected unicode escape sequence ";
            } else if (i2 == 5) {
                str2 = "Unexpected duplicate key:";
            } else if (i2 == 6) {
                str2 = "Unexpected leading 0 in digit for token:";
            } else {
                str = "Unkown error at position ";
            }
            sb.append(str2);
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i);
            sb.append(".");
            return sb.toString();
        }
        sb.append("Unexpected character (");
        sb.append(obj);
        str = ") at position ";
        sb.append(str);
        sb.append(i);
        sb.append(".");
        return sb.toString();
    }

    public int getErrorType() {
        return this.errorType;
    }

    public int getPosition() {
        return this.position;
    }

    public Object getUnexpectedObject() {
        return this.unexpectedObject;
    }
}

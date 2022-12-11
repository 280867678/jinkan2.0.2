package org.mozilla.javascript.json;

import java.util.ArrayList;
import me.tvspark.outline;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;

/* loaded from: classes5.dex */
public class JsonParser {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: cx */
    public Context f4725cx;
    public int length;
    public int pos;
    public Scriptable scope;
    public String src;

    /* loaded from: classes5.dex */
    public static class ParseException extends Exception {
        public static final long serialVersionUID = 4804542791749920772L;

        public ParseException(Exception exc) {
            super(exc);
        }

        public ParseException(String str) {
            super(str);
        }
    }

    public JsonParser(Context context, Scriptable scriptable) {
        this.f4725cx = context;
        this.scope = scriptable;
    }

    private void consume(char c) throws ParseException {
        consumeWhitespace();
        int i = this.pos;
        if (i >= this.length) {
            throw new ParseException("Expected " + c + " but reached end of stream");
        }
        String str = this.src;
        this.pos = i + 1;
        char charAt = str.charAt(i);
        if (charAt == c) {
            return;
        }
        throw new ParseException("Expected " + c + " found " + charAt);
    }

    private void consumeWhitespace() {
        while (true) {
            int i = this.pos;
            if (i < this.length) {
                char charAt = this.src.charAt(i);
                if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                    return;
                }
                this.pos++;
            } else {
                return;
            }
        }
    }

    private int fromHex(char c) {
        if (c < '0' || c > '9') {
            char c2 = 'A';
            if (c < 'A' || c > 'F') {
                c2 = 'a';
                if (c < 'a' || c > 'f') {
                    return -1;
                }
            }
            return (c - c2) + 10;
        }
        return c - '0';
    }

    private char nextOrNumberError(int i) throws ParseException {
        int i2 = this.pos;
        int i3 = this.length;
        if (i2 < i3) {
            String str = this.src;
            this.pos = i2 + 1;
            return str.charAt(i2);
        }
        throw numberError(i, i3);
    }

    private ParseException numberError(int i, int i2) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unsupported number format: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.src.substring(i, i2));
        return new ParseException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    private Object readArray() throws ParseException {
        consumeWhitespace();
        int i = this.pos;
        if (i < this.length && this.src.charAt(i) == ']') {
            this.pos++;
            return this.f4725cx.newArray(this.scope, 0);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.length) {
                throw new ParseException("Unterminated array literal");
            }
            char charAt = this.src.charAt(i2);
            if (charAt != ',') {
                if (charAt == ']') {
                    if (!z) {
                        throw new ParseException("Unexpected comma in array literal");
                    }
                    this.pos++;
                    return this.f4725cx.newArray(this.scope, arrayList.toArray());
                } else if (z) {
                    throw new ParseException("Missing comma in array literal");
                } else {
                    arrayList.add(readValue());
                    z = true;
                }
            } else if (!z) {
                throw new ParseException("Unexpected comma in array literal");
            } else {
                this.pos++;
                z = false;
            }
            consumeWhitespace();
        }
    }

    private void readDigits() {
        char charAt;
        while (true) {
            int i = this.pos;
            if (i >= this.length || (charAt = this.src.charAt(i)) < '0' || charAt > '9') {
                return;
            }
            this.pos++;
        }
    }

    private Boolean readFalse() throws ParseException {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 >= 4 && this.src.charAt(i2) == 'a' && this.src.charAt(this.pos + 1) == 'l' && this.src.charAt(this.pos + 2) == 's' && this.src.charAt(this.pos + 3) == 'e') {
            this.pos += 4;
            return Boolean.FALSE;
        }
        throw new ParseException("Unexpected token: f");
    }

    private Object readNull() throws ParseException {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 >= 3 && this.src.charAt(i2) == 'u' && this.src.charAt(this.pos + 1) == 'l' && this.src.charAt(this.pos + 2) == 'l') {
            this.pos += 3;
            return null;
        }
        throw new ParseException("Unexpected token: n");
    }

    private Number readNumber(char c) throws ParseException {
        char charAt;
        int i = this.pos - 1;
        if (c != '-' || ((c = nextOrNumberError(i)) >= '0' && c <= '9')) {
            if (c != '0') {
                readDigits();
            }
            int i2 = this.pos;
            if (i2 < this.length && this.src.charAt(i2) == '.') {
                this.pos++;
                char nextOrNumberError = nextOrNumberError(i);
                if (nextOrNumberError < '0' || nextOrNumberError > '9') {
                    throw numberError(i, this.pos);
                }
                readDigits();
            }
            int i3 = this.pos;
            if (i3 < this.length && ((charAt = this.src.charAt(i3)) == 'e' || charAt == 'E')) {
                this.pos++;
                char nextOrNumberError2 = nextOrNumberError(i);
                if (nextOrNumberError2 == '-' || nextOrNumberError2 == '+') {
                    nextOrNumberError2 = nextOrNumberError(i);
                }
                if (nextOrNumberError2 < '0' || nextOrNumberError2 > '9') {
                    throw numberError(i, this.pos);
                }
                readDigits();
            }
            double parseDouble = Double.parseDouble(this.src.substring(i, this.pos));
            int i4 = (int) parseDouble;
            return ((double) i4) == parseDouble ? Integer.valueOf(i4) : Double.valueOf(parseDouble);
        }
        throw numberError(i, this.pos);
    }

    private Object readObject() throws ParseException {
        consumeWhitespace();
        Scriptable newObject = this.f4725cx.newObject(this.scope);
        int i = this.pos;
        if (i < this.length && this.src.charAt(i) == '}') {
            this.pos++;
            return newObject;
        }
        boolean z = false;
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.length) {
                throw new ParseException("Unterminated object literal");
            }
            String str = this.src;
            this.pos = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt != '\"') {
                if (charAt != ',') {
                    if (charAt != '}') {
                        throw new ParseException("Unexpected token in object literal");
                    }
                    if (!z) {
                        throw new ParseException("Unexpected comma in object literal");
                    }
                    return newObject;
                } else if (!z) {
                    throw new ParseException("Unexpected comma in object literal");
                } else {
                    z = false;
                }
            } else if (z) {
                throw new ParseException("Missing comma in object literal");
            } else {
                String readString = readString();
                consume(':');
                Object readValue = readValue();
                long indexFromString = ScriptRuntime.indexFromString(readString);
                if (indexFromString < 0) {
                    newObject.put(readString, newObject, readValue);
                } else {
                    newObject.put((int) indexFromString, newObject, readValue);
                }
                z = true;
            }
            consumeWhitespace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0037, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String readString() throws ParseException {
        char c;
        char charAt;
        int i = this.pos;
        do {
            int i2 = this.pos;
            if (i2 < this.length) {
                String str = this.src;
                this.pos = i2 + 1;
                charAt = str.charAt(i2);
                if (charAt <= 31) {
                    throw new ParseException("String contains control character");
                }
                if (charAt == '\\') {
                }
            }
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i3 = this.pos;
                if (i3 >= this.length) {
                    throw new ParseException("Unterminated string literal");
                }
                sb.append((CharSequence) this.src, i, i3 - 1);
                int i4 = this.pos;
                if (i4 >= this.length) {
                    throw new ParseException("Unterminated string");
                }
                String str2 = this.src;
                this.pos = i4 + 1;
                char charAt2 = str2.charAt(i4);
                if (charAt2 == '\"') {
                    sb.append('\"');
                } else if (charAt2 == '/') {
                    sb.append('/');
                } else if (charAt2 == '\\') {
                    sb.append('\\');
                } else if (charAt2 == 'b') {
                    sb.append('\b');
                } else if (charAt2 != 'f') {
                    if (charAt2 == 'n') {
                        c = '\n';
                    } else if (charAt2 == 'r') {
                        c = '\r';
                    } else if (charAt2 == 't') {
                        c = '\t';
                    } else if (charAt2 != 'u') {
                        throw new ParseException("Unexpected character in string: '\\" + charAt2 + "'");
                    } else {
                        int i5 = this.length;
                        int i6 = this.pos;
                        if (i5 - i6 < 5) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid character code: \\u");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.src.substring(this.pos));
                            throw new ParseException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        }
                        int fromHex = (fromHex(this.src.charAt(i6 + 0)) << 12) | (fromHex(this.src.charAt(this.pos + 1)) << 8) | (fromHex(this.src.charAt(this.pos + 2)) << 4) | fromHex(this.src.charAt(this.pos + 3));
                        if (fromHex < 0) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid character code: ");
                            String str3 = this.src;
                            int i7 = this.pos;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str3.substring(i7, i7 + 4));
                            throw new ParseException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                        }
                        this.pos += 4;
                        c = (char) fromHex;
                    }
                    sb.append(c);
                } else {
                    sb.append('\f');
                }
                i = this.pos;
                while (true) {
                    int i8 = this.pos;
                    if (i8 < this.length) {
                        String str4 = this.src;
                        this.pos = i8 + 1;
                        char charAt3 = str4.charAt(i8);
                        if (charAt3 <= 31) {
                            throw new ParseException("String contains control character");
                        }
                        if (charAt3 == '\\') {
                            break;
                        } else if (charAt3 == '\"') {
                            sb.append((CharSequence) this.src, i, this.pos - 1);
                            return sb.toString();
                        }
                    }
                }
            }
        } while (charAt != '\"');
        return this.src.substring(i, this.pos - 1);
    }

    private Boolean readTrue() throws ParseException {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 >= 3 && this.src.charAt(i2) == 'r' && this.src.charAt(this.pos + 1) == 'u' && this.src.charAt(this.pos + 2) == 'e') {
            this.pos += 3;
            return Boolean.TRUE;
        }
        throw new ParseException("Unexpected token: t");
    }

    private Object readValue() throws ParseException {
        consumeWhitespace();
        int i = this.pos;
        if (i < this.length) {
            String str = this.src;
            this.pos = i + 1;
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                return readString();
            }
            if (charAt != '-') {
                if (charAt == '[') {
                    return readArray();
                }
                if (charAt == 'f') {
                    return readFalse();
                }
                if (charAt == 'n') {
                    return readNull();
                }
                if (charAt == 't') {
                    return readTrue();
                }
                if (charAt == '{') {
                    return readObject();
                }
                switch (charAt) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        break;
                    default:
                        throw new ParseException("Unexpected token: " + charAt);
                }
            }
            return readNumber(charAt);
        }
        throw new ParseException("Empty JSON string");
    }

    public synchronized Object parseValue(String str) throws ParseException {
        Object readValue;
        try {
            if (str == null) {
                throw new ParseException("Input string may not be null");
            }
            this.pos = 0;
            this.length = str.length();
            this.src = str;
            readValue = readValue();
            consumeWhitespace();
            if (this.pos < this.length) {
                throw new ParseException("Expected end of stream at char " + this.pos);
            }
        } catch (Throwable th) {
            throw th;
        }
        return readValue;
    }
}

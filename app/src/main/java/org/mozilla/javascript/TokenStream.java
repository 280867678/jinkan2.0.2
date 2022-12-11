package org.mozilla.javascript;

import com.umeng.commonsdk.UMConfigure;
import java.io.IOException;
import java.io.Reader;
import org.eclipse.jetty.util.MultiPartWriter;
import org.fourthline.cling.model.meta.QueryStateVariableAction;
import org.mozilla.javascript.Token;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes5.dex */
public class TokenStream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final char BYTE_ORDER_MARK = 65279;
    public static final int EOF_CHAR = -1;
    public Token.CommentType commentType;
    public int cursor;
    public boolean dirtyLine;
    public boolean isBinary;
    public boolean isHex;
    public boolean isOctal;
    public boolean isOldOctal;
    public int lineno;
    public double number;
    public Parser parser;
    public int quoteChar;
    public String regExpFlags;
    public char[] sourceBuffer;
    public int sourceCursor;
    public int sourceEnd;
    public Reader sourceReader;
    public String sourceString;
    public int stringBufferTop;
    public int tokenBeg;
    public int tokenEnd;
    public int ungetCursor;
    public boolean xmlIsAttribute;
    public boolean xmlIsTagContent;
    public int xmlOpenTagsCount;
    public String string = "";
    public char[] stringBuffer = new char[128];
    public ObjToIntMap allStrings = new ObjToIntMap(50);
    public final int[] ungetBuffer = new int[3];
    public boolean hitEOF = false;
    public int lineStart = 0;
    public int lineEndChar = -1;
    public String commentPrefix = "";
    public int commentCursor = -1;

    public TokenStream(Parser parser, Reader reader, String str, int i) {
        this.parser = parser;
        this.lineno = i;
        if (reader != null) {
            if (str != null) {
                Kit.codeBug();
            }
            this.sourceReader = reader;
            this.sourceBuffer = new char[512];
            this.sourceEnd = 0;
        } else {
            if (str == null) {
                Kit.codeBug();
            }
            this.sourceString = str;
            this.sourceEnd = str.length();
        }
        this.cursor = 0;
        this.sourceCursor = 0;
    }

    private void addToString(int i) {
        int i2 = this.stringBufferTop;
        char[] cArr = this.stringBuffer;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.stringBuffer = cArr2;
        }
        this.stringBuffer[i2] = (char) i;
        this.stringBufferTop = i2 + 1;
    }

    private boolean canUngetChar() {
        int i = this.ungetCursor;
        return i == 0 || this.ungetBuffer[i - 1] != 10;
    }

    private final int charAt(int i) {
        if (i < 0) {
            return -1;
        }
        String str = this.sourceString;
        if (str != null) {
            if (i < this.sourceEnd) {
                return str.charAt(i);
            }
            return -1;
        }
        if (i >= this.sourceEnd) {
            int i2 = this.sourceCursor;
            try {
                if (!fillSourceBuffer()) {
                    return -1;
                }
                i -= i2 - this.sourceCursor;
            } catch (IOException unused) {
                return -1;
            }
        }
        return this.sourceBuffer[i];
    }

    private String convertLastCharToHex(String str) {
        int length = str.length() - 1;
        StringBuilder sb = new StringBuilder(str.substring(0, length));
        sb.append("\\u");
        String hexString = Integer.toHexString(str.charAt(length));
        for (int i = 0; i < 4 - hexString.length(); i++) {
            sb.append('0');
        }
        sb.append(hexString);
        return sb.toString();
    }

    private boolean fillSourceBuffer() throws IOException {
        if (this.sourceString != null) {
            Kit.codeBug();
        }
        if (this.sourceEnd == this.sourceBuffer.length) {
            if (this.lineStart == 0 || isMarkingComment()) {
                char[] cArr = this.sourceBuffer;
                char[] cArr2 = new char[cArr.length * 2];
                System.arraycopy(cArr, 0, cArr2, 0, this.sourceEnd);
                this.sourceBuffer = cArr2;
            } else {
                char[] cArr3 = this.sourceBuffer;
                int i = this.lineStart;
                System.arraycopy(cArr3, i, cArr3, 0, this.sourceEnd - i);
                int i2 = this.sourceEnd;
                int i3 = this.lineStart;
                this.sourceEnd = i2 - i3;
                this.sourceCursor -= i3;
                this.lineStart = 0;
            }
        }
        Reader reader = this.sourceReader;
        char[] cArr4 = this.sourceBuffer;
        int i4 = this.sourceEnd;
        int read = reader.read(cArr4, i4, cArr4.length - i4);
        if (read < 0) {
            return false;
        }
        this.sourceEnd += read;
        return true;
    }

    private int getChar() throws IOException {
        return getChar(true);
    }

    private int getChar(boolean z) throws IOException {
        char c;
        int i = this.ungetCursor;
        if (i != 0) {
            this.cursor++;
            int[] iArr = this.ungetBuffer;
            int i2 = i - 1;
            this.ungetCursor = i2;
            return iArr[i2];
        }
        while (true) {
            String str = this.sourceString;
            if (str != null) {
                int i3 = this.sourceCursor;
                if (i3 == this.sourceEnd) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                this.sourceCursor = i3 + 1;
                c = str.charAt(i3);
            } else if (this.sourceCursor == this.sourceEnd && !fillSourceBuffer()) {
                this.hitEOF = true;
                return -1;
            } else {
                this.cursor++;
                char[] cArr = this.sourceBuffer;
                int i4 = this.sourceCursor;
                this.sourceCursor = i4 + 1;
                c = cArr[i4];
            }
            int i5 = this.lineEndChar;
            if (i5 >= 0) {
                if (i5 == 13 && c == '\n') {
                    this.lineEndChar = 10;
                } else {
                    this.lineEndChar = -1;
                    this.lineStart = this.sourceCursor - 1;
                    this.lineno++;
                }
            }
            if (c <= 127) {
                if (c != '\n' && c != '\r') {
                    return c;
                }
            } else if (c == 65279) {
                return c;
            } else {
                if (!z || !isJSFormatChar(c)) {
                    break;
                }
            }
        }
        if (!ScriptRuntime.isJSLineTerminator(c)) {
            return c;
        }
        this.lineEndChar = c;
        return 10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        r5.lineEndChar = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
        return 10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getCharIgnoreLineEnd() throws IOException {
        char c;
        int i = this.ungetCursor;
        if (i != 0) {
            this.cursor++;
            int[] iArr = this.ungetBuffer;
            int i2 = i - 1;
            this.ungetCursor = i2;
            return iArr[i2];
        }
        while (true) {
            String str = this.sourceString;
            if (str != null) {
                int i3 = this.sourceCursor;
                if (i3 == this.sourceEnd) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                this.sourceCursor = i3 + 1;
                c = str.charAt(i3);
            } else if (this.sourceCursor == this.sourceEnd && !fillSourceBuffer()) {
                this.hitEOF = true;
                return -1;
            } else {
                this.cursor++;
                char[] cArr = this.sourceBuffer;
                int i4 = this.sourceCursor;
                this.sourceCursor = i4 + 1;
                c = cArr[i4];
            }
            if (c <= 127) {
                if (c != '\n' && c != '\r') {
                    return c;
                }
            } else if (c == 65279) {
                return c;
            } else {
                if (!isJSFormatChar(c)) {
                    if (!ScriptRuntime.isJSLineTerminator(c)) {
                        return c;
                    }
                }
            }
        }
    }

    private String getStringFromBuffer() {
        this.tokenEnd = this.cursor;
        return new String(this.stringBuffer, 0, this.stringBufferTop);
    }

    public static boolean isAlpha(int i) {
        return i <= 90 ? 65 <= i : 97 <= i && i <= 122;
    }

    public static boolean isDigit(int i) {
        return 48 <= i && i <= 57;
    }

    public static boolean isJSFormatChar(int i) {
        return i > 127 && Character.getType((char) i) == 16;
    }

    public static boolean isJSSpace(int i) {
        return i <= 127 ? i == 32 || i == 9 || i == 12 || i == 11 : i == 160 || i == 65279 || Character.getType((char) i) == 12;
    }

    public static boolean isKeyword(String str, int i, boolean z) {
        return stringToKeyword(str, i, z) != 0;
    }

    private boolean isMarkingComment() {
        return this.commentCursor != -1;
    }

    private void markCommentStart() {
        markCommentStart("");
    }

    private void markCommentStart(String str) {
        if (!this.parser.compilerEnv.isRecordingComments() || this.sourceReader == null) {
            return;
        }
        this.commentPrefix = str;
        this.commentCursor = this.sourceCursor - 1;
    }

    private boolean matchChar(int i) throws IOException {
        int charIgnoreLineEnd = getCharIgnoreLineEnd();
        if (charIgnoreLineEnd == i) {
            this.tokenEnd = this.cursor;
            return true;
        }
        ungetCharIgnoreLineEnd(charIgnoreLineEnd);
        return false;
    }

    private int peekChar() throws IOException {
        int i = getChar();
        ungetChar(i);
        return i;
    }

    private boolean readCDATA() throws IOException {
        while (true) {
            int i = getChar();
            while (i != -1) {
                addToString(i);
                if (i == 93 && peekChar() == 93) {
                    i = getChar();
                    addToString(i);
                    if (peekChar() == 62) {
                        addToString(getChar());
                        return true;
                    }
                }
            }
            this.stringBufferTop = 0;
            this.string = null;
            this.parser.addError("msg.XML.bad.form");
            return false;
        }
    }

    private boolean readEntity() throws IOException {
        int i = getChar();
        int i2 = 1;
        while (i != -1) {
            addToString(i);
            if (i == 60) {
                i2++;
            } else if (i == 62 && i2 - 1 == 0) {
                return true;
            }
            i = getChar();
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private boolean readPI() throws IOException {
        while (true) {
            int i = getChar();
            if (i == -1) {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
            addToString(i);
            if (i == 63 && peekChar() == 62) {
                addToString(getChar());
                return true;
            }
        }
    }

    private boolean readQuotedString(int i) throws IOException {
        int i2;
        do {
            i2 = getChar();
            if (i2 == -1) {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
            addToString(i2);
        } while (i2 != i);
        return true;
    }

    private boolean readXmlComment() throws IOException {
        while (true) {
            int i = getChar();
            while (i != -1) {
                addToString(i);
                if (i == 45 && peekChar() == 45) {
                    i = getChar();
                    addToString(i);
                    if (peekChar() == 62) {
                        addToString(getChar());
                        return true;
                    }
                }
            }
            this.stringBufferTop = 0;
            this.string = null;
            this.parser.addError("msg.XML.bad.form");
            return false;
        }
    }

    private void skipLine() throws IOException {
        int i;
        do {
            i = getChar();
            if (i == -1) {
                break;
            }
        } while (i != 10);
        ungetChar(i);
        this.tokenEnd = this.cursor;
    }

    public static int stringToKeyword(String str, int i, boolean z) {
        return i < 200 ? stringToKeywordForJS(str) : stringToKeywordForES(str, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01a9, code lost:
        if (r17.charAt(1) == 'l') goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
        if (r1 != 'x') goto L187;
     */
    /* JADX WARN: Removed duplicated region for block: B:187:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0271 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int stringToKeywordForES(String str, boolean z) {
        String str2;
        int i;
        int i2 = 114;
        switch (str.length()) {
            case 2:
                char charAt = str.charAt(1);
                if (charAt == 'f') {
                    if (str.charAt(0) == 'i') {
                        i2 = 113;
                        break;
                    }
                    str2 = null;
                    i = 0;
                } else if (charAt == 'n') {
                    if (str.charAt(0) == 'i') {
                        i2 = 52;
                        break;
                    }
                    str2 = null;
                    i = 0;
                } else {
                    if (charAt == 'o' && str.charAt(0) == 'd') {
                        i2 = 119;
                        break;
                    }
                    str2 = null;
                    i = 0;
                }
                if (str2 == null && str2 != str && !str2.equals(str)) {
                    i2 = 0;
                    break;
                } else {
                    i2 = i;
                    break;
                }
                break;
            case 3:
                char charAt2 = str.charAt(0);
                if (charAt2 == 'f') {
                    if (str.charAt(2) == 'r' && str.charAt(1) == 'o') {
                        i2 = 120;
                        break;
                    }
                    str2 = null;
                    i = 0;
                } else if (charAt2 == 'l') {
                    if (str.charAt(2) == 't' && str.charAt(1) == 'e') {
                        i2 = 154;
                        break;
                    }
                    str2 = null;
                    i = 0;
                } else if (charAt2 == 'n') {
                    if (str.charAt(2) == 'w' && str.charAt(1) == 'e') {
                        i2 = 30;
                        break;
                    }
                    str2 = null;
                    i = 0;
                } else if (charAt2 != 't') {
                    if (charAt2 == 'v' && str.charAt(2) == 'r' && str.charAt(1) == 'a') {
                        i2 = 123;
                        break;
                    }
                    str2 = null;
                    i = 0;
                } else {
                    if (str.charAt(2) == 'y' && str.charAt(1) == 'r') {
                        i2 = 82;
                        break;
                    }
                    str2 = null;
                    i = 0;
                }
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 4:
                char charAt3 = str.charAt(0);
                if (charAt3 == 'c') {
                    if (str.charAt(3) == 'e' && str.charAt(2) == 's' && str.charAt(1) == 'a') {
                        i2 = 116;
                        break;
                    }
                    str2 = null;
                    i = 0;
                } else if (charAt3 == 'e') {
                    char charAt4 = str.charAt(3);
                    if (charAt4 == 'e') {
                        if (str.charAt(2) == 's') {
                            break;
                        }
                        str2 = null;
                        i = 0;
                    } else {
                        if (charAt4 == 'm' && str.charAt(2) == 'u' && str.charAt(1) == 'n') {
                            i2 = 128;
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else if (charAt3 != 'n') {
                    if (charAt3 == 't') {
                        char charAt5 = str.charAt(3);
                        if (charAt5 != 'e') {
                            if (charAt5 == 's' && str.charAt(2) == 'i' && str.charAt(1) == 'h') {
                                i2 = 43;
                                break;
                            }
                        } else if (str.charAt(2) == 'u' && str.charAt(1) == 'r') {
                            i2 = 45;
                            break;
                        }
                    } else if (charAt3 == 'v') {
                        i = 127;
                        str2 = ClassTransform.VOID;
                    } else if (charAt3 == 'w') {
                        i = 124;
                        str2 = "with";
                    }
                    str2 = null;
                    i = 0;
                } else {
                    i = 42;
                    str2 = "null";
                }
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 5:
                char charAt6 = str.charAt(2);
                if (charAt6 == 'a') {
                    char charAt7 = str.charAt(0);
                    if (charAt7 == 'c') {
                        str2 = "class";
                    } else {
                        if (charAt7 == 'a') {
                            str2 = "await";
                        }
                        str2 = null;
                        i = 0;
                    }
                    i = 128;
                } else if (charAt6 == 'e') {
                    char charAt8 = str.charAt(0);
                    if (charAt8 == 'b') {
                        str2 = "break";
                        i = 121;
                    } else {
                        if (charAt8 == 'y') {
                            i = 73;
                            str2 = "yield";
                        }
                        str2 = null;
                        i = 0;
                    }
                } else if (charAt6 == 'i') {
                    str2 = "while";
                    i = 118;
                } else if (charAt6 == 'l') {
                    i = 44;
                    str2 = "false";
                } else if (charAt6 == 'n') {
                    i = 155;
                    str2 = "const";
                } else if (charAt6 == 'p') {
                    str2 = "super";
                    i = 128;
                } else if (charAt6 != 'r') {
                    if (charAt6 == 't') {
                        i = 125;
                        str2 = "catch";
                    }
                    str2 = null;
                    i = 0;
                } else {
                    i = 50;
                    str2 = "throw";
                }
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 6:
                char charAt9 = str.charAt(1);
                if (charAt9 != 'e') {
                    if (charAt9 == 'm') {
                        str2 = "import";
                    } else if (charAt9 != 't') {
                        if (charAt9 != 'u') {
                            switch (charAt9) {
                                case 'w':
                                    str2 = "switch";
                                    i = 115;
                                    break;
                                case 'x':
                                    str2 = "export";
                                    break;
                                case 'y':
                                    i = 32;
                                    str2 = "typeof";
                                    break;
                                default:
                                    str2 = null;
                                    i = 0;
                                    break;
                            }
                            if (str2 == null) {
                            }
                            i2 = i;
                            break;
                        }
                        if (z) {
                            str2 = "public";
                        }
                        str2 = "switch";
                        i = 115;
                        if (str2 == null) {
                        }
                        i2 = i;
                    } else {
                        if (z) {
                            str2 = "static";
                        }
                        if (z) {
                        }
                        str2 = "switch";
                        i = 115;
                        if (str2 == null) {
                        }
                        i2 = i;
                    }
                    i = 128;
                    if (str2 == null) {
                    }
                    i2 = i;
                } else {
                    char charAt10 = str.charAt(0);
                    if (charAt10 == 'd') {
                        i = 31;
                        str2 = "delete";
                    } else {
                        if (charAt10 == 'r') {
                            i = 4;
                            str2 = QueryStateVariableAction.OUTPUT_ARG_RETURN;
                        }
                        str2 = null;
                        i = 0;
                    }
                    if (str2 == null) {
                    }
                    i2 = i;
                }
                break;
            case 7:
                char charAt11 = str.charAt(1);
                if (charAt11 != 'a') {
                    if (charAt11 != 'e') {
                        if (charAt11 != 'i') {
                            if (charAt11 != 'r') {
                                break;
                            } else if (z) {
                                str2 = "private";
                                i = 128;
                            }
                            str2 = "extends";
                            i = 128;
                        } else {
                            i = 126;
                            str2 = "finally";
                        }
                    }
                    str2 = "default";
                    i = 117;
                } else {
                    if (z) {
                        str2 = "package";
                        i = 128;
                    }
                    str2 = "default";
                    i = 117;
                }
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 8:
                char charAt12 = str.charAt(0);
                if (charAt12 == 'c') {
                    i = 122;
                    str2 = "continue";
                } else if (charAt12 != 'd') {
                    if (charAt12 == 'f') {
                        str2 = "function";
                        i = 110;
                    }
                    str2 = null;
                    i = 0;
                } else {
                    i = 161;
                    str2 = "debugger";
                }
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 9:
                char charAt13 = str.charAt(0);
                if (charAt13 != 'i' || !z) {
                    if (charAt13 == 'p' && z) {
                        str2 = "protected";
                    }
                    str2 = null;
                    i = 0;
                    if (str2 == null) {
                    }
                    i2 = i;
                    break;
                } else {
                    str2 = "interface";
                }
                i = 128;
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 10:
                char charAt14 = str.charAt(1);
                if (charAt14 != 'm' || !z) {
                    if (charAt14 == 'n') {
                        i = 53;
                        str2 = "instanceof";
                        if (str2 == null) {
                        }
                        i2 = i;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    if (str2 == null) {
                    }
                    i2 = i;
                } else {
                    str2 = "implements";
                    i = 128;
                    if (str2 == null) {
                    }
                    i2 = i;
                }
                break;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 & 255;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0205, code lost:
        if (r17.charAt(1) == 'n') goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02a1, code lost:
        r6 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0231, code lost:
        if (r17.charAt(1) == 'h') goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x029f, code lost:
        if (r17.charAt(1) == 'n') goto L155;
     */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x02df A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int stringToKeywordForJS(String str) {
        String str2;
        int i;
        int i2;
        switch (str.length()) {
            case 2:
                char charAt = str.charAt(1);
                if (charAt == 'f') {
                    if (str.charAt(0) == 'i') {
                        i2 = 113;
                        break;
                    }
                    str2 = null;
                    i = 0;
                } else if (charAt == 'n') {
                    if (str.charAt(0) == 'i') {
                        i2 = 52;
                        break;
                    }
                    str2 = null;
                    i = 0;
                } else {
                    if (charAt == 'o' && str.charAt(0) == 'd') {
                        i2 = 119;
                        break;
                    }
                    str2 = null;
                    i = 0;
                }
                if (str2 == null && str2 != str && !str2.equals(str)) {
                    i2 = 0;
                    break;
                } else {
                    i2 = i;
                    break;
                }
            case 3:
                char charAt2 = str.charAt(0);
                if (charAt2 != 'f') {
                    if (charAt2 == 'i') {
                        if (str.charAt(2) == 't') {
                            break;
                        }
                    } else if (charAt2 == 'l') {
                        if (str.charAt(2) == 't' && str.charAt(1) == 'e') {
                            i2 = 154;
                            break;
                        }
                    } else if (charAt2 == 'n') {
                        if (str.charAt(2) == 'w' && str.charAt(1) == 'e') {
                            i2 = 30;
                            break;
                        }
                    } else if (charAt2 == 't') {
                        if (str.charAt(2) == 'y' && str.charAt(1) == 'r') {
                            i2 = 82;
                            break;
                        }
                    } else if (charAt2 == 'v' && str.charAt(2) == 'r' && str.charAt(1) == 'a') {
                        i2 = 123;
                        break;
                    }
                    str2 = null;
                    i = 0;
                } else {
                    if (str.charAt(2) == 'r' && str.charAt(1) == 'o') {
                        i2 = 120;
                        break;
                    }
                    str2 = null;
                    i = 0;
                }
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 4:
                char charAt3 = str.charAt(0);
                if (charAt3 == 'b') {
                    str2 = ClassTransform.BYTE;
                } else if (charAt3 != 'c') {
                    if (charAt3 == 'e') {
                        char charAt4 = str.charAt(3);
                        if (charAt4 != 'e') {
                            if (charAt4 == 'm') {
                                if (str.charAt(2) == 'u') {
                                    break;
                                }
                            }
                        } else if (str.charAt(2) == 's' && str.charAt(1) == 'l') {
                            i2 = 114;
                            break;
                        }
                        str2 = null;
                        i = 0;
                    } else if (charAt3 == 'g') {
                        str2 = "goto";
                    } else if (charAt3 == 'l') {
                        str2 = ClassTransform.LONG;
                    } else if (charAt3 != 'n') {
                        if (charAt3 == 't') {
                            char charAt5 = str.charAt(3);
                            if (charAt5 != 'e') {
                                if (charAt5 == 's' && str.charAt(2) == 'i' && str.charAt(1) == 'h') {
                                    i2 = 43;
                                    break;
                                }
                            } else if (str.charAt(2) == 'u' && str.charAt(1) == 'r') {
                                i2 = 45;
                                break;
                            }
                        } else if (charAt3 == 'v') {
                            i = 127;
                            str2 = ClassTransform.VOID;
                        } else if (charAt3 == 'w') {
                            i = 124;
                            str2 = "with";
                        }
                        str2 = null;
                        i = 0;
                    } else {
                        i = 42;
                        str2 = "null";
                    }
                    if (str2 == null) {
                    }
                    i2 = i;
                    break;
                } else {
                    char charAt6 = str.charAt(3);
                    if (charAt6 != 'e') {
                        if (charAt6 == 'r') {
                            if (str.charAt(2) == 'a') {
                                break;
                            }
                        }
                    } else if (str.charAt(2) == 's' && str.charAt(1) == 'a') {
                        i2 = 116;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    if (str2 == null) {
                    }
                    i2 = i;
                }
                i = 128;
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 5:
                char charAt7 = str.charAt(2);
                if (charAt7 == 'a') {
                    str2 = "class";
                } else if (charAt7 != 'e') {
                    if (charAt7 == 'i') {
                        str2 = "while";
                        i = 118;
                    } else if (charAt7 == 'l') {
                        i = 44;
                        str2 = "false";
                    } else if (charAt7 == 'r') {
                        i = 50;
                        str2 = "throw";
                    } else if (charAt7 != 't') {
                        switch (charAt7) {
                            case 'n':
                                char charAt8 = str.charAt(0);
                                if (charAt8 != 'c') {
                                    if (charAt8 == 'f') {
                                        str2 = "final";
                                        break;
                                    }
                                    str2 = null;
                                    i = 0;
                                    break;
                                } else {
                                    i = 155;
                                    str2 = "const";
                                    break;
                                }
                            case 'o':
                                char charAt9 = str.charAt(0);
                                if (charAt9 != 'f') {
                                    if (charAt9 == 's') {
                                        str2 = ClassTransform.SHORT;
                                        break;
                                    }
                                    str2 = null;
                                    i = 0;
                                    break;
                                } else {
                                    str2 = ClassTransform.FLOAT;
                                    break;
                                }
                            case 'p':
                                str2 = "super";
                                break;
                            default:
                                str2 = null;
                                i = 0;
                                break;
                        }
                    } else {
                        i = 125;
                        str2 = "catch";
                    }
                    if (str2 == null) {
                    }
                    i2 = i;
                    break;
                } else {
                    char charAt10 = str.charAt(0);
                    if (charAt10 == 'b') {
                        str2 = "break";
                        i = 121;
                    } else {
                        if (charAt10 == 'y') {
                            i = 73;
                            str2 = "yield";
                        }
                        str2 = null;
                        i = 0;
                    }
                    if (str2 == null) {
                    }
                    i2 = i;
                }
                i = 128;
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 6:
                char charAt11 = str.charAt(1);
                if (charAt11 == 'a') {
                    str2 = UMConfigure.WRAPER_TYPE_NATIVE;
                } else if (charAt11 == 'e') {
                    char charAt12 = str.charAt(0);
                    if (charAt12 == 'd') {
                        i = 31;
                        str2 = "delete";
                    } else {
                        if (charAt12 == 'r') {
                            i = 4;
                            str2 = QueryStateVariableAction.OUTPUT_ARG_RETURN;
                        }
                        str2 = null;
                        i = 0;
                    }
                    if (str2 == null) {
                    }
                    i2 = i;
                } else if (charAt11 == 'h') {
                    str2 = "throws";
                } else if (charAt11 == 'm') {
                    str2 = "import";
                } else if (charAt11 == 'o') {
                    str2 = ClassTransform.DOUBLE;
                } else if (charAt11 == 't') {
                    str2 = "static";
                } else if (charAt11 != 'u') {
                    switch (charAt11) {
                        case 'w':
                            str2 = "switch";
                            i = 115;
                            break;
                        case 'x':
                            str2 = "export";
                            break;
                        case 'y':
                            i = 32;
                            str2 = "typeof";
                            break;
                    }
                    if (str2 == null) {
                    }
                    i2 = i;
                    break;
                } else {
                    str2 = "public";
                }
                i = 128;
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 7:
                char charAt13 = str.charAt(1);
                if (charAt13 != 'a') {
                    if (charAt13 == 'e') {
                        str2 = "default";
                        i = 117;
                    } else if (charAt13 == 'i') {
                        i = 126;
                        str2 = "finally";
                    } else if (charAt13 == 'o') {
                        str2 = ClassTransform.BOOLEAN;
                    } else if (charAt13 != 'r') {
                        if (charAt13 == 'x') {
                            str2 = "extends";
                        }
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "private";
                    }
                    if (str2 == null) {
                    }
                    i2 = i;
                    break;
                } else {
                    str2 = "package";
                }
                i = 128;
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 8:
                char charAt14 = str.charAt(0);
                if (charAt14 != 'a') {
                    if (charAt14 == 'f') {
                        str2 = "function";
                        i = 110;
                    } else if (charAt14 == 'v') {
                        str2 = "volatile";
                    } else if (charAt14 != 'c') {
                        if (charAt14 == 'd') {
                            i = 161;
                            str2 = "debugger";
                        }
                        str2 = null;
                        i = 0;
                    } else {
                        i = 122;
                        str2 = "continue";
                    }
                    if (str2 == null) {
                    }
                    i2 = i;
                    break;
                } else {
                    str2 = "abstract";
                }
                i = 128;
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 9:
                char charAt15 = str.charAt(0);
                if (charAt15 != 'i') {
                    if (charAt15 != 'p') {
                        if (charAt15 == 't') {
                            str2 = "transient";
                        }
                        str2 = null;
                        i = 0;
                        if (str2 == null) {
                        }
                        i2 = i;
                        break;
                    } else {
                        str2 = "protected";
                    }
                } else {
                    str2 = "interface";
                }
                i = 128;
                if (str2 == null) {
                }
                i2 = i;
                break;
            case 10:
                char charAt16 = str.charAt(1);
                if (charAt16 == 'm') {
                    str2 = "implements";
                    i = 128;
                    if (str2 == null) {
                    }
                    i2 = i;
                    break;
                } else {
                    if (charAt16 == 'n') {
                        i = 53;
                        str2 = "instanceof";
                        if (str2 == null) {
                        }
                        i2 = i;
                    }
                    str2 = null;
                    i = 0;
                    if (str2 == null) {
                    }
                    i2 = i;
                }
                break;
            case 12:
                str2 = "synchronized";
                i = 128;
                if (str2 == null) {
                }
                i2 = i;
                break;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 & 255;
    }

    private final String substring(int i, int i2) {
        String str = this.sourceString;
        if (str != null) {
            return str.substring(i, i2);
        }
        return new String(this.sourceBuffer, i, i2 - i);
    }

    private void ungetChar(int i) {
        int i2 = this.ungetCursor;
        if (i2 != 0 && this.ungetBuffer[i2 - 1] == 10) {
            Kit.codeBug();
        }
        int[] iArr = this.ungetBuffer;
        int i3 = this.ungetCursor;
        this.ungetCursor = i3 + 1;
        iArr[i3] = i;
        this.cursor--;
    }

    private void ungetCharIgnoreLineEnd(int i) {
        int[] iArr = this.ungetBuffer;
        int i2 = this.ungetCursor;
        this.ungetCursor = i2 + 1;
        iArr[i2] = i;
        this.cursor--;
    }

    public final boolean eof() {
        return this.hitEOF;
    }

    public final String getAndResetCurrentComment() {
        if (this.sourceString != null) {
            if (isMarkingComment()) {
                Kit.codeBug();
            }
            return this.sourceString.substring(this.tokenBeg, this.tokenEnd);
        }
        if (!isMarkingComment()) {
            Kit.codeBug();
        }
        StringBuilder sb = new StringBuilder(this.commentPrefix);
        sb.append(this.sourceBuffer, this.commentCursor, getTokenLength() - this.commentPrefix.length());
        this.commentCursor = -1;
        return sb.toString();
    }

    public Token.CommentType getCommentType() {
        return this.commentType;
    }

    public int getCursor() {
        return this.cursor;
    }

    public int getFirstXMLToken() throws IOException {
        this.xmlOpenTagsCount = 0;
        this.xmlIsAttribute = false;
        this.xmlIsTagContent = false;
        if (!canUngetChar()) {
            return -1;
        }
        ungetChar(60);
        return getNextXMLToken();
    }

    public final String getLine() {
        int i;
        int i2 = this.sourceCursor;
        int i3 = this.lineEndChar;
        if (i3 >= 0) {
            i = i2 - 1;
            if (i3 == 10 && charAt(i - 1) == 13) {
                i--;
            }
        } else {
            int i4 = i2 - this.lineStart;
            while (true) {
                int charAt = charAt(this.lineStart + i4);
                if (charAt == -1 || ScriptRuntime.isJSLineTerminator(charAt)) {
                    break;
                }
                i4++;
            }
            i = i4 + this.lineStart;
        }
        return substring(this.lineStart, i);
    }

    public final String getLine(int i, int[] iArr) {
        int i2 = (this.cursor + this.ungetCursor) - i;
        int i3 = this.sourceCursor;
        if (i2 > i3) {
            return null;
        }
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            int charAt = charAt(i3 - 1);
            if (ScriptRuntime.isJSLineTerminator(charAt)) {
                if (charAt == 10 && charAt(i3 - 2) == 13) {
                    i2--;
                    i3--;
                }
                i4++;
                i5 = i3 - 1;
            }
            i2--;
            i3--;
        }
        int i6 = 0;
        while (true) {
            if (i3 <= 0) {
                i3 = 0;
                break;
            } else if (ScriptRuntime.isJSLineTerminator(charAt(i3 - 1))) {
                break;
            } else {
                i3--;
                i6++;
            }
        }
        iArr[0] = (this.lineno - i4) + (this.lineEndChar >= 0 ? 1 : 0);
        iArr[1] = i6;
        return i4 == 0 ? getLine() : substring(i3, i5);
    }

    public final int getLineno() {
        return this.lineno;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d3, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x004c, code lost:
        ungetChar(r1);
        r10.string = getStringFromBuffer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0055, code lost:
        return 146;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNextXMLToken() throws IOException {
        int i;
        this.tokenBeg = this.cursor;
        this.stringBufferTop = 0;
        while (true) {
            int i2 = getChar();
            if (i2 == -1) {
                this.tokenEnd = this.cursor;
                break;
            } else if (!this.xmlIsTagContent) {
                if (i2 == 60) {
                    addToString(i2);
                    int peekChar = peekChar();
                    if (peekChar == 33) {
                        addToString(getChar());
                        int peekChar2 = peekChar();
                        if (peekChar2 == 45) {
                            addToString(getChar());
                            int i3 = getChar();
                            if (i3 != 45) {
                                break;
                            }
                            addToString(i3);
                            if (!readXmlComment()) {
                                return -1;
                            }
                        } else if (peekChar2 == 91) {
                            addToString(getChar());
                            if (getChar() != 67 || getChar() != 68 || getChar() != 65 || getChar() != 84 || getChar() != 65 || getChar() != 91) {
                                break;
                            }
                            addToString(67);
                            addToString(68);
                            addToString(65);
                            addToString(84);
                            addToString(65);
                            addToString(91);
                            if (!readCDATA()) {
                                return -1;
                            }
                        } else if (!readEntity()) {
                            return -1;
                        }
                    } else {
                        if (peekChar == 47) {
                            addToString(getChar());
                            int i4 = this.xmlOpenTagsCount;
                            if (i4 == 0) {
                                break;
                            }
                            this.xmlIsTagContent = true;
                            i = i4 - 1;
                        } else if (peekChar != 63) {
                            this.xmlIsTagContent = true;
                            i = this.xmlOpenTagsCount + 1;
                        } else {
                            addToString(getChar());
                            if (!readPI()) {
                                return -1;
                            }
                        }
                        this.xmlOpenTagsCount = i;
                    }
                } else if (i2 == 123) {
                    break;
                } else {
                    addToString(i2);
                }
            } else {
                if (i2 == 9 || i2 == 10 || i2 == 13 || i2 == 32) {
                    addToString(i2);
                } else if (i2 == 34 || i2 == 39) {
                    addToString(i2);
                    if (!readQuotedString(i2)) {
                        return -1;
                    }
                } else if (i2 == 47) {
                    addToString(i2);
                    if (peekChar() == 62) {
                        addToString(getChar());
                        this.xmlIsTagContent = false;
                        this.xmlOpenTagsCount--;
                    }
                } else if (i2 == 123) {
                    break;
                } else {
                    addToString(i2);
                    if (i2 != 61) {
                        if (i2 == 62) {
                            this.xmlIsTagContent = false;
                        }
                        this.xmlIsAttribute = false;
                    } else {
                        this.xmlIsAttribute = true;
                    }
                }
                if (!this.xmlIsTagContent && this.xmlOpenTagsCount == 0) {
                    this.string = getStringFromBuffer();
                    return 149;
                }
            }
        }
    }

    public final double getNumber() {
        return this.number;
    }

    public final int getOffset() {
        int i = this.sourceCursor - this.lineStart;
        return this.lineEndChar >= 0 ? i - 1 : i;
    }

    public final char getQuoteChar() {
        return (char) this.quoteChar;
    }

    public final String getSourceString() {
        return this.sourceString;
    }

    public final String getString() {
        return this.string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bd, code lost:
        if (r1 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bf, code lost:
        r1 = stringToKeyword(r2, r16.parser.compilerEnv.getLanguageVersion(), r16.parser.inUseStrictDirective());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
        if (r1 == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d5, code lost:
        if (r1 == 154) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d9, code lost:
        if (r1 != 73) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f4, code lost:
        r16.string = (java.lang.String) r16.allStrings.intern(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0100, code lost:
        if (r1 == 128) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0102, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x010d, code lost:
        if (r16.parser.compilerEnv.getLanguageVersion() < 200) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010f, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0118, code lost:
        if (r16.parser.compilerEnv.isReservedKeywordAsIdentifier() != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x011a, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e5, code lost:
        if (r16.parser.compilerEnv.getLanguageVersion() >= 170) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e9, code lost:
        if (r1 != 154) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00eb, code lost:
        r1 = "let";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f0, code lost:
        r16.string = r1;
        r1 = 39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ee, code lost:
        r1 = "yield";
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0133, code lost:
        r16.string = (java.lang.String) r16.allStrings.intern(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013d, code lost:
        return 39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012d, code lost:
        if (isKeyword(r2, r16.parser.compilerEnv.getLanguageVersion(), r16.parser.inUseStrictDirective()) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x012f, code lost:
        r2 = convertLastCharToHex(r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0295 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x053d A[LOOP:8: B:402:0x053d->B:403:0x0548, LOOP_START, PHI: r1 
      PHI: (r1v27 int) = (r1v11 int), (r1v28 int) binds: [B:401:0x053b, B:403:0x0548] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:405:0x054a A[PHI: r1 
      PHI: (r1v19 int) = (r1v11 int), (r1v28 int) binds: [B:401:0x053b, B:404:0x054a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0577 A[LOOP:9: B:417:0x0577->B:418:0x0582, LOOP_START, PHI: r1 
      PHI: (r1v23 int) = (r1v22 int), (r1v24 int) binds: [B:414:0x056d, B:418:0x0582] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:432:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:206:0x02a4 -> B:200:0x0288). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:212:0x028e -> B:201:0x028f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getToken() throws IOException {
        int i;
        boolean z;
        boolean isJavaIdentifierStart;
        boolean z2;
        int i2;
        boolean z3;
        String stringFromBuffer;
        double stringPrefixToNumber;
        int i3;
        int i4;
        int i5;
        boolean z4;
        int i6;
        do {
            i = getChar();
            if (i == -1) {
                int i7 = this.cursor;
                this.tokenBeg = i7 - 1;
                this.tokenEnd = i7;
                return 0;
            }
            z = true;
            if (i == 10) {
                this.dirtyLine = false;
                int i8 = this.cursor;
                this.tokenBeg = i8 - 1;
                this.tokenEnd = i8;
                return 1;
            }
        } while (isJSSpace(i));
        if (i != 45) {
            this.dirtyLine = true;
        }
        int i9 = this.cursor;
        this.tokenBeg = i9 - 1;
        this.tokenEnd = i9;
        if (i == 64) {
            return 148;
        }
        if (i == 92) {
            i = getChar();
            if (i == 117) {
                this.stringBufferTop = 0;
                isJavaIdentifierStart = true;
                z2 = true;
                if (isJavaIdentifierStart) {
                    if (isDigit(i) || (i == 46 && isDigit(peekChar()))) {
                        this.stringBufferTop = 0;
                        this.isBinary = false;
                        this.isOctal = false;
                        this.isOldOctal = false;
                        this.isHex = false;
                        boolean z5 = this.parser.compilerEnv.getLanguageVersion() >= 200;
                        if (i == 48) {
                            i = getChar();
                            if (i == 120 || i == 88) {
                                this.isHex = true;
                                i = getChar();
                                i2 = 16;
                            } else {
                                if (z5 && (i == 111 || i == 79)) {
                                    this.isOctal = true;
                                    i = getChar();
                                } else if (z5 && (i == 98 || i == 66)) {
                                    this.isBinary = true;
                                    i = getChar();
                                    i2 = 2;
                                } else if (isDigit(i)) {
                                    this.isOldOctal = true;
                                } else {
                                    addToString(48);
                                }
                                i2 = 8;
                            }
                            if (i2 != 16) {
                                z3 = true;
                                while (Kit.xDigitToInt(i, 0) >= 0) {
                                    addToString(i);
                                    i = getChar();
                                    z3 = false;
                                }
                            } else {
                                z3 = true;
                                while (48 <= i && i <= 57) {
                                    if (i2 != 8 || i < 56) {
                                        if (i2 == 2 && i >= 50) {
                                            this.parser.addError("msg.caught.nfe");
                                            return -1;
                                        }
                                    } else if (!this.isOldOctal) {
                                        this.parser.addError("msg.caught.nfe");
                                        return -1;
                                    } else {
                                        this.parser.addWarning("msg.bad.octal.literal", i == 56 ? "8" : "9");
                                        i2 = 10;
                                    }
                                    addToString(i);
                                    i = getChar();
                                    z3 = false;
                                }
                            }
                            if (!z3 && (this.isBinary || this.isOctal || this.isHex)) {
                                this.parser.addError("msg.caught.nfe");
                                return -1;
                            }
                            if (i2 == 10 && (i == 46 || i == 101 || i == 69)) {
                                if (i != 46) {
                                    do {
                                        addToString(i);
                                        i = getChar();
                                    } while (isDigit(i));
                                    if (i != 101 || i == 69) {
                                        addToString(i);
                                        i = getChar();
                                        if (i != 43 || i == 45) {
                                            addToString(i);
                                            i = getChar();
                                        }
                                        if (isDigit(i)) {
                                            this.parser.addError("msg.missing.exponent");
                                            return -1;
                                        }
                                        do {
                                            addToString(i);
                                            i = getChar();
                                        } while (isDigit(i));
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                } else {
                                    if (i != 101) {
                                    }
                                    addToString(i);
                                    i = getChar();
                                    if (i != 43) {
                                    }
                                    addToString(i);
                                    i = getChar();
                                    if (isDigit(i)) {
                                    }
                                }
                            }
                            ungetChar(i);
                            stringFromBuffer = getStringFromBuffer();
                            this.string = stringFromBuffer;
                            if (i2 == 10 || z) {
                                stringPrefixToNumber = ScriptRuntime.stringPrefixToNumber(stringFromBuffer, 0, i2);
                            } else {
                                try {
                                    stringPrefixToNumber = Double.parseDouble(stringFromBuffer);
                                } catch (NumberFormatException unused) {
                                    this.parser.addError("msg.caught.nfe");
                                    return -1;
                                }
                            }
                            this.number = stringPrefixToNumber;
                            return 40;
                        }
                        i2 = 10;
                        if (i2 != 16) {
                        }
                        if (!z3) {
                        }
                        if (i2 == 10) {
                            if (i != 46) {
                            }
                        }
                        ungetChar(i);
                        stringFromBuffer = getStringFromBuffer();
                        this.string = stringFromBuffer;
                        if (i2 == 10) {
                        }
                        stringPrefixToNumber = ScriptRuntime.stringPrefixToNumber(stringFromBuffer, 0, i2);
                        this.number = stringPrefixToNumber;
                        return 40;
                    } else if (i == 34 || i == 39 || i == 96) {
                        this.quoteChar = i;
                        this.stringBufferTop = 0;
                        while (true) {
                            i3 = getChar(false);
                            while (i3 != this.quoteChar) {
                                if (i3 != 10 && i3 != -1) {
                                    if (i3 == 92) {
                                        i3 = getChar();
                                        if (i3 != 10) {
                                            if (i3 == 98) {
                                                i3 = 8;
                                            } else if (i3 == 102) {
                                                i3 = 12;
                                            } else if (i3 == 110) {
                                                i3 = 10;
                                            } else if (i3 == 114) {
                                                i3 = 13;
                                            } else if (i3 != 120) {
                                                switch (i3) {
                                                    case 116:
                                                        i3 = 9;
                                                        break;
                                                    case 117:
                                                        int i10 = this.stringBufferTop;
                                                        addToString(117);
                                                        i4 = 0;
                                                        for (int i11 = 0; i11 != 4; i11++) {
                                                            int i12 = getChar();
                                                            i4 = Kit.xDigitToInt(i12, i4);
                                                            if (i4 < 0) {
                                                                i3 = i12;
                                                                break;
                                                            } else {
                                                                addToString(i12);
                                                            }
                                                        }
                                                        this.stringBufferTop = i10;
                                                        i3 = i4;
                                                        break;
                                                    case 118:
                                                        i3 = 11;
                                                        break;
                                                    default:
                                                        if (48 <= i3 && i3 < 56) {
                                                            i3 -= 48;
                                                            int i13 = getChar();
                                                            if (48 <= i13 && i13 < 56) {
                                                                i3 = ((i3 * 8) + i13) - 48;
                                                                i13 = getChar();
                                                                if (48 <= i13 && i13 < 56 && i3 <= 31) {
                                                                    i3 = ((i3 * 8) + i13) - 48;
                                                                    i13 = getChar();
                                                                }
                                                            }
                                                            ungetChar(i13);
                                                            break;
                                                        }
                                                        break;
                                                }
                                            } else {
                                                i3 = getChar();
                                                int xDigitToInt = Kit.xDigitToInt(i3, 0);
                                                if (xDigitToInt < 0) {
                                                    addToString(120);
                                                } else {
                                                    int i14 = getChar();
                                                    i4 = Kit.xDigitToInt(i14, xDigitToInt);
                                                    if (i4 < 0) {
                                                        addToString(120);
                                                        addToString(i3);
                                                        i3 = i14;
                                                    } else {
                                                        i3 = i4;
                                                    }
                                                }
                                            }
                                            addToString(i3);
                                        } else {
                                            i3 = getChar();
                                        }
                                    }
                                    addToString(i3);
                                }
                            }
                            this.string = (String) this.allStrings.intern(getStringFromBuffer());
                            return 41;
                        }
                        ungetChar(i3);
                        this.tokenEnd = this.cursor;
                        this.parser.addError("msg.unterminated.string.lit");
                        return -1;
                    } else if (i == 33) {
                        if (!matchChar(61)) {
                            return 26;
                        }
                        return matchChar(61) ? 47 : 13;
                    } else if (i == 91) {
                        return 84;
                    } else {
                        if (i == 37) {
                            return matchChar(61) ? 102 : 25;
                        } else if (i == 38) {
                            if (matchChar(38)) {
                                return 106;
                            }
                            return matchChar(61) ? 94 : 11;
                        } else if (i == 93) {
                            return 85;
                        } else {
                            if (i == 94) {
                                return matchChar(61) ? 93 : 10;
                            }
                            switch (i) {
                                case 40:
                                    return 88;
                                case 41:
                                    return 89;
                                case 42:
                                    return matchChar(61) ? 100 : 23;
                                case 43:
                                    if (matchChar(61)) {
                                        return 98;
                                    }
                                    return matchChar(43) ? 107 : 21;
                                case 44:
                                    return 90;
                                case 45:
                                    if (matchChar(61)) {
                                        i5 = 99;
                                    } else if (!matchChar(45)) {
                                        i5 = 22;
                                    } else if (!this.dirtyLine && matchChar(62)) {
                                        markCommentStart(MultiPartWriter.__DASHDASH);
                                        skipLine();
                                        this.commentType = Token.CommentType.HTML;
                                        return 162;
                                    } else {
                                        i5 = 108;
                                    }
                                    this.dirtyLine = true;
                                    return i5;
                                case 46:
                                    if (matchChar(46)) {
                                        return 144;
                                    }
                                    return matchChar(40) ? 147 : 109;
                                case 47:
                                    markCommentStart();
                                    if (matchChar(47)) {
                                        this.tokenBeg = this.cursor - 2;
                                        skipLine();
                                        this.commentType = Token.CommentType.LINE;
                                        return 162;
                                    } else if (!matchChar(42)) {
                                        return matchChar(61) ? 101 : 24;
                                    } else {
                                        this.tokenBeg = this.cursor - 2;
                                        if (!matchChar(42)) {
                                            this.commentType = Token.CommentType.BLOCK_COMMENT;
                                            z4 = false;
                                            do {
                                                i6 = getChar();
                                                if (i6 == -1) {
                                                }
                                            } while (!z4);
                                            this.tokenEnd = this.cursor;
                                            return 162;
                                        }
                                        this.commentType = Token.CommentType.JSDOC;
                                        z4 = true;
                                        do {
                                            i6 = getChar();
                                            if (i6 == -1) {
                                                if (i6 == 42) {
                                                    z4 = true;
                                                    i6 = getChar();
                                                    if (i6 == -1) {
                                                    }
                                                } else if (i6 != 47) {
                                                    this.tokenEnd = this.cursor;
                                                    z4 = false;
                                                    i6 = getChar();
                                                    if (i6 == -1) {
                                                        this.tokenEnd = this.cursor - 1;
                                                        this.parser.addError("msg.unterminated.comment");
                                                        return 162;
                                                    }
                                                }
                                            }
                                        } while (!z4);
                                        this.tokenEnd = this.cursor;
                                        return 162;
                                    }
                                default:
                                    switch (i) {
                                        case 58:
                                            return matchChar(58) ? 145 : 104;
                                        case 59:
                                            return 83;
                                        case 60:
                                            if (matchChar(33)) {
                                                if (matchChar(45)) {
                                                    if (matchChar(45)) {
                                                        this.tokenBeg = this.cursor - 4;
                                                        skipLine();
                                                        this.commentType = Token.CommentType.HTML;
                                                        return 162;
                                                    }
                                                    ungetCharIgnoreLineEnd(45);
                                                }
                                                ungetCharIgnoreLineEnd(33);
                                            }
                                            return matchChar(60) ? matchChar(61) ? 95 : 18 : matchChar(61) ? 15 : 14;
                                        case 61:
                                            return matchChar(61) ? matchChar(61) ? 46 : 12 : matchChar(62) ? 165 : 91;
                                        case 62:
                                            return matchChar(62) ? matchChar(62) ? matchChar(61) ? 97 : 20 : matchChar(61) ? 96 : 19 : matchChar(61) ? 17 : 16;
                                        case 63:
                                            return 103;
                                        default:
                                            switch (i) {
                                                case 123:
                                                    return 86;
                                                case 124:
                                                    if (matchChar(124)) {
                                                        return 105;
                                                    }
                                                    return matchChar(61) ? 92 : 9;
                                                case 125:
                                                    return 87;
                                                case 126:
                                                    return 27;
                                                default:
                                                    this.parser.addError("msg.illegal.character", i);
                                                    return -1;
                                            }
                                    }
                            }
                        }
                    }
                }
                boolean z6 = z2;
                while (true) {
                    if (!z2) {
                        int i15 = getChar();
                        if (i15 == 92) {
                            int i16 = getChar();
                            if (i16 != 117) {
                                this.parser.addError("msg.illegal.character", i16);
                                return -1;
                            }
                            z6 = true;
                            z2 = true;
                        } else if (i15 == -1 || i15 == 65279 || !Character.isJavaIdentifierPart((char) i15)) {
                            break;
                        } else {
                            addToString(i15);
                        }
                    } else {
                        int i17 = 0;
                        for (int i18 = 0; i18 != 4; i18++) {
                            i17 = Kit.xDigitToInt(getChar(), i17);
                            if (i17 < 0) {
                                break;
                            }
                        }
                        if (i17 < 0) {
                            this.parser.addError("msg.invalid.escape");
                            return -1;
                        }
                        addToString(i17);
                        z2 = false;
                    }
                }
            } else {
                ungetChar(i);
                i = 92;
                isJavaIdentifierStart = false;
            }
        } else {
            isJavaIdentifierStart = Character.isJavaIdentifierStart((char) i);
            if (isJavaIdentifierStart) {
                this.stringBufferTop = 0;
                addToString(i);
            }
        }
        z2 = false;
        if (isJavaIdentifierStart) {
        }
    }

    public int getTokenBeg() {
        return this.tokenBeg;
    }

    public int getTokenEnd() {
        return this.tokenEnd;
    }

    public int getTokenLength() {
        return this.tokenEnd - this.tokenBeg;
    }

    public final boolean isNumberBinary() {
        return this.isBinary;
    }

    public final boolean isNumberHex() {
        return this.isHex;
    }

    public final boolean isNumberOctal() {
        return this.isOctal;
    }

    public final boolean isNumberOldOctal() {
        return this.isOldOctal;
    }

    public boolean isXMLAttribute() {
        return this.xmlIsAttribute;
    }

    public String readAndClearRegExpFlags() {
        String str = this.regExpFlags;
        this.regExpFlags = null;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x009e, code lost:
        ungetChar(r2);
        r5.tokenEnd = r5.cursor - 1;
        r5.string = new java.lang.String(r5.stringBuffer, 0, r5.stringBufferTop);
        r5.parser.reportError("msg.unterminated.re.lit");
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b8, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void readRegExp(int i) throws IOException {
        int i2 = this.tokenBeg;
        this.stringBufferTop = 0;
        if (i == 101) {
            addToString(61);
        } else if (i != 24) {
            Kit.codeBug();
        }
        boolean z = false;
        while (true) {
            int i3 = getChar();
            if (i3 == 47 && !z) {
                int i4 = this.stringBufferTop;
                while (true) {
                    int i5 = 103;
                    if (!matchChar(103)) {
                        i5 = 105;
                        if (!matchChar(105)) {
                            i5 = 109;
                            if (!matchChar(109)) {
                                i5 = 121;
                                if (!matchChar(121)) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                    addToString(i5);
                }
                this.tokenEnd = i2 + this.stringBufferTop + 2;
                if (isAlpha(peekChar())) {
                    this.parser.reportError("msg.invalid.re.flag");
                }
                this.string = new String(this.stringBuffer, 0, i4);
                this.regExpFlags = new String(this.stringBuffer, i4, this.stringBufferTop - i4);
                return;
            } else if (i3 == 10 || i3 == -1) {
                break;
            } else {
                if (i3 == 92) {
                    addToString(i3);
                    i3 = getChar();
                } else if (i3 == 91) {
                    z = true;
                } else if (i3 == 93) {
                    z = false;
                }
                addToString(i3);
            }
        }
    }

    public String tokenToString(int i) {
        return "";
    }
}

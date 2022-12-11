package org.jsoup.nodes;

import java.io.IOException;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.util.B64Code;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.CharacterReader;
import org.jsoup.parser.Parser;

/* loaded from: classes5.dex */
public class Entities {
    public static final int codepointRadix = 36;
    public static final int empty = -1;
    public static final String emptyName = "";
    public static final char[] codeDelims = {',', BasicHeaderValueParser.PARAM_DELIMITER};
    public static final HashMap<String, String> multipoints = new HashMap<>();
    public static final Document.OutputSettings DefaultOutput = new Document.OutputSettings();

    /* renamed from: org.jsoup.nodes.Entities$1 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C31401 {
        public static final /* synthetic */ int[] $SwitchMap$org$jsoup$nodes$Entities$CoreCharset;

        static {
            int[] iArr = new int[CoreCharset.values().length];
            $SwitchMap$org$jsoup$nodes$Entities$CoreCharset = iArr;
            try {
                CoreCharset coreCharset = CoreCharset.ascii;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$org$jsoup$nodes$Entities$CoreCharset;
                CoreCharset coreCharset2 = CoreCharset.utf;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum CoreCharset {
        ascii,
        utf,
        fallback;

        public static CoreCharset byName(String str) {
            return str.equals("US-ASCII") ? ascii : str.startsWith("UTF-") ? utf : fallback;
        }
    }

    /* loaded from: classes5.dex */
    public enum EscapeMode {
        xhtml(EntitiesData.xmlPoints, 4),
        base(EntitiesData.basePoints, 106),
        extended(EntitiesData.fullPoints, 2125);
        
        public int[] codeKeys;
        public int[] codeVals;
        public String[] nameKeys;
        public String[] nameVals;

        EscapeMode(String str, int i) {
            Entities.load(this, str, i);
        }

        private int size() {
            return this.nameKeys.length;
        }

        public int codepointForName(String str) {
            int binarySearch = Arrays.binarySearch(this.nameKeys, str);
            if (binarySearch >= 0) {
                return this.codeVals[binarySearch];
            }
            return -1;
        }

        public String nameForCodepoint(int i) {
            int binarySearch = Arrays.binarySearch(this.codeKeys, i);
            if (binarySearch >= 0) {
                String[] strArr = this.nameVals;
                if (binarySearch < strArr.length - 1) {
                    int i2 = binarySearch + 1;
                    if (this.codeKeys[i2] == i) {
                        return strArr[i2];
                    }
                }
                return this.nameVals[binarySearch];
            }
            return "";
        }
    }

    public static void appendEncoded(Appendable appendable, EscapeMode escapeMode, int i) throws IOException {
        Appendable append;
        String nameForCodepoint = escapeMode.nameForCodepoint(i);
        if (!"".equals(nameForCodepoint)) {
            append = appendable.append('&');
        } else {
            append = appendable.append("&#x");
            nameForCodepoint = Integer.toHexString(i);
        }
        append.append(nameForCodepoint).append(BasicHeaderValueParser.PARAM_DELIMITER);
    }

    public static boolean canEncode(CoreCharset coreCharset, char c, CharsetEncoder charsetEncoder) {
        int ordinal = coreCharset.ordinal();
        if (ordinal == 0) {
            return c < 128;
        } else if (ordinal == 1) {
            return true;
        } else {
            return charsetEncoder.canEncode(c);
        }
    }

    public static int codepointsForName(String str, int[] iArr) {
        String str2 = multipoints.get(str);
        if (str2 != null) {
            iArr[0] = str2.codePointAt(0);
            iArr[1] = str2.codePointAt(1);
            return 2;
        }
        int codepointForName = EscapeMode.extended.codepointForName(str);
        if (codepointForName == -1) {
            return 0;
        }
        iArr[0] = codepointForName;
        return 1;
    }

    public static String escape(String str) {
        return escape(str, DefaultOutput);
    }

    public static String escape(String str, Document.OutputSettings outputSettings) {
        if (str == null) {
            return "";
        }
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        try {
            escape(borrowBuilder, str, outputSettings, false, false, false);
            return StringUtil.releaseBuilder(borrowBuilder);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
        if (canEncode(r12, r8, r1) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
        appendEncoded(r10, r0, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
        if (r1.canEncode(r8) != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void escape(Appendable appendable, String str, Document.OutputSettings outputSettings, boolean z, boolean z2, boolean z3) throws IOException {
        String str2;
        EscapeMode escapeMode = outputSettings.escapeMode();
        CharsetEncoder encoder = outputSettings.encoder();
        CoreCharset coreCharset = outputSettings.coreCharset;
        int length = str.length();
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (z2) {
                if (StringUtil.isWhitespace(codePointAt)) {
                    if ((!z3 || z4) && !z5) {
                        appendable.append(TokenParser.f4579SP);
                        z5 = true;
                    }
                    i += Character.charCount(codePointAt);
                } else {
                    z4 = true;
                    z5 = false;
                }
            }
            if (codePointAt < 65536) {
                char c = (char) codePointAt;
                if (c != '\"') {
                    if (c == '&') {
                        str2 = "&amp;";
                    } else if (c == '<') {
                        if (!z || escapeMode == EscapeMode.xhtml) {
                            str2 = "&lt;";
                        }
                        appendable.append(c);
                    } else if (c == '>') {
                        if (!z) {
                            str2 = "&gt;";
                        }
                        appendable.append(c);
                    } else if (c == 160) {
                        str2 = escapeMode != EscapeMode.xhtml ? "&nbsp;" : "&#xa0;";
                    }
                    appendable.append(str2);
                } else {
                    if (z) {
                        str2 = "&quot;";
                        appendable.append(str2);
                    }
                    appendable.append(c);
                }
            } else {
                str2 = new String(Character.toChars(codePointAt));
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static String getByName(String str) {
        String str2 = multipoints.get(str);
        if (str2 != null) {
            return str2;
        }
        int codepointForName = EscapeMode.extended.codepointForName(str);
        return codepointForName != -1 ? new String(new int[]{codepointForName}, 0, 1) : "";
    }

    public static boolean isBaseNamedEntity(String str) {
        return EscapeMode.base.codepointForName(str) != -1;
    }

    public static boolean isNamedEntity(String str) {
        return EscapeMode.extended.codepointForName(str) != -1;
    }

    public static void load(EscapeMode escapeMode, String str, int i) {
        int i2;
        escapeMode.nameKeys = new String[i];
        escapeMode.codeVals = new int[i];
        escapeMode.codeKeys = new int[i];
        escapeMode.nameVals = new String[i];
        CharacterReader characterReader = new CharacterReader(str);
        boolean z = false;
        int i3 = 0;
        while (!characterReader.isEmpty()) {
            String consumeTo = characterReader.consumeTo(B64Code.__pad);
            characterReader.advance();
            int parseInt = Integer.parseInt(characterReader.consumeToAny(codeDelims), 36);
            char current = characterReader.current();
            characterReader.advance();
            if (current == ',') {
                i2 = Integer.parseInt(characterReader.consumeTo(BasicHeaderValueParser.PARAM_DELIMITER), 36);
                characterReader.advance();
            } else {
                i2 = -1;
            }
            int parseInt2 = Integer.parseInt(characterReader.consumeTo('&'), 36);
            characterReader.advance();
            escapeMode.nameKeys[i3] = consumeTo;
            escapeMode.codeVals[i3] = parseInt;
            escapeMode.codeKeys[parseInt2] = parseInt;
            escapeMode.nameVals[parseInt2] = consumeTo;
            if (i2 != -1) {
                multipoints.put(consumeTo, new String(new int[]{parseInt, i2}, 0, 2));
            }
            i3++;
        }
        if (i3 == i) {
            z = true;
        }
        Validate.isTrue(z, "Unexpected count of entities loaded");
    }

    public static String unescape(String str) {
        return unescape(str, false);
    }

    public static String unescape(String str, boolean z) {
        return Parser.unescapeEntities(str, z);
    }
}

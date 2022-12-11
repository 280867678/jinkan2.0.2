package org.apache.commons.lang3.text;

import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import me.tvspark.outline;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes4.dex */
public class ExtendedMessageFormat extends MessageFormat {
    public static final String DUMMY_PATTERN = "";
    public static final char END_FE = '}';
    public static final String ESCAPED_QUOTE = "''";
    public static final int HASH_SEED = 31;
    public static final char QUOTE = '\'';
    public static final char START_FE = '{';
    public static final char START_FMT = ',';
    public static final long serialVersionUID = -2362048321261811743L;
    public final Map<String, ? extends FormatFactory> registry;
    public String toPattern;

    public ExtendedMessageFormat(String str) {
        this(str, Locale.getDefault());
    }

    public ExtendedMessageFormat(String str, Locale locale) {
        this(str, locale, null);
    }

    public ExtendedMessageFormat(String str, Locale locale, Map<String, ? extends FormatFactory> map) {
        super("");
        setLocale(locale);
        this.registry = map;
        applyPattern(str);
    }

    public ExtendedMessageFormat(String str, Map<String, ? extends FormatFactory> map) {
        this(str, Locale.getDefault(), map);
    }

    private StringBuilder appendQuotedString(String str, ParsePosition parsePosition, StringBuilder sb, boolean z) {
        int index = parsePosition.getIndex();
        char[] charArray = str.toCharArray();
        if (z && charArray[index] == '\'') {
            next(parsePosition);
            if (sb == null) {
                return null;
            }
            sb.append(QUOTE);
            return sb;
        }
        int i = index;
        for (int index2 = parsePosition.getIndex(); index2 < str.length(); index2++) {
            if (!z || !str.substring(index2).startsWith(ESCAPED_QUOTE)) {
                char c = charArray[parsePosition.getIndex()];
                next(parsePosition);
                if (c == '\'') {
                    if (sb == null) {
                        return null;
                    }
                    sb.append(charArray, i, parsePosition.getIndex() - i);
                    return sb;
                }
            } else {
                sb.append(charArray, i, parsePosition.getIndex() - i);
                sb.append(QUOTE);
                parsePosition.setIndex(index2 + 2);
                i = parsePosition.getIndex();
            }
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unterminated quoted string at position ", index));
    }

    private boolean containsElements(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Format getFormat(String str) {
        String str2;
        if (this.registry != null) {
            int indexOf = str.indexOf(44);
            if (indexOf > 0) {
                String trim = str.substring(0, indexOf).trim();
                str2 = str.substring(indexOf + 1).trim();
                str = trim;
            } else {
                str2 = null;
            }
            FormatFactory formatFactory = this.registry.get(str);
            if (formatFactory != null) {
                return formatFactory.getFormat(str, str2, getLocale());
            }
        }
        return null;
    }

    private void getQuotedString(String str, ParsePosition parsePosition, boolean z) {
        appendQuotedString(str, parsePosition, null, z);
    }

    private String insertFormats(String str, ArrayList<String> arrayList) {
        String str2;
        if (!containsElements(arrayList)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() * 2);
        ParsePosition parsePosition = new ParsePosition(0);
        int i = -1;
        int i2 = 0;
        while (parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (charAt == '\'') {
                appendQuotedString(str, parsePosition, sb, false);
            } else if (charAt != '{') {
                if (charAt == '}') {
                    i2--;
                }
                sb.append(charAt);
                next(parsePosition);
            } else {
                i2++;
                sb.append('{');
                sb.append(readArgumentIndex(str, next(parsePosition)));
                if (i2 == 1 && (str2 = arrayList.get((i = i + 1))) != null) {
                    sb.append(',');
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }

    private ParsePosition next(ParsePosition parsePosition) {
        parsePosition.setIndex(parsePosition.getIndex() + 1);
        return parsePosition;
    }

    private String parseFormatDescription(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        seekNonWs(str, parsePosition);
        int index2 = parsePosition.getIndex();
        int i = 1;
        while (parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (charAt == '\'') {
                getQuotedString(str, parsePosition, false);
            } else if (charAt == '{') {
                i++;
            } else if (charAt == '}' && i - 1 == 0) {
                return str.substring(index2, parsePosition.getIndex());
            }
            next(parsePosition);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unterminated format element at position ", index));
    }

    private int readArgumentIndex(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        seekNonWs(str, parsePosition);
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (!z && parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (Character.isWhitespace(charAt)) {
                seekNonWs(str, parsePosition);
                charAt = str.charAt(parsePosition.getIndex());
                if (charAt != ',' && charAt != '}') {
                    z = true;
                    next(parsePosition);
                }
            }
            if ((charAt == ',' || charAt == '}') && sb.length() > 0) {
                try {
                    return Integer.parseInt(sb.toString());
                } catch (NumberFormatException unused) {
                }
            }
            sb.append(charAt);
            z = !Character.isDigit(charAt);
            next(parsePosition);
        }
        if (z) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid format argument index at position ", index, ": ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str.substring(index, parsePosition.getIndex()));
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unterminated format element at position ", index));
    }

    private void seekNonWs(String str, ParsePosition parsePosition) {
        char[] charArray = str.toCharArray();
        do {
            int isMatch = StrMatcher.splitMatcher().isMatch(charArray, parsePosition.getIndex());
            parsePosition.setIndex(parsePosition.getIndex() + isMatch);
            if (isMatch <= 0) {
                return;
            }
        } while (parsePosition.getIndex() < str.length());
    }

    @Override // java.text.MessageFormat
    public final void applyPattern(String str) {
        String str2;
        Format format;
        if (this.registry == null) {
            super.applyPattern(str);
            this.toPattern = super.toPattern();
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder(str.length());
        int i = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        char[] charArray = str.toCharArray();
        int i2 = 0;
        while (parsePosition.getIndex() < str.length()) {
            char c = charArray[parsePosition.getIndex()];
            boolean z = true;
            if (c != '\'') {
                if (c == '{') {
                    i2++;
                    seekNonWs(str, parsePosition);
                    int index = parsePosition.getIndex();
                    int readArgumentIndex = readArgumentIndex(str, next(parsePosition));
                    sb.append('{');
                    sb.append(readArgumentIndex);
                    seekNonWs(str, parsePosition);
                    String str3 = null;
                    if (charArray[parsePosition.getIndex()] == ',') {
                        str2 = parseFormatDescription(str, next(parsePosition));
                        format = getFormat(str2);
                        if (format == null) {
                            sb.append(',');
                            sb.append(str2);
                        }
                    } else {
                        str2 = null;
                        format = null;
                    }
                    arrayList.add(format);
                    if (format != null) {
                        str3 = str2;
                    }
                    arrayList2.add(str3);
                    Validate.isTrue(arrayList.size() == i2);
                    if (arrayList2.size() != i2) {
                        z = false;
                    }
                    Validate.isTrue(z);
                    if (charArray[parsePosition.getIndex()] != '}') {
                        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unreadable format element at position ", index));
                    }
                }
                sb.append(charArray[parsePosition.getIndex()]);
                next(parsePosition);
            } else {
                appendQuotedString(str, parsePosition, sb, true);
            }
        }
        super.applyPattern(sb.toString());
        this.toPattern = insertFormats(super.toPattern(), arrayList2);
        if (!containsElements(arrayList)) {
            return;
        }
        Format[] formats = getFormats();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Format format2 = (Format) it.next();
            if (format2 != null) {
                formats[i] = format2;
            }
            i++;
        }
        super.setFormats(formats);
    }

    @Override // java.text.MessageFormat
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !super.equals(obj) || ObjectUtils.notEqual(ExtendedMessageFormat.class, obj.getClass())) {
            return false;
        }
        ExtendedMessageFormat extendedMessageFormat = (ExtendedMessageFormat) obj;
        return !ObjectUtils.notEqual(this.toPattern, extendedMessageFormat.toPattern) && !ObjectUtils.notEqual(this.registry, extendedMessageFormat.registry);
    }

    @Override // java.text.MessageFormat
    public int hashCode() {
        int hashCode = ObjectUtils.hashCode(this.registry);
        return ObjectUtils.hashCode(this.toPattern) + ((hashCode + (super.hashCode() * 31)) * 31);
    }

    @Override // java.text.MessageFormat
    public void setFormat(int i, Format format) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public void setFormatByArgumentIndex(int i, Format format) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public void setFormats(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public void setFormatsByArgumentIndex(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public String toPattern() {
        return this.toPattern;
    }
}

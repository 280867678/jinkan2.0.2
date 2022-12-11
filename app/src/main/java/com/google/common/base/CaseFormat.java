package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2123ft;
import me.tvspark.Illllllllllllllllllllllllllll;
import org.apache.http.message.TokenParser;

/* loaded from: classes3.dex */
public enum CaseFormat {
    LOWER_HYPHEN(new AbstractC2123ft.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('-'), "-") { // from class: com.google.common.base.CaseFormat.1
        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            return caseFormat == CaseFormat.LOWER_UNDERSCORE ? str.replace('-', '_') : caseFormat == CaseFormat.UPPER_UNDERSCORE ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str.replace('-', '_')) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }
    },
    LOWER_UNDERSCORE(new AbstractC2123ft.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('_'), "_") { // from class: com.google.common.base.CaseFormat.2
        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            return caseFormat == CaseFormat.LOWER_HYPHEN ? str.replace('_', '-') : caseFormat == CaseFormat.UPPER_UNDERSCORE ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }
    },
    LOWER_CAMEL(new AbstractC2123ft.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.3
        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_CAMEL(new AbstractC2123ft.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.4
        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_UNDERSCORE(new AbstractC2123ft.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('_'), "_") { // from class: com.google.common.base.CaseFormat.5
        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            return caseFormat == CaseFormat.LOWER_HYPHEN ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.replace('_', '-')) : caseFormat == CaseFormat.LOWER_UNDERSCORE ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }
    };
    
    public final AbstractC2123ft wordBoundary;
    public final String wordSeparator;

    /* loaded from: classes3.dex */
    public static final class StringConverter extends Converter<String, String> implements Serializable {
        public static final long serialVersionUID = 0;
        public final CaseFormat sourceFormat;
        public final CaseFormat targetFormat;

        public StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            if (caseFormat != null) {
                this.sourceFormat = caseFormat;
                if (caseFormat2 == null) {
                    throw null;
                }
                this.targetFormat = caseFormat2;
                return;
            }
            throw null;
        }

        @Override // com.google.common.base.Converter
        public String doBackward(String str) {
            return this.targetFormat.m3934to(this.sourceFormat, str);
        }

        @Override // com.google.common.base.Converter
        public String doForward(String str) {
            return this.sourceFormat.m3934to(this.targetFormat, str);
        }

        @Override // com.google.common.base.Converter, me.tvspark.AbstractC2271jt
        public boolean equals(Object obj) {
            if (obj instanceof StringConverter) {
                StringConverter stringConverter = (StringConverter) obj;
                return this.sourceFormat.equals(stringConverter.sourceFormat) && this.targetFormat.equals(stringConverter.targetFormat);
            }
            return false;
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }
    }

    CaseFormat(AbstractC2123ft abstractC2123ft, String str) {
        this.wordBoundary = abstractC2123ft;
        this.wordSeparator = str;
    }

    public static String firstCharOnlyToUpper(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charAt)) {
            charAt = (char) (charAt ^ TokenParser.f4579SP);
        }
        sb.append(charAt);
        sb.append(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.substring(1)));
        return sb.toString();
    }

    private String normalizeFirstWord(String str) {
        return this == LOWER_CAMEL ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) : normalizeWord(str);
    }

    public String convert(CaseFormat caseFormat, String str) {
        String normalizeWord;
        int i = 0;
        StringBuilder sb = null;
        int i2 = -1;
        while (true) {
            AbstractC2123ft abstractC2123ft = this.wordBoundary;
            i2++;
            if (abstractC2123ft != null) {
                int length = str.length();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, length);
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (abstractC2123ft.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.charAt(i2))) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == -1) {
                    if (i == 0) {
                        return caseFormat.normalizeFirstWord(str);
                    }
                    sb.append(caseFormat.normalizeWord(str.substring(i)));
                    return sb.toString();
                }
                if (i == 0) {
                    sb = new StringBuilder((this.wordSeparator.length() * 4) + str.length());
                    normalizeWord = caseFormat.normalizeFirstWord(str.substring(i, i2));
                } else {
                    normalizeWord = caseFormat.normalizeWord(str.substring(i, i2));
                }
                sb.append(normalizeWord);
                sb.append(caseFormat.wordSeparator);
                i = this.wordSeparator.length() + i2;
            } else {
                throw null;
            }
        }
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }

    public abstract String normalizeWord(String str);

    /* renamed from: to */
    public final String m3934to(CaseFormat caseFormat, String str) {
        if (caseFormat != null) {
            if (str == null) {
                throw null;
            }
            return caseFormat == this ? str : convert(caseFormat, str);
        }
        throw null;
    }
}

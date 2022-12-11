package com.alibaba.fastjson;

import org.apache.http.message.TokenParser;

/* loaded from: classes3.dex */
public enum PropertyNamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase;

    /* renamed from: com.alibaba.fastjson.PropertyNamingStrategy$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C06421 {
        public static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy;

        static {
            int[] iArr = new int[PropertyNamingStrategy.values().length];
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = iArr;
            try {
                PropertyNamingStrategy propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy;
                PropertyNamingStrategy propertyNamingStrategy2 = PropertyNamingStrategy.KebabCase;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy;
                PropertyNamingStrategy propertyNamingStrategy3 = PropertyNamingStrategy.PascalCase;
                iArr3[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy;
                PropertyNamingStrategy propertyNamingStrategy4 = PropertyNamingStrategy.CamelCase;
                iArr4[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String translate(String str) {
        int ordinal = ordinal();
        int i = 0;
        if (ordinal == 0) {
            char charAt = str.charAt(0);
            if (charAt < 'A' || charAt > 'Z') {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] + TokenParser.f4579SP);
            return new String(charArray);
        } else if (ordinal == 1) {
            char charAt2 = str.charAt(0);
            if (charAt2 < 'a' || charAt2 > 'z') {
                return str;
            }
            char[] charArray2 = str.toCharArray();
            charArray2[0] = (char) (charArray2[0] - ' ');
            return new String(charArray2);
        } else if (ordinal == 2) {
            StringBuilder sb = new StringBuilder();
            while (i < str.length()) {
                char charAt3 = str.charAt(i);
                if (charAt3 >= 'A' && charAt3 <= 'Z') {
                    charAt3 = (char) (charAt3 + TokenParser.f4579SP);
                    if (i > 0) {
                        sb.append('_');
                    }
                }
                sb.append(charAt3);
                i++;
            }
            return sb.toString();
        } else if (ordinal != 3) {
            return str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            while (i < str.length()) {
                char charAt4 = str.charAt(i);
                if (charAt4 >= 'A' && charAt4 <= 'Z') {
                    charAt4 = (char) (charAt4 + TokenParser.f4579SP);
                    if (i > 0) {
                        sb2.append('-');
                    }
                }
                sb2.append(charAt4);
                i++;
            }
            return sb2.toString();
        }
    }
}

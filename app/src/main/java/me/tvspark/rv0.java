package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public class rv0 {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Appendable appendable);
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str);
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char charAt = str.charAt(0);
            if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
                return true;
            }
            for (int i = 0; i < length; i++) {
                char charAt2 = str.charAt(i);
                if ((charAt2 == '\r' || charAt2 == '\n' || charAt2 == '\t' || charAt2 == ' ') || rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charAt2)) {
                    return true;
                }
                if ((charAt2 == '\b' || charAt2 == '\f' || charAt2 == '\n') || rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charAt2)) {
                    return true;
                }
            }
            return rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char charAt = str.charAt(0);
            if (!rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charAt) && !rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charAt)) {
                for (int i = 1; i < length; i++) {
                    char charAt2 = str.charAt(i);
                    if (!(charAt2 == '}' || charAt2 == ']' || charAt2 == ',' || charAt2 == ':') && !rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charAt2)) {
                    }
                }
                if (rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
                    return true;
                }
                char charAt3 = str.charAt(0);
                if ((charAt3 >= '0' && charAt3 <= '9') || charAt3 == '-') {
                    int i2 = 1;
                    while (i2 < length) {
                        charAt3 = str.charAt(i2);
                        if (charAt3 < '0' || charAt3 > '9') {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == length) {
                        return true;
                    }
                    if (charAt3 == '.') {
                        i2++;
                    }
                    while (i2 < length) {
                        charAt3 = str.charAt(i2);
                        if (charAt3 < '0' || charAt3 > '9') {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == length) {
                        return true;
                    }
                    if (charAt3 == 'E' || charAt3 == 'e') {
                        i2++;
                        if (i2 == length) {
                            return false;
                        }
                        char charAt4 = str.charAt(i2);
                        if (charAt4 == '+' || charAt4 == '-') {
                            i2++;
                            str.charAt(i2);
                        }
                    }
                    if (i2 == length) {
                        return false;
                    }
                    while (i2 < length) {
                        char charAt5 = str.charAt(i2);
                        if (charAt5 < '0' || charAt5 > '9') {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == length) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Appendable appendable) {
            String str2;
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == '\f') {
                        str2 = "\\f";
                    } else if (charAt == '\r') {
                        str2 = "\\r";
                    } else if (charAt == '\"') {
                        str2 = "\\\"";
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                str2 = "\\b";
                                break;
                            case '\t':
                                str2 = "\\t";
                                break;
                            case '\n':
                                str2 = "\\n";
                                break;
                            default:
                                if ((charAt >= 0 && charAt <= 31) || ((charAt >= 127 && charAt <= 159) || (charAt >= 8192 && charAt <= 8447))) {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 4) & 15));
                                    charAt = "0123456789ABCDEF".charAt((charAt >> 0) & 15);
                                }
                                appendable.append(charAt);
                                continue;
                                break;
                        }
                    } else {
                        str2 = "\\\\";
                    }
                    appendable.append(str2);
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Exeption");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Appendable appendable) {
            String str2;
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == '\f') {
                        str2 = "\\f";
                    } else if (charAt == '\r') {
                        str2 = "\\r";
                    } else if (charAt == '\"') {
                        str2 = "\\\"";
                    } else if (charAt == '/') {
                        str2 = "\\/";
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                str2 = "\\b";
                                break;
                            case '\t':
                                str2 = "\\t";
                                break;
                            case '\n':
                                str2 = "\\n";
                                break;
                            default:
                                if ((charAt >= 0 && charAt <= 31) || ((charAt >= 127 && charAt <= 159) || (charAt >= 8192 && charAt <= 8447))) {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 4) & 15));
                                    charAt = "0123456789ABCDEF".charAt((charAt >> 0) & 15);
                                }
                                appendable.append(charAt);
                                continue;
                                break;
                        }
                    } else {
                        str2 = "\\\\";
                    }
                    appendable.append(str2);
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Error");
            }
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        if (c < 0 || c > 31) {
            if (c >= 127 && c <= 159) {
                return true;
            }
            return c >= 8192 && c <= 8447;
        }
        return true;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        return c == '{' || c == '[' || c == ',' || c == '}' || c == ']' || c == ':' || c == '\'' || c == '\"';
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String str2;
        if (str.length() < 3) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt == 'n') {
            str2 = "null";
        } else if (charAt == 't') {
            str2 = "true";
        } else if (charAt == 'f') {
            str2 = "false";
        } else if (charAt != 'N') {
            return false;
        } else {
            str2 = "NaN";
        }
        return str.equals(str2);
    }
}

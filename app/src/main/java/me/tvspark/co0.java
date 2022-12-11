package me.tvspark;

import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* loaded from: classes4.dex */
public class co0 {
    static {
        HashMap hashMap = new HashMap();
        char[] charArray = "零一二三四五六七八九十".toCharArray();
        for (int i = 0; i <= 10; i++) {
            hashMap.put(Character.valueOf(charArray[i]), Integer.valueOf(i));
        }
        char[] charArray2 = "〇壹贰叁肆伍陆柒捌玖拾".toCharArray();
        for (int i2 = 0; i2 <= 10; i2++) {
            hashMap.put(Character.valueOf(charArray2[i2]), Integer.valueOf(i2));
        }
        hashMap.put((char) 20004, 2);
        hashMap.put((char) 30334, 100);
        hashMap.put((char) 20336, 100);
        hashMap.put((char) 21315, 1000);
        hashMap.put((char) 20191, 1000);
        hashMap.put((char) 19975, 10000);
        hashMap.put((char) 20159, Integer.valueOf((int) FastDtoa.kTen8));
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (trim.startsWith("{") && trim.endsWith("}")) {
                return true;
            }
            if (trim.startsWith("[") && trim.endsWith("]")) {
                return true;
            }
        }
        return false;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return TextUtils.isEmpty(str) ? "" : str.endsWith("/") ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, -1, 0) : str;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        Uri parse;
        String str2 = "";
        try {
            str2 = parse.getScheme() + "://" + parse.getHost();
            int port = Uri.parse(str).getPort();
            if (port > 0) {
                str2 = str2 + ":" + port;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String str2;
        try {
            str2 = Uri.parse(str).getHost();
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll("(?i)<(br[\\s/]*|/?p[^>]*|/?div[^>]*)>", "\n").replaceAll("</?[a-zA-Z][^>]*>", "").replaceAll("\\s*\\n+\\s*", "\n\u3000\u3000").replaceAll("^[\\n\\s]+", "\u3000\u3000").replaceAll("[\\n\\s]+$", "");
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        if (str == null || str2 == null || str2.length() > str.length()) {
            return false;
        }
        return str.substring(0, str2.length()).equalsIgnoreCase(str2);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (str == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(str.length() * 2);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, false, sb, false) ? sb.toString() : str;
        } catch (IOException unused) {
            return str;
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        StringBuilder sb;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() <= 2) {
                return str;
            }
            sb = new StringBuilder();
        } else if (TextUtils.isEmpty(str2)) {
            return "网站\n书签";
        } else {
            str = str2.replace("《", "").replace("》", "").replace("(", "").replace(")", "").replace("（", "").replace("）", "").replace("|", "");
            if (str.length() <= 2) {
                return str;
            }
            sb = new StringBuilder();
        }
        sb.append(str.substring(0, 2));
        sb.append("\n");
        sb.append(str.substring(2, str.length()));
        return sb.toString();
    }

    public static <T> List<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<T> list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(list);
            return (List) new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (Exception unused) {
            return list;
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z, Appendable appendable, boolean z2) throws IOException {
        char c;
        StringBuilder sb;
        String str2;
        if (appendable != null) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            boolean z3 = false;
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt < ' ') {
                    switch (charAt) {
                        case '\b':
                            appendable.append('\\');
                            c = 'b';
                            appendable.append(c);
                            break;
                        case '\t':
                            appendable.append('\\');
                            c = 't';
                            appendable.append(c);
                            break;
                        case '\n':
                            appendable.append('\\');
                            c = 'n';
                            appendable.append(c);
                            break;
                        case 11:
                        default:
                            if (charAt > 15) {
                                sb = new StringBuilder();
                                str2 = "\\u00";
                            } else {
                                sb = new StringBuilder();
                                str2 = "\\u000";
                            }
                            sb.append(str2);
                            sb.append(Integer.toHexString(charAt).toUpperCase());
                            appendable.append(sb.toString());
                            break;
                        case '\f':
                            appendable.append('\\');
                            c = 'f';
                            appendable.append(c);
                            break;
                        case '\r':
                            appendable.append('\\');
                            c = 'r';
                            appendable.append(c);
                            break;
                    }
                } else if (z2 && charAt > 255) {
                    appendable.append(charAt > 4095 ? "\\u" : "\\u0").append(Integer.toHexString(charAt).toUpperCase());
                } else if (charAt != '\"') {
                    if (charAt == '\'' || charAt == '/') {
                        if (z) {
                            appendable.append('\\');
                            z3 = true;
                        }
                    } else if (charAt == '\\') {
                        appendable.append('\\');
                        appendable.append('\\');
                    }
                    appendable.append(charAt);
                } else {
                    appendable.append('\\');
                    appendable.append('\"');
                }
                z3 = true;
            }
            return z3;
        }
        throw new IllegalArgumentException("The Appendable must not be null");
    }
}

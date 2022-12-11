package me.tvspark;

import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.C1553ao;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class mq0 {
    public static final char[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "0123456789ABCDEF".toCharArray();

    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cc, code lost:
        if (r6 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        String str4 = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty("bf7dddc7c9cfe6f7")) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
            int indexOf = str.indexOf(47, 8);
            int length = str.length();
            int i = indexOf;
            while (true) {
                if (i >= length) {
                    break;
                } else if ("?#".indexOf(str.charAt(i)) != -1) {
                    length = i;
                    break;
                } else {
                    i++;
                }
            }
            String substring = str.substring(indexOf, length);
            if (substring == null) {
                return null;
            }
            if (substring.endsWith("/")) {
                substring = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring, -1, 0);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("&");
            if (substring == null) {
                substring = null;
            } else {
                int length2 = substring.length();
                int i2 = 0;
                StringBuilder sb = null;
                while (true) {
                    if (i2 < length2) {
                        int i3 = i2;
                        while (i3 < length2 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring.charAt(i3), null)) {
                            i3++;
                        }
                        if (i3 != length2) {
                            if (sb == null) {
                                sb = new StringBuilder();
                            }
                            if (i3 > i2) {
                                sb.append((CharSequence) substring, i2, i3);
                            }
                            i2 = i3 + 1;
                            while (i2 < length2 && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring.charAt(i2), null)) {
                                i2++;
                            }
                            try {
                                byte[] bytes = substring.substring(i3, i2).getBytes("UTF-8");
                                int length3 = bytes.length;
                                for (int i4 = 0; i4 < length3; i4++) {
                                    sb.append('%');
                                    sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(bytes[i4] & 240) >> 4]);
                                    sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[bytes[i4] & 15]);
                                }
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        } else if (i2 != 0) {
                            sb.append((CharSequence) substring, i2, length2);
                        }
                    }
                }
                substring = sb.toString();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(substring);
            if (!TextUtils.isEmpty(str3)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("&");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str3);
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("&");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(currentTimeMillis);
            try {
                String sb2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                try {
                    SecretKeySpec secretKeySpec = new SecretKeySpec("bf7dddc7c9cfe6f7".getBytes(), "HmacSHA1");
                    Mac mac = Mac.getInstance("HmacSHA1");
                    mac.init(secretKeySpec);
                    str4 = Base64.encodeToString(mac.doFinal(sb2.getBytes()), 2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                hashMap.put("_sig", URLEncoder.encode(str4, "utf-8"));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            hashMap.put(C1553ao.f3119h, String.valueOf(currentTimeMillis));
            return hashMap;
        }
        return null;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c, String str) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || !((c < '0' || c > '9') && "_-!.~'()*".indexOf(c) == -1 && (str == null || str.indexOf(c) == -1));
    }
}

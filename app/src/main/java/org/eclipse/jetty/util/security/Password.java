package org.eclipse.jetty.util.security;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.security.Credential;

/* loaded from: classes5.dex */
public class Password extends Credential {
    public static final Logger LOG = Log.getLogger(Password.class);
    public static final String __OBFUSCATE = "OBF:";
    public static final long serialVersionUID = 5062906681431569445L;
    public String _pw;

    public Password(String str) {
        while (true) {
            this._pw = str;
            String str2 = this._pw;
            if (str2 == null || !str2.startsWith(__OBFUSCATE)) {
                return;
            }
            str = deobfuscate(this._pw);
        }
    }

    public static String deobfuscate(String str) {
        if (str.startsWith(__OBFUSCATE)) {
            str = str.substring(4);
        }
        byte[] bArr = new byte[str.length() / 2];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i + 4;
            int parseInt = Integer.parseInt(str.substring(i, i3), 36);
            bArr[i2] = (byte) ((((parseInt / 256) + (parseInt % 256)) - 254) / 2);
            i = i3;
            i2++;
        }
        return new String(bArr, 0, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r4.length() != 0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Password getPassword(String str, String str2, String str3) {
        String property = System.getProperty(str, str2);
        if (property == null || property.length() == 0) {
            try {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append((str3 == null || str3.length() <= 0) ? "" : " [dft]");
                sb.append(" : ");
                printStream.print(sb.toString());
                System.out.flush();
                byte[] bArr = new byte[512];
                int read = System.in.read(bArr);
                if (read > 0) {
                    property = new String(bArr, 0, read).trim();
                }
            } catch (IOException e) {
                LOG.warn(Log.EXCEPTION, e);
            }
            if (property != null) {
            }
            return new Password(str3);
        }
        str3 = property;
        return new Password(str3);
    }

    public static void main(String[] strArr) {
        char c = 1;
        if (strArr.length != 1 && strArr.length != 2) {
            System.err.println("Usage - java org.eclipse.jetty.security.Password [<user>] <password>");
            System.err.println("If the password is ?, the user will be prompted for the password");
            System.exit(1);
        }
        if (strArr.length == 1) {
            c = 0;
        }
        String str = strArr[c];
        Password password = new Password(str);
        System.err.println(password.toString());
        System.err.println(obfuscate(password.toString()));
        System.err.println(Credential.MD5.digest(str));
        if (strArr.length == 2) {
            System.err.println(Credential.Crypt.crypt(strArr[0], password.toString()));
        }
    }

    public static String obfuscate(String str) {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = str.getBytes();
        sb.append(__OBFUSCATE);
        int i = 0;
        while (i < bytes.length) {
            byte b = bytes[i];
            i++;
            byte b2 = bytes[str.length() - i];
            int i2 = b + Byte.MAX_VALUE;
            String num = Integer.toString(((i2 + b2) * 256) + (i2 - b2), 36);
            int length = num.length();
            if (length == 1) {
                sb.append('0');
            } else if (length != 2) {
                if (length != 3) {
                    sb.append(num);
                }
                sb.append('0');
                sb.append(num);
            }
            sb.append('0');
            sb.append('0');
            sb.append(num);
        }
        return sb.toString();
    }

    @Override // org.eclipse.jetty.util.security.Credential
    public boolean check(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Password) && !(obj instanceof String)) {
            if (obj instanceof char[]) {
                return Arrays.equals(this._pw.toCharArray(), (char[]) obj);
            }
            if (!(obj instanceof Credential)) {
                return false;
            }
            return ((Credential) obj).check(this._pw);
        }
        return obj.equals(this._pw);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Password)) {
            if (!(obj instanceof String)) {
                return false;
            }
            return obj.equals(this._pw);
        }
        String str = ((Password) obj)._pw;
        String str2 = this._pw;
        if (str == str2) {
            return true;
        }
        return str2 != null && str2.equals(str);
    }

    public int hashCode() {
        String str = this._pw;
        return str == null ? super.hashCode() : str.hashCode();
    }

    public String toStarString() {
        return "*****************************************************".substring(0, this._pw.length());
    }

    public String toString() {
        return this._pw;
    }
}

package me.tvspark;

/* loaded from: classes4.dex */
public class jy0 implements iy0 {
    public static final jy0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        String[] strArr = new String[0];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = strArr;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new jy0(strArr, strArr, strArr);
    }

    public jy0(String[] strArr, String[] strArr2, String[] strArr3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = strArr == null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : strArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = strArr2 == null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : strArr2;
        strArr3 = strArr3 == null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : strArr3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = strArr3;
        Math.max(strArr3.length, Math.max(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length));
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i >= 0) {
            String[] strArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        if (i == -1) {
            return "EOF";
        }
        return null;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i >= 0) {
            String[] strArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i >= strArr.length) {
                return null;
            }
            return strArr[i];
        }
        return null;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        String str;
        if (i >= 0) {
            String[] strArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i < strArr.length && (str = strArr[i]) != null) {
                return str;
            }
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Integer.toString(i);
    }
}

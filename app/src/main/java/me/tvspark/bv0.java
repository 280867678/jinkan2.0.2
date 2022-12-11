package me.tvspark;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mozilla.javascript.Token;

/* loaded from: classes4.dex */
public class bv0 {
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Field Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public bv0(Class<?> cls, Field field, jv0 jv0Var) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = field.getName();
        int modifiers = field.getModifiers();
        if ((modifiers & Token.JSR) > 0) {
            return;
        }
        if ((modifiers & 1) > 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = field;
        }
        String name = field.getName();
        int length = name.length();
        char[] cArr = new char[length + 3];
        cArr[0] = 's';
        cArr[1] = 'e';
        cArr[2] = 't';
        char charAt = name.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            charAt = (char) (charAt - ' ');
        }
        cArr[3] = charAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 3] = name.charAt(i);
        }
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls.getDeclaredMethod(new String(cArr), field.getType());
        } catch (Exception unused) {
        }
        boolean equals = field.getType().equals(Boolean.TYPE);
        if (equals) {
            String name2 = field.getName();
            int length2 = name2.length();
            char[] cArr2 = new char[length2 + 2];
            cArr2[0] = 'i';
            cArr2[1] = 's';
            char charAt2 = name2.charAt(0);
            if (charAt2 >= 'a' && charAt2 <= 'z') {
                charAt2 = (char) (charAt2 - ' ');
            }
            cArr2[2] = charAt2;
            for (int i2 = 1; i2 < length2; i2++) {
                cArr2[i2 + 2] = name2.charAt(i2);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new String(cArr2);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(field.getName());
        }
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls.getDeclaredMethod(Wwwwwwwwwwwwwwwwwwwwwwwwwwww, new Class[0]);
        } catch (Exception unused2) {
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && equals) {
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls.getDeclaredMethod(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(field.getName()), new Class[0]);
            } catch (Exception unused3) {
            }
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        Method method = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (method != null && !jv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(field, method)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        Method method2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (method2 != null && !jv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(field, method2)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = field.getType();
        field.getGenericType();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null;
    }
}

package me.tvspark;

import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.internal.function.ParamType;
import com.jayway.jsonpath.internal.path.ArraySliceOperation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import me.tvspark.p30;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.message.TokenParser;

/* loaded from: classes4.dex */
public class o40 {
    public final g30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final LinkedList<f30> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public o40(String str, LinkedList<f30> linkedList) {
        g30 g30Var = new g30(str);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = linkedList;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g30Var;
    }

    public o40(g30 g30Var, LinkedList<f30> linkedList) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = linkedList;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g30Var;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(q40 q40Var) {
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[');
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            g30 g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, '*')) {
                return false;
            }
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('*')) {
            g30 g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1)) {
                return false;
            }
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('*');
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ']')) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ']') + 1;
            } else {
                throw new InvalidPathException("Expected wildcard token to end with ']' on position " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
            }
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        v40 v40Var = (v40) q40Var;
        v40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new y40());
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v40Var);
        }
        return true;
    }

    public final Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        return Boolean.valueOf(c == '$' || c == '@');
    }

    public final k30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).booleanValue()) {
            w40 w40Var = new w40(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != '.' && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != '[') {
                    throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Illegal character at position "), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, " expected '.' or '["));
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new v40(w40Var));
            }
            return new l40(w40Var, w40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("$"));
        }
        throw new InvalidPathException("Path must start with '$' or '@'");
    }

    public static k30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, f30... f30VarArr) {
        try {
            g30 g30Var = new g30(str);
            g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0) != '$' && g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0) != '@') {
                g30Var = new g30("$." + str);
                g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            if (g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('.')) {
                throw new InvalidPathException("Path must not end with a '.' or '..'");
            }
            return new o40(g30Var, new LinkedList(Arrays.asList(f30VarArr))).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } catch (Exception e) {
            if (!(e instanceof InvalidPathException)) {
                throw new InvalidPathException(e);
            }
            throw ((InvalidPathException) e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:267:0x04df, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, '?') == false) goto L268;
     */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x06f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(q40 q40Var) {
        g30 g30Var;
        int i;
        boolean z;
        boolean z2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        boolean z3;
        boolean z4;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        char Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ArraySliceOperation.Operation operation;
        boolean z5;
        int i2;
        boolean z6;
        int i3;
        ArrayList arrayList;
        p40 u40Var;
        int intValue;
        int intValue2;
        int intValue3;
        char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == '*') {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(q40Var)) {
                return true;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not parse token starting at position ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
        }
        boolean z7 = false;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != '.') {
            char c = '\"';
            char c2 = ']';
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != '[') {
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[') && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('*') && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('.') && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TokenParser.f4579SP)) {
                    int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i5 = i4;
                    while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5)) {
                        char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == ' ') {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Use bracket notion ['my prop'] if your property contains blank characters. position: ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.toString());
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == '.' || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == '[') {
                            i2 = i5;
                            break;
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == '(') {
                            i3 = i5 + 1;
                            z6 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    i2 = 0;
                    z6 = false;
                    int i6 = i2;
                    i3 = i5;
                    i5 = i6;
                    if (i5 == 0) {
                        i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                    }
                    if (z6) {
                        int i7 = i3 + 1;
                        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7)) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7) != ')') {
                            g30 g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 1;
                            String charSequence = g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, i5).toString();
                            Integer num = 1;
                            Integer num2 = 0;
                            Boolean bool = false;
                            arrayList = new ArrayList();
                            StringBuffer stringBuffer = new StringBuffer();
                            Integer num3 = num2;
                            ParamType paramType = null;
                            char c3 = 0;
                            Integer num4 = num3;
                            while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && !bool.booleanValue()) {
                                char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                if (paramType == null) {
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7)) {
                                        continue;
                                        c = '\"';
                                        c2 = ']';
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 == '{' || Character.isDigit(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7) || c == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7) {
                                        paramType = ParamType.JSON;
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7).booleanValue()) {
                                        paramType = ParamType.PATH;
                                    }
                                }
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != c) {
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != ',') {
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 == '[') {
                                            intValue2 = num3.intValue() + 1;
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != c2) {
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 == '{') {
                                                intValue3 = num2.intValue() + 1;
                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != '}') {
                                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 == '(') {
                                                    num = Integer.valueOf(num.intValue() + 1);
                                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 == ')') {
                                                    num = Integer.valueOf(num.intValue() - 1);
                                                    if (num.intValue() != 0) {
                                                        stringBuffer.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                                    }
                                                }
                                            } else if (num2.intValue() == 0) {
                                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected close brace '}' at character position: ");
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                                throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.toString());
                                            } else {
                                                intValue3 = num2.intValue() - 1;
                                            }
                                            num2 = Integer.valueOf(intValue3);
                                        } else if (num3.intValue() == 0) {
                                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected close bracket ']' at character position: ");
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                            throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.toString());
                                        } else {
                                            intValue2 = num3.intValue() - 1;
                                        }
                                        num3 = Integer.valueOf(intValue2);
                                    }
                                    if (num4.intValue() == 0 && num2.intValue() == 0 && num3.intValue() == 0 && ((num.intValue() == 0 && ')' == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7) || 1 == num.intValue())) {
                                        bool = Boolean.valueOf(num.intValue() == 0);
                                        if (paramType != null) {
                                            int ordinal = paramType.ordinal();
                                            t30 t30Var = ordinal != 0 ? ordinal != 1 ? null : new t30(new o40(stringBuffer.toString(), new LinkedList()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) : new t30(stringBuffer.toString());
                                            if (t30Var != null) {
                                                arrayList.add(t30Var);
                                            }
                                            stringBuffer.delete(0, stringBuffer.length());
                                            paramType = null;
                                        }
                                    }
                                } else {
                                    if (c3 == '\\' || num4.intValue() <= 0) {
                                        intValue = num4.intValue() + 1;
                                    } else if (num4.intValue() == 0) {
                                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected quote '\"' at character position: ");
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                        throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.toString());
                                    } else {
                                        intValue = num4.intValue() - 1;
                                    }
                                    num4 = Integer.valueOf(intValue);
                                }
                                if (paramType != null && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != ',' || num2.intValue() != 0 || num3.intValue() != 0 || 1 != num.intValue())) {
                                    stringBuffer.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                }
                                c3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
                                c = '\"';
                                c2 = ']';
                            }
                            if (num2.intValue() != 0 || num.intValue() != 0 || num3.intValue() != 0) {
                                throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Arguments to function: '", charSequence, "' are not closed properly."));
                            }
                            String charSequence2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, i5).toString();
                            if (!z6) {
                                u40Var = new n40(charSequence2, arrayList);
                            } else {
                                u40Var = new u40(Collections.singletonList(charSequence2), ExtendedMessageFormat.QUOTE);
                            }
                            ((v40) q40Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u40Var);
                            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(q40Var)) {
                                z5 = true;
                                if (z5) {
                                    return true;
                                }
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not parse token starting at position ");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.toString());
                            }
                        } else {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
                        }
                    } else {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
                    }
                    arrayList = null;
                    String charSequence22 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, i5).toString();
                    if (!z6) {
                    }
                    ((v40) q40Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u40Var);
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    }
                    z5 = true;
                    if (z5) {
                    }
                }
                z5 = false;
                if (z5) {
                }
            } else {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[')) {
                    g30 g30Var3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    char Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = g30Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(g30Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == '\'' || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == '\"') {
                        ArrayList arrayList2 = new ArrayList();
                        int i8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                        int i9 = i8;
                        boolean z8 = false;
                        boolean z9 = false;
                        boolean z10 = false;
                        int i10 = 0;
                        while (true) {
                            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8)) {
                                break;
                            }
                            char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                            if (z8) {
                                z8 = false;
                            } else if ('\\' == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12) {
                                z8 = true;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 != ']' || z9) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 == Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                                    if (!z9 || z8) {
                                        i9 = i8 + 1;
                                        z9 = true;
                                        z10 = false;
                                    } else {
                                        char Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != ']' && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != ',') {
                                            throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Property must be separated by comma or Property must be terminated close square bracket at index ", i8));
                                        }
                                        arrayList2.add(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9, i8).toString()));
                                        z9 = false;
                                        i10 = i8;
                                    }
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 != ',') {
                                    continue;
                                } else if (z10) {
                                    throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Found empty property at index ", i8));
                                } else {
                                    z10 = true;
                                }
                            } else if (z10) {
                                throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Found empty property at index ", i8));
                            }
                            i8++;
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10, ']') + 1;
                        u40 u40Var2 = new u40(arrayList2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        v40 v40Var = (v40) q40Var;
                        v40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u40Var2);
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v40Var)) {
                            z = true;
                            if (!z) {
                                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[')) {
                                    g30 g30Var4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    char Wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = g30Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(g30Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                    if (Character.isDigit(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww4) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == '-' || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == ':') {
                                        g30 g30Var5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        int i11 = g30Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = g30Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i11, ']');
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1) {
                                            String trim = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i11, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).toString().trim();
                                            if (!"*".equals(trim)) {
                                                int i12 = 0;
                                                while (true) {
                                                    if (i12 < trim.length()) {
                                                        char charAt = trim.charAt(i12);
                                                        if (!Character.isDigit(charAt) && charAt != ',' && charAt != '-' && charAt != ':' && charAt != ' ') {
                                                            break;
                                                        }
                                                        i12++;
                                                    } else {
                                                        if (trim.contains(":")) {
                                                            for (int i13 = 0; i13 < trim.length(); i13++) {
                                                                char charAt2 = trim.charAt(i13);
                                                                if (!Character.isDigit(charAt2) && charAt2 != '-' && charAt2 != ':') {
                                                                    throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to parse SliceOperation: ", trim));
                                                                }
                                                            }
                                                            String[] split = trim.split(":");
                                                            Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = ArraySliceOperation.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split, 0);
                                                            Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 = ArraySliceOperation.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split, 1);
                                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 == null) {
                                                                operation = ArraySliceOperation.Operation.SLICE_FROM;
                                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 != null) {
                                                                operation = ArraySliceOperation.Operation.SLICE_BETWEEN;
                                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 != null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 == null) {
                                                                throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to parse SliceOperation: ", trim));
                                                            } else {
                                                                operation = ArraySliceOperation.Operation.SLICE_TO;
                                                            }
                                                            ((v40) q40Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new k40(new ArraySliceOperation(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14, operation)));
                                                        } else {
                                                            ((v40) q40Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new k40(j40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trim)));
                                                        }
                                                        g30 g30Var6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                        g30Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1;
                                                        if (g30Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(q40Var)) {
                                                            z2 = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                z2 = false;
                                if (!z2 && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(q40Var)) {
                                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[')) {
                                        g30 g30Var7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    }
                                    g30 g30Var8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int i14 = g30Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = g30Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('?');
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != -1 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, '(')) != -1 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, '(', ')', true, true)) != -1 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, ']')) {
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, ']') + 1;
                                        p30 p30Var = new p30(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i14, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15).toString());
                                        try {
                                            o30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = p30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            p30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            if (!p30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                                v40 v40Var2 = (v40) q40Var;
                                                v40Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new t40(new p30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null)));
                                                g30 g30Var9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                g30Var9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15;
                                                if (g30Var9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v40Var2)) {
                                                    z3 = true;
                                                    if (!z3) {
                                                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[') && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('?')) != -1 && ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) == ']' || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == ',')) {
                                                            g30 g30Var10 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                            int i15 = g30Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                                                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = g30Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i15, ']');
                                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != -1) {
                                                                String charSequence3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i15, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4).toString();
                                                                String[] split2 = charSequence3.split(",");
                                                                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() >= split2.length) {
                                                                    ArrayList arrayList3 = new ArrayList();
                                                                    int length = split2.length;
                                                                    for (int i16 = 0; i16 < length; i16++) {
                                                                        String str = split2[i16];
                                                                        if (str != null) {
                                                                            str = str.trim();
                                                                        }
                                                                        if (!"?".equals(str == null ? "" : str)) {
                                                                            throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected '?' but found ", str));
                                                                        }
                                                                        arrayList3.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.pop());
                                                                    }
                                                                    t40 t40Var = new t40(arrayList3);
                                                                    v40 v40Var3 = (v40) q40Var;
                                                                    v40Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t40Var);
                                                                    g30 g30Var11 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                    g30Var11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 + 1;
                                                                    if (g30Var11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v40Var3)) {
                                                                        z4 = true;
                                                                        if (!z4) {
                                                                            throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not parse token starting at position "), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ". Expected ?, ', 0-9, * "));
                                                                        }
                                                                    }
                                                                } else {
                                                                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Not enough predicates supplied for filter [", charSequence3, "] at position ");
                                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                                                    throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
                                                                }
                                                            }
                                                        }
                                                        z4 = false;
                                                        if (!z4) {
                                                        }
                                                    }
                                                }
                                            } else {
                                                throw new InvalidPathException(String.format("Expected end of filter expression instead of: %s", p30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, p30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1)));
                                            }
                                        } catch (InvalidPathException e) {
                                            throw e;
                                        } catch (Exception unused) {
                                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to parse filter: ");
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16.append(p30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16.append(", error on position: ");
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16.append(p30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16.append(", char: ");
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16.append(p30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                            throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16.toString());
                                        }
                                    }
                                    z3 = false;
                                    if (!z3) {
                                    }
                                }
                            }
                            return true;
                        }
                    }
                }
                z = false;
                if (!z) {
                }
                return true;
            }
        } else {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('.')) {
                g30 g30Var12 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (g30Var12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g30Var12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1) && g30Var12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(g30Var12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1) == '.') {
                    z7 = true;
                }
                if (z7) {
                    ((v40) q40Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new x40());
                    g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    i = 2;
                    g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('.')) {
                        throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Character '.' on position "), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, " is not valid."));
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(q40Var)) {
                        return true;
                    }
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not parse token starting at position ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17.toString());
                }
            }
            g30 g30Var13 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!g30Var13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g30Var13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1)) {
                throw new InvalidPathException("Path must not end with a '.");
            }
            g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i = 1;
            g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('.')) {
            }
        }
    }
}

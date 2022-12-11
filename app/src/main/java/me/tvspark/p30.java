package me.tvspark;

import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.internal.filter.LogicalOperator;
import com.jayway.jsonpath.internal.filter.RelationalOperator;
import java.util.ArrayList;
import me.tvspark.f30;
import me.tvspark.s30;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.message.TokenParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public class p30 {
    public static final Logger Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LoggerFactory.getLogger(p30.class);
    public g30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends d30 {
        public final f30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30 f30Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f30Var;
        }

        @Override // me.tvspark.f30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            String str;
            String obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            if (obj.startsWith("(")) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[?", obj);
                str = "]";
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[?(", obj);
                str = ")]";
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public p30(String str) {
        g30 g30Var = new g30(str);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g30Var;
        g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[') || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(']')) {
            throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Filter must start with '[' and end with ']'. ", str));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        g30 g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
        g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('?')) {
            throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Filter must start with '[?' and end with ']'. ", str));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('(') && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(')')) {
            return;
        }
        throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Filter must start with '[?(' and end with ')]'. ", str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (r0 != '{') goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final s30 Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        g30 g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == '!') {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            g30 g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != '$' && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != '@') {
                throw new InvalidPathException(String.format("Unexpected character: %c", Character.valueOf(PublicSuffixDatabase.EXCEPTION_MARKER)));
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == '$') {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != '@') {
                g30 g30Var3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                g30Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = g30Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                char c = '\"';
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != '\"') {
                    c = ExtendedMessageFormat.QUOTE;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != '\'') {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != '-') {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == '/') {
                                g30 g30Var4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i = g30Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g30Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, '/');
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Pattern not closed. Expected / in ");
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                    throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
                                }
                                int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) == 'i') {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                                }
                                g30 g30Var5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                                g30Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                                CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = g30Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i3);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.trace("PatternNode from {} to {} -> [{}]", Integer.valueOf(i), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                                return s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                            }
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != '[') {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != 'f') {
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 'n') {
                                        g30 g30Var6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        int i4 = g30Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        if (g30Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 'n') {
                                            g30 g30Var7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            if (g30Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g30Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 3)) {
                                                g30 g30Var8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                int i5 = g30Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = g30Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, i5 + 4);
                                                if ("null".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.toString())) {
                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.trace("NullLiteral from {} to {} -> [{}]", Integer.valueOf(i4), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 3), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.length());
                                                    return s30.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                }
                                            }
                                        }
                                        throw new InvalidPathException("Expected <null> value");
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != 't') {
                                    }
                                }
                                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            }
                            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                }
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public final RelationalOperator Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        g30 g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            }
        } else {
            while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != ' ') {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            }
        }
        g30 g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.trace("Operator from {} to {} -> [{}]", Integer.valueOf(i), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        return RelationalOperator.fromString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d3, code lost:
        if (r0 == '!') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d6, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d7, code lost:
        r0 = r14.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e3, code lost:
        return me.tvspark.s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r4, r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), false, r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z;
        boolean z2;
        g30 g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1 ? TokenParser.f4579SP : g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        g30 g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z3 = true;
        while (true) {
            g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                break;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == '[') {
                g30 g30Var3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = g30Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g30Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, '[', ']', true, false);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != -1) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 + 1;
                } else {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Square brackets does not match in filter ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                }
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == ')') {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == ')') {
                    g30 g30Var4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = g30Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g30Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) == '(') {
                        do {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2--;
                            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > i) {
                            }
                        } while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) != '.');
                        z2 = true;
                        if (z2) {
                            z = true;
                            boolean z4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != ')' && !z;
                            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == ' ' || z4) {
                                break;
                            }
                            g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            z = false;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != ')') {
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                break;
                break;
            }
            g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public final s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            g30 g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            char charAt = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!(Character.isDigit(charAt) || charAt == '-' || charAt == '.')) {
                break;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        g30 g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.trace("NumberLiteral from {} to {} -> [{}]", Integer.valueOf(i), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        return s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    public final o30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        while (true) {
            g30 g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            try {
                g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LogicalOperator.OR.getOperatorString());
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            } catch (InvalidPathException unused) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                return 1 == arrayList.size() ? (o30) arrayList.get(0) : new q30(LogicalOperator.OR, arrayList);
            }
        }
    }

    public final o30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        g30 g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        g30 g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(PublicSuffixDatabase.EXCEPTION_MARKER)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(PublicSuffixDatabase.EXCEPTION_MARKER);
            g30 g30Var3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            g30Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = g30Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != '$' && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != '@') {
                return new q30(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), LogicalOperator.NOT, null);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }
        g30 g30Var4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        g30Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (g30Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('(')) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('(');
            o30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(')');
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        s30 Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwww();
        try {
            return new r30(Wwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwwwwww());
        } catch (InvalidPathException unused) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = new s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww, true, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwww);
            return new r30(wwwwwwwwwwwwwwwwwwwwwwwwwwww, RelationalOperator.EXISTS, wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww ? s30.Wwwwwwwwwwwwwwwwwwwwwww : s30.Wwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public final o30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        while (true) {
            g30 g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            try {
                g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LogicalOperator.AND.getOperatorString());
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            } catch (InvalidPathException unused) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                return 1 == arrayList.size() ? (o30) arrayList.get(0) : new q30(LogicalOperator.AND, arrayList);
            }
        }
    }

    public final s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        g30 g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        char c = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == '[' ? ']' : '}';
        g30 g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, c, true, false);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == -1) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("String not closed. Expected ' in ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
        }
        g30 g30Var3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 + 1;
        g30Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = g30Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.trace("JsonLiteral from {} to {} -> [{}]", Integer.valueOf(i), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
        return s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
    }

    public final s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        g30 g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 't') {
            i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 3;
        } else {
            i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 4;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) {
            CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i + 1);
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals("true") && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals("false")) {
                throw new InvalidPathException("Expected boolean literal");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.trace("BooleanLiteral from {} to {} -> [{}]", Integer.valueOf(i2), Integer.valueOf(i), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            return s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        throw new InvalidPathException("Expected boolean literal");
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        return c == '<' || c == '>' || c == '=' || c == '~' || c == '!';
    }

    public final s30.Wwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        g30 g30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, c);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            g30 g30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
            g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = g30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.trace("StringLiteral from {} to {} -> [{}]", Integer.valueOf(i), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            return s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, true);
        }
        throw new InvalidPathException("String literal does not have matching quotes. Expected " + c + " in " + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}

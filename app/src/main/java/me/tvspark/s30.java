package me.tvspark;

import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.JsonPathException;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.PathNotFoundException;
import com.umeng.analytics.pro.C1543ak;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import me.tvspark.f30;
import net.minidev.json.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public abstract class s30 {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("true", null);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("false", null);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwww extends s30 implements Iterable<s30> {
        public List<s30> Wwwwwwwwwwwwwwwwwwww = new ArrayList();

        /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00b4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Wwwwwwwwwwwwwwwwwwwwwwww(Collection<?> collection) {
            boolean z;
            boolean z2;
            s30 wwwwwwwwwwwwwwwwwwwwwwwwwww;
            s30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            char charAt;
            for (Object obj : collection) {
                List<s30> list = this.Wwwwwwwwwwwwwwwwwwww;
                if (obj == null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30.Wwwwwwwwwwwwwwwwwwwwwwww;
                } else if (obj instanceof s30) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (s30) obj;
                } else {
                    if (obj instanceof Class) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Class) obj, null);
                    } else {
                        boolean z3 = obj instanceof String;
                        if (z3) {
                            String trim = obj.toString().trim();
                            if (trim.length() > 0 && ((charAt = trim.charAt(0)) == '@' || charAt == '$')) {
                                try {
                                    o40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trim, new f30[0]);
                                    z = true;
                                } catch (Exception unused) {
                                }
                                if (!z) {
                                    wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) obj.toString(), false, false);
                                } else {
                                    if (z3) {
                                        String trim2 = obj.toString().trim();
                                        if (trim2.length() > 1) {
                                            char charAt2 = trim2.charAt(0);
                                            char charAt3 = trim2.charAt(trim2.length() - 1);
                                            if ((charAt2 == '[' && charAt3 == ']') || (charAt2 == '{' && charAt3 == '}')) {
                                                try {
                                                    new tv0(-1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trim2);
                                                    z2 = true;
                                                } catch (Exception unused2) {
                                                }
                                                if (!z2) {
                                                    wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj.toString(), null);
                                                } else if (z3) {
                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj.toString(), true);
                                                } else if (obj instanceof Character) {
                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj.toString(), false);
                                                } else if (obj instanceof Number) {
                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj.toString());
                                                } else if (obj instanceof Boolean) {
                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj.toString());
                                                } else if (obj instanceof Pattern) {
                                                    wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwww((Pattern) obj);
                                                } else {
                                                    throw new JsonPathException("Could not determine value type");
                                                }
                                            }
                                        }
                                    }
                                    z2 = false;
                                    if (!z2) {
                                    }
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                list.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        @Override // me.tvspark.s30
        public boolean Wwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // me.tvspark.s30
        public Wwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this;
        }

        @Override // me.tvspark.s30
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return List.class;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var) {
            return this.Wwwwwwwwwwwwwwwwwwww.contains(s30Var);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwww) obj;
            if (wwwwwwwwwwwwwwwwwwwwwwww != null) {
                if (this.Wwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww)) {
                    return true;
                }
            } else if (wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww == null) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Iterable
        public Iterator<s30> iterator() {
            return this.Wwwwwwwwwwwwwwwwwwww.iterator();
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(",", (Iterable<? extends Object>) this.Wwwwwwwwwwwwwwwwwwww));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwww extends s30 {
        @Override // me.tvspark.s30
        public boolean Wwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // me.tvspark.s30
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return Void.class;
        }

        public boolean equals(Object obj) {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwww extends s30 {
        public boolean Wwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwww = true;
            if (charSequence.length() > 1) {
                char charAt = charSequence.charAt(0);
                char charAt2 = charSequence.charAt(charSequence.length() - 1);
                if (charAt == '\'' && charAt2 == '\'') {
                    charSequence = charSequence.subSequence(1, charSequence.length() - 1);
                } else if (charAt == '\"' && charAt2 == '\"') {
                    charSequence = charSequence.subSequence(1, charSequence.length() - 1);
                    this.Wwwwwwwwwwwwwwwwwww = false;
                }
            }
            String charSequence2 = charSequence.toString();
            this.Wwwwwwwwwwwwwwwwwwww = z ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence2) : charSequence2;
        }

        @Override // me.tvspark.s30
        public boolean Wwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // me.tvspark.s30
        public Wwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this;
        }

        @Override // me.tvspark.s30
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            try {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(new BigDecimal(this.Wwwwwwwwwwwwwwwwwwww), (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
            } catch (NumberFormatException unused) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
            }
        }

        @Override // me.tvspark.s30
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return String.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwww) && !(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ((s30) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
            String str = this.Wwwwwwwwwwwwwwwwwwww;
            if (str != null) {
                if (str.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww)) {
                    return true;
                }
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            String stringWriter;
            StringBuilder sb;
            String str = this.Wwwwwwwwwwwwwwwwwww ? "'" : "\"";
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            String str2 = this.Wwwwwwwwwwwwwwwwwwww;
            if (str2 == null) {
                stringWriter = null;
            } else {
                int length = str2.length();
                StringWriter stringWriter2 = new StringWriter(length * 2);
                for (int i = 0; i < length; i++) {
                    char charAt = str2.charAt(i);
                    String str3 = "\\u00";
                    if (charAt > 4095) {
                        sb = new StringBuilder();
                        str3 = "\\u";
                    } else if (charAt > 255) {
                        sb = new StringBuilder();
                        str3 = "\\u0";
                    } else if (charAt > 127) {
                        sb = new StringBuilder();
                    } else {
                        if (charAt < ' ') {
                            switch (charAt) {
                                case '\b':
                                    stringWriter2.write(92);
                                    charAt = 'b';
                                    break;
                                case '\t':
                                    stringWriter2.write(92);
                                    charAt = 't';
                                    break;
                                case '\n':
                                    stringWriter2.write(92);
                                    charAt = 'n';
                                    break;
                                case 11:
                                default:
                                    if (charAt > 15) {
                                        sb = new StringBuilder();
                                        break;
                                    } else {
                                        sb = new StringBuilder();
                                        str3 = "\\u000";
                                        break;
                                    }
                                case '\f':
                                    stringWriter2.write(92);
                                    charAt = 'f';
                                    break;
                                case '\r':
                                    stringWriter2.write(92);
                                    charAt = 'r';
                                    break;
                            }
                        } else {
                            int i2 = 34;
                            if (charAt != '\"') {
                                i2 = 39;
                                if (charAt != '\'') {
                                    i2 = 47;
                                    if (charAt != '/') {
                                        if (charAt == '\\') {
                                            stringWriter2.write(92);
                                            stringWriter2.write(92);
                                        }
                                    }
                                }
                            }
                            stringWriter2.write(92);
                            stringWriter2.write(i2);
                        }
                        stringWriter2.write(charAt);
                    }
                    sb.append(str3);
                    sb.append(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charAt));
                    stringWriter2.write(sb.toString());
                }
                stringWriter = stringWriter2.toString();
            }
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, stringWriter, str);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwww extends s30 {
        public final Pattern Wwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            String charSequence2 = charSequence.toString();
            int indexOf = charSequence2.indexOf(47);
            int lastIndexOf = charSequence2.lastIndexOf(47);
            int i = charSequence2.endsWith("/i") ? 2 : 0;
            String substring = charSequence2.substring(indexOf + 1, lastIndexOf);
            this.Wwwwwwwwwwwwwwwwwwww = substring;
            this.Wwwwwwwwwwwwwwwwwww = Pattern.compile(substring, i);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwww(Pattern pattern) {
            this.Wwwwwwwwwwwwwwwwwwww = pattern.pattern();
            this.Wwwwwwwwwwwwwwwwwww = pattern;
        }

        @Override // me.tvspark.s30
        public boolean Wwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // me.tvspark.s30
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this;
        }

        @Override // me.tvspark.s30
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return Void.TYPE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            Pattern pattern = this.Wwwwwwwwwwwwwwwwwww;
            Pattern pattern2 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwww;
            if (pattern != null) {
                if (pattern.equals(pattern2)) {
                    return true;
                }
            } else if (pattern2 == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            return !this.Wwwwwwwwwwwwwwwwwwww.startsWith("/") ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("/"), this.Wwwwwwwwwwwwwwwwwwww, "/", (this.Wwwwwwwwwwwwwwwwwww.flags() & 2) == 2 ? C1543ak.f2966aC : "") : this.Wwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends s30 {
        public static final Logger Wwwwwwwwwwwwwwwww = LoggerFactory.getLogger(Wwwwwwwwwwwwwwwwwwwwwwwwwwww.class);
        public final boolean Wwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwww;
        public final k30 Wwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, boolean z, boolean z2) {
            k30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.toString(), new f30[0]);
            this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwww = z2;
            Wwwwwwwwwwwwwwwww.trace("PathNode {} existsCheck: {}", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Boolean.valueOf(z));
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(k30 k30Var, boolean z, boolean z2) {
            this.Wwwwwwwwwwwwwwwwwwww = k30Var;
            this.Wwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwww = z2;
            Wwwwwwwwwwwwwwwww.trace("PathNode {} existsCheck: {}", k30Var, Boolean.valueOf(z));
        }

        @Override // me.tvspark.s30
        public boolean Wwwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // me.tvspark.s30
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this;
        }

        public s30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Object obj;
            Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (this.Wwwwwwwwwwwwwwwwwww) {
                try {
                    EnumSet noneOf = EnumSet.noneOf(Option.class);
                    ArrayList arrayList = new ArrayList();
                    b50 b50Var = ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    noneOf.addAll(Arrays.asList(Option.REQUIRE_PROPERTIES));
                    h30 h30Var = h30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (b50Var == null) {
                        if (h30Var == null) {
                            throw null;
                        }
                        b50Var = new c50();
                    }
                    return ((m40) ((l40) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new b30(b50Var, h30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, noneOf, arrayList, null))).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false) == b50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? s30.Wwwwwwwwwwwwwwwwwwwwww : s30.Wwwwwwwwwwwwwwwwwwwwwww;
                } catch (PathNotFoundException unused) {
                    return s30.Wwwwwwwwwwwwwwwwwwwwww;
                }
            }
            try {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof s40) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww);
                } else {
                    if (((l40) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        obj = ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    } else {
                        obj = ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((m40) ((l40) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                if (((c50) ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                    throw null;
                }
                if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Number) && !(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof BigDecimal)) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof String) {
                        return s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), false);
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Boolean) {
                        return s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        return s30.Wwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    if (((c50) ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof List) {
                            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        if (((c50) ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Map) {
                                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            }
                            throw new JsonPathException("Could not convert " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString() + " to a ValueNode");
                        }
                        throw null;
                    }
                    throw null;
                }
                return s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } catch (PathNotFoundException unused2) {
                return s30.Wwwwwwwwwwwwwwwwwwwww;
            }
        }

        @Override // me.tvspark.s30
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return Void.class;
        }

        public String toString() {
            return (!this.Wwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwww) ? this.Wwwwwwwwwwwwwwwwwwww.toString() : Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("!", this.Wwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww extends s30 {
        public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        public final BigDecimal Wwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwww = new BigDecimal(charSequence.toString());
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(BigDecimal bigDecimal) {
            this.Wwwwwwwwwwwwwwwwwwww = bigDecimal;
        }

        @Override // me.tvspark.s30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // me.tvspark.s30
        public Wwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww.toString(), false, null);
        }

        @Override // me.tvspark.s30
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this;
        }

        @Override // me.tvspark.s30
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return Number.class;
        }

        public boolean equals(Object obj) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (this == obj) {
                return true;
            }
            return ((obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) || (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwww)) && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((s30) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) != Wwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwww.compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww) == 0;
        }

        public String toString() {
            return this.Wwwwwwwwwwwwwwwwwwww.toString();
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(BigDecimal bigDecimal, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwww = bigDecimal;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends s30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.s30
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return Void.class;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public String toString() {
            return "null";
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends s30 {
        public final boolean Wwwwwwwwwwwwwwwwwww = false;
        public final Object Wwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwww = charSequence.toString();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            this.Wwwwwwwwwwwwwwwwwwww = obj;
        }

        public Object Wwwwwwwwwwwwwwwwww() {
            try {
                return this.Wwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwww : new tv0(-1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww.toString());
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override // me.tvspark.s30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            b50 b50Var = ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Object Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwww();
            if (((c50) b50Var) != null) {
                return Wwwwwwwwwwwwwwwwww instanceof Map;
            }
            throw null;
        }

        @Override // me.tvspark.s30
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            b50 b50Var = ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Object Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwww();
            if (((c50) b50Var) != null) {
                return Wwwwwwwwwwwwwwwwww instanceof List;
            }
            throw null;
        }

        public s30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? s30.Wwwwwwwwwwwwwwwwwwwww : new Wwwwwwwwwwwwwwwwwwwwwwww(Collections.unmodifiableList((List) Wwwwwwwwwwwwwwwwww()));
        }

        @Override // me.tvspark.s30
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? List.class : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? Map.class : Wwwwwwwwwwwwwwwwww() instanceof Number ? Number.class : Wwwwwwwwwwwwwwwwww() instanceof String ? String.class : Wwwwwwwwwwwwwwwwww() instanceof Boolean ? Boolean.class : Void.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            Object obj2 = this.Wwwwwwwwwwwwwwwwwwww;
            Object obj3 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwww;
            if (obj2 != null) {
                if (obj2.equals(obj3)) {
                    return true;
                }
            } else if (obj3 == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            return this.Wwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends s30 {
        public final Class Wwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwww = cls;
        }

        @Override // me.tvspark.s30
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this;
        }

        @Override // me.tvspark.s30
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return Class.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            Class cls = this.Wwwwwwwwwwwwwwwwwwww;
            Class cls2 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwww;
            if (cls != null) {
                if (cls.equals(cls2)) {
                    return true;
                }
            } else if (cls2 == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            return this.Wwwwwwwwwwwwwwwwwwww.getName();
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends s30 {
        public final Boolean Wwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwww = Boolean.valueOf(Boolean.parseBoolean(charSequence.toString()));
        }

        public boolean Wwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwww.booleanValue();
        }

        @Override // me.tvspark.s30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // me.tvspark.s30
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return Boolean.class;
        }

        @Override // me.tvspark.s30
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            Boolean bool = this.Wwwwwwwwwwwwwwwwwwww;
            Boolean bool2 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwww;
            if (bool != null) {
                if (bool.equals(bool2)) {
                    return true;
                }
            } else if (bool2 == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            return this.Wwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, null);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, null);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, boolean z) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, z, null);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, boolean z, boolean z2) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, z, z2);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence) {
        return Boolean.parseBoolean(charSequence.toString()) ? Wwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean Wwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public boolean Wwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public Wwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new InvalidPathException("Expected value list node");
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new InvalidPathException("Expected string node");
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new InvalidPathException("Expected regexp node");
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new InvalidPathException("Expected path node");
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new InvalidPathException("Expected number node");
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new InvalidPathException("Expected json node");
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new InvalidPathException("Expected class node");
    }

    public abstract Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new InvalidPathException("Expected boolean node");
    }
}

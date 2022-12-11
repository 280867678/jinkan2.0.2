package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.gk0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.kk0;
import me.tvspark.lk0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.yj0;
import me.tvspark.zj0;

@ef0
/* loaded from: classes4.dex */
public final class Regex implements Serializable {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Companion = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public Set<? extends RegexOption> _options;
    public final Pattern nativePattern;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Serialized implements Serializable {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Companion = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        public static final long serialVersionUID = 0;
        public final int flags;
        public final String pattern;

        /* loaded from: classes4.dex */
        public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gi0 gi0Var) {
            }
        }

        public Serialized(String str, int i) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(compile, "Pattern.compile(pattern, flags)");
            return new Regex(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gi0 gi0Var) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String str) {
        this(r2);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "pattern");
        Pattern compile = Pattern.compile(str);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(compile, "Pattern.compile(pattern)");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String str, Set<? extends RegexOption> set) {
        this(r4);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "pattern");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(set, "options");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Companion;
        int i = 0;
        for (gk0 gk0Var : set) {
            i |= gk0Var.getValue();
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Pattern compile = Pattern.compile(str, (i & 2) != 0 ? i | 64 : i);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(compile, "Pattern.compile(pattern,…odeCase(options.toInt()))");
            return;
        }
        throw null;
    }

    public Regex(Pattern pattern) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ kk0 find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ zj0 findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    public final kk0 find(CharSequence charSequence, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher, "nativePattern.matcher(input)");
        if (!matcher.find(i)) {
            return null;
        }
        return new lk0(matcher, charSequence);
    }

    public final zj0<kk0> findAll(CharSequence charSequence, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "input");
        if (i >= 0 && i <= charSequence.length()) {
            Regex$findAll$1 regex$findAll$1 = new Regex$findAll$1(this, charSequence, i);
            Regex$findAll$2 regex$findAll$2 = Regex$findAll$2.INSTANCE;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(regex$findAll$1, "seedFunction");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(regex$findAll$2, "nextFunction");
            return new yj0(regex$findAll$1, regex$findAll$2);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Start index out of bounds: ", i, ", input length: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(charSequence.length());
        throw new IndexOutOfBoundsException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        Regex$fromInt$$inlined$apply$lambda$1 regex$fromInt$$inlined$apply$lambda$1 = new Regex$fromInt$$inlined$apply$lambda$1(flags);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(allOf, "$this$retainAll");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(regex$fromInt$$inlined$apply$lambda$1, "predicate");
        Iterator it = allOf.iterator();
        while (it.hasNext()) {
            if (!regex$fromInt$$inlined$apply$lambda$1.mo4916invoke((Regex$fromInt$$inlined$apply$lambda$1) it.next()).booleanValue()) {
                it.remove();
            }
        }
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pattern, "nativePattern.pattern()");
        return pattern;
    }

    public final kk0 matchEntire(CharSequence charSequence) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher, "nativePattern.matcher(input)");
        if (!matcher.matches()) {
            return null;
        }
        return new lk0(matcher, charSequence);
    }

    public final boolean matches(CharSequence charSequence) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final String replace(CharSequence charSequence, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "input");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replace(CharSequence charSequence, ih0<? super kk0, ? extends CharSequence> ih0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "input");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "transform");
        int i = 0;
        kk0 find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default != null) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(length);
            do {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(find$default);
                sb.append(charSequence, i, find$default.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().intValue());
                sb.append(ih0Var.mo4916invoke(find$default));
                i = Integer.valueOf(find$default.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwww).intValue() + 1;
                find$default = find$default.next();
                if (i >= length) {
                    break;
                }
            } while (find$default != null);
            if (i < length) {
                sb.append(charSequence, i, length);
            }
            String sb2 = sb.toString();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "sb.toString()");
            return sb2;
        }
        return charSequence.toString();
    }

    public final String replaceFirst(CharSequence charSequence, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "input");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public final List<String> split(CharSequence charSequence, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "input");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (!matcher.find() || i == 1) {
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.toString());
        }
        int i3 = 10;
        if (i > 0 && i <= 10) {
            i3 = i;
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = i - 1;
        do {
            arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
            i2 = matcher.end();
            if (i4 >= 0 && arrayList.size() == i4) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String str, RegexOption regexOption) {
        this(r2);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "pattern");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(regexOption, "option");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Companion;
        int value = regexOption.getValue();
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Pattern compile = Pattern.compile(str, (value & 2) != 0 ? value | 64 : value);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(compile, "Pattern.compile(pattern,…nicodeCase(option.value))");
            return;
        }
        throw null;
    }
}

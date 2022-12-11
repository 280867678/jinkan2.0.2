package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.AbstractC2197ht;
import me.tvspark.AbstractC2234it;

/* loaded from: classes3.dex */
public final class JdkPattern extends AbstractC2234it implements Serializable {
    public static final long serialVersionUID = 0;
    public final Pattern pattern;

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2197ht {
        public final Matcher Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Matcher matcher) {
            if (matcher != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = matcher;
                return;
            }
            throw null;
        }
    }

    public JdkPattern(Pattern pattern) {
        if (pattern != null) {
            this.pattern = pattern;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2234it
    public int flags() {
        return this.pattern.flags();
    }

    @Override // me.tvspark.AbstractC2234it
    public AbstractC2197ht matcher(CharSequence charSequence) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.pattern.matcher(charSequence));
    }

    @Override // me.tvspark.AbstractC2234it
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // me.tvspark.AbstractC2234it
    public String toString() {
        return this.pattern.toString();
    }
}

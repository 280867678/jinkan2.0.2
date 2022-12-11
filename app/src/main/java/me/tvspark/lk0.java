package me.tvspark;

import java.util.regex.Matcher;
import kotlin.collections.AbstractCollection;

@ef0
/* loaded from: classes4.dex */
public final class lk0 implements kk0 {
    public final CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Matcher Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractCollection<hk0> implements jk0 {
        public final /* synthetic */ lk0 Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public lk0(Matcher matcher, CharSequence charSequence) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher, "matcher");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "input");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = matcher;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charSequence;
    }

    @Override // me.tvspark.kk0
    public bj0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Matcher matcher = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher.start(), matcher.end());
    }

    @Override // me.tvspark.kk0
    public kk0 next() {
        int end = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.end() + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.end() == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start() ? 1 : 0);
        if (end <= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length()) {
            Matcher matcher = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.pattern().matcher(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher, "matcher.pattern().matcher(input)");
            CharSequence charSequence = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (matcher.find(end)) {
                return new lk0(matcher, charSequence);
            }
            return null;
        }
        return null;
    }
}

package org.antlr.p055v4.runtime.tree.pattern;

import me.tvspark.outline;
import org.antlr.p055v4.runtime.CommonToken;

/* renamed from: org.antlr.v4.runtime.tree.pattern.TokenTagToken */
/* loaded from: classes4.dex */
public class TokenTagToken extends CommonToken {
    public final String label;
    public final String tokenName;

    public TokenTagToken(String str, int i) {
        this(str, i, null);
    }

    public TokenTagToken(String str, int i, String str2) {
        super(i);
        this.tokenName = str;
        this.label = str2;
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // org.antlr.p055v4.runtime.CommonToken, me.tvspark.ey0
    public String getText() {
        StringBuilder sb;
        String str = "<";
        if (this.label != null) {
            sb = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            sb.append(this.label);
            str = ":";
        } else {
            sb = new StringBuilder();
        }
        sb.append(str);
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, this.tokenName, ">");
    }

    public final String getTokenName() {
        return this.tokenName;
    }

    @Override // org.antlr.p055v4.runtime.CommonToken
    public String toString() {
        return this.tokenName + ":" + this.type;
    }
}

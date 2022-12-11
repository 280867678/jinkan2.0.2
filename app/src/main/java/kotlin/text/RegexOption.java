package kotlin.text;

import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.gk0;

@ef0
/* loaded from: classes4.dex */
public enum RegexOption implements gk0 {
    IGNORE_CASE(2, 0, 2, null),
    MULTILINE(8, 0, 2, null),
    LITERAL(16, 0, 2, null),
    UNIX_LINES(1, 0, 2, null),
    COMMENTS(4, 0, 2, null),
    DOT_MATCHES_ALL(32, 0, 2, null),
    CANON_EQ(128, 0, 2, null);
    
    public final int mask;
    public final int value;

    RegexOption(int i, int i2) {
        this.value = i;
        this.mask = i2;
    }

    /* synthetic */ RegexOption(int i, int i2, int i3, gi0 gi0Var) {
        this(i, (i3 & 2) != 0 ? i : i2);
    }

    @Override // me.tvspark.gk0
    public int getMask() {
        return this.mask;
    }

    @Override // me.tvspark.gk0
    public int getValue() {
        return this.value;
    }
}

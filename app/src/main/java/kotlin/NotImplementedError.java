package kotlin;

import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes4.dex */
public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String str) {
        super(str);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "message");
    }

    public /* synthetic */ NotImplementedError(String str, int i, gi0 gi0Var) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}

package kotlin.p049io;

import java.nio.charset.CharsetDecoder;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.wg0;

@ef0
/* renamed from: kotlin.io.LineReader$readLine$1 */
/* loaded from: classes4.dex */
public final /* synthetic */ class LineReader$readLine$1 extends MutablePropertyReference0Impl {
    public LineReader$readLine$1(wg0 wg0Var) {
        super(wg0Var, wg0.class, "decoder", "getDecoder()Ljava/nio/charset/CharsetDecoder;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, me.tvspark.qj0
    public Object get() {
        wg0 wg0Var = (wg0) this.receiver;
        CharsetDecoder charsetDecoder = wg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (charsetDecoder != null) {
            return charsetDecoder;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("decoder");
        throw null;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl
    public void set(Object obj) {
        wg0 wg0Var = (wg0) this.receiver;
        wg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (CharsetDecoder) obj;
    }
}

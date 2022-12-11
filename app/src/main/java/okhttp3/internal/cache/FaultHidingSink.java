package okhttp3.internal.cache;

import java.io.IOException;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.kx0;
import me.tvspark.of0;
import me.tvspark.uw0;
import me.tvspark.xw0;

@ef0
/* loaded from: classes4.dex */
public class FaultHidingSink extends xw0 {
    public boolean hasErrors;
    public final ih0<IOException, of0> onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(kx0 kx0Var, ih0<? super IOException, of0> ih0Var) {
        super(kx0Var);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0Var, "delegate");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "onException");
        this.onException = ih0Var;
    }

    @Override // me.tvspark.xw0, me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.mo4916invoke(e);
        }
    }

    @Override // me.tvspark.xw0, me.tvspark.kx0, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.mo4916invoke(e);
        }
    }

    public final ih0<IOException, of0> getOnException() {
        return this.onException;
    }

    @Override // me.tvspark.xw0, me.tvspark.kx0
    public void write(uw0 uw0Var, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
        if (this.hasErrors) {
            uw0Var.skip(j);
            return;
        }
        try {
            super.write(uw0Var, j);
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.mo4916invoke(e);
        }
    }
}

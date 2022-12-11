package me.tvspark;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.DirectExecutor;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import me.tvspark.AbstractC2542qz;

/* renamed from: me.tvspark.mz */
/* loaded from: classes4.dex */
public abstract class AbstractRunnableC2388mz<I, O, F, T> extends AbstractC2542qz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<O> implements Runnable {
    public F Wwwwwwwwwwwwwwww;
    public AbstractFutureC2691uz<? extends I> Wwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.mz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<I, O> extends AbstractRunnableC2388mz<I, O, AbstractC2271jt<? super I, ? extends O>, O> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFutureC2691uz<? extends I> abstractFutureC2691uz, AbstractC2271jt<? super I, ? extends O> abstractC2271jt) {
            super(abstractFutureC2691uz, abstractC2271jt);
        }
    }

    public AbstractRunnableC2388mz(AbstractFutureC2691uz<? extends I> abstractFutureC2691uz, F f) {
        if (abstractFutureC2691uz != null) {
            this.Wwwwwwwwwwwwwwwww = abstractFutureC2691uz;
            if (f == null) {
                throw null;
            }
            this.Wwwwwwwwwwwwwwww = f;
            return;
        }
        throw null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String str;
        AbstractFutureC2691uz<? extends I> abstractFutureC2691uz = this.Wwwwwwwwwwwwwwwww;
        F f = this.Wwwwwwwwwwwwwwww;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (abstractFutureC2691uz != null) {
            str = "inputFuture=[" + abstractFutureC2691uz + "], ";
        } else {
            str = "";
        }
        if (f == null) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return null;
            }
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return str + "function=[" + f + "]";
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        AbstractFutureC2691uz<? extends I> abstractFutureC2691uz = this.Wwwwwwwwwwwwwwwww;
        boolean z = false;
        if ((abstractFutureC2691uz != null) & isCancelled()) {
            Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if ((obj instanceof AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && ((AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                z = true;
            }
            abstractFutureC2691uz.cancel(z);
        }
        this.Wwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwww = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        AbstractFutureC2691uz abstractFutureC2691uz = (AbstractFutureC2691uz<? extends I>) this.Wwwwwwwwwwwwwwwww;
        F f = this.Wwwwwwwwwwwwwwww;
        boolean z = true;
        boolean z2 = (this.Wwwwwwwwwwwwwwwwwwwwwwww instanceof AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) | (abstractFutureC2691uz == null);
        if (f != null) {
            z = false;
        }
        if (z2 || z) {
            return;
        }
        this.Wwwwwwwwwwwwwwwww = null;
        if (abstractFutureC2691uz.isCancelled()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractFutureC2691uz);
            return;
        }
        try {
            try {
                Object mo4462apply = ((AbstractC2271jt) f).mo4462apply(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Future<Object>) abstractFutureC2691uz));
                this.Wwwwwwwwwwwwwwww = null;
                ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) mo4462apply);
            } catch (Throwable th) {
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                } finally {
                    this.Wwwwwwwwwwwwwwww = null;
                }
            }
        } catch (Error e) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e2);
        } catch (ExecutionException e3) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e3.getCause());
        }
    }

    public static <I, O> AbstractFutureC2691uz<O> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFutureC2691uz<I> abstractFutureC2691uz, AbstractC2271jt<? super I, ? extends O> abstractC2271jt, Executor executor) {
        if (abstractC2271jt != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractFutureC2691uz, abstractC2271jt);
            if (executor != null) {
                if (executor != DirectExecutor.INSTANCE) {
                    executor = new ExecutorC2768wz(executor, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                abstractFutureC2691uz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, executor);
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            throw null;
        }
        throw null;
    }
}

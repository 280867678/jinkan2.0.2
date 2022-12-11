package me.tvspark;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class o60 implements p60, h70 {
    public volatile boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public fd0<p60> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046 A[Catch: all -> 0x004a, DONT_GENERATE, TryCatch #0 {, blocks: (B:7:0x000c, B:9:0x0010, B:11:0x0012, B:13:0x0016, B:18:0x0046, B:20:0x002a, B:22:0x0030, B:23:0x0035, B:25:0x003c, B:31:0x0048), top: B:6:0x000c }] */
    @Override // me.tvspark.h70
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60 p60Var) {
        p60 p60Var2;
        boolean z;
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var, "Disposable item is null");
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        synchronized (this) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                return false;
            }
            fd0<p60> fd0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (fd0Var != null) {
                p60[] p60VarArr = fd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i = fd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fd0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var.hashCode()) & i;
                p60 p60Var3 = p60VarArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                if (p60Var3 != null) {
                    if (!p60Var3.equals(p60Var)) {
                        do {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1) & i;
                            p60Var2 = p60VarArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                            if (p60Var2 == null) {
                            }
                        } while (!p60Var2.equals(p60Var));
                    }
                    fd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, p60VarArr, i);
                    z = true;
                    if (!z) {
                        return true;
                    }
                }
                z = false;
                if (!z) {
                }
            }
            return false;
        }
    }

    @Override // me.tvspark.h70
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60 p60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var, "d is null");
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            synchronized (this) {
                if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    fd0<p60> fd0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (fd0Var == null) {
                        fd0Var = new fd0<>();
                        this.Wwwwwwwwwwwwwwwwwwwwwwww = fd0Var;
                    }
                    fd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((fd0<p60>) p60Var);
                    return true;
                }
            }
        }
        p60Var.dispose();
        return false;
    }

    @Override // me.tvspark.h70
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60 p60Var) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var)) {
            p60Var.dispose();
            return true;
        }
        return false;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        p60[] p60VarArr;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        synchronized (this) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            fd0<p60> fd0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            ArrayList arrayList = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            if (fd0Var == null) {
                return;
            }
            for (p60 p60Var : fd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (p60Var instanceof p60) {
                    try {
                        p60Var.dispose();
                    } catch (Throwable th) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) arrayList.get(0));
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }
}

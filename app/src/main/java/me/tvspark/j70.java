package me.tvspark;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public final class j70 implements p60, h70 {
    public volatile boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public List<p60> Wwwwwwwwwwwwwwwwwwwwwwww;

    @Override // me.tvspark.h70
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60 p60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var, "Disposable item is null");
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        synchronized (this) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                return false;
            }
            List<p60> list = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (list != null && list.remove(p60Var)) {
                return true;
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
                    List list = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (list == null) {
                        list = new LinkedList();
                        this.Wwwwwwwwwwwwwwwwwwwwwwww = list;
                    }
                    list.add(p60Var);
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
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        synchronized (this) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            List<p60> list = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            ArrayList arrayList = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            if (list == null) {
                return;
            }
            for (p60 p60Var : list) {
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

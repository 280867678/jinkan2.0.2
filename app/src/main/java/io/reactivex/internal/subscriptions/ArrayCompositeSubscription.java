package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReferenceArray;
import me.tvspark.p60;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<t51> implements p60 {
    public static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i) {
        super(i);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        t51 andSet;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                t51 t51Var = get(i);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (t51Var != subscriptionHelper && (andSet = getAndSet(i, subscriptionHelper)) != SubscriptionHelper.CANCELLED && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }

    public t51 replaceResource(int i, t51 t51Var) {
        t51 t51Var2;
        do {
            t51Var2 = get(i);
            if (t51Var2 == SubscriptionHelper.CANCELLED) {
                if (t51Var == null) {
                    return null;
                }
                t51Var.cancel();
                return null;
            }
        } while (!compareAndSet(i, t51Var2, t51Var));
        return t51Var2;
    }

    public boolean setResource(int i, t51 t51Var) {
        t51 t51Var2;
        do {
            t51Var2 = get(i);
            if (t51Var2 == SubscriptionHelper.CANCELLED) {
                if (t51Var == null) {
                    return false;
                }
                t51Var.cancel();
                return false;
            }
        } while (!compareAndSet(i, t51Var2, t51Var));
        if (t51Var2 != null) {
            t51Var2.cancel();
            return true;
        }
        return true;
    }
}

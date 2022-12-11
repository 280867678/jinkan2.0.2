package io.reactivex.internal.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import me.tvspark.a70;
import me.tvspark.b70;
import me.tvspark.c60;
import me.tvspark.c70;
import me.tvspark.d70;
import me.tvspark.e70;
import me.tvspark.f70;
import me.tvspark.g70;
import me.tvspark.k60;
import me.tvspark.l70;
import me.tvspark.outline;
import me.tvspark.pd0;
import me.tvspark.r40;
import me.tvspark.r60;
import me.tvspark.s60;
import me.tvspark.t60;
import me.tvspark.v60;
import me.tvspark.x60;
import me.tvspark.y60;
import me.tvspark.z60;

/* loaded from: classes4.dex */
public final class Functions {
    public static final f70<Object, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwww();
    public static final r60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final x60<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final x60<Throwable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final g70<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final g70<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final Callable<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final Comparator<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* loaded from: classes4.dex */
    public enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwww<K, V, T> implements s60<Map<K, Collection<V>>, T> {
        public final f70<? super T, ? extends K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final f70<? super T, ? extends V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final f70<? super K, ? extends Collection<? super V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwww(f70<? super K, ? extends Collection<? super V>> f70Var, f70<? super T, ? extends V> f70Var2, f70<? super T, ? extends K> f70Var3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f70Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f70Var2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f70Var3;
        }

        @Override // me.tvspark.s60
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) throws Exception {
            Map map = (Map) obj;
            K apply = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.apply(obj2);
            Collection<? super V> collection = (Collection) map.get(apply);
            if (collection == null) {
                collection = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.apply(obj2));
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwww<K, V, T> implements s60<Map<K, V>, T> {
        public final f70<? super T, ? extends K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final f70<? super T, ? extends V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwww(f70<? super T, ? extends V> f70Var, f70<? super T, ? extends K> f70Var2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f70Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f70Var2;
        }

        @Override // me.tvspark.s60
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) throws Exception {
            ((Map) obj).put(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.apply(obj2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.apply(obj2));
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwww<K, T> implements s60<Map<K, T>, T> {
        public final f70<? super T, ? extends K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwww(f70<? super T, ? extends K> f70Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f70Var;
        }

        @Override // me.tvspark.s60
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) throws Exception {
            ((Map) obj).put(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.apply(obj2), obj2);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwww<T> implements f70<T, pd0<T>> {
        public final k60 Wwwwwwwwwwwwwwwwwwwwwww;
        public final TimeUnit Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwww(TimeUnit timeUnit, k60 k60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = timeUnit;
            this.Wwwwwwwwwwwwwwwwwwwwwww = k60Var;
        }

        @Override // me.tvspark.f70
        public Object apply(Object obj) throws Exception {
            return new pd0(obj, this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwww<T> implements x60<T> {
        public final x60<? super c60<T>> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwww(x60<? super c60<T>> x60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = x60Var;
        }

        @Override // me.tvspark.x60
        public void accept(T t) throws Exception {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.accept(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t));
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwww<T> implements x60<Throwable> {
        public final x60<? super c60<T>> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwww(x60<? super c60<T>> x60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = x60Var;
        }

        @Override // me.tvspark.x60
        public void accept(Throwable th) throws Exception {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.accept(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th));
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwww<T> implements r60 {
        public final x60<? super c60<T>> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwww(x60<? super c60<T>> x60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = x60Var;
        }

        @Override // me.tvspark.r60
        public void run() throws Exception {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.accept(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwww<T> implements f70<List<T>, List<T>> {
        public final Comparator<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwww(Comparator<? super T> comparator) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = comparator;
        }

        @Override // me.tvspark.f70
        public Object apply(Object obj) throws Exception {
            List list = (List) obj;
            Collections.sort(list, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            return list;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwww<T, U> implements Callable<U>, f70<T, U> {
        public final U Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwww(U u) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = u;
        }

        @Override // me.tvspark.f70
        public U apply(T t) throws Exception {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwww<T> implements g70<T> {
        public final T Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwww(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = t;
        }

        @Override // me.tvspark.g70
        public boolean test(T t) throws Exception {
            return l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwww<T, U> implements g70<T> {
        public final Class<U> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwww(Class<U> cls) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = cls;
        }

        @Override // me.tvspark.g70
        public boolean test(T t) throws Exception {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.isInstance(t);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwww<T, U> implements f70<T, U> {
        public final Class<U> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwww(Class<U> cls) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = cls;
        }

        @Override // me.tvspark.f70
        public U apply(T t) throws Exception {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.cast(t);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwww<T> implements g70<T> {
        public final v60 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwww(v60 v60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = v60Var;
        }

        @Override // me.tvspark.g70
        public boolean test(T t) throws Exception {
            return !this.Wwwwwwwwwwwwwwwwwwwwwwww.getAsBoolean();
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwww<T> implements Callable<List<T>> {
        public final int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            return new ArrayList(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwww<T> implements x60<T> {
        public final r60 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwww(r60 r60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = r60Var;
        }

        @Override // me.tvspark.x60
        public void accept(T t) throws Exception {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.run();
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwww implements f70<Object, Object> {
        @Override // me.tvspark.f70
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwww implements f70<Object[], R> {
        public final /* synthetic */ e70 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwww(e70 e70Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = e70Var;
        }

        @Override // me.tvspark.f70
        public Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length == 9) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6], objArr2[7], objArr2[8]);
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array of size 9 expected but got ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(objArr2.length);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwww implements f70<Object[], R> {
        public final /* synthetic */ d70 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwww(d70 d70Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = d70Var;
        }

        @Override // me.tvspark.f70
        public Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length == 8) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6], objArr2[7]);
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array of size 8 expected but got ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(objArr2.length);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwww implements f70<Object[], R> {
        public final /* synthetic */ c70 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwww(c70 c70Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = c70Var;
        }

        @Override // me.tvspark.f70
        public Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length == 7) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6]);
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array of size 7 expected but got ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(objArr2.length);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwww implements f70<Object[], R> {
        public final /* synthetic */ b70 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwww(b70 b70Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = b70Var;
        }

        @Override // me.tvspark.f70
        public Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length == 6) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5]);
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array of size 6 expected but got ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(objArr2.length);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwww implements f70<Object[], R> {
        public final /* synthetic */ a70 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwww(a70 a70Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = a70Var;
        }

        @Override // me.tvspark.f70
        public Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length == 5) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4]);
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array of size 5 expected but got ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(objArr2.length);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwww implements f70<Object[], R> {
        public final /* synthetic */ z60 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwww(z60 z60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = z60Var;
        }

        @Override // me.tvspark.f70
        public Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length == 4) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr2[0], objArr2[1], objArr2[2], objArr2[3]);
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array of size 4 expected but got ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(objArr2.length);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwww implements f70<Object[], R> {
        public final /* synthetic */ y60 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwww(y60 y60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = y60Var;
        }

        @Override // me.tvspark.f70
        public Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length == 3) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr2[0], objArr2[1], objArr2[2]);
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array of size 3 expected but got ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(objArr2.length);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements f70<Object[], R> {
        public final /* synthetic */ t60 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwww(t60 t60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = t60Var;
        }

        @Override // me.tvspark.f70
        public Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length == 2) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr2[0], objArr2[1]);
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array of size 2 expected but got ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(objArr2.length);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements g70<Object> {
        @Override // me.tvspark.g70
        public boolean test(Object obj) {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements g70<Object> {
        @Override // me.tvspark.g70
        public boolean test(Object obj) {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements x60<Throwable> {
        @Override // me.tvspark.x60
        public void accept(Throwable th) throws Exception {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements x60<Object> {
        @Override // me.tvspark.x60
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements r60 {
        @Override // me.tvspark.r60
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    public static <T, U> f70<T, U> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(U u) {
        return new Wwwwwwwwwwww(u);
    }

    public static <T> Comparator<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Callable<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        return new Wwwwwwwwwwww(t);
    }

    public static <T, U> g70<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<U> cls) {
        return new Wwwwwwwwwwwwww(cls);
    }

    public static <T> Callable<Set<T>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return HashSetCallable.INSTANCE;
    }

    public static <T> Callable<List<T>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return new Wwwwwwwwwwwwwwwww(i);
    }

    public static <T, U> f70<T, U> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<U> cls) {
        return new Wwwwwwwwwwwwwww(cls);
    }

    public static <T> f70<List<T>, List<T>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<? super T> comparator) {
        return new Wwwwwwwwwww(comparator);
    }

    public static <T> f70<T, pd0<T>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit timeUnit, k60 k60Var) {
        return new Wwwwwww(timeUnit, k60Var);
    }

    public static <T1, T2, T3, T4, T5, R> f70<Object[], R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a70<T1, T2, T3, T4, T5, R> a70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a70Var, "f is null");
        return new Wwwwwwwwwwwwwwwwwwwwwwww(a70Var);
    }

    public static <T1, T2, T3, T4, T5, T6, R> f70<Object[], R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b70<T1, T2, T3, T4, T5, T6, R> b70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b70Var, "f is null");
        return new Wwwwwwwwwwwwwwwwwwwwwww(b70Var);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> f70<Object[], R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c70<T1, T2, T3, T4, T5, T6, T7, R> c70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c70Var, "f is null");
        return new Wwwwwwwwwwwwwwwwwwwwww(c70Var);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> f70<Object[], R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d70<T1, T2, T3, T4, T5, T6, T7, T8, R> d70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d70Var, "f is null");
        return new Wwwwwwwwwwwwwwwwwwwww(d70Var);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f70<Object[], R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e70<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> e70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e70Var, "f is null");
        return new Wwwwwwwwwwwwwwwwwwww(e70Var);
    }

    public static <T1, T2, R> f70<Object[], R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t60<? super T1, ? super T2, ? extends R> t60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t60Var, "f is null");
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwww(t60Var);
    }

    public static <T1, T2, T3, R> f70<Object[], R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(y60<T1, T2, T3, R> y60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(y60Var, "f is null");
        return new Wwwwwwwwwwwwwwwwwwwwwwwwww(y60Var);
    }

    public static <T1, T2, T3, T4, R> f70<Object[], R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z60<T1, T2, T3, T4, R> z60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z60Var, "f is null");
        return new Wwwwwwwwwwwwwwwwwwwwwwwww(z60Var);
    }

    public static <T> g70<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        return new Wwwwwwwwwwwww(t);
    }

    public static <T> g70<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v60 v60Var) {
        return new Wwwwwwwwwwwwwwww(v60Var);
    }

    public static <T, K> s60<Map<K, T>, T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70<? super T, ? extends K> f70Var) {
        return new Wwwwww(f70Var);
    }

    public static <T, K, V> s60<Map<K, V>, T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2) {
        return new Wwwww(f70Var2, f70Var);
    }

    public static <T, K, V> s60<Map<K, Collection<V>>, T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2, f70<? super K, ? extends Collection<? super V>> f70Var3) {
        return new Wwww(f70Var3, f70Var2, f70Var);
    }

    public static <T> x60<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60<? super c60<T>> x60Var) {
        return new Wwwwwwww(x60Var);
    }
}

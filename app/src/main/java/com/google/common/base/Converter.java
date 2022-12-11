package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import me.tvspark.AbstractC2271jt;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public abstract class Converter<A, B> implements AbstractC2271jt<A, B> {
    public final boolean handleNullAutomatically;
    public transient Converter<B, A> reverse;

    /* loaded from: classes3.dex */
    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        public static final long serialVersionUID = 0;
        public final Converter<A, B> first;
        public final Converter<B, C> second;

        public ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.common.base.Converter
        public A correctedDoBackward(C c) {
            return this.first.correctedDoBackward(this.second.correctedDoBackward(c));
        }

        @Override // com.google.common.base.Converter
        public C correctedDoForward(A a) {
            return this.second.correctedDoForward(this.first.correctedDoForward(a));
        }

        @Override // com.google.common.base.Converter
        public A doBackward(C c) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public C doForward(A a) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, me.tvspark.AbstractC2271jt
        public boolean equals(Object obj) {
            if (obj instanceof ConverterComposition) {
                ConverterComposition converterComposition = (ConverterComposition) obj;
                return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
            }
            return false;
        }

        public int hashCode() {
            return this.second.hashCode() + (this.first.hashCode() * 31);
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    /* loaded from: classes3.dex */
    public static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        public final AbstractC2271jt<? super B, ? extends A> backwardFunction;
        public final AbstractC2271jt<? super A, ? extends B> forwardFunction;

        public FunctionBasedConverter(AbstractC2271jt<? super A, ? extends B> abstractC2271jt, AbstractC2271jt<? super B, ? extends A> abstractC2271jt2) {
            if (abstractC2271jt != null) {
                this.forwardFunction = abstractC2271jt;
                if (abstractC2271jt2 == null) {
                    throw null;
                }
                this.backwardFunction = abstractC2271jt2;
                return;
            }
            throw null;
        }

        public /* synthetic */ FunctionBasedConverter(AbstractC2271jt abstractC2271jt, AbstractC2271jt abstractC2271jt2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this(abstractC2271jt, abstractC2271jt2);
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b) {
            return this.backwardFunction.mo4462apply(b);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a) {
            return this.forwardFunction.mo4462apply(a);
        }

        @Override // com.google.common.base.Converter, me.tvspark.AbstractC2271jt
        public boolean equals(Object obj) {
            if (obj instanceof FunctionBasedConverter) {
                FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
                return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
            }
            return false;
        }

        public int hashCode() {
            return this.backwardFunction.hashCode() + (this.forwardFunction.hashCode() * 31);
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Converter.from(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.forwardFunction);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.backwardFunction);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        public static final IdentityConverter INSTANCE = new IdentityConverter();
        public static final long serialVersionUID = 0;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(converter, "otherConverter");
            return converter;
        }

        @Override // com.google.common.base.Converter
        public T doBackward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        public T doForward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        /* renamed from: reverse */
        public IdentityConverter<T> mo4460reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    /* loaded from: classes3.dex */
    public static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        public static final long serialVersionUID = 0;
        public final Converter<A, B> original;

        public ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        @Override // com.google.common.base.Converter
        public B correctedDoBackward(A a) {
            return this.original.correctedDoForward(a);
        }

        @Override // com.google.common.base.Converter
        public A correctedDoForward(B b) {
            return this.original.correctedDoBackward(b);
        }

        @Override // com.google.common.base.Converter
        public B doBackward(A a) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public A doForward(B b) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, me.tvspark.AbstractC2271jt
        public boolean equals(Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
        /* renamed from: reverse */
        public Converter<A, B> mo4460reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterable<B> {
        public final /* synthetic */ Iterable Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: com.google.common.base.Converter$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C3452Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<B> {
            public final Iterator<? extends A> Wwwwwwwwwwwwwwwwwwwwwwww;

            public C3452Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
            }

            @Override // java.util.Iterator
            public B next() {
                return (B) Converter.this.convert(this.Wwwwwwwwwwwwwwwwwwwwwwww.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.remove();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable iterable) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<B> iterator() {
            return new C3452Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public Converter() {
        this(true);
    }

    public Converter(boolean z) {
        this.handleNullAutomatically = z;
    }

    public static <A, B> Converter<A, B> from(AbstractC2271jt<? super A, ? extends B> abstractC2271jt, AbstractC2271jt<? super B, ? extends A> abstractC2271jt2) {
        return new FunctionBasedConverter(abstractC2271jt, abstractC2271jt2, null);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // me.tvspark.AbstractC2271jt
    @Deprecated
    /* renamed from: apply */
    public final B mo4462apply(A a) {
        return convert(a);
    }

    public final B convert(A a) {
        return correctedDoForward(a);
    }

    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "fromIterable");
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable);
    }

    public A correctedDoBackward(B b) {
        if (this.handleNullAutomatically) {
            if (b == null) {
                return null;
            }
            A doBackward = doBackward(b);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(doBackward);
            return doBackward;
        }
        return doBackward(b);
    }

    public B correctedDoForward(A a) {
        if (this.handleNullAutomatically) {
            if (a == null) {
                return null;
            }
            B doForward = doForward(a);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(doForward);
            return doForward;
        }
        return doForward(a);
    }

    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        if (converter != null) {
            return new ConverterComposition(this, converter);
        }
        throw null;
    }

    public abstract A doBackward(B b);

    public abstract B doForward(A a);

    @Override // me.tvspark.AbstractC2271jt
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: reverse */
    public Converter<B, A> mo4460reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter == null) {
            ReverseConverter reverseConverter = new ReverseConverter(this);
            this.reverse = reverseConverter;
            return reverseConverter;
        }
        return converter;
    }
}

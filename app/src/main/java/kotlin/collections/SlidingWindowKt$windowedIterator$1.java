package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import me.tvspark.ak0;
import me.tvspark.ef0;
import me.tvspark.eg0;
import me.tvspark.ii0;
import me.tvspark.mg0;
import me.tvspark.mh0;
import me.tvspark.of0;
import me.tvspark.r40;
import me.tvspark.rg0;

@rg0(m188c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", m187f = "SlidingWindow.kt", m186l = {34, 40, 49, 55, 58}, m185m = "invokeSuspend")
@ef0
/* loaded from: classes4.dex */
public final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements mh0<ak0<? super List<? extends T>>, mg0<? super of0>, Object> {
    public final /* synthetic */ Iterator $iterator;
    public final /* synthetic */ boolean $partialWindows;
    public final /* synthetic */ boolean $reuseBuffer;
    public final /* synthetic */ int $size;
    public final /* synthetic */ int $step;
    public int I$0;
    public int I$1;
    public int I$2;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* renamed from: p$ */
    public ak0 f4478p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, mg0 mg0Var) {
        super(2, mg0Var);
        this.$size = i;
        this.$step = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final mg0<of0> create(Object obj, mg0<?> mg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "completion");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, mg0Var);
        slidingWindowKt$windowedIterator$1.f4478p$ = (ak0) obj;
        return slidingWindowKt$windowedIterator$1;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public final Object mo4918invoke(Object obj, mg0<? super of0> mg0Var) {
        return ((SlidingWindowKt$windowedIterator$1) create(obj, mg0Var)).invokeSuspend(of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0099  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x01c2 -> B:16:0x01c5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0139 -> B:33:0x018f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0161 -> B:33:0x018f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0187 -> B:32:0x018a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x00c1 -> B:70:0x00c4). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        eg0 eg0Var;
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1;
        ak0 ak0Var;
        Iterator it;
        int i2;
        int i3;
        ArrayList arrayList;
        int i4;
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$12;
        ak0 ak0Var2;
        Iterator it2;
        eg0 eg0Var2;
        int i5;
        int i6;
        ak0 ak0Var3;
        Object[] array;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i7 = this.label;
        int i8 = 0;
        if (i7 != 0) {
            if (i7 == 1) {
                it2 = (Iterator) this.L$3;
                arrayList = (ArrayList) this.L$1;
                int i9 = this.I$1;
                i4 = this.I$0;
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                slidingWindowKt$windowedIterator$12 = this;
                i = i9;
                ak0Var2 = (ak0) this.L$0;
                if (!slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                    arrayList.clear();
                } else {
                    arrayList = new ArrayList(slidingWindowKt$windowedIterator$12.$size);
                }
                i8 = i;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (i8 > 0) {
                        i8--;
                    } else {
                        arrayList.add(next);
                        if (arrayList.size() == slidingWindowKt$windowedIterator$12.$size) {
                            slidingWindowKt$windowedIterator$12.L$0 = ak0Var2;
                            slidingWindowKt$windowedIterator$12.I$0 = i4;
                            slidingWindowKt$windowedIterator$12.I$1 = i;
                            slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                            slidingWindowKt$windowedIterator$12.I$2 = i8;
                            slidingWindowKt$windowedIterator$12.L$2 = next;
                            slidingWindowKt$windowedIterator$12.L$3 = it2;
                            slidingWindowKt$windowedIterator$12.label = 1;
                            if (ak0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) arrayList, (mg0<? super of0>) slidingWindowKt$windowedIterator$12) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            if (!slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                            }
                            i8 = i;
                            while (it2.hasNext()) {
                            }
                        }
                    }
                }
                if ((!arrayList.isEmpty()) && (slidingWindowKt$windowedIterator$12.$partialWindows || arrayList.size() == slidingWindowKt$windowedIterator$12.$size)) {
                    slidingWindowKt$windowedIterator$12.L$0 = ak0Var2;
                    slidingWindowKt$windowedIterator$12.I$0 = i4;
                    slidingWindowKt$windowedIterator$12.I$1 = i;
                    slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                    slidingWindowKt$windowedIterator$12.I$2 = i8;
                    slidingWindowKt$windowedIterator$12.label = 2;
                    if (ak0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) arrayList, (mg0<? super of0>) slidingWindowKt$windowedIterator$12) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (i7 == 2) {
                ArrayList arrayList2 = (ArrayList) this.L$1;
            } else if (i7 == 3) {
                it = (Iterator) this.L$3;
                eg0Var = (eg0) this.L$1;
                i3 = this.I$1;
                i2 = this.I$0;
                ak0Var = (ak0) this.L$0;
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                slidingWindowKt$windowedIterator$1 = this;
                eg0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(slidingWindowKt$windowedIterator$1.$step);
                if (it.hasNext()) {
                    Object next2 = it.next();
                    if (!(eg0Var.Wwwwwwwwwwwwwwwwwwwwww == eg0Var.Wwwwwwwwwwwwwwwwwwwwwwww)) {
                        Object[] objArr = eg0Var.Wwwwwwwwwwwwwwwwwwwww;
                        int i10 = eg0Var.Wwwwwwwwwwwwwwwwwwwwwww;
                        int i11 = eg0Var.Wwwwwwwwwwwwwwwwwwwwww;
                        int i12 = eg0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                        objArr[(i10 + i11) % i12] = next2;
                        int i13 = i11 + 1;
                        eg0Var.Wwwwwwwwwwwwwwwwwwwwww = i13;
                        if (i13 == i12) {
                            int i14 = eg0Var.Wwwwwwwwwwwwwwwwwwwwww;
                            int i15 = slidingWindowKt$windowedIterator$1.$size;
                            if (i14 < i15) {
                                int i16 = eg0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                                int i17 = i16 + (i16 >> 1) + 1;
                                if (i17 <= i15) {
                                    i15 = i17;
                                }
                                if (eg0Var.Wwwwwwwwwwwwwwwwwwwwwww == 0) {
                                    array = Arrays.copyOf(eg0Var.Wwwwwwwwwwwwwwwwwwwww, i15);
                                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(array, "java.util.Arrays.copyOf(this, newSize)");
                                } else {
                                    array = eg0Var.toArray(new Object[i15]);
                                }
                                eg0Var = new eg0(array, eg0Var.Wwwwwwwwwwwwwwwwwwwwww);
                            } else {
                                RandomAccess arrayList3 = slidingWindowKt$windowedIterator$1.$reuseBuffer ? eg0Var : new ArrayList(eg0Var);
                                slidingWindowKt$windowedIterator$1.L$0 = ak0Var;
                                slidingWindowKt$windowedIterator$1.I$0 = i2;
                                slidingWindowKt$windowedIterator$1.I$1 = i3;
                                slidingWindowKt$windowedIterator$1.L$1 = eg0Var;
                                slidingWindowKt$windowedIterator$1.L$2 = next2;
                                slidingWindowKt$windowedIterator$1.L$3 = it;
                                slidingWindowKt$windowedIterator$1.label = 3;
                                if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) arrayList3, (mg0<? super of0>) slidingWindowKt$windowedIterator$1) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                eg0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(slidingWindowKt$windowedIterator$1.$step);
                            }
                        }
                        if (it.hasNext()) {
                            if (slidingWindowKt$windowedIterator$1.$partialWindows) {
                                eg0Var2 = eg0Var;
                                i5 = i3;
                                i6 = i2;
                                ak0Var3 = ak0Var;
                                if (eg0Var2.Wwwwwwwwwwwwwwwwwwwwww <= slidingWindowKt$windowedIterator$1.$step) {
                                }
                            }
                            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                    } else {
                        throw new IllegalStateException("ring buffer is full");
                    }
                }
            } else if (i7 == 4) {
                eg0Var2 = (eg0) this.L$1;
                i5 = this.I$1;
                i6 = this.I$0;
                ak0Var3 = (ak0) this.L$0;
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                slidingWindowKt$windowedIterator$1 = this;
                eg0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(slidingWindowKt$windowedIterator$1.$step);
                if (eg0Var2.Wwwwwwwwwwwwwwwwwwwwww <= slidingWindowKt$windowedIterator$1.$step) {
                    RandomAccess arrayList4 = slidingWindowKt$windowedIterator$1.$reuseBuffer ? eg0Var2 : new ArrayList(eg0Var2);
                    slidingWindowKt$windowedIterator$1.L$0 = ak0Var3;
                    slidingWindowKt$windowedIterator$1.I$0 = i6;
                    slidingWindowKt$windowedIterator$1.I$1 = i5;
                    slidingWindowKt$windowedIterator$1.L$1 = eg0Var2;
                    slidingWindowKt$windowedIterator$1.label = 4;
                    if (ak0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) arrayList4, (mg0<? super of0>) slidingWindowKt$windowedIterator$1) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    eg0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(slidingWindowKt$windowedIterator$1.$step);
                    if (eg0Var2.Wwwwwwwwwwwwwwwwwwwwww <= slidingWindowKt$windowedIterator$1.$step) {
                        if (!eg0Var2.isEmpty()) {
                            slidingWindowKt$windowedIterator$1.L$0 = ak0Var3;
                            slidingWindowKt$windowedIterator$1.I$0 = i6;
                            slidingWindowKt$windowedIterator$1.I$1 = i5;
                            slidingWindowKt$windowedIterator$1.L$1 = eg0Var2;
                            slidingWindowKt$windowedIterator$1.label = 5;
                            if (ak0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) eg0Var2, (mg0<? super of0>) slidingWindowKt$windowedIterator$1) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                }
            } else if (i7 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                eg0 eg0Var3 = (eg0) this.L$1;
            }
            ak0 ak0Var4 = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        ak0 ak0Var5 = this.f4478p$;
        int i18 = this.$size;
        if (i18 > 1024) {
            i18 = 1024;
        }
        i = this.$step - this.$size;
        if (i >= 0) {
            arrayList = new ArrayList(i18);
            i4 = i18;
            slidingWindowKt$windowedIterator$12 = this;
            ak0Var2 = ak0Var5;
            it2 = this.$iterator;
            while (it2.hasNext()) {
            }
            if (!arrayList.isEmpty()) {
                slidingWindowKt$windowedIterator$12.L$0 = ak0Var2;
                slidingWindowKt$windowedIterator$12.I$0 = i4;
                slidingWindowKt$windowedIterator$12.I$1 = i;
                slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                slidingWindowKt$windowedIterator$12.I$2 = i8;
                slidingWindowKt$windowedIterator$12.label = 2;
                if (ak0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) arrayList, (mg0<? super of0>) slidingWindowKt$windowedIterator$12) == coroutineSingletons) {
                }
            }
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        eg0Var = new eg0(new Object[i18], 0);
        slidingWindowKt$windowedIterator$1 = this;
        ak0Var = ak0Var5;
        it = this.$iterator;
        i2 = i18;
        i3 = i;
        if (it.hasNext()) {
        }
    }
}

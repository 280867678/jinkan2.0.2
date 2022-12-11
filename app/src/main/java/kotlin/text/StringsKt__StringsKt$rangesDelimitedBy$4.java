package kotlin.text;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import me.tvspark.bj0;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mh0;
import me.tvspark.nk0;

@ef0
/* loaded from: classes4.dex */
public final class StringsKt__StringsKt$rangesDelimitedBy$4 extends Lambda implements mh0<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List $delimitersList;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$4(List list, boolean z) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> mo4918invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i) {
        Object obj;
        Pair pair;
        Object obj2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$receiver");
        List list = this.$delimitersList;
        boolean z = this.$ignoreCase;
        if (!z && list.size() == 1) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "$this$single");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "$this$single");
            int size = list.size();
            if (size == 0) {
                throw new NoSuchElementException("List is empty.");
            }
            if (size == 1) {
                String str = (String) list.get(0);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, str, i, false, 4);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 0) {
                    pair = new Pair(Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), str);
                }
                pair = null;
            } else {
                throw new IllegalArgumentException("List has more than one element.");
            }
        } else {
            if (i < 0) {
                i = 0;
            }
            bj0 bj0Var = new bj0(i, charSequence.length());
            if (charSequence instanceof String) {
                int i2 = bj0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = bj0Var.Wwwwwwwwwwwwwwwwwwwwwww;
                int i4 = bj0Var.Wwwwwwwwwwwwwwwwwwwwww;
                if (i4 < 0 ? i2 >= i3 : i2 <= i3) {
                    while (true) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str2 = (String) obj2;
                            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, 0, (String) charSequence, i2, str2.length(), z)) {
                                break;
                            }
                        }
                        String str3 = (String) obj2;
                        if (str3 == null) {
                            if (i2 == i3) {
                                break;
                            }
                            i2 += i4;
                        } else {
                            pair = new Pair(Integer.valueOf(i2), str3);
                            break;
                        }
                    }
                }
                pair = null;
            } else {
                int i5 = bj0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i6 = bj0Var.Wwwwwwwwwwwwwwwwwwwwwww;
                int i7 = bj0Var.Wwwwwwwwwwwwwwwwwwwwww;
                if (i7 < 0 ? i5 >= i6 : i5 <= i6) {
                    while (true) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str4 = (String) obj;
                            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4, 0, charSequence, i5, str4.length(), z)) {
                                break;
                            }
                        }
                        String str5 = (String) obj;
                        if (str5 == null) {
                            if (i5 == i6) {
                                break;
                            }
                            i5 += i7;
                        } else {
                            pair = new Pair(Integer.valueOf(i5), str5);
                            break;
                        }
                    }
                }
                pair = null;
            }
        }
        if (pair != null) {
            return new Pair<>(pair.getFirst(), Integer.valueOf(((String) pair.getSecond()).length()));
        }
        return null;
    }
}

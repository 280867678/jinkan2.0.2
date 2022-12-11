package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.sf0;

@ef0
/* loaded from: classes4.dex */
public final class AbstractMap$toString$1 extends Lambda implements ih0<Map.Entry<? extends K, ? extends V>, CharSequence> {
    public final /* synthetic */ sf0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractMap$toString$1(sf0 sf0Var) {
        super(1);
        this.this$0 = sf0Var;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public final CharSequence mo4916invoke(Map.Entry<? extends K, ? extends V> entry) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry, "it");
        sf0 sf0Var = this.this$0;
        if (sf0Var != null) {
            StringBuilder sb = new StringBuilder();
            Object key = entry.getKey();
            String str = "(this Map)";
            sb.append(key == sf0Var ? str : String.valueOf(key));
            sb.append("=");
            Object value = entry.getValue();
            if (value != sf0Var) {
                str = String.valueOf(value);
            }
            sb.append(str);
            return sb.toString();
        }
        throw null;
    }
}

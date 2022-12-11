package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.r40;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class CharDirectionality$Companion$directionalityMap$2 extends Lambda implements xg0<Map<Integer, ? extends CharDirectionality>> {
    public static final CharDirectionality$Companion$directionalityMap$2 INSTANCE = new CharDirectionality$Companion$directionalityMap$2();

    public CharDirectionality$Companion$directionalityMap$2() {
        super(0);
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Map<Integer, ? extends CharDirectionality> mo4969invoke() {
        CharDirectionality[] values = CharDirectionality.values();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(values.length);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww < 16) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        for (CharDirectionality charDirectionality : values) {
            linkedHashMap.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
        }
        return linkedHashMap;
    }
}

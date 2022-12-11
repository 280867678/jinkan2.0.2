package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.r40;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class CharCategory$Companion$categoryMap$2 extends Lambda implements xg0<Map<Integer, ? extends CharCategory>> {
    public static final CharCategory$Companion$categoryMap$2 INSTANCE = new CharCategory$Companion$categoryMap$2();

    public CharCategory$Companion$categoryMap$2() {
        super(0);
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Map<Integer, ? extends CharCategory> mo4969invoke() {
        CharCategory[] values = CharCategory.values();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(values.length);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww < 16) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        for (CharCategory charCategory : values) {
            linkedHashMap.put(Integer.valueOf(charCategory.getValue()), charCategory);
        }
        return linkedHashMap;
    }
}

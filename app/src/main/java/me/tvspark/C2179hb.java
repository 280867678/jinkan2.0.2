package me.tvspark;

import java.util.List;
import me.tvspark.AbstractC2327lb;
import me.tvspark.C2245j3;

/* renamed from: me.tvspark.hb */
/* loaded from: classes4.dex */
public final class C2179hb {
    public final AbstractC2740w7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<C2245j3> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2179hb(List<C2245j3> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2740w7[list.size()];
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length; i++) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 3);
            C2245j3 c2245j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            String str = c2245j3.Wwwwwwwwwwwww;
            boolean z = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String valueOf = String.valueOf(str);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, (Object) (valueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(valueOf) : new String("Invalid closed caption mime type provided: ")));
            String str2 = c2245j3.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (str2 == null) {
                str2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = str;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwww = c2245j3.Kkkkkkkkkkkkkkkkkkk;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }
}

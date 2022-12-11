package me.tvspark;

import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.support.contentdirectory.DIDLParser;
import org.fourthline.cling.support.model.DIDLContent;
import org.fourthline.cling.support.model.item.Item;

/* loaded from: classes4.dex */
public class bp0 implements AbstractC3509oo0 {
    public final /* synthetic */ ControlManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AbstractC3509oo0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Item Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC3509oo0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC3509oo0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            bp0 bp0Var = bp0.this;
            bp0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bp0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC3509oo0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
            bp0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str);
        }
    }

    public bp0(ControlManager controlManager, Item item, AbstractC3509oo0 abstractC3509oo0) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = controlManager;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = item;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC3509oo0;
    }

    @Override // me.tvspark.AbstractC3509oo0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String str;
        ControlManager controlManager = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Item item = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(101, "service is null");
            return;
        }
        String value = item.getFirstResource().getValue();
        DIDLContent dIDLContent = new DIDLContent();
        dIDLContent.addItem(item);
        try {
            str = new DIDLParser().generate(dIDLContent);
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        String str2 = str;
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("metadata: %s", str2);
        ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(new kp0(controlManager, controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, value, str2, value, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.AbstractC3509oo0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str);
    }
}

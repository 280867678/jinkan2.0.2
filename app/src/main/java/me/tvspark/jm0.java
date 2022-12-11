package me.tvspark;

import java.util.HashMap;
import me.tvspark.utils.sniffer.dialog.DialogParse;

/* loaded from: classes4.dex */
public class jm0 extends zk0<en0> implements dn0 {
    public HashMap<String, String> Wwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogParse.Wwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ((en0) jm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ((en0) jm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogParse.Wwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ((en0) jm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ((en0) jm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        HashMap<String, String> hashMap = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // me.tvspark.dn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, String str2) {
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.put(str, str2);
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwww.remove(str);
        }
    }

    @Override // me.tvspark.dn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, String str2, String str3, String str4, String str5, int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        ((en0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwwwwwwwwwww.containsKey(str3)) {
            DialogParse dialogParse = new DialogParse(((en0) this.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext());
            dialogParse.Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            dialogParse.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, str5);
            dialogParse.Kkkkkkkkkkkkkkkkk = z;
            dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", this.Wwwwwwwwwwwwwwwwwwwwwww.get(str3), str2, str3, str4, str5, i);
            return;
        }
        DialogParse dialogParse2 = new DialogParse(((en0) this.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext(), str, str4, str3, str2, str5, i, false);
        dialogParse2.Kkkkkkkkkkkkkkkkk = z;
        dialogParse2.Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        dialogParse2.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, str5);
        dialogParse2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogParse.Wwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, DialogParse dialogParse) {
            if (dialogParse != null) {
                dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ((en0) jm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, boolean z) {
            if (!z && str.startsWith("http")) {
                jm0.this.Wwwwwwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str);
            }
            ((en0) jm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, str);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogParse.Wwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, DialogParse dialogParse) {
            if (dialogParse != null) {
                dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ((en0) jm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, boolean z) {
            if (!z && str.startsWith("http")) {
                jm0.this.Wwwwwwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str);
            }
            ((en0) jm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, str);
        }
    }
}

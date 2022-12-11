package me.tvspark;

import java.io.IOException;
import me.tvspark.rv0;

/* loaded from: classes4.dex */
public class ov0 {
    public static final ov0 Wwwwwwwwwwwwwwwwwwwwwwwwwww = new ov0(0);
    public rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        new ov0(-1);
        new ov0(2);
    }

    public ov0(int i) {
        boolean z = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 1) == 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 4) == 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 2) == 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 16) > 0 ? true : z;
        rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 8) > 0 ? rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : rv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Appendable appendable, String str) throws IOException {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
            appendable.append(str);
            return;
        }
        appendable.append('\"');
        qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, appendable, this);
        appendable.append('\"');
    }
}

package me.tvspark;

import android.app.Dialog;
import android.text.TextUtils;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.cu0;
import me.tvspark.nn0;
import me.tvspark.view.fragment.SiteFragment;
import me.tvspark.view.fragment.WebSourceFragment;

/* loaded from: classes4.dex */
public class vt0 implements nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ WebSourceFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog) {
            dialog.dismiss();
        }

        @Override // me.tvspark.cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog, String str) {
            dialog.dismiss();
            WebSourceFragment webSourceFragment = vt0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (webSourceFragment.Wwwwwwwwwwwwww != 1) {
                webSourceFragment.Wwwwwwwwwwww = str;
                webSourceFragment.viewpager.setCurrentItem(1);
                return;
            }
            SiteFragment siteFragment = webSourceFragment.Wwwwwwwwwwwww;
            if (siteFragment == null) {
                return;
            }
            siteFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }
    }

    public vt0(WebSourceFragment webSourceFragment) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webSourceFragment;
    }

    @Override // me.tvspark.nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        BaseActivity baseActivity;
        if (!TextUtils.isEmpty(str)) {
            if ((!str.startsWith("whale://") && !str.startsWith("whalev2://") && !str.startsWith("tita://") && !str.startsWith("titav2://")) || bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("clipboard_content").equals(str)) {
                return;
            }
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("clipboard_content", str);
            baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            cu0 cu0Var = new cu0(baseActivity, "检测到你复制了站源规则", str);
            cu0Var.Wwwwwwwww = str;
            cu0Var.Wwwwwwwwwwwwww = 2;
            cu0Var.Wwwwwwwwwwwww = "取 消";
            cu0Var.Wwwwwwwwwwww = "导 入";
            cu0Var.Wwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            cu0Var.Wwwwww = 19;
            cu0Var.Wwwww = 13;
            cu0Var.Wwwwwwwwwwwwww = 3;
            cu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }
}

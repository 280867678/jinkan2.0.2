package me.tvspark;

import android.content.DialogInterface;
import com.just.agentweb.AgentWeb;
import me.tvspark.view.activity.WebSnifferActivity;

/* loaded from: classes4.dex */
public class ft0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ WebSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    public ft0(WebSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwww;
        if (i == 0) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("vip_browser_ua", 0);
            str = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwww;
        } else if (i == 1) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("vip_browser_ua", 1);
            str = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36";
        }
        AgentWeb agentWeb = WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwww;
        if (agentWeb != null) {
            agentWeb.getWebCreator().getWebView().stopLoading();
            WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwww.getAgentWebSettings().getWebSettings().setUserAgentString(str);
            WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwww.getWebCreator().getWebView().loadUrl(WebSnifferActivity.this.Wwwwwwwwwwwwwwwwww);
            WebSnifferActivity.this.Wwwwwwwwwwwww();
        }
    }
}

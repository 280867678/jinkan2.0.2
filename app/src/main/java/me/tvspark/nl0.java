package me.tvspark;

import android.text.TextUtils;
import java.util.List;
import me.tvspark.data.bean.EngineResultParcel;
import me.tvspark.model.analyzeRule.AnalyzeRule;
import org.litepal.crud.callback.FindCallback;

/* loaded from: classes4.dex */
public class nl0 implements FindCallback<Boolean> {
    public final /* synthetic */ ol0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AnalyzeRule Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ EngineResultParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public nl0(ol0 ol0Var, EngineResultParcel engineResultParcel, AnalyzeRule analyzeRule, Object obj, List list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ol0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = engineResultParcel;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = analyzeRule;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
    }

    @Override // org.litepal.crud.callback.FindCallback
    public void onFinish(Boolean bool) {
        EngineResultParcel engineResultParcel;
        String str;
        EngineResultParcel engineResultParcel2;
        String str2;
        if (!bool.booleanValue()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setCover(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getSearchCoverPrefix() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchCover()));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setActor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchActor()));
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getSearchLinkPrefix())) {
                engineResultParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchLink());
            } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getSearchLinkPrefix().contains("{id}")) {
                engineResultParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getSearchLinkPrefix().replace("{id}", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchLink()));
            } else {
                engineResultParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getSearchLinkPrefix() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchLink());
            }
            engineResultParcel.setLink(str);
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink().startsWith("http") && !TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl())) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink().startsWith("/")) {
                    engineResultParcel2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    str2 = co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl()) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink();
                } else {
                    engineResultParcel2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    str2 = co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl()) + "/" + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink();
                }
                engineResultParcel2.setLink(str2);
            }
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink())) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}

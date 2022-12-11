package me.tvspark;

import android.text.TextUtils;
import java.util.List;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.model.analyzeRule.AnalyzeRule;
import org.litepal.crud.callback.FindCallback;

/* loaded from: classes4.dex */
public class wl0 implements FindCallback<Boolean> {
    public final /* synthetic */ xl0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AnalyzeRule Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ VideoParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public wl0(xl0 xl0Var, VideoParcel videoParcel, AnalyzeRule analyzeRule, Object obj, List list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = xl0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = videoParcel;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = analyzeRule;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
    }

    @Override // org.litepal.crud.callback.FindCallback
    public void onFinish(Boolean bool) {
        VideoParcel videoParcel;
        String str;
        if (!bool.booleanValue()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setLink(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.getIndexOtherLinkPrefix() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.getRuleIndexOtherLink()));
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink().startsWith("http") && !TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl())) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink().startsWith("/")) {
                    videoParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    str = co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl()) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink();
                } else {
                    videoParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    str = co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl()) + "/" + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink();
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setCoverUrl(un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.getIndexOtherCoverPrefix(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.getRuleIndexOtherCover())));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setActor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.getRuleIndexOtherActor()));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        videoParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        str = "";
        videoParcel.setLink(str);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setCoverUrl(un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.getIndexOtherCoverPrefix(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.getRuleIndexOtherCover())));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setActor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.getRuleIndexOtherActor()));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}

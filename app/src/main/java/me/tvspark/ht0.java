package me.tvspark;

import android.widget.ImageView;
import me.tvspark.view.activity.WebSnifferActivity;
import org.litepal.crud.callback.CountCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class ht0 implements CountCallback {
    public final /* synthetic */ WebSnifferActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public ht0(WebSnifferActivity webSnifferActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webSnifferActivity;
    }

    @Override // org.litepal.crud.callback.CountCallback
    public void onFinish(int i) {
        ImageView imageView;
        int i2;
        if (i != 0) {
            WebSnifferActivity webSnifferActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            webSnifferActivity.Wwwwwwwwww = true;
            imageView = webSnifferActivity.ivWebCollect;
            i2 = R.drawable.ic_web_collect_yes;
        } else {
            WebSnifferActivity webSnifferActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            webSnifferActivity2.Wwwwwwwwww = false;
            imageView = webSnifferActivity2.ivWebCollect;
            i2 = R.drawable.ic_web_collect_no;
        }
        imageView.setImageResource(i2);
    }
}

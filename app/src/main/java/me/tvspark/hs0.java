package me.tvspark;

import android.widget.ImageView;
import me.tvspark.view.activity.DetailActivity;
import org.litepal.crud.callback.CountCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class hs0 implements CountCallback {
    public final /* synthetic */ DetailActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public hs0(DetailActivity detailActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = detailActivity;
    }

    @Override // org.litepal.crud.callback.CountCallback
    public void onFinish(int i) {
        ImageView imageView;
        int i2;
        if (i != 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.tvOperate4.setText("已收藏");
            imageView = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ivOperate4;
            i2 = R.drawable.ic_detail_collect_yes;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.tvOperate4.setText("收藏");
            imageView = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ivOperate4;
            i2 = R.drawable.ic_detail_collect_no;
        }
        imageView.setImageResource(i2);
    }
}

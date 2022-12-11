package me.tvspark;

import android.content.DialogInterface;
import com.arialyy.aria.core.Aria;
import java.util.List;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.MyDownData;
import me.tvspark.view.activity.AllDownParentActivity;

/* loaded from: classes4.dex */
public class wr0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ AllDownParentActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ MyDownData Wwwwwwwwwwwwwwwwwwwwwwww;

    public wr0(AllDownParentActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, MyDownData myDownData, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = myDownData;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        BaseActivity baseActivity;
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getDirName());
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getDirPath());
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getDirName());
        for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwww.getChildList().size(); i2++) {
            baseActivity = AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            Aria.download(baseActivity).load(this.Wwwwwwwwwwwwwwwwwwwwwwww.getChildList().get(i2).getId()).cancel(false);
        }
        List<MyDownData> list = AllDownParentActivity.this.Wwwwwwwwwwwwwwwww;
        if (list != null) {
            int size = list.size();
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (size <= i3) {
                return;
            }
            AllDownParentActivity.this.Wwwwwwwwwwwwwwwww.remove(i3);
            AllDownParentActivity allDownParentActivity = AllDownParentActivity.this;
            allDownParentActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(allDownParentActivity.Wwwwwwwwwwwwwwwww, false);
        }
    }
}

package me.tvspark;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.EditText;
import com.arialyy.aria.core.Aria;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.view.activity.WebSnifferActivity;

/* loaded from: classes4.dex */
public class gt0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ WebSnifferActivity Wwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

    public gt0(WebSnifferActivity webSnifferActivity, EditText editText, EditText editText2, String str) {
        this.Wwwwwwwwwwwwwwwwwwwww = webSnifferActivity;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
        this.Wwwwwwwwwwwwwwwwwwwwwww = editText2;
        this.Wwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        String obj = this.Wwwwwwwwwwwwwwwwwwwwwwww.getText().toString();
        String obj2 = this.Wwwwwwwwwwwwwwwwwwwwwww.getText().toString();
        if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
            baseActivity = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, "请完整填写正确内容");
            return;
        }
        baseActivity2 = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
        if (Aria.download(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww).taskExists(this.Wwwwwwwwwwwwwwwwwwwwww)) {
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, "已存在，请查看我的缓存");
            return;
        }
        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, "加入缓存任务列表");
        String replace = obj.replace("/", "");
        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww) + "download/" + replace + "/" + obj2.replace("/", "") + "-" + replace, -1L, 0);
    }
}

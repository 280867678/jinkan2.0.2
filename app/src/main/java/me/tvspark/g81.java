package me.tvspark;

import android.view.View;
import ru.bartwell.exfilepicker.p062ui.activity.ExFilePickerActivity;

/* loaded from: classes4.dex */
public class g81 implements View.OnClickListener {
    public final /* synthetic */ ExFilePickerActivity Wwwwwwwwwwwwwwwwwwwwwwww;

    public g81(ExFilePickerActivity exFilePickerActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = exFilePickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ExFilePickerActivity exFilePickerActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (exFilePickerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exFilePickerActivity.Wwwwwwwwwwwwwww)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.finish();
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww();
        }
    }
}

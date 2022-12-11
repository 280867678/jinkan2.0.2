package me.tvspark;

import android.view.View;
import java.io.File;
import ru.bartwell.exfilepicker.p062ui.activity.ExFilePickerActivity;

/* loaded from: classes4.dex */
public class j81 implements View.OnClickListener {
    public final /* synthetic */ ExFilePickerActivity Wwwwwwwwwwwwwwwwwwwwwwww;

    public j81(ExFilePickerActivity exFilePickerActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = exFilePickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File file = new File(this.Wwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkk);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww = new File(file.getAbsolutePath());
        ExFilePickerActivity exFilePickerActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        exFilePickerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exFilePickerActivity.Wwwwwwwwwwwwwww.getParentFile(), this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww.getName());
    }
}

package me.tvspark;

import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import java.io.File;
import ru.bartwell.exfilepicker.ExFilePicker$ChoiceType;
import ru.bartwell.exfilepicker.p062ui.activity.ExFilePickerActivity;

/* loaded from: classes4.dex */
public class e81 implements View.OnClickListener {
    public final /* synthetic */ ExFilePickerActivity Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ExFilePickerActivity exFilePickerActivity;
            File parentFile;
            String name;
            ExFilePickerActivity exFilePickerActivity2 = e81.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (exFilePickerActivity2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exFilePickerActivity2.Wwwwwwwwwwwwwww)) {
                exFilePickerActivity = e81.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                parentFile = exFilePickerActivity.Wwwwwwwwwwwwwww;
                name = "/";
            } else {
                exFilePickerActivity = e81.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                parentFile = exFilePickerActivity.Wwwwwwwwwwwwwww.getParentFile();
                name = e81.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww.getName();
            }
            exFilePickerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parentFile, name);
        }
    }

    public e81(ExFilePickerActivity exFilePickerActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = exFilePickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ExFilePickerActivity exFilePickerActivity;
        File parentFile;
        String name;
        ExFilePickerActivity exFilePickerActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (exFilePickerActivity2.Wwwwwwwwwwwwwwwww == ExFilePicker$ChoiceType.DIRECTORIES) {
            if (Build.VERSION.SDK_INT >= 30) {
                AlertDialog create = new AlertDialog.Builder(exFilePickerActivity2).setTitle("提示").setMessage("Android 11 及以上系统请注意目录权限问题，若出现问题请点击页面下方的【 还原默认目录 】").setPositiveButton("知道了", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).create();
                create.setCanceledOnTouchOutside(true);
                create.show();
                return;
            }
            if (exFilePickerActivity2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exFilePickerActivity2.Wwwwwwwwwwwwwww)) {
                exFilePickerActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                parentFile = exFilePickerActivity.Wwwwwwwwwwwwwww;
                name = "/";
            } else {
                exFilePickerActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                parentFile = exFilePickerActivity.Wwwwwwwwwwwwwww.getParentFile();
                name = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww.getName();
            }
            exFilePickerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parentFile, name);
        }
    }
}

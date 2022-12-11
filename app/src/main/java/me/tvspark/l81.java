package me.tvspark;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

/* loaded from: classes4.dex */
public class l81 implements DialogInterface.OnClickListener {
    public AlertDialog.Builder Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull String str);
    }

    public l81(@NonNull Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        this.Wwwwwwwwwwwwwwwwwwwwwww = builder;
        builder.setTitle(ru.bartwell.exfilepicker.R$string.efp__new_folder);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setView(LayoutInflater.from(context).inflate(ru.bartwell.exfilepicker.R$layout.efp__new_folder, (ViewGroup) null));
        this.Wwwwwwwwwwwwwwwwwwwwwww.setPositiveButton(17039370, this);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        TextView textView = (TextView) ((AlertDialog) dialogInterface).findViewById(ru.bartwell.exfilepicker.R$id.name);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || textView == null) {
            return;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(textView.getText().toString());
    }
}

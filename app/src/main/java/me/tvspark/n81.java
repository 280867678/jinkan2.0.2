package me.tvspark;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public class n81 implements DialogInterface.OnClickListener {
    public LinkedHashMap<String, String> Wwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final AlertDialog.Builder Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str);
    }

    public n81(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = builder;
        builder.setTitle(ru.bartwell.exfilepicker.R$string.efp__storage);
        LinkedHashMap<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setItems((CharSequence[]) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.values().toArray(new String[0]), this);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((String) this.Wwwwwwwwwwwwwwwwwwwwww.keySet().toArray()[i]);
    }
}

package me.tvspark;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import ru.bartwell.exfilepicker.ExFilePicker$SortingType;

/* loaded from: classes4.dex */
public class m81 implements DialogInterface.OnClickListener {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final AlertDialog.Builder Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ExFilePicker$SortingType exFilePicker$SortingType);
    }

    public m81(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = builder;
        builder.setItems(context.getResources().getStringArray(ru.bartwell.exfilepicker.R$array.efp__sorting_types), this);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ExFilePicker$SortingType exFilePicker$SortingType = ExFilePicker$SortingType.NAME_ASC;
        if (i == 1) {
            exFilePicker$SortingType = ExFilePicker$SortingType.NAME_DESC;
        } else if (i == 2) {
            exFilePicker$SortingType = ExFilePicker$SortingType.SIZE_ASC;
        } else if (i == 3) {
            exFilePicker$SortingType = ExFilePicker$SortingType.SIZE_DESC;
        } else if (i == 4) {
            exFilePicker$SortingType = ExFilePicker$SortingType.DATE_ASC;
        } else if (i == 5) {
            exFilePicker$SortingType = ExFilePicker$SortingType.DATE_DESC;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exFilePicker$SortingType);
    }
}

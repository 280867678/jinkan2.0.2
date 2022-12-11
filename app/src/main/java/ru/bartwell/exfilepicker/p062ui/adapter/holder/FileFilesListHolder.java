package ru.bartwell.exfilepicker.p062ui.adapter.holder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import java.io.File;
import me.tvspark.k81;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p056io.FilenameUtils;
import ru.bartwell.exfilepicker.R$array;
import ru.bartwell.exfilepicker.R$drawable;
import ru.bartwell.exfilepicker.R$id;

/* renamed from: ru.bartwell.exfilepicker.ui.adapter.holder.FileFilesListHolder */
/* loaded from: classes5.dex */
public class FileFilesListHolder extends BaseFilesListHolder {
    @NonNull
    public final AppCompatImageView Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public final AppCompatTextView Wwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final Context Wwwwwwwwwwwwwwwwwwwww;

    public FileFilesListHolder(@NonNull View view) {
        super(view);
        this.Wwwwwwwwwwwwwwwwwwwww = view.getContext();
        this.Wwwwwwwwwwwwwwwwwwww = (AppCompatTextView) view.findViewById(R$id.filesize);
        this.Wwwwwwwwwwwwwwwwwww = (AppCompatImageView) view.findViewById(R$id.thumbnail);
    }

    @Override // ru.bartwell.exfilepicker.p062ui.adapter.holder.BaseFilesListHolder
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file, boolean z, boolean z2, @Nullable k81 k81Var) {
        AppCompatImageView appCompatImageView;
        int i;
        String[] stringArray;
        String str;
        double d;
        double d2;
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, z, z2, k81Var);
        AppCompatTextView appCompatTextView = this.Wwwwwwwwwwwwwwwwwwww;
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(0);
            AppCompatTextView appCompatTextView2 = this.Wwwwwwwwwwwwwwwwwwww;
            Context context = this.Wwwwwwwwwwwwwwwwwwwww;
            long length = file.length();
            int length2 = context.getResources().getStringArray(R$array.efp__size_units).length;
            while (true) {
                length2--;
                if (length2 < 0) {
                    str = length + StringUtils.SPACE + stringArray[0];
                    break;
                }
                if (length >= Math.pow(1024.0d, length2)) {
                    str = Math.round(d / Math.pow(1024.0d, d2)) + StringUtils.SPACE + stringArray[length2];
                    break;
                }
            }
            appCompatTextView2.setText(str);
        }
        String extension = FilenameUtils.getExtension(file.getName());
        if (TextUtils.isEmpty(extension) || !extension.contains("torrent")) {
            appCompatImageView = this.Wwwwwwwwwwwwwwwwwww;
            i = R$drawable.efp__ic_file;
        } else {
            appCompatImageView = this.Wwwwwwwwwwwwwwwwwww;
            i = R$drawable.efp__ic_magnet;
        }
        appCompatImageView.setImageResource(i);
    }
}

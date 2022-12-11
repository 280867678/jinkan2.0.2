package ru.bartwell.exfilepicker.p062ui.adapter.holder;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import java.io.File;
import me.tvspark.k81;
import ru.bartwell.exfilepicker.R$drawable;
import ru.bartwell.exfilepicker.R$id;

/* renamed from: ru.bartwell.exfilepicker.ui.adapter.holder.DirectoryFilesListHolder */
/* loaded from: classes5.dex */
public class DirectoryFilesListHolder extends BaseFilesListHolder {
    @Nullable
    public final AppCompatTextView Wwwwwwwwwwwwwwwwwwwww = (AppCompatTextView) this.itemView.findViewById(R$id.filesize);
    @NonNull
    public final AppCompatImageView Wwwwwwwwwwwwwwwwwwww = (AppCompatImageView) this.itemView.findViewById(R$id.thumbnail);

    public DirectoryFilesListHolder(@NonNull View view) {
        super(view);
    }

    @Override // ru.bartwell.exfilepicker.p062ui.adapter.holder.BaseFilesListHolder
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file, boolean z, boolean z2, @Nullable k81 k81Var) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, z, z2, k81Var);
        AppCompatTextView appCompatTextView = this.Wwwwwwwwwwwwwwwwwwwww;
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(8);
        }
        this.Wwwwwwwwwwwwwwwwwwww.setImageResource(R$drawable.efp__ic_folder);
    }
}

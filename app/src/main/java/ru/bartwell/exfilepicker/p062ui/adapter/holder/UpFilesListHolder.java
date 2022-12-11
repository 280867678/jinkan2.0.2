package ru.bartwell.exfilepicker.p062ui.adapter.holder;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import ru.bartwell.exfilepicker.R$id;

/* renamed from: ru.bartwell.exfilepicker.ui.adapter.holder.UpFilesListHolder */
/* loaded from: classes5.dex */
public class UpFilesListHolder extends BaseFilesListHolder {
    @NonNull
    public final AppCompatImageView Wwwwwwwwwwwwwwwwww;
    @Nullable
    public final AppCompatTextView Wwwwwwwwwwwwwwwwwww;
    @NonNull
    public final AppCompatCheckBox Wwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final AppCompatTextView Wwwwwwwwwwwwwwwwwwwww;

    public UpFilesListHolder(@NonNull View view) {
        super(view);
        this.Wwwwwwwwwwwwwwwwwwwww = (AppCompatTextView) view.findViewById(R$id.filename);
        this.Wwwwwwwwwwwwwwwwwwww = (AppCompatCheckBox) view.findViewById(R$id.checkbox);
        this.Wwwwwwwwwwwwwwwwwww = (AppCompatTextView) view.findViewById(R$id.filesize);
        this.Wwwwwwwwwwwwwwwwww = (AppCompatImageView) view.findViewById(R$id.thumbnail);
    }

    @Override // ru.bartwell.exfilepicker.p062ui.adapter.holder.BaseFilesListHolder
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return -1;
    }
}

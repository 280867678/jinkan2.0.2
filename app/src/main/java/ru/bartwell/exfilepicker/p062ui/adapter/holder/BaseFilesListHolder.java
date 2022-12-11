package ru.bartwell.exfilepicker.p062ui.adapter.holder;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import me.tvspark.k81;
import ru.bartwell.exfilepicker.R$id;

/* renamed from: ru.bartwell.exfilepicker.ui.adapter.holder.BaseFilesListHolder */
/* loaded from: classes5.dex */
public abstract class BaseFilesListHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    @Nullable
    public k81 Wwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final AppCompatCheckBox Wwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final AppCompatTextView Wwwwwwwwwwwwwwwwwwwwwwww;

    public BaseFilesListHolder(@NonNull View view) {
        super(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = (AppCompatTextView) view.findViewById(R$id.filename);
        this.Wwwwwwwwwwwwwwwwwwwwwww = (AppCompatCheckBox) view.findViewById(R$id.checkbox);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return getAdapterPosition();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file, boolean z, boolean z2, @Nullable k81 k81Var) {
        this.Wwwwwwwwwwwwwwwwwwwwww = k81Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setText(file.getName());
        this.Wwwwwwwwwwwwwwwwwwwwwww.setVisibility(z ? 0 : 8);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setChecked(z2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k81 k81Var = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (k81Var != null) {
            k81Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        k81 k81Var = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (k81Var != null) {
            k81Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            return true;
        }
        return true;
    }
}

package ru.bartwell.exfilepicker.p062ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.k81;
import me.tvspark.outline;
import me.tvspark.q81;
import me.tvspark.r81;
import me.tvspark.s81;
import me.tvspark.t81;
import me.tvspark.u81;
import me.tvspark.v81;
import ru.bartwell.exfilepicker.ExFilePicker$SortingType;
import ru.bartwell.exfilepicker.R$drawable;
import ru.bartwell.exfilepicker.R$layout;
import ru.bartwell.exfilepicker.p062ui.adapter.holder.BaseFilesListHolder;
import ru.bartwell.exfilepicker.p062ui.adapter.holder.DirectoryFilesListHolder;
import ru.bartwell.exfilepicker.p062ui.adapter.holder.FileFilesListHolder;
import ru.bartwell.exfilepicker.p062ui.adapter.holder.UpFilesListHolder;

/* renamed from: ru.bartwell.exfilepicker.ui.adapter.FilesListAdapter */
/* loaded from: classes5.dex */
public class FilesListAdapter extends RecyclerView.Adapter<BaseFilesListHolder> {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public k81 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public List<File> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    @NonNull
    public ArrayList<File> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList<>();
    @NonNull
    public List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    @NonNull
    public final View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ViewGroup viewGroup, @LayoutRes int i) {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, i, viewGroup, false);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
        String name = getItem(i).getName();
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(name);
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(name);
        }
        notifyItemChanged(i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ExFilePicker$SortingType exFilePicker$SortingType) {
        List<File> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int ordinal = exFilePicker$SortingType.ordinal();
        Collections.sort(list, ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? ordinal != 5 ? new s81() : new r81() : new q81() : new v81() : new u81() : new t81());
        notifyDataSetChanged();
    }

    @NonNull
    public File getItem(int i) {
        List<File> list;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i--;
        } else {
            list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return list.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() + 1 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww && i == 0) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 4 : 5;
        }
        boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean isDirectory = getItem(i).isDirectory();
        return z ? isDirectory ? 3 : 1 : isDirectory ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull BaseFilesListHolder baseFilesListHolder, int i) {
        BaseFilesListHolder baseFilesListHolder2 = baseFilesListHolder;
        if (getItemViewType(i) != 5 && getItemViewType(i) != 4) {
            baseFilesListHolder2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getItem(i), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(getItem(i).getName()), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        UpFilesListHolder upFilesListHolder = (UpFilesListHolder) baseFilesListHolder2;
        upFilesListHolder.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        upFilesListHolder.Wwwwwwwwwwwwwwwwwwwww.setText("..");
        upFilesListHolder.Wwwwwwwwwwwwwwwwwwww.setVisibility(8);
        AppCompatTextView appCompatTextView = upFilesListHolder.Wwwwwwwwwwwwwwwwwww;
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(8);
        }
        upFilesListHolder.Wwwwwwwwwwwwwwwwww.setImageResource(R$drawable.efp__ic_up);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseFilesListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i != 0) {
            if (i == 1) {
                return new FileFilesListHolder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, R$layout.layout_files_grid_item));
            }
            if (i == 2) {
                return new DirectoryFilesListHolder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, R$layout.layout_files_list_item));
            }
            if (i != 4 && i != 5) {
                return new DirectoryFilesListHolder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, R$layout.layout_files_grid_item));
            }
            return new UpFilesListHolder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, R$layout.layout_files_list_item));
        }
        return new FileFilesListHolder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, R$layout.layout_files_list_item));
    }
}

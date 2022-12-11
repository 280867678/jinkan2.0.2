package ru.bartwell.exfilepicker.p062ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import me.tvspark.r40;
import ru.bartwell.exfilepicker.R$attr;
import ru.bartwell.exfilepicker.R$menu;

/* renamed from: ru.bartwell.exfilepicker.ui.view.FilesListToolbar */
/* loaded from: classes5.dex */
public class FilesListToolbar extends Toolbar {
    public CharSequence Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

    public FilesListToolbar(@NonNull Context context) {
        super(context);
    }

    public FilesListToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FilesListToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMultiChoiceModeEnabled(boolean z) {
        getMenu().clear();
        if (z) {
            inflateMenu(R$menu.files_list_multi_choice);
            this.Wwwwwwwwwwwwwwwwwwwwwww = getTitle();
            setTitle((CharSequence) null);
        } else {
            inflateMenu(R$menu.files_list_single_choice);
            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                setTitle(this.Wwwwwwwwwwwwwwwwwwwwwww);
            }
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                setNavigationIcon((Drawable) null);
                return;
            }
        }
        setNavigationIcon(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), R$attr.efp__ic_action_cancel));
    }

    public void setQuitButtonEnabled(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
    }
}

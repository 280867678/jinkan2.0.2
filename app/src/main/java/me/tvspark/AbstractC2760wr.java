package me.tvspark;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: me.tvspark.wr */
/* loaded from: classes4.dex */
public abstract class AbstractC2760wr {
    public CheckableImageButton Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public TextInputLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC2760wr(@NonNull TextInputLayout textInputLayout) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = textInputLayout;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = textInputLayout.getContext();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = textInputLayout.getEndIconView();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return true;
    }
}

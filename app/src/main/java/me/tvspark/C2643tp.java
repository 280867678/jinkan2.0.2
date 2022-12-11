package me.tvspark;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.tp */
/* loaded from: classes4.dex */
public class C2643tp extends ImageButton {
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2643tp(Context context) {
        this(context, null);
    }

    public C2643tp(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C2643tp(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = getVisibility();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
    }
}

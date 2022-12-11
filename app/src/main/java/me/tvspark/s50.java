package me.tvspark;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
public class s50 extends FrameLayout implements Checkable {
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwww = {16842912};
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

    public s50(Context context) {
        super(context);
    }

    public View getTagView() {
        return getChildAt(0);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, Wwwwwwwwwwwwwwwwwwwwwww);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }
}

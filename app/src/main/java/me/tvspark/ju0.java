package me.tvspark;

import android.widget.SeekBar;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class ju0 implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ lu0 Wwwwwwwwwwwwwwwwwwwwwwww;

    public ju0(lu0 lu0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = lu0Var;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        lu0 lu0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        lu0Var.Wwwwwwwwwwww = i;
        TextView textView = lu0Var.Wwwwwwwwwwwwwwwwww;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("跳过片头：");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
        textView.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}

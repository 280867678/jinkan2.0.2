package me.tvspark;

import android.widget.SeekBar;
import me.tvspark.utils.cast.p050ui.CastPlayActivity;

/* loaded from: classes4.dex */
public class vp0 implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ CastPlayActivity Wwwwwwwwwwwwwwwwwwwwwwww;

    public vp0(CastPlayActivity castPlayActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = castPlayActivity;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        CastPlayActivity castPlayActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (castPlayActivity.Wwwwwwwwwwwwwwwwww == null && castPlayActivity.Wwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        CastPlayActivity castPlayActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        castPlayActivity2.Wwwwwwwwwwwwww = false;
        castPlayActivity2.Wwwwwwwwwwwwwwwww = seekBar.getProgress();
        CastPlayActivity castPlayActivity3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        castPlayActivity3.tvPlayTime.setText(bq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity3.Wwwwwwwwwwwwwwwww));
        CastPlayActivity castPlayActivity4 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity4, castPlayActivity4.Wwwwwwwwwwwwwwwww);
    }
}

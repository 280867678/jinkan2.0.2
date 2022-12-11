package me.tvspark;

import android.view.MotionEvent;
import android.view.View;
import com.lzf.easyfloat.interfaces.OnFloatCallbacks;
import me.tvspark.utils.player.MyJzvdStd;
import me.tvspark.utils.service.FloatPlayService;

/* loaded from: classes4.dex */
public class fr0 implements OnFloatCallbacks {
    public final /* synthetic */ FloatPlayService Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public fr0(FloatPlayService floatPlayService) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = floatPlayService;
    }

    @Override // com.lzf.easyfloat.interfaces.OnFloatCallbacks
    public void createdResult(boolean z, String str, View view) {
    }

    @Override // com.lzf.easyfloat.interfaces.OnFloatCallbacks
    public void dismiss() {
    }

    @Override // com.lzf.easyfloat.interfaces.OnFloatCallbacks
    public void drag(View view, MotionEvent motionEvent) {
    }

    @Override // com.lzf.easyfloat.interfaces.OnFloatCallbacks
    public void dragEnd(View view) {
    }

    @Override // com.lzf.easyfloat.interfaces.OnFloatCallbacks
    public void hide(View view) {
    }

    @Override // com.lzf.easyfloat.interfaces.OnFloatCallbacks
    public void show(View view) {
    }

    @Override // com.lzf.easyfloat.interfaces.OnFloatCallbacks
    public void touchEvent(View view, MotionEvent motionEvent) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww = motionEvent.getX();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = motionEvent.getY();
            } else if (action == 1) {
                MyJzvdStd myJzvdStd = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (!myJzvdStd.Oooooooo) {
                    return;
                }
                myJzvdStd.Kkkkkkkkkkkkkkkkk();
            } else if (action != 2) {
            } else {
                float x = motionEvent.getX() - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww;
                float Wwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwww((int) Math.abs(motionEvent.getY() - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww));
                if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwww((int) Math.abs(x)) <= 2.0f && Wwwwwwwwwwwwwwwwwwwwwwwwww <= 2.0f) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Ooooooo = true;
            }
        }
    }
}

package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.locks.Lock;

/* loaded from: classes4.dex */
public final class Zzzzzz {
    public static final OO0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends QQOOOOOOOOO {
        @Override // me.tvspark.QQOOOOOOOOO, me.tvspark.OO0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap) {
        }
    }

    @Nullable
    public static AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(OO0 oo0, Drawable drawable, int i, int i2) {
        StringBuilder sb;
        String str;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        Bitmap bitmap = null;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            if (i != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i2 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i2 = current.getIntrinsicHeight();
                    }
                    Lock lock = Cccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    lock.lock();
                    Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        current.setBounds(0, 0, i, i2);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                    sb = new StringBuilder();
                    sb.append("Unable to draw ");
                    sb.append(current);
                    str = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height";
                    sb.append(str);
                    sb.toString();
                }
                z = true;
            } else {
                if (Log.isLoggable("DrawableToBitmap", 5)) {
                    sb = new StringBuilder();
                    sb.append("Unable to draw ");
                    sb.append(current);
                    str = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width";
                    sb.append(str);
                    sb.toString();
                }
                z = true;
            }
        }
        if (!z) {
            oo0 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return Xxxx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap, oo0);
    }
}

package com.tencent.smtt.audio.core.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import com.tencent.mtt.ContextHolder;
import com.tencent.tbs.common.resources.TBSResources;
import java.lang.reflect.Constructor;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/NinePatchUtils.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/NinePatchUtils.class */
public class NinePatchUtils {
    private static final int NO_COLOR = 1;

    private NinePatchUtils() {
    }

    public static void readPaddingFromChunk(byte[] chunk, Rect paddingRect) {
        paddingRect.left = getInt(chunk, 12);
        paddingRect.right = getInt(chunk, 16);
        paddingRect.top = getInt(chunk, 20);
        paddingRect.bottom = getInt(chunk, 24);
    }

    private static int getInt(byte[] bs, int from) {
        int i = bs[from + 0] | (bs[from + 1] << 8) | (bs[from + 2] << 16) | (bs[from + 3] << 24);
        return i;
    }

    public static Drawable createNinePatchDrawable(Context context, String path) {
        try {
            BitmapFactory.Options opt = new BitmapFactory.Options();
            Bitmap bm = TBSResources.decodeResource(path, opt);
            if (bm == null) {
                return null;
            }
            if (bm.getNinePatchChunk() == null) {
                return getBmpDrawable(bm);
            }
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            bm.setDensity(dm.densityDpi);
            Rect paddingRect = new Rect();
            readPaddingFromChunk(bm.getNinePatchChunk(), paddingRect);
            NinePatchDrawable d = new NinePatchDrawable(context.getResources(), bm, bm.getNinePatchChunk(), paddingRect, null);
            d.getPaint().setAntiAlias(true);
            d.setFilterBitmap(true);
            return d;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BitmapDrawable getBmpDrawable(Bitmap bitmap) {
        BitmapDrawable bd;
        try {
            Class[] arrayOfClass = {Resources.class, Bitmap.class};
            Constructor mBmpConstructor = BitmapDrawable.class.getConstructor(arrayOfClass);
            Object[] arrayOfObject = {ContextHolder.getAppContext().getResources(), bitmap};
            bd = (BitmapDrawable) mBmpConstructor.newInstance(arrayOfObject);
        } catch (Exception e) {
            e.printStackTrace();
            bd = new BitmapDrawable(bitmap);
        }
        return bd;
    }
}

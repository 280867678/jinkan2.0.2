package me.tvspark.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GestureDetectorCompat;
import me.tvspark.bq0;
import me.tvspark.df0;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.r40;
import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.p050ui.CastPlayActivity;
import me.tvspark.xg0;
import white.whale.R;

@ef0
/* loaded from: classes4.dex */
public final class DirectionDpadView extends View implements GestureDetector.OnGestureListener {
    public boolean Wwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwww;
    public Bitmap Wwwwwwwwwwwwwwwwwwww;
    public Bitmap Wwwwwwwwwwwwwwwwwwwww;
    public Bitmap Wwwwwwwwwwwwwwwwwwwwww;
    public Bitmap Wwwwwwwwwwwwwwwwwwwwwww;
    public final df0 Wwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((xg0) DirectionDpadView$mPaint$2.INSTANCE);
    public final df0 Wwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((xg0) new DirectionDpadView$mGestureDetectorCompat$2(this));
    public int Wwwwwwwwwwwwwwwww = -1;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public DirectionDpadView(Context context) {
        super(context);
        Resources resources = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources, "resources");
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_background, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(240.0f), resources);
        Resources resources2 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources2, "resources");
        this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_5way_play, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(240.0f), resources2);
        Resources resources3 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources3, "resources");
        this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_5way_pause, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(240.0f), resources3);
        Resources resources4 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources4, "resources");
        this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_center_normal, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(80.0f), resources4);
    }

    public DirectionDpadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources, "resources");
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_background, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(240.0f), resources);
        Resources resources2 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources2, "resources");
        this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_5way_play, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(240.0f), resources2);
        Resources resources3 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources3, "resources");
        this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_5way_pause, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(240.0f), resources3);
        Resources resources4 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources4, "resources");
        this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_center_normal, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(80.0f), resources4);
    }

    public DirectionDpadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources, "resources");
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_background, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(240.0f), resources);
        Resources resources2 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources2, "resources");
        this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_5way_play, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(240.0f), resources2);
        Resources resources3 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources3, "resources");
        this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_5way_pause, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(240.0f), resources3);
        Resources resources4 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources4, "resources");
        this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_center_normal, (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(80.0f), resources4);
    }

    private final GestureDetectorCompat getMGestureDetectorCompat() {
        return (GestureDetectorCompat) this.Wwwwwwwwwwwwwwwwwww.getValue();
    }

    private final Paint getMPaint() {
        return (Paint) this.Wwwwwwwwwwwwwwwwwwwwwwww.getValue();
    }

    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        Resources system = Resources.getSystem();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(system, "Resources.getSystem()");
        return TypedValue.applyDimension(1, f, system.getDisplayMetrics());
    }

    public final Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, Resources resources) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inDensity = options.outWidth;
        options.inTargetDensity = i2;
        options.inJustDecodeBounds = false;
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i, options);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(decodeResource, "BitmapFactory.decodeReso…e(resources, id, options)");
        return decodeResource;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwww;
        int i2 = R.drawable.dpad_background;
        switch (i) {
            case 19:
                i2 = R.drawable.dpad_up_pressed;
                break;
            case 20:
                i2 = R.drawable.dpad_down_pressed;
                break;
            case 21:
                i2 = R.drawable.dpad_left_pressed;
                break;
            case 22:
                i2 = R.drawable.dpad_right_pressed;
                break;
        }
        int i3 = this.Wwwwwwwwwwwwwwwww != 23 ? R.drawable.dpad_center_normal : R.drawable.dpad_center_pressed;
        int width = getWidth();
        Resources resources = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources, "resources");
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, width, resources);
        Resources resources2 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources2, "resources");
        this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, (int) (this.Wwwwwwwwwwwwwwwwww * 2), resources2);
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas, "canvas");
        super.draw(canvas);
        canvas.drawBitmap(this.Wwwwwwwwwwwwwwwwwwwwwww, 0.0f, 0.0f, getMPaint());
        canvas.drawBitmap(this.Wwwwwwwwwwwwwwwwwwww, (getWidth() - this.Wwwwwwwwwwwwwwwwwwww.getWidth()) / 2.0f, (getHeight() - this.Wwwwwwwwwwwwwwwwwwww.getHeight()) / 2.0f, getMPaint());
        canvas.drawBitmap(this.Wwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwww, 0.0f, 0.0f, getMPaint());
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        int i;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(motionEvent, NotificationCompat.CATEGORY_EVENT);
        this.Wwwwwwwwwwwwwwwww = -1;
        float x = motionEvent.getX() - (getWidth() / 2.0f);
        float y = motionEvent.getY() - (getHeight() / 2.0f);
        if (((float) Math.sqrt((y * y) + (x * x))) <= getWidth() / 2.0f) {
            if (Math.abs(x) <= this.Wwwwwwwwwwwwwwwwww && Math.abs(y) <= this.Wwwwwwwwwwwwwwwwww) {
                i = 23;
            } else if (Math.abs(y) > this.Wwwwwwwwwwwwwwwwww && y < 0 && Math.abs(y) > Math.abs(x)) {
                i = 19;
            } else if (Math.abs(y) <= this.Wwwwwwwwwwwwwwwwww || y <= 0 || Math.abs(y) <= Math.abs(x)) {
                float f = 0;
                if (x < f && Math.abs(x) > this.Wwwwwwwwwwwwwwwwww && Math.abs(x) > Math.abs(y)) {
                    i = 21;
                } else if (x > f && Math.abs(x) > this.Wwwwwwwwwwwwwwwwww && Math.abs(x) > Math.abs(y)) {
                    i = 22;
                }
            } else {
                i = 20;
            }
            this.Wwwwwwwwwwwwwwwww = i;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(motionEvent, NotificationCompat.CATEGORY_EVENT);
        int i = this.Wwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwww = true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        CastPlayActivity castPlayActivity;
        String str;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(motionEvent, NotificationCompat.CATEGORY_EVENT);
        int i = this.Wwwwwwwwwwwwwwwww;
        if (i != -1 && (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww) != null) {
            CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            CastPlayActivity castPlayActivity2 = CastPlayActivity.this;
            if (castPlayActivity2.Wwwwwwwwwwwwwwwwww != null || castPlayActivity2.Wwwwwwwwwwwwwwwwwww != null) {
                switch (i) {
                    case 19:
                        CastPlayActivity castPlayActivity3 = CastPlayActivity.this;
                        CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity3, castPlayActivity3.Wwwwwwwwwwwwwwww + 1);
                        castPlayActivity = CastPlayActivity.this;
                        str = "音量已加 1";
                        CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity, str);
                        break;
                    case 20:
                        CastPlayActivity castPlayActivity4 = CastPlayActivity.this;
                        int i2 = castPlayActivity4.Wwwwwwwwwwwwwwww - 1;
                        if (i2 >= 0) {
                            CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity4, i2);
                            castPlayActivity = CastPlayActivity.this;
                            str = "音量已减 1";
                            CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity, str);
                            break;
                        }
                        break;
                    case 21:
                        CastPlayActivity castPlayActivity5 = CastPlayActivity.this;
                        castPlayActivity5.Wwwwwwwwwwwwwwwww = castPlayActivity5.seekBarProgress.getProgress();
                        CastPlayActivity castPlayActivity6 = CastPlayActivity.this;
                        int i3 = castPlayActivity6.Wwwwwwwwwwwwwwwww - 15;
                        if (i3 > 0) {
                            castPlayActivity6.Wwwwwwwwwwwwwwwww = i3;
                            castPlayActivity6.tvPlayTime.setText(bq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3));
                            CastPlayActivity castPlayActivity7 = CastPlayActivity.this;
                            CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity7, castPlayActivity7.Wwwwwwwwwwwwwwwww);
                            castPlayActivity = CastPlayActivity.this;
                            str = "后退 15 秒";
                            CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity, str);
                            break;
                        }
                        break;
                    case 22:
                        CastPlayActivity castPlayActivity8 = CastPlayActivity.this;
                        castPlayActivity8.Wwwwwwwwwwwwwwwww = castPlayActivity8.seekBarProgress.getProgress();
                        CastPlayActivity castPlayActivity9 = CastPlayActivity.this;
                        int i4 = castPlayActivity9.Wwwwwwwwwwwwwwwww + 15;
                        castPlayActivity9.Wwwwwwwwwwwwwwwww = i4;
                        castPlayActivity9.tvPlayTime.setText(bq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4));
                        CastPlayActivity castPlayActivity10 = CastPlayActivity.this;
                        CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity10, castPlayActivity10.Wwwwwwwwwwwwwwwww);
                        castPlayActivity = CastPlayActivity.this;
                        str = "前进 15 秒";
                        CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity, str);
                        break;
                    case 23:
                        if (ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww != ControlManager.CastState.TRANSITIONING) {
                            CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity.this);
                            break;
                        }
                        break;
                }
            }
        }
        this.Wwwwwwwwwwwwwwwww = -1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return true;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int width = getWidth();
        Resources resources = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources, "resources");
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_background, width, resources);
        int width2 = getWidth();
        Resources resources2 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources2, "resources");
        this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_5way_play, width2, resources2);
        int width3 = getWidth();
        Resources resources3 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources3, "resources");
        this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_5way_pause, width3, resources3);
        float width4 = ((getWidth() * 2) / 5.0f) / 2.0f;
        this.Wwwwwwwwwwwwwwwwww = width4;
        Resources resources4 = getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources4, "resources");
        this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.dpad_center_normal, (int) (width4 * 2), resources4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Wwwwwwwwwwwwwwww && motionEvent != null && motionEvent.getAction() == 1) {
            int i = this.Wwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwww = -1;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return getMGestureDetectorCompat().onTouchEvent(motionEvent);
    }

    public final void setOnDirectionKeyListener(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "listener");
        this.Wwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final void setPlayStatus(boolean z) {
        if (this.Wwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwww = z;
            postInvalidate();
        }
    }
}

package com.hedgehog.ratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class RatingBar extends LinearLayout {
    public Drawable Wwwwwwwwwwwwww;
    public Drawable Wwwwwwwwwwwwwww;
    public Drawable Wwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwww = 1;
    public boolean Wwwwwwwwwwww = true;

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f);
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RatingBar ratingBar;
            RatingBar ratingBar2 = RatingBar.this;
            if (ratingBar2.Wwwwwwwwwwwwwwwwwwwwwwww) {
                if (ratingBar2.Wwwwwwwwwwwwwwwwwwwwwww) {
                    ratingBar2.setStar(ratingBar2.Wwwwwwwwwwwww % 2 == 0 ? ratingBar2.indexOfChild(view) + 1.0f : ratingBar2.indexOfChild(view) + 0.5f);
                    RatingBar ratingBar3 = RatingBar.this;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ratingBar3.Wwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        return;
                    }
                    int i = ratingBar3.Wwwwwwwwwwwww % 2;
                    float indexOfChild = ratingBar3.indexOfChild(view);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i == 0 ? indexOfChild + 1.0f : indexOfChild + 0.5f);
                    RatingBar.this.Wwwwwwwwwwwww++;
                    return;
                }
                ratingBar2.setStar(ratingBar2.indexOfChild(view) + 1.0f);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = RatingBar.this.Wwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                    return;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ratingBar.indexOfChild(view) + 1.0f);
            }
        }
    }

    public RatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RatingBar);
        this.Wwwwwwwwwwwwww = obtainStyledAttributes.getDrawable(R$styleable.RatingBar_starHalf);
        this.Wwwwwwwwwwwwwwww = obtainStyledAttributes.getDrawable(R$styleable.RatingBar_starEmpty);
        this.Wwwwwwwwwwwwwww = obtainStyledAttributes.getDrawable(R$styleable.RatingBar_starFill);
        obtainStyledAttributes.getDimension(R$styleable.RatingBar_starImageSize, 120.0f);
        this.Wwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimension(R$styleable.RatingBar_starImageWidth, 60.0f);
        this.Wwwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimension(R$styleable.RatingBar_starImageHeight, 120.0f);
        this.Wwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimension(R$styleable.RatingBar_starImagePadding, 15.0f);
        this.Wwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getInteger(R$styleable.RatingBar_starCount, 5);
        this.Wwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getInteger(R$styleable.RatingBar_starNum, 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getBoolean(R$styleable.RatingBar_clickable, true);
        this.Wwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getBoolean(R$styleable.RatingBar_halfstart, false);
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwww; i++) {
            addView(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, false));
        }
        for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwww; i2++) {
            ImageView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, this.Wwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            addView(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
    }

    public final ImageView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.Wwwwwwwwwwwwwwwwwww), Math.round(this.Wwwwwwwwwwwwwwwwww)));
        imageView.setPadding(0, 0, Math.round(this.Wwwwwwwwwwwwwwwww), 0);
        imageView.setImageDrawable(z ? this.Wwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwww);
        return imageView;
    }

    public void setImagePadding(float f) {
        this.Wwwwwwwwwwwwwwwww = f;
    }

    public void setOnRatingChangeListener(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void setStar(float f) {
        int i = (int) f;
        float floatValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwww;
        float f2 = i > i2 ? i2 : i;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        for (int i3 = 0; i3 < f2; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.Wwwwwwwwwwwwwww);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.Wwwwwwwwwwwwww);
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwww;
            while (true) {
                i4--;
                if (i4 < 1.0f + f2) {
                    return;
                }
                ((ImageView) getChildAt(i4)).setImageDrawable(this.Wwwwwwwwwwwwwwww);
            }
        } else {
            int i5 = this.Wwwwwwwwwwwwwwwwwwwwww;
            while (true) {
                i5--;
                if (i5 < f2) {
                    return;
                }
                ((ImageView) getChildAt(i5)).setImageDrawable(this.Wwwwwwwwwwwwwwww);
            }
        }
    }

    public void setStarCount(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwww = i;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.Wwwwwwwwwwwwwwww = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.Wwwwwwwwwwwwwww = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.Wwwwwwwwwwwwww = drawable;
    }

    public void setStarImageHeight(float f) {
        this.Wwwwwwwwwwwwwwwwww = f;
    }

    public void setStarImageSize(float f) {
    }

    public void setStarImageWidth(float f) {
        this.Wwwwwwwwwwwwwwwwwww = f;
    }

    public void setmClickable(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
    }
}

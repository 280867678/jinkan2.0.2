package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AbstractC0047Px;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import me.tvspark.AbstractC1918aq;
import me.tvspark.AbstractC2570rq;
import me.tvspark.C1955bq;
import me.tvspark.C1957bs;
import me.tvspark.C2415np;
import me.tvspark.C2416nq;
import me.tvspark.C2449om;
import me.tvspark.C2530qn;
import me.tvspark.C2832yp;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2570rq {
    public final AbstractC1918aq Wwwwwwwww;
    public final RectF Wwwwwwwwww;
    public final Rect Wwwwwwwwwww;
    @NonNull
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwww;
    @Dimension(unit = 1)
    public int Wwwwwwwwwwwww;
    public int Wwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public CompoundButton.OnCheckedChangeListener Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public View.OnClickListener Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public RippleDrawable Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public InsetDrawable Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ChipDrawable Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final int Wwwwwwww = R$style.Widget_MaterialComponents_Chip_Action;
    public static final Rect Wwwwwww = new Rect();
    public static final int[] Wwwwww = {16842913};
    public static final int[] Wwwww = {16842911};

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends ExploreByTouchHelper {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f, float f2) {
            return (!Chip.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || !Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? 0 : 1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(@NonNull List<Integer> list) {
            boolean z = false;
            list.add(0);
            if (Chip.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                ChipDrawable chipDrawable = Chip.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (chipDrawable != null && chipDrawable.Kkkkkkkkkkk) {
                    z = true;
                }
                if (!z || Chip.this.Wwwwwwwwwwwwwwwwwwwww == null) {
                    return;
                }
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            boolean z = false;
            if (i2 == 16) {
                if (i == 0) {
                    return Chip.this.performClick();
                }
                if (i == 1) {
                    Chip chip = Chip.this;
                    chip.playSoundEffect(0);
                    View.OnClickListener onClickListener = chip.Wwwwwwwwwwwwwwwwwwwww;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip);
                        z = true;
                    }
                    chip.Wwwwwwwwwwww.sendEventForVirtualView(1, 1);
                }
            }
            return z;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCheckable(Chip.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            accessibilityNodeInfoCompat.setClickable(Chip.this.isClickable());
            accessibilityNodeInfoCompat.setClassName((Chip.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Chip.this.isClickable()) ? Chip.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? "android.widget.CompoundButton" : "android.widget.Button" : ExploreByTouchHelper.DEFAULT_CLASS_NAME);
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.setText(text);
            } else {
                accessibilityNodeInfoCompat.setContentDescription(text);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence = "";
            if (i != 1) {
                accessibilityNodeInfoCompat.setContentDescription(charSequence);
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.Wwwwwww);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription == null) {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i2 = R$string.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                if (!TextUtils.isEmpty(text)) {
                    charSequence = text;
                }
                objArr[0] = charSequence;
                closeIconContentDescription = context.getString(i2, objArr).trim();
            }
            accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
            if (i == 1) {
                Chip chip = Chip.this;
                chip.Wwwwwwwwwwwwwwww = z;
                chip.refreshDrawableState();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC1918aq {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC1918aq
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        }

        @Override // me.tvspark.AbstractC1918aq
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Typeface typeface, boolean z) {
            CharSequence text;
            Chip chip = Chip.this;
            ChipDrawable chipDrawable = chip.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (chipDrawable.IIl) {
                text = chipDrawable.Kkkkkkkkkkkkkkkkk;
            } else {
                text = chip.getText();
            }
            chip.setText(text);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0329  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Chip(Context context, AttributeSet attributeSet, int i) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, Wwwwwwww), attributeSet, i);
        TextUtils.TruncateAt truncateAt;
        boolean hasValue;
        int resourceId;
        this.Wwwwwwwwwww = new Rect();
        this.Wwwwwwwwww = new RectF();
        this.Wwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Context context2 = getContext();
        if (attributeSet != null) {
            attributeSet.getAttributeValue(TypedArrayUtils.NAMESPACE, NotificationCompat.WearableExtender.KEY_BACKGROUND);
            if (attributeSet.getAttributeValue(TypedArrayUtils.NAMESPACE, "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue(TypedArrayUtils.NAMESPACE, "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue(TypedArrayUtils.NAMESPACE, "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue(TypedArrayUtils.NAMESPACE, "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue(TypedArrayUtils.NAMESPACE, "singleLine", true) || attributeSet.getAttributeIntValue(TypedArrayUtils.NAMESPACE, "lines", 1) != 1 || attributeSet.getAttributeIntValue(TypedArrayUtils.NAMESPACE, "minLines", 1) != 1 || attributeSet.getAttributeIntValue(TypedArrayUtils.NAMESPACE, "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            attributeSet.getAttributeIntValue(TypedArrayUtils.NAMESPACE, NotificationCompat.WearableExtender.KEY_GRAVITY, 8388627);
        }
        int i2 = Wwwwwwww;
        ChipDrawable chipDrawable = new ChipDrawable(context2, attributeSet, i, i2);
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, attributeSet, R$styleable.Chip, i, i2, new int[0]);
        chipDrawable.O000000000 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.Chip_shapeAppearance);
        ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_chipSurfaceColor);
        if (chipDrawable.Kkkkkkkkkkkkkkkkkkkkkkkk != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            chipDrawable.Kkkkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_chipBackgroundColor));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.Chip_chipCornerRadius)) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_chipCornerRadius, 0.0f));
        }
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_chipStrokeColor));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_rippleColor));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getText(R$styleable.Chip_android_text));
        Context context3 = chipDrawable.Illllllllllllllllll;
        int i3 = R$styleable.Chip_android_textAppearance;
        C2832yp c2832yp = (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(i3) || (resourceId = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getResourceId(i3, 0)) == 0) ? null : new C2832yp(context3, resourceId);
        c2832yp.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_android_textSize, c2832yp.Wwwwwwwwwwwwwwwwwwwwwwww);
        chipDrawable.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2832yp, chipDrawable.Illllllllllllllllll);
        int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i4 == 1) {
            truncateAt = TextUtils.TruncateAt.START;
        } else if (i4 != 2) {
            if (i4 == 3) {
                truncateAt = TextUtils.TruncateAt.END;
            }
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_chipIconVisible, false));
            if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
                chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_chipIconEnabled, false));
            }
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_chipIcon));
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.Chip_chipIconTint)) {
                chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_chipIconTint));
            }
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_closeIconVisible, false));
            if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
                chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_closeIconEnabled, false));
            }
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_closeIcon));
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_closeIconTint));
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_android_checkable, false));
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_checkedIconVisible, false));
            if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
                chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
            }
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_checkedIcon));
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.Chip_checkedIconTint)) {
                chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_checkedIconTint));
            }
            chipDrawable.Illllllllllllllllllllllllllll = C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_showMotionSpec);
            chipDrawable.Illlllllllllllllllllllllllll = C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_hideMotionSpec);
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
            chipDrawable.Wwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
            chipDrawable.Wwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
            chipDrawable.O0000000000 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.recycle();
            TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, R$styleable.Chip, i, Wwwwwwww, new int[0]);
            this.Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
            this.Wwwwwwwwwwwww = (int) Math.ceil(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), 48))));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.recycle();
            setChipDrawable(chipDrawable);
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewCompat.getElevation(this));
            TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, R$styleable.Chip, i, Wwwwwwww, new int[0]);
            if (Build.VERSION.SDK_INT < 23) {
                setTextColor(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, R$styleable.Chip_android_textColor));
            }
            hasValue = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.hasValue(R$styleable.Chip_shapeAppearance);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.recycle();
            this.Wwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (!hasValue) {
                setOutlineProvider(new C2530qn(this));
            }
            setChecked(this.Wwwwwwwwwwwwwwwwwww);
            setText(chipDrawable.Kkkkkkkkkkkkkkkkk);
            setEllipsize(chipDrawable.IIll);
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.IIl) {
                setLines(1);
                setHorizontallyScrolling(true);
            }
            setGravity(8388627);
            Wwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwwwwwwwww) {
                setMinHeight(this.Wwwwwwwwwwwww);
            }
            this.Wwwwwwwwwwwwww = ViewCompat.getLayoutDirection(this);
        } else {
            truncateAt = TextUtils.TruncateAt.MIDDLE;
        }
        chipDrawable.IIll = truncateAt;
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (attributeSet != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_chipIcon));
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.Chip_chipIconTint)) {
        }
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (attributeSet != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_closeIcon));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_closeIconTint));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_android_checkable, false));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_checkedIcon));
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.Chip_checkedIconTint)) {
        }
        chipDrawable.Illllllllllllllllllllllllllll = C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_showMotionSpec);
        chipDrawable.Illlllllllllllllllllllllllll = C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.Chip_hideMotionSpec);
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        chipDrawable.Wwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        chipDrawable.O0000000000 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.recycle();
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, R$styleable.Chip, i, Wwwwwwww, new int[0]);
        this.Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
        this.Wwwwwwwwwwwww = (int) Math.ceil(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), 48))));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.recycle();
        setChipDrawable(chipDrawable);
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewCompat.getElevation(this));
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, R$styleable.Chip, i, Wwwwwwww, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
        }
        hasValue = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42.hasValue(R$styleable.Chip_shapeAppearance);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42.recycle();
        this.Wwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!hasValue) {
        }
        setChecked(this.Wwwwwwwwwwwwwwwwwww);
        setText(chipDrawable.Kkkkkkkkkkkkkkkkk);
        setEllipsize(chipDrawable.IIll);
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.IIl) {
        }
        setGravity(8388627);
        Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwww) {
        }
        this.Wwwwwwwwwwwwww = ViewCompat.getLayoutDirection(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.Wwwwwwwwww.setEmpty();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Wwwwwwwwwwwwwwwwwwwww != null) {
            ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.getBounds(), this.Wwwwwwwwww);
        }
        return this.Wwwwwwwwww;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.Wwwwwwwwwww.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.Wwwwwwwwwww;
    }

    @Nullable
    private C2832yp getTextAppearance() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.Wwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwww = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwwww = z;
            refreshDrawableState();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            paint.drawableState = chipDrawable.getState();
        }
        C2832yp textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), paint, this.Wwwwwwwww);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ChipDrawable chipDrawable;
        if (TextUtils.isEmpty(getText()) || (chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww) == null) {
            return;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwww = (int) (chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwww() + chipDrawable.Illlllllllllllllllll + chipDrawable.Illllllllllllllllllllll);
        ChipDrawable chipDrawable2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwww = (int) (chipDrawable2.Wwwwwwwwwwwwwwwwwwwwwwwww() + chipDrawable2.Illllllllllllllllllllllllll + chipDrawable2.Illlllllllllllllllllllll);
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            Rect rect = new Rect();
            this.Wwwwwwwwwwwwwwwwwwwwwww.getPadding(rect);
            Wwwwwwwwwwwwwwwwwwwwwwwww += rect.left;
            Wwwwwwwwwwwwwwwwwwwwwwww += rect.right;
        }
        ViewCompat.setPaddingRelative(this, Wwwwwwwwwwwwwwwwwwwwwwwww, getPaddingTop(), Wwwwwwwwwwwwwwwwwwwwwwww, getPaddingBottom());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwww = new RippleDrawable(C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkk), getBackgroundDrawable(), null);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        ViewCompat.setBackground(this, this.Wwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        ViewCompat.setBackground(this, getBackgroundDrawable());
        Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (getBackgroundDrawable() != this.Wwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwww.getCallback() != null) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setCallback(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if ((chipDrawable != null && chipDrawable.Kkkkkkkkkkk) && this.Wwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwww;
                ViewCompat.setAccessibilityDelegate(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        ViewCompat.setAccessibilityDelegate(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return chipDrawable != null && chipDrawable.Kkkkk;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return (chipDrawable == null || chipDrawable.Wwwwwwwwwwwwwwwwwwwwww() == null) ? false : true;
    }

    @Override // com.google.android.material.chip.ChipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww);
        requestLayout();
        invalidateOutline();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Dimension int i) {
        this.Wwwwwwwwwwwww = i;
        if (!this.Wwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return false;
        }
        int max = Math.max(0, i - ((int) this.Wwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkk));
        int max2 = Math.max(0, i - this.Wwwwwwwwwwwwwwwwwwwwwwww.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return false;
        }
        int i2 = max2 > 0 ? max2 / 2 : 0;
        int i3 = max > 0 ? max / 2 : 0;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            Rect rect = new Rect();
            this.Wwwwwwwwwwwwwwwwwwwwwww.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return true;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = new InsetDrawable((Drawable) this.Wwwwwwwwwwwwwwwwwwwwwwww, i2, i3, i2, i3);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return true;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        Field declaredField;
        boolean z;
        if (motionEvent.getAction() == 10) {
            try {
                declaredField = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
                declaredField.setAccessible(true);
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
            }
            if (((Integer) declaredField.get(this.Wwwwwwwwwwww)).intValue() != Integer.MIN_VALUE) {
                Method declaredMethod = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.Wwwwwwwwwwww, Integer.MIN_VALUE);
                z = true;
                return !z ? true : true;
            }
        }
        z = false;
        return !z ? true : true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.Wwwwwwwwwwww.dispatchKeyEvent(keyEvent) || this.Wwwwwwwwwwww.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [int, boolean] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        boolean z = false;
        int i = 0;
        z = false;
        if (chipDrawable != null && ChipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Kkkkkkkkkk)) {
            ChipDrawable chipDrawable2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            ?? isEnabled = isEnabled();
            int i2 = isEnabled;
            if (this.Wwwwwwwwwwwwwwww) {
                i2 = isEnabled + 1;
            }
            int i3 = i2;
            if (this.Wwwwwwwwwwwwwwwww) {
                i3 = i2 + 1;
            }
            int i4 = i3;
            if (this.Wwwwwwwwwwwwwwwwww) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (isChecked()) {
                i5 = i4 + 1;
            }
            int[] iArr = new int[i5];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            }
            if (this.Wwwwwwwwwwwwwwww) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.Wwwwwwwwwwwwwwwww) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.Wwwwwwwwwwwwwwwwww) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            z = chipDrawable2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr);
        }
        if (z) {
            invalidate();
        }
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.Wwwwwwwwwwwwwwwwwwwwwww;
        return insetDrawable == null ? this.Wwwwwwwwwwwwwwwwwwwwwwww : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Kkk;
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.f578Kk;
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Kkkkkkkkkkkkkkkkkkkkkkk;
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return Math.max(0.0f, chipDrawable.Wwwwwwwwwwwwwwwwwwwwwww());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Illlllllllllllllllll;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable;
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable == null || (drawable = chipDrawable.Kkkkkkkkkkkkkkk) == null) {
            return null;
        }
        return DrawableCompat.unwrap(drawable);
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Kkkkkkkkkkkkk;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Kkkkkkkkkkkkkk;
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Kkkkkkkkkkkkkkkkkkkkkk;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Illllllllllllllllllllllllll;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Kkkkkkkkkkkkkkkkkkkk;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Kkkkkkkkkkkkkkkkkkk;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Wwwwwwwwwwwwwwwwwwwwww();
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Kkkkkk;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Illllllllllllllllllll;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Kkkkkkk;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Illlllllllllllllllllll;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Kkkkkkkk;
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.IIll;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        if (this.Wwwwwwwwwwww.getKeyboardFocusedVirtualViewId() == 1 || this.Wwwwwwwwwwww.getAccessibilityFocusedVirtualViewId() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    @Nullable
    public C2449om getHideMotionSpec() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Illlllllllllllllllllllllllll;
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Illllllllllllllllllllllll;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Illlllllllllllllllllllllll;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Kkkkkkkkkkkkkkkkkk;
        }
        return null;
    }

    @Override // me.tvspark.AbstractC2570rq
    @NonNull
    public C2416nq getShapeAppearanceModel() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public C2449om getShowMotionSpec() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Illllllllllllllllllllllllllll;
        }
        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Illllllllllllllllllllll;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            return chipDrawable.Illlllllllllllllllllllll;
        }
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, (MaterialShapeDrawable) this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, Wwwwww);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, Wwwww);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        this.Wwwwwwwwwwww.onFocusChanged(z, i, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        boolean contains;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                contains = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(contains);
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || isClickable()) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? "android.widget.CompoundButton" : "android.widget.Button" : ExploreByTouchHelper.DEFAULT_CLASS_NAME);
        accessibilityNodeInfo.setCheckable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            if (chipGroup.Wwwwwwwwwwwwwwwwwwwwww) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= chipGroup.getChildCount()) {
                        i3 = -1;
                        break;
                    }
                    if (chipGroup.getChildAt(i2) instanceof Chip) {
                        if (((Chip) chipGroup.getChildAt(i2)) == this) {
                            break;
                        }
                        i3++;
                    }
                    i2++;
                }
                i = i3;
            } else {
                i = -1;
            }
            Object tag = getTag(R$id.row_index_key);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(!(tag instanceof Integer) ? -1 : ((Integer) tag).intValue(), 1, i, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.Wwwwwwwwwwwwww != i) {
            this.Wwwwwwwwwwwwww = i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r0 != 3) goto L16;
     */
    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.Wwwwwwwwwwwwwwwwww) {
                        if (!contains) {
                            setCloseIconPressed(false);
                        }
                        z = true;
                    }
                }
                z = false;
            } else if (this.Wwwwwwwwwwwwwwwwww) {
                playSoundEffect(0);
                View.OnClickListener onClickListener = this.Wwwwwwwwwwwwwwwwwwwww;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
                this.Wwwwwwwwwwww.sendEventForVirtualView(1, 1);
                z = true;
                setCloseIconPressed(false);
            }
            z = false;
            setCloseIconPressed(false);
        } else {
            if (contains) {
                setCloseIconPressed(true);
                z = true;
            }
            z = false;
        }
        return z || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.Wwwwwwwwwwwwwwwwwwwwww) {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.Wwwwwwwwwwwwwwwwwwwwww) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
    }

    public void setCheckable(boolean z) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        }
    }

    public void setCheckableResource(@BoolRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable == null) {
            this.Wwwwwwwwwwwwwwwwwww = z;
        } else if (!chipDrawable.Kkkkk) {
        } else {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked == z || (onCheckedChangeListener = this.Wwwwwwwwwwwwwwwwwwww) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AppCompatResources.getDrawable(chipDrawable.Illllllllllllllllll, i));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AppCompatResources.getColorStateList(chipDrawable.Illllllllllllllllll, i));
        }
    }

    public void setCheckedIconVisible(@BoolRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getBoolean(i));
        }
    }

    public void setCheckedIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable == null || chipDrawable.Kkkkkkkkkkkkkkkkkkkkkkk == colorStateList) {
            return;
        }
        chipDrawable.Kkkkkkkkkkkkkkkkkkkkkkk = colorStateList;
        chipDrawable.onStateChange(chipDrawable.getState());
    }

    public void setChipBackgroundColorResource(@ColorRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AppCompatResources.getColorStateList(chipDrawable.Illllllllllllllllll, i));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(@NonNull ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable2 != chipDrawable) {
            if (chipDrawable2 != null) {
                chipDrawable2.IIlll = new WeakReference<>(null);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = chipDrawable;
            chipDrawable.IIl = false;
            if (chipDrawable != null) {
                chipDrawable.IIlll = new WeakReference<>(this);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww);
                return;
            }
            throw null;
        }
    }

    public void setChipEndPadding(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable == null || chipDrawable.Illlllllllllllllllll == f) {
            return;
        }
        chipDrawable.Illlllllllllllllllll = f;
        chipDrawable.invalidateSelf();
        chipDrawable.Wwwwwwwwwwwwwwwwwwww();
    }

    public void setChipEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(@DrawableRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AppCompatResources.getDrawable(chipDrawable.Illllllllllllllllll, i));
        }
    }

    public void setChipIconSize(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AppCompatResources.getColorStateList(chipDrawable.Illllllllllllllllll, i));
        }
    }

    public void setChipIconVisible(@BoolRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getBoolean(i));
        }
    }

    public void setChipIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        }
    }

    public void setChipMinHeight(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable == null || chipDrawable.Kkkkkkkkkkkkkkkkkkkkkk == f) {
            return;
        }
        chipDrawable.Kkkkkkkkkkkkkkkkkkkkkk = f;
        chipDrawable.invalidateSelf();
        chipDrawable.Wwwwwwwwwwwwwwwwwwww();
    }

    public void setChipMinHeightResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    public void setChipStartPadding(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable == null || chipDrawable.Illllllllllllllllllllllllll == f) {
            return;
        }
        chipDrawable.Illllllllllllllllllllllllll = f;
        chipDrawable.invalidateSelf();
        chipDrawable.Wwwwwwwwwwwwwwwwwwww();
    }

    public void setChipStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(AppCompatResources.getColorStateList(chipDrawable.Illllllllllllllllll, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwww(f);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(drawable);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable == null || chipDrawable.Kkkkkk == charSequence) {
            return;
        }
        chipDrawable.Kkkkkk = BidiFormatter.getInstance().unicodeWrap(charSequence);
        chipDrawable.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww(f);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(@DrawableRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AppCompatResources.getDrawable(chipDrawable.Illllllllllllllllll, i));
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setCloseIconSize(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwww(f);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwww(f);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(AppCompatResources.getColorStateList(chipDrawable.Illllllllllllllllll, i));
        }
    }

    public void setCloseIconVisible(@BoolRes int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    public void setCloseIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i == 0) {
            if (i3 != 0) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
            return;
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i == 0) {
            if (i3 != 0) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
            return;
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 != null) {
                throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            MaterialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww == f) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = f;
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable == null) {
            return;
        }
        chipDrawable.IIll = truncateAt;
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.Wwwwwwwwwwwwwww = z;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            return;
        }
        super.setGravity(i);
    }

    public void setHideMotionSpec(@Nullable C2449om c2449om) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Illlllllllllllllllllllllllll = c2449om;
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Illlllllllllllllllllllllllll = C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, i);
        }
    }

    public void setIconEndPadding(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwww(f);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwww(f);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@AbstractC0047Px int i) {
        super.setMaxWidth(i);
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.O0000000000 = i;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.Wwwwwwwwwwwwwwwwwwww = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.Wwwwwwwwwwwwwwwwwwwww = onClickListener;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList);
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.IIlllll) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setRippleColorResource(@ColorRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwww(AppCompatResources.getColorStateList(chipDrawable.Illllllllllllllllll, i));
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.IIlllll) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC2570rq
    public void setShapeAppearanceModel(@NonNull C2416nq c2416nq) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq;
        chipDrawable.invalidateSelf();
    }

    public void setShowMotionSpec(@Nullable C2449om c2449om) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Illllllllllllllllllllllllllll = c2449om;
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Illllllllllllllllllllllllllll = C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll, i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(this.Wwwwwwwwwwwwwwwwwwwwwwww.IIl ? null : charSequence, bufferType);
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable == null) {
            return;
        }
        chipDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2832yp(chipDrawable.Illllllllllllllllll, i), chipDrawable.Illllllllllllllllll);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setTextAppearanceResource(@StyleRes int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable == null || chipDrawable.Illllllllllllllllllllll == f) {
            return;
        }
        chipDrawable.Illllllllllllllllllllll = f;
        chipDrawable.invalidateSelf();
        chipDrawable.Wwwwwwwwwwwwwwwwwwww();
    }

    public void setTextEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    public void setTextStartPadding(float f) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable == null || chipDrawable.Illlllllllllllllllllllll == f) {
            return;
        }
        chipDrawable.Illlllllllllllllllllllll = f;
        chipDrawable.invalidateSelf();
        chipDrawable.Wwwwwwwwwwwwwwwwwwww();
    }

    public void setTextStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Wwwwwwwwwwwwwwwwwwww(chipDrawable.Illllllllllllllllll.getResources().getDimension(i));
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2832yp(chipDrawable.Illllllllllllllllll, i), chipDrawable.Illllllllllllllllll);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setTextAppearance(@Nullable C2832yp c2832yp) {
        ChipDrawable chipDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (chipDrawable != null) {
            chipDrawable.Illlllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2832yp, chipDrawable.Illllllllllllllllll);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}

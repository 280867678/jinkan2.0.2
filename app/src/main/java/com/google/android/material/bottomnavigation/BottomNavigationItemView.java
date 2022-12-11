package com.google.android.material.bottomnavigation;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import me.tvspark.C1989cn;
import me.tvspark.C2043dn;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {
    public static final int[] Wwwwwwww = {16842912};
    @Nullable
    public C1989cn Wwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwww;
    @Nullable
    public MenuItemImpl Wwwwwwwwwwwww;
    public int Wwwwwwwwwwwwww;
    public final TextView Wwwwwwwwwwwwwww;
    public final TextView Wwwwwwwwwwwwwwww;
    public final ViewGroup Wwwwwwwwwwwwwwwww;
    public ImageView Wwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i2 = 0; i2 < indexOfChild; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof BottomNavigationItemView) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = f - f2;
        this.Wwwwwwwwwwwwwwwwwwwwww = (f2 * 1.0f) / f;
        this.Wwwwwwwwwwwwwwwwwwwww = (f * 1.0f) / f2;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwww != null;
    }

    @Nullable
    public C1989cn getBadge() {
        return this.Wwwwwwwww;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.Wwwwwwwwwwwww;
    }

    public int getItemPosition() {
        return this.Wwwwwwwwwwwwww;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i) {
        this.Wwwwwwwwwwwww = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        TooltipCompat.setTooltipText(this, !TextUtils.isEmpty(menuItemImpl.getTooltipText()) ? menuItemImpl.getTooltipText() : menuItemImpl.getTitle());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        MenuItemImpl menuItemImpl = this.Wwwwwwwwwwwww;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.Wwwwwwwwwwwww.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, Wwwwwwww);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C1989cn c1989cn = this.Wwwwwwwww;
        if (c1989cn != null && c1989cn.isVisible()) {
            CharSequence title = this.Wwwwwwwwwwwww.getTitle();
            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwww.getContentDescription())) {
                title = this.Wwwwwwwwwwwww.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(R$string.item_view_role_description));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setBadge(@NonNull C1989cn c1989cn) {
        this.Wwwwwwwww = c1989cn;
        ImageView imageView = this.Wwwwwwwwwwwwwwwwww;
        if (imageView == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || imageView == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        C2043dn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwww, imageView, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
        if (r9 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0069, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r8.Wwwwwwwwwwwwwwwwww, (int) (r8.Wwwwwwwwwwwwwwwwwwwwwwww + r8.Wwwwwwwwwwwwwwwwwwwwwww), 49);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r8.Wwwwwwwwwwwwwww, 1.0f, 1.0f, 0);
        r0 = r8.Wwwwwwwwwwwwwwww;
        r1 = r8.Wwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0, r1, r1, 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0082, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r8.Wwwwwwwwwwwwwwwwww, r8.Wwwwwwwwwwwwwwwwwwwwwwww, 49);
        r0 = r8.Wwwwwwwwwwwwwww;
        r1 = r8.Wwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0, r1, r1, 4);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r8.Wwwwwwwwwwwwwwww, 1.0f, 1.0f, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x009a, code lost:
        if (r9 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009c, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0, r1, 49);
        r0 = r8.Wwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0, ((java.lang.Integer) r0.getTag(com.google.android.material.R$id.mtrl_view_tag_bottom_padding)).intValue());
        r8.Wwwwwwwwwwwwwww.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c3, code lost:
        r8.Wwwwwwwwwwwwwwww.setVisibility(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b6, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0, r1, 17);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r8.Wwwwwwwwwwwwwwwww, 0);
        r8.Wwwwwwwwwwwwwww.setVisibility(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d1, code lost:
        if (r9 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e5, code lost:
        if (r9 != false) goto L13;
     */
    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setChecked(boolean z) {
        ImageView imageView;
        int i;
        TextView textView = this.Wwwwwwwwwwwwwww;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.Wwwwwwwwwwwwwww;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.Wwwwwwwwwwwwwwww;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.Wwwwwwwwwwwwwwww;
        textView4.setPivotY(textView4.getBaseline());
        int i2 = this.Wwwwwwwwwwwwwwwwwwww;
        if (i2 != -1) {
            if (i2 == 0) {
                imageView = this.Wwwwwwwwwwwwwwwwww;
                i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            } else if (i2 == 1) {
                ViewGroup viewGroup = this.Wwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, ((Integer) viewGroup.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue());
            } else if (i2 == 2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, 17);
                this.Wwwwwwwwwwwwwww.setVisibility(8);
                this.Wwwwwwwwwwwwwwww.setVisibility(8);
            }
        } else if (this.Wwwwwwwwwwwwwwwwwww) {
            imageView = this.Wwwwwwwwwwwwwwwwww;
            i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            ViewGroup viewGroup2 = this.Wwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup2, ((Integer) viewGroup2.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue());
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.Wwwwwwwwwwwwwwww.setEnabled(z);
        this.Wwwwwwwwwwwwwww.setEnabled(z);
        this.Wwwwwwwwwwwwwwwwww.setEnabled(z);
        ViewCompat.setPointerIcon(this, z ? PointerIconCompat.getSystemIcon(getContext(), 1002) : null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.Wwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwww = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.Wwwwwwwwww = drawable;
            ColorStateList colorStateList = this.Wwwwwwwwwwww;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
        this.Wwwwwwwwwwwwwwwwww.setImageDrawable(drawable);
    }

    public void setIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Wwwwwwwwwwwwwwwwww.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.Wwwwwwwwwwwwwwwwww.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.Wwwwwwwwwwww = colorStateList;
        if (this.Wwwwwwwwwwwww == null || (drawable = this.Wwwwwwwwww) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable, colorStateList);
        this.Wwwwwwwwww.invalidateSelf();
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.setBackground(this, drawable);
    }

    public void setItemPosition(int i) {
        this.Wwwwwwwwwwwwww = i;
    }

    public void setLabelVisibilityMode(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwww != i) {
            this.Wwwwwwwwwwwwwwwwwwww = i;
            if (!(this.Wwwwwwwwwwwww != null)) {
                return;
            }
            setChecked(this.Wwwwwwwwwwwww.isChecked());
        }
    }

    public void setShifting(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwwwww = z;
            if (!(this.Wwwwwwwwwwwww != null)) {
                return;
            }
            setChecked(this.Wwwwwwwwwwwww.isChecked());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearanceActive(@StyleRes int i) {
        TextViewCompat.setTextAppearance(this.Wwwwwwwwwwwwwww, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww.getTextSize(), this.Wwwwwwwwwwwwwww.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i) {
        TextViewCompat.setTextAppearance(this.Wwwwwwwwwwwwwwww, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww.getTextSize(), this.Wwwwwwwwwwwwwww.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.Wwwwwwwwwwwwwwww.setTextColor(colorStateList);
            this.Wwwwwwwwwwwwwww.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.Wwwwwwwwwwwwwwww.setText(charSequence);
        this.Wwwwwwwwwwwwwww.setText(charSequence);
        MenuItemImpl menuItemImpl = this.Wwwwwwwwwwwww;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.Wwwwwwwwwwwww;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.Wwwwwwwwwwwww.getTooltipText();
        }
        TooltipCompat.setTooltipText(this, charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }
}

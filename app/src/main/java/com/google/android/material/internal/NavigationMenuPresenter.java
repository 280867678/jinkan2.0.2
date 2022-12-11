package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;
import me.tvspark.C2267jp;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class NavigationMenuPresenter implements MenuPresenter {
    public int Wwwwwwww;
    public int Wwwwwwwww;
    public boolean Wwwwwwwwww;
    public int Wwwwwwwwwww;
    public int Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public Drawable Wwwwwwwwwwwwww;
    public ColorStateList Wwwwwwwwwwwwwww;
    public ColorStateList Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public LayoutInflater Wwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public MenuBuilder Wwwwwwwwwwwwwwwwwwwww;
    public MenuPresenter.Callback Wwwwwwwwwwwwwwwwwwwwww;
    public LinearLayout Wwwwwwwwwwwwwwwwwwwwwww;
    public NavigationMenuView Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwww = -1;
    public final View.OnClickListener Wwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwww extends RecyclerView.ViewHolder {
        public Wwwwwwwwwwwwwwwwwwwwwww(View view) {
            super(view);
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwww(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwww(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww extends RecyclerViewAccessibilityDelegate {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwwww;
            int i = NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwwwwwww.getChildCount() == 0 ? 0 : 1;
            for (int i2 = 0; i2 < NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwwww.getItemCount(); i2++) {
                if (NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwwww.getItemViewType(i2) == 0) {
                    i++;
                }
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i, 0, false));
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final MenuItemImpl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(MenuItemImpl menuItemImpl) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = menuItemImpl;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends RecyclerView.Adapter<Wwwwwwwwwwwwwwwwwwwwwww> {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public MenuItemImpl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList<>();

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            int i = -1;
            int size = NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwwwww.getVisibleItems().size();
            boolean z = false;
            int i2 = 0;
            boolean z2 = false;
            int i3 = 0;
            while (i2 < size) {
                MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwwwww.getVisibleItems().get(i2);
                if (menuItemImpl.isChecked()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(z);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i2 != 0) {
                            ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> arrayList = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i4 = NavigationMenuPresenter.this.Wwwwwwww;
                            int i5 = z ? 1 : 0;
                            int i6 = z ? 1 : 0;
                            int i7 = z ? 1 : 0;
                            int i8 = z ? 1 : 0;
                            arrayList.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, i5));
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(menuItemImpl));
                        int size2 = subMenu.size();
                        int i9 = 0;
                        boolean z3 = false;
                        while (i9 < size2) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i9);
                            if (menuItemImpl2.isVisible()) {
                                if (!z3 && menuItemImpl2.getIcon() != null) {
                                    z3 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(z);
                                }
                                if (menuItemImpl.isChecked()) {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(menuItemImpl);
                                }
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(menuItemImpl2));
                            }
                            i9++;
                            z = false;
                        }
                        if (z3) {
                            int size3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
                            for (int size4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); size4 < size3; size4++) {
                                ((Wwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(size4)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                            }
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i) {
                        i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
                        z2 = menuItemImpl.getIcon() != null;
                        if (i2 != 0) {
                            i3++;
                            ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> arrayList2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i10 = NavigationMenuPresenter.this.Wwwwwwww;
                            arrayList2.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10, i10));
                        }
                    } else if (!z2 && menuItemImpl.getIcon() != null) {
                        int size5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
                        for (int i11 = i3; i11 < size5; i11++) {
                            ((Wwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i11)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        }
                        z2 = true;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(menuItemImpl);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    i = groupId;
                }
                i2++;
                z = false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MenuItemImpl menuItemImpl) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return 2;
            }
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return 3;
            }
            if (!(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                throw new RuntimeException("Unknown item type.");
            }
            return ((Wwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasSubMenu() ? 1 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull Wwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwww, int i) {
            Wwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwww;
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((TextView) wwwwwwwwwwwwwwwwwwwwwww2.itemView).setText(((Wwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getTitle());
                    return;
                } else if (itemViewType != 2) {
                    return;
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                    wwwwwwwwwwwwwwwwwwwwwww2.itemView.setPadding(0, wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) wwwwwwwwwwwwwwwwwwwwwww2.itemView;
            navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.Wwwwwwwwwwwwwww);
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            if (navigationMenuPresenter.Wwwwwwwwwwwwwwwww) {
                navigationMenuItemView.setTextAppearance(navigationMenuPresenter.Wwwwwwwwwwwwwwwwww);
            }
            ColorStateList colorStateList = NavigationMenuPresenter.this.Wwwwwwwwwwwwwwww;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = NavigationMenuPresenter.this.Wwwwwwwwwwwwww;
            ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            navigationMenuItemView.setNeedsEmptyIcon(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            navigationMenuItemView.setHorizontalPadding(NavigationMenuPresenter.this.Wwwwwwwwwwwww);
            navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.Wwwwwwwwwwww);
            NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
            if (navigationMenuPresenter2.Wwwwwwwwww) {
                navigationMenuItemView.setIconSize(navigationMenuPresenter2.Wwwwwwwwwww);
            }
            navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.Wwwwwwwww);
            navigationMenuItemView.initialize(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public Wwwwwwwwwwwwwwwwwwwwwww onCreateViewHolder(ViewGroup viewGroup, int i) {
            Wwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                wwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwww(navigationMenuPresenter.Wwwwwwwwwwwwwwwwwww, viewGroup, navigationMenuPresenter.Wwwwww);
            } else if (i == 1) {
                wwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwww(NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwww, viewGroup);
            } else if (i != 2) {
                if (i == 3) {
                    return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwwwwwww);
                }
                return null;
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwww(NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwww, viewGroup);
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(Wwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwww2 instanceof Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) wwwwwwwwwwwwwwwwwwwwwww2.itemView;
                FrameLayout frameLayout = navigationMenuItemView.Wwwwwwwwwwwwww;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                navigationMenuItemView.Wwwwwwwwwwwwwww.setCompoundDrawables(null, null, null, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
            super(view);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwwww;
            boolean z = true;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            MenuItemImpl itemData = navigationMenuItemView.getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean performItemAction = navigationMenuPresenter.Wwwwwwwwwwwwwwwwwwwww.performItemAction(itemData, navigationMenuPresenter, 0);
            if (itemData == null || !itemData.isCheckable() || !performItemAction) {
                z = false;
            } else {
                NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(itemData);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = NavigationMenuPresenter.this.Wwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            }
            if (z) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.Wwwwwwwwwwwwwwwwwww.inflate(R$layout.design_navigation_menu, viewGroup, false);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww));
            if (this.Wwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            int i = this.Wwwwwww;
            if (i != -1) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.setOverScrollMode(i);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = (LinearLayout) this.Wwwwwwwwwwwwwwwwwww.inflate(R$layout.design_navigation_item_header, (ViewGroup) this.Wwwwwwwwwwwwwwwwwwwwwwww, false);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setAdapter(this.Wwwwwwwwwwwwwwwwwwww);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.Wwwwwwwwwwwwwwwwwww = LayoutInflater.from(context);
        this.Wwwwwwwwwwwwwwwwwwwww = menuBuilder;
        this.Wwwwwwww = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItemImpl menuItemImpl;
        View actionView;
        C2267jp c2267jp;
        MenuItemImpl menuItemImpl2;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(ListMenuPresenter.VIEWS_TAG);
            if (sparseParcelableArray != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    throw null;
                }
                int i = bundle2.getInt("android:menu:checked", 0);
                if (i != 0) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                    int size = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
                        if ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwww) && (menuItemImpl2 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null && menuItemImpl2.getItemId() == i) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(menuItemImpl2);
                            break;
                        }
                        i2++;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i3);
                        if ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwww) && (menuItemImpl = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null && (actionView = menuItemImpl.getActionView()) != null && (c2267jp = (C2267jp) sparseParcelableArray2.get(menuItemImpl.getItemId())) != null) {
                            actionView.restoreHierarchyState(c2267jp);
                        }
                    }
                }
            }
            SparseArray sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 == null) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww.restoreHierarchyState(sparseParcelableArray3);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.Wwwwwwwwwwwwwwwwwwwwwwww.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray(ListMenuPresenter.VIEWS_TAG, sparseArray);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                Bundle bundle2 = new Bundle();
                MenuItemImpl menuItemImpl = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (menuItemImpl != null) {
                    bundle2.putInt("android:menu:checked", menuItemImpl.getItemId());
                }
                SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
                int size = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
                for (int i = 0; i < size; i++) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        MenuItemImpl menuItemImpl2 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        View actionView = menuItemImpl2 != null ? menuItemImpl2.getActionView() : null;
                        if (actionView != null) {
                            C2267jp c2267jp = new C2267jp();
                            actionView.saveHierarchyState(c2267jp);
                            sparseArray2.put(menuItemImpl2.getItemId(), c2267jp);
                        }
                    }
                }
                bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
                bundle.putBundle("android:menu:adapter", bundle2);
            } else {
                throw null;
            }
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            SparseArray<? extends Parcelable> sparseArray3 = new SparseArray<>();
            this.Wwwwwwwwwwwwwwwwwwwwwww.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.Wwwwwwwwwwwwwwwwwwwwww = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.notifyDataSetChanged();
        }
    }
}

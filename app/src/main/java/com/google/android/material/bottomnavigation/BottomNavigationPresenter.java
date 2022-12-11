package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import me.tvspark.C2267jp;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class BottomNavigationPresenter implements MenuPresenter {
    public boolean Wwwwwwwwwwwwwwwwwwwwwww = false;
    public MenuBuilder Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable {
        public static final Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> CREATOR = new C3451Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        @Nullable
        public C2267jp Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: com.google.android.material.bottomnavigation.BottomNavigationPresenter$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C3451Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww createFromParcel(@NonNull Parcel parcel) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] newArray(int i) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Parcel parcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwwwwww = (C2267jp) parcel.readParcelable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeParcelable(this.Wwwwwwwwwwwwwwwwwwwwwww, 0);
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
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = menuBuilder;
        throw null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return;
        }
        int i = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) parcelable).Wwwwwwwwwwwwwwwwwwwwwwww;
        throw null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        throw null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        throw null;
    }
}

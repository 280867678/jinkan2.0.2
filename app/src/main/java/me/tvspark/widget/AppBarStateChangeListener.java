package me.tvspark.widget;

import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes4.dex */
public abstract class AppBarStateChangeListener implements AppBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public State Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = State.IDLE;

    /* loaded from: classes4.dex */
    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AppBarLayout appBarLayout, int i) {
        State state;
        if (i == 0) {
            State state2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            State state3 = State.EXPANDED;
            if (state2 != state3) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appBarLayout, state3);
            }
            state = State.EXPANDED;
        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            State state4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            State state5 = State.COLLAPSED;
            if (state4 != state5) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appBarLayout, state5);
            }
            state = State.COLLAPSED;
        } else {
            State state6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            State state7 = State.IDLE;
            if (state6 != state7) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appBarLayout, state7);
            }
            state = State.IDLE;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = state;
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AppBarLayout appBarLayout, State state);
}

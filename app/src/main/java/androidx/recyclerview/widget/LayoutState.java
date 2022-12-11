package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class LayoutState {
    public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    public static final int ITEM_DIRECTION_HEAD = -1;
    public static final int ITEM_DIRECTION_TAIL = 1;
    public static final int LAYOUT_END = 1;
    public static final int LAYOUT_START = -1;
    public int mAvailable;
    public int mCurrentPosition;
    public boolean mInfinite;
    public int mItemDirection;
    public int mLayoutDirection;
    public boolean mStopInFocusable;
    public boolean mRecycle = true;
    public int mStartLine = 0;
    public int mEndLine = 0;

    public boolean hasMore(RecyclerView.State state) {
        int i = this.mCurrentPosition;
        return i >= 0 && i < state.getItemCount();
    }

    public View next(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return viewForPosition;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LayoutState{mAvailable=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mAvailable);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", mCurrentPosition=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mCurrentPosition);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", mItemDirection=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mItemDirection);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", mLayoutDirection=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mLayoutDirection);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", mStartLine=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mStartLine);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", mEndLine=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mEndLine);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

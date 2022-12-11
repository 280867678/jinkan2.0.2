package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class FocusStrategy {

    /* loaded from: classes3.dex */
    public interface BoundsAdapter<T> {
        void obtainBounds(T t, Rect rect);
    }

    /* loaded from: classes3.dex */
    public interface CollectionAdapter<T, V> {
        V get(T t, int i);

        int size(T t);
    }

    /* loaded from: classes3.dex */
    public static class SequentialComparator<T> implements Comparator<T> {
        public final BoundsAdapter<T> mAdapter;
        public final boolean mIsLayoutRtl;
        public final Rect mTemp1 = new Rect();
        public final Rect mTemp2 = new Rect();

        public SequentialComparator(boolean z, BoundsAdapter<T> boundsAdapter) {
            this.mIsLayoutRtl = z;
            this.mAdapter = boundsAdapter;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            Rect rect = this.mTemp1;
            Rect rect2 = this.mTemp2;
            this.mAdapter.obtainBounds(t, rect);
            this.mAdapter.obtainBounds(t2, rect2);
            int i = rect.top;
            int i2 = rect2.top;
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            int i3 = rect.left;
            int i4 = rect2.left;
            if (i3 < i4) {
                return this.mIsLayoutRtl ? 1 : -1;
            } else if (i3 > i4) {
                return this.mIsLayoutRtl ? -1 : 1;
            } else {
                int i5 = rect.bottom;
                int i6 = rect2.bottom;
                if (i5 < i6) {
                    return -1;
                }
                if (i5 > i6) {
                    return 1;
                }
                int i7 = rect.right;
                int i8 = rect2.right;
                if (i7 < i8) {
                    return this.mIsLayoutRtl ? 1 : -1;
                } else if (i7 <= i8) {
                    return 0;
                } else {
                    return this.mIsLayoutRtl ? -1 : 1;
                }
            }
        }
    }

    public static boolean beamBeats(int i, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean beamsOverlap = beamsOverlap(i, rect, rect2);
        if (beamsOverlap(i, rect, rect3) || !beamsOverlap) {
            return false;
        }
        return !isToDirectionOf(i, rect, rect3) || i == 17 || i == 66 || majorAxisDistance(i, rect, rect2) < majorAxisDistanceToFarEdge(i, rect, rect3);
    }

    public static boolean beamsOverlap(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L l, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t, @NonNull Rect rect, int i) {
        int width;
        int size;
        int height;
        Rect rect2 = new Rect(rect);
        if (i != 17) {
            if (i == 33) {
                height = rect.height() + 1;
            } else if (i == 66) {
                width = -(rect.width() + 1);
            } else if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            } else {
                height = -(rect.height() + 1);
            }
            rect2.offset(0, height);
            T t2 = null;
            size = collectionAdapter.size(l);
            Rect rect3 = new Rect();
            for (int i2 = 0; i2 < size; i2++) {
                T t3 = collectionAdapter.get(l, i2);
                if (t3 != t) {
                    boundsAdapter.obtainBounds(t3, rect3);
                    if (isBetterCandidate(i, rect, rect3, rect2)) {
                        rect2.set(rect3);
                        t2 = t3;
                    }
                }
            }
            return t2;
        }
        width = rect.width() + 1;
        rect2.offset(width, 0);
        T t22 = null;
        size = collectionAdapter.size(l);
        Rect rect32 = new Rect();
        while (i2 < size) {
        }
        return t22;
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L l, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t, int i, boolean z, boolean z2) {
        int size = collectionAdapter.size(l);
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(collectionAdapter.get(l, i2));
        }
        Collections.sort(arrayList, new SequentialComparator(z, boundsAdapter));
        if (i != 1) {
            if (i != 2) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
            return (T) getNextFocusable(t, arrayList, z2);
        }
        return (T) getPreviousFocusable(t, arrayList, z2);
    }

    public static <T> T getNextFocusable(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int lastIndexOf = (t == null ? -1 : arrayList.lastIndexOf(t)) + 1;
        if (lastIndexOf < size) {
            return arrayList.get(lastIndexOf);
        }
        if (z && size > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    public static <T> T getPreviousFocusable(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int indexOf = (t == null ? size : arrayList.indexOf(t)) - 1;
        if (indexOf >= 0) {
            return arrayList.get(indexOf);
        }
        if (z && size > 0) {
            return arrayList.get(size - 1);
        }
        return null;
    }

    public static int getWeightedDistanceFor(int i, int i2) {
        return (i2 * i2) + (i * 13 * i);
    }

    public static boolean isBetterCandidate(int i, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (!isCandidate(rect, rect2, i)) {
            return false;
        }
        if (!isCandidate(rect, rect3, i) || beamBeats(i, rect, rect2, rect3)) {
            return true;
        }
        return !beamBeats(i, rect, rect3, rect2) && getWeightedDistanceFor(majorAxisDistance(i, rect, rect2), minorAxisDistance(i, rect, rect2)) < getWeightedDistanceFor(majorAxisDistance(i, rect, rect3), minorAxisDistance(i, rect, rect3));
    }

    public static boolean isCandidate(@NonNull Rect rect, @NonNull Rect rect2, int i) {
        if (i == 17) {
            int i2 = rect.right;
            int i3 = rect2.right;
            return (i2 > i3 || rect.left >= i3) && rect.left > rect2.left;
        } else if (i == 33) {
            int i4 = rect.bottom;
            int i5 = rect2.bottom;
            return (i4 > i5 || rect.top >= i5) && rect.top > rect2.top;
        } else if (i == 66) {
            int i6 = rect.left;
            int i7 = rect2.left;
            return (i6 < i7 || rect.right <= i7) && rect.right < rect2.right;
        } else if (i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            int i8 = rect.top;
            int i9 = rect2.top;
            return (i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom;
        }
    }

    public static boolean isToDirectionOf(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i == 17) {
            return rect.left >= rect2.right;
        } else if (i == 33) {
            return rect.top >= rect2.bottom;
        } else if (i == 66) {
            return rect.right <= rect2.left;
        } else if (i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            return rect.bottom <= rect2.top;
        }
    }

    public static int majorAxisDistance(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i, rect, rect2));
    }

    public static int majorAxisDistanceRaw(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (i == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else if (i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            i2 = rect2.top;
            i3 = rect.bottom;
        }
        return i2 - i3;
    }

    public static int majorAxisDistanceToFarEdge(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i, rect, rect2));
    }

    public static int majorAxisDistanceToFarEdgeRaw(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.left;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.top;
        } else if (i == 66) {
            i2 = rect2.right;
            i3 = rect.right;
        } else if (i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            i2 = rect2.bottom;
            i3 = rect.bottom;
        }
        return i2 - i3;
    }

    public static int minorAxisDistance(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        int height;
        int i2;
        int height2;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            height = (rect.width() / 2) + rect.left;
            i2 = rect2.left;
            height2 = rect2.width();
            return Math.abs(height - ((height2 / 2) + i2));
        }
        height = (rect.height() / 2) + rect.top;
        i2 = rect2.top;
        height2 = rect2.height();
        return Math.abs(height - ((height2 / 2) + i2));
    }
}

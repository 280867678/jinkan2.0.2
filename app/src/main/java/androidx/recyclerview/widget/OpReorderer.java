package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

/* loaded from: classes3.dex */
public class OpReorderer {
    public final Callback mCallback;

    /* loaded from: classes3.dex */
    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        int i3 = updateOp.itemCount < updateOp2.positionStart ? -1 : 0;
        if (updateOp.positionStart < updateOp2.positionStart) {
            i3++;
        }
        int i4 = updateOp2.positionStart;
        int i5 = updateOp.positionStart;
        if (i4 <= i5) {
            updateOp.positionStart = i5 + updateOp2.itemCount;
        }
        int i6 = updateOp2.positionStart;
        int i7 = updateOp.itemCount;
        if (i6 <= i7) {
            updateOp.itemCount = i7 + updateOp2.itemCount;
        }
        updateOp2.positionStart += i3;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i, int i2) {
        AdapterHelper.UpdateOp updateOp = list.get(i);
        AdapterHelper.UpdateOp updateOp2 = list.get(i2);
        int i3 = updateOp2.cmd;
        if (i3 == 1) {
            swapMoveAdd(list, i, updateOp, i2, updateOp2);
        } else if (i3 == 2) {
            swapMoveRemove(list, i, updateOp, i2, updateOp2);
        } else if (i3 != 4) {
        } else {
            swapMoveUpdate(list, i, updateOp, i2, updateOp2);
        }
    }

    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009e, code lost:
        if (r0 > r14.positionStart) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ca, code lost:
        r12.itemCount = r0 - r14.itemCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c8, code lost:
        if (r0 >= r14.positionStart) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        boolean z;
        int i3;
        int i4 = updateOp.positionStart;
        int i5 = updateOp.itemCount;
        boolean z2 = false;
        int i6 = updateOp2.positionStart;
        if (i4 < i5) {
            if (i6 == i4 && updateOp2.itemCount == i5 - i4) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (i6 == i5 + 1 && updateOp2.itemCount == i4 - i5) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i7 = updateOp.itemCount;
        int i8 = updateOp2.positionStart;
        if (i7 < i8) {
            updateOp2.positionStart = i8 - 1;
        } else {
            int i9 = updateOp2.itemCount;
            if (i7 < i8 + i9) {
                updateOp2.itemCount = i9 - 1;
                updateOp.cmd = 2;
                updateOp.itemCount = 1;
                if (updateOp2.itemCount != 0) {
                    return;
                }
                list.remove(i2);
                this.mCallback.recycleUpdateOp(updateOp2);
                return;
            }
        }
        int i10 = updateOp.positionStart;
        int i11 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i10 <= i11) {
            updateOp2.positionStart = i11 + 1;
        } else {
            int i12 = updateOp2.itemCount;
            if (i10 < i11 + i12) {
                updateOp3 = this.mCallback.obtainUpdateOp(2, i10 + 1, (i11 + i12) - i10, null);
                updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
            }
        }
        if (z2) {
            list.set(i, updateOp2);
            list.remove(i2);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (z) {
            if (updateOp3 != null) {
                int i13 = updateOp.positionStart;
                if (i13 > updateOp3.positionStart) {
                    updateOp.positionStart = i13 - updateOp3.itemCount;
                }
                int i14 = updateOp.itemCount;
                if (i14 > updateOp3.positionStart) {
                    updateOp.itemCount = i14 - updateOp3.itemCount;
                }
            }
            int i15 = updateOp.positionStart;
            if (i15 > updateOp2.positionStart) {
                updateOp.positionStart = i15 - updateOp2.itemCount;
            }
            i3 = updateOp.itemCount;
        } else {
            if (updateOp3 != null) {
                int i16 = updateOp.positionStart;
                if (i16 >= updateOp3.positionStart) {
                    updateOp.positionStart = i16 - updateOp3.itemCount;
                }
                int i17 = updateOp.itemCount;
                if (i17 >= updateOp3.positionStart) {
                    updateOp.itemCount = i17 - updateOp3.itemCount;
                }
            }
            int i18 = updateOp.positionStart;
            if (i18 >= updateOp2.positionStart) {
                updateOp.positionStart = i18 - updateOp2.itemCount;
            }
            i3 = updateOp.itemCount;
        }
        list.set(i, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i2, updateOp);
        } else {
            list.remove(i2);
        }
        if (updateOp3 == null) {
            return;
        }
        list.add(i, updateOp3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void swapMoveUpdate(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        AdapterHelper.UpdateOp obtainUpdateOp;
        int i3;
        int i4;
        int i5 = updateOp.itemCount;
        int i6 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i5 < i6) {
            updateOp2.positionStart = i6 - 1;
        } else {
            int i7 = updateOp2.itemCount;
            if (i5 < i6 + i7) {
                updateOp2.itemCount = i7 - 1;
                obtainUpdateOp = this.mCallback.obtainUpdateOp(4, updateOp.positionStart, 1, updateOp2.payload);
                i3 = updateOp.positionStart;
                i4 = updateOp2.positionStart;
                if (i3 > i4) {
                    updateOp2.positionStart = i4 + 1;
                } else {
                    int i8 = updateOp2.itemCount;
                    if (i3 < i4 + i8) {
                        int i9 = (i4 + i8) - i3;
                        updateOp3 = this.mCallback.obtainUpdateOp(4, i3 + 1, i9, updateOp2.payload);
                        updateOp2.itemCount -= i9;
                    }
                }
                list.set(i2, updateOp);
                if (updateOp2.itemCount <= 0) {
                    list.set(i, updateOp2);
                } else {
                    list.remove(i);
                    this.mCallback.recycleUpdateOp(updateOp2);
                }
                if (obtainUpdateOp != null) {
                    list.add(i, obtainUpdateOp);
                }
                if (updateOp3 != null) {
                    return;
                }
                list.add(i, updateOp3);
                return;
            }
        }
        obtainUpdateOp = null;
        i3 = updateOp.positionStart;
        i4 = updateOp2.positionStart;
        if (i3 > i4) {
        }
        list.set(i2, updateOp);
        if (updateOp2.itemCount <= 0) {
        }
        if (obtainUpdateOp != null) {
        }
        if (updateOp3 != null) {
        }
    }
}

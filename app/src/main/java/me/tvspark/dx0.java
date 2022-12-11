package me.tvspark;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.TypeCastException;
import okio.ByteString;

@ef0
/* loaded from: classes4.dex */
public final class dx0 extends AbstractList<ByteString> implements RandomAccess {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public final int[] Wwwwwwwwwwwwwwwwwwwwwww;
    public final ByteString[] Wwwwwwwwwwwwwwwwwwwwwwww;

    public /* synthetic */ dx0(ByteString[] byteStringArr, int[] iArr, gi0 gi0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = byteStringArr;
        this.Wwwwwwwwwwwwwwwwwwwwwww = iArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj != null ? obj instanceof ByteString : true) {
            return super.contains((ByteString) obj);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj != null ? obj instanceof ByteString : true) {
            return super.indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj != null ? obj instanceof ByteString : true) {
            return super.lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        if (obj != null ? obj instanceof ByteString : true) {
            return super.remove((ByteString) obj);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.length;
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gi0 gi0Var) {
        }

        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0 uw0Var) {
            return uw0Var.Wwwwwwwwwwwwwwwwwwwwwww / 4;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, uw0 uw0Var, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) {
            int i4;
            int i5;
            int i6;
            int i7;
            uw0 uw0Var2;
            int i8 = i;
            if (i2 < i3) {
                for (int i9 = i2; i9 < i3; i9++) {
                    if (!(list.get(i9).size() >= i8)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = list.get(i2);
                ByteString byteString2 = list.get(i3 - 1);
                if (i8 == byteString.size()) {
                    int i10 = i2 + 1;
                    i4 = i10;
                    i5 = list2.get(i2).intValue();
                    byteString = list.get(i10);
                } else {
                    i4 = i2;
                    i5 = -1;
                }
                if (byteString.getByte(i8) == byteString2.getByte(i8)) {
                    int min = Math.min(byteString.size(), byteString2.size());
                    int i11 = 0;
                    for (int i12 = i8; i12 < min && byteString.getByte(i12) == byteString2.getByte(i12); i12++) {
                        i11++;
                    }
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var) + j + 2 + i11 + 1;
                    uw0Var.mo4964writeInt(-i11);
                    uw0Var.mo4964writeInt(i5);
                    int i13 = i8 + i11;
                    while (i8 < i13) {
                        uw0Var.mo4964writeInt(byteString.getByte(i8) & 255);
                        i8++;
                    }
                    if (i4 + 1 == i3) {
                        if (!(i13 == list.get(i4).size())) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        uw0Var.mo4964writeInt(list2.get(i4).intValue());
                        return;
                    }
                    uw0 uw0Var3 = new uw0();
                    uw0Var.mo4964writeInt(((int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var3) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) * (-1));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uw0Var3, i13, list, i4, i3, list2);
                    uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((mx0) uw0Var3);
                    return;
                }
                int i14 = 1;
                for (int i15 = i4 + 1; i15 < i3; i15++) {
                    if (list.get(i15 - 1).getByte(i8) != list.get(i15).getByte(i8)) {
                        i14++;
                    }
                }
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var) + j + 2 + (i14 * 2);
                uw0Var.mo4964writeInt(i14);
                uw0Var.mo4964writeInt(i5);
                for (int i16 = i4; i16 < i3; i16++) {
                    byte b = list.get(i16).getByte(i8);
                    if (i16 == i4 || b != list.get(i16 - 1).getByte(i8)) {
                        uw0Var.mo4964writeInt(b & 255);
                    }
                }
                uw0 uw0Var4 = new uw0();
                while (i4 < i3) {
                    byte b2 = list.get(i4).getByte(i8);
                    int i17 = i4 + 1;
                    int i18 = i17;
                    while (true) {
                        if (i18 >= i3) {
                            i6 = i3;
                            break;
                        } else if (b2 != list.get(i18).getByte(i8)) {
                            i6 = i18;
                            break;
                        } else {
                            i18++;
                        }
                    }
                    if (i17 == i6 && i8 + 1 == list.get(i4).size()) {
                        uw0Var.mo4964writeInt(list2.get(i4).intValue());
                        i7 = i6;
                        uw0Var2 = uw0Var4;
                    } else {
                        uw0Var.mo4964writeInt(((int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var4) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) * (-1));
                        i7 = i6;
                        uw0Var2 = uw0Var4;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, uw0Var4, i8 + 1, list, i4, i6, list2);
                    }
                    uw0Var4 = uw0Var2;
                    i4 = i7;
                }
                uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((mx0) uw0Var4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        /* JADX WARN: Code restructure failed: missing block: B:79:0x0162, code lost:
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final dx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString... byteStringArr) {
            int i;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteStringArr, "byteStrings");
            int i2 = 0;
            if (byteStringArr.length == 0) {
                return new dx0(new ByteString[0], new int[]{0, -1}, null);
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteStringArr, "$this$toMutableList");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteStringArr, "$this$asCollection");
            ArrayList arrayList = new ArrayList(new tf0(byteStringArr, false));
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, "$this$sort");
            if (arrayList.size() > 1) {
                Collections.sort(arrayList);
            }
            ArrayList arrayList2 = new ArrayList(byteStringArr.length);
            for (ByteString byteString : byteStringArr) {
                arrayList2.add(-1);
            }
            Object[] array = arrayList2.toArray(new Integer[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Integer[] numArr = (Integer[]) array;
            Integer[] numArr2 = (Integer[]) Arrays.copyOf(numArr, numArr.length);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(numArr2, "elements");
            List<Integer> arrayList3 = numArr2.length == 0 ? new ArrayList<>() : new ArrayList<>(new tf0(numArr2, true));
            int length = byteStringArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                ByteString byteString2 = byteStringArr[i3];
                int i5 = i4 + 1;
                int size = arrayList.size();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, "$this$binarySearch");
                int size2 = arrayList.size();
                if (size < 0) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("fromIndex (", 0, ") is greater than toIndex (", size, ")."));
                }
                if (size <= size2) {
                    int i6 = size - 1;
                    int i7 = 0;
                    while (true) {
                        if (i7 > i6) {
                            i = -(i7 + 1);
                            break;
                        }
                        i = (i7 + i6) >>> 1;
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ByteString) arrayList.get(i), byteString2);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 0) {
                            i7 = i + 1;
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                            i6 = i - 1;
                        }
                    }
                    arrayList3.set(i, Integer.valueOf(i4));
                    i3++;
                    i4 = i5;
                } else {
                    throw new IndexOutOfBoundsException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("toIndex (", size, ") is greater than size (", size2, ")."));
                }
            }
            if (!(((ByteString) arrayList.get(0)).size() > 0)) {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            int i8 = 0;
            while (i8 < arrayList.size()) {
                ByteString byteString3 = (ByteString) arrayList.get(i8);
                int i9 = i8 + 1;
                int i10 = i9;
                while (i10 < arrayList.size()) {
                    ByteString byteString4 = (ByteString) arrayList.get(i10);
                    if (!byteString4.startsWith(byteString3)) {
                        break;
                    }
                    if (!(byteString4.size() != byteString3.size())) {
                        throw new IllegalArgumentException(("duplicate option: " + byteString4).toString());
                    } else if (arrayList3.get(i10).intValue() > arrayList3.get(i8).intValue()) {
                        arrayList.remove(i10);
                        arrayList3.remove(i10);
                    } else {
                        i10++;
                    }
                }
                i8 = i9;
            }
            uw0 uw0Var = new uw0();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L, uw0Var, 0, arrayList, 0, arrayList.size(), arrayList3);
            int[] iArr = new int[(int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var)];
            while (!uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                iArr[i2] = uw0Var.readInt();
                i2++;
            }
            return new dx0((ByteString[]) byteStringArr.clone(), iArr, null);
        }
    }
}

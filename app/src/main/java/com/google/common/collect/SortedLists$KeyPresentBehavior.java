package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public enum SortedLists$KeyPresentBehavior {
    ANY_PRESENT { // from class: com.google.common.collect.SortedLists$KeyPresentBehavior.1
        @Override // com.google.common.collect.SortedLists$KeyPresentBehavior
        public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
            return i;
        }
    },
    LAST_PRESENT { // from class: com.google.common.collect.SortedLists$KeyPresentBehavior.2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.SortedLists$KeyPresentBehavior
        public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
            int size = list.size() - 1;
            while (i < size) {
                int i2 = ((i + size) + 1) >>> 1;
                if (comparator.compare((E) list.get(i2), e) > 0) {
                    size = i2 - 1;
                } else {
                    i = i2;
                }
            }
            return i;
        }
    },
    FIRST_PRESENT { // from class: com.google.common.collect.SortedLists$KeyPresentBehavior.3
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.SortedLists$KeyPresentBehavior
        public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
            int i2 = 0;
            while (i2 < i) {
                int i3 = (i2 + i) >>> 1;
                if (comparator.compare((E) list.get(i3), e) < 0) {
                    i2 = i3 + 1;
                } else {
                    i = i3;
                }
            }
            return i2;
        }
    },
    FIRST_AFTER { // from class: com.google.common.collect.SortedLists$KeyPresentBehavior.4
        @Override // com.google.common.collect.SortedLists$KeyPresentBehavior
        public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
            return SortedLists$KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e, list, i) + 1;
        }
    },
    LAST_BEFORE { // from class: com.google.common.collect.SortedLists$KeyPresentBehavior.5
        @Override // com.google.common.collect.SortedLists$KeyPresentBehavior
        public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
            return SortedLists$KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e, list, i) - 1;
        }
    };

    public abstract <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i);
}

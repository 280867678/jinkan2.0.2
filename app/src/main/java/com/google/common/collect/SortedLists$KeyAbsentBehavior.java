package com.google.common.collect;

/* loaded from: classes3.dex */
public enum SortedLists$KeyAbsentBehavior {
    NEXT_LOWER { // from class: com.google.common.collect.SortedLists$KeyAbsentBehavior.1
        @Override // com.google.common.collect.SortedLists$KeyAbsentBehavior
        public int resultIndex(int i) {
            return i - 1;
        }
    },
    NEXT_HIGHER { // from class: com.google.common.collect.SortedLists$KeyAbsentBehavior.2
        @Override // com.google.common.collect.SortedLists$KeyAbsentBehavior
        public int resultIndex(int i) {
            return i;
        }
    },
    INVERTED_INSERTION_INDEX { // from class: com.google.common.collect.SortedLists$KeyAbsentBehavior.3
        @Override // com.google.common.collect.SortedLists$KeyAbsentBehavior
        public int resultIndex(int i) {
            return ~i;
        }
    };

    public abstract int resultIndex(int i);
}

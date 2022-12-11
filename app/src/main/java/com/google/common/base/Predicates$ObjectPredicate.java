package com.google.common.base;

import me.tvspark.AbstractC2573rt;

/* loaded from: classes3.dex */
public enum Predicates$ObjectPredicate implements AbstractC2573rt<Object> {
    ALWAYS_TRUE { // from class: com.google.common.base.Predicates$ObjectPredicate.1
        @Override // me.tvspark.AbstractC2573rt
        public boolean apply(Object obj) {
            return true;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Predicates.alwaysTrue()";
        }
    },
    ALWAYS_FALSE { // from class: com.google.common.base.Predicates$ObjectPredicate.2
        @Override // me.tvspark.AbstractC2573rt
        public boolean apply(Object obj) {
            return false;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Predicates.alwaysFalse()";
        }
    },
    IS_NULL { // from class: com.google.common.base.Predicates$ObjectPredicate.3
        @Override // me.tvspark.AbstractC2573rt
        public boolean apply(Object obj) {
            return obj == null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Predicates.isNull()";
        }
    },
    NOT_NULL { // from class: com.google.common.base.Predicates$ObjectPredicate.4
        @Override // me.tvspark.AbstractC2573rt
        public boolean apply(Object obj) {
            return obj != null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Predicates.notNull()";
        }
    };

    public <T> AbstractC2573rt<T> withNarrowedType() {
        return this;
    }
}

package org.apache.commons.lang3.mutable;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class MutableBoolean implements Mutable<Boolean>, Serializable, Comparable<MutableBoolean> {
    public static final long serialVersionUID = -4830728138360036487L;
    public boolean value;

    public MutableBoolean() {
    }

    public MutableBoolean(Boolean bool) {
        this.value = bool.booleanValue();
    }

    public MutableBoolean(boolean z) {
        this.value = z;
    }

    public boolean booleanValue() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableBoolean mutableBoolean) {
        boolean z = mutableBoolean.value;
        boolean z2 = this.value;
        if (z2 == z) {
            return 0;
        }
        return z2 ? 1 : -1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableBoolean) && this.value == ((MutableBoolean) obj).booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Boolean mo5179getValue() {
        return Boolean.valueOf(this.value);
    }

    public int hashCode() {
        return (this.value ? Boolean.TRUE : Boolean.FALSE).hashCode();
    }

    public boolean isFalse() {
        return !this.value;
    }

    public boolean isTrue() {
        return this.value;
    }

    public void setFalse() {
        this.value = false;
    }

    public void setTrue() {
        this.value = true;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Boolean bool) {
        this.value = bool.booleanValue();
    }

    public void setValue(boolean z) {
        this.value = z;
    }

    public Boolean toBoolean() {
        return Boolean.valueOf(booleanValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}

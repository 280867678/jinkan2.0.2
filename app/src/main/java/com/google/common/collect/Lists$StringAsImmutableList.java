package com.google.common.collect;

import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class Lists$StringAsImmutableList extends ImmutableList<Character> {
    public final String string;

    public Lists$StringAsImmutableList(String str) {
        this.string = str;
    }

    @Override // java.util.List
    /* renamed from: get */
    public Character mo4656get(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, size());
        return Character.valueOf(this.string.charAt(i));
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Character) {
            return this.string.indexOf(((Character) obj).charValue());
        }
        return -1;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(Object obj) {
        if (obj instanceof Character) {
            return this.string.lastIndexOf(((Character) obj).charValue());
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.string.length();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    /* renamed from: subList */
    public ImmutableList<Character> mo4657subList(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, size());
        String substring = this.string.substring(i, i2);
        if (substring != null) {
            return new Lists$StringAsImmutableList(substring);
        }
        throw null;
    }
}

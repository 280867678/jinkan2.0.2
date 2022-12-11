package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import me.tvspark.C2456ot;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class MapMaker {
    public Equivalence<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public MapMakerInternalMap.Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public MapMakerInternalMap.Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    /* loaded from: classes3.dex */
    public enum Dummy {
        VALUE
    }

    public <K, V> ConcurrentMap<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == -1) {
                i = 16;
            }
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 == -1) {
                i2 = 4;
            }
            return new ConcurrentHashMap(i, 0.75f, i2);
        }
        return MapMakerInternalMap.create(this);
    }

    public MapMakerInternalMap.Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return (MapMakerInternalMap.Strength) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap.Strength strength) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null, "Key strength was already set to %s", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (strength != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = strength;
            if (strength != MapMakerInternalMap.Strength.STRONG) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            return this;
        }
        throw null;
    }

    public MapMakerInternalMap.Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return (MapMakerInternalMap.Strength) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, MapMakerInternalMap.Strength.STRONG);
    }

    public String toString() {
        C2456ot Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("initialCapacity", i);
        }
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("concurrencyLevel", i2);
        }
        MapMakerInternalMap.Strength strength = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (strength != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("keyStrength", Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (strength2 != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("valueStrength", Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(strength2.toString()));
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("keyEquivalence");
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

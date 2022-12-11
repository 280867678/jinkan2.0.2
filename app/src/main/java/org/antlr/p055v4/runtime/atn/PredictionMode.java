package org.antlr.p055v4.runtime.atn;

import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.tvspark.e01;
import me.tvspark.g01;
import me.tvspark.my0;
import me.tvspark.ny0;
import me.tvspark.r40;
import me.tvspark.s01;
import me.tvspark.sy0;
import me.tvspark.v01;

/* renamed from: org.antlr.v4.runtime.atn.PredictionMode */
/* loaded from: classes4.dex */
public enum PredictionMode {
    SLL,
    LL,
    LL_EXACT_AMBIG_DETECTION;

    /* renamed from: org.antlr.v4.runtime.atn.PredictionMode$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends v01<my0, BitSet> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: org.antlr.v4.runtime.atn.PredictionMode$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends s01<my0> {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        @Override // me.tvspark.s01
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0 my0Var, my0 my0Var2) {
            my0 my0Var3 = my0Var;
            my0 my0Var4 = my0Var2;
            if (my0Var3 == my0Var4) {
                return true;
            }
            return my0Var3 != null && my0Var4 != null && my0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == my0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && my0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(my0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.s01
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0 my0Var) {
            my0 my0Var2 = my0Var;
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7, my0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), my0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), 2);
        }
    }

    public static boolean allConfigsInRuleStopStates(ny0 ny0Var) {
        Iterator<my0> it = ny0Var.iterator();
        while (it.hasNext()) {
            if (!(it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof e01)) {
                return false;
            }
        }
        return true;
    }

    public static boolean allSubsetsConflict(Collection<BitSet> collection) {
        return !hasNonConflictingAltSet(collection);
    }

    public static boolean allSubsetsEqual(Collection<BitSet> collection) {
        Iterator<BitSet> it = collection.iterator();
        BitSet next = it.next();
        while (it.hasNext()) {
            if (!it.next().equals(next)) {
                return false;
            }
        }
        return true;
    }

    public static BitSet getAlts(Collection<BitSet> collection) {
        BitSet bitSet = new BitSet();
        for (BitSet bitSet2 : collection) {
            bitSet.or(bitSet2);
        }
        return bitSet;
    }

    public static BitSet getAlts(ny0 ny0Var) {
        BitSet bitSet = new BitSet();
        Iterator<my0> it = ny0Var.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return bitSet;
    }

    public static Collection<BitSet> getConflictingAltSubsets(ny0 ny0Var) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Iterator<my0> it = ny0Var.iterator();
        while (it.hasNext()) {
            my0 next = it.next();
            BitSet bitSet = (BitSet) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(next);
            if (bitSet == null) {
                bitSet = new BitSet();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(next, bitSet);
            }
            bitSet.set(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.values();
    }

    public static int getSingleViableAlt(Collection<BitSet> collection) {
        BitSet bitSet = new BitSet();
        for (BitSet bitSet2 : collection) {
            bitSet.set(bitSet2.nextSetBit(0));
            if (bitSet.cardinality() > 1) {
                return 0;
            }
        }
        return bitSet.nextSetBit(0);
    }

    public static Map<sy0, BitSet> getStateToAltMap(ny0 ny0Var) {
        HashMap hashMap = new HashMap();
        Iterator<my0> it = ny0Var.iterator();
        while (it.hasNext()) {
            my0 next = it.next();
            BitSet bitSet = (BitSet) hashMap.get(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (bitSet == null) {
                bitSet = new BitSet();
                hashMap.put(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bitSet);
            }
            bitSet.set(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return hashMap;
    }

    public static int getUniqueAlt(Collection<BitSet> collection) {
        BitSet alts = getAlts(collection);
        if (alts.cardinality() == 1) {
            return alts.nextSetBit(0);
        }
        return 0;
    }

    public static boolean hasConfigInRuleStopState(ny0 ny0Var) {
        Iterator<my0> it = ny0Var.iterator();
        while (it.hasNext()) {
            if (it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof e01) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasConflictingAltSet(Collection<BitSet> collection) {
        for (BitSet bitSet : collection) {
            if (bitSet.cardinality() > 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasNonConflictingAltSet(Collection<BitSet> collection) {
        for (BitSet bitSet : collection) {
            if (bitSet.cardinality() == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSLLConflictTerminatingPrediction(PredictionMode predictionMode, ny0 ny0Var) {
        if (allConfigsInRuleStopStates(ny0Var)) {
            return true;
        }
        if (predictionMode == SLL && ny0Var.Wwwwwwwwwwwwwwwwwww) {
            ny0 ny0Var2 = new ny0(true);
            Iterator<my0> it = ny0Var.iterator();
            while (it.hasNext()) {
                my0 next = it.next();
                ny0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new my0(next, next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, g01.Wwwwwwwwwwwwwwwwwwwwwwww), null);
            }
            ny0Var = ny0Var2;
        }
        return hasConflictingAltSet(getConflictingAltSubsets(ny0Var)) && !hasStateAssociatedWithOneAlt(ny0Var);
    }

    public static boolean hasStateAssociatedWithOneAlt(ny0 ny0Var) {
        for (BitSet bitSet : getStateToAltMap(ny0Var).values()) {
            if (bitSet.cardinality() == 1) {
                return true;
            }
        }
        return false;
    }

    public static int resolvesToJustOneViableAlt(Collection<BitSet> collection) {
        return getSingleViableAlt(collection);
    }
}

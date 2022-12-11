package org.mozilla.javascript.optimizer;

import java.util.BitSet;
import java.util.HashMap;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.ast.Jump;

/* loaded from: classes5.dex */
public class Block {
    public static final boolean DEBUG = false;
    public static int debug_blockCount;
    public int itsBlockID;
    public int itsEndNodeIndex;
    public BitSet itsLiveOnEntrySet;
    public BitSet itsLiveOnExitSet;
    public BitSet itsNotDefSet;
    public Block[] itsPredecessors;
    public int itsStartNodeIndex;
    public Block[] itsSuccessors;
    public BitSet itsUseBeforeDefSet;

    /* loaded from: classes5.dex */
    public static class FatBlock {
        public ObjToIntMap predecessors;
        public Block realBlock;
        public ObjToIntMap successors;

        public FatBlock() {
            this.successors = new ObjToIntMap();
            this.predecessors = new ObjToIntMap();
        }

        public static Block[] reduceToArray(ObjToIntMap objToIntMap) {
            if (!objToIntMap.isEmpty()) {
                Block[] blockArr = new Block[objToIntMap.size()];
                int i = 0;
                ObjToIntMap.Iterator newIterator = objToIntMap.newIterator();
                newIterator.start();
                while (!newIterator.done()) {
                    blockArr[i] = ((FatBlock) newIterator.getKey()).realBlock;
                    newIterator.next();
                    i++;
                }
                return blockArr;
            }
            return null;
        }

        public void addPredecessor(FatBlock fatBlock) {
            this.predecessors.put(fatBlock, 0);
        }

        public void addSuccessor(FatBlock fatBlock) {
            this.successors.put(fatBlock, 0);
        }

        public Block[] getPredecessors() {
            return reduceToArray(this.predecessors);
        }

        public Block[] getSuccessors() {
            return reduceToArray(this.successors);
        }
    }

    public Block(int i, int i2) {
        this.itsStartNodeIndex = i;
        this.itsEndNodeIndex = i2;
    }

    public static boolean assignType(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        int i4 = i2 | iArr[i];
        iArr[i] = i4;
        return i3 != i4;
    }

    public static Block[] buildBlocks(Node[] nodeArr) {
        HashMap hashMap = new HashMap();
        ObjArray objArray = new ObjArray();
        int i = 0;
        for (int i2 = 0; i2 < nodeArr.length; i2++) {
            int type = nodeArr[i2].getType();
            if (type == 5 || type == 6 || type == 7) {
                FatBlock newFatBlock = newFatBlock(i, i2);
                if (nodeArr[i].getType() == 132) {
                    hashMap.put(nodeArr[i], newFatBlock);
                }
                objArray.add(newFatBlock);
                i = i2 + 1;
            } else if (type == 132 && i2 != i) {
                FatBlock newFatBlock2 = newFatBlock(i, i2 - 1);
                if (nodeArr[i].getType() == 132) {
                    hashMap.put(nodeArr[i], newFatBlock2);
                }
                objArray.add(newFatBlock2);
                i = i2;
            }
        }
        if (i != nodeArr.length) {
            FatBlock newFatBlock3 = newFatBlock(i, nodeArr.length - 1);
            if (nodeArr[i].getType() == 132) {
                hashMap.put(nodeArr[i], newFatBlock3);
            }
            objArray.add(newFatBlock3);
        }
        for (int i3 = 0; i3 < objArray.size(); i3++) {
            FatBlock fatBlock = (FatBlock) objArray.get(i3);
            Node node = nodeArr[fatBlock.realBlock.itsEndNodeIndex];
            int type2 = node.getType();
            if (type2 != 5 && i3 < objArray.size() - 1) {
                FatBlock fatBlock2 = (FatBlock) objArray.get(i3 + 1);
                fatBlock.addSuccessor(fatBlock2);
                fatBlock2.addPredecessor(fatBlock);
            }
            if (type2 == 7 || type2 == 6 || type2 == 5) {
                Node node2 = ((Jump) node).target;
                FatBlock fatBlock3 = (FatBlock) hashMap.get(node2);
                node2.putProp(6, fatBlock3.realBlock);
                fatBlock.addSuccessor(fatBlock3);
                fatBlock3.addPredecessor(fatBlock);
            }
        }
        Block[] blockArr = new Block[objArray.size()];
        for (int i4 = 0; i4 < objArray.size(); i4++) {
            FatBlock fatBlock4 = (FatBlock) objArray.get(i4);
            Block block = fatBlock4.realBlock;
            block.itsSuccessors = fatBlock4.getSuccessors();
            block.itsPredecessors = fatBlock4.getPredecessors();
            block.itsBlockID = i4;
            blockArr[i4] = block;
        }
        return blockArr;
    }

    private boolean doReachedUseDataFlow() {
        this.itsLiveOnExitSet.clear();
        if (this.itsSuccessors != null) {
            int i = 0;
            while (true) {
                Block[] blockArr = this.itsSuccessors;
                if (i >= blockArr.length) {
                    break;
                }
                this.itsLiveOnExitSet.or(blockArr[i].itsLiveOnEntrySet);
                i++;
            }
        }
        return updateEntrySet(this.itsLiveOnEntrySet, this.itsLiveOnExitSet, this.itsUseBeforeDefSet, this.itsNotDefSet);
    }

    private boolean doTypeFlow(OptFunctionNode optFunctionNode, Node[] nodeArr, int[] iArr) {
        boolean z = false;
        for (int i = this.itsStartNodeIndex; i <= this.itsEndNodeIndex; i++) {
            Node node = nodeArr[i];
            if (node != null) {
                z |= findDefPoints(optFunctionNode, node, iArr);
            }
        }
        return z;
    }

    public static boolean findDefPoints(OptFunctionNode optFunctionNode, Node node, int[] iArr) {
        Node firstChild = node.getFirstChild();
        boolean z = false;
        for (Node node2 = firstChild; node2 != null; node2 = node2.getNext()) {
            z |= findDefPoints(optFunctionNode, node2, iArr);
        }
        int type = node.getType();
        if (type == 56 || type == 157) {
            int findExpressionType = findExpressionType(optFunctionNode, firstChild.getNext(), iArr);
            int varIndex = optFunctionNode.getVarIndex(node);
            return (node.getType() != 56 || !optFunctionNode.fnode.getParamAndVarConst()[varIndex]) ? z | assignType(iArr, varIndex, findExpressionType) : z;
        } else if ((type != 107 && type != 108) || firstChild.getType() != 55) {
            return z;
        } else {
            int varIndex2 = optFunctionNode.getVarIndex(firstChild);
            return !optFunctionNode.fnode.getParamAndVarConst()[varIndex2] ? assignType(iArr, varIndex2, 1) | z : z;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static int findExpressionType(org.mozilla.javascript.optimizer.OptFunctionNode r3, org.mozilla.javascript.Node r4, int[] r5) {
        /*
            int r0 = r4.getType()
            r1 = 35
            if (r0 == r1) goto L76
            r1 = 37
            if (r0 == r1) goto L76
            r1 = 40
            r2 = 1
            if (r0 == r1) goto L75
            r1 = 90
            if (r0 == r1) goto L76
            r1 = 103(0x67, float:1.44E-43)
            if (r0 == r1) goto L5f
            r1 = 157(0x9d, float:2.2E-43)
            if (r0 == r1) goto L76
            r1 = 55
            if (r0 == r1) goto L58
            r1 = 56
            if (r0 == r1) goto L76
            switch(r0) {
                case 8: goto L76;
                case 9: goto L57;
                case 10: goto L57;
                case 11: goto L57;
                default: goto L28;
            }
        L28:
            switch(r0) {
                case 18: goto L57;
                case 19: goto L57;
                case 20: goto L57;
                case 21: goto L45;
                case 22: goto L57;
                case 23: goto L57;
                case 24: goto L57;
                case 25: goto L57;
                default: goto L2b;
            }
        L2b:
            switch(r0) {
                case 27: goto L57;
                case 28: goto L57;
                case 29: goto L57;
                default: goto L2e;
            }
        L2e:
            switch(r0) {
                case 105: goto L33;
                case 106: goto L33;
                case 107: goto L57;
                case 108: goto L57;
                default: goto L31;
            }
        L31:
            r3 = 3
            return r3
        L33:
            org.mozilla.javascript.Node r4 = r4.getFirstChild()
            int r0 = findExpressionType(r3, r4, r5)
            org.mozilla.javascript.Node r4 = r4.getNext()
            int r3 = findExpressionType(r3, r4, r5)
            r3 = r3 | r0
            return r3
        L45:
            org.mozilla.javascript.Node r4 = r4.getFirstChild()
            int r0 = findExpressionType(r3, r4, r5)
            org.mozilla.javascript.Node r4 = r4.getNext()
            int r3 = findExpressionType(r3, r4, r5)
            r3 = r3 | r0
            return r3
        L57:
            return r2
        L58:
            int r3 = r3.getVarIndex(r4)
            r3 = r5[r3]
            return r3
        L5f:
            org.mozilla.javascript.Node r4 = r4.getFirstChild()
            org.mozilla.javascript.Node r4 = r4.getNext()
            org.mozilla.javascript.Node r0 = r4.getNext()
            int r4 = findExpressionType(r3, r4, r5)
            int r3 = findExpressionType(r3, r0, r5)
            r3 = r3 | r4
            return r3
        L75:
            return r2
        L76:
            org.mozilla.javascript.Node r4 = r4.getLastChild()
            int r3 = findExpressionType(r3, r4, r5)     // Catch: java.lang.Throwable -> L7f
            return r3
        L7f:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.Block.findExpressionType(org.mozilla.javascript.optimizer.OptFunctionNode, org.mozilla.javascript.Node, int[]):int");
    }

    private void initLiveOnEntrySets(OptFunctionNode optFunctionNode, Node[] nodeArr) {
        int varCount = optFunctionNode.getVarCount();
        this.itsUseBeforeDefSet = new BitSet(varCount);
        this.itsNotDefSet = new BitSet(varCount);
        this.itsLiveOnEntrySet = new BitSet(varCount);
        this.itsLiveOnExitSet = new BitSet(varCount);
        for (int i = this.itsStartNodeIndex; i <= this.itsEndNodeIndex; i++) {
            lookForVariableAccess(optFunctionNode, nodeArr[i]);
        }
        this.itsNotDefSet.flip(0, varCount);
    }

    private void lookForVariableAccess(OptFunctionNode optFunctionNode, Node node) {
        int varIndex;
        BitSet bitSet;
        int type = node.getType();
        if (type != 55) {
            if (type != 56) {
                if (type == 107 || type == 108) {
                    Node firstChild = node.getFirstChild();
                    if (firstChild.getType() != 55) {
                        lookForVariableAccess(optFunctionNode, firstChild);
                        return;
                    }
                    varIndex = optFunctionNode.getVarIndex(firstChild);
                    if (!this.itsNotDefSet.get(varIndex)) {
                        this.itsUseBeforeDefSet.set(varIndex);
                    }
                    bitSet = this.itsNotDefSet;
                    bitSet.set(varIndex);
                } else if (type == 138) {
                    varIndex = optFunctionNode.fnode.getIndexForNameNode(node);
                    if (varIndex <= -1 || this.itsNotDefSet.get(varIndex)) {
                        return;
                    }
                } else if (type != 157) {
                    for (Node firstChild2 = node.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNext()) {
                        lookForVariableAccess(optFunctionNode, firstChild2);
                    }
                    return;
                }
            }
            lookForVariableAccess(optFunctionNode, node.getFirstChild().getNext());
            this.itsNotDefSet.set(optFunctionNode.getVarIndex(node));
            return;
        }
        varIndex = optFunctionNode.getVarIndex(node);
        if (this.itsNotDefSet.get(varIndex)) {
            return;
        }
        bitSet = this.itsUseBeforeDefSet;
        bitSet.set(varIndex);
    }

    private void markAnyTypeVariables(int[] iArr) {
        for (int i = 0; i != iArr.length; i++) {
            if (this.itsLiveOnEntrySet.get(i)) {
                assignType(iArr, i, 3);
            }
        }
    }

    public static FatBlock newFatBlock(int i, int i2) {
        FatBlock fatBlock = new FatBlock();
        fatBlock.realBlock = new Block(i, i2);
        return fatBlock;
    }

    private void printLiveOnEntrySet(OptFunctionNode optFunctionNode) {
    }

    public static void reachingDefDataFlow(OptFunctionNode optFunctionNode, Node[] nodeArr, Block[] blockArr, int[] iArr) {
        Block[] blockArr2;
        for (Block block : blockArr) {
            block.initLiveOnEntrySets(optFunctionNode, nodeArr);
        }
        boolean[] zArr = new boolean[blockArr.length];
        boolean[] zArr2 = new boolean[blockArr.length];
        int length = blockArr.length - 1;
        zArr[length] = true;
        while (true) {
            boolean z = false;
            while (true) {
                if (zArr[length] || !zArr2[length]) {
                    zArr2[length] = true;
                    zArr[length] = false;
                    if (blockArr[length].doReachedUseDataFlow() && (blockArr2 = blockArr[length].itsPredecessors) != null) {
                        for (Block block2 : blockArr2) {
                            int i = block2.itsBlockID;
                            zArr[i] = true;
                            z |= i > length;
                        }
                    }
                }
                if (length == 0) {
                    break;
                }
                length--;
            }
            if (!z) {
                blockArr[0].markAnyTypeVariables(iArr);
                return;
            }
            length = blockArr.length - 1;
        }
    }

    public static void runFlowAnalyzes(OptFunctionNode optFunctionNode, Node[] nodeArr) {
        int paramCount = optFunctionNode.fnode.getParamCount();
        int paramAndVarCount = optFunctionNode.fnode.getParamAndVarCount();
        int[] iArr = new int[paramAndVarCount];
        for (int i = 0; i != paramCount; i++) {
            iArr[i] = 3;
        }
        for (int i2 = paramCount; i2 != paramAndVarCount; i2++) {
            iArr[i2] = 0;
        }
        Block[] buildBlocks = buildBlocks(nodeArr);
        reachingDefDataFlow(optFunctionNode, nodeArr, buildBlocks, iArr);
        typeFlow(optFunctionNode, nodeArr, buildBlocks, iArr);
        while (paramCount != paramAndVarCount) {
            if (iArr[paramCount] == 1) {
                optFunctionNode.setIsNumberVar(paramCount);
            }
            paramCount++;
        }
    }

    public static String toString(Block[] blockArr, Node[] nodeArr) {
        return null;
    }

    public static void typeFlow(OptFunctionNode optFunctionNode, Node[] nodeArr, Block[] blockArr, int[] iArr) {
        boolean z;
        Block[] blockArr2;
        boolean[] zArr = new boolean[blockArr.length];
        boolean[] zArr2 = new boolean[blockArr.length];
        zArr[0] = true;
        do {
            int i = 0;
            z = false;
            while (true) {
                if (zArr[i] || !zArr2[i]) {
                    zArr2[i] = true;
                    zArr[i] = false;
                    if (blockArr[i].doTypeFlow(optFunctionNode, nodeArr, iArr) && (blockArr2 = blockArr[i].itsSuccessors) != null) {
                        for (Block block : blockArr2) {
                            int i2 = block.itsBlockID;
                            zArr[i2] = true;
                            z |= i2 < i;
                        }
                    }
                }
                if (i == blockArr.length - 1) {
                    break;
                }
                i++;
            }
        } while (z);
    }

    public static boolean updateEntrySet(BitSet bitSet, BitSet bitSet2, BitSet bitSet3, BitSet bitSet4) {
        int cardinality = bitSet.cardinality();
        bitSet.or(bitSet2);
        bitSet.and(bitSet4);
        bitSet.or(bitSet3);
        return bitSet.cardinality() != cardinality;
    }
}

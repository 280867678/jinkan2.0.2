package androidx.renderscript;

import androidx.renderscript.Script;
import androidx.renderscript.ScriptGroupThunker;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ScriptGroup extends BaseObj {
    public C0528IO[] mInputs;
    public C0528IO[] mOutputs;

    /* loaded from: classes3.dex */
    public static final class Builder {
        public int mKernelCount;
        public RenderScript mRS;

        /* renamed from: mT */
        public ScriptGroupThunker.Builder f130mT;
        public ArrayList<Node> mNodes = new ArrayList<>();
        public ArrayList<ConnectLine> mLines = new ArrayList<>();

        public Builder(RenderScript renderScript) {
            if (RenderScript.isNative) {
                this.f130mT = new ScriptGroupThunker.Builder(renderScript);
            }
            this.mRS = renderScript;
        }

        private Node findNode(Script.KernelID kernelID) {
            for (int i = 0; i < this.mNodes.size(); i++) {
                Node node = this.mNodes.get(i);
                for (int i2 = 0; i2 < node.mKernels.size(); i2++) {
                    if (kernelID == node.mKernels.get(i2)) {
                        return node;
                    }
                }
            }
            return null;
        }

        private Node findNode(Script script) {
            for (int i = 0; i < this.mNodes.size(); i++) {
                if (script == this.mNodes.get(i).mScript) {
                    return this.mNodes.get(i);
                }
            }
            return null;
        }

        private void mergeDAGs(int i, int i2) {
            for (int i3 = 0; i3 < this.mNodes.size(); i3++) {
                if (this.mNodes.get(i3).dagNumber == i2) {
                    this.mNodes.get(i3).dagNumber = i;
                }
            }
        }

        private void validateCycle(Node node, Node node2) {
            for (int i = 0; i < node.mOutputs.size(); i++) {
                ConnectLine connectLine = node.mOutputs.get(i);
                Script.KernelID kernelID = connectLine.mToK;
                if (kernelID != null) {
                    Node findNode = findNode(kernelID.mScript);
                    if (findNode.equals(node2)) {
                        throw new RSInvalidStateException("Loops in group not allowed.");
                    }
                    validateCycle(findNode, node2);
                }
                Script.FieldID fieldID = connectLine.mToF;
                if (fieldID != null) {
                    Node findNode2 = findNode(fieldID.mScript);
                    if (findNode2.equals(node2)) {
                        throw new RSInvalidStateException("Loops in group not allowed.");
                    }
                    validateCycle(findNode2, node2);
                }
            }
        }

        private void validateDAG() {
            for (int i = 0; i < this.mNodes.size(); i++) {
                Node node = this.mNodes.get(i);
                if (node.mInputs.size() == 0) {
                    if (node.mOutputs.size() == 0 && this.mNodes.size() > 1) {
                        throw new RSInvalidStateException("Groups cannot contain unconnected scripts");
                    }
                    validateDAGRecurse(node, i + 1);
                }
            }
            int i2 = this.mNodes.get(0).dagNumber;
            for (int i3 = 0; i3 < this.mNodes.size(); i3++) {
                if (this.mNodes.get(i3).dagNumber != i2) {
                    throw new RSInvalidStateException("Multiple DAGs in group not allowed.");
                }
            }
        }

        private void validateDAGRecurse(Node node, int i) {
            int i2 = node.dagNumber;
            if (i2 != 0 && i2 != i) {
                mergeDAGs(i2, i);
                return;
            }
            node.dagNumber = i;
            for (int i3 = 0; i3 < node.mOutputs.size(); i3++) {
                ConnectLine connectLine = node.mOutputs.get(i3);
                Script.KernelID kernelID = connectLine.mToK;
                if (kernelID != null) {
                    validateDAGRecurse(findNode(kernelID.mScript), i);
                }
                Script.FieldID fieldID = connectLine.mToF;
                if (fieldID != null) {
                    validateDAGRecurse(findNode(fieldID.mScript), i);
                }
            }
        }

        public Builder addConnection(Type type, Script.KernelID kernelID, Script.FieldID fieldID) {
            ScriptGroupThunker.Builder builder = this.f130mT;
            if (builder != null) {
                builder.addConnection(type, kernelID, fieldID);
                return this;
            }
            Node findNode = findNode(kernelID);
            if (findNode == null) {
                throw new RSInvalidStateException("From script not found.");
            }
            Node findNode2 = findNode(fieldID.mScript);
            if (findNode2 == null) {
                throw new RSInvalidStateException("To script not found.");
            }
            ConnectLine connectLine = new ConnectLine(type, kernelID, fieldID);
            this.mLines.add(new ConnectLine(type, kernelID, fieldID));
            findNode.mOutputs.add(connectLine);
            findNode2.mInputs.add(connectLine);
            validateCycle(findNode, findNode);
            return this;
        }

        public Builder addConnection(Type type, Script.KernelID kernelID, Script.KernelID kernelID2) {
            ScriptGroupThunker.Builder builder = this.f130mT;
            if (builder != null) {
                builder.addConnection(type, kernelID, kernelID2);
                return this;
            }
            Node findNode = findNode(kernelID);
            if (findNode == null) {
                throw new RSInvalidStateException("From script not found.");
            }
            Node findNode2 = findNode(kernelID2);
            if (findNode2 == null) {
                throw new RSInvalidStateException("To script not found.");
            }
            ConnectLine connectLine = new ConnectLine(type, kernelID, kernelID2);
            this.mLines.add(new ConnectLine(type, kernelID, kernelID2));
            findNode.mOutputs.add(connectLine);
            findNode2.mInputs.add(connectLine);
            validateCycle(findNode, findNode);
            return this;
        }

        public Builder addKernel(Script.KernelID kernelID) {
            ScriptGroupThunker.Builder builder = this.f130mT;
            if (builder != null) {
                builder.addKernel(kernelID);
                return this;
            } else if (this.mLines.size() != 0) {
                throw new RSInvalidStateException("Kernels may not be added once connections exist.");
            } else {
                if (findNode(kernelID) != null) {
                    return this;
                }
                this.mKernelCount++;
                Node findNode = findNode(kernelID.mScript);
                if (findNode == null) {
                    findNode = new Node(kernelID.mScript);
                    this.mNodes.add(findNode);
                }
                findNode.mKernels.add(kernelID);
                return this;
            }
        }

        public ScriptGroup create() {
            ScriptGroupThunker.Builder builder = this.f130mT;
            if (builder != null) {
                return builder.create();
            }
            if (this.mNodes.size() == 0) {
                throw new RSInvalidStateException("Empty script groups are not allowed");
            }
            for (int i = 0; i < this.mNodes.size(); i++) {
                this.mNodes.get(i).dagNumber = 0;
            }
            validateDAG();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int[] iArr = new int[this.mKernelCount];
            int i2 = 0;
            for (int i3 = 0; i3 < this.mNodes.size(); i3++) {
                Node node = this.mNodes.get(i3);
                int i4 = 0;
                while (i4 < node.mKernels.size()) {
                    Script.KernelID kernelID = node.mKernels.get(i4);
                    int i5 = i2 + 1;
                    iArr[i2] = kernelID.getID(this.mRS);
                    boolean z = false;
                    for (int i6 = 0; i6 < node.mInputs.size(); i6++) {
                        if (node.mInputs.get(i6).mToK == kernelID) {
                            z = true;
                        }
                    }
                    boolean z2 = false;
                    for (int i7 = 0; i7 < node.mOutputs.size(); i7++) {
                        if (node.mOutputs.get(i7).mFrom == kernelID) {
                            z2 = true;
                        }
                    }
                    if (!z) {
                        arrayList.add(new C0528IO(kernelID));
                    }
                    if (!z2) {
                        arrayList2.add(new C0528IO(kernelID));
                    }
                    i4++;
                    i2 = i5;
                }
            }
            if (i2 != this.mKernelCount) {
                throw new RSRuntimeException("Count mismatch, should not happen.");
            }
            int[] iArr2 = new int[this.mLines.size()];
            int[] iArr3 = new int[this.mLines.size()];
            int[] iArr4 = new int[this.mLines.size()];
            int[] iArr5 = new int[this.mLines.size()];
            for (int i8 = 0; i8 < this.mLines.size(); i8++) {
                ConnectLine connectLine = this.mLines.get(i8);
                iArr2[i8] = connectLine.mFrom.getID(this.mRS);
                Script.KernelID kernelID2 = connectLine.mToK;
                if (kernelID2 != null) {
                    iArr3[i8] = kernelID2.getID(this.mRS);
                }
                Script.FieldID fieldID = connectLine.mToF;
                if (fieldID != null) {
                    iArr4[i8] = fieldID.getID(this.mRS);
                }
                iArr5[i8] = connectLine.mAllocationType.getID(this.mRS);
            }
            int nScriptGroupCreate = this.mRS.nScriptGroupCreate(iArr, iArr2, iArr3, iArr4, iArr5);
            if (nScriptGroupCreate == 0) {
                throw new RSRuntimeException("Object creation error, should not happen.");
            }
            ScriptGroup scriptGroup = new ScriptGroup(nScriptGroupCreate, this.mRS);
            scriptGroup.mOutputs = new C0528IO[arrayList2.size()];
            for (int i9 = 0; i9 < arrayList2.size(); i9++) {
                scriptGroup.mOutputs[i9] = (C0528IO) arrayList2.get(i9);
            }
            scriptGroup.mInputs = new C0528IO[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                scriptGroup.mInputs[i10] = (C0528IO) arrayList.get(i10);
            }
            return scriptGroup;
        }
    }

    /* loaded from: classes3.dex */
    public static class ConnectLine {
        public Type mAllocationType;
        public Script.KernelID mFrom;
        public Script.FieldID mToF;
        public Script.KernelID mToK;

        public ConnectLine(Type type, Script.KernelID kernelID, Script.FieldID fieldID) {
            this.mFrom = kernelID;
            this.mToF = fieldID;
            this.mAllocationType = type;
        }

        public ConnectLine(Type type, Script.KernelID kernelID, Script.KernelID kernelID2) {
            this.mFrom = kernelID;
            this.mToK = kernelID2;
            this.mAllocationType = type;
        }
    }

    /* renamed from: androidx.renderscript.ScriptGroup$IO */
    /* loaded from: classes3.dex */
    public static class C0528IO {
        public Allocation mAllocation;
        public Script.KernelID mKID;

        public C0528IO(Script.KernelID kernelID) {
            this.mKID = kernelID;
        }
    }

    /* loaded from: classes3.dex */
    public static class Node {
        public int dagNumber;
        public Node mNext;
        public Script mScript;
        public ArrayList<Script.KernelID> mKernels = new ArrayList<>();
        public ArrayList<ConnectLine> mInputs = new ArrayList<>();
        public ArrayList<ConnectLine> mOutputs = new ArrayList<>();

        public Node(Script script) {
            this.mScript = script;
        }
    }

    public ScriptGroup(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public void execute() {
        RenderScript renderScript = this.mRS;
        renderScript.nScriptGroupExecute(getID(renderScript));
    }

    public void setInput(Script.KernelID kernelID, Allocation allocation) {
        int i = 0;
        while (true) {
            C0528IO[] c0528ioArr = this.mInputs;
            if (i < c0528ioArr.length) {
                if (c0528ioArr[i].mKID == kernelID) {
                    c0528ioArr[i].mAllocation = allocation;
                    RenderScript renderScript = this.mRS;
                    renderScript.nScriptGroupSetInput(getID(renderScript), kernelID.getID(this.mRS), this.mRS.safeID(allocation));
                    return;
                }
                i++;
            } else {
                throw new RSIllegalArgumentException("Script not found");
            }
        }
    }

    public void setOutput(Script.KernelID kernelID, Allocation allocation) {
        int i = 0;
        while (true) {
            C0528IO[] c0528ioArr = this.mOutputs;
            if (i < c0528ioArr.length) {
                if (c0528ioArr[i].mKID == kernelID) {
                    c0528ioArr[i].mAllocation = allocation;
                    RenderScript renderScript = this.mRS;
                    renderScript.nScriptGroupSetOutput(getID(renderScript), kernelID.getID(this.mRS), this.mRS.safeID(allocation));
                    return;
                }
                i++;
            } else {
                throw new RSIllegalArgumentException("Script not found");
            }
        }
    }
}

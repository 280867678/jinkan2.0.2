package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
public class InputStack extends Stack<InputNode> {
    public InputStack() {
        super(6);
    }

    public boolean isRelevant(InputNode inputNode) {
        return contains(inputNode) || isEmpty();
    }
}

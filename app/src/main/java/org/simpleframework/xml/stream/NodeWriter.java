package org.simpleframework.xml.stream;

import java.io.Writer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes5.dex */
public class NodeWriter {
    public final Set active;
    public final OutputStack stack;
    public final boolean verbose;
    public final Formatter writer;

    public NodeWriter(Writer writer) {
        this(writer, new Format());
    }

    public NodeWriter(Writer writer, Format format) {
        this(writer, format, false);
    }

    public NodeWriter(Writer writer, Format format, boolean z) {
        this.writer = new Formatter(writer, format);
        this.active = new HashSet();
        this.stack = new OutputStack(this.active);
        this.verbose = z;
    }

    private void writeAttributes(OutputNode outputNode) throws Exception {
        NodeMap<OutputNode> mo5310getAttributes = outputNode.mo5310getAttributes();
        for (String str : mo5310getAttributes) {
            OutputNode mo5312get = mo5310getAttributes.mo5312get(str);
            this.writer.writeAttribute(str, mo5312get.getValue(), mo5312get.getPrefix(this.verbose));
        }
        this.active.remove(outputNode);
    }

    private void writeComment(OutputNode outputNode) throws Exception {
        String comment = outputNode.getComment();
        if (comment != null) {
            this.writer.writeComment(comment);
        }
    }

    private void writeEnd(OutputNode outputNode) throws Exception {
        String name = outputNode.getName();
        String prefix = outputNode.getPrefix(this.verbose);
        if (outputNode.getValue() != null) {
            writeValue(outputNode);
        }
        if (name != null) {
            this.writer.writeEnd(name, prefix);
            this.writer.flush();
        }
    }

    private void writeName(OutputNode outputNode) throws Exception {
        String prefix = outputNode.getPrefix(this.verbose);
        String name = outputNode.getName();
        if (name != null) {
            this.writer.writeStart(name, prefix);
        }
    }

    private void writeNamespaces(OutputNode outputNode) throws Exception {
        NamespaceMap namespaces = outputNode.getNamespaces();
        for (String str : namespaces) {
            this.writer.writeNamespace(str, namespaces.getPrefix(str));
        }
    }

    private OutputNode writeStart(OutputNode outputNode, String str) throws Exception {
        OutputElement outputElement = new OutputElement(outputNode, this, str);
        if (str != null) {
            return this.stack.push(outputElement);
        }
        throw new NodeException("Can not have a null name");
    }

    private void writeStart(OutputNode outputNode) throws Exception {
        writeComment(outputNode);
        writeName(outputNode);
        writeAttributes(outputNode);
        writeNamespaces(outputNode);
    }

    private void writeValue(OutputNode outputNode) throws Exception {
        Mode mode = outputNode.getMode();
        String value = outputNode.getValue();
        if (value != null) {
            Iterator<OutputNode> it = this.stack.iterator();
            while (it.hasNext()) {
                OutputNode next = it.next();
                if (mode != Mode.INHERIT) {
                    break;
                }
                mode = next.getMode();
            }
            this.writer.writeText(value, mode);
        }
        outputNode.setValue(null);
    }

    public void commit(OutputNode outputNode) throws Exception {
        if (this.stack.contains(outputNode)) {
            OutputNode pVar = this.stack.top();
            if (!isCommitted(pVar)) {
                writeStart(pVar);
            }
            while (this.stack.top() != outputNode) {
                writeEnd(this.stack.pop());
            }
            writeEnd(outputNode);
            this.stack.pop();
        }
    }

    public boolean isCommitted(OutputNode outputNode) {
        return !this.active.contains(outputNode);
    }

    public boolean isRoot(OutputNode outputNode) {
        return this.stack.bottom() == outputNode;
    }

    public void remove(OutputNode outputNode) throws Exception {
        if (this.stack.top() == outputNode) {
            this.stack.pop();
            return;
        }
        throw new NodeException("Cannot remove node");
    }

    public OutputNode writeElement(OutputNode outputNode, String str) throws Exception {
        if (this.stack.isEmpty()) {
            return writeStart(outputNode, str);
        }
        if (!this.stack.contains(outputNode)) {
            return null;
        }
        OutputNode pVar = this.stack.top();
        if (!isCommitted(pVar)) {
            writeStart(pVar);
        }
        while (this.stack.top() != outputNode) {
            writeEnd(this.stack.pop());
        }
        if (!this.stack.isEmpty()) {
            writeValue(outputNode);
        }
        return writeStart(outputNode, str);
    }

    public OutputNode writeRoot() throws Exception {
        OutputDocument outputDocument = new OutputDocument(this, this.stack);
        if (this.stack.isEmpty()) {
            this.writer.writeProlog();
        }
        return outputDocument;
    }
}

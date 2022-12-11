package org.mozilla.javascript.tools.shell;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Segment;

/* loaded from: classes5.dex */
public class ConsoleTextArea extends JTextArea implements KeyListener, DocumentListener {
    public static final long serialVersionUID = 8557083244830872961L;

    /* renamed from: in */
    public PipedInputStream f4746in;
    public PrintWriter inPipe;
    public int historyIndex = -1;
    public int outputMark = 0;
    public List<String> history = new ArrayList();
    public ConsoleWriter console1 = new ConsoleWriter(this);
    public ConsoleWriter console2 = new ConsoleWriter(this);
    public PrintStream out = new PrintStream((OutputStream) this.console1, true);
    public PrintStream err = new PrintStream((OutputStream) this.console2, true);

    public ConsoleTextArea(String[] strArr) {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        this.inPipe = new PrintWriter(pipedOutputStream);
        PipedInputStream pipedInputStream = new PipedInputStream();
        this.f4746in = pipedInputStream;
        try {
            pipedOutputStream.connect(pipedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        getDocument().addDocumentListener(this);
        addKeyListener(this);
        setLineWrap(true);
        setFont(new Font("Monospaced", 0, 12));
    }

    public synchronized void changedUpdate(DocumentEvent documentEvent) {
    }

    public void eval(String str) {
        this.inPipe.write(str);
        this.inPipe.write("\n");
        this.inPipe.flush();
        this.console1.flush();
    }

    public PrintStream getErr() {
        return this.err;
    }

    public InputStream getIn() {
        return this.f4746in;
    }

    public PrintStream getOut() {
        return this.out;
    }

    public synchronized void insertUpdate(DocumentEvent documentEvent) {
        int length = documentEvent.getLength();
        if (this.outputMark > documentEvent.getOffset()) {
            this.outputMark += length;
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        int i;
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 8 || keyCode == 37) {
            if (this.outputMark != getCaretPosition()) {
                return;
            }
        } else if (keyCode == 36) {
            int caretPosition = getCaretPosition();
            int i2 = this.outputMark;
            if (caretPosition != i2) {
                if (caretPosition <= i2 || keyEvent.isControlDown()) {
                    return;
                }
                if (keyEvent.isShiftDown()) {
                    moveCaretPosition(this.outputMark);
                } else {
                    setCaretPosition(this.outputMark);
                }
            }
        } else if (keyCode == 10) {
            returnPressed();
        } else {
            if (keyCode == 38) {
                int i3 = this.historyIndex - 1;
                this.historyIndex = i3;
                if (i3 >= 0) {
                    if (i3 >= this.history.size()) {
                        this.historyIndex = this.history.size() - 1;
                    }
                    i3 = this.historyIndex;
                    if (i3 >= 0) {
                        String str = this.history.get(i3);
                        replaceRange(str, this.outputMark, getDocument().getLength());
                        i = str.length() + this.outputMark;
                    }
                }
                this.historyIndex = i3 + 1;
            } else if (keyCode != 40) {
                return;
            } else {
                i = this.outputMark;
                if (this.history.size() > 0) {
                    int i4 = this.historyIndex + 1;
                    this.historyIndex = i4;
                    if (i4 < 0) {
                        this.historyIndex = 0;
                    }
                    int length = getDocument().getLength();
                    if (this.historyIndex < this.history.size()) {
                        String str2 = this.history.get(this.historyIndex);
                        replaceRange(str2, this.outputMark, length);
                        i = str2.length() + this.outputMark;
                    } else {
                        this.historyIndex = this.history.size();
                        replaceRange("", this.outputMark, length);
                    }
                }
            }
            select(i, i);
        }
        keyEvent.consume();
    }

    public synchronized void keyReleased(KeyEvent keyEvent) {
    }

    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == '\b') {
            if (this.outputMark != getCaretPosition()) {
                return;
            }
            keyEvent.consume();
            return;
        }
        int caretPosition = getCaretPosition();
        int i = this.outputMark;
        if (caretPosition >= i) {
            return;
        }
        setCaretPosition(i);
    }

    public synchronized void postUpdateUI() {
        requestFocus();
        setCaret(getCaret());
        select(this.outputMark, this.outputMark);
    }

    public synchronized void removeUpdate(DocumentEvent documentEvent) {
        int length = documentEvent.getLength();
        int offset = documentEvent.getOffset();
        if (this.outputMark > offset) {
            if (this.outputMark >= offset + length) {
                this.outputMark -= length;
            } else {
                this.outputMark = offset;
            }
        }
    }

    public synchronized void returnPressed() {
        Document document = getDocument();
        int length = document.getLength();
        Segment segment = new Segment();
        try {
            document.getText(this.outputMark, length - this.outputMark, segment);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        if (segment.count > 0) {
            this.history.add(segment.toString());
        }
        this.historyIndex = this.history.size();
        this.inPipe.write(segment.array, segment.offset, segment.count);
        append("\n");
        this.outputMark = document.getLength();
        this.inPipe.write("\n");
        this.inPipe.flush();
        this.console1.flush();
    }

    public void select(int i, int i2) {
        requestFocus();
        super.select(i, i2);
    }

    public synchronized void write(String str) {
        insert(str, this.outputMark);
        int length = this.outputMark + str.length();
        this.outputMark = length;
        select(length, length);
    }
}

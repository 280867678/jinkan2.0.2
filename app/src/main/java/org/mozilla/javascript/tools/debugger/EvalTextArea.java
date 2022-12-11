package org.mozilla.javascript.tools.debugger;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Segment;

/* loaded from: classes5.dex */
public class EvalTextArea extends JTextArea implements KeyListener, DocumentListener {
    public static final long serialVersionUID = -3918033649601064194L;
    public SwingGui debugGui;
    public int outputMark;
    public int historyIndex = -1;
    public List<String> history = Collections.synchronizedList(new ArrayList());

    public EvalTextArea(SwingGui swingGui) {
        this.debugGui = swingGui;
        Document document = getDocument();
        document.addDocumentListener(this);
        addKeyListener(this);
        setLineWrap(true);
        setFont(new Font("Monospaced", 0, 12));
        append("% ");
        this.outputMark = document.getLength();
    }

    private synchronized void returnPressed() {
        Document document = getDocument();
        int length = document.getLength();
        Segment segment = new Segment();
        try {
            document.getText(this.outputMark, length - this.outputMark, segment);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        String segment2 = segment.toString();
        if (this.debugGui.dim.stringIsCompilableUnit(segment2)) {
            if (segment2.trim().length() > 0) {
                this.history.add(segment2);
                this.historyIndex = this.history.size();
            }
            append("\n");
            String eval = this.debugGui.dim.eval(segment2);
            if (eval.length() > 0) {
                append(eval);
                append("\n");
            }
            append("% ");
            this.outputMark = document.getLength();
        } else {
            append("\n");
        }
    }

    public synchronized void changedUpdate(DocumentEvent documentEvent) {
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

    public void select(int i, int i2) {
        super.select(i, i2);
    }

    public synchronized void write(String str) {
        insert(str, this.outputMark);
        int length = this.outputMark + str.length();
        this.outputMark = length;
        select(length, length);
    }
}

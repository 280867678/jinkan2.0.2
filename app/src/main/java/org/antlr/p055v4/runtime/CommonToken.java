package org.antlr.p055v4.runtime;

import java.io.Serializable;
import me.tvspark.ey0;
import me.tvspark.gy0;
import me.tvspark.jy0;
import me.tvspark.ky0;
import me.tvspark.outline;
import me.tvspark.sx0;
import me.tvspark.z01;
import org.antlr.p055v4.runtime.misc.Pair;
import org.apache.commons.lang3.StringUtils;

/* renamed from: org.antlr.v4.runtime.CommonToken */
/* loaded from: classes4.dex */
public class CommonToken implements ky0, Serializable {
    public static final Pair<gy0, sx0> EMPTY_SOURCE = new Pair<>(null, null);
    public int channel;
    public int charPositionInLine;
    public int index;
    public int line;
    public Pair<gy0, sx0> source;
    public int start;
    public int stop;
    public String text;
    public int type;

    public CommonToken(int i) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.type = i;
        this.source = EMPTY_SOURCE;
    }

    public CommonToken(int i, String str) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.type = i;
        this.channel = 0;
        this.text = str;
        this.source = EMPTY_SOURCE;
    }

    public CommonToken(ey0 ey0Var) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.type = ey0Var.getType();
        this.line = ey0Var.getLine();
        this.index = ey0Var.getTokenIndex();
        this.charPositionInLine = ey0Var.getCharPositionInLine();
        this.channel = ey0Var.getChannel();
        this.start = ey0Var.getStartIndex();
        this.stop = ey0Var.getStopIndex();
        if (!(ey0Var instanceof CommonToken)) {
            this.text = ey0Var.getText();
            this.source = new Pair<>(ey0Var.getTokenSource(), ey0Var.getInputStream());
            return;
        }
        CommonToken commonToken = (CommonToken) ey0Var;
        this.text = commonToken.text;
        this.source = commonToken.source;
    }

    public CommonToken(Pair<gy0, sx0> pair, int i, int i2, int i3, int i4) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.source = pair;
        this.type = i;
        this.channel = i2;
        this.start = i3;
        this.stop = i4;
        gy0 gy0Var = pair.f4543a;
        if (gy0Var != null) {
            this.line = gy0Var.getLine();
            this.charPositionInLine = pair.f4543a.getCharPositionInLine();
        }
    }

    @Override // me.tvspark.ey0
    public int getChannel() {
        return this.channel;
    }

    @Override // me.tvspark.ey0
    public int getCharPositionInLine() {
        return this.charPositionInLine;
    }

    @Override // me.tvspark.ey0
    public sx0 getInputStream() {
        return this.source.f4544b;
    }

    @Override // me.tvspark.ey0
    public int getLine() {
        return this.line;
    }

    @Override // me.tvspark.ey0
    public int getStartIndex() {
        return this.start;
    }

    @Override // me.tvspark.ey0
    public int getStopIndex() {
        return this.stop;
    }

    @Override // me.tvspark.ey0
    public String getText() {
        int i;
        String str = this.text;
        if (str != null) {
            return str;
        }
        sx0 inputStream = getInputStream();
        if (inputStream == null) {
            return null;
        }
        int size = inputStream.size();
        int i2 = this.start;
        return (i2 >= size || (i = this.stop) >= size) ? "<EOF>" : inputStream.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i));
    }

    @Override // me.tvspark.ey0
    public int getTokenIndex() {
        return this.index;
    }

    @Override // me.tvspark.ey0
    public gy0 getTokenSource() {
        return this.source.f4543a;
    }

    @Override // me.tvspark.ey0
    public int getType() {
        return this.type;
    }

    public void setChannel(int i) {
        this.channel = i;
    }

    public void setCharPositionInLine(int i) {
        this.charPositionInLine = i;
    }

    public void setLine(int i) {
        this.line = i;
    }

    public void setStartIndex(int i) {
        this.start = i;
    }

    public void setStopIndex(int i) {
        this.stop = i;
    }

    public void setText(String str) {
        this.text = str;
    }

    @Override // me.tvspark.ky0
    public void setTokenIndex(int i) {
        this.index = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return toString(null);
    }

    public String toString(Recognizer recognizer) {
        String str;
        if (this.channel > 0) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(",channel=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.channel);
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        } else {
            str = "";
        }
        String text = getText();
        String replace = text != null ? text.replace("\n", "\\n").replace(StringUtils.f4552CR, "\\r").replace("\t", "\\t") : "<no text>";
        String valueOf = String.valueOf(this.type);
        if (recognizer != null) {
            valueOf = ((jy0) recognizer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.type);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[@");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getTokenIndex());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(",");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.start);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.stop);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(replace);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("',<");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, valueOf, ">", str, ",");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.line);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getCharPositionInLine());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }
}

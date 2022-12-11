package org.apache.http.config;

import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import me.tvspark.outline;
import org.apache.http.Consts;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes4.dex */
public class ConnectionConfig implements Cloneable {
    public static final ConnectionConfig DEFAULT = new Builder().build();
    public final int bufferSize;
    public final Charset charset;
    public final int fragmentSizeHint;
    public final CodingErrorAction malformedInputAction;
    public final MessageConstraints messageConstraints;
    public final CodingErrorAction unmappableInputAction;

    /* loaded from: classes4.dex */
    public static class Builder {
        public int bufferSize;
        public Charset charset;
        public int fragmentSizeHint = -1;
        public CodingErrorAction malformedInputAction;
        public MessageConstraints messageConstraints;
        public CodingErrorAction unmappableInputAction;

        public ConnectionConfig build() {
            Charset charset = this.charset;
            if (charset == null && (this.malformedInputAction != null || this.unmappableInputAction != null)) {
                charset = Consts.ASCII;
            }
            Charset charset2 = charset;
            int i = this.bufferSize;
            int i2 = i > 0 ? i : 8192;
            int i3 = this.fragmentSizeHint;
            return new ConnectionConfig(i2, i3 >= 0 ? i3 : i2, charset2, this.malformedInputAction, this.unmappableInputAction, this.messageConstraints);
        }

        public Builder setBufferSize(int i) {
            this.bufferSize = i;
            return this;
        }

        public Builder setCharset(Charset charset) {
            this.charset = charset;
            return this;
        }

        public Builder setFragmentSizeHint(int i) {
            this.fragmentSizeHint = i;
            return this;
        }

        public Builder setMalformedInputAction(CodingErrorAction codingErrorAction) {
            this.malformedInputAction = codingErrorAction;
            if (codingErrorAction != null && this.charset == null) {
                this.charset = Consts.ASCII;
            }
            return this;
        }

        public Builder setMessageConstraints(MessageConstraints messageConstraints) {
            this.messageConstraints = messageConstraints;
            return this;
        }

        public Builder setUnmappableInputAction(CodingErrorAction codingErrorAction) {
            this.unmappableInputAction = codingErrorAction;
            if (codingErrorAction != null && this.charset == null) {
                this.charset = Consts.ASCII;
            }
            return this;
        }
    }

    public ConnectionConfig(int i, int i2, Charset charset, CodingErrorAction codingErrorAction, CodingErrorAction codingErrorAction2, MessageConstraints messageConstraints) {
        this.bufferSize = i;
        this.fragmentSizeHint = i2;
        this.charset = charset;
        this.malformedInputAction = codingErrorAction;
        this.unmappableInputAction = codingErrorAction2;
        this.messageConstraints = messageConstraints;
    }

    public static Builder copy(ConnectionConfig connectionConfig) {
        Args.notNull(connectionConfig, "Connection config");
        return new Builder().setBufferSize(connectionConfig.getBufferSize()).setCharset(connectionConfig.getCharset()).setFragmentSizeHint(connectionConfig.getFragmentSizeHint()).setMalformedInputAction(connectionConfig.getMalformedInputAction()).setUnmappableInputAction(connectionConfig.getUnmappableInputAction()).setMessageConstraints(connectionConfig.getMessageConstraints());
    }

    public static Builder custom() {
        return new Builder();
    }

    public ConnectionConfig clone() throws CloneNotSupportedException {
        return (ConnectionConfig) super.clone();
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public int getFragmentSizeHint() {
        return this.fragmentSizeHint;
    }

    public CodingErrorAction getMalformedInputAction() {
        return this.malformedInputAction;
    }

    public MessageConstraints getMessageConstraints() {
        return this.messageConstraints;
    }

    public CodingErrorAction getUnmappableInputAction() {
        return this.unmappableInputAction;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[bufferSize=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.bufferSize);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", fragmentSizeHint=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.fragmentSizeHint);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", charset=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.charset);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", malformedInputAction=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.malformedInputAction);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", unmappableInputAction=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.unmappableInputAction);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", messageConstraints=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.messageConstraints);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

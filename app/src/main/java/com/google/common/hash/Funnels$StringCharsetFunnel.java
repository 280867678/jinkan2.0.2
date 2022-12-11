package com.google.common.hash;

import java.io.Serializable;
import java.nio.charset.Charset;
import me.tvspark.AbstractC2652ty;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Funnels$StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
    public final Charset charset;

    /* loaded from: classes3.dex */
    public static class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final String charsetCanonicalName;

        public SerializedForm(Charset charset) {
            this.charsetCanonicalName = charset.name();
        }

        private Object readResolve() {
            return new Funnels$StringCharsetFunnel(Charset.forName(this.charsetCanonicalName));
        }
    }

    public Funnels$StringCharsetFunnel(Charset charset) {
        if (charset != null) {
            this.charset = charset;
            return;
        }
        throw null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Funnels$StringCharsetFunnel) {
            return this.charset.equals(((Funnels$StringCharsetFunnel) obj).charset);
        }
        return false;
    }

    @Override // com.google.common.hash.Funnel
    public void funnel(CharSequence charSequence, AbstractC2652ty abstractC2652ty) {
        abstractC2652ty.mo4944Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, this.charset);
    }

    public int hashCode() {
        return Funnels$StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Funnels.stringFunnel(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.charset.name());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public Object writeReplace() {
        return new SerializedForm(this.charset);
    }
}

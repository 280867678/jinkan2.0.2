package me.tvspark;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: me.tvspark.yc */
/* loaded from: classes4.dex */
public final class C2819yc extends AbstractC2519qc {
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("(.+?)='(.*?)';", 32);
    public final CharsetDecoder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.newDecoder();
    public final CharsetDecoder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.newDecoder();

    @Override // me.tvspark.AbstractC2519qc
    public C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2402nc c2402nc, ByteBuffer byteBuffer) {
        String str;
        CharsetDecoder charsetDecoder;
        String str2 = null;
        try {
            str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.decode(byteBuffer).toString();
            charsetDecoder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } catch (CharacterCodingException unused) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.reset();
            byteBuffer.rewind();
            try {
                str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.decode(byteBuffer).toString();
            } catch (CharacterCodingException unused2) {
                str = null;
            } catch (Throwable th) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.reset();
                byteBuffer.rewind();
                throw th;
            }
            charsetDecoder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } catch (Throwable th2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.reset();
            byteBuffer.rewind();
            throw th2;
        }
        charsetDecoder.reset();
        byteBuffer.rewind();
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (str == null) {
            return new C2254jc(new C1905ad(bArr, null, null));
        }
        Matcher matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str);
        String str3 = null;
        for (int i = 0; matcher.find(i); i = matcher.end()) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher.group(1));
            String group = matcher.group(2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                char c = 65535;
                int hashCode = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
                if (hashCode != -315603473) {
                    if (hashCode == 1646559960 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("streamtitle")) {
                        c = 0;
                    }
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("streamurl")) {
                    c = 1;
                }
                if (c == 0) {
                    str2 = group;
                } else if (c == 1) {
                    str3 = group;
                }
            }
        }
        return new C2254jc(new C1905ad(bArr, str2, str3));
    }
}

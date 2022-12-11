package me.tvspark;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.mozilla.universalchardet.UniversalDetector$InputState;
import org.mozilla.universalchardet.prober.CharsetProber;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes4.dex */
public class al0 extends Converter.Factory {
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Converter<ResponseBody, String> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:113:0x01bd, code lost:
            if (r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r3, 0, r8) == org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT) goto L114;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x015a, code lost:
            if (r7 != null) goto L125;
         */
        @Override // retrofit2.Converter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String convert(@NonNull ResponseBody responseBody) throws IOException {
            String str;
            CharsetProber charsetProber;
            String str2;
            Charset charset;
            ResponseBody responseBody2 = responseBody;
            if (!TextUtils.isEmpty(al0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return new String(responseBody2.bytes(), al0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            MediaType contentType = responseBody2.contentType();
            byte[] bytes = responseBody2.bytes();
            if (contentType != null && (charset = contentType.charset()) != null) {
                String displayName = charset.displayName();
                if (!TextUtils.isEmpty(displayName)) {
                    return new String(bytes, Charset.forName(displayName));
                }
            }
            Iterator<Element> it = Jsoup.parse(new String(Arrays.copyOfRange(bytes, 0, 1024), "utf-8")).getElementsByTag("meta").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                String attr = next.attr("content");
                String attr2 = next.attr("http-equiv");
                String attr3 = next.attr("charset");
                if (!attr3.isEmpty() && !TextUtils.isEmpty(attr3)) {
                    return new String(bytes, Charset.forName(attr3));
                }
                if (attr2.toLowerCase().equals("content-type")) {
                    String substring = attr.substring(attr.toLowerCase().contains("charset") ? attr.toLowerCase().indexOf("charset") + 8 : attr.toLowerCase().indexOf(";") + 1);
                    if (!TextUtils.isEmpty(substring)) {
                        try {
                            return new String(bytes, Charset.forName(substring));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        continue;
                    }
                }
            }
            CharsetProber[] charsetProberArr = new CharsetProber[3];
            for (int i = 0; i < 3; i++) {
                charsetProberArr[i] = null;
            }
            UniversalDetector$InputState universalDetector$InputState = UniversalDetector$InputState.PURE_ASCII;
            for (int i2 = 0; i2 < 3; i2++) {
                if (charsetProberArr[i2] != null) {
                    charsetProberArr[i2].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
            int length = bytes.length - 1;
            boolean z = length > 0;
            if (length > 3) {
                int i3 = bytes[0] & 255;
                int i4 = bytes[1] & 255;
                int i5 = bytes[2] & 255;
                int i6 = bytes[3] & 255;
                if (i3 == 0) {
                    if (i4 == 0 && i5 == 254 && i6 == 255) {
                        str2 = v21.Wwwwwwwwwww;
                    } else {
                        if (i4 == 0 && i5 == 255 && i6 == 254) {
                            str2 = v21.Wwwwwww;
                        }
                        str = null;
                    }
                    str = str2;
                } else if (i3 == 239) {
                    if (i4 == 187 && i5 == 191) {
                        str2 = v21.Wwwwwwwwwwwwww;
                        str = str2;
                    }
                    str = null;
                } else if (i3 != 254) {
                    if (i3 == 255) {
                        if (i4 == 254 && i5 == 0 && i6 == 0) {
                            str2 = v21.Wwwwwwwwww;
                        } else if (i4 == 254) {
                            str2 = v21.Wwwwwwwwwwww;
                        }
                        str = str2;
                    }
                    str = null;
                } else {
                    if (i4 == 255 && i5 == 0 && i6 == 0) {
                        str2 = v21.Wwwwwwww;
                    } else {
                        if (i4 == 255) {
                            str2 = v21.Wwwwwwwwwwwww;
                        }
                        str = null;
                    }
                    str = str2;
                }
            } else {
                str = null;
            }
            int i7 = 0 + length;
            byte b = 0;
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = bytes[i8] & 255;
                if ((i9 & 128) == 0 || i9 == 160) {
                    if (universalDetector$InputState == UniversalDetector$InputState.PURE_ASCII && (i9 == 27 || (i9 == 123 && b == 126))) {
                        universalDetector$InputState = UniversalDetector$InputState.ESC_ASCII;
                    }
                    b = bytes[i8];
                } else {
                    UniversalDetector$InputState universalDetector$InputState2 = UniversalDetector$InputState.HIGHBYTE;
                    if (universalDetector$InputState != universalDetector$InputState2) {
                        if (charsetProberArr[0] == null) {
                            charsetProberArr[0] = new e31();
                        }
                        if (charsetProberArr[1] == null) {
                            charsetProberArr[1] = new f31();
                        }
                        if (charsetProberArr[2] == null) {
                            charsetProberArr[2] = new d31();
                        }
                        universalDetector$InputState = universalDetector$InputState2;
                    }
                }
            }
            if (universalDetector$InputState != UniversalDetector$InputState.ESC_ASCII) {
                if (universalDetector$InputState == UniversalDetector$InputState.HIGHBYTE) {
                    int i10 = 0;
                    for (int i11 = 3; i10 < i11; i11 = 3) {
                        if (charsetProberArr[i10].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bytes, 0, length) == CharsetProber.ProbingState.FOUND_IT) {
                            charsetProber = charsetProberArr[i10];
                            str = charsetProber.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            break;
                        }
                        i10++;
                    }
                }
                if (z && str == null) {
                    if (universalDetector$InputState == UniversalDetector$InputState.HIGHBYTE) {
                        float f = 0.0f;
                        int i12 = 0;
                        for (int i13 = 0; i13 < 3; i13++) {
                            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charsetProberArr[i13].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > f) {
                                i12 = i13;
                                f = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            }
                        }
                        if (f > 0.2f) {
                            str = charsetProberArr[i12].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                    } else {
                        UniversalDetector$InputState universalDetector$InputState3 = UniversalDetector$InputState.ESC_ASCII;
                    }
                }
                return new String(bytes, Charset.forName(str));
            }
            charsetProber = new a31();
        }
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, String> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}

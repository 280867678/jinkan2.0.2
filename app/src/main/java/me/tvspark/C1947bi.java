package me.tvspark;

import android.text.Layout;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.net.MailTo;
import com.efs.sdk.base.Constants;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.umeng.analytics.pro.C1543ak;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.seamless.xhtml.XHTMLElement;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: me.tvspark.bi */
/* loaded from: classes4.dex */
public final class C1947bi extends AbstractC2823yg {
    public final XmlPullParserFactory Wwwwwwwwwwwwwwwwwwwww;
    public static final Pattern Wwwwwwwwwwwwwwwwwwww = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    public static final Pattern Wwwwwwwwwwwwwwwwwww = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    public static final Pattern Wwwwwwwwwwwwwwwwww = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    public static final Pattern Wwwwwwwwwwwwwwwww = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    public static final Pattern Wwwwwwwwwwwwwwww = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    public static final Pattern Wwwwwwwwwwwwwww = Pattern.compile("^(\\d+) (\\d+)$");
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(30.0f, 1, 1);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(32, 15);

    /* renamed from: me.tvspark.bi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }
    }

    /* renamed from: me.tvspark.bi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, int i, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }
    }

    /* renamed from: me.tvspark.bi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }
    }

    public C1947bi() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.Wwwwwwwwwwwwwwwwwwwww = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    @Nullable
    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(XmlPullParser xmlPullParser) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "extent");
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
            return null;
        }
        Matcher matcher = Wwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (!matcher.matches()) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length() != 0) {
                "Ignoring non-pixel tts extent: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            } else {
                new String("Ignoring non-pixel tts extent: ");
            }
            return null;
        }
        try {
            String group = matcher.group(1);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
            int parseInt = Integer.parseInt(group);
            String group2 = matcher.group(2);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parseInt, Integer.parseInt(group2));
        } catch (NumberFormatException unused) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length() != 0) {
                "Ignoring malformed tts extent: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            } else {
                new String("Ignoring malformed tts extent: ");
            }
            return null;
        }
    }

    public static String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trim, "\\s+");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d5, code lost:
        if (r14.equals(com.umeng.analytics.pro.C1543ak.f2965aB) != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws SubtitleDecoderException {
        double d;
        double d2;
        String group;
        String group2;
        String group3;
        String group4;
        String group5;
        Matcher matcher = Wwwwwwwwwwwwwwwwwwww.matcher(str);
        char c = 2;
        if (matcher.matches()) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher.group(1));
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher.group(2));
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher.group(3));
            double parseLong = (Long.parseLong(group) * 3600) + (Long.parseLong(group2) * 60) + Long.parseLong(group3);
            String group6 = matcher.group(4);
            double d3 = RoundRectDrawableWithShadow.COS_45;
            double parseDouble = parseLong + (group6 != null ? Double.parseDouble(group6) : 0.0d) + (matcher.group(5) != null ? ((float) Long.parseLong(group4)) / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : 0.0d);
            if (matcher.group(6) != null) {
                d3 = (Long.parseLong(group5) / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return (long) ((parseDouble + d3) * 1000000.0d);
        }
        Matcher matcher2 = Wwwwwwwwwwwwwwwwwww.matcher(str);
        if (!matcher2.matches()) {
            String valueOf = String.valueOf(str);
            throw new SubtitleDecoderException(valueOf.length() != 0 ? "Malformed time expression: ".concat(valueOf) : new String("Malformed time expression: "));
        }
        String group7 = matcher2.group(1);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group7);
        double parseDouble2 = Double.parseDouble(group7);
        String group8 = matcher2.group(2);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group8);
        String str2 = group8;
        int hashCode = str2.hashCode();
        if (hashCode == 102) {
            if (str2.equals("f")) {
                c = 4;
            }
            c = 65535;
        } else if (hashCode == 104) {
            if (str2.equals(XHTMLElement.XPATH_PREFIX)) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode == 109) {
            if (str2.equals("m")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode == 3494) {
            if (str2.equals("ms")) {
                c = 3;
            }
            c = 65535;
        } else if (hashCode != 115) {
            if (hashCode == 116 && str2.equals(C1543ak.f2971aH)) {
                c = 5;
            }
            c = 65535;
        }
        if (c == 0) {
            d = 3600.0d;
        } else if (c != 1) {
            if (c == 3) {
                d2 = 1000.0d;
            } else if (c != 4) {
                if (c == 5) {
                    d2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                return (long) (parseDouble2 * 1000000.0d);
            } else {
                d2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            parseDouble2 /= d2;
            return (long) (parseDouble2 * 1000000.0d);
        } else {
            d = 60.0d;
        }
        parseDouble2 *= d;
        return (long) (parseDouble2 * 1000000.0d);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue2, StringUtils.SPACE);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[0]) / Integer.parseInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1]);
        }
        int i = Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i = Integer.parseInt(attributeValue3);
        }
        int i2 = Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        }
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parseInt * f, i, i2);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(XmlPullParser xmlPullParser, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        Matcher matcher = Wwwwwwwwwwwwwww.matcher(attributeValue);
        if (!matcher.matches()) {
            if (attributeValue.length() != 0) {
                "Ignoring malformed cell resolution: ".concat(attributeValue);
            } else {
                new String("Ignoring malformed cell resolution: ");
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        try {
            String group = matcher.group(1);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
            int parseInt = Integer.parseInt(group);
            String group2 = matcher.group(2);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
            int parseInt2 = Integer.parseInt(group2);
            if (parseInt != 0 && parseInt2 != 0) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parseInt, parseInt2);
            }
            StringBuilder sb = new StringBuilder(47);
            sb.append("Invalid cell resolution ");
            sb.append(parseInt);
            sb.append(StringUtils.SPACE);
            sb.append(parseInt2);
            throw new SubtitleDecoderException(sb.toString());
        } catch (NumberFormatException unused) {
            if (attributeValue.length() != 0) {
                "Ignoring malformed cell resolution: ".concat(attributeValue);
            } else {
                new String("Ignoring malformed cell resolution: ");
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public static C2075ei Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2075ei c2075ei) {
        return c2075ei == null ? new C2075ei() : c2075ei;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return str.equals("tt") || str.equals("head") || str.equals(MailTo.BODY) || str.equals("div") || str.equals(C1543ak.f3013ax) || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    @Override // me.tvspark.AbstractC2823yg
    public AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        try {
            XmlPullParser newPullParser = this.Wwwwwwwwwwwwwwwwwwwww.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new C2038di("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwww;
            C2112fi c2112fi = null;
            int i2 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                C1984ci c1984ci = (C1984ci) arrayDeque.peek();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newPullParser);
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newPullParser, Wwwwwwwwwwwww);
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newPullParser);
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name)) {
                            String valueOf = String.valueOf(newPullParser.getName());
                            if (valueOf.length() != 0) {
                                "Ignoring unsupported tag: ".concat(valueOf);
                            } else {
                                new String("Ignoring unsupported tag: ");
                            }
                            i2++;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                        } else if ("head".equals(name)) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newPullParser, hashMap, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, hashMap2, hashMap3);
                        } else {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                            try {
                                C1984ci Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newPullParser, c1984ci, hashMap2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                arrayDeque.push(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                if (c1984ci != null) {
                                    c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                }
                            } catch (SubtitleDecoderException e) {
                                C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Suppressing parser error", e);
                                i2++;
                            }
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    } else if (eventType == 4) {
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1984ci);
                        C1984ci Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newPullParser.getText());
                        if (c1984ci.Wwwwwwwwwwwwwwwwwwwwww == null) {
                            c1984ci.Wwwwwwwwwwwwwwwwwwwwww = new ArrayList();
                        }
                        c1984ci.Wwwwwwwwwwwwwwwwwwwwww.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            C1984ci c1984ci2 = (C1984ci) arrayDeque.peek();
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1984ci2);
                            c2112fi = new C2112fi(c1984ci2, hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            if (c2112fi != null) {
                return c2112fi;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, C2075ei c2075ei) throws SubtitleDecoderException {
        Matcher matcher;
        String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "\\s+");
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length == 1) {
            matcher = Wwwwwwwwwwwwwwwwww.matcher(str);
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length != 2) {
            int length = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Invalid number of entries for fontSize: ");
            sb.append(length);
            sb.append(".");
            throw new SubtitleDecoderException(sb.toString());
        } else {
            matcher = Wwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[1]);
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
            String str2 = group;
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 37) {
                if (hashCode != 3240) {
                    if (hashCode == 3592 && str2.equals("px")) {
                        c = 0;
                    }
                } else if (str2.equals("em")) {
                    c = 1;
                }
            } else if (str2.equals("%")) {
                c = 2;
            }
            if (c == 0) {
                c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwww = 1;
            } else if (c == 1) {
                c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwww = 2;
            } else if (c == 2) {
                c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwww = 3;
            } else {
                StringBuilder sb2 = new StringBuilder(str2.length() + 30);
                sb2.append("Invalid unit for fontSize: '");
                sb2.append(str2);
                sb2.append("'.");
                throw new SubtitleDecoderException(sb2.toString());
            }
            String group2 = matcher.group(1);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
            c2075ei.Wwwwwwwwwwwwwwwwwwwwwwww = Float.parseFloat(group2);
            return;
        }
        StringBuilder sb3 = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 36));
        sb3.append("Invalid expression for fontSize: '");
        sb3.append(str);
        sb3.append("'.");
        throw new SubtitleDecoderException(sb3.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01eb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0199  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, C2075ei> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(XmlPullParser xmlPullParser, Map<String, C2075ei> map, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, @Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Map<String, C2038di> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        float parseFloat;
        float parseFloat2;
        String str;
        float parseFloat3;
        float f;
        float f2;
        int i;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        int i2;
        C2038di c2038di;
        char c;
        char c2;
        do {
            xmlPullParser.next();
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "style")) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "style");
                C2075ei Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, new C2075ei());
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null) {
                    for (String str2 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map.get(str2));
                    }
                }
                String str3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwww;
                if (str3 != null) {
                    map.put(str3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                }
            } else if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "region")) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "id");
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != null && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "origin")) != null) {
                    Matcher matcher = Wwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    Matcher matcher2 = Wwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    if (matcher.matches()) {
                        try {
                            String group = matcher.group(1);
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
                            parseFloat = Float.parseFloat(group) / 100.0f;
                            String group2 = matcher.group(2);
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
                            parseFloat2 = Float.parseFloat(group2) / 100.0f;
                        } catch (NumberFormatException unused) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length() == 0) {
                                new String("Ignoring region with malformed origin: ");
                            }
                            "Ignoring region with malformed origin: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        }
                    } else if (!matcher2.matches()) {
                        str = "Ignoring region with unsupported origin: ";
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length() == 0) {
                            new String(str);
                        }
                        str.concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length() == 0) {
                            new String("Ignoring region with missing tts:extent: ");
                        }
                        "Ignoring region with missing tts:extent: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    } else {
                        try {
                            String group3 = matcher2.group(1);
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group3);
                            int parseInt = Integer.parseInt(group3);
                            String group4 = matcher2.group(2);
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group4);
                            float f3 = parseInt / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            float parseInt2 = Integer.parseInt(group4) / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            parseFloat = f3;
                            parseFloat2 = parseInt2;
                        } catch (NumberFormatException unused2) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length() == 0) {
                                new String("Ignoring region with malformed origin: ");
                            }
                            "Ignoring region with malformed origin: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        }
                    }
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "extent");
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 != null) {
                        Matcher matcher3 = Wwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8);
                        Matcher matcher4 = Wwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8);
                        str = "Ignoring region with malformed extent: ";
                        if (matcher3.matches()) {
                            try {
                                String group5 = matcher3.group(1);
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group5);
                                float parseFloat4 = Float.parseFloat(group5) / 100.0f;
                                String group6 = matcher3.group(2);
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group6);
                                parseFloat3 = Float.parseFloat(group6) / 100.0f;
                                f = parseFloat4;
                            } catch (NumberFormatException unused3) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length() == 0) {
                                    new String(str);
                                }
                            }
                        } else if (!matcher4.matches()) {
                            str = "Ignoring region with unsupported extent: ";
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length() == 0) {
                                new String(str);
                            }
                            str.concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length() == 0) {
                                new String("Ignoring region with missing tts:extent: ");
                            }
                            "Ignoring region with missing tts:extent: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        } else {
                            try {
                                String group7 = matcher4.group(1);
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group7);
                                int parseInt3 = Integer.parseInt(group7);
                                String group8 = matcher4.group(2);
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group8);
                                float f4 = parseInt3 / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                parseFloat3 = Integer.parseInt(group8) / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                f = f4;
                            } catch (NumberFormatException unused4) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length() == 0) {
                                    new String(str);
                                }
                            }
                        }
                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "displayAlign");
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 != null) {
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9);
                            int hashCode = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
                            if (hashCode != -1364013995) {
                                if (hashCode == 92734940 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("after")) {
                                    c2 = 1;
                                    if (c2 != 0) {
                                        f2 = (parseFloat3 / 2.0f) + parseFloat2;
                                        i = 1;
                                    } else if (c2 == 1) {
                                        f2 = parseFloat2 + parseFloat3;
                                        i = 2;
                                    }
                                    float f5 = 1.0f / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "writingMode");
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                        int hashCode2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hashCode();
                                        if (hashCode2 == 3694) {
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals("tb")) {
                                                c = 0;
                                                if (c != 0) {
                                                }
                                                i2 = 2;
                                                c2038di = new C2038di(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, parseFloat, f2, 0, i, f, parseFloat3, 1, f5, i2);
                                                if (c2038di != null) {
                                                }
                                            }
                                            c = 65535;
                                            if (c != 0) {
                                            }
                                            i2 = 2;
                                            c2038di = new C2038di(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, parseFloat, f2, 0, i, f, parseFloat3, 1, f5, i2);
                                            if (c2038di != null) {
                                            }
                                        } else if (hashCode2 != 3553396) {
                                            if (hashCode2 == 3553576 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals("tbrl")) {
                                                c = 2;
                                                if (c != 0 || c == 1) {
                                                    i2 = 2;
                                                } else if (c == 2) {
                                                    i2 = 1;
                                                }
                                                c2038di = new C2038di(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, parseFloat, f2, 0, i, f, parseFloat3, 1, f5, i2);
                                                if (c2038di != null) {
                                                    map2.put(c2038di.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2038di);
                                                }
                                            }
                                            c = 65535;
                                            if (c != 0) {
                                            }
                                            i2 = 2;
                                            c2038di = new C2038di(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, parseFloat, f2, 0, i, f, parseFloat3, 1, f5, i2);
                                            if (c2038di != null) {
                                            }
                                        } else {
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals("tblr")) {
                                                c = 1;
                                                if (c != 0) {
                                                }
                                                i2 = 2;
                                                c2038di = new C2038di(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, parseFloat, f2, 0, i, f, parseFloat3, 1, f5, i2);
                                                if (c2038di != null) {
                                                }
                                            }
                                            c = 65535;
                                            if (c != 0) {
                                            }
                                            i2 = 2;
                                            c2038di = new C2038di(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, parseFloat, f2, 0, i, f, parseFloat3, 1, f5, i2);
                                            if (c2038di != null) {
                                            }
                                        }
                                    }
                                    i2 = Integer.MIN_VALUE;
                                    c2038di = new C2038di(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, parseFloat, f2, 0, i, f, parseFloat3, 1, f5, i2);
                                    if (c2038di != null) {
                                    }
                                }
                                c2 = 65535;
                                if (c2 != 0) {
                                }
                                float f52 = 1.0f / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "writingMode");
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                                }
                                i2 = Integer.MIN_VALUE;
                                c2038di = new C2038di(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, parseFloat, f2, 0, i, f, parseFloat3, 1, f52, i2);
                                if (c2038di != null) {
                                }
                            } else {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("center")) {
                                    c2 = 0;
                                    if (c2 != 0) {
                                    }
                                    float f522 = 1.0f / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "writingMode");
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                                    }
                                    i2 = Integer.MIN_VALUE;
                                    c2038di = new C2038di(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, parseFloat, f2, 0, i, f, parseFloat3, 1, f522, i2);
                                    if (c2038di != null) {
                                    }
                                }
                                c2 = 65535;
                                if (c2 != 0) {
                                }
                                float f5222 = 1.0f / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "writingMode");
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                                }
                                i2 = Integer.MIN_VALUE;
                                c2038di = new C2038di(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, parseFloat, f2, 0, i, f, parseFloat3, 1, f5222, i2);
                                if (c2038di != null) {
                                }
                            }
                        }
                        f2 = parseFloat2;
                        i = 0;
                        float f52222 = 1.0f / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "writingMode");
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                        }
                        i2 = Integer.MIN_VALUE;
                        c2038di = new C2038di(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, parseFloat, f2, 0, i, f, parseFloat3, 1, f52222, i2);
                        if (c2038di != null) {
                        }
                    }
                }
                c2038di = null;
                if (c2038di != null) {
                }
            } else if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "metadata")) {
                do {
                    xmlPullParser.next();
                    if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "image") && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "id")) != null) {
                        map3.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, xmlPullParser.nextText());
                    }
                } while (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "metadata"));
            }
        } while (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, "head"));
        return map;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static C1984ci Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(XmlPullParser xmlPullParser, @Nullable C1984ci c1984ci, Map<String, C2038di> map, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws SubtitleDecoderException {
        long j;
        long j2;
        char c;
        int attributeCount = xmlPullParser.getAttributeCount();
        C2075ei Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xmlPullParser, (C2075ei) null);
        String str = null;
        String str2 = "";
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        long j5 = -9223372036854775807L;
        String[] strArr = null;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (c == 1) {
                j4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (c == 2) {
                j5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (c == 3) {
                String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length > 0) {
                    strArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
            } else if (c != 4) {
                if (c == 5 && attributeValue.startsWith("#")) {
                    str = attributeValue.substring(1);
                }
            } else if (map.containsKey(attributeValue)) {
                str2 = attributeValue;
            }
        }
        if (c1984ci != null) {
            long j6 = c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            j = -9223372036854775807L;
            if (j6 != -9223372036854775807L) {
                if (j3 != -9223372036854775807L) {
                    j3 += j6;
                }
                if (j4 != -9223372036854775807L) {
                    j4 += c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        if (j4 == j) {
            if (j5 != j) {
                j2 = j3 + j5;
            } else if (c1984ci != null) {
                long j7 = c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (j7 != j) {
                    j2 = j7;
                }
            }
            return new C1984ci(xmlPullParser.getName(), null, j3, j2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, strArr, str2, str, c1984ci);
        }
        j2 = j4;
        return new C1984ci(xmlPullParser.getName(), null, j3, j2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, strArr, str2, str, c1984ci);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static C2075ei Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(XmlPullParser xmlPullParser, C2075ei c2075ei) {
        char c;
        String str;
        String valueOf;
        Layout.Alignment alignment;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            char c2 = 65535;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if ("style".equals(xmlPullParser.getName())) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwwww = attributeValue;
                        continue;
                    }
                case 1:
                    c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                    try {
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2638tk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue, false);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        continue;
                    } catch (IllegalArgumentException unused) {
                        str = "Failed parsing background value: ";
                        valueOf = String.valueOf(attributeValue);
                        if (valueOf.length() == 0) {
                            new String(str);
                        }
                    }
                    break;
                case 2:
                    c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                    try {
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2638tk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue, false);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        continue;
                    } catch (IllegalArgumentException unused2) {
                        str = "Failed parsing color value: ";
                        valueOf = String.valueOf(attributeValue);
                        if (valueOf.length() == 0) {
                            new String(str);
                        }
                    }
                    break;
                case 3:
                    c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                    c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = attributeValue;
                    continue;
                case 4:
                    try {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue, c2075ei);
                        continue;
                    } catch (SubtitleDecoderException unused3) {
                        str = "Failed parsing fontSize value: ";
                        valueOf = String.valueOf(attributeValue);
                        if (valueOf.length() == 0) {
                            new String(str);
                        }
                    }
                    break;
                case 5:
                    c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                    c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwww = "bold".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    continue;
                case 6:
                    c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                    c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwww = "italic".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    continue;
                case 7:
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue);
                    switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode()) {
                        case -1364013995:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("center")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 100571:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("end")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 3317767:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("left")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 108511772:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("right")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 109757538:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("start")) {
                                c2 = 1;
                                break;
                            }
                            break;
                    }
                    if (c2 == 0 || c2 == 1) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        alignment = Layout.Alignment.ALIGN_NORMAL;
                    } else if (c2 == 2 || c2 == 3) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    } else if (c2 == 4) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        alignment = Layout.Alignment.ALIGN_CENTER;
                    }
                    c2075ei.Wwwwwwwwwwwwwwwwwwww = alignment;
                    continue;
                case '\b':
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue);
                    int hashCode = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hashCode();
                    if (hashCode != 96673) {
                        if (hashCode == 3387192 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals(Constants.CP_NONE)) {
                            c2 = 0;
                        }
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals("all")) {
                        c2 = 1;
                    }
                    if (c2 == 0) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwww = 0;
                    } else if (c2 == 1) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwww = 1;
                        continue;
                    }
                    break;
                case '\t':
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue);
                    switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.hashCode()) {
                        case -618561360:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals("baseContainer")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case -410956671:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals("container")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -250518009:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals("delimiter")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case -136074796:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals("textContainer")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 3016401:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals("base")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 3556653:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals("text")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    if (c2 == 0) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwww = 1;
                    } else if (c2 == 1 || c2 == 2) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwww = 2;
                    } else if (c2 == 3 || c2 == 4) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwww = 3;
                    } else if (c2 == 5) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwww = 4;
                        continue;
                    }
                case '\n':
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue);
                    int hashCode2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.hashCode();
                    if (hashCode2 != -1392885889) {
                        if (hashCode2 == 92734940 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.equals("after")) {
                            c2 = 1;
                        }
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.equals("before")) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwww = 1;
                    } else if (c2 == 1) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwww = 2;
                        continue;
                    }
                    break;
                case 11:
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(attributeValue);
                    switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.hashCode()) {
                        case -1461280213:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.equals("nounderline")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.equals("underline")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 913457136:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.equals("nolinethrough")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww5.equals("linethrough")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    if (c2 == 0) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                    } else if (c2 == 1) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                    } else if (c2 == 2) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                    } else if (c2 == 3) {
                        c2075ei = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2075ei);
                        c2075ei.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                        continue;
                    }
                default:
            }
            str.concat(valueOf);
        }
        return c2075ei;
    }
}

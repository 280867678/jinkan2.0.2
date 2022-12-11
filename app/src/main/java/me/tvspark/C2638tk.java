package me.tvspark;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* renamed from: me.tvspark.tk */
/* loaded from: classes4.dex */
public final class C2638tk {
    public static final Map<String, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");

    static {
        HashMap hashMap = new HashMap();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hashMap;
        hashMap.put("aliceblue", -984833);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("antiquewhite", -332841);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("aqua", -16711681);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("aquamarine", -8388652);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("azure", -983041);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("beige", -657956);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("bisque", -6972);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("black", -16777216);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("blanchedalmond", -5171);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("blue", -16776961);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("blueviolet", -7722014);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("brown", -5952982);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("burlywood", -2180985);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("cadetblue", -10510688);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("chartreuse", -8388864);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("chocolate", -2987746);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("coral", -32944);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("cornflowerblue", -10185235);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("cornsilk", -1828);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("crimson", -2354116);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("cyan", -16711681);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkblue", -16777077);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkcyan", -16741493);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkgoldenrod", -4684277);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkgray", -5658199);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkgreen", -16751616);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkgrey", -5658199);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkkhaki", -4343957);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkmagenta", -7667573);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkolivegreen", -11179217);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkorange", -29696);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkorchid", -6737204);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkred", -7667712);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darksalmon", -1468806);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkseagreen", -7357297);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkslateblue", -12042869);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkslategray", -13676721);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkslategrey", -13676721);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkturquoise", -16724271);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("darkviolet", -7077677);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("deeppink", -60269);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("deepskyblue", -16728065);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("dimgray", -9868951);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("dimgrey", -9868951);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("dodgerblue", -14774017);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("firebrick", -5103070);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("floralwhite", -1296);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("forestgreen", -14513374);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("fuchsia", -65281);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("gainsboro", -2302756);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("ghostwhite", -460545);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("gold", -10496);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("goldenrod", -2448096);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("gray", -8355712);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("green", -16744448);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("greenyellow", -5374161);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("grey", -8355712);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("honeydew", -983056);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("hotpink", -38476);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("indianred", -3318692);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("indigo", -11861886);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("ivory", -16);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("khaki", -989556);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lavender", -1644806);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lavenderblush", -3851);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lawngreen", -8586240);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lemonchiffon", -1331);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightblue", -5383962);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightcoral", -1015680);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightcyan", -2031617);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightgoldenrodyellow", -329006);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightgray", -2894893);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightgreen", -7278960);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightgrey", -2894893);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightpink", -18751);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightsalmon", -24454);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightseagreen", -14634326);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightskyblue", -7876870);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightslategray", -8943463);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightslategrey", -8943463);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightsteelblue", -5192482);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lightyellow", -32);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("lime", -16711936);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("limegreen", -13447886);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("linen", -331546);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("magenta", -65281);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("maroon", -8388608);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("mediumaquamarine", -10039894);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("mediumblue", -16777011);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("mediumorchid", -4565549);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("mediumpurple", -7114533);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("mediumseagreen", -12799119);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("mediumslateblue", -8689426);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("mediumspringgreen", -16713062);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("mediumturquoise", -12004916);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("mediumvioletred", -3730043);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("midnightblue", -15132304);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("mintcream", -655366);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("mistyrose", -6943);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("moccasin", -6987);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("navajowhite", -8531);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("navy", -16777088);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("oldlace", -133658);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("olive", -8355840);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("olivedrab", -9728477);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("orange", -23296);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("orangered", -47872);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("orchid", -2461482);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("palegoldenrod", -1120086);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("palegreen", -6751336);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("paleturquoise", -5247250);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("palevioletred", -2396013);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("papayawhip", -4139);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("peachpuff", -9543);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("peru", -3308225);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("pink", -16181);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("plum", -2252579);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("powderblue", -5185306);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("purple", -8388480);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("rebeccapurple", -10079335);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("red", -65536);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("rosybrown", -4419697);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("royalblue", -12490271);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("saddlebrown", -7650029);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("salmon", -360334);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("sandybrown", -744352);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("seagreen", -13726889);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("seashell", -2578);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("sienna", -6270419);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("silver", -4144960);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("skyblue", -7876885);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("slateblue", -9807155);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("slategray", -9404272);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("slategrey", -9404272);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("snow", -1286);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("springgreen", -16711809);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("steelblue", -12156236);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("tan", -2968436);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("teal", -16744320);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("thistle", -2572328);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("tomato", -40121);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("transparent", 0);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("turquoise", -12525360);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("violet", -1146130);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("wheat", -663885);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("white", -1);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("whitesmoke", -657931);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("yellowgreen", -6632142);
    }

    @ColorInt
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z) {
        int parseInt;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!TextUtils.isEmpty(str));
        String replace = str.replace(StringUtils.SPACE, "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return (-16777216) | parseLong;
            }
            if (replace.length() != 9) {
                throw new IllegalArgumentException();
            }
            return ((parseLong & 255) << 24) | (parseLong >>> 8);
        }
        if (replace.startsWith("rgba")) {
            Matcher matcher = (z ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    String group = matcher.group(4);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
                    parseInt = (int) (Float.parseFloat(group) * 255.0f);
                } else {
                    String group2 = matcher.group(4);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
                    parseInt = Integer.parseInt(group2, 10);
                }
                String group3 = matcher.group(1);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group3);
                int parseInt2 = Integer.parseInt(group3, 10);
                String group4 = matcher.group(2);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group4);
                int parseInt3 = Integer.parseInt(group4, 10);
                String group5 = matcher.group(3);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group5);
                return Color.argb(parseInt, parseInt2, parseInt3, Integer.parseInt(group5, 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(replace);
            if (matcher2.matches()) {
                String group6 = matcher2.group(1);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group6);
                int parseInt4 = Integer.parseInt(group6, 10);
                String group7 = matcher2.group(2);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group7);
                int parseInt5 = Integer.parseInt(group7, 10);
                String group8 = matcher2.group(3);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group8);
                return Color.rgb(parseInt4, parseInt5, Integer.parseInt(group8, 10));
            }
        } else {
            Integer num = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}

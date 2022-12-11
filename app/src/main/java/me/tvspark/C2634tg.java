package me.tvspark;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.C2245j3;
import me.tvspark.C2258jg;
import me.tvspark.C2322l6;
import me.tvspark.C2336lk;
import me.tvspark.C2523qg;
import me.tvspark.C2560rg;
import org.apache.commons.lang3.time.StopWatch;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.eclipse.jetty.util.security.Constraint;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;
import org.mozilla.javascript.ES6Iterator;

/* renamed from: me.tvspark.tg */
/* loaded from: classes4.dex */
public final class C2634tg implements C2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<AbstractC2597sg> {
    public final C2523qg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("VIDEO=\"(.+?)\"");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("AUDIO=\"(.+?)\"");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("SUBTITLES=\"(.+?)\"");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("CHANNELS=\"(.+?)\"");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("CODECS=\"(.+?)\"");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwww = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwww = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern Wwwwwwwwwwwwwwwwwwww = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern Wwwwwwwwwwwwwwwwwww = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern Wwwwwwwwwwwwwwwwww = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final Pattern Wwwwwwwwwwwwwwwww = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern Wwwwwwwwwwwwwwww = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern Wwwwwwwwwwwwwww = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern Wwwwwwwwwwwwww = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final Pattern Wwwwwwwwwwwww = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern Wwwwwwwwwwww = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    public static final Pattern Wwwwwwwwwww = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern Wwwwwwwwww = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern Wwwwwwwww = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern Wwwwwwww = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern Wwwwwww = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern Wwwwww = Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final Pattern Wwwww = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    public static final Pattern Wwww = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern Www = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("AUTOSELECT");
    public static final Pattern Kkkkkkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("DEFAULT");
    public static final Pattern Kkkkkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FORCED");
    public static final Pattern Kkkkkkkkkkkkkkkkkkkkkkkk = Pattern.compile("VALUE=\"(.+?)\"");
    public static final Pattern Kkkkkkkkkkkkkkkkkkkkkkk = Pattern.compile("IMPORT=\"(.+?)\"");
    public static final Pattern Kkkkkkkkkkkkkkkkkkkkkk = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* renamed from: me.tvspark.tg$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Queue<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final BufferedReader Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Queue<String> queue, BufferedReader bufferedReader) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = queue;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bufferedReader;
        }

        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                return str;
            }
            throw new NoSuchElementException();
        }

        @EnsuresNonNullIf(expression = {ES6Iterator.NEXT_METHOD}, result = true)
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            String trim;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                return true;
            }
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                String poll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.poll();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(poll);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = poll;
                return true;
            }
            do {
                String readLine = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.readLine();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = trim;
            } while (trim.isEmpty());
            return true;
        }
    }

    public C2634tg() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2523qg.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public C2634tg(C2523qg c2523qg) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2523qg;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, pattern, map);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        String pattern2 = pattern.pattern();
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pattern2, 19)));
        sb.append("Couldn't match ");
        sb.append(pattern2);
        sb.append(" in ");
        sb.append(str);
        throw new ParserException(sb.toString());
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BufferedReader bufferedReader, boolean z, int i) throws IOException {
        while (i != -1 && Character.isWhitespace(i) && (z || !C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, pattern, Collections.emptyMap()));
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Map<String, String> map) {
        Matcher matcher = Kkkkkkkkkkkkkkkkkkkkkk.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
            str2 = group;
        }
        return (map.isEmpty() || str2 == null) ? str2 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, map);
    }

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Pattern pattern, Map<String, String> map) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, pattern, null, map);
    }

    public static Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 9));
        sb.append(str);
        sb.append("=(");
        sb.append("NO");
        sb.append("|");
        sb.append("YES");
        sb.append(")");
        return Pattern.compile(sb.toString());
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:
        r1 = r0.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
        if (r1 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
        r1 = r1.trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005e, code lost:
        if (r1.isEmpty() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
        if (r1.startsWith("#EXT-X-STREAM-INF") == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
        if (r1.startsWith("#EXT-X-TARGETDURATION") != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
        if (r1.startsWith("#EXT-X-MEDIA-SEQUENCE") != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
        if (r1.startsWith("#EXTINF") != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
        if (r1.startsWith("#EXT-X-KEY") != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a0, code lost:
        if (r1.startsWith("#EXT-X-BYTERANGE") != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a8, code lost:
        if (r1.equals("#EXT-X-DISCONTINUITY") != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b0, code lost:
        if (r1.equals("#EXT-X-DISCONTINUITY-SEQUENCE") != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b8, code lost:
        if (r1.equals("#EXT-X-ENDLIST") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bb, code lost:
        r8.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bf, code lost:
        r8.add(r1);
        r7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new me.tvspark.C2634tg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r8, r0), r7.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d4, code lost:
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0069, code lost:
        r8.add(r1);
        r7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new me.tvspark.C2634tg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r8, r0), r7.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d5, code lost:
        me.tvspark.C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((java.io.Closeable) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00df, code lost:
        throw new com.google.android.exoplayer2.ParserException("Failed to parse the playlist, could not identify any tags.");
     */
    @Override // me.tvspark.C2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC2597sg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            int read = bufferedReader.read();
            boolean z = false;
            if (read == 239) {
                if (bufferedReader.read() == 187 && bufferedReader.read() == 191) {
                    read = bufferedReader.read();
                }
                throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bufferedReader, true, read);
            int i = 0;
            while (true) {
                if (i >= 7) {
                    z = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bufferedReader, false, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
                    break;
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != "#EXTM3U".charAt(i)) {
                    break;
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bufferedReader.read();
                    i++;
                }
            }
            throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
        } finally {
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Closeable) bufferedReader);
        }
    }

    @Nullable
    public static C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, Map<String, String> map) throws ParserException {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Wwwwwwwwwwww, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Wwwwwwwwwww, map);
            return new C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4, Base64.decode(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, "hls", C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        } else {
            if (!"com.microsoft.playready".equals(str2) || !"1".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                return null;
            }
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Wwwwwwwwwww, map);
            return new C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Base64.decode(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.indexOf(44)), 0)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    public static C2523qg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, String str) throws IOException {
        ArrayList arrayList;
        int i;
        char c;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ArrayList arrayList5;
        ArrayList arrayList6;
        C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String str2;
        C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        String str3;
        int parseInt;
        String str4;
        ArrayList arrayList7;
        ArrayList arrayList8;
        int i2;
        ArrayList arrayList9;
        ArrayList arrayList10;
        int i3;
        ArrayList arrayList11;
        int i4;
        ArrayList arrayList12;
        ArrayList arrayList13;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        HashMap hashMap;
        int i5;
        String str5 = str;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        ArrayList arrayList19 = new ArrayList();
        ArrayList arrayList20 = new ArrayList();
        ArrayList arrayList21 = new ArrayList();
        boolean z = false;
        boolean z2 = false;
        while (true) {
            String str6 = "application/x-mpegURL";
            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                HashMap hashMap4 = hashMap2;
                ArrayList arrayList22 = arrayList19;
                ArrayList arrayList23 = arrayList15;
                ArrayList arrayList24 = arrayList16;
                ArrayList arrayList25 = arrayList17;
                ArrayList arrayList26 = arrayList18;
                ArrayList arrayList27 = arrayList21;
                boolean z3 = z2;
                ArrayList arrayList28 = arrayList20;
                ArrayList arrayList29 = new ArrayList();
                HashSet hashSet = new HashSet();
                int i6 = 0;
                while (true) {
                    arrayList = null;
                    if (i6 >= arrayList14.size()) {
                        break;
                    }
                    C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = (C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayList14.get(i6);
                    if (hashSet.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww == null);
                        ArrayList arrayList30 = (ArrayList) hashMap4.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList30);
                        C2254jc c2254jc = new C2254jc(new C2258jg(null, null, arrayList30));
                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc;
                        arrayList29.add(new C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    }
                    i6++;
                }
                int i7 = 0;
                C2245j3 c2245j3 = null;
                while (i7 < arrayList22.size()) {
                    ArrayList arrayList31 = arrayList22;
                    String str7 = (String) arrayList31.get(i7);
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7, Wwwwww, hashMap3);
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7, Wwwwwww, hashMap3);
                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, 1)));
                    sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    sb.append(":");
                    sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sb.toString();
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwww = str6;
                    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7, Kkkkkkkkkkkkkkkkkkkkkkkkkk, false);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7, Kkkkkkkkkkkkkkkkkkkkkkkkk, false)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 ? 1 : 0) | true;
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7, Www, false)) {
                        boolean z4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 ? 1 : 0;
                        ?? r12 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 ? 1 : 0;
                        ?? r122 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 ? 1 : 0;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = z4 | true;
                    }
                    int i8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 ? 1 : 0;
                    int i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 ? 1 : 0;
                    int i10 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 ? 1 : 0;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8;
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7, Wwwww, hashMap3);
                    if (TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4)) {
                        i = 0;
                    } else {
                        String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, ",");
                        int i11 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, (Object) "public.accessibility.describes-video") ? 512 : 0;
                        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, (Object) "public.accessibility.transcribes-spoken-dialog")) {
                            i11 |= 4096;
                        }
                        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, (Object) "public.accessibility.describes-music-and-sound")) {
                            i11 |= 1024;
                        }
                        i = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, (Object) "public.easy-to-read") ? i11 | 8192 : i11;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7, Wwwwwwww, hashMap3);
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7, Wwwwwwwwwww, hashMap3);
                    Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == null ? null : Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                    arrayList22 = arrayList31;
                    String str8 = str6;
                    C2254jc c2254jc2 = new C2254jc(new C2258jg(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, Collections.emptyList()));
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7, Wwwwwwwww, hashMap3);
                    switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.hashCode()) {
                        case -959297733:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.equals("SUBTITLES")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -333210994:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.equals("CLOSED-CAPTIONS")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 62628790:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.equals("AUDIO")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 81665115:
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.equals("VIDEO")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            if (c == 2) {
                                int i12 = 0;
                                while (true) {
                                    if (i12 < arrayList14.size()) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = (C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayList14.get(i12);
                                        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                            i12++;
                                        }
                                    } else {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = null;
                                    }
                                }
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww, 3);
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8;
                                    str3 = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8);
                                } else {
                                    str3 = null;
                                }
                                if (str3 == null) {
                                    str3 = "text/vtt";
                                }
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwww = str3;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc2;
                                arrayList4 = arrayList25;
                                arrayList4.add(new C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4));
                            } else if (c != 3) {
                                arrayList4 = arrayList25;
                            } else {
                                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7, Wwww, hashMap3);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.startsWith("CC")) {
                                    parseInt = Integer.parseInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.substring(2));
                                    str4 = "application/cea-608";
                                } else {
                                    parseInt = Integer.parseInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.substring(7));
                                    str4 = "application/cea-708";
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwww = str4;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwww = parseInt;
                                arrayList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                arrayList6 = arrayList;
                                arrayList3 = arrayList24;
                                arrayList5 = arrayList23;
                                arrayList4 = arrayList25;
                                i7++;
                                arrayList23 = arrayList5;
                                arrayList24 = arrayList3;
                                arrayList25 = arrayList4;
                                str6 = str8;
                                arrayList = arrayList6;
                            }
                            arrayList2 = arrayList;
                            arrayList3 = arrayList24;
                        } else {
                            arrayList4 = arrayList25;
                            int i13 = 0;
                            while (true) {
                                if (i13 < arrayList14.size()) {
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayList14.get(i13);
                                    arrayList2 = arrayList;
                                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                        i13++;
                                        arrayList = arrayList2;
                                    }
                                } else {
                                    arrayList2 = arrayList;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = null;
                                }
                            }
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww, 1);
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
                                str2 = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9);
                            } else {
                                str2 = null;
                            }
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7, Wwwwwwwwwwwwwwwwwwwwwwwwwww, hashMap3);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 != null) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwww = Integer.parseInt(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10, "/")[0]);
                                if ("audio/eac3".equals(str2) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.endsWith("/JOC")) {
                                    str2 = "audio/eac3-joc";
                                }
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwww = str2;
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != null) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc2;
                                arrayList3 = arrayList24;
                                arrayList3.add(new C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4));
                            } else {
                                arrayList3 = arrayList24;
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                                    c2245j3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    arrayList6 = arrayList2;
                                    arrayList5 = arrayList23;
                                    i7++;
                                    arrayList23 = arrayList5;
                                    arrayList24 = arrayList3;
                                    arrayList25 = arrayList4;
                                    str6 = str8;
                                    arrayList = arrayList6;
                                }
                            }
                        }
                        arrayList6 = arrayList2;
                        i7++;
                        arrayList23 = arrayList5;
                        arrayList24 = arrayList3;
                        arrayList25 = arrayList4;
                        str6 = str8;
                        arrayList = arrayList6;
                    } else {
                        arrayList2 = arrayList;
                        arrayList3 = arrayList24;
                        arrayList4 = arrayList25;
                        int i14 = 0;
                        while (true) {
                            if (i14 < arrayList14.size()) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayList14.get(i14);
                                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                    i14++;
                                }
                            } else {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                            }
                        }
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                            C2245j3 c2245j32 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j32.Wwwwwwwwwwwwwwww, 2);
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwww = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11);
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwww = c2245j32.Wwwwwww;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwww = c2245j32.Wwwwww;
                        }
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != null) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc2;
                            arrayList5 = arrayList23;
                            arrayList5.add(new C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4));
                            arrayList6 = arrayList2;
                            i7++;
                            arrayList23 = arrayList5;
                            arrayList24 = arrayList3;
                            arrayList25 = arrayList4;
                            str6 = str8;
                            arrayList = arrayList6;
                        }
                    }
                    arrayList5 = arrayList23;
                    arrayList6 = arrayList2;
                    i7++;
                    arrayList23 = arrayList5;
                    arrayList24 = arrayList3;
                    arrayList25 = arrayList4;
                    str6 = str8;
                    arrayList = arrayList6;
                }
                return new C2523qg(str, arrayList27, arrayList29, arrayList23, arrayList24, arrayList25, arrayList26, c2245j3, z ? Collections.emptyList() : arrayList, z3, hashMap3, arrayList28);
            }
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.startsWith("#EXT")) {
                arrayList21.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
            }
            boolean startsWith = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            boolean z5 = z2;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.startsWith("#EXT-X-DEFINE")) {
                hashMap3.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwww, hashMap3), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Kkkkkkkkkkkkkkkkkkkkkkkk, hashMap3));
            } else {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    z2 = true;
                    hashMap = hashMap2;
                    arrayList13 = arrayList19;
                    arrayList10 = arrayList15;
                    arrayList11 = arrayList16;
                    arrayList12 = arrayList17;
                    arrayList7 = arrayList18;
                    arrayList9 = arrayList21;
                    arrayList8 = arrayList20;
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.startsWith("#EXT-X-MEDIA")) {
                    arrayList19.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                } else {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.startsWith("#EXT-X-SESSION-KEY")) {
                        C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwww, "identity", hashMap3), hashMap3);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 != null) {
                            arrayList7 = arrayList18;
                            arrayList20.add(new C2322l6(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwww, hashMap3)), true, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12));
                        }
                    } else {
                        arrayList7 = arrayList18;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                            boolean contains = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.contains("CLOSED-CAPTIONS=NONE") | z;
                            int i15 = startsWith ? 16384 : 0;
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Matcher matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                            arrayList8 = arrayList20;
                            if (matcher.find()) {
                                String group = matcher.group(1);
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
                                i2 = Integer.parseInt(group);
                            } else {
                                i2 = -1;
                            }
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwwwww, hashMap3);
                            arrayList9 = arrayList21;
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwwww, hashMap3);
                            arrayList10 = arrayList15;
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15 != null) {
                                String[] split = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15.split("x");
                                i3 = Integer.parseInt(split[0]);
                                int parseInt2 = Integer.parseInt(split[1]);
                                if (i3 <= 0 || parseInt2 <= 0) {
                                    i3 = -1;
                                    i5 = -1;
                                } else {
                                    i5 = parseInt2;
                                }
                                i4 = i5;
                                arrayList11 = arrayList16;
                            } else {
                                i3 = -1;
                                arrayList11 = arrayList16;
                                i4 = -1;
                            }
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwww, hashMap3);
                            float parseFloat = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 != null ? Float.parseFloat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16) : -1.0f;
                            arrayList12 = arrayList17;
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, hashMap3);
                            arrayList13 = arrayList19;
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, hashMap3);
                            HashMap hashMap5 = hashMap2;
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, hashMap3);
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, hashMap3);
                            if (startsWith) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwww, hashMap3);
                            } else if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                throw new ParserException("#EXT-X-STREAM-INF must be followed by another line");
                            } else {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), hashMap3);
                            }
                            Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList14.size());
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwww = str6;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwww = i3;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwww = i4;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwww = parseFloat;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i15;
                            arrayList14.add(new C2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20));
                            hashMap = hashMap5;
                            ArrayList arrayList32 = (ArrayList) hashMap.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21);
                            if (arrayList32 == null) {
                                arrayList32 = new ArrayList();
                                hashMap.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21, arrayList32);
                            }
                            arrayList32.add(new C2258jg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20));
                            z2 = z5;
                            z = contains;
                        }
                    }
                    hashMap = hashMap2;
                    arrayList13 = arrayList19;
                    arrayList10 = arrayList15;
                    arrayList11 = arrayList16;
                    arrayList12 = arrayList17;
                    arrayList9 = arrayList21;
                    arrayList8 = arrayList20;
                    z2 = z5;
                }
                hashMap2 = hashMap;
                arrayList16 = arrayList11;
                arrayList18 = arrayList7;
                arrayList20 = arrayList8;
                arrayList21 = arrayList9;
                arrayList15 = arrayList10;
                arrayList17 = arrayList12;
                arrayList19 = arrayList13;
                str5 = str;
            }
            arrayList7 = arrayList18;
            hashMap = hashMap2;
            arrayList13 = arrayList19;
            arrayList10 = arrayList15;
            arrayList11 = arrayList16;
            arrayList12 = arrayList17;
            arrayList9 = arrayList21;
            arrayList8 = arrayList20;
            z2 = z5;
            hashMap2 = hashMap;
            arrayList16 = arrayList11;
            arrayList18 = arrayList7;
            arrayList20 = arrayList8;
            arrayList21 = arrayList9;
            arrayList15 = arrayList10;
            arrayList17 = arrayList12;
            arrayList19 = arrayList13;
            str5 = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:176:0x015f, code lost:
        if (r5 != null) goto L177;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C2560rg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2523qg c2523qg, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, String str) throws IOException {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String str2;
        TreeMap treeMap;
        HashMap hashMap;
        HashMap hashMap2;
        int i;
        HashMap hashMap3;
        HashMap hashMap4;
        TreeMap treeMap2;
        C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String str3;
        C2322l6 c2322l6;
        boolean z = c2523qg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        HashMap hashMap5 = new HashMap();
        HashMap hashMap6 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        TreeMap treeMap3 = new TreeMap();
        int i2 = 1;
        char c = 0;
        String str4 = "";
        C2523qg c2523qg2 = c2523qg;
        boolean z2 = z;
        String str5 = str4;
        int i3 = 0;
        String str6 = null;
        int i4 = 0;
        long j = -9223372036854775807L;
        long j2 = 0;
        boolean z3 = false;
        int i5 = 0;
        long j3 = 0;
        int i6 = 1;
        long j4 = -9223372036854775807L;
        boolean z4 = false;
        C2322l6 c2322l62 = null;
        long j5 = 0;
        long j6 = 0;
        C2322l6 c2322l63 = null;
        boolean z5 = false;
        long j7 = -1;
        String str7 = null;
        String str8 = null;
        boolean z6 = false;
        C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = null;
        long j8 = 0;
        while (true) {
            long j9 = 0;
            while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT")) {
                    arrayList2.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwww, hashMap5);
                    if ("VOD".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4)) {
                        i3 = 1;
                    } else if ("EVENT".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4)) {
                        i3 = 2;
                    }
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals("#EXT-X-I-FRAMES-ONLY")) {
                    z6 = true;
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT-X-START")) {
                    j = (long) (Double.parseDouble(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwww, Collections.emptyMap())) * 1000000.0d);
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT-X-MAP")) {
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwww, hashMap5);
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwww, hashMap5);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                        String[] split = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.split("@");
                        j7 = Long.parseLong(split[c]);
                        if (split.length > i2) {
                            j5 = Long.parseLong(split[i2]);
                        }
                    }
                    long j10 = j5;
                    long j11 = j7;
                    if (str7 != null && str8 == null) {
                        throw new ParserException("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = new C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, j10, j11, str7, str8);
                    j5 = 0;
                    j7 = -1;
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT-X-TARGETDURATION")) {
                    j4 = StopWatch.NANO_2_MILLIS * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwww);
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    j6 = Long.parseLong(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwww, Collections.emptyMap()));
                    j3 = j6;
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT-X-VERSION")) {
                    i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwww);
                } else {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT-X-DEFINE")) {
                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Kkkkkkkkkkkkkkkkkkkkkkk, hashMap5);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2523qg2.Wwwwwwwwwwwwwwwwwwwwwwwww.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        } else {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwww, hashMap5);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Kkkkkkkkkkkkkkkkkkkkkkkk, hashMap5);
                        }
                        hashMap5.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXTINF")) {
                        str5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwww, str4, hashMap5);
                        j9 = (long) (Double.parseDouble(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwww, Collections.emptyMap())) * 1000000.0d);
                        i2 = 1;
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT-X-KEY")) {
                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwww, hashMap5);
                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwww, "identity", hashMap5);
                        if (Constraint.NONE.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6)) {
                            treeMap3.clear();
                            i2 = 1;
                            c = 0;
                            c2322l63 = null;
                            str7 = null;
                            str8 = null;
                        } else {
                            str8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwww, hashMap5);
                            if (!"identity".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4)) {
                                if (str6 == null) {
                                    str6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                                }
                                C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, hashMap5);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null) {
                                    treeMap3.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                                    i2 = 1;
                                    c = 0;
                                    c2322l63 = null;
                                    str7 = null;
                                }
                            } else if ("AES-128".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6)) {
                                str7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwww, hashMap5);
                                i2 = 1;
                                c = 0;
                            }
                            i2 = 1;
                            c = 0;
                            str7 = null;
                        }
                    } else {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT-X-BYTERANGE")) {
                            String[] split2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwww, hashMap5).split("@");
                            j7 = Long.parseLong(split2[0]);
                            if (split2.length > 1) {
                                j5 = Long.parseLong(split2[1]);
                            }
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                            i5 = Integer.parseInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.indexOf(58) + 1));
                            i2 = 1;
                            c = 0;
                            z3 = true;
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals("#EXT-X-DISCONTINUITY")) {
                            i4++;
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                            if (j2 == 0) {
                                String substring = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.indexOf(58) + 1);
                                Matcher matcher = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(substring);
                                if (!matcher.matches()) {
                                    String valueOf = String.valueOf(substring);
                                    throw new ParserException(valueOf.length() != 0 ? "Invalid date/time format: ".concat(valueOf) : new String("Invalid date/time format: "));
                                }
                                if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                                    i = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                                    if ("-".equals(matcher.group(11))) {
                                        i *= -1;
                                    }
                                } else {
                                    i = 0;
                                }
                                GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                                gregorianCalendar.clear();
                                gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
                                if (!TextUtils.isEmpty(matcher.group(8))) {
                                    String valueOf2 = String.valueOf(matcher.group(8));
                                    gregorianCalendar.set(14, new BigDecimal(valueOf2.length() != 0 ? "0.".concat(valueOf2) : new String("0.")).movePointRight(3).intValue());
                                }
                                long timeInMillis = gregorianCalendar.getTimeInMillis();
                                if (i != 0) {
                                    timeInMillis -= i * 60000;
                                }
                                j2 = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeInMillis) - j8;
                                hashMap2 = hashMap5;
                                hashMap = hashMap6;
                                treeMap = treeMap3;
                                str2 = str4;
                                hashMap5 = hashMap2;
                                hashMap6 = hashMap;
                                treeMap3 = treeMap;
                                str4 = str2;
                            }
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals("#EXT-X-GAP")) {
                            i2 = 1;
                            c = 0;
                            z5 = true;
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                            i2 = 1;
                            c = 0;
                            z2 = true;
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals("#EXT-X-ENDLIST")) {
                            i2 = 1;
                            c = 0;
                            z4 = true;
                        } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("#")) {
                            String hexString = str7 == null ? null : str8 != null ? str8 : Long.toHexString(j6);
                            long j12 = j6 + 1;
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, hashMap5);
                            C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = (C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) hashMap6.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                            int i7 = (j7 > (-1L) ? 1 : (j7 == (-1L) ? 0 : -1));
                            if (i7 == 0) {
                                j5 = 0;
                            } else if (z6 && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == null) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = new C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, 0L, j5, null, null);
                                hashMap6.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                            }
                            if (c2322l63 != null || treeMap3.isEmpty()) {
                                hashMap3 = hashMap5;
                                hashMap4 = hashMap6;
                                treeMap2 = treeMap3;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                str3 = str4;
                                c2322l6 = c2322l63;
                            } else {
                                hashMap3 = hashMap5;
                                C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = (C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) treeMap3.values().toArray(new C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0]);
                                C2322l6 c2322l64 = new C2322l6(str6, true, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr);
                                if (c2322l62 == null) {
                                    C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 = new C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length];
                                    hashMap4 = hashMap6;
                                    treeMap2 = treeMap3;
                                    int i8 = 0;
                                    while (i8 < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) {
                                        C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i8];
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2[i8] = new C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww, null);
                                        i8++;
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                        c2322l64 = c2322l64;
                                        str4 = str4;
                                    }
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                    c2322l6 = c2322l64;
                                    str3 = str4;
                                    c2322l62 = new C2322l6(str6, true, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2);
                                } else {
                                    hashMap4 = hashMap6;
                                    treeMap2 = treeMap3;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                    c2322l6 = c2322l64;
                                    str3 = str4;
                                }
                            }
                            arrayList.add(new C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, str5, j9, i4, j8, c2322l6, str7, hexString, j5, j7, z5));
                            j8 += j9;
                            if (i7 != 0) {
                                j5 += j7;
                            }
                            c2523qg2 = c2523qg;
                            j6 = j12;
                            hashMap5 = hashMap3;
                            hashMap6 = hashMap4;
                            treeMap3 = treeMap2;
                            c2322l63 = c2322l6;
                            str4 = str3;
                            str5 = str4;
                            j7 = -1;
                            i2 = 1;
                            c = 0;
                            z5 = false;
                        }
                        i2 = 1;
                        c = 0;
                    }
                    hashMap2 = hashMap5;
                    hashMap = hashMap6;
                    treeMap = treeMap3;
                    str2 = str4;
                    c2523qg2 = c2523qg;
                    hashMap5 = hashMap2;
                    hashMap6 = hashMap;
                    treeMap3 = treeMap;
                    str4 = str2;
                    i2 = 1;
                    c = 0;
                }
            }
            boolean z7 = true;
            if (j2 == 0) {
                z7 = false;
            }
            return new C2560rg(i3, str, arrayList2, j, j2, z3, i5, j3, i6, j4, z2, z4, z7, c2322l62, arrayList);
        }
    }
}

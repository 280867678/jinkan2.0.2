package me.tvspark;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;

/* loaded from: classes4.dex */
public class kr0 {
    public static final List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.asList("m3u8", "m3u", "mp4", "flv", "mpeg", "hls");
    public static final List<jr0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.asList(new jr0("m3u8", Arrays.asList("application/x-mpeg", "application/octet-stream", "application/vnd.apple.mpegurl", "application/mpegurl", "application/x-mpegurl", "audio/mpegurl", "audio/x-mpegurl")), new jr0("m3u", Arrays.asList("application/x-mpeg", "application/octet-stream", "application/vnd.apple.mpegurl", "application/mpegurl", "application/x-mpegurl", "audio/mpegurl", "audio/x-mpegurl")), new jr0("mp4", Arrays.asList(DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4, "application/mp4", "video/h264")), new jr0("flv", Arrays.asList("video/x-flv")), new jr0("f4v", Arrays.asList("video/x-f4v")), new jr0("mpeg", Arrays.asList("video/vnd.mpegurl")), new jr0("html", Arrays.asList("text/html", "image/gif")));

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile("(https?:)?//.*=(https?://.*)").matcher(str);
        return matcher.find() ? matcher.group(2) : "";
    }

    public static jr0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        try {
            String path = new URL(str).getPath();
            if ("mp4".equals(path.lastIndexOf(".") < 1 ? "" : path.substring(path.lastIndexOf(".") + 1))) {
                str2 = DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4;
            }
            String lowerCase = str2.toLowerCase();
            for (jr0 jr0Var : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (!TextUtils.isEmpty(lowerCase)) {
                    for (String str3 : jr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if (lowerCase.contains(str3)) {
                            if (jr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("html") && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
                                return null;
                            }
                            return jr0Var;
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        for (String str2 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!TextUtils.isEmpty(str) && str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}

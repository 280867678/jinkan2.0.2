package me.tvspark;

import android.text.TextUtils;
import android.util.Patterns;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.data.sql.SPData;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.URIUtil;
import org.litepal.crud.callback.FindCallback;

/* loaded from: classes4.dex */
public class un0 implements sk0 {
    public static List<String> Wwwwwwwwwwwwwwwww = null;
    public static String Wwwwwwwwwwwwwwwwww = null;
    public static String Wwwwwwwwwwwwwwwwwww = null;
    public static String Wwwwwwwwwwwwwwwwwwwwww = null;
    public static String Wwwwwwwwwwwwwwwwwwwwwww = "(https|http):\\/\\/(([0-9]{1,3}\\.){3}[0-9]{1,3}|([^\\./\\?]+\\.)+[^\\./\\?]+)(:[0-9]{1,4})?/([0-9a-zA-Z_!~*'().;:@&=+$,%#-]+/){0,20}[^\\\\/:*?\"<>|,]+";
    public static String Wwwwwwwwwwwwwwwwwwwwwwww = "\\?((\\w+=[\\w!~*'().;:@+$,%#-&=]*))(&(\\w+=[\\w!~*'().;:@+$,%#-&=]*))*";
    public static String Wwwwwwwwwwwwwwwwwwwww = "magnet\\:\\?xt\\=urn\\:btih\\:(([a-fA-F0-9]){40}|[a-zA-Z0-9]{32})(&\\w+=[^&\"\\s]+)*&?";
    public static Pattern Wwwwwwwwwwwwwwwwwwww = Pattern.compile("(?i)((?:http|https|file)://|(?:inline|data|about|javascript):|(?:.*:.*@))(.*)");

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindCallback<SPData> {
        public final /* synthetic */ FindCallback Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, FindCallback findCallback) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findCallback;
        }

        @Override // org.litepal.crud.callback.FindCallback
        public void onFinish(SPData sPData) {
            FindCallback findCallback;
            SPData sPData2 = sPData;
            boolean z = false;
            if (sPData2 != null && !TextUtils.isEmpty(sPData2.getBlockWordJson())) {
                un0.Wwwwwwwwwwwwwwwww = (List) JSON.parseObject(sPData2.getBlockWordJson(), new tn0(this), new Feature[0]);
            }
            List<String> list = un0.Wwwwwwwwwwwwwwwww;
            if (list != null) {
                for (String str : list) {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(str)) {
                        findCallback = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        z = true;
                        break;
                    }
                }
            }
            findCallback = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            findCallback.onFinish(Boolean.valueOf(z));
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Wwwwwwwwwwwwwwwwwwwwwww);
        sb.append("\\.(mkv|torrent|flv|avi|rmvb|rm|asf|divx|mpg|mpeg|mpe|wmv|mp4|mkv|vob|3gp)(");
        Wwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, Wwwwwwwwwwwwwwwwwwwwwwww, ")?");
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Wwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(")|(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Wwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(")");
        Pattern.compile(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        Pattern.compile("http-equiv=\"refresh\"[^\"/>]*content=\"[^\"/>]*(url|URL)='?([^\"']*)'?");
        Pattern.compile("((http://)|(https://))?((\\d+\\.){3}(\\d+))");
        Pattern.compile("(\\w*\\.?){1}\\.(com\\.cn|net\\.cn|gov\\.cn|org\\.nz|org\\.cn|com|net|org|gov|cc|biz|info|cn|co|me)");
        Pattern.compile("(\\w*\\.?){2}\\.(com\\.cn|net\\.cn|gov\\.cn|org\\.nz|org\\.cn|com|net|org|gov|cc|biz|info|cn|co|me)");
        Pattern.compile("(\\w*\\.?){3}\\.(com\\.cn|net\\.cn|gov\\.cn|org\\.nz|org\\.cn|com|net|org|gov|cc|biz|info|cn|co|me)");
        Pattern.compile("\\.(\\w+)$");
        Pattern.compile(Wwwwwwwwwwwwwwwwwwwww);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Wwwwwwwwwwwwwwwwwwwwwww);
        sb2.append("\\.torrent(");
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, Wwwwwwwwwwwwwwwwwwwwwwww, ")?");
        Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        Pattern.compile(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(Wwwwwwwwwwwwwwwwwwwwwww);
        sb3.append("\\.(mkv|flv|avi|rmvb|rm|asf|divx|mpg|mpeg|mpe|wmv|mp4|mkv|vob|3gp)(");
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb3, Wwwwwwwwwwwwwwwwwwwwwwww, ")?");
        Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        Pattern.compile(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String trim = str.trim();
        boolean contains = trim.contains(StringUtils.SPACE);
        if (Wwwwwwwwwwwwwwwwwwww.matcher(trim).matches()) {
            return true;
        }
        return !contains && Patterns.WEB_URL.matcher(trim).matches();
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+".trim()).matcher(str.trim()).matches();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        StringBuilder sb;
        if (!TextUtils.isEmpty(str2)) {
            try {
                Matcher matcher = Pattern.compile("window.location.href\\s?=\\s?\"(.*)\";").matcher(str2);
                if (!matcher.find()) {
                    return "";
                }
                String group = matcher.group(1);
                if (group.startsWith("//")) {
                    if (str.startsWith("https")) {
                        sb = new StringBuilder();
                        sb.append(URIUtil.HTTPS_COLON);
                        sb.append(group);
                    } else {
                        sb = new StringBuilder();
                        sb.append(URIUtil.HTTP_COLON);
                        sb.append(group);
                    }
                    group = sb.toString();
                } else if (!group.startsWith("http")) {
                    group = str + group;
                }
                return group.contains("btwaf=") ? group : "";
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return !str.startsWith("http");
    }

    @NonNull
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull String str) {
        Matcher matcher = Pattern.compile("<([^>]*)>").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString().trim();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.startsWith("//")) {
                str = URIUtil.HTTP_COLON;
            } else if (str2.startsWith("http")) {
                return str2;
            }
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2);
        }
        return "";
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, FindCallback<Boolean> findCallback) {
        if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            findCallback.onFinish(false);
            return;
        }
        List<String> list = Wwwwwwwwwwwwwwwww;
        if (list == null) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, findCallback));
            return;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                findCallback.onFinish(true);
                return;
            }
        }
        findCallback.onFinish(false);
    }
}

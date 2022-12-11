package me.tvspark;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.ir0;

/* loaded from: classes4.dex */
public class mr0 {
    public SortedMap<String, lr0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 10;
    public List<Thread> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Thread {
        public int Wwwwwwwwwwwwwwwwwwwwwww = 2;
        public SortedMap<String, lr0> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SortedMap<String, lr0> sortedMap) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = sortedMap;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004d A[Catch: IOException -> 0x018f, TryCatch #1 {IOException -> 0x018f, blocks: (B:3:0x000e, B:5:0x0017, B:7:0x001f, B:9:0x0039, B:12:0x004d, B:14:0x0055, B:16:0x005d, B:18:0x0065, B:20:0x006d, B:22:0x0075, B:24:0x007d, B:26:0x0085, B:28:0x008d, B:30:0x0095, B:32:0x009d, B:34:0x00a5, B:36:0x00ad, B:38:0x00b5, B:40:0x00bd, B:43:0x00c7, B:45:0x00da, B:48:0x00e2, B:50:0x00fb, B:53:0x0103, B:55:0x010d, B:58:0x0118, B:60:0x0121, B:63:0x012d, B:66:0x013e, B:67:0x0142, B:69:0x014c, B:71:0x0154, B:73:0x015c, B:75:0x0164, B:77:0x016f, B:79:0x003e, B:81:0x0044), top: B:2:0x000e, inners: #0 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hr0 hr0Var, int i) {
            boolean z;
            String str = hr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            lr0 lr0Var = new lr0();
            lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            try {
                if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("quick_sniff", true) && str.endsWith(".m3u8")) {
                    Matcher matcher = Pattern.compile("=((http|https).*(\\.m3u8)$)").matcher(str);
                    Matcher matcher2 = Pattern.compile("((http|https).*(\\.m3u8)$)").matcher(str);
                    if (matcher.find()) {
                        str = matcher.group(1);
                    } else if (matcher2.find()) {
                        str = matcher2.group(0);
                    }
                    z = true;
                    if (!z) {
                        if (!str.contains(".js") && !str.contains(".css") && !str.contains(".ico") && !str.contains(".png") && !str.contains(".jpg") && !str.contains(".txt") && !str.contains(".woff") && !str.contains(".asp") && !str.contains(".ttf") && !str.contains(ActivityChooserModel.HISTORY_FILE_EXTENSION) && !str.contains(".apk") && !str.contains("changyan.sohu.com") && !str.contains(".ts") && !str.contains(".shtml") && !str.contains(".html")) {
                            ir0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ir0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ir0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0);
                            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                            lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                            hr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                            Map<String, List<String>> map = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (map != null && map.containsKey("Content-Type")) {
                                map.get("Content-Type").toString();
                                jr0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = kr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, map.get("Content-Type").toString());
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                    o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lr0Var);
                                    return true;
                                }
                                if (!"m3u8".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !"html".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                    JSON.toJSONString(map);
                                    if (map.containsKey("Content-Length") && map.get("Content-Length").size() > 0) {
                                        try {
                                            Long.parseLong(map.get("Content-Length").get(0));
                                        } catch (NumberFormatException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) <= RoundRectDrawableWithShadow.COS_45) {
                                    o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lr0Var);
                                    return true;
                                }
                            }
                            JSON.toJSONString(map);
                            if (i >= this.Wwwwwwwwwwwwwwwwwwwwwww - 1) {
                                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lr0Var);
                            }
                            return false;
                        }
                        lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lr0Var);
                        return true;
                    }
                    lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                    lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                    UUID.randomUUID().toString().replaceAll("-", "");
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.put(str, lr0Var);
                    o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lr0Var);
                    return true;
                }
                z = false;
                if (!z) {
                }
                lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                UUID.randomUUID().toString().replaceAll("-", "");
                this.Wwwwwwwwwwwwwwwwwwwwwwww.put(str, lr0Var);
                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lr0Var);
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                if (i >= this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lr0Var);
                }
                return false;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            Thread.currentThread().getId();
            while (mr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                try {
                    hr0 take = ApplicationC1880C.Wwwwwwwwww.take();
                    int i = 0;
                    while (mr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(take, i) && (i = i + 1) < this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Thread.currentThread().getId();
        }
    }

    public mr0(SortedMap<String, lr0> sortedMap) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sortedMap;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
        for (Thread thread : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            try {
                thread.start();
            } catch (IllegalThreadStateException unused) {
            }
        }
    }
}

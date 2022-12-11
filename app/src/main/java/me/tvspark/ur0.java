package me.tvspark;

import java.io.InputStream;
import java.util.Map;
import me.tvspark.utils.wifitransfer.NanoHTTPD;

/* loaded from: classes4.dex */
public class ur0 extends NanoHTTPD {
    public static ur0 Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public ur0(int i) {
        super(i);
    }

    @Override // me.tvspark.utils.wifitransfer.NanoHTTPD
    public NanoHTTPD.Response Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, NanoHTTPD.Method method, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        byte[] bArr = null;
        try {
            try {
                InputStream open = nn0.Wwwwwwwwwwwwwwwwwwwwwwww.getAssets().open("playm3u8.html");
                bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable unused) {
        }
        return new NanoHTTPD.Response(NanoHTTPD.Response.Status.OK, "text/html", new String(bArr).replace("#title#", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).replace("#url#", this.Wwwwwwwwwwwwwwwwwwwwwwwwwww));
    }
}

package me.tvspark;

/* loaded from: classes4.dex */
public class lr0 {
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String lowerCase = str.toLowerCase();
        if ((lowerCase.contains("m3u8") || lowerCase.contains("m3u") || lowerCase.contains("mp4")) && !lowerCase.endsWith(".js") && !lowerCase.endsWith(".css")) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }
    }
}

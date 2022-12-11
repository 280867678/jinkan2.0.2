package me.tvspark.utils.web.utils;

import android.content.res.AssetManager;
import android.text.TextUtils;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.io.IOException;
import me.tvspark.ApplicationC1880C;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class AssetsWeb {
    public AssetManager assetManager;
    public String rootPath;

    public AssetsWeb(String str) {
        this.rootPath = "web";
        if (!TextUtils.isEmpty(str)) {
            this.rootPath = str;
        }
        this.assetManager = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww.getAssets();
    }

    private String getMimeType(String str) {
        String substring = str.substring(str.lastIndexOf("."));
        return (substring.equalsIgnoreCase(".html") || substring.equalsIgnoreCase(".htm")) ? "text/html" : substring.equalsIgnoreCase(".js") ? "text/javascript" : substring.equalsIgnoreCase(".css") ? "text/css" : substring.equalsIgnoreCase(".ico") ? "image/x-icon" : "text/html";
    }

    public NanoHTTPD.Response getResponse(String str) throws IOException {
        String replaceAll = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.rootPath, str).replaceAll("/+", File.separator);
        return NanoHTTPD.newChunkedResponse(NanoHTTPD.Response.Status.OK, getMimeType(replaceAll), this.assetManager.open(replaceAll));
    }
}

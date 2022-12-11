package me.tvspark.utils.web;

import fi.iki.elonen.NanoHTTPD;
import java.util.HashMap;
import me.tvspark.k00;
import me.tvspark.utils.web.utils.AssetsWeb;
import me.tvspark.utils.web.utils.ReturnData;

/* loaded from: classes4.dex */
public class HttpServer extends NanoHTTPD {
    public AssetsWeb assetsWeb = new AssetsWeb("web");

    public HttpServer(int i) {
        super(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5 A[Catch: Exception -> 0x0199, TryCatch #0 {Exception -> 0x0199, blocks: (B:3:0x0004, B:10:0x0026, B:18:0x0052, B:30:0x008f, B:31:0x009a, B:32:0x00a5, B:33:0x0069, B:36:0x0072, B:39:0x007c, B:43:0x013b, B:45:0x0143, B:46:0x0154, B:49:0x015b, B:51:0x00b0, B:52:0x00c6, B:61:0x0107, B:63:0x0111, B:64:0x011b, B:65:0x0125, B:66:0x012f, B:67:0x00ca, B:70:0x00d4, B:73:0x00de, B:76:0x00e8, B:79:0x00f1, B:82:0x017b, B:85:0x002e, B:88:0x0038), top: B:2:0x0004 }] */
    @Override // fi.iki.elonen.NanoHTTPD
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NanoHTTPD.Response serve(NanoHTTPD.IHTTPSession iHTTPSession) {
        char c;
        ReturnData str2Decrypt;
        String uri = iHTTPSession.getUri();
        try {
            String name = iHTTPSession.getMethod().name();
            int hashCode = name.hashCode();
            char c2 = 0;
            if (hashCode == -531492226) {
                if (name.equals("OPTIONS")) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode != 70454) {
                if (hashCode == 2461856 && name.equals("POST")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (name.equals("GET")) {
                    c = 2;
                }
                c = 65535;
            }
            if (c == 0) {
                NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse("");
                newFixedLengthResponse.addHeader("Access-Control-Allow-Methods", "POST");
                newFixedLengthResponse.addHeader("Access-Control-Allow-Headers", "content-type");
                newFixedLengthResponse.addHeader("Access-Control-Allow-Origin", iHTTPSession.getHeaders().get("origin"));
                return newFixedLengthResponse;
            }
            ReturnData returnData = null;
            if (c == 1) {
                HashMap hashMap = new HashMap();
                iHTTPSession.parseBody(hashMap);
                String str = (String) hashMap.get("postData");
                switch (uri.hashCode()) {
                    case 152426945:
                        if (uri.equals("/saveIndexSource")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 222236317:
                        if (uri.equals("/str2Decrypt")) {
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 649088298:
                        if (uri.equals("/saveSeasonSource")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1243663219:
                        if (uri.equals("/saveLiveSource")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1367402357:
                        if (uri.equals("/str2Encrypt")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    str2Decrypt = new SourceController().str2Decrypt(str);
                } else if (c2 == 1) {
                    str2Decrypt = new SourceController().str2Encrypt(str);
                } else if (c2 == 2) {
                    str2Decrypt = new SourceController().saveIndexSource(str);
                } else if (c2 == 3) {
                    str2Decrypt = new SourceController().saveSeasonSource(str);
                } else if (c2 == 4) {
                    str2Decrypt = new SourceController().saveLiveSource(str);
                }
                returnData = str2Decrypt;
            } else if (c == 2) {
                iHTTPSession.getParameters();
                int hashCode2 = uri.hashCode();
                if (hashCode2 == -2116479163) {
                    if (uri.equals("/getSeasonSource")) {
                        c2 = 1;
                        if (c2 != 0) {
                        }
                    }
                    c2 = 65535;
                    if (c2 != 0) {
                    }
                } else if (hashCode2 != -1717870514) {
                    if (hashCode2 == -1460805562 && uri.equals("/getIndexSource")) {
                        if (c2 != 0) {
                            returnData = new SourceController().getIndexSource();
                        } else if (c2 == 1) {
                            returnData = new SourceController().getSeasonSource();
                        } else if (c2 == 2) {
                            returnData = new SourceController().getLiveSource();
                        }
                    }
                    c2 = 65535;
                    if (c2 != 0) {
                    }
                } else {
                    if (uri.equals("/getLiveSource")) {
                        c2 = 2;
                        if (c2 != 0) {
                        }
                    }
                    c2 = 65535;
                    if (c2 != 0) {
                    }
                }
            }
            if (returnData != null) {
                NanoHTTPD.Response newFixedLengthResponse2 = NanoHTTPD.newFixedLengthResponse(new k00().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(returnData));
                newFixedLengthResponse2.addHeader("Access-Control-Allow-Methods", "GET, POST");
                newFixedLengthResponse2.addHeader("Access-Control-Allow-Origin", iHTTPSession.getHeaders().get("origin"));
                return newFixedLengthResponse2;
            }
            if (uri.endsWith("/")) {
                uri = uri + "index.html";
            }
            return this.assetsWeb.getResponse(uri);
        } catch (Exception e) {
            return NanoHTTPD.newFixedLengthResponse(e.getMessage());
        }
    }
}

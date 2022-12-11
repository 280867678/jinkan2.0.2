package org.eclipse.jetty.client.security;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.http.HttpTokens;
import org.eclipse.jetty.util.B64Code;
import org.eclipse.jetty.util.TypeUtil;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class DigestAuthentication implements Authentication {

    /* renamed from: NC */
    public static final String f4585NC = "00000001";
    public Map details;
    public Realm securityRealm;

    public DigestAuthentication(Realm realm, Map map) {
        this.securityRealm = realm;
        this.details = map;
    }

    public static String encode(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(Integer.toHexString((bArr[i] & 240) >>> 4));
            sb.append(Integer.toHexString(bArr[i] & 15));
        }
        return sb.toString();
    }

    public String newCnonce(HttpExchange httpExchange, Realm realm, Map map) {
        try {
            return encode(MessageDigest.getInstance(LitePalSupport.MD5).digest(String.valueOf(System.currentTimeMillis()).getBytes("ISO-8859-1")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String newResponse(String str, HttpExchange httpExchange, Realm realm, Map map) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
            messageDigest.update(realm.getPrincipal().getBytes("ISO-8859-1"));
            messageDigest.update(HttpTokens.COLON);
            messageDigest.update(String.valueOf(map.get("realm")).getBytes("ISO-8859-1"));
            messageDigest.update(HttpTokens.COLON);
            messageDigest.update(realm.getCredentials().getBytes("ISO-8859-1"));
            byte[] digest = messageDigest.digest();
            messageDigest.reset();
            messageDigest.update(httpExchange.getMethod().getBytes("ISO-8859-1"));
            messageDigest.update(HttpTokens.COLON);
            messageDigest.update(httpExchange.getURI().getBytes("ISO-8859-1"));
            byte[] digest2 = messageDigest.digest();
            messageDigest.update(TypeUtil.toString(digest, 16).getBytes("ISO-8859-1"));
            messageDigest.update(HttpTokens.COLON);
            messageDigest.update(String.valueOf(map.get("nonce")).getBytes("ISO-8859-1"));
            messageDigest.update(HttpTokens.COLON);
            messageDigest.update(f4585NC.getBytes("ISO-8859-1"));
            messageDigest.update(HttpTokens.COLON);
            messageDigest.update(str.getBytes("ISO-8859-1"));
            messageDigest.update(HttpTokens.COLON);
            messageDigest.update(String.valueOf(map.get("qop")).getBytes("ISO-8859-1"));
            messageDigest.update(HttpTokens.COLON);
            messageDigest.update(TypeUtil.toString(digest2, 16).getBytes("ISO-8859-1"));
            return encode(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.eclipse.jetty.client.security.Authentication
    public void setCredentials(HttpExchange httpExchange) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Digest");
        sb.append(StringUtils.SPACE);
        sb.append("username");
        sb.append(B64Code.__pad);
        sb.append('\"');
        sb.append(this.securityRealm.getPrincipal());
        sb.append('\"');
        sb.append(", ");
        sb.append("realm");
        sb.append(B64Code.__pad);
        sb.append('\"');
        sb.append(String.valueOf(this.details.get("realm")));
        sb.append('\"');
        sb.append(", ");
        sb.append("nonce");
        sb.append(B64Code.__pad);
        sb.append('\"');
        sb.append(String.valueOf(this.details.get("nonce")));
        sb.append('\"');
        sb.append(", ");
        sb.append("uri");
        sb.append(B64Code.__pad);
        sb.append('\"');
        sb.append(httpExchange.getURI());
        sb.append('\"');
        sb.append(", ");
        sb.append("algorithm");
        sb.append(B64Code.__pad);
        sb.append(String.valueOf(this.details.get("algorithm")));
        String newCnonce = newCnonce(httpExchange, this.securityRealm, this.details);
        sb.append(", ");
        sb.append("response");
        sb.append(B64Code.__pad);
        sb.append('\"');
        sb.append(newResponse(newCnonce, httpExchange, this.securityRealm, this.details));
        sb.append('\"');
        sb.append(", ");
        sb.append("qop");
        sb.append(B64Code.__pad);
        sb.append(String.valueOf(this.details.get("qop")));
        sb.append(", ");
        sb.append("nc");
        sb.append(B64Code.__pad);
        sb.append(f4585NC);
        sb.append(", ");
        sb.append("cnonce");
        sb.append(B64Code.__pad);
        sb.append('\"');
        sb.append(newCnonce);
        sb.append('\"');
        httpExchange.setRequestHeader("Authorization", new String(sb.toString().getBytes("ISO-8859-1")));
    }
}

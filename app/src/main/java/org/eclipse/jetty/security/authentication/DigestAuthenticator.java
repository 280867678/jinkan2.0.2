package org.eclipse.jetty.security.authentication;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.BitSet;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.http.HttpTokens;
import org.eclipse.jetty.security.Authenticator;
import org.eclipse.jetty.security.ServerAuthException;
import org.eclipse.jetty.security.UserAuthentication;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.B64Code;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.security.Constraint;
import org.eclipse.jetty.util.security.Credential;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class DigestAuthenticator extends LoginAuthenticator {
    public static final Logger LOG = Log.getLogger(DigestAuthenticator.class);
    public SecureRandom _random = new SecureRandom();
    public long _maxNonceAgeMs = 60000;
    public int _maxNC = 1024;
    public ConcurrentMap<String, Nonce> _nonceMap = new ConcurrentHashMap();
    public Queue<Nonce> _nonceQueue = new ConcurrentLinkedQueue();

    /* loaded from: classes4.dex */
    public static class Digest extends Credential {
        public static final long serialVersionUID = -2484639019549527724L;
        public final String method;
        public String username = "";
        public String realm = "";
        public String nonce = "";

        /* renamed from: nc */
        public String f4592nc = "";
        public String cnonce = "";
        public String qop = "";
        public String uri = "";
        public String response = "";

        public Digest(String str) {
            this.method = str;
        }

        @Override // org.eclipse.jetty.util.security.Credential
        public boolean check(Object obj) {
            byte[] digest;
            if (obj instanceof char[]) {
                obj = new String((char[]) obj);
            }
            String obj2 = obj instanceof String ? obj : obj.toString();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
                if (obj instanceof Credential.MD5) {
                    digest = ((Credential.MD5) obj).getDigest();
                } else {
                    messageDigest.update(this.username.getBytes("ISO-8859-1"));
                    messageDigest.update(HttpTokens.COLON);
                    messageDigest.update(this.realm.getBytes("ISO-8859-1"));
                    messageDigest.update(HttpTokens.COLON);
                    messageDigest.update(obj2.getBytes("ISO-8859-1"));
                    digest = messageDigest.digest();
                }
                messageDigest.reset();
                messageDigest.update(this.method.getBytes("ISO-8859-1"));
                messageDigest.update(HttpTokens.COLON);
                messageDigest.update(this.uri.getBytes("ISO-8859-1"));
                byte[] digest2 = messageDigest.digest();
                messageDigest.update(TypeUtil.toString(digest, 16).getBytes("ISO-8859-1"));
                messageDigest.update(HttpTokens.COLON);
                messageDigest.update(this.nonce.getBytes("ISO-8859-1"));
                messageDigest.update(HttpTokens.COLON);
                messageDigest.update(this.f4592nc.getBytes("ISO-8859-1"));
                messageDigest.update(HttpTokens.COLON);
                messageDigest.update(this.cnonce.getBytes("ISO-8859-1"));
                messageDigest.update(HttpTokens.COLON);
                messageDigest.update(this.qop.getBytes("ISO-8859-1"));
                messageDigest.update(HttpTokens.COLON);
                messageDigest.update(TypeUtil.toString(digest2, 16).getBytes("ISO-8859-1"));
                return TypeUtil.toString(messageDigest.digest(), 16).equalsIgnoreCase(this.response);
            } catch (Exception e) {
                DigestAuthenticator.LOG.warn(e);
                return false;
            }
        }

        public String toString() {
            return this.username + "," + this.response;
        }
    }

    /* loaded from: classes4.dex */
    public static class Nonce {
        public final String _nonce;
        public final BitSet _seen;
        public final long _ts;

        public Nonce(String str, long j, int i) {
            this._nonce = str;
            this._ts = j;
            this._seen = new BitSet(i);
        }

        public boolean seen(int i) {
            synchronized (this) {
                if (i >= this._seen.size()) {
                    return true;
                }
                boolean z = this._seen.get(i);
                this._seen.set(i);
                return z;
            }
        }
    }

    private int checkNonce(Digest digest, Request request) {
        long timeStamp = request.getTimeStamp() - this._maxNonceAgeMs;
        while (true) {
            Nonce peek = this._nonceQueue.peek();
            if (peek == null || peek._ts >= timeStamp) {
                break;
            }
            this._nonceQueue.remove(peek);
            this._nonceMap.remove(peek._nonce);
        }
        try {
            Nonce nonce = this._nonceMap.get(digest.nonce);
            if (nonce == null) {
                return 0;
            }
            long parseLong = Long.parseLong(digest.f4592nc, 16);
            if (parseLong >= this._maxNC) {
                return 0;
            }
            return nonce.seen((int) parseLong) ? -1 : 1;
        } catch (Exception e) {
            LOG.ignore(e);
            return -1;
        }
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public String getAuthMethod() {
        return Constraint.__DIGEST_AUTH;
    }

    public long getMaxNonceAge() {
        return this._maxNonceAgeMs;
    }

    public int getMaxNonceCount() {
        return this._maxNC;
    }

    public String newNonce(Request request) {
        Nonce nonce;
        do {
            byte[] bArr = new byte[24];
            this._random.nextBytes(bArr);
            nonce = new Nonce(new String(B64Code.encode(bArr)), request.getTimeStamp(), this._maxNC);
        } while (this._nonceMap.putIfAbsent(nonce._nonce, nonce) != null);
        this._nonceQueue.add(nonce);
        return nonce._nonce;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public boolean secureResponse(ServletRequest servletRequest, ServletResponse servletResponse, boolean z, Authentication.User user) throws ServerAuthException {
        return true;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginAuthenticator, org.eclipse.jetty.security.Authenticator
    public void setConfiguration(Authenticator.AuthConfiguration authConfiguration) {
        super.setConfiguration(authConfiguration);
        String initParameter = authConfiguration.getInitParameter("maxNonceAge");
        if (initParameter != null) {
            this._maxNonceAgeMs = Long.valueOf(initParameter).longValue();
        }
    }

    public void setMaxNonceAge(long j) {
        this._maxNonceAgeMs = j;
    }

    public void setMaxNonceCount(int i) {
        this._maxNC = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00f2 A[Catch: IOException -> 0x0144, TryCatch #0 {IOException -> 0x0144, blocks: (B:18:0x0017, B:20:0x001f, B:21:0x0037, B:22:0x004a, B:24:0x0050, B:26:0x005a, B:40:0x006e, B:42:0x0076, B:44:0x0079, B:46:0x0081, B:47:0x0084, B:49:0x008c, B:50:0x008f, B:52:0x0097, B:53:0x009a, B:55:0x00a2, B:56:0x00a5, B:58:0x00ad, B:59:0x00b0, B:61:0x00b8, B:62:0x00bb, B:64:0x00c3, B:71:0x00cd, B:73:0x00d6, B:75:0x00de, B:8:0x00ec, B:10:0x00f2, B:13:0x00fa, B:15:0x0141), top: B:17:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0141 A[Catch: IOException -> 0x0144, TRY_LEAVE, TryCatch #0 {IOException -> 0x0144, blocks: (B:18:0x0017, B:20:0x001f, B:21:0x0037, B:22:0x004a, B:24:0x0050, B:26:0x005a, B:40:0x006e, B:42:0x0076, B:44:0x0079, B:46:0x0081, B:47:0x0084, B:49:0x008c, B:50:0x008f, B:52:0x0097, B:53:0x009a, B:55:0x00a2, B:56:0x00a5, B:58:0x00ad, B:59:0x00b0, B:61:0x00b8, B:62:0x00bb, B:64:0x00c3, B:71:0x00cd, B:73:0x00d6, B:75:0x00de, B:8:0x00ec, B:10:0x00f2, B:13:0x00fa, B:15:0x0141), top: B:17:0x0017 }] */
    @Override // org.eclipse.jetty.security.Authenticator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Authentication validateRequest(ServletRequest servletRequest, ServletResponse servletResponse, boolean z) throws ServerAuthException {
        if (!z) {
            return new DeferredAuthentication(this);
        }
        ae0 ae0Var = (ae0) servletRequest;
        ce0 ce0Var = (ce0) servletResponse;
        String header = ae0Var.getHeader("Authorization");
        boolean z2 = true;
        if (header != null) {
            try {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Credentials: " + header, new Object[0]);
                }
                QuotedStringTokenizer quotedStringTokenizer = new QuotedStringTokenizer(header, "=, ", true, false);
                Digest digest = new Digest(ae0Var.getMethod());
                String str = null;
                String str2 = null;
                while (quotedStringTokenizer.hasMoreTokens()) {
                    String nextToken = quotedStringTokenizer.nextToken();
                    char charAt = nextToken.length() == 1 ? nextToken.charAt(0) : (char) 0;
                    if (charAt != ' ') {
                        if (charAt != ',') {
                            if (charAt == '=') {
                                str2 = str;
                            } else if (str2 != null) {
                                if ("username".equalsIgnoreCase(str2)) {
                                    digest.username = nextToken;
                                } else if ("realm".equalsIgnoreCase(str2)) {
                                    digest.realm = nextToken;
                                } else if ("nonce".equalsIgnoreCase(str2)) {
                                    digest.nonce = nextToken;
                                } else if ("nc".equalsIgnoreCase(str2)) {
                                    digest.f4592nc = nextToken;
                                } else if ("cnonce".equalsIgnoreCase(str2)) {
                                    digest.cnonce = nextToken;
                                } else if ("qop".equalsIgnoreCase(str2)) {
                                    digest.qop = nextToken;
                                } else if ("uri".equalsIgnoreCase(str2)) {
                                    digest.uri = nextToken;
                                } else if ("response".equalsIgnoreCase(str2)) {
                                    digest.response = nextToken;
                                }
                                str2 = null;
                            }
                            str = nextToken;
                        } else {
                            str2 = null;
                        }
                    }
                }
                int checkNonce = checkNonce(digest, (Request) ae0Var);
                if (checkNonce > 0) {
                    UserIdentity login = login(digest.username, digest, servletRequest);
                    if (login != null) {
                        return new UserAuthentication(getAuthMethod(), login);
                    }
                } else if (checkNonce == 0) {
                    if (!DeferredAuthentication.isDeferred(ce0Var)) {
                        return Authentication.UNAUTHENTICATED;
                    }
                    String contextPath = ae0Var.getContextPath();
                    if (contextPath == null) {
                        contextPath = "/";
                    }
                    ce0Var.setHeader("WWW-Authenticate", "Digest realm=\"" + this._loginService.getName() + "\", domain=\"" + contextPath + "\", nonce=\"" + newNonce((Request) ae0Var) + "\", algorithm=MD5, qop=\"auth\", stale=" + z2);
                    ce0Var.sendError(401);
                    return Authentication.SEND_CONTINUE;
                }
            } catch (IOException e) {
                throw new ServerAuthException(e);
            }
        }
        z2 = false;
        if (!DeferredAuthentication.isDeferred(ce0Var)) {
        }
    }
}

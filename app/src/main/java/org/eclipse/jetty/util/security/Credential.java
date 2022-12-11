package org.eclipse.jetty.util.security;

import java.io.Serializable;
import java.security.MessageDigest;
import me.tvspark.outline;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes5.dex */
public abstract class Credential implements Serializable {
    public static final Logger LOG = Log.getLogger(Credential.class);
    public static final long serialVersionUID = -7760551052768181572L;

    /* loaded from: classes5.dex */
    public static class Crypt extends Credential {
        public static final String __TYPE = "CRYPT:";
        public static final long serialVersionUID = -2027792997664744210L;
        public final String _cooked;

        public Crypt(String str) {
            this._cooked = str.startsWith(__TYPE) ? str.substring(6) : str;
        }

        public static String crypt(String str, String str2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(__TYPE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(UnixCrypt.crypt(str2, str));
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }

        @Override // org.eclipse.jetty.util.security.Credential
        public boolean check(Object obj) {
            if (obj instanceof char[]) {
                obj = new String((char[]) obj);
            }
            if (!(obj instanceof String) && !(obj instanceof Password)) {
                Logger logger = Credential.LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't check ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" against CRYPT");
                logger.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            }
            String obj2 = obj.toString();
            String str = this._cooked;
            return str.equals(UnixCrypt.crypt(obj2, str));
        }
    }

    /* loaded from: classes5.dex */
    public static class MD5 extends Credential {
        public static final String __TYPE = "MD5:";
        public static MessageDigest __md = null;
        public static final Object __md5Lock = new Object();
        public static final long serialVersionUID = 5533846540822684240L;
        public final byte[] _digest;

        public MD5(String str) {
            this._digest = TypeUtil.parseBytes(str.startsWith(__TYPE) ? str.substring(4) : str, 16);
        }

        public static String digest(String str) {
            byte[] digest;
            try {
                synchronized (__md5Lock) {
                    if (__md == null) {
                        try {
                            __md = MessageDigest.getInstance(LitePalSupport.MD5);
                        } catch (Exception e) {
                            Credential.LOG.warn(e);
                            return null;
                        }
                    }
                    __md.reset();
                    __md.update(str.getBytes("ISO-8859-1"));
                    digest = __md.digest();
                }
                return __TYPE + TypeUtil.toString(digest, 16);
            } catch (Exception e2) {
                Credential.LOG.warn(e2);
                return null;
            }
        }

        @Override // org.eclipse.jetty.util.security.Credential
        public boolean check(Object obj) {
            byte[] digest;
            try {
                if (obj instanceof char[]) {
                    obj = new String((char[]) obj);
                }
                if (!(obj instanceof Password) && !(obj instanceof String)) {
                    if (!(obj instanceof MD5)) {
                        if (obj instanceof Credential) {
                            return ((Credential) obj).check(this);
                        } else {
                            Logger logger = Credential.LOG;
                            logger.warn("Can't check " + obj.getClass() + " against MD5", new Object[0]);
                            return false;
                        }
                    }
                    MD5 md5 = (MD5) obj;
                    if (this._digest.length != md5._digest.length) {
                        return false;
                    }
                    for (int i = 0; i < this._digest.length; i++) {
                        if (this._digest[i] != md5._digest[i]) {
                            return false;
                        }
                    }
                    return true;
                }
                synchronized (__md5Lock) {
                    if (__md == null) {
                        __md = MessageDigest.getInstance(LitePalSupport.MD5);
                    }
                    __md.reset();
                    __md.update(obj.toString().getBytes("ISO-8859-1"));
                    digest = __md.digest();
                }
                if (digest != null && digest.length == this._digest.length) {
                    for (int i2 = 0; i2 < digest.length; i2++) {
                        if (digest[i2] != this._digest[i2]) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Exception e) {
                Credential.LOG.warn(e);
                return false;
            }
        }

        public byte[] getDigest() {
            return this._digest;
        }
    }

    public static Credential getCredential(String str) {
        return str.startsWith(Crypt.__TYPE) ? new Crypt(str) : str.startsWith(MD5.__TYPE) ? new MD5(str) : new Password(str);
    }

    public abstract boolean check(Object obj);
}

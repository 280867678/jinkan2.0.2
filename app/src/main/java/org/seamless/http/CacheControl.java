package org.seamless.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;
import org.eclipse.jetty.http.HttpHeaderValues;

/* loaded from: classes5.dex */
public class CacheControl {
    public int maxAge = -1;
    public int sharedMaxAge = -1;
    public boolean noCache = false;
    public List<String> noCacheFields = new ArrayList();
    public boolean privateFlag = false;
    public List<String> privateFields = new ArrayList();
    public boolean noStore = false;
    public boolean noTransform = true;
    public boolean mustRevalidate = false;
    public boolean proxyRevalidate = false;
    public Map<String, String> cacheExtensions = new HashMap();

    private StringBuilder append(String str, StringBuilder sb) {
        if (sb.length() > 0) {
            sb.append(", ");
        }
        sb.append(str);
        return sb;
    }

    public static CacheControl valueOf(String str) throws IllegalArgumentException {
        String str2;
        List<String> privateFields;
        if (str == null) {
            return null;
        }
        CacheControl cacheControl = new CacheControl();
        for (String str3 : str.split(",")) {
            String[] split = str3.trim().split("=");
            String trim = split[0].trim();
            if (split.length > 1) {
                str2 = split[1].trim();
                if (str2.startsWith("\"")) {
                    str2 = str2.substring(1);
                }
                if (str2.endsWith("\"")) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
            } else {
                str2 = null;
            }
            String lowerCase = trim.toLowerCase();
            if (HttpHeaderValues.NO_CACHE.equals(lowerCase)) {
                cacheControl.setNoCache(true);
                if (str2 != null && !"".equals(str2)) {
                    privateFields = cacheControl.getNoCacheFields();
                    privateFields.add(str2);
                }
            } else {
                if ("private".equals(lowerCase)) {
                    cacheControl.setPrivateFlag(true);
                    if (str2 != null && !"".equals(str2)) {
                        privateFields = cacheControl.getPrivateFields();
                        privateFields.add(str2);
                    }
                } else if ("no-store".equals(lowerCase)) {
                    cacheControl.setNoStore(true);
                } else if ("max-age".equals(lowerCase)) {
                    if (str2 == null) {
                        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("CacheControl max-age header does not have a value: ", str2));
                    }
                    cacheControl.setMaxAge(Integer.valueOf(str2).intValue());
                } else if ("s-maxage".equals(lowerCase)) {
                    if (str2 == null) {
                        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("CacheControl s-maxage header does not have a value: ", str2));
                    }
                    cacheControl.setSharedMaxAge(Integer.valueOf(str2).intValue());
                } else if ("no-transform".equals(lowerCase)) {
                    cacheControl.setNoTransform(true);
                } else if ("must-revalidate".equals(lowerCase)) {
                    cacheControl.setMustRevalidate(true);
                } else if ("proxy-revalidate".equals(lowerCase)) {
                    cacheControl.setProxyRevalidate(true);
                } else if (!"public".equals(lowerCase)) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    cacheControl.getCacheExtensions().put(trim, str2);
                }
            }
        }
        return cacheControl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CacheControl.class != obj.getClass()) {
            return false;
        }
        CacheControl cacheControl = (CacheControl) obj;
        return this.maxAge == cacheControl.maxAge && this.mustRevalidate == cacheControl.mustRevalidate && this.noCache == cacheControl.noCache && this.noStore == cacheControl.noStore && this.noTransform == cacheControl.noTransform && this.privateFlag == cacheControl.privateFlag && this.proxyRevalidate == cacheControl.proxyRevalidate && this.sharedMaxAge == cacheControl.sharedMaxAge && this.cacheExtensions.equals(cacheControl.cacheExtensions) && this.noCacheFields.equals(cacheControl.noCacheFields) && this.privateFields.equals(cacheControl.privateFields);
    }

    public Map<String, String> getCacheExtensions() {
        return this.cacheExtensions;
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    public List<String> getNoCacheFields() {
        return this.noCacheFields;
    }

    public List<String> getPrivateFields() {
        return this.privateFields;
    }

    public int getSharedMaxAge() {
        return this.sharedMaxAge;
    }

    public int hashCode() {
        int hashCode = this.noCacheFields.hashCode();
        int hashCode2 = this.privateFields.hashCode();
        return this.cacheExtensions.hashCode() + ((((((((((hashCode2 + ((((hashCode + (((((this.maxAge * 31) + this.sharedMaxAge) * 31) + (this.noCache ? 1 : 0)) * 31)) * 31) + (this.privateFlag ? 1 : 0)) * 31)) * 31) + (this.noStore ? 1 : 0)) * 31) + (this.noTransform ? 1 : 0)) * 31) + (this.mustRevalidate ? 1 : 0)) * 31) + (this.proxyRevalidate ? 1 : 0)) * 31);
    }

    public boolean isMustRevalidate() {
        return this.mustRevalidate;
    }

    public boolean isNoCache() {
        return this.noCache;
    }

    public boolean isNoStore() {
        return this.noStore;
    }

    public boolean isNoTransform() {
        return this.noTransform;
    }

    public boolean isPrivateFlag() {
        return this.privateFlag;
    }

    public boolean isProxyRevalidate() {
        return this.proxyRevalidate;
    }

    public void setCacheExtensions(Map<String, String> map) {
        this.cacheExtensions = map;
    }

    public void setMaxAge(int i) {
        this.maxAge = i;
    }

    public void setMustRevalidate(boolean z) {
        this.mustRevalidate = z;
    }

    public void setNoCache(boolean z) {
        this.noCache = z;
    }

    public void setNoCacheFields(List<String> list) {
        this.noCacheFields = list;
    }

    public void setNoStore(boolean z) {
        this.noStore = z;
    }

    public void setNoTransform(boolean z) {
        this.noTransform = z;
    }

    public void setPrivateFields(List<String> list) {
        this.privateFields = list;
    }

    public void setPrivateFlag(boolean z) {
        this.privateFlag = z;
    }

    public void setProxyRevalidate(boolean z) {
        this.proxyRevalidate = z;
    }

    public void setSharedMaxAge(int i) {
        this.sharedMaxAge = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!isPrivateFlag()) {
            sb.append("public");
        }
        if (isMustRevalidate()) {
            append("must-revalidate", sb);
        }
        if (isNoTransform()) {
            append("no-transform", sb);
        }
        if (isNoStore()) {
            append("no-store", sb);
        }
        if (isProxyRevalidate()) {
            append("proxy-revalidate", sb);
        }
        if (getSharedMaxAge() > -1) {
            StringBuilder append = append("s-maxage", sb);
            append.append("=");
            append.append(getSharedMaxAge());
        }
        if (getMaxAge() > -1) {
            StringBuilder append2 = append("max-age", sb);
            append2.append("=");
            append2.append(getMaxAge());
        }
        if (isNoCache()) {
            if (getNoCacheFields().size() < 1) {
                append(HttpHeaderValues.NO_CACHE, sb);
            } else {
                for (String str : getNoCacheFields()) {
                    outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(append(HttpHeaderValues.NO_CACHE, sb), "=\"", str, "\"");
                }
            }
        }
        if (isPrivateFlag()) {
            if (getPrivateFields().size() < 1) {
                append("private", sb);
            } else {
                for (String str2 : getPrivateFields()) {
                    outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(append("private", sb), "=\"", str2, "\"");
                }
            }
        }
        for (String str3 : getCacheExtensions().keySet()) {
            String str4 = getCacheExtensions().get(str3);
            append(str3, sb);
            if (str4 != null && !"".equals(str4)) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "=\"", str4, "\"");
            }
        }
        return sb.toString();
    }
}

package org.fourthline.cling.model;

import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.TokenParser;

/* loaded from: classes5.dex */
public class ServerClientTokens {
    public static final String UNKNOWN_PLACEHOLDER = "UNKNOWN";
    public int majorVersion;
    public int minorVersion;
    public String osName;
    public String osVersion;
    public String productName;
    public String productVersion;

    public ServerClientTokens() {
        this.majorVersion = 1;
        this.minorVersion = 0;
        this.osName = System.getProperty("os.name").replaceAll("[^a-zA-Z0-9\\.\\-_]", "");
        this.osVersion = System.getProperty("os.version").replaceAll("[^a-zA-Z0-9\\.\\-_]", "");
        this.productName = UserConstants.PRODUCT_TOKEN_NAME;
        this.productVersion = "2.0";
    }

    public ServerClientTokens(int i, int i2) {
        this.majorVersion = 1;
        this.minorVersion = 0;
        this.osName = System.getProperty("os.name").replaceAll("[^a-zA-Z0-9\\.\\-_]", "");
        this.osVersion = System.getProperty("os.version").replaceAll("[^a-zA-Z0-9\\.\\-_]", "");
        this.productName = UserConstants.PRODUCT_TOKEN_NAME;
        this.productVersion = "2.0";
        this.majorVersion = i;
        this.minorVersion = i2;
    }

    public ServerClientTokens(int i, int i2, String str, String str2, String str3, String str4) {
        this.majorVersion = 1;
        this.minorVersion = 0;
        this.osName = System.getProperty("os.name").replaceAll("[^a-zA-Z0-9\\.\\-_]", "");
        this.osVersion = System.getProperty("os.version").replaceAll("[^a-zA-Z0-9\\.\\-_]", "");
        this.productName = UserConstants.PRODUCT_TOKEN_NAME;
        this.productVersion = "2.0";
        this.majorVersion = i;
        this.minorVersion = i2;
        this.osName = str;
        this.osVersion = str2;
        this.productName = str3;
        this.productVersion = str4;
    }

    public ServerClientTokens(String str, String str2) {
        this.majorVersion = 1;
        this.minorVersion = 0;
        this.osName = System.getProperty("os.name").replaceAll("[^a-zA-Z0-9\\.\\-_]", "");
        this.osVersion = System.getProperty("os.version").replaceAll("[^a-zA-Z0-9\\.\\-_]", "");
        this.productName = UserConstants.PRODUCT_TOKEN_NAME;
        this.productVersion = "2.0";
        this.productName = str;
        this.productVersion = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ServerClientTokens.class != obj.getClass()) {
            return false;
        }
        ServerClientTokens serverClientTokens = (ServerClientTokens) obj;
        return this.majorVersion == serverClientTokens.majorVersion && this.minorVersion == serverClientTokens.minorVersion && this.osName.equals(serverClientTokens.osName) && this.osVersion.equals(serverClientTokens.osVersion) && this.productName.equals(serverClientTokens.productName) && this.productVersion.equals(serverClientTokens.productVersion);
    }

    public String getHttpToken() {
        StringBuilder sb = new StringBuilder(256);
        sb.append(this.osName.indexOf(32) != -1 ? this.osName.replace(TokenParser.f4579SP, '_') : this.osName);
        sb.append('/');
        sb.append(this.osVersion.indexOf(32) != -1 ? this.osVersion.replace(TokenParser.f4579SP, '_') : this.osVersion);
        sb.append(" UPnP/");
        sb.append(this.majorVersion);
        sb.append('.');
        sb.append(this.minorVersion);
        sb.append(TokenParser.f4579SP);
        sb.append(this.productName.indexOf(32) != -1 ? this.productName.replace(TokenParser.f4579SP, '_') : this.productName);
        sb.append('/');
        sb.append(this.productVersion.indexOf(32) != -1 ? this.productVersion.replace(TokenParser.f4579SP, '_') : this.productVersion);
        return sb.toString();
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public String getOsName() {
        return this.osName;
    }

    public String getOsToken() {
        return getOsName().replaceAll(StringUtils.SPACE, "_") + "/" + getOsVersion().replaceAll(StringUtils.SPACE, "_");
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getProductToken() {
        return getProductName().replaceAll(StringUtils.SPACE, "_") + "/" + getProductVersion().replaceAll(StringUtils.SPACE, "_");
    }

    public String getProductVersion() {
        return this.productVersion;
    }

    public int hashCode() {
        return this.productVersion.hashCode() + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.productName, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.osVersion, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.osName, ((this.majorVersion * 31) + this.minorVersion) * 31, 31), 31), 31);
    }

    public void setMajorVersion(int i) {
        this.majorVersion = i;
    }

    public void setMinorVersion(int i) {
        this.minorVersion = i;
    }

    public void setOsName(String str) {
        this.osName = str;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setProductVersion(String str) {
        this.productVersion = str;
    }

    public String toString() {
        return getOsName() + "/" + getOsVersion() + " UPnP/" + getMajorVersion() + "." + getMinorVersion() + StringUtils.SPACE + getProductName() + "/" + getProductVersion();
    }
}

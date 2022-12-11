package com.arialyy.aria.core.common;

import com.arialyy.annotations.TaskEnum;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class ProxyHelper {
    public static volatile ProxyHelper INSTANCE = null;
    public static int PROXY_TYPE_DOWNLOAD = 1;
    public static int PROXY_TYPE_DOWNLOAD_GROUP = 2;
    public static int PROXY_TYPE_DOWNLOAD_GROUP_SUB = 5;
    public static int PROXY_TYPE_M3U8_PEER = 4;
    public static int PROXY_TYPE_UPLOAD = 3;
    public Map<String, Set<Integer>> mProxyCache = new ConcurrentHashMap();

    private boolean checkProxyExist(String str, String str2) {
        String concat = str.concat(str2);
        try {
            if (getClass().getClassLoader().loadClass(concat) != null) {
                return true;
            }
            Class.forName(concat);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static ProxyHelper getInstance() {
        if (INSTANCE == null) {
            synchronized (ProxyHelper.class) {
                INSTANCE = new ProxyHelper();
            }
        }
        return INSTANCE;
    }

    public Set<Integer> checkProxyType(Class cls) {
        String name = cls.getName();
        Set<Integer> set = this.mProxyCache.get(cls.getName());
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        if (checkProxyExist(name, TaskEnum.DOWNLOAD_GROUP.proxySuffix)) {
            hashSet.add(Integer.valueOf(PROXY_TYPE_DOWNLOAD_GROUP));
        }
        if (checkProxyExist(name, TaskEnum.DOWNLOAD.proxySuffix)) {
            hashSet.add(Integer.valueOf(PROXY_TYPE_DOWNLOAD));
        }
        if (checkProxyExist(name, TaskEnum.UPLOAD.proxySuffix)) {
            hashSet.add(Integer.valueOf(PROXY_TYPE_UPLOAD));
        }
        if (checkProxyExist(name, TaskEnum.M3U8_PEER.proxySuffix)) {
            hashSet.add(Integer.valueOf(PROXY_TYPE_M3U8_PEER));
        }
        if (checkProxyExist(name, TaskEnum.DOWNLOAD_GROUP_SUB.proxySuffix)) {
            hashSet.add(Integer.valueOf(PROXY_TYPE_DOWNLOAD_GROUP_SUB));
        }
        if (!hashSet.isEmpty()) {
            this.mProxyCache.put(cls.getName(), hashSet);
        }
        return hashSet;
    }
}

package org.eclipse.jetty.util;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: classes5.dex */
public class Loader {
    public static String getClassPath(ClassLoader classLoader) throws Exception {
        StringBuilder sb = new StringBuilder();
        while (classLoader != null && (classLoader instanceof URLClassLoader)) {
            URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
            if (uRLs != null) {
                for (URL url : uRLs) {
                    File file = Resource.newResource(url).getFile();
                    if (file != null && file.exists()) {
                        if (sb.length() > 0) {
                            sb.append(File.pathSeparatorChar);
                        }
                        sb.append(file.getAbsolutePath());
                    }
                }
            }
            classLoader = classLoader.getParent();
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0027 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002d -> B:10:0x001f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002f -> B:10:0x001f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static URL getResource(Class<?> cls, String str, boolean z) {
        ClassLoader classLoader;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        URL url = null;
        while (url == null && contextClassLoader != null) {
            url = contextClassLoader.getResource(str);
            contextClassLoader = (url != null || !z) ? null : contextClassLoader.getParent();
        }
        if (cls != null) {
            classLoader = cls.getClassLoader();
            while (url == null && classLoader != null) {
                url = classLoader.getResource(str);
                if (url == null && z) {
                    classLoader = classLoader.getParent();
                }
            }
            return url != null ? ClassLoader.getSystemResource(str) : url;
        }
        classLoader = null;
        while (url == null) {
            url = classLoader.getResource(str);
            if (url == null) {
                classLoader = classLoader.getParent();
            }
            classLoader = null;
            while (url == null) {
            }
        }
        if (url != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0038 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x004a -> B:17:0x0030). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x004c -> B:17:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ResourceBundle getResourceBundle(Class<?> cls, String str, boolean z, Locale locale) throws MissingResourceException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        HashSet hashSet = new HashSet();
        ResourceBundle resourceBundle = null;
        MissingResourceException missingResourceException = null;
        while (resourceBundle == null && contextClassLoader != null && hashSet.add(contextClassLoader)) {
            try {
                resourceBundle = ResourceBundle.getBundle(str, locale, contextClassLoader);
            } catch (MissingResourceException e) {
                if (missingResourceException == null) {
                    missingResourceException = e;
                }
            }
            contextClassLoader = (resourceBundle != null || !z) ? null : contextClassLoader.getParent();
        }
        ClassLoader classLoader = cls.getClassLoader();
        while (resourceBundle == null && classLoader != null && hashSet.add(classLoader)) {
            try {
            } catch (MissingResourceException e2) {
                if (missingResourceException == null) {
                    missingResourceException = e2;
                }
            }
            resourceBundle = ResourceBundle.getBundle(str, locale, classLoader);
            if (resourceBundle == null && z) {
                classLoader = classLoader.getParent();
            }
            classLoader = null;
            while (resourceBundle == null) {
                resourceBundle = ResourceBundle.getBundle(str, locale, classLoader);
                if (resourceBundle == null) {
                    classLoader = classLoader.getParent();
                }
                classLoader = null;
                while (resourceBundle == null) {
                }
            }
        }
        ClassLoader classLoader2 = Loader.class.getClassLoader();
        if (resourceBundle == null && classLoader2 != null && hashSet.add(classLoader2)) {
            try {
                resourceBundle = ResourceBundle.getBundle(str, locale);
            } catch (MissingResourceException e3) {
                if (missingResourceException == null) {
                    missingResourceException = e3;
                }
            }
        }
        if (resourceBundle != null) {
            return resourceBundle;
        }
        throw missingResourceException;
    }

    public static Class loadClass(Class cls, String str) throws ClassNotFoundException {
        return loadClass(cls, str, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0038 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x004a -> B:17:0x0030). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x004c -> B:17:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Class loadClass(Class cls, String str, boolean z) throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        HashSet hashSet = new HashSet();
        Class<?> cls2 = null;
        ClassNotFoundException classNotFoundException = null;
        while (cls2 == null && contextClassLoader != null && hashSet.add(contextClassLoader)) {
            try {
                cls2 = contextClassLoader.loadClass(str);
            } catch (ClassNotFoundException e) {
                if (classNotFoundException == null) {
                    classNotFoundException = e;
                }
            }
            contextClassLoader = (cls2 != null || !z) ? null : contextClassLoader.getParent();
        }
        ClassLoader classLoader = cls.getClassLoader();
        while (cls2 == null && classLoader != null && hashSet.add(classLoader)) {
            try {
            } catch (ClassNotFoundException e2) {
                if (classNotFoundException == null) {
                    classNotFoundException = e2;
                }
            }
            cls2 = classLoader.loadClass(str);
            if (cls2 == null && z) {
                classLoader = classLoader.getParent();
            }
            classLoader = null;
            while (cls2 == null) {
                cls2 = classLoader.loadClass(str);
                if (cls2 == null) {
                    classLoader = classLoader.getParent();
                }
                classLoader = null;
                while (cls2 == null) {
                }
            }
        }
        ClassLoader classLoader2 = Loader.class.getClassLoader();
        if (cls2 == null && classLoader2 != null && hashSet.add(classLoader2)) {
            try {
                cls2 = Class.forName(str);
            } catch (ClassNotFoundException e3) {
                if (classNotFoundException == null) {
                    classNotFoundException = e3;
                }
            }
        }
        if (cls2 != null) {
            return cls2;
        }
        throw classNotFoundException;
    }
}

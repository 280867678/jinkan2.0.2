package org.eclipse.jetty.http;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.BufferCache;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class MimeTypes {
    public static final BufferCache CACHE;
    public static final String FORM_ENCODED = "application/x-www-form-urlencoded";
    public static final BufferCache.CachedBuffer FORM_ENCODED_BUFFER;
    public static final int FORM_ENCODED_ORDINAL = 1;
    public static final String MESSAGE_HTTP = "message/http";
    public static final BufferCache.CachedBuffer MESSAGE_HTTP_BUFFER;
    public static final int MESSAGE_HTTP_ORDINAL = 2;
    public static final String MULTIPART_BYTERANGES = "multipart/byteranges";
    public static final BufferCache.CachedBuffer MULTIPART_BYTERANGES_BUFFER;
    public static final int MULTIPART_BYTERANGES_ORDINAL = 3;
    public static final String TEXT_HTML = "text/html";
    public static final String TEXT_HTML_8859_1 = "text/html;charset=ISO-8859-1";
    public static final BufferCache.CachedBuffer TEXT_HTML_8859_1_BUFFER;
    public static final int TEXT_HTML_8859_1_ORDINAL = 8;
    public static final BufferCache.CachedBuffer TEXT_HTML_BUFFER;
    public static final int TEXT_HTML_ORDINAL = 4;
    public static final String TEXT_HTML_UTF_8 = "text/html;charset=UTF-8";
    public static final BufferCache.CachedBuffer TEXT_HTML_UTF_8_BUFFER;
    public static final int TEXT_HTML_UTF_8_ORDINAL = 11;
    public static final String TEXT_HTML__8859_1 = "text/html; charset=ISO-8859-1";
    public static final BufferCache.CachedBuffer TEXT_HTML__8859_1_BUFFER;
    public static final String TEXT_HTML__UTF_8 = "text/html; charset=UTF-8";
    public static final BufferCache.CachedBuffer TEXT_HTML__UTF_8_BUFFER;
    public static final String TEXT_JSON = "text/json";
    public static final BufferCache.CachedBuffer TEXT_JSON_BUFFER;
    public static final int TEXT_JSON_ORDINAL = 7;
    public static final String TEXT_JSON_UTF_8 = "text/json;charset=UTF-8";
    public static final BufferCache.CachedBuffer TEXT_JSON_UTF_8_BUFFER;
    public static final int TEXT_JSON_UTF_8_ORDINAL = 14;
    public static final String TEXT_JSON__UTF_8 = "text/json; charset=UTF-8";
    public static final BufferCache.CachedBuffer TEXT_JSON__UTF_8_BUFFER;
    public static final String TEXT_PLAIN = "text/plain";
    public static final String TEXT_PLAIN_8859_1 = "text/plain;charset=ISO-8859-1";
    public static final BufferCache.CachedBuffer TEXT_PLAIN_8859_1_BUFFER;
    public static final int TEXT_PLAIN_8859_1_ORDINAL = 9;
    public static final BufferCache.CachedBuffer TEXT_PLAIN_BUFFER;
    public static final int TEXT_PLAIN_ORDINAL = 5;
    public static final String TEXT_PLAIN_UTF_8 = "text/plain;charset=UTF-8";
    public static final BufferCache.CachedBuffer TEXT_PLAIN_UTF_8_BUFFER;
    public static final int TEXT_PLAIN_UTF_8_ORDINAL = 12;
    public static final String TEXT_PLAIN__8859_1 = "text/plain; charset=ISO-8859-1";
    public static final BufferCache.CachedBuffer TEXT_PLAIN__8859_1_BUFFER;
    public static final String TEXT_PLAIN__UTF_8 = "text/plain; charset=UTF-8";
    public static final BufferCache.CachedBuffer TEXT_PLAIN__UTF_8_BUFFER;
    public static final String TEXT_XML = "text/xml";
    public static final String TEXT_XML_8859_1 = "text/xml;charset=ISO-8859-1";
    public static final BufferCache.CachedBuffer TEXT_XML_8859_1_BUFFER;
    public static final int TEXT_XML_8859_1_ORDINAL = 10;
    public static final BufferCache.CachedBuffer TEXT_XML_BUFFER;
    public static final int TEXT_XML_ORDINAL = 6;
    public static final String TEXT_XML_UTF_8 = "text/xml;charset=UTF-8";
    public static final BufferCache.CachedBuffer TEXT_XML_UTF_8_BUFFER;
    public static final int TEXT_XML_UTF_8_ORDINAL = 13;
    public static final String TEXT_XML__8859_1 = "text/xml; charset=ISO-8859-1";
    public static final BufferCache.CachedBuffer TEXT_XML__8859_1_BUFFER;
    public static final String TEXT_XML__UTF_8 = "text/xml; charset=UTF-8";
    public static final BufferCache.CachedBuffer TEXT_XML__UTF_8_BUFFER;
    public Map _mimeMap;
    public static final Logger LOG = Log.getLogger(MimeTypes.class);
    public static int __index = 15;
    public static final Map __dftMimeMap = new HashMap();
    public static final Map __encodings = new HashMap();

    static {
        BufferCache bufferCache = new BufferCache();
        CACHE = bufferCache;
        FORM_ENCODED_BUFFER = bufferCache.add("application/x-www-form-urlencoded", 1);
        MESSAGE_HTTP_BUFFER = CACHE.add(MESSAGE_HTTP, 2);
        MULTIPART_BYTERANGES_BUFFER = CACHE.add(MULTIPART_BYTERANGES, 3);
        TEXT_HTML_BUFFER = CACHE.add("text/html", 4);
        TEXT_PLAIN_BUFFER = CACHE.add("text/plain", 5);
        TEXT_XML_BUFFER = CACHE.add(TEXT_XML, 6);
        TEXT_JSON_BUFFER = CACHE.add(TEXT_JSON, 7);
        TEXT_HTML_8859_1_BUFFER = CACHE.add(TEXT_HTML_8859_1, 8);
        TEXT_PLAIN_8859_1_BUFFER = CACHE.add(TEXT_PLAIN_8859_1, 9);
        TEXT_XML_8859_1_BUFFER = CACHE.add(TEXT_XML_8859_1, 10);
        TEXT_HTML_UTF_8_BUFFER = CACHE.add(TEXT_HTML_UTF_8, 11);
        TEXT_PLAIN_UTF_8_BUFFER = CACHE.add(TEXT_PLAIN_UTF_8, 12);
        TEXT_XML_UTF_8_BUFFER = CACHE.add(TEXT_XML_UTF_8, 13);
        TEXT_JSON_UTF_8_BUFFER = CACHE.add(TEXT_JSON_UTF_8, 14);
        TEXT_HTML__8859_1_BUFFER = CACHE.add(TEXT_HTML__8859_1, 8);
        TEXT_PLAIN__8859_1_BUFFER = CACHE.add(TEXT_PLAIN__8859_1, 9);
        TEXT_XML__8859_1_BUFFER = CACHE.add(TEXT_XML__8859_1, 10);
        TEXT_HTML__UTF_8_BUFFER = CACHE.add(TEXT_HTML__UTF_8, 11);
        TEXT_PLAIN__UTF_8_BUFFER = CACHE.add(TEXT_PLAIN__UTF_8, 12);
        TEXT_XML__UTF_8_BUFFER = CACHE.add(TEXT_XML__UTF_8, 13);
        TEXT_JSON__UTF_8_BUFFER = CACHE.add(TEXT_JSON__UTF_8, 14);
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("org/eclipse/jetty/http/mime");
            Enumeration<String> keys = bundle.getKeys();
            while (keys.hasMoreElements()) {
                String nextElement = keys.nextElement();
                __dftMimeMap.put(StringUtil.asciiToLowerCase(nextElement), normalizeMimeType(bundle.getString(nextElement)));
            }
        } catch (MissingResourceException e) {
            LOG.warn(e.toString(), new Object[0]);
            LOG.debug(e);
        }
        try {
            ResourceBundle bundle2 = ResourceBundle.getBundle("org/eclipse/jetty/http/encoding");
            Enumeration<String> keys2 = bundle2.getKeys();
            while (keys2.hasMoreElements()) {
                Buffer normalizeMimeType = normalizeMimeType(keys2.nextElement());
                __encodings.put(normalizeMimeType, bundle2.getString(normalizeMimeType.toString()));
            }
        } catch (MissingResourceException e2) {
            LOG.warn(e2.toString(), new Object[0]);
            LOG.debug(e2);
        }
        TEXT_HTML_BUFFER.setAssociate("ISO-8859-1", TEXT_HTML_8859_1_BUFFER);
        TEXT_HTML_BUFFER.setAssociate("ISO_8859_1", TEXT_HTML_8859_1_BUFFER);
        TEXT_HTML_BUFFER.setAssociate("iso-8859-1", TEXT_HTML_8859_1_BUFFER);
        TEXT_PLAIN_BUFFER.setAssociate("ISO-8859-1", TEXT_PLAIN_8859_1_BUFFER);
        TEXT_PLAIN_BUFFER.setAssociate("ISO_8859_1", TEXT_PLAIN_8859_1_BUFFER);
        TEXT_PLAIN_BUFFER.setAssociate("iso-8859-1", TEXT_PLAIN_8859_1_BUFFER);
        TEXT_XML_BUFFER.setAssociate("ISO-8859-1", TEXT_XML_8859_1_BUFFER);
        TEXT_XML_BUFFER.setAssociate("ISO_8859_1", TEXT_XML_8859_1_BUFFER);
        TEXT_XML_BUFFER.setAssociate("iso-8859-1", TEXT_XML_8859_1_BUFFER);
        TEXT_HTML_BUFFER.setAssociate("UTF-8", TEXT_HTML_UTF_8_BUFFER);
        TEXT_HTML_BUFFER.setAssociate(StringUtil.__UTF8Alt, TEXT_HTML_UTF_8_BUFFER);
        TEXT_HTML_BUFFER.setAssociate("utf8", TEXT_HTML_UTF_8_BUFFER);
        TEXT_HTML_BUFFER.setAssociate("utf-8", TEXT_HTML_UTF_8_BUFFER);
        TEXT_PLAIN_BUFFER.setAssociate("UTF-8", TEXT_PLAIN_UTF_8_BUFFER);
        TEXT_PLAIN_BUFFER.setAssociate(StringUtil.__UTF8Alt, TEXT_PLAIN_UTF_8_BUFFER);
        TEXT_PLAIN_BUFFER.setAssociate("utf8", TEXT_PLAIN_UTF_8_BUFFER);
        TEXT_PLAIN_BUFFER.setAssociate("utf-8", TEXT_PLAIN_UTF_8_BUFFER);
        TEXT_XML_BUFFER.setAssociate("UTF-8", TEXT_XML_UTF_8_BUFFER);
        TEXT_XML_BUFFER.setAssociate(StringUtil.__UTF8Alt, TEXT_XML_UTF_8_BUFFER);
        TEXT_XML_BUFFER.setAssociate("utf8", TEXT_XML_UTF_8_BUFFER);
        TEXT_XML_BUFFER.setAssociate("utf-8", TEXT_XML_UTF_8_BUFFER);
        TEXT_JSON_BUFFER.setAssociate("UTF-8", TEXT_JSON_UTF_8_BUFFER);
        TEXT_JSON_BUFFER.setAssociate(StringUtil.__UTF8Alt, TEXT_JSON_UTF_8_BUFFER);
        TEXT_JSON_BUFFER.setAssociate("utf8", TEXT_JSON_UTF_8_BUFFER);
        TEXT_JSON_BUFFER.setAssociate("utf-8", TEXT_JSON_UTF_8_BUFFER);
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x00a7, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCharsetFromContentType(Buffer buffer) {
        if (buffer instanceof BufferCache.CachedBuffer) {
            switch (((BufferCache.CachedBuffer) buffer).getOrdinal()) {
                case 8:
                case 9:
                case 10:
                    return "ISO-8859-1";
                case 11:
                case 12:
                case 13:
                case 14:
                    return "UTF-8";
            }
        }
        int index = buffer.getIndex();
        int putIndex = buffer.putIndex();
        char c = 0;
        boolean z = false;
        int i = 0;
        while (index < putIndex) {
            byte peek = buffer.peek(index);
            if (!z || c == '\n') {
                switch (c) {
                    case 0:
                        if (34 != peek) {
                            if (59 != peek) {
                                break;
                            } else {
                                c = 1;
                                break;
                            }
                        }
                        z = true;
                        break;
                    case 1:
                        if (99 != peek) {
                            if (32 == peek) {
                                break;
                            }
                            c = 0;
                            break;
                        } else {
                            c = 2;
                            break;
                        }
                    case 2:
                        if (104 == peek) {
                            c = 3;
                            break;
                        }
                        c = 0;
                        break;
                    case 3:
                        if (97 == peek) {
                            c = 4;
                            break;
                        }
                        c = 0;
                        break;
                    case 4:
                        if (114 == peek) {
                            c = 5;
                            break;
                        }
                        c = 0;
                        break;
                    case 5:
                        if (115 == peek) {
                            c = 6;
                            break;
                        }
                        c = 0;
                        break;
                    case 6:
                        if (101 == peek) {
                            c = 7;
                            break;
                        }
                        c = 0;
                        break;
                    case 7:
                        if (116 == peek) {
                            c = '\b';
                            break;
                        }
                        c = 0;
                        break;
                    case '\b':
                        if (61 != peek) {
                            if (32 == peek) {
                                break;
                            }
                            c = 0;
                            break;
                        } else {
                            c = '\t';
                            break;
                        }
                    case '\t':
                        if (32 == peek) {
                            break;
                        } else if (34 != peek) {
                            i = index;
                            c = '\n';
                            break;
                        } else {
                            i = index + 1;
                            c = '\n';
                            z = true;
                            break;
                        }
                    case '\n':
                        if ((!z && (59 == peek || 32 == peek)) || (z && 34 == peek)) {
                            return CACHE.lookup(buffer.peek(i, index - i)).toString("UTF-8");
                        }
                }
            } else if (34 == peek) {
                z = false;
            }
            index++;
        }
        return c == '\n' ? CACHE.lookup(buffer.peek(i, index - i)).toString("UTF-8") : (String) __encodings.get(buffer);
    }

    public static synchronized Buffer normalizeMimeType(String str) {
        BufferCache.CachedBuffer cachedBuffer;
        synchronized (MimeTypes.class) {
            cachedBuffer = CACHE.get(str);
            if (cachedBuffer == null) {
                BufferCache bufferCache = CACHE;
                int i = __index;
                __index = i + 1;
                cachedBuffer = bufferCache.add(str, i);
            }
        }
        return cachedBuffer;
    }

    public void addMimeMapping(String str, String str2) {
        if (this._mimeMap == null) {
            this._mimeMap = new HashMap();
        }
        this._mimeMap.put(StringUtil.asciiToLowerCase(str), normalizeMimeType(str2));
    }

    public Buffer getMimeByExtension(String str) {
        Buffer buffer = null;
        if (str != null) {
            int i = -1;
            while (buffer == null) {
                i = str.indexOf(".", i + 1);
                if (i < 0 || i >= str.length()) {
                    break;
                }
                String asciiToLowerCase = StringUtil.asciiToLowerCase(str.substring(i + 1));
                Map map = this._mimeMap;
                if (map != null) {
                    buffer = (Buffer) map.get(asciiToLowerCase);
                }
                if (buffer == null) {
                    buffer = (Buffer) __dftMimeMap.get(asciiToLowerCase);
                }
            }
        }
        if (buffer == null) {
            Map map2 = this._mimeMap;
            if (map2 != null) {
                buffer = (Buffer) map2.get("*");
            }
            return buffer == null ? (Buffer) __dftMimeMap.get("*") : buffer;
        }
        return buffer;
    }

    public synchronized Map getMimeMap() {
        return this._mimeMap;
    }

    public void setMimeMap(Map map) {
        if (map == null) {
            this._mimeMap = null;
            return;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put(entry.getKey(), normalizeMimeType(entry.getValue().toString()));
        }
        this._mimeMap = hashMap;
    }
}

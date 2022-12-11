package org.eclipse.jetty.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import me.tvspark.me0;
import me.tvspark.outline;
import org.apache.commons.lang3.SystemUtils;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class MultiPartInputStream {
    public static final Logger LOG = Log.getLogger(MultiPartInputStream.class);
    public static final MultipartConfigElement __DEFAULT_MULTIPART_CONFIG = new MultipartConfigElement(System.getProperty(SystemUtils.JAVA_IO_TMPDIR_KEY));
    public MultipartConfigElement _config;
    public String _contentType;
    public File _contextTmpDir;
    public boolean _deleteOnExit;
    public InputStream _in;
    public MultiMap<String> _parts;
    public File _tmpDir;

    /* loaded from: classes5.dex */
    public static class Base64InputStream extends InputStream {
        public byte[] _buffer;
        public ReadLineInputStream _in;
        public String _line;
        public int _pos;

        public Base64InputStream(ReadLineInputStream readLineInputStream) {
            this._in = readLineInputStream;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            byte[] bArr = this._buffer;
            if (bArr == null || this._pos >= bArr.length) {
                String readLine = this._in.readLine();
                this._line = readLine;
                if (readLine == null) {
                    return -1;
                }
                if (readLine.startsWith(MultiPartWriter.__DASHDASH)) {
                    this._buffer = (this._line + "\r\n").getBytes();
                } else if (this._line.length() == 0) {
                    this._buffer = "\r\n".getBytes();
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((this._line.length() * 4) / 3) + 2);
                    B64Code.decode(this._line, byteArrayOutputStream);
                    byteArrayOutputStream.write(13);
                    byteArrayOutputStream.write(10);
                    this._buffer = byteArrayOutputStream.toByteArray();
                }
                this._pos = 0;
            }
            byte[] bArr2 = this._buffer;
            int i = this._pos;
            this._pos = i + 1;
            return bArr2[i];
        }
    }

    /* loaded from: classes5.dex */
    public class MultiPart implements me0 {
        public ByteArrayOutputStream2 _bout;
        public String _contentType;
        public File _file;
        public String _filename;
        public MultiMap<String> _headers;
        public String _name;
        public OutputStream _out;
        public long _size = 0;
        public boolean _temporary = true;

        public MultiPart(String str, String str2) throws IOException {
            this._name = str;
            this._filename = str2;
        }

        public void cleanUp() throws IOException {
            File file;
            if (!this._temporary || (file = this._file) == null || !file.exists()) {
                return;
            }
            this._file.delete();
        }

        public void close() throws IOException {
            this._out.close();
        }

        public void createFile() throws IOException {
            OutputStream outputStream;
            File createTempFile = File.createTempFile("MultiPart", "", MultiPartInputStream.this._tmpDir);
            this._file = createTempFile;
            createTempFile.setReadable(false, false);
            this._file.setReadable(true, true);
            if (MultiPartInputStream.this._deleteOnExit) {
                this._file.deleteOnExit();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this._file));
            if (this._size > 0 && (outputStream = this._out) != null) {
                outputStream.flush();
                this._bout.writeTo(bufferedOutputStream);
                this._out.close();
                this._bout = null;
            }
            this._out = bufferedOutputStream;
        }

        public void delete() throws IOException {
            File file = this._file;
            if (file == null || !file.exists()) {
                return;
            }
            this._file.delete();
        }

        public byte[] getBytes() {
            ByteArrayOutputStream2 byteArrayOutputStream2 = this._bout;
            if (byteArrayOutputStream2 != null) {
                return byteArrayOutputStream2.toByteArray();
            }
            return null;
        }

        public String getContentDispositionFilename() {
            return this._filename;
        }

        public String getContentType() {
            return this._contentType;
        }

        public File getFile() {
            return this._file;
        }

        public String getHeader(String str) {
            if (str == null) {
                return null;
            }
            return (String) this._headers.getValue(str.toLowerCase(Locale.ENGLISH), 0);
        }

        public Collection<String> getHeaderNames() {
            return this._headers.keySet();
        }

        public Collection<String> getHeaders(String str) {
            return this._headers.getValues(str);
        }

        public InputStream getInputStream() throws IOException {
            return this._file != null ? new BufferedInputStream(new FileInputStream(this._file)) : new ByteArrayInputStream(this._bout.getBuf(), 0, this._bout.size());
        }

        public String getName() {
            return this._name;
        }

        public long getSize() {
            return this._size;
        }

        public void open() throws IOException {
            String str = this._filename;
            if (str != null && str.trim().length() > 0) {
                createFile();
                return;
            }
            ByteArrayOutputStream2 byteArrayOutputStream2 = new ByteArrayOutputStream2();
            this._bout = byteArrayOutputStream2;
            this._out = byteArrayOutputStream2;
        }

        public void setContentType(String str) {
            this._contentType = str;
        }

        public void setHeaders(MultiMap<String> multiMap) {
            this._headers = multiMap;
        }

        public void write(int i) throws IOException {
            if (MultiPartInputStream.this._config.getMaxFileSize() <= 0 || this._size + 1 <= MultiPartInputStream.this._config.getMaxFileSize()) {
                if (MultiPartInputStream.this._config.getFileSizeThreshold() > 0 && this._size + 1 > MultiPartInputStream.this._config.getFileSizeThreshold() && this._file == null) {
                    createFile();
                }
                this._out.write(i);
                this._size++;
                return;
            }
            throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Multipart Mime part "), this._name, " exceeds max filesize"));
        }

        public void write(String str) throws IOException {
            BufferedOutputStream bufferedOutputStream;
            File file = this._file;
            this._temporary = false;
            if (file != null) {
                File file2 = new File(MultiPartInputStream.this._tmpDir, str);
                if (!this._file.renameTo(file2)) {
                    return;
                }
                this._file = file2;
                return;
            }
            this._file = new File(MultiPartInputStream.this._tmpDir, str);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this._file));
                try {
                    this._bout.writeTo(bufferedOutputStream);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    this._bout = null;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    this._bout = null;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (MultiPartInputStream.this._config.getMaxFileSize() <= 0 || this._size + i2 <= MultiPartInputStream.this._config.getMaxFileSize()) {
                if (MultiPartInputStream.this._config.getFileSizeThreshold() > 0 && this._size + i2 > MultiPartInputStream.this._config.getFileSizeThreshold() && this._file == null) {
                    createFile();
                }
                this._out.write(bArr, i, i2);
                this._size += i2;
                return;
            }
            throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Multipart Mime part "), this._name, " exceeds max filesize"));
        }
    }

    public MultiPartInputStream(InputStream inputStream, String str, MultipartConfigElement multipartConfigElement, File file) {
        this._in = new ReadLineInputStream(inputStream);
        this._contentType = str;
        this._config = multipartConfigElement;
        this._contextTmpDir = file;
        if (file == null) {
            this._contextTmpDir = new File(System.getProperty(SystemUtils.JAVA_IO_TMPDIR_KEY));
        }
        if (this._config == null) {
            this._config = new MultipartConfigElement(this._contextTmpDir.getAbsolutePath());
        }
    }

    private String filenameValue(String str) {
        String trim = str.substring(str.indexOf(61) + 1).trim();
        if (trim.matches(".??[a-z,A-Z]\\:\\\\[^\\\\].*")) {
            char charAt = trim.charAt(0);
            if (charAt == '\"' || charAt == '\'') {
                trim = trim.substring(1);
            }
            char charAt2 = trim.charAt(trim.length() - 1);
            return (charAt2 == '\"' || charAt2 == '\'') ? trim.substring(0, trim.length() - 1) : trim;
        }
        return QuotedStringTokenizer.unquoteOnly(trim, true);
    }

    private String value(String str, boolean z) {
        return QuotedStringTokenizer.unquoteOnly(str.substring(str.indexOf(61) + 1).trim());
    }

    public void deleteParts() throws MultiException {
        Collection<me0> parsedParts = getParsedParts();
        MultiException multiException = new MultiException();
        Iterator<me0> it = parsedParts.iterator();
        while (it.hasNext()) {
            try {
                ((MultiPart) it.next()).cleanUp();
            } catch (Exception e) {
                multiException.add(e);
            }
        }
        this._parts.clear();
        multiException.ifExceptionThrowMulti();
    }

    public Collection<me0> getParsedParts() {
        MultiMap<String> multiMap = this._parts;
        if (multiMap == null) {
            return Collections.emptyList();
        }
        Collection<Object> values = multiMap.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            arrayList.addAll(LazyList.getList(obj, false));
        }
        return arrayList;
    }

    public me0 getPart(String str) throws IOException, ServletException {
        parse();
        return (me0) this._parts.getValue(str, 0);
    }

    public Collection<me0> getParts() throws IOException, ServletException {
        parse();
        Collection<Object> values = this._parts.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            arrayList.addAll(LazyList.getList(obj, false));
        }
        return arrayList;
    }

    public boolean isDeleteOnExit() {
        return this._deleteOnExit;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0183, code lost:
        r2 = new org.eclipse.jetty.util.MultiPartInputStream.Base64InputStream((org.eclipse.jetty.util.ReadLineInputStream) r22._in);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x019f, code lost:
        r5 = -2;
        r7 = false;
        r10 = false;
        r11 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01a3, code lost:
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01a5, code lost:
        if (r11 == r5) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01a7, code lost:
        r5 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01af, code lost:
        if (r5 == (-1)) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01b1, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01bf, code lost:
        if (r22._config.getMaxRequestSize() <= 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01c9, code lost:
        if (r8 > r22._config.getMaxRequestSize()) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01e9, code lost:
        throw new java.lang.IllegalStateException("Request exceeds maxRequestSize (" + r22._config.getMaxRequestSize() + ")");
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01ea, code lost:
        r11 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01ec, code lost:
        if (r5 == 13) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01ee, code lost:
        if (r5 != 10) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01f3, code lost:
        if (r13 < 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01f6, code lost:
        if (r13 >= r6.length) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01fa, code lost:
        if (r5 != r6[r13]) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0201, code lost:
        if (r7 == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0203, code lost:
        r4.write(13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0208, code lost:
        if (r10 == false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x020a, code lost:
        r4.write(10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x020d, code lost:
        if (r13 <= 0) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x020f, code lost:
        r4.write(r6, 0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0213, code lost:
        r4.write(r5);
        r5 = -2;
        r13 = -1;
        r7 = false;
        r11 = -2;
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01fc, code lost:
        r13 = r13 + 1;
        r5 = -2;
        r11 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01f0, code lost:
        r11 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x021c, code lost:
        if (r5 != r11) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x021e, code lost:
        r2.mark(1);
        r11 = r2.read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0226, code lost:
        if (r11 == 10) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0228, code lost:
        r2.reset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x022c, code lost:
        if (r13 <= 0) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0231, code lost:
        if (r13 < (r6.length - 2)) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0238, code lost:
        if (r7 == false) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x023a, code lost:
        r4.write(13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x023f, code lost:
        if (r10 == false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0241, code lost:
        r4.write(10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0244, code lost:
        r4.write(r6, 0, r13);
        r13 = -1;
        r7 = false;
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x024b, code lost:
        if (r13 > 0) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x024e, code lost:
        if (r5 != (-1)) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0251, code lost:
        if (r7 == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0253, code lost:
        r4.write(13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0258, code lost:
        if (r10 == false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x025a, code lost:
        r4.write(10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x025f, code lost:
        if (r5 != 13) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0261, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0264, code lost:
        if (r5 == 10) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0266, code lost:
        if (r11 != 10) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0269, code lost:
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x026e, code lost:
        if (r11 != 10) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0270, code lost:
        r11 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0272, code lost:
        r5 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x026c, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0263, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0276, code lost:
        if (r13 != r6.length) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0278, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x027c, code lost:
        r5 = true;
        r7 = false;
        r3 = r16;
        r4 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0236, code lost:
        if (r13 != (r6.length - 1)) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x022b, code lost:
        r11 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0284, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0285, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0288, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x01a9, code lost:
        r5 = r2.read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0193, code lost:
        if ("quoted-printable".equalsIgnoreCase(r12) == false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0195, code lost:
        r2 = new org.eclipse.jetty.util.MultiPartInputStream.C30121(r22, r22._in);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x019d, code lost:
        r2 = r22._in;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x027c, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0290, code lost:
        throw new java.io.IOException("Missing content-disposition");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0110, code lost:
        if (r10 == null) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0112, code lost:
        r13 = new org.eclipse.jetty.util.QuotedStringTokenizer(r10, r4, r7, r5);
        r5 = null;
        r7 = null;
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x011e, code lost:
        if (r13.hasMoreTokens() == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0120, code lost:
        r14 = r13.nextToken().trim();
        r17 = r4;
        r4 = r14.toLowerCase(java.util.Locale.ENGLISH);
        r18 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0138, code lost:
        if (r14.startsWith("form-data") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x013a, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0159, code lost:
        r4 = r17;
        r13 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0143, code lost:
        if (r4.startsWith("name=") == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0145, code lost:
        r7 = value(r14, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0152, code lost:
        if (r4.startsWith("filename=") == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0154, code lost:
        r5 = filenameValue(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x015e, code lost:
        r17 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0160, code lost:
        if (r10 != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0164, code lost:
        if (r7 != null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0168, code lost:
        r4 = new org.eclipse.jetty.util.MultiPartInputStream.MultiPart(r22, r7, r5);
        r4.setHeaders(r2);
        r4.setContentType(r11);
        r22._parts.add(r7, r4);
        r4.open();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0181, code lost:
        if ("base64".equalsIgnoreCase(r12) == false) goto L193;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parse() throws IOException, ServletException {
        File file;
        String str;
        if (this._parts != null) {
            return;
        }
        this._parts = new MultiMap<>();
        String str2 = this._contentType;
        if (str2 == null || !str2.startsWith("multipart/form-data")) {
            return;
        }
        String str3 = "";
        if (this._config.getLocation() != null && !str3.equals(this._config.getLocation())) {
            file = new File(this._config.getLocation());
            if (!file.isAbsolute()) {
                file = new File(this._contextTmpDir, this._config.getLocation());
            }
        } else {
            file = this._contextTmpDir;
        }
        this._tmpDir = file;
        if (!this._tmpDir.exists()) {
            this._tmpDir.mkdirs();
        }
        int indexOf = this._contentType.indexOf("boundary=");
        String str4 = ";";
        boolean z = true;
        if (indexOf >= 0) {
            int indexOf2 = this._contentType.indexOf(str4, indexOf);
            if (indexOf2 < 0) {
                indexOf2 = this._contentType.length();
            }
            str = QuotedStringTokenizer.unquote(value(this._contentType.substring(indexOf, indexOf2), true).trim());
        } else {
            str = str3;
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MultiPartWriter.__DASHDASH, str);
        byte[] bytes = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + MultiPartWriter.__DASHDASH).getBytes("ISO-8859-1");
        boolean z2 = false;
        try {
            String readLine = ((ReadLineInputStream) this._in).readLine();
            if (readLine == null) {
                throw new IOException("Missing content for multipart request");
            }
            String trim = readLine.trim();
            boolean z3 = false;
            while (trim != null && !trim.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                if (!z3) {
                    LOG.warn("Badly formatted multipart request", new Object[0]);
                    z3 = true;
                }
                trim = ((ReadLineInputStream) this._in).readLine();
                if (trim != null) {
                    trim = trim.trim();
                }
            }
            if (trim == null || trim.length() == 0) {
                throw new IOException("Missing initial multi part boundary");
            }
            boolean z4 = false;
            long j = 0;
            loop1: while (!z4) {
                MultiMap<String> multiMap = new MultiMap<>();
                String str5 = null;
                String str6 = null;
                String str7 = null;
                while (true) {
                    String readLine2 = ((ReadLineInputStream) this._in).readLine();
                    if (readLine2 == null) {
                        break loop1;
                    }
                    String str8 = str3;
                    if (str3.equals(readLine2)) {
                        break;
                    }
                    String str9 = str4;
                    j += readLine2.length();
                    if (this._config.getMaxRequestSize() > 0 && j > this._config.getMaxRequestSize()) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Request exceeds maxRequestSize (");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this._config.getMaxRequestSize());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(")");
                        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    }
                    int indexOf3 = readLine2.indexOf(58, 0);
                    if (indexOf3 > 0) {
                        String lowerCase = readLine2.substring(0, indexOf3).trim().toLowerCase(Locale.ENGLISH);
                        String trim2 = readLine2.substring(indexOf3 + 1, readLine2.length()).trim();
                        multiMap.put(lowerCase, trim2);
                        if (lowerCase.equalsIgnoreCase("content-disposition")) {
                            str5 = trim2;
                        }
                        if (lowerCase.equalsIgnoreCase("content-type")) {
                            str6 = trim2;
                        }
                        if (lowerCase.equals("content-transfer-encoding")) {
                            str7 = trim2;
                        }
                    }
                    z = true;
                    z2 = false;
                    str3 = str8;
                    str4 = str9;
                }
            }
            if (!z4) {
                throw new IOException("Incomplete parts");
            }
        } catch (IOException e) {
            LOG.warn("Badly formatted multipart request", new Object[0]);
            throw e;
        }
    }

    public void setDeleteOnExit(boolean z) {
        this._deleteOnExit = z;
    }
}

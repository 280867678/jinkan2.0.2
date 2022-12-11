package com.efs.sdk.base.core.util.p015b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.core.util.C0769b;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.http.IHttpUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Map;
import org.eclipse.jetty.http.HttpHeaderValues;

/* renamed from: com.efs.sdk.base.core.util.b.a */
/* loaded from: classes3.dex */
public final class C0770a implements IHttpUtil {

    /* renamed from: com.efs.sdk.base.core.util.b.a$a */
    /* loaded from: classes3.dex */
    public static class C0771a {

        /* renamed from: a */
        public static final C0770a f322a = new C0770a((byte) 0);
    }

    public C0770a() {
    }

    public /* synthetic */ C0770a(byte b) {
        this();
    }

    /* renamed from: a */
    public static C0770a m4026a() {
        return C0771a.f322a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v9 */
    @NonNull
    /* renamed from: a */
    public static HttpResponse m4024a(@NonNull String str, @Nullable Map<String, String> map, @Nullable File file, @Nullable byte[] bArr) {
        FileInputStream fileInputStream;
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        String str2;
        FileInputStream fileInputStream4;
        HttpResponse httpResponse = new HttpResponse();
        ?? r4 = 0;
        r4 = null;
        r4 = null;
        r4 = null;
        ?? r42 = null;
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection httpURLConnection2 = null;
        HttpURLConnection httpURLConnection3 = null;
        try {
            try {
                HttpURLConnection m4025a = m4025a(str, map);
                try {
                    m4025a.setRequestMethod("POST");
                    m4025a.setRequestProperty("Connection", HttpHeaderValues.CLOSE);
                    m4025a.setRequestProperty("Content-Type", "multipart/form-data;boundary=----WebKitFormBoundaryP0Rfzlf32iRoMhmb");
                    outputStream = m4025a.getOutputStream();
                    try {
                        dataOutputStream = new DataOutputStream(outputStream);
                        try {
                            dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb\r\n");
                            if (bArr == 0) {
                                if (file != null && file.exists()) {
                                    dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
                                    dataOutputStream.writeBytes("\r\n");
                                    fileInputStream4 = new FileInputStream(file);
                                    try {
                                        byte[] bArr2 = new byte[4096];
                                        while (true) {
                                            int read = fileInputStream4.read(bArr2);
                                            if (read == -1) {
                                                break;
                                            }
                                            dataOutputStream.write(bArr2, 0, read);
                                        }
                                        r42 = fileInputStream4;
                                    } catch (SocketTimeoutException e) {
                                        e = e;
                                        httpURLConnection = m4025a;
                                        fileInputStream3 = fileInputStream4;
                                        httpResponse.setHttpCode(-3);
                                        str2 = "post file '" + str + "' error";
                                        r4 = httpURLConnection;
                                        bArr = fileInputStream3;
                                        Log.m4065e("efs.util.http", str2, e);
                                        m4022b(r4);
                                        C0769b.m4037a(outputStream);
                                        C0769b.m4037a(dataOutputStream);
                                        C0769b.m4037a((Closeable) bArr);
                                        httpResponse.setReqUrl(str);
                                        return httpResponse;
                                    } catch (UnknownHostException e2) {
                                        e = e2;
                                        httpURLConnection2 = m4025a;
                                        fileInputStream2 = fileInputStream4;
                                        httpResponse.setHttpCode(-2);
                                        str2 = "post file '" + str + "' error， maybe network is disconnect";
                                        r4 = httpURLConnection2;
                                        bArr = fileInputStream2;
                                        Log.m4065e("efs.util.http", str2, e);
                                        m4022b(r4);
                                        C0769b.m4037a(outputStream);
                                        C0769b.m4037a(dataOutputStream);
                                        C0769b.m4037a((Closeable) bArr);
                                        httpResponse.setReqUrl(str);
                                        return httpResponse;
                                    } catch (Throwable th) {
                                        e = th;
                                        httpURLConnection3 = m4025a;
                                        fileInputStream = fileInputStream4;
                                        str2 = "post file '" + str + "' error";
                                        r4 = httpURLConnection3;
                                        bArr = fileInputStream;
                                        Log.m4065e("efs.util.http", str2, e);
                                        m4022b(r4);
                                        C0769b.m4037a(outputStream);
                                        C0769b.m4037a(dataOutputStream);
                                        C0769b.m4037a((Closeable) bArr);
                                        httpResponse.setReqUrl(str);
                                        return httpResponse;
                                    }
                                }
                                return httpResponse;
                            }
                            dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"f\"\r\n");
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.write(bArr, 0, bArr.length);
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb--\r\n");
                            httpResponse = m4023a(m4025a);
                        } catch (SocketTimeoutException e3) {
                            e = e3;
                            fileInputStream4 = r42;
                        } catch (UnknownHostException e4) {
                            e = e4;
                            fileInputStream4 = r42;
                        } catch (Throwable th2) {
                            e = th2;
                            fileInputStream4 = r42;
                        }
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    } catch (Throwable th3) {
                        e = th3;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    }
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                } catch (UnknownHostException e8) {
                    e = e8;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                } catch (Throwable th4) {
                    e = th4;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                }
            } finally {
                m4022b(r4);
                C0769b.m4037a(outputStream);
                C0769b.m4037a(dataOutputStream);
                C0769b.m4037a((Closeable) bArr);
            }
        } catch (SocketTimeoutException e9) {
            e = e9;
            fileInputStream3 = null;
            outputStream = null;
            dataOutputStream = null;
        } catch (UnknownHostException e10) {
            e = e10;
            fileInputStream2 = null;
            outputStream = null;
            dataOutputStream = null;
        } catch (Throwable th5) {
            e = th5;
            fileInputStream = null;
            outputStream = null;
            dataOutputStream = null;
        }
        httpResponse.setReqUrl(str);
        return httpResponse;
    }

    /* renamed from: a */
    public static HttpResponse m4023a(HttpURLConnection httpURLConnection) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        HttpResponse httpResponse = new HttpResponse();
        if (httpURLConnection == null) {
            return httpResponse;
        }
        try {
            httpResponse.setHttpCode(httpURLConnection.getResponseCode());
            inputStream = httpURLConnection.getInputStream();
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            Log.m4065e("efs.util.http", "get response error", th);
                            return httpResponse;
                        } finally {
                            C0769b.m4037a(inputStream);
                            C0769b.m4037a(byteArrayOutputStream);
                        }
                    }
                }
                httpResponse.data = byteArrayOutputStream.toString();
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStream = null;
        }
        return httpResponse;
    }

    /* renamed from: a */
    public static HttpURLConnection m4025a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        if (map == null) {
            map = Collections.emptyMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }

    /* renamed from: b */
    public static void m4022b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                C0769b.m4037a(httpURLConnection.getInputStream());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse get(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        String str2;
        HttpResponse httpResponse = new HttpResponse();
        while (true) {
            if (0 >= 3) {
                break;
            }
            httpURLConnection = null;
            try {
                try {
                    httpURLConnection = m4025a(str, map);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestProperty("Connection", HttpHeaderValues.CLOSE);
                    httpURLConnection.connect();
                    httpResponse = m4023a(httpURLConnection);
                    m4022b(httpURLConnection);
                    break;
                } catch (UnknownHostException e) {
                    e = e;
                    httpResponse.setHttpCode(-2);
                    str2 = "get request '" + str + "' error， maybe network is disconnect";
                    Log.m4065e("efs.util.http", str2, e);
                    m4022b(httpURLConnection);
                }
            } catch (SocketTimeoutException e2) {
                e = e2;
                try {
                    httpResponse.setHttpCode(-3);
                    str2 = "post file '" + str + "' error";
                    Log.m4065e("efs.util.http", str2, e);
                    m4022b(httpURLConnection);
                }
            }
            m4022b(httpURLConnection);
        }
        httpResponse.setReqUrl(str);
        return httpResponse;
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse post(@NonNull String str, @Nullable Map<String, String> map, @NonNull File file) {
        return m4024a(str, map, file, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v7 */
    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse post(@NonNull String str, @Nullable Map<String, String> map, @NonNull byte[] bArr) {
        HttpURLConnection httpURLConnection;
        String str2;
        HttpURLConnection httpURLConnection2;
        HttpResponse httpResponse = new HttpResponse();
        OutputStream outputStream = null;
        try {
            try {
                httpURLConnection = m4025a(str, map);
                try {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Connection", HttpHeaderValues.CLOSE);
                    outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    httpResponse = m4023a(httpURLConnection);
                    httpURLConnection2 = httpURLConnection;
                } catch (SocketTimeoutException e) {
                    e = e;
                    httpResponse.setHttpCode(-3);
                    str2 = "post file '" + str + "' error";
                    map = httpURLConnection;
                    Log.m4065e("efs.util.http", str2, e);
                    httpURLConnection2 = map;
                    httpResponse.setReqUrl(str);
                    return httpResponse;
                } catch (UnknownHostException e2) {
                    e = e2;
                    httpResponse.setHttpCode(-2);
                    str2 = "post data to '" + str + "' error， maybe network is disconnect";
                    map = httpURLConnection;
                    Log.m4065e("efs.util.http", str2, e);
                    httpURLConnection2 = map;
                    httpResponse.setReqUrl(str);
                    return httpResponse;
                } catch (Throwable th) {
                    e = th;
                    str2 = "post data '" + str + "' error";
                    map = httpURLConnection;
                    Log.m4065e("efs.util.http", str2, e);
                    httpURLConnection2 = map;
                    httpResponse.setReqUrl(str);
                    return httpResponse;
                }
            } finally {
                C0769b.m4037a(outputStream);
                m4022b(map);
            }
        } catch (SocketTimeoutException e3) {
            e = e3;
            httpURLConnection = null;
        } catch (UnknownHostException e4) {
            e = e4;
            httpURLConnection = null;
        } catch (Throwable th2) {
            e = th2;
            httpURLConnection = null;
        }
        httpResponse.setReqUrl(str);
        return httpResponse;
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse postAsFile(String str, Map<String, String> map, byte[] bArr) {
        return m4024a(str, map, null, bArr);
    }
}

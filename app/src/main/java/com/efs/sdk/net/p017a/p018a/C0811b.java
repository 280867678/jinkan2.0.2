package com.efs.sdk.net.p017a.p018a;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.p017a.C0809a;
import com.efs.sdk.net.p017a.C0824b;
import com.efs.sdk.net.p017a.p018a.AbstractC0816f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* renamed from: com.efs.sdk.net.a.a.b */
/* loaded from: classes3.dex */
public final class C0811b {

    /* renamed from: a */
    public Map<String, Long> f434a = new HashMap();

    /* renamed from: a */
    public static long m3962a(AbstractC0816f.AbstractC0817a abstractC0817a) {
        try {
            byte[] mo3953d = abstractC0817a.mo3953d();
            if (mo3953d == null) {
                return 0L;
            }
            return mo3953d.length;
        } catch (IOException | OutOfMemoryError e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: a */
    public static ByteArrayOutputStream m3961a(InputStream inputStream, C0824b c0824b, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                Log.m4066e("NetTrace-Interceptor", "parse and save body, e is ".concat(String.valueOf(e)));
            }
        }
        byteArrayOutputStream.flush();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BufferedReader bufferedReader = "gzip".equals(str) ? new BufferedReader(new InputStreamReader(new GZIPInputStream(byteArrayInputStream))) : new BufferedReader(new InputStreamReader(byteArrayInputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine + '\n');
        }
        c0824b.f458i = sb.toString().getBytes().length;
        return byteArrayOutputStream;
    }

    /* renamed from: a */
    public static InputStream m3960a(String str, String str2, String str3, InputStream inputStream) {
        Log.m4062i("NetTrace-Interceptor", "save interpret response stream");
        C0824b m3967a = C0809a.m3968a().m3967a(str);
        m3967a.f457h = str2;
        if (str2 != null) {
            if (str2.contains("text") || str2.contains("json")) {
                ByteArrayOutputStream m3961a = m3961a(inputStream, m3967a, str3);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(m3961a.toByteArray());
                try {
                    m3961a.close();
                } catch (IOException e) {
                    Log.m4066e("NetTrace-Interceptor", "save interpret response stream, e is ".concat(String.valueOf(e)));
                }
                return byteArrayInputStream;
            }
        }
        m3967a.f458i = 0L;
        return inputStream;
    }
}

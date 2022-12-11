package org.seamless.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.seamless.util.p061io.C3387IO;

/* loaded from: classes5.dex */
public class HttpFetch {

    /* loaded from: classes5.dex */
    public interface RepresentationFactory<E> {
        Representation<E> createRepresentation(URLConnection uRLConnection, InputStream inputStream) throws IOException;
    }

    public static <E> Representation<E> fetch(URL url, int i, int i2, RepresentationFactory<E> representationFactory) throws IOException {
        return fetch(url, "GET", i, i2, representationFactory);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <E> Representation<E> fetch(URL url, String str, int i, int i2, RepresentationFactory<E> representationFactory) throws IOException {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2 = null;
        inputStream2 = null;
        HttpURLConnection httpURLConnection3 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } catch (Throwable th) {
                th = th;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                throw th;
            }
        } catch (IOException e) {
            e = e;
            inputStream = null;
        }
        try {
            httpURLConnection.setRequestMethod(str);
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i2);
            inputStream2 = httpURLConnection.getInputStream();
            Representation<E> createRepresentation = representationFactory.createRepresentation(httpURLConnection, inputStream2);
            if (inputStream2 != null) {
                inputStream2.close();
            }
            return createRepresentation;
        } catch (IOException e2) {
            e = e2;
            InputStream inputStream3 = inputStream2;
            httpURLConnection3 = httpURLConnection2;
            inputStream = inputStream3;
            try {
                if (httpURLConnection3 == null) {
                    throw e;
                }
                throw new IOException("Fetching resource failed, returned status code: " + httpURLConnection3.getResponseCode());
            } catch (Throwable th2) {
                inputStream2 = inputStream;
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
        }
    }

    public static Representation<byte[]> fetchBinary(URL url) throws IOException {
        return fetchBinary(url, 500, 500);
    }

    public static Representation<byte[]> fetchBinary(URL url, int i, int i2) throws IOException {
        return fetch(url, i, i2, new RepresentationFactory<byte[]>() { // from class: org.seamless.http.HttpFetch.1
            @Override // org.seamless.http.HttpFetch.RepresentationFactory
            public Representation<byte[]> createRepresentation(URLConnection uRLConnection, InputStream inputStream) throws IOException {
                return new Representation<>(uRLConnection, C3387IO.readBytes(inputStream));
            }
        });
    }

    public static Representation<String> fetchString(URL url, int i, int i2) throws IOException {
        return fetch(url, i, i2, new RepresentationFactory<String>() { // from class: org.seamless.http.HttpFetch.2
            @Override // org.seamless.http.HttpFetch.RepresentationFactory
            public Representation<String> createRepresentation(URLConnection uRLConnection, InputStream inputStream) throws IOException {
                return new Representation<>(uRLConnection, C3387IO.readLines(inputStream));
            }
        });
    }

    public static void validate(URL url) throws IOException {
        fetch(url, "HEAD", 500, 500, new RepresentationFactory() { // from class: org.seamless.http.HttpFetch.3
            @Override // org.seamless.http.HttpFetch.RepresentationFactory
            public Representation createRepresentation(URLConnection uRLConnection, InputStream inputStream) throws IOException {
                return new Representation(uRLConnection, null);
            }
        });
    }
}

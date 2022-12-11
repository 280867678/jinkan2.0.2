package retrofit2;

import java.io.IOException;
import java.util.regex.Pattern;
import me.tvspark.outline;
import me.tvspark.uw0;
import me.tvspark.vw0;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: classes5.dex */
public final class RequestBuilder {
    public static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    public final HttpUrl baseUrl;
    public RequestBody body;
    public MediaType contentType;
    public FormBody.Builder formBuilder;
    public final boolean hasBody;
    public final Headers.Builder headersBuilder;
    public final String method;
    public MultipartBody.Builder multipartBuilder;
    public String relativeUrl;
    public final Request.Builder requestBuilder = new Request.Builder();
    public HttpUrl.Builder urlBuilder;
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* loaded from: classes5.dex */
    public static class ContentTypeOverridingRequestBody extends RequestBody {
        public final MediaType contentType;
        public final RequestBody delegate;

        public ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.delegate = requestBody;
            this.contentType = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.contentType;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(vw0 vw0Var) throws IOException {
            this.delegate.writeTo(vw0Var);
        }
    }

    public RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = httpUrl;
        this.relativeUrl = str2;
        this.contentType = mediaType;
        this.hasBody = z;
        this.headersBuilder = headers != null ? headers.newBuilder() : new Headers.Builder();
        if (z2) {
            this.formBuilder = new FormBody.Builder();
        } else if (!z3) {
        } else {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.multipartBuilder = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    public static String canonicalizeForPath(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                uw0 uw0Var = new uw0();
                uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 0, i);
                canonicalizeForPath(uw0Var, str, i, length, z);
                return uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    public static void canonicalizeForPath(uw0 uw0Var, String str, int i, int i2, boolean z) {
        uw0 uw0Var2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (uw0Var2 == null) {
                        uw0Var2 = new uw0();
                    }
                    uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(codePointAt);
                    while (!uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        int readByte = uw0Var2.readByte() & 255;
                        uw0Var.mo4963writeByte(37);
                        uw0Var.mo4963writeByte((int) HEX_DIGITS[(readByte >> 4) & 15]);
                        uw0Var.mo4963writeByte((int) HEX_DIGITS[readByte & 15]);
                    }
                } else {
                    uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    public void addFormField(String str, String str2, boolean z) {
        if (z) {
            this.formBuilder.addEncoded(str, str2);
        } else {
            this.formBuilder.add(str, str2);
        }
    }

    public void addHeader(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.headersBuilder.add(str, str2);
            return;
        }
        try {
            this.contentType = MediaType.get(str2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Malformed content type: ", str2), e);
        }
    }

    public void addHeaders(Headers headers) {
        this.headersBuilder.addAll(headers);
    }

    public void addPart(Headers headers, RequestBody requestBody) {
        this.multipartBuilder.addPart(headers, requestBody);
    }

    public void addPart(MultipartBody.Part part) {
        this.multipartBuilder.addPart(part);
    }

    public void addPathParam(String str, String str2, boolean z) {
        if (this.relativeUrl != null) {
            String canonicalizeForPath = canonicalizeForPath(str2, z);
            String str3 = this.relativeUrl;
            String replace = str3.replace("{" + str + "}", canonicalizeForPath);
            if (PATH_TRAVERSAL.matcher(replace).matches()) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("@Path parameters shouldn't perform path traversal ('.' or '..'): ", str2));
            }
            this.relativeUrl = replace;
            return;
        }
        throw new AssertionError();
    }

    public void addQueryParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.baseUrl.newBuilder(str3);
            this.urlBuilder = newBuilder;
            if (newBuilder == null) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Malformed URL. Base: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.baseUrl);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", Relative: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.relativeUrl);
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            this.relativeUrl = null;
        }
        if (z) {
            this.urlBuilder.addEncodedQueryParameter(str, str2);
        } else {
            this.urlBuilder.addQueryParameter(str, str2);
        }
    }

    public <T> void addTag(Class<T> cls, T t) {
        this.requestBuilder.tag(cls, t);
    }

    public Request.Builder get() {
        HttpUrl resolve;
        HttpUrl.Builder builder = this.urlBuilder;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = this.baseUrl.resolve(this.relativeUrl);
            if (resolve == null) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Malformed URL. Base: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.baseUrl);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", Relative: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.relativeUrl);
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        ContentTypeOverridingRequestBody contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            FormBody.Builder builder2 = this.formBuilder;
            if (builder2 != null) {
                contentTypeOverridingRequestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.multipartBuilder;
                if (builder3 != null) {
                    contentTypeOverridingRequestBody = builder3.build();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.contentType;
        if (mediaType != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, mediaType);
            } else {
                this.headersBuilder.add("Content-Type", mediaType.toString());
            }
        }
        return this.requestBuilder.url(resolve).headers(this.headersBuilder.build()).method(this.method, contentTypeOverridingRequestBody);
    }

    public void setBody(RequestBody requestBody) {
        this.body = requestBody;
    }

    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }
}

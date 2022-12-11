package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import me.tvspark.outline;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* loaded from: classes5.dex */
public abstract class ParameterHandler<T> {

    /* loaded from: classes5.dex */
    public static final class Body<T> extends ParameterHandler<T> {
        public final Converter<T, RequestBody> converter;
        public final Method method;

        /* renamed from: p */
        public final int f5027p;

        public Body(Method method, int i, Converter<T, RequestBody> converter) {
            this.method = method;
            this.f5027p = i;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) {
            if (t != null) {
                try {
                    requestBuilder.setBody(this.converter.convert(t));
                    return;
                } catch (IOException e) {
                    Method method = this.method;
                    int i = this.f5027p;
                    throw Utils.parameterError(method, e, i, "Unable to convert " + t + " to RequestBody", new Object[0]);
                }
            }
            throw Utils.parameterError(this.method, this.f5027p, "Body parameter value must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes5.dex */
    public static final class Field<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final String name;
        public final Converter<T, String> valueConverter;

        public Field(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addFormField(this.name, convert, this.encoded);
        }
    }

    /* loaded from: classes5.dex */
    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        public final boolean encoded;
        public final Method method;

        /* renamed from: p */
        public final int f5028p;
        public final Converter<T, String> valueConverter;

        public FieldMap(Method method, int i, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.f5028p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key == null) {
                        throw Utils.parameterError(this.method, this.f5028p, "Field map contained null key.", new Object[0]);
                    }
                    T value = entry.getValue();
                    if (value == null) {
                        throw Utils.parameterError(this.method, this.f5028p, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Field map contained null value for key '", key, "'."), new Object[0]);
                    }
                    String convert = this.valueConverter.convert(value);
                    if (convert == null) {
                        Method method = this.method;
                        int i = this.f5028p;
                        throw Utils.parameterError(method, i, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                    }
                    requestBuilder.addFormField(key, convert, this.encoded);
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f5028p, "Field map was null.", new Object[0]);
        }
    }

    /* loaded from: classes5.dex */
    public static final class Header<T> extends ParameterHandler<T> {
        public final String name;
        public final Converter<T, String> valueConverter;

        public Header(String str, Converter<T, String> converter) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addHeader(this.name, convert);
        }
    }

    /* loaded from: classes5.dex */
    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        public final Method method;

        /* renamed from: p */
        public final int f5029p;
        public final Converter<T, String> valueConverter;

        public HeaderMap(Method method, int i, Converter<T, String> converter) {
            this.method = method;
            this.f5029p = i;
            this.valueConverter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key == null) {
                        throw Utils.parameterError(this.method, this.f5029p, "Header map contained null key.", new Object[0]);
                    }
                    T value = entry.getValue();
                    if (value == null) {
                        throw Utils.parameterError(this.method, this.f5029p, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Header map contained null value for key '", key, "'."), new Object[0]);
                    }
                    requestBuilder.addHeader(key, this.valueConverter.convert(value));
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f5029p, "Header map was null.", new Object[0]);
        }
    }

    /* loaded from: classes5.dex */
    public static final class Headers extends ParameterHandler<okhttp3.Headers> {
        public final Method method;

        /* renamed from: p */
        public final int f5030p;

        public Headers(Method method, int i) {
            this.method = method;
            this.f5030p = i;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, okhttp3.Headers headers) {
            if (headers != null) {
                requestBuilder.addHeaders(headers);
                return;
            }
            throw Utils.parameterError(this.method, this.f5030p, "Headers parameter must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes5.dex */
    public static final class Part<T> extends ParameterHandler<T> {
        public final Converter<T, RequestBody> converter;
        public final okhttp3.Headers headers;
        public final Method method;

        /* renamed from: p */
        public final int f5031p;

        public Part(Method method, int i, okhttp3.Headers headers, Converter<T, RequestBody> converter) {
            this.method = method;
            this.f5031p = i;
            this.headers = headers;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.addPart(this.headers, this.converter.convert(t));
            } catch (IOException e) {
                Method method = this.method;
                int i = this.f5031p;
                throw Utils.parameterError(method, i, "Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        public final Method method;

        /* renamed from: p */
        public final int f5032p;
        public final String transferEncoding;
        public final Converter<T, RequestBody> valueConverter;

        public PartMap(Method method, int i, Converter<T, RequestBody> converter, String str) {
            this.method = method;
            this.f5032p = i;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key == null) {
                        throw Utils.parameterError(this.method, this.f5032p, "Part map contained null key.", new Object[0]);
                    }
                    T value = entry.getValue();
                    if (value == null) {
                        throw Utils.parameterError(this.method, this.f5032p, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Part map contained null value for key '", key, "'."), new Object[0]);
                    }
                    requestBuilder.addPart(okhttp3.Headers.m55of("Content-Disposition", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("form-data; name=\"", key, "\""), "Content-Transfer-Encoding", this.transferEncoding), this.valueConverter.convert(value));
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f5032p, "Part map was null.", new Object[0]);
        }
    }

    /* loaded from: classes5.dex */
    public static final class Path<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final Method method;
        public final String name;

        /* renamed from: p */
        public final int f5033p;
        public final Converter<T, String> valueConverter;

        public Path(Method method, int i, String str, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.f5033p = i;
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                requestBuilder.addPathParam(this.name, this.valueConverter.convert(t), this.encoded);
                return;
            }
            throw Utils.parameterError(this.method, this.f5033p, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Path parameter \""), this.name, "\" value must not be null."), new Object[0]);
        }
    }

    /* loaded from: classes5.dex */
    public static final class Query<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final String name;
        public final Converter<T, String> valueConverter;

        public Query(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addQueryParam(this.name, convert, this.encoded);
        }
    }

    /* loaded from: classes5.dex */
    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        public final boolean encoded;
        public final Method method;

        /* renamed from: p */
        public final int f5034p;
        public final Converter<T, String> valueConverter;

        public QueryMap(Method method, int i, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.f5034p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key == null) {
                        throw Utils.parameterError(this.method, this.f5034p, "Query map contained null key.", new Object[0]);
                    }
                    T value = entry.getValue();
                    if (value == null) {
                        throw Utils.parameterError(this.method, this.f5034p, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Query map contained null value for key '", key, "'."), new Object[0]);
                    }
                    String convert = this.valueConverter.convert(value);
                    if (convert == null) {
                        Method method = this.method;
                        int i = this.f5034p;
                        throw Utils.parameterError(method, i, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                    }
                    requestBuilder.addQueryParam(key, convert, this.encoded);
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f5034p, "Query map was null", new Object[0]);
        }
    }

    /* loaded from: classes5.dex */
    public static final class QueryName<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final Converter<T, String> nameConverter;

        public QueryName(Converter<T, String> converter, boolean z) {
            this.nameConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                return;
            }
            requestBuilder.addQueryParam(this.nameConverter.convert(t), null, this.encoded);
        }
    }

    /* loaded from: classes5.dex */
    public static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        public static final RawPart INSTANCE = new RawPart();

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, MultipartBody.Part part) {
            if (part != null) {
                requestBuilder.addPart(part);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class RelativeUrl extends ParameterHandler<Object> {
        public final Method method;

        /* renamed from: p */
        public final int f5035p;

        public RelativeUrl(Method method, int i) {
            this.method = method;
            this.f5035p = i;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj != null) {
                requestBuilder.setRelativeUrl(obj);
                return;
            }
            throw Utils.parameterError(this.method, this.f5035p, "@Url parameter is null.", new Object[0]);
        }
    }

    /* loaded from: classes5.dex */
    public static final class Tag<T> extends ParameterHandler<T> {
        public final Class<T> cls;

        public Tag(Class<T> cls) {
            this.cls = cls;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) {
            requestBuilder.addTag(this.cls, t);
        }
    }

    public abstract void apply(RequestBuilder requestBuilder, T t) throws IOException;

    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // retrofit2.ParameterHandler
            public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    ParameterHandler.this.apply(requestBuilder, Array.get(obj, i));
                }
            }
        };
    }

    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
            public void apply(RequestBuilder requestBuilder, Iterable<T> iterable) throws IOException {
                if (iterable == null) {
                    return;
                }
                for (T t : iterable) {
                    ParameterHandler.this.apply(requestBuilder, t);
                }
            }

            @Override // retrofit2.ParameterHandler
            public /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
                apply(requestBuilder, (Iterable) ((Iterable) obj));
            }
        };
    }
}

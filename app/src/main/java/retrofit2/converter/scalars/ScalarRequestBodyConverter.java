package retrofit2.converter.scalars;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.eclipse.jetty.http.MimeTypes;
import retrofit2.Converter;

/* loaded from: classes5.dex */
public final class ScalarRequestBodyConverter<T> implements Converter<T, RequestBody> {
    public static final ScalarRequestBodyConverter<Object> INSTANCE = new ScalarRequestBodyConverter<>();
    public static final MediaType MEDIA_TYPE = MediaType.get(MimeTypes.TEXT_PLAIN__UTF_8);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
        return convert2((ScalarRequestBodyConverter<T>) obj);
    }

    @Override // retrofit2.Converter
    /* renamed from: convert  reason: avoid collision after fix types in other method */
    public RequestBody convert2(T t) throws IOException {
        return RequestBody.create(MEDIA_TYPE, String.valueOf(t));
    }
}

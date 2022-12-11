package retrofit2;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class HttpException extends RuntimeException {
    public final int code;
    public final String message;
    public final transient Response<?> response;

    public HttpException(Response<?> response) {
        super(getMessage(response));
        this.code = response.code();
        this.message = response.message();
        this.response = response;
    }

    public static String getMessage(Response<?> response) {
        Objects.requireNonNull(response, "response == null");
        return "HTTP " + response.code() + StringUtils.SPACE + response.message();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public Response<?> response() {
        return this.response;
    }
}

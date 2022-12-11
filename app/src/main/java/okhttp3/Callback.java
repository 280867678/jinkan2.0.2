package okhttp3;

import java.io.IOException;
import me.tvspark.ef0;

@ef0
/* loaded from: classes4.dex */
public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, Response response) throws IOException;
}

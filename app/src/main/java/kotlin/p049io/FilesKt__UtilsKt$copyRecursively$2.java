package kotlin.p049io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mh0;
import me.tvspark.of0;

@ef0
/* renamed from: kotlin.io.FilesKt__UtilsKt$copyRecursively$2 */
/* loaded from: classes4.dex */
public final class FilesKt__UtilsKt$copyRecursively$2 extends Lambda implements mh0<File, IOException, of0> {
    public final /* synthetic */ mh0 $onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesKt__UtilsKt$copyRecursively$2(mh0 mh0Var) {
        super(2);
        this.$onError = mh0Var;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ of0 mo4918invoke(File file, IOException iOException) {
        invoke2(file, iOException);
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(File file, IOException iOException) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "f");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "e");
        if (((OnErrorAction) this.$onError.mo4918invoke(file, iOException)) != OnErrorAction.TERMINATE) {
            return;
        }
        throw new TerminateException(file);
    }
}

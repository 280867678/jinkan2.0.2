package retrofit2;

import java.lang.annotation.Annotation;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    public static final SkipCallbackExecutor INSTANCE = new SkipCallbackExecutorImpl();

    public static Annotation[] ensurePresent(Annotation[] annotationArr) {
        if (Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = INSTANCE;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("@");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(SkipCallbackExecutor.class.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("()");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

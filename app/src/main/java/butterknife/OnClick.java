package butterknife;

import androidx.annotation.IdRes;
import androidx.customview.widget.ExploreByTouchHelper;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(name = "doClick", parameters = {ExploreByTouchHelper.DEFAULT_CLASS_NAME})}, setter = "setOnClickListener", targetType = ExploreByTouchHelper.DEFAULT_CLASS_NAME, type = "butterknife.internal.DebouncingOnClickListener")
/* loaded from: classes3.dex */
public @interface OnClick {
    @IdRes
    int[] value() default {-1};
}

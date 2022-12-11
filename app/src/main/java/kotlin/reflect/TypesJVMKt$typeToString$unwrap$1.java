package kotlin.reflect;

import kotlin.jvm.internal.FunctionReferenceImpl;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes4.dex */
public final /* synthetic */ class TypesJVMKt$typeToString$unwrap$1 extends FunctionReferenceImpl implements ih0<Class<? extends Object>, Class<?>> {
    public static final TypesJVMKt$typeToString$unwrap$1 INSTANCE = new TypesJVMKt$typeToString$unwrap$1();

    public TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Class<?> invoke2(Class<?> cls) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "p1");
        return cls.getComponentType();
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Class<?> mo4916invoke(Class<? extends Object> cls) {
        return invoke2((Class<?>) cls);
    }
}

package kotlin.reflect;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.vj0;
import me.tvspark.yj0;
import okhttp3.HttpUrl;

@ef0
/* loaded from: classes4.dex */
public final /* synthetic */ class ParameterizedTypeImpl$getTypeName$1$1 extends FunctionReferenceImpl implements ih0<Type, String> {
    public static final ParameterizedTypeImpl$getTypeName$1$1 INSTANCE = new ParameterizedTypeImpl$getTypeName$1$1();

    public ParameterizedTypeImpl$getTypeName$1$1() {
        super(1, vj0.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final String mo4916invoke(Type type) {
        String name;
        Object next;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, "p1");
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                TypesJVMKt$typeToString$unwrap$1 typesJVMKt$typeToString$unwrap$1 = TypesJVMKt$typeToString$unwrap$1.INSTANCE;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typesJVMKt$typeToString$unwrap$1, "nextFunction");
                yj0 yj0Var = new yj0(new SequencesKt__SequencesKt$generateSequence$2(type), typesJVMKt$typeToString$unwrap$1);
                StringBuilder sb = new StringBuilder();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(yj0Var, "$this$last");
                Iterator<T> it = yj0Var.iterator();
                if (it.hasNext()) {
                    do {
                        next = it.next();
                    } while (it.hasNext());
                    sb.append(((Class) next).getName());
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(yj0Var, "$this$count");
                    Iterator<T> it2 = yj0Var.iterator();
                    int i = 0;
                    while (it2.hasNext()) {
                        it2.next();
                        i++;
                        if (i < 0) {
                            throw new ArithmeticException("Count overflow has happened.");
                        }
                    }
                    sb.append(nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, i));
                    name = sb.toString();
                } else {
                    throw new NoSuchElementException("Sequence is empty.");
                }
            } else {
                name = cls.getName();
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, "if (type.isArray) {\n    …\n        } else type.name");
            return name;
        }
        return type.toString();
    }
}

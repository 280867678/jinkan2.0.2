package me.tvspark;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import me.tvspark.C2166gz;

/* renamed from: me.tvspark.hz */
/* loaded from: classes4.dex */
public class C2203hz extends C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ TypeVariable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2203hz(C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, TypeVariable typeVariable, C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = typeVariable;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    @Override // me.tvspark.C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeVariable<?> typeVariable, C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        return typeVariable.getGenericDeclaration().equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getGenericDeclaration()) ? typeVariable : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeVariable, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}

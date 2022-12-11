package me.tvspark;

import java.util.function.Consumer;
import org.mozilla.javascript.Hashtable;

/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class s21 implements Consumer {
    public static final /* synthetic */ s21 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new s21();

    private /* synthetic */ s21() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((Hashtable.Entry) obj).clear();
    }
}

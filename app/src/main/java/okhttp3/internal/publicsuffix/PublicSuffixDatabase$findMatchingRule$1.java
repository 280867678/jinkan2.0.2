package okhttp3.internal.publicsuffix;

import kotlin.jvm.internal.MutablePropertyReference0;
import me.tvspark.ef0;
import me.tvspark.jj0;
import me.tvspark.ki0;

@ef0
/* loaded from: classes4.dex */
public final /* synthetic */ class PublicSuffixDatabase$findMatchingRule$1 extends MutablePropertyReference0 {
    public PublicSuffixDatabase$findMatchingRule$1(PublicSuffixDatabase publicSuffixDatabase) {
        super(publicSuffixDatabase);
    }

    @Override // me.tvspark.qj0
    public Object get() {
        return PublicSuffixDatabase.access$getPublicSuffixListBytes$p((PublicSuffixDatabase) this.receiver);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getName() {
        return "publicSuffixListBytes";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public jj0 getOwner() {
        return ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(PublicSuffixDatabase.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getPublicSuffixListBytes()[B";
    }

    public void set(Object obj) {
        ((PublicSuffixDatabase) this.receiver).publicSuffixListBytes = (byte[]) obj;
    }
}

package me.tvspark;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* renamed from: me.tvspark.vc */
/* loaded from: classes4.dex */
public final class C2705vc {
    public final ByteArrayOutputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ByteArrayOutputStream(512);
    public final DataOutputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new DataOutputStream(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DataOutputStream dataOutputStream, long j) throws IOException {
        dataOutputStream.writeByte(((int) (j >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j) & 255);
    }
}

package me.tvspark;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
public class kq0 extends FileInputStream {
    public final /* synthetic */ long Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kq0(jq0 jq0Var, File file, long j) {
        super(file);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int available() throws IOException {
        return (int) this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }
}

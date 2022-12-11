package me.tvspark;

import java.io.IOException;
import java.util.ResourceBundle;
import javax.servlet.ServletOutputStream;

/* loaded from: classes4.dex */
public class ke0 extends ServletOutputStream {
    public static ResourceBundle Wwwwwwwwwwwwwwwwwwwwwww = ResourceBundle.getBundle("javax.servlet.http.LocalStrings");
    public int Wwwwwwwwwwwwwwwwwwwwwwww = 0;

    @Override // java.io.OutputStream
    public void write(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 >= 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww += i2;
            return;
        }
        throw new IOException(Wwwwwwwwwwwwwwwwwwwwwww.getString("err.io.negativelength"));
    }
}

package me.tvspark;

import org.apache.http.message.BasicHeaderValueParser;

/* loaded from: classes4.dex */
public class p51 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public p51(byte[] bArr, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public String toString() {
        char c;
        byte b = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        StringBuffer stringBuffer = new StringBuffer(b * 2);
        for (int i = 0; i < b; i++) {
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = i * 2;
            byte b2 = bArr[i3 + i2 + 1];
            if (b2 == 0) {
                c = '[';
            } else if (b2 == 1) {
                c = '.';
            } else if (b2 == 2) {
                c = '*';
            } else if (b2 != 3) {
                c = '_';
            } else {
                stringBuffer.append((int) bArr[i3 + i2 + 2]);
                c = BasicHeaderValueParser.PARAM_DELIMITER;
            }
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
}

package okhttp3.internal.http2;

import androidx.core.view.PointerIconCompat;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.IOException;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.r40;
import me.tvspark.vw0;
import me.tvspark.ww0;
import okhttp3.internal.Util;
import okio.ByteString;
import org.eclipse.jetty.http.HttpHeaderValues;
import org.mozilla.javascript.regexp.NativeRegExp;

@ef0
/* loaded from: classes4.dex */
public final class Huffman {
    public static final Huffman INSTANCE;
    public static final int[] CODES = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 115, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    public static final byte[] CODE_BIT_COUNTS = {13, 23, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, 24, NativeRegExp.REOP_RPAREN, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_RPAREN, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_RPAREN, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, NativeRegExp.REOP_OPT, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, NativeRegExp.REOP_UCFLAT1i, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, NativeRegExp.REOP_OPT, 20, NativeRegExp.REOP_CLASS, 20, 20, NativeRegExp.REOP_CLASS, NativeRegExp.REOP_CLASS, NativeRegExp.REOP_CLASS, 23, NativeRegExp.REOP_CLASS, 23, 23, 23, 23, 23, 24, 23, 24, 24, NativeRegExp.REOP_CLASS, 23, 24, 23, 23, 23, 23, 21, NativeRegExp.REOP_CLASS, 23, NativeRegExp.REOP_CLASS, 23, 23, 24, NativeRegExp.REOP_CLASS, 21, 20, NativeRegExp.REOP_CLASS, NativeRegExp.REOP_CLASS, 23, 23, 21, 23, NativeRegExp.REOP_CLASS, NativeRegExp.REOP_CLASS, 24, 21, NativeRegExp.REOP_CLASS, 23, 23, 21, 21, NativeRegExp.REOP_CLASS, 21, 23, NativeRegExp.REOP_CLASS, 23, 23, 20, NativeRegExp.REOP_CLASS, NativeRegExp.REOP_CLASS, NativeRegExp.REOP_CLASS, 23, NativeRegExp.REOP_CLASS, NativeRegExp.REOP_CLASS, 23, NativeRegExp.REOP_STAR, NativeRegExp.REOP_STAR, 20, NativeRegExp.REOP_UCFLAT1i, NativeRegExp.REOP_CLASS, 23, NativeRegExp.REOP_CLASS, NativeRegExp.REOP_QUANT, NativeRegExp.REOP_STAR, NativeRegExp.REOP_STAR, NativeRegExp.REOP_STAR, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_STAR, 24, NativeRegExp.REOP_QUANT, NativeRegExp.REOP_UCFLAT1i, 21, NativeRegExp.REOP_STAR, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_STAR, NativeRegExp.REOP_PLUS, 24, 21, 21, NativeRegExp.REOP_STAR, NativeRegExp.REOP_STAR, NativeRegExp.REOP_OPT, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, 20, 24, 20, 21, NativeRegExp.REOP_CLASS, 21, 21, 23, NativeRegExp.REOP_CLASS, NativeRegExp.REOP_CLASS, NativeRegExp.REOP_QUANT, NativeRegExp.REOP_QUANT, 24, 24, NativeRegExp.REOP_STAR, 23, NativeRegExp.REOP_STAR, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_STAR, NativeRegExp.REOP_STAR, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_OPT, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_STAR};
    public static final Node root = new Node();

    @ef0
    /* loaded from: classes4.dex */
    public static final class Node {
        public final Node[] children;
        public final int symbol;
        public final int terminalBitCount;

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        public Node(int i, int i2) {
            this.children = null;
            this.symbol = i;
            int i3 = i2 & 7;
            this.terminalBitCount = i3 == 0 ? 8 : i3;
        }

        public final Node[] getChildren() {
            return this.children;
        }

        public final int getSymbol() {
            return this.symbol;
        }

        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }
    }

    static {
        Huffman huffman = new Huffman();
        INSTANCE = huffman;
        int length = CODE_BIT_COUNTS.length;
        for (int i = 0; i < length; i++) {
            huffman.addCode(i, CODES[i], CODE_BIT_COUNTS[i]);
        }
    }

    private final void addCode(int i, int i2, int i3) {
        Node node = new Node(i, i3);
        Node node2 = root;
        while (i3 > 8) {
            i3 -= 8;
            int i4 = (i2 >>> i3) & 255;
            Node[] children = node2.getChildren();
            if (children == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            Node node3 = children[i4];
            if (node3 == null) {
                node3 = new Node();
                children[i4] = node3;
            }
            node2 = node3;
        }
        int i5 = 8 - i3;
        int i6 = (i2 << i5) & 255;
        int i7 = 1 << i5;
        Node[] children2 = node2.getChildren();
        if (children2 != null) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(children2, node, i6, i7 + i6);
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }

    public final void decode(ww0 ww0Var, long j, vw0 vw0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
        Node node = root;
        int i = 0;
        int i2 = 0;
        for (long j2 = 0; j2 < j; j2++) {
            i = (i << 8) | Util.and(ww0Var.readByte(), 255);
            i2 += 8;
            while (i2 >= 8) {
                int i3 = i2 - 8;
                int i4 = (i >>> i3) & 255;
                Node[] children = node.getChildren();
                if (children == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                node = children[i4];
                if (node == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (node.getChildren() == null) {
                    vw0Var.mo4963writeByte(node.getSymbol());
                    i2 -= node.getTerminalBitCount();
                    node = root;
                } else {
                    i2 = i3;
                }
            }
        }
        while (i2 > 0) {
            int i5 = (i << (8 - i2)) & 255;
            Node[] children2 = node.getChildren();
            if (children2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            Node node2 = children2[i5];
            if (node2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else if (node2.getChildren() != null || node2.getTerminalBitCount() > i2) {
                return;
            } else {
                vw0Var.mo4963writeByte(node2.getSymbol());
                i2 -= node2.getTerminalBitCount();
                node = root;
            }
        }
    }

    public final void encode(ByteString byteString, vw0 vw0Var) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "source");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
        int size = byteString.size();
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int and = Util.and(byteString.getByte(i2), 255);
            int i3 = CODES[and];
            byte b = CODE_BIT_COUNTS[and];
            j = (j << b) | i3;
            i += b;
            while (i >= 8) {
                i = (i == true ? 1 : 0) - 8;
                vw0Var.mo4963writeByte((int) (j >> i));
            }
        }
        if (i > 0) {
            vw0Var.mo4963writeByte((int) ((j << (8 - i)) | (255 >>> (i == 1 ? 1L : 0L))));
        }
    }

    public final int encodedLength(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, HttpHeaderValues.BYTES);
        int size = byteString.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            j += CODE_BIT_COUNTS[Util.and(byteString.getByte(i), 255)];
        }
        return (int) ((j + 7) >> 3);
    }
}

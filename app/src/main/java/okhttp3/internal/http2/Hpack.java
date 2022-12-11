package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.hx0;
import me.tvspark.ii0;
import me.tvspark.mx0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.uw0;
import me.tvspark.ww0;
import okhttp3.internal.Util;
import okio.ByteString;

@ef0
/* loaded from: classes4.dex */
public final class Hpack {
    public static final Hpack INSTANCE;
    public static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    public static final int PREFIX_4_BITS = 15;
    public static final int PREFIX_5_BITS = 31;
    public static final int PREFIX_6_BITS = 63;
    public static final int PREFIX_7_BITS = 127;
    public static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    public static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    public static final Header[] STATIC_HEADER_TABLE = {new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header(Http2ExchangeCodec.HOST, ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header(Http2ExchangeCodec.TRANSFER_ENCODING, ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    @ef0
    /* loaded from: classes4.dex */
    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        public final List<Header> headerList;
        public final int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        public int nextHeaderIndex;
        public final ww0 source;

        public Reader(mx0 mx0Var, int i) {
            this(mx0Var, i, 0, 4, null);
        }

        public Reader(mx0 mx0Var, int i, int i2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "source");
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i2;
            this.headerList = new ArrayList();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "$receiver");
            this.source = new hx0(mx0Var);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = 7;
        }

        public /* synthetic */ Reader(mx0 mx0Var, int i, int i2, int i3, gi0 gi0Var) {
            this(mx0Var, i, (i3 & 4) != 0 ? i : i2);
        }

        private final void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i);
                }
            }
        }

        private final void clearDynamicTable() {
            Header[] headerArr = this.dynamicTable;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headerArr, (Object) null, 0, headerArr.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i) {
            return this.nextHeaderIndex + 1 + i;
        }

        private final int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    if (header == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    int i3 = header.hpackSize;
                    i -= i3;
                    this.dynamicTableByteCount -= i3;
                    this.headerCount--;
                    i2++;
                }
                Header[] headerArr = this.dynamicTable;
                int i4 = this.nextHeaderIndex;
                System.arraycopy(headerArr, i4 + 1, headerArr, i4 + 1 + i2, this.headerCount);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        private final ByteString getName(int i) throws IOException {
            Header header;
            if (!isStaticHeader(i)) {
                int dynamicTableIndex = dynamicTableIndex(i - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
                if (dynamicTableIndex >= 0) {
                    Header[] headerArr = this.dynamicTable;
                    if (dynamicTableIndex < headerArr.length) {
                        header = headerArr[dynamicTableIndex];
                        if (header == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                    }
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Header index too large ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i + 1);
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            header = Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i];
            return header.name;
        }

        private final void insertIntoDynamicTable(int i, Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (i != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i)];
                if (header2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                i2 -= header2.hpackSize;
            }
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            if (i == -1) {
                int i4 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i5 = this.nextHeaderIndex;
                this.nextHeaderIndex = i5 - 1;
                this.dynamicTable[i5] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[dynamicTableIndex(i) + evictToRecoverBytes + i] = header;
            }
            this.dynamicTableByteCount += i2;
        }

        private final boolean isStaticHeader(int i) {
            return i >= 0 && i <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i) throws IOException {
            if (isStaticHeader(i)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[dynamicTableIndex];
                    if (header != null) {
                        list.add(header);
                        return;
                    } else {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                }
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Header index too large ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i + 1);
            throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i) throws IOException {
            this.headerList.add(new Header(getName(i), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) this.headerList);
            this.headerList.clear();
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final ByteString readByteString() throws IOException {
            int readByte = readByte();
            boolean z = (readByte & 128) == 128;
            long readInt = readInt(readByte, 127);
            if (z) {
                uw0 uw0Var = new uw0();
                Huffman.INSTANCE.decode(this.source, readInt, uw0Var);
                return uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readInt);
        }

        public final void readHeaders() throws IOException {
            while (!this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                int and = Util.and(this.source.readByte(), 255);
                if (and == 128) {
                    throw new IOException("index == 0");
                }
                if ((and & 128) == 128) {
                    readIndexedHeader(readInt(and, 127) - 1);
                } else if (and == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((and & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                } else if ((and & 32) == 32) {
                    int readInt = readInt(and, 31);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid dynamic table size update ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.maxDynamicTableByteCount);
                        throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    }
                    adjustDynamicTableByteCount();
                } else if (and == 16 || and == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                }
            }
        }

        public final int readInt(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i2 + (readByte << i4);
                }
                i2 += (readByte & 127) << i4;
                i4 += 7;
            }
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        public int nextHeaderIndex;
        public final uw0 out;
        public int smallestHeaderTableSizeSetting;
        public final boolean useCompression;

        public Writer(int i, uw0 uw0Var) {
            this(i, false, uw0Var, 2, null);
        }

        public Writer(int i, boolean z, uw0 uw0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "out");
            this.headerTableSizeSetting = i;
            this.useCompression = z;
            this.out = uw0Var;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        public /* synthetic */ Writer(int i, boolean z, uw0 uw0Var, int i2, gi0 gi0Var) {
            this((i2 & 1) != 0 ? 4096 : i, (i2 & 2) != 0 ? true : z, uw0Var);
        }

        public Writer(uw0 uw0Var) {
            this(0, false, uw0Var, 3, null);
        }

        private final void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i);
                }
            }
        }

        private final void clearDynamicTable() {
            Header[] headerArr = this.dynamicTable;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headerArr, (Object) null, 0, headerArr.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i <= 0) {
                        break;
                    }
                    Header[] headerArr = this.dynamicTable;
                    Header header = headerArr[length];
                    if (header == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    i -= header.hpackSize;
                    int i3 = this.dynamicTableByteCount;
                    Header header2 = headerArr[length];
                    if (header2 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    this.dynamicTableByteCount = i3 - header2.hpackSize;
                    this.headerCount--;
                    i2++;
                }
                Header[] headerArr2 = this.dynamicTable;
                int i4 = this.nextHeaderIndex;
                System.arraycopy(headerArr2, i4 + 1, headerArr2, i4 + 1 + i2, this.headerCount);
                Header[] headerArr3 = this.dynamicTable;
                int i5 = this.nextHeaderIndex;
                Arrays.fill(headerArr3, i5 + 1, i5 + 1 + i2, (Object) null);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        public final void resizeHeaderTable(int i) {
            this.headerTableSizeSetting = i;
            int min = Math.min(i, 16384);
            int i2 = this.maxDynamicTableByteCount;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = min;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(ByteString byteString) throws IOException {
            int size;
            int i;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "data");
            if (!this.useCompression || Huffman.INSTANCE.encodedLength(byteString) >= byteString.size()) {
                size = byteString.size();
                i = 0;
            } else {
                uw0 uw0Var = new uw0();
                Huffman.INSTANCE.encode(byteString, uw0Var);
                byteString = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
                size = byteString.size();
                i = 128;
            }
            writeInt(size, 127, i);
            this.out.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString);
        }

        public final void writeHeaders(List<Header> list) throws IOException {
            int i;
            int i2;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i3 = this.smallestHeaderTableSizeSetting;
                if (i3 < this.maxDynamicTableByteCount) {
                    writeInt(i3, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                Header header = list.get(i4);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = Hpack.INSTANCE.getNAME_TO_FIRST_INDEX().get(asciiLowercase);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (2 <= i && 7 >= i) {
                        if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i - 1].value, byteString)) {
                            i2 = i;
                        } else if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i].value, byteString)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        Header header2 = this.dynamicTable[i5];
                        if (header2 == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(header2.name, asciiLowercase)) {
                            Header header3 = this.dynamicTable[i5];
                            if (header3 == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            } else if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(header3.value, byteString)) {
                                i = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i5 - this.nextHeaderIndex);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    writeInt(i, 127, 128);
                } else {
                    if (i2 == -1) {
                        this.out.mo4963writeByte(64);
                        writeByteString(asciiLowercase);
                    } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || !(!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Header.TARGET_AUTHORITY, asciiLowercase))) {
                        writeInt(i2, 63, 64);
                    } else {
                        writeInt(i2, 15, 0);
                        writeByteString(byteString);
                    }
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                }
            }
        }

        public final void writeInt(int i, int i2, int i3) {
            int i4;
            uw0 uw0Var;
            if (i < i2) {
                uw0Var = this.out;
                i4 = i | i3;
            } else {
                this.out.mo4963writeByte(i3 | i2);
                i4 = i - i2;
                while (i4 >= 128) {
                    this.out.mo4963writeByte(128 | (i4 & 127));
                    i4 >>>= 7;
                }
                uw0Var = this.out;
            }
            uw0Var.mo4963writeByte(i4);
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int length = STATIC_HEADER_TABLE.length;
        for (int i = 0; i < length; i++) {
            if (!linkedHashMap.containsKey(STATIC_HEADER_TABLE[i].name)) {
                linkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
            }
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableMap, "Collections.unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final ByteString checkLowercase(ByteString byteString) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "name");
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b = (byte) 65;
            byte b2 = (byte) 90;
            byte b3 = byteString.getByte(i);
            if (b <= b3 && b2 >= b3) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("PROTOCOL_ERROR response malformed: mixed case name: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(byteString.utf8());
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        return byteString;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}

package org.eclipse.jetty.http;

import androidx.core.net.MailTo;
import java.io.IOException;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.BufferCache;
import org.eclipse.jetty.p059io.BufferUtil;
import org.eclipse.jetty.p059io.Buffers;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.EofException;
import org.eclipse.jetty.p059io.View;
import org.eclipse.jetty.p059io.bio.StreamEndPoint;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class HttpParser implements Parser {
    public static final Logger LOG = Log.getLogger(HttpParser.class);
    public static final int STATE_CHUNK = 6;
    public static final int STATE_CHUNKED_CONTENT = 3;
    public static final int STATE_CHUNK_PARAMS = 5;
    public static final int STATE_CHUNK_SIZE = 4;
    public static final int STATE_CONTENT = 2;
    public static final int STATE_END = 0;
    public static final int STATE_END0 = -8;
    public static final int STATE_END1 = -7;
    public static final int STATE_EOF_CONTENT = 1;
    public static final int STATE_FIELD0 = -13;
    public static final int STATE_FIELD2 = -6;
    public static final int STATE_HEADER = -5;
    public static final int STATE_HEADER_IN_NAME = -3;
    public static final int STATE_HEADER_IN_VALUE = -1;
    public static final int STATE_HEADER_NAME = -4;
    public static final int STATE_HEADER_VALUE = -2;
    public static final int STATE_SEEKING_EOF = 7;
    public static final int STATE_SPACE1 = -12;
    public static final int STATE_SPACE2 = -9;
    public static final int STATE_START = -14;
    public static final int STATE_STATUS = -11;
    public static final int STATE_URI = -10;
    public Buffer _body;
    public Buffer _buffer;
    public final Buffers _buffers;
    public BufferCache.CachedBuffer _cached;
    public int _chunkLength;
    public int _chunkPosition;
    public long _contentLength;
    public long _contentPosition;
    public final View _contentView;
    public final EndPoint _endp;
    public byte _eol;
    public boolean _forceContentBuffer;
    public final EventHandler _handler;
    public boolean _headResponse;
    public Buffer _header;
    public int _length;
    public String _multiLineValue;
    public boolean _persistent;
    public int _responseStatus;
    public int _state;
    public final View.CaseInsensitive _tok0;
    public final View.CaseInsensitive _tok1;

    /* loaded from: classes4.dex */
    public static abstract class EventHandler {
        public abstract void content(Buffer buffer) throws IOException;

        public void earlyEOF() {
        }

        public void headerComplete() throws IOException {
        }

        public void messageComplete(long j) throws IOException {
        }

        public void parsedHeader(Buffer buffer, Buffer buffer2) throws IOException {
        }

        public abstract void startRequest(Buffer buffer, Buffer buffer2, Buffer buffer3) throws IOException;

        public abstract void startResponse(Buffer buffer, int i, Buffer buffer2) throws IOException;
    }

    public HttpParser(Buffer buffer, EventHandler eventHandler) {
        this._contentView = new View();
        this._state = -14;
        this._endp = null;
        this._buffers = null;
        this._header = buffer;
        this._buffer = buffer;
        this._handler = eventHandler;
        this._tok0 = new View.CaseInsensitive(this._header);
        this._tok1 = new View.CaseInsensitive(this._header);
    }

    public HttpParser(Buffers buffers, EndPoint endPoint, EventHandler eventHandler) {
        this._contentView = new View();
        this._state = -14;
        this._buffers = buffers;
        this._endp = endPoint;
        this._handler = eventHandler;
        this._tok0 = new View.CaseInsensitive();
        this._tok1 = new View.CaseInsensitive();
    }

    public int available() throws IOException {
        View view = this._contentView;
        if (view == null || view.length() <= 0) {
            if (this._endp.isBlocking()) {
                if (this._state <= 0) {
                    return 0;
                }
                EndPoint endPoint = this._endp;
                return (!(endPoint instanceof StreamEndPoint) || ((StreamEndPoint) endPoint).getInputStream().available() <= 0) ? 0 : 1;
            }
            parseNext();
            View view2 = this._contentView;
            if (view2 != null) {
                return view2.length();
            }
            return 0;
        }
        return this._contentView.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0056, code lost:
        r3._endp.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0062, code lost:
        throw new org.eclipse.jetty.p059io.EofException("timeout");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Buffer blockForContent(long j) throws IOException {
        if (this._contentView.length() > 0) {
            return this._contentView;
        }
        if (getState() <= 0 || isState(7)) {
            return null;
        }
        loop0: while (true) {
            try {
                parseNext();
                while (this._contentView.length() == 0 && !isState(0) && !isState(7) && this._endp != null && this._endp.isOpen()) {
                    if (!this._endp.isBlocking()) {
                        if (parseNext() <= 0) {
                            if (!this._endp.blockReadable(j)) {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                this._endp.close();
                throw e;
            }
        }
        if (this._contentView.length() <= 0) {
            return null;
        }
        return this._contentView;
    }

    public int fill() throws IOException {
        Buffer buffer;
        if (this._buffer == null) {
            this._buffer = getHeaderBuffer();
        }
        if (this._state > 0) {
            Buffer buffer2 = this._buffer;
            Buffer buffer3 = this._header;
            if (buffer2 == buffer3 && buffer3 != null && !buffer3.hasContent() && (buffer = this._body) != null && buffer.hasContent()) {
                Buffer buffer4 = this._body;
                this._buffer = buffer4;
                return buffer4.length();
            }
        }
        Buffer buffer5 = this._buffer;
        Buffer buffer6 = this._header;
        if (buffer5 == buffer6 && this._state > 0 && buffer6.length() == 0 && ((this._forceContentBuffer || this._contentLength - this._contentPosition > this._header.capacity()) && (this._body != null || this._buffers != null))) {
            if (this._body == null) {
                this._body = this._buffers.getBuffer();
            }
            this._buffer = this._body;
        }
        if (this._endp != null) {
            if (this._buffer == this._body || this._state > 0) {
                this._buffer.compact();
            }
            if (this._buffer.space() == 0) {
                LOG.warn("HttpParser Full for {} ", this._endp);
                this._buffer.clear();
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Request Entity Too Large: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._buffer == this._body ? MailTo.BODY : "head");
                throw new HttpException(413, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            try {
                return this._endp.fill(this._buffer);
            } catch (IOException e) {
                LOG.debug(e);
                if (!(e instanceof EofException)) {
                    throw new EofException(e);
                }
                throw e;
            }
        }
        return -1;
    }

    public Buffer getBodyBuffer() {
        return this._body;
    }

    public long getContentLength() {
        return this._contentLength;
    }

    public long getContentRead() {
        return this._contentPosition;
    }

    public Buffer getHeaderBuffer() {
        if (this._header == null) {
            Buffer header = this._buffers.getHeader();
            this._header = header;
            this._tok0.update(header);
            this._tok1.update(this._header);
        }
        return this._header;
    }

    public int getState() {
        return this._state;
    }

    public boolean inContentState() {
        return this._state > 0;
    }

    public boolean inHeaderState() {
        return this._state < 0;
    }

    public boolean isChunking() {
        return this._contentLength == -2;
    }

    @Override // org.eclipse.jetty.http.Parser
    public boolean isComplete() {
        return this._responseStatus > 0 ? isState(0) || isState(7) : isState(0);
    }

    @Override // org.eclipse.jetty.http.Parser
    public boolean isIdle() {
        return isState(-14);
    }

    @Override // org.eclipse.jetty.http.Parser
    public boolean isMoreInBuffer() throws IOException {
        Buffer buffer;
        Buffer buffer2 = this._header;
        return (buffer2 != null && buffer2.hasContent()) || ((buffer = this._body) != null && buffer.hasContent());
    }

    @Override // org.eclipse.jetty.http.Parser
    public boolean isPersistent() {
        return this._persistent;
    }

    public boolean isState(int i) {
        return this._state == i;
    }

    public void parse() throws IOException {
        if (this._state == 0) {
            reset();
        }
        if (this._state == -14) {
            while (this._state != 0 && parseNext() >= 0) {
            }
            return;
        }
        throw new IllegalStateException("!START");
    }

    @Override // org.eclipse.jetty.http.Parser
    public boolean parseAvailable() throws IOException {
        Buffer buffer;
        boolean z = parseNext() > 0;
        while (!isComplete() && (buffer = this._buffer) != null && buffer.length() > 0 && !this._contentView.hasContent()) {
            z |= parseNext() > 0;
        }
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:166:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04ee A[Catch: HttpException -> 0x0960, TryCatch #4 {HttpException -> 0x0960, blocks: (B:49:0x0133, B:50:0x0135, B:55:0x0139, B:57:0x013d, B:59:0x0145, B:60:0x015a, B:62:0x015e, B:63:0x0166, B:64:0x0198, B:65:0x019a, B:66:0x019d, B:71:0x01a8, B:73:0x01ad, B:74:0x01b2, B:75:0x01c2, B:76:0x01c6, B:78:0x01ca, B:80:0x01d2, B:81:0x01e7, B:83:0x01eb, B:84:0x01f3, B:85:0x0225, B:92:0x0235, B:93:0x023c, B:95:0x0240, B:97:0x0244, B:98:0x0258, B:99:0x025d, B:101:0x0261, B:102:0x0275, B:103:0x0279, B:110:0x028a, B:112:0x0292, B:113:0x0297, B:114:0x02ab, B:116:0x02af, B:118:0x02b3, B:119:0x02c7, B:120:0x02cc, B:122:0x02d0, B:123:0x02e4, B:128:0x02f0, B:130:0x02f4, B:132:0x02fc, B:134:0x0304, B:136:0x03f5, B:139:0x0402, B:141:0x040e, B:143:0x0420, B:147:0x043f, B:149:0x0443, B:151:0x0449, B:153:0x044f, B:155:0x0455, B:157:0x0485, B:159:0x048d, B:161:0x0495, B:163:0x049d, B:164:0x04a5, B:172:0x04bd, B:173:0x04c2, B:175:0x04c6, B:177:0x04ca, B:179:0x04d0, B:183:0x04da, B:186:0x04e9, B:187:0x04ee, B:188:0x04b2, B:189:0x045a, B:191:0x0462, B:193:0x0466, B:195:0x046c, B:197:0x0472, B:200:0x0479, B:201:0x047e, B:203:0x0308, B:205:0x030c, B:207:0x0319, B:209:0x031f, B:210:0x0329, B:218:0x03d6, B:219:0x033f, B:223:0x0345, B:226:0x0351, B:229:0x0356, B:230:0x0363, B:231:0x0364, B:233:0x0373, B:234:0x0376, B:237:0x0383, B:241:0x038c, B:242:0x0394, B:243:0x0395, B:249:0x03a5, B:250:0x03a8, B:251:0x03ac, B:253:0x03ba, B:259:0x03d2, B:260:0x03cc, B:262:0x03cf, B:266:0x0322, B:267:0x0310, B:268:0x04f5, B:271:0x04ff, B:273:0x0503, B:274:0x0535, B:277:0x0544, B:278:0x055f, B:280:0x0519, B:285:0x056a, B:287:0x056e, B:289:0x059d, B:291:0x05c0, B:293:0x05cc, B:294:0x05de, B:298:0x05e8, B:301:0x0611, B:306:0x062c, B:309:0x063b, B:310:0x0668, B:318:0x067b, B:319:0x0682, B:320:0x0683, B:322:0x068c, B:323:0x0696, B:326:0x069f, B:329:0x06be, B:335:0x06d1, B:336:0x06d8, B:337:0x06d9, B:340:0x06e5, B:342:0x06ef, B:344:0x06f3, B:346:0x06f7, B:348:0x06fb, B:350:0x0701, B:354:0x070b, B:356:0x0714, B:357:0x071c, B:360:0x0722, B:362:0x0726, B:363:0x072a, B:365:0x0730, B:367:0x0738, B:369:0x0742, B:370:0x0747, B:371:0x074c, B:376:0x095b, B:378:0x0759, B:380:0x0762, B:381:0x078c, B:383:0x076a, B:385:0x0772, B:388:0x077e, B:393:0x0792, B:395:0x079a, B:399:0x07a1, B:401:0x07c5, B:405:0x07d7, B:410:0x07df, B:412:0x07e7, B:414:0x07ef, B:415:0x07f7, B:418:0x07fe, B:407:0x0808, B:421:0x080c, B:433:0x0829, B:438:0x083c, B:443:0x0851, B:445:0x085e, B:446:0x0874, B:448:0x0875, B:449:0x087c, B:455:0x0889, B:457:0x0891, B:459:0x0899, B:460:0x08a1, B:463:0x08a8, B:451:0x08b2, B:466:0x08b7, B:471:0x08ca, B:472:0x08d1, B:473:0x08db, B:475:0x08e5, B:477:0x08f0, B:480:0x08f7, B:483:0x0901, B:485:0x0906, B:486:0x0907, B:488:0x0929, B:491:0x0930, B:495:0x093a), top: B:48:0x0133, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04b2 A[Catch: HttpException -> 0x0960, TryCatch #4 {HttpException -> 0x0960, blocks: (B:49:0x0133, B:50:0x0135, B:55:0x0139, B:57:0x013d, B:59:0x0145, B:60:0x015a, B:62:0x015e, B:63:0x0166, B:64:0x0198, B:65:0x019a, B:66:0x019d, B:71:0x01a8, B:73:0x01ad, B:74:0x01b2, B:75:0x01c2, B:76:0x01c6, B:78:0x01ca, B:80:0x01d2, B:81:0x01e7, B:83:0x01eb, B:84:0x01f3, B:85:0x0225, B:92:0x0235, B:93:0x023c, B:95:0x0240, B:97:0x0244, B:98:0x0258, B:99:0x025d, B:101:0x0261, B:102:0x0275, B:103:0x0279, B:110:0x028a, B:112:0x0292, B:113:0x0297, B:114:0x02ab, B:116:0x02af, B:118:0x02b3, B:119:0x02c7, B:120:0x02cc, B:122:0x02d0, B:123:0x02e4, B:128:0x02f0, B:130:0x02f4, B:132:0x02fc, B:134:0x0304, B:136:0x03f5, B:139:0x0402, B:141:0x040e, B:143:0x0420, B:147:0x043f, B:149:0x0443, B:151:0x0449, B:153:0x044f, B:155:0x0455, B:157:0x0485, B:159:0x048d, B:161:0x0495, B:163:0x049d, B:164:0x04a5, B:172:0x04bd, B:173:0x04c2, B:175:0x04c6, B:177:0x04ca, B:179:0x04d0, B:183:0x04da, B:186:0x04e9, B:187:0x04ee, B:188:0x04b2, B:189:0x045a, B:191:0x0462, B:193:0x0466, B:195:0x046c, B:197:0x0472, B:200:0x0479, B:201:0x047e, B:203:0x0308, B:205:0x030c, B:207:0x0319, B:209:0x031f, B:210:0x0329, B:218:0x03d6, B:219:0x033f, B:223:0x0345, B:226:0x0351, B:229:0x0356, B:230:0x0363, B:231:0x0364, B:233:0x0373, B:234:0x0376, B:237:0x0383, B:241:0x038c, B:242:0x0394, B:243:0x0395, B:249:0x03a5, B:250:0x03a8, B:251:0x03ac, B:253:0x03ba, B:259:0x03d2, B:260:0x03cc, B:262:0x03cf, B:266:0x0322, B:267:0x0310, B:268:0x04f5, B:271:0x04ff, B:273:0x0503, B:274:0x0535, B:277:0x0544, B:278:0x055f, B:280:0x0519, B:285:0x056a, B:287:0x056e, B:289:0x059d, B:291:0x05c0, B:293:0x05cc, B:294:0x05de, B:298:0x05e8, B:301:0x0611, B:306:0x062c, B:309:0x063b, B:310:0x0668, B:318:0x067b, B:319:0x0682, B:320:0x0683, B:322:0x068c, B:323:0x0696, B:326:0x069f, B:329:0x06be, B:335:0x06d1, B:336:0x06d8, B:337:0x06d9, B:340:0x06e5, B:342:0x06ef, B:344:0x06f3, B:346:0x06f7, B:348:0x06fb, B:350:0x0701, B:354:0x070b, B:356:0x0714, B:357:0x071c, B:360:0x0722, B:362:0x0726, B:363:0x072a, B:365:0x0730, B:367:0x0738, B:369:0x0742, B:370:0x0747, B:371:0x074c, B:376:0x095b, B:378:0x0759, B:380:0x0762, B:381:0x078c, B:383:0x076a, B:385:0x0772, B:388:0x077e, B:393:0x0792, B:395:0x079a, B:399:0x07a1, B:401:0x07c5, B:405:0x07d7, B:410:0x07df, B:412:0x07e7, B:414:0x07ef, B:415:0x07f7, B:418:0x07fe, B:407:0x0808, B:421:0x080c, B:433:0x0829, B:438:0x083c, B:443:0x0851, B:445:0x085e, B:446:0x0874, B:448:0x0875, B:449:0x087c, B:455:0x0889, B:457:0x0891, B:459:0x0899, B:460:0x08a1, B:463:0x08a8, B:451:0x08b2, B:466:0x08b7, B:471:0x08ca, B:472:0x08d1, B:473:0x08db, B:475:0x08e5, B:477:0x08f0, B:480:0x08f7, B:483:0x0901, B:485:0x0906, B:486:0x0907, B:488:0x0929, B:491:0x0930, B:495:0x093a), top: B:48:0x0133, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f4 A[Catch: HttpException -> 0x0964, TryCatch #2 {HttpException -> 0x0964, blocks: (B:3:0x0004, B:7:0x0009, B:9:0x000d, B:10:0x0013, B:12:0x0019, B:14:0x0021, B:16:0x002b, B:509:0x00d9, B:20:0x00e2, B:21:0x00ea, B:23:0x00f4, B:25:0x00f8, B:27:0x00fc, B:28:0x0101, B:31:0x010f, B:37:0x0114, B:38:0x0119, B:39:0x011a, B:511:0x006b, B:513:0x0071, B:515:0x0079, B:517:0x007d, B:518:0x009d, B:522:0x00a5, B:524:0x00ab, B:525:0x00b0, B:526:0x00b4, B:528:0x00c3, B:530:0x00c9, B:533:0x00d0, B:534:0x00d5, B:536:0x00d7, B:537:0x00b8, B:538:0x00bf, B:543:0x005b), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x06f3 A[Catch: HttpException -> 0x0960, TryCatch #4 {HttpException -> 0x0960, blocks: (B:49:0x0133, B:50:0x0135, B:55:0x0139, B:57:0x013d, B:59:0x0145, B:60:0x015a, B:62:0x015e, B:63:0x0166, B:64:0x0198, B:65:0x019a, B:66:0x019d, B:71:0x01a8, B:73:0x01ad, B:74:0x01b2, B:75:0x01c2, B:76:0x01c6, B:78:0x01ca, B:80:0x01d2, B:81:0x01e7, B:83:0x01eb, B:84:0x01f3, B:85:0x0225, B:92:0x0235, B:93:0x023c, B:95:0x0240, B:97:0x0244, B:98:0x0258, B:99:0x025d, B:101:0x0261, B:102:0x0275, B:103:0x0279, B:110:0x028a, B:112:0x0292, B:113:0x0297, B:114:0x02ab, B:116:0x02af, B:118:0x02b3, B:119:0x02c7, B:120:0x02cc, B:122:0x02d0, B:123:0x02e4, B:128:0x02f0, B:130:0x02f4, B:132:0x02fc, B:134:0x0304, B:136:0x03f5, B:139:0x0402, B:141:0x040e, B:143:0x0420, B:147:0x043f, B:149:0x0443, B:151:0x0449, B:153:0x044f, B:155:0x0455, B:157:0x0485, B:159:0x048d, B:161:0x0495, B:163:0x049d, B:164:0x04a5, B:172:0x04bd, B:173:0x04c2, B:175:0x04c6, B:177:0x04ca, B:179:0x04d0, B:183:0x04da, B:186:0x04e9, B:187:0x04ee, B:188:0x04b2, B:189:0x045a, B:191:0x0462, B:193:0x0466, B:195:0x046c, B:197:0x0472, B:200:0x0479, B:201:0x047e, B:203:0x0308, B:205:0x030c, B:207:0x0319, B:209:0x031f, B:210:0x0329, B:218:0x03d6, B:219:0x033f, B:223:0x0345, B:226:0x0351, B:229:0x0356, B:230:0x0363, B:231:0x0364, B:233:0x0373, B:234:0x0376, B:237:0x0383, B:241:0x038c, B:242:0x0394, B:243:0x0395, B:249:0x03a5, B:250:0x03a8, B:251:0x03ac, B:253:0x03ba, B:259:0x03d2, B:260:0x03cc, B:262:0x03cf, B:266:0x0322, B:267:0x0310, B:268:0x04f5, B:271:0x04ff, B:273:0x0503, B:274:0x0535, B:277:0x0544, B:278:0x055f, B:280:0x0519, B:285:0x056a, B:287:0x056e, B:289:0x059d, B:291:0x05c0, B:293:0x05cc, B:294:0x05de, B:298:0x05e8, B:301:0x0611, B:306:0x062c, B:309:0x063b, B:310:0x0668, B:318:0x067b, B:319:0x0682, B:320:0x0683, B:322:0x068c, B:323:0x0696, B:326:0x069f, B:329:0x06be, B:335:0x06d1, B:336:0x06d8, B:337:0x06d9, B:340:0x06e5, B:342:0x06ef, B:344:0x06f3, B:346:0x06f7, B:348:0x06fb, B:350:0x0701, B:354:0x070b, B:356:0x0714, B:357:0x071c, B:360:0x0722, B:362:0x0726, B:363:0x072a, B:365:0x0730, B:367:0x0738, B:369:0x0742, B:370:0x0747, B:371:0x074c, B:376:0x095b, B:378:0x0759, B:380:0x0762, B:381:0x078c, B:383:0x076a, B:385:0x0772, B:388:0x077e, B:393:0x0792, B:395:0x079a, B:399:0x07a1, B:401:0x07c5, B:405:0x07d7, B:410:0x07df, B:412:0x07e7, B:414:0x07ef, B:415:0x07f7, B:418:0x07fe, B:407:0x0808, B:421:0x080c, B:433:0x0829, B:438:0x083c, B:443:0x0851, B:445:0x085e, B:446:0x0874, B:448:0x0875, B:449:0x087c, B:455:0x0889, B:457:0x0891, B:459:0x0899, B:460:0x08a1, B:463:0x08a8, B:451:0x08b2, B:466:0x08b7, B:471:0x08ca, B:472:0x08d1, B:473:0x08db, B:475:0x08e5, B:477:0x08f0, B:480:0x08f7, B:483:0x0901, B:485:0x0906, B:486:0x0907, B:488:0x0929, B:491:0x0930, B:495:0x093a), top: B:48:0x0133, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0720 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0726 A[Catch: HttpException -> 0x0960, TryCatch #4 {HttpException -> 0x0960, blocks: (B:49:0x0133, B:50:0x0135, B:55:0x0139, B:57:0x013d, B:59:0x0145, B:60:0x015a, B:62:0x015e, B:63:0x0166, B:64:0x0198, B:65:0x019a, B:66:0x019d, B:71:0x01a8, B:73:0x01ad, B:74:0x01b2, B:75:0x01c2, B:76:0x01c6, B:78:0x01ca, B:80:0x01d2, B:81:0x01e7, B:83:0x01eb, B:84:0x01f3, B:85:0x0225, B:92:0x0235, B:93:0x023c, B:95:0x0240, B:97:0x0244, B:98:0x0258, B:99:0x025d, B:101:0x0261, B:102:0x0275, B:103:0x0279, B:110:0x028a, B:112:0x0292, B:113:0x0297, B:114:0x02ab, B:116:0x02af, B:118:0x02b3, B:119:0x02c7, B:120:0x02cc, B:122:0x02d0, B:123:0x02e4, B:128:0x02f0, B:130:0x02f4, B:132:0x02fc, B:134:0x0304, B:136:0x03f5, B:139:0x0402, B:141:0x040e, B:143:0x0420, B:147:0x043f, B:149:0x0443, B:151:0x0449, B:153:0x044f, B:155:0x0455, B:157:0x0485, B:159:0x048d, B:161:0x0495, B:163:0x049d, B:164:0x04a5, B:172:0x04bd, B:173:0x04c2, B:175:0x04c6, B:177:0x04ca, B:179:0x04d0, B:183:0x04da, B:186:0x04e9, B:187:0x04ee, B:188:0x04b2, B:189:0x045a, B:191:0x0462, B:193:0x0466, B:195:0x046c, B:197:0x0472, B:200:0x0479, B:201:0x047e, B:203:0x0308, B:205:0x030c, B:207:0x0319, B:209:0x031f, B:210:0x0329, B:218:0x03d6, B:219:0x033f, B:223:0x0345, B:226:0x0351, B:229:0x0356, B:230:0x0363, B:231:0x0364, B:233:0x0373, B:234:0x0376, B:237:0x0383, B:241:0x038c, B:242:0x0394, B:243:0x0395, B:249:0x03a5, B:250:0x03a8, B:251:0x03ac, B:253:0x03ba, B:259:0x03d2, B:260:0x03cc, B:262:0x03cf, B:266:0x0322, B:267:0x0310, B:268:0x04f5, B:271:0x04ff, B:273:0x0503, B:274:0x0535, B:277:0x0544, B:278:0x055f, B:280:0x0519, B:285:0x056a, B:287:0x056e, B:289:0x059d, B:291:0x05c0, B:293:0x05cc, B:294:0x05de, B:298:0x05e8, B:301:0x0611, B:306:0x062c, B:309:0x063b, B:310:0x0668, B:318:0x067b, B:319:0x0682, B:320:0x0683, B:322:0x068c, B:323:0x0696, B:326:0x069f, B:329:0x06be, B:335:0x06d1, B:336:0x06d8, B:337:0x06d9, B:340:0x06e5, B:342:0x06ef, B:344:0x06f3, B:346:0x06f7, B:348:0x06fb, B:350:0x0701, B:354:0x070b, B:356:0x0714, B:357:0x071c, B:360:0x0722, B:362:0x0726, B:363:0x072a, B:365:0x0730, B:367:0x0738, B:369:0x0742, B:370:0x0747, B:371:0x074c, B:376:0x095b, B:378:0x0759, B:380:0x0762, B:381:0x078c, B:383:0x076a, B:385:0x0772, B:388:0x077e, B:393:0x0792, B:395:0x079a, B:399:0x07a1, B:401:0x07c5, B:405:0x07d7, B:410:0x07df, B:412:0x07e7, B:414:0x07ef, B:415:0x07f7, B:418:0x07fe, B:407:0x0808, B:421:0x080c, B:433:0x0829, B:438:0x083c, B:443:0x0851, B:445:0x085e, B:446:0x0874, B:448:0x0875, B:449:0x087c, B:455:0x0889, B:457:0x0891, B:459:0x0899, B:460:0x08a1, B:463:0x08a8, B:451:0x08b2, B:466:0x08b7, B:471:0x08ca, B:472:0x08d1, B:473:0x08db, B:475:0x08e5, B:477:0x08f0, B:480:0x08f7, B:483:0x0901, B:485:0x0906, B:486:0x0907, B:488:0x0929, B:491:0x0930, B:495:0x093a), top: B:48:0x0133, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x074f  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0759 A[Catch: HttpException -> 0x0960, TryCatch #4 {HttpException -> 0x0960, blocks: (B:49:0x0133, B:50:0x0135, B:55:0x0139, B:57:0x013d, B:59:0x0145, B:60:0x015a, B:62:0x015e, B:63:0x0166, B:64:0x0198, B:65:0x019a, B:66:0x019d, B:71:0x01a8, B:73:0x01ad, B:74:0x01b2, B:75:0x01c2, B:76:0x01c6, B:78:0x01ca, B:80:0x01d2, B:81:0x01e7, B:83:0x01eb, B:84:0x01f3, B:85:0x0225, B:92:0x0235, B:93:0x023c, B:95:0x0240, B:97:0x0244, B:98:0x0258, B:99:0x025d, B:101:0x0261, B:102:0x0275, B:103:0x0279, B:110:0x028a, B:112:0x0292, B:113:0x0297, B:114:0x02ab, B:116:0x02af, B:118:0x02b3, B:119:0x02c7, B:120:0x02cc, B:122:0x02d0, B:123:0x02e4, B:128:0x02f0, B:130:0x02f4, B:132:0x02fc, B:134:0x0304, B:136:0x03f5, B:139:0x0402, B:141:0x040e, B:143:0x0420, B:147:0x043f, B:149:0x0443, B:151:0x0449, B:153:0x044f, B:155:0x0455, B:157:0x0485, B:159:0x048d, B:161:0x0495, B:163:0x049d, B:164:0x04a5, B:172:0x04bd, B:173:0x04c2, B:175:0x04c6, B:177:0x04ca, B:179:0x04d0, B:183:0x04da, B:186:0x04e9, B:187:0x04ee, B:188:0x04b2, B:189:0x045a, B:191:0x0462, B:193:0x0466, B:195:0x046c, B:197:0x0472, B:200:0x0479, B:201:0x047e, B:203:0x0308, B:205:0x030c, B:207:0x0319, B:209:0x031f, B:210:0x0329, B:218:0x03d6, B:219:0x033f, B:223:0x0345, B:226:0x0351, B:229:0x0356, B:230:0x0363, B:231:0x0364, B:233:0x0373, B:234:0x0376, B:237:0x0383, B:241:0x038c, B:242:0x0394, B:243:0x0395, B:249:0x03a5, B:250:0x03a8, B:251:0x03ac, B:253:0x03ba, B:259:0x03d2, B:260:0x03cc, B:262:0x03cf, B:266:0x0322, B:267:0x0310, B:268:0x04f5, B:271:0x04ff, B:273:0x0503, B:274:0x0535, B:277:0x0544, B:278:0x055f, B:280:0x0519, B:285:0x056a, B:287:0x056e, B:289:0x059d, B:291:0x05c0, B:293:0x05cc, B:294:0x05de, B:298:0x05e8, B:301:0x0611, B:306:0x062c, B:309:0x063b, B:310:0x0668, B:318:0x067b, B:319:0x0682, B:320:0x0683, B:322:0x068c, B:323:0x0696, B:326:0x069f, B:329:0x06be, B:335:0x06d1, B:336:0x06d8, B:337:0x06d9, B:340:0x06e5, B:342:0x06ef, B:344:0x06f3, B:346:0x06f7, B:348:0x06fb, B:350:0x0701, B:354:0x070b, B:356:0x0714, B:357:0x071c, B:360:0x0722, B:362:0x0726, B:363:0x072a, B:365:0x0730, B:367:0x0738, B:369:0x0742, B:370:0x0747, B:371:0x074c, B:376:0x095b, B:378:0x0759, B:380:0x0762, B:381:0x078c, B:383:0x076a, B:385:0x0772, B:388:0x077e, B:393:0x0792, B:395:0x079a, B:399:0x07a1, B:401:0x07c5, B:405:0x07d7, B:410:0x07df, B:412:0x07e7, B:414:0x07ef, B:415:0x07f7, B:418:0x07fe, B:407:0x0808, B:421:0x080c, B:433:0x0829, B:438:0x083c, B:443:0x0851, B:445:0x085e, B:446:0x0874, B:448:0x0875, B:449:0x087c, B:455:0x0889, B:457:0x0891, B:459:0x0899, B:460:0x08a1, B:463:0x08a8, B:451:0x08b2, B:466:0x08b7, B:471:0x08ca, B:472:0x08d1, B:473:0x08db, B:475:0x08e5, B:477:0x08f0, B:480:0x08f7, B:483:0x0901, B:485:0x0906, B:486:0x0907, B:488:0x0929, B:491:0x0930, B:495:0x093a), top: B:48:0x0133, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0792 A[Catch: HttpException -> 0x0960, TryCatch #4 {HttpException -> 0x0960, blocks: (B:49:0x0133, B:50:0x0135, B:55:0x0139, B:57:0x013d, B:59:0x0145, B:60:0x015a, B:62:0x015e, B:63:0x0166, B:64:0x0198, B:65:0x019a, B:66:0x019d, B:71:0x01a8, B:73:0x01ad, B:74:0x01b2, B:75:0x01c2, B:76:0x01c6, B:78:0x01ca, B:80:0x01d2, B:81:0x01e7, B:83:0x01eb, B:84:0x01f3, B:85:0x0225, B:92:0x0235, B:93:0x023c, B:95:0x0240, B:97:0x0244, B:98:0x0258, B:99:0x025d, B:101:0x0261, B:102:0x0275, B:103:0x0279, B:110:0x028a, B:112:0x0292, B:113:0x0297, B:114:0x02ab, B:116:0x02af, B:118:0x02b3, B:119:0x02c7, B:120:0x02cc, B:122:0x02d0, B:123:0x02e4, B:128:0x02f0, B:130:0x02f4, B:132:0x02fc, B:134:0x0304, B:136:0x03f5, B:139:0x0402, B:141:0x040e, B:143:0x0420, B:147:0x043f, B:149:0x0443, B:151:0x0449, B:153:0x044f, B:155:0x0455, B:157:0x0485, B:159:0x048d, B:161:0x0495, B:163:0x049d, B:164:0x04a5, B:172:0x04bd, B:173:0x04c2, B:175:0x04c6, B:177:0x04ca, B:179:0x04d0, B:183:0x04da, B:186:0x04e9, B:187:0x04ee, B:188:0x04b2, B:189:0x045a, B:191:0x0462, B:193:0x0466, B:195:0x046c, B:197:0x0472, B:200:0x0479, B:201:0x047e, B:203:0x0308, B:205:0x030c, B:207:0x0319, B:209:0x031f, B:210:0x0329, B:218:0x03d6, B:219:0x033f, B:223:0x0345, B:226:0x0351, B:229:0x0356, B:230:0x0363, B:231:0x0364, B:233:0x0373, B:234:0x0376, B:237:0x0383, B:241:0x038c, B:242:0x0394, B:243:0x0395, B:249:0x03a5, B:250:0x03a8, B:251:0x03ac, B:253:0x03ba, B:259:0x03d2, B:260:0x03cc, B:262:0x03cf, B:266:0x0322, B:267:0x0310, B:268:0x04f5, B:271:0x04ff, B:273:0x0503, B:274:0x0535, B:277:0x0544, B:278:0x055f, B:280:0x0519, B:285:0x056a, B:287:0x056e, B:289:0x059d, B:291:0x05c0, B:293:0x05cc, B:294:0x05de, B:298:0x05e8, B:301:0x0611, B:306:0x062c, B:309:0x063b, B:310:0x0668, B:318:0x067b, B:319:0x0682, B:320:0x0683, B:322:0x068c, B:323:0x0696, B:326:0x069f, B:329:0x06be, B:335:0x06d1, B:336:0x06d8, B:337:0x06d9, B:340:0x06e5, B:342:0x06ef, B:344:0x06f3, B:346:0x06f7, B:348:0x06fb, B:350:0x0701, B:354:0x070b, B:356:0x0714, B:357:0x071c, B:360:0x0722, B:362:0x0726, B:363:0x072a, B:365:0x0730, B:367:0x0738, B:369:0x0742, B:370:0x0747, B:371:0x074c, B:376:0x095b, B:378:0x0759, B:380:0x0762, B:381:0x078c, B:383:0x076a, B:385:0x0772, B:388:0x077e, B:393:0x0792, B:395:0x079a, B:399:0x07a1, B:401:0x07c5, B:405:0x07d7, B:410:0x07df, B:412:0x07e7, B:414:0x07ef, B:415:0x07f7, B:418:0x07fe, B:407:0x0808, B:421:0x080c, B:433:0x0829, B:438:0x083c, B:443:0x0851, B:445:0x085e, B:446:0x0874, B:448:0x0875, B:449:0x087c, B:455:0x0889, B:457:0x0891, B:459:0x0899, B:460:0x08a1, B:463:0x08a8, B:451:0x08b2, B:466:0x08b7, B:471:0x08ca, B:472:0x08d1, B:473:0x08db, B:475:0x08e5, B:477:0x08f0, B:480:0x08f7, B:483:0x0901, B:485:0x0906, B:486:0x0907, B:488:0x0929, B:491:0x0930, B:495:0x093a), top: B:48:0x0133, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:401:0x07c5 A[Catch: HttpException -> 0x0960, TryCatch #4 {HttpException -> 0x0960, blocks: (B:49:0x0133, B:50:0x0135, B:55:0x0139, B:57:0x013d, B:59:0x0145, B:60:0x015a, B:62:0x015e, B:63:0x0166, B:64:0x0198, B:65:0x019a, B:66:0x019d, B:71:0x01a8, B:73:0x01ad, B:74:0x01b2, B:75:0x01c2, B:76:0x01c6, B:78:0x01ca, B:80:0x01d2, B:81:0x01e7, B:83:0x01eb, B:84:0x01f3, B:85:0x0225, B:92:0x0235, B:93:0x023c, B:95:0x0240, B:97:0x0244, B:98:0x0258, B:99:0x025d, B:101:0x0261, B:102:0x0275, B:103:0x0279, B:110:0x028a, B:112:0x0292, B:113:0x0297, B:114:0x02ab, B:116:0x02af, B:118:0x02b3, B:119:0x02c7, B:120:0x02cc, B:122:0x02d0, B:123:0x02e4, B:128:0x02f0, B:130:0x02f4, B:132:0x02fc, B:134:0x0304, B:136:0x03f5, B:139:0x0402, B:141:0x040e, B:143:0x0420, B:147:0x043f, B:149:0x0443, B:151:0x0449, B:153:0x044f, B:155:0x0455, B:157:0x0485, B:159:0x048d, B:161:0x0495, B:163:0x049d, B:164:0x04a5, B:172:0x04bd, B:173:0x04c2, B:175:0x04c6, B:177:0x04ca, B:179:0x04d0, B:183:0x04da, B:186:0x04e9, B:187:0x04ee, B:188:0x04b2, B:189:0x045a, B:191:0x0462, B:193:0x0466, B:195:0x046c, B:197:0x0472, B:200:0x0479, B:201:0x047e, B:203:0x0308, B:205:0x030c, B:207:0x0319, B:209:0x031f, B:210:0x0329, B:218:0x03d6, B:219:0x033f, B:223:0x0345, B:226:0x0351, B:229:0x0356, B:230:0x0363, B:231:0x0364, B:233:0x0373, B:234:0x0376, B:237:0x0383, B:241:0x038c, B:242:0x0394, B:243:0x0395, B:249:0x03a5, B:250:0x03a8, B:251:0x03ac, B:253:0x03ba, B:259:0x03d2, B:260:0x03cc, B:262:0x03cf, B:266:0x0322, B:267:0x0310, B:268:0x04f5, B:271:0x04ff, B:273:0x0503, B:274:0x0535, B:277:0x0544, B:278:0x055f, B:280:0x0519, B:285:0x056a, B:287:0x056e, B:289:0x059d, B:291:0x05c0, B:293:0x05cc, B:294:0x05de, B:298:0x05e8, B:301:0x0611, B:306:0x062c, B:309:0x063b, B:310:0x0668, B:318:0x067b, B:319:0x0682, B:320:0x0683, B:322:0x068c, B:323:0x0696, B:326:0x069f, B:329:0x06be, B:335:0x06d1, B:336:0x06d8, B:337:0x06d9, B:340:0x06e5, B:342:0x06ef, B:344:0x06f3, B:346:0x06f7, B:348:0x06fb, B:350:0x0701, B:354:0x070b, B:356:0x0714, B:357:0x071c, B:360:0x0722, B:362:0x0726, B:363:0x072a, B:365:0x0730, B:367:0x0738, B:369:0x0742, B:370:0x0747, B:371:0x074c, B:376:0x095b, B:378:0x0759, B:380:0x0762, B:381:0x078c, B:383:0x076a, B:385:0x0772, B:388:0x077e, B:393:0x0792, B:395:0x079a, B:399:0x07a1, B:401:0x07c5, B:405:0x07d7, B:410:0x07df, B:412:0x07e7, B:414:0x07ef, B:415:0x07f7, B:418:0x07fe, B:407:0x0808, B:421:0x080c, B:433:0x0829, B:438:0x083c, B:443:0x0851, B:445:0x085e, B:446:0x0874, B:448:0x0875, B:449:0x087c, B:455:0x0889, B:457:0x0891, B:459:0x0899, B:460:0x08a1, B:463:0x08a8, B:451:0x08b2, B:466:0x08b7, B:471:0x08ca, B:472:0x08d1, B:473:0x08db, B:475:0x08e5, B:477:0x08f0, B:480:0x08f7, B:483:0x0901, B:485:0x0906, B:486:0x0907, B:488:0x0929, B:491:0x0930, B:495:0x093a), top: B:48:0x0133, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x080c A[Catch: HttpException -> 0x0960, TryCatch #4 {HttpException -> 0x0960, blocks: (B:49:0x0133, B:50:0x0135, B:55:0x0139, B:57:0x013d, B:59:0x0145, B:60:0x015a, B:62:0x015e, B:63:0x0166, B:64:0x0198, B:65:0x019a, B:66:0x019d, B:71:0x01a8, B:73:0x01ad, B:74:0x01b2, B:75:0x01c2, B:76:0x01c6, B:78:0x01ca, B:80:0x01d2, B:81:0x01e7, B:83:0x01eb, B:84:0x01f3, B:85:0x0225, B:92:0x0235, B:93:0x023c, B:95:0x0240, B:97:0x0244, B:98:0x0258, B:99:0x025d, B:101:0x0261, B:102:0x0275, B:103:0x0279, B:110:0x028a, B:112:0x0292, B:113:0x0297, B:114:0x02ab, B:116:0x02af, B:118:0x02b3, B:119:0x02c7, B:120:0x02cc, B:122:0x02d0, B:123:0x02e4, B:128:0x02f0, B:130:0x02f4, B:132:0x02fc, B:134:0x0304, B:136:0x03f5, B:139:0x0402, B:141:0x040e, B:143:0x0420, B:147:0x043f, B:149:0x0443, B:151:0x0449, B:153:0x044f, B:155:0x0455, B:157:0x0485, B:159:0x048d, B:161:0x0495, B:163:0x049d, B:164:0x04a5, B:172:0x04bd, B:173:0x04c2, B:175:0x04c6, B:177:0x04ca, B:179:0x04d0, B:183:0x04da, B:186:0x04e9, B:187:0x04ee, B:188:0x04b2, B:189:0x045a, B:191:0x0462, B:193:0x0466, B:195:0x046c, B:197:0x0472, B:200:0x0479, B:201:0x047e, B:203:0x0308, B:205:0x030c, B:207:0x0319, B:209:0x031f, B:210:0x0329, B:218:0x03d6, B:219:0x033f, B:223:0x0345, B:226:0x0351, B:229:0x0356, B:230:0x0363, B:231:0x0364, B:233:0x0373, B:234:0x0376, B:237:0x0383, B:241:0x038c, B:242:0x0394, B:243:0x0395, B:249:0x03a5, B:250:0x03a8, B:251:0x03ac, B:253:0x03ba, B:259:0x03d2, B:260:0x03cc, B:262:0x03cf, B:266:0x0322, B:267:0x0310, B:268:0x04f5, B:271:0x04ff, B:273:0x0503, B:274:0x0535, B:277:0x0544, B:278:0x055f, B:280:0x0519, B:285:0x056a, B:287:0x056e, B:289:0x059d, B:291:0x05c0, B:293:0x05cc, B:294:0x05de, B:298:0x05e8, B:301:0x0611, B:306:0x062c, B:309:0x063b, B:310:0x0668, B:318:0x067b, B:319:0x0682, B:320:0x0683, B:322:0x068c, B:323:0x0696, B:326:0x069f, B:329:0x06be, B:335:0x06d1, B:336:0x06d8, B:337:0x06d9, B:340:0x06e5, B:342:0x06ef, B:344:0x06f3, B:346:0x06f7, B:348:0x06fb, B:350:0x0701, B:354:0x070b, B:356:0x0714, B:357:0x071c, B:360:0x0722, B:362:0x0726, B:363:0x072a, B:365:0x0730, B:367:0x0738, B:369:0x0742, B:370:0x0747, B:371:0x074c, B:376:0x095b, B:378:0x0759, B:380:0x0762, B:381:0x078c, B:383:0x076a, B:385:0x0772, B:388:0x077e, B:393:0x0792, B:395:0x079a, B:399:0x07a1, B:401:0x07c5, B:405:0x07d7, B:410:0x07df, B:412:0x07e7, B:414:0x07ef, B:415:0x07f7, B:418:0x07fe, B:407:0x0808, B:421:0x080c, B:433:0x0829, B:438:0x083c, B:443:0x0851, B:445:0x085e, B:446:0x0874, B:448:0x0875, B:449:0x087c, B:455:0x0889, B:457:0x0891, B:459:0x0899, B:460:0x08a1, B:463:0x08a8, B:451:0x08b2, B:466:0x08b7, B:471:0x08ca, B:472:0x08d1, B:473:0x08db, B:475:0x08e5, B:477:0x08f0, B:480:0x08f7, B:483:0x0901, B:485:0x0906, B:486:0x0907, B:488:0x0929, B:491:0x0930, B:495:0x093a), top: B:48:0x0133, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:466:0x08b7 A[Catch: HttpException -> 0x0960, TryCatch #4 {HttpException -> 0x0960, blocks: (B:49:0x0133, B:50:0x0135, B:55:0x0139, B:57:0x013d, B:59:0x0145, B:60:0x015a, B:62:0x015e, B:63:0x0166, B:64:0x0198, B:65:0x019a, B:66:0x019d, B:71:0x01a8, B:73:0x01ad, B:74:0x01b2, B:75:0x01c2, B:76:0x01c6, B:78:0x01ca, B:80:0x01d2, B:81:0x01e7, B:83:0x01eb, B:84:0x01f3, B:85:0x0225, B:92:0x0235, B:93:0x023c, B:95:0x0240, B:97:0x0244, B:98:0x0258, B:99:0x025d, B:101:0x0261, B:102:0x0275, B:103:0x0279, B:110:0x028a, B:112:0x0292, B:113:0x0297, B:114:0x02ab, B:116:0x02af, B:118:0x02b3, B:119:0x02c7, B:120:0x02cc, B:122:0x02d0, B:123:0x02e4, B:128:0x02f0, B:130:0x02f4, B:132:0x02fc, B:134:0x0304, B:136:0x03f5, B:139:0x0402, B:141:0x040e, B:143:0x0420, B:147:0x043f, B:149:0x0443, B:151:0x0449, B:153:0x044f, B:155:0x0455, B:157:0x0485, B:159:0x048d, B:161:0x0495, B:163:0x049d, B:164:0x04a5, B:172:0x04bd, B:173:0x04c2, B:175:0x04c6, B:177:0x04ca, B:179:0x04d0, B:183:0x04da, B:186:0x04e9, B:187:0x04ee, B:188:0x04b2, B:189:0x045a, B:191:0x0462, B:193:0x0466, B:195:0x046c, B:197:0x0472, B:200:0x0479, B:201:0x047e, B:203:0x0308, B:205:0x030c, B:207:0x0319, B:209:0x031f, B:210:0x0329, B:218:0x03d6, B:219:0x033f, B:223:0x0345, B:226:0x0351, B:229:0x0356, B:230:0x0363, B:231:0x0364, B:233:0x0373, B:234:0x0376, B:237:0x0383, B:241:0x038c, B:242:0x0394, B:243:0x0395, B:249:0x03a5, B:250:0x03a8, B:251:0x03ac, B:253:0x03ba, B:259:0x03d2, B:260:0x03cc, B:262:0x03cf, B:266:0x0322, B:267:0x0310, B:268:0x04f5, B:271:0x04ff, B:273:0x0503, B:274:0x0535, B:277:0x0544, B:278:0x055f, B:280:0x0519, B:285:0x056a, B:287:0x056e, B:289:0x059d, B:291:0x05c0, B:293:0x05cc, B:294:0x05de, B:298:0x05e8, B:301:0x0611, B:306:0x062c, B:309:0x063b, B:310:0x0668, B:318:0x067b, B:319:0x0682, B:320:0x0683, B:322:0x068c, B:323:0x0696, B:326:0x069f, B:329:0x06be, B:335:0x06d1, B:336:0x06d8, B:337:0x06d9, B:340:0x06e5, B:342:0x06ef, B:344:0x06f3, B:346:0x06f7, B:348:0x06fb, B:350:0x0701, B:354:0x070b, B:356:0x0714, B:357:0x071c, B:360:0x0722, B:362:0x0726, B:363:0x072a, B:365:0x0730, B:367:0x0738, B:369:0x0742, B:370:0x0747, B:371:0x074c, B:376:0x095b, B:378:0x0759, B:380:0x0762, B:381:0x078c, B:383:0x076a, B:385:0x0772, B:388:0x077e, B:393:0x0792, B:395:0x079a, B:399:0x07a1, B:401:0x07c5, B:405:0x07d7, B:410:0x07df, B:412:0x07e7, B:414:0x07ef, B:415:0x07f7, B:418:0x07fe, B:407:0x0808, B:421:0x080c, B:433:0x0829, B:438:0x083c, B:443:0x0851, B:445:0x085e, B:446:0x0874, B:448:0x0875, B:449:0x087c, B:455:0x0889, B:457:0x0891, B:459:0x0899, B:460:0x08a1, B:463:0x08a8, B:451:0x08b2, B:466:0x08b7, B:471:0x08ca, B:472:0x08d1, B:473:0x08db, B:475:0x08e5, B:477:0x08f0, B:480:0x08f7, B:483:0x0901, B:485:0x0906, B:486:0x0907, B:488:0x0929, B:491:0x0930, B:495:0x093a), top: B:48:0x0133, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:474:0x08e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:494:0x093a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:508:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x00c3 A[Catch: HttpException -> 0x0964, TryCatch #2 {HttpException -> 0x0964, blocks: (B:3:0x0004, B:7:0x0009, B:9:0x000d, B:10:0x0013, B:12:0x0019, B:14:0x0021, B:16:0x002b, B:509:0x00d9, B:20:0x00e2, B:21:0x00ea, B:23:0x00f4, B:25:0x00f8, B:27:0x00fc, B:28:0x0101, B:31:0x010f, B:37:0x0114, B:38:0x0119, B:39:0x011a, B:511:0x006b, B:513:0x0071, B:515:0x0079, B:517:0x007d, B:518:0x009d, B:522:0x00a5, B:524:0x00ab, B:525:0x00b0, B:526:0x00b4, B:528:0x00c3, B:530:0x00c9, B:533:0x00d0, B:534:0x00d5, B:536:0x00d7, B:537:0x00b8, B:538:0x00bf, B:543:0x005b), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:536:0x00d7 A[Catch: HttpException -> 0x0964, TryCatch #2 {HttpException -> 0x0964, blocks: (B:3:0x0004, B:7:0x0009, B:9:0x000d, B:10:0x0013, B:12:0x0019, B:14:0x0021, B:16:0x002b, B:509:0x00d9, B:20:0x00e2, B:21:0x00ea, B:23:0x00f4, B:25:0x00f8, B:27:0x00fc, B:28:0x0101, B:31:0x010f, B:37:0x0114, B:38:0x0119, B:39:0x011a, B:511:0x006b, B:513:0x0071, B:515:0x0079, B:517:0x007d, B:518:0x009d, B:522:0x00a5, B:524:0x00ab, B:525:0x00b0, B:526:0x00b4, B:528:0x00c3, B:530:0x00c9, B:533:0x00d0, B:534:0x00d5, B:536:0x00d7, B:537:0x00b8, B:538:0x00bf, B:543:0x005b), top: B:2:0x0004 }] */
    /* JADX WARN: Type inference failed for: r2v147, types: [org.eclipse.jetty.http.HttpParser$EventHandler] */
    /* JADX WARN: Type inference failed for: r2v151, types: [org.eclipse.jetty.io.BufferCache, org.eclipse.jetty.http.HttpHeaderValues] */
    /* JADX WARN: Type inference failed for: r7v39, types: [org.eclipse.jetty.io.BufferCache, org.eclipse.jetty.http.HttpHeaderValues] */
    /* JADX WARN: Type inference failed for: r7v40, types: [org.eclipse.jetty.io.BufferCache, org.eclipse.jetty.http.HttpHeaderValues] */
    /* JADX WARN: Type inference failed for: r8v14, types: [org.eclipse.jetty.io.AbstractBuffer, org.eclipse.jetty.io.Buffer] */
    /* JADX WARN: Type inference failed for: r8v15, types: [org.eclipse.jetty.io.Buffer] */
    /* JADX WARN: Type inference failed for: r8v16, types: [org.eclipse.jetty.io.Buffer] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int parseNext() throws IOException {
        HttpException httpException;
        IOException iOException;
        int i;
        int i2;
        EventHandler eventHandler;
        long j;
        int length;
        int length2;
        int i3;
        Buffer buffer;
        int i4;
        String str;
        Buffer buffer2;
        int i5;
        Buffer buffer3;
        long j2;
        int i6;
        EventHandler eventHandler2;
        int i7;
        int i8;
        boolean z = false;
        byte b = 0;
        try {
            if (this._state == 0) {
                return 0;
            }
            if (this._buffer == null) {
                this._buffer = getHeaderBuffer();
            }
            if (this._state == 2 && this._contentPosition == this._contentLength) {
                this._state = 0;
                this._handler.messageComplete(this._contentPosition);
                return 1;
            }
            int length3 = this._buffer.length();
            if (length3 == 0) {
                try {
                    i = fill();
                } catch (IOException e) {
                    iOException = e;
                    i = -1;
                }
                try {
                    LOG.debug("filled {}/{}", Integer.valueOf(i), Integer.valueOf(this._buffer.length()));
                    iOException = null;
                } catch (IOException e2) {
                    iOException = e2;
                    LOG.debug(toString(), iOException);
                    if (i <= 0) {
                    }
                    length = this._buffer.length();
                    byte[] array = this._buffer.array();
                    int i9 = this._state;
                    while (this._state < 0) {
                    }
                    if (this._responseStatus > 0) {
                    }
                    length2 = this._buffer.length();
                    i3 = this._state;
                    while (this._state > 0) {
                    }
                    return i2;
                }
                if (i <= 0) {
                    i2 = 1;
                } else if (i < 0) {
                    this._persistent = false;
                    if (this._state > 0 && this._buffer.length() > 0 && !this._headResponse) {
                        Buffer buffer4 = this._buffer.get(this._buffer.length());
                        this._contentPosition += buffer4.length();
                        this._contentView.update(buffer4);
                        this._handler.content(buffer4);
                    }
                    int i10 = this._state;
                    if (i10 != 0) {
                        if (i10 == 1) {
                            this._state = 0;
                            eventHandler = this._handler;
                            j = this._contentPosition;
                        } else if (i10 != 7) {
                            this._state = 0;
                            if (!this._headResponse) {
                                this._handler.earlyEOF();
                            }
                            eventHandler = this._handler;
                            j = this._contentPosition;
                        }
                        eventHandler.messageComplete(j);
                        if (iOException == null) {
                            throw iOException;
                        }
                        if (!isComplete() && !isIdle()) {
                            throw new EofException();
                        }
                        return -1;
                    }
                    this._state = 0;
                    if (iOException == null) {
                    }
                } else {
                    i2 = 0;
                }
                length = this._buffer.length();
            } else {
                length = length3;
                i2 = 0;
            }
            byte[] array2 = this._buffer.array();
            int i92 = this._state;
            while (this._state < 0) {
                int i11 = length - 1;
                if (length <= 0) {
                    if (this._responseStatus > 0 && this._headResponse) {
                        if (!this._persistent && (this._responseStatus < 100 || this._responseStatus >= 200)) {
                            i4 = 7;
                            this._state = i4;
                            this._handler.messageComplete(this._contentLength);
                        }
                        i4 = 0;
                        this._state = i4;
                        this._handler.messageComplete(this._contentLength);
                    }
                    length2 = this._buffer.length();
                    i3 = this._state;
                    while (this._state > 0 && length2 > 0) {
                        if (i3 != this._state) {
                            i2++;
                            i3 = this._state;
                        }
                        if (this._eol == 13 || this._buffer.peek() != 10) {
                            this._eol = (byte) 0;
                            switch (this._state) {
                                case 1:
                                    Buffer buffer5 = this._buffer.get(this._buffer.length());
                                    this._contentPosition += buffer5.length();
                                    this._contentView.update(buffer5);
                                    this._handler.content(buffer5);
                                    return 1;
                                case 2:
                                    long j3 = this._contentLength - this._contentPosition;
                                    if (j3 == 0) {
                                        this._state = this._persistent ? 0 : 7;
                                        this._handler.messageComplete(this._contentPosition);
                                        return 1;
                                    }
                                    if (length2 > j3) {
                                        length2 = (int) j3;
                                    }
                                    Buffer buffer6 = this._buffer.get(length2);
                                    this._contentPosition += buffer6.length();
                                    this._contentView.update(buffer6);
                                    this._handler.content(buffer6);
                                    if (this._contentPosition == this._contentLength) {
                                        this._state = this._persistent ? 0 : 7;
                                        this._handler.messageComplete(this._contentPosition);
                                    }
                                    return 1;
                                case 3:
                                    byte peek = this._buffer.peek();
                                    if (peek != 13 && peek != 10) {
                                        if (peek <= 32) {
                                            this._buffer.get();
                                            break;
                                        } else {
                                            this._chunkLength = 0;
                                            this._chunkPosition = 0;
                                            this._state = 4;
                                            break;
                                        }
                                    }
                                    this._eol = this._buffer.get();
                                case 4:
                                    byte b2 = this._buffer.get();
                                    if (b2 != 13 && b2 != 10) {
                                        if (b2 > 32 && b2 != 59) {
                                            if (b2 >= 48 && b2 <= 57) {
                                                this._chunkLength = (b2 - 48) + (this._chunkLength * 16);
                                            } else if (b2 >= 97 && b2 <= 102) {
                                                this._chunkLength = ((b2 + 10) - 97) + (this._chunkLength * 16);
                                            } else if (b2 < 65 || b2 > 70) {
                                                throw new IOException("bad chunk char: " + ((int) b2));
                                            } else {
                                                this._chunkLength = ((b2 + 10) - 65) + (this._chunkLength * 16);
                                            }
                                            break;
                                        }
                                        this._state = 5;
                                    }
                                    this._eol = b2;
                                    if (this._chunkLength == 0) {
                                        if (b2 == 13 && this._buffer.hasContent() && this._buffer.peek() == 10) {
                                            this._eol = this._buffer.get();
                                        }
                                        this._state = this._persistent ? 0 : 7;
                                        this._handler.messageComplete(this._contentPosition);
                                        return 1;
                                    }
                                    this._state = 6;
                                    break;
                                case 5:
                                    byte b3 = this._buffer.get();
                                    if (b3 != 13) {
                                        if (b3 == 10) {
                                        }
                                        break;
                                    }
                                    this._eol = b3;
                                    if (this._chunkLength == 0) {
                                        if (b3 == 13 && this._buffer.hasContent() && this._buffer.peek() == 10) {
                                            this._eol = this._buffer.get();
                                        }
                                        this._state = this._persistent ? 0 : 7;
                                        this._handler.messageComplete(this._contentPosition);
                                        return 1;
                                    }
                                    this._state = 6;
                                    break;
                                case 6:
                                    int i12 = this._chunkLength - this._chunkPosition;
                                    if (i12 != 0) {
                                        if (length2 > i12) {
                                            length2 = i12;
                                        }
                                        Buffer buffer7 = this._buffer.get(length2);
                                        this._contentPosition += buffer7.length();
                                        this._chunkPosition += buffer7.length();
                                        this._contentView.update(buffer7);
                                        this._handler.content(buffer7);
                                        return 1;
                                    }
                                    this._state = 3;
                                    break;
                                case 7:
                                    if (this._buffer.length() > 2) {
                                        this._state = 0;
                                        this._endp.close();
                                    } else {
                                        while (this._buffer.length() > 0) {
                                            if (!Character.isWhitespace(this._buffer.get())) {
                                                this._state = 0;
                                                this._endp.close();
                                                this._buffer.clear();
                                            }
                                        }
                                    }
                                    this._buffer.clear();
                                    break;
                            }
                            buffer = this._buffer;
                        } else {
                            this._eol = this._buffer.get();
                            buffer = this._buffer;
                        }
                        length2 = buffer.length();
                    }
                    return i2;
                }
                if (i92 != this._state) {
                    i2++;
                    i92 = this._state;
                }
                byte b4 = this._buffer.get();
                if (this._eol != 13) {
                    this._eol = b;
                    switch (this._state) {
                        case -14:
                            this._contentLength = -3L;
                            this._cached = null;
                            if (b4 > 32 || b4 < 0) {
                                this._buffer.mark();
                                this._state = -13;
                                break;
                            }
                        case -13:
                            if (b4 == 32) {
                                this._tok0.update(this._buffer.markIndex(), this._buffer.getIndex() - 1);
                                this._responseStatus = HttpVersions.CACHE.get(this._tok0) == null ? -1 : 0;
                                this._state = -12;
                                break;
                            } else if (b4 < 32 && b4 >= 0) {
                                throw new HttpException(400);
                            }
                        case -12:
                            if (b4 <= 32 && b4 >= 0) {
                                if (b4 < 32) {
                                    throw new HttpException(400);
                                }
                            }
                            this._buffer.mark();
                            if (this._responseStatus >= 0) {
                                this._state = -11;
                                this._responseStatus = b4 - 48;
                            } else {
                                this._state = -10;
                            }
                        case -11:
                            if (b4 == 32) {
                                this._tok1.update(this._buffer.markIndex(), this._buffer.getIndex() - 1);
                                this._state = -9;
                                break;
                            } else if (b4 >= 48 && b4 <= 57) {
                                this._responseStatus = (b4 - 48) + (this._responseStatus * 10);
                                break;
                            } else if (b4 < 32 && b4 >= 0) {
                                this._handler.startResponse(HttpMethods.CACHE.lookup(this._tok0), this._responseStatus, null);
                                this._eol = b4;
                                this._state = -5;
                                this._tok0.setPutIndex(this._tok0.getIndex());
                                this._tok1.setPutIndex(this._tok1.getIndex());
                                str = null;
                                this._multiLineValue = str;
                                break;
                            } else {
                                this._state = -10;
                                this._responseStatus = -1;
                            }
                            break;
                        case -10:
                            if (b4 == 32) {
                                this._tok1.update(this._buffer.markIndex(), this._buffer.getIndex() - 1);
                                this._state = -9;
                                break;
                            } else if (b4 < 32 && b4 >= 0) {
                                this._handler.startRequest(HttpMethods.CACHE.lookup(this._tok0), this._buffer.sliceFromMark(), null);
                                this._persistent = false;
                                this._state = 7;
                                this._handler.headerComplete();
                                this._handler.messageComplete(this._contentPosition);
                                return 1;
                            }
                        case -9:
                            if (b4 <= 32 && b4 >= 0) {
                                if (b4 < 32) {
                                    if (this._responseStatus <= 0) {
                                        this._handler.startRequest(HttpMethods.CACHE.lookup(this._tok0), this._tok1, null);
                                        this._persistent = false;
                                        this._state = 7;
                                        this._handler.headerComplete();
                                        this._handler.messageComplete(this._contentPosition);
                                        return 1;
                                    }
                                    this._handler.startResponse(HttpMethods.CACHE.lookup(this._tok0), this._responseStatus, null);
                                    this._eol = b4;
                                    this._state = -5;
                                    this._tok0.setPutIndex(this._tok0.getIndex());
                                    this._tok1.setPutIndex(this._tok1.getIndex());
                                    this._multiLineValue = null;
                                }
                            }
                            this._buffer.mark();
                            this._state = -6;
                        case -6:
                            if (b4 == 13 || b4 == 10) {
                                if (this._responseStatus > 0) {
                                    EventHandler eventHandler3 = this._handler;
                                    buffer2 = HttpVersions.CACHE.lookup(this._tok0);
                                    eventHandler3.startResponse(buffer2, this._responseStatus, this._buffer.sliceFromMark());
                                } else {
                                    EventHandler eventHandler4 = this._handler;
                                    Buffer lookup = HttpMethods.CACHE.lookup(this._tok0);
                                    View.CaseInsensitive caseInsensitive = this._tok1;
                                    Buffer lookup2 = HttpVersions.CACHE.lookup(this._buffer.sliceFromMark());
                                    eventHandler4.startRequest(lookup, caseInsensitive, lookup2);
                                    buffer2 = lookup2;
                                }
                                this._eol = b4;
                                this._persistent = HttpVersions.CACHE.getOrdinal(buffer2) >= 11;
                                this._state = -5;
                                this._tok0.setPutIndex(this._tok0.getIndex());
                                this._tok1.setPutIndex(this._tok1.getIndex());
                                str = null;
                                this._multiLineValue = str;
                                break;
                            }
                        case -5:
                            if (b4 != 9 && b4 != 32 && b4 != 58) {
                                if (this._cached != null || this._tok0.length() > 0 || this._tok1.length() > 0 || this._multiLineValue != null) {
                                    Buffer lookup3 = this._cached != null ? this._cached : HttpHeaders.CACHE.lookup(this._tok0);
                                    this._cached = null;
                                    ?? byteArrayBuffer = this._multiLineValue == null ? this._tok1 : new ByteArrayBuffer(this._multiLineValue);
                                    int ordinal = HttpHeaders.CACHE.getOrdinal(lookup3);
                                    if (ordinal < 0) {
                                        buffer3 = lookup3;
                                    } else if (ordinal != 1) {
                                        buffer3 = lookup3;
                                        if (ordinal == 5) {
                                            byteArrayBuffer = HttpHeaderValues.CACHE.lookup(byteArrayBuffer);
                                            if (2 != HttpHeaderValues.CACHE.getOrdinal(byteArrayBuffer)) {
                                                String buffer8 = byteArrayBuffer.toString("ISO-8859-1");
                                                if (!buffer8.endsWith("chunked")) {
                                                    if (buffer8.indexOf("chunked") >= 0) {
                                                        throw new HttpException(400, null);
                                                    }
                                                }
                                            }
                                            this._contentLength = -2L;
                                        } else if (ordinal == 12 && this._contentLength != -2) {
                                            try {
                                                long j4 = BufferUtil.toLong(byteArrayBuffer);
                                                this._contentLength = j4;
                                                if (j4 <= 0) {
                                                    this._contentLength = 0L;
                                                }
                                            } catch (NumberFormatException e3) {
                                                LOG.ignore(e3);
                                                throw new HttpException(400);
                                            }
                                        }
                                    } else {
                                        buffer3 = lookup3;
                                        int ordinal2 = HttpHeaderValues.CACHE.getOrdinal(byteArrayBuffer);
                                        if (ordinal2 == -1) {
                                            for (String str2 : byteArrayBuffer.toString().split(",")) {
                                                int ordinal3 = HttpHeaderValues.CACHE.getOrdinal(str2.trim());
                                                if (ordinal3 == 1) {
                                                    this._persistent = false;
                                                } else if (ordinal3 == 5) {
                                                    this._persistent = true;
                                                }
                                            }
                                        } else if (ordinal2 == 1) {
                                            this._persistent = false;
                                        } else if (ordinal2 == 5) {
                                            this._persistent = true;
                                        }
                                    }
                                    this._handler.parsedHeader(buffer3, byteArrayBuffer);
                                    this._tok0.setPutIndex(this._tok0.getIndex());
                                    this._tok1.setPutIndex(this._tok1.getIndex());
                                    this._multiLineValue = null;
                                }
                                this._buffer.setMarkIndex(-1);
                                if (b4 != 13 && b4 != 10) {
                                    this._length = 1;
                                    this._buffer.mark();
                                    this._state = -4;
                                    if (array2 != null) {
                                        BufferCache.CachedBuffer best = HttpHeaders.CACHE.getBest(array2, this._buffer.markIndex(), i11 + 1);
                                        this._cached = best;
                                        if (best != null) {
                                            this._length = best.length();
                                            this._buffer.setGetIndex(this._buffer.markIndex() + this._length);
                                            length = this._buffer.length();
                                            continue;
                                            b = 0;
                                        }
                                    }
                                }
                                if (this._responseStatus > 0 && (this._responseStatus == 304 || this._responseStatus == 204 || this._responseStatus < 200)) {
                                    this._contentLength = 0L;
                                } else if (this._contentLength == -3) {
                                    if (this._responseStatus != 0 && this._responseStatus != 304 && this._responseStatus != 204 && this._responseStatus >= 200) {
                                        this._contentLength = -1L;
                                    }
                                    j2 = 0;
                                    this._contentLength = 0L;
                                    this._contentPosition = j2;
                                    this._eol = b4;
                                    if (b4 == 13 && this._buffer.hasContent() && this._buffer.peek() == 10) {
                                        this._eol = this._buffer.get();
                                    }
                                    i6 = this._contentLength <= 2147483647L ? Integer.MAX_VALUE : (int) this._contentLength;
                                    if (i6 != -2) {
                                        this._state = 3;
                                        eventHandler2 = this._handler;
                                    } else if (i6 == -1) {
                                        this._state = 1;
                                        eventHandler2 = this._handler;
                                    } else if (i6 == 0) {
                                        if (!this._persistent && (this._responseStatus < 100 || this._responseStatus >= 200)) {
                                            i7 = 7;
                                            this._state = i7;
                                            this._handler.headerComplete();
                                            this._handler.messageComplete(this._contentPosition);
                                            return 1;
                                        }
                                        i7 = 0;
                                        this._state = i7;
                                        this._handler.headerComplete();
                                        this._handler.messageComplete(this._contentPosition);
                                        return 1;
                                    } else {
                                        this._state = 2;
                                        eventHandler2 = this._handler;
                                    }
                                    eventHandler2.headerComplete();
                                    return 1;
                                }
                                j2 = 0;
                                this._contentPosition = j2;
                                this._eol = b4;
                                if (b4 == 13) {
                                    this._eol = this._buffer.get();
                                }
                                if (this._contentLength <= 2147483647L) {
                                }
                                if (i6 != -2) {
                                }
                                eventHandler2.headerComplete();
                                return 1;
                            }
                            this._length = -1;
                            i5 = -2;
                            this._state = i5;
                            break;
                        case -4:
                            if (b4 != 9) {
                                if (b4 == 10 || b4 == 13) {
                                    if (this._length > 0) {
                                        this._tok0.update(this._buffer.markIndex(), this._buffer.markIndex() + this._length);
                                    }
                                    this._eol = b4;
                                    this._state = -5;
                                } else if (b4 != 32) {
                                    if (b4 != 58) {
                                        this._cached = null;
                                        if (this._length == -1) {
                                            this._buffer.mark();
                                        }
                                        this._length = this._buffer.getIndex() - this._buffer.markIndex();
                                        this._state = -3;
                                    } else {
                                        if (this._length > 0 && this._cached == null) {
                                            this._tok0.update(this._buffer.markIndex(), this._buffer.markIndex() + this._length);
                                        }
                                        this._length = -1;
                                        this._state = -2;
                                    }
                                }
                            }
                            break;
                        case -3:
                            if (b4 != 9) {
                                if (b4 == 10 || b4 == 13) {
                                    if (this._length > 0) {
                                        this._tok0.update(this._buffer.markIndex(), this._buffer.markIndex() + this._length);
                                    }
                                    this._eol = b4;
                                    this._state = -5;
                                } else if (b4 != 32) {
                                    if (b4 != 58) {
                                        this._cached = null;
                                        i8 = this._length;
                                        this._length = i8 + 1;
                                    } else {
                                        if (this._length > 0 && this._cached == null) {
                                            this._tok0.update(this._buffer.markIndex(), this._buffer.markIndex() + this._length);
                                        }
                                        this._length = -1;
                                        this._state = -2;
                                    }
                                }
                            }
                            this._state = -4;
                            break;
                        case -2:
                            if (b4 != 9) {
                                if (b4 == 10 || b4 == 13) {
                                    if (this._length > 0) {
                                        if (this._tok1.length() == 0) {
                                            this._tok1.update(this._buffer.markIndex(), this._buffer.markIndex() + this._length);
                                        } else {
                                            if (this._multiLineValue == null) {
                                                this._multiLineValue = this._tok1.toString("ISO-8859-1");
                                            }
                                            this._tok1.update(this._buffer.markIndex(), this._buffer.markIndex() + this._length);
                                            this._multiLineValue += StringUtils.SPACE + this._tok1.toString("ISO-8859-1");
                                        }
                                    }
                                    this._eol = b4;
                                    this._state = -5;
                                } else if (b4 != 32) {
                                    if (this._length == -1) {
                                        this._buffer.mark();
                                    }
                                    this._length = this._buffer.getIndex() - this._buffer.markIndex();
                                    i5 = -1;
                                    this._state = i5;
                                }
                            }
                        case -1:
                            if (b4 != 9) {
                                if (b4 == 10 || b4 == 13) {
                                    if (this._length > 0) {
                                        if (this._tok1.length() == 0) {
                                            this._tok1.update(this._buffer.markIndex(), this._buffer.markIndex() + this._length);
                                        } else {
                                            if (this._multiLineValue == null) {
                                                this._multiLineValue = this._tok1.toString("ISO-8859-1");
                                            }
                                            this._tok1.update(this._buffer.markIndex(), this._buffer.markIndex() + this._length);
                                            this._multiLineValue += StringUtils.SPACE + this._tok1.toString("ISO-8859-1");
                                        }
                                    }
                                    this._eol = b4;
                                    this._state = -5;
                                } else if (b4 != 32) {
                                    try {
                                        i8 = this._length;
                                        this._length = i8 + 1;
                                    } catch (HttpException e4) {
                                        httpException = e4;
                                        z = false;
                                        this._persistent = z;
                                        this._state = 7;
                                        throw httpException;
                                    }
                                }
                            }
                            this._state = -2;
                    }
                    length = i11;
                    b = 0;
                } else if (b4 != 10) {
                    throw new HttpException(400);
                } else {
                    this._eol = (byte) 10;
                }
                length = i11;
                b = 0;
            }
            if (this._responseStatus > 0) {
                if (!this._persistent) {
                    i4 = 7;
                    this._state = i4;
                    this._handler.messageComplete(this._contentLength);
                }
                i4 = 0;
                this._state = i4;
                this._handler.messageComplete(this._contentLength);
            }
            length2 = this._buffer.length();
            i3 = this._state;
            while (this._state > 0) {
                if (i3 != this._state) {
                }
                if (this._eol == 13) {
                }
                this._eol = (byte) 0;
                switch (this._state) {
                }
                buffer = this._buffer;
                length2 = buffer.length();
            }
            return i2;
        } catch (HttpException e5) {
            httpException = e5;
        }
    }

    @Override // org.eclipse.jetty.http.Parser
    public void reset() {
        Buffer buffer;
        View view = this._contentView;
        view.setGetIndex(view.putIndex());
        this._state = this._persistent ? -14 : this._endp.isInputShutdown() ? 0 : 7;
        this._contentLength = -3L;
        this._contentPosition = 0L;
        this._length = 0;
        this._responseStatus = 0;
        if (this._eol == 13 && (buffer = this._buffer) != null && buffer.hasContent() && this._buffer.peek() == 10) {
            this._eol = this._buffer.get();
        }
        Buffer buffer2 = this._body;
        if (buffer2 != null && buffer2.hasContent()) {
            Buffer buffer3 = this._header;
            if (buffer3 == null) {
                getHeaderBuffer();
            } else {
                buffer3.setMarkIndex(-1);
                this._header.compact();
            }
            int space = this._header.space();
            if (space > this._body.length()) {
                space = this._body.length();
            }
            Buffer buffer4 = this._body;
            buffer4.peek(buffer4.getIndex(), space);
            Buffer buffer5 = this._body;
            buffer5.skip(this._header.put(buffer5.peek(buffer5.getIndex(), space)));
        }
        Buffer buffer6 = this._header;
        if (buffer6 != null) {
            buffer6.setMarkIndex(-1);
            this._header.compact();
        }
        Buffer buffer7 = this._body;
        if (buffer7 != null) {
            buffer7.setMarkIndex(-1);
        }
        this._buffer = this._header;
        returnBuffers();
    }

    @Override // org.eclipse.jetty.http.Parser
    public void returnBuffers() {
        Buffer buffer = this._body;
        if (buffer != null && !buffer.hasContent() && this._body.markIndex() == -1 && this._buffers != null) {
            if (this._buffer == this._body) {
                this._buffer = this._header;
            }
            Buffers buffers = this._buffers;
            if (buffers != null) {
                buffers.returnBuffer(this._body);
            }
            this._body = null;
        }
        Buffer buffer2 = this._header;
        if (buffer2 == null || buffer2.hasContent() || this._header.markIndex() != -1 || this._buffers == null) {
            return;
        }
        if (this._buffer == this._header) {
            this._buffer = null;
        }
        this._buffers.returnBuffer(this._header);
        this._header = null;
    }

    public void setForceContentBuffer(boolean z) {
        this._forceContentBuffer = z;
    }

    public void setHeadResponse(boolean z) {
        this._headResponse = z;
    }

    @Override // org.eclipse.jetty.http.Parser
    public void setPersistent(boolean z) {
        this._persistent = z;
        if (!z) {
            int i = this._state;
            if (i != 0 && i != -14) {
                return;
            }
            this._state = 7;
        }
    }

    public void setState(int i) {
        this._state = i;
        this._contentLength = -3L;
    }

    public String toString() {
        return String.format("%s{s=%d,l=%d,c=%d}", HttpParser.class.getSimpleName(), Integer.valueOf(this._state), Integer.valueOf(this._length), Long.valueOf(this._contentLength));
    }

    public String toString(Buffer buffer) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("state=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._state);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" length=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._length);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" buf=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(buffer.hashCode());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

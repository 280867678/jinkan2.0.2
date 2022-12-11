package org.apache.http.impl.p057io;

import java.io.IOException;
import java.io.InputStream;
import me.tvspark.outline;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.TruncatedChunkException;
import org.apache.http.config.MessageConstraints;
import org.apache.http.p058io.BufferInfo;
import org.apache.http.p058io.SessionInputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* renamed from: org.apache.http.impl.io.ChunkedInputStream */
/* loaded from: classes4.dex */
public class ChunkedInputStream extends InputStream {
    public static final int BUFFER_SIZE = 2048;
    public static final int CHUNK_CRLF = 3;
    public static final int CHUNK_DATA = 2;
    public static final int CHUNK_INVALID = Integer.MAX_VALUE;
    public static final int CHUNK_LEN = 1;
    public final CharArrayBuffer buffer;
    public long chunkSize;
    public boolean closed;
    public final MessageConstraints constraints;
    public boolean eof;
    public Header[] footers;

    /* renamed from: in */
    public final SessionInputBuffer f4573in;
    public long pos;
    public int state;

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer) {
        this(sessionInputBuffer, null);
    }

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        this.eof = false;
        this.closed = false;
        this.footers = new Header[0];
        this.f4573in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.pos = 0L;
        this.buffer = new CharArrayBuffer(16);
        this.constraints = messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints;
        this.state = 1;
    }

    private long getChunkSize() throws IOException {
        int i = this.state;
        if (i != 1) {
            if (i != 3) {
                throw new IllegalStateException("Inconsistent codec state");
            }
            this.buffer.clear();
            if (this.f4573in.readLine(this.buffer) == -1) {
                throw new MalformedChunkCodingException("CRLF expected at end of chunk");
            }
            if (!this.buffer.isEmpty()) {
                throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
            }
            this.state = 1;
        }
        this.buffer.clear();
        if (this.f4573in.readLine(this.buffer) != -1) {
            int indexOf = this.buffer.indexOf(59);
            if (indexOf < 0) {
                indexOf = this.buffer.length();
            }
            String substringTrimmed = this.buffer.substringTrimmed(0, indexOf);
            try {
                return Long.parseLong(substringTrimmed, 16);
            } catch (NumberFormatException unused) {
                throw new MalformedChunkCodingException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bad chunk header: ", substringTrimmed));
            }
        }
        throw new ConnectionClosedException("Premature end of chunk coded message body: closing chunk expected");
    }

    private void nextChunk() throws IOException {
        if (this.state != Integer.MAX_VALUE) {
            try {
                long chunkSize = getChunkSize();
                this.chunkSize = chunkSize;
                if (chunkSize < 0) {
                    throw new MalformedChunkCodingException("Negative chunk size");
                }
                this.state = 2;
                this.pos = 0L;
                if (chunkSize != 0) {
                    return;
                }
                this.eof = true;
                parseTrailerHeaders();
                return;
            } catch (MalformedChunkCodingException e) {
                this.state = Integer.MAX_VALUE;
                throw e;
            }
        }
        throw new MalformedChunkCodingException("Corrupt data stream");
    }

    private void parseTrailerHeaders() throws IOException {
        try {
            this.footers = AbstractMessageParser.parseHeaders(this.f4573in, this.constraints.getMaxHeaderCount(), this.constraints.getMaxLineLength(), null);
        } catch (HttpException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid footer: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            MalformedChunkCodingException malformedChunkCodingException = new MalformedChunkCodingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            malformedChunkCodingException.initCause(e);
            throw malformedChunkCodingException;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer sessionInputBuffer = this.f4573in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return (int) Math.min(((BufferInfo) sessionInputBuffer).length(), this.chunkSize - this.pos);
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            try {
                if (this.eof || this.state == Integer.MAX_VALUE) {
                }
                do {
                } while (read(new byte[2048]) >= 0);
            } finally {
                this.eof = true;
                this.closed = true;
            }
        }
    }

    public Header[] getFooters() {
        return (Header[]) this.footers.clone();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.closed) {
            if (this.eof) {
                return -1;
            }
            if (this.state != 2) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int read = this.f4573in.read();
            if (read != -1) {
                long j = this.pos + 1;
                this.pos = j;
                if (j >= this.chunkSize) {
                    this.state = 3;
                }
            }
            return read;
        }
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.closed) {
            if (this.eof) {
                return -1;
            }
            if (this.state != 2) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int read = this.f4573in.read(bArr, i, (int) Math.min(i2, this.chunkSize - this.pos));
            if (read != -1) {
                long j = this.pos + read;
                this.pos = j;
                if (j >= this.chunkSize) {
                    this.state = 3;
                }
                return read;
            }
            this.eof = true;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Truncated chunk ( expected size: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.chunkSize);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; actual size: ");
            throw new TruncatedChunkException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.pos, ")"));
        }
        throw new IOException("Attempted read from closed stream.");
    }
}

package com.efs.sdk.net.p017a.p018a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

/* renamed from: com.efs.sdk.net.a.a.e */
/* loaded from: classes3.dex */
public final class C0814e extends FilterOutputStream {

    /* renamed from: b */
    public static final ExecutorService f439b = Executors.newCachedThreadPool();

    /* renamed from: a */
    public final Future<Void> f440a;

    /* renamed from: com.efs.sdk.net.a.a.e$a */
    /* loaded from: classes3.dex */
    public static class CallableC0815a implements Callable<Void> {

        /* renamed from: a */
        public final InputStream f441a;

        /* renamed from: b */
        public final OutputStream f442b;

        public CallableC0815a(InputStream inputStream, OutputStream outputStream) {
            this.f441a = inputStream;
            this.f442b = outputStream;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(this.f441a);
            try {
                C0823i.m3941a(gZIPInputStream, this.f442b, new byte[1024]);
                gZIPInputStream.close();
                this.f442b.close();
                return null;
            } catch (Throwable th) {
                gZIPInputStream.close();
                this.f442b.close();
                throw th;
            }
        }
    }

    public C0814e(OutputStream outputStream, Future<Void> future) {
        super(outputStream);
        this.f440a = future;
    }

    /* renamed from: a */
    public static C0814e m3958a(OutputStream outputStream) {
        PipedInputStream pipedInputStream = new PipedInputStream();
        return new C0814e(new PipedOutputStream(pipedInputStream), f439b.submit(new CallableC0815a(pipedInputStream, outputStream)));
    }

    /* renamed from: a */
    public static <T> T m3957a(Future<T> future) {
        while (true) {
            try {
                return future.get();
            } catch (InterruptedException unused) {
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                C0813d.m3959a(cause, IOException.class);
                C0813d.m3959a(cause, Error.class);
                C0813d.m3959a(cause, RuntimeException.class);
                throw new RuntimeException(cause);
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            super.close();
            try {
            } catch (IOException e) {
                throw e;
            }
        } finally {
            try {
                m3957a(this.f440a);
            } catch (IOException unused) {
            }
        }
    }
}

package org.apache.http.impl.bootstrap;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import me.tvspark.outline;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.DefaultBHttpServerConnection;
import org.apache.http.protocol.HttpService;

/* loaded from: classes4.dex */
public class HttpServer {
    public final HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
    public final ExceptionLogger exceptionLogger;
    public final HttpService httpService;
    public final InetAddress ifAddress;
    public final ThreadPoolExecutor listenerExecutorService;
    public final int port;
    public volatile RequestListener requestListener;
    public volatile ServerSocket serverSocket;
    public final ServerSocketFactory serverSocketFactory;
    public final SocketConfig socketConfig;
    public final SSLServerSetupHandler sslSetupHandler;
    public final ThreadGroup workerThreads = new ThreadGroup("HTTP-workers");
    public final WorkerPoolExecutor workerExecutorService = new WorkerPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryImpl("HTTP-worker", this.workerThreads));
    public final AtomicReference<Status> status = new AtomicReference<>(Status.READY);

    /* loaded from: classes4.dex */
    public enum Status {
        READY,
        ACTIVE,
        STOPPING
    }

    public HttpServer(int i, InetAddress inetAddress, SocketConfig socketConfig, ServerSocketFactory serverSocketFactory, HttpService httpService, HttpConnectionFactory<? extends DefaultBHttpServerConnection> httpConnectionFactory, SSLServerSetupHandler sSLServerSetupHandler, ExceptionLogger exceptionLogger) {
        this.port = i;
        this.ifAddress = inetAddress;
        this.socketConfig = socketConfig;
        this.serverSocketFactory = serverSocketFactory;
        this.httpService = httpService;
        this.connectionFactory = httpConnectionFactory;
        this.sslSetupHandler = sSLServerSetupHandler;
        this.exceptionLogger = exceptionLogger;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("HTTP-listener-");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.port);
        this.listenerExecutorService = new ThreadPoolExecutor(1, 1, 0L, timeUnit, synchronousQueue, new ThreadFactoryImpl(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()));
    }

    public void awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        this.workerExecutorService.awaitTermination(j, timeUnit);
    }

    public InetAddress getInetAddress() {
        ServerSocket serverSocket = this.serverSocket;
        if (serverSocket != null) {
            return serverSocket.getInetAddress();
        }
        return null;
    }

    public int getLocalPort() {
        ServerSocket serverSocket = this.serverSocket;
        if (serverSocket != null) {
            return serverSocket.getLocalPort();
        }
        return -1;
    }

    public void shutdown(long j, TimeUnit timeUnit) {
        stop();
        if (j > 0) {
            try {
                awaitTermination(j, timeUnit);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        for (Worker worker : this.workerExecutorService.getWorkers()) {
            try {
                worker.getConnection().shutdown();
            } catch (IOException e) {
                this.exceptionLogger.log(e);
            }
        }
    }

    public void start() throws IOException {
        if (this.status.compareAndSet(Status.READY, Status.ACTIVE)) {
            this.serverSocket = this.serverSocketFactory.createServerSocket(this.port, this.socketConfig.getBacklogSize(), this.ifAddress);
            this.serverSocket.setReuseAddress(this.socketConfig.isSoReuseAddress());
            if (this.socketConfig.getRcvBufSize() > 0) {
                this.serverSocket.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
            }
            if (this.sslSetupHandler != null && (this.serverSocket instanceof SSLServerSocket)) {
                this.sslSetupHandler.initialize((SSLServerSocket) this.serverSocket);
            }
            this.requestListener = new RequestListener(this.socketConfig, this.serverSocket, this.httpService, this.connectionFactory, this.exceptionLogger, this.workerExecutorService);
            this.listenerExecutorService.execute(this.requestListener);
        }
    }

    public void stop() {
        if (this.status.compareAndSet(Status.ACTIVE, Status.STOPPING)) {
            this.listenerExecutorService.shutdown();
            this.workerExecutorService.shutdown();
            RequestListener requestListener = this.requestListener;
            if (requestListener != null) {
                try {
                    requestListener.terminate();
                } catch (IOException e) {
                    this.exceptionLogger.log(e);
                }
            }
            this.workerThreads.interrupt();
        }
    }
}

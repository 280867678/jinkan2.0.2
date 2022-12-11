package org.eclipse.jetty.server;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import me.tvspark.outline;
import org.apache.commons.lang3.text.FormattableUtils;
import org.eclipse.jetty.util.thread.ShutdownThread;

/* loaded from: classes4.dex */
public class ShutdownMonitor {
    public boolean DEBUG;
    public boolean exitVm;
    public String key;
    public int port;
    public ServerSocket serverSocket;
    public ShutdownMonitorThread thread;

    /* loaded from: classes4.dex */
    public static class Holder {
        public static ShutdownMonitor instance = new ShutdownMonitor();
    }

    /* loaded from: classes4.dex */
    public class ShutdownMonitorThread extends Thread {
        public ShutdownMonitorThread() {
            setDaemon(true);
            setName("ShutdownMonitor");
        }

        private void startListenSocket() {
            if (ShutdownMonitor.this.port < 0) {
                if (!ShutdownMonitor.this.DEBUG) {
                    return;
                }
                PrintStream printStream = System.err;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ShutdownMonitor not in use (port < 0): ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ShutdownMonitor.this.port);
                printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return;
            }
            try {
                try {
                    ShutdownMonitor.this.serverSocket = new ServerSocket(ShutdownMonitor.this.port, 1, InetAddress.getByName("127.0.0.1"));
                    if (ShutdownMonitor.this.port == 0) {
                        ShutdownMonitor.this.port = ShutdownMonitor.this.serverSocket.getLocalPort();
                        System.out.printf("STOP.PORT=%d%n", Integer.valueOf(ShutdownMonitor.this.port));
                    }
                    if (ShutdownMonitor.this.key == null) {
                        ShutdownMonitor.this.key = Long.toString((long) ((Math.random() * 9.223372036854776E18d) + hashCode() + System.currentTimeMillis()), 36);
                        System.out.printf("STOP.KEY=%s%n", ShutdownMonitor.this.key);
                    }
                    ShutdownMonitor shutdownMonitor = ShutdownMonitor.this;
                    shutdownMonitor.debug("STOP.PORT=%d", Integer.valueOf(shutdownMonitor.port));
                    ShutdownMonitor shutdownMonitor2 = ShutdownMonitor.this;
                    shutdownMonitor2.debug("STOP.KEY=%s", shutdownMonitor2.key);
                    ShutdownMonitor shutdownMonitor3 = ShutdownMonitor.this;
                    shutdownMonitor3.debug(FormattableUtils.SIMPLEST_FORMAT, shutdownMonitor3.serverSocket);
                } catch (Exception e) {
                    ShutdownMonitor.this.debug(e);
                    PrintStream printStream2 = System.err;
                    printStream2.println("Error binding monitor port " + ShutdownMonitor.this.port + ": " + e.toString());
                    ShutdownMonitor.this.serverSocket = null;
                    ShutdownMonitor shutdownMonitor4 = ShutdownMonitor.this;
                    shutdownMonitor4.debug("STOP.PORT=%d", Integer.valueOf(shutdownMonitor4.port));
                    ShutdownMonitor shutdownMonitor5 = ShutdownMonitor.this;
                    shutdownMonitor5.debug("STOP.KEY=%s", shutdownMonitor5.key);
                    ShutdownMonitor shutdownMonitor6 = ShutdownMonitor.this;
                    shutdownMonitor6.debug(FormattableUtils.SIMPLEST_FORMAT, shutdownMonitor6.serverSocket);
                }
            } catch (Throwable th) {
                ShutdownMonitor shutdownMonitor7 = ShutdownMonitor.this;
                shutdownMonitor7.debug("STOP.PORT=%d", Integer.valueOf(shutdownMonitor7.port));
                ShutdownMonitor shutdownMonitor8 = ShutdownMonitor.this;
                shutdownMonitor8.debug("STOP.KEY=%s", shutdownMonitor8.key);
                ShutdownMonitor shutdownMonitor9 = ShutdownMonitor.this;
                shutdownMonitor9.debug(FormattableUtils.SIMPLEST_FORMAT, shutdownMonitor9.serverSocket);
                throw th;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Socket socket;
            Throwable th;
            Exception e;
            LineNumberReader lineNumberReader;
            if (ShutdownMonitor.this.serverSocket == null) {
                return;
            }
            while (ShutdownMonitor.this.serverSocket != null) {
                Socket socket2 = null;
                try {
                    socket = ShutdownMonitor.this.serverSocket.accept();
                    try {
                        try {
                            lineNumberReader = new LineNumberReader(new InputStreamReader(socket.getInputStream()));
                        } catch (Throwable th2) {
                            th = th2;
                            ShutdownMonitor.this.close(socket);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        ShutdownMonitor.this.debug(e);
                        System.err.println(e.toString());
                        ShutdownMonitor.this.close(socket);
                    }
                } catch (Exception e3) {
                    socket = null;
                    e = e3;
                } catch (Throwable th3) {
                    socket = null;
                    th = th3;
                }
                if (!ShutdownMonitor.this.key.equals(lineNumberReader.readLine())) {
                    System.err.println("Ignoring command with incorrect key");
                    ShutdownMonitor.this.close(socket);
                } else {
                    OutputStream outputStream = socket.getOutputStream();
                    String readLine = lineNumberReader.readLine();
                    ShutdownMonitor.this.debug("command=%s", readLine);
                    if ("stop".equals(readLine)) {
                        ShutdownMonitor.this.debug("Issuing graceful shutdown..", new Object[0]);
                        ShutdownThread.getInstance().run();
                        ShutdownMonitor.this.debug("Informing client that we are stopped.", new Object[0]);
                        outputStream.write("Stopped\r\n".getBytes("UTF-8"));
                        outputStream.flush();
                        ShutdownMonitor.this.debug("Shutting down monitor", new Object[0]);
                        ShutdownMonitor.this.close(socket);
                        ShutdownMonitor.this.close(ShutdownMonitor.this.serverSocket);
                        ShutdownMonitor.this.serverSocket = null;
                        if (ShutdownMonitor.this.exitVm) {
                            ShutdownMonitor.this.debug("Killing JVM", new Object[0]);
                            System.exit(0);
                        }
                    } else {
                        if (NotificationCompat.CATEGORY_STATUS.equals(readLine)) {
                            outputStream.write("OK\r\n".getBytes("UTF-8"));
                            outputStream.flush();
                        }
                        socket2 = socket;
                    }
                    ShutdownMonitor.this.close(socket2);
                }
            }
        }

        @Override // java.lang.Thread
        public void start() {
            if (isAlive()) {
                System.err.printf("ShutdownMonitorThread already started", new Object[0]);
                return;
            }
            startListenSocket();
            if (ShutdownMonitor.this.serverSocket == null) {
                return;
            }
            if (ShutdownMonitor.this.DEBUG) {
                System.err.println("Starting ShutdownMonitorThread");
            }
            super.start();
        }
    }

    public ShutdownMonitor() {
        Properties properties = System.getProperties();
        this.DEBUG = properties.containsKey("DEBUG");
        this.port = Integer.parseInt(properties.getProperty("STOP.PORT", "-1"));
        this.key = properties.getProperty("STOP.KEY", null);
        this.exitVm = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close(ServerSocket serverSocket) {
        if (serverSocket == null) {
            return;
        }
        try {
            serverSocket.close();
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close(Socket socket) {
        if (socket == null) {
            return;
        }
        try {
            socket.close();
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(String str, Object... objArr) {
        if (this.DEBUG) {
            PrintStream printStream = System.err;
            printStream.printf("[ShutdownMonitor] " + str + "%n", objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(Throwable th) {
        if (this.DEBUG) {
            th.printStackTrace(System.err);
        }
    }

    public static ShutdownMonitor getInstance() {
        return Holder.instance;
    }

    public String getKey() {
        return this.key;
    }

    public int getPort() {
        return this.port;
    }

    public ServerSocket getServerSocket() {
        return this.serverSocket;
    }

    public boolean isAlive() {
        boolean z;
        synchronized (this) {
            z = this.thread != null && this.thread.isAlive();
        }
        return z;
    }

    public boolean isExitVm() {
        return this.exitVm;
    }

    public void setDebug(boolean z) {
        this.DEBUG = z;
    }

    public void setExitVm(boolean z) {
        synchronized (this) {
            if (this.thread != null && this.thread.isAlive()) {
                throw new IllegalStateException("ShutdownMonitorThread already started");
            }
            this.exitVm = z;
        }
    }

    public void setKey(String str) {
        synchronized (this) {
            if (this.thread != null && this.thread.isAlive()) {
                throw new IllegalStateException("ShutdownMonitorThread already started");
            }
            this.key = str;
        }
    }

    public void setPort(int i) {
        synchronized (this) {
            if (this.thread != null && this.thread.isAlive()) {
                throw new IllegalStateException("ShutdownMonitorThread already started");
            }
            this.port = i;
        }
    }

    public void start() throws Exception {
        synchronized (this) {
            if (this.thread != null && this.thread.isAlive()) {
                System.err.printf("ShutdownMonitorThread already started", new Object[0]);
                return;
            }
            ShutdownMonitorThread shutdownMonitorThread = new ShutdownMonitorThread();
            this.thread = shutdownMonitorThread;
            if (shutdownMonitorThread == null) {
                return;
            }
            shutdownMonitorThread.start();
        }
    }

    public String toString() {
        return String.format("%s[port=%d]", ShutdownMonitor.class.getName(), Integer.valueOf(this.port));
    }
}

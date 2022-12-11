package fi.iki.elonen.util;

import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public class ServerRunner {
    public static final Logger LOG = Logger.getLogger(ServerRunner.class.getName());

    public static void executeInstance(NanoHTTPD nanoHTTPD) {
        try {
            nanoHTTPD.start(5000, false);
        } catch (IOException e) {
            PrintStream printStream = System.err;
            printStream.println("Couldn't start server:\n" + e);
            System.exit(-1);
        }
        System.out.println("Server started, Hit Enter to stop.\n");
        try {
            System.in.read();
        } catch (Throwable unused) {
        }
        nanoHTTPD.stop();
        System.out.println("Server stopped.\n");
    }

    public static <T extends NanoHTTPD> void run(Class<T> cls) {
        try {
            executeInstance(cls.newInstance());
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Cound nor create server", (Throwable) e);
        }
    }
}

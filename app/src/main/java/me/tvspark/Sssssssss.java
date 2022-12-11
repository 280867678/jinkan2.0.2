package me.tvspark;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes4.dex */
public final class Sssssssss {
    public final Map<String, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Queue<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque();

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww poll;
            synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                poll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.poll();
            }
            return poll == null ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : poll;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() < 10) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.offer(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Lock Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ReentrantLock();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (this) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "Argument must not be null");
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            if (i == 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww remove = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(str);
                if (!remove.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(remove);
            }
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unlock();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (this) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lock();
    }
}

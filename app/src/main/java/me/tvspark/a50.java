package me.tvspark;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes4.dex */
public class a50 {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ReentrantLock Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ReentrantLock();
    public final Map<String, e30> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ConcurrentHashMap();
    public final Deque<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new LinkedList();

    public a50(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lock();
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeFirstOccurrence(str);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addFirst(str);
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unlock();
        }
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

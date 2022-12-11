package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class CycleDetectingLockFactory {
    public static final Logger Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Logger.getLogger(CycleDetectingLockFactory.class.getName());
    public static final ThreadLocal<ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes3.dex */
    public final class CycleDetectingReentrantLock extends ReentrantLock implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww lockGraphNode;

        public CycleDetectingReentrantLock(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
            super(z);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.lockGraphNode = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return;
            }
            throw null;
        }

        public /* synthetic */ CycleDetectingReentrantLock(CycleDetectingLockFactory cycleDetectingLockFactory, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
        public final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantReadLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this.readWriteLock);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.readWriteLock);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww lockGraphNode;
        public final CycleDetectingReentrantReadLock readLock;
        public final CycleDetectingReentrantWriteLock writeLock;

        public CycleDetectingReentrantReadWriteLock(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
            super(z);
            this.readLock = new CycleDetectingReentrantReadLock(this);
            this.writeLock = new CycleDetectingReentrantWriteLock(this);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.lockGraphNode = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return;
            }
            throw null;
        }

        public /* synthetic */ CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean isAcquiredByCurrentThread() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }
    }

    /* loaded from: classes3.dex */
    public class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
        public final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantWriteLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory.this, this.readWriteLock);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.readWriteLock);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class ExampleStackTrace extends IllegalStateException {
        public static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        public static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = ImmutableSet.m3874of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getName());

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExampleStackTrace(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            super("null -> null");
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                    throw null;
                }
                StackTraceElement[] stackTrace = getStackTrace();
                int length = stackTrace.length;
                for (int i = 0; i < length; i++) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getName().equals(stackTrace[i].getClassName())) {
                        setStackTrace(EMPTY_STACK_TRACE);
                        return;
                    } else if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i].getClassName())) {
                        setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i, length));
                        return;
                    }
                }
                return;
            }
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public enum Policies {
        THROW { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.1
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        },
        DISABLED { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.3
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        };

        /* synthetic */ Policies(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        public final ExampleStackTrace conflictingStackTrace;

        public PotentialDeadlockException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, ExampleStackTrace exampleStackTrace) {
            super(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }

        public /* synthetic */ PotentialDeadlockException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, ExampleStackTrace exampleStackTrace, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, exampleStackTrace);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder sb = new StringBuilder(super.getMessage());
            for (Throwable th = this.conflictingStackTrace; th != null; th = th.getCause()) {
                sb.append(", ");
                sb.append(th.getMessage());
            }
            return sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E extends Enum<E>> extends CycleDetectingLockFactory {
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends ThreadLocal<ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> initialValue() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, "initialArraySize");
            return new ArrayList<>(3);
        }
    }

    static {
        MapMaker mapMaker = new MapMaker();
        mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MapMakerInternalMap.Strength.WEAK);
        mapMaker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CycleDetectingLockFactory cycleDetectingLockFactory, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (cycleDetectingLockFactory != null) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAcquiredByCurrentThread()) {
                return;
            }
            ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> arrayList = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww lockGraphNode = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLockGraphNode();
            if (lockGraphNode != null) {
                if (arrayList.size() <= 0) {
                    arrayList.add(lockGraphNode);
                    return;
                }
                boolean z = false;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = arrayList.get(0);
                if (lockGraphNode != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    z = true;
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, "Attempted to acquire multiple locks with the same rank %s", (Object) null);
                    throw null;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAcquiredByCurrentThread()) {
            ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> arrayList = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww lockGraphNode = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLockGraphNode();
            int size = arrayList.size();
            do {
                size--;
                if (size < 0) {
                    return;
                }
            } while (arrayList.get(size) != lockGraphNode);
            arrayList.remove(size);
        }
    }
}

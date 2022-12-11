package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public abstract class Lifecycle {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AtomicReference<Object> mInternalScopeRef = new AtomicReference<>();

    /* renamed from: androidx.lifecycle.Lifecycle$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C03891 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        static {
            int[] iArr = new int[Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                Event event = Event.ON_CREATE;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Event event2 = Event.ON_STOP;
                iArr2[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Event event3 = Event.ON_START;
                iArr3[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Event event4 = Event.ON_PAUSE;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Event event5 = Event.ON_RESUME;
                iArr5[2] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Event event6 = Event.ON_DESTROY;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Event event7 = Event.ON_ANY;
                iArr7[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr8 = new int[State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr8;
            try {
                State state = State.CREATED;
                iArr8[2] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = $SwitchMap$androidx$lifecycle$Lifecycle$State;
                State state2 = State.STARTED;
                iArr9[3] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = $SwitchMap$androidx$lifecycle$Lifecycle$State;
                State state3 = State.RESUMED;
                iArr10[4] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = $SwitchMap$androidx$lifecycle$Lifecycle$State;
                State state4 = State.DESTROYED;
                iArr11[0] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                int[] iArr12 = $SwitchMap$androidx$lifecycle$Lifecycle$State;
                State state5 = State.INITIALIZED;
                iArr12[1] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        @Nullable
        public static Event downFrom(@NonNull State state) {
            int ordinal = state.ordinal();
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return ON_STOP;
                }
                if (ordinal == 4) {
                    return ON_PAUSE;
                }
                return null;
            }
            return ON_DESTROY;
        }

        @Nullable
        public static Event downTo(@NonNull State state) {
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal == 2) {
                    return ON_STOP;
                }
                if (ordinal == 3) {
                    return ON_PAUSE;
                }
                return null;
            }
            return ON_DESTROY;
        }

        @Nullable
        public static Event upFrom(@NonNull State state) {
            int ordinal = state.ordinal();
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return ON_START;
                }
                if (ordinal == 3) {
                    return ON_RESUME;
                }
                return null;
            }
            return ON_CREATE;
        }

        @Nullable
        public static Event upTo(@NonNull State state) {
            int ordinal = state.ordinal();
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return ON_START;
                }
                if (ordinal == 4) {
                    return ON_RESUME;
                }
                return null;
            }
            return ON_CREATE;
        }

        @NonNull
        public State getTargetState() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        return State.RESUMED;
                    }
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            if (ordinal == 5) {
                                return State.DESTROYED;
                            }
                            throw new IllegalArgumentException(this + " has no target state");
                        }
                    }
                }
                return State.STARTED;
            }
            return State.CREATED;
        }
    }

    /* loaded from: classes3.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(@NonNull State state) {
            return compareTo(state) >= 0;
        }
    }

    @MainThread
    public abstract void addObserver(@NonNull LifecycleObserver lifecycleObserver);

    @NonNull
    @MainThread
    public abstract State getCurrentState();

    @MainThread
    public abstract void removeObserver(@NonNull LifecycleObserver lifecycleObserver);
}

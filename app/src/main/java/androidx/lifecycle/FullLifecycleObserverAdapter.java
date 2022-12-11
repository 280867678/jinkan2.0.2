package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes3.dex */
public class FullLifecycleObserverAdapter implements LifecycleEventObserver {
    public final FullLifecycleObserver mFullLifecycleObserver;
    public final LifecycleEventObserver mLifecycleEventObserver;

    /* renamed from: androidx.lifecycle.FullLifecycleObserverAdapter$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C03881 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                Lifecycle.Event event = Lifecycle.Event.ON_CREATE;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Lifecycle.Event event2 = Lifecycle.Event.ON_START;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Lifecycle.Event event3 = Lifecycle.Event.ON_RESUME;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Lifecycle.Event event4 = Lifecycle.Event.ON_PAUSE;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Lifecycle.Event event5 = Lifecycle.Event.ON_STOP;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Lifecycle.Event event6 = Lifecycle.Event.ON_DESTROY;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
                Lifecycle.Event event7 = Lifecycle.Event.ON_ANY;
                iArr7[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver, LifecycleEventObserver lifecycleEventObserver) {
        this.mFullLifecycleObserver = fullLifecycleObserver;
        this.mLifecycleEventObserver = lifecycleEventObserver;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        switch (event.ordinal()) {
            case 0:
                this.mFullLifecycleObserver.onCreate(lifecycleOwner);
                break;
            case 1:
                this.mFullLifecycleObserver.onStart(lifecycleOwner);
                break;
            case 2:
                this.mFullLifecycleObserver.onResume(lifecycleOwner);
                break;
            case 3:
                this.mFullLifecycleObserver.onPause(lifecycleOwner);
                break;
            case 4:
                this.mFullLifecycleObserver.onStop(lifecycleOwner);
                break;
            case 5:
                this.mFullLifecycleObserver.onDestroy(lifecycleOwner);
                break;
            case 6:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        LifecycleEventObserver lifecycleEventObserver = this.mLifecycleEventObserver;
        if (lifecycleEventObserver != null) {
            lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
        }
    }
}

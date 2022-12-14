package kotlin.text;

import me.tvspark.df0;
import me.tvspark.ef0;
import me.tvspark.r40;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public enum CharDirectionality {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);
    
    public final int value;
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Companion = new Object(null) { // from class: kotlin.text.CharDirectionality.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    };
    public static final df0 directionalityMap$delegate = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((xg0) CharDirectionality$Companion$directionalityMap$2.INSTANCE);

    CharDirectionality(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}

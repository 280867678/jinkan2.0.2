package org.mozilla.javascript;

/* loaded from: classes5.dex */
public abstract class Icode {
    public static final int Icode_CALLSPECIAL = -21;
    public static final int Icode_CLOSURE_EXPR = -19;
    public static final int Icode_CLOSURE_STMT = -20;
    public static final int Icode_DEBUGGER = -64;
    public static final int Icode_DELNAME = 0;
    public static final int Icode_DUP = -1;
    public static final int Icode_DUP2 = -2;
    public static final int Icode_ELEM_AND_THIS = -17;
    public static final int Icode_ELEM_INC_DEC = -10;
    public static final int Icode_ENTERDQ = -53;
    public static final int Icode_GENERATOR = -62;
    public static final int Icode_GENERATOR_END = -63;
    public static final int Icode_GETVAR1 = -48;
    public static final int Icode_GOSUB = -23;
    public static final int Icode_IFEQ_POP = -6;
    public static final int Icode_INTNUMBER = -28;
    public static final int Icode_LEAVEDQ = -54;
    public static final int Icode_LINE = -26;
    public static final int Icode_LITERAL_GETTER = -57;
    public static final int Icode_LITERAL_NEW = -29;
    public static final int Icode_LITERAL_SET = -30;
    public static final int Icode_LITERAL_SETTER = -58;
    public static final int Icode_LOCAL_CLEAR = -56;
    public static final int Icode_NAME_AND_THIS = -15;
    public static final int Icode_NAME_INC_DEC = -8;
    public static final int Icode_ONE = -52;
    public static final int Icode_POP = -4;
    public static final int Icode_POP_RESULT = -5;
    public static final int Icode_PROP_AND_THIS = -16;
    public static final int Icode_PROP_INC_DEC = -9;
    public static final int Icode_REF_INC_DEC = -11;
    public static final int Icode_REG_IND1 = -38;
    public static final int Icode_REG_IND2 = -39;
    public static final int Icode_REG_IND4 = -40;
    public static final int Icode_REG_IND_C0 = -32;
    public static final int Icode_REG_IND_C1 = -33;
    public static final int Icode_REG_IND_C2 = -34;
    public static final int Icode_REG_IND_C3 = -35;
    public static final int Icode_REG_IND_C4 = -36;
    public static final int Icode_REG_IND_C5 = -37;
    public static final int Icode_REG_STR1 = -45;
    public static final int Icode_REG_STR2 = -46;
    public static final int Icode_REG_STR4 = -47;
    public static final int Icode_REG_STR_C0 = -41;
    public static final int Icode_REG_STR_C1 = -42;
    public static final int Icode_REG_STR_C2 = -43;
    public static final int Icode_REG_STR_C3 = -44;
    public static final int Icode_RETSUB = -25;
    public static final int Icode_RETUNDEF = -22;
    public static final int Icode_SCOPE_LOAD = -12;
    public static final int Icode_SCOPE_SAVE = -13;
    public static final int Icode_SETCONST = -59;
    public static final int Icode_SETCONSTVAR = -60;
    public static final int Icode_SETCONSTVAR1 = -61;
    public static final int Icode_SETVAR1 = -49;
    public static final int Icode_SHORTNUMBER = -27;
    public static final int Icode_SPARE_ARRAYLIT = -31;
    public static final int Icode_STARTSUB = -24;
    public static final int Icode_SWAP = -3;
    public static final int Icode_TAIL_CALL = -55;
    public static final int Icode_TYPEOFNAME = -14;
    public static final int Icode_UNDEF = -50;
    public static final int Icode_VALUE_AND_THIS = -18;
    public static final int Icode_VAR_INC_DEC = -7;
    public static final int Icode_ZERO = -51;
    public static final int MIN_ICODE = -64;

    public static String bytecodeName(int i) {
        if (validBytecode(i)) {
            return String.valueOf(i);
        }
        throw new IllegalArgumentException(String.valueOf(i));
    }

    public static boolean validBytecode(int i) {
        return validIcode(i) || validTokenCode(i);
    }

    public static boolean validIcode(int i) {
        return -64 <= i && i <= 0;
    }

    public static boolean validTokenCode(int i) {
        return 2 <= i && i <= 81;
    }
}

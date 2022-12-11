package androidx.renderscript;

import me.tvspark.outline;

/* loaded from: classes3.dex */
public class FieldPacker {
    public final byte[] mData;
    public int mLen;

    /* renamed from: mN */
    public FieldPackerThunker f96mN;
    public int mPos = 0;

    public FieldPacker(int i) {
        this.mLen = i;
        this.mData = new byte[i];
        if (RenderScript.shouldThunk()) {
            this.f96mN = new FieldPackerThunker(i);
        }
    }

    public void addBoolean(boolean z) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addBoolean(z);
        } else {
            addI8(z ? (byte) 1 : (byte) 0);
        }
    }

    public void addF32(float f) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addF32(f);
        } else {
            addI32(Float.floatToRawIntBits(f));
        }
    }

    public void addF32(Float2 float2) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addF32(float2);
            return;
        }
        addF32(float2.f98x);
        addF32(float2.f99y);
    }

    public void addF32(Float3 float3) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addF32(float3);
            return;
        }
        addF32(float3.f100x);
        addF32(float3.f101y);
        addF32(float3.f102z);
    }

    public void addF32(Float4 float4) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addF32(float4);
            return;
        }
        addF32(float4.f104x);
        addF32(float4.f105y);
        addF32(float4.f106z);
        addF32(float4.f103w);
    }

    public void addF64(double d) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addF64(d);
        } else {
            addI64(Double.doubleToRawLongBits(d));
        }
    }

    public void addF64(Double2 double2) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addF64(double2);
            return;
        }
        addF64(double2.f84x);
        addF64(double2.f85y);
    }

    public void addF64(Double3 double3) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addF64(double3);
            return;
        }
        addF64(double3.f86x);
        addF64(double3.f87y);
        addF64(double3.f88z);
    }

    public void addF64(Double4 double4) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addF64(double4);
            return;
        }
        addF64(double4.f90x);
        addF64(double4.f91y);
        addF64(double4.f92z);
        addF64(double4.f89w);
    }

    public void addI16(Short2 short2) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI16(short2);
            return;
        }
        addI16(short2.f141x);
        addI16(short2.f142y);
    }

    public void addI16(Short3 short3) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI16(short3);
            return;
        }
        addI16(short3.f143x);
        addI16(short3.f144y);
        addI16(short3.f145z);
    }

    public void addI16(Short4 short4) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI16(short4);
            return;
        }
        addI16(short4.f147x);
        addI16(short4.f148y);
        addI16(short4.f149z);
        addI16(short4.f146w);
    }

    public void addI16(short s) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI16(s);
            return;
        }
        align(2);
        byte[] bArr = this.mData;
        int i = this.mPos;
        int i2 = i + 1;
        this.mPos = i2;
        bArr[i] = (byte) (s & 255);
        this.mPos = i2 + 1;
        bArr[i2] = (byte) (s >> 8);
    }

    public void addI32(int i) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI32(i);
            return;
        }
        align(4);
        byte[] bArr = this.mData;
        int i2 = this.mPos;
        int i3 = i2 + 1;
        this.mPos = i3;
        bArr[i2] = (byte) (i & 255);
        int i4 = i3 + 1;
        this.mPos = i4;
        bArr[i3] = (byte) ((i >> 8) & 255);
        int i5 = i4 + 1;
        this.mPos = i5;
        bArr[i4] = (byte) ((i >> 16) & 255);
        this.mPos = i5 + 1;
        bArr[i5] = (byte) ((i >> 24) & 255);
    }

    public void addI32(Int2 int2) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI32(int2);
            return;
        }
        addI32(int2.f107x);
        addI32(int2.f108y);
    }

    public void addI32(Int3 int3) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI32(int3);
            return;
        }
        addI32(int3.f109x);
        addI32(int3.f110y);
        addI32(int3.f111z);
    }

    public void addI32(Int4 int4) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI32(int4);
            return;
        }
        addI32(int4.f113x);
        addI32(int4.f114y);
        addI32(int4.f115z);
        addI32(int4.f112w);
    }

    public void addI64(long j) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI64(j);
            return;
        }
        align(8);
        byte[] bArr = this.mData;
        int i = this.mPos;
        int i2 = i + 1;
        this.mPos = i2;
        bArr[i] = (byte) (j & 255);
        int i3 = i2 + 1;
        this.mPos = i3;
        bArr[i2] = (byte) ((j >> 8) & 255);
        int i4 = i3 + 1;
        this.mPos = i4;
        bArr[i3] = (byte) ((j >> 16) & 255);
        int i5 = i4 + 1;
        this.mPos = i5;
        bArr[i4] = (byte) ((j >> 24) & 255);
        int i6 = i5 + 1;
        this.mPos = i6;
        bArr[i5] = (byte) ((j >> 32) & 255);
        int i7 = i6 + 1;
        this.mPos = i7;
        bArr[i6] = (byte) ((j >> 40) & 255);
        int i8 = i7 + 1;
        this.mPos = i8;
        bArr[i7] = (byte) ((j >> 48) & 255);
        this.mPos = i8 + 1;
        bArr[i8] = (byte) ((j >> 56) & 255);
    }

    public void addI64(Long2 long2) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI64(long2);
            return;
        }
        addI64(long2.f116x);
        addI64(long2.f117y);
    }

    public void addI64(Long3 long3) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI64(long3);
            return;
        }
        addI64(long3.f118x);
        addI64(long3.f119y);
        addI64(long3.f120z);
    }

    public void addI64(Long4 long4) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI64(long4);
            return;
        }
        addI64(long4.f122x);
        addI64(long4.f123y);
        addI64(long4.f124z);
        addI64(long4.f121w);
    }

    public void addI8(byte b) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI8(b);
            return;
        }
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = b;
    }

    public void addI8(Byte2 byte2) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI8(byte2);
            return;
        }
        addI8(byte2.f75x);
        addI8(byte2.f76y);
    }

    public void addI8(Byte3 byte3) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI8(byte3);
            return;
        }
        addI8(byte3.f77x);
        addI8(byte3.f78y);
        addI8(byte3.f79z);
    }

    public void addI8(Byte4 byte4) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addI8(byte4);
            return;
        }
        addI8(byte4.f81x);
        addI8(byte4.f82y);
        addI8(byte4.f83z);
        addI8(byte4.f80w);
    }

    public void addMatrix(Matrix2f matrix2f) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addMatrix(matrix2f);
            return;
        }
        int i = 0;
        while (true) {
            float[] fArr = matrix2f.mMat;
            if (i >= fArr.length) {
                return;
            }
            addF32(fArr[i]);
            i++;
        }
    }

    public void addMatrix(Matrix3f matrix3f) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addMatrix(matrix3f);
            return;
        }
        int i = 0;
        while (true) {
            float[] fArr = matrix3f.mMat;
            if (i >= fArr.length) {
                return;
            }
            addF32(fArr[i]);
            i++;
        }
    }

    public void addMatrix(Matrix4f matrix4f) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addMatrix(matrix4f);
            return;
        }
        int i = 0;
        while (true) {
            float[] fArr = matrix4f.mMat;
            if (i >= fArr.length) {
                return;
            }
            addF32(fArr[i]);
            i++;
        }
    }

    public void addObj(BaseObj baseObj) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addObj(baseObj);
        } else {
            addI32(baseObj != null ? baseObj.getID(null) : 0);
        }
    }

    public void addU16(int i) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU16(i);
        } else if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Saving value out of range for type");
        } else {
            align(2);
            byte[] bArr = this.mData;
            int i2 = this.mPos;
            int i3 = i2 + 1;
            this.mPos = i3;
            bArr[i2] = (byte) (i & 255);
            this.mPos = i3 + 1;
            bArr[i3] = (byte) (i >> 8);
        }
    }

    public void addU16(Int2 int2) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU16(int2);
            return;
        }
        addU16(int2.f107x);
        addU16(int2.f108y);
    }

    public void addU16(Int3 int3) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU16(int3);
            return;
        }
        addU16(int3.f109x);
        addU16(int3.f110y);
        addU16(int3.f111z);
    }

    public void addU16(Int4 int4) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU16(int4);
            return;
        }
        addU16(int4.f113x);
        addU16(int4.f114y);
        addU16(int4.f115z);
        addU16(int4.f112w);
    }

    public void addU32(long j) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU32(j);
        } else if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("Saving value out of range for type");
        } else {
            align(4);
            byte[] bArr = this.mData;
            int i = this.mPos;
            int i2 = i + 1;
            this.mPos = i2;
            bArr[i] = (byte) (j & 255);
            int i3 = i2 + 1;
            this.mPos = i3;
            bArr[i2] = (byte) ((j >> 8) & 255);
            int i4 = i3 + 1;
            this.mPos = i4;
            bArr[i3] = (byte) ((j >> 16) & 255);
            this.mPos = i4 + 1;
            bArr[i4] = (byte) ((j >> 24) & 255);
        }
    }

    public void addU32(Long2 long2) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU32(long2);
            return;
        }
        addU32(long2.f116x);
        addU32(long2.f117y);
    }

    public void addU32(Long3 long3) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU32(long3);
            return;
        }
        addU32(long3.f118x);
        addU32(long3.f119y);
        addU32(long3.f120z);
    }

    public void addU32(Long4 long4) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU32(long4);
            return;
        }
        addU32(long4.f122x);
        addU32(long4.f123y);
        addU32(long4.f124z);
        addU32(long4.f121w);
    }

    public void addU64(long j) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU64(j);
        } else if (j < 0) {
            throw new IllegalArgumentException("Saving value out of range for type");
        } else {
            align(8);
            byte[] bArr = this.mData;
            int i = this.mPos;
            int i2 = i + 1;
            this.mPos = i2;
            bArr[i] = (byte) (j & 255);
            int i3 = i2 + 1;
            this.mPos = i3;
            bArr[i2] = (byte) ((j >> 8) & 255);
            int i4 = i3 + 1;
            this.mPos = i4;
            bArr[i3] = (byte) ((j >> 16) & 255);
            int i5 = i4 + 1;
            this.mPos = i5;
            bArr[i4] = (byte) ((j >> 24) & 255);
            int i6 = i5 + 1;
            this.mPos = i6;
            bArr[i5] = (byte) ((j >> 32) & 255);
            int i7 = i6 + 1;
            this.mPos = i7;
            bArr[i6] = (byte) ((j >> 40) & 255);
            int i8 = i7 + 1;
            this.mPos = i8;
            bArr[i7] = (byte) ((j >> 48) & 255);
            this.mPos = i8 + 1;
            bArr[i8] = (byte) ((j >> 56) & 255);
        }
    }

    public void addU64(Long2 long2) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU64(long2);
            return;
        }
        addU64(long2.f116x);
        addU64(long2.f117y);
    }

    public void addU64(Long3 long3) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU64(long3);
            return;
        }
        addU64(long3.f118x);
        addU64(long3.f119y);
        addU64(long3.f120z);
    }

    public void addU64(Long4 long4) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU64(long4);
            return;
        }
        addU64(long4.f122x);
        addU64(long4.f123y);
        addU64(long4.f124z);
        addU64(long4.f121w);
    }

    public void addU8(Short2 short2) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU8(short2);
            return;
        }
        addU8(short2.f141x);
        addU8(short2.f142y);
    }

    public void addU8(Short3 short3) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU8(short3);
            return;
        }
        addU8(short3.f143x);
        addU8(short3.f144y);
        addU8(short3.f145z);
    }

    public void addU8(Short4 short4) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU8(short4);
            return;
        }
        addU8(short4.f147x);
        addU8(short4.f148y);
        addU8(short4.f149z);
        addU8(short4.f146w);
    }

    public void addU8(short s) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.addU8(s);
        } else if (s < 0 || s > 255) {
            throw new IllegalArgumentException("Saving value out of range for type");
        } else {
            byte[] bArr = this.mData;
            int i = this.mPos;
            this.mPos = i + 1;
            bArr[i] = (byte) s;
        }
    }

    public void align(int i) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.align(i);
            return;
        }
        if (i > 0) {
            int i2 = i - 1;
            if ((i & i2) == 0) {
                while (true) {
                    int i3 = this.mPos;
                    if ((i3 & i2) == 0) {
                        return;
                    }
                    byte[] bArr = this.mData;
                    this.mPos = i3 + 1;
                    bArr[i3] = 0;
                }
            }
        }
        throw new RSIllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("argument must be a non-negative non-zero power of 2: ", i));
    }

    public final byte[] getData() {
        return RenderScript.shouldThunk() ? this.f96mN.getData() : this.mData;
    }

    public int getPos() {
        return RenderScript.shouldThunk() ? this.f96mN.getPos() : this.mPos;
    }

    public void reset() {
        if (RenderScript.shouldThunk()) {
            this.f96mN.reset();
        } else {
            this.mPos = 0;
        }
    }

    public void reset(int i) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.reset(i);
        } else if (i < 0 || i >= this.mLen) {
            throw new RSIllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("out of range argument: ", i));
        } else {
            this.mPos = i;
        }
    }

    public void skip(int i) {
        if (RenderScript.shouldThunk()) {
            this.f96mN.skip(i);
            return;
        }
        int i2 = this.mPos + i;
        if (i2 < 0 || i2 > this.mLen) {
            throw new RSIllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("out of range argument: ", i));
        }
        this.mPos = i2;
    }
}

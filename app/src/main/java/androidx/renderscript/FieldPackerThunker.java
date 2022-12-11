package androidx.renderscript;

/* loaded from: classes3.dex */
public class FieldPackerThunker {

    /* renamed from: mN */
    public android.renderscript.FieldPacker f97mN;
    public int mPos = 0;

    public FieldPackerThunker(int i) {
        this.f97mN = new android.renderscript.FieldPacker(i);
    }

    public void addBoolean(boolean z) {
        this.f97mN.addBoolean(z);
        this.mPos++;
    }

    public void addF32(float f) {
        this.f97mN.addF32(f);
        this.mPos += 4;
    }

    public void addF32(Float2 float2) {
        this.f97mN.addF32(new android.renderscript.Float2(float2.f98x, float2.f99y));
        this.mPos += 8;
    }

    public void addF32(Float3 float3) {
        this.f97mN.addF32(new android.renderscript.Float3(float3.f100x, float3.f101y, float3.f102z));
        this.mPos += 12;
    }

    public void addF32(Float4 float4) {
        this.f97mN.addF32(new android.renderscript.Float4(float4.f104x, float4.f105y, float4.f106z, float4.f103w));
        this.mPos += 16;
    }

    public void addF64(double d) {
        this.f97mN.addF64(d);
        this.mPos += 8;
    }

    public void addF64(Double2 double2) {
        this.f97mN.addF64(new android.renderscript.Double2(double2.f84x, double2.f85y));
        this.mPos += 16;
    }

    public void addF64(Double3 double3) {
        this.f97mN.addF64(new android.renderscript.Double3(double3.f86x, double3.f87y, double3.f88z));
        this.mPos += 24;
    }

    public void addF64(Double4 double4) {
        this.f97mN.addF64(new android.renderscript.Double4(double4.f90x, double4.f91y, double4.f92z, double4.f89w));
        this.mPos += 32;
    }

    public void addI16(Short2 short2) {
        this.f97mN.addI16(new android.renderscript.Short2(short2.f141x, short2.f142y));
        this.mPos += 4;
    }

    public void addI16(Short3 short3) {
        this.f97mN.addI16(new android.renderscript.Short3(short3.f143x, short3.f144y, short3.f145z));
        this.mPos += 6;
    }

    public void addI16(Short4 short4) {
        this.f97mN.addI16(new android.renderscript.Short4(short4.f147x, short4.f148y, short4.f149z, short4.f146w));
        this.mPos += 8;
    }

    public void addI16(short s) {
        this.f97mN.addI16(s);
        this.mPos += 2;
    }

    public void addI32(int i) {
        this.f97mN.addI32(i);
        this.mPos += 4;
    }

    public void addI32(Int2 int2) {
        this.f97mN.addI32(new android.renderscript.Int2(int2.f107x, int2.f108y));
        this.mPos += 8;
    }

    public void addI32(Int3 int3) {
        this.f97mN.addI32(new android.renderscript.Int3(int3.f109x, int3.f110y, int3.f111z));
        this.mPos += 12;
    }

    public void addI32(Int4 int4) {
        this.f97mN.addI32(new android.renderscript.Int4(int4.f113x, int4.f114y, int4.f115z, int4.f112w));
        this.mPos += 16;
    }

    public void addI64(long j) {
        this.f97mN.addI64(j);
        this.mPos += 8;
    }

    public void addI64(Long2 long2) {
        this.f97mN.addI64(new android.renderscript.Long2(long2.f116x, long2.f117y));
        this.mPos += 16;
    }

    public void addI64(Long3 long3) {
        this.f97mN.addI64(new android.renderscript.Long3(long3.f118x, long3.f119y, long3.f120z));
        this.mPos += 24;
    }

    public void addI64(Long4 long4) {
        this.f97mN.addI64(new android.renderscript.Long4(long4.f122x, long4.f123y, long4.f124z, long4.f121w));
        this.mPos += 32;
    }

    public void addI8(byte b) {
        this.f97mN.addI8(b);
        this.mPos++;
    }

    public void addI8(Byte2 byte2) {
        this.f97mN.addI8(new android.renderscript.Byte2(byte2.f75x, byte2.f76y));
        this.mPos += 2;
    }

    public void addI8(Byte3 byte3) {
        this.f97mN.addI8(new android.renderscript.Byte3(byte3.f77x, byte3.f78y, byte3.f79z));
        this.mPos += 3;
    }

    public void addI8(Byte4 byte4) {
        this.f97mN.addI8(new android.renderscript.Byte4(byte4.f81x, byte4.f82y, byte4.f83z, byte4.f80w));
        this.mPos += 4;
    }

    public void addMatrix(Matrix2f matrix2f) {
        this.f97mN.addMatrix(new android.renderscript.Matrix2f(matrix2f.getArray()));
        this.mPos += 16;
    }

    public void addMatrix(Matrix3f matrix3f) {
        this.f97mN.addMatrix(new android.renderscript.Matrix3f(matrix3f.getArray()));
        this.mPos += 36;
    }

    public void addMatrix(Matrix4f matrix4f) {
        this.f97mN.addMatrix(new android.renderscript.Matrix4f(matrix4f.getArray()));
        this.mPos += 64;
    }

    public void addObj(BaseObj baseObj) {
        if (baseObj != null) {
            this.f97mN.addObj(baseObj.mo4369getNObj());
        } else {
            this.f97mN.addObj(null);
        }
        this.mPos += 4;
    }

    public void addU16(int i) {
        this.f97mN.addU16(i);
        this.mPos += 2;
    }

    public void addU16(Int2 int2) {
        this.f97mN.addU16(new android.renderscript.Int2(int2.f107x, int2.f108y));
        this.mPos += 4;
    }

    public void addU16(Int3 int3) {
        this.f97mN.addU16(new android.renderscript.Int3(int3.f109x, int3.f110y, int3.f111z));
        this.mPos += 6;
    }

    public void addU16(Int4 int4) {
        this.f97mN.addU16(new android.renderscript.Int4(int4.f113x, int4.f114y, int4.f115z, int4.f112w));
        this.mPos += 8;
    }

    public void addU32(long j) {
        this.f97mN.addU32(j);
        this.mPos += 4;
    }

    public void addU32(Long2 long2) {
        this.f97mN.addU32(new android.renderscript.Long2(long2.f116x, long2.f117y));
        this.mPos += 8;
    }

    public void addU32(Long3 long3) {
        this.f97mN.addU32(new android.renderscript.Long3(long3.f118x, long3.f119y, long3.f120z));
        this.mPos += 12;
    }

    public void addU32(Long4 long4) {
        this.f97mN.addU32(new android.renderscript.Long4(long4.f122x, long4.f123y, long4.f124z, long4.f121w));
        this.mPos += 16;
    }

    public void addU64(long j) {
        this.f97mN.addU64(j);
        this.mPos += 8;
    }

    public void addU64(Long2 long2) {
        this.f97mN.addU64(new android.renderscript.Long2(long2.f116x, long2.f117y));
        this.mPos += 16;
    }

    public void addU64(Long3 long3) {
        this.f97mN.addU64(new android.renderscript.Long3(long3.f118x, long3.f119y, long3.f120z));
        this.mPos += 24;
    }

    public void addU64(Long4 long4) {
        this.f97mN.addU64(new android.renderscript.Long4(long4.f122x, long4.f123y, long4.f124z, long4.f121w));
        this.mPos += 32;
    }

    public void addU8(Short2 short2) {
        this.f97mN.addU8(new android.renderscript.Short2(short2.f141x, short2.f142y));
        this.mPos += 2;
    }

    public void addU8(Short3 short3) {
        this.f97mN.addU8(new android.renderscript.Short3(short3.f143x, short3.f144y, short3.f145z));
        this.mPos += 3;
    }

    public void addU8(Short4 short4) {
        this.f97mN.addU8(new android.renderscript.Short4(short4.f147x, short4.f148y, short4.f149z, short4.f146w));
        this.mPos += 4;
    }

    public void addU8(short s) {
        this.f97mN.addU8(s);
        this.mPos++;
    }

    public void align(int i) {
        this.f97mN.align(i);
        while (true) {
            int i2 = this.mPos;
            if (((i - 1) & i2) != 0) {
                this.mPos = i2 + 1;
            } else {
                return;
            }
        }
    }

    public final byte[] getData() {
        return this.f97mN.getData();
    }

    public int getPos() {
        return this.mPos;
    }

    public void reset() {
        this.f97mN.reset();
        this.mPos = 0;
    }

    public void reset(int i) {
        this.f97mN.reset(i);
        this.mPos = i;
    }

    public void skip(int i) {
        this.f97mN.skip(i);
        this.mPos += i;
    }
}

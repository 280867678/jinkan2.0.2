package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseBooleanArray;
import androidx.annotation.AbstractC0047Px;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Palette {
    public static final int DEFAULT_CALCULATE_NUMBER_COLORS = 16;
    public static final Filter DEFAULT_FILTER = new Filter() { // from class: androidx.palette.graphics.Palette.1
        public static final float BLACK_MAX_LIGHTNESS = 0.05f;
        public static final float WHITE_MIN_LIGHTNESS = 0.95f;

        private boolean isBlack(float[] fArr) {
            return fArr[2] <= 0.05f;
        }

        private boolean isNearRedILine(float[] fArr) {
            return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f;
        }

        private boolean isWhite(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        @Override // androidx.palette.graphics.Palette.Filter
        public boolean isAllowed(int i, float[] fArr) {
            return !isWhite(fArr) && !isBlack(fArr) && !isNearRedILine(fArr);
        }
    };
    public static final int DEFAULT_RESIZE_BITMAP_AREA = 12544;
    public static final String LOG_TAG = "Palette";
    public static final boolean LOG_TIMINGS = false;
    public static final float MIN_CONTRAST_BODY_TEXT = 4.5f;
    public static final float MIN_CONTRAST_TITLE_TEXT = 3.0f;
    public final List<Swatch> mSwatches;
    public final List<Target> mTargets;
    public final SparseBooleanArray mUsedColors = new SparseBooleanArray();
    public final Map<Target, Swatch> mSelectedSwatches = new ArrayMap();
    @Nullable
    public final Swatch mDominantSwatch = findDominantSwatch();

    /* loaded from: classes3.dex */
    public static final class Builder {
        @Nullable
        public final Bitmap mBitmap;
        @Nullable
        public Rect mRegion;
        @Nullable
        public final List<Swatch> mSwatches;
        public final List<Target> mTargets = new ArrayList();
        public int mMaxColors = 16;
        public int mResizeArea = Palette.DEFAULT_RESIZE_BITMAP_AREA;
        public int mResizeMaxDimension = -1;
        public final List<Filter> mFilters = new ArrayList();

        public Builder(@NonNull Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            this.mFilters.add(Palette.DEFAULT_FILTER);
            this.mBitmap = bitmap;
            this.mSwatches = null;
            this.mTargets.add(Target.LIGHT_VIBRANT);
            this.mTargets.add(Target.VIBRANT);
            this.mTargets.add(Target.DARK_VIBRANT);
            this.mTargets.add(Target.LIGHT_MUTED);
            this.mTargets.add(Target.MUTED);
            this.mTargets.add(Target.DARK_MUTED);
        }

        public Builder(@NonNull List<Swatch> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("List of Swatches is not valid");
            }
            this.mFilters.add(Palette.DEFAULT_FILTER);
            this.mSwatches = list;
            this.mBitmap = null;
        }

        private int[] getPixelsFromBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.mRegion;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.mRegion.height();
            int[] iArr2 = new int[width2 * height2];
            for (int i = 0; i < height2; i++) {
                Rect rect2 = this.mRegion;
                System.arraycopy(iArr, ((rect2.top + i) * width) + rect2.left, iArr2, i * width2, width2);
            }
            return iArr2;
        }

        private Bitmap scaleBitmapDown(Bitmap bitmap) {
            int max;
            int i;
            double d = -1.0d;
            if (this.mResizeArea > 0) {
                int height = bitmap.getHeight() * bitmap.getWidth();
                int i2 = this.mResizeArea;
                if (height > i2) {
                    d = Math.sqrt(i2 / height);
                }
            } else if (this.mResizeMaxDimension > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i = this.mResizeMaxDimension)) {
                d = i / max;
            }
            return d <= RoundRectDrawableWithShadow.COS_45 ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * d), (int) Math.ceil(bitmap.getHeight() * d), false);
        }

        @NonNull
        public Builder addFilter(Filter filter) {
            if (filter != null) {
                this.mFilters.add(filter);
            }
            return this;
        }

        @NonNull
        public Builder addTarget(@NonNull Target target) {
            if (!this.mTargets.contains(target)) {
                this.mTargets.add(target);
            }
            return this;
        }

        @NonNull
        public Builder clearFilters() {
            this.mFilters.clear();
            return this;
        }

        @NonNull
        public Builder clearRegion() {
            this.mRegion = null;
            return this;
        }

        @NonNull
        public Builder clearTargets() {
            List<Target> list = this.mTargets;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        @NonNull
        public AsyncTask<Bitmap, Void, Palette> generate(@NonNull final PaletteAsyncListener paletteAsyncListener) {
            if (paletteAsyncListener != null) {
                return new AsyncTask<Bitmap, Void, Palette>() { // from class: androidx.palette.graphics.Palette.Builder.1
                    @Override // android.os.AsyncTask
                    @Nullable
                    public Palette doInBackground(Bitmap... bitmapArr) {
                        try {
                            return Builder.this.generate();
                        } catch (Exception unused) {
                            return null;
                        }
                    }

                    @Override // android.os.AsyncTask
                    public void onPostExecute(@Nullable Palette palette) {
                        paletteAsyncListener.onGenerated(palette);
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.mBitmap);
            }
            throw new IllegalArgumentException("listener can not be null");
        }

        @NonNull
        public Palette generate() {
            List<Swatch> list;
            Filter[] filterArr;
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                Bitmap scaleBitmapDown = scaleBitmapDown(bitmap);
                Rect rect = this.mRegion;
                if (scaleBitmapDown != this.mBitmap && rect != null) {
                    double width = scaleBitmapDown.getWidth() / this.mBitmap.getWidth();
                    rect.left = (int) Math.floor(rect.left * width);
                    rect.top = (int) Math.floor(rect.top * width);
                    rect.right = Math.min((int) Math.ceil(rect.right * width), scaleBitmapDown.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(rect.bottom * width), scaleBitmapDown.getHeight());
                }
                int[] pixelsFromBitmap = getPixelsFromBitmap(scaleBitmapDown);
                int i = this.mMaxColors;
                if (this.mFilters.isEmpty()) {
                    filterArr = null;
                } else {
                    List<Filter> list2 = this.mFilters;
                    filterArr = (Filter[]) list2.toArray(new Filter[list2.size()]);
                }
                ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(pixelsFromBitmap, i, filterArr);
                if (scaleBitmapDown != this.mBitmap) {
                    scaleBitmapDown.recycle();
                }
                list = colorCutQuantizer.getQuantizedColors();
            } else {
                list = this.mSwatches;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            Palette palette = new Palette(list, this.mTargets);
            palette.generate();
            return palette;
        }

        @NonNull
        public Builder maximumColorCount(int i) {
            this.mMaxColors = i;
            return this;
        }

        @NonNull
        public Builder resizeBitmapArea(int i) {
            this.mResizeArea = i;
            this.mResizeMaxDimension = -1;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder resizeBitmapSize(int i) {
            this.mResizeMaxDimension = i;
            this.mResizeArea = -1;
            return this;
        }

        @NonNull
        public Builder setRegion(@AbstractC0047Px int i, @AbstractC0047Px int i2, @AbstractC0047Px int i3, @AbstractC0047Px int i4) {
            if (this.mBitmap != null) {
                if (this.mRegion == null) {
                    this.mRegion = new Rect();
                }
                this.mRegion.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
                if (!this.mRegion.intersect(i, i2, i3, i4)) {
                    throw new IllegalArgumentException("The given region must intersect with the Bitmap's dimensions.");
                }
            }
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public interface Filter {
        boolean isAllowed(@ColorInt int i, @NonNull float[] fArr);
    }

    /* loaded from: classes3.dex */
    public interface PaletteAsyncListener {
        void onGenerated(@Nullable Palette palette);
    }

    /* loaded from: classes3.dex */
    public static final class Swatch {
        public final int mBlue;
        public int mBodyTextColor;
        public boolean mGeneratedTextColors;
        public final int mGreen;
        @Nullable
        public float[] mHsl;
        public final int mPopulation;
        public final int mRed;
        public final int mRgb;
        public int mTitleTextColor;

        public Swatch(@ColorInt int i, int i2) {
            this.mRed = Color.red(i);
            this.mGreen = Color.green(i);
            this.mBlue = Color.blue(i);
            this.mRgb = i;
            this.mPopulation = i2;
        }

        public Swatch(int i, int i2, int i3, int i4) {
            this.mRed = i;
            this.mGreen = i2;
            this.mBlue = i3;
            this.mRgb = Color.rgb(i, i2, i3);
            this.mPopulation = i4;
        }

        public Swatch(float[] fArr, int i) {
            this(ColorUtils.HSLToColor(fArr), i);
            this.mHsl = fArr;
        }

        private void ensureTextColorsGenerated() {
            int alphaComponent;
            if (!this.mGeneratedTextColors) {
                int calculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, 4.5f);
                int calculateMinimumAlpha2 = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, 3.0f);
                if (calculateMinimumAlpha == -1 || calculateMinimumAlpha2 == -1) {
                    int calculateMinimumAlpha3 = ColorUtils.calculateMinimumAlpha(-16777216, this.mRgb, 4.5f);
                    int calculateMinimumAlpha4 = ColorUtils.calculateMinimumAlpha(-16777216, this.mRgb, 3.0f);
                    if (calculateMinimumAlpha3 == -1 || calculateMinimumAlpha4 == -1) {
                        this.mBodyTextColor = calculateMinimumAlpha != -1 ? ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha) : ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha3);
                        this.mTitleTextColor = calculateMinimumAlpha2 != -1 ? ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2) : ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha4);
                        this.mGeneratedTextColors = true;
                        return;
                    }
                    this.mBodyTextColor = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha3);
                    alphaComponent = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha4);
                } else {
                    this.mBodyTextColor = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
                    alphaComponent = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
                }
                this.mTitleTextColor = alphaComponent;
                this.mGeneratedTextColors = true;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Swatch.class != obj.getClass()) {
                return false;
            }
            Swatch swatch = (Swatch) obj;
            return this.mPopulation == swatch.mPopulation && this.mRgb == swatch.mRgb;
        }

        @ColorInt
        public int getBodyTextColor() {
            ensureTextColorsGenerated();
            return this.mBodyTextColor;
        }

        @NonNull
        public float[] getHsl() {
            if (this.mHsl == null) {
                this.mHsl = new float[3];
            }
            ColorUtils.RGBToHSL(this.mRed, this.mGreen, this.mBlue, this.mHsl);
            return this.mHsl;
        }

        public int getPopulation() {
            return this.mPopulation;
        }

        @ColorInt
        public int getRgb() {
            return this.mRgb;
        }

        @ColorInt
        public int getTitleTextColor() {
            ensureTextColorsGenerated();
            return this.mTitleTextColor;
        }

        public int hashCode() {
            return (this.mRgb * 31) + this.mPopulation;
        }

        public String toString() {
            return Swatch.class.getSimpleName() + " [RGB: #" + Integer.toHexString(getRgb()) + "] [HSL: " + Arrays.toString(getHsl()) + "] [Population: " + this.mPopulation + "] [Title Text: #" + Integer.toHexString(getTitleTextColor()) + "] [Body Text: #" + Integer.toHexString(getBodyTextColor()) + ']';
        }
    }

    public Palette(List<Swatch> list, List<Target> list2) {
        this.mSwatches = list;
        this.mTargets = list2;
    }

    @Nullable
    private Swatch findDominantSwatch() {
        int size = this.mSwatches.size();
        int i = Integer.MIN_VALUE;
        Swatch swatch = null;
        for (int i2 = 0; i2 < size; i2++) {
            Swatch swatch2 = this.mSwatches.get(i2);
            if (swatch2.getPopulation() > i) {
                i = swatch2.getPopulation();
                swatch = swatch2;
            }
        }
        return swatch;
    }

    @NonNull
    public static Builder from(@NonNull Bitmap bitmap) {
        return new Builder(bitmap);
    }

    @NonNull
    public static Palette from(@NonNull List<Swatch> list) {
        return new Builder(list).generate();
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap) {
        return from(bitmap).generate();
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap, int i) {
        return from(bitmap).maximumColorCount(i).generate();
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, int i, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).maximumColorCount(i).generate(paletteAsyncListener);
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).generate(paletteAsyncListener);
    }

    private float generateScore(Swatch swatch, Target target) {
        float[] hsl = swatch.getHsl();
        Swatch swatch2 = this.mDominantSwatch;
        int population = swatch2 != null ? swatch2.getPopulation() : 1;
        float f = 0.0f;
        float abs = target.getSaturationWeight() > 0.0f ? (1.0f - Math.abs(hsl[1] - target.getTargetSaturation())) * target.getSaturationWeight() : 0.0f;
        float abs2 = target.getLightnessWeight() > 0.0f ? (1.0f - Math.abs(hsl[2] - target.getTargetLightness())) * target.getLightnessWeight() : 0.0f;
        if (target.getPopulationWeight() > 0.0f) {
            f = (swatch.getPopulation() / population) * target.getPopulationWeight();
        }
        return abs + abs2 + f;
    }

    @Nullable
    private Swatch generateScoredTarget(Target target) {
        Swatch maxScoredSwatchForTarget = getMaxScoredSwatchForTarget(target);
        if (maxScoredSwatchForTarget != null && target.isExclusive()) {
            this.mUsedColors.append(maxScoredSwatchForTarget.getRgb(), true);
        }
        return maxScoredSwatchForTarget;
    }

    @Nullable
    private Swatch getMaxScoredSwatchForTarget(Target target) {
        int size = this.mSwatches.size();
        float f = 0.0f;
        Swatch swatch = null;
        for (int i = 0; i < size; i++) {
            Swatch swatch2 = this.mSwatches.get(i);
            if (shouldBeScoredForTarget(swatch2, target)) {
                float generateScore = generateScore(swatch2, target);
                if (swatch == null || generateScore > f) {
                    swatch = swatch2;
                    f = generateScore;
                }
            }
        }
        return swatch;
    }

    private boolean shouldBeScoredForTarget(Swatch swatch, Target target) {
        float[] hsl = swatch.getHsl();
        return hsl[1] >= target.getMinimumSaturation() && hsl[1] <= target.getMaximumSaturation() && hsl[2] >= target.getMinimumLightness() && hsl[2] <= target.getMaximumLightness() && !this.mUsedColors.get(swatch.getRgb());
    }

    public void generate() {
        int size = this.mTargets.size();
        for (int i = 0; i < size; i++) {
            Target target = this.mTargets.get(i);
            target.normalizeWeights();
            this.mSelectedSwatches.put(target, generateScoredTarget(target));
        }
        this.mUsedColors.clear();
    }

    @ColorInt
    public int getColorForTarget(@NonNull Target target, @ColorInt int i) {
        Swatch swatchForTarget = getSwatchForTarget(target);
        return swatchForTarget != null ? swatchForTarget.getRgb() : i;
    }

    @ColorInt
    public int getDarkMutedColor(@ColorInt int i) {
        return getColorForTarget(Target.DARK_MUTED, i);
    }

    @Nullable
    public Swatch getDarkMutedSwatch() {
        return getSwatchForTarget(Target.DARK_MUTED);
    }

    @ColorInt
    public int getDarkVibrantColor(@ColorInt int i) {
        return getColorForTarget(Target.DARK_VIBRANT, i);
    }

    @Nullable
    public Swatch getDarkVibrantSwatch() {
        return getSwatchForTarget(Target.DARK_VIBRANT);
    }

    @ColorInt
    public int getDominantColor(@ColorInt int i) {
        Swatch swatch = this.mDominantSwatch;
        return swatch != null ? swatch.getRgb() : i;
    }

    @Nullable
    public Swatch getDominantSwatch() {
        return this.mDominantSwatch;
    }

    @ColorInt
    public int getLightMutedColor(@ColorInt int i) {
        return getColorForTarget(Target.LIGHT_MUTED, i);
    }

    @Nullable
    public Swatch getLightMutedSwatch() {
        return getSwatchForTarget(Target.LIGHT_MUTED);
    }

    @ColorInt
    public int getLightVibrantColor(@ColorInt int i) {
        return getColorForTarget(Target.LIGHT_VIBRANT, i);
    }

    @Nullable
    public Swatch getLightVibrantSwatch() {
        return getSwatchForTarget(Target.LIGHT_VIBRANT);
    }

    @ColorInt
    public int getMutedColor(@ColorInt int i) {
        return getColorForTarget(Target.MUTED, i);
    }

    @Nullable
    public Swatch getMutedSwatch() {
        return getSwatchForTarget(Target.MUTED);
    }

    @Nullable
    public Swatch getSwatchForTarget(@NonNull Target target) {
        return this.mSelectedSwatches.get(target);
    }

    @NonNull
    public List<Swatch> getSwatches() {
        return Collections.unmodifiableList(this.mSwatches);
    }

    @NonNull
    public List<Target> getTargets() {
        return Collections.unmodifiableList(this.mTargets);
    }

    @ColorInt
    public int getVibrantColor(@ColorInt int i) {
        return getColorForTarget(Target.VIBRANT, i);
    }

    @Nullable
    public Swatch getVibrantSwatch() {
        return getSwatchForTarget(Target.VIBRANT);
    }
}

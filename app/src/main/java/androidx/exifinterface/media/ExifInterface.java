package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.AutoScrollHelper;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import okhttp3.internal.p054ws.WebSocketProtocol;
import org.apache.http.message.TokenParser;
import org.mozilla.javascript.Icode;
import org.mozilla.javascript.regexp.NativeRegExp;

/* loaded from: classes3.dex */
public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    public static final Charset ASCII;
    public static final short BYTE_ALIGN_II = 18761;
    public static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    public static final boolean DEBUG = false;
    public static final ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    public static final byte[] IDENTIFIER_EXIF_APP1;
    public static final int IFD_FORMAT_BYTE = 1;
    public static final int IFD_FORMAT_DOUBLE = 12;
    public static final int IFD_FORMAT_IFD = 13;
    public static final int IFD_FORMAT_SBYTE = 6;
    public static final int IFD_FORMAT_SINGLE = 11;
    public static final int IFD_FORMAT_SLONG = 9;
    public static final int IFD_FORMAT_SRATIONAL = 10;
    public static final int IFD_FORMAT_SSHORT = 8;
    public static final int IFD_FORMAT_STRING = 2;
    public static final int IFD_FORMAT_ULONG = 4;
    public static final int IFD_FORMAT_UNDEFINED = 7;
    public static final int IFD_FORMAT_URATIONAL = 5;
    public static final int IFD_FORMAT_USHORT = 3;
    public static final int IFD_OFFSET = 8;
    public static final int IFD_TYPE_EXIF = 1;
    public static final int IFD_TYPE_GPS = 2;
    public static final int IFD_TYPE_INTEROPERABILITY = 3;
    public static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    public static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    public static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    public static final int IFD_TYPE_PEF = 9;
    public static final int IFD_TYPE_PREVIEW = 5;
    public static final int IFD_TYPE_PRIMARY = 0;
    public static final int IFD_TYPE_THUMBNAIL = 4;
    public static final int IMAGE_TYPE_ARW = 1;
    public static final int IMAGE_TYPE_CR2 = 2;
    public static final int IMAGE_TYPE_DNG = 3;
    public static final int IMAGE_TYPE_JPEG = 4;
    public static final int IMAGE_TYPE_NEF = 5;
    public static final int IMAGE_TYPE_NRW = 6;
    public static final int IMAGE_TYPE_ORF = 7;
    public static final int IMAGE_TYPE_PEF = 8;
    public static final int IMAGE_TYPE_RAF = 9;
    public static final int IMAGE_TYPE_RW2 = 10;
    public static final int IMAGE_TYPE_SRW = 11;
    public static final int IMAGE_TYPE_UNKNOWN = 0;
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    public static final byte MARKER = -1;
    public static final byte MARKER_APP1 = -31;
    public static final byte MARKER_COM = -2;
    public static final byte MARKER_EOI = -39;
    public static final byte MARKER_SOF0 = -64;
    public static final byte MARKER_SOF1 = -63;
    public static final byte MARKER_SOF10 = -54;
    public static final byte MARKER_SOF11 = -53;
    public static final byte MARKER_SOF13 = -51;
    public static final byte MARKER_SOF14 = -50;
    public static final byte MARKER_SOF15 = -49;
    public static final byte MARKER_SOF2 = -62;
    public static final byte MARKER_SOF3 = -61;
    public static final byte MARKER_SOF5 = -59;
    public static final byte MARKER_SOF6 = -58;
    public static final byte MARKER_SOF7 = -57;
    public static final byte MARKER_SOF9 = -55;
    public static final byte MARKER_SOS = -38;
    public static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    public static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    public static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    public static final short ORF_SIGNATURE_1 = 20306;
    public static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    public static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    public static final String PEF_SIGNATURE = "PENTAX";
    public static final ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    public static final int RAF_INFO_SIZE = 160;
    public static final int RAF_JPEG_LENGTH_VALUE_SIZE = 4;
    public static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    public static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    public static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    public static final int SIGNATURE_CHECK_SIZE = 5000;
    public static final byte START_CODE = 42;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    public static final String TAG = "ExifInterface";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_HAS_THUMBNAIL = "HasThumbnail";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_THUMBNAIL_DATA = "ThumbnailData";
    public static final String TAG_THUMBNAIL_LENGTH = "ThumbnailLength";
    public static final String TAG_THUMBNAIL_OFFSET = "ThumbnailOffset";
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    public static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    public static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    public static SimpleDateFormat sFormatter;
    public static final Pattern sGpsTimestampPattern;
    public static final Pattern sNonZeroTimePattern;
    public final AssetManager.AssetInputStream mAssetInputStream;
    public final HashMap<String, ExifAttribute>[] mAttributes;
    public Set<Integer> mAttributesOffsets;
    public ByteOrder mExifByteOrder;
    public int mExifOffset;
    public final String mFilename;
    public boolean mHasThumbnail;
    public boolean mIsSupportedFile;
    public int mMimeType;
    public int mOrfMakerNoteOffset;
    public int mOrfThumbnailLength;
    public int mOrfThumbnailOffset;
    public int mRw2JpgFromRawOffset;
    public byte[] mThumbnailBytes;
    public int mThumbnailCompression;
    public int mThumbnailLength;
    public int mThumbnailOffset;
    public static final List<Integer> ROTATION_ORDER = Arrays.asList(1, 6, 3, 8);
    public static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(2, 7, 4, 5);
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    public static final byte MARKER_SOI = -40;
    public static final byte[] JPEG_SIGNATURE = {-1, MARKER_SOI, -1};
    public static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    public static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    public static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    public static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final ExifTag[] IFD_TIFF_TAGS = {new ExifTag(TAG_NEW_SUBFILE_TYPE, TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_IMAGE_LENGTH, InputDeviceCompat.SOURCE_KEYBOARD, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 2), new ExifTag(TAG_WHITE_POINT, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ISSUPPORT, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, TbsListener.ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 5), new ExifTag(TAG_SUB_IFD_POINTER, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7)};
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final ExifTag[] IFD_EXIF_TAGS = {new ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(TAG_F_NUMBER, 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(TAG_OECF, 34856, 7), new ExifTag(TAG_EXIF_VERSION, UMModuleRegister.INNER_EVENT_VALUE_HIGH, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, UMModuleRegister.APPSTATUS_SWITCH_LOW, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifTag(TAG_METERING_MODE, 37383, 3), new ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(TAG_FLASH, 37385, 3), new ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(TAG_FLASHPIX_VERSION, 40960, 7), new ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final ExifTag[] IFD_GPS_TAGS = {new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(TAG_GPS_LATITUDE, 2, 5), new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(TAG_GPS_LONGITUDE, 4, 5), new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3)};
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final ExifTag[] IFD_INTEROPERABILITY_TAGS = {new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final ExifTag[] IFD_THUMBNAIL_TAGS = {new ExifTag(TAG_NEW_SUBFILE_TYPE, TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, InputDeviceCompat.SOURCE_KEYBOARD, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 2), new ExifTag(TAG_WHITE_POINT, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ISSUPPORT, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, TbsListener.ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 5), new ExifTag(TAG_SUB_IFD_POINTER, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
    public static final ExifTag TAG_RAF_IMAGE_SIZE = new ExifTag(TAG_STRIP_OFFSETS, 273, 3);
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    public static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final ExifTag[] ORF_MAKER_NOTE_TAGS = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, InputDeviceCompat.SOURCE_KEYBOARD, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    public static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS = {new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
    public static final ExifTag[] EXIF_POINTER_TAGS = {new ExifTag(TAG_SUB_IFD_POINTER, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
    public static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4);
    public static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
    public static final HashSet<String> sTagSetForCompatibility = new HashSet<>(Arrays.asList(TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP));
    public static final HashMap<Integer, Integer> sExifPointerTagMap = new HashMap<>();

    /* loaded from: classes3.dex */
    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        public ByteOrder mByteOrder;
        public DataInputStream mDataInputStream;
        public final int mLength;
        public int mPosition;
        public static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        public static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            int available = dataInputStream.available();
            this.mLength = available;
            this.mPosition = 0;
            this.mDataInputStream.mark(available);
        }

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.mDataInputStream.available();
        }

        public int peek() {
            return this.mPosition;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.mDataInputStream.read(bArr, i, i2);
            this.mPosition += read;
            return read;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i = this.mPosition + 1;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                if (read < 0) {
                    throw new EOFException();
                }
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.mPosition + bArr.length;
            this.mPosition = length;
            if (length <= this.mLength) {
                if (this.mDataInputStream.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.mPosition + i2;
            this.mPosition = i3;
            if (i3 <= this.mLength) {
                if (this.mDataInputStream.read(bArr, i, i2) != i2) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i = this.mPosition + 4;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                if ((read | read2 | read3 | read4) < 0) {
                    throw new EOFException();
                }
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == BIG_ENDIAN) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid byte order: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mByteOrder);
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i = this.mPosition + 8;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                int read5 = this.mDataInputStream.read();
                int read6 = this.mDataInputStream.read();
                int read7 = this.mDataInputStream.read();
                int read8 = this.mDataInputStream.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                    throw new EOFException();
                }
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == BIG_ENDIAN) {
                    return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid byte order: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mByteOrder);
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i = this.mPosition + 2;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) < 0) {
                    throw new EOFException();
                }
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == BIG_ENDIAN) {
                    return (short) ((read << 8) + read2);
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid byte order: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mByteOrder);
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        public long readUnsignedInt() throws IOException {
            return readInt() & 4294967295L;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i = this.mPosition + 2;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) < 0) {
                    throw new EOFException();
                }
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == BIG_ENDIAN) {
                    return (read << 8) + read2;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid byte order: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mByteOrder);
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            throw new EOFException();
        }

        public void seek(long j) throws IOException {
            int i = this.mPosition;
            if (i > j) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
                this.mDataInputStream.mark(this.mLength);
            } else {
                j -= i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) == i2) {
                return;
            }
            throw new IOException("Couldn't seek up to the byteCount");
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.mLength - this.mPosition);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.mDataInputStream.skipBytes(min - i2);
            }
            this.mPosition += i2;
            return i2;
        }
    }

    /* loaded from: classes3.dex */
    public static class ByteOrderedDataOutputStream extends FilterOutputStream {
        public ByteOrder mByteOrder;
        public final OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.mOutputStream = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.mOutputStream.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.mOutputStream.write(bArr, i, i2);
        }

        public void writeByte(int i) throws IOException {
            this.mOutputStream.write(i);
        }

        public void writeInt(int i) throws IOException {
            OutputStream outputStream;
            int i2;
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((i >>> 0) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                outputStream = this.mOutputStream;
                i2 = i >>> 24;
            } else if (byteOrder != ByteOrder.BIG_ENDIAN) {
                return;
            } else {
                this.mOutputStream.write((i >>> 24) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                outputStream = this.mOutputStream;
                i2 = i >>> 0;
            }
            outputStream.write(i2 & 255);
        }

        public void writeShort(short s) throws IOException {
            OutputStream outputStream;
            int i;
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((s >>> 0) & 255);
                outputStream = this.mOutputStream;
                i = s >>> 8;
            } else if (byteOrder != ByteOrder.BIG_ENDIAN) {
                return;
            } else {
                this.mOutputStream.write((s >>> 8) & 255);
                outputStream = this.mOutputStream;
                i = s >>> 0;
            }
            outputStream.write(i & 255);
        }

        public void writeUnsignedInt(long j) throws IOException {
            writeInt((int) j);
        }

        public void writeUnsignedShort(int i) throws IOException {
            writeShort((short) i);
        }
    }

    /* loaded from: classes3.dex */
    public static class ExifAttribute {
        public final byte[] bytes;
        public final int format;
        public final int numberOfComponents;

        public ExifAttribute(int i, int i2, byte[] bArr) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytes = bArr;
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes = str.getBytes(ExifInterface.ASCII);
                return new ExifAttribute(1, bytes.length, bytes);
            }
            return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static ExifAttribute createDouble(double d, ByteOrder byteOrder) {
            return createDouble(new double[]{d}, byteOrder);
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length]);
            wrap.order(byteOrder);
            for (double d : dArr) {
                wrap.putDouble(d);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute createSLong(int i, ByteOrder byteOrder) {
            return createSLong(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putInt(i);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            return createSRational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes = (str + (char) 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, bytes.length, bytes);
        }

        public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
            return createULong(new long[]{j}, byteOrder);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int i, ByteOrder byteOrder) {
            return createUShort(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value != null) {
                if (value instanceof String) {
                    return Double.parseDouble((String) value);
                }
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length != 1) {
                        throw new NumberFormatException("There are more than one component");
                    }
                    return jArr[0];
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length != 1) {
                        throw new NumberFormatException("There are more than one component");
                    }
                    return iArr[0];
                } else if (value instanceof double[]) {
                    double[] dArr = (double[]) value;
                    if (dArr.length != 1) {
                        throw new NumberFormatException("There are more than one component");
                    }
                    return dArr[0];
                } else if (!(value instanceof Rational[])) {
                    throw new NumberFormatException("Couldn't find a double value");
                } else {
                    Rational[] rationalArr = (Rational[]) value;
                    if (rationalArr.length != 1) {
                        throw new NumberFormatException("There are more than one component");
                    }
                    return rationalArr[0].calculate();
                }
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value != null) {
                if (value instanceof String) {
                    return Integer.parseInt((String) value);
                }
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length != 1) {
                        throw new NumberFormatException("There are more than one component");
                    }
                    return (int) jArr[0];
                } else if (!(value instanceof int[])) {
                    throw new NumberFormatException("Couldn't find a integer value");
                } else {
                    int[] iArr = (int[]) value;
                    if (iArr.length != 1) {
                        throw new NumberFormatException("There are more than one component");
                    }
                    return iArr[0];
                }
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof String) {
                return (String) value;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(value instanceof Rational[])) {
                return null;
            } else {
                Rational[] rationalArr = (Rational[]) value;
                while (i < rationalArr.length) {
                    sb.append(rationalArr[i].numerator);
                    sb.append('/');
                    sb.append(rationalArr[i].denominator);
                    i++;
                    if (i != rationalArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        public Object getValue(ByteOrder byteOrder) {
            ByteOrderedDataInputStream byteOrderedDataInputStream;
            byte b;
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
            try {
                byteOrderedDataInputStream = new ByteOrderedDataInputStream(this.bytes);
                try {
                    byteOrderedDataInputStream.setByteOrder(byteOrder);
                    boolean z = true;
                    int i = 0;
                    switch (this.format) {
                        case 1:
                        case 6:
                            if (this.bytes.length != 1 || this.bytes[0] < 0 || this.bytes[0] > 1) {
                                String str = new String(this.bytes, ExifInterface.ASCII);
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException unused) {
                                }
                                return str;
                            }
                            String str2 = new String(new char[]{(char) (this.bytes[0] + NativeRegExp.REOP_MINIMALQUANT)});
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused2) {
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.numberOfComponents >= ExifInterface.EXIF_ASCII_PREFIX.length) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 < ExifInterface.EXIF_ASCII_PREFIX.length) {
                                        if (this.bytes[i2] != ExifInterface.EXIF_ASCII_PREFIX[i2]) {
                                            z = false;
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                                if (z) {
                                    i = ExifInterface.EXIF_ASCII_PREFIX.length;
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (i < this.numberOfComponents && (b = this.bytes[i]) != 0) {
                                if (b >= 32) {
                                    sb.append((char) b);
                                } else {
                                    sb.append('?');
                                }
                                i++;
                            }
                            String sb2 = sb.toString();
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused3) {
                            }
                            return sb2;
                        case 3:
                            int[] iArr = new int[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                iArr[i] = byteOrderedDataInputStream.readUnsignedShort();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused4) {
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                jArr[i] = byteOrderedDataInputStream.readUnsignedInt();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused5) {
                            }
                            return jArr;
                        case 5:
                            Rational[] rationalArr = new Rational[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                rationalArr[i] = new Rational(byteOrderedDataInputStream.readUnsignedInt(), byteOrderedDataInputStream.readUnsignedInt());
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused6) {
                            }
                            return rationalArr;
                        case 8:
                            int[] iArr2 = new int[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                iArr2[i] = byteOrderedDataInputStream.readShort();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused7) {
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                iArr3[i] = byteOrderedDataInputStream.readInt();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused8) {
                            }
                            return iArr3;
                        case 10:
                            Rational[] rationalArr2 = new Rational[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                rationalArr2[i] = new Rational(byteOrderedDataInputStream.readInt(), byteOrderedDataInputStream.readInt());
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused9) {
                            }
                            return rationalArr2;
                        case 11:
                            double[] dArr = new double[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                dArr[i] = byteOrderedDataInputStream.readFloat();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused10) {
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                dArr2[i] = byteOrderedDataInputStream.readDouble();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused11) {
                            }
                            return dArr2;
                        default:
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused12) {
                            }
                            return null;
                    }
                } catch (IOException unused13) {
                    if (byteOrderedDataInputStream != null) {
                        try {
                            byteOrderedDataInputStream.close();
                        } catch (IOException unused14) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                    if (byteOrderedDataInputStream2 != null) {
                        try {
                            byteOrderedDataInputStream2.close();
                        } catch (IOException unused15) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused16) {
                byteOrderedDataInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public int size() {
            return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExifInterface.IFD_FORMAT_NAMES[this.format]);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", data length:");
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.bytes.length, ")");
        }
    }

    /* loaded from: classes3.dex */
    public static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        public ExifTag(String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        public ExifTag(String str, int i, int i2, int i3) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }

        public boolean isFormatCompatible(int i) {
            int i2;
            int i3 = this.primaryFormat;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.secondaryFormat) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((this.primaryFormat == 9 || this.secondaryFormat == 9) && i == 8) {
                return true;
            }
            return (this.primaryFormat == 12 || this.secondaryFormat == 12) && i == 11;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes3.dex */
    public @interface IfdType {
    }

    /* loaded from: classes3.dex */
    public static class Rational {
        public final long denominator;
        public final long numerator;

        public Rational(double d) {
            this((long) (d * 10000.0d), 10000L);
        }

        public Rational(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0L;
                this.denominator = 1L;
                return;
            }
            this.numerator = j;
            this.denominator = j2;
        }

        public double calculate() {
            return this.numerator / this.denominator;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }
    }

    static {
        ExifTag[] exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = exifTagArr2;
        ExifTag[] exifTagArr3 = IFD_TIFF_TAGS;
        EXIF_TAGS = new ExifTag[][]{exifTagArr3, IFD_EXIF_TAGS, IFD_GPS_TAGS, IFD_INTEROPERABILITY_TAGS, IFD_THUMBNAIL_TAGS, exifTagArr3, ORF_MAKER_NOTE_TAGS, ORF_CAMERA_SETTINGS_TAGS, ORF_IMAGE_PROCESSING_TAGS, exifTagArr2};
        ExifTag[][] exifTagArr4 = EXIF_TAGS;
        sExifTagMapsForReading = new HashMap[exifTagArr4.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr4.length];
        Charset forName = Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            sExifTagMapsForReading[i] = new HashMap<>();
            sExifTagMapsForWriting[i] = new HashMap<>();
            for (ExifTag exifTag : EXIF_TAGS[i]) {
                sExifTagMapsForReading[i].put(Integer.valueOf(exifTag.number), exifTag);
                sExifTagMapsForWriting[i].put(exifTag.name, exifTag);
            }
        }
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[0].number), 5);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[1].number), 1);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[2].number), 2);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[3].number), 3);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[4].number), 7);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[5].number), 8);
        sNonZeroTimePattern = Pattern.compile(".*[1-9].*");
        sGpsTimestampPattern = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            AssetManager.AssetInputStream assetInputStream = null;
            this.mFilename = null;
            this.mAssetInputStream = inputStream instanceof AssetManager.AssetInputStream ? (AssetManager.AssetInputStream) inputStream : assetInputStream;
            loadAttributes(inputStream);
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null");
    }

    public ExifInterface(@NonNull String str) throws IOException {
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.mAssetInputStream = null;
            this.mFilename = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    loadAttributes(fileInputStream2);
                    closeQuietly(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalArgumentException("filename cannot be null");
        }
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.mAttributes[0].put(TAG_DATETIME, ExifAttribute.createString(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.mAttributes[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    private String convertDecimalDegree(double d) {
        long j = (long) d;
        double d2 = d - j;
        long j2 = (long) (d2 * 60.0d);
        long round = Math.round((d2 - (j2 / 60.0d)) * 3600.0d * 1.0E7d);
        return j + "/1," + j2 + "/1," + round + "/10000000";
    }

    public static double convertRationalLatLonToDouble(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            double parseDouble = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble2 = ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + parseDouble;
            if (!str2.equals(LATITUDE_SOUTH) && !str2.equals(LONGITUDE_WEST)) {
                if (!str2.equals("N") && !str2.equals(LONGITUDE_EAST)) {
                    throw new IllegalArgumentException();
                }
                return parseDouble2;
            }
            return -parseDouble2;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    public static long[] convertToLongArray(Object obj) {
        if (!(obj instanceof int[])) {
            if (!(obj instanceof long[])) {
                return null;
            }
            return (long[]) obj;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                i += read;
                outputStream.write(bArr, 0, read);
            } else {
                return i;
            }
        }
    }

    @Nullable
    private ExifAttribute getExifAttribute(@NonNull String str) {
        if (TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            ExifAttribute exifAttribute = this.mAttributes[i].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0113, code lost:
        r9.setByteOrder(r8.mExifByteOrder);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0118, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getJpegAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream, int i, int i2) throws IOException {
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byteOrderedDataInputStream.seek(i);
        byte readByte = byteOrderedDataInputStream.readByte();
        if (readByte != -1) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid marker: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(readByte & 255));
            throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        int i3 = i + 1;
        if (byteOrderedDataInputStream.readByte() != -40) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid marker: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Integer.toHexString(readByte & 255));
            throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        int i4 = i3 + 1;
        while (true) {
            byte readByte2 = byteOrderedDataInputStream.readByte();
            if (readByte2 != -1) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid marker:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(Integer.toHexString(readByte2 & 255));
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            }
            byte readByte3 = byteOrderedDataInputStream.readByte();
            int i5 = i4 + 1 + 1;
            if (readByte3 != -39 && readByte3 != -38) {
                int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort() - 2;
                int i6 = i5 + 2;
                if (readUnsignedShort < 0) {
                    throw new IOException("Invalid length");
                }
                if (readByte3 != -31) {
                    if (readByte3 != -2) {
                        switch (readByte3) {
                            default:
                                switch (readByte3) {
                                    default:
                                        switch (readByte3) {
                                            default:
                                                switch (readByte3) {
                                                }
                                            case Icode.Icode_TAIL_CALL /* -55 */:
                                            case Icode.Icode_LEAVEDQ /* -54 */:
                                            case Icode.Icode_ENTERDQ /* -53 */:
                                                if (byteOrderedDataInputStream.skipBytes(1) != 1) {
                                                    throw new IOException("Invalid SOFx");
                                                }
                                                this.mAttributes[i2].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                this.mAttributes[i2].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                readUnsignedShort -= 5;
                                                break;
                                        }
                                    case Icode.Icode_SETCONST /* -59 */:
                                    case Icode.Icode_LITERAL_SETTER /* -58 */:
                                    case Icode.Icode_LITERAL_GETTER /* -57 */:
                                        break;
                                }
                            case -64:
                            case Icode.Icode_GENERATOR_END /* -63 */:
                            case Icode.Icode_GENERATOR /* -62 */:
                            case Icode.Icode_SETCONSTVAR1 /* -61 */:
                                break;
                        }
                    } else {
                        byte[] bArr = new byte[readUnsignedShort];
                        if (byteOrderedDataInputStream.read(bArr) != readUnsignedShort) {
                            throw new IOException("Invalid exif");
                        }
                        if (getAttribute(TAG_USER_COMMENT) == null) {
                            this.mAttributes[1].put(TAG_USER_COMMENT, ExifAttribute.createString(new String(bArr, ASCII)));
                        }
                        readUnsignedShort = 0;
                    }
                } else if (readUnsignedShort >= 6) {
                    byte[] bArr2 = new byte[6];
                    if (byteOrderedDataInputStream.read(bArr2) != 6) {
                        throw new IOException("Invalid exif");
                    }
                    i6 += 6;
                    readUnsignedShort -= 6;
                    if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                        if (readUnsignedShort <= 0) {
                            throw new IOException("Invalid exif");
                        }
                        this.mExifOffset = i6;
                        byte[] bArr3 = new byte[readUnsignedShort];
                        if (byteOrderedDataInputStream.read(bArr3) != readUnsignedShort) {
                            throw new IOException("Invalid exif");
                        }
                        i6 += readUnsignedShort;
                        readExifSegment(bArr3, i2);
                        readUnsignedShort = 0;
                    }
                }
                if (readUnsignedShort < 0) {
                    throw new IOException("Invalid length");
                }
                if (byteOrderedDataInputStream.skipBytes(readUnsignedShort) != readUnsignedShort) {
                    throw new IOException("Invalid JPEG segment");
                }
                i4 = i6 + readUnsignedShort;
            }
        }
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        return isRw2Format(bArr) ? 10 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getOrfAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        long j;
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2;
        ExifAttribute exifAttribute3;
        getRawAttributes(byteOrderedDataInputStream);
        ExifAttribute exifAttribute4 = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (exifAttribute4 != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute4.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = new byte[ORF_MAKER_NOTE_HEADER_1.length];
            byteOrderedDataInputStream2.readFully(bArr);
            byteOrderedDataInputStream2.seek(0L);
            byte[] bArr2 = new byte[ORF_MAKER_NOTE_HEADER_2.length];
            byteOrderedDataInputStream2.readFully(bArr2);
            if (!Arrays.equals(bArr, ORF_MAKER_NOTE_HEADER_1)) {
                if (Arrays.equals(bArr2, ORF_MAKER_NOTE_HEADER_2)) {
                    j = 12;
                }
                readImageFileDirectory(byteOrderedDataInputStream2, 6);
                exifAttribute = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
                exifAttribute2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
                if (exifAttribute != null && exifAttribute2 != null) {
                    this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute);
                    this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute2);
                }
                exifAttribute3 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
                if (exifAttribute3 != null) {
                    return;
                }
                int[] iArr = (int[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    Arrays.toString(iArr);
                    return;
                } else if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                    return;
                } else {
                    int i = (iArr[2] - iArr[0]) + 1;
                    int i2 = (iArr[3] - iArr[1]) + 1;
                    if (i < i2) {
                        int i3 = i + i2;
                        i2 = i3 - i2;
                        i = i3 - i2;
                    }
                    ExifAttribute createUShort = ExifAttribute.createUShort(i, this.mExifByteOrder);
                    ExifAttribute createUShort2 = ExifAttribute.createUShort(i2, this.mExifByteOrder);
                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort);
                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort2);
                    return;
                }
            }
            j = 8;
            byteOrderedDataInputStream2.seek(j);
            readImageFileDirectory(byteOrderedDataInputStream2, 6);
            exifAttribute = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            exifAttribute2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (exifAttribute != null) {
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute);
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute2);
            }
            exifAttribute3 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
            if (exifAttribute3 != null) {
            }
        }
    }

    private void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        byteOrderedDataInputStream.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.skipBytes(4);
        byteOrderedDataInputStream.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        getJpegAttributes(byteOrderedDataInputStream, i, 5);
        byteOrderedDataInputStream.seek(i2);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort(readShort, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(readShort2, this.mExifByteOrder);
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort2);
                return;
            }
            byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
        }
    }

    private void getRawAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        parseTiffHeaders(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
        readImageFileDirectory(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 5);
        updateImageSizeValues(byteOrderedDataInputStream, 4);
        validateImages(byteOrderedDataInputStream);
        if (this.mMimeType != 8 || (exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE)) == null) {
            return;
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
        byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
        byteOrderedDataInputStream2.seek(6L);
        readImageFileDirectory(byteOrderedDataInputStream2, 9);
        ExifAttribute exifAttribute2 = this.mAttributes[9].get(TAG_COLOR_SPACE);
        if (exifAttribute2 == null) {
            return;
        }
        this.mAttributes[1].put(TAG_COLOR_SPACE, exifAttribute2);
    }

    private void getRw2Attributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        getRawAttributes(byteOrderedDataInputStream);
        if (this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW) != null) {
            getJpegAttributes(byteOrderedDataInputStream, this.mRw2JpgFromRawOffset, 5);
        }
        ExifAttribute exifAttribute = this.mAttributes[0].get(TAG_RW2_ISO);
        ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (exifAttribute == null || exifAttribute2 != null) {
            return;
        }
        this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute);
    }

    public static Pair<Integer, Integer> guessDataFormat(String str) {
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair<Integer, Integer> guessDataFormat = guessDataFormat(split[0]);
            if (((Integer) guessDataFormat.first).intValue() == 2) {
                return guessDataFormat;
            }
            for (int i = 1; i < split.length; i++) {
                Pair<Integer, Integer> guessDataFormat2 = guessDataFormat(split[i]);
                int intValue = (((Integer) guessDataFormat2.first).equals(guessDataFormat.first) || ((Integer) guessDataFormat2.second).equals(guessDataFormat.first)) ? ((Integer) guessDataFormat.first).intValue() : -1;
                int intValue2 = (((Integer) guessDataFormat.second).intValue() == -1 || (!((Integer) guessDataFormat2.first).equals(guessDataFormat.second) && !((Integer) guessDataFormat2.second).equals(guessDataFormat.second))) ? -1 : ((Integer) guessDataFormat.second).intValue();
                if (intValue == -1 && intValue2 == -1) {
                    return new Pair<>(2, -1);
                }
                if (intValue == -1) {
                    guessDataFormat = new Pair<>(Integer.valueOf(intValue2), -1);
                } else if (intValue2 == -1) {
                    guessDataFormat = new Pair<>(Integer.valueOf(intValue), -1);
                }
            }
            return guessDataFormat;
        } else if (!str.contains("/")) {
            try {
                try {
                    Long valueOf = Long.valueOf(Long.parseLong(str));
                    return (valueOf.longValue() < 0 || valueOf.longValue() > WebSocketProtocol.PAYLOAD_SHORT_MAX) ? valueOf.longValue() < 0 ? new Pair<>(9, -1) : new Pair<>(4, -1) : new Pair<>(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair<>(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair<>(12, -1);
            }
        } else {
            String[] split2 = str.split("/", -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble >= 0 && parseDouble2 >= 0) {
                        if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                            return new Pair<>(10, 5);
                        }
                        return new Pair<>(5, -1);
                    }
                    return new Pair<>(10, -1);
                } catch (NumberFormatException unused3) {
                }
            }
            return new Pair<>(2, -1);
        }
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        int i;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int min = Math.min(exifAttribute2.getIntValue(this.mExifByteOrder), byteOrderedDataInputStream.available() - intValue);
        int i2 = this.mMimeType;
        if (i2 != 4 && i2 != 9 && i2 != 10) {
            if (i2 == 7) {
                i = this.mOrfMakerNoteOffset;
            }
            if (intValue <= 0 || min <= 0) {
            }
            this.mHasThumbnail = true;
            this.mThumbnailOffset = intValue;
            this.mThumbnailLength = min;
            if (this.mFilename != null || this.mAssetInputStream != null) {
                return;
            }
            byte[] bArr = new byte[min];
            byteOrderedDataInputStream.seek(intValue);
            byteOrderedDataInputStream.readFully(bArr);
            this.mThumbnailBytes = bArr;
            return;
        }
        i = this.mExifOffset;
        intValue += i;
        if (intValue <= 0) {
        }
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_STRIP_OFFSETS);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_STRIP_BYTE_COUNTS);
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        long[] convertToLongArray = convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
        long[] convertToLongArray2 = convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
        if (convertToLongArray == null || convertToLongArray2 == null) {
            return;
        }
        long j = 0;
        for (long j2 : convertToLongArray2) {
            j += j2;
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < convertToLongArray.length; i4++) {
            int i5 = (int) convertToLongArray[i4];
            int i6 = (int) convertToLongArray2[i4];
            int i7 = i5 - i2;
            byteOrderedDataInputStream.seek(i7);
            int i8 = i2 + i7;
            byte[] bArr2 = new byte[i6];
            byteOrderedDataInputStream.read(bArr2);
            i2 = i8 + i6;
            System.arraycopy(bArr2, 0, bArr, i3, i6);
            i3 += i6;
        }
        this.mHasThumbnail = true;
        this.mThumbnailBytes = bArr;
        this.mThumbnailLength = i;
    }

    public static boolean isJpegFormat(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i < bArr2.length) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
                i++;
            } else {
                return true;
            }
        }
    }

    private boolean isOrfFormat(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        short readShort = byteOrderedDataInputStream.readShort();
        byteOrderedDataInputStream.close();
        return readShort == 20306 || readShort == 21330;
    }

    private boolean isRafFormat(byte[] bArr) throws IOException {
        byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isRw2Format(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        short readShort = byteOrderedDataInputStream.readShort();
        byteOrderedDataInputStream.close();
        return readShort == 85;
    }

    private boolean isSupportedDataType(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_BITS_PER_SAMPLE);
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.getValue(this.mExifByteOrder);
            if (Arrays.equals(BITS_PER_SAMPLE_RGB, iArr)) {
                return true;
            }
            if (this.mMimeType != 3 || (exifAttribute = (ExifAttribute) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) == null) {
                return false;
            }
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            return (intValue == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && Arrays.equals(iArr, BITS_PER_SAMPLE_RGB));
        }
        return false;
    }

    private boolean isThumbnail(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.mExifByteOrder) <= 512 && exifAttribute2.getIntValue(this.mExifByteOrder) <= 512;
    }

    private void loadAttributes(@NonNull InputStream inputStream) throws IOException {
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            try {
                try {
                    this.mAttributes[i] = new HashMap<>();
                } catch (IOException unused) {
                    this.mIsSupportedFile = false;
                }
            } finally {
                addDefaultValuesForCompatibility();
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.mMimeType = getMimeType(bufferedInputStream);
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bufferedInputStream);
        switch (this.mMimeType) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                getRawAttributes(byteOrderedDataInputStream);
                break;
            case 4:
                getJpegAttributes(byteOrderedDataInputStream, 0, 0);
                break;
            case 7:
                getOrfAttributes(byteOrderedDataInputStream);
                break;
            case 9:
                getRafAttributes(byteOrderedDataInputStream);
                break;
            case 10:
                getRw2Attributes(byteOrderedDataInputStream);
                break;
        }
        setThumbnailData(byteOrderedDataInputStream);
        this.mIsSupportedFile = true;
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i2 = this.mMimeType;
        if (i2 != 7 && i2 != 10 && readUnsignedShort != 42) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid start code: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(readUnsignedShort));
            throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        int readInt = byteOrderedDataInputStream.readInt();
        if (readInt < 8 || readInt >= i) {
            throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid first Ifd offset: ", readInt));
        }
        int i3 = readInt - 8;
        if (i3 > 0 && byteOrderedDataInputStream.skipBytes(i3) != i3) {
            throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Couldn't jump to first Ifd: ", i3));
        }
    }

    private void printAttributes() {
        int i = 0;
        while (true) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            if (i < hashMapArr.length) {
                hashMapArr[i].size();
                for (Map.Entry<String, ExifAttribute> entry : this.mAttributes[i].entrySet()) {
                    ExifAttribute value = entry.getValue();
                    entry.getKey();
                    value.toString();
                    value.getStringValue(this.mExifByteOrder);
                }
                i++;
            } else {
                return;
            }
        }
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                return ByteOrder.BIG_ENDIAN;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid byte order: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(readShort));
            throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void readExifSegment(byte[] bArr, int i) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        parseTiffHeaders(byteOrderedDataInputStream, bArr.length);
        readImageFileDirectory(byteOrderedDataInputStream, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void readImageFileDirectory(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        int i2;
        long j;
        boolean z;
        short s;
        int i3;
        int i4;
        short s2;
        int readUnsignedShort;
        int i5 = i;
        this.mAttributesOffsets.add(Integer.valueOf(byteOrderedDataInputStream.mPosition));
        if (byteOrderedDataInputStream.mPosition + 2 > byteOrderedDataInputStream.mLength) {
            return;
        }
        short readShort = byteOrderedDataInputStream.readShort();
        if ((readShort * 12) + byteOrderedDataInputStream.mPosition > byteOrderedDataInputStream.mLength || readShort <= 0) {
            return;
        }
        short s3 = 0;
        while (s3 < readShort) {
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort3 = byteOrderedDataInputStream.readUnsignedShort();
            int readInt = byteOrderedDataInputStream.readInt();
            long peek = byteOrderedDataInputStream.peek() + 4;
            ExifTag exifTag = sExifTagMapsForReading[i5].get(Integer.valueOf(readUnsignedShort2));
            if (exifTag != null && readUnsignedShort3 > 0 && readUnsignedShort3 < IFD_FORMAT_BYTES_PER_FORMAT.length) {
                if (!exifTag.isFormatCompatible(readUnsignedShort3)) {
                    String str = IFD_FORMAT_NAMES[readUnsignedShort3];
                } else {
                    if (readUnsignedShort3 == 7) {
                        readUnsignedShort3 = exifTag.primaryFormat;
                    }
                    i2 = readUnsignedShort2;
                    j = readInt * IFD_FORMAT_BYTES_PER_FORMAT[readUnsignedShort3];
                    if (j >= 0 && j <= 2147483647L) {
                        z = true;
                        if (!z) {
                            byteOrderedDataInputStream.seek(peek);
                            s = readShort;
                            s2 = s3;
                        } else {
                            if (j > 4) {
                                int readInt2 = byteOrderedDataInputStream.readInt();
                                int i6 = this.mMimeType;
                                if (i6 == 7) {
                                    if (TAG_MAKER_NOTE.equals(exifTag.name)) {
                                        this.mOrfMakerNoteOffset = readInt2;
                                    } else if (i5 == 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(exifTag.name)) {
                                        this.mOrfThumbnailOffset = readInt2;
                                        this.mOrfThumbnailLength = readInt;
                                        ExifAttribute createUShort = ExifAttribute.createUShort(6, this.mExifByteOrder);
                                        s = readShort;
                                        ExifAttribute createULong = ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
                                        i3 = readUnsignedShort3;
                                        i4 = readInt;
                                        ExifAttribute createULong2 = ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
                                        this.mAttributes[4].put(TAG_COMPRESSION, createUShort);
                                        this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, createULong);
                                        this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, createULong2);
                                    }
                                    s = readShort;
                                    i3 = readUnsignedShort3;
                                    i4 = readInt;
                                } else {
                                    s = readShort;
                                    i3 = readUnsignedShort3;
                                    i4 = readInt;
                                    if (i6 == 10 && TAG_RW2_JPG_FROM_RAW.equals(exifTag.name)) {
                                        this.mRw2JpgFromRawOffset = readInt2;
                                    }
                                }
                                long j2 = readInt2;
                                s2 = s3;
                                if (j2 + j <= byteOrderedDataInputStream.mLength) {
                                    byteOrderedDataInputStream.seek(j2);
                                }
                                byteOrderedDataInputStream.seek(peek);
                            } else {
                                s = readShort;
                                i3 = readUnsignedShort3;
                                i4 = readInt;
                                s2 = s3;
                            }
                            Integer num = sExifPointerTagMap.get(Integer.valueOf(i2));
                            if (num != null) {
                                long j3 = -1;
                                int i7 = i3;
                                if (i7 != 3) {
                                    if (i7 == 4) {
                                        j3 = byteOrderedDataInputStream.readUnsignedInt();
                                    } else if (i7 == 8) {
                                        readUnsignedShort = byteOrderedDataInputStream.readShort();
                                    } else if (i7 == 9 || i7 == 13) {
                                        readUnsignedShort = byteOrderedDataInputStream.readInt();
                                    }
                                    if (j3 > 0 && j3 < byteOrderedDataInputStream.mLength) {
                                        if (this.mAttributesOffsets.contains(Integer.valueOf((int) j3))) {
                                            byteOrderedDataInputStream.seek(j3);
                                            readImageFileDirectory(byteOrderedDataInputStream, num.intValue());
                                        } else {
                                            String str2 = "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j3 + ")";
                                        }
                                    }
                                } else {
                                    readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                                }
                                j3 = readUnsignedShort;
                                if (j3 > 0) {
                                    if (this.mAttributesOffsets.contains(Integer.valueOf((int) j3))) {
                                    }
                                }
                            } else {
                                byte[] bArr = new byte[(int) j];
                                byteOrderedDataInputStream.readFully(bArr);
                                ExifAttribute exifAttribute = new ExifAttribute(i3, i4, bArr);
                                this.mAttributes[i].put(exifTag.name, exifAttribute);
                                if (TAG_DNG_VERSION.equals(exifTag.name)) {
                                    this.mMimeType = 3;
                                }
                                if (((TAG_MAKE.equals(exifTag.name) || TAG_MODEL.equals(exifTag.name)) && exifAttribute.getStringValue(this.mExifByteOrder).contains(PEF_SIGNATURE)) || (TAG_COMPRESSION.equals(exifTag.name) && exifAttribute.getIntValue(this.mExifByteOrder) == 65535)) {
                                    this.mMimeType = 8;
                                }
                                if (byteOrderedDataInputStream.peek() == peek) {
                                }
                            }
                            byteOrderedDataInputStream.seek(peek);
                        }
                        s3 = (short) (s2 + 1);
                        i5 = i;
                        readShort = s;
                    }
                    z = false;
                    if (!z) {
                    }
                    s3 = (short) (s2 + 1);
                    i5 = i;
                    readShort = s;
                }
            }
            i2 = readUnsignedShort2;
            j = 0;
            z = false;
            if (!z) {
            }
            s3 = (short) (s2 + 1);
            i5 = i;
            readShort = s;
        }
        if (byteOrderedDataInputStream.peek() + 4 > byteOrderedDataInputStream.mLength) {
            return;
        }
        int readInt3 = byteOrderedDataInputStream.readInt();
        long j4 = readInt3;
        if (j4 <= 0 || readInt3 >= byteOrderedDataInputStream.mLength || this.mAttributesOffsets.contains(Integer.valueOf(readInt3))) {
            return;
        }
        byteOrderedDataInputStream.seek(j4);
        int i8 = 4;
        if (!this.mAttributes[4].isEmpty()) {
            i8 = 5;
            if (!this.mAttributes[5].isEmpty()) {
                return;
            }
        }
        readImageFileDirectory(byteOrderedDataInputStream, i8);
    }

    private void removeAttribute(String str) {
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            this.mAttributes[i].remove(str);
        }
    }

    private void retrieveJpegImageSize(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = this.mAttributes[i].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute3 = this.mAttributes[i].get(TAG_IMAGE_WIDTH);
        if ((exifAttribute2 == null || exifAttribute3 == null) && (exifAttribute = this.mAttributes[i].get(TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
            getJpegAttributes(byteOrderedDataInputStream, exifAttribute.getIntValue(this.mExifByteOrder), i);
        }
    }

    private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() == -1) {
            byteOrderedDataOutputStream.writeByte(-1);
            if (dataInputStream.readByte() != -40) {
                throw new IOException("Invalid marker");
            }
            byteOrderedDataOutputStream.writeByte(-40);
            byteOrderedDataOutputStream.writeByte(-1);
            byteOrderedDataOutputStream.writeByte(-31);
            writeExifSegment(byteOrderedDataOutputStream, 6);
            byte[] bArr = new byte[4096];
            while (dataInputStream.readByte() == -1) {
                byte readByte = dataInputStream.readByte();
                if (readByte == -39 || readByte == -38) {
                    byteOrderedDataOutputStream.writeByte(-1);
                    byteOrderedDataOutputStream.writeByte(readByte);
                    copy(dataInputStream, byteOrderedDataOutputStream);
                    return;
                } else if (readByte != -31) {
                    byteOrderedDataOutputStream.writeByte(-1);
                    byteOrderedDataOutputStream.writeByte(readByte);
                    int readUnsignedShort = dataInputStream.readUnsignedShort();
                    byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                    int i = readUnsignedShort - 2;
                    if (i < 0) {
                        throw new IOException("Invalid length");
                    }
                    while (i > 0) {
                        int read = dataInputStream.read(bArr, 0, Math.min(i, 4096));
                        if (read >= 0) {
                            byteOrderedDataOutputStream.write(bArr, 0, read);
                            i -= read;
                        }
                    }
                } else {
                    int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                    if (readUnsignedShort2 < 0) {
                        throw new IOException("Invalid length");
                    }
                    byte[] bArr2 = new byte[6];
                    if (readUnsignedShort2 >= 6) {
                        if (dataInputStream.read(bArr2) != 6) {
                            throw new IOException("Invalid exif");
                        }
                        if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                            int i2 = readUnsignedShort2 - 6;
                            if (dataInputStream.skipBytes(i2) != i2) {
                                throw new IOException("Invalid length");
                            }
                        }
                    }
                    byteOrderedDataOutputStream.writeByte(-1);
                    byteOrderedDataOutputStream.writeByte(readByte);
                    byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2 + 2);
                    if (readUnsignedShort2 >= 6) {
                        readUnsignedShort2 -= 6;
                        byteOrderedDataOutputStream.write(bArr2);
                    }
                    while (readUnsignedShort2 > 0) {
                        int read2 = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                        if (read2 >= 0) {
                            byteOrderedDataOutputStream.write(bArr, 0, read2);
                            readUnsignedShort2 -= read2;
                        }
                    }
                }
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.mAttributes[4];
        ExifAttribute exifAttribute = hashMap.get(TAG_COMPRESSION);
        if (exifAttribute != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            this.mThumbnailCompression = intValue;
            if (intValue != 1) {
                if (intValue != 6) {
                    if (intValue != 7) {
                        return;
                    }
                }
            }
            if (!isSupportedDataType(hashMap)) {
                return;
            }
            handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
            return;
        }
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
    }

    private void swapBasedOnImageSize(int i, int i2) throws IOException {
        if (this.mAttributes[i].isEmpty() || this.mAttributes[i2].isEmpty()) {
            return;
        }
        ExifAttribute exifAttribute = this.mAttributes[i].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = this.mAttributes[i].get(TAG_IMAGE_WIDTH);
        ExifAttribute exifAttribute3 = this.mAttributes[i2].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute4 = this.mAttributes[i2].get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
        int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
        if (intValue >= intValue3 || intValue2 >= intValue4) {
            return;
        }
        HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
        HashMap<String, ExifAttribute> hashMap = hashMapArr[i];
        hashMapArr[i] = hashMapArr[i2];
        hashMapArr[i2] = hashMap;
    }

    private boolean updateAttribute(String str, ExifAttribute exifAttribute) {
        boolean z = false;
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            if (this.mAttributes[i].containsKey(str)) {
                this.mAttributes[i].put(str, exifAttribute);
                z = true;
            }
        }
        return z;
    }

    private void updateImageSizeValues(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute createUShort;
        ExifAttribute createUShort2;
        ExifAttribute exifAttribute = this.mAttributes[i].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute exifAttribute2 = this.mAttributes[i].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute exifAttribute3 = this.mAttributes[i].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute exifAttribute4 = this.mAttributes[i].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute exifAttribute5 = this.mAttributes[i].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (exifAttribute != null) {
            if (exifAttribute.format == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 2) {
                    Arrays.toString(rationalArr);
                    return;
                } else {
                    createUShort = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
                    createUShort2 = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
                }
            } else {
                int[] iArr = (int[]) exifAttribute.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 2) {
                    Arrays.toString(iArr);
                    return;
                } else {
                    createUShort = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                    createUShort2 = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
                }
            }
            this.mAttributes[i].put(TAG_IMAGE_WIDTH, createUShort);
            this.mAttributes[i].put(TAG_IMAGE_LENGTH, createUShort2);
        } else if (exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null || exifAttribute5 == null) {
            retrieveJpegImageSize(byteOrderedDataInputStream, i);
        } else {
            int intValue = exifAttribute2.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute5.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute3.getIntValue(this.mExifByteOrder);
            if (intValue2 <= intValue || intValue3 <= intValue4) {
                return;
            }
            ExifAttribute createUShort3 = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
            ExifAttribute createUShort4 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
            this.mAttributes[i].put(TAG_IMAGE_LENGTH, createUShort3);
            this.mAttributes[i].put(TAG_IMAGE_WIDTH, createUShort4);
        }
    }

    private void validateImages(InputStream inputStream) throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (exifAttribute != null && exifAttribute2 != null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifAttribute);
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        isThumbnail(this.mAttributes[4]);
    }

    private int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream, int i) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : EXIF_POINTER_TAGS) {
            removeAttribute(exifTag.name);
        }
        removeAttribute(JPEG_INTERCHANGE_FORMAT_TAG.name);
        removeAttribute(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            for (Object obj : this.mAttributes[i2].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.mAttributes[i2].remove(entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(0L, this.mExifByteOrder));
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, ExifAttribute.createULong(this.mThumbnailLength, this.mExifByteOrder));
        }
        for (int i3 = 0; i3 < EXIF_TAGS.length; i3++) {
            int i4 = 0;
            for (Map.Entry<String, ExifAttribute> entry2 : this.mAttributes[i3].entrySet()) {
                int size = entry2.getValue().size();
                if (size > 4) {
                    i4 += size;
                }
            }
            iArr2[i3] = iArr2[i3] + i4;
        }
        int i5 = 8;
        for (int i6 = 0; i6 < EXIF_TAGS.length; i6++) {
            if (!this.mAttributes[i6].isEmpty()) {
                iArr[i6] = i5;
                i5 += (this.mAttributes[i6].size() * 12) + 2 + 4 + iArr2[i6];
            }
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(i5, this.mExifByteOrder));
            this.mThumbnailOffset = i + i5;
            i5 += this.mThumbnailLength;
        }
        int i7 = i5 + 8;
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(iArr[2], this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(iArr[3], this.mExifByteOrder));
        }
        byteOrderedDataOutputStream.writeUnsignedShort(i7);
        byteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
        byteOrderedDataOutputStream.writeShort(this.mExifByteOrder == ByteOrder.BIG_ENDIAN ? BYTE_ALIGN_MM : BYTE_ALIGN_II);
        byteOrderedDataOutputStream.setByteOrder(this.mExifByteOrder);
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8L);
        for (int i8 = 0; i8 < EXIF_TAGS.length; i8++) {
            if (!this.mAttributes[i8].isEmpty()) {
                byteOrderedDataOutputStream.writeUnsignedShort(this.mAttributes[i8].size());
                int size2 = (this.mAttributes[i8].size() * 12) + iArr[i8] + 2 + 4;
                for (Map.Entry<String, ExifAttribute> entry3 : this.mAttributes[i8].entrySet()) {
                    int i9 = sExifTagMapsForWriting[i8].get(entry3.getKey()).number;
                    ExifAttribute value = entry3.getValue();
                    int size3 = value.size();
                    byteOrderedDataOutputStream.writeUnsignedShort(i9);
                    byteOrderedDataOutputStream.writeUnsignedShort(value.format);
                    byteOrderedDataOutputStream.writeInt(value.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream.writeUnsignedInt(size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream.write(value.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                if (i8 != 0 || this.mAttributes[4].isEmpty()) {
                    byteOrderedDataOutputStream.writeUnsignedInt(0L);
                } else {
                    byteOrderedDataOutputStream.writeUnsignedInt(iArr[4]);
                }
                for (Map.Entry<String, ExifAttribute> entry4 : this.mAttributes[i8].entrySet()) {
                    byte[] bArr = entry4.getValue().bytes;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream.write(getThumbnailBytes());
        }
        byteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        return i7;
    }

    public void flipHorizontally() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 2;
                break;
            case 2:
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i));
    }

    public void flipVertically() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 4;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                break;
            case 5:
                i = 8;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i));
    }

    public double getAltitude(double d) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int i = -1;
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < RoundRectDrawableWithShadow.COS_45 || attributeInt < 0) {
            return d;
        }
        if (attributeInt != 1) {
            i = 1;
        }
        return attributeDouble * i;
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mExifByteOrder);
            }
            if (str.equals(TAG_GPS_TIMESTAMP)) {
                int i = exifAttribute.format;
                if (i != 5 && i != 10) {
                    return null;
                }
                Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr != null && rationalArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) rationalArr[0].numerator) / ((float) rationalArr[0].denominator))), Integer.valueOf((int) (((float) rationalArr[1].numerator) / ((float) rationalArr[1].denominator))), Integer.valueOf((int) (((float) rationalArr[2].numerator) / ((float) rationalArr[2].denominator))));
                }
                Arrays.toString(rationalArr);
                return null;
            }
            try {
                return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public double getAttributeDouble(@NonNull String str, double d) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute == null) {
            return d;
        }
        try {
            return exifAttribute.getDoubleValue(this.mExifByteOrder);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public int getAttributeInt(@NonNull String str, int i) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute == null) {
            return i;
        }
        try {
            return exifAttribute.getIntValue(this.mExifByteOrder);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getDateTime() {
        String attribute = getAttribute(TAG_DATETIME);
        if (attribute != null && sNonZeroTimePattern.matcher(attribute).matches()) {
            try {
                Date parse = sFormatter.parse(attribute, new ParsePosition(0));
                if (parse == null) {
                    return -1L;
                }
                long time = parse.getTime();
                String attribute2 = getAttribute(TAG_SUBSEC_TIME);
                if (attribute2 == null) {
                    return time;
                }
                try {
                    long parseLong = Long.parseLong(attribute2);
                    while (parseLong > 1000) {
                        parseLong /= 10;
                    }
                    return time + parseLong;
                } catch (NumberFormatException unused) {
                    return time;
                }
            } catch (IllegalArgumentException unused2) {
            }
        }
        return -1L;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getGpsDateTime() {
        String attribute = getAttribute(TAG_GPS_DATESTAMP);
        String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (attribute != null && attribute2 != null && (sNonZeroTimePattern.matcher(attribute).matches() || sNonZeroTimePattern.matcher(attribute2).matches())) {
            try {
                Date parse = sFormatter.parse(attribute + TokenParser.f4579SP + attribute2, new ParsePosition(0));
                if (parse != null) {
                    return parse.getTime();
                }
                return -1L;
            } catch (IllegalArgumentException unused) {
            }
        }
        return -1L;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    @Nullable
    public double[] getLatLong() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", attribute, attribute2, attribute3, attribute4);
            return null;
        }
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] getThumbnail() {
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
        }
        if (i == 1) {
            int length = this.mThumbnailBytes.length / 3;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                byte[] bArr = this.mThumbnailBytes;
                int i3 = i2 * 3;
                iArr[i2] = (bArr[i3] << 16) + 0 + (bArr[i3 + 1] << 8) + bArr[i3 + 2];
            }
            ExifAttribute exifAttribute = this.mAttributes[4].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = this.mAttributes[4].get(TAG_IMAGE_WIDTH);
            if (exifAttribute != null && exifAttribute2 != null) {
                return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    @Nullable
    public byte[] getThumbnailBytes() {
        Throwable th;
        InputStream inputStream;
        if (!this.mHasThumbnail) {
            return null;
        }
        byte[] bArr = this.mThumbnailBytes;
        if (bArr != null) {
            return bArr;
        }
        try {
            if (this.mAssetInputStream != null) {
                inputStream = this.mAssetInputStream;
                try {
                    if (!inputStream.markSupported()) {
                        closeQuietly(inputStream);
                        return null;
                    }
                    inputStream.reset();
                } catch (IOException unused) {
                    closeQuietly(inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(inputStream);
                    throw th;
                }
            } else {
                inputStream = this.mFilename != null ? new FileInputStream(this.mFilename) : null;
            }
            if (inputStream == null) {
                throw new FileNotFoundException();
            }
            if (inputStream.skip(this.mThumbnailOffset) != this.mThumbnailOffset) {
                throw new IOException("Corrupted image");
            }
            byte[] bArr2 = new byte[this.mThumbnailLength];
            if (inputStream.read(bArr2) != this.mThumbnailLength) {
                throw new IOException("Corrupted image");
            }
            this.mThumbnailBytes = bArr2;
            closeQuietly(inputStream);
            return bArr2;
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (!this.mHasThumbnail) {
            return null;
        }
        return new long[]{this.mThumbnailOffset, this.mThumbnailLength};
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
    }

    public boolean isThumbnailCompressed() {
        int i = this.mThumbnailCompression;
        return i == 6 || i == 7;
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int i) {
        int i2;
        List<Integer> list;
        if (i % 90 == 0) {
            int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
            int i3 = 0;
            if (!ROTATION_ORDER.contains(Integer.valueOf(attributeInt))) {
                if (FLIPPED_ROTATION_ORDER.contains(Integer.valueOf(attributeInt))) {
                    int indexOf = ((i / 90) + FLIPPED_ROTATION_ORDER.indexOf(Integer.valueOf(attributeInt))) % 4;
                    if (indexOf < 0) {
                        i3 = 4;
                    }
                    i2 = indexOf + i3;
                    list = FLIPPED_ROTATION_ORDER;
                }
                setAttribute(TAG_ORIENTATION, Integer.toString(i3));
                return;
            }
            int indexOf2 = ((i / 90) + ROTATION_ORDER.indexOf(Integer.valueOf(attributeInt))) % 4;
            if (indexOf2 < 0) {
                i3 = 4;
            }
            i2 = indexOf2 + i3;
            list = ROTATION_ORDER;
            i3 = list.get(i2).intValue();
            setAttribute(TAG_ORIENTATION, Integer.toString(i3));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    public void saveAttributes() throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (!this.mIsSupportedFile || this.mMimeType != 4) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
        }
        if (this.mFilename == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        }
        this.mThumbnailBytes = getThumbnail();
        File file = new File(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.mFilename, ".tmp"));
        if (!new File(this.mFilename).renameTo(file)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not rename to ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file.getAbsolutePath());
            throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(this.mFilename);
            } catch (Throwable th) {
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            saveJpegAttributes(fileInputStream, fileOutputStream);
            closeQuietly(fileInputStream);
            closeQuietly(fileOutputStream);
            file.delete();
            this.mThumbnailBytes = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            closeQuietly(fileInputStream2);
            closeQuietly(fileOutputStream);
            file.delete();
            throw th;
        }
    }

    public void setAltitude(double d) {
        String str = d >= RoundRectDrawableWithShadow.COS_45 ? "0" : "1";
        setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(d)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0249  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setAttribute(@NonNull String str, @Nullable String str2) {
        ExifTag exifTag;
        int i;
        int i2;
        HashMap<String, ExifAttribute> hashMap;
        ExifAttribute createByte;
        Matcher matcher;
        String str3 = str2;
        String str4 = TAG_ISO_SPEED_RATINGS.equals(str) ? TAG_PHOTOGRAPHIC_SENSITIVITY : str;
        int i3 = 2;
        int i4 = 1;
        if (str3 != null && sTagSetForCompatibility.contains(str4)) {
            if (str4.equals(TAG_GPS_TIMESTAMP)) {
                if (!sGpsTimestampPattern.matcher(str3).find()) {
                    return;
                }
                str3 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    str3 = new Rational(Double.parseDouble(str2)).toString();
                } catch (NumberFormatException unused) {
                    return;
                }
            }
        }
        char c = 0;
        int i5 = 0;
        while (i5 < EXIF_TAGS.length) {
            if ((i5 != 4 || this.mHasThumbnail) && (exifTag = sExifTagMapsForWriting[i5].get(str4)) != null) {
                if (str3 == null) {
                    this.mAttributes[i5].remove(str4);
                } else {
                    Pair<Integer, Integer> guessDataFormat = guessDataFormat(str3);
                    if (exifTag.primaryFormat != ((Integer) guessDataFormat.first).intValue() && exifTag.primaryFormat != ((Integer) guessDataFormat.second).intValue()) {
                        int i6 = exifTag.secondaryFormat;
                        if (i6 == -1 || !(i6 == ((Integer) guessDataFormat.first).intValue() || exifTag.secondaryFormat == ((Integer) guessDataFormat.second).intValue())) {
                            int i7 = exifTag.primaryFormat;
                            if (i7 != i4 && i7 != 7 && i7 != i3) {
                                String str5 = IFD_FORMAT_NAMES[i7];
                                if (exifTag.secondaryFormat != -1) {
                                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(", ");
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(IFD_FORMAT_NAMES[exifTag.secondaryFormat]);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                                }
                                String str6 = IFD_FORMAT_NAMES[((Integer) guessDataFormat.first).intValue()];
                                if (((Integer) guessDataFormat.second).intValue() != -1) {
                                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(", ");
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(IFD_FORMAT_NAMES[((Integer) guessDataFormat.second).intValue()]);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                                }
                            }
                        } else {
                            i = exifTag.secondaryFormat;
                            switch (i) {
                                case 1:
                                    i2 = i5;
                                    hashMap = this.mAttributes[i2];
                                    createByte = ExifAttribute.createByte(str3);
                                    hashMap.put(str4, createByte);
                                    break;
                                case 2:
                                case 7:
                                    i2 = i5;
                                    hashMap = this.mAttributes[i2];
                                    createByte = ExifAttribute.createString(str3);
                                    hashMap.put(str4, createByte);
                                    break;
                                case 3:
                                    i2 = i5;
                                    String[] split = str3.split(",", -1);
                                    int[] iArr = new int[split.length];
                                    for (int i8 = 0; i8 < split.length; i8++) {
                                        iArr[i8] = Integer.parseInt(split[i8]);
                                    }
                                    hashMap = this.mAttributes[i2];
                                    createByte = ExifAttribute.createUShort(iArr, this.mExifByteOrder);
                                    hashMap.put(str4, createByte);
                                    break;
                                case 4:
                                    i2 = i5;
                                    String[] split2 = str3.split(",", -1);
                                    long[] jArr = new long[split2.length];
                                    for (int i9 = 0; i9 < split2.length; i9++) {
                                        jArr[i9] = Long.parseLong(split2[i9]);
                                    }
                                    hashMap = this.mAttributes[i2];
                                    createByte = ExifAttribute.createULong(jArr, this.mExifByteOrder);
                                    hashMap.put(str4, createByte);
                                    break;
                                case 5:
                                    i2 = i5;
                                    String[] split3 = str3.split(",", -1);
                                    Rational[] rationalArr = new Rational[split3.length];
                                    for (int i10 = 0; i10 < split3.length; i10++) {
                                        String[] split4 = split3[i10].split("/", -1);
                                        rationalArr[i10] = new Rational((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                    }
                                    hashMap = this.mAttributes[i2];
                                    createByte = ExifAttribute.createURational(rationalArr, this.mExifByteOrder);
                                    hashMap.put(str4, createByte);
                                    break;
                                case 9:
                                    i2 = i5;
                                    String[] split5 = str3.split(",", -1);
                                    int[] iArr2 = new int[split5.length];
                                    for (int i11 = 0; i11 < split5.length; i11++) {
                                        iArr2[i11] = Integer.parseInt(split5[i11]);
                                    }
                                    hashMap = this.mAttributes[i2];
                                    createByte = ExifAttribute.createSLong(iArr2, this.mExifByteOrder);
                                    hashMap.put(str4, createByte);
                                    break;
                                case 10:
                                    String[] split6 = str3.split(",", -1);
                                    Rational[] rationalArr2 = new Rational[split6.length];
                                    int i12 = 0;
                                    while (i12 < split6.length) {
                                        String[] split7 = split6[i12].split("/", -1);
                                        rationalArr2[i12] = new Rational((long) Double.parseDouble(split7[c]), (long) Double.parseDouble(split7[i4]));
                                        i12++;
                                        i4 = 1;
                                        i5 = i5;
                                        c = 0;
                                    }
                                    i2 = i5;
                                    hashMap = this.mAttributes[i2];
                                    createByte = ExifAttribute.createSRational(rationalArr2, this.mExifByteOrder);
                                    hashMap.put(str4, createByte);
                                    break;
                                case 12:
                                    String[] split8 = str3.split(",", -1);
                                    double[] dArr = new double[split8.length];
                                    for (int i13 = 0; i13 < split8.length; i13++) {
                                        dArr[i13] = Double.parseDouble(split8[i13]);
                                    }
                                    this.mAttributes[i5].put(str4, ExifAttribute.createDouble(dArr, this.mExifByteOrder));
                                    break;
                            }
                            i5 = i2 + 1;
                            i3 = 2;
                            i4 = 1;
                            c = 0;
                        }
                    }
                    i = exifTag.primaryFormat;
                    switch (i) {
                    }
                    i5 = i2 + 1;
                    i3 = 2;
                    i4 = 1;
                    c = 0;
                }
            }
            i2 = i5;
            i5 = i2 + 1;
            i3 = 2;
            i4 = 1;
            c = 0;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDateTime(long j) {
        setAttribute(TAG_DATETIME, sFormatter.format(new Date(j)));
        setAttribute(TAG_SUBSEC_TIME, Long.toString(j % 1000));
    }

    public void setGpsInfo(Location location) {
        if (location == null) {
            return;
        }
        setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
        setLatLong(location.getLatitude(), location.getLongitude());
        setAltitude(location.getAltitude());
        setAttribute(TAG_GPS_SPEED_REF, "K");
        setAttribute(TAG_GPS_SPEED, new Rational((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1L))) / 1000.0f).toString());
        String[] split = sFormatter.format(new Date(location.getTime())).split("\\s+", -1);
        setAttribute(TAG_GPS_DATESTAMP, split[0]);
        setAttribute(TAG_GPS_TIMESTAMP, split[1]);
    }

    public void setLatLong(double d, double d2) {
        if (d < -90.0d || d > 90.0d || Double.isNaN(d)) {
            throw new IllegalArgumentException("Latitude value " + d + " is not valid.");
        } else if (d2 < -180.0d || d2 > 180.0d || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Longitude value " + d2 + " is not valid.");
        } else {
            setAttribute(TAG_GPS_LATITUDE_REF, d >= RoundRectDrawableWithShadow.COS_45 ? "N" : LATITUDE_SOUTH);
            setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(d)));
            setAttribute(TAG_GPS_LONGITUDE_REF, d2 >= RoundRectDrawableWithShadow.COS_45 ? LONGITUDE_EAST : LONGITUDE_WEST);
            setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(d2)));
        }
    }
}

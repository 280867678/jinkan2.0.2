package org.fourthline.cling.binding.xml;

import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.Device;
import org.seamless.util.Exceptions;
import org.seamless.xml.ParserException;
import org.seamless.xml.XmlPullParserUtils;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class RecoveringUDA10DeviceDescriptorBinderImpl extends UDA10DeviceDescriptorBinderImpl {
    public static Logger log = Logger.getLogger(RecoveringUDA10DeviceDescriptorBinderImpl.class.getName());

    private String fixGarbageLeadingChars(String str) {
        int indexOf = str.indexOf("<?xml");
        return indexOf == -1 ? str : str.substring(indexOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0087 A[Catch: ValidationException -> 0x000b, TRY_LEAVE, TryCatch #1 {ValidationException -> 0x000b, blocks: (B:53:0x0002, B:2:0x0006, B:7:0x000f, B:43:0x0033, B:9:0x0057, B:37:0x005d, B:14:0x0087, B:17:0x008d, B:22:0x0093, B:24:0x00b4, B:30:0x00be, B:26:0x00e2, B:34:0x00c4, B:41:0x0063, B:47:0x0039), top: B:52:0x0002, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderImpl, org.fourthline.cling.binding.xml.DeviceDescriptorBinder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <D extends Device> D describe(D d, String str) throws DescriptorBindingException, ValidationException {
        String fixGarbageTrailingChars;
        int i;
        String str2;
        DescriptorBindingException e;
        String fixXMLEntities;
        if (str != null) {
            try {
                try {
                    str = str.trim();
                } catch (DescriptorBindingException e2) {
                    Logger logger = log;
                    logger.warning("Regular parsing failed: " + Exceptions.unwrap(e2).getMessage());
                    String fixGarbageLeadingChars = fixGarbageLeadingChars(str);
                    if (fixGarbageLeadingChars != null) {
                        try {
                            return (D) super.describe((RecoveringUDA10DeviceDescriptorBinderImpl) d, fixGarbageLeadingChars);
                        } catch (DescriptorBindingException e3) {
                            Logger logger2 = log;
                            logger2.warning("Removing leading garbage didn't work: " + Exceptions.unwrap(e3).getMessage());
                            fixGarbageTrailingChars = fixGarbageTrailingChars(str, e2);
                            if (fixGarbageTrailingChars != null) {
                            }
                            str2 = str;
                            e = e2;
                            for (i = 0; i < 5; i++) {
                                try {
                                    return (D) super.describe((RecoveringUDA10DeviceDescriptorBinderImpl) d, str2);
                                } catch (DescriptorBindingException e4) {
                                    e = e4;
                                    Logger logger3 = log;
                                    logger3.warning("Fixing namespace prefix didn't work: " + Exceptions.unwrap(e).getMessage());
                                }
                            }
                            fixXMLEntities = XmlPullParserUtils.fixXMLEntities(str);
                            if (!fixXMLEntities.equals(str)) {
                            }
                            handleInvalidDescriptor(str, e2);
                            throw new IllegalStateException("No device produced, did you swallow exceptions in your subclass?");
                        }
                    }
                    fixGarbageTrailingChars = fixGarbageTrailingChars(str, e2);
                    if (fixGarbageTrailingChars != null) {
                        try {
                            return (D) super.describe((RecoveringUDA10DeviceDescriptorBinderImpl) d, fixGarbageTrailingChars);
                        } catch (DescriptorBindingException e5) {
                            Logger logger4 = log;
                            logger4.warning("Removing trailing garbage didn't work: " + Exceptions.unwrap(e5).getMessage());
                            str2 = str;
                            e = e2;
                            while (i < 5) {
                            }
                            fixXMLEntities = XmlPullParserUtils.fixXMLEntities(str);
                            if (!fixXMLEntities.equals(str)) {
                            }
                            handleInvalidDescriptor(str, e2);
                            throw new IllegalStateException("No device produced, did you swallow exceptions in your subclass?");
                        }
                    }
                    str2 = str;
                    e = e2;
                    while (i < 5 && (str2 = fixMissingNamespaces(str2, e)) != null) {
                        return (D) super.describe((RecoveringUDA10DeviceDescriptorBinderImpl) d, str2);
                    }
                    fixXMLEntities = XmlPullParserUtils.fixXMLEntities(str);
                    if (!fixXMLEntities.equals(str)) {
                        try {
                            return (D) super.describe((RecoveringUDA10DeviceDescriptorBinderImpl) d, fixXMLEntities);
                        } catch (DescriptorBindingException e6) {
                            Logger logger5 = log;
                            logger5.warning("Fixing XML entities didn't work: " + Exceptions.unwrap(e6).getMessage());
                            handleInvalidDescriptor(str, e2);
                            throw new IllegalStateException("No device produced, did you swallow exceptions in your subclass?");
                        }
                    }
                    handleInvalidDescriptor(str, e2);
                    throw new IllegalStateException("No device produced, did you swallow exceptions in your subclass?");
                }
            } catch (ValidationException e7) {
                D d2 = (D) handleInvalidDevice(str, null, e7);
                if (d2 != null) {
                    return d2;
                }
                throw new IllegalStateException("No device produced, did you swallow exceptions in your subclass?");
            }
        }
        return (D) super.describe((RecoveringUDA10DeviceDescriptorBinderImpl) d, str);
    }

    public String fixGarbageTrailingChars(String str, DescriptorBindingException descriptorBindingException) {
        int indexOf = str.indexOf("</root>");
        if (indexOf == -1) {
            log.warning("No closing </root> element in descriptor");
            return null;
        } else if (str.length() == indexOf + 7) {
            return null;
        } else {
            log.warning("Detected garbage characters after <root> node, removing");
            return str.substring(0, indexOf) + "</root>";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0040, code lost:
        if (r0.groupCount() == 1) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String fixMissingNamespaces(String str, DescriptorBindingException descriptorBindingException) {
        String message;
        Logger logger;
        String str2;
        Throwable cause = descriptorBindingException.getCause();
        if (((cause instanceof SAXParseException) || (cause instanceof ParserException)) && (message = cause.getMessage()) != null) {
            Matcher matcher = Pattern.compile("The prefix \"(.*)\" for element").matcher(message);
            if (!matcher.find() || matcher.groupCount() != 1) {
                matcher = Pattern.compile("undefined prefix: ([^ ]*)").matcher(message);
                if (matcher.find()) {
                }
                return null;
            }
            String group = matcher.group(1);
            Logger logger2 = log;
            logger2.warning("Fixing missing namespace declaration for: " + group);
            Matcher matcher2 = Pattern.compile("<root([^>]*)").matcher(str);
            if (!matcher2.find() || matcher2.groupCount() != 1) {
                logger = log;
                str2 = "Could not find <root> element attributes";
            } else {
                String group2 = matcher2.group(1);
                Logger logger3 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Preserving existing <root> element attributes/namespace declarations: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(matcher2.group(0));
                logger3.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                Matcher matcher3 = Pattern.compile("<root[^>]*>(.*)</root>", 32).matcher(str);
                if (matcher3.find() && matcher3.groupCount() == 1) {
                    String group3 = matcher3.group(1);
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<?xml version=\"1.0\" encoding=\"UTF-8\" ?><root ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(String.format(Locale.ROOT, "xmlns:%s=\"urn:schemas-dlna-org:device-1-0\"", group));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(group2);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(">");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(group3);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("</root>");
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                }
                logger = log;
                str2 = "Could not extract body of <root> element";
            }
            logger.fine(str2);
            return null;
        }
        return null;
    }

    public void handleInvalidDescriptor(String str, DescriptorBindingException descriptorBindingException) throws DescriptorBindingException {
        throw descriptorBindingException;
    }

    public <D extends Device> D handleInvalidDevice(String str, D d, ValidationException validationException) throws ValidationException {
        throw validationException;
    }
}

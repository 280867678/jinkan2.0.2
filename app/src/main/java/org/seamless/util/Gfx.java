package org.seamless.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;

/* loaded from: classes5.dex */
public class Gfx {
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0044 -> B:6:0x0013). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0046 -> B:6:0x0013). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.awt.image.BufferedImage getScaledInstance(java.awt.image.BufferedImage r11, int r12, int r13, java.lang.Object r14, boolean r15) {
        /*
            int r0 = r11.getTransparency()
            r1 = 1
            if (r0 != r1) goto L8
            goto L9
        L8:
            r1 = 2
        L9:
            if (r15 == 0) goto L15
            int r0 = r11.getWidth()
            int r2 = r11.getHeight()
        L13:
            r4 = r11
            goto L18
        L15:
            r4 = r11
            r0 = r12
            r2 = r13
        L18:
            if (r15 == 0) goto L21
            if (r0 <= r12) goto L21
            int r0 = r0 / 2
            if (r0 >= r12) goto L21
            r0 = r12
        L21:
            if (r15 == 0) goto L2a
            if (r2 <= r13) goto L2a
            int r2 = r2 / 2
            if (r2 >= r13) goto L2a
            r2 = r13
        L2a:
            java.awt.image.BufferedImage r11 = new java.awt.image.BufferedImage
            r11.<init>(r0, r2, r1)
            java.awt.Graphics2D r10 = r11.createGraphics()
            java.awt.RenderingHints$Key r3 = java.awt.RenderingHints.KEY_INTERPOLATION
            r10.setRenderingHint(r3, r14)
            r5 = 0
            r6 = 0
            r9 = 0
            r3 = r10
            r7 = r0
            r8 = r2
            r3.drawImage(r4, r5, r6, r7, r8, r9)
            r10.dispose()
            if (r0 != r12) goto L13
            if (r2 != r13) goto L13
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.seamless.util.Gfx.getScaledInstance(java.awt.image.BufferedImage, int, int, java.lang.Object, boolean):java.awt.image.BufferedImage");
    }

    public static byte[] resizeProportionally(ImageIcon imageIcon, String str, int i, int i2) throws IOException {
        double d = 1.0d;
        double iconWidth = i != imageIcon.getIconWidth() ? i / imageIcon.getIconWidth() : 1.0d;
        if (i2 != imageIcon.getIconHeight()) {
            d = i2 / imageIcon.getIconHeight();
        }
        if (iconWidth < d) {
            i2 = (int) (imageIcon.getIconHeight() * iconWidth);
        } else {
            i = (int) (imageIcon.getIconWidth() * d);
        }
        BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_PNG.equals(str) ? 2 : 1);
        Graphics2D createGraphics = bufferedImage.createGraphics();
        createGraphics.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight(), (ImageObserver) null);
        createGraphics.dispose();
        BufferedImage scaledInstance = getScaledInstance(bufferedImage, i, i2, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR, false);
        String str2 = DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_PNG.equals(str) ? "png" : (DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_JPEG.equals(str) || "image/jpg".equals(str)) ? "jpeg" : "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        ImageIO.write(scaledInstance, str2, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}

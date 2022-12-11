package org.jsoup.nodes;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;

/* loaded from: classes5.dex */
public class DocumentType extends LeafNode {
    public static final String NAME = "name";
    public static final String PUBLIC_ID = "publicId";
    public static final String PUBLIC_KEY = "PUBLIC";
    public static final String PUB_SYS_KEY = "pubSysKey";
    public static final String SYSTEM_ID = "systemId";
    public static final String SYSTEM_KEY = "SYSTEM";

    public DocumentType(String str, String str2, String str3) {
        Validate.notNull(str);
        Validate.notNull(str2);
        Validate.notNull(str3);
        mo5251attr("name", str);
        mo5251attr(PUBLIC_ID, str2);
        mo5251attr(SYSTEM_ID, str3);
        updatePubSyskey();
    }

    private boolean has(String str) {
        return !StringUtil.isBlank(attr(str));
    }

    private void updatePubSyskey() {
        String str;
        if (has(PUBLIC_ID)) {
            str = PUBLIC_KEY;
        } else if (!has(SYSTEM_ID)) {
            return;
        } else {
            str = SYSTEM_KEY;
        }
        mo5251attr(PUB_SYS_KEY, str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    /* renamed from: attr */
    public /* bridge */ /* synthetic */ Node mo5251attr(String str, String str2) {
        return super.mo5251attr(str, str2);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String baseUri() {
        return super.baseUri();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ int childNodeSize() {
        return super.childNodeSize();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    /* renamed from: empty */
    public /* bridge */ /* synthetic */ Node mo5257empty() {
        return super.mo5257empty();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public String name() {
        return attr("name");
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#doctype";
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        appendable.append((outputSettings.syntax() != Document.OutputSettings.Syntax.html || has(PUBLIC_ID) || has(SYSTEM_ID)) ? "<!DOCTYPE" : "<!doctype");
        if (has("name")) {
            appendable.append(StringUtils.SPACE).append(attr("name"));
        }
        if (has(PUB_SYS_KEY)) {
            appendable.append(StringUtils.SPACE).append(attr(PUB_SYS_KEY));
        }
        if (has(PUBLIC_ID)) {
            appendable.append(" \"").append(attr(PUBLIC_ID)).append('\"');
        }
        if (has(SYSTEM_ID)) {
            appendable.append(" \"").append(attr(SYSTEM_ID)).append('\"');
        }
        appendable.append('>');
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    public String publicId() {
        return attr(PUBLIC_ID);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    /* renamed from: removeAttr */
    public /* bridge */ /* synthetic */ Node mo5260removeAttr(String str) {
        return super.mo5260removeAttr(str);
    }

    public void setPubSysKey(String str) {
        if (str != null) {
            mo5251attr(PUB_SYS_KEY, str);
        }
    }

    public String systemId() {
        return attr(SYSTEM_ID);
    }
}

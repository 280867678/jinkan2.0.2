package org.jsoup.parser;

import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.net.MailTo;
import com.umeng.analytics.pro.C1543ak;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;

/* loaded from: classes5.dex */
public class Tag implements Cloneable {
    public static final String[] blockTags;
    public String normalName;
    public String tagName;
    public static final Map<String, Tag> tags = new HashMap();
    public static final String[] inlineTags = {"object", "base", "font", "tt", C1543ak.f2966aC, "b", C1543ak.f2970aG, "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", NotificationCompatJellybean.KEY_LABEL, "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", C1543ak.f2965aB};
    public static final String[] emptyTags = {"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
    public static final String[] formatAsInlineTags = {NotificationCompatJellybean.KEY_TITLE, "a", C1543ak.f3013ax, "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", C1543ak.f2965aB};
    public static final String[] preserveWhitespaceTags = {"pre", "plaintext", NotificationCompatJellybean.KEY_TITLE, "textarea"};
    public static final String[] formListedTags = {"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
    public static final String[] formSubmitTags = {"input", "keygen", "object", "select", "textarea"};
    public boolean isBlock = true;
    public boolean formatAsBlock = true;
    public boolean empty = false;
    public boolean selfClosing = false;
    public boolean preserveWhitespace = false;
    public boolean formList = false;
    public boolean formSubmit = false;

    static {
        String[] strArr = {"html", "head", MailTo.BODY, "frameset", "script", "noscript", "style", "meta", "link", NotificationCompatJellybean.KEY_TITLE, "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", C1543ak.f3013ax, "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", SupportMenuInflater.XML_MENU, "plaintext", "template", "article", "main", "svg", "math", "center"};
        blockTags = strArr;
        for (String str : strArr) {
            register(new Tag(str));
        }
        for (String str2 : inlineTags) {
            Tag tag = new Tag(str2);
            tag.isBlock = false;
            tag.formatAsBlock = false;
            register(tag);
        }
        for (String str3 : emptyTags) {
            Tag tag2 = tags.get(str3);
            Validate.notNull(tag2);
            tag2.empty = true;
        }
        for (String str4 : formatAsInlineTags) {
            Tag tag3 = tags.get(str4);
            Validate.notNull(tag3);
            tag3.formatAsBlock = false;
        }
        for (String str5 : preserveWhitespaceTags) {
            Tag tag4 = tags.get(str5);
            Validate.notNull(tag4);
            tag4.preserveWhitespace = true;
        }
        for (String str6 : formListedTags) {
            Tag tag5 = tags.get(str6);
            Validate.notNull(tag5);
            tag5.formList = true;
        }
        for (String str7 : formSubmitTags) {
            Tag tag6 = tags.get(str7);
            Validate.notNull(tag6);
            tag6.formSubmit = true;
        }
    }

    public Tag(String str) {
        this.tagName = str;
        this.normalName = Normalizer.lowerCase(str);
    }

    public static boolean isKnownTag(String str) {
        return tags.containsKey(str);
    }

    public static void register(Tag tag) {
        tags.put(tag.tagName, tag);
    }

    public static Tag valueOf(String str) {
        return valueOf(str, ParseSettings.preserveCase);
    }

    public static Tag valueOf(String str, ParseSettings parseSettings) {
        Validate.notNull(str);
        Tag tag = tags.get(str);
        if (tag == null) {
            String normalizeTag = parseSettings.normalizeTag(str);
            Validate.notEmpty(normalizeTag);
            String lowerCase = Normalizer.lowerCase(normalizeTag);
            Tag tag2 = tags.get(lowerCase);
            if (tag2 == null) {
                Tag tag3 = new Tag(normalizeTag);
                tag3.isBlock = false;
                return tag3;
            } else if (!parseSettings.preserveTagCase() || normalizeTag.equals(lowerCase)) {
                return tag2;
            } else {
                Tag clone = tag2.clone();
                clone.tagName = normalizeTag;
                return clone;
            }
        }
        return tag;
    }

    public Tag clone() {
        try {
            return (Tag) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        return this.tagName.equals(tag.tagName) && this.empty == tag.empty && this.formatAsBlock == tag.formatAsBlock && this.isBlock == tag.isBlock && this.preserveWhitespace == tag.preserveWhitespace && this.selfClosing == tag.selfClosing && this.formList == tag.formList && this.formSubmit == tag.formSubmit;
    }

    public boolean formatAsBlock() {
        return this.formatAsBlock;
    }

    public String getName() {
        return this.tagName;
    }

    public int hashCode() {
        return (((((((((((((this.tagName.hashCode() * 31) + (this.isBlock ? 1 : 0)) * 31) + (this.formatAsBlock ? 1 : 0)) * 31) + (this.empty ? 1 : 0)) * 31) + (this.selfClosing ? 1 : 0)) * 31) + (this.preserveWhitespace ? 1 : 0)) * 31) + (this.formList ? 1 : 0)) * 31) + (this.formSubmit ? 1 : 0);
    }

    public boolean isBlock() {
        return this.isBlock;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isFormListed() {
        return this.formList;
    }

    public boolean isFormSubmittable() {
        return this.formSubmit;
    }

    public boolean isInline() {
        return !this.isBlock;
    }

    public boolean isKnownTag() {
        return tags.containsKey(this.tagName);
    }

    public boolean isSelfClosing() {
        return this.empty || this.selfClosing;
    }

    public String normalName() {
        return this.normalName;
    }

    public boolean preserveWhitespace() {
        return this.preserveWhitespace;
    }

    public Tag setSelfClosing() {
        this.selfClosing = true;
        return this;
    }

    public String toString() {
        return this.tagName;
    }
}

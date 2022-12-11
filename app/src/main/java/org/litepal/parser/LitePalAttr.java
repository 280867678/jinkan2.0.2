package org.litepal.parser;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;
import org.litepal.exceptions.InvalidAttributesException;
import org.litepal.util.BaseUtility;
import org.litepal.util.Const;
import org.litepal.util.SharedUtil;

/* loaded from: classes5.dex */
public final class LitePalAttr {
    public static LitePalAttr litePalAttr;
    public String cases;
    public List<String> classNames;
    public String dbName;
    public String extraKeyName;
    public String storage;
    public int version;

    public static void clearInstance() {
        litePalAttr = null;
    }

    public static LitePalAttr getInstance() {
        if (litePalAttr == null) {
            synchronized (LitePalAttr.class) {
                if (litePalAttr == null) {
                    litePalAttr = new LitePalAttr();
                    loadLitePalXMLConfiguration();
                }
            }
        }
        return litePalAttr;
    }

    public static void loadLitePalXMLConfiguration() {
        if (BaseUtility.isLitePalXMLExists()) {
            LitePalConfig parseLitePalConfiguration = LitePalParser.parseLitePalConfiguration();
            litePalAttr.setDbName(parseLitePalConfiguration.getDbName());
            litePalAttr.setVersion(parseLitePalConfiguration.getVersion());
            litePalAttr.setClassNames(parseLitePalConfiguration.getClassNames());
            litePalAttr.setCases(parseLitePalConfiguration.getCases());
            litePalAttr.setStorage(parseLitePalConfiguration.getStorage());
        }
    }

    public void addClassName(String str) {
        getClassNames().add(str);
    }

    public void checkSelfValid() {
        if (TextUtils.isEmpty(this.dbName)) {
            loadLitePalXMLConfiguration();
            if (TextUtils.isEmpty(this.dbName)) {
                throw new InvalidAttributesException(InvalidAttributesException.DBNAME_IS_EMPTY_OR_NOT_DEFINED);
            }
        }
        if (!this.dbName.endsWith(".db")) {
            this.dbName = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.dbName, ".db");
        }
        int i = this.version;
        if (i >= 1) {
            if (i < SharedUtil.getLastVersion(this.extraKeyName)) {
                throw new InvalidAttributesException(InvalidAttributesException.VERSION_IS_EARLIER_THAN_CURRENT);
            }
            if (TextUtils.isEmpty(this.cases)) {
                this.cases = Const.Config.CASES_LOWER;
                return;
            } else if (!this.cases.equals(Const.Config.CASES_UPPER) && !this.cases.equals(Const.Config.CASES_LOWER) && !this.cases.equals(Const.Config.CASES_KEEP)) {
                throw new InvalidAttributesException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.cases, InvalidAttributesException.CASES_VALUE_IS_INVALID));
            } else {
                return;
            }
        }
        throw new InvalidAttributesException(InvalidAttributesException.VERSION_OF_DATABASE_LESS_THAN_ONE);
    }

    public String getCases() {
        return this.cases;
    }

    public List<String> getClassNames() {
        List list;
        List<String> list2 = this.classNames;
        if (list2 != null) {
            if (list2.isEmpty()) {
                list = this.classNames;
            }
            return this.classNames;
        }
        list = new ArrayList();
        this.classNames = list;
        list.add("org.litepal.model.Table_Schema");
        return this.classNames;
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getExtraKeyName() {
        return this.extraKeyName;
    }

    public String getStorage() {
        return this.storage;
    }

    public int getVersion() {
        return this.version;
    }

    public void setCases(String str) {
        this.cases = str;
    }

    public void setClassNames(List<String> list) {
        this.classNames = list;
    }

    public void setDbName(String str) {
        this.dbName = str;
    }

    public void setExtraKeyName(String str) {
        this.extraKeyName = str;
    }

    public void setStorage(String str) {
        this.storage = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}

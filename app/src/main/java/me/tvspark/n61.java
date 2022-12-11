package me.tvspark;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import me.tvspark.g61;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.exception.NoSuchAxisException;
import org.seimicrawler.xpath.exception.NoSuchFunctionException;
import org.seimicrawler.xpath.exception.XpathMergeValueException;
import org.seimicrawler.xpath.exception.XpathParserException;
import org.slf4j.Marker;

/* loaded from: classes4.dex */
public class n61 extends d61<m61> {
    public l61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Stack<l61> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Stack<>();

    public n61(Elements elements) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new l61(elements);
        Stack<l61> stack = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        l61 l61Var = new l61(elements);
        l61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        stack.push(l61Var);
    }

    public final l61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.peek();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Elements elements) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.peek().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = elements;
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if ("..".equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getText())) {
            HashSet hashSet = new HashSet();
            Elements elements = new Elements();
            Iterator<Element> it = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().mo5259parent());
            }
            elements.addAll(hashSet);
            return new m61(elements);
        }
        return new m61(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (Objects.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getText(), "//")) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) ((g61.Wwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwww.class, 0)));
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwww.class);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() == 1) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0));
        }
        Double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        String str = null;
        for (int i = 1; i < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getChildCount(); i++) {
            f11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof g61.Wwwwwwwwwwwwwwwwwwwwww) {
                m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                if (Marker.ANY_NON_NULL_MARKER.equals(str)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue() + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue());
                } else if (!"-".equals(str)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getText());
                    throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue() - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue());
                }
            } else {
                str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getText();
            }
        }
        return new m61(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.class);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() > 1) {
            Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            for (int i = 1; i < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Boolean.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.booleanValue() & Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().booleanValue());
            }
            return new m61(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0));
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7, 0) != null) {
            String text = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7, 0).getText();
            i61 i61Var = z71.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(text);
            if (i61Var != null) {
                return i61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            throw new NoSuchAxisException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("not support axis: ", text));
        } else if (!"@".equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getText())) {
            return null;
        } else {
            m61 m61Var = new m61(null);
            m61Var.Wwwwwwwwwwwwwwwwwwwwwww = true;
            return m61Var;
        }
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        m61 m61Var;
        List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwww.class);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() == 1) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0));
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() != 2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("error equalityExpr near:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(wwwwwwwwwwwwwwwwwwwwwwwwwwwww.getText());
            throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0));
        m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(1));
        if ("=".equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getText())) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                m61Var = new m61(Boolean.valueOf(Objects.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4)));
            } else {
                m61Var = new m61(Boolean.valueOf(Objects.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())));
            }
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            m61Var = new m61(Boolean.valueOf(!Objects.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4)));
        } else {
            m61Var = new m61(Boolean.valueOf(!Objects.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())));
        }
        return m61Var;
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) ((g61.Wwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwww.class, 0)));
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) ((g61.Wwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwww.class, 0)));
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww) {
        LinkedList linkedList = new LinkedList();
        m61 m61Var = (m61) ((g61.Wwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwww.class, 0)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        for (g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.class)) {
            Stack<l61> stack = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            l61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            l61 l61Var = new l61(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            l61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            stack.push(l61Var);
            linkedList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.pop();
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        j61 j61Var = z71.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (j61Var != null) {
            return j61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), linkedList);
        }
        throw new NoSuchFunctionException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("not support function: ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwww) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) ((g61.Wwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwww.class, 0)));
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null || wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) ? (g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class, 0) : wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwww) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) ((g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.class, 0)));
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwww) {
        if (wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null && !wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) ((g61.Wwwwwwwwww) wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwww.class, 0)));
            m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            switch (wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getType()) {
                case 17:
                    return new m61(Double.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue() * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue()));
                case 18:
                    return new m61(Double.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue() / Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue()));
                case 19:
                    return new m61(Double.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue() % Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue()));
                default:
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(wwwwwwwwwwwwwwwwwwwwww.getText());
                    throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) ((g61.Wwwwwwwwww) wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwww.class, 0)));
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwww) {
        m61 m61Var;
        if (wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7, 0) != null) {
            m61Var = new m61(wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7, 0).getText());
        } else {
            m61Var = new m61(wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(41, 0).getText());
        }
        m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return m61Var;
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwww) {
        f11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if ("*".equals(wwwwwwwwwwwwwwwwwwww.getText())) {
            m61 m61Var = new m61("*");
            m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return m61Var;
        }
        if (wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null && !wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null || wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return null;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwww) {
        if (((g61.Wwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwww.class, 0)) != null) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) ((g61.Wwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwww.class, 0)));
        }
        if (wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5, 0) == null) {
            return null;
        }
        return z71.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5, 0).getText()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwww) {
        List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() > 1) {
            Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            for (int i = 1; i < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Boolean.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.booleanValue() | Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().booleanValue());
            }
            return new m61(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0));
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwww) {
        f11 f11Var;
        if (wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null || wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            ey0 ey0Var = wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (ey0Var == null) {
                f11Var = (g61.Wwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwww.class, 0);
            } else {
                if ("//".equals(ey0Var.getText())) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                }
                f11Var = (g61.Wwwwwwwwwwww) wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwww.class, 0);
            }
        } else {
            f11Var = wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f11Var);
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwww wwwwwwwwwwwwwwww) {
        Elements elements = new Elements();
        Iterator<Element> it = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            Stack<l61> stack = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            l61 l61Var = new l61(next);
            l61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            stack.push(l61Var);
            m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) ((g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.class, 0)));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.pop();
            Object obj = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (obj instanceof Number) {
                long longValue = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().longValue();
                if (longValue < 0) {
                    l61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Elements elements2 = new Elements();
                    Iterator<Element> it2 = next.mo5259parent().getElementsByTag(next.tagName()).iterator();
                    while (it2.hasNext()) {
                        Element next2 = it2.next();
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(next2)) {
                            elements2.add(next2);
                        }
                    }
                    longValue = 1 + elements2.size() + longValue;
                }
                if (longValue == r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                    elements.add(next);
                }
            } else if (obj instanceof Boolean) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().booleanValue()) {
                    elements.add(next);
                }
            } else if (obj instanceof String) {
                if (StringUtils.isNotBlank(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                    elements.add(next);
                }
            } else if (obj instanceof Elements) {
                if (((Elements) obj).size() > 0) {
                    elements.add(next);
                }
            } else if (!(obj instanceof List)) {
                throw new XpathParserException("unknown expr val:" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (((List) obj).size() > 0) {
                elements.add(next);
            }
        }
        return new m61(elements);
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwww wwwwwwwwwwwwwww) {
        m61 m61Var;
        f11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null && !wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null || wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            if (wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(39, 0) != null) {
                m61Var = new m61(wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(39, 0).getText());
                m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else if (wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6, 0) != null) {
                m61Var = new m61(NumberUtils.createDouble(wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6, 0).getText()));
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("not support variableReference:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(wwwwwwwwwwwwwww.getText());
                throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            return m61Var;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwww wwwwwwwwwwwwww) {
        List<g61.Wwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwww.class);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() > 1) {
                LinkedList linkedList = new LinkedList();
                for (g61.Wwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) wwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                        linkedList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    }
                }
                return new m61(StringUtils.join(linkedList, ":"));
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0));
        }
        return null;
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwww wwwwwwwwwwwww) {
        m61 m61Var;
        List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class);
        boolean z = false;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() == 1) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0));
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() == 2) {
            m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0));
            m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(1));
            switch (wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getType()) {
                case 24:
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) < 0) {
                        z = true;
                    }
                    m61Var = new m61(Boolean.valueOf(z));
                    break;
                case 25:
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) > 0) {
                        z = true;
                    }
                    m61Var = new m61(Boolean.valueOf(z));
                    break;
                case 26:
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) <= 0) {
                        z = true;
                    }
                    m61Var = new m61(Boolean.valueOf(z));
                    break;
                case 27:
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) >= 0) {
                        z = true;
                    }
                    m61Var = new m61(Boolean.valueOf(z));
                    break;
                case 28:
                case 29:
                default:
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unknown operator");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getText());
                    throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                case 30:
                    m61Var = new m61(Boolean.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww().startsWith(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())));
                    break;
                case 31:
                    m61Var = new m61(Boolean.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww().endsWith(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())));
                    break;
                case 32:
                    m61Var = new m61(Boolean.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww().contains(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())));
                    break;
                case 33:
                    m61Var = new m61(Boolean.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww().matches(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())));
                    break;
                case 34:
                    m61Var = new m61(Boolean.valueOf(!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww().matches(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())));
                    break;
            }
            return m61Var;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("error equalityExpr near:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(wwwwwwwwwwwww.getText());
        throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwwww wwwwwwwwwwww) {
        m61 m61Var = null;
        for (int i = 0; i < wwwwwwwwwwww.getChildCount(); i++) {
            f11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof g61.Wwwwwwwwwww) {
                m61Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Object obj = m61Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (obj instanceof Elements) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Elements) obj);
                }
            } else if ("//".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getText())) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            }
        }
        return m61Var;
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwwww wwwwwwwwwww) {
        boolean z;
        m61 m61Var;
        m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null || wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            boolean z2 = false;
            if (wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null || wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) == null) {
                z = false;
            } else {
                Object obj = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (obj instanceof Elements) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Elements) obj);
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww) {
                    z = true;
                    z2 = true;
                }
                z = true;
            }
            if (wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null && !wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                if (z2) {
                    Elements elements = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if (elements.size() == 1) {
                            Element Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            Elements select = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.select("[" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww + "]");
                            LinkedList linkedList = new LinkedList();
                            Iterator<Element> it = select.iterator();
                            while (it.hasNext()) {
                                linkedList.add(it.next().attr(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                            }
                            return new m61(linkedList);
                        }
                        Elements elements2 = new Elements();
                        Iterator<Element> it2 = elements.iterator();
                        while (it2.hasNext()) {
                            elements2.addAll(it2.next().select("[" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww + "]"));
                        }
                        LinkedList linkedList2 = new LinkedList();
                        Iterator<Element> it3 = elements2.iterator();
                        while (it3.hasNext()) {
                            linkedList2.add(it3.next().attr(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                        m61Var = new m61(linkedList2);
                    } else if (elements.size() == 1) {
                        m61Var = new m61(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().attr(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    } else {
                        LinkedList linkedList3 = new LinkedList();
                        Iterator<Element> it4 = elements.iterator();
                        while (it4.hasNext()) {
                            linkedList3.add(it4.next().attr(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                        return new m61(linkedList3);
                    }
                    return m61Var;
                } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                } else {
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Elements elements3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(elements3.select(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
                    } else {
                        Elements elements4 = new Elements();
                        Iterator<Element> it5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
                        while (it5.hasNext()) {
                            Element next = it5.next();
                            if (!z) {
                                Iterator<Element> it6 = next.children().iterator();
                                while (it6.hasNext()) {
                                    Element next2 = it6.next();
                                    if (next2.nodeName().equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) || "*".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                                        elements4.add(next2);
                                    }
                                }
                            } else if (next.nodeName().equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) || "*".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                                elements4.add(next);
                            }
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.peek().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = elements4;
                    }
                }
            }
            if (wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww() != null && wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().size() > 0) {
                for (g61.Wwwwwwwwwwwwwwww wwwwwwwwwwwwwwww : wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Elements) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) wwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
            m61Var = new m61(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return m61Var;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwwww wwwwwwwwww) {
        m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f11) ((g61.Wwwwwwwww) wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwww.class, 0)));
        return wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : new m61(Double.valueOf(-Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue()));
    }

    @Override // me.tvspark.h61
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwww wwwwwwwww) {
        m61 m61Var;
        Element element;
        if (wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null && !wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return (m61) ((g61.Wwwwwwwww) wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwww.class, 0)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
        m61 m61Var2 = (m61) wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        if (wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Stack<l61> stack = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            l61 l61Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            l61 l61Var2 = new l61(l61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            l61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = l61Var;
            stack.push(l61Var2);
            m61 m61Var3 = (m61) ((g61.Wwwwwwwww) wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g61.Wwwwwwwww.class, 0)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.pop();
            Object obj = m61Var2.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (!(obj instanceof Elements)) {
                if (obj instanceof String) {
                    if (m61Var3.Wwwwwwwwwwwwwwwwwwwwwwww instanceof Elements) {
                        element = new Element(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                        element.appendText(m61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        ((Elements) m61Var3.Wwwwwwwwwwwwwwwwwwwwwwww).add(element);
                        return m61Var3;
                    }
                    m61Var = new m61(m61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + m61Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    return m61Var;
                } else if (obj instanceof Boolean) {
                    Object obj2 = m61Var3.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (obj2 instanceof Boolean) {
                        m61Var = new m61(Boolean.valueOf(m61Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().booleanValue() | m61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().booleanValue()));
                    } else if (obj2 instanceof Elements) {
                        element = new Element(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                        element.appendText(m61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        ((Elements) m61Var3.Wwwwwwwwwwwwwwwwwwwwwwww).add(element);
                        return m61Var3;
                    } else if (obj2 instanceof String) {
                        m61Var = new m61(m61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + m61Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    } else {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not merge val1=");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(m61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",val2=");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(m61Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        throw new XpathMergeValueException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    }
                    return m61Var;
                } else {
                    if (obj instanceof Number) {
                        Object obj3 = m61Var3.Wwwwwwwwwwwwwwwwwwwwwwww;
                        if (obj3 instanceof String) {
                            m61Var = new m61(m61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + m61Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        } else if (obj3 instanceof Elements) {
                            element = new Element(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                            element.appendText(m61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                            ((Elements) m61Var3.Wwwwwwwwwwwwwwwwwwwwwwww).add(element);
                            return m61Var3;
                        } else {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not merge val1=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(m61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(",val2=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(m61Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                            throw new XpathMergeValueException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                        }
                    } else {
                        LinkedList linkedList = new LinkedList();
                        if (StringUtils.isNotBlank(m61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                            linkedList.add(m61Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        }
                        if (StringUtils.isNotBlank(m61Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                            linkedList.add(m61Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        }
                        m61Var = new m61(StringUtils.join(linkedList, ","));
                    }
                    return m61Var;
                }
            }
            Object obj4 = m61Var3.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (obj4 instanceof Elements) {
                ((Elements) obj).addAll((Elements) obj4);
            } else {
                Element element2 = new Element(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                element2.appendText(m61Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                ((Elements) m61Var2.Wwwwwwwwwwwwwwwwwwwwwwww).add(element2);
            }
        }
        return m61Var2;
    }
}

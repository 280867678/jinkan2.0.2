package org.jsoup.select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.TokenParser;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.parser.TokenQueue;
import org.jsoup.select.CombiningEvaluator;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Selector;
import org.jsoup.select.StructuralEvaluator;
import org.slf4j.Marker;

/* loaded from: classes5.dex */
public class QueryParser {
    public List<Evaluator> evals = new ArrayList();
    public String query;

    /* renamed from: tq */
    public TokenQueue f4659tq;
    public static final String[] combinators = {",", ">", Marker.ANY_NON_NULL_MARKER, "~", StringUtils.SPACE};
    public static final String[] AttributeEvals = {"=", "!=", "^=", "$=", "*=", "~="};
    public static final Pattern NTH_AB = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
    public static final Pattern NTH_B = Pattern.compile("([+-])?(\\d+)");

    public QueryParser(String str) {
        Validate.notEmpty(str);
        String trim = str.trim();
        this.query = trim;
        this.f4659tq = new TokenQueue(trim);
    }

    private void allElements() {
        this.evals.add(new Evaluator.AllElements());
    }

    private void byAttribute() {
        List<Evaluator> list;
        Evaluator attributeWithValueMatching;
        List<Evaluator> list2;
        Evaluator attribute;
        TokenQueue tokenQueue = new TokenQueue(this.f4659tq.chompBalanced('[', ']'));
        String consumeToAny = tokenQueue.consumeToAny(AttributeEvals);
        Validate.notEmpty(consumeToAny);
        tokenQueue.consumeWhitespace();
        if (tokenQueue.isEmpty()) {
            if (consumeToAny.startsWith("^")) {
                list2 = this.evals;
                attribute = new Evaluator.AttributeStarting(consumeToAny.substring(1));
            } else {
                list2 = this.evals;
                attribute = new Evaluator.Attribute(consumeToAny);
            }
            list2.add(attribute);
            return;
        }
        if (tokenQueue.matchChomp("=")) {
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValue(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("!=")) {
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValueNot(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("^=")) {
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValueStarting(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("$=")) {
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValueEnding(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("*=")) {
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValueContaining(consumeToAny, tokenQueue.remainder());
        } else if (!tokenQueue.matchChomp("~=")) {
            throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.query, tokenQueue.remainder());
        } else {
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValueMatching(consumeToAny, Pattern.compile(tokenQueue.remainder()));
        }
        list.add(attributeWithValueMatching);
    }

    private void byClass() {
        String consumeCssIdentifier = this.f4659tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        this.evals.add(new Evaluator.Class(consumeCssIdentifier.trim()));
    }

    private void byId() {
        String consumeCssIdentifier = this.f4659tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        this.evals.add(new Evaluator.C3236Id(consumeCssIdentifier));
    }

    private void byTag() {
        String normalize = Normalizer.normalize(this.f4659tq.consumeElementSelector());
        Validate.notEmpty(normalize);
        if (normalize.startsWith("*|")) {
            this.evals.add(new CombiningEvaluator.C3235Or(new Evaluator.Tag(normalize), new Evaluator.TagEndsWith(normalize.replace("*|", ":"))));
            return;
        }
        if (normalize.contains("|")) {
            normalize = normalize.replace("|", ":");
        }
        this.evals.add(new Evaluator.Tag(normalize));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void combinator(char c) {
        Evaluator and;
        CombiningEvaluator.C3235Or c3235Or;
        boolean z;
        CombiningEvaluator.And and2;
        this.f4659tq.consumeWhitespace();
        Evaluator parse = parse(consumeSubQuery());
        if (this.evals.size() == 1) {
            and = this.evals.get(0);
            if ((and instanceof CombiningEvaluator.C3235Or) && c != ',') {
                z = true;
                c3235Or = and;
                and = ((CombiningEvaluator.C3235Or) and).rightMostEvaluator();
                this.evals.clear();
                if (c != '>') {
                    and2 = new CombiningEvaluator.And(parse, new StructuralEvaluator.ImmediateParent(and));
                } else if (c == ' ') {
                    and2 = new CombiningEvaluator.And(parse, new StructuralEvaluator.Parent(and));
                } else if (c == '+') {
                    and2 = new CombiningEvaluator.And(parse, new StructuralEvaluator.ImmediatePreviousSibling(and));
                } else if (c == '~') {
                    and2 = new CombiningEvaluator.And(parse, new StructuralEvaluator.PreviousSibling(and));
                } else if (c != ',') {
                    throw new Selector.SelectorParseException("Unknown combinator: " + c, new Object[0]);
                } else if (and instanceof CombiningEvaluator.C3235Or) {
                    CombiningEvaluator.C3235Or c3235Or2 = (CombiningEvaluator.C3235Or) and;
                    c3235Or2.add(parse);
                    and2 = c3235Or2;
                } else {
                    CombiningEvaluator.C3235Or c3235Or3 = new CombiningEvaluator.C3235Or();
                    c3235Or3.add(and);
                    c3235Or3.add(parse);
                    and2 = c3235Or3;
                }
                if (!z) {
                    ((CombiningEvaluator.C3235Or) c3235Or).replaceRightMostEvaluator(and2);
                } else {
                    c3235Or = and2;
                }
                this.evals.add(c3235Or);
            }
        } else {
            and = new CombiningEvaluator.And(this.evals);
        }
        c3235Or = and;
        z = false;
        this.evals.clear();
        if (c != '>') {
        }
        if (!z) {
        }
        this.evals.add(c3235Or);
    }

    private int consumeIndex() {
        String trim = this.f4659tq.chompTo(")").trim();
        Validate.isTrue(StringUtil.isNumeric(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private String consumeSubQuery() {
        String str;
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        while (!this.f4659tq.isEmpty()) {
            if (this.f4659tq.matches("(")) {
                borrowBuilder.append("(");
                borrowBuilder.append(this.f4659tq.chompBalanced('(', ')'));
                str = ")";
            } else if (this.f4659tq.matches("[")) {
                borrowBuilder.append("[");
                borrowBuilder.append(this.f4659tq.chompBalanced('[', ']'));
                str = "]";
            } else if (this.f4659tq.matchesAny(combinators)) {
                break;
            } else {
                borrowBuilder.append(this.f4659tq.consume());
            }
            borrowBuilder.append(str);
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    private void contains(boolean z) {
        List<Evaluator> list;
        Evaluator containsText;
        this.f4659tq.consume(z ? ":containsOwn" : ":contains");
        String unescape = TokenQueue.unescape(this.f4659tq.chompBalanced('(', ')'));
        Validate.notEmpty(unescape, ":contains(text) query must not be empty");
        if (z) {
            list = this.evals;
            containsText = new Evaluator.ContainsOwnText(unescape);
        } else {
            list = this.evals;
            containsText = new Evaluator.ContainsText(unescape);
        }
        list.add(containsText);
    }

    private void containsData() {
        this.f4659tq.consume(":containsData");
        String unescape = TokenQueue.unescape(this.f4659tq.chompBalanced('(', ')'));
        Validate.notEmpty(unescape, ":containsData(text) query must not be empty");
        this.evals.add(new Evaluator.ContainsData(unescape));
    }

    private void cssNthChild(boolean z, boolean z2) {
        List<Evaluator> list;
        Evaluator isNthChild;
        String normalize = Normalizer.normalize(this.f4659tq.chompTo(")"));
        Matcher matcher = NTH_AB.matcher(normalize);
        Matcher matcher2 = NTH_B.matcher(normalize);
        int i = 2;
        int i2 = 0;
        if ("odd".equals(normalize)) {
            i2 = 1;
        } else if (!"even".equals(normalize)) {
            if (matcher.matches()) {
                int parseInt = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                if (matcher.group(4) != null) {
                    i2 = Integer.parseInt(matcher.group(4).replaceFirst("^\\+", ""));
                }
                i = parseInt;
            } else if (!matcher2.matches()) {
                throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", normalize);
            } else {
                i2 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i = 0;
            }
        }
        if (z2) {
            if (z) {
                list = this.evals;
                isNthChild = new Evaluator.IsNthLastOfType(i, i2);
            } else {
                list = this.evals;
                isNthChild = new Evaluator.IsNthOfType(i, i2);
            }
        } else if (z) {
            list = this.evals;
            isNthChild = new Evaluator.IsNthLastChild(i, i2);
        } else {
            list = this.evals;
            isNthChild = new Evaluator.IsNthChild(i, i2);
        }
        list.add(isNthChild);
    }

    private void findElements() {
        List<Evaluator> list;
        Evaluator matchText;
        if (this.f4659tq.matchChomp("#")) {
            byId();
        } else if (this.f4659tq.matchChomp(".")) {
            byClass();
        } else if (this.f4659tq.matchesWord() || this.f4659tq.matches("*|")) {
            byTag();
        } else if (this.f4659tq.matches("[")) {
            byAttribute();
        } else if (this.f4659tq.matchChomp("*")) {
            allElements();
        } else if (this.f4659tq.matchChomp(":lt(")) {
            indexLessThan();
        } else if (this.f4659tq.matchChomp(":gt(")) {
            indexGreaterThan();
        } else if (this.f4659tq.matchChomp(":eq(")) {
            indexEquals();
        } else if (this.f4659tq.matches(":has(")) {
            has();
        } else if (this.f4659tq.matches(":contains(")) {
            contains(false);
        } else if (this.f4659tq.matches(":containsOwn(")) {
            contains(true);
        } else if (this.f4659tq.matches(":containsData(")) {
            containsData();
        } else if (this.f4659tq.matches(":matches(")) {
            matches(false);
        } else if (this.f4659tq.matches(":matchesOwn(")) {
            matches(true);
        } else if (this.f4659tq.matches(":not(")) {
            not();
        } else if (this.f4659tq.matchChomp(":nth-child(")) {
            cssNthChild(false, false);
        } else if (this.f4659tq.matchChomp(":nth-last-child(")) {
            cssNthChild(true, false);
        } else if (this.f4659tq.matchChomp(":nth-of-type(")) {
            cssNthChild(false, true);
        } else if (this.f4659tq.matchChomp(":nth-last-of-type(")) {
            cssNthChild(true, true);
        } else {
            if (this.f4659tq.matchChomp(":first-child")) {
                list = this.evals;
                matchText = new Evaluator.IsFirstChild();
            } else if (this.f4659tq.matchChomp(":last-child")) {
                list = this.evals;
                matchText = new Evaluator.IsLastChild();
            } else if (this.f4659tq.matchChomp(":first-of-type")) {
                list = this.evals;
                matchText = new Evaluator.IsFirstOfType();
            } else if (this.f4659tq.matchChomp(":last-of-type")) {
                list = this.evals;
                matchText = new Evaluator.IsLastOfType();
            } else if (this.f4659tq.matchChomp(":only-child")) {
                list = this.evals;
                matchText = new Evaluator.IsOnlyChild();
            } else if (this.f4659tq.matchChomp(":only-of-type")) {
                list = this.evals;
                matchText = new Evaluator.IsOnlyOfType();
            } else if (this.f4659tq.matchChomp(":empty")) {
                list = this.evals;
                matchText = new Evaluator.IsEmpty();
            } else if (this.f4659tq.matchChomp(":root")) {
                list = this.evals;
                matchText = new Evaluator.IsRoot();
            } else if (!this.f4659tq.matchChomp(":matchText")) {
                throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.query, this.f4659tq.remainder());
            } else {
                list = this.evals;
                matchText = new Evaluator.MatchText();
            }
            list.add(matchText);
        }
    }

    private void has() {
        this.f4659tq.consume(":has");
        String chompBalanced = this.f4659tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":has(el) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Has(parse(chompBalanced)));
    }

    private void indexEquals() {
        this.evals.add(new Evaluator.IndexEquals(consumeIndex()));
    }

    private void indexGreaterThan() {
        this.evals.add(new Evaluator.IndexGreaterThan(consumeIndex()));
    }

    private void indexLessThan() {
        this.evals.add(new Evaluator.IndexLessThan(consumeIndex()));
    }

    private void matches(boolean z) {
        List<Evaluator> list;
        Evaluator matches;
        this.f4659tq.consume(z ? ":matchesOwn" : ":matches");
        String chompBalanced = this.f4659tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":matches(regex) query must not be empty");
        if (z) {
            list = this.evals;
            matches = new Evaluator.MatchesOwn(Pattern.compile(chompBalanced));
        } else {
            list = this.evals;
            matches = new Evaluator.Matches(Pattern.compile(chompBalanced));
        }
        list.add(matches);
    }

    private void not() {
        this.f4659tq.consume(":not");
        String chompBalanced = this.f4659tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":not(selector) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Not(parse(chompBalanced)));
    }

    public static Evaluator parse(String str) {
        try {
            return new QueryParser(str).parse();
        } catch (IllegalArgumentException e) {
            throw new Selector.SelectorParseException(e.getMessage(), new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0041 -> B:5:0x001f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0023 -> B:6:0x0026). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x003c -> B:4:0x0019). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Evaluator parse() {
        this.f4659tq.consumeWhitespace();
        if (this.f4659tq.matchesAny(combinators)) {
            this.evals.add(new StructuralEvaluator.Root());
            char c = this.f4659tq.consume();
            combinator(c);
            if (this.f4659tq.isEmpty()) {
                boolean consumeWhitespace = this.f4659tq.consumeWhitespace();
                if (!this.f4659tq.matchesAny(combinators)) {
                    if (consumeWhitespace) {
                        c = TokenParser.f4579SP;
                        combinator(c);
                        if (this.f4659tq.isEmpty()) {
                            return this.evals.size() == 1 ? this.evals.get(0) : new CombiningEvaluator.And(this.evals);
                        }
                    }
                }
                char c2 = this.f4659tq.consume();
                combinator(c2);
                if (this.f4659tq.isEmpty()) {
                }
            }
        }
        findElements();
        if (this.f4659tq.isEmpty()) {
        }
    }
}

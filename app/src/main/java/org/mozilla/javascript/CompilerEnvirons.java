package org.mozilla.javascript;

import java.util.Set;
import org.mozilla.javascript.ast.ErrorCollector;

/* loaded from: classes5.dex */
public class CompilerEnvirons {
    public Set<String> activationNames;
    public boolean ideMode;
    public boolean recordingComments;
    public boolean recordingLocalJsDocComments;
    public boolean recoverFromErrors;
    public boolean warnTrailingComma;
    public ErrorReporter errorReporter = DefaultErrorReporter.instance;
    public int languageVersion = 0;
    public boolean generateDebugInfo = true;
    public boolean reservedKeywordAsIdentifier = true;
    public boolean allowMemberExprAsFunctionName = false;
    public boolean xmlAvailable = true;
    public int optimizationLevel = 0;
    public boolean generatingSource = true;
    public boolean strictMode = false;
    public boolean warningAsError = false;
    public boolean generateObserverCount = false;
    public boolean allowSharpComments = false;

    public static CompilerEnvirons ideEnvirons() {
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        compilerEnvirons.setRecoverFromErrors(true);
        compilerEnvirons.setRecordingComments(true);
        compilerEnvirons.setStrictMode(true);
        compilerEnvirons.setWarnTrailingComma(true);
        compilerEnvirons.setLanguageVersion(170);
        compilerEnvirons.setReservedKeywordAsIdentifier(true);
        compilerEnvirons.setIdeMode(true);
        compilerEnvirons.setErrorReporter(new ErrorCollector());
        return compilerEnvirons;
    }

    public Set<String> getActivationNames() {
        return this.activationNames;
    }

    public boolean getAllowSharpComments() {
        return this.allowSharpComments;
    }

    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final int getLanguageVersion() {
        return this.languageVersion;
    }

    public final int getOptimizationLevel() {
        return this.optimizationLevel;
    }

    public boolean getWarnTrailingComma() {
        return this.warnTrailingComma;
    }

    public void initFromContext(Context context) {
        setErrorReporter(context.getErrorReporter());
        this.languageVersion = context.getLanguageVersion();
        this.generateDebugInfo = !context.isGeneratingDebugChanged() || context.isGeneratingDebug();
        this.reservedKeywordAsIdentifier = context.hasFeature(3);
        this.allowMemberExprAsFunctionName = context.hasFeature(2);
        this.strictMode = context.hasFeature(11);
        this.warningAsError = context.hasFeature(12);
        this.xmlAvailable = context.hasFeature(6);
        this.optimizationLevel = context.getOptimizationLevel();
        this.generatingSource = context.isGeneratingSource();
        this.activationNames = context.activationNames;
        this.generateObserverCount = context.generateObserverCount;
    }

    public final boolean isAllowMemberExprAsFunctionName() {
        return this.allowMemberExprAsFunctionName;
    }

    public final boolean isGenerateDebugInfo() {
        return this.generateDebugInfo;
    }

    public boolean isGenerateObserverCount() {
        return this.generateObserverCount;
    }

    public final boolean isGeneratingSource() {
        return this.generatingSource;
    }

    public boolean isIdeMode() {
        return this.ideMode;
    }

    public boolean isRecordingComments() {
        return this.recordingComments;
    }

    public boolean isRecordingLocalJsDocComments() {
        return this.recordingLocalJsDocComments;
    }

    public final boolean isReservedKeywordAsIdentifier() {
        return this.reservedKeywordAsIdentifier;
    }

    public final boolean isStrictMode() {
        return this.strictMode;
    }

    public final boolean isXmlAvailable() {
        return this.xmlAvailable;
    }

    public boolean recoverFromErrors() {
        return this.recoverFromErrors;
    }

    public final boolean reportWarningAsError() {
        return this.warningAsError;
    }

    public void setActivationNames(Set<String> set) {
        this.activationNames = set;
    }

    public void setAllowMemberExprAsFunctionName(boolean z) {
        this.allowMemberExprAsFunctionName = z;
    }

    public void setAllowSharpComments(boolean z) {
        this.allowSharpComments = z;
    }

    public void setErrorReporter(ErrorReporter errorReporter) {
        if (errorReporter != null) {
            this.errorReporter = errorReporter;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setGenerateDebugInfo(boolean z) {
        this.generateDebugInfo = z;
    }

    public void setGenerateObserverCount(boolean z) {
        this.generateObserverCount = z;
    }

    public void setGeneratingSource(boolean z) {
        this.generatingSource = z;
    }

    public void setIdeMode(boolean z) {
        this.ideMode = z;
    }

    public void setLanguageVersion(int i) {
        Context.checkLanguageVersion(i);
        this.languageVersion = i;
    }

    public void setOptimizationLevel(int i) {
        Context.checkOptimizationLevel(i);
        this.optimizationLevel = i;
    }

    public void setRecordingComments(boolean z) {
        this.recordingComments = z;
    }

    public void setRecordingLocalJsDocComments(boolean z) {
        this.recordingLocalJsDocComments = z;
    }

    public void setRecoverFromErrors(boolean z) {
        this.recoverFromErrors = z;
    }

    public void setReservedKeywordAsIdentifier(boolean z) {
        this.reservedKeywordAsIdentifier = z;
    }

    public void setStrictMode(boolean z) {
        this.strictMode = z;
    }

    public void setWarnTrailingComma(boolean z) {
        this.warnTrailingComma = z;
    }

    public void setXmlAvailable(boolean z) {
        this.xmlAvailable = z;
    }
}

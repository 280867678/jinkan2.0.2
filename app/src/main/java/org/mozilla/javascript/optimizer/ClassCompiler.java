package org.mozilla.javascript.optimizer;

import me.tvspark.outline;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.IRFactory;
import org.mozilla.javascript.JavaAdapter;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.ScriptNode;

/* loaded from: classes5.dex */
public class ClassCompiler {
    public CompilerEnvirons compilerEnv;
    public String mainMethodClassName;
    public Class<?> targetExtends;
    public Class<?>[] targetImplements;

    public ClassCompiler(CompilerEnvirons compilerEnvirons) {
        if (compilerEnvirons != null) {
            this.compilerEnv = compilerEnvirons;
            this.mainMethodClassName = Codegen.DEFAULT_MAIN_METHOD_CLASS;
            return;
        }
        throw new IllegalArgumentException();
    }

    public Object[] compileToClassFiles(String str, String str2, int i, String str3) {
        ScriptNode transformTree = new IRFactory(this.compilerEnv).transformTree(new Parser(this.compilerEnv).parse(str, str2, i));
        Class<?> targetExtends = getTargetExtends();
        Class<?>[] targetImplements = getTargetImplements();
        boolean z = targetImplements == null && targetExtends == null;
        String makeAuxiliaryClassName = z ? str3 : makeAuxiliaryClassName(str3, "1");
        Codegen codegen = new Codegen();
        codegen.setMainMethodClass(this.mainMethodClassName);
        byte[] compileToClassFile = codegen.compileToClassFile(this.compilerEnv, makeAuxiliaryClassName, transformTree, transformTree.getEncodedSource(), false);
        if (z) {
            return new Object[]{makeAuxiliaryClassName, compileToClassFile};
        }
        int functionCount = transformTree.getFunctionCount();
        ObjToIntMap objToIntMap = new ObjToIntMap(functionCount);
        for (int i2 = 0; i2 != functionCount; i2++) {
            FunctionNode functionNode = transformTree.getFunctionNode(i2);
            String name = functionNode.getName();
            if (name != null && name.length() != 0) {
                objToIntMap.put(name, functionNode.getParamCount());
            }
        }
        if (targetExtends == null) {
            targetExtends = ScriptRuntime.ObjectClass;
        }
        return new Object[]{str3, JavaAdapter.createAdapterCode(objToIntMap, str3, targetExtends, targetImplements, makeAuxiliaryClassName), makeAuxiliaryClassName, compileToClassFile};
    }

    public CompilerEnvirons getCompilerEnv() {
        return this.compilerEnv;
    }

    public String getMainMethodClass() {
        return this.mainMethodClassName;
    }

    public Class<?> getTargetExtends() {
        return this.targetExtends;
    }

    public Class<?>[] getTargetImplements() {
        Class<?>[] clsArr = this.targetImplements;
        if (clsArr == null) {
            return null;
        }
        return (Class[]) clsArr.clone();
    }

    public String makeAuxiliaryClassName(String str, String str2) {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2);
    }

    public void setMainMethodClass(String str) {
        this.mainMethodClassName = str;
    }

    public void setTargetExtends(Class<?> cls) {
        this.targetExtends = cls;
    }

    public void setTargetImplements(Class<?>[] clsArr) {
        this.targetImplements = clsArr == null ? null : (Class[]) clsArr.clone();
    }
}

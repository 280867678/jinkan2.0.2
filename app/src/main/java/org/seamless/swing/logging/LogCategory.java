package org.seamless.swing.logging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/* loaded from: classes5.dex */
public class LogCategory {
    public List<Group> groups;
    public String name;

    /* loaded from: classes5.dex */
    public static class Group {
        public boolean enabled;
        public List<LoggerLevel> loggerLevels;
        public String name;
        public List<LoggerLevel> previousLevels;

        public Group(String str) {
            this.loggerLevels = new ArrayList();
            this.previousLevels = new ArrayList();
            this.name = str;
        }

        public Group(String str, LoggerLevel[] loggerLevelArr) {
            this.loggerLevels = new ArrayList();
            this.previousLevels = new ArrayList();
            this.name = str;
            this.loggerLevels = Arrays.asList(loggerLevelArr);
        }

        public List<LoggerLevel> getLoggerLevels() {
            return this.loggerLevels;
        }

        public String getName() {
            return this.name;
        }

        public List<LoggerLevel> getPreviousLevels() {
            return this.previousLevels;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(boolean z) {
            this.enabled = z;
        }

        public void setPreviousLevels(List<LoggerLevel> list) {
            this.previousLevels = list;
        }
    }

    /* loaded from: classes5.dex */
    public static class LoggerLevel {
        public Level level;
        public String logger;

        public LoggerLevel(String str, Level level) {
            this.logger = str;
            this.level = level;
        }

        public Level getLevel() {
            return this.level;
        }

        public String getLogger() {
            return this.logger;
        }
    }

    public LogCategory(String str) {
        this.groups = new ArrayList();
        this.name = str;
    }

    public LogCategory(String str, Group[] groupArr) {
        this.groups = new ArrayList();
        this.name = str;
        this.groups = Arrays.asList(groupArr);
    }

    public void addGroup(String str, LoggerLevel[] loggerLevelArr) {
        this.groups.add(new Group(str, loggerLevelArr));
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    public String getName() {
        return this.name;
    }
}

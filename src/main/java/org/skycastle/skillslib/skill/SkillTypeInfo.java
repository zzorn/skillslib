package org.skycastle.skillslib.skill;

import org.flowutils.Symbol;

/**
 * User readable information about a skill type.
 */
public class SkillTypeInfo {
    private final Symbol skillTypeId;
    private final String name;
    private final String description;

    public SkillTypeInfo(Symbol skillTypeId, String name, String description) {
        this.skillTypeId = skillTypeId;
        this.name = name;
        this.description = description;
    }

    public Symbol getSkillTypeId() {
        return skillTypeId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

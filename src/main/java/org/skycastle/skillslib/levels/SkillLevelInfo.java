package org.skycastle.skillslib.levels;

import org.flowutils.Symbol;

/**
 * Information about a skill level that is available to the player.
 * Suitable for passing to the client.
 */
public class SkillLevelInfo {

    private final Symbol skillId;
    private final double skillLevel;

    public SkillLevelInfo(Symbol skillId, double skillLevel) {
        this.skillId = skillId;
        this.skillLevel = skillLevel;
    }

    public Symbol getSkillId() {
        return skillId;
    }

    public double getSkillLevel() {
        return skillLevel;
    }
}

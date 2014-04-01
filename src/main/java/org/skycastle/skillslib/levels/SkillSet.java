package org.skycastle.skillslib.levels;

import org.skycastle.skillslib.CharacterState;

import java.util.List;

/**
 * Describes a set of skills that some in-game character has.
 */
public interface SkillSet {

    /**
     * Calculates the change to the skills in the skillset over time.
     *
     * @param characterState current physical and mental state of the character.
     * @param secondsSinceLastCall number of seconds since the last call to this method for this SkillSet.
     */
    void updateOverTime(CharacterState characterState, double secondsSinceLastCall);

    /**
     * @return the skills and their levels in this skillset.
     */
    List<SkillLevel> getSkillLevels();

}

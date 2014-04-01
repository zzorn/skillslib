package org.skycastle.skillslib.levels;

import org.skycastle.skillslib.CharacterState;
import org.skycastle.skillslib.SkillService;
import org.skycastle.skillslib.skill.Skill;

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

    /**
     * Learn a new skill, and add it to this SkillSet.
     *
     * @param skill new skill to learn.
     * @param characterState Current physical and mental state of the character.
     */
    void learnSkill(Skill skill, CharacterState characterState);

}

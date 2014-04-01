package org.skycastle.skillslib.levels;

import org.skycastle.skillslib.CharacterState;
import org.skycastle.skillslib.skill.Skill;

/**
 * Represents some level of knowledge of a skill.
 */
public interface SkillLevel {

    /**
     * @return the Skill that this skill level is in.
     */
    Skill getSkill();

    /**
     * @return information for player, suitable for passing to a client.
     */
    SkillLevelInfo getLevelInfo();

    /**
     * Called when the skill is used.
     *
     * @param characterState Current physical and mental state of the character.
     * @param taskDifficulty base difficulty for the attempted task.
     * @param difficultyAdjustments adjustments to the difficulty from tools and environmental factors.
     * @param durationSeconds number of seconds that the skill use took.
     * @return success amount of the skill use:
     *          -1..0 = destructive failure,
     *          0 = no success,
     *          0..1 = partial success,
     *          1 = skill succeeded,
     *          1..2 = excellent success
     */
    double useSkill(CharacterState characterState, double taskDifficulty, double difficultyAdjustments, double durationSeconds);

    /**
     * Applies training to this skill.
     *
     * @param characterState Current physical and mental state of the character.
     * @param trainerSkill skill of the trainer or the training material.
     * @param trainingQuality adjustment for how efficient the training is, affected e.g. by the trainers teaching skill, or the readers understanding of the written word.
     *                        (0 = no communication possible, 1 = perfect communication, -1 = faulty training, 2 = excellent training).
     * @param secondsStudied time used to train.
     */
    void trainSkill(CharacterState characterState, double trainerSkill, double trainingQuality, double secondsStudied);

    /**
     * Adds skillpoints to this skill, e.g. during character creation or during levelup or from other reward.
     * @param skillPoints skillpoints to add to this skill level.
     */
    void addPoints(double skillPoints);

    /**
     * Updates the skill level over time.
     * @param secondsSinceLastCall number of seconds since the last call of this method for this skill.
     */
    void updateSkill(double secondsSinceLastCall);

    /**
     * @return current skill level, indicating how knowledgeable the character is in this skill at this moment.
     */
    double getLevel();
    void setLevel(double newSkillLevel);
    void changeLevel(double levelChange);

    /**
     * @return general indication of how much used a skill is.  A well used skill is harder to forget,
     *         and could be easier to learn more in.
     */
    double getUsage();
    void setUsage(double newUsage);
    void changeUsage(double usageChange);

    /**
     * @return general indication of how well memorized a skill is.
     * Skills that are not much used may get forgotten, but if they were once well recalled, they will be easier to re-learn.
     */
    double getRecall();
    void setRecall(double newSkillRecall);
    void changeRecall(double recallChange);



}

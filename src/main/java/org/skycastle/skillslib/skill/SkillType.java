package org.skycastle.skillslib.skill;

import org.skycastle.skillslib.CharacterState;
import org.skycastle.skillslib.levels.SkillLevel;

/**
 * Describes how a skill is learned.
 * E.g. agility based motion skills might be best learned by using in suitably challenging environments,
 * while knowledge skills could best be learned by training.
 *
 * Has a few parameters, such as the skill difficulty, and any other skills it depends on,
 * and how strongly it depends on other skills in its category.
 */
// TODO: Formulas could / should be parsed from the config and used for updating the SkillLevel data
// when using skills, teaching skills, adding skill points, and updating skills over time.
// The formulas can use the character state, current skill skill level data, current skill category data,
// or the skill level data of another skill, or the category data of another category, to calculate the changes to the skill level.
// Formulas can be specified in general for all skills, or per category, or per skill.
// Optionally formulas could be defined in functions and used in many different places (e.g. some skills could be agility skills and
// learn in a certain way, and knowledge skills in another, even if they are in different categories).
// TODO: Skills should probably reveal some hints about how hard they are to learn, or what other skills they depend on, etc?
// Either in free-form descriptions, or maybe define a set of descriptions / skill types?
// Maybe instead of all freeform formulas, allow designers to define skill types, with some parameters (difficulty, dependent skills, etc)?
// Each skill would then specify what skill type it is, and the skill type would provide a description about how to learn the skill.
public interface SkillType {

    /**
     * @return a user readable description of this SkillType that can be sent to the client.
     */
    SkillTypeInfo getSkillTypeInfo();

    /**
     * Calculates the change to a skill level as a result of usage.
     *
     * @param skillLevel the skill level to update.
     * @param characterState current physical and mental state of the character.  Exact attributes depend on the rest of the game
     *                       system and configuration, but could e.g. be attributes such as strength, intelligence and dexterity,
     *                       or mental or biological state such as focus, alertness, pain, adrenaline, elation, fear, energy level, hunger, etc.
     * @param taskDifficulty basic difficulty of the task.
     * @param difficultyAdjustments adjustments to the difficulty from the tools and the environment.
     * @param durationSeconds number of seconds that the skill use took.
     * @return success amount of the skill use:
     *          -1..0 = destructive failure,
     *          0 = no success,
     *          0..1 = partial success,
     *          1 = skill succeeded,
     *          1..2 = excellent success
     */
    double useSkill(SkillLevel skillLevel, CharacterState characterState, double taskDifficulty, double difficultyAdjustments, double durationSeconds);

    /**
     * Applies training for this skill to the specified skill level.
     *
     * @param skillLevel the skill level to train.
     * @param characterState Current physical and mental state of the character.
     * @param trainerSkill skill of the trainer or the training material.
     * @param trainingQuality adjustment for how efficient the training is, affected e.g. by the trainers teaching skill, or the readers understanding of the written word.
     *                        (0 = no communication possible, 1 = perfect communication, -1 = faulty training, 2 = excellent training).
     * @param secondsStudied time used to train.
     */
    void train(SkillLevel skillLevel, CharacterState characterState, double trainerSkill, double trainingQuality, double secondsStudied);

    /**
     * Adds skillpoints, e.g. during character creation, or if given as levelup or other rewards.
     *
     * @param skillLevel the skill level to update.
     * @param points point amount to add to this skill.
     */
    void addPoints(SkillLevel skillLevel, double points);

    /**
     * Calculates the change to a skill level over time.
     *
     * @param skillLevel the skill level to update.
     * @param characterState current physical and mental state of the character.
     * @param secondsSinceLastCall number of seconds since the last call to this method for this skill.
     */
    void updateOverTime(SkillLevel skillLevel, CharacterState characterState, double secondsSinceLastCall);

}

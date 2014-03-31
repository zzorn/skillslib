package org.skycastle.skillslib;

/**
 * Contains information about a specific skill.
 */
//TODO: The level of some specific other skills could affect the level of a skill?  E.g. give some boost, possibly with a max cap of some sort.
public interface Skill {

    /**
     * @return generic information about a skill, suitable for e.g. passing to a client.
     */
    SkillInfo getInfo();

    /**
     * @return the category this skill belongs to, or null if none.
     */
    SkillCategory getCategory();

}

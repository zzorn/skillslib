package org.skycastle.skillslib.skill;

import java.util.List;

/**
 * A group of related skills.
 */
public interface SkillCategory {

    

    /**
     * @return parent category for this category of skills, or null if none.
     */
    SkillCategory getParentCategory();

    /**
     * @return the skills in this category, ordered by their default ordering.
     */
    List<Skill> getSkills();

}

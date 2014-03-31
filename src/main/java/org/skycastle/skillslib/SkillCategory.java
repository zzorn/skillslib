package org.skycastle.skillslib;

import java.util.List;

/**
 * A group of related skills.
 */
// TODO: A SkillCategory could specify some common properties for skills in it?
    // TODO: Should we just nest skills instead?
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

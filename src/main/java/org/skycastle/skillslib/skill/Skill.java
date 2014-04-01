package org.skycastle.skillslib.skill;

import org.flowutils.Symbol;
import org.skycastle.skillslib.CharacterState;
import org.skycastle.skillslib.SkillService;
import org.skycastle.skillslib.levels.SkillLevel;

import java.util.List;
import java.util.Map;

/**
 * Contains information about a specific skill.
 */
public interface Skill {

    /**
     * @return unique id for this skill.
     */
    Symbol getSkillId();

    /**
     * @return user readable name for this skill.
     */
    String getName();

    /**
     * @return user readable description of this skill.
     */
    String getDescription();

    /**
     * @return reference or path to the icon for this skill.
     */
    String getIconRef();

    /**
     * @return id of the SkillType this Skill has.
     */
    Symbol getSkillTypeId();

    /**
     * @return id of the category that this Skill has.
     */
    Symbol getCategoryId();

    /**
     * @return describes in what way the skill is learned.
     */
    SkillType getSkillType();

    /**
     * @return the category this skill belongs to, or null if none.
     */
    SkillCategory getCategory();

    /**
     * @return how difficult the skill is to master.
     *         0 = innate, 0.5 = normal, 1 = extremely challenging.
     */
    double getDifficulty();

    /**
     * @return skills that this skill depends on, and the degree of dependence.
     *         -1 = very hard to learn if the specified skill is known,
     *         -0.5 = hard to learn if the specified skill is known,
     *         0 = no dependency,
     *         0.5 = medium dependency,
     *         1 = next ot impossible to learn without knowing the specified skill.
     */
    Map<Symbol, Double> getSkillDependencies();

    /**
     * @return how much this skill depends on the level of other skills in its category.
     *         -1 = very hard to learn if other skills in the category are known to some degree,
     *         -0.5 = hard to learn if other skills in the category are known,
     *         0 = no effect from other skills in the category,
     *         0.5 = requires some knowledge of other skills in the category to learn well,
     *         1 = very dependent on skill levels of other skills in the category to learn.
     */
    double getCategoryDependency();

    /**
     * Used when updating skill settings and formulas on the fly - reads the source object and applies its properties to this one.
     * That way we can keep references to a single Skill object from SkillLevels, without needing to update the reference when
     * we reload settings.
     *
     * @param source source Skill object to copy to this.
     * @param skillService used to look up SkillTypes and SkillCategories.
     */
    void copyFrom(Skill source, SkillService skillService);

}

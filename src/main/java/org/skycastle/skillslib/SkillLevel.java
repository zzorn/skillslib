package org.skycastle.skillslib;

/**
 * Represents some level of knowledge of a skill.
 */
public interface SkillLevel {

    Skill getSkill(SkillService skillService);
    
    double getLevel();

    double useSkill(SkillService skillService, double difficulty);



}

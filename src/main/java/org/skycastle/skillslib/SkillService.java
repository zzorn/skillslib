package org.skycastle.skillslib;

import org.flowutils.Symbol;
import org.flowutils.service.Service;
import org.skycastle.skillslib.skill.Skill;
import org.skycastle.skillslib.skill.SkillCategory;
import org.skycastle.skillslib.skill.SkillType;

import java.io.File;
import java.io.Reader;
import java.util.List;

/**
 * Provides skill related services.
 */
// TODO: Resource library that abstracts away the location of a resource (file system or jar or custom stream or string constant)  Put it in flowutils.
public interface SkillService extends Service {

    void loadSkills(File file);
    void loadSkills(String path);
    void loadSkills(Reader reader);

    void saveSkills(File file);

    void importSkills(String skillData);
    String exportSkills();

    Skill getSkill(Symbol skillId);
    SkillType getSkillType(Symbol skillTypeId);
    SkillCategory getCategory(Symbol categoryId);

    List<Skill> getSkills();
    List<SkillCategory> getCategories();
    List<SkillType> getSkillTypes();

    List<Class> getClassesNeededForSerializingSkills();

    List<Class> getClassesNeededForSerializingSkillSets();




}

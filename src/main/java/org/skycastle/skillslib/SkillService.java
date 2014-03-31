package org.skycastle.skillslib;

import org.flowutils.Symbol;
import org.flowutils.service.Service;

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

    List<Class> getClassesNeededForSerializingSkills();

    List<Class> getClassesNeededForSerializingSkillSets();



}

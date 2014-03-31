package org.skycastle.skillslib;

import java.util.List;

/**
 * Describes a set of skills that some in-game character has.
 */
// TODO: Some mechanism for awarding and placing skill points?  Or maybe that is implementation specific?
public interface SkillSet {

    List<SkillLevel> getSkillLevels();

}

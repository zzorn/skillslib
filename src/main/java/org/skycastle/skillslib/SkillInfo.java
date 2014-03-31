package org.skycastle.skillslib;

import org.flowutils.Symbol;

/**
 * Generic information about a skill.  Does not contain any mechanics details, just name, description and icon.
 */
public interface SkillInfo {

    Symbol skillId();

    String getName();

    String getDescription();

    String getIconRef();

}

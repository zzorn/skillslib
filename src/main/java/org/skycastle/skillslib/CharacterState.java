package org.skycastle.skillslib;

import org.flowutils.Symbol;

/**
 * Represents the characters abilities and current mental and physical state.
 * Used to calculate how easily skills are learned and forgotten.
 */
public interface CharacterState {

    /**
     * @return the value of the specified attribute, or zero if the character has no such attribute.
     */
    double getAttribute(Symbol attributeName);

    /**
     * @return the value of the specified attribute, or the default value if the character has no such attribute.
     */
    double getAttribute(Symbol attributeId, double defaultValue);

}

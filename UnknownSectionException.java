package de.hrw.progra2.assignment7;

/**
 * Exception that occurs if a section is unknown.
 */
public class UnknownSectionException extends Exception {
    /**
     * Construction setting name of missing section.
     * @param sectionName name of missing section
     */
    public UnknownSectionException(String sectionName) {
        super("Section '" + sectionName+  "' is unknown.");
    }
}

package de.hrw.progra2.assignment6;

/**
 * Enumerator for text placeholders.
 */
public enum Placeholder {
    PROJECT_ID("P1-2331-212"),
    TEAM_ID("T123"),
    TEAM_LEAD("Bob");

    /**
     * Text that replaces placeholder.
     */
    private String replacementText;

    /**
     * Constructor setting replacement text.
     * @param replacementText replacement text
     */
    Placeholder(String replacementText) {
        this.replacementText = replacementText;
    }

    /**
     * @return replacement text
     */
    public String getReplacementText() {
        return replacementText;
    }
}

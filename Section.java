package de.hrw.progra2.assignment7;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration section.
 */
public class Section {
    /**
     * Name of the section.
     */
    private String name;

    /**
     * Key-value pair of values in the section
     */
    private Map<String, String> values;

    /**
     * Constructor setting section name and creating empty value map.
     * @param sectionName section name
     */
    public Section(String sectionName) {
        this.name = sectionName;
        this.values = new HashMap<>();
    }

    /**
     * @return name of section
     */
    public String getName() {
        return this.name;
    }

    /**
     * Puts a key with a value into the section.
     * @param key key
     * @param value value
     */
    public void putValue(String key, String value) {
        this.values.put(key, value);
    }

    /**
     * Checks if a key is present in the section.
     * @param key key
     * @return true iff key is present
     */
    public boolean containsKey(String key) {
        return values.containsKey(key);
    }

    /**
     * Returns value
     * @param key
     * @return
     */
    public String getValue(String key) {
        return values.get(key);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Section{" +
                "sectionName='" + name + '\'' +
                ", values=" + values +
                '}';
    }
}

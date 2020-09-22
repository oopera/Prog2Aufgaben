package de.hrw.progra2.assignment7;

import java.io.*;
import java.nio.channels.SelectableChannel;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Config {
    /**
     * List of all sections.
     */
    private static List<Section> sections;

    /**
     * Name of resource.
     */
    private static final String RESOURCE_NAME = "de/hrw/progra2/assignment7/config.ini";

    /**
     * Pattern to identify a section.
     */
    private static final Pattern SECTION_PATTERN = Pattern.compile("\\[(.*)\\]");

    /**
     * Pattern to identify a key-value pair.
     */
    private static final Pattern KEY_VALUE_PAIR_PATTERN = Pattern.compile("(.*)=(.*)");
    //"([^=])=(.*)"

    /**
     * Constructor. The constructor preloads configuration from resource.
     */
    public Config() throws IOException {

        sections = new ArrayList<Section>(25);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(RESOURCE_NAME)), StandardCharsets.UTF_8))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                Matcher matcher = SECTION_PATTERN.matcher(line);
                if (matcher.find()) {
                    Section section = new Section(matcher.group(1));
                    try {
                        for (int i = 0; i < 3; i++) {
                            while ((line = br.readLine()) != null) {
                                Matcher matcher2 = KEY_VALUE_PAIR_PATTERN.matcher(line);
                                while (matcher2.find()) {
                                    String key = matcher2.group(1);
                                    String value = matcher2.group(2);
                                    section.putValue(key, value);
                                }
                                break;
                            }
                        }
                    } catch (NumberFormatException e){
                        throw new NumberFormatException();
                    }
                    sections.add(section);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            }
        }

    /**
     * Retrieves the value of a key in a section.
     * @param sectionName name of a section
     * @param key key in the section
     * @return value of the given key in the section
     * @throws UnknownSectionException if section is unknown
     * @throws NoSuchElementException if value is not found
     */
    public String getConfigValue(String sectionName, String key) throws UnknownSectionException {


        while(sections.iterator().hasNext()){
            if (sectionName == "main") {
                if(key.equals("application-name")){
                    System.out.println(sections.get(0).getValue(key));
                } else if(key.equals("purpose")){
                    System.out.println(sections.get(0).getValue(key));
                } else if(key.equals("version")){
                    System.out.println(sections.get(0).getValue(key));
                } else{
                    throw new NoSuchElementException();
                }

            } else if (sectionName == "values"){
                if(key.equals("baseCost")) {
                    System.out.println(sections.get(1).getValue(key));
                } else if(key.equals("additionalCost")) {
                    System.out.println(sections.get(1).getValue(key));
                } else {
                    throw new NoSuchElementException();
                }
            } else if (sectionName == "flags"){
                    if(key.equals("showLoadOnStartup")){
                        System.out.println(sections.get(2).getValue(key));
                    } else if(key.equals("autoUpdateEnabled")){
                        System.out.println(sections.get(2).getValue(key));
                    } else {
                        throw new NoSuchElementException();
                    }
                } else {
                throw new UnknownSectionException(sectionName);

            }
                break;
        }

        return sectionName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Config: ");
        if(sections == null) {
            builder.append("no sections");
        } else {
            for(Section section : sections) {
                builder.append("\n- " + section);
            }
        }
        return builder.toString();
    }
}

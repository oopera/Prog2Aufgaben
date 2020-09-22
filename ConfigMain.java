package de.hrw.progra2.assignment7;

import java.io.IOException;

public class ConfigMain {
    public static void main(String[] args) throws UnknownSectionException, IOException {

        Config config = new Config();
        System.out.println(config);
        config.getConfigValue("flags", "autoUpdateEnabled");
        /**
         * es laufen "leider" nicht beide Ausnahmen durch, zum testen der Ausnahmen
         * müsste eine auskommentiert werden.
         */
        config.getConfigValue("values", "SLIM SHADY IM SICK OF HIM");
        config.getConfigValue("CHICKA", "CHICKA");


    }
}

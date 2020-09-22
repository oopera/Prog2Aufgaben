package de.hrw.progra2.assignment7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;


public class TranscriptReport {
    /**
     * Number of times word 'million' occurs.
     */
    private long millionCount;

    /**
     * Number of times word 'billion' occurs.
     */
    private long billionCount;

    /**
     * Average word count per file.
     */
    private long averageWordCount;

    /**
     * Constructor.
     */
    public TranscriptReport(String folder) throws IOException {
        analyseFolder(folder);
    //  resetStatistic();

    }

    /**
     * Resets statistic.
     */
    private final void resetStatistic() {
        millionCount = 0;
        billionCount = 0;
        averageWordCount = 0;
    }

    /**
     * Analyses a folder with text files for number of times the word 'million' and 'billion' occurs
     * (case insensitive). Also computes the average word count per file.
     * @param folder folder contain text files only
     * @throws IOException if an I/O problem occurs
     */
    public void analyseFolder(String folder) throws IOException {

        final File directory = new File(folder);
        int numberoftranscripts = 0;
        int count = 0;

        Set<String> millions = new HashSet<>(Arrays.asList("million", "Million", "Millions"));
        Set<String> billions = new HashSet<>(Arrays.asList("billion", "Billion", "Billions"));

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };
        try{


        for (final File fileEntry : (directory.listFiles(filter))) {
            System.out.println("Parsing: " + fileEntry.getAbsolutePath() + "...");
            if (fileEntry.isDirectory()) {
                analyseFolder(folder);
            } else {
                }
                try (Scanner sc = new Scanner(new FileInputStream(fileEntry.getAbsolutePath()))) {
                    while (sc.hasNext()) {
                        String str = sc.next();
                        if(!str.contains("♪") || !str.contains("-")) {
                            count++;
                        }
                        if (millions.contains(str)) {
                            millionCount++;
                    } else if(billions.contains(str)){
                            billionCount++;
                        }
                    }
                }
                numberoftranscripts++;
                averageWordCount = count / numberoftranscripts;

            }

        System.out.println("Average words: " + averageWordCount);
        System.out.println("Number of occurrences million: " + millionCount);
        System.out.println("Number of occurrences billion: " + billionCount);
    } catch(IOException e){
            throw new IOException();
        }

    }

    /**
     * Save report to a file.
     * @param reportOutputFilename filename for output file
     * @throws IOException if an I/O problem occurs
     */
    public void saveReport(String reportOutputFilename) {

        try {
            File myObj = new File(reportOutputFilename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(reportOutputFilename);
            myWriter.write("Million Count: " + millionCount + "\n"
            + "Billion Count: " + billionCount + "\n"
            + "Average word count per episode: " + averageWordCount + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
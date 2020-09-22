package de.hrw.progra2.assignment7;

import java.io.File;
import java.io.IOException;
import java.sql.Savepoint;

public class TranscriptReportMain {
    public static void main(String[] args) throws IOException {
        String directory = "/Users/operboi/Desktop/UNI/SEM II/Programmierung 2/Abgaben/p2-assignment-7-group-99/Transcripts_1/Transcripts";
        TranscriptReport Reporty = new TranscriptReport(directory);
        System.out.println(Reporty);
        Reporty.saveReport("FileyTheFile");


    }
}

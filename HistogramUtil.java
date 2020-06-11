package de.hrw.progra2.assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HistogramUtil<T> {

    private final List<T> arrayList = new ArrayList<>();

    public static <T> Map<String, Long> computeHistogram(List<T> list) {
        Map<String, Long> computeHistogram = new HashMap<>();
        for(T item : list){
            System.out.println(item + ": " + Collections.frequency(list, item));
                if(computeHistogram.containsKey(item)){
                    computeHistogram.put((String) item, (computeHistogram.get(item) + 1));
                }else
                    computeHistogram.put((String) item, (long) 1);
            }
        return computeHistogram;
    }

    public static <T> Map<String, Double> computeRelativeHistogram(List<T> list) {
        Map<String, Double> computeRelativeHistogram = new HashMap<>();
        for(T item : list){
            double number1 = Collections.frequency(list, item);
            double number2 = list.size();
            System.out.println(item + ": " + number1 / number2);
            if(computeRelativeHistogram.containsKey(item)){
                computeRelativeHistogram.put((String) item, (computeRelativeHistogram.get(item) + (1/number2)));
            }else
                computeRelativeHistogram.put((String) item, (double) 1/number2);
        }
        return computeRelativeHistogram;
    }

    public static Map<Character, Double> computeRelativeLetterHistogram(String string){
        Map<Character, Double> computeRelativeLetterHistogram = new HashMap<>();
        string = string.toUpperCase();
        int Length = string.replace(" ", "").length();
        for(char ch: string.toCharArray()){
            if(computeRelativeLetterHistogram.containsKey(ch)){
                computeRelativeLetterHistogram.put(ch, (computeRelativeLetterHistogram.get(ch) + (1.0 / Length)));
            }else
                computeRelativeLetterHistogram.put(ch, 1.0/Length);
            }
        return computeRelativeLetterHistogram;
    }

   // public static Map<Character, Double> computeRelativeLetterHistogramDistance(Map<Character, Double> map1, Map<Character, Double> map2){


    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistogramUtil<?> that = (HistogramUtil<?>) o;
        return Objects.equals(arrayList, that.arrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrayList);
    }

    public static void main(String[] args) {

        List<String> Listy = Arrays.asList("Bob", "Charles", "David", "Bob");

        Map<String, Long> Histogram = HistogramUtil.computeHistogram(Listy);
        System.out.println(Histogram);
        System.out.println(Histogram.get("Bob"));

        Map<String, Double> Histogram2 = HistogramUtil.computeRelativeHistogram(Listy);
        System.out.println(Histogram2.get("Bob"));

        Map<Character, Double> FILMNACHT = HistogramUtil.computeRelativeLetterHistogram("The Big Lebowski");
        System.out.println(FILMNACHT.get('B'));
        System.out.println(FILMNACHT.get('G'));
        System.out.println(FILMNACHT.get('X'));


    }
}

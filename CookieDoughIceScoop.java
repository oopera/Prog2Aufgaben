package de.hrw.progra2.assignment5;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CookieDoughIceScoop implements Comparable<CookieDoughIceScoop> {
    private String owner;

    private double amount;

    private double weight;

    private int numberOfDoughPieces;

    public static final iceCreamAmountComparator AMOUNT_COMPARATOR = new iceCreamAmountComparator();

    public static final CookieAmountComparator NUMBER_OF_DOUGH_PIECES_COMPARATOR = new CookieAmountComparator();

    public CookieDoughIceScoop(String owner, double amount, double weight, int numberOfDoughPieces) {
        this.owner = owner;
        this.amount = amount;
        this.weight = weight;
        this.numberOfDoughPieces = numberOfDoughPieces;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getNumberOfDoughPieces() {
        return numberOfDoughPieces;
    }

    public void setNumberOfDoughPieces(int numberOfDoughPieces) {
        this.numberOfDoughPieces = numberOfDoughPieces;
    }

    public static iceCreamAmountComparator getAmountComparator() {
        return AMOUNT_COMPARATOR;
    }

    public static CookieAmountComparator getNumberOfDoughPiecesComparator() {
        return NUMBER_OF_DOUGH_PIECES_COMPARATOR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CookieDoughIceScoop that = (CookieDoughIceScoop) o;
        return Double.compare(that.amount, amount) == 0 &&
                Double.compare(that.weight, weight) == 0 &&
                numberOfDoughPieces == that.numberOfDoughPieces &&
                Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, amount, weight, numberOfDoughPieces);
    }

    @Override
    public String toString() {
        return "CookieDoughIceScoop{" + "owner='" + owner + '\'' + ", amount=" + amount + ", weight=" + weight + ", numberOfDoughPieces=" + numberOfDoughPieces + '}' + "\n" ;
    }

    @Override
    public int compareTo(CookieDoughIceScoop cookieDoughIceScoop) {
     return getOwner().compareTo(cookieDoughIceScoop.getOwner());
    }


    public static class iceCreamAmountComparator implements Comparator<CookieDoughIceScoop> {
        @Override
        public int compare(CookieDoughIceScoop cookieDoughIceScoop, CookieDoughIceScoop t1) {
            if (cookieDoughIceScoop.getAmount() > t1.getAmount()) {
                return 1;
            } else if (cookieDoughIceScoop.getAmount() < t1.getAmount()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static class CookieAmountComparator implements Comparator<CookieDoughIceScoop> {
        @Override
        public int compare(CookieDoughIceScoop cookieDoughIceScoop, CookieDoughIceScoop t1) {
            if (cookieDoughIceScoop.getNumberOfDoughPieces() > t1.getNumberOfDoughPieces()) {
                return 1;
            } else if (cookieDoughIceScoop.getNumberOfDoughPieces() < t1.getNumberOfDoughPieces()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args){

        List<CookieDoughIceScoop> cookieDoughIceScoop = new LinkedList<>();
        cookieDoughIceScoop.add(new CookieDoughIceScoop("A", 4,6,10));
        cookieDoughIceScoop.add(new CookieDoughIceScoop("C", 3,7,9));
        cookieDoughIceScoop.add(new CookieDoughIceScoop("B", 6, 8, 12));
        cookieDoughIceScoop.add(new CookieDoughIceScoop("D", 5,9,11));

        System.out.println("Standardsortierung \n");
        System.out.println(cookieDoughIceScoop);
        Collections.sort(cookieDoughIceScoop);
        System.out.println("Natürliche Ordnung\n");
        System.out.println(cookieDoughIceScoop);
        Collections.sort(cookieDoughIceScoop,new iceCreamAmountComparator());
        System.out.println("Sortierung nach Eiskugeln \n");
        System.out.println(cookieDoughIceScoop);
        System.out.println("Sortierung nach Keksstürkcne \n");
        Collections.sort(cookieDoughIceScoop, new CookieAmountComparator());
        System.out.println(cookieDoughIceScoop);
    }

}

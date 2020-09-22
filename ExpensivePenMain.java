package de.hrw.progra2.assignment7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExpensivePenMain {
    public static void main(String[] args) {
        List<ExpensivePen> pens = Arrays.asList(
                new ExpensivePen("Montblanc – Limited Edition Boheme Papillon Pen", 205329),
                new ExpensivePen("Montegrappa – Ancient Mexican Civilisations Rollerball Pen (€127,433)", 1310520),
                new ExpensivePen("Montblanc - Mystery Masterpiece", 650537),
                new ExpensivePen("Tibaldi - Fulgor Nocturnus", 7129172),
                new ExpensivePen("Montblanc - Prince Rainier III Limited Edition 81 Pen", 231876),
                new ExpensivePen("Caran d'Ache - La Modernista Diamonds Pen", 236153),
                new ExpensivePen("Aurora - The Aurora Diamante", 1310520)
        );

        /**
         * inner class
         */
        Collections.shuffle(pens);

        /**
         * anonym class
         */
        Collections.shuffle(pens);
        System.out.println("ANONYME KLASSE");
        Collections.sort(pens, new Comparator<ExpensivePen>() {
            @Override
            public int compare(ExpensivePen expensivePen, ExpensivePen t1) {
                if (expensivePen.getPriceInEuro() > t1.getPriceInEuro()) {
                    return 1;
                } else if (expensivePen.getPriceInEuro() < t1.getPriceInEuro()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(pens);

        /**
         * Lambda expression
         */
        System.out.println("LAMBDA AUSDRUCK");
        Collections.shuffle(pens);
        pens.sort((ExpensivePen p1, ExpensivePen p2) -> (int) (p1.getPriceInEuro()-p2.getPriceInEuro()));
        System.out.println(pens);

        /**
         * Local class
         */

        Collections.shuffle(pens);
        System.out.println("LOKALE KLASSE");
       class SortByLocalClass implements Comparator<ExpensivePen> {
            public int compare(ExpensivePen expensivePen, ExpensivePen t1){
                if (expensivePen.getPriceInEuro() > t1.getPriceInEuro()) {
                    return 1;
                } else if (expensivePen.getPriceInEuro() < t1.getPriceInEuro()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
        Collections.sort(pens, new SortByLocalClass());
        System.out.println(pens);
    }
}

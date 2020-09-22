package de.hrw.progra2.assignment5;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LimitedArrayList<T> {
    private int maxCount;
    private List<T> arrayList;

    public LimitedArrayList(int maxCount, List<T> arrayList) {
        this.maxCount = maxCount;
        this.arrayList = arrayList;
        ArrayList<T> arrayList1 = new ArrayList<>();
    }
    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public List<T> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<T> arrayList) {
        this.arrayList = arrayList;
    }


    public void addElement(T element) {

        if (arrayList.size() >= maxCount) {
            System.err.println("Element konnte nicht geadded werden, die Liste ist voll.");
        } else {
            arrayList.add(element);
        }
    }

    public void removeElement(T element) {
        for (int i = 0; i < arrayList.size(); i++)
            for (int j = 0; j < arrayList.size(); j++)
                if (arrayList.get(i).equals(arrayList.get(j)) && i != j) {
                    arrayList.remove(element);
                } else if (arrayList.contains(element)) {
                    arrayList.remove(element);
                } else return;
                    }



    public void iterator(T element){
    Iterator iterator = arrayList.iterator();
    System.out.println("Iteratorausgabe: ");
    while (iterator.hasNext())
        System.out.println(iterator.next() + " ");
    System.out.println();
    }

    @Override
    public String toString() {
        return "LimitedArrayList{" +
                "arrayList=" + arrayList +
                ", maxCount=" + maxCount +
                '}';
    }

    public static void main(String[] args){
        LimitedArrayList<String> Listy = new LimitedArrayList(2, new ArrayList<>(20));
        Listy.addElement("my Guy");
        Listy.addElement("you suck");
        System.out.println(Listy);
        Listy.removeElement("you suck");
        Listy.addElement("i like you");
        Listy.addElement("you're the best");
        System.out.println(Listy);
        Listy.iterator("");
    }
}
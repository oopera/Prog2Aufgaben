package de.hrw.progra2.assignment3;

public class Group 

    private String[] names;

    public Group(String[] names) {
        this.names = names.clone();

    }

    public String[] getNames() {
        return names.clone();
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public static void main (String[] args){
        return;
    }

}
package de.hrw.progra2.assignment7;

/**
 * An expensive pen.
 */
public class ExpensivePen {
    /**
     * Name of pen.
     */
    private String name;

    /**
     * Price of pen in Euro.
     */
    private double priceInEuro;

    /**
     * Constructor setting all fields.
     * @param name name of pen
     * @param priceInEuro price in Euro
     */
    public ExpensivePen(String name, double priceInEuro) {
        this.name = name;
        this.priceInEuro = priceInEuro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceInEuro() {
        return priceInEuro;
    }

    public void setPriceInEuro(double priceInEuro) {
        this.priceInEuro = priceInEuro;
    }

    @Override
    public String toString() {
        return "ExpensivePen{" +
                "type='" + name + '\'' +
                ", priceInEuro=" + priceInEuro +
                '}';
    }
}

package edu.du.ict_4315;

public class Money {
    private long cents;

    public Money(double d) {
        this.cents = (long) (d * 100); 
    }

    public double getDollars() {
        return cents / 100.0;
    }

    public Money add(Money other) {
        long totalCents = this.cents + other.cents;
        return new Money(totalCents / 100.0);  
    }

    @Override
    public String toString() {
        return "$" + getDollars();
    }
}

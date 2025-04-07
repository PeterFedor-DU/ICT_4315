package edu.du.ict_4315

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TransactionManager {
    private List<ParkingTransaction> transactions;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }


    public ParkingTransaction park(Calendar date, ParkingPermit permit, ParkingLot lot) {
        ParkingTransaction transaction = new ParkingTransaction(date, permit, lot);
        transactions.add(transaction);
        return transaction;
    }

    public Money getParkingCharges(ParkingPermit permit) {
        Money totalCharges = new Money(0); 
        for (ParkingTransaction transaction : transactions) {
            if (transaction.getPermit().equals(permit)) {
                totalCharges = totalCharges.add(transaction.getFeeCharged());
            }
        }
        return totalCharges;
    }

    public Money getParkingCharges(Customer customer) {
        Money totalCharges = new Money(0);  
      
        for (Car car : customer.getCars()) {
            String permit = car.getPermit();  
            totalCharges = totalCharges.add(getParkingCharges(permit));  
        }

        return totalCharges;
    }

    public Money getParkingCharges(String licensePlate) {
        Money totalCharges = new Money(0); 
        for (ParkingTransaction transaction : transactions) {
            if (transaction.getPermit().getCar().getLicense().equals(licensePlate)) {
                totalCharges = totalCharges.add(transaction.getFeeCharged());
            }
        }
        return totalCharges;
    }
}

package edu.du.ict_4315;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TransactionManager {
    private List<ParkingTransaction> transactions;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

    public ParkingTransaction park(Calendar date, ParkingPermit permit, ParkingLot lot) {
        LocalDateTime entryTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime exitTime = entryTime.plusHours(1); 

        ParkingChargeStrategy strategy = ParkingChargeStrategyFactory.getStrategy(lot);
        Money feeCharged = strategy.calculateCharge(permit, entryTime, exitTime, lot.getBaseRate());

        ParkingTransaction transaction = new ParkingTransaction(permit, entryTime, exitTime, feeCharged);
        transactions.add(transaction);
        return transaction;
    }

///New method for oberserver 
    public ParkingTransaction park(ParkingEvent event) {
        ParkingPermit permit = event.getPermit();
        ParkingLot lot = event.getLot();

        LocalDateTime exitTime = event.getTimestamp(); 
        LocalDateTime entryTime = exitTime.minusHours(1); 

        ParkingChargeStrategy strategy = ParkingChargeStrategyFactory.getStrategy(lot);
        Money feeCharged = strategy.calculateCharge(permit, entryTime, exitTime, lot.getBaseRate());

        ParkingTransaction transaction = new ParkingTransaction(permit, entryTime, exitTime, feeCharged);
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
            ParkingPermit permit = car.getPermit(); 
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

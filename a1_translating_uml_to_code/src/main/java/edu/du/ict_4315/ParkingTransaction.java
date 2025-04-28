package edu.du.ict_4315;

import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ParkingTransaction {
    private Calendar transactionDate;
    private ParkingPermit permit;
    private Money feeCharged;

    public ParkingTransaction(Calendar transactionDate, ParkingPermit permit, ParkingLot lot) {
        this.transactionDate = transactionDate;
        this.permit = permit;


        LocalDateTime entryTime = transactionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
///setting an exit time for the transaction calc 
        LocalDateTime exitTime = entryTime.plusHours(1);

///Getting the fee from the charger factory
        ParkingChargeStrategy strategy = ParkingChargeStrategyFactory.getStrategy(lot);
        this.feeCharged = strategy.calculateCharge(permit, entryTime, exitTime, lot.getBaseRate());
    }

    public Calendar getTransactionDate() {
        return transactionDate;
    }

///Seeing if a transaction happened today
    public boolean isTransactionToday() {
        Calendar today = Calendar.getInstance();
        return today.get(Calendar.YEAR) == transactionDate.get(Calendar.YEAR) &&
               today.get(Calendar.MONTH) == transactionDate.get(Calendar.MONTH) &&
               today.get(Calendar.DAY_OF_MONTH) == transactionDate.get(Calendar.DAY_OF_MONTH);
    }

    public ParkingPermit getPermit() {
        return permit;
    }

    public Money getFeeCharged() {
        return feeCharged;
    }
}

package edu.du.ict_4315

import java.util.Calendar;

public class ParkingTransaction {
    private Calendar transactionDate;
    private ParkingPermit permit;
    private Money feeCharged;


    public ParkingTransaction(Calendar transactionDate, ParkingPermit permit, ParkingLot lot) {
        this.transactionDate = transactionDate;
        this.permit = permit;
        this.feeCharged = new Money(7.50);
    }


    public Calendar getTransactionDate() {
        return transactionDate;
    }

///checking if the transaction happened today
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

package edu.du.ict_4315;
import edu.du.ict_4315.Money;
import java.time.Instant;

public class ParkingCharge {
 private String permitId;
 private String lotId;
 private Instant incurred;
 Money amount;

 public ParkingCharge(String permitId, String lotId, Instant incurred, Money amount) {
     this.permitId = permitId;
     this.lotId = lotId;
     this.incurred = incurred;
     this.amount = amount;
 }



public ParkingCharge(Money chargeAmount, Customer testCustomer) {

}



public String toString() {
     return "Charge[Permit: " + permitId + ", Lot: " + lotId + ", Time: " + incurred + ", Amount: " + amount + "]";
 }
}

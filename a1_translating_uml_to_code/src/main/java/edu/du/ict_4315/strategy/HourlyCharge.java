///Peter Fedor, ICT 4315, 4/20/2025
package edu.du.ict_4315.strategy;
import java.time.LocalDateTime;
import java.time.DayOfWeek;

public class HourlyCharge implements ParkingChargeStrategy {

    private static final double Weekend_Charge = 0.25;
    private static final double Workhour_Charge = 0.15;
    private static final int Workhour_Start = 9;  
    private static final int Workhour_End = 5;   

    @Override
    public Money calculateCharge(ParkingPermit permit, LocalDateTime entryTime, LocalDateTime exitTime, Money baseRate) {
        double chargeMultiplier = 1.0;

///Weekend charge calc
        DayOfWeek day = entryTime.getDayOfWeek();
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            surchargeMultiplier += Weekend_Charge;
        }

///Work hour charge calc
        int hour = entryTime.getHour();
        if (hour >= Workhour_Start && hour < Workhour_End) {
            surchargeMultiplier += WorkhourCharge;
        }

        return baseRate.multiply(chargeMultiplier);
    }
}

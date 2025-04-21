///Peter Fedor, ICT 4315, 4/20/2025
package edu.du.ict_4315.strategy;
import java.time.LocalDateTime;
import java.time.DayOfWeek;

public class TimeAndDayBasedSurcharge implements ParkingChargeStrategy {

    private static final double WEEKEND_SURCHARGE = 0.25;
    private static final double PRIME_TIME_SURCHARGE = 0.15;
    private static final int PRIME_START_HOUR = 7;  // 7 AM
    private static final int PRIME_END_HOUR = 10;   // 10 AM

    @Override
    public Money calculateCharge(ParkingPermit permit, LocalDateTime entryTime, LocalDateTime exitTime, Money baseRate) {
        double surchargeMultiplier = 1.0;

        // Weekend surcharge
        DayOfWeek day = entryTime.getDayOfWeek();
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            surchargeMultiplier += WEEKEND_SURCHARGE;
        }

        // Prime time surcharge (e.g., during rush hour)
        int hour = entryTime.getHour();
        if (hour >= PRIME_START_HOUR && hour < PRIME_END_HOUR) {
            surchargeMultiplier += PRIME_TIME_SURCHARGE;
        }

        return baseRate.multiply(surchargeMultiplier);
    }
}

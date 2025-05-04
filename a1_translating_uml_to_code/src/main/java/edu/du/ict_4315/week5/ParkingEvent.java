package edu.du.ict_4315;

import java.time.LocalDateTime;

public class ParkingEvent {
    private final ParkingPermit permit;
    private final ParkingLot lot;
    private final LocalDateTime timestamp;
    private final boolean isEntry;

    public ParkingEvent(ParkingPermit permit, ParkingLot lot, boolean isEntry) {
        this.permit = permit;
        this.lot = lot;
        this.timestamp = LocalDateTime.now();
        this.isEntry = isEntry;
    }

    public ParkingPermit getPermit() { return permit; }
    public ParkingLot getLot() { return lot; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public boolean isEntry() { return isEntry; }
}

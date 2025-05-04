package edu.du.ict_4315;

public class ParkingObserver implements ParkingAction {
    private final TransactionManager manager;

    public ParkingObserver(TransactionManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(ParkingEvent event) {
        if (!event.isEntry()) { 
            manager.park(event);
        }
    }
}

package co.develhope.Custom.Queries.entities;

import java.util.Random;

public enum FlightStatus {
    ONTIME(1),
    DELAYED(2),
    CANCELLED(3);

    private final int status;

    public static FlightStatus fromString(String status) {
        for (FlightStatus a : FlightStatus.values()) {
            if(a.name().equals(status)) return a;
        }
        return null;
    }

    public int getStatus() {

        return status;
    }

    FlightStatus(int status) {

        this.status = status;
    }

    public static FlightStatus fromStatus(int status){
        for (FlightStatus a : FlightStatus.values()) {
            if(a.getStatus() == status) return a;
        }
        return null;
    }

    public static FlightStatus randomStatus(){
        Random random = new Random();
        int b = random.nextInt(1, FlightStatus.values().length);
        return FlightStatus.fromStatus(b);
    }
}

package dev.dmgiangi.APIcustomquery01.entities;

import java.util.Random;
import java.util.stream.Stream;

public enum FlightStatus {
    ONTIME(1),
    DELAYED(2),
    CANCELLED(3);

    private final int code;

    FlightStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static FlightStatus randomStatus() {
        Random random = new Random();
        int newCode = random.nextInt(1, FlightStatus.values().length);
        return FlightStatus.fromStatus(newCode);
    }

    private static FlightStatus fromStatus(int status) throws IllegalArgumentException{
        return Stream.of(FlightStatus.values())
                .filter(c -> c.getCode() == status)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static FlightStatus fromString(String status) throws IllegalArgumentException{
        return status == null
                ? null
                : Stream.of(FlightStatus.values())
                .filter(t -> status.equals(t.name()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
package dev.dmgiangi.APIcustomquery01.entities;

import java.util.Random;
import java.util.stream.Stream;

public enum AirportCode {
    BRI(1),
    BDS(2),
    FOG(3),
    FCO(4),
    FCC(5),
    MXP(6),
    LIN(7);

    private final int code;

    AirportCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AirportCode fromCode(int code){
        return Stream.of(AirportCode.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static AirportCode randomAirport() {
        Random random = new Random();
        int newCode = random.nextInt(1, AirportCode.values().length);
        return AirportCode.fromCode(newCode);
    }
}

package co.develhope.Custom.Queries.entities;

import java.util.Random;

public enum AirportCode {
    BDS(1),
    LCC(2),
    FCO(3),
    LXT(4),
    CMP(5);

    private final int code;

    public int getCode() {
        return code;
    }

    AirportCode(int code) {
        this.code = code;
    }

    public static AirportCode fromCode(int code){
        for (AirportCode a : AirportCode.values()) {
            if(a.getCode() == code) return a;
        }
        return null;
    }
    public static AirportCode randomCode() {
        Random random = new Random();
        int b = random.nextInt(1, AirportCode.values().length);
        return AirportCode.fromCode(b);
    }
}

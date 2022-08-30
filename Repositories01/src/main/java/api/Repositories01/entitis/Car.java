package api.Repositories01.entitis;

import com.sun.istack.NotNull;

import javax.persistence.Table;

@Table
public class Car {


    private int id;

    @NotNull
    private String modelName;

    private String serialNumber;

    private Integer currentPrice;

}

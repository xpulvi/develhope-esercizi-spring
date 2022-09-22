package com.Email01.api.entitis;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NotificationDto {

    @NotNull
    private String userId;
    @NotNull
    private String title;
    @NotNull
    private String text;

}

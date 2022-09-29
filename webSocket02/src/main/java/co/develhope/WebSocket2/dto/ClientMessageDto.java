package co.develhope.WebSocket2.dto;

public class ClientMessageDto {

    private String clientName;

    private String clientAlert;

    private String clientMsg;

    public String getClientName() {
        return clientName;
    }

    public ClientMessageDto setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public String getClientAlert() {
        return clientAlert;
    }

    public ClientMessageDto setClientAlert(String clientAlert) {
        this.clientAlert = clientAlert;
        return this;
    }

    public String getClientMsg() {
        return clientMsg;
    }

    public ClientMessageDto setClientMsg(String clientMsg) {
        this.clientMsg = clientMsg;
        return this;
    }


    public ClientMessageDto(String clientName, String clientAlert, String clientMsg) {
        this.clientName = clientName;
        this.clientAlert = clientAlert;
        this.clientMsg = clientMsg;
    }

    public ClientMessageDto() {
    }

    @Override
    public String toString() {
        return "ClientMessageDto{" +
                "clientName='" + clientName + '\'' +
                ", clientAlert='" + clientAlert + '\'' +
                ", clientMsg='" + clientMsg + '\'' +
                '}';
    }
}

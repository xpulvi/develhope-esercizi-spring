package co.develhope.WebSocket2.dto;

public class MessageDto {

    private String sender;
    private String type;
    private String message;

    public MessageDto(String s) {
    }

    public String getType() {
        return type;
    }

    public MessageDto setType(String type) {
        this.type = type;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessageDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public MessageDto setSender(String sender) {
        this.sender = sender;
        return this;
    }



    public MessageDto(String sender, String type, String message) {
        this.sender = sender;
        this.type = type;
        this.message = message;
    }

    public MessageDto() {
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "sender='" + sender + '\'' +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

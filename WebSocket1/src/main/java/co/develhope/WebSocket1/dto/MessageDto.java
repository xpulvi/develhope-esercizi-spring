package co.develhope.WebSocket1.dto;

public class MessageDto {

    private String type;
    private String message;

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

    public MessageDto(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public MessageDto() {
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

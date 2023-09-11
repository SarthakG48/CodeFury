package in.co.codefury.meetingroombooking.service.exception;

public class MeetingRoomAlreadyBooked extends Exception{
    private String message;
    public MeetingRoomAlreadyBooked(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
